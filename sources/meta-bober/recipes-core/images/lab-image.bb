DESCRIPTION = "Test image"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image
inherit populate_sdk_qt5

IMAGE_LINGUAS = "en-us en-gb"

PACKAGE_CLASSES = "package_ipk"
INIT_MANAGER = "systemd"

SYSTEM_TOOLS_INSTALL = " \
  i2c-tools \
  memtester \
  sysbench \
  tzdata \
  devmem2 \
  minicom \
"

QT_TOOLS = " \
  qtbase \
  qtbase-plugins \
"

FONTS = " \
  fontconfig \
  fontconfig-utils \
  liberation-fonts \
"

QT_DEV_TOOLS = " \
  qtbase-dev \
  qtbase-mkspecs \
  qtbase-tools \
"

KERNEL_EXTRA_INSTALL = " \
  kernel \
  kernel-devicetree \
  kernel-modules \
"

UTILITIES_INSTALL = " \
  coreutils \
  gdbserver \
  ldd \
  libstdc++ \
  libstdc++-dev \
  openssh-sftp \
  ppp \
"

TSLIB = " \
  tslib \
  tslib-calibrate \
  tslib-conf \
  tslib-dev \
  tslib-tests \
"
 
IMAGE_INSTALL += " \
  ${SYSTEM_TOOLS_INSTALL} \
  ${QT_TOOLS} \
  ${FONTS} \
  ${QT_DEV_TOOLS} \
  ${KERNEL_EXTRA_INSTALL} \
  ${UTILITIES_INSTALL} \
  ${TSLIB} \
"


IMAGE_FEATURES:append = " \
  hwcodecs \
  package-management \
  splash \
  read-only-rootfs \
"

IMAGE_INSTALL:append = " \
  packagegroup-core-boot \
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
  libubootenv \
  network-config-misc \
"

EXTRA_IMAGE_FEATURES = " \
  debug-tweaks \
  tools-sdk \
  tools-debug \
  ssh-server-openssh \
"

#Always add cmake to sdk
TOOLCHAIN_HOST_TASK:append = " nativesdk-cmake"
TOOLCHAIN_TARGET_TASK += " libgl-mesa-dev libegl-mesa-dev libgles1-mesa-dev libgles2-mesa-dev libgles3-mesa-dev"