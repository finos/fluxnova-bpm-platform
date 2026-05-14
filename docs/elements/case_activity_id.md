---
search:
  boost: 5.0
---

# Slot: case_activity_id 


_The unique identifier of the case activity in the case._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:case_activity_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/case_activity_id)
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
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CASE_ACT_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:case_activity_id |
| native | fluxnova_bpm_platform:case_activity_id |




## LinkML Source

<details>
```yaml
name: case_activity_id
annotations:
  sql_column:
    tag: sql_column
    value: CASE_ACT_ID_
description: The unique identifier of the case activity in the case.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricCaseActivityInstance
range: string
required: true

```
</details></div>