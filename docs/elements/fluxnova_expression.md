---
search:
  boost: 5.0
---

# Slot: fluxnova_expression 


_EL expression for this element._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:fluxnova_expression](https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_expression)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [MessageEventDefinition](MessageEventDefinition.md) | The BPMN messageEventDefinition element |  no  |
| [SendTask](SendTask.md) | The BPMN sendTask element |  no  |
| [ServiceTask](ServiceTask.md) | The BPMN serviceTask element |  no  |
| [FluxnovaErrorEventDefinition](FluxnovaErrorEventDefinition.md) | Fluxnova extension that augments an end event error definition with engine-sp... |  no  |
| [FluxnovaExecutionListener](FluxnovaExecutionListener.md) | The BPMN executionListener camunda extension element |  no  |
| [FluxnovaField](FluxnovaField.md) | The BPMN field camunda extension element |  no  |
| [FluxnovaFormProperty](FluxnovaFormProperty.md) | The BPMN formProperty camunda extension element |  no  |
| [FluxnovaTaskListener](FluxnovaTaskListener.md) | The BPMN taskListener camunda extension element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [BusinessRuleTask](BusinessRuleTask.md), [MessageEventDefinition](MessageEventDefinition.md), [SendTask](SendTask.md), [ServiceTask](ServiceTask.md), [FluxnovaErrorEventDefinition](FluxnovaErrorEventDefinition.md), [FluxnovaExecutionListener](FluxnovaExecutionListener.md), [FluxnovaField](FluxnovaField.md), [FluxnovaFormProperty](FluxnovaFormProperty.md), [FluxnovaTaskListener](FluxnovaTaskListener.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:fluxnova_expression |
| native | fluxnova_bpm_platform:fluxnova_expression |




## LinkML Source

<details>
```yaml
name: fluxnova_expression
description: EL expression for this element.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- BusinessRuleTask
- MessageEventDefinition
- SendTask
- ServiceTask
- FluxnovaErrorEventDefinition
- FluxnovaExecutionListener
- FluxnovaField
- FluxnovaFormProperty
- FluxnovaTaskListener
range: string

```
</details></div>