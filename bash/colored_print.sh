#!/bin/bash

DONE=`echo -e "\033[0;32m > [DONE] \033[0m \n"`
FAIL=`echo -e "\033[0;31m > [FAIL] \033[0m \n"`
WRONG=" > Wrong option!"

echo
read -p "Confirm operation (y/n)? " result

if [[ $result == "y" ]] ; then	
	echo "$DONE"
elif [[ $result == "n" ]] ; then
	echo "$FAIL"
else
	echo "$WRONG"
fi
