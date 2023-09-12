#!/bin/bash
haxelib install hxjava
haxelib install hxcs
haxelib install hxcpp
sudo apt-get install g++
rm -rf java
rm -rf cs
rm -rf python3
mkdir python3
pushd src
haxe --java ../java/ jackbergus/dgep/RestfulHTTPConnections.hx jackbergus/protocol/EvaluatorOrSubscriber.hx jackbergus/protocol/ProposerOrPublisher.hx 
haxe --cs   ../cs/   jackbergus/dgep/RestfulHTTPConnections.hx jackbergus/protocol/EvaluatorOrSubscriber.hx jackbergus/protocol/ProposerOrPublisher.hx 
haxe --cpp   ../cpp/   jackbergus/dgep/RestfulHTTPConnections.hx jackbergus/protocol/EvaluatorOrSubscriber.hx jackbergus/protocol/ProposerOrPublisher.hx 
haxe --python  ../python3/main.py   jackbergus/dgep/RestfulHTTPConnections.hx jackbergus/protocol/EvaluatorOrSubscriber.hx jackbergus/protocol/ProposerOrPublisher.hx 
popd 
rm -rf protocol
mvn archetype:generate -DgroupId=uk.jackbergus -DartifactId=protocol -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
cp -r java/src/* protocol/src/main/java
pushd protocol
mvn test-compile
popd
rm -rf java
rm -rf cs/bin/*
rm -rf cpp/obj/*
rm -rf cpp/output
echo '#!/usr/bin/env python3' | cat - python3/main.py > temp && mv temp python3/main.py
