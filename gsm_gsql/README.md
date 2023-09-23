---
title: "JSON Serialisation for GSM format"
author: "Giacomo Bergami (c) 2023"
date: "2023-09-22"
output: html_document
---

## JSON Serialisation for GSM format

This folder provides a script for downloading the jsonschema2pojo dependencies
for generating the Java classes out of the GSM schema file. Doing so is not 
strictly required, as the current folder already provides the outcome of the 
generation of such scripts. Still, these scripts are provided to abide to the
reproducibility requirements. The dependencies for generating Python3 code are
already provided by the given Dockerfile.

* JSON Schema
   - [GSM.schema.json](GSM.schema.json): the JSON schema file providing the 
     specifications in JSON for represneting the GSM model
* Scripts
   - [dependencies.sh](dependencies.sh): Installing the aforementioned Java 
  dependencies
   - [generate_code.sh](generate_code.sh): Generate the Python3 and Java code 
     from the aforementioned dependencies

The outcome of such scripts (plus some rewritings to provide better support)
are also given in the current folder.
