---
search:
  boost: 5.0
---

# Slot: variable_name 


_The name of the output variable._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:variable_name](https://w3id.org/TD-Universe/fluxnova-bpm-platform/variable_name)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |
| [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) | Represents one output variable of a decision evaluation |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseSentryPart](CaseSentryPart.md), [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | VAR_NAME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:variable_name |
| native | fluxnova_bpm_platform:variable_name |




## LinkML Source

<details>
```yaml
name: variable_name
annotations:
  sql_column:
    tag: sql_column
    value: VAR_NAME_
description: The name of the output variable.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseSentryPart
- HistoricDecisionOutputInstance
range: string

```
</details></div>