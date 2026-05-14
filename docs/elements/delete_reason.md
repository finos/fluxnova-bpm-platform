---
search:
  boost: 5.0
---

# Slot: delete_reason 


_Obtains the reason for the process instance's deletion._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:delete_reason](https://w3id.org/TD-Universe/fluxnova-bpm-platform/delete_reason)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricProcessInstance](HistoricProcessInstance.md), [HistoricTaskInstance](HistoricTaskInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | DELETE_REASON_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:delete_reason |
| native | fluxnova_bpm_platform:delete_reason |




## LinkML Source

<details>
```yaml
name: delete_reason
annotations:
  sql_column:
    tag: sql_column
    value: DELETE_REASON_
description: Obtains the reason for the process instance's deletion.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricProcessInstance
- HistoricTaskInstance
range: string

```
</details></div>