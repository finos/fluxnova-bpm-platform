---
search:
  boost: 5.0
---

# Slot: root_process_instance_id 


_Root process instance for history cleanup._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:root_process_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/root_process_instance_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ByteArray](ByteArray.md) | Byte Array entity in the engine infrastructure |  no  |
| [Authorization](Authorization.md) | An Authorization assigns a set of Permission Permissions to an identity to in... |  no  |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |  no  |
| [Comment](Comment.md) | User comments that form discussions around tasks |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md) | Represents one input variable of a decision evaluation |  no  |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |
| [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) | Represents one output variable of a decision evaluation |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |
| [HistoricScopeInstance](HistoricScopeInstance.md) | Abstract base for historic entities with start/end time and duration |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  no  |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  no  |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [ByteArray](ByteArray.md), [Authorization](Authorization.md), [Execution](Execution.md), [Attachment](Attachment.md), [Comment](Comment.md), [Job](Job.md), [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md), [HistoricDecisionInstance](HistoricDecisionInstance.md), [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricIdentityLink](HistoricIdentityLink.md), [HistoricIncident](HistoricIncident.md), [HistoricJobLog](HistoricJobLog.md), [HistoricScopeInstance](HistoricScopeInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:root_process_instance_id |
| native | fluxnova_bpm_platform:root_process_instance_id |




## LinkML Source

<details>
```yaml
name: root_process_instance_id
description: Root process instance for history cleanup.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ByteArray
- Authorization
- Execution
- Attachment
- Comment
- Job
- HistoricDecisionInputInstance
- HistoricDecisionInstance
- HistoricDecisionOutputInstance
- HistoricDetail
- HistoricExternalTaskLog
- HistoricIdentityLink
- HistoricIncident
- HistoricJobLog
- HistoricScopeInstance
- HistoricVariableInstance
- UserOperationLogEntry
range: string

```
</details></div>