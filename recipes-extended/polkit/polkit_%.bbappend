FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://10-controls-management.rules \
	"

do_install:append() {
	# Add additional rules files
        install -m 0644 ${WORKDIR}/10-controls-management.rules ${D}${datadir}/polkit-1/rules.d
}
