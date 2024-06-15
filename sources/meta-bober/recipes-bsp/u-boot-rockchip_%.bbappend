FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "\
	file://rk3566-radxa-zero3.dts \
	file://rk3566-radxa-zero3-u-boot.dtsi \
	file://radxa-zero3-rk3566_defconfig \
"

do_configure:append() {

	# # Add custom DT
	# cp ${WORKDIR}/rk3566-radxa-zero3.dts ${S}/arch/arm64/boot/dts/rockchip
	# echo 'dtb-$(CONFIG_ARCH_ROCKCHIP) += rk3566-radxa-zero3.dtb' >> ${S}/arch/arm64/boot/dts/rockchip/Makefile

	cp ${WORKDIR}/radxa-zero3-rk3566_defconfig ${S}/configs
	cp ${WORKDIR}/rk3566-radxa-zero3-u-boot.dtsi ${S}/arch/arm64/boot/dts/rockchip
}