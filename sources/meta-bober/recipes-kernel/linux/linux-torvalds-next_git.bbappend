FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
	file://fragment.cfg \
	file://0001-add-peripherals.patch \
	file://0001-Fix-gmac-phy-mode-to-rgmii.patch \
"

SRCREV = "6906a84c482f098d31486df8dc98cead21cce2d0"
