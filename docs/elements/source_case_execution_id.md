---
search:
  boost: 5.0
---

# Slot: source_case_execution_id 


_Reference to the source case execution._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:source_case_execution_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/source_case_execution_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseSentryPart](CaseSentryPart.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | SOURCE_CASE_EXEC_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:source_case_execution_id |
| native | fluxnova_bpm_platform:source_case_execution_id |




## LinkML Source

<details>
```yaml
name: source_case_execution_id
annotations:
  sql_column:
    tag: sql_column
    value: SOURCE_CASE_EXEC_ID_
description: Reference to the source case execution.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseSentryPart
range: string

```
</details></div>