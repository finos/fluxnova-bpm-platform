---
search:
  boost: 5.0
---

# Slot: restarted_process_instance_id 


_The id of the original process instance which was restarted._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:restarted_process_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/restarted_process_instance_id)
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
| sql_column | RESTARTED_PROC_INST_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:restarted_process_instance_id |
| native | fluxnova_bpm_platform:restarted_process_instance_id |




## LinkML Source

<details>
```yaml
name: restarted_process_instance_id
annotations:
  sql_column:
    tag: sql_column
    value: RESTARTED_PROC_INST_ID_
description: The id of the original process instance which was restarted.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricProcessInstance
range: string

```
</details></div>