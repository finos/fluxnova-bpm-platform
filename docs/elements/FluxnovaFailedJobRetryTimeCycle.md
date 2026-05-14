---
search:
  boost: 10.0
---

# Class: FluxnovaFailedJobRetryTimeCycle 


_The BPMN failedJobRetryTimeCycle camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaFailedJobRetryTimeCycle](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaFailedJobRetryTimeCycle)





```mermaid
 classDiagram
    class FluxnovaFailedJobRetryTimeCycle
    click FluxnovaFailedJobRetryTimeCycle href "../FluxnovaFailedJobRetryTimeCycle/"
      BpmnModelElementInstance <|-- FluxnovaFailedJobRetryTimeCycle
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaFailedJobRetryTimeCycle : scope
        
          
    
        
        
        FluxnovaFailedJobRetryTimeCycle --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaFailedJobRetryTimeCycle**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFailedJobRetryTimeCycle.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaFailedJobRetryTimeCycle |
| native | fluxnova_bpm_platform:FluxnovaFailedJobRetryTimeCycle |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaFailedJobRetryTimeCycle
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFailedJobRetryTimeCycle.java
description: The BPMN failedJobRetryTimeCycle camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance

```
</details>

### Induced

<details>
```yaml
name: FluxnovaFailedJobRetryTimeCycle
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaFailedJobRetryTimeCycle.java
description: The BPMN failedJobRetryTimeCycle camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaFailedJobRetryTimeCycle
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>