---
search:
  boost: 5.0
---

# Slot: activity_id 


_BPMN activity element identifier._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:activity_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/activity_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseExecution](CaseExecution.md) | Case Execution entity in the process execution runtime |  no  |
| [EventSubscription](EventSubscription.md) | A message event subscription exists, if an Execution waits for an event like ... |  no  |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |  no  |
| [JobDefinition](JobDefinition.md) | A Job Definition provides details about asynchronous background processing ("... |  no  |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  yes  |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseExecution](CaseExecution.md), [EventSubscription](EventSubscription.md), [Execution](Execution.md), [ExternalTask](ExternalTask.md), [Incident](Incident.md), [JobDefinition](JobDefinition.md), [HistoricActivityInstance](HistoricActivityInstance.md), [HistoricDecisionInstance](HistoricDecisionInstance.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricIncident](HistoricIncident.md), [HistoricJobLog](HistoricJobLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:activity_id |
| native | fluxnova_bpm_platform:activity_id |




## LinkML Source

<details>
```yaml
name: activity_id
description: BPMN activity element identifier.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseExecution
- EventSubscription
- Execution
- ExternalTask
- Incident
- JobDefinition
- HistoricActivityInstance
- HistoricDecisionInstance
- HistoricExternalTaskLog
- HistoricIncident
- HistoricJobLog
range: string

```
</details></div>