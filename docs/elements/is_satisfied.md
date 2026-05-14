---
search:
  boost: 5.0
---

# Slot: is_satisfied 


_Whether this entity is satisfied._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:is_satisfied](https://w3id.org/TD-Universe/fluxnova-bpm-platform/is_satisfied)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Boolean](Boolean.md) |
| Domain Of | [CaseSentryPart](CaseSentryPart.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | SATISFIED_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:is_satisfied |
| native | fluxnova_bpm_platform:is_satisfied |




## LinkML Source

<details>
```yaml
name: is_satisfied
annotations:
  sql_column:
    tag: sql_column
    value: SATISFIED_
description: Whether this entity is satisfied.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseSentryPart
range: boolean

```
</details></div>