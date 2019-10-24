FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "file://tangorc.service \
		file://tangorc.sh \
		"

SYSTEMD_SERVICE_${PN} += "tangorc.service"

FILES_${PN} += "${bindir} ${systemd_unitdir} ${sysconfdir}"

do_install_append() {
	sed -i -e "s,@ETH@,${@d.getVar('PRIMARY_NETIF').split(' ')[1]},g" \
		${WORKDIR}/tangorc.sh

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/tangorc.sh ${D}${bindir}

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/tangorc.service ${D}${systemd_unitdir}/system

	install -d ${D}${sysconfdir}/profile.d
	lnr ${D}/run/tango/tangorc ${D}${sysconfdir}/tangorc
	lnr ${D}/run/tango/corba.sh ${D}${sysconfdir}/profile.d/corba.sh
}

inherit systemd
