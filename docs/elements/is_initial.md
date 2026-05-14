---
search:
  boost: 5.0
---

# Slot: is_initial 


_Whether this entity is initial._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:is_initial](https://w3id.org/TD-Universe/fluxnova-bpm-platform/is_initial)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Boolean](Boolean.md) |
| Domain Of | [HistoricDetail](HistoricDetail.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | INITIAL_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:is_initial |
| native | fluxnova_bpm_platform:is_initial |




## LinkML Source

<details>
```yaml
name: is_initial
annotations:
  sql_column:
    tag: sql_column
    value: INITIAL_
description: Whether this entity is initial.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDetail
range: boolean

```
</details></div>