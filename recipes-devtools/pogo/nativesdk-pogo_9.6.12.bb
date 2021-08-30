DESCRIPTION = "Pogo is the TANGO code generator. It allows to define a TANGO class model."
# HOMEPAGE = "https://github.com/tango-controls/pogo"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = " \
	file://Pogo-${PV}.jar;unpack=0 \
	file://pogo \
"
#SRC_URI[md5sum] = "cca4e8f1087305b61e5d2ed4850f0bab"
#SRC_URI[sha256sum] = "f7901de1942233e59db078fa35ea48b80192b412b24435904b0a7893fbdcaeb3"

FILES_${PN} += "${SDKPATHNATIVE}"
do_install() {
	install -d ${D}${SDKPATHNATIVE}/usr/share/esrf-pogo/ ${D}${SDKPATHNATIVE}/usr/bin
	install -m 0644 ${WORKDIR}/Pogo-${PV}.jar ${D}${SDKPATHNATIVE}/usr/share/esrf-pogo/
	install -m 0755 ${WORKDIR}/pogo ${D}${SDKPATHNATIVE}/usr/bin
}

inherit nativesdk
