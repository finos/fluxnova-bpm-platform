---
search:
  boost: 5.0
---

# Slot: activity_instance_id 


_Runtime activity instance identifier._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:activity_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/activity_instance_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |  no  |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Execution](Execution.md), [ExternalTask](ExternalTask.md), [HistoricDecisionInstance](HistoricDecisionInstance.md), [HistoricDetail](HistoricDetail.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricTaskInstance](HistoricTaskInstance.md), [HistoricVariableInstance](HistoricVariableInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:activity_instance_id |
| native | fluxnova_bpm_platform:activity_instance_id |




## LinkML Source

<details>
```yaml
name: activity_instance_id
description: Runtime activity instance identifier.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Execution
- ExternalTask
- HistoricDecisionInstance
- HistoricDetail
- HistoricExternalTaskLog
- HistoricTaskInstance
- HistoricVariableInstance
range: string

```
</details></div>