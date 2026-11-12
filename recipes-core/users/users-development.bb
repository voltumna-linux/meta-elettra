# Development variant of the users recipe with all users available
require users.bb
ELETTRA_ACCOUNTS = "all"

# Drop-in replacement for the "users" package: it owns the same
# /etc/ssh/authorized_keys.d/* files (plus the extra accounts), so the two
# packages cannot coexist in the same rootfs. base-files and dpdk RDEPENDS
# on "users": the Provides below lets this package satisfy that dependency
# when an image explicitly installs it (e.g. ds-sde), so the real "users"
# package is not dragged in as well.
RPROVIDES:${PN} = "users"
RREPLACES:${PN} = "users"
RCONFLICTS:${PN} = "users"
