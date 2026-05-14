---
search:
  boost: 10.0
---

# Class: InputDataItem 


_The BPMN 2.0 inputDataItem from the tMultiInstanceLoopCharacteristics type_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:InputDataItem](https://w3id.org/TD-Universe/fluxnova-bpm-platform/InputDataItem)





```mermaid
 classDiagram
    class InputDataItem
    click InputDataItem href "../InputDataItem/"
      DataInput <|-- InputDataItem
        click DataInput href "../DataInput/"
      
      InputDataItem : collection
        
      InputDataItem : data_state
        
          
    
        
        
        InputDataItem --> "0..1" DataState : data_state
        click DataState href "../DataState/"
    

        
      InputDataItem : diagram_element
        
          
    
        
        
        InputDataItem --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      InputDataItem : documentations
        
          
    
        
        
        InputDataItem --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      InputDataItem : extension_elements
        
          
    
        
        
        InputDataItem --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      InputDataItem : id
        
      InputDataItem : item_subject
        
          
    
        
        
        InputDataItem --> "0..1" ItemDefinition : item_subject
        click ItemDefinition href "../ItemDefinition/"
    

        
      InputDataItem : name
        
      InputDataItem : scope
        
          
    
        
        
        InputDataItem --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [ItemAwareElement](ItemAwareElement.md)
            * [DataInput](DataInput.md)
                * **InputDataItem**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | [DataInput](DataInput.md) |
| [collection](collection.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether collection | [DataInput](DataInput.md) |
| [item_subject](item_subject.md) | 0..1 <br/> [ItemDefinition](ItemDefinition.md) | The item subject of this element | [ItemAwareElement](ItemAwareElement.md) |
| [data_state](data_state.md) | 0..1 <br/> [DataState](DataState.md) | Current state of this data object or data store reference | [ItemAwareElement](ItemAwareElement.md) |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [MultiInstanceLoopCharacteristics](MultiInstanceLoopCharacteristics.md) | [input_data_item](input_data_item.md) | range | [InputDataItem](InputDataItem.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/InputDataItem.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:InputDataItem |
| native | fluxnova_bpm_platform:InputDataItem |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: InputDataItem
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/InputDataItem.java
description: The BPMN 2.0 inputDataItem from the tMultiInstanceLoopCharacteristics
  type
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: DataInput

```
</details>

### Induced

<details>
```yaml
name: InputDataItem
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/InputDataItem.java
description: The BPMN 2.0 inputDataItem from the tMultiInstanceLoopCharacteristics
  type
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: DataInput
attributes:
  name:
    name: name
    description: Human-readable name.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:name
    owner: InputDataItem
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
  collection:
    name: collection
    description: Whether collection.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputDataItem
    domain_of:
    - DataInput
    - DataObject
    - DataOutput
    - ItemDefinition
    range: boolean
  item_subject:
    name: item_subject
    description: The item subject of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputDataItem
    domain_of:
    - ItemAwareElement
    range: ItemDefinition
  data_state:
    name: data_state
    description: Current state of this data object or data store reference.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputDataItem
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
    owner: InputDataItem
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
    owner: InputDataItem
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
    owner: InputDataItem
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputDataItem
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputDataItem
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>