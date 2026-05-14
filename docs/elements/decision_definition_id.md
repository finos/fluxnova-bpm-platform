---
search:
  boost: 5.0
---

# Slot: decision_definition_id 


_The decision definition reference._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:decision_definition_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/decision_definition_id)
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
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | DEC_DEF_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:decision_definition_id |
| native | fluxnova_bpm_platform:decision_definition_id |




## LinkML Source

<details>
```yaml
name: decision_definition_id
annotations:
  sql_column:
    tag: sql_column
    value: DEC_DEF_ID_
description: The decision definition reference.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionInstance
range: string
required: true

```
</details></div>