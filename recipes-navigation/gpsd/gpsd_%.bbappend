FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
	file://gpsd.default \
"

do_install:append () {
	install -m 644 ${UNPACKDIR}/gpsd.default ${D}${sysconfdir}/default/gpsd.default
}
