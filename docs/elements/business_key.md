---
search:
  boost: 5.0
---

# Slot: business_key 


_Domain-specific business key._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:business_key](https://w3id.org/TD-Universe/fluxnova-bpm-platform/business_key)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseExecution](CaseExecution.md) | Case Execution entity in the process execution runtime |  no  |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  no  |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseExecution](CaseExecution.md), [Execution](Execution.md), [HistoricCaseInstance](HistoricCaseInstance.md), [HistoricProcessInstance](HistoricProcessInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:business_key |
| native | fluxnova_bpm_platform:business_key |




## LinkML Source

<details>
```yaml
name: business_key
description: Domain-specific business key.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseExecution
- Execution
- HistoricCaseInstance
- HistoricProcessInstance
range: string

```
</details></div>