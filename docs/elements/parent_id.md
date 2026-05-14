---
search:
  boost: 5.0
---

# Slot: parent_id 


_Reference to a CaseExecution._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:parent_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/parent_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [IdentityInfo](IdentityInfo.md) | Identity Info entity in the identity and access management |  no  |
| [CaseExecution](CaseExecution.md) | Case Execution entity in the process execution runtime |  no  |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [IdentityInfo](IdentityInfo.md), [CaseExecution](CaseExecution.md), [Execution](Execution.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | PARENT_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:parent_id |
| native | fluxnova_bpm_platform:parent_id |




## LinkML Source

<details>
```yaml
name: parent_id
annotations:
  sql_column:
    tag: sql_column
    value: PARENT_ID_
description: Reference to a CaseExecution.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- IdentityInfo
- CaseExecution
- Execution
range: string

```
</details></div>