FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
	file://bootcmd.cfg \
	file://decompression.cfg \
	file://quickstart.cfg \
"

SRC_URI:radxa-zero-3 = "git://source.denx.de/u-boot/u-boot.git;protocol=https;branch=master"
SRCREV:radxa-zero-3 = "${AUTOREV}"
