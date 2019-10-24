FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += " \
	file://10-enable-controls.rules \
	"

do_install_append() {
	# Add additional rules files
        install -m 0644 ${WORKDIR}/10-enable-controls.rules ${D}${datadir}/polkit-1/rules.d
}
