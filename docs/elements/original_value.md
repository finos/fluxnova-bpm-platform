---
search:
  boost: 5.0
---

# Slot: original_value 


_The original value._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:original_value](https://w3id.org/TD-Universe/fluxnova-bpm-platform/original_value)
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
| sql_column | ORG_VALUE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:original_value |
| native | fluxnova_bpm_platform:original_value |




## LinkML Source

<details>
```yaml
name: original_value
annotations:
  sql_column:
    tag: sql_column
    value: ORG_VALUE_
description: The original value.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- UserOperationLogEntry
range: string

```
</details></div>