---
search:
  boost: 5.0
---

# Slot: deployment_id 


_Reference to the deployment._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:deployment_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/deployment_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ByteArray](ByteArray.md) | Byte Array entity in the engine infrastructure |  no  |
| [ResourceDefinition](ResourceDefinition.md) | Abstract base for deployable resource definitions (process, case, decision, f... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [JobDefinition](JobDefinition.md) | A Job Definition provides details about asynchronous background processing ("... |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |
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
| Domain Of | [ByteArray](ByteArray.md), [ResourceDefinition](ResourceDefinition.md), [Job](Job.md), [JobDefinition](JobDefinition.md), [HistoricJobLog](HistoricJobLog.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:deployment_id |
| native | fluxnova_bpm_platform:deployment_id |




## LinkML Source

<details>
```yaml
name: deployment_id
description: Reference to the deployment.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ByteArray
- ResourceDefinition
- Job
- JobDefinition
- HistoricJobLog
- UserOperationLogEntry
range: string

```
</details></div>