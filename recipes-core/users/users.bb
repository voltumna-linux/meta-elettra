DESCRIPTION = "This recipe adds users to an image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

USERADD_PACKAGES = "${PN}"

GROUPADD_PARAM:${PN} = "-g 10000 controls; -g 10100 diagnostics; -g 10200 physics; \
    -g 10300 operators;"

ELETTRA_ACCOUNTS ?= ""
ELETTRA_SUDO_ACCOUNTS ?= ""

def elettra_registry(d):
    import bb, glob, os, re
    out = {}
    for path in sorted(glob.glob(os.path.join(os.path.dirname(d.getVar('FILE')), 'accounts', '*'))):
        name = os.path.basename(path)
        if name == 'README.md' or name.startswith('.'):
            continue
        if not re.match(r'^[a-z][a-z0-9._-]*$', name):
            bb.fatal('%s: nome account non valido' % path)
        param, keys, fields = None, [], set()
        with open(path) as f:
            for n, raw in enumerate(f, 1):
                line = raw.strip()
                if not line or line.startswith('#'):
                    continue
                if re.search(r'\b(ssh-|ecdsa-|sk-)[a-z0-9-]+[ \t]+AAAA[A-Za-z0-9+/=]+', line):
                    keys.append(line)
                    continue
                m = re.match(r'^([a-z][a-z0-9_-]*):[ \t]*(.*)$', line)
                if not m:
                    bb.fatal("%s:%d: riga inattesa (atteso un campo 'nome: valore' o una chiave pubblica): %s"
                             % (path, n, line))
                field, value = m.group(1), m.group(2).strip()
                if field != 'useradd':
                    bb.fatal('%s:%d: campo sconosciuto "%s" (formato in accounts/README.md)'
                             % (path, n, field))
                if field in fields:
                    bb.fatal('%s:%d: campo "%s" ripetuto' % (path, n, field))
                if not value:
                    bb.fatal('%s:%d: campo "%s" vuoto' % (path, n, field))
                fields.add(field)
                param = value
        if param is None:
            bb.fatal('%s: manca il campo "useradd"' % path)
        out[name] = (param, keys)
    return out

def elettra_selected(d):
    import bb
    registry = elettra_registry(d)
    sudo = set(d.getVar('ELETTRA_SUDO_ACCOUNTS').split())
    names = d.getVar('ELETTRA_ACCOUNTS').split()
    if 'all' in names:
        if len(names) != 1:
            bb.fatal('ELETTRA_ACCOUNTS: "all" non e\' combinabile con altri account')
        names = sorted(registry)
    out, seen = [], set()
    for name in names:
        if name in seen:
            bb.fatal('ELETTRA_ACCOUNTS: account "%s" ripetuto' % name)
        seen.add(name)
        if name not in registry:
            bb.fatal('ELETTRA_ACCOUNTS: account "%s" senza file in accounts/' % name)
        out.append((name, registry[name][0], registry[name][1], name in sudo))
    for name in sorted(sudo):
        if name not in seen:
            bb.fatal('ELETTRA_SUDO_ACCOUNTS: account "%s" non selezionato in ELETTRA_ACCOUNTS' % name)
    return out

def elettra_useradd_param(d):
    import re
    out = []
    for name, param, keys, sudo in elettra_selected(d):
        if sudo:
            m = re.search(r'--groups[= ]([A-Za-z0-9._,-]+)', param)
            if m:
                groups = m.group(1).split(',')
                if 'sudo' not in groups:
                    groups.append('sudo')
                param = param[:m.start(1)] + ','.join(groups) + param[m.end(1):]
            else:
                param = '--groups sudo ' + param
        out.append('%s %s' % (param, name))
    return '; '.join(out)

USERADD_PARAM:${PN} = "--uid 10000 -g controls --groups dialout,video --no-create-home \
    --home-dir /var/run/tango --shell /bin/nologin controls; ${@elettra_useradd_param(d)}"

python do_install() {
    import os
    keydir = os.path.join(d.getVar('D'), d.getVar('sysconfdir').lstrip('/'),
                          'ssh', 'authorized_keys.d')
    os.makedirs(keydir, exist_ok=True)
    for name, param, keys, sudo in elettra_selected(d):
        path = os.path.join(keydir, name)
        with open(path, 'w') as f:
            for k in keys:
                f.write(k + '\n')
        os.chmod(path, 0o644)
    os.chmod(keydir, 0o755)
}

FILES:${PN} += "${sysconfdir}/ssh/authorized_keys.d"

# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

ALLOW_EMPTY:${PN} = "1"

inherit useradd
