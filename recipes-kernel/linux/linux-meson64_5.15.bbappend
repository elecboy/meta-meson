FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += " \
	file://0001-add-sports-cle-v41-support.patch \
	file://use-rtc1-as-default-rtc.cfg \
	file://add-erofs-and-overlayfs.cfg \
	file://add-rtl8187-8188.cfg \
        file://add-rtc-pcf8563.cfg \
	file://add-usb-ethernet-and-lte-modem.cfg \
	file://add-i2c-char-device.cfg \
"

COMPATIBLE_MACHINE:append:meson-gx = "|meson64all"

LINUX_VERSION_EXTENSION:append:meson-gx = "-meson64"
