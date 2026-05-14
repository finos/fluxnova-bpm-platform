---
search:
  boost: 5.0
---

# Slot: variable_type 


_The variable type._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:variable_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/variable_type)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md) | Represents one input variable of a decision evaluation |  no  |
| [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) | Represents one output variable of a decision evaluation |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md), [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricVariableInstance](HistoricVariableInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | VAR_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:variable_type |
| native | fluxnova_bpm_platform:variable_type |




## LinkML Source

<details>
```yaml
name: variable_type
annotations:
  sql_column:
    tag: sql_column
    value: VAR_TYPE_
description: The variable type.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionInputInstance
- HistoricDecisionOutputInstance
- HistoricDetail
- HistoricVariableInstance
range: string

```
</details></div>