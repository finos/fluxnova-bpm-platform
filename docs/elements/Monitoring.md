---
search:
  boost: 10.0
---

# Class: Monitoring 


_The BPMN monitoring element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:Monitoring](https://w3id.org/TD-Universe/fluxnova-bpm-platform/Monitoring)





```mermaid
 classDiagram
    class Monitoring
    click Monitoring href "../Monitoring/"
      BaseElement <|-- Monitoring
        click BaseElement href "../BaseElement/"
      
      Monitoring : diagram_element
        
          
    
        
        
        Monitoring --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      Monitoring : documentations
        
          
    
        
        
        Monitoring --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      Monitoring : extension_elements
        
          
    
        
        
        Monitoring --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      Monitoring : id
        
      Monitoring : scope
        
          
    
        
        
        Monitoring --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **Monitoring**


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
| [Activity](Activity.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [BoundaryEvent](BoundaryEvent.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [CallActivity](CallActivity.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [CatchEvent](CatchEvent.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [ComplexGateway](ComplexGateway.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [DataObject](DataObject.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [DataObjectReference](DataObjectReference.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [DataStoreReference](DataStoreReference.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [EndEvent](EndEvent.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [Event](Event.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [EventBasedGateway](EventBasedGateway.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [ExclusiveGateway](ExclusiveGateway.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [FlowElement](FlowElement.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [FlowNode](FlowNode.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [Gateway](Gateway.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [InclusiveGateway](InclusiveGateway.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [ManualTask](ManualTask.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [ParallelGateway](ParallelGateway.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [Process](Process.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [ReceiveTask](ReceiveTask.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [ScriptTask](ScriptTask.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [SendTask](SendTask.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [SequenceFlow](SequenceFlow.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [ServiceTask](ServiceTask.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [StartEvent](StartEvent.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [SubProcess](SubProcess.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [BpmnTask](BpmnTask.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [ThrowEvent](ThrowEvent.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [Transaction](Transaction.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |
| [UserTask](UserTask.md) | [monitoring](monitoring.md) | range | [Monitoring](Monitoring.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Monitoring.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:Monitoring |
| native | fluxnova_bpm_platform:Monitoring |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: Monitoring
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Monitoring.java
description: The BPMN monitoring element
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
name: Monitoring
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Monitoring.java
description: The BPMN monitoring element
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
    owner: Monitoring
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
    owner: Monitoring
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
    owner: Monitoring
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Monitoring
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Monitoring
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>