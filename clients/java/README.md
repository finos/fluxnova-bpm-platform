# Flowave External Task Client (Java)

** Needs To Be Reviewed **

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.finos.fluxnova.bpm/camunda-external-task-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.finos.fluxnova.bpm/camunda-external-task-client)

> Are you looking for the Spring Boot External Task Client? This way please: [Spring Boot External Task Client](../../spring-boot-starter/starter-client)

The **Flowave External Task Client (Java)** allows to set up remote Service Tasks for your workflow.

** Needs To Be Reviewed - Docs and example location **
* [Quick Start](https://docs.flowave.org/get-started/quick-start/)
* [Documentation](https://docs.flowave.org/manual/develop/user-guide/ext-client/)
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
* Java (supported version by the used Flowave Platform 7)
* Flowave Platform 7

## Maven coordinates
The following Maven coordinate needs to be added to the projects `pom.xml`:
```xml
<dependency>
  <groupId>org.finos.fluxnova.bpm</groupId>
  <artifactId>flowave-external-task-client</artifactId>
  <version>${version}</version>
</dependency>
```

## Contributing

Have a look at our [contribution guide](https://github.com/finos/flowave-bpm-platform/blob/master/CONTRIBUTING.md) for how to contribute to this repository.


## License
The source files in this repository are made available under the [Apache License Version 2.0](./LICENSE).
