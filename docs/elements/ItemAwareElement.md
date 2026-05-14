---
search:
  boost: 10.0
---

# Class: ItemAwareElement 


_The BPMN itemAwareElement element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ItemAwareElement](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ItemAwareElement)





```mermaid
 classDiagram
    class ItemAwareElement
    click ItemAwareElement href "../ItemAwareElement/"
      BaseElement <|-- ItemAwareElement
        click BaseElement href "../BaseElement/"
      

      ItemAwareElement <|-- DataInput
        click DataInput href "../DataInput/"
      ItemAwareElement <|-- DataObject
        click DataObject href "../DataObject/"
      ItemAwareElement <|-- DataObjectReference
        click DataObjectReference href "../DataObjectReference/"
      ItemAwareElement <|-- DataOutput
        click DataOutput href "../DataOutput/"
      ItemAwareElement <|-- DataStore
        click DataStore href "../DataStore/"
      ItemAwareElement <|-- DataStoreReference
        click DataStoreReference href "../DataStoreReference/"
      ItemAwareElement <|-- BpmnProperty
        click BpmnProperty href "../BpmnProperty/"
      

      ItemAwareElement : data_state
        
          
    
        
        
        ItemAwareElement --> "0..1" DataState : data_state
        click DataState href "../DataState/"
    

        
      ItemAwareElement : diagram_element
        
          
    
        
        
        ItemAwareElement --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      ItemAwareElement : documentations
        
          
    
        
        
        ItemAwareElement --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      ItemAwareElement : extension_elements
        
          
    
        
        
        ItemAwareElement --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      ItemAwareElement : id
        
      ItemAwareElement : item_subject
        
          
    
        
        
        ItemAwareElement --> "0..1" ItemDefinition : item_subject
        click ItemDefinition href "../ItemDefinition/"
    

        
      ItemAwareElement : scope
        
          
    
        
        
        ItemAwareElement --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **ItemAwareElement**
            * [DataInput](DataInput.md)
            * [DataOutput](DataOutput.md)
            * [BpmnProperty](BpmnProperty.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [item_subject](item_subject.md) | 0..1 <br/> [ItemDefinition](ItemDefinition.md) | The item subject of this element | direct |
| [data_state](data_state.md) | 0..1 <br/> [DataState](DataState.md) | Current state of this data object or data store reference | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [DataAssociation](DataAssociation.md) | [sources](sources.md) | range | [ItemAwareElement](ItemAwareElement.md) |
| [DataAssociation](DataAssociation.md) | [target](target.md) | range | [ItemAwareElement](ItemAwareElement.md) |
| [DataInputAssociation](DataInputAssociation.md) | [sources](sources.md) | range | [ItemAwareElement](ItemAwareElement.md) |
| [DataInputAssociation](DataInputAssociation.md) | [target](target.md) | range | [ItemAwareElement](ItemAwareElement.md) |
| [DataOutputAssociation](DataOutputAssociation.md) | [sources](sources.md) | range | [ItemAwareElement](ItemAwareElement.md) |
| [DataOutputAssociation](DataOutputAssociation.md) | [target](target.md) | range | [ItemAwareElement](ItemAwareElement.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ItemAwareElement.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ItemAwareElement |
| native | fluxnova_bpm_platform:ItemAwareElement |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ItemAwareElement
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ItemAwareElement.java
description: The BPMN itemAwareElement element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- item_subject
- data_state

```
</details>

### Induced

<details>
```yaml
name: ItemAwareElement
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ItemAwareElement.java
description: The BPMN itemAwareElement element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  item_subject:
    name: item_subject
    description: The item subject of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ItemAwareElement
    domain_of:
    - ItemAwareElement
    range: ItemDefinition
  data_state:
    name: data_state
    description: Current state of this data object or data store reference.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ItemAwareElement
    domain_of:
    - ItemAwareElement
    range: DataState
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: ItemAwareElement
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
    owner: ItemAwareElement
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
    owner: ItemAwareElement
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ItemAwareElement
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ItemAwareElement
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>