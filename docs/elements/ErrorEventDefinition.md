---
search:
  boost: 10.0
---

# Class: ErrorEventDefinition 


_The BPMN errorEventDefinition element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ErrorEventDefinition](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ErrorEventDefinition)





```mermaid
 classDiagram
    class ErrorEventDefinition
    click ErrorEventDefinition href "../ErrorEventDefinition/"
      EventDefinition <|-- ErrorEventDefinition
        click EventDefinition href "../EventDefinition/"
      

      ErrorEventDefinition <|-- FluxnovaErrorEventDefinition
        click FluxnovaErrorEventDefinition href "../FluxnovaErrorEventDefinition/"
      

      ErrorEventDefinition : diagram_element
        
          
    
        
        
        ErrorEventDefinition --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      ErrorEventDefinition : documentations
        
          
    
        
        
        ErrorEventDefinition --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      ErrorEventDefinition : error
        
          
    
        
        
        ErrorEventDefinition --> "0..1" Error : error
        click Error href "../Error/"
    

        
      ErrorEventDefinition : extension_elements
        
          
    
        
        
        ErrorEventDefinition --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      ErrorEventDefinition : fluxnova_error_code_variable
        
      ErrorEventDefinition : fluxnova_error_message_variable
        
      ErrorEventDefinition : id
        
      ErrorEventDefinition : scope
        
          
    
        
        
        ErrorEventDefinition --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [RootElement](RootElement.md)
            * [EventDefinition](EventDefinition.md)
                * **ErrorEventDefinition**
                    * [FluxnovaErrorEventDefinition](FluxnovaErrorEventDefinition.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [error](error.md) | 0..1 <br/> [Error](Error.md) | The error of this element | direct |
| [fluxnova_error_code_variable](fluxnova_error_code_variable.md) | 0..1 <br/> [String](String.md) | Process variable to receive the error code | direct |
| [fluxnova_error_message_variable](fluxnova_error_message_variable.md) | 0..1 <br/> [String](String.md) | Process variable to receive the error message | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
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
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ErrorEventDefinition.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ErrorEventDefinition |
| native | fluxnova_bpm_platform:ErrorEventDefinition |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ErrorEventDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ErrorEventDefinition.java
description: The BPMN errorEventDefinition element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: EventDefinition
slots:
- error
- fluxnova_error_code_variable
- fluxnova_error_message_variable

```
</details>

### Induced

<details>
```yaml
name: ErrorEventDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ErrorEventDefinition.java
description: The BPMN errorEventDefinition element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: EventDefinition
attributes:
  error:
    name: error
    description: The error of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ErrorEventDefinition
    domain_of:
    - ErrorEventDefinition
    range: Error
  fluxnova_error_code_variable:
    name: fluxnova_error_code_variable
    description: Process variable to receive the error code.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ErrorEventDefinition
    domain_of:
    - ErrorEventDefinition
    range: string
  fluxnova_error_message_variable:
    name: fluxnova_error_message_variable
    description: Process variable to receive the error message.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ErrorEventDefinition
    domain_of:
    - ErrorEventDefinition
    range: string
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: ErrorEventDefinition
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
    owner: ErrorEventDefinition
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
    owner: ErrorEventDefinition
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ErrorEventDefinition
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ErrorEventDefinition
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>