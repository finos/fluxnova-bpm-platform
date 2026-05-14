---
search:
  boost: 10.0
---

# Class: ItemDefinition 


_The BPMN itemDefinition element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ItemDefinition](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ItemDefinition)





```mermaid
 classDiagram
    class ItemDefinition
    click ItemDefinition href "../ItemDefinition/"
      RootElement <|-- ItemDefinition
        click RootElement href "../RootElement/"
      
      ItemDefinition : collection
        
      ItemDefinition : diagram_element
        
          
    
        
        
        ItemDefinition --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      ItemDefinition : documentations
        
          
    
        
        
        ItemDefinition --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      ItemDefinition : extension_elements
        
          
    
        
        
        ItemDefinition --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      ItemDefinition : id
        
      ItemDefinition : item_kind
        
      ItemDefinition : scope
        
          
    
        
        
        ItemDefinition --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      ItemDefinition : structure_ref
        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [RootElement](RootElement.md)
            * **ItemDefinition**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [structure_ref](structure_ref.md) | 0..1 <br/> [String](String.md) | The item definition describing the data structure | direct |
| [collection](collection.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether collection | direct |
| [item_kind](item_kind.md) | 0..1 <br/> [String](String.md) | The item kind of this element | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [ConditionExpression](ConditionExpression.md) | [evaluates_to_type](evaluates_to_type.md) | range | [ItemDefinition](ItemDefinition.md) |
| [CorrelationProperty](CorrelationProperty.md) | [type](type.md) | range | [ItemDefinition](ItemDefinition.md) |
| [DataInput](DataInput.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [DataObject](DataObject.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [DataObjectReference](DataObjectReference.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [DataOutput](DataOutput.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [DataStore](DataStore.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [DataStoreReference](DataStoreReference.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [Error](Error.md) | [structure](structure.md) | range | [ItemDefinition](ItemDefinition.md) |
| [Escalation](Escalation.md) | [structure](structure.md) | range | [ItemDefinition](ItemDefinition.md) |
| [FormalExpression](FormalExpression.md) | [evaluates_to_type](evaluates_to_type.md) | range | [ItemDefinition](ItemDefinition.md) |
| [InputDataItem](InputDataItem.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [ItemAwareElement](ItemAwareElement.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [Message](Message.md) | [item](item.md) | range | [ItemDefinition](ItemDefinition.md) |
| [OutputDataItem](OutputDataItem.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [BpmnProperty](BpmnProperty.md) | [item_subject](item_subject.md) | range | [ItemDefinition](ItemDefinition.md) |
| [ResourceParameter](ResourceParameter.md) | [type](type.md) | range | [ItemDefinition](ItemDefinition.md) |
| [Signal](Signal.md) | [structure](structure.md) | range | [ItemDefinition](ItemDefinition.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ItemDefinition.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ItemDefinition |
| native | fluxnova_bpm_platform:ItemDefinition |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ItemDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ItemDefinition.java
description: The BPMN itemDefinition element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: RootElement
slots:
- structure_ref
- collection
- item_kind

```
</details>

### Induced

<details>
```yaml
name: ItemDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ItemDefinition.java
description: The BPMN itemDefinition element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: RootElement
attributes:
  structure_ref:
    name: structure_ref
    description: The item definition describing the data structure.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ItemDefinition
    domain_of:
    - ItemDefinition
    range: string
  collection:
    name: collection
    description: Whether collection.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ItemDefinition
    domain_of:
    - DataInput
    - DataObject
    - DataOutput
    - ItemDefinition
    range: boolean
  item_kind:
    name: item_kind
    description: The item kind of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ItemDefinition
    domain_of:
    - ItemDefinition
    range: string
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: ItemDefinition
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
    owner: ItemDefinition
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
    owner: ItemDefinition
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ItemDefinition
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ItemDefinition
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>