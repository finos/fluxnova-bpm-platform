---
search:
  boost: 5.0
---

# Slot: is_active 


_Whether this entity is active._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:is_active](https://w3id.org/TD-Universe/fluxnova-bpm-platform/is_active)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Boolean](Boolean.md) |
| Domain Of | [Execution](Execution.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | IS_ACTIVE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:is_active |
| native | fluxnova_bpm_platform:is_active |




## LinkML Source

<details>
```yaml
name: is_active
annotations:
  sql_column:
    tag: sql_column
    value: IS_ACTIVE_
description: Whether this entity is active.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Execution
range: boolean

```
</details></div>