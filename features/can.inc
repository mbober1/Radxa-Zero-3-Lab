DISTRO_FEATURES:append = " can"

KERNEL_FEATURES += "features/can/can.scc"

IMAGE_INSTALL += " \
  iproute2 \
  canutils \
  "
