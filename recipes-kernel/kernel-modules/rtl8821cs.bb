SUMMARY = "RTL8821CS kernel driver (wifi 2.4G/5.8G + bluetooth)"
DESCRIPTION = "RTL8821CS kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PV = "5.12.0-8"
SRCREV = "4354e9529610f5d8d963f4095d77576111edffe4"
SRC_URI = "git://git@git.witcent.net:10022/changzhijie/rtl8821cs_wifi_linux.git;protocol=ssh \
            file://0001-build-for-s905.patch \
           "

S = "${WORKDIR}/git"

DEPENDS = "virtual/kernel bc-native"

inherit module

EXTRA_OEMAKE  = "ARCH=${ARCH} \
                 KSRC=${STAGING_KERNEL_BUILDDIR} \
                "

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}
    install -m 0755 ${B}/8821cs.ko ${D}/lib/modules/${KERNEL_VERSION}/8821cs.ko
}

FILES_${PN} += "${sysconfdir}"
