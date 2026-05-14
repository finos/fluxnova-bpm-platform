---
search:
  boost: 5.0
---

# Slot: action 


_The action._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:action](https://w3id.org/TD-Universe/fluxnova-bpm-platform/action)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Comment](Comment.md) | User comments that form discussions around tasks |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Comment](Comment.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ACTION_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:action |
| native | fluxnova_bpm_platform:action |




## LinkML Source

<details>
```yaml
name: action
annotations:
  sql_column:
    tag: sql_column
    value: ACTION_
description: The action.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Comment
range: string

```
</details></div>