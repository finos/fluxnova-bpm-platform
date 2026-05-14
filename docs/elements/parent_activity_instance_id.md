---
search:
  boost: 5.0
---

# Slot: parent_activity_instance_id 


_Id of the parent activity instance_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:parent_activity_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/parent_activity_instance_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricActivityInstance](HistoricActivityInstance.md), [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | PARENT_ACT_INST_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:parent_activity_instance_id |
| native | fluxnova_bpm_platform:parent_activity_instance_id |




## LinkML Source

<details>
```yaml
name: parent_activity_instance_id
annotations:
  sql_column:
    tag: sql_column
    value: PARENT_ACT_INST_ID_
description: Id of the parent activity instance
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricActivityInstance
- HistoricCaseActivityInstance
range: string

```
</details></div>