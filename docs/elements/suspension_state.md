---
search:
  boost: 5.0
---

# Slot: suspension_state 


_Whether the entity is active or suspended._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:suspension_state](https://w3id.org/TD-Universe/fluxnova-bpm-platform/suspension_state)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [ProcessDefinition](ProcessDefinition.md) | An object structure representing an executable process composed of activities... |  no  |
| [Batch](Batch.md) | A batch represents a number of jobs which execute a number of commands asynch... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  yes  |
| [JobDefinition](JobDefinition.md) | A Job Definition provides details about asynchronous background processing ("... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [SuspensionState](SuspensionState.md) |
| Domain Of | [Execution](Execution.md), [ExternalTask](ExternalTask.md), [Task](Task.md), [ProcessDefinition](ProcessDefinition.md), [Batch](Batch.md), [Job](Job.md), [JobDefinition](JobDefinition.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | SUSPENSION_STATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:suspension_state |
| native | fluxnova_bpm_platform:suspension_state |




## LinkML Source

<details>
```yaml
name: suspension_state
annotations:
  sql_column:
    tag: sql_column
    value: SUSPENSION_STATE_
description: Whether the entity is active or suspended.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Execution
- ExternalTask
- Task
- ProcessDefinition
- Batch
- Job
- JobDefinition
range: SuspensionState

```
</details></div>