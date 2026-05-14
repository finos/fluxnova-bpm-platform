---
search:
  boost: 5.0
---

# Slot: exception_stack_id 


_Reference to a ByteArray._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:exception_stack_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/exception_stack_id)
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
| sql_column | EXCEPTION_STACK_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:exception_stack_id |
| native | fluxnova_bpm_platform:exception_stack_id |




## LinkML Source

<details>
```yaml
name: exception_stack_id
annotations:
  sql_column:
    tag: sql_column
    value: EXCEPTION_STACK_ID_
description: Reference to a ByteArray.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Job
range: string

```
</details></div>