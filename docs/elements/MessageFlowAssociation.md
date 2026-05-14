---
search:
  boost: 10.0
---

# Class: MessageFlowAssociation 


_The BPMN messageFlowAssociation element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:MessageFlowAssociation](https://w3id.org/TD-Universe/fluxnova-bpm-platform/MessageFlowAssociation)





```mermaid
 classDiagram
    class MessageFlowAssociation
    click MessageFlowAssociation href "../MessageFlowAssociation/"
      BaseElement <|-- MessageFlowAssociation
        click BaseElement href "../BaseElement/"
      
      MessageFlowAssociation : diagram_element
        
          
    
        
        
        MessageFlowAssociation --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      MessageFlowAssociation : documentations
        
          
    
        
        
        MessageFlowAssociation --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      MessageFlowAssociation : extension_elements
        
          
    
        
        
        MessageFlowAssociation --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      MessageFlowAssociation : id
        
      MessageFlowAssociation : inner_message_flow
        
          
    
        
        
        MessageFlowAssociation --> "0..1" MessageFlow : inner_message_flow
        click MessageFlow href "../MessageFlow/"
    

        
      MessageFlowAssociation : outer_message_flow
        
          
    
        
        
        MessageFlowAssociation --> "0..1" MessageFlow : outer_message_flow
        click MessageFlow href "../MessageFlow/"
    

        
      MessageFlowAssociation : scope
        
          
    
        
        
        MessageFlowAssociation --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **MessageFlowAssociation**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [inner_message_flow](inner_message_flow.md) | 0..1 <br/> [MessageFlow](MessageFlow.md) | The inner message flow of this element | direct |
| [outer_message_flow](outer_message_flow.md) | 0..1 <br/> [MessageFlow](MessageFlow.md) | The outer message flow of this element | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Collaboration](Collaboration.md) | [message_flow_associations](message_flow_associations.md) | range | [MessageFlowAssociation](MessageFlowAssociation.md) |
| [GlobalConversation](GlobalConversation.md) | [message_flow_associations](message_flow_associations.md) | range | [MessageFlowAssociation](MessageFlowAssociation.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/MessageFlowAssociation.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:MessageFlowAssociation |
| native | fluxnova_bpm_platform:MessageFlowAssociation |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: MessageFlowAssociation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/MessageFlowAssociation.java
description: The BPMN messageFlowAssociation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- inner_message_flow
- outer_message_flow

```
</details>

### Induced

<details>
```yaml
name: MessageFlowAssociation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/MessageFlowAssociation.java
description: The BPMN messageFlowAssociation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  inner_message_flow:
    name: inner_message_flow
    description: The inner message flow of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: MessageFlowAssociation
    domain_of:
    - MessageFlowAssociation
    range: MessageFlow
  outer_message_flow:
    name: outer_message_flow
    description: The outer message flow of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: MessageFlowAssociation
    domain_of:
    - MessageFlowAssociation
    range: MessageFlow
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: MessageFlowAssociation
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
    owner: MessageFlowAssociation
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
    owner: MessageFlowAssociation
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: MessageFlowAssociation
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: MessageFlowAssociation
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>