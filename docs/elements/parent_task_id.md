---
search:
  boost: 5.0
---

# Slot: parent_task_id 


_The parent task for which this task is a subtask_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:parent_task_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/parent_task_id)
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
| sql_column | PARENT_TASK_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:parent_task_id |
| native | fluxnova_bpm_platform:parent_task_id |




## LinkML Source

<details>
```yaml
name: parent_task_id
annotations:
  sql_column:
    tag: sql_column
    value: PARENT_TASK_ID_
description: The parent task for which this task is a subtask
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Task
- HistoricTaskInstance
range: string

```
</details></div>