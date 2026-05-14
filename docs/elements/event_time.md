---
search:
  boost: 5.0
---

# Slot: event_time 


_Timestamp for event time._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:event_time](https://w3id.org/TD-Universe/fluxnova-bpm-platform/event_time)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Comment](Comment.md) | User comments that form discussions around tasks |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [Comment](Comment.md), [HistoricDetail](HistoricDetail.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | TIME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:event_time |
| native | fluxnova_bpm_platform:event_time |




## LinkML Source

<details>
```yaml
name: event_time
annotations:
  sql_column:
    tag: sql_column
    value: TIME_
description: Timestamp for event time.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Comment
- HistoricDetail
range: datetime
required: true

```
</details></div>