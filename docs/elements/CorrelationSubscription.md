---
search:
  boost: 10.0
---

# Class: CorrelationSubscription 


_The BPMN correlationSubscription element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:CorrelationSubscription](https://w3id.org/TD-Universe/fluxnova-bpm-platform/CorrelationSubscription)





```mermaid
 classDiagram
    class CorrelationSubscription
    click CorrelationSubscription href "../CorrelationSubscription/"
      BaseElement <|-- CorrelationSubscription
        click BaseElement href "../BaseElement/"
      
      CorrelationSubscription : correlation_key
        
          
    
        
        
        CorrelationSubscription --> "0..1" CorrelationKey : correlation_key
        click CorrelationKey href "../CorrelationKey/"
    

        
      CorrelationSubscription : correlation_property_bindings
        
          
    
        
        
        CorrelationSubscription --> "*" CorrelationPropertyBinding : correlation_property_bindings
        click CorrelationPropertyBinding href "../CorrelationPropertyBinding/"
    

        
      CorrelationSubscription : diagram_element
        
          
    
        
        
        CorrelationSubscription --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      CorrelationSubscription : documentations
        
          
    
        
        
        CorrelationSubscription --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      CorrelationSubscription : extension_elements
        
          
    
        
        
        CorrelationSubscription --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      CorrelationSubscription : id
        
      CorrelationSubscription : scope
        
          
    
        
        
        CorrelationSubscription --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **CorrelationSubscription**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [correlation_key](correlation_key.md) | 0..1 <br/> [CorrelationKey](CorrelationKey.md) | Correlation key grouping correlation properties | direct |
| [correlation_property_bindings](correlation_property_bindings.md) | * <br/> [CorrelationPropertyBinding](CorrelationPropertyBinding.md) | Bindings mapping correlation properties to data paths | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Process](Process.md) | [correlation_subscriptions](correlation_subscriptions.md) | range | [CorrelationSubscription](CorrelationSubscription.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/CorrelationSubscription.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:CorrelationSubscription |
| native | fluxnova_bpm_platform:CorrelationSubscription |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: CorrelationSubscription
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/CorrelationSubscription.java
description: The BPMN correlationSubscription element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- correlation_key
- correlation_property_bindings

```
</details>

### Induced

<details>
```yaml
name: CorrelationSubscription
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/CorrelationSubscription.java
description: The BPMN correlationSubscription element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  correlation_key:
    name: correlation_key
    description: Correlation key grouping correlation properties.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationSubscription
    domain_of:
    - CorrelationSubscription
    range: CorrelationKey
  correlation_property_bindings:
    name: correlation_property_bindings
    description: Bindings mapping correlation properties to data paths.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationSubscription
    domain_of:
    - CorrelationSubscription
    range: CorrelationPropertyBinding
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
    owner: CorrelationSubscription
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
    owner: CorrelationSubscription
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
    owner: CorrelationSubscription
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationSubscription
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationSubscription
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>