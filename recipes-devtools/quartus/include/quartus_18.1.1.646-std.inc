QUARTUSVER="18.1.1.646-std"

install_quartus_into_sdk() {
	install -d ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/
	tar zxf ${DL_DIR}/intel-quartus_${QUARTUSVER}-linux.tar.gz -C ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/

	mkdir -p ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/
	cat <<-__EOF__ > ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/quartus.sh
	export QUARTUSVER=${QUARTUSVER}
	export QUARTUSPATH=\$OECORE_NATIVE_SYSROOT/opt/intel-quartus_\$QUARTUSVER
	export QSYS_ROOTDIR=\$QUARTUSPATH/quartus/sopc_builder/bin
	export PATH=\$QUARTUSPATH/quartus/bin:\$PATH
	__EOF__
}

install_quartus_into_sdk_sdkmingw32() {
	install -d ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/
	tar zxf ${DL_DIR}/intel-quartus_${QUARTUSVER}-windows.tar.gz -C ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/

	mkdir -p ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/
	cat <<-__EOF__ > ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/quartus.bat
	set QUARTUSVER=${QUARTUSVER}
	set QUARTUSPATH=%OECORE_NATIVE_SYSROOT%\opt\intel-quartus_%QUARTUSVER%
	set QSYS_ROOTDIR=%QUARTUSPATH%\quartus\sopc_builder\bin
	set PATH=%QUARTUSPATH%\quartus\bin64;%PATH%
	__EOF__
}
