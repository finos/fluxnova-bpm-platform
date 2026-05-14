---
search:
  boost: 5.0
---

# Slot: delegation_state 


_The current DelegationState for this task._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:delegation_state](https://w3id.org/TD-Universe/fluxnova-bpm-platform/delegation_state)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Task](Task.md) | Represents one task for a human user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [DelegationState](DelegationState.md) |
| Domain Of | [Task](Task.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | DELEGATION_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:delegation_state |
| native | fluxnova_bpm_platform:delegation_state |




## LinkML Source

<details>
```yaml
name: delegation_state
annotations:
  sql_column:
    tag: sql_column
    value: DELEGATION_
description: The current DelegationState for this task.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Task
range: DelegationState

```
</details></div>