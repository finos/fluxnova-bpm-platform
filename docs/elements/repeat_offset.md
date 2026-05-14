---
search:
  boost: 5.0
---

# Slot: repeat_offset 


_Offset applied to repeat interval calculation._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:repeat_offset](https://w3id.org/TD-Universe/fluxnova-bpm-platform/repeat_offset)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [Job](Job.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | REPEAT_OFFSET_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:repeat_offset |
| native | fluxnova_bpm_platform:repeat_offset |




## LinkML Source

<details>
```yaml
name: repeat_offset
annotations:
  sql_column:
    tag: sql_column
    value: REPEAT_OFFSET_
description: Offset applied to repeat interval calculation.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Job
range: integer

```
</details></div>