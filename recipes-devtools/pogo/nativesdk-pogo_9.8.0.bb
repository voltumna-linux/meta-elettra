DESCRIPTION = "Pogo is the TANGO code generator. It allows to define a TANGO class model."
HOMEPAGE = "https://gitlab.com/tango-controls/pogo"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0-or-later;md5=1c76c4cc354acaac30ed4d5eefea7245"

SRC_URI = " \
	https://repo1.maven.org/maven2/org/tango-controls/Pogo/${PV}/Pogo-${PV}.jar;unpack=0 \
	file://pogo \
"
SRC_URI[sha256sum] = "6c590553a061f92b192d78df2427178b1e4da303cbf887ed25735a2d0366acc5"

FILES:${PN} = "${SDKPATHNATIVE}"
do_install() {
	install -d ${D}${SDKPATHNATIVE}/usr/share/esrf-pogo/ ${D}${SDKPATHNATIVE}/usr/bin
	install -m 0644 ${WORKDIR}/Pogo-${PV}.jar ${D}${SDKPATHNATIVE}/usr/share/esrf-pogo/
	install -m 0755 ${WORKDIR}/pogo ${D}${SDKPATHNATIVE}/usr/bin
}

inherit nativesdk
