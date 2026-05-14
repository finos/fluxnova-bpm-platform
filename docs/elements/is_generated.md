---
search:
  boost: 5.0
---

# Slot: is_generated 


_Whether this entity is generated._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:is_generated](https://w3id.org/TD-Universe/fluxnova-bpm-platform/is_generated)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ByteArray](ByteArray.md) | Byte Array entity in the engine infrastructure |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Boolean](Boolean.md) |
| Domain Of | [ByteArray](ByteArray.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | GENERATED_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:is_generated |
| native | fluxnova_bpm_platform:is_generated |




## LinkML Source

<details>
```yaml
name: is_generated
annotations:
  sql_column:
    tag: sql_column
    value: GENERATED_
description: Whether this entity is generated.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ByteArray
range: boolean

```
</details></div>