---
search:
  boost: 5.0
---

# Slot: super_process_instance_id 


_The process instance id of a potential super process instance or null if no super process instance exists_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:super_process_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/super_process_instance_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  no  |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricCaseInstance](HistoricCaseInstance.md), [HistoricProcessInstance](HistoricProcessInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | SUPER_PROCESS_INSTANCE_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:super_process_instance_id |
| native | fluxnova_bpm_platform:super_process_instance_id |




## LinkML Source

<details>
```yaml
name: super_process_instance_id
annotations:
  sql_column:
    tag: sql_column
    value: SUPER_PROCESS_INSTANCE_ID_
description: The process instance id of a potential super process instance or null
  if no super process instance exists
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricCaseInstance
- HistoricProcessInstance
range: string

```
</details></div>