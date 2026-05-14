---
search:
  boost: 10.0
---

# Class: Auditing 


_The BPMN auditing element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:Auditing](https://w3id.org/TD-Universe/fluxnova-bpm-platform/Auditing)





```mermaid
 classDiagram
    class Auditing
    click Auditing href "../Auditing/"
      BaseElement <|-- Auditing
        click BaseElement href "../BaseElement/"
      
      Auditing : diagram_element
        
          
    
        
        
        Auditing --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      Auditing : documentations
        
          
    
        
        
        Auditing --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      Auditing : extension_elements
        
          
    
        
        
        Auditing --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      Auditing : id
        
      Auditing : scope
        
          
    
        
        
        Auditing --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **Auditing**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Activity](Activity.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [BoundaryEvent](BoundaryEvent.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [CallActivity](CallActivity.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [CatchEvent](CatchEvent.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [ComplexGateway](ComplexGateway.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [DataObject](DataObject.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [DataObjectReference](DataObjectReference.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [DataStoreReference](DataStoreReference.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [EndEvent](EndEvent.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [Event](Event.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [EventBasedGateway](EventBasedGateway.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [ExclusiveGateway](ExclusiveGateway.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [FlowElement](FlowElement.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [FlowNode](FlowNode.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [Gateway](Gateway.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [InclusiveGateway](InclusiveGateway.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [ManualTask](ManualTask.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [ParallelGateway](ParallelGateway.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [Process](Process.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [ReceiveTask](ReceiveTask.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [ScriptTask](ScriptTask.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [SendTask](SendTask.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [SequenceFlow](SequenceFlow.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [ServiceTask](ServiceTask.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [StartEvent](StartEvent.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [SubProcess](SubProcess.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [BpmnTask](BpmnTask.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [ThrowEvent](ThrowEvent.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [Transaction](Transaction.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |
| [UserTask](UserTask.md) | [auditing](auditing.md) | range | [Auditing](Auditing.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Auditing.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:Auditing |
| native | fluxnova_bpm_platform:Auditing |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: Auditing
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Auditing.java
description: The BPMN auditing element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement

```
</details>

### Induced

<details>
```yaml
name: Auditing
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Auditing.java
description: The BPMN auditing element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: Auditing
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
    owner: Auditing
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
    owner: Auditing
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Auditing
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Auditing
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>