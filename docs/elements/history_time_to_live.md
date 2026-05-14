---
search:
  boost: 5.0
---

# Slot: history_time_to_live 


_Days to retain history before cleanup._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:history_time_to_live](https://w3id.org/TD-Universe/fluxnova-bpm-platform/history_time_to_live)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ResourceDefinition](ResourceDefinition.md) | Abstract base for deployable resource definitions (process, case, decision, f... |  no  |
| [CaseDefinition](CaseDefinition.md) | A deployed case definition in the process repository |  no  |
| [DecisionDefinition](DecisionDefinition.md) | Definition of a decision resource |  no  |
| [DecisionRequirementsDefinition](DecisionRequirementsDefinition.md) | Container of DecisionDefinitions which belongs to the same decision requireme... |  no  |
| [FormDefinition](FormDefinition.md) | An object structure representing a Camunda Form used to present forms to user... |  no  |
| [ProcessDefinition](ProcessDefinition.md) | An object structure representing an executable process composed of activities... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [ResourceDefinition](ResourceDefinition.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:history_time_to_live |
| native | fluxnova_bpm_platform:history_time_to_live |




## LinkML Source

<details>
```yaml
name: history_time_to_live
description: Days to retain history before cleanup.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ResourceDefinition
range: integer

```
</details></div>