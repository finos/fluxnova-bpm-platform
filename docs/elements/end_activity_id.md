---
search:
  boost: 5.0
---

# Slot: end_activity_id 


_Reference to the end activity._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:end_activity_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/end_activity_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricProcessInstance](HistoricProcessInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | END_ACT_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:end_activity_id |
| native | fluxnova_bpm_platform:end_activity_id |




## LinkML Source

<details>
```yaml
name: end_activity_id
annotations:
  sql_column:
    tag: sql_column
    value: END_ACT_ID_
description: Reference to the end activity.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricProcessInstance
range: string

```
</details></div>