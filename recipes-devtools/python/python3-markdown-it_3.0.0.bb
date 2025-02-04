SUMMARY = "Markdown parser, done right. "
HOMEPAGE = "https://pypi.org/project/markdown-it-py/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a38a1697260a7ad7bf29f44b362db1fc"

inherit pypi python_flit_core

PYPI_PACKAGE = "markdown-it-py"
SRC_URI[sha256sum] = "e3f60a94fa066dc52ec76661e37c851cb232d92f9886b15cb560aaada2df8feb"

BBCLASSEXTEND = "nativesdk"
