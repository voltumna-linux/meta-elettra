SUMMARY = "URL utilities for markdown-it"
HOMEPAGE = "https://github.com/executablebooks/mdurl"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aca1dc6b9088f1dda81c89cad2c77ad1"

inherit pypi python_flit_core

PYPI_PACKAGE = "mdurl"
SRC_URI[sha256sum] = "bb413d29f5eea38f31dd4754dd7377d4465116fb207585f97bf925588687c1ba"

BBCLASSEXTEND = "nativesdk"
