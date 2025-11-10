
==================

Lightweight Execution Engine for DMN (Decision Model and Notation) written in Java.
** Needs To Be Reviewed **

<p>
  <a href="http://fluxnova.finos.org/">Home</a> |
  <a href="https://github.com/finos/fluxnova-bpm-platform/discussion">Forum</a> |
  <a href="https://github.com/finos/fluxnova-bpm-platform/issues">Issues</a> |
</p>

The Decision Engine can be used seamlessly in combination with BPMN and CMMN or standalone.

## Standalone Usage

Add the following Maven Coordinates to your project:

```xml
<dependency>
  <groupId>org.finos.fluxnova.bpm.dmn</groupId>
  <artifactId>fluxnova-engine-dmn</artifactId>
  <version>${version.fluxnova}</version>
</dependency>
```

Now you can use the DMN engine inside your Java Code:

```java
public class DmnApp {

  public static void main(String[] args) {

    // configure and build the DMN engine
    DmnEngine dmnEngine = DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();

    // parse a decision
    DmnDecision decision = dmnEngine.parseDecision("orderDecision", "CheckOrder.dmn");

    Map<String, Object> data = new HashMap<String, Object>();
    data.put("status", "gold");
    data.put("sum", 354.12d);

    // evaluate a decision
    DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(decision, data);

  }

}
```

## Use DMN Engine for implementing a BPMN Business Rule Task

Add the following Maven Coordinates to your project:
```xml
<dependency>
  <groupId>org.finos.fluxnova.bpm</groupId>
  <artifactId>fluxnova-engine</artifactId>
  <version>${version.fluxnova}</versions>
</dependency>
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <version>1.3.168</version>
  <scope>test</scope>
</dependency>
```

Next, reference a DMN decision from a BPMN Business Rule Task:** Needs To Be Reviewed **

```xml
<bpmn:businessRuleTask id="assignApprover"
  camunda:decisionRef="invoice-assign-approver"
  camunda:resultVariable="approverGroups"
  name="Assign Approver Group(s)">
</bpmn:businessRuleTask>
```
The `camunda:decisionRef` attribute references the id of the decision in the DMN file:

```xml
<dmn:decision id="invoice-assign-approver" name="Assign Approver">
  ...
</dmn:decision>
```

Now you can start the BPMN process inside your application:

```java
public class App {

  public static void main(String[] args) {

    ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration()
      .buildProcessEngine();

    try {
      processEngine.getRepositoryService()
        .createDeployment()
        .name("invoice deployment")
        .addClasspathResource("invoice.bpmn")
        .addClasspathResource("assign-approver-groups.dmn")
        .deploy();

      processEngine.getRuntimeService()
        .startProcessInstanceByKey("invoice", createVariables()
            .putValue("invoceNumber", "2323"));
    }
    finally {
      processEngine.close();
    }
  }
}
```
