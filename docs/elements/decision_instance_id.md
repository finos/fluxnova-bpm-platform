---
search:
  boost: 5.0
---

# Slot: decision_instance_id 


_The unique identifier of the historic decision instance._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:decision_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/decision_instance_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md) | Represents one input variable of a decision evaluation |  no  |
| [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) | Represents one output variable of a decision evaluation |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md), [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | DEC_INST_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:decision_instance_id |
| native | fluxnova_bpm_platform:decision_instance_id |




## LinkML Source

<details>
```yaml
name: decision_instance_id
annotations:
  sql_column:
    tag: sql_column
    value: DEC_INST_ID_
description: The unique identifier of the historic decision instance.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionInputInstance
- HistoricDecisionOutputInstance
range: string
required: true

```
</details></div>