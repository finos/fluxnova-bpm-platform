---
search:
  boost: 5.0
---

# Slot: batch_id 


_Reference to a batch._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:batch_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/batch_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [VariableInstance](VariableInstance.md), [Job](Job.md), [HistoricJobLog](HistoricJobLog.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:batch_id |
| native | fluxnova_bpm_platform:batch_id |




## LinkML Source

<details>
```yaml
name: batch_id
description: Reference to a batch.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- VariableInstance
- Job
- HistoricJobLog
- UserOperationLogEntry
range: string

```
</details></div>