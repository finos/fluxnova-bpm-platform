---
search:
  boost: 5.0
---

# Slot: full_message 


_The full comment message the user had related to the task and/or process instance_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:full_message](https://w3id.org/TD-Universe/fluxnova-bpm-platform/full_message)
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
| sql_column | FULL_MSG_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:full_message |
| native | fluxnova_bpm_platform:full_message |




## LinkML Source

<details>
```yaml
name: full_message
annotations:
  sql_column:
    tag: sql_column
    value: FULL_MSG_
description: The full comment message the user had related to the task and/or process
  instance
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Comment
range: string

```
</details></div>