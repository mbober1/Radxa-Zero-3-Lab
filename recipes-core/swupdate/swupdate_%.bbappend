FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " e2fsprogs libarchive zstd"
do_package_qa[noexec] = "1"

SRC_URI += "\
	file://html/favicon.png \
	file://html/logo.png \
	file://html/background.jpg \
	file://swupdate.cfg \
	file://swupdate.default \
"

do_install:append () {
	install -m 644 ${UNPACKDIR}/html/favicon.png ${D}/www/images/
	install -m 644 ${UNPACKDIR}/html/logo.png ${D}/www/images/
	install -m 644 ${UNPACKDIR}/html/background.jpg ${D}/www/images/

	install -m 644 ${UNPACKDIR}/swupdate.cfg ${D}${sysconfdir}/
	install -d ${D}${sysconfdir}/default/
	install -m 644 ${UNPACKDIR}/swupdate.default ${D}${sysconfdir}/default/swupdate
}
