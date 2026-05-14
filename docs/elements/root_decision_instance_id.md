---
search:
  boost: 5.0
---

# Slot: root_decision_instance_id 


_The unique identifier of the historic decision instance of the evaluated root decision. Can be null if this instance is the root decision instance of the evaluation._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:root_decision_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/root_decision_instance_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricDecisionInstance](HistoricDecisionInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ROOT_DEC_INST_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:root_decision_instance_id |
| native | fluxnova_bpm_platform:root_decision_instance_id |




## LinkML Source

<details>
```yaml
name: root_decision_instance_id
annotations:
  sql_column:
    tag: sql_column
    value: ROOT_DEC_INST_ID_
description: The unique identifier of the historic decision instance of the evaluated
  root decision. Can be null if this instance is the root decision instance of the
  evaluation.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionInstance
range: string

```
</details></div>