---
search:
  boost: 5.0
---

# Slot: is_exclusive 


_Whether this entity is exclusive._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:is_exclusive](https://w3id.org/TD-Universe/fluxnova-bpm-platform/is_exclusive)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Boolean](Boolean.md) |
| Domain Of | [Job](Job.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | EXCLUSIVE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:is_exclusive |
| native | fluxnova_bpm_platform:is_exclusive |




## LinkML Source

<details>
```yaml
name: is_exclusive
annotations:
  sql_column:
    tag: sql_column
    value: EXCLUSIVE_
description: Whether this entity is exclusive.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Job
range: boolean

```
</details></div>