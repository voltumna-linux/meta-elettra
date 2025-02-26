do_install:append() {
    sed -i -e's/users/controls/g' -e's/666/660/g' \
        ${D}${sysconfdir}/udev/rules.d/50-tuusb.rules 
}
