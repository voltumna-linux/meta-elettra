CGTPRUVER="2.3.2"

install_cgtpru_into_sdk() {
	install -d ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/
	tar zxf ${DL_DIR}/ti-cgtpru_${CGTPRUVER}-linux.tar.gz -C ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/

	mkdir -p ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/
	cat <<-__EOF__ > ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/cgtpru.sh
	export CGTPRUVER=${CGTPRUVER}
	export CGTPRUPATH=\$OECORE_NATIVE_SYSROOT/opt/ti-cgtpru_\$CGTPRUVER
	export PATH=\$CGTPRUPATH/bin:\$PATH
	export CLPRU="clpru -i \$CGTPRUPATH/include"
	export CLPRULDFLAGS=" -l \$CGTPRUPATH/lib/libc.a"
	export HEXPRU="hexpru"
	__EOF__
}

install_cgtpru_into_sdk_sdkmingw32() {
	install -d ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/
	tar zxf ${DL_DIR}/ti-cgtpru_${CGTPRUVER}-windows.tar.gz -C ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/

	mkdir -p ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/
	cat <<-__EOF__ > ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/cgtpru.bat
	set CGTPRUVER=${CGTPRUVER}
	set CGTPRUPATH=%OECORE_NATIVE_SYSROOT%\opt\ti-cgtpru_%CGTPRUVER%
	set PATH=%CGTPRUPATH%\bin;%PATH%
	set CLPRU=clpru -i %CGTPRUPATH%\include
	set CLPRULDFLAGS= -l %CGTPRUPATH%\lib\libc.a
	set HEXPRU=hexpru
	__EOF__
}

install_cgtpru_into_sde() {
	mv ${IMAGE_ROOTFS}/usr/share/ti/cgt-pru ${IMAGE_ROOTFS}/usr/share/ti/cgt-pru_${CGTPRUVER}
	install -d ${IMAGE_ROOTFS}${sysconfdir}/profile.d
	cat <<-__EOF__ > ${IMAGE_ROOTFS}${sysconfdir}/profile.d/cgtpru.sh
	export CGTPRUVER=${CGTPRUVER}
	export CGTPRUPATH=/usr/share/ti/cgt-pru_${CGTPRUVER}
	export CLPRU="clpru -i \$CGTPRUPATH/include"
	export CLPRULDFLAGS=" -l \$CGTPRUPATH/lib/libc.a"
	export HEXPRU="hexpru"
	__EOF__
}
