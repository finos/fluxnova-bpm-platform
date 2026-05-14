---
search:
  boost: 5.0
---

# Slot: evaluation_time 


_Time when the decision was evaluated._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:evaluation_time](https://w3id.org/TD-Universe/fluxnova-bpm-platform/evaluation_time)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [HistoricDecisionInstance](HistoricDecisionInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | EVAL_TIME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:evaluation_time |
| native | fluxnova_bpm_platform:evaluation_time |




## LinkML Source

<details>
```yaml
name: evaluation_time
annotations:
  sql_column:
    tag: sql_column
    value: EVAL_TIME_
description: Time when the decision was evaluated.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionInstance
range: datetime
required: true

```
</details></div>