---
search:
  boost: 10.0
---

# Class: FluxnovaMap 


_The BPMN camundaMap extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaMap](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaMap)





```mermaid
 classDiagram
    class FluxnovaMap
    click FluxnovaMap href "../FluxnovaMap/"
      BpmnModelElementInstance <|-- FluxnovaMap
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaMap : fluxnova_entries
        
          
    
        
        
        FluxnovaMap --> "*" FluxnovaEntry : fluxnova_entries
        click FluxnovaEntry href "../FluxnovaEntry/"
    

        
      FluxnovaMap : scope
        
          
    
        
        
        FluxnovaMap --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaMap**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_entries](fluxnova_entries.md) | * <br/> [FluxnovaEntry](FluxnovaEntry.md) | Key-value entries in this Fluxnova map | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaMap.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaMap |
| native | fluxnova_bpm_platform:FluxnovaMap |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaMap
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaMap.java
description: The BPMN camundaMap extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- fluxnova_entries

```
</details>

### Induced

<details>
```yaml
name: FluxnovaMap
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaMap.java
description: The BPMN camundaMap extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  fluxnova_entries:
    name: fluxnova_entries
    description: Key-value entries in this Fluxnova map.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaMap
    domain_of:
    - FluxnovaMap
    range: FluxnovaEntry
    multivalued: true
    inlined: true
    inlined_as_list: true
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaMap
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>