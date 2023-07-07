DESCRIPTION = "Kernel loadable module rtw88 backports"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/lwfinger/rtw88.git;protocol=https;branch=master"

SRCREV = "7ca1ec0e768f083e4a2116d6978021814b83bb74"

S = "${WORKDIR}/git"

inherit module

EXTRA_OEMAKE += " \
    KSRC=${STAGING_KERNEL_DIR} \
    KVER=${KERNEL_VERSION} \
"
do_install () {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0755 ${B}/*.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/

    install -d ${D}${nonarch_base_libdir}/firmware/rtw88
    install -m 0755 ${B}/*.bin ${D}${nonarch_base_libdir}/firmware/rtw88/
}

FILES:${PN} += "${nonarch_base_libdir}/firmware/rtw88/"
