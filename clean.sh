#!/bin/bash

#Clean backend
cd compiler/backend
mvn clean
cd ..
cd ..

#Clean Flow Front end
cd compiler/frontend/flowspec/src
ant clean
cd ..
mvn clean
cd ..
cd ..
cd ..
rm -rf compiler/frontend/flowspec/bin

#Clean sample Eclipse project
cd eclipse
mvn clean
cd ..

#Clean Web App
cd webapp
grails clean
cd ..

