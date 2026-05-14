---
search:
  boost: 10.0
---

# Class: RootElement 


_The BPMN rootElement element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:RootElement](https://w3id.org/TD-Universe/fluxnova-bpm-platform/RootElement)





```mermaid
 classDiagram
    class RootElement
    click RootElement href "../RootElement/"
      BaseElement <|-- RootElement
        click BaseElement href "../BaseElement/"
      

      RootElement <|-- CallableElement
        click CallableElement href "../CallableElement/"
      RootElement <|-- Category
        click Category href "../Category/"
      RootElement <|-- Collaboration
        click Collaboration href "../Collaboration/"
      RootElement <|-- CorrelationProperty
        click CorrelationProperty href "../CorrelationProperty/"
      RootElement <|-- DataStore
        click DataStore href "../DataStore/"
      RootElement <|-- EndPoint
        click EndPoint href "../EndPoint/"
      RootElement <|-- Error
        click Error href "../Error/"
      RootElement <|-- Escalation
        click Escalation href "../Escalation/"
      RootElement <|-- EventDefinition
        click EventDefinition href "../EventDefinition/"
      RootElement <|-- Interface
        click Interface href "../Interface/"
      RootElement <|-- ItemDefinition
        click ItemDefinition href "../ItemDefinition/"
      RootElement <|-- Message
        click Message href "../Message/"
      RootElement <|-- Resource
        click Resource href "../Resource/"
      RootElement <|-- Signal
        click Signal href "../Signal/"
      

      RootElement : diagram_element
        
          
    
        
        
        RootElement --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      RootElement : documentations
        
          
    
        
        
        RootElement --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      RootElement : extension_elements
        
          
    
        
        
        RootElement --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      RootElement : id
        
      RootElement : scope
        
          
    
        
        
        RootElement --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **RootElement**
            * [CallableElement](CallableElement.md)
            * [Category](Category.md)
            * [Collaboration](Collaboration.md)
            * [CorrelationProperty](CorrelationProperty.md)
            * [DataStore](DataStore.md) [ [ItemAwareElement](ItemAwareElement.md)]
            * [EndPoint](EndPoint.md)
            * [Error](Error.md)
            * [Escalation](Escalation.md)
            * [EventDefinition](EventDefinition.md)
            * [Interface](Interface.md)
            * [ItemDefinition](ItemDefinition.md)
            * [Message](Message.md)
            * [Resource](Resource.md)
            * [Signal](Signal.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Definitions](Definitions.md) | [root_elements](root_elements.md) | range | [RootElement](RootElement.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/RootElement.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:RootElement |
| native | fluxnova_bpm_platform:RootElement |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: RootElement
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/RootElement.java
description: The BPMN rootElement element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement

```
</details>

### Induced

<details>
```yaml
name: RootElement
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/RootElement.java
description: The BPMN rootElement element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: RootElement
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
    owner: RootElement
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
    owner: RootElement
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: RootElement
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: RootElement
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>