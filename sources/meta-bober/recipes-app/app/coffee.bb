SUMMARY = "Coffee QT5 Example"
DESCRIPTION = "Coffee QT5 Example"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += " qtbase qtdeclarative"
SRC_URI = "file://coffee/"

S = "${WORKDIR}/coffee/1.0"

inherit qmake5

do_install() {
	install -d ${D}${bindir}
	install -m 0755 coffee ${D}${bindir}
}