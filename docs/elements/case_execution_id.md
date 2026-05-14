---
search:
  boost: 5.0
---

# Slot: case_execution_id 


_Reference to the case execution._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:case_execution_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/case_execution_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseSentryPart](CaseSentryPart.md), [Task](Task.md), [VariableInstance](VariableInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricTaskInstance](HistoricTaskInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:case_execution_id |
| native | fluxnova_bpm_platform:case_execution_id |




## LinkML Source

<details>
```yaml
name: case_execution_id
description: Reference to the case execution.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseSentryPart
- Task
- VariableInstance
- HistoricDetail
- HistoricTaskInstance
- HistoricVariableInstance
- UserOperationLogEntry
range: string

```
</details></div>