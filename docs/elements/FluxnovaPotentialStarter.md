---
search:
  boost: 10.0
---

# Class: FluxnovaPotentialStarter 


_The BPMN potentialStarter camunda extension_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FluxnovaPotentialStarter](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FluxnovaPotentialStarter)





```mermaid
 classDiagram
    class FluxnovaPotentialStarter
    click FluxnovaPotentialStarter href "../FluxnovaPotentialStarter/"
      BpmnModelElementInstance <|-- FluxnovaPotentialStarter
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      FluxnovaPotentialStarter : resource_assignment_expression
        
          
    
        
        
        FluxnovaPotentialStarter --> "0..1" ResourceAssignmentExpression : resource_assignment_expression
        click ResourceAssignmentExpression href "../ResourceAssignmentExpression/"
    

        
      FluxnovaPotentialStarter : scope
        
          
    
        
        
        FluxnovaPotentialStarter --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **FluxnovaPotentialStarter**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [resource_assignment_expression](resource_assignment_expression.md) | 0..1 <br/> [ResourceAssignmentExpression](ResourceAssignmentExpression.md) | Expression used to resolve the assigned resource | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [FluxnovaExtensions](FluxnovaExtensions.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaPotentialStarter.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FluxnovaPotentialStarter |
| native | fluxnova_bpm_platform:FluxnovaPotentialStarter |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FluxnovaPotentialStarter
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaPotentialStarter.java
description: The BPMN potentialStarter camunda extension
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- resource_assignment_expression

```
</details>

### Induced

<details>
```yaml
name: FluxnovaPotentialStarter
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/fluxnova/FluxnovaPotentialStarter.java
description: The BPMN potentialStarter camunda extension
in_subset:
- fluxnova_extensions
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  resource_assignment_expression:
    name: resource_assignment_expression
    description: Expression used to resolve the assigned resource.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaPotentialStarter
    domain_of:
    - ResourceRole
    - FluxnovaPotentialStarter
    range: ResourceAssignmentExpression
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FluxnovaPotentialStarter
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>