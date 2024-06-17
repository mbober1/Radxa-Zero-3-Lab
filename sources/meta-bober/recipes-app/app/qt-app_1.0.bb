SUMMARY = "QT6 demo app"
DESCRIPTION = "QT6 demo app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/mbober1/QT6-demo-app.git;branch=qt5;protocol=https"
SRCREV = "efe14145069b8adac1c2443a3cc21572328a606d"

S = "${WORKDIR}/git"

DEPENDS += " qtbase \
			qtdeclarative-native \
			qtcharts \
			"

inherit cmake_qt5

do_install() {
	install -d ${D}${bindir}
	install -m 0755 qt_test ${D}${bindir}
}