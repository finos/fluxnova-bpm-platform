---
search:
  boost: 5.0
---

# Slot: sequence_counter 


_Monotonically increasing counter for ordering._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:sequence_counter](https://w3id.org/TD-Universe/fluxnova-bpm-platform/sequence_counter)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [Execution](Execution.md), [VariableInstance](VariableInstance.md), [Job](Job.md), [HistoricActivityInstance](HistoricActivityInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricJobLog](HistoricJobLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | SEQUENCE_COUNTER_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:sequence_counter |
| native | fluxnova_bpm_platform:sequence_counter |




## LinkML Source

<details>
```yaml
name: sequence_counter
annotations:
  sql_column:
    tag: sql_column
    value: SEQUENCE_COUNTER_
description: Monotonically increasing counter for ordering.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Execution
- VariableInstance
- Job
- HistoricActivityInstance
- HistoricDetail
- HistoricJobLog
range: integer

```
</details></div>