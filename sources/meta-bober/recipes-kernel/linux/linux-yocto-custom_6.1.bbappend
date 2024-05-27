FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
	file://rk3566-radxa-zero-3e.dts \
	file://drm.cfg \
	file://cleanup.cfg \
"

COMPATIBLE_MACHINE:radxa-zero-3e = "radxa-zero-3e"

do_configure:append() {

	# Add custom DT
	cp ${WORKDIR}/rk3566-radxa-zero-3e.dts ${S}/arch/arm64/boot/dts/rockchip
	echo 'dtb-$(CONFIG_ARCH_ROCKCHIP) += rk3566-radxa-zero-3e.dtb' >> ${S}/arch/arm64/boot/dts/rockchip/Makefile
}