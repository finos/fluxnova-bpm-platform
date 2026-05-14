---
search:
  boost: 10.0
---

# Class: CorrelationPropertyBinding 


_The BPMN correlationPropertyBinding element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:CorrelationPropertyBinding](https://w3id.org/TD-Universe/fluxnova-bpm-platform/CorrelationPropertyBinding)





```mermaid
 classDiagram
    class CorrelationPropertyBinding
    click CorrelationPropertyBinding href "../CorrelationPropertyBinding/"
      BaseElement <|-- CorrelationPropertyBinding
        click BaseElement href "../BaseElement/"
      
      CorrelationPropertyBinding : correlation_property
        
          
    
        
        
        CorrelationPropertyBinding --> "0..1" CorrelationProperty : correlation_property
        click CorrelationProperty href "../CorrelationProperty/"
    

        
      CorrelationPropertyBinding : data_path
        
      CorrelationPropertyBinding : diagram_element
        
          
    
        
        
        CorrelationPropertyBinding --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      CorrelationPropertyBinding : documentations
        
          
    
        
        
        CorrelationPropertyBinding --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      CorrelationPropertyBinding : extension_elements
        
          
    
        
        
        CorrelationPropertyBinding --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      CorrelationPropertyBinding : id
        
      CorrelationPropertyBinding : scope
        
          
    
        
        
        CorrelationPropertyBinding --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **CorrelationPropertyBinding**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [correlation_property](correlation_property.md) | 0..1 <br/> [CorrelationProperty](CorrelationProperty.md) | The correlation property this binding is based on | direct |
| [data_path](data_path.md) | 0..1 <br/> [String](String.md) | XPath expression navigating to the relevant data node | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [CorrelationSubscription](CorrelationSubscription.md) | [correlation_property_bindings](correlation_property_bindings.md) | range | [CorrelationPropertyBinding](CorrelationPropertyBinding.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/CorrelationPropertyBinding.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:CorrelationPropertyBinding |
| native | fluxnova_bpm_platform:CorrelationPropertyBinding |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: CorrelationPropertyBinding
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/CorrelationPropertyBinding.java
description: The BPMN correlationPropertyBinding element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- correlation_property
- data_path

```
</details>

### Induced

<details>
```yaml
name: CorrelationPropertyBinding
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/CorrelationPropertyBinding.java
description: The BPMN correlationPropertyBinding element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  correlation_property:
    name: correlation_property
    description: The correlation property this binding is based on.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationPropertyBinding
    domain_of:
    - CorrelationPropertyBinding
    range: CorrelationProperty
  data_path:
    name: data_path
    description: XPath expression navigating to the relevant data node.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationPropertyBinding
    domain_of:
    - CorrelationPropertyBinding
    range: string
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: CorrelationPropertyBinding
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
    owner: CorrelationPropertyBinding
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
    owner: CorrelationPropertyBinding
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationPropertyBinding
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationPropertyBinding
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>