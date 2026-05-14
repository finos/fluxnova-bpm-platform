---
search:
  boost: 5.0
---

# Slot: repeat 


_Repeat/recurrence expression (ISO 8601)._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:repeat](https://w3id.org/TD-Universe/fluxnova-bpm-platform/repeat)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Job](Job.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | REPEAT_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:repeat |
| native | fluxnova_bpm_platform:repeat |




## LinkML Source

<details>
```yaml
name: repeat
annotations:
  sql_column:
    tag: sql_column
    value: REPEAT_
description: Repeat/recurrence expression (ISO 8601).
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Job
range: string

```
</details></div>