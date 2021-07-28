#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

DEPENDS += "rsync-native"

SRCREV_meson = "08277b9dde633e1447e96b8cb89da2b40f96ae69"
LINUX_VERSION = "5.10.54"

# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-5.10.y;name=meson \
           file://defconfig \
	   file://0001-Add-higher-clocks-for-SM1-family.patch \
	   file://0031-WIP-clk-meson-g12a-fix-gp0-and-hifi-ranges.patch \
	   file://0051-WIP-arm64-dts-meson-add-audio-playback-to-s905x-p212.patch \
	   file://0055-HACK-media-cec-silence-CEC-timeout-message.patch \
	   file://0056-HACK-revert-mm-emit-tracepoint-when-RSS-changes.patch \
	   file://0060-HACK-set-meson-g12-cma-pool-to-896MB.patch \
	   file://01-10-soc-sunxi-convert-to-devm_platform_ioremap_resource.patch \
	   file://dts-meson-add-watchdog-to-g12-common-dtsi.patch.txt.patch \
	   file://0001-g12-add-uart_ao_b-pins.patch \
	   file://0002-add-qihua-s905d3-and-mt-sports-cle-v4-dts.patch \
	   file://0003-add-qihua-s905d3-and-sports-cle-v4-dts-build.patch \
           file://0004-add-sports-cle-v4-gpio-and-led.patch \
           file://0005-qihua-s905d3-regulator-fix.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

# Checksum changed on 5.10
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

