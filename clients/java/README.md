# Fluxnova External Task Client (Java)

** Needs To Be Reviewed **

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.finos.fluxnova.bpm/camunda-external-task-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.finos.fluxnova.bpm/camunda-external-task-client)

> Are you looking for the Spring Boot External Task Client? This way please: [Spring Boot External Task Client](../../spring-boot-starter/starter-client)

The **Fluxnova External Task Client (Java)** allows to set up remote Service Tasks for your workflow.

** Needs To Be Reviewed -Example location **
* [Quick Start](https://docs.fluxnova.finos.org/get-started/quick-start/)
* [Documentation](https://docs.fluxnova.finos.org/user-guide/ext-client/)
* [Examples](https://github.com/camunda/camunda-bpm-examples/tree/master/clients/java)

## Features
* Complete External Tasks
* Extend the lock duration of External Tasks
* Unlock External Tasks
* Report BPMN errors as well as failures
* Share primitive and object typed process variables with the Workflow Engine


## Configuration options
* The client can be configured with the fluent api of the [ExternalTaskClientBuilder](client/src/main/java/org/finos/fluxnova/bpm/client/ExternalTaskClientBuilder.java).
* The topic subscription can be configured with the fluent api of the [TopicSubscriptionBuilder](client/src/main/java/org/finos/fluxnova/bpm/client/topic/TopicSubscriptionBuilder.java).

## Prerequisites
* Java (supported version by the used Fluxnova Platform 1.0.0)
* Fluxnova Platform 1.0.0

## Maven coordinates
The following Maven coordinate needs to be added to the projects `pom.xml`:
```xml
<dependency>
  <groupId>org.finos.fluxnova.bpm</groupId>
  <artifactId>fluxnova-external-task-client</artifactId>
  <version>${version}</version>
</dependency>
```

## Contributing

Have a look at our [contribution guide](https://github.com/finos/fluxnova-bpm-platform/blob/main/CONTRIBUTING.md) for how to contribute to this repository.


## License
The source files in this repository are made available under the [Apache License Version 2.0](./LICENSE).
