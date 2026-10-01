FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

RDEPENDS:${PN}:class-target += "users"

do_install:append() {
	# Add mountpoint for shared binaries
	mkdir ${D}/runtime
}
