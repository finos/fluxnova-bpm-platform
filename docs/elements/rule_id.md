---
search:
  boost: 5.0
---

# Slot: rule_id 


_The unique identifier of the rule that is matched. Can be null if the decision is not implemented as decision table._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:rule_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/rule_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) | Represents one output variable of a decision evaluation |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | RULE_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:rule_id |
| native | fluxnova_bpm_platform:rule_id |




## LinkML Source

<details>
```yaml
name: rule_id
annotations:
  sql_column:
    tag: sql_column
    value: RULE_ID_
description: The unique identifier of the rule that is matched. Can be null if the
  decision is not implemented as decision table.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDecisionOutputInstance
range: string

```
</details></div>