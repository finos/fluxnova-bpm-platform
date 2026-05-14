---
search:
  boost: 10.0
---

# Class: ResourceRole 


_The BPMN resourceRole element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ResourceRole](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ResourceRole)





```mermaid
 classDiagram
    class ResourceRole
    click ResourceRole href "../ResourceRole/"
      BaseElement <|-- ResourceRole
        click BaseElement href "../BaseElement/"
      

      ResourceRole <|-- Performer
        click Performer href "../Performer/"
      

      ResourceRole : diagram_element
        
          
    
        
        
        ResourceRole --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      ResourceRole : documentations
        
          
    
        
        
        ResourceRole --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      ResourceRole : extension_elements
        
          
    
        
        
        ResourceRole --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      ResourceRole : id
        
      ResourceRole : name
        
      ResourceRole : resource
        
          
    
        
        
        ResourceRole --> "0..1" Resource : resource
        click Resource href "../Resource/"
    

        
      ResourceRole : resource_assignment_expression
        
          
    
        
        
        ResourceRole --> "0..1" ResourceAssignmentExpression : resource_assignment_expression
        click ResourceAssignmentExpression href "../ResourceAssignmentExpression/"
    

        
      ResourceRole : resource_parameter_binding
        
          
    
        
        
        ResourceRole --> "*" ResourceParameterBinding : resource_parameter_binding
        click ResourceParameterBinding href "../ResourceParameterBinding/"
    

        
      ResourceRole : scope
        
          
    
        
        
        ResourceRole --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **ResourceRole**
            * [Performer](Performer.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | direct |
| [resource](resource.md) | 0..1 <br/> [Resource](Resource.md) | The resource of this element | direct |
| [resource_parameter_binding](resource_parameter_binding.md) | * <br/> [ResourceParameterBinding](ResourceParameterBinding.md) | Collection of resource parameter binding elements associated with this elemen... | direct |
| [resource_assignment_expression](resource_assignment_expression.md) | 0..1 <br/> [ResourceAssignmentExpression](ResourceAssignmentExpression.md) | Expression used to resolve the assigned resource | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Activity](Activity.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [CallActivity](CallActivity.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [ManualTask](ManualTask.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [Process](Process.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [ReceiveTask](ReceiveTask.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [ScriptTask](ScriptTask.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [SendTask](SendTask.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [ServiceTask](ServiceTask.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [SubProcess](SubProcess.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [BpmnTask](BpmnTask.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [Transaction](Transaction.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |
| [UserTask](UserTask.md) | [resource_roles](resource_roles.md) | range | [ResourceRole](ResourceRole.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ResourceRole.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ResourceRole |
| native | fluxnova_bpm_platform:ResourceRole |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ResourceRole
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ResourceRole.java
description: The BPMN resourceRole element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- name
- resource
- resource_parameter_binding
- resource_assignment_expression

```
</details>

### Induced

<details>
```yaml
name: ResourceRole
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ResourceRole.java
description: The BPMN resourceRole element
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
    owner: ResourceRole
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
    owner: ResourceRole
    domain_of:
    - ResourceRole
    range: Resource
  resource_parameter_binding:
    name: resource_parameter_binding
    description: Collection of resource parameter binding elements associated with
      this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ResourceRole
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
    owner: ResourceRole
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
    owner: ResourceRole
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
    owner: ResourceRole
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
    owner: ResourceRole
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ResourceRole
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ResourceRole
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>