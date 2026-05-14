---
search:
  boost: 10.0
---

# Class: FluxnovaFormData 


_The BPMN formData camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaFormData](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaFormData)





```mermaid
 classDiagram
    class FluxnovaFormData
    click FluxnovaFormData href "../FluxnovaFormData/"
      BpmnModelElementInstance <|-- FluxnovaFormData
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaFormData : fluxnova_form_fields
        
          
    
        
        
        FluxnovaFormData --> "*" FluxnovaFormField : fluxnova_form_fields
        click FluxnovaFormField href "../FluxnovaFormField/"
    

        
      FluxnovaFormData : scope
        
          
    
        
        
        FluxnovaFormData --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaFormData**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_form_fields](fluxnova_form_fields.md) | * <br/> [FluxnovaFormField](FluxnovaFormField.md) | Form fields defined in this form data | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFormData.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaFormData |
| native | fluxnova_bpm_platform:FluxnovaFormData |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaFormData
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFormData.java
description: The BPMN formData camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- fluxnova_form_fields

```
</details>

### Induced

<details>
```yaml
name: FluxnovaFormData
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFormData.java
description: The BPMN formData camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  fluxnova_form_fields:
    name: fluxnova_form_fields
    description: Form fields defined in this form data.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormData
    domain_of:
    - FluxnovaFormData
    range: FluxnovaFormField
    multivalued: true
    inlined: true
    inlined_as_list: true
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFormData
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>