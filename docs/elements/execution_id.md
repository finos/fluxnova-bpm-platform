---
search:
  boost: 5.0
---

# Slot: execution_id 


_Reference to the execution._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:execution_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/execution_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [EventSubscription](EventSubscription.md) | A message event subscription exists, if an Execution waits for an event like ... |  no  |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |  no  |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  yes  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [EventSubscription](EventSubscription.md), [ExternalTask](ExternalTask.md), [Incident](Incident.md), [Task](Task.md), [VariableInstance](VariableInstance.md), [Job](Job.md), [HistoricActivityInstance](HistoricActivityInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricIncident](HistoricIncident.md), [HistoricJobLog](HistoricJobLog.md), [HistoricTaskInstance](HistoricTaskInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:execution_id |
| native | fluxnova_bpm_platform:execution_id |




## LinkML Source

<details>
```yaml
name: execution_id
description: Reference to the execution.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- EventSubscription
- ExternalTask
- Incident
- Task
- VariableInstance
- Job
- HistoricActivityInstance
- HistoricDetail
- HistoricExternalTaskLog
- HistoricIncident
- HistoricJobLog
- HistoricTaskInstance
- HistoricVariableInstance
- UserOperationLogEntry
range: string

```
</details></div>