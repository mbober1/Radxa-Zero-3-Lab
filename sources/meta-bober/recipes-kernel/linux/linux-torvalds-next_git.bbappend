FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
	file://fragment.cfg \
	file://0001-add-onewire-bus.patch \
"

SRCREV = "6906a84c482f098d31486df8dc98cead21cce2d0"
