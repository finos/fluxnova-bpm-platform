---
search:
  boost: 5.0
---

# Slot: fluxnova_result_variable 


_Process variable to store the expression result._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:fluxnova_result_variable](https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_result_variable)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |  no  |
| [MessageEventDefinition](MessageEventDefinition.md) | The BPMN messageEventDefinition element |  no  |
| [ScriptTask](ScriptTask.md) | The BPMN scriptTask element |  no  |
| [SendTask](SendTask.md) | The BPMN sendTask element |  no  |
| [ServiceTask](ServiceTask.md) | The BPMN serviceTask element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [BusinessRuleTask](BusinessRuleTask.md), [MessageEventDefinition](MessageEventDefinition.md), [ScriptTask](ScriptTask.md), [SendTask](SendTask.md), [ServiceTask](ServiceTask.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:fluxnova_result_variable |
| native | fluxnova_bpm_platform:fluxnova_result_variable |




## LinkML Source

<details>
```yaml
name: fluxnova_result_variable
description: Process variable to store the expression result.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- BusinessRuleTask
- MessageEventDefinition
- ScriptTask
- SendTask
- ServiceTask
range: string

```
</details></div>