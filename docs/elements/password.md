---
search:
  boost: 5.0
---

# Slot: password 


_Hashed password._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:password](https://w3id.org/TD-Universe/fluxnova-bpm-platform/password)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [IdentityInfo](IdentityInfo.md) | Identity Info entity in the identity and access management |  no  |
| [User](User.md) | Represents a user, used in IdentityService |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [IdentityInfo](IdentityInfo.md), [User](User.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | PASSWORD_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:password |
| native | fluxnova_bpm_platform:password |




## LinkML Source

<details>
```yaml
name: password
annotations:
  sql_column:
    tag: sql_column
    value: PASSWORD_
description: Hashed password.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- IdentityInfo
- User
range: string

```
</details></div>