---
search:
  boost: 5.0
---

# Slot: sentry_id 


_Reference to the sentry._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:sentry_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/sentry_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseSentryPart](CaseSentryPart.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | SENTRY_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:sentry_id |
| native | fluxnova_bpm_platform:sentry_id |




## LinkML Source

<details>
```yaml
name: sentry_id
annotations:
  sql_column:
    tag: sql_column
    value: SENTRY_ID_
description: Reference to the sentry.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseSentryPart
range: string

```
</details></div>