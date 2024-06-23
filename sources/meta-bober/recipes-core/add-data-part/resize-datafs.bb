DESCRIPTION = "Add data partition systemd service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SYSTEMD_AUTO_ENABLE = "disable"
DEPENDS += " e2fsprogs parted"

inherit systemd

SRC_URI = "\
	file://resize-datafs.init \
	file://resize-datafs.service \
"

SYSTEMD_SERVICE:${PN} = "resize-datafs.service"

FILES:${PN} += "${systemd_unitdir}/system/resize-datafs.service"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/resize-datafs.init ${D}${bindir}/resize-datafs
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/resize-datafs.service ${D}${systemd_unitdir}/system
}
