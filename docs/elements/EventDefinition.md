---
search:
  boost: 10.0
---

# Class: EventDefinition 


_The BPMN eventDefinition element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:EventDefinition](https://w3id.org/TD-Universe/fluxnova-bpm-platform/EventDefinition)





```mermaid
 classDiagram
    class EventDefinition
    click EventDefinition href "../EventDefinition/"
      RootElement <|-- EventDefinition
        click RootElement href "../RootElement/"
      

      EventDefinition <|-- CancelEventDefinition
        click CancelEventDefinition href "../CancelEventDefinition/"
      EventDefinition <|-- CompensateEventDefinition
        click CompensateEventDefinition href "../CompensateEventDefinition/"
      EventDefinition <|-- ConditionalEventDefinition
        click ConditionalEventDefinition href "../ConditionalEventDefinition/"
      EventDefinition <|-- ErrorEventDefinition
        click ErrorEventDefinition href "../ErrorEventDefinition/"
      EventDefinition <|-- EscalationEventDefinition
        click EscalationEventDefinition href "../EscalationEventDefinition/"
      EventDefinition <|-- LinkEventDefinition
        click LinkEventDefinition href "../LinkEventDefinition/"
      EventDefinition <|-- MessageEventDefinition
        click MessageEventDefinition href "../MessageEventDefinition/"
      EventDefinition <|-- SignalEventDefinition
        click SignalEventDefinition href "../SignalEventDefinition/"
      EventDefinition <|-- TerminateEventDefinition
        click TerminateEventDefinition href "../TerminateEventDefinition/"
      EventDefinition <|-- TimerEventDefinition
        click TimerEventDefinition href "../TimerEventDefinition/"
      

      EventDefinition : diagram_element
        
          
    
        
        
        EventDefinition --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      EventDefinition : documentations
        
          
    
        
        
        EventDefinition --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      EventDefinition : extension_elements
        
          
    
        
        
        EventDefinition --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      EventDefinition : id
        
      EventDefinition : scope
        
          
    
        
        
        EventDefinition --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [RootElement](RootElement.md)
            * **EventDefinition**
                * [CancelEventDefinition](CancelEventDefinition.md)
                * [CompensateEventDefinition](CompensateEventDefinition.md)
                * [ConditionalEventDefinition](ConditionalEventDefinition.md)
                * [ErrorEventDefinition](ErrorEventDefinition.md)
                * [EscalationEventDefinition](EscalationEventDefinition.md)
                * [LinkEventDefinition](LinkEventDefinition.md)
                * [MessageEventDefinition](MessageEventDefinition.md)
                * [SignalEventDefinition](SignalEventDefinition.md)
                * [TerminateEventDefinition](TerminateEventDefinition.md)
                * [TimerEventDefinition](TimerEventDefinition.md)


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
| [BoundaryEvent](BoundaryEvent.md) | [event_definitions](event_definitions.md) | range | [EventDefinition](EventDefinition.md) |
| [BoundaryEvent](BoundaryEvent.md) | [event_definition_refs](event_definition_refs.md) | range | [EventDefinition](EventDefinition.md) |
| [CatchEvent](CatchEvent.md) | [event_definitions](event_definitions.md) | range | [EventDefinition](EventDefinition.md) |
| [CatchEvent](CatchEvent.md) | [event_definition_refs](event_definition_refs.md) | range | [EventDefinition](EventDefinition.md) |
| [EndEvent](EndEvent.md) | [event_definitions](event_definitions.md) | range | [EventDefinition](EventDefinition.md) |
| [EndEvent](EndEvent.md) | [event_definition_refs](event_definition_refs.md) | range | [EventDefinition](EventDefinition.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [event_definitions](event_definitions.md) | range | [EventDefinition](EventDefinition.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [event_definition_refs](event_definition_refs.md) | range | [EventDefinition](EventDefinition.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [event_definitions](event_definitions.md) | range | [EventDefinition](EventDefinition.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [event_definition_refs](event_definition_refs.md) | range | [EventDefinition](EventDefinition.md) |
| [MultiInstanceLoopCharacteristics](MultiInstanceLoopCharacteristics.md) | [one_behavior_event_ref](one_behavior_event_ref.md) | range | [EventDefinition](EventDefinition.md) |
| [MultiInstanceLoopCharacteristics](MultiInstanceLoopCharacteristics.md) | [none_behavior_event_ref](none_behavior_event_ref.md) | range | [EventDefinition](EventDefinition.md) |
| [StartEvent](StartEvent.md) | [event_definitions](event_definitions.md) | range | [EventDefinition](EventDefinition.md) |
| [StartEvent](StartEvent.md) | [event_definition_refs](event_definition_refs.md) | range | [EventDefinition](EventDefinition.md) |
| [ThrowEvent](ThrowEvent.md) | [event_definitions](event_definitions.md) | range | [EventDefinition](EventDefinition.md) |
| [ThrowEvent](ThrowEvent.md) | [event_definition_refs](event_definition_refs.md) | range | [EventDefinition](EventDefinition.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/EventDefinition.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:EventDefinition |
| native | fluxnova_bpm_platform:EventDefinition |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: EventDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/EventDefinition.java
description: The BPMN eventDefinition element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: RootElement

```
</details>

### Induced

<details>
```yaml
name: EventDefinition
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/EventDefinition.java
description: The BPMN eventDefinition element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: RootElement
attributes:
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: EventDefinition
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
    owner: EventDefinition
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
    owner: EventDefinition
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: EventDefinition
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: EventDefinition
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>