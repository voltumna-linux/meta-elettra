FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# The rule uses subject.isInGroup("controls"): need the recipe creating the group
RDEPENDS_${PN}_class-target += "users"

SRC_URI_append += " \
	file://10-controls-management.rules \
	"

do_install_append() {
	# Add additional rules files
        install -m 0644 ${WORKDIR}/10-controls-management.rules ${D}${datadir}/polkit-1/rules.d
}
