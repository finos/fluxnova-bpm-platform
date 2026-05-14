---
search:
  boost: 5.0
---

# Slot: case_activity_name 


_The display name for the case activity._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:case_activity_name](https://w3id.org/TD-Universe/fluxnova-bpm-platform/case_activity_name)
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
| sql_column | CASE_ACT_NAME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:case_activity_name |
| native | fluxnova_bpm_platform:case_activity_name |




## LinkML Source

<details>
```yaml
name: case_activity_name
annotations:
  sql_column:
    tag: sql_column
    value: CASE_ACT_NAME_
description: The display name for the case activity.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricCaseActivityInstance
range: string

```
</details></div>