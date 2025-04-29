DESCRIPTION = "This recipe adds users to an image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS:append = "bash systemd"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
	--uid 10000 --user-group --groups dialout --no-create-home \
            --home-dir /var/run/tango --shell /bin/nologin controls; \
            "

lorenzo.pivetta = "--uid 11000 --groups controls,dialout --no-create-home \
            --home-dir /home/lorenzo.pivetta --shell /bin/bash lorenzo.pivetta; \
            "
alessio.bogani = "--uid 11001 --groups controls,dialout --no-create-home \
            --home-dir /home/alessio.bogani --shell /bin/bash alessio.bogani; \
            "
giulio.gaio = "--uid 11002 --groups controls,dialout --no-create-home \
            --home-dir /home/giulio.gaio --shell /bin/bash giulio.gaio; \
            "
graziano.scalamera = "--uid 11003 --groups controls,dialout --no-create-home \
            --home-dir /home/graziano.scalamera --shell /bin/bash graziano.scalamera; \
            "
claudio.scafuri = "--uid 11004 --groups controls,dialout --no-create-home \
            --home-dir /home/claudio.scafuri --shell /bin/bash claudio.scafuri; \
            "
alessandro.abrami = "--uid 11005 --groups controls,dialout --no-create-home \
            --home-dir /home/alessandro.abrami --shell /bin/bash alessandro.abrami; \
            "
martin.scarcia = "--uid 11006 --groups controls,dialout --no-create-home \
            --home-dir /home/martin.scarcia --shell /bin/bash martin.scarcia; \
            "
adriano.contillo = "--uid 11008 --groups controls,dialout --no-create-home \
            --home-dir /home/adriano.contillo --shell /bin/bash adriano.contillo; \
            "
igor.trovarelli = "--uid 11007 --groups controls,dialout --no-create-home \
            --home-dir /home/igor.trovarelli --shell /bin/bash igor.trovarelli; \
            "
maurizio.bossi = "--uid 11100 --groups dialout --no-create-home \
            --home-dir /home/maurizio.bossi --shell /bin/bash maurizio.bossi; \
            "
mauro.trovo = "--uid 11200 --groups dialout,video --no-create-home \
            --home-dir /home/mauro.trovo --shell /bin/bash mauro.trovo; \
            "

# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

ALLOW_EMPTY_${PN} = "1"

inherit useradd
