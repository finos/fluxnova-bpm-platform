---
search:
  boost: 5.0
---

# Slot: case_definition_key 


_Case definition key reference._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:case_definition_key](https://w3id.org/TD-Universe/fluxnova-bpm-platform/case_definition_key)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricDecisionInstance](HistoricDecisionInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricTaskInstance](HistoricTaskInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CASE_DEF_KEY_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:case_definition_key |
| native | fluxnova_bpm_platform:case_definition_key |




## LinkML Source

<details>
```yaml
name: case_definition_key
annotations:
  sql_column:
    tag: sql_column
    value: CASE_DEF_KEY_
description: Case definition key reference.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionInstance
- HistoricDetail
- HistoricTaskInstance
- HistoricVariableInstance
range: string

```
</details></div>