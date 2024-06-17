FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://beaver.png \
    file://spinner.plymouth \
"

PACKAGECONFIG:remove = "initrd"
PACKAGECONFIG:append = " drm"

EXTRA_OECONF += "--with-udev --with-runtimedir=/run"

do_install:append () {
    install -m 0644 ${WORKDIR}/beaver.png ${D}${datadir}/plymouth/themes/spinner/watermark.png
    install -m 0644 ${WORKDIR}/spinner.plymouth ${D}${datadir}/plymouth/themes/spinner/spinner.plymouth
}