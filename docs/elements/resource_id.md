---
search:
  boost: 5.0
---

# Slot: resource_id 


_Reference to the resource._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:resource_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/resource_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Authorization](Authorization.md) | An Authorization assigns a set of Permission Permissions to an identity to in... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Authorization](Authorization.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | RESOURCE_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:resource_id |
| native | fluxnova_bpm_platform:resource_id |




## LinkML Source

<details>
```yaml
name: resource_id
annotations:
  sql_column:
    tag: sql_column
    value: RESOURCE_ID_
description: Reference to the resource.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Authorization
range: string

```
</details></div>