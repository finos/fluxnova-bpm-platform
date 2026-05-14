---
search:
  boost: 5.0
---

# Slot: resource_type 


_Numeric type of the authorized resource._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:resource_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/resource_type)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Authorization](Authorization.md) | An Authorization assigns a set of Permission Permissions to an identity to in... |  no  |
| [Filter](Filter.md) | Filter entity in the user collaboration |  yes  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [Authorization](Authorization.md), [Filter](Filter.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | RESOURCE_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:resource_type |
| native | fluxnova_bpm_platform:resource_type |




## LinkML Source

<details>
```yaml
name: resource_type
annotations:
  sql_column:
    tag: sql_column
    value: RESOURCE_TYPE_
description: Numeric type of the authorized resource.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Authorization
- Filter
range: integer
required: true

```
</details></div>