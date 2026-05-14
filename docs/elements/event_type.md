---
search:
  boost: 5.0
---

# Slot: event_type 


_The event subscriptions type. "message" identifies message event subscriptions, "signal" identifies signal event subscription, "compensation" identifies event subscriptions used for compensation ev..._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:event_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/event_type)
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
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | EVENT_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:event_type |
| native | fluxnova_bpm_platform:event_type |




## LinkML Source

<details>
```yaml
name: event_type
annotations:
  sql_column:
    tag: sql_column
    value: EVENT_TYPE_
description: The event subscriptions type. "message" identifies message event subscriptions,
  "signal" identifies signal event subscription, "compensation" identifies event subscriptions
  used for compensation ev...
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- EventSubscription
range: string
required: true

```
</details></div>