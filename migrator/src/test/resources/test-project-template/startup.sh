#!/bin/bash
# Camunda startup script

export CAMUNDA_HOME=/opt/camunda
export CAMUNDA_PORT=8080

echo "Starting Camunda BPM Platform..."
java -jar $CAMUNDA_HOME/camunda-bpm-run.jar
