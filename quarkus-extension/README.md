# Fluxnova Platform Quarkus Extensions

** Needs To Be Reviewed **
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.camunda.bpm.quarkus/camunda-bpm-quarkus-engine/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.camunda.bpm.quarkus/camunda-bpm-quarkus-engine) [![camunda manual latest](https://img.shields.io/badge/manual-latest-brown.svg)](https://docs.camunda.org/manual/develop/user-guide/quarkus-integration/)

This sub-project provides Fluxnova Platform Quarkus Extensions that allow you to add behavior to your Quarkus 
application by adding dependencies to the classpath.

You can find the documentation on the Fluxnova Platform Quarkus Extensions 
[here](https://docs.fluxnova.finos.org/user-guide/quarkus-integration/).

** Needs To Be Reviewed **
We also provide some useful examples at our 
[camunda-bpm-examples](https://github.com/camunda/camunda-bpm-examples/tree/master/quarkus-extension) repository.

```xml
<dependency>
  <dependency>
    <groupId>org.finos.fluxnova.bpm.quarkus</groupId>
    <artifactId>fluxnova-bpm-quarkus-engine</artifactId>
    <version>${version.fluxnova}</version><!-- place Fluxnova version here -->
  </dependency>
</dependency>
```

To configure a Fluxnova Platform Quarkus extension, you can use an `application.properties` file. It
can look like the following:

```properties
# process engine configuration
quarkus.fluxnova.generic-config.cmmn-enabled=false
quarkus.fluxnova.generic-config.dmn-enabled=false
quarkus.fluxnova.generic-config.history=none

# job executor configuration
quarkus.fluxnova.job-executor.thread-pool.max-pool-size=12
quarkus.fluxnova.job-executor.thread-pool.queue-size=5
quarkus.fluxnova.job-executor.generic-config.max-jobs-per-acquisition=5
quarkus.fluxnova.job-executor.generic-config.lock-time-in-millis=500000
quarkus.fluxnova.job-executor.generic-config.wait-time-in-millis=7000
quarkus.fluxnova.job-executor.generic-config.max-wait=65000
quarkus.fluxnova.job-executor.generic-config.backoff-time-in-millis=5

# custom data source configuration and selection
quarkus.datasource.my-datasource.db-kind=h2
quarkus.datasource.my-datasource.username=fluxnova
quarkus.datasource.my-datasource.password=fluxnova
quarkus.datasource.my-datasource.jdbc.url=jdbc:h2:mem:fluxnova;TRACE_LEVEL_FILE=0;DB_CLOSE_ON_EXIT=FALSE
quarkus.fluxnova.datasource=my-datasource
```

### Local Build

The extension is built against Quarkus 3.40.1.1 LTS and requires Java 21 for this
repository's build. Keep the application's Quarkus BOM and build plugin aligned
with the extension's Quarkus version.

#### Executing the Tests  
```mvn clean install -Pquarkus-tests```

The `quarkus-tests` profile is required: extension tests are skipped by default.
It enables both the deployment-module tests and the CDI QA tests, including the
shared CDI tests packaged by `engine-cdi`.

GitHub Actions runs these suites in the existing integration-test job, in a
separate "Quarkus extension tests" step before the Tomcat suite. After installing
internal artifacts, it cleans JUEL's workspace output as described below and
runs the extension tests with `quarkus-tests` enabled, without `-am`.

To build and test just the extension and its reactor dependencies from the
repository root:

```shell
mvn clean install -Pquarkus-tests -pl :fluxnova-bpm-quarkus-engine-deployment,:fluxnova-bpm-quarkus-engine-qa -am
```

#### Upgrading from Quarkus 3.27

Quarkus 3.40 uses JUnit 6. Extension tests now depend on
`quarkus-junit-internal` instead of `quarkus-junit5-internal`. Custom Surefire JVM
arguments must retain `@{argLine}` so injected test and coverage arguments are
preserved.

Runtime configuration is supplied to the engine recorder through
`RuntimeValue<FluxnovaEngineConfig>`; build steps must not consume runtime
configuration directly.

ArC rejects CDI Full features such as `@Specializes` during augmentation. Use
CDI alternatives instead. The extension tests verify this rejection separately
from supported bean lookup and exclude the unused specialization fixture from
the shared CDI QA deployment.

The default JDBC connection pool maximum increased from 20 to 50 in Quarkus
3.31. Applications that need the previous limit should explicitly configure
`quarkus.datasource.jdbc.max-size=20` (and the corresponding property for each
named datasource). The extension does not override Quarkus's datasource defaults.

The TLS registry also defaults to TLS 1.3. Applications using it should verify
compatibility with their endpoints and configure supported protocols explicitly
if TLS 1.2 is still required.

Review the intervening
[Quarkus migration guides](https://github.com/quarkusio/quarkus/wiki/Migration-Guides)
for changes affecting other extensions used by the application.


---------
#### Quarkus and JUEL bytecode incompatibilities

**Context**: Quarkus workspace discovery may bypass the packaged JUEL jar and
load classes whose Jakarta EL references have not been relocated.

**Solution**: Quarkus workspace discovery can load unshaded JUEL classes from
`juel/target/classes` instead of the installed shaded artifact. First install
JUEL with `mvn install -pl :fluxnova-juel -DskipTests`. Then remove only its
workspace output with `mvn clean -pl :fluxnova-juel` and rerun the extension
tests without `-am`:

```shell
mvn verify -Pquarkus-tests -pl :fluxnova-bpm-quarkus-engine,:fluxnova-bpm-quarkus-engine-deployment,:fluxnova-bpm-quarkus-engine-qa
```

The other reactor dependencies must already be installed.

<details>

<summary>Stacktrace</summary>

```java
Caused by: java.lang.VerifyError: Bad type on operand stack
Exception Details:
Location:
org/fluxnova/bpm/engine/impl/el/JuelExpressionManager.<init>(Ljava/util/Map;)V @28: putfield
Reason:
Type 'org/fluxnova/bpm/impl/juel/ExpressionFactoryImpl' (current frame, stack[1]) is not assignable to 'org/fluxnova/bpm/impl/juel/jakarta/el/ExpressionFactory'
Current Frame:
bci: @28
flags: { }
locals: { 'org/fluxnova/bpm/engine/impl/el/JuelExpressionManager', 'java/util/Map' }
stack: { 'org/fluxnova/bpm/engine/impl/el/JuelExpressionManager', 'org/fluxnova/bpm/impl/juel/ExpressionFactoryImpl' }
Bytecode:
0000000: 2ab7 0007 2abb 000c 59b7 000e b500 0f2a
0000010: 03b5 0013 2abb 0017 59b7 0019 b500 1a2a
0000020: 2bb5 001e b1```
</details>

#### Platform integration tests

After installing the current Tomcat assembly, run the platform integration suite
from the repository root:

```shell
mvn clean verify -f qa/pom.xml -Ptomcat,engine-integration-jakarta,h2
```

Keep the `clean` phase when reusing a workspace. The Jakarta suite copies test
sources into `target/generated-test-sources`; copying does not remove previously
generated files for tests deleted from the repository. Without cleaning, obsolete
JBoss tests can still run under Tomcat and fail on unsupported JNDI bindings.
