---
search:
  boost: 5.0
---

# Slot: case_activity_type 


_The display type for the case activity._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:case_activity_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/case_activity_type)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CASE_ACT_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:case_activity_type |
| native | fluxnova_bpm_platform:case_activity_type |




## LinkML Source

<details>
```yaml
name: case_activity_type
annotations:
  sql_column:
    tag: sql_column
    value: CASE_ACT_TYPE_
description: The display type for the case activity.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricCaseActivityInstance
range: string

```
</details></div>