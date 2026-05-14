---
search:
  boost: 5.0
---

# Slot: data_input_associations 


_Data associations that feed input data into this activity._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:data_input_associations](https://w3id.org/TD-Universe/fluxnova-bpm-platform/data_input_associations)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Activity](Activity.md) | The BPMN activity element |  no  |
| [ThrowEvent](ThrowEvent.md) | The BPMN throwEvent element |  no  |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [CallActivity](CallActivity.md) | The BPMN callActivity element |  no  |
| [EndEvent](EndEvent.md) | The BPMN endEvent element |  no  |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | The BPMN intermediateThrowEvent element |  no  |
| [ManualTask](ManualTask.md) | The BPMN manualTask element |  no  |
| [ReceiveTask](ReceiveTask.md) | The BPMN receiveTask element |  no  |
| [ScriptTask](ScriptTask.md) | The BPMN scriptTask element |  no  |
| [SendTask](SendTask.md) | The BPMN sendTask element |  no  |
| [ServiceTask](ServiceTask.md) | The BPMN serviceTask element |  no  |
| [SubProcess](SubProcess.md) | The BPMN subProcess element |  no  |
| [BpmnTask](BpmnTask.md) | The BPMN task element |  no  |
| [Transaction](Transaction.md) | A sub-process that executes as an atomic unit with compensation support |  no  |
| [UserTask](UserTask.md) | The BPMN userTask element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [DataInputAssociation](DataInputAssociation.md) |
| Domain Of | [Activity](Activity.md), [ThrowEvent](ThrowEvent.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Multivalued | Yes |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:data_input_associations |
| native | fluxnova_bpm_platform:data_input_associations |




## LinkML Source

<details>
```yaml
name: data_input_associations
description: Data associations that feed input data into this activity.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Activity
- ThrowEvent
range: DataInputAssociation
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>