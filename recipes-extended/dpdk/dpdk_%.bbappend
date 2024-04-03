FILESEXTRAPATHS:prepend := "${THISDIR}/dpdk:"

SRC_URI:append = " \
	file://90-vfio.rules \
	file://90-hpet.rules \
	"

FILES:${PN} += "{sysconfdir}/udev/rules.d"
do_install:append() {
 	install -d ${D}${sysconfdir}/udev/rules.d/
 	install -m 0644 ${WORKDIR}/90-vfio.rules ${WORKDIR}/90-hpet.rules \
		${D}${sysconfdir}/udev/rules.d/
}
