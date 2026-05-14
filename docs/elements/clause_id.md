---
search:
  boost: 5.0
---

# Slot: clause_id 


_The unique identifier of the clause that the value is assigned for. Can be null if the decision is not implemented as decision table._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:clause_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/clause_id)
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










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CLAUSE_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:clause_id |
| native | fluxnova_bpm_platform:clause_id |




## LinkML Source

<details>
```yaml
name: clause_id
annotations:
  sql_column:
    tag: sql_column
    value: CLAUSE_ID_
description: The unique identifier of the clause that the value is assigned for. Can
  be null if the decision is not implemented as decision table.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionInputInstance
- HistoricDecisionOutputInstance
range: string

```
</details></div>