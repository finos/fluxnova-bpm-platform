---
search:
  boost: 10.0
---

# Class: FluxnovaEntry 


_The BPMN camundaEntry camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaEntry](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaEntry)





```mermaid
 classDiagram
    class FluxnovaEntry
    click FluxnovaEntry href "../FluxnovaEntry/"
      FluxnovaGenericValueElement <|-- FluxnovaEntry
        click FluxnovaGenericValueElement href "../FluxnovaGenericValueElement/"
      BpmnModelElementInstance <|-- FluxnovaEntry
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaEntry : fluxnova_key
        
      FluxnovaEntry : scope
        
          
    
        
        
        FluxnovaEntry --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      FluxnovaEntry : value
        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaEntry** [ [FluxnovaGenericValueElement](FluxnovaGenericValueElement.md)]


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_key](fluxnova_key.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: key | direct |
| [value](value.md) | 0..1 <br/> [String](String.md) | Value of this variable instance | [FluxnovaGenericValueElement](FluxnovaGenericValueElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [FluxnovaMap](FluxnovaMap.md) | [fluxnova_entries](fluxnova_entries.md) | range | [FluxnovaEntry](FluxnovaEntry.md) |








## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaEntry.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaEntry |
| native | fluxnova_bpm_platform:FluxnovaEntry |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaEntry
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaEntry.java
description: The BPMN camundaEntry camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
mixins:
- FluxnovaGenericValueElement
slots:
- fluxnova_key

```
</details>

### Induced

<details>
```yaml
name: FluxnovaEntry
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaEntry.java
description: The BPMN camundaEntry camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
mixins:
- FluxnovaGenericValueElement
attributes:
  fluxnova_key:
    name: fluxnova_key
    description: 'Fluxnova extension property: key.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaEntry
    domain_of:
    - FluxnovaEntry
    range: string
  value:
    name: value
    annotations:
      sql_column:
        tag: sql_column
        value: VALUE_
    description: Value of this variable instance.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaEntry
    domain_of:
    - MeterLog
    - Property
    - IdentityInfo
    - CategoryValue
    - FluxnovaGenericValueElement
    range: string
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaEntry
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>