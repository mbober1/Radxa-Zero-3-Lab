SUMMARY = "Embed container image into root file system"
DESCRIPTION = "Pull container images from a container registry \
    as defined by the container-images.manifest and embed them \
    into the root file system."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
S = "${WORKDIR}/sources-unpack"

CONTAINER_MANIFEST ?= "file://container-images.manifest"
CONTAINER_ARCHIVE ?= "container-images.zstd"
CONTAINER_INSTALL_DIR ?= "${D}/${datadir}"
CONTAINER_DEFAULT_REGISTRY ?= "docker.io"

RDEPENDS:${PN} = "nerdctl containerd-opencontainers ca-certificates iptables cni"

SRC_URI = "${CONTAINER_MANIFEST}"

do_pull_image[nostamp] = "1"
do_delete_images[nostamp] = "1"
do_compile[noexec] = "1"


do_pull_image() {
    # check for manifest
    manifest=$(echo ${CONTAINER_MANIFEST} | grep -o '[^/]*$')
    [ -f "${S}/${manifest}" ] || bbfatal "container image manifest does not exist"

    # architecture determination; used if not set explicitly by the manifest
    arch=${TARGET_ARCH}
    sys=$(echo ${TARGET_OS} | cut -d '-' -f 1)

    # pull images
    local image platform version registry
    grep -v '^\s*$\|^\s*#' ${S}/${manifest} | (
        while read -r image platform version registry _; do
            if [ ${platform} = '-' ]; then
               platform="${sys}/${arch}"
            fi
            if [ ${registry} = '-' ]; then
                registry="${CONTAINER_DEFAULT_REGISTRY}"
            fi
            if [ ${version} = '-' ]; then
                version="latest"
            fi
            # echo ${image}, ${platform}, ${version}, ${registry}
            PATH=/usr/bin:${PATH} docker pull --platform ${platform} ${registry}/${image}:${version}
        done
    )
}
addtask pull_image before do_install after do_unpack


do_tag_image() {
    # check for manifest
    manifest=$(echo ${CONTAINER_MANIFEST} | grep -o '[^/]*$')
    [ -f "${S}/${manifest}" ] || bbfatal "container image manifest does not exist"

    # tag images
    local image platform version registry localname localversion
    grep -v '^\s*$\|^\s*#' ${S}/${manifest} | (
        while read -r image platform version registry localname localversion _; do
            if [ ${version} = '-' ]; then
                version="latest"
            fi
            if [ ${localname} = '-' ]; then
               localname="${image}"
            fi
            if [ ${localversion} = '-' ]; then
                localversion="${version}"
            fi
            #echo ${image}, ${version}, ${localname}, ${localversion}
            PATH=/usr/bin:${PATH} docker tag ${image}:${version} ${localname}:${localversion}
        done
    )
}
addtask tag_image before do_install after do_pull_image


do_create_archive() {
    # check for manifest
    manifest=$(echo ${CONTAINER_MANIFEST} | grep -o '[^/]*$')
    [ -f "${S}/${manifest}" ] || bbfatal "container image manifest does not exist"
    rm -f ${S}/${manifest}.target

    # collect images to archive
    local image platform version registry localname localversion
    grep -v '^\s*$\|^\s*#' ${S}/${manifest} | (
        while read -r image platform version registry localname localversion _; do
            if [ ${version} = '-' ]; then
                version="latest"
            fi
            if [ ${localname} = '-' ]; then
               localname="${image}"
            fi
            if [ ${localversion} = '-' ]; then
               localversion="${version}"
            fi
            images="${images} ${localname}:${localversion}"
            printf "${localname}:${localversion}\n" >> ${WORKDIR}/${manifest}.target
        done
        #echo ${images}
        PATH=/usr/bin:${PATH} docker save ${images} | zstd -o ${WORKDIR}/${CONTAINER_ARCHIVE}
    )
}
addtask create_archive before do_install after do_tag_image


do_delete_images() {
    # check for manifest
    manifest=$(echo ${CONTAINER_MANIFEST} | grep -o '[^/]*$')
    [ -f "${S}/${manifest}" ] || bbfatal "container image manifest does not exist"

    # delete images
    # it will only delete the images from the manifest, if it has changed then some
    # images might not be deleted
    local image platform version registry localname localversion
    grep -v '^\s*$\|^\s*#' ${S}/${manifest} | (
        while read -r image platform version registry localname localversion _; do
            if [ ${version} = '-' ]; then
                version="latest"
            fi
            if [ ${localname} = '-' ]; then
               localname="${image}"
            fi
            if [ ${localversion} = '-' ]; then
               localversion="${version}"
            fi
            PATH=/usr/bin:${PATH} docker rmi ${localname}:${localversion} ${image}:${version} -f
        done
    )
}
addtask delete_images


do_install() {
    # check for manifest
    manifest=$(echo ${CONTAINER_MANIFEST} | grep -o '[^/]*$')
    [ -f "${S}/${manifest}" ] || bbfatal "container image manifest does not exist"

    install -d ${CONTAINER_INSTALL_DIR}
    install -m 0400 ${WORKDIR}/${manifest}.target ${CONTAINER_INSTALL_DIR}/${manifest}
    install -m 0400 ${WORKDIR}/${CONTAINER_ARCHIVE} ${CONTAINER_INSTALL_DIR}
}

FILES:${PN} =+ "${datadir}"
