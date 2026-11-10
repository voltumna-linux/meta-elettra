EXTRA_OEMESON:append = ' \
	-Ddns-servers="" \
	'

# systemd v255.22 already contains the SO_PASSSEC downgrade fix (upstream
# commit b97861dadc, backported from bb887cf), so the meta-xilinx backport
# patch fails to apply and is redundant. Drop it when present.
SRC_URI:remove = "file://0001-socket-downgrade-not-supported-logging-for-SO_PASSSE.patch"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install[vardeps] += "PRIMARY_NETIF"
do_install:append() {
	# Replace wheel with controls group to let it views logs
	sed -i 's/wheel/controls/g' ${D}${base_libdir}/tmpfiles.d/systemd.conf

	# Make wait-online waits indefinitely
	sed -i 's/^ExecStart=\(.*\)/ExecStart=\1 --timeout=0 -i ${@d.getVar('PRIMARY_NETIF')}/' \
		${D}${systemd_unitdir}/system/systemd-networkd-wait-online.service
}
