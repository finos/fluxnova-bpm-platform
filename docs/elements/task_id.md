---
search:
  boost: 5.0
---

# Slot: task_id 


_Reference to the task._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:task_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/task_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [IdentityLink](IdentityLink.md) | An identity link is used to associate a task with a certain identity |  no  |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |  no  |
| [Comment](Comment.md) | User comments that form discussions around tasks |  no  |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [IdentityLink](IdentityLink.md), [VariableInstance](VariableInstance.md), [Attachment](Attachment.md), [Comment](Comment.md), [HistoricActivityInstance](HistoricActivityInstance.md), [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricIdentityLink](HistoricIdentityLink.md), [HistoricVariableInstance](HistoricVariableInstance.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:task_id |
| native | fluxnova_bpm_platform:task_id |




## LinkML Source

<details>
```yaml
name: task_id
description: Reference to the task.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- IdentityLink
- VariableInstance
- Attachment
- Comment
- HistoricActivityInstance
- HistoricCaseActivityInstance
- HistoricDetail
- HistoricIdentityLink
- HistoricVariableInstance
- UserOperationLogEntry
range: string

```
</details></div>