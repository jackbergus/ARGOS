#!/bin/bash
sudo add-apt-repository ppa:deadsnakes/ppa
sudo apt install python3.7 python3.7-distutils

#sudo apt-get install python3.8
python3.7 -m pip install --upgrade pip
python3.7 -m pip install -r requirements.txt
python3.7 -m pip install gunicorn
python3.7 -m spacy download en
sudo apt-get install python3-tk