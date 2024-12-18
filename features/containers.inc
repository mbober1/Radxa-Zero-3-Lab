DISTRO_FEATURES:append = " virtualization"
TCLIBC = "glibc"
KERNEL_FEATURES += "features/docker/docker.scc"

IMAGE_INSTALL += " \
  container-images \
  docker \
  docker-compose \
  nerdctl \
  "
