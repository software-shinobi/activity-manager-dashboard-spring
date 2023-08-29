#!/bin/bash

##

set -e

set -x

##

reset

clear

##

mvn install

##

java -jar target/activity-manager-dashboard-1.0.jar
