---
search:
  boost: 5.0
---

# Slot: content_id 


_Reference to the content._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:content_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/content_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Attachment](Attachment.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CONTENT_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:content_id |
| native | fluxnova_bpm_platform:content_id |




## LinkML Source

<details>
```yaml
name: content_id
annotations:
  sql_column:
    tag: sql_column
    value: CONTENT_ID_
description: Reference to the content.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Attachment
range: string

```
</details></div>