#	-Dntp-servers="" \
#

EXTRA_OEMESON_append += ' \
	-Ddns-servers="" \
	'

GROUPADD_PARAM_${PN} = "--system controls"

do_install_append() {
	# Replace wheel with controls group to let it views logs
	sed -i 's/wheel/controls/g' ${D}${base_libdir}/tmpfiles.d/systemd.conf

	# Make wait-online waits indefinitely
	sed -ie 's/^ExecStart=\(.*\)/ExecStart=\1 --timeout=0/' ${D}${systemd_unitdir}/system/systemd-networkd-wait-online.service
}
