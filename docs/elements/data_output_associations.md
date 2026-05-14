---
search:
  boost: 5.0
---

# Slot: data_output_associations 


_Data associations that move output data out of this activity._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:data_output_associations](https://w3id.org/TD-Universe/fluxnova-bpm-platform/data_output_associations)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Activity](Activity.md) | The BPMN activity element |  no  |
| [CatchEvent](CatchEvent.md) | The BPMN catchEvent element |  no  |
| [BoundaryEvent](BoundaryEvent.md) | The BPMN boundaryEvent element |  no  |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [CallActivity](CallActivity.md) | The BPMN callActivity element |  no  |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | The BPMN intermediateCatchEvent element |  no  |
| [ManualTask](ManualTask.md) | The BPMN manualTask element |  no  |
| [ReceiveTask](ReceiveTask.md) | The BPMN receiveTask element |  no  |
| [ScriptTask](ScriptTask.md) | The BPMN scriptTask element |  no  |
| [SendTask](SendTask.md) | The BPMN sendTask element |  no  |
| [ServiceTask](ServiceTask.md) | The BPMN serviceTask element |  no  |
| [StartEvent](StartEvent.md) | The BPMN startEvent element |  no  |
| [SubProcess](SubProcess.md) | The BPMN subProcess element |  no  |
| [BpmnTask](BpmnTask.md) | The BPMN task element |  no  |
| [Transaction](Transaction.md) | A sub-process that executes as an atomic unit with compensation support |  no  |
| [UserTask](UserTask.md) | The BPMN userTask element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [DataOutputAssociation](DataOutputAssociation.md) |
| Domain Of | [Activity](Activity.md), [CatchEvent](CatchEvent.md) |

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
| self | fluxnova_bpm_platform:data_output_associations |
| native | fluxnova_bpm_platform:data_output_associations |




## LinkML Source

<details>
```yaml
name: data_output_associations
description: Data associations that move output data out of this activity.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Activity
- CatchEvent
range: DataOutputAssociation
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>