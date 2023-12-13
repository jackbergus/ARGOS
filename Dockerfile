# syntax=docker/dockerfile:1
FROM ubuntu:jammy
LABEL maintainer="bergamigiacomo@gmail.com"
LABEL version="0.1"
LABEL description="Showcasing ARGA and DGDL"
ARG DEBIAN_FRONTEND=noninteractive
ADD requirements.txt /root/requirements.txt
RUN echo "--------------------------------"
RUN echo "|                              |"
RUN echo "| // _ \                       |"
RUN echo "|// |_| | ___ _   _ ___        |"
RUN echo "| |  _  |/ _ ( \ / ) _ \ /     |"
RUN echo "| | | | | |_) ) v ( (_) |      |"
RUN echo "| |_| |_|  __/ | | \___/       |"
RUN echo "|       | |    | |             |"
RUN echo "|       |_|    |_|             |"
RUN echo "|                              |"
RUN echo "|                              |"
RUN echo "| (by Giacomo Bergami - 2023)  |"
RUN echo "--------------------------------"
RUN apt-get update && apt-get upgrade -y && apt-get clean
RUN apt-get update && \
    apt-get install -y software-properties-common 
RUN add-apt-repository ppa:deadsnakes/ppa
RUN apt-get update --allow-insecure-repositories -y && apt-get install apt-file -y && apt-file update && apt-get install -y python3-dev build-essential python3.9
RUN apt-get install wget
RUN wget https://bootstrap.pypa.io/get-pip.py
RUN python3 get-pip.py
RUN pip3 install --trusted-host pypi.python.org --only-binary :all:  spacy==2.3.8
RUN python3 -m pip install --upgrade pip
RUN pip3 install --only-binary :all: pandas==1.3.3
RUN pip3 install --trusted-host pypi.python.org pywsd==1.2.4
RUN pip3 install --trusted-host pypi.python.org --only-binary :all: -r /root/requirements.txt
RUN pip3 install --trusted-host pypi.python.org --only-binary :all: antlr4-python3-runtime==4.13.1 readerwriterlock pathlib nltk==3.6 fuzzywuzzy==0.18.0 joblib==0.14.1 numpy==1.21.2 networkx==2.4 flask==2.1.3 requests==2.25.0 scikit_learn==1.0.2 itsdangerous==2.0.1 werkzeug==2.0.3 pytz jinja2  datamodel-code-generator uvicorn==0.24.0 fastapi==0.104.1 pytest
RUN pip3 install wn==0.0.22
##########
## GIT  ##
##########
RUN apt-get install -y git
##########
## C++  ##
##########
RUN apt-get install -y clang cmake autotools-dev autoconf
##########
## JAVA ##
##########
RUN apt-get install -y wget
RUN wget https://download.oracle.com/java/19/archive/jdk-19.0.2_linux-x64_bin.deb
RUN apt-get install libc6-i386 libc6-x32 libxi6 libxtst6 libasound2 libfreetype6 libxrender1 maven -y
RUN dpkg -i jdk-19.0.2_linux-x64_bin.deb
ENV JAVA_HOME /usr/lib/jvm/jdk-19/
#ADD ARGA_DEP/pom.xml .
#RUN --mount=type=cache,target=/root/.m2 mvn clean package -Dmaven.main.skip -Dmaven.test.skip && rm -rf target
##########
## HAXE ##
##########
RUN apt-get install -y haxe
RUN haxelib setup /usr/share/haxe/lib
RUN haxelib install json2object
RUN haxelib install polygonal-ds
RUN haxelib install hxjava
RUN haxelib install hxcs
RUN haxelib install hxcpp
ADD . /root/
#RUN cd /root/ARGA/ && mvn clean install spring-boot:repackage && mvn compile
###############################
# Exposing the services ports #
###############################

# Fix DNS resolution issues when nss is not installed
RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf


EXPOSE 5000 8001 8000 8888
CMD bash
# Now, on the terminal, type "cd /root/ARGA/ && mvn clean install spring-boot:repackage compile" and exit upon hagnging up untill the setup is not finished! Then, mvn exec:java -pl tweetyPrEAF -Dexec.mainClass=uk.jackbergus.ARGA.SouthamptonArgumentation. 
