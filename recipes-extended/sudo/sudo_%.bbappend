FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://10-elettra-privilege \
	"

do_install:append() {
	install -d ${D}${sysconfdir}/sudoers.d
	install -m 0440 ${UNPACKDIR}/10-elettra-privilege ${D}${sysconfdir}/sudoers.d
}
