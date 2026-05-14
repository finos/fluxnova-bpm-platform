---
search:
  boost: 5.0
---

# Slot: called_process_instance_id 


_The called process instance in case of call activity_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:called_process_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/called_process_instance_id)
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
| sql_column | CALL_PROC_INST_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:called_process_instance_id |
| native | fluxnova_bpm_platform:called_process_instance_id |




## LinkML Source

<details>
```yaml
name: called_process_instance_id
annotations:
  sql_column:
    tag: sql_column
    value: CALL_PROC_INST_ID_
description: The called process instance in case of call activity
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricActivityInstance
- HistoricCaseActivityInstance
range: string

```
</details></div>