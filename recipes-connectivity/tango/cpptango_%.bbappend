FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "file://tangorc.service \
		file://tangorc.sh \
		"

SYSTEMD_SERVICE_${PN} += "tangorc.service"

FILES_${PN} += "${bindir} ${systemd_unitdir} ${sysconfdir}"

do_install[vardeps] += "PRIMARY_NETIF"
do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/tangorc.sh ${D}${bindir}
	sed -i -e "s,@ETH@,${@d.getVar('PRIMARY_NETIF')},g" \
		${D}${bindir}/tangorc.sh

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/tangorc.service ${D}${systemd_unitdir}/system

	install -d ${D}${sysconfdir}/profile.d
	ln -sfr ${D}/run/tango/tangorc ${D}${sysconfdir}/tangorc
	ln -sfr ${D}/run/tango/corba.sh ${D}${sysconfdir}/profile.d/corba.sh
}

inherit systemd
