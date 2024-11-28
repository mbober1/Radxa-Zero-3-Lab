FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
	file://fragment.cfg \
	file://gadget.cfg \
	file://can.cfg \
	file://0001-Fix-gmac-phy-mode-to-rgmii.patch \
	file://0001-build-dtbo.patch \
	file://0001-arm64-dts-rockchip-Add-DMA-channel-names-for-rk356x.patch \
	file://0001-radxa-zero-3E-Enable-UART3.patch \
	file://0001-radxa-zero-3E-Enable-SPI1-spidev.patch \
	file://0001-Enable-MCP2515-on-SPI3-M1-CS0.patch \
"

SRCREV = "f486c8aa16b8172f63bddc70116a0c897a7f3f02"
