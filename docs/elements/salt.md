---
search:
  boost: 5.0
---

# Slot: salt 


_Cryptographic salt for password hashing._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:salt](https://w3id.org/TD-Universe/fluxnova-bpm-platform/salt)
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
| sql_column | SALT_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:salt |
| native | fluxnova_bpm_platform:salt |




## LinkML Source

<details>
```yaml
name: salt
annotations:
  sql_column:
    tag: sql_column
    value: SALT_
description: Cryptographic salt for password hashing.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- User
range: string

```
</details></div>