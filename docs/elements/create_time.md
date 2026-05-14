---
search:
  boost: 5.0
---

# Slot: create_time 


_Creation timestamp._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:create_time](https://w3id.org/TD-Universe/fluxnova-bpm-platform/create_time)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ByteArray](ByteArray.md) | Byte Array entity in the engine infrastructure |  no  |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  yes  |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  yes  |
| [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md) | Represents one input variable of a decision evaluation |  no  |
| [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) | Represents one output variable of a decision evaluation |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  yes  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [ByteArray](ByteArray.md), [ExternalTask](ExternalTask.md), [Task](Task.md), [Attachment](Attachment.md), [Job](Job.md), [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md), [HistoricCaseInstance](HistoricCaseInstance.md), [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md), [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md), [HistoricIncident](HistoricIncident.md), [HistoricVariableInstance](HistoricVariableInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:create_time |
| native | fluxnova_bpm_platform:create_time |




## LinkML Source

<details>
```yaml
name: create_time
description: Creation timestamp.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ByteArray
- ExternalTask
- Task
- Attachment
- Job
- HistoricCaseActivityInstance
- HistoricCaseInstance
- HistoricDecisionInputInstance
- HistoricDecisionOutputInstance
- HistoricIncident
- HistoricVariableInstance
range: datetime

```
</details></div>