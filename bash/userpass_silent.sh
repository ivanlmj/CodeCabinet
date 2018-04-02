#!/bin/bash

echo
read -p "Username: " user
read -sp "Password: " pass

if [ -n $user ] && [ -n $pass ] ; then
	echo -e "\n\nCredentials were successfully stored!\n"
fi
