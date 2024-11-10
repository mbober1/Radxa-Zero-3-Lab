FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
	file://quickstart.cfg \
	file://splash.cfg \
	file://bootcmd.cfg \
"

SRC_URI:radxa-zero-3 = "git://source.denx.de/u-boot/u-boot.git;protocol=https;branch=master"
SRCREV:radxa-zero-3 = "9c25cd563179cf32cf3b119d5ae78ef8348d0335"
