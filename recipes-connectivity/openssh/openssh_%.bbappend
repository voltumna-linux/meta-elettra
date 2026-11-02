FILES:${PN} += " \
    ${sysconfdir}/ssh/sshd_config.d \
    "

do_install:append() {
	install -d ${D}${sysconfdir}/ssh/sshd_config.d
	cat <<-__EOF__ > ${D}${sysconfdir}/ssh/sshd_config.d/voltumna.conf
AuthenticationMethods publickey
PubkeyAuthentication yes
AuthorizedKeysFile /etc/ssh/authorized_keys.d/%u
PermitRootLogin no
PasswordAuthentication no
KbdInteractiveAuthentication no
ChallengeResponseAuthentication no
	__EOF__
}
