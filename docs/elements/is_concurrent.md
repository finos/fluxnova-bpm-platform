---
search:
  boost: 5.0
---

# Slot: is_concurrent 


_Whether this entity is concurrent._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:is_concurrent](https://w3id.org/TD-Universe/fluxnova-bpm-platform/is_concurrent)
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
| sql_column | IS_CONCURRENT_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:is_concurrent |
| native | fluxnova_bpm_platform:is_concurrent |




## LinkML Source

<details>
```yaml
name: is_concurrent
annotations:
  sql_column:
    tag: sql_column
    value: IS_CONCURRENT_
description: Whether this entity is concurrent.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Execution
range: boolean

```
</details></div>