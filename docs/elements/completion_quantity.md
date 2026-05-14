---
search:
  boost: 5.0
---

# Slot: completion_quantity 


_Number of tokens produced when this activity completes._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:completion_quantity](https://w3id.org/TD-Universe/fluxnova-bpm-platform/completion_quantity)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Activity](Activity.md) | The BPMN activity element |  no  |
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
| Range | [Integer](Integer.md) |
| Domain Of | [Activity](Activity.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:completion_quantity |
| native | fluxnova_bpm_platform:completion_quantity |




## LinkML Source

<details>
```yaml
name: completion_quantity
description: Number of tokens produced when this activity completes.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Activity
range: integer

```
</details></div>