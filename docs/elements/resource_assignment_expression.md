---
search:
  boost: 5.0
---

# Slot: resource_assignment_expression 


_Expression used to resolve the assigned resource._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:resource_assignment_expression](https://w3id.org/TD-Universe/fluxnova-bpm-platform/resource_assignment_expression)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ResourceRole](ResourceRole.md) | The BPMN resourceRole element |  no  |
| [FluxnovaPotentialStarter](FluxnovaPotentialStarter.md) | The BPMN potentialStarter camunda extension |  no  |
| [HumanPerformer](HumanPerformer.md) | The BPMN humanPerformer element |  no  |
| [Performer](Performer.md) | The BPMN performer element |  no  |
| [PotentialOwner](PotentialOwner.md) | The BPMN potentialOwner element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [ResourceAssignmentExpression](ResourceAssignmentExpression.md) |
| Domain Of | [ResourceRole](ResourceRole.md), [FluxnovaPotentialStarter](FluxnovaPotentialStarter.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:resource_assignment_expression |
| native | fluxnova_bpm_platform:resource_assignment_expression |




## LinkML Source

<details>
```yaml
name: resource_assignment_expression
description: Expression used to resolve the assigned resource.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ResourceRole
- FluxnovaPotentialStarter
range: ResourceAssignmentExpression

```
</details></div>