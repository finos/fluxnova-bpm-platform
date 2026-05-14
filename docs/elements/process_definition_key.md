---
search:
  boost: 5.0
---

# Slot: process_definition_key 


_Key of the process definition._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:process_definition_key](https://w3id.org/TD-Universe/fluxnova-bpm-platform/process_definition_key)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [JobDefinition](JobDefinition.md) | A Job Definition provides details about asynchronous background processing ("... |  no  |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |
| [HistoricScopeInstance](HistoricScopeInstance.md) | Abstract base for historic entities with start/end time and duration |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  no  |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  no  |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Execution](Execution.md), [ExternalTask](ExternalTask.md), [Job](Job.md), [JobDefinition](JobDefinition.md), [HistoricDecisionInstance](HistoricDecisionInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricIdentityLink](HistoricIdentityLink.md), [HistoricIncident](HistoricIncident.md), [HistoricJobLog](HistoricJobLog.md), [HistoricScopeInstance](HistoricScopeInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:process_definition_key |
| native | fluxnova_bpm_platform:process_definition_key |




## LinkML Source

<details>
```yaml
name: process_definition_key
description: Key of the process definition.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Execution
- ExternalTask
- Job
- JobDefinition
- HistoricDecisionInstance
- HistoricDetail
- HistoricExternalTaskLog
- HistoricIdentityLink
- HistoricIncident
- HistoricJobLog
- HistoricScopeInstance
- HistoricVariableInstance
- UserOperationLogEntry
range: string

```
</details></div>