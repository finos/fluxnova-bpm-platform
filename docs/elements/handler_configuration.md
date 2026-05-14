---
search:
  boost: 5.0
---

# Slot: handler_configuration 


_Configuration for the handler._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:handler_configuration](https://w3id.org/TD-Universe/fluxnova-bpm-platform/handler_configuration)
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
| sql_column | HANDLER_CFG_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:handler_configuration |
| native | fluxnova_bpm_platform:handler_configuration |




## LinkML Source

<details>
```yaml
name: handler_configuration
annotations:
  sql_column:
    tag: sql_column
    value: HANDLER_CFG_
description: Configuration for the handler.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Job
range: string

```
</details></div>