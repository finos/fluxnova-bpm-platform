---
search:
  boost: 10.0
---

# Class: ResourceAssignmentExpression 


_The BPMN resourceAssignmentExpression element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ResourceAssignmentExpression](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ResourceAssignmentExpression)





```mermaid
 classDiagram
    class ResourceAssignmentExpression
    click ResourceAssignmentExpression href "../ResourceAssignmentExpression/"
      BaseElement <|-- ResourceAssignmentExpression
        click BaseElement href "../BaseElement/"
      
      ResourceAssignmentExpression : diagram_element
        
          
    
        
        
        ResourceAssignmentExpression --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      ResourceAssignmentExpression : documentations
        
          
    
        
        
        ResourceAssignmentExpression --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      ResourceAssignmentExpression : expression
        
          
    
        
        
        ResourceAssignmentExpression --> "0..1" Expression : expression
        click Expression href "../Expression/"
    

        
      ResourceAssignmentExpression : extension_elements
        
          
    
        
        
        ResourceAssignmentExpression --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      ResourceAssignmentExpression : id
        
      ResourceAssignmentExpression : scope
        
          
    
        
        
        ResourceAssignmentExpression --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **ResourceAssignmentExpression**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [expression](expression.md) | 0..1 <br/> [Expression](Expression.md) | The expression of this element | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [HumanPerformer](HumanPerformer.md) | [resource_assignment_expression](resource_assignment_expression.md) | range | [ResourceAssignmentExpression](ResourceAssignmentExpression.md) |
| [Performer](Performer.md) | [resource_assignment_expression](resource_assignment_expression.md) | range | [ResourceAssignmentExpression](ResourceAssignmentExpression.md) |
| [PotentialOwner](PotentialOwner.md) | [resource_assignment_expression](resource_assignment_expression.md) | range | [ResourceAssignmentExpression](ResourceAssignmentExpression.md) |
| [ResourceRole](ResourceRole.md) | [resource_assignment_expression](resource_assignment_expression.md) | range | [ResourceAssignmentExpression](ResourceAssignmentExpression.md) |
| [FluxnovaPotentialStarter](FluxnovaPotentialStarter.md) | [resource_assignment_expression](resource_assignment_expression.md) | range | [ResourceAssignmentExpression](ResourceAssignmentExpression.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ResourceAssignmentExpression.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ResourceAssignmentExpression |
| native | fluxnova_bpm_platform:ResourceAssignmentExpression |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ResourceAssignmentExpression
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ResourceAssignmentExpression.java
description: The BPMN resourceAssignmentExpression element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- expression

```
</details>

### Induced

<details>
```yaml
name: ResourceAssignmentExpression
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ResourceAssignmentExpression.java
description: The BPMN resourceAssignmentExpression element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  expression:
    name: expression
    description: The expression of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ResourceAssignmentExpression
    domain_of:
    - ResourceAssignmentExpression
    - ResourceParameterBinding
    range: Expression
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: ResourceAssignmentExpression
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
    owner: ResourceAssignmentExpression
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
    owner: ResourceAssignmentExpression
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ResourceAssignmentExpression
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ResourceAssignmentExpression
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>