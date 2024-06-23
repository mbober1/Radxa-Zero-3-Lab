SUMMARY = "QT6 demo app"
DESCRIPTION = "QT6 demo app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/mbober1/QT-Cube-Demo.git;branch=master;protocol=https"
SRCREV = "aec316de713c982ea5e05c26073387a235d1131f"

S = "${WORKDIR}/git"

DEPENDS += " qtbase qtdeclarative-native"

inherit cmake_qt5

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/build/cube ${D}${bindir}
}