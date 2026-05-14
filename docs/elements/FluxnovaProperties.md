---
search:
  boost: 10.0
---

# Class: FluxnovaProperties 


_The BPMN properties camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaProperties](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaProperties)





```mermaid
 classDiagram
    class FluxnovaProperties
    click FluxnovaProperties href "../FluxnovaProperties/"
      BpmnModelElementInstance <|-- FluxnovaProperties
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaProperties : fluxnova_properties
        
          
    
        
        
        FluxnovaProperties --> "0..1" FluxnovaProperty : fluxnova_properties
        click FluxnovaProperty href "../FluxnovaProperty/"
    

        
      FluxnovaProperties : scope
        
          
    
        
        
        FluxnovaProperties --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaProperties**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_properties](fluxnova_properties.md) | 0..1 <br/> [FluxnovaProperty](FluxnovaProperty.md) | Fluxnova extension properties container | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [FluxnovaFormField](FluxnovaFormField.md) | [fluxnova_properties](fluxnova_properties.md) | range | [FluxnovaProperties](FluxnovaProperties.md) |








## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaProperties.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaProperties |
| native | fluxnova_bpm_platform:FluxnovaProperties |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaProperties
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaProperties.java
description: The BPMN properties camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- fluxnova_properties
slot_usage:
  fluxnova_properties:
    name: fluxnova_properties
    range: FluxnovaProperty

```
</details>

### Induced

<details>
```yaml
name: FluxnovaProperties
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaProperties.java
description: The BPMN properties camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slot_usage:
  fluxnova_properties:
    name: fluxnova_properties
    range: FluxnovaProperty
attributes:
  fluxnova_properties:
    name: fluxnova_properties
    description: Fluxnova extension properties container.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaProperties
    domain_of:
    - FluxnovaFormField
    - FluxnovaProperties
    range: FluxnovaProperty
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaProperties
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>