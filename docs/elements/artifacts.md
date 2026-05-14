---
search:
  boost: 5.0
---

# Slot: artifacts 


_Artifacts (text annotations, groups, associations) in this process._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:artifacts](https://w3id.org/TD-Universe/fluxnova-bpm-platform/artifacts)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Collaboration](Collaboration.md) | The BPMN collaboration element |  no  |
| [Process](Process.md) | The BPMN process element |  no  |
| [SubProcess](SubProcess.md) | The BPMN subProcess element |  no  |
| [GlobalConversation](GlobalConversation.md) | The BPMN globalConversation element |  no  |
| [Transaction](Transaction.md) | A sub-process that executes as an atomic unit with compensation support |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Artifact](Artifact.md) |
| Domain Of | [Collaboration](Collaboration.md), [Process](Process.md), [SubProcess](SubProcess.md) |

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
| self | fluxnova_bpm_platform:artifacts |
| native | fluxnova_bpm_platform:artifacts |




## LinkML Source

<details>
```yaml
name: artifacts
description: Artifacts (text annotations, groups, associations) in this process.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Collaboration
- Process
- SubProcess
range: Artifact
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>