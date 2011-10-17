#!/bin/bash

#Compile backend
cd compiler/backend
mvn -DdownloadSources=true compile
mvn -DdownloadSources=true eclipse:eclipse
mvn package
mvn install
cd ..
cd ..
mv compiler/backend/target/*.jar dist

#Compile XML Front end
cd compiler/frontend/xmlspec/src
ant
cd ..
mvn -DdownloadSources=true eclipse:eclipse
mvn package
cd ..
cd ..
cd ..
mv compiler/frontend/xmlspec/target/*.jar dist

#Compile sample Eclipse project
cd eclipse
mvn eclipse:eclipse
cd ..

#Compile Web App
cd webapp
grails prod war
cd ..
mv webapp/target/*.war dist

