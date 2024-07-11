inherit externalsrc
EXTERNALSRC = "/home/max/ulan_bsp/sources/_sdcard.img.extracted"
EXTERNALSRC_BUILD = "/home/max/ulan_bsp/sources/_sdcard.img.extracted"

do_install:append() {
    # Remove conflicting shared libraries
    find ${D} -name "*.so*" -exec rm -f {} +
}
