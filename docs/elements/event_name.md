---
search:
  boost: 5.0
---

# Slot: event_name 


_The name of the event this subscription belongs to as defined in the process model._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:event_name](https://w3id.org/TD-Universe/fluxnova-bpm-platform/event_name)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [EventSubscription](EventSubscription.md) | A message event subscription exists, if an Execution waits for an event like ... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [EventSubscription](EventSubscription.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | EVENT_NAME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:event_name |
| native | fluxnova_bpm_platform:event_name |




## LinkML Source

<details>
```yaml
name: event_name
annotations:
  sql_column:
    tag: sql_column
    value: EVENT_NAME_
description: The name of the event this subscription belongs to as defined in the
  process model.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- EventSubscription
range: string

```
</details></div>