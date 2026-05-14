---
search:
  boost: 5.0
---

# Slot: handler_type 


_Type of handler that processes this entity._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:handler_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/handler_type)
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
| sql_column | HANDLER_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:handler_type |
| native | fluxnova_bpm_platform:handler_type |




## LinkML Source

<details>
```yaml
name: handler_type
annotations:
  sql_column:
    tag: sql_column
    value: HANDLER_TYPE_
description: Type of handler that processes this entity.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Job
range: string

```
</details></div>