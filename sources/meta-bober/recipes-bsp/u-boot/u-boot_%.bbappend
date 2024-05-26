FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
	file://0001-Fix-Radxa-ZERO-defconfig.patch \
"

COMPATIBLE_MACHINE:radxa-zero-3e = "radxa-zero-3e"
