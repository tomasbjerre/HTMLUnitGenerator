#!/bin/bash

#Clean backend
cd compiler/backend
mvn clean
cd ..
cd ..

#Clean XML Front end
cd compiler/frontend/xmlspec/src
ant clean
cd ..
mvn clean
cd ..
cd ..
cd ..

#Clean sample Eclipse project
cd eclipse
mvn clean
cd ..

#Clean Web App
cd webapp
grails clean
cd ..

