---
search:
  boost: 5.0
---

# Slot: task_definition_key 


_The id of the activity in the process defining this task or null if this is not related to a process_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:task_definition_key](https://w3id.org/TD-Universe/fluxnova-bpm-platform/task_definition_key)
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
| sql_column | TASK_DEF_KEY_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:task_definition_key |
| native | fluxnova_bpm_platform:task_definition_key |




## LinkML Source

<details>
```yaml
name: task_definition_key
annotations:
  sql_column:
    tag: sql_column
    value: TASK_DEF_KEY_
description: The id of the activity in the process defining this task or null if this
  is not related to a process
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Task
- HistoricTaskInstance
range: string

```
</details></div>