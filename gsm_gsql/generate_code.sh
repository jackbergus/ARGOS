#!/bin/bash
#Donwloads external Java dependencies for generating the Java code for representing
#the GSM data model as serialised in the JSON format
wget https://github.com/joelittlejohn/jsonschema2pojo/releases/download/jsonschema2pojo-1.2.1/jsonschema2pojo-1.2.1.zip
unzip jsonschema2pojo-1.2.1.zip
pushd jsonschema2pojo-1.2.1
## Generating the Java code in the jsonschema2pojo-1.2.1 folder
./bin/jsonschema2pojo --source ../GSM.schema.json -t .
popd
## Generating the Python3 code
datamodel-codegen --input GSM.schema.json --output gsm_python_generated.py

