---
search:
  boost: 5.0
---

# Slot: implementation 


_Implementation technology of this service or send/receive task._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:implementation](https://w3id.org/TD-Universe/fluxnova-bpm-platform/implementation)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [ReceiveTask](ReceiveTask.md) | The BPMN receiveTask element |  no  |
| [SendTask](SendTask.md) | The BPMN sendTask element |  no  |
| [ServiceTask](ServiceTask.md) | The BPMN serviceTask element |  no  |
| [UserTask](UserTask.md) | The BPMN userTask element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [BusinessRuleTask](BusinessRuleTask.md), [ReceiveTask](ReceiveTask.md), [SendTask](SendTask.md), [ServiceTask](ServiceTask.md), [UserTask](UserTask.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:implementation |
| native | fluxnova_bpm_platform:implementation |




## LinkML Source

<details>
```yaml
name: implementation
description: Implementation technology of this service or send/receive task.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- BusinessRuleTask
- ReceiveTask
- SendTask
- ServiceTask
- UserTask
range: string

```
</details></div>