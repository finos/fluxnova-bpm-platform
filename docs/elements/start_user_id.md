---
search:
  boost: 5.0
---

# Slot: start_user_id 


_The authenticated user that started this process instance._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:start_user_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/start_user_id)
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
| sql_column | START_USER_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:start_user_id |
| native | fluxnova_bpm_platform:start_user_id |




## LinkML Source

<details>
```yaml
name: start_user_id
annotations:
  sql_column:
    tag: sql_column
    value: START_USER_ID_
description: The authenticated user that started this process instance.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricProcessInstance
range: string

```
</details></div>