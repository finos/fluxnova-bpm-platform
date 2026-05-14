---
search:
  boost: 10.0
---

# Class: IoBinding 


_The BPMN ioBinding element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:IoBinding](https://w3id.org/TD-Universe/fluxnova-bpm-platform/IoBinding)





```mermaid
 classDiagram
    class IoBinding
    click IoBinding href "../IoBinding/"
      BaseElement <|-- IoBinding
        click BaseElement href "../BaseElement/"
      
      IoBinding : diagram_element
        
          
    
        
        
        IoBinding --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      IoBinding : documentations
        
          
    
        
        
        IoBinding --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      IoBinding : extension_elements
        
          
    
        
        
        IoBinding --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      IoBinding : id
        
      IoBinding : input_data
        
          
    
        
        
        IoBinding --> "0..1" DataInput : input_data
        click DataInput href "../DataInput/"
    

        
      IoBinding : operation
        
          
    
        
        
        IoBinding --> "0..1" Operation : operation
        click Operation href "../Operation/"
    

        
      IoBinding : output_data
        
          
    
        
        
        IoBinding --> "0..1" DataOutput : output_data
        click DataOutput href "../DataOutput/"
    

        
      IoBinding : scope
        
          
    
        
        
        IoBinding --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **IoBinding**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [operation](operation.md) | 0..1 <br/> [Operation](Operation.md) | The operation of this element | direct |
| [input_data](input_data.md) | 0..1 <br/> [DataInput](DataInput.md) | The input data of this element | direct |
| [output_data](output_data.md) | 0..1 <br/> [DataOutput](DataOutput.md) | The output data of this element | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [CallableElement](CallableElement.md) | [io_bindings](io_bindings.md) | range | [IoBinding](IoBinding.md) |
| [Process](Process.md) | [io_bindings](io_bindings.md) | range | [IoBinding](IoBinding.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/IoBinding.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:IoBinding |
| native | fluxnova_bpm_platform:IoBinding |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: IoBinding
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/IoBinding.java
description: The BPMN ioBinding element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- operation
- input_data
- output_data

```
</details>

### Induced

<details>
```yaml
name: IoBinding
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/IoBinding.java
description: The BPMN ioBinding element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  operation:
    name: operation
    description: The operation of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: IoBinding
    domain_of:
    - IoBinding
    - MessageEventDefinition
    - ReceiveTask
    - SendTask
    - ServiceTask
    range: Operation
  input_data:
    name: input_data
    description: The input data of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: IoBinding
    domain_of:
    - IoBinding
    range: DataInput
  output_data:
    name: output_data
    description: The output data of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: IoBinding
    domain_of:
    - IoBinding
    range: DataOutput
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: IoBinding
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
    owner: IoBinding
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
    owner: IoBinding
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: IoBinding
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: IoBinding
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>