---
search:
  boost: 2.0
---


# Enum: AuthorizationType 




_Type of authorization rule._



<div data-search-exclude markdown="1">

URI: [fluxnova_bpm_platform:AuthorizationType](https://w3id.org/TD-Universe/fluxnova-bpm-platform/AuthorizationType)

## Permissible Values
| Value | Meaning | Description |
| --- | --- | --- |
| GLOBAL | fluxnova_bpm_platform:AuthorizationType/0 | Applies to all users |
| GRANT | fluxnova_bpm_platform:AuthorizationType/1 | Grants permission |
| REVOKE | fluxnova_bpm_platform:AuthorizationType/2 | Revokes permission |




## Slots

| Name | Description |
| ---  | --- |
| [type](type.md) |  |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform






## LinkML Source

<details>
```yaml
name: AuthorizationType
description: Type of authorization rule.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
permissible_values:
  GLOBAL:
    text: GLOBAL
    description: Applies to all users.
    meaning: fluxnova_bpm_platform:AuthorizationType/0
  GRANT:
    text: GRANT
    description: Grants permission.
    meaning: fluxnova_bpm_platform:AuthorizationType/1
  REVOKE:
    text: REVOKE
    description: Revokes permission.
    meaning: fluxnova_bpm_platform:AuthorizationType/2

```
</details>

</div>