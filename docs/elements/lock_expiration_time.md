---
search:
  boost: 5.0
---

# Slot: lock_expiration_time 


_Time at which the lock expires._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:lock_expiration_time](https://w3id.org/TD-Universe/fluxnova-bpm-platform/lock_expiration_time)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [User](User.md) | Represents a user, used in IdentityService |  no  |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [User](User.md), [ExternalTask](ExternalTask.md), [Job](Job.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | LOCK_EXP_TIME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:lock_expiration_time |
| native | fluxnova_bpm_platform:lock_expiration_time |




## LinkML Source

<details>
```yaml
name: lock_expiration_time
annotations:
  sql_column:
    tag: sql_column
    value: LOCK_EXP_TIME_
description: Time at which the lock expires.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- User
- ExternalTask
- Job
range: datetime

```
</details></div>