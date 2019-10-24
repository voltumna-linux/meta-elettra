POGOVER="9.4.2"

install_pogo_into_sdk() {
	install -d ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/
	tar zxf ${DL_DIR}/esrf-pogo_${POGOVER}-linux.tar.gz -C ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/

	mkdir -p ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/
	cat <<-__EOF__ > ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/pogo.sh
	export POGOVER=${POGOVER}
	export POGOPATH=\$OECORE_NATIVE_SYSROOT/opt/esrf-pogo_\$POGOVER
	export PATH=\$POGOPATH/bin:\$PATH
	__EOF__
}

install_pogo_into_sdk_sdkmingw32() {
	install -d ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/
	tar zxf ${DL_DIR}/esrf-pogo_${POGOVER}-windows.tar.gz -C ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/

	mkdir -p ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/
	cat <<-__EOF__ > ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/pogo.bat
	set POGOVER=${POGOVER}
	set POGOPATH=%OECORE_NATIVE_SYSROOT%\opt\esrf-pogo_%POGOVER%
	set PATH=%POGOPATH%\bin;%PATH%
	__EOF__
}
