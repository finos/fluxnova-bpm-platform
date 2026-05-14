---
search:
  boost: 10.0
---

# Class: LoopCharacteristics 


_The BPMN loopCharacteristics element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:LoopCharacteristics](https://w3id.org/TD-Universe/fluxnova-bpm-platform/LoopCharacteristics)





```mermaid
 classDiagram
    class LoopCharacteristics
    click LoopCharacteristics href "../LoopCharacteristics/"
      BaseElement <|-- LoopCharacteristics
        click BaseElement href "../BaseElement/"
      

      LoopCharacteristics <|-- MultiInstanceLoopCharacteristics
        click MultiInstanceLoopCharacteristics href "../MultiInstanceLoopCharacteristics/"
      

      LoopCharacteristics : diagram_element
        
          
    
        
        
        LoopCharacteristics --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      LoopCharacteristics : documentations
        
          
    
        
        
        LoopCharacteristics --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      LoopCharacteristics : extension_elements
        
          
    
        
        
        LoopCharacteristics --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      LoopCharacteristics : id
        
      LoopCharacteristics : scope
        
          
    
        
        
        LoopCharacteristics --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **LoopCharacteristics**
            * [MultiInstanceLoopCharacteristics](MultiInstanceLoopCharacteristics.md)


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
| [Activity](Activity.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [CallActivity](CallActivity.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [ManualTask](ManualTask.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [ReceiveTask](ReceiveTask.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [ScriptTask](ScriptTask.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [SendTask](SendTask.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [ServiceTask](ServiceTask.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [SubProcess](SubProcess.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [BpmnTask](BpmnTask.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [Transaction](Transaction.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |
| [UserTask](UserTask.md) | [loop_characteristics](loop_characteristics.md) | range | [LoopCharacteristics](LoopCharacteristics.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/LoopCharacteristics.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:LoopCharacteristics |
| native | fluxnova_bpm_platform:LoopCharacteristics |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: LoopCharacteristics
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/LoopCharacteristics.java
description: The BPMN loopCharacteristics element
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
name: LoopCharacteristics
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/LoopCharacteristics.java
description: The BPMN loopCharacteristics element
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
    owner: LoopCharacteristics
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
    owner: LoopCharacteristics
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
    owner: LoopCharacteristics
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: LoopCharacteristics
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: LoopCharacteristics
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>