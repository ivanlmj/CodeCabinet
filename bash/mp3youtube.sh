#!/bin/bash

# check binary for youtube-dl
if [ ! -f /usr/local/bin/youtube-dl ] ;
then
	echo "Must download youtube-dl."
	echo -e "\nLink: http://rg3.github.io/youtube-dl/\n"
	exit 1
else
	# checking YouTube URI
	if [[ ! $1 =~ "youtube.com" ]] ;
	then
		echo "YouTube URI, please."
		exit 1
	else
		echo "[DOWNLOAD]"
		/usr/local/bin/youtube-dl --extract-audio --audio-format mp3 "$1"
		echo "[FINISHED]"
	fi
	
	# check folder for mp3 files
	if [ ! -d ~/mp3files ] ;
	then
		mkdir ~/mp3files
		mv *.mp3 ~/mp3files
	else
		mv *.mp3 ~/mp3files
	fi
	echo "Done!"

fi
