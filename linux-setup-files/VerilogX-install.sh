#!/bin/bash

if [ $(id -u) -ne 0 ]
then
echo "This script was intended to run as root. Try with 'sudo'."
exit
fi


install_package(){
echo "Checking if $1 is installed..."
if ! command -v $1 >/dev/null
then
    echo "$1 is not installed. Installing..."
    apt install $2
else
    echo "$1 is installed."
fi
}


packages=(
    "iverilog iverilog"
    "gtkwave gtkwave"
    "java openjdk-8-jre"
)



for p in "${packages[@]}"
do
install_package $p
done

mkdir /usr/local/VerilogX
cp VerilogX.jar /usr/local/VerilogX/verilogx.jar
chmod +x /usr/local/VerilogX/verilogx.jar
ln -s /usr/local/VerilogX/verilogx.jar /usr/local/bin/verilogx
cp icon.ico /usr/local/VerilogX/icon.ico
cp VerilogX.desktop /usr/share/applications/verilogx.desktop
cp VerilogX-uninstall.sh /usr/local/VerilogX/uninstall.sh
chmod +x /usr/local/VerilogX/uninstall.sh

echo "Successfully Installed VerilogX"

