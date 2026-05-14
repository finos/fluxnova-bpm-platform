---
search:
  boost: 5.0
---

# Slot: collect_result_value 


_The result of the collect operation if the hit policy 'collect' was used for the decision._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:collect_result_value](https://w3id.org/TD-Universe/fluxnova-bpm-platform/collect_result_value)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Float](Float.md) |
| Domain Of | [HistoricDecisionInstance](HistoricDecisionInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | COLLECT_VALUE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:collect_result_value |
| native | fluxnova_bpm_platform:collect_result_value |




## LinkML Source

<details>
```yaml
name: collect_result_value
annotations:
  sql_column:
    tag: sql_column
    value: COLLECT_VALUE_
description: The result of the collect operation if the hit policy 'collect' was used
  for the decision.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionInstance
range: float

```
</details></div>