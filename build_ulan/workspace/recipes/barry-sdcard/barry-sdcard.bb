inherit autotools

DESCRIPTION = "Your package description"
LICENSE = "GPL-2.0-only & LGPL-2.1-only & MIT"
LIC_FILES_CHKSUM = "file://ext-root/lib/firmware/LICENSE.sdma_firmware;md5=51e8c19ecc2270f4b8ea30341ad63ce9 \
                    file://ext-root/usr/lib/python3.5/LICENSE.txt;md5=b680ed99aa60d350c65a65914494207e \
                    file://ext-root/usr/lib/ruby/2.4.0/rubygems/util/licenses.rb;md5=2a7fd143e35605b7f8aa34c8f83d2db8 \
                    file://ext-root/usr/lib/ruby/gems/2.4.0/gems/did_you_mean-1.1.0/LICENSE.txt;md5=d7a6da564b0f9f7c28de06d494d10801 \
                    file://ext-root/usr/lib/ruby/gems/2.4.0/gems/net-telnet-0.1.1/LICENSE.txt;md5=837b32593517ae48b9c3b5c87a5d288c \
                    file://ext-root/usr/lib/ruby/gems/2.4.0/gems/power_assert-0.4.1/COPYING;md5=6866c52d8a166a95f098ac02c519a26b \
                    file://ext-root/usr/lib/ruby/gems/2.4.0/gems/power_assert-0.4.1/LEGAL;md5=1cff95a683df942bf2f148be74b5e0da \
                    file://ext-root/usr/lib/ruby/gems/2.4.0/gems/rake-12.0.0/MIT-LICENSE;md5=b217e3354f829a186a07233cd480fbee \
                    file://ext-root/usr/lib/ruby/gems/2.4.0/gems/test-unit-3.2.3/COPYING;md5=611afadf58cf5d35edb42ba577e7e4dd \
                    file://ext-root/usr/lib/ruby/gems/2.4.0/gems/test-unit-3.2.3/GPL;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://ext-root/usr/lib/ruby/gems/2.4.0/gems/test-unit-3.2.3/LGPL;md5=4fbd65380cdd255951079008b364516c \
                    file://ext-root/usr/lib/ruby/gems/2.4.0/gems/xmlrpc-0.2.1/LICENSE.txt;md5=837b32593517ae48b9c3b5c87a5d288c \
                    file://ext-root/usr/share/doc/liberation-fonts/LICENSE;md5=f96db970a9a46c5369142b99f530366b"

S = "${WORKDIR}/git"

SRC_URI = "git:///home/max/ulan_bsp/sources/_sdcard.img.extracted;protocol=file;branch=master"
SRCREV = "7c1b30aeb9db36cd67ddae5d0d17e3933057ce9d"

DEPENDS += "unzip-native"

EXTRA_OECONF = ""

# 跳过一些QA检查
INSANE_SKIP:${PN} = "installed-vs-shipped already-stripped"

do_install() {
    install -d ${D}${libdir}/python3.8/site-packages/
    cp -r ${S}/ext-root ${D}${libdir}/python3.8/site-packages/
    cp -r ${S}/pip ${D}${libdir}/python3.8/site-packages/
    cp -r ${S}/pip-9.0.1.dist-info ${D}${libdir}/python3.8/site-packages/
    cp -r ${S}/pkg_resources ${D}${libdir}/python3.8/site-packages/
    cp -r ${S}/setuptools ${D}${libdir}/python3.8/site-packages/
    cp -r ${S}/setuptools-28.8.0.dist-info ${D}${libdir}/python3.8/site-packages/
    cp ${S}/easy_install.py ${D}${libdir}/python3.8/site-packages/
    cp ${S}/0.ext ${D}${libdir}/python3.8/site-packages/

    cp ${S}/*.lzo ${D}${libdir}/python3.8/site-packages/
    cp ${S}/*.zlib ${D}${libdir}/python3.8/site-packages/
    cp ${S}/*.zip ${D}${libdir}/python3.8/site-packages/
    cp ${S}/*.tar ${D}${libdir}/python3.8/site-packages/
}

FILES:${PN} += "/usr/lib/python3.8/site-packages/*"


