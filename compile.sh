#!/bin/bash
cd compiler
cd testspec
ant
cd ..
mvn -DdownloadSources=true compile
mvn -DdownloadSources=true eclipse:eclipse
cd ..

cd eclipse
mvn eclipse:eclipse
cd ..

