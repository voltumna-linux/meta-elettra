EXTRA_OEMESON:append = ' \
	-Ddns-servers="" \
	'

do_install[vardeps] += "PRIMARY_NETIF"
do_install:append() {
	# Replace wheel with controls group to let it views logs
	sed -i 's/wheel/controls/g' ${D}${base_libdir}/tmpfiles.d/systemd.conf

	# Make wait-online waits indefinitely
	sed -i 's/^ExecStart=\(.*\)/ExecStart=\1 --timeout=0 -i ${@d.getVar('PRIMARY_NETIF')}/' \
		${D}${systemd_unitdir}/system/systemd-networkd-wait-online.service
}
