FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LINUX_VERSION = "6.12+"
BRANCH = "linux-6.12.y"
SRCREV = "${AUTOREV}"
SRCPV = "${@bb.fetch2.get_srcrev(d)}"

SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=${BRANCH} \
	file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta \
	git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.12;destsuffix=kernel-meta;protocol=https \
	file://fit-image.its \
	file://fragment.cfg \
	file://gadget.cfg \
	file://0001-Fix-gmac-phy-mode-to-rgmii.patch \
	file://0001-build-dtbo.patch \
	${@bb.utils.contains('DISTRO_FEATURES', 'can', 'file://0001-Enable-MCP2515-on-SPI3-M1-CS0.patch', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'spi', 'file://0001-radxa-zero-3E-Enable-SPI1-spidev.patch', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'gps', 'file://0001-radxa-zero-3E-Enable-UART3.patch', '', d)} \
"
