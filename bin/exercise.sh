#!/bin/sh

echo "==============================================================================="
./gradlew run
echo "==============================================================================="
echo "XDG_CACHE_HOME=/srv/mycache"
XDG_CACHE_HOME=/srv/mycache ./gradlew run
echo "==============================================================================="
echo "XDG_CONFIG_HOME=~/.config HOME=/srv/myhome"
XDG_CONFIG_HOME=~/.config HOME=/srv/myhome ./gradlew run
echo "==============================================================================="
echo "XDG_CONFIG_HOME=~/.config XDG_CACHE_HOME=/srv/mycache HOME=/srv/myhome"
XDG_CONFIG_HOME=~/.config XDG_CACHE_HOME=/srv/mycache HOME=/srv/myhome ./gradlew run
echo "==============================================================================="
