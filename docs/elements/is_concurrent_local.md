---
search:
  boost: 5.0
---

# Slot: is_concurrent_local 


_Whether this entity is concurrent local._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:is_concurrent_local](https://w3id.org/TD-Universe/fluxnova-bpm-platform/is_concurrent_local)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Boolean](Boolean.md) |
| Domain Of | [VariableInstance](VariableInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | IS_CONCURRENT_LOCAL_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:is_concurrent_local |
| native | fluxnova_bpm_platform:is_concurrent_local |




## LinkML Source

<details>
```yaml
name: is_concurrent_local
annotations:
  sql_column:
    tag: sql_column
    value: IS_CONCURRENT_LOCAL_
description: Whether this entity is concurrent local.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- VariableInstance
range: boolean

```
</details></div>