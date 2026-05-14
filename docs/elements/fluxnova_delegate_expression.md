---
search:
  boost: 5.0
---

# Slot: fluxnova_delegate_expression 


_Expression resolving to a JavaDelegate._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:fluxnova_delegate_expression](https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_delegate_expression)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [MessageEventDefinition](MessageEventDefinition.md) | The BPMN messageEventDefinition element |  no  |
| [SendTask](SendTask.md) | The BPMN sendTask element |  no  |
| [ServiceTask](ServiceTask.md) | The BPMN serviceTask element |  no  |
| [FluxnovaExecutionListener](FluxnovaExecutionListener.md) | The BPMN executionListener camunda extension element |  no  |
| [FluxnovaTaskListener](FluxnovaTaskListener.md) | The BPMN taskListener camunda extension element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [BusinessRuleTask](BusinessRuleTask.md), [MessageEventDefinition](MessageEventDefinition.md), [SendTask](SendTask.md), [ServiceTask](ServiceTask.md), [FluxnovaExecutionListener](FluxnovaExecutionListener.md), [FluxnovaTaskListener](FluxnovaTaskListener.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:fluxnova_delegate_expression |
| native | fluxnova_bpm_platform:fluxnova_delegate_expression |




## LinkML Source

<details>
```yaml
name: fluxnova_delegate_expression
description: Expression resolving to a JavaDelegate.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- BusinessRuleTask
- MessageEventDefinition
- SendTask
- ServiceTask
- FluxnovaExecutionListener
- FluxnovaTaskListener
range: string

```
</details></div>