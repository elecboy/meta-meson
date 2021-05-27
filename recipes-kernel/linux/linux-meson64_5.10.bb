#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

DEPENDS += "rsync-native"

SRCREV_meson = "4068786a86905a7a358b9fe1327a480f08fb6a40"
LINUX_VERSION = "5.10.40"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-5.10.y;name=meson \
           file://defconfig \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

# Checksum changed on 5.10
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

