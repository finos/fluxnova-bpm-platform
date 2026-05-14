---
search:
  boost: 5.0
---

# Slot: decision_definition_name 


_The name of the decision definition_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:decision_definition_name](https://w3id.org/TD-Universe/fluxnova-bpm-platform/decision_definition_name)
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
| sql_column | DEC_DEF_NAME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:decision_definition_name |
| native | fluxnova_bpm_platform:decision_definition_name |




## LinkML Source

<details>
```yaml
name: decision_definition_name
annotations:
  sql_column:
    tag: sql_column
    value: DEC_DEF_NAME_
description: The name of the decision definition
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionInstance
range: string

```
</details></div>