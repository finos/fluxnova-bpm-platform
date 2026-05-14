---
search:
  boost: 10.0
---

# Class: CorrelationPropertyRetrievalExpression 


_The BPMN correlationPropertyRetrievalExpression element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:CorrelationPropertyRetrievalExpression](https://w3id.org/TD-Universe/fluxnova-bpm-platform/CorrelationPropertyRetrievalExpression)





```mermaid
 classDiagram
    class CorrelationPropertyRetrievalExpression
    click CorrelationPropertyRetrievalExpression href "../CorrelationPropertyRetrievalExpression/"
      BaseElement <|-- CorrelationPropertyRetrievalExpression
        click BaseElement href "../BaseElement/"
      
      CorrelationPropertyRetrievalExpression : diagram_element
        
          
    
        
        
        CorrelationPropertyRetrievalExpression --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      CorrelationPropertyRetrievalExpression : documentations
        
          
    
        
        
        CorrelationPropertyRetrievalExpression --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      CorrelationPropertyRetrievalExpression : extension_elements
        
          
    
        
        
        CorrelationPropertyRetrievalExpression --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      CorrelationPropertyRetrievalExpression : id
        
      CorrelationPropertyRetrievalExpression : message
        
          
    
        
        
        CorrelationPropertyRetrievalExpression --> "0..1" Message : message
        click Message href "../Message/"
    

        
      CorrelationPropertyRetrievalExpression : message_path
        
      CorrelationPropertyRetrievalExpression : scope
        
          
    
        
        
        CorrelationPropertyRetrievalExpression --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * **CorrelationPropertyRetrievalExpression**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [message](message.md) | 0..1 <br/> [Message](Message.md) | Short message or summary | direct |
| [message_path](message_path.md) | 0..1 <br/> [String](String.md) | The message path of this element | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [CorrelationProperty](CorrelationProperty.md) | [correlation_property_retrieval_expressions](correlation_property_retrieval_expressions.md) | range | [CorrelationPropertyRetrievalExpression](CorrelationPropertyRetrievalExpression.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/CorrelationPropertyRetrievalExpression.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:CorrelationPropertyRetrievalExpression |
| native | fluxnova_bpm_platform:CorrelationPropertyRetrievalExpression |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: CorrelationPropertyRetrievalExpression
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/CorrelationPropertyRetrievalExpression.java
description: The BPMN correlationPropertyRetrievalExpression element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slots:
- message
- message_path
slot_usage:
  message:
    name: message
    range: Message

```
</details>

### Induced

<details>
```yaml
name: CorrelationPropertyRetrievalExpression
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/CorrelationPropertyRetrievalExpression.java
description: The BPMN correlationPropertyRetrievalExpression element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BaseElement
slot_usage:
  message:
    name: message
    range: Message
attributes:
  message:
    name: message
    annotations:
      sql_column:
        tag: sql_column
        value: MESSAGE_
    description: Short message or summary.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationPropertyRetrievalExpression
    domain_of:
    - Comment
    - CorrelationPropertyRetrievalExpression
    - MessageEventDefinition
    - MessageFlow
    - ReceiveTask
    - SendTask
    range: Message
  message_path:
    name: message_path
    description: The message path of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationPropertyRetrievalExpression
    domain_of:
    - CorrelationPropertyRetrievalExpression
    range: string
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: CorrelationPropertyRetrievalExpression
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
    owner: CorrelationPropertyRetrievalExpression
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
    owner: CorrelationPropertyRetrievalExpression
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationPropertyRetrievalExpression
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: CorrelationPropertyRetrievalExpression
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>