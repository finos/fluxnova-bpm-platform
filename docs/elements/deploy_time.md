---
search:
  boost: 5.0
---

# Slot: deploy_time 


_Timestamp for deploy time._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:deploy_time](https://w3id.org/TD-Universe/fluxnova-bpm-platform/deploy_time)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Deployment](Deployment.md) | Represents a deployment that is already present in the process repository |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [Deployment](Deployment.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | DEPLOY_TIME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:deploy_time |
| native | fluxnova_bpm_platform:deploy_time |




## LinkML Source

<details>
```yaml
name: deploy_time
annotations:
  sql_column:
    tag: sql_column
    value: DEPLOY_TIME_
description: Timestamp for deploy time.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Deployment
range: datetime

```
</details></div>