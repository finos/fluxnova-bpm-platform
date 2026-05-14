---
search:
  boost: 5.0
---

# Slot: created 


_The time this event subscription was created._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:created](https://w3id.org/TD-Universe/fluxnova-bpm-platform/created)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [EventSubscription](EventSubscription.md) | A message event subscription exists, if an Execution waits for an event like ... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [EventSubscription](EventSubscription.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CREATED_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:created |
| native | fluxnova_bpm_platform:created |




## LinkML Source

<details>
```yaml
name: created
annotations:
  sql_column:
    tag: sql_column
    value: CREATED_
description: The time this event subscription was created.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- EventSubscription
range: datetime
required: true

```
</details></div>