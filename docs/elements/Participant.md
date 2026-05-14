---
search:
  boost: 10.0
---

# Class: Participant 


_The BPMN participant element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:Participant](https://w3id.org/TD-Universe/fluxnova-bpm-platform/Participant)





```mermaid
 classDiagram
    class Participant
    click Participant href "../Participant/"
      InteractionNode <|-- Participant
        click InteractionNode href "../InteractionNode/"
      BaseElement <|-- Participant
        click BaseElement href "../BaseElement/"
      
      Participant : diagram_element
        
          
    
        
        
        Participant --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      Participant : documentations
        
          
    
        
        
        Participant --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      Participant : end_points
        
          
    
        
        
        Participant --> "*" EndPoint : end_points
        click EndPoint href "../EndPoint/"
    

        
      Participant : extension_elements
        
          
    
        
        
        Participant --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      Participant : id
        
      Participant : interfaces
        
          
    
        
        
        Participant --> "*" Interface : interfaces
        click Interface href "../Interface/"
    

        
      Participant : name
        
      Participant : participant_multiplicity
        
          
    
        
        
        Participant --> "0..1" ParticipantMultiplicity : participant_multiplicity
        click ParticipantMultiplicity href "../ParticipantMultiplicity/"
    

        
      Participant : process
        
          
    
        
        
        Participant --> "0..1" Process : process
        click Process href "../Process/"
    

        
      Participant : scope
        
          
    
        
        
        Participant --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **Participant** [ [InteractionNode](InteractionNode.md)]


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | direct |
| [process](process.md) | 0..1 <br/> [Process](Process.md) | The process of this element | direct |
| [interfaces](interfaces.md) | * <br/> [Interface](Interface.md) | Collection of interface elements associated with this element | direct |
| [end_points](end_points.md) | * <br/> [EndPoint](EndPoint.md) | Endpoints associated with this process or service | direct |
| [participant_multiplicity](participant_multiplicity.md) | 0..1 <br/> [ParticipantMultiplicity](ParticipantMultiplicity.md) | Multiplicity configuration of this participant | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [InteractionNode](InteractionNode.md), [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [CallConversation](CallConversation.md) | [participants](participants.md) | range | [Participant](Participant.md) |
| [Collaboration](Collaboration.md) | [participants](participants.md) | range | [Participant](Participant.md) |
| [Conversation](Conversation.md) | [participants](participants.md) | range | [Participant](Participant.md) |
| [ConversationNode](ConversationNode.md) | [participants](participants.md) | range | [Participant](Participant.md) |
| [GlobalConversation](GlobalConversation.md) | [participants](participants.md) | range | [Participant](Participant.md) |
| [ParticipantAssociation](ParticipantAssociation.md) | [inner_participant](inner_participant.md) | range | [Participant](Participant.md) |
| [ParticipantAssociation](ParticipantAssociation.md) | [outer_participant](outer_participant.md) | range | [Participant](Participant.md) |
| [SubConversation](SubConversation.md) | [participants](participants.md) | range | [Participant](Participant.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Participant.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:Participant |
| native | fluxnova_bpm_platform:Participant |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: Participant
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Participant.java
description: The BPMN participant element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
mixins:
- InteractionNode
slots:
- name
- process
- interfaces
- end_points
- participant_multiplicity

```
</details>

### Induced

<details>
```yaml
name: Participant
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Participant.java
description: The BPMN participant element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
mixins:
- InteractionNode
attributes:
  name:
    name: name
    description: Human-readable name.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:name
    owner: Participant
    domain_of:
    - ByteArray
    - MeterLog
    - Property
    - Group
    - Tenant
    - Task
    - VariableInstance
    - Attachment
    - Filter
    - Deployment
    - ResourceDefinition
    - HistoricDetail
    - HistoricTaskInstance
    - HistoricVariableInstance
    - Font
    - Diagram
    - CallableElement
    - Category
    - Collaboration
    - ConversationLink
    - ConversationNode
    - CorrelationKey
    - CorrelationProperty
    - DataInput
    - DataOutput
    - DataState
    - DataStore
    - Definitions
    - Error
    - Escalation
    - FlowElement
    - InputSet
    - Interface
    - Lane
    - LaneSet
    - LinkEventDefinition
    - Message
    - MessageFlow
    - Operation
    - OutputSet
    - Participant
    - BpmnProperty
    - Resource
    - ResourceParameter
    - ResourceRole
    - Signal
    range: string
  process:
    name: process
    description: The process of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Participant
    domain_of:
    - Participant
    range: Process
  interfaces:
    name: interfaces
    description: Collection of interface elements associated with this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Participant
    domain_of:
    - Participant
    range: Interface
    multivalued: true
    inlined: true
    inlined_as_list: true
  end_points:
    name: end_points
    description: Endpoints associated with this process or service.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Participant
    domain_of:
    - Participant
    range: EndPoint
    multivalued: true
    inlined: true
    inlined_as_list: true
  participant_multiplicity:
    name: participant_multiplicity
    description: Multiplicity configuration of this participant.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Participant
    domain_of:
    - Participant
    range: ParticipantMultiplicity
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: Participant
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
    owner: Participant
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
    owner: Participant
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Participant
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Participant
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>