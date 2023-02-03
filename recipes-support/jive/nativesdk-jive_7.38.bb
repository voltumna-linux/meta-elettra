DESCRIPTION = "Jive is a standalone JAVA application designed to browse and edit the static TANGO database."
HOMEPAGE = "https://gitlab.com/tango-controls/jive"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = " \
	https://repo1.maven.org/maven2/org/tango-controls/Jive/${PV}/Jive-${PV}-jar-with-dependencies.jar;unpack=0 \
	file://jive \
"
SRC_URI[sha256sum] = "891767c2051412966e7f700c218f911ab8a832bee6138418e48265fa8bbd25c3"

FILES:${PN} = "${SDKPATHNATIVE}"
do_install() {
	install -d ${D}${SDKPATHNATIVE}/usr/share/esrf-jive/ ${D}${SDKPATHNATIVE}/usr/bin
	install -m 0644 ${WORKDIR}/Jive-${PV}*.jar ${D}${SDKPATHNATIVE}/usr/share/esrf-jive/
	install -m 0755 ${WORKDIR}/jive ${D}${SDKPATHNATIVE}/usr/bin
}

inherit nativesdk
