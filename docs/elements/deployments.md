---
search:
  boost: 5.0
---

# Slot: deployments 


_Deployed resources._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:deployments](https://w3id.org/TD-Universe/fluxnova-bpm-platform/deployments)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [FluxnovaPlatformData](FluxnovaPlatformData.md) | Root container for Fluxnova BPM Platform data |  yes  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Deployment](Deployment.md) |
| Domain Of | [FluxnovaPlatformData](FluxnovaPlatformData.md) |

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
| self | fluxnova_bpm_platform:deployments |
| native | fluxnova_bpm_platform:deployments |




## LinkML Source

<details>
```yaml
name: deployments
description: Deployed resources.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- FluxnovaPlatformData
range: Deployment
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>