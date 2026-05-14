---
search:
  boost: 10.0
---

# Class: FluxnovaErrorEventDefinition 


_Fluxnova extension that augments an end event error definition with engine-specific variables._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaErrorEventDefinition](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaErrorEventDefinition)





```mermaid
 classDiagram
    class FluxnovaErrorEventDefinition
    click FluxnovaErrorEventDefinition href "../FluxnovaErrorEventDefinition/"
      ErrorEventDefinition <|-- FluxnovaErrorEventDefinition
        click ErrorEventDefinition href "../ErrorEventDefinition/"
      
      FluxnovaErrorEventDefinition : diagram_element
        
          
    
        
        
        FluxnovaErrorEventDefinition --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      FluxnovaErrorEventDefinition : documentations
        
          
    
        
        
        FluxnovaErrorEventDefinition --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      FluxnovaErrorEventDefinition : error
        
          
    
        
        
        FluxnovaErrorEventDefinition --> "0..1" Error : error
        click Error href "../Error/"
    

        
      FluxnovaErrorEventDefinition : extension_elements
        
          
    
        
        
        FluxnovaErrorEventDefinition --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      FluxnovaErrorEventDefinition : fluxnova_error_code_variable
        
      FluxnovaErrorEventDefinition : fluxnova_error_message_variable
        
      FluxnovaErrorEventDefinition : fluxnova_expression
        
      FluxnovaErrorEventDefinition : id
        
      FluxnovaErrorEventDefinition : scope
        
          
    
        
        
        FluxnovaErrorEventDefinition --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [RootElement](RootElement.md)
            * [EventDefinition](EventDefinition.md)
                * [ErrorEventDefinition](ErrorEventDefinition.md)
                    * **FluxnovaErrorEventDefinition**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_expression](fluxnova_expression.md) | 0..1 <br/> [String](String.md) | EL expression for this element | direct |
| [error](error.md) | 0..1 <br/> [Error](Error.md) | The error of this element | [ErrorEventDefinition](ErrorEventDefinition.md) |
| [fluxnova_error_code_variable](fluxnova_error_code_variable.md) | 0..1 <br/> [String](String.md) | Process variable to receive the error code | [ErrorEventDefinition](ErrorEventDefinition.md) |
| [fluxnova_error_message_variable](fluxnova_error_message_variable.md) | 0..1 <br/> [String](String.md) | Process variable to receive the error message | [ErrorEventDefinition](ErrorEventDefinition.md) |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaErrorEventDefinition.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaErrorEventDefinition |
| native | fluxnova_bpm_platform:FluxnovaErrorEventDefinition |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaErrorEventDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaErrorEventDefinition.java
description: Fluxnova extension that augments an end event error definition with engine-specific
  variables.
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: ErrorEventDefinition
slots:
- fluxnova_expression

```
</details>

### Induced

<details>
```yaml
name: FluxnovaErrorEventDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaErrorEventDefinition.java
description: Fluxnova extension that augments an end event error definition with engine-specific
  variables.
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: ErrorEventDefinition
attributes:
  fluxnova_expression:
    name: fluxnova_expression
    description: EL expression for this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaErrorEventDefinition
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - SendTask
    - ServiceTask
    - FluxnovaErrorEventDefinition
    - FluxnovaExecutionListener
    - FluxnovaField
    - FluxnovaFormProperty
    - FluxnovaTaskListener
    range: string
  error:
    name: error
    description: The error of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaErrorEventDefinition
    domain_of:
    - ErrorEventDefinition
    range: Error
  fluxnova_error_code_variable:
    name: fluxnova_error_code_variable
    description: Process variable to receive the error code.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaErrorEventDefinition
    domain_of:
    - ErrorEventDefinition
    range: string
  fluxnova_error_message_variable:
    name: fluxnova_error_message_variable
    description: Process variable to receive the error message.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaErrorEventDefinition
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
    owner: FluxnovaErrorEventDefinition
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
    owner: FluxnovaErrorEventDefinition
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
    owner: FluxnovaErrorEventDefinition
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaErrorEventDefinition
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaErrorEventDefinition
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>