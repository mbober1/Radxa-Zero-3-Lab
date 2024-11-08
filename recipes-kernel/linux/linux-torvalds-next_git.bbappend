FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
	file://fragment.cfg \
	file://gadget.cfg \
	file://0001-Fix-gmac-phy-mode-to-rgmii.patch \
	file://0001-build-dtbo.patch \
"

SRCREV = "c88416ba074a8913cf6d61b789dd834bbca6681c"
