FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
    file://HARICA-TLS-Root-2021-RSA.crt \
"

do_install_prepend() {
    install -d ${D}${datadir}/${BPN}/elettra
    install -m 0644 ${WORKDIR}/HARICA-TLS-Root-2021-RSA.crt ${D}${datadir}/${BPN}/elettra
}

do_install_append() {
    echo "elettra/HARICA-TLS-Root-2021-RSA.crt" >> ${D}${sysconfdir}/${BPN}.conf
}
