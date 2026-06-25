DESCRIPTION = "This recipe adds users to an image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS:append = "bash systemd"

USERADD_PACKAGES = "${PN}"

GROUPADD_PARAM:${PN} = "-g 10000 controls; -g 10100 diagnostics; -g 10200 physics; \
    -g 10300 operators;"
USERADD_PARAM:${PN} = "--uid 10000 --groups controls,dialout,video --no-create-home \
    --home-dir /var/run/tango --shell /bin/nologin controls;"

lorenzo.pivetta = "--uid 11000 --groups controls,dialout,video --no-create-home \
    --home-dir /home/lorenzo.pivetta --shell /bin/bash lorenzo.pivetta;"
alessio.bogani = "--uid 11001 --groups controls,dialout,video --no-create-home \
    --home-dir /home/alessio.bogani --shell /bin/bash alessio.bogani;"
giulio.gaio = "--uid 11002 --groups controls,dialout,video --no-create-home \
    --home-dir /home/giulio.gaio --shell /bin/bash giulio.gaio;"
graziano.scalamera = "--uid 11003 --groups controls,dialout,video --no-create-home \
    --home-dir /home/graziano.scalamera --shell /bin/bash graziano.scalamera;"
claudio.scafuri = "--uid 11004 --groups controls,dialout,video --no-create-home \
    --home-dir /home/claudio.scafuri --shell /bin/bash claudio.scafuri;"
alessandro.abrami = "--uid 11005 --groups controls,dialout,video --no-create-home \
    --home-dir /home/alessandro.abrami --shell /bin/bash alessandro.abrami;"
martin.scarcia = "--uid 11006 --groups controls,dialout,video --no-create-home \
    --home-dir /home/martin.scarcia --shell /bin/bash martin.scarcia;"
igor.trovarelli = "--uid 11007 --groups controls,dialout,video --no-create-home \
    --home-dir /home/igor.trovarelli --shell /bin/bash igor.trovarelli;"
adriano.contillo = "--uid 11008 --groups controls,dialout,video --no-create-home \
    --home-dir /home/adriano.contillo --shell /bin/bash adriano.contillo;"
maurizio.bossi = "--uid 11100 --groups diagnostics,dialout,video --no-create-home \
    --home-dir /home/maurizio.bossi --shell /bin/bash maurizio.bossi;"
mauro.trovo = "--uid 11200 --groups physics,dialout,video --no-create-home \
    --home-dir /home/mauro.trovo --shell /bin/bash mauro.trovo;"
sara.dastan = "--uid 11201 --groups physics,dialout,video --no-create-home \
    --home-dir /home/sara.dastan --shell /bin/bash sara.dastan;"
ivan.morozov = "--uid 11202 --groups physics,dialout,video --no-create-home \
    --home-dir /home/ivan.morozov --shell /bin/bash ivan.morozov;"
koryun.manukyan = "--uid 11203 --groups physics,dialout,video --no-create-home \
    --home-dir /home/koryun.manukyan --shell /bin/bash koryun.manukyan;"
stefano.krecic = "--uid 11204 --groups physics,dialout,video --no-create-home \
    --home-dir /home/stefano.krecic --shell /bin/bash stefano.krecic;"
francesco.tripaldi = "--uid 11300 --groups operators,dialout,video --no-create-home \
    --home-dir /home/francesco.tripaldi --shell /bin/bash francesco.tripaldi;"

# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

ALLOW_EMPTY:${PN} = "1"

inherit useradd
