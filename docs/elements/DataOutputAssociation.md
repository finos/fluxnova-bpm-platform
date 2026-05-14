---
search:
  boost: 10.0
---

# Class: DataOutputAssociation 


_The BPMN dataOutputAssociation element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:DataOutputAssociation](https://w3id.org/TD-Universe/fluxnova-bpm-platform/DataOutputAssociation)





```mermaid
 classDiagram
    class DataOutputAssociation
    click DataOutputAssociation href "../DataOutputAssociation/"
      DataAssociation <|-- DataOutputAssociation
        click DataAssociation href "../DataAssociation/"
      
      DataOutputAssociation : assignments
        
          
    
        
        
        DataOutputAssociation --> "*" Assignment : assignments
        click Assignment href "../Assignment/"
    

        
      DataOutputAssociation : diagram_element
        
          
    
        
        
        DataOutputAssociation --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      DataOutputAssociation : documentations
        
          
    
        
        
        DataOutputAssociation --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      DataOutputAssociation : extension_elements
        
          
    
        
        
        DataOutputAssociation --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      DataOutputAssociation : id
        
      DataOutputAssociation : scope
        
          
    
        
        
        DataOutputAssociation --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      DataOutputAssociation : sources
        
          
    
        
        
        DataOutputAssociation --> "*" ItemAwareElement : sources
        click ItemAwareElement href "../ItemAwareElement/"
    

        
      DataOutputAssociation : target
        
          
    
        
        
        DataOutputAssociation --> "0..1" ItemAwareElement : target
        click ItemAwareElement href "../ItemAwareElement/"
    

        
      DataOutputAssociation : transformation
        
          
    
        
        
        DataOutputAssociation --> "0..1" FormalExpression : transformation
        click FormalExpression href "../FormalExpression/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [DataAssociation](DataAssociation.md)
            * **DataOutputAssociation**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [sources](sources.md) | * <br/> [ItemAwareElement](ItemAwareElement.md) | The throwing link events that send to this link target | [DataAssociation](DataAssociation.md) |
| [target](target.md) | 0..1 <br/> [ItemAwareElement](ItemAwareElement.md) | The catching link event that receives this link | [DataAssociation](DataAssociation.md) |
| [transformation](transformation.md) | 0..1 <br/> [FormalExpression](FormalExpression.md) | Transformation expression applied during data association | [DataAssociation](DataAssociation.md) |
| [assignments](assignments.md) | * <br/> [Assignment](Assignment.md) | Data assignments (from/to) within this data association | [DataAssociation](DataAssociation.md) |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Activity](Activity.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [BoundaryEvent](BoundaryEvent.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [CallActivity](CallActivity.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [CatchEvent](CatchEvent.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [ManualTask](ManualTask.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [ReceiveTask](ReceiveTask.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [ScriptTask](ScriptTask.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [SendTask](SendTask.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [ServiceTask](ServiceTask.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [StartEvent](StartEvent.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [SubProcess](SubProcess.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [BpmnTask](BpmnTask.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [Transaction](Transaction.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |
| [UserTask](UserTask.md) | [data_output_associations](data_output_associations.md) | range | [DataOutputAssociation](DataOutputAssociation.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/DataOutputAssociation.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:DataOutputAssociation |
| native | fluxnova_bpm_platform:DataOutputAssociation |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: DataOutputAssociation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/DataOutputAssociation.java
description: The BPMN dataOutputAssociation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: DataAssociation

```
</details>

### Induced

<details>
```yaml
name: DataOutputAssociation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/DataOutputAssociation.java
description: The BPMN dataOutputAssociation element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: DataAssociation
attributes:
  sources:
    name: sources
    description: The throwing link events that send to this link target.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataOutputAssociation
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
    owner: DataOutputAssociation
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
    owner: DataOutputAssociation
    domain_of:
    - DataAssociation
    range: FormalExpression
  assignments:
    name: assignments
    description: Data assignments (from/to) within this data association.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataOutputAssociation
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
    owner: DataOutputAssociation
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
    owner: DataOutputAssociation
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
    owner: DataOutputAssociation
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataOutputAssociation
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DataOutputAssociation
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>