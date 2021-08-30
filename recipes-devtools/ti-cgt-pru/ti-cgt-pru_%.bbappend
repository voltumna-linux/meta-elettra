do_install_append() {
	# Remove a 32bit binary
	rm -f ${D}${TI_CGT_PRU_INSTALL_DIR_RECIPE}/ti_cgt_pru_${PV}_uninstaller.run

	# Add an empty cdefs.h
	install -d ${D}${TI_CGT_PRU_INSTALL_DIR_RECIPE}/include/sys
	touch ${D}${TI_CGT_PRU_INSTALL_DIR_RECIPE}/include/sys/cdefs.h
}
