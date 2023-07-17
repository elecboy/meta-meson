FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	git://github.com/LibreELEC/brcmfmac_sdio-firmware.git;protocol=https;branch=master;name=brcmfmac-sdio-firmware;destsuffix=brcmfmac_sdio-firmware \
	file://brcmfmac4354-sdio.txt \
"

SRCREV_brcmfmac-sdio-firmware = "c70355f9ec6d015b91a5c3199aa08b433e2f7caf"

do_install:append() {
	for f in ${WORKDIR}/brcmfmac_sdio-firmware/*.txt ${WORKDIR}/brcmfmac_sdio-firmware/*.bin; do
	        install -m 0644 $f ${D}${nonarch_base_libdir}/firmware/brcm
	done
	install -m 0644 ${WORKDIR}/brcmfmac4354-sdio.txt ${D}${nonarch_base_libdir}/firmware/brcm
}

PACKAGES +="\
			${PN}-bcm43456 \
"

LICENSE:${PN}-bcm43456 = "Firmware-broadcom_bcm43xx"
RDEPENDS:${PN}-bcm43456 += "${PN}-broadcom-license"

FILES:${PN}-bcm4329 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4329* \
"

FILES:${PN}-bcm4330 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4330* \
"

FILES:${PN}-bcm4335 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4335* \
"

FILES:${PN}-bcm43362 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43362* \
"

FILES:${PN}-bcm43430 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43430* \
"

FILES:${PN}-bcm43430a0 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43430a0* \
"

FILES:${PN}-bcm43455 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.* \
"

FILES:${PN}-bcm43455 += "\
	${nonarch_base_libdir}/firmware/brcm/brcmfmac43456-sdio.* \
	"

FILES:${PN}-bcm4354 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4354* \
"

FILES:${PN}-bcm4356 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4356* \
"

FILES:${PN}-bcm4359 += " \
	${nonarch_base_libdir}/firmware/brcm/brcmfmac4359* \
"
