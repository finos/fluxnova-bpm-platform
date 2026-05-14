---
search:
  boost: 10.0
---

# Class: ConversationNode 


_The BPMN conversationNode element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ConversationNode](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ConversationNode)





```mermaid
 classDiagram
    class ConversationNode
    click ConversationNode href "../ConversationNode/"
      InteractionNode <|-- ConversationNode
        click InteractionNode href "../InteractionNode/"
      BaseElement <|-- ConversationNode
        click BaseElement href "../BaseElement/"
      

      ConversationNode <|-- CallConversation
        click CallConversation href "../CallConversation/"
      ConversationNode <|-- Conversation
        click Conversation href "../Conversation/"
      ConversationNode <|-- SubConversation
        click SubConversation href "../SubConversation/"
      

      ConversationNode : correlation_keys
        
          
    
        
        
        ConversationNode --> "*" CorrelationKey : correlation_keys
        click CorrelationKey href "../CorrelationKey/"
    

        
      ConversationNode : diagram_element
        
          
    
        
        
        ConversationNode --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      ConversationNode : documentations
        
          
    
        
        
        ConversationNode --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      ConversationNode : extension_elements
        
          
    
        
        
        ConversationNode --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      ConversationNode : id
        
      ConversationNode : message_flows
        
          
    
        
        
        ConversationNode --> "*" MessageFlow : message_flows
        click MessageFlow href "../MessageFlow/"
    

        
      ConversationNode : name
        
      ConversationNode : participants
        
          
    
        
        
        ConversationNode --> "*" Participant : participants
        click Participant href "../Participant/"
    

        
      ConversationNode : scope
        
          
    
        
        
        ConversationNode --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **ConversationNode** [ [InteractionNode](InteractionNode.md)]
            * [CallConversation](CallConversation.md)
            * [Conversation](Conversation.md)
            * [SubConversation](SubConversation.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | direct |
| [participants](participants.md) | * <br/> [Participant](Participant.md) | Participants (pools) in this collaboration | direct |
| [message_flows](message_flows.md) | * <br/> [MessageFlow](MessageFlow.md) | Message flows between participants in this collaboration | direct |
| [correlation_keys](correlation_keys.md) | * <br/> [CorrelationKey](CorrelationKey.md) | Correlation keys used to correlate messages in this collaboration | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [InteractionNode](InteractionNode.md), [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Collaboration](Collaboration.md) | [conversation_nodes](conversation_nodes.md) | range | [ConversationNode](ConversationNode.md) |
| [ConversationAssociation](ConversationAssociation.md) | [inner_conversation_node](inner_conversation_node.md) | range | [ConversationNode](ConversationNode.md) |
| [ConversationAssociation](ConversationAssociation.md) | [outer_conversation_node](outer_conversation_node.md) | range | [ConversationNode](ConversationNode.md) |
| [GlobalConversation](GlobalConversation.md) | [conversation_nodes](conversation_nodes.md) | range | [ConversationNode](ConversationNode.md) |
| [SubConversation](SubConversation.md) | [conversation_nodes](conversation_nodes.md) | range | [ConversationNode](ConversationNode.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ConversationNode.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ConversationNode |
| native | fluxnova_bpm_platform:ConversationNode |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ConversationNode
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ConversationNode.java
description: The BPMN conversationNode element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
mixins:
- InteractionNode
slots:
- name
- participants
- message_flows
- correlation_keys

```
</details>

### Induced

<details>
```yaml
name: ConversationNode
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ConversationNode.java
description: The BPMN conversationNode element
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
    owner: ConversationNode
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
  participants:
    name: participants
    description: Participants (pools) in this collaboration.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ConversationNode
    domain_of:
    - Collaboration
    - ConversationNode
    range: Participant
    multivalued: true
    inlined: true
    inlined_as_list: true
  message_flows:
    name: message_flows
    description: Message flows between participants in this collaboration.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ConversationNode
    domain_of:
    - Collaboration
    - ConversationNode
    range: MessageFlow
    multivalued: true
    inlined: true
    inlined_as_list: true
  correlation_keys:
    name: correlation_keys
    description: Correlation keys used to correlate messages in this collaboration.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ConversationNode
    domain_of:
    - Collaboration
    - ConversationNode
    range: CorrelationKey
    multivalued: true
    inlined: true
    inlined_as_list: true
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: ConversationNode
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
    owner: ConversationNode
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
    owner: ConversationNode
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ConversationNode
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ConversationNode
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>