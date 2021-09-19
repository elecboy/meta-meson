FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://brcmfmac43456-sdio.qihua,s905d3.txt \
"

do_install_append() {
        install -m 0644 ${WORKDIR}/brcmfmac43456-sdio.*txt \
        ${D}${nonarch_base_libdir}/firmware/brcm
}

FILES_${PN}-bcm43456 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43456-sdio.qihua,s905d3.txt \
"
