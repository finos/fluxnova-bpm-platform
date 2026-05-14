---
search:
  boost: 10.0
---

# Class: InputSet 


_The BPMN inputSet element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:InputSet](https://w3id.org/TD-Universe/fluxnova-bpm-platform/InputSet)





```mermaid
 classDiagram
    class InputSet
    click InputSet href "../InputSet/"
      BaseElement <|-- InputSet
        click BaseElement href "../BaseElement/"
      
      InputSet : data_inputs
        
          
    
        
        
        InputSet --> "*" DataInput : data_inputs
        click DataInput href "../DataInput/"
    

        
      InputSet : diagram_element
        
          
    
        
        
        InputSet --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      InputSet : documentations
        
          
    
        
        
        InputSet --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      InputSet : extension_elements
        
          
    
        
        
        InputSet --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      InputSet : id
        
      InputSet : name
        
      InputSet : optional_inputs
        
          
    
        
        
        InputSet --> "*" DataInput : optional_inputs
        click DataInput href "../DataInput/"
    

        
      InputSet : output_sets
        
          
    
        
        
        InputSet --> "*" OutputSet : output_sets
        click OutputSet href "../OutputSet/"
    

        
      InputSet : scope
        
          
    
        
        
        InputSet --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      InputSet : while_executing_input
        
          
    
        
        
        InputSet --> "*" DataInput : while_executing_input
        click DataInput href "../DataInput/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **InputSet**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | direct |
| [data_inputs](data_inputs.md) | * <br/> [DataInput](DataInput.md) | Input data elements of this specification | direct |
| [optional_inputs](optional_inputs.md) | * <br/> [DataInput](DataInput.md) | Collection of data input elements associated with this element | direct |
| [while_executing_input](while_executing_input.md) | * <br/> [DataInput](DataInput.md) | Collection of data input elements associated with this element | direct |
| [output_sets](output_sets.md) | * <br/> [OutputSet](OutputSet.md) | Output sets grouping produced output data | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [EndEvent](EndEvent.md) | [input_set](input_set.md) | range | [InputSet](InputSet.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [input_set](input_set.md) | range | [InputSet](InputSet.md) |
| [IoSpecification](IoSpecification.md) | [input_sets](input_sets.md) | range | [InputSet](InputSet.md) |
| [OutputSet](OutputSet.md) | [input_set_refs](input_set_refs.md) | range | [InputSet](InputSet.md) |
| [ThrowEvent](ThrowEvent.md) | [input_set](input_set.md) | range | [InputSet](InputSet.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/InputSet.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:InputSet |
| native | fluxnova_bpm_platform:InputSet |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: InputSet
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/InputSet.java
description: The BPMN inputSet element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- name
- data_inputs
- optional_inputs
- while_executing_input
- output_sets

```
</details>

### Induced

<details>
```yaml
name: InputSet
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/InputSet.java
description: The BPMN inputSet element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  name:
    name: name
    description: Human-readable name.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:name
    owner: InputSet
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
  data_inputs:
    name: data_inputs
    description: Input data elements of this specification.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputSet
    domain_of:
    - InputSet
    - IoSpecification
    - ThrowEvent
    range: DataInput
    multivalued: true
    inlined: true
    inlined_as_list: true
  optional_inputs:
    name: optional_inputs
    description: Collection of data input elements associated with this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputSet
    domain_of:
    - InputSet
    range: DataInput
    multivalued: true
    inlined: true
    inlined_as_list: true
  while_executing_input:
    name: while_executing_input
    description: Collection of data input elements associated with this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputSet
    domain_of:
    - InputSet
    range: DataInput
    multivalued: true
    inlined: true
    inlined_as_list: true
  output_sets:
    name: output_sets
    description: Output sets grouping produced output data.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputSet
    domain_of:
    - InputSet
    - IoSpecification
    range: OutputSet
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
    owner: InputSet
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
    owner: InputSet
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
    owner: InputSet
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputSet
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: InputSet
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>