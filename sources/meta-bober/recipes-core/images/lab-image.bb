DESCRIPTION = "Test image"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image


PACKAGE_CLASSES = "package_ipk"
INIT_MANAGER = "systemd"

IMAGE_FEATURES:append = " \
  hwcodecs \
  package-management \
  splash \
"

IMAGE_INSTALL:append = " \
  packagegroup-core-boot \
  kernel \
  kernel-devicetree \
  kernel-modules \
	swupdate \
	swupdate-www \
	swupdate-client \
	swupdate-tools \
  nano \
  htop \
  openssh \
  e2fsprogs \
  openssl \
  rsync \
  qt-app \
  qt-app-service \
  psplash \
"

EXTRA_IMAGE_FEATURES = " \
  debug-tweaks \
  tools-sdk \
  tools-debug \
  ssh-server-openssh \
"