---
search:
  boost: 5.0
---

# Slot: resource_roles 


_Resources (performers, potential owners) assigned to this activity._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:resource_roles](https://w3id.org/TD-Universe/fluxnova-bpm-platform/resource_roles)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Activity](Activity.md) | The BPMN activity element |  no  |
| [Process](Process.md) | The BPMN process element |  no  |
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
| Range | [ResourceRole](ResourceRole.md) |
| Domain Of | [Activity](Activity.md), [Process](Process.md) |

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
| self | fluxnova_bpm_platform:resource_roles |
| native | fluxnova_bpm_platform:resource_roles |




## LinkML Source

<details>
```yaml
name: resource_roles
description: Resources (performers, potential owners) assigned to this activity.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Activity
- Process
range: ResourceRole
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>