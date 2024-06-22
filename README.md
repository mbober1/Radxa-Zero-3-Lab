Custom Linux System based on Yocto Project
=========================================

Hardware: Radxa Zero 3E

Software Features:
- Kernel 6.10+
- QT application with OpenGL ES 3.2
- Partitions scheme A/B + Data
- Read-only rootfs
- OTA updates via SWUpdate
- Ethernet over USB
- Custom splash screen
- Zeroconf support
- Lightweigth system (~160MB)
- Boot time < 7s

Hardware Features:
- Rockchip RK3566 (Quad-core Cortex-A55)
- Mali-G52 GPU
- 2GB RAM
- PoE 802.3af Support

TODO:
- add Hawkbit
- add RAUC (compare with SWUpdate)
- auto resize data partition
- add OTA fallback

## Build
Clone repository and initialize build environment:
```
git clone https://github.com/mbober1/Radxa-Zero-3-Lab.git --recursive
source poky/oe-init-build-env
```

Edit `conf/local.conf` to match your needs. You can find example configuration in in main directory.

```
cp ../example_local.conf conf/local.conf
```

Add needed layers to `conf/bblayers.conf`. You can use example configuration:
```
cp ../example_bblayers.conf conf/bblayers.conf
```

Build image:
```
bitbake lab-image
```