PYLONVER="6.1.1.19861"

install_pylon_into_sdk() {
	true
}

install_pylon_into_sdk_sdkmingw32() {
	true
}

install_pylon_into_sre() {
	true
}

install_pylon_into_sde() {
	install -d ${IMAGE_ROOTFS}/opt/pylon
	tar zxf ${DL_DIR}/pylon_${PYLONVER}_x86_64.tar.gz -C ${IMAGE_ROOTFS}/opt/pylon
}
