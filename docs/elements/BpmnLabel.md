---
search:
  boost: 10.0
---

# Class: BpmnLabel 


_The BPMNDI BPMNLabel element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:BpmnLabel](https://w3id.org/TD-Universe/fluxnova-bpm-platform/BpmnLabel)





```mermaid
 classDiagram
    class BpmnLabel
    click BpmnLabel href "../BpmnLabel/"
      Label <|-- BpmnLabel
        click Label href "../Label/"
      
      BpmnLabel : bounds
        
          
    
        
        
        BpmnLabel --> "0..1" Bounds : bounds
        click Bounds href "../Bounds/"
    

        
      BpmnLabel : extension
        
          
    
        
        
        BpmnLabel --> "0..1" Extension : extension
        click Extension href "../Extension/"
    

        
      BpmnLabel : id
        
      BpmnLabel : label_style
        
          
    
        
        
        BpmnLabel --> "0..1" BpmnLabelStyle : label_style
        click BpmnLabelStyle href "../BpmnLabelStyle/"
    

        
      BpmnLabel : scope
        
          
    
        
        
        BpmnLabel --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [DiagramElement](DiagramElement.md)
        * [Node](Node.md)
            * [Label](Label.md)
                * **BpmnLabel**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [label_style](label_style.md) | 0..1 <br/> [BpmnLabelStyle](BpmnLabelStyle.md) | The label style of this element | direct |
| [bounds](bounds.md) | 0..1 <br/> [Bounds](Bounds.md) | Bounding rectangle giving position and size of this diagram element | [Label](Label.md) |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [DiagramElement](DiagramElement.md) |
| [extension](extension.md) | 0..1 <br/> [Extension](Extension.md) | Extension element containing additional diagram information | [DiagramElement](DiagramElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [BpmnEdge](BpmnEdge.md) | [bpmn_label](bpmn_label.md) | range | [BpmnLabel](BpmnLabel.md) |
| [BpmnShape](BpmnShape.md) | [bpmn_label](bpmn_label.md) | range | [BpmnLabel](BpmnLabel.md) |








## In Subsets


* [Bpmndi](Bpmndi.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.bpmndi |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/bpmndi/BpmnLabel.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:BpmnLabel |
| native | fluxnova_bpm_platform:BpmnLabel |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: BpmnLabel
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.bpmndi
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/bpmndi/BpmnLabel.java
description: The BPMNDI BPMNLabel element
in_subset:
- bpmndi
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: Label
slots:
- label_style

```
</details>

### Induced

<details>
```yaml
name: BpmnLabel
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.bpmndi
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/bpmndi/BpmnLabel.java
description: The BPMNDI BPMNLabel element
in_subset:
- bpmndi
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: Label
attributes:
  label_style:
    name: label_style
    description: The label style of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnLabel
    domain_of:
    - BpmnLabel
    range: BpmnLabelStyle
  bounds:
    name: bounds
    description: Bounding rectangle giving position and size of this diagram element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnLabel
    domain_of:
    - Label
    - Shape
    range: Bounds
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: BpmnLabel
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
    owner: BpmnLabel
    domain_of:
    - DiagramElement
    range: Extension
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BpmnLabel
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>