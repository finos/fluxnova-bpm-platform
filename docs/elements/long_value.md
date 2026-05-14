---
search:
  boost: 5.0
---

# Slot: long_value 


_Variable value stored as long._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:long_value](https://w3id.org/TD-Universe/fluxnova-bpm-platform/long_value)
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
| Range | [Integer](Integer.md) |
| Domain Of | [VariableInstance](VariableInstance.md), [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md), [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricVariableInstance](HistoricVariableInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | LONG_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:long_value |
| native | fluxnova_bpm_platform:long_value |




## LinkML Source

<details>
```yaml
name: long_value
annotations:
  sql_column:
    tag: sql_column
    value: LONG_
description: Variable value stored as long.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- VariableInstance
- HistoricDecisionInputInstance
- HistoricDecisionOutputInstance
- HistoricDetail
- HistoricVariableInstance
range: integer

```
</details></div>