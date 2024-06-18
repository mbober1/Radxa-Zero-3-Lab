#!/bin/sh

if [ $# -lt 1 ]; then
	exit 0;
fi

function get_current_root_device
{
	for i in `cat /proc/cmdline`; do
		if [ ${i:0:5} = "root=" ]; then
			CURRENT_ROOT="${i:5}"
		fi
	done

	#returns PARTLABEL=rootfsX
}

function get_update_device
{
	if [ $CURRENT_ROOT = "PARTLABEL=rootfsA" ]; then
		UPDATE_ROOT="/dev/disk/by-label/rootfsB";
		UPDATE_LABEL="rootfsB";
		CURRENT_LABEL="rootfsA";
	else
		UPDATE_ROOT="/dev/disk/by-label/rootfsA";
		UPDATE_LABEL="rootfsA";
		CURRENT_LABEL="rootfsB";
	fi

	#returns PARTLABEL=rootfsA or PARTLABEL=rootfsB
}

function format_update_device
{
	umount $UPDATE_ROOT || true
	mkfs.ext4 $UPDATE_ROOT -q -F -m0 -L ${UPDATE_LABEL}
}

if [ $1 == "preinst" ]; then
	#stop any services here

	# get the current root device
	get_current_root_device

	# get the device to be updated
	get_update_device

	# format the device to be updated
	format_update_device

	# create a symlink for the update process
	ln -sf $UPDATE_ROOT /dev/update
fi

if [ $1 == "postinst" ]; then

	# get the current root device
	get_current_root_device

	# get the device to be updated
	get_update_device

	# change extlinux.conf to boot from the updated device 
	sed -i "s/$CURRENT_LABEL/$UPDATE_LABEL/g" /boot/extlinux/extlinux.conf
fi
