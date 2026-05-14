---
search:
  boost: 5.0
---

# Slot: task_state 


_Task's state._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:task_state](https://w3id.org/TD-Universe/fluxnova-bpm-platform/task_state)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Task](Task.md), [HistoricTaskInstance](HistoricTaskInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | TASK_STATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:task_state |
| native | fluxnova_bpm_platform:task_state |




## LinkML Source

<details>
```yaml
name: task_state
annotations:
  sql_column:
    tag: sql_column
    value: TASK_STATE_
description: Task's state.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Task
- HistoricTaskInstance
range: string

```
</details></div>