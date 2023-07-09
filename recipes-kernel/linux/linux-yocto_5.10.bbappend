FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += "file://meson64-kmeta;type=kmeta;destsuffix=meson64-kmeta"

SRC_URI += " \
        file://0051-WIP-arm64-dts-meson-add-audio-playback-to-s905x-p212.patch \
        file://0055-HACK-media-cec-silence-CEC-timeout-message.patch \
        file://0056-HACK-revert-mm-emit-tracepoint-when-RSS-changes.patch \
        file://0060-HACK-set-meson-g12-cma-pool-to-896MB.patch \
        file://01-10-soc-sunxi-convert-to-devm_platform_ioremap_resource.patch \
        file://dts-meson-add-watchdog-to-g12-common-dtsi.patch.txt.patch \
        file://0001-g12-add-uart_ao_b-pins.patch \
        file://0001-add-sports-cle-v41-support.patch \
	file://0006-fix-8821cs-drv-build.patch \
        file://use-rtc1-as-default-rtc.cfg \
        file://add-erofs-and-overlayfs.cfg \
        file://add-rtl8187-8188.cfg \
        file://add-rtc-pcf8563.cfg \
        file://add-usb-ethernet-and-lte-modem.cfg \
        file://add-i2c-char-device.cfg \
"

#SRC_URI:append:meson-gx = " file://0001-ASoC-meson-implement-driver-name.patch \
#			    file://0002-FROMLIST-arm64-dts-amlogic-add-support-for-radxa-zero.patch"

COMPATIBLE_MACHINE:append:meson-gx = "|meson64all"
KMACHINE:meson-gx = "meson-gx"

LINUX_VERSION_EXTENSION:append:meson-gx = "-meson64"

# Add HDMI output support if display output is required
KERNEL_FEATURES:append = "${@bb.utils.contains_any('DISTRO_FEATURES', 'x11 wayland', \
    ' cfg/meson-hdmi.scc', '', d)}"

KERNEL_FEATURES:append = "${@bb.utils.contains('DISTRO_FEATURES', 'pci', \
    ' cfg/meson-pci.scc', '', d)}"