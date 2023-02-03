install_tango_sh() {
	mkdir -p ${SDK_OUTPUT}/${SDKPATHNATIVE}/environment-setup.d/
	cat <<-__EOF__ >> ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/tango.sh
	export TANGO_HOST=srv-tango-ctrl-01.elettra.trieste.it:20000
	__EOF__
}

install_sdk_sh() {
	mkdir -p ${SDK_OUTPUT}/${SDKPATHNATIVE}/environment-setup.d/
	cat <<-__EOF__ >> ${SDK_OUTPUT}${SDKPATHNATIVE}/environment-setup.d/sdk.sh
	export MAKEFLAGS=-j\`getconf _NPROCESSORS_ONLN\`
	__EOF__
}

POPULATE_SDK_POST_HOST_COMMAND_append += " install_tango_sh; install_sdk_sh;"
