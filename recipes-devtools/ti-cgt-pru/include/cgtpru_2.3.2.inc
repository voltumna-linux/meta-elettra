# CGTPRUVER="2.3.2"

install_cgtpru_into_sdk() {
#	install -d ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/
#	tar zxf ${DL_DIR}/ti-cgtpru_${CGTPRUVER}-linux.tar.gz -C ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/

	CGTPRUPATH="${SDKPATHNATIVE}/usr/share/ti/cgt-pru"
	PRUINCLUDE="${SDKTARGETSYSROOT}"

	mkdir -p ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/
	cat <<-__EOF__ > ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/cgtpru.sh
	export CLPRU="${CGTPRUPATH}/bin/clpru -i${PRUINCLUDE}/usr/include/${TI_PDK_LIMIT_SOCS} -i${CGTPRUPATH}/include"
	export CLPRUFLAGS="--section_sizes --endian=little --silicon_version=3 -k --symdebug:none --hardware_mac=on"
	export CLPRULDFLAGS="-l${CGTPRUPATH}/lib/libc.a"
	export HEXPRU="${CGTPRUPATH}/bin/hexpru"
	__EOF__
}

#install_cgtpru_into_sdk_sdkmingw32() {
#	install -d ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/
#	tar zxf ${DL_DIR}/ti-cgtpru_${CGTPRUVER}-windows.tar.gz -C ${SDK_OUTPUT}${SDKPATHNATIVE}/opt/
#
#	mkdir -p ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/
#	cat <<-__EOF__ > ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/cgtpru.bat
#	set CGTPRUVER=${CGTPRUVER}
#	set CGTPRUPATH=%OECORE_NATIVE_SYSROOT%\opt\ti-cgtpru_%CGTPRUVER%
#	set PATH=%CGTPRUPATH%\bin;%PATH%
#	set CLPRU=clpru -i %CGTPRUPATH%\include
#	set CLPRULDFLAGS= -l %CGTPRUPATH%\lib\libc.a
#	set HEXPRU=hexpru
#	__EOF__
#}

install_cgtpru_into_sde() {
#	install -d ${IMAGE_ROOTFS}/usr/share/
#	tar zxf ${DL_DIR}/ti-cgtpru_${CGTPRUVER}-linux.tar.gz -C ${IMAGE_ROOTFS}/usr/share/
#
#	mkdir -p ${IMAGE_ROOTFS}${sysconfdir}/profile.d
#	cat <<-__EOF__ > ${IMAGE_ROOTFS}${sysconfdir}/profile.d/cgtpru.sh
#	export CGTPRUVER=\$CGTPRUVER
#	export CGTPRUPATH=/usr/share/ti-cgtpru_\$CGTPRUVER
#	export PATH=\$CGTPRUPATH/bin:\$PATH
#	export CLPRU="clpru -i \$CGTPRUPATH/include"
#	export CLPRULDFLAGS=" -l \$CGTPRUPATH/lib/libc.a"
#	export HEXPRU="hexpru"
#	__EOF__

	CGTPRUPATH="/usr"
	PRUINCLUDE=""

	mkdir -p ${IMAGE_ROOTFS}${sysconfdir}/profile.d
	cat <<-__EOF__ > ${IMAGE_ROOTFS}${sysconfdir}/profile.d/cgtpru.sh
	export CLPRU="${CGTPRUPATH}/bin/clpru -i${PRUINCLUDE}/usr/include/${TI_PDK_LIMIT_SOCS} -i${CGTPRUPATH}/share/ti/cgt-pru/include"
	export CLPRUFLAGS="--section_sizes --endian=little --silicon_version=3 -k --symdebug:none --hardware_mac=on"
	export CLPRULDFLAGS="-l${CGTPRUPATH}/share/ti/cgt-pru/lib/libc.a"
	export HEXPRU="${CGTPRUPATH}/bin/hexpru"
	__EOF__
}
