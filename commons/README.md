# fluxnova commons

 ** Needs To Be Reviewed **

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.camunda.commons/camunda-commons-bom/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.camunda.commons/camunda-commons-bom)


fluxnova commons is a collection of shared libraries used by fluxnova open source projects.

## List of libraries

* [fluxnova commons logging][logging]
* [fluxnova commons utils][utils]
* [fluxnova-bpm-platform][typed-values]


## Getting started

If your project is a maven project, start by importing the `fluxnova-commons-bom`.
This will ensure that your project uses all commons libraries in the same version:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.finos.fluxnova.commons</groupId>
      <artifactId>fluxnova-commons-bom</artifactId>
      <version>${version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

Now you can reference individual commons projects:

```xml
<dependency>
  <groupId>org.finos.fluxnova.commons</groupId>
  <artifactId>fluxnova-commons-logging</artifactId>
</dependency>
```

## FAQ

### Which Java (JRE) Version is required?

Java JRE 11+ is required.

## Contributing

Have a look at our [contribution guide](https://github.com/finos/fluxnova-bpm-platform/blob/main/CONTRIBUTING.md) for how to contribute to this repository.


## License:

The source files in this repository are made available under the <a href="LICENSE">Apache License, Version 2.0</a>.

[logging]: logging/
[utils]: utils/
[typed-values]: typed-values/
