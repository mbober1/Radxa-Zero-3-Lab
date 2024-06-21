FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
	file://fragment.cfg \
	file://gadget.cfg \
	file://0001-add-peripherals.patch \
	file://0001-Fix-gmac-phy-mode-to-rgmii.patch \
"
