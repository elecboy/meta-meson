SUMMARY = "RTL8821CS kernel driver (wifi 2.4G/5.8G + bluetooth)"
DESCRIPTION = "RTL8821CS kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PV = "5.12.0-8"
SRCREV = "807e576afa42e38066402aaf94140662b4bc2f3c"
SRC_URI = "git://git@git.witcent.net:10022/changzhijie/rtl8821cs_wifi_linux.git;protocol=ssh;branch=master \
            file://0001-build-for-s905.patch \
	    file://0002-modify-debug-level.patch \
	    file://0003-disable-power-save.patch \
	    file://0004-disable-P2P-and-MP.patch \
	    file://0005-disable-CONFIG_CONCURRENT_MODE.patch \
           "

S = "${WORKDIR}/git"

DEPENDS = "virtual/kernel bc-native"

EXTRA_OEMAKE  = "ARCH=${ARCH} \
                 KSRC=${STAGING_KERNEL_BUILDDIR} \
                "

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0755 ${B}/8821cs.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/8821cs.ko
}

