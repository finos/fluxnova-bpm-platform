---
search:
  boost: 5.0
---

# Slot: properties 


_Serialized properties._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:properties](https://w3id.org/TD-Universe/fluxnova-bpm-platform/properties)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Filter](Filter.md) | Filter entity in the user collaboration |  no  |
| [Activity](Activity.md) | The BPMN activity element |  yes  |
| [Event](Event.md) | The BPMN event element |  yes  |
| [Process](Process.md) | The BPMN process element |  yes  |
| [BoundaryEvent](BoundaryEvent.md) | The BPMN boundaryEvent element |  no  |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [CallActivity](CallActivity.md) | The BPMN callActivity element |  no  |
| [CatchEvent](CatchEvent.md) | The BPMN catchEvent element |  no  |
| [EndEvent](EndEvent.md) | The BPMN endEvent element |  no  |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | The BPMN intermediateCatchEvent element |  no  |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | The BPMN intermediateThrowEvent element |  no  |
| [ManualTask](ManualTask.md) | The BPMN manualTask element |  no  |
| [ReceiveTask](ReceiveTask.md) | The BPMN receiveTask element |  no  |
| [ScriptTask](ScriptTask.md) | The BPMN scriptTask element |  no  |
| [SendTask](SendTask.md) | The BPMN sendTask element |  no  |
| [ServiceTask](ServiceTask.md) | The BPMN serviceTask element |  no  |
| [StartEvent](StartEvent.md) | The BPMN startEvent element |  no  |
| [SubProcess](SubProcess.md) | The BPMN subProcess element |  no  |
| [BpmnTask](BpmnTask.md) | The BPMN task element |  no  |
| [ThrowEvent](ThrowEvent.md) | The BPMN throwEvent element |  no  |
| [Transaction](Transaction.md) | A sub-process that executes as an atomic unit with compensation support |  no  |
| [UserTask](UserTask.md) | The BPMN userTask element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Filter](Filter.md), [Activity](Activity.md), [Event](Event.md), [Process](Process.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | PROPERTIES_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:properties |
| native | fluxnova_bpm_platform:properties |




## LinkML Source

<details>
```yaml
name: properties
annotations:
  sql_column:
    tag: sql_column
    value: PROPERTIES_
description: Serialized properties.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Filter
- Activity
- Event
- Process
range: string

```
</details></div>