---
search:
  boost: 5.0
---

# Slot: assignee 


_The userId of the person to which this task is assigned or delegated._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:assignee](https://w3id.org/TD-Universe/fluxnova-bpm-platform/assignee)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Task](Task.md), [HistoricActivityInstance](HistoricActivityInstance.md), [HistoricTaskInstance](HistoricTaskInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ASSIGNEE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:assignee |
| native | fluxnova_bpm_platform:assignee |




## LinkML Source

<details>
```yaml
name: assignee
annotations:
  sql_column:
    tag: sql_column
    value: ASSIGNEE_
description: The userId of the person to which this task is assigned or delegated.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Task
- HistoricActivityInstance
- HistoricTaskInstance
range: string

```
</details></div>