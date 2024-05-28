SUMMARY = "Kernel recipe based on armbian rockchip"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/armbian/linux-rockchip.git;name=machine;branch=rk-6.1-rkr1;protocol=https"

LINUX_VERSION ?= "6.1.43"
LINUX_VERSION_EXTENSION:append = "-custom"

SRCREV_machine="4a6add88cc1956ce604f06802b8d3e165a54bb5c"

PV = "${LINUX_VERSION}+git"

COMPATIBLE_MACHINE = "(^$)"

SRC_URI:append = " file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta"
