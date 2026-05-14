---
search:
  boost: 10.0
---

# Class: FluxnovaScript 


_The BPMN script camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaScript](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaScript)





```mermaid
 classDiagram
    class FluxnovaScript
    click FluxnovaScript href "../FluxnovaScript/"
      BpmnModelElementInstance <|-- FluxnovaScript
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaScript : fluxnova_resource
        
      FluxnovaScript : fluxnova_script_format
        
      FluxnovaScript : scope
        
          
    
        
        
        FluxnovaScript --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaScript**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_script_format](fluxnova_script_format.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: script format | direct |
| [fluxnova_resource](fluxnova_resource.md) | 0..1 <br/> [String](String.md) | Camunda extensions | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [FluxnovaExecutionListener](FluxnovaExecutionListener.md) | [fluxnova_script](fluxnova_script.md) | range | [FluxnovaScript](FluxnovaScript.md) |
| [FluxnovaTaskListener](FluxnovaTaskListener.md) | [fluxnova_script](fluxnova_script.md) | range | [FluxnovaScript](FluxnovaScript.md) |








## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaScript.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaScript |
| native | fluxnova_bpm_platform:FluxnovaScript |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaScript
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaScript.java
description: The BPMN script camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- fluxnova_script_format
- fluxnova_resource

```
</details>

### Induced

<details>
```yaml
name: FluxnovaScript
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaScript.java
description: The BPMN script camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  fluxnova_script_format:
    name: fluxnova_script_format
    description: 'Fluxnova extension property: script format.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaScript
    domain_of:
    - FluxnovaScript
    range: string
  fluxnova_resource:
    name: fluxnova_resource
    description: Camunda extensions
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaScript
    domain_of:
    - ConditionExpression
    - ScriptTask
    - FluxnovaScript
    range: string
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaScript
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>