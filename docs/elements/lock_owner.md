---
search:
  boost: 5.0
---

# Slot: lock_owner 


_Identifier of the node that acquired the lock._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:lock_owner](https://w3id.org/TD-Universe/fluxnova-bpm-platform/lock_owner)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Job](Job.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | LOCK_OWNER_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:lock_owner |
| native | fluxnova_bpm_platform:lock_owner |




## LinkML Source

<details>
```yaml
name: lock_owner
annotations:
  sql_column:
    tag: sql_column
    value: LOCK_OWNER_
description: Identifier of the node that acquired the lock.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Job
range: string

```
</details></div>