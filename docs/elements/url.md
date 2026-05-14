---
search:
  boost: 5.0
---

# Slot: url 


_The remote URL in case this is remote content. If the attachment content was uploaded with an input stream, then this method returns null and the content can be fetched with ._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:url](https://w3id.org/TD-Universe/fluxnova-bpm-platform/url)
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
| sql_column | URL_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:url |
| native | fluxnova_bpm_platform:url |




## LinkML Source

<details>
```yaml
name: url
annotations:
  sql_column:
    tag: sql_column
    value: URL_
description: The remote URL in case this is remote content. If the attachment content
  was uploaded with an input stream, then this method returns null and the content
  can be fetched with .
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Attachment
range: string

```
</details></div>