#!/bin/bash
echo Downloading from www.jkjsf.net ...
scp -P 22 h2@www.jkjsf.net:~/backup/128db/hbcsprod.zip ./temp/
if [ $? -ne 0 ]
then
  echo "Download Failed!"
  read -p "Press ENTER to exit "
fi