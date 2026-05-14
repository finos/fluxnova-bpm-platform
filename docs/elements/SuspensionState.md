---
search:
  boost: 2.0
---


# Enum: SuspensionState 




_Whether an entity is active or suspended._



<div data-search-exclude markdown="1">

URI: [fluxnova_bpm_platform:SuspensionState](https://w3id.org/TD-Universe/fluxnova-bpm-platform/SuspensionState)

## Permissible Values
| Value | Meaning | Description |
| --- | --- | --- |
| ACTIVE | fluxnova_bpm_platform:SuspensionState/1 | The entity is active |
| SUSPENDED | fluxnova_bpm_platform:SuspensionState/2 | The entity is suspended |




## Slots

| Name | Description |
| ---  | --- |
| [suspension_state](suspension_state.md) | Whether the entity is active or suspended |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform






## LinkML Source

<details>
```yaml
name: SuspensionState
description: Whether an entity is active or suspended.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
permissible_values:
  ACTIVE:
    text: ACTIVE
    description: The entity is active.
    meaning: fluxnova_bpm_platform:SuspensionState/1
  SUSPENDED:
    text: SUSPENDED
    description: The entity is suspended.
    meaning: fluxnova_bpm_platform:SuspensionState/2

```
</details>

</div>