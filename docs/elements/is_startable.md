---
search:
  boost: 5.0
---

# Slot: is_startable 


_Whether this entity is startable._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:is_startable](https://w3id.org/TD-Universe/fluxnova-bpm-platform/is_startable)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ProcessDefinition](ProcessDefinition.md) | An object structure representing an executable process composed of activities... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Boolean](Boolean.md) |
| Domain Of | [ProcessDefinition](ProcessDefinition.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | STARTABLE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:is_startable |
| native | fluxnova_bpm_platform:is_startable |




## LinkML Source

<details>
```yaml
name: is_startable
annotations:
  sql_column:
    tag: sql_column
    value: STARTABLE_
description: Whether this entity is startable.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ProcessDefinition
range: boolean
required: true

```
</details></div>