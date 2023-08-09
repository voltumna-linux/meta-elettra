DESCRIPTION = "Pogo is the TANGO code generator. It allows to define a TANGO class model."
HOMEPAGE = "https://gitlab.com/tango-controls/pogo"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=1c76c4cc354acaac30ed4d5eefea7245"

SRC_URI = " \
	https://repo1.maven.org/maven2/org/tango-controls/Pogo/${PV}/Pogo-${PV}.jar;unpack=0 \
	file://pogo \
"
SRC_URI[sha256sum] = "dca0d02ce7b4148369db401636486a152df650b07a9d4cc19b6b5ccc18e47cf9"

FILES_${PN} += "${SDKPATHNATIVE}"
do_install() {
	install -d ${D}${SDKPATHNATIVE}/usr/share/esrf-pogo/ ${D}${SDKPATHNATIVE}/usr/bin
	install -m 0644 ${WORKDIR}/Pogo-${PV}.jar ${D}${SDKPATHNATIVE}/usr/share/esrf-pogo/
	install -m 0755 ${WORKDIR}/pogo ${D}${SDKPATHNATIVE}/usr/bin
}

inherit nativesdk
