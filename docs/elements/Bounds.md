---
search:
  boost: 10.0
---

# Class: Bounds 


_The DC bounds element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:Bounds](https://w3id.org/TD-Universe/fluxnova-bpm-platform/Bounds)





```mermaid
 classDiagram
    class Bounds
    click Bounds href "../Bounds/"
      BpmnModelElementInstance <|-- Bounds
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      Bounds : height
        
      Bounds : scope
        
          
    
        
        
        Bounds --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      Bounds : width
        
      Bounds : x
        
      Bounds : y
        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **Bounds**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [x](x.md) | 0..1 <br/> [Float](Float.md) | X coordinate (horizontal offset) of this element's bounds | direct |
| [y](y.md) | 0..1 <br/> [Float](Float.md) | Y coordinate (vertical offset) of this element's bounds | direct |
| [width](width.md) | 0..1 <br/> [Float](Float.md) | Width of this element's bounding rectangle | direct |
| [height](height.md) | 0..1 <br/> [Float](Float.md) | Height of this element's bounding rectangle | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Label](Label.md) | [bounds](bounds.md) | range | [Bounds](Bounds.md) |
| [LabeledShape](LabeledShape.md) | [bounds](bounds.md) | range | [Bounds](Bounds.md) |
| [Shape](Shape.md) | [bounds](bounds.md) | range | [Bounds](Bounds.md) |
| [BpmnLabel](BpmnLabel.md) | [bounds](bounds.md) | range | [Bounds](Bounds.md) |
| [BpmnShape](BpmnShape.md) | [bounds](bounds.md) | range | [Bounds](Bounds.md) |








## In Subsets


* [Dc](Dc.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.dc |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/dc/Bounds.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:Bounds |
| native | fluxnova_bpm_platform:Bounds |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: Bounds
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.dc
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/dc/Bounds.java
description: The DC bounds element
in_subset:
- dc
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- x
- y
- width
- height

```
</details>

### Induced

<details>
```yaml
name: Bounds
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.dc
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/dc/Bounds.java
description: The DC bounds element
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
    owner: Bounds
    domain_of:
    - Bounds
    - Point
    range: float
  y:
    name: y
    description: Y coordinate (vertical offset) of this element's bounds.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Bounds
    domain_of:
    - Bounds
    - Point
    range: float
  width:
    name: width
    description: Width of this element's bounding rectangle.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Bounds
    domain_of:
    - Bounds
    range: float
  height:
    name: height
    description: Height of this element's bounding rectangle.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Bounds
    domain_of:
    - Bounds
    range: float
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Bounds
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>