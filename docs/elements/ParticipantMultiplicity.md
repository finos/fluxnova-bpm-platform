---
search:
  boost: 10.0
---

# Class: ParticipantMultiplicity 


_The BPMN participantMultiplicity element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ParticipantMultiplicity](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ParticipantMultiplicity)





```mermaid
 classDiagram
    class ParticipantMultiplicity
    click ParticipantMultiplicity href "../ParticipantMultiplicity/"
      BaseElement <|-- ParticipantMultiplicity
        click BaseElement href "../BaseElement/"
      
      ParticipantMultiplicity : diagram_element
        
          
    
        
        
        ParticipantMultiplicity --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      ParticipantMultiplicity : documentations
        
          
    
        
        
        ParticipantMultiplicity --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      ParticipantMultiplicity : extension_elements
        
          
    
        
        
        ParticipantMultiplicity --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      ParticipantMultiplicity : id
        
      ParticipantMultiplicity : maximum
        
      ParticipantMultiplicity : minimum
        
      ParticipantMultiplicity : scope
        
          
    
        
        
        ParticipantMultiplicity --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **ParticipantMultiplicity**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [minimum](minimum.md) | 0..1 <br/> [Integer](Integer.md) | Minimum number of instances for this participant multiplicity | direct |
| [maximum](maximum.md) | 0..1 <br/> [Integer](Integer.md) | Maximum number of instances for this participant multiplicity | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Participant](Participant.md) | [participant_multiplicity](participant_multiplicity.md) | range | [ParticipantMultiplicity](ParticipantMultiplicity.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ParticipantMultiplicity.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ParticipantMultiplicity |
| native | fluxnova_bpm_platform:ParticipantMultiplicity |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ParticipantMultiplicity
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ParticipantMultiplicity.java
description: The BPMN participantMultiplicity element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- minimum
- maximum

```
</details>

### Induced

<details>
```yaml
name: ParticipantMultiplicity
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ParticipantMultiplicity.java
description: The BPMN participantMultiplicity element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
attributes:
  minimum:
    name: minimum
    description: Minimum number of instances for this participant multiplicity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantMultiplicity
    domain_of:
    - ParticipantMultiplicity
    range: integer
  maximum:
    name: maximum
    description: Maximum number of instances for this participant multiplicity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantMultiplicity
    domain_of:
    - ParticipantMultiplicity
    range: integer
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: ParticipantMultiplicity
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
    owner: ParticipantMultiplicity
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
    owner: ParticipantMultiplicity
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantMultiplicity
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ParticipantMultiplicity
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>