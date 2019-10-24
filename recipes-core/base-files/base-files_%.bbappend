FILES_${PN} += "/runtime"

do_install_append() {
	# Add mountpoint for shared binaries
	mkdir ${D}/runtime
}
