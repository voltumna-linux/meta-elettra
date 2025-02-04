DESCRIPTION = "Build sophisticated user interfaces with a simple Python API. Run your apps in the terminal and a web browser."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=efa34cbda5817e1e7c540c6cff8f033d"

SRC_URI[sha256sum] = "bec9fe63547c1c552569d1b75d309038b7d456c03f86dfa3706ddb099b151399"

inherit pypi python_poetry_core

BBCLASSEXTEND = "nativesdk"
