FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
	file://rk3566-radxa-zero-3e.dts \
	file://fragment1.cfg \
	file://fragment2.cfg \
	file://fragment3.cfg \
	file://fragment4.cfg \
"

COMPATIBLE_MACHINE:radxa-zero-3e = "radxa-zero-3e"

do_configure:append() {

	# Add custom DT
	cp ${WORKDIR}/rk3566-radxa-zero-3e.dts ${S}/arch/arm64/boot/dts/rockchip
	echo 'dtb-$(CONFIG_ARCH_ROCKCHIP) += rk3566-radxa-zero-3e.dtb' >> ${S}/arch/arm64/boot/dts/rockchip/Makefile
}