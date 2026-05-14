---
search:
  boost: 5.0
---

# Slot: due_date 


_Due date of the task._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:due_date](https://w3id.org/TD-Universe/fluxnova-bpm-platform/due_date)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [Task](Task.md), [Job](Job.md), [HistoricTaskInstance](HistoricTaskInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | DUE_DATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:due_date |
| native | fluxnova_bpm_platform:due_date |




## LinkML Source

<details>
```yaml
name: due_date
annotations:
  sql_column:
    tag: sql_column
    value: DUE_DATE_
description: Due date of the task.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Task
- Job
- HistoricTaskInstance
range: datetime

```
</details></div>