---
search:
  boost: 10.0
---

# Class: ParticipantAssociation 


_The BPMN participantAssociation element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ParticipantAssociation](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ParticipantAssociation)





```mermaid
 classDiagram
    class ParticipantAssociation
    click ParticipantAssociation href "../ParticipantAssociation/"
      BaseElement <|-- ParticipantAssociation
        click BaseElement href "../BaseElement/"
      
      ParticipantAssociation : diagram_element
        
          
    
        
        
        ParticipantAssociation --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      ParticipantAssociation : documentations
        
          
    
        
        
        ParticipantAssociation --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      ParticipantAssociation : extension_elements
        
          
    
        
        
        ParticipantAssociation --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      ParticipantAssociation : id
        
      ParticipantAssociation : inner_participant
        
          
    
        
        
        ParticipantAssociation --> "0..1" Participant : inner_participant
        click Participant href "../Participant/"
    

        
      ParticipantAssociation : outer_participant
        
          
    
        
        
        ParticipantAssociation --> "0..1" Participant : outer_participant
        click Participant href "../Participant/"
    

        
      ParticipantAssociation : scope
        
          
    
        
        
        ParticipantAssociation --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **ParticipantAssociation**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [inner_participant](inner_participant.md) | 0..1 <br/> [Participant](Participant.md) | The inner participant of this element | direct |
| [outer_participant](outer_participant.md) | 0..1 <br/> [Participant](Participant.md) | The outer participant of this element | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [CallConversation](CallConversation.md) | [participant_associations](participant_associations.md) | range | [ParticipantAssociation](ParticipantAssociation.md) |
| [Collaboration](Collaboration.md) | [participant_associations](participant_associations.md) | range | [ParticipantAssociation](ParticipantAssociation.md) |
| [GlobalConversation](GlobalConversation.md) | [participant_associations](participant_associations.md) | range | [ParticipantAssociation](ParticipantAssociation.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ParticipantAssociation.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ParticipantAssociation |
| native | fluxnova_bpm_platform:ParticipantAssociation |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ParticipantAssociation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ParticipantAssociation.java
description: The BPMN participantAssociation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- inner_participant
- outer_participant

```
</details>

### Induced

<details>
```yaml
name: ParticipantAssociation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ParticipantAssociation.java
description: The BPMN participantAssociation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  inner_participant:
    name: inner_participant
    description: The inner participant of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantAssociation
    domain_of:
    - ParticipantAssociation
    range: Participant
  outer_participant:
    name: outer_participant
    description: The outer participant of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantAssociation
    domain_of:
    - ParticipantAssociation
    range: Participant
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: ParticipantAssociation
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
  documentations:
    name: documentations
    description: Collection of documentation elements associated with this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantAssociation
    domain_of:
    - BaseElement
    range: Documentation
    multivalued: true
    inlined: true
    inlined_as_list: true
  extension_elements:
    name: extension_elements
    description: Extension elements holding vendor-specific metadata.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantAssociation
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantAssociation
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantAssociation
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>