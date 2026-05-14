---
search:
  boost: 5.0
---

# Slot: activity_instance_state 


_The activity instance state._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:activity_instance_state](https://w3id.org/TD-Universe/fluxnova-bpm-platform/activity_instance_state)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [ActivityInstanceState](ActivityInstanceState.md) |
| Domain Of | [HistoricActivityInstance](HistoricActivityInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ACT_INST_STATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:activity_instance_state |
| native | fluxnova_bpm_platform:activity_instance_state |




## LinkML Source

<details>
```yaml
name: activity_instance_state
annotations:
  sql_column:
    tag: sql_column
    value: ACT_INST_STATE_
description: The activity instance state.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricActivityInstance
range: ActivityInstanceState

```
</details></div>