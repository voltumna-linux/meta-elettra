FILES_${PN} = "${ROOT_HOME}/.ssh"

do_install_append() {
	install -d ${D}${ROOT_HOME}/.ssh
	cat <<-__EOF__ > ${D}${ROOT_HOME}/.ssh/authorized_keys
	ssh-rsa AAAAB3NzaC1yc2EAAAABIwAAAQEAt01T61gbfsPkLolWDPPkGW7GmRcbNnmhH0s7foXZCSofFDpSOdi4HapgKnP2wNnDw8U7aOVB6kqfRSZz3AqvlJplrSNSrNeiQisVIR1nYzwcC81qxiapVMqR3E9E0Rs+8HrlF9DHQf8f6xQvRFBDKde3xaulXeZ+AhmP2sEYcAsqQQcLAQm/h8PIFK+Gws14qS+oVKw1ZYA4DJHphmDJZ0HyH3rxqTaVxYHokWsp5vd1jGTviHTAxrBGA+k1T6oU+7yjMzSQVRdVOiAL9Bz4Nd1VaSSzbgxpljTrP7ZU8BKikqdG+MwCf881xCE7IiT3yfZCpXtfwhPTl0vQEMVDew== abogani@picasso
	__EOF__
}
