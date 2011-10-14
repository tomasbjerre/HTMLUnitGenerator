#!/bin/bash
cd compiler
mvn package
cd ..
cp compiler/target/*.jar dist/htmlunitgenerator.jar
