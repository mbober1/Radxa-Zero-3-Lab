FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "\
	file://rk3566-radxa-zero-3e.dts \
	file://rk3566-radxa-zero3.dtsi \
	file://drm2.cfg \
	file://cleanup.cfg \
	file://logo.bmp \
"

do_configure:append() {
	cp ${WORKDIR}/rk3566-radxa-zero-3e.dts ${S}/arch/arm64/boot/dts/rockchip
	cp ${WORKDIR}/rk3566-radxa-zero3.dtsi ${S}/arch/arm64/boot/dts/rockchip
	cp ${WORKDIR}/logo.bmp ${S}/logo.bmp
	cp ${WORKDIR}/logo.bmp ${S}/logo_kernel.bmp
	echo 'dtb-$(CONFIG_ARCH_ROCKCHIP) += rk3566-radxa-zero-3e.dtb' >> ${S}/arch/arm64/boot/dts/rockchip/Makefile
}