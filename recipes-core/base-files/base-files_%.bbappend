FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

FILES:${PN} += "/runtime"

do_install:append() {
	# Add mountpoint for shared binaries
	mkdir ${D}/runtime
}
