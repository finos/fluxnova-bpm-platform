---
search:
  boost: 5.0
---

# Slot: super_execution_id 


_Reference to the super execution._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:super_execution_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/super_execution_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseExecution](CaseExecution.md) | Case Execution entity in the process execution runtime |  no  |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseExecution](CaseExecution.md), [Execution](Execution.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | SUPER_EXEC_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:super_execution_id |
| native | fluxnova_bpm_platform:super_execution_id |




## LinkML Source

<details>
```yaml
name: super_execution_id
annotations:
  sql_column:
    tag: sql_column
    value: SUPER_EXEC_
description: Reference to the super execution.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseExecution
- Execution
range: string

```
</details></div>