---
search:
  boost: 10.0
---

# Class: DataAssociation 


_The BPMN dataAssociation element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:DataAssociation](https://w3id.org/TD-Universe/fluxnova-bpm-platform/DataAssociation)





```mermaid
 classDiagram
    class DataAssociation
    click DataAssociation href "../DataAssociation/"
      BaseElement <|-- DataAssociation
        click BaseElement href "../BaseElement/"
      

      DataAssociation <|-- DataInputAssociation
        click DataInputAssociation href "../DataInputAssociation/"
      DataAssociation <|-- DataOutputAssociation
        click DataOutputAssociation href "../DataOutputAssociation/"
      

      DataAssociation : assignments
        
          
    
        
        
        DataAssociation --> "*" Assignment : assignments
        click Assignment href "../Assignment/"
    

        
      DataAssociation : diagram_element
        
          
    
        
        
        DataAssociation --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      DataAssociation : documentations
        
          
    
        
        
        DataAssociation --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      DataAssociation : extension_elements
        
          
    
        
        
        DataAssociation --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      DataAssociation : id
        
      DataAssociation : scope
        
          
    
        
        
        DataAssociation --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      DataAssociation : sources
        
          
    
        
        
        DataAssociation --> "*" ItemAwareElement : sources
        click ItemAwareElement href "../ItemAwareElement/"
    

        
      DataAssociation : target
        
          
    
        
        
        DataAssociation --> "0..1" ItemAwareElement : target
        click ItemAwareElement href "../ItemAwareElement/"
    

        
      DataAssociation : transformation
        
          
    
        
        
        DataAssociation --> "0..1" FormalExpression : transformation
        click FormalExpression href "../FormalExpression/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **DataAssociation**
            * [DataInputAssociation](DataInputAssociation.md)
            * [DataOutputAssociation](DataOutputAssociation.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [sources](sources.md) | * <br/> [ItemAwareElement](ItemAwareElement.md) | The throwing link events that send to this link target | direct |
| [target](target.md) | 0..1 <br/> [ItemAwareElement](ItemAwareElement.md) | The catching link event that receives this link | direct |
| [transformation](transformation.md) | 0..1 <br/> [FormalExpression](FormalExpression.md) | Transformation expression applied during data association | direct |
| [assignments](assignments.md) | * <br/> [Assignment](Assignment.md) | Data assignments (from/to) within this data association | direct |
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
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/DataAssociation.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:DataAssociation |
| native | fluxnova_bpm_platform:DataAssociation |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: DataAssociation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/DataAssociation.java
description: The BPMN dataAssociation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- sources
- target
- transformation
- assignments
slot_usage:
  target:
    name: target
    range: ItemAwareElement

```
</details>

### Induced

<details>
```yaml
name: DataAssociation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/DataAssociation.java
description: The BPMN dataAssociation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slot_usage:
  target:
    name: target
    range: ItemAwareElement
attributes:
  sources:
    name: sources
    description: The throwing link events that send to this link target.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataAssociation
    domain_of:
    - DataAssociation
    - LinkEventDefinition
    - Relationship
    range: ItemAwareElement
    multivalued: true
    inlined: true
    inlined_as_list: true
  target:
    name: target
    description: The catching link event that receives this link.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataAssociation
    domain_of:
    - Association
    - ConversationLink
    - DataAssociation
    - LinkEventDefinition
    - MessageFlow
    - SequenceFlow
    range: ItemAwareElement
  transformation:
    name: transformation
    description: Transformation expression applied during data association.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataAssociation
    domain_of:
    - DataAssociation
    range: FormalExpression
  assignments:
    name: assignments
    description: Data assignments (from/to) within this data association.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataAssociation
    domain_of:
    - DataAssociation
    range: Assignment
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
    owner: DataAssociation
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
    owner: DataAssociation
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
    owner: DataAssociation
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataAssociation
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataAssociation
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>