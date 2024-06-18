FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://splash.png \
  file://0001-change-bg-color.patch \
"

SPLASH_IMAGES = "file://splash.png;outsuffix=default"