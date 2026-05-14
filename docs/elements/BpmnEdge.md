---
search:
  boost: 10.0
---

# Class: BpmnEdge 


_The BPMNDI BPMNEdge element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:BpmnEdge](https://w3id.org/TD-Universe/fluxnova-bpm-platform/BpmnEdge)





```mermaid
 classDiagram
    class BpmnEdge
    click BpmnEdge href "../BpmnEdge/"
      LabeledEdge <|-- BpmnEdge
        click LabeledEdge href "../LabeledEdge/"
      
      BpmnEdge : bpmn_element
        
      BpmnEdge : bpmn_label
        
          
    
        
        
        BpmnEdge --> "0..1" BpmnLabel : bpmn_label
        click BpmnLabel href "../BpmnLabel/"
    

        
      BpmnEdge : extension
        
          
    
        
        
        BpmnEdge --> "0..1" Extension : extension
        click Extension href "../Extension/"
    

        
      BpmnEdge : id
        
      BpmnEdge : message_visible_kind
        
          
    
        
        
        BpmnEdge --> "0..1" MessageVisibleKind : message_visible_kind
        click MessageVisibleKind href "../MessageVisibleKind/"
    

        
      BpmnEdge : scope
        
          
    
        
        
        BpmnEdge --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      BpmnEdge : source_element
        
          
    
        
        
        BpmnEdge --> "0..1" DiagramElement : source_element
        click DiagramElement href "../DiagramElement/"
    

        
      BpmnEdge : target_element
        
          
    
        
        
        BpmnEdge --> "0..1" DiagramElement : target_element
        click DiagramElement href "../DiagramElement/"
    

        
      BpmnEdge : waypoints
        
          
    
        
        
        BpmnEdge --> "*" Waypoint : waypoints
        click Waypoint href "../Waypoint/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [DiagramElement](DiagramElement.md)
        * [Edge](Edge.md)
            * [LabeledEdge](LabeledEdge.md)
                * **BpmnEdge**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [bpmn_element](bpmn_element.md) | 0..1 <br/> [String](String.md) | The BPMN model element this diagram element represents | direct |
| [source_element](source_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The source element of this element | direct |
| [target_element](target_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The target element of this element | direct |
| [message_visible_kind](message_visible_kind.md) | 0..1 <br/> [MessageVisibleKind](MessageVisibleKind.md) | Visibility kind of the message flow in this edge | direct |
| [bpmn_label](bpmn_label.md) | 0..1 <br/> [BpmnLabel](BpmnLabel.md) | The label element attached to this shape or edge | direct |
| [waypoints](waypoints.md) | * <br/> [Waypoint](Waypoint.md) | Ordered list of waypoints defining the visual path of this edge | [Edge](Edge.md) |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [DiagramElement](DiagramElement.md) |
| [extension](extension.md) | 0..1 <br/> [Extension](Extension.md) | Extension element containing additional diagram information | [DiagramElement](DiagramElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [Bpmndi](Bpmndi.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.bpmndi |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/bpmndi/BpmnEdge.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:BpmnEdge |
| native | fluxnova_bpm_platform:BpmnEdge |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: BpmnEdge
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.bpmndi
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/bpmndi/BpmnEdge.java
description: The BPMNDI BPMNEdge element
in_subset:
- bpmndi
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: LabeledEdge
slots:
- bpmn_element
- source_element
- target_element
- message_visible_kind
- bpmn_label

```
</details>

### Induced

<details>
```yaml
name: BpmnEdge
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.bpmndi
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/bpmndi/BpmnEdge.java
description: The BPMNDI BPMNEdge element
in_subset:
- bpmndi
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: LabeledEdge
attributes:
  bpmn_element:
    name: bpmn_element
    description: The BPMN model element this diagram element represents.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnEdge
    domain_of:
    - BpmnEdge
    - BpmnPlane
    - BpmnShape
    range: string
  source_element:
    name: source_element
    description: The source element of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnEdge
    domain_of:
    - BpmnEdge
    range: DiagramElement
  target_element:
    name: target_element
    description: The target element of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnEdge
    domain_of:
    - BpmnEdge
    range: DiagramElement
  message_visible_kind:
    name: message_visible_kind
    description: Visibility kind of the message flow in this edge.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnEdge
    domain_of:
    - BpmnEdge
    range: MessageVisibleKind
  bpmn_label:
    name: bpmn_label
    description: The label element attached to this shape or edge.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnEdge
    domain_of:
    - BpmnEdge
    - BpmnShape
    range: BpmnLabel
  waypoints:
    name: waypoints
    description: Ordered list of waypoints defining the visual path of this edge.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnEdge
    domain_of:
    - Edge
    range: Waypoint
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
    owner: BpmnEdge
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
  extension:
    name: extension
    description: Extension element containing additional diagram information.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnEdge
    domain_of:
    - DiagramElement
    range: Extension
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnEdge
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>