FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += "file://meson64-kmeta;type=kmeta;destsuffix=meson64-kmeta"

SRC_URI += "file://0001-add-qihua-s922x-core-board-support.patch \
	    		         file://0002-add-qihua-s905d3-board-support.patch \
				 file://0003-add-qihua-board-to-makefile.patch \
				 file://use-rtc1-as-default-rtc.cfg \
			      	 file://add-erofs-and-overlayfs.cfg \
				 file://add-rtl8187-8188.cfg \
            			 file://add-rtc-pcf8563.cfg \
				 file://add-usb-ethernet-and-lte-modem.cfg \
"

COMPATIBLE_MACHINE:append:meson-gx = "|meson64all"
KMACHINE:meson-gx = "meson-gx"

LINUX_VERSION_EXTENSION:append:meson-gx = "-meson64"

# Add HDMI output support if display output is required
KERNEL_FEATURES:append = "${@bb.utils.contains_any('DISTRO_FEATURES', 'x11 wayland', \
    ' cfg/meson-hdmi.scc', '', d)}"

KERNEL_FEATURES:append = "${@bb.utils.contains('DISTRO_FEATURES', 'pci', \
    ' cfg/meson-pci.scc', '', d)}"
