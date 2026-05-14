---
search:
  boost: 5.0
---

# Slot: variable_event 


_The variable event._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:variable_event](https://w3id.org/TD-Universe/fluxnova-bpm-platform/variable_event)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseSentryPart](CaseSentryPart.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | VARIABLE_EVENT_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:variable_event |
| native | fluxnova_bpm_platform:variable_event |




## LinkML Source

<details>
```yaml
name: variable_event
annotations:
  sql_column:
    tag: sql_column
    value: VARIABLE_EVENT_
description: The variable event.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseSentryPart
range: string

```
</details></div>