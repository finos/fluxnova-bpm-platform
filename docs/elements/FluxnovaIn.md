---
search:
  boost: 10.0
---

# Class: FluxnovaIn 


_The BPMN in camunda extension element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaIn](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaIn)





```mermaid
 classDiagram
    class FluxnovaIn
    click FluxnovaIn href "../FluxnovaIn/"
      BpmnModelElementInstance <|-- FluxnovaIn
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaIn : fluxnova_business_key
        
      FluxnovaIn : fluxnova_local
        
      FluxnovaIn : fluxnova_source
        
      FluxnovaIn : fluxnova_source_expression
        
      FluxnovaIn : fluxnova_target
        
      FluxnovaIn : fluxnova_variables
        
      FluxnovaIn : scope
        
          
    
        
        
        FluxnovaIn --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaIn**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [fluxnova_source](fluxnova_source.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: source | direct |
| [fluxnova_source_expression](fluxnova_source_expression.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: source expression | direct |
| [fluxnova_variables](fluxnova_variables.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: variables | direct |
| [fluxnova_target](fluxnova_target.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: target | direct |
| [fluxnova_business_key](fluxnova_business_key.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: business key | direct |
| [fluxnova_local](fluxnova_local.md) | 0..1 <br/> [Boolean](Boolean.md) | Fluxnova extension property: local | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaIn.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaIn |
| native | fluxnova_bpm_platform:FluxnovaIn |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaIn
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaIn.java
description: The BPMN in camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- fluxnova_source
- fluxnova_source_expression
- fluxnova_variables
- fluxnova_target
- fluxnova_business_key
- fluxnova_local

```
</details>

### Induced

<details>
```yaml
name: FluxnovaIn
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaIn.java
description: The BPMN in camunda extension element
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  fluxnova_source:
    name: fluxnova_source
    description: 'Fluxnova extension property: source.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaIn
    domain_of:
    - FluxnovaIn
    - FluxnovaOut
    range: string
  fluxnova_source_expression:
    name: fluxnova_source_expression
    description: 'Fluxnova extension property: source expression.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaIn
    domain_of:
    - FluxnovaIn
    - FluxnovaOut
    range: string
  fluxnova_variables:
    name: fluxnova_variables
    description: 'Fluxnova extension property: variables.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaIn
    domain_of:
    - FluxnovaIn
    - FluxnovaOut
    range: string
  fluxnova_target:
    name: fluxnova_target
    description: 'Fluxnova extension property: target.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaIn
    domain_of:
    - FluxnovaIn
    - FluxnovaOut
    range: string
  fluxnova_business_key:
    name: fluxnova_business_key
    description: 'Fluxnova extension property: business key.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaIn
    domain_of:
    - FluxnovaIn
    range: string
  fluxnova_local:
    name: fluxnova_local
    description: 'Fluxnova extension property: local.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaIn
    domain_of:
    - FluxnovaIn
    - FluxnovaOut
    range: boolean
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaIn
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>