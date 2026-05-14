---
search:
  boost: 5.0
---

# Slot: fluxnova_type 


_Type name for this form field or listener._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:fluxnova_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_type)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [MessageEventDefinition](MessageEventDefinition.md) | The BPMN messageEventDefinition element |  no  |
| [SendTask](SendTask.md) | The BPMN sendTask element |  no  |
| [ServiceTask](ServiceTask.md) | The BPMN serviceTask element |  no  |
| [FluxnovaFormField](FluxnovaFormField.md) | The BPMN formField camunda extension element |  no  |
| [FluxnovaFormProperty](FluxnovaFormProperty.md) | The BPMN formProperty camunda extension element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [BusinessRuleTask](BusinessRuleTask.md), [MessageEventDefinition](MessageEventDefinition.md), [SendTask](SendTask.md), [ServiceTask](ServiceTask.md), [FluxnovaFormField](FluxnovaFormField.md), [FluxnovaFormProperty](FluxnovaFormProperty.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:fluxnova_type |
| native | fluxnova_bpm_platform:fluxnova_type |




## LinkML Source

<details>
```yaml
name: fluxnova_type
description: Type name for this form field or listener.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- BusinessRuleTask
- MessageEventDefinition
- SendTask
- ServiceTask
- FluxnovaFormField
- FluxnovaFormProperty
range: string

```
</details></div>