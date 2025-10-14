# Fluxnova Platform Assert

**Fluxnova Platform Assert** makes it easy to assert the status of your BPMN processes and CMMN cases when driving them forward in your typical unit test methods. Simply write code like

```groovy
assertThat(instance).isWaitingAt("UserTask_InformCustomer");
assertThat(task).hasCandidateGroup("Sales").isNotAssigned();
```

Furthermore a set of static helper methods is provided to make it easier to drive through a process. Based on the [80/20 principle](https://en.wikipedia.org/wiki/Pareto_principle) the library reaches out to make those things simple you need really often. You will e.g. often have a single open task instance in your process instance. Then just write
 
```groovy
complete(task(instance), withVariables("approved", true));
```

## Compatibility

Fluxnova Platform Assert works with the corresponding version of Fluxnova Platform ** Needs To Be Reviewed ** (i.e., Camunda Platform Assert 7.17.0 is compatible to Camunda Platform 7.17.0). The compatibility between earlier versions are as shown [in the documentation](https://docs.camunda.org/manual/latest/user-guide/testing/#assertions-version-compatibility).
Fluxnova Platform Assert works with multiple Java versions (1.8+). All of this is continuously verified by executing around 500 test cases. 

## Get started

1. Add a maven test dependency to your project:

```xml  
<dependency>
    <groupId>org.finos.fluxnova.bpm</groupId>
    <artifactId>fluxnova-bpm-assert</artifactId>
    <version>${fluxnova.platform.version}</version>
    <scope>test</scope>
</dependency>
```

Additionally, [AssertJ](https://assertj.github.io/doc/) needs to be provided as a dependency with a version that is compatible with the one documented in the ** Needs To Be Reviewed ** [compatibility matrix](https://docs.camunda.org/manual/latest/user-guide/testing/#assertions-version-compatibility).

Please note that if you use [Spring Boot](https://spring.io/projects/spring-boot) or the [Fluxnova Spring Boot Starter] ** Needs To Be Reviewed ** (https://docs.camunda.org/manual/latest/user-guide/spring-boot-integration/) in your project, AssertJ is already included in your project's setup.

2. Add a static import to your test class

Create your test case just as described in the ** Needs To Be Reviewed ** [Fluxnova Platform Testing Guide](https://docs.camunda.org/manual/latest/user-guide/testing/) and add Fluxnova Platform Assert by statically importing it in your test class:

```groovy  
import static org.finos.fluxnova.bpm.engine.test.assertions.ProcessEngineTests.*;
```

3. Start using the assertions in your test methods

You now have access to all the Fluxnova Platform assertions. Assuming you want to assert that your process instance is actually started, waiting at a specific user task and that task should yet be unassigned, but waiting to be assigned to a user of a specific group, just write:

```groovy
assertThat(processInstance).isStarted()
  .task().hasDefinitionKey("edit")
    .hasCandidateGroup("human-resources")
    .isNotAssigned();
```

In case you want to combine Fluxnova Platform Assert with the assertions provided by AssertJ, your imports should look like this:
```groovy  
import static org.assertj.core.api.Assertions.*;
import static org.finos.fluxnova.bpm.engine.test.assertions.ProcessEngineTests.*;
```

## Credits

The Fluxnova Platform Assert project used to be the community extension, created and supported by
** Needs To Be Reviewed **
<img src="http://camunda.github.io/camunda-bpm-assert/resources/images/community-award.png" align="right" width="76">

[Martin Schimak](https://github.com/martinschimak) (plexiti GmbH)<a href="http://plexiti.com">
<img src="https://plexiti.com/images/plexiti-transparent.png" align="right"></img></a><br>
[Jan Galinski](https://github.com/jangalinski) (Holisticon AG)<br>
[Martin Günther](https://github.com/margue) (Holisticon AG)<br>
[Malte Sörensen](https://github.com/malteser) (Holisticon AG)<br>
<a href="http://www.holisticon.de"><img src="https://www.holisticon.de/wp-content/uploads/2020/08/logo2016_black_242.png" align="right" /></a>[Simon Zambrovski](https://github.com/zambrovski) (Holisticon AG)

** Needs To Be Reviewed **
... and [many others](https://github.com/camunda/camunda-bpm-assert/graphs/contributors).
** Needs To Be Reviewed **
In 2014, the library won the **Camunda Platform Community Award**.
** Needs To Be Reviewed **
Starting from version 3.0.0 it was adopted as part of the Fluxnova Platform.
Starting from version 7.17.0 it was merged into the Fluxnova Platform main repository.