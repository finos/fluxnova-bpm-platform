---
search:
  boost: 10.0
---

# Class: Performer 


_The BPMN performer element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:Performer](https://w3id.org/TD-Universe/fluxnova-bpm-platform/Performer)





```mermaid
 classDiagram
    class Performer
    click Performer href "../Performer/"
      ResourceRole <|-- Performer
        click ResourceRole href "../ResourceRole/"
      

      Performer <|-- HumanPerformer
        click HumanPerformer href "../HumanPerformer/"
      

      Performer : diagram_element
        
          
    
        
        
        Performer --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      Performer : documentations
        
          
    
        
        
        Performer --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      Performer : extension_elements
        
          
    
        
        
        Performer --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      Performer : id
        
      Performer : name
        
      Performer : resource
        
          
    
        
        
        Performer --> "0..1" Resource : resource
        click Resource href "../Resource/"
    

        
      Performer : resource_assignment_expression
        
          
    
        
        
        Performer --> "0..1" ResourceAssignmentExpression : resource_assignment_expression
        click ResourceAssignmentExpression href "../ResourceAssignmentExpression/"
    

        
      Performer : resource_parameter_binding
        
          
    
        
        
        Performer --> "*" ResourceParameterBinding : resource_parameter_binding
        click ResourceParameterBinding href "../ResourceParameterBinding/"
    

        
      Performer : scope
        
          
    
        
        
        Performer --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [ResourceRole](ResourceRole.md)
            * **Performer**
                * [HumanPerformer](HumanPerformer.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | [ResourceRole](ResourceRole.md) |
| [resource](resource.md) | 0..1 <br/> [Resource](Resource.md) | The resource of this element | [ResourceRole](ResourceRole.md) |
| [resource_parameter_binding](resource_parameter_binding.md) | * <br/> [ResourceParameterBinding](ResourceParameterBinding.md) | Collection of resource parameter binding elements associated with this elemen... | [ResourceRole](ResourceRole.md) |
| [resource_assignment_expression](resource_assignment_expression.md) | 0..1 <br/> [ResourceAssignmentExpression](ResourceAssignmentExpression.md) | Expression used to resolve the assigned resource | [ResourceRole](ResourceRole.md) |
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
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Performer.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:Performer |
| native | fluxnova_bpm_platform:Performer |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: Performer
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Performer.java
description: The BPMN performer element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: ResourceRole

```
</details>

### Induced

<details>
```yaml
name: Performer
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Performer.java
description: The BPMN performer element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: ResourceRole
attributes:
  name:
    name: name
    description: Human-readable name.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:name
    owner: Performer
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
  resource:
    name: resource
    description: The resource of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Performer
    domain_of:
    - ResourceRole
    range: Resource
  resource_parameter_binding:
    name: resource_parameter_binding
    description: Collection of resource parameter binding elements associated with
      this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Performer
    domain_of:
    - ResourceRole
    range: ResourceParameterBinding
    multivalued: true
    inlined: true
    inlined_as_list: true
  resource_assignment_expression:
    name: resource_assignment_expression
    description: Expression used to resolve the assigned resource.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Performer
    domain_of:
    - ResourceRole
    - FluxnovaPotentialStarter
    range: ResourceAssignmentExpression
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: Performer
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
    owner: Performer
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
    owner: Performer
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Performer
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Performer
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>