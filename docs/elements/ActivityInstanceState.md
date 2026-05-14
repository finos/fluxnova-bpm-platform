---
search:
  boost: 2.0
---


# Enum: ActivityInstanceState 




_State of an activity instance._



<div data-search-exclude markdown="1">

URI: [fluxnova_bpm_platform:ActivityInstanceState](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ActivityInstanceState)

## Permissible Values
| Value | Meaning | Description |
| --- | --- | --- |
| DEFAULT | fluxnova_bpm_platform:ActivityInstanceState/0 | The activity instance is running normally |
| SCOPE_COMPLETE | fluxnova_bpm_platform:ActivityInstanceState/1 | The scope of the activity instance is complete |
| CANCELED | fluxnova_bpm_platform:ActivityInstanceState/2 | The activity instance was canceled |
| STARTING | fluxnova_bpm_platform:ActivityInstanceState/3 | The activity instance is starting |
| ENDING | fluxnova_bpm_platform:ActivityInstanceState/4 | The activity instance is ending |




## Slots

| Name | Description |
| ---  | --- |
| [activity_instance_state](activity_instance_state.md) | The activity instance state |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform






## LinkML Source

<details>
```yaml
name: ActivityInstanceState
description: State of an activity instance.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
permissible_values:
  DEFAULT:
    text: DEFAULT
    description: The activity instance is running normally.
    meaning: fluxnova_bpm_platform:ActivityInstanceState/0
  SCOPE_COMPLETE:
    text: SCOPE_COMPLETE
    description: The scope of the activity instance is complete.
    meaning: fluxnova_bpm_platform:ActivityInstanceState/1
  CANCELED:
    text: CANCELED
    description: The activity instance was canceled.
    meaning: fluxnova_bpm_platform:ActivityInstanceState/2
  STARTING:
    text: STARTING
    description: The activity instance is starting.
    meaning: fluxnova_bpm_platform:ActivityInstanceState/3
  ENDING:
    text: ENDING
    description: The activity instance is ending.
    meaning: fluxnova_bpm_platform:ActivityInstanceState/4

```
</details>

</div>