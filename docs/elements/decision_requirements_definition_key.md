---
search:
  boost: 5.0
---

# Slot: decision_requirements_definition_key 


_Key of the related decision requirements definition. Can be null if the decision has no relations to other decisions._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:decision_requirements_definition_key](https://w3id.org/TD-Universe/fluxnova-bpm-platform/decision_requirements_definition_key)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [DecisionDefinition](DecisionDefinition.md) | Definition of a decision resource |  no  |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [DecisionDefinition](DecisionDefinition.md), [HistoricDecisionInstance](HistoricDecisionInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | DEC_REQ_KEY_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:decision_requirements_definition_key |
| native | fluxnova_bpm_platform:decision_requirements_definition_key |




## LinkML Source

<details>
```yaml
name: decision_requirements_definition_key
annotations:
  sql_column:
    tag: sql_column
    value: DEC_REQ_KEY_
description: Key of the related decision requirements definition. Can be null if the
  decision has no relations to other decisions.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- DecisionDefinition
- HistoricDecisionInstance
range: string

```
</details></div>