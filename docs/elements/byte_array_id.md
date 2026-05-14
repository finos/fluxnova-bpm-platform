---
search:
  boost: 5.0
---

# Slot: byte_array_id 


_Reference to the byte array._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:byte_array_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/byte_array_id)
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
| sql_column | BYTEARRAY_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:byte_array_id |
| native | fluxnova_bpm_platform:byte_array_id |




## LinkML Source

<details>
```yaml
name: byte_array_id
annotations:
  sql_column:
    tag: sql_column
    value: BYTEARRAY_ID_
description: Reference to the byte array.
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