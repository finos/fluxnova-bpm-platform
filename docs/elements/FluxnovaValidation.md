---
search:
  boost: 10.0
---

# Class: FluxnovaValidation 


_The BPMN validation camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaValidation](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaValidation)





```mermaid
 classDiagram
    class FluxnovaValidation
    click FluxnovaValidation href "../FluxnovaValidation/"
      BpmnModelElementInstance <|-- FluxnovaValidation
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaValidation : fluxnova_constraints
        
          
    
        
        
        FluxnovaValidation --> "*" FluxnovaConstraint : fluxnova_constraints
        click FluxnovaConstraint href "../FluxnovaConstraint/"
    

        
      FluxnovaValidation : scope
        
          
    
        
        
        FluxnovaValidation --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaValidation**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_constraints](fluxnova_constraints.md) | * <br/> [FluxnovaConstraint](FluxnovaConstraint.md) | Validation constraints for this form field | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [FluxnovaFormField](FluxnovaFormField.md) | [fluxnova_validation](fluxnova_validation.md) | range | [FluxnovaValidation](FluxnovaValidation.md) |








## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaValidation.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaValidation |
| native | fluxnova_bpm_platform:FluxnovaValidation |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaValidation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaValidation.java
description: The BPMN validation camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- fluxnova_constraints

```
</details>

### Induced

<details>
```yaml
name: FluxnovaValidation
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaValidation.java
description: The BPMN validation camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  fluxnova_constraints:
    name: fluxnova_constraints
    description: Validation constraints for this form field.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaValidation
    domain_of:
    - FluxnovaValidation
    range: FluxnovaConstraint
    multivalued: true
    inlined: true
    inlined_as_list: true
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaValidation
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>