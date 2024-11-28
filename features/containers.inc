DISTRO_FEATURES:append = " virtualization"
TCLIBC = "glibc"

IMAGE_INSTALL += " \
  container-images \
  docker \
  docker-compose \
  systemd-analyze \
  nerdctl \
  "