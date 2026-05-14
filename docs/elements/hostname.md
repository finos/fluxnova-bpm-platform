---
search:
  boost: 5.0
---

# Slot: hostname 


_Name of the host where the Process Engine that added this job log runs._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:hostname](https://w3id.org/TD-Universe/fluxnova-bpm-platform/hostname)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricJobLog](HistoricJobLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | HOSTNAME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:hostname |
| native | fluxnova_bpm_platform:hostname |




## LinkML Source

<details>
```yaml
name: hostname
annotations:
  sql_column:
    tag: sql_column
    value: HOSTNAME_
description: Name of the host where the Process Engine that added this job log runs.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricJobLog
range: string

```
</details></div>