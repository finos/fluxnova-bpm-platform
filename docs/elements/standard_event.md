---
search:
  boost: 5.0
---

# Slot: standard_event 


_The standard event._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:standard_event](https://w3id.org/TD-Universe/fluxnova-bpm-platform/standard_event)
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
| sql_column | STANDARD_EVENT_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:standard_event |
| native | fluxnova_bpm_platform:standard_event |




## LinkML Source

<details>
```yaml
name: standard_event
annotations:
  sql_column:
    tag: sql_column
    value: STANDARD_EVENT_
description: The standard event.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseSentryPart
range: string

```
</details></div>