LICENSE = "CLOSED"
inherit useradd

USERNAME = "mbober"
PASSWD = "\$1\$Ka7FbtOE\$DSvtRNudJe7OV6tSIJP2J/"

USERADD_PACKAGES = "${PN}"

USERADD_PARAM:${PN} += "--create-home --home-dir /home/${USERNAME} --groups sudo --password '${PASSWD}' ${USERNAME}"

SRC_URI = "file://sudoers"

do_install() {
    install -d ${D}/home/${USERNAME}
	install -d ${D}${sysconfdir}/sudoers.d
    install -m 0440 ${WORKDIR}/sudoers ${D}${sysconfdir}/sudoers.d/sudoers
}

FILES:${PN} += "/home/${USERNAME}"