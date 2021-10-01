#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

DEPENDS += "rsync-native"

SRCREV_meson = "d27a14321366788cef927dbe69854f34460b3f7c"
LINUX_VERSION = "5.14.3"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-5.14.y;name=meson \
           file://defconfig \
	   file://0001-g12-add-uart_ao_b-pins.patch \
	   file://0002-add-qihua-s905d3-and-mt-sports-cle-v4-dts.patch \
	   file://0003-add-qihua-s905d3-and-sports-cle-v4-dts-build.patch \
           file://0004-add-sports-cle-v4-gpio-and-led.patch \
           file://0005-qihua-s905d3-regulator-fix.patch \
           file://0006-fix-8821cs-drv-build.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION:append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

# Checksum changed on 5.10
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

