---
search:
  boost: 10.0
---

# Class: InteractionNode 


_The BPMN interactionNode interface_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:InteractionNode](https://w3id.org/TD-Universe/fluxnova-bpm-platform/InteractionNode)





```mermaid
 classDiagram
    class InteractionNode
    click InteractionNode href "../InteractionNode/"
      InteractionNode <|-- Activity
        click Activity href "../Activity/"
      InteractionNode <|-- ConversationNode
        click ConversationNode href "../ConversationNode/"
      InteractionNode <|-- Event
        click Event href "../Event/"
      InteractionNode <|-- Participant
        click Participant href "../Participant/"
      
      InteractionNode : id
        
      
```




<!-- no inheritance hierarchy -->

## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | direct |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [ConversationLink](ConversationLink.md) | [source](source.md) | range | [InteractionNode](InteractionNode.md) |
| [ConversationLink](ConversationLink.md) | [target](target.md) | range | [InteractionNode](InteractionNode.md) |
| [MessageFlow](MessageFlow.md) | [source](source.md) | range | [InteractionNode](InteractionNode.md) |
| [MessageFlow](MessageFlow.md) | [target](target.md) | range | [InteractionNode](InteractionNode.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/InteractionNode.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:InteractionNode |
| native | fluxnova_bpm_platform:InteractionNode |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: InteractionNode
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/InteractionNode.java
description: The BPMN interactionNode interface
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
slots:
- id

```
</details>

### Induced

<details>
```yaml
name: InteractionNode
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/InteractionNode.java
description: The BPMN interactionNode interface
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
attributes:
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: InteractionNode
    domain_of:
    - ByteArray
    - MeterLog
    - SchemaLogEntry
    - TaskMeterLog
    - Authorization
    - Group
    - IdentityInfo
    - IdentityLink
    - Tenant
    - TenantMembership
    - User
    - CaseExecution
    - CaseSentryPart
    - EventSubscription
    - Execution
    - ExternalTask
    - Incident
    - Task
    - VariableInstance
    - Attachment
    - Comment
    - Filter
    - Deployment
    - ResourceDefinition
    - Batch
    - Job
    - JobDefinition
    - HistoricBatch
    - HistoricDecisionInputInstance
    - HistoricDecisionInstance
    - HistoricDecisionOutputInstance
    - HistoricDetail
    - HistoricExternalTaskLog
    - HistoricIdentityLink
    - HistoricIncident
    - HistoricJobLog
    - HistoricScopeInstance
    - HistoricVariableInstance
    - UserOperationLogEntry
    - Diagram
    - DiagramElement
    - Style
    - BaseElement
    - Definitions
    - Documentation
    - InteractionNode
    range: string
    required: true

```
</details></div>