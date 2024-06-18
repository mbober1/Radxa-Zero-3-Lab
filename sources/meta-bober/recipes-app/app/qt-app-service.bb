LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "qt-app.service"

SRC_URI:append = " file://qt-app.service "
FILES:${PN} += "${systemd_unitdir}/system/qt-app.service"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/qt-app.service ${D}/${systemd_unitdir}/system
}
