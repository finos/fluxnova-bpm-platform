---
search:
  boost: 5.0
---

# Slot: current_state 


_The current state._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:current_state](https://w3id.org/TD-Universe/fluxnova-bpm-platform/current_state)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseExecution](CaseExecution.md) | Case Execution entity in the process execution runtime |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [CaseExecution](CaseExecution.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CURRENT_STATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:current_state |
| native | fluxnova_bpm_platform:current_state |




## LinkML Source

<details>
```yaml
name: current_state
annotations:
  sql_column:
    tag: sql_column
    value: CURRENT_STATE_
description: The current state.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseExecution
range: integer

```
</details></div>