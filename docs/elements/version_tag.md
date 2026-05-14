---
search:
  boost: 5.0
---

# Slot: version_tag 


_Version tag of the process definition._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:version_tag](https://w3id.org/TD-Universe/fluxnova-bpm-platform/version_tag)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [DecisionDefinition](DecisionDefinition.md) | Definition of a decision resource |  no  |
| [ProcessDefinition](ProcessDefinition.md) | An object structure representing an executable process composed of activities... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [DecisionDefinition](DecisionDefinition.md), [ProcessDefinition](ProcessDefinition.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | VERSION_TAG_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:version_tag |
| native | fluxnova_bpm_platform:version_tag |




## LinkML Source

<details>
```yaml
name: version_tag
annotations:
  sql_column:
    tag: sql_column
    value: VERSION_TAG_
description: Version tag of the process definition.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- DecisionDefinition
- ProcessDefinition
range: string

```
</details></div>