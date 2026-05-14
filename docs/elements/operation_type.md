---
search:
  boost: 5.0
---

# Slot: operation_type 


_Type of identity link history (add or delete identity link)_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:operation_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/operation_type)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricIdentityLink](HistoricIdentityLink.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | OPERATION_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:operation_type |
| native | fluxnova_bpm_platform:operation_type |




## LinkML Source

<details>
```yaml
name: operation_type
annotations:
  sql_column:
    tag: sql_column
    value: OPERATION_TYPE_
description: Type of identity link history (add or delete identity link)
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricIdentityLink
- UserOperationLogEntry
range: string

```
</details></div>