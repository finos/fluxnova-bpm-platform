---
search:
  boost: 5.0
---

# Slot: type 


_Type discriminator._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/type)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ByteArray](ByteArray.md) | Byte Array entity in the engine infrastructure |  yes  |
| [Authorization](Authorization.md) | An Authorization assigns a set of Permission Permissions to an identity to in... |  yes  |
| [Group](Group.md) | Represents a group, used in IdentityService |  no  |
| [IdentityInfo](IdentityInfo.md) | Identity Info entity in the identity and access management |  no  |
| [IdentityLink](IdentityLink.md) | An identity link is used to associate a task with a certain identity |  no  |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  yes  |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |  no  |
| [Comment](Comment.md) | User comments that form discussions around tasks |  no  |
| [Batch](Batch.md) | A batch represents a number of jobs which execute a number of commands asynch... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  yes  |
| [HistoricBatch](HistoricBatch.md) | Historic representation of a org |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  yes  |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  no  |
| [ConditionExpression](ConditionExpression.md) | The BPMN conditionExpression element of the BPMN tSequenceFlow type |  no  |
| [CorrelationProperty](CorrelationProperty.md) | The BPMN correlationProperty element |  yes  |
| [Relationship](Relationship.md) | The BPMN relationship element |  no  |
| [ResourceParameter](ResourceParameter.md) | The BPMN resourceParameter element |  yes  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [ByteArray](ByteArray.md), [Authorization](Authorization.md), [Group](Group.md), [IdentityInfo](IdentityInfo.md), [IdentityLink](IdentityLink.md), [CaseSentryPart](CaseSentryPart.md), [VariableInstance](VariableInstance.md), [Attachment](Attachment.md), [Comment](Comment.md), [Batch](Batch.md), [Job](Job.md), [HistoricBatch](HistoricBatch.md), [HistoricDetail](HistoricDetail.md), [HistoricIdentityLink](HistoricIdentityLink.md), [ConditionExpression](ConditionExpression.md), [CorrelationProperty](CorrelationProperty.md), [Relationship](Relationship.md), [ResourceParameter](ResourceParameter.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:type |
| native | fluxnova_bpm_platform:type |




## LinkML Source

<details>
```yaml
name: type
description: Type discriminator.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ByteArray
- Authorization
- Group
- IdentityInfo
- IdentityLink
- CaseSentryPart
- VariableInstance
- Attachment
- Comment
- Batch
- Job
- HistoricBatch
- HistoricDetail
- HistoricIdentityLink
- ConditionExpression
- CorrelationProperty
- Relationship
- ResourceParameter
range: string

```
</details></div>