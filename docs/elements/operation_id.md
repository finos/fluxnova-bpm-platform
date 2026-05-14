---
search:
  boost: 5.0
---

# Slot: operation_id 


_The unique identifier of this operation. If an operation modifies multiple properties, multiple UserOperationLogEntry instances will be created with a common operationId. This allows grouping multi..._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:operation_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/operation_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricDetail](HistoricDetail.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | OPERATION_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:operation_id |
| native | fluxnova_bpm_platform:operation_id |




## LinkML Source

<details>
```yaml
name: operation_id
annotations:
  sql_column:
    tag: sql_column
    value: OPERATION_ID_
description: The unique identifier of this operation. If an operation modifies multiple
  properties, multiple UserOperationLogEntry instances will be created with a common
  operationId. This allows grouping multi...
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDetail
- UserOperationLogEntry
range: string

```
</details></div>