---
search:
  boost: 10.0
---

# Class: FluxnovaFormProperty 


_The BPMN formProperty camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaFormProperty](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaFormProperty)





```mermaid
 classDiagram
    class FluxnovaFormProperty
    click FluxnovaFormProperty href "../FluxnovaFormProperty/"
      BpmnModelElementInstance <|-- FluxnovaFormProperty
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaFormProperty : fluxnova_date_pattern
        
      FluxnovaFormProperty : fluxnova_default
        
      FluxnovaFormProperty : fluxnova_expression
        
      FluxnovaFormProperty : fluxnova_id
        
      FluxnovaFormProperty : fluxnova_name
        
      FluxnovaFormProperty : fluxnova_readable
        
      FluxnovaFormProperty : fluxnova_required
        
      FluxnovaFormProperty : fluxnova_type
        
      FluxnovaFormProperty : fluxnova_values
        
          
    
        
        
        FluxnovaFormProperty --> "*" FluxnovaValue : fluxnova_values
        click FluxnovaValue href "../FluxnovaValue/"
    

        
      FluxnovaFormProperty : fluxnova_variable
        
      FluxnovaFormProperty : fluxnova_writeable
        
      FluxnovaFormProperty : scope
        
          
    
        
        
        FluxnovaFormProperty --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaFormProperty**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_id](fluxnova_id.md) | 0..1 <br/> [String](String.md) | Identifier for this Fluxnova extension element | direct |
| [fluxnova_name](fluxnova_name.md) | 0..1 <br/> [String](String.md) | Name attribute of this Fluxnova extension element | direct |
| [fluxnova_type](fluxnova_type.md) | 0..1 <br/> [String](String.md) | Type name for this form field or listener | direct |
| [fluxnova_required](fluxnova_required.md) | 0..1 <br/> [Boolean](Boolean.md) | Fluxnova extension property: required | direct |
| [fluxnova_readable](fluxnova_readable.md) | 0..1 <br/> [Boolean](Boolean.md) | Fluxnova extension property: readable | direct |
| [fluxnova_writeable](fluxnova_writeable.md) | 0..1 <br/> [Boolean](Boolean.md) | Fluxnova extension property: writeable | direct |
| [fluxnova_variable](fluxnova_variable.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: variable | direct |
| [fluxnova_expression](fluxnova_expression.md) | 0..1 <br/> [String](String.md) | EL expression for this element | direct |
| [fluxnova_date_pattern](fluxnova_date_pattern.md) | 0..1 <br/> [String](String.md) | Date pattern for date-typed form fields | direct |
| [fluxnova_default](fluxnova_default.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: default | direct |
| [fluxnova_values](fluxnova_values.md) | * <br/> [FluxnovaValue](FluxnovaValue.md) | Permissible value options for this form field | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFormProperty.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaFormProperty |
| native | fluxnova_bpm_platform:FluxnovaFormProperty |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaFormProperty
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFormProperty.java
description: The BPMN formProperty camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- fluxnova_id
- fluxnova_name
- fluxnova_type
- fluxnova_required
- fluxnova_readable
- fluxnova_writeable
- fluxnova_variable
- fluxnova_expression
- fluxnova_date_pattern
- fluxnova_default
- fluxnova_values

```
</details>

### Induced

<details>
```yaml
name: FluxnovaFormProperty
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFormProperty.java
description: The BPMN formProperty camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  fluxnova_id:
    name: fluxnova_id
    description: Identifier for this Fluxnova extension element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - FluxnovaFormField
    - FluxnovaFormProperty
    - FluxnovaProperty
    - FluxnovaValue
    range: string
  fluxnova_name:
    name: fluxnova_name
    description: Name attribute of this Fluxnova extension element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - FluxnovaConstraint
    - FluxnovaField
    - FluxnovaFormProperty
    - FluxnovaInputParameter
    - FluxnovaOutputParameter
    - FluxnovaProperty
    - FluxnovaValue
    range: string
  fluxnova_type:
    name: fluxnova_type
    description: Type name for this form field or listener.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - SendTask
    - ServiceTask
    - FluxnovaFormField
    - FluxnovaFormProperty
    range: string
  fluxnova_required:
    name: fluxnova_required
    description: 'Fluxnova extension property: required.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - FluxnovaFormProperty
    range: boolean
  fluxnova_readable:
    name: fluxnova_readable
    description: 'Fluxnova extension property: readable.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - FluxnovaFormProperty
    range: boolean
  fluxnova_writeable:
    name: fluxnova_writeable
    description: 'Fluxnova extension property: writeable.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - FluxnovaFormProperty
    range: boolean
  fluxnova_variable:
    name: fluxnova_variable
    description: 'Fluxnova extension property: variable.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - FluxnovaFormProperty
    range: string
  fluxnova_expression:
    name: fluxnova_expression
    description: EL expression for this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - SendTask
    - ServiceTask
    - FluxnovaErrorEventDefinition
    - FluxnovaExecutionListener
    - FluxnovaField
    - FluxnovaFormProperty
    - FluxnovaTaskListener
    range: string
  fluxnova_date_pattern:
    name: fluxnova_date_pattern
    description: Date pattern for date-typed form fields.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - FluxnovaFormField
    - FluxnovaFormProperty
    range: string
  fluxnova_default:
    name: fluxnova_default
    description: 'Fluxnova extension property: default.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - FluxnovaFormProperty
    range: string
  fluxnova_values:
    name: fluxnova_values
    description: Permissible value options for this form field.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - FluxnovaFormField
    - FluxnovaFormProperty
    range: FluxnovaValue
    multivalued: true
    inlined: true
    inlined_as_list: true
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormProperty
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>