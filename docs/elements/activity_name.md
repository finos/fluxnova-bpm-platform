---
search:
  boost: 5.0
---

# Slot: activity_name 


_The display name for the activity_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:activity_name](https://w3id.org/TD-Universe/fluxnova-bpm-platform/activity_name)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricActivityInstance](HistoricActivityInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ACT_NAME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:activity_name |
| native | fluxnova_bpm_platform:activity_name |




## LinkML Source

<details>
```yaml
name: activity_name
annotations:
  sql_column:
    tag: sql_column
    value: ACT_NAME_
description: The display name for the activity
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricActivityInstance
range: string

```
</details></div>