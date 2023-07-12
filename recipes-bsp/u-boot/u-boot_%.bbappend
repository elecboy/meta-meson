FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://acs_tool.py \
	file://fit.cfg \
"

SRC_URI:sei510:append = " \
	file://no-android.cfg \
"

SRC_URI:sei610:append = " \
	file://no-android.cfg \
"
SRC_URI:append:sports-cle-v41 = " \
        file://0001-add-sports-cle-v41-support.patch \
"
SRC_URI:append:sports-cle-v40 = " \
        file://u-boot-2023-04-add-qihua-s905d3.patch \
		file://mmc.cfg \
		file://fs.cfg \
"
