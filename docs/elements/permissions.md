---
search:
  boost: 5.0
---

# Slot: permissions 


_Bitmask of granted permissions._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:permissions](https://w3id.org/TD-Universe/fluxnova-bpm-platform/permissions)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Authorization](Authorization.md) | An Authorization assigns a set of Permission Permissions to an identity to in... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [Authorization](Authorization.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | PERMS_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:permissions |
| native | fluxnova_bpm_platform:permissions |




## LinkML Source

<details>
```yaml
name: permissions
annotations:
  sql_column:
    tag: sql_column
    value: PERMS_
description: Bitmask of granted permissions.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Authorization
range: integer

```
</details></div>