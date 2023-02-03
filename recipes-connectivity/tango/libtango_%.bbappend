FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "file://tangorc.service \
		file://tangorc.sh \
		"

SYSTEMD_SERVICE:${PN} += "tangorc.service"

FILES:${PN} += "${bindir} ${systemd_unitdir} ${sysconfdir}"

do_install:append() {
	sed -i -e "s,@ETH@,${@d.getVar('PRIMARY_NETIF')},g" \
		${WORKDIR}/tangorc.sh

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/tangorc.sh ${D}${bindir}

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/tangorc.service ${D}${systemd_unitdir}/system

	install -d ${D}${sysconfdir}/profile.d
	ln -sfr ${D}/run/tango/tangorc ${D}${sysconfdir}/tangorc
	ln -sfr ${D}/run/tango/corba.sh ${D}${sysconfdir}/profile.d/corba.sh
}

inherit systemd
