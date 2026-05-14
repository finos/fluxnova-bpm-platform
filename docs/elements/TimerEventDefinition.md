---
search:
  boost: 10.0
---

# Class: TimerEventDefinition 


_The BPMN timerEventDefinition element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:TimerEventDefinition](https://w3id.org/TD-Universe/fluxnova-bpm-platform/TimerEventDefinition)





```mermaid
 classDiagram
    class TimerEventDefinition
    click TimerEventDefinition href "../TimerEventDefinition/"
      EventDefinition <|-- TimerEventDefinition
        click EventDefinition href "../EventDefinition/"
      
      TimerEventDefinition : diagram_element
        
          
    
        
        
        TimerEventDefinition --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      TimerEventDefinition : documentations
        
          
    
        
        
        TimerEventDefinition --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      TimerEventDefinition : extension_elements
        
          
    
        
        
        TimerEventDefinition --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      TimerEventDefinition : id
        
      TimerEventDefinition : scope
        
          
    
        
        
        TimerEventDefinition --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      TimerEventDefinition : time_cycle
        
          
    
        
        
        TimerEventDefinition --> "0..1" TimeCycle : time_cycle
        click TimeCycle href "../TimeCycle/"
    

        
      TimerEventDefinition : time_date
        
          
    
        
        
        TimerEventDefinition --> "0..1" TimeDate : time_date
        click TimeDate href "../TimeDate/"
    

        
      TimerEventDefinition : time_duration
        
          
    
        
        
        TimerEventDefinition --> "0..1" TimeDuration : time_duration
        click TimeDuration href "../TimeDuration/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [RootElement](RootElement.md)
            * [EventDefinition](EventDefinition.md)
                * **TimerEventDefinition**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [time_date](time_date.md) | 0..1 <br/> [TimeDate](TimeDate.md) | Specific date and time at which this timer fires | direct |
| [time_duration](time_duration.md) | 0..1 <br/> [TimeDuration](TimeDuration.md) | Duration expression for this timer | direct |
| [time_cycle](time_cycle.md) | 0..1 <br/> [TimeCycle](TimeCycle.md) | Repeating cycle expression for this timer | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [FluxnovaTaskListener](FluxnovaTaskListener.md) | [timeouts](timeouts.md) | range | [TimerEventDefinition](TimerEventDefinition.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/TimerEventDefinition.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:TimerEventDefinition |
| native | fluxnova_bpm_platform:TimerEventDefinition |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: TimerEventDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/TimerEventDefinition.java
description: The BPMN timerEventDefinition element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: EventDefinition
slots:
- time_date
- time_duration
- time_cycle

```
</details>

### Induced

<details>
```yaml
name: TimerEventDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/TimerEventDefinition.java
description: The BPMN timerEventDefinition element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: EventDefinition
attributes:
  time_date:
    name: time_date
    description: Specific date and time at which this timer fires.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: TimerEventDefinition
    domain_of:
    - TimerEventDefinition
    range: TimeDate
  time_duration:
    name: time_duration
    description: Duration expression for this timer.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: TimerEventDefinition
    domain_of:
    - TimerEventDefinition
    range: TimeDuration
  time_cycle:
    name: time_cycle
    description: Repeating cycle expression for this timer.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: TimerEventDefinition
    domain_of:
    - TimerEventDefinition
    range: TimeCycle
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: TimerEventDefinition
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
    owner: TimerEventDefinition
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
    owner: TimerEventDefinition
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: TimerEventDefinition
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: TimerEventDefinition
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>