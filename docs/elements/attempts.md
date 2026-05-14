---
search:
  boost: 5.0
---

# Slot: attempts 


_Number of failed login attempts._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:attempts](https://w3id.org/TD-Universe/fluxnova-bpm-platform/attempts)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [User](User.md) | Represents a user, used in IdentityService |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [User](User.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ATTEMPTS_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:attempts |
| native | fluxnova_bpm_platform:attempts |




## LinkML Source

<details>
```yaml
name: attempts
annotations:
  sql_column:
    tag: sql_column
    value: ATTEMPTS_
description: Number of failed login attempts.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- User
range: integer

```
</details></div>