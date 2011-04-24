#!/bin/bash

cd testspec
ant
cd ..

mvn -DdownloadSources=true compile

mvn -DdownloadSources=true eclipse:eclipse
