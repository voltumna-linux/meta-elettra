FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://10-starter-management.rules \
	"

do_install:append() {
	# Add additional rules files
        install -m 0644 ${WORKDIR}/10-starter-management.rules ${D}${datadir}/polkit-1/rules.d
}
