---
search:
  boost: 5.0
---

# Slot: state 


_Current state of HistoricProcessInstance, following values are recognized during process engine operations: STATE_ACTIVE - running process instance STATE_SUSPENDED - suspended process instances STA..._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:state](https://w3id.org/TD-Universe/fluxnova-bpm-platform/state)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  no  |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [EntityState](EntityState.md) |
| Domain Of | [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md), [HistoricCaseInstance](HistoricCaseInstance.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricProcessInstance](HistoricProcessInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | STATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:state |
| native | fluxnova_bpm_platform:state |




## LinkML Source

<details>
```yaml
name: state
annotations:
  sql_column:
    tag: sql_column
    value: STATE_
description: 'Current state of HistoricProcessInstance, following values are recognized
  during process engine operations: STATE_ACTIVE - running process instance STATE_SUSPENDED
  - suspended process instances STA...'
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricCaseActivityInstance
- HistoricCaseInstance
- HistoricExternalTaskLog
- HistoricProcessInstance
- HistoricVariableInstance
range: EntityState

```
</details></div>