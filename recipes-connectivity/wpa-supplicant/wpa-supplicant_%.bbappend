FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://wpa_supplicant-wlu1.conf"


do_install:append () {
	install -d ${D}${sysconfdir}/wpa_supplicant
	install -m 600 ${UNPACKDIR}/wpa_supplicant-wlu1.conf ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlu1.conf
}

SYSTEMD_SERVICE:${PN} = "wpa_supplicant@wlu1.service"
SYSTEMD_AUTO_ENABLE = "enable"
