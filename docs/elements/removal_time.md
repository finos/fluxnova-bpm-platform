---
search:
  boost: 5.0
---

# Slot: removal_time 


_Timestamp when this entity is eligible for removal._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:removal_time](https://w3id.org/TD-Universe/fluxnova-bpm-platform/removal_time)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ByteArray](ByteArray.md) | Byte Array entity in the engine infrastructure |  no  |
| [Authorization](Authorization.md) | An Authorization assigns a set of Permission Permissions to an identity to in... |  no  |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |  no  |
| [Comment](Comment.md) | User comments that form discussions around tasks |  no  |
| [HistoricBatch](HistoricBatch.md) | Historic representation of a org |  no  |
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
| Range | [Datetime](Datetime.md) |
| Domain Of | [ByteArray](ByteArray.md), [Authorization](Authorization.md), [Attachment](Attachment.md), [Comment](Comment.md), [HistoricBatch](HistoricBatch.md), [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md), [HistoricDecisionInstance](HistoricDecisionInstance.md), [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricIdentityLink](HistoricIdentityLink.md), [HistoricIncident](HistoricIncident.md), [HistoricJobLog](HistoricJobLog.md), [HistoricScopeInstance](HistoricScopeInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:removal_time |
| native | fluxnova_bpm_platform:removal_time |




## LinkML Source

<details>
```yaml
name: removal_time
description: Timestamp when this entity is eligible for removal.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ByteArray
- Authorization
- Attachment
- Comment
- HistoricBatch
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
range: datetime

```
</details></div>