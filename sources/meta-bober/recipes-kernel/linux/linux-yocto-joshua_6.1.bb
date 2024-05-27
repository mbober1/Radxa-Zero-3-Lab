SUMMARY = "Kernel recipe based on Joshua-Riek rockchip"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto-custom:"
SRC_URI = "git://github.com/Joshua-Riek/linux-rockchip.git;name=machine;branch=noble;protocol=https"
SRC_URI:append = " file://drm.cfg"
SRC_URI:append = " file://cleanup.cfg"


LINUX_VERSION ?= "6.1.43"
LINUX_VERSION_EXTENSION:append = "-custom"

SRCREV_machine="213f2d59bc1d30a25ce5f0a949aaee5dda6538cc"

PV = "${LINUX_VERSION}+git"

COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:radxa-zero-3e-joshua = "radxa-zero-3e-joshua"

SRC_URI:append = " file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta"
