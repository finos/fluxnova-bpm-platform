---
search:
  boost: 5.0
---

# Slot: follow_up_date 


_Follow-up date of the task._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:follow_up_date](https://w3id.org/TD-Universe/fluxnova-bpm-platform/follow_up_date)
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
| Range | [Datetime](Datetime.md) |
| Domain Of | [Task](Task.md), [HistoricTaskInstance](HistoricTaskInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | FOLLOW_UP_DATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:follow_up_date |
| native | fluxnova_bpm_platform:follow_up_date |




## LinkML Source

<details>
```yaml
name: follow_up_date
annotations:
  sql_column:
    tag: sql_column
    value: FOLLOW_UP_DATE_
description: Follow-up date of the task.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Task
- HistoricTaskInstance
range: datetime

```
</details></div>