---
search:
  boost: 5.0
---

# Slot: assigner_id 


_UserId of the user who assigns a task to the user_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:assigner_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/assigner_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricIdentityLink](HistoricIdentityLink.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ASSIGNER_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:assigner_id |
| native | fluxnova_bpm_platform:assigner_id |




## LinkML Source

<details>
```yaml
name: assigner_id
annotations:
  sql_column:
    tag: sql_column
    value: ASSIGNER_ID_
description: UserId of the user who assigns a task to the user
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricIdentityLink
range: string

```
</details></div>