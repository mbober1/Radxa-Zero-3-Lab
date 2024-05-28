require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "bc-native dtc-native"

SRCREV = "ac211f86dc2164395038d3752a307639aa5ab244"

SRC_URI = "git://github.com/radxa/u-boot.git;protocol=https;branch=rk3xxx-2024.04"
