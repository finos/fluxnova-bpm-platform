---
search:
  boost: 5.0
---

# Slot: property 


_The property changed by this operation._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:property](https://w3id.org/TD-Universe/fluxnova-bpm-platform/property)
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
| sql_column | PROPERTY_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:property |
| native | fluxnova_bpm_platform:property |




## LinkML Source

<details>
```yaml
name: property
annotations:
  sql_column:
    tag: sql_column
    value: PROPERTY_
description: The property changed by this operation.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- UserOperationLogEntry
range: string

```
</details></div>