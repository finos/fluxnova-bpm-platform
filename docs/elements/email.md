---
search:
  boost: 5.0
---

# Slot: email 


_Email address._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:email](https://w3id.org/TD-Universe/fluxnova-bpm-platform/email)
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
| sql_column | EMAIL_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:email |
| native | fluxnova_bpm_platform:email |




## LinkML Source

<details>
```yaml
name: email
annotations:
  sql_column:
    tag: sql_column
    value: EMAIL_
description: Email address.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- User
range: string

```
</details></div>