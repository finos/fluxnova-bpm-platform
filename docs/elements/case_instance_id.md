---
search:
  boost: 5.0
---

# Slot: case_instance_id 


_Reference to the case instance._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:case_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/case_instance_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseExecution](CaseExecution.md) | Case Execution entity in the process execution runtime |  no  |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  yes  |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  yes  |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseExecution](CaseExecution.md), [CaseSentryPart](CaseSentryPart.md), [Execution](Execution.md), [Task](Task.md), [VariableInstance](VariableInstance.md), [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md), [HistoricCaseInstance](HistoricCaseInstance.md), [HistoricDecisionInstance](HistoricDecisionInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricProcessInstance](HistoricProcessInstance.md), [HistoricTaskInstance](HistoricTaskInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:case_instance_id |
| native | fluxnova_bpm_platform:case_instance_id |




## LinkML Source

<details>
```yaml
name: case_instance_id
description: Reference to the case instance.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseExecution
- CaseSentryPart
- Execution
- Task
- VariableInstance
- HistoricCaseActivityInstance
- HistoricCaseInstance
- HistoricDecisionInstance
- HistoricDetail
- HistoricProcessInstance
- HistoricTaskInstance
- HistoricVariableInstance
- UserOperationLogEntry
range: string

```
</details></div>