---
search:
  boost: 5.0
---

# Slot: first_name 


_First name._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:first_name](https://w3id.org/TD-Universe/fluxnova-bpm-platform/first_name)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [User](User.md) | Represents a user, used in IdentityService |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [User](User.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | FIRST_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:first_name |
| native | fluxnova_bpm_platform:first_name |




## LinkML Source

<details>
```yaml
name: first_name
annotations:
  sql_column:
    tag: sql_column
    value: FIRST_
description: First name.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- User
range: string

```
</details></div>