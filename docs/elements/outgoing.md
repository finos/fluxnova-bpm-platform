---
search:
  boost: 5.0
---

# Slot: outgoing 


_Sequence flows leaving this flow node._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:outgoing](https://w3id.org/TD-Universe/fluxnova-bpm-platform/outgoing)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [FlowNode](FlowNode.md) | The BPMN flowNode element |  no  |
| [Activity](Activity.md) | The BPMN activity element |  no  |
| [BoundaryEvent](BoundaryEvent.md) | The BPMN boundaryEvent element |  no  |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [CallActivity](CallActivity.md) | The BPMN callActivity element |  no  |
| [CatchEvent](CatchEvent.md) | The BPMN catchEvent element |  no  |
| [ComplexGateway](ComplexGateway.md) | The BPMN complexGateway element |  no  |
| [EndEvent](EndEvent.md) | The BPMN endEvent element |  no  |
| [Event](Event.md) | The BPMN event element |  no  |
| [EventBasedGateway](EventBasedGateway.md) | The BPMN eventBasedGateway element |  no  |
| [ExclusiveGateway](ExclusiveGateway.md) | The BPMN exclusiveGateway element |  no  |
| [Gateway](Gateway.md) | The BPMN gateway element |  no  |
| [InclusiveGateway](InclusiveGateway.md) | The BPMN inclusiveGateway element |  no  |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | The BPMN intermediateCatchEvent element |  no  |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | The BPMN intermediateThrowEvent element |  no  |
| [ManualTask](ManualTask.md) | The BPMN manualTask element |  no  |
| [ParallelGateway](ParallelGateway.md) | The BPMN parallelGateway element |  no  |
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
| Range | [SequenceFlow](SequenceFlow.md) |
| Domain Of | [FlowNode](FlowNode.md) |

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
| self | fluxnova_bpm_platform:outgoing |
| native | fluxnova_bpm_platform:outgoing |




## LinkML Source

<details>
```yaml
name: outgoing
description: Sequence flows leaving this flow node.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- FlowNode
range: SequenceFlow
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>