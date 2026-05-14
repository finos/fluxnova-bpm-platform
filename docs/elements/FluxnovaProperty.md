---
search:
  boost: 10.0
---

# Class: FluxnovaProperty 


_The BPMN property camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaProperty](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaProperty)





```mermaid
 classDiagram
    class FluxnovaProperty
    click FluxnovaProperty href "../FluxnovaProperty/"
      BpmnModelElementInstance <|-- FluxnovaProperty
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaProperty : fluxnova_id
        
      FluxnovaProperty : fluxnova_name
        
      FluxnovaProperty : fluxnova_value
        
      FluxnovaProperty : scope
        
          
    
        
        
        FluxnovaProperty --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaProperty**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_id](fluxnova_id.md) | 0..1 <br/> [String](String.md) | Identifier for this Fluxnova extension element | direct |
| [fluxnova_name](fluxnova_name.md) | 0..1 <br/> [String](String.md) | Name attribute of this Fluxnova extension element | direct |
| [fluxnova_value](fluxnova_value.md) | 0..1 <br/> [String](String.md) | Value of this Fluxnova extension element | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [FluxnovaProperties](FluxnovaProperties.md) | [fluxnova_properties](fluxnova_properties.md) | range | [FluxnovaProperty](FluxnovaProperty.md) |








## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaProperty.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaProperty |
| native | fluxnova_bpm_platform:FluxnovaProperty |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaProperty
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaProperty.java
description: The BPMN property camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- fluxnova_id
- fluxnova_name
- fluxnova_value

```
</details>

### Induced

<details>
```yaml
name: FluxnovaProperty
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaProperty.java
description: The BPMN property camunda extension element
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
    owner: FluxnovaProperty
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
    owner: FluxnovaProperty
    domain_of:
    - FluxnovaConstraint
    - FluxnovaField
    - FluxnovaFormProperty
    - FluxnovaInputParameter
    - FluxnovaOutputParameter
    - FluxnovaProperty
    - FluxnovaValue
    range: string
  fluxnova_value:
    name: fluxnova_value
    description: Value of this Fluxnova extension element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaProperty
    domain_of:
    - FluxnovaProperty
    range: string
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaProperty
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>