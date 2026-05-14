---
search:
  boost: 5.0
---

# Slot: fluxnova_resource 


_Camunda extensions_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:fluxnova_resource](https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_resource)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ConditionExpression](ConditionExpression.md) | The BPMN conditionExpression element of the BPMN tSequenceFlow type |  no  |
| [ScriptTask](ScriptTask.md) | The BPMN scriptTask element |  no  |
| [FluxnovaScript](FluxnovaScript.md) | The BPMN script camunda extension element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [ConditionExpression](ConditionExpression.md), [ScriptTask](ScriptTask.md), [FluxnovaScript](FluxnovaScript.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:fluxnova_resource |
| native | fluxnova_bpm_platform:fluxnova_resource |




## LinkML Source

<details>
```yaml
name: fluxnova_resource
description: Camunda extensions
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ConditionExpression
- ScriptTask
- FluxnovaScript
range: string

```
</details></div>