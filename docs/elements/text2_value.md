---
search:
  boost: 5.0
---

# Slot: text2_value 


_Variable value stored as text2._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:text2_value](https://w3id.org/TD-Universe/fluxnova-bpm-platform/text2_value)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |
| [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md) | Represents one input variable of a decision evaluation |  no  |
| [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) | Represents one output variable of a decision evaluation |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [VariableInstance](VariableInstance.md), [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md), [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricVariableInstance](HistoricVariableInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | TEXT2_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:text2_value |
| native | fluxnova_bpm_platform:text2_value |




## LinkML Source

<details>
```yaml
name: text2_value
annotations:
  sql_column:
    tag: sql_column
    value: TEXT2_
description: Variable value stored as text2.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- VariableInstance
- HistoricDecisionInputInstance
- HistoricDecisionOutputInstance
- HistoricDetail
- HistoricVariableInstance
range: string

```
</details></div>