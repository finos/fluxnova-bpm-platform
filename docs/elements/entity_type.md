---
search:
  boost: 5.0
---

# Slot: entity_type 


_The type of the entity on which this operation was executed._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:entity_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/entity_type)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ENTITY_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:entity_type |
| native | fluxnova_bpm_platform:entity_type |




## LinkML Source

<details>
```yaml
name: entity_type
annotations:
  sql_column:
    tag: sql_column
    value: ENTITY_TYPE_
description: The type of the entity on which this operation was executed.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- UserOperationLogEntry
range: string

```
</details></div>