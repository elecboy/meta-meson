# Amlogic S905D3 Configurations

require conf/machine/include/arm/armv8-2a/tune-cortexa55.inc
require conf/machine/include/amlogic-meson64.inc

MACHINE_FEATURES = "serial usbhost sdio screen wifi"

SOC_FAMILY:append = ":meson-sm1"
