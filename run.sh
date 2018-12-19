#!/bin/bash
mvn clean install
export PORT="8080"
java -jar target/dependency/webapp-runner.jar --port $PORT target/*.war
