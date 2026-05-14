---
search:
  boost: 5.0
---

# Slot: cached_entity_state 


_Bitmask caching associated entity existence._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:cached_entity_state](https://w3id.org/TD-Universe/fluxnova-bpm-platform/cached_entity_state)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [Execution](Execution.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CACHED_ENT_STATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:cached_entity_state |
| native | fluxnova_bpm_platform:cached_entity_state |




## LinkML Source

<details>
```yaml
name: cached_entity_state
annotations:
  sql_column:
    tag: sql_column
    value: CACHED_ENT_STATE_
description: Bitmask caching associated entity existence.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Execution
range: integer

```
</details></div>