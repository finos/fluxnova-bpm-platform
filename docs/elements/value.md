---
search:
  boost: 5.0
---

# Slot: value 


_Value of this variable instance._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:value](https://w3id.org/TD-Universe/fluxnova-bpm-platform/value)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [MeterLog](MeterLog.md) | Meter Log entity in the engine infrastructure |  yes  |
| [Property](Property.md) | Property entity in the engine infrastructure |  no  |
| [IdentityInfo](IdentityInfo.md) | Identity Info entity in the identity and access management |  no  |
| [CategoryValue](CategoryValue.md) | The BPMN categoryValue element |  no  |
| [FluxnovaGenericValueElement](FluxnovaGenericValueElement.md) | A helper interface for camunda extension elements which hold a generic child ... |  no  |
| [FluxnovaEntry](FluxnovaEntry.md) | The BPMN camundaEntry camunda extension element |  no  |
| [FluxnovaInputParameter](FluxnovaInputParameter.md) | The BPMN inputParameter camunda extension element |  no  |
| [FluxnovaOutputParameter](FluxnovaOutputParameter.md) | The BPMN outputParameter camunda extension element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [MeterLog](MeterLog.md), [Property](Property.md), [IdentityInfo](IdentityInfo.md), [CategoryValue](CategoryValue.md), [FluxnovaGenericValueElement](FluxnovaGenericValueElement.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | VALUE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:value |
| native | fluxnova_bpm_platform:value |




## LinkML Source

<details>
```yaml
name: value
annotations:
  sql_column:
    tag: sql_column
    value: VALUE_
description: Value of this variable instance.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- MeterLog
- Property
- IdentityInfo
- CategoryValue
- FluxnovaGenericValueElement
range: string

```
</details></div>