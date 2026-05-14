---
search:
  boost: 10.0
---

# Class: Point 


_The DC point element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:Point](https://w3id.org/TD-Universe/fluxnova-bpm-platform/Point)





```mermaid
 classDiagram
    class Point
    click Point href "../Point/"
      BpmnModelElementInstance <|-- Point
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      

      Point <|-- Waypoint
        click Waypoint href "../Waypoint/"
      

      Point : scope
        
          
    
        
        
        Point --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      Point : x
        
      Point : y
        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **Point**
        * [Waypoint](Waypoint.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [x](x.md) | 0..1 <br/> [Float](Float.md) | X coordinate (horizontal offset) of this element's bounds | direct |
| [y](y.md) | 0..1 <br/> [Float](Float.md) | Y coordinate (vertical offset) of this element's bounds | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [Dc](Dc.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.dc |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/dc/Point.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:Point |
| native | fluxnova_bpm_platform:Point |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: Point
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.dc
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/dc/Point.java
description: The DC point element
in_subset:
- dc
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- x
- y

```
</details>

### Induced

<details>
```yaml
name: Point
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.dc
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/dc/Point.java
description: The DC point element
in_subset:
- dc
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  x:
    name: x
    description: X coordinate (horizontal offset) of this element's bounds.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Point
    domain_of:
    - Bounds
    - Point
    range: float
  y:
    name: y
    description: Y coordinate (vertical offset) of this element's bounds.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Point
    domain_of:
    - Bounds
    - Point
    range: float
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Point
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>