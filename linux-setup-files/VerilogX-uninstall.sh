#!/bin/bash

if [ $(id -u) -ne 0 ]
then
echo "This script was intended to run as root. Try with 'sudo'."
exit
fi

echo "Uninstalling VerilogX"

rm /usr/local/bin/verilogx
rm /usr/share/applications/verilogx.desktop
rm -r /usr/local/VerilogX

echo "Uninstall successful."
