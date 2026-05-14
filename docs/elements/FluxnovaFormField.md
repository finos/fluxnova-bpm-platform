---
search:
  boost: 10.0
---

# Class: FluxnovaFormField 


_The BPMN formField camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaFormField](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaFormField)





```mermaid
 classDiagram
    class FluxnovaFormField
    click FluxnovaFormField href "../FluxnovaFormField/"
      BpmnModelElementInstance <|-- FluxnovaFormField
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaFormField : fluxnova_date_pattern
        
      FluxnovaFormField : fluxnova_default_value
        
      FluxnovaFormField : fluxnova_id
        
      FluxnovaFormField : fluxnova_label
        
      FluxnovaFormField : fluxnova_properties
        
          
    
        
        
        FluxnovaFormField --> "0..1" FluxnovaProperties : fluxnova_properties
        click FluxnovaProperties href "../FluxnovaProperties/"
    

        
      FluxnovaFormField : fluxnova_type
        
      FluxnovaFormField : fluxnova_validation
        
          
    
        
        
        FluxnovaFormField --> "0..1" FluxnovaValidation : fluxnova_validation
        click FluxnovaValidation href "../FluxnovaValidation/"
    

        
      FluxnovaFormField : fluxnova_values
        
          
    
        
        
        FluxnovaFormField --> "*" FluxnovaValue : fluxnova_values
        click FluxnovaValue href "../FluxnovaValue/"
    

        
      FluxnovaFormField : scope
        
          
    
        
        
        FluxnovaFormField --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaFormField**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_id](fluxnova_id.md) | 0..1 <br/> [String](String.md) | Identifier for this Fluxnova extension element | direct |
| [fluxnova_label](fluxnova_label.md) | 0..1 <br/> [String](String.md) | Display label for this form field | direct |
| [fluxnova_type](fluxnova_type.md) | 0..1 <br/> [String](String.md) | Type name for this form field or listener | direct |
| [fluxnova_date_pattern](fluxnova_date_pattern.md) | 0..1 <br/> [String](String.md) | Date pattern for date-typed form fields | direct |
| [fluxnova_default_value](fluxnova_default_value.md) | 0..1 <br/> [String](String.md) | Default value for this form field | direct |
| [fluxnova_properties](fluxnova_properties.md) | 0..1 <br/> [FluxnovaProperties](FluxnovaProperties.md) | Fluxnova extension properties container | direct |
| [fluxnova_validation](fluxnova_validation.md) | 0..1 <br/> [FluxnovaValidation](FluxnovaValidation.md) | Validation rules for this form field | direct |
| [fluxnova_values](fluxnova_values.md) | * <br/> [FluxnovaValue](FluxnovaValue.md) | Permissible value options for this form field | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [FluxnovaFormData](FluxnovaFormData.md) | [fluxnova_form_fields](fluxnova_form_fields.md) | range | [FluxnovaFormField](FluxnovaFormField.md) |








## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFormField.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaFormField |
| native | fluxnova_bpm_platform:FluxnovaFormField |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaFormField
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFormField.java
description: The BPMN formField camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- fluxnova_id
- fluxnova_label
- fluxnova_type
- fluxnova_date_pattern
- fluxnova_default_value
- fluxnova_properties
- fluxnova_validation
- fluxnova_values

```
</details>

### Induced

<details>
```yaml
name: FluxnovaFormField
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFormField.java
description: The BPMN formField camunda extension element
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
    owner: FluxnovaFormField
    domain_of:
    - FluxnovaFormField
    - FluxnovaFormProperty
    - FluxnovaProperty
    - FluxnovaValue
    range: string
  fluxnova_label:
    name: fluxnova_label
    description: Display label for this form field.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormField
    domain_of:
    - FluxnovaFormField
    range: string
  fluxnova_type:
    name: fluxnova_type
    description: Type name for this form field or listener.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormField
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - SendTask
    - ServiceTask
    - FluxnovaFormField
    - FluxnovaFormProperty
    range: string
  fluxnova_date_pattern:
    name: fluxnova_date_pattern
    description: Date pattern for date-typed form fields.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormField
    domain_of:
    - FluxnovaFormField
    - FluxnovaFormProperty
    range: string
  fluxnova_default_value:
    name: fluxnova_default_value
    description: Default value for this form field.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormField
    domain_of:
    - FluxnovaFormField
    range: string
  fluxnova_properties:
    name: fluxnova_properties
    description: Fluxnova extension properties container.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormField
    domain_of:
    - FluxnovaFormField
    - FluxnovaProperties
    range: FluxnovaProperties
  fluxnova_validation:
    name: fluxnova_validation
    description: Validation rules for this form field.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormField
    domain_of:
    - FluxnovaFormField
    range: FluxnovaValidation
  fluxnova_values:
    name: fluxnova_values
    description: Permissible value options for this form field.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormField
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
    owner: FluxnovaFormField
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>