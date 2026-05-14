---
search:
  boost: 5.0
---

# Slot: default 


_Default sequence flow taken when no other outgoing condition is satisfied._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:default](https://w3id.org/TD-Universe/fluxnova-bpm-platform/default)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Activity](Activity.md) | The BPMN activity element |  no  |
| [ComplexGateway](ComplexGateway.md) | The BPMN complexGateway element |  no  |
| [ExclusiveGateway](ExclusiveGateway.md) | The BPMN exclusiveGateway element |  no  |
| [InclusiveGateway](InclusiveGateway.md) | The BPMN inclusiveGateway element |  no  |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [CallActivity](CallActivity.md) | The BPMN callActivity element |  no  |
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
| Range | [SequenceFlow](SequenceFlow.md) |
| Domain Of | [Activity](Activity.md), [ComplexGateway](ComplexGateway.md), [ExclusiveGateway](ExclusiveGateway.md), [InclusiveGateway](InclusiveGateway.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:default |
| native | fluxnova_bpm_platform:default |




## LinkML Source

<details>
```yaml
name: default
description: Default sequence flow taken when no other outgoing condition is satisfied.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Activity
- ComplexGateway
- ExclusiveGateway
- InclusiveGateway
range: SequenceFlow

```
</details></div>