#@TYPE: Machine
#@NAME: Sports CLE V40/V41 machine
#@DESCRIPTION: Machine configuration

KERNEL_IMAGETYPE = "Image"

require conf/machine/include/sports-cle-v4x-dtb.inc
require conf/machine/include/amlogic-modern-boot.inc

#UBOOT_MACHINE ?= "sports-cle-v41_defconfig"

MACHINE_FEATURES:append = " alsa ext2 screen usbgadget usbhost vfat"

#PREFERRED_VERSION_linux-meson64 = "5.15%"
#PREFERRED_PROVIDER_virtual/kernel = "linux-meson64"

PREFERRED_VERSION_linux-yocto = "5.10%"

PREFERRED_VERSION_libgpiod = "1.%"

MACHINE_EXTRA_RRECOMMENDS += "kernel-modules"
MACHINE_EXTRA_RRECOMMENDS += "linux-firmware-rtl8192cu"
#MACHINE_EXTRA_RRECOMMENDS += "linux-firmware-rtl8723"
MACHINE_EXTRA_RRECOMMENDS += "linux-firmware-rtl8821 kernel-module-rtl8821cs"
#MACHINE_EXTRA_RRECOMMENDS += "kernel-module-rtw88"
MACHINE_EXTRA_RRECOMMENDS += "zram"
MACHINE_EXTRA_RRECOMMENDS += "udev-rules-sports-cle-v4"
MACHINE_EXTRA_RRECOMMENDS += "u-boot-tools"

