#!/bin/bash

#Compile backend
cd compiler/backend
mvn -DdownloadSources=true compile
mvn -DdownloadSources=true eclipse:eclipse
mvn package
mvn install
cd ..
cd ..
mv compiler/backend/target/*.jar webapp/lib

#Compile Flow Front end
cd compiler/frontend/flowspec/src
ant
cd ..
mvn -DdownloadSources=true eclipse:eclipse
mvn package
cd ..
cd ..
cd ..
mv compiler/frontend/flowspec/target/*.jar webapp/lib

#Compile sample Eclipse project
cd eclipse
mvn eclipse:eclipse
cd ..

#Compile Web App
cd webapp
grails prod war
cd ..


