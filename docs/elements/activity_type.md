---
search:
  boost: 5.0
---

# Slot: activity_type 


_The activity type of the activity. Typically the activity type correspond to the XML tag used in the BPMN 2.0 process definition file. All activity types are available in org.finos.fluxnova.bpm.eng..._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:activity_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/activity_type)
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
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ACT_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:activity_type |
| native | fluxnova_bpm_platform:activity_type |




## LinkML Source

<details>
```yaml
name: activity_type
annotations:
  sql_column:
    tag: sql_column
    value: ACT_TYPE_
description: The activity type of the activity. Typically the activity type correspond
  to the XML tag used in the BPMN 2.0 process definition file. All activity types
  are available in org.finos.fluxnova.bpm.eng...
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricActivityInstance
range: string
required: true

```
</details></div>