do_install:append() {
	# Only the User=/Group= lines: a global replace on "root" would corrupt
	# any future occurrence (RootDirectory, /root, ...). Fail the build if
	# upstream changes the lines rather than install a silently wrong unit.
	sed -i -e 's,^User=root$,User=controls,' \
		-e 's,^Group=root$,Group=controls,' \
		${D}${systemd_unitdir}/system/starter.service
	grep -q '^User=controls$' ${D}${systemd_unitdir}/system/starter.service &&
	grep -q '^Group=controls$' ${D}${systemd_unitdir}/system/starter.service ||
		bbfatal "starter.service: User=/Group= lines not found as expected (upstream changed?)"
}
