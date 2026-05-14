---
search:
  boost: 5.0
---

# Slot: tenant_id 


_Multi-tenancy discriminator._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:tenant_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/tenant_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ByteArray](ByteArray.md) | Byte Array entity in the engine infrastructure |  no  |
| [IdentityLink](IdentityLink.md) | An identity link is used to associate a task with a certain identity |  no  |
| [TenantMembership](TenantMembership.md) | Association entity in identity and access management |  yes  |
| [CaseExecution](CaseExecution.md) | Case Execution entity in the process execution runtime |  no  |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |
| [EventSubscription](EventSubscription.md) | A message event subscription exists, if an Execution waits for an event like ... |  no  |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |  no  |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |  no  |
| [Comment](Comment.md) | User comments that form discussions around tasks |  no  |
| [Deployment](Deployment.md) | Represents a deployment that is already present in the process repository |  no  |
| [ResourceDefinition](ResourceDefinition.md) | Abstract base for deployable resource definitions (process, case, decision, f... |  no  |
| [Batch](Batch.md) | A batch represents a number of jobs which execute a number of commands asynch... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [JobDefinition](JobDefinition.md) | A Job Definition provides details about asynchronous background processing ("... |  no  |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |
| [HistoricBatch](HistoricBatch.md) | Historic representation of a org |  no  |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  no  |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  no  |
| [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md) | Represents one input variable of a decision evaluation |  no  |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |
| [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) | Represents one output variable of a decision evaluation |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |
| [CaseDefinition](CaseDefinition.md) | A deployed case definition in the process repository |  no  |
| [DecisionDefinition](DecisionDefinition.md) | Definition of a decision resource |  no  |
| [DecisionRequirementsDefinition](DecisionRequirementsDefinition.md) | Container of DecisionDefinitions which belongs to the same decision requireme... |  no  |
| [FormDefinition](FormDefinition.md) | An object structure representing a Camunda Form used to present forms to user... |  no  |
| [ProcessDefinition](ProcessDefinition.md) | An object structure representing an executable process composed of activities... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [ByteArray](ByteArray.md), [IdentityLink](IdentityLink.md), [TenantMembership](TenantMembership.md), [CaseExecution](CaseExecution.md), [CaseSentryPart](CaseSentryPart.md), [EventSubscription](EventSubscription.md), [Execution](Execution.md), [ExternalTask](ExternalTask.md), [Incident](Incident.md), [Task](Task.md), [VariableInstance](VariableInstance.md), [Attachment](Attachment.md), [Comment](Comment.md), [Deployment](Deployment.md), [ResourceDefinition](ResourceDefinition.md), [Batch](Batch.md), [Job](Job.md), [JobDefinition](JobDefinition.md), [HistoricActivityInstance](HistoricActivityInstance.md), [HistoricBatch](HistoricBatch.md), [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md), [HistoricCaseInstance](HistoricCaseInstance.md), [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md), [HistoricDecisionInstance](HistoricDecisionInstance.md), [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricIdentityLink](HistoricIdentityLink.md), [HistoricIncident](HistoricIncident.md), [HistoricJobLog](HistoricJobLog.md), [HistoricProcessInstance](HistoricProcessInstance.md), [HistoricTaskInstance](HistoricTaskInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:tenant_id |
| native | fluxnova_bpm_platform:tenant_id |




## LinkML Source

<details>
```yaml
name: tenant_id
description: Multi-tenancy discriminator.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ByteArray
- IdentityLink
- TenantMembership
- CaseExecution
- CaseSentryPart
- EventSubscription
- Execution
- ExternalTask
- Incident
- Task
- VariableInstance
- Attachment
- Comment
- Deployment
- ResourceDefinition
- Batch
- Job
- JobDefinition
- HistoricActivityInstance
- HistoricBatch
- HistoricCaseActivityInstance
- HistoricCaseInstance
- HistoricDecisionInputInstance
- HistoricDecisionInstance
- HistoricDecisionOutputInstance
- HistoricDetail
- HistoricExternalTaskLog
- HistoricIdentityLink
- HistoricIncident
- HistoricJobLog
- HistoricProcessInstance
- HistoricTaskInstance
- HistoricVariableInstance
- UserOperationLogEntry
range: string

```
</details></div>