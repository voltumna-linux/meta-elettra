#!/bin/sh

mkdir -p /run/tango

IPADDRESS=$(networkctl status @ETH@ | sed -ne 's/^[[:space:]]*Address:[[:space:]]*\([0-9.]*\).*/\1/p')

case $(echo $IPADDRESS | cut -d"." -f3) in
	204)     TANGO_HOST=tom.ecs.elettra.trieste.it:20000;;
	23*|246) TANGO_HOST=srv-tango-srf-01.fcs.elettra.trieste.it:20000;;
	248)     TANGO_HOST=srv-tango-padres-01.fcs.elettra.trieste.it:20000;;
	249)     TANGO_HOST=srv-tango-tmr-01.fcs.elettra.trieste.it:20000;;
	244)     TANGO_HOST=srv-tango-tmx-01.fcs.elettra.trieste.it:20000;;
	245)     TANGO_HOST=srv-dpi-srf.fcs.elettra.trieste.it:20000;;
	247)     TANGO_HOST=srv-ldm-srf.fcs.elettra.trieste.it:20000;;
	228)     TANGO_HOST=srv-tf-srf.fcs.elettra.trieste.it:20000;;
	*)       TANGO_HOST=ken.elettra.trieste.it:20000;;
esac

echo TANGO_HOST=$TANGO_HOST > /run/tango/tangorc
echo export ORBendPoint=giop:tcp:$IPADDRESS: > /run/tango/corba.sh
