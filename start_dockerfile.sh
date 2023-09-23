#!/bin/bash
docker build -t "argos:Dockerfile" .
docker run -it argos:Dockerfile bash
