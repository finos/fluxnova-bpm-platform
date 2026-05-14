---
search:
  boost: 10.0
---

# Class: SubConversation 


_The BPMN subConversation element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:SubConversation](https://w3id.org/TD-Universe/fluxnova-bpm-platform/SubConversation)





```mermaid
 classDiagram
    class SubConversation
    click SubConversation href "../SubConversation/"
      ConversationNode <|-- SubConversation
        click ConversationNode href "../ConversationNode/"
      
      SubConversation : conversation_nodes
        
          
    
        
        
        SubConversation --> "*" ConversationNode : conversation_nodes
        click ConversationNode href "../ConversationNode/"
    

        
      SubConversation : correlation_keys
        
          
    
        
        
        SubConversation --> "*" CorrelationKey : correlation_keys
        click CorrelationKey href "../CorrelationKey/"
    

        
      SubConversation : diagram_element
        
          
    
        
        
        SubConversation --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      SubConversation : documentations
        
          
    
        
        
        SubConversation --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      SubConversation : extension_elements
        
          
    
        
        
        SubConversation --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      SubConversation : id
        
      SubConversation : message_flows
        
          
    
        
        
        SubConversation --> "*" MessageFlow : message_flows
        click MessageFlow href "../MessageFlow/"
    

        
      SubConversation : name
        
      SubConversation : participants
        
          
    
        
        
        SubConversation --> "*" Participant : participants
        click Participant href "../Participant/"
    

        
      SubConversation : scope
        
          
    
        
        
        SubConversation --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [ConversationNode](ConversationNode.md) [ [InteractionNode](InteractionNode.md)]
            * **SubConversation**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [conversation_nodes](conversation_nodes.md) | * <br/> [ConversationNode](ConversationNode.md) | Conversation nodes in this collaboration | direct |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | [ConversationNode](ConversationNode.md) |
| [participants](participants.md) | * <br/> [Participant](Participant.md) | Participants (pools) in this collaboration | [ConversationNode](ConversationNode.md) |
| [message_flows](message_flows.md) | * <br/> [MessageFlow](MessageFlow.md) | Message flows between participants in this collaboration | [ConversationNode](ConversationNode.md) |
| [correlation_keys](correlation_keys.md) | * <br/> [CorrelationKey](CorrelationKey.md) | Correlation keys used to correlate messages in this collaboration | [ConversationNode](ConversationNode.md) |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [InteractionNode](InteractionNode.md), [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/SubConversation.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:SubConversation |
| native | fluxnova_bpm_platform:SubConversation |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: SubConversation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/SubConversation.java
description: The BPMN subConversation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: ConversationNode
slots:
- conversation_nodes

```
</details>

### Induced

<details>
```yaml
name: SubConversation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/SubConversation.java
description: The BPMN subConversation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: ConversationNode
attributes:
  conversation_nodes:
    name: conversation_nodes
    description: Conversation nodes in this collaboration.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SubConversation
    domain_of:
    - Collaboration
    - SubConversation
    range: ConversationNode
    multivalued: true
    inlined: true
    inlined_as_list: true
  name:
    name: name
    description: Human-readable name.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:name
    owner: SubConversation
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
    owner: SubConversation
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
    owner: SubConversation
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
    owner: SubConversation
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
    owner: SubConversation
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
    owner: SubConversation
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
    owner: SubConversation
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SubConversation
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SubConversation
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>