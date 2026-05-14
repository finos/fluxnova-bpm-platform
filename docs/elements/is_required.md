---
search:
  boost: 5.0
---

# Slot: is_required 


_Whether this entity is required._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:is_required](https://w3id.org/TD-Universe/fluxnova-bpm-platform/is_required)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseExecution](CaseExecution.md) | Case Execution entity in the process execution runtime |  no  |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Boolean](Boolean.md) |
| Domain Of | [CaseExecution](CaseExecution.md), [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | REQUIRED_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:is_required |
| native | fluxnova_bpm_platform:is_required |




## LinkML Source

<details>
```yaml
name: is_required
annotations:
  sql_column:
    tag: sql_column
    value: REQUIRED_
description: Whether this entity is required.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseExecution
- HistoricCaseActivityInstance
range: boolean

```
</details></div>