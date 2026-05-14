---
search:
  boost: 10.0
---

# Class: Import 


_The BPMN Import element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:Import](https://w3id.org/TD-Universe/fluxnova-bpm-platform/Import)





```mermaid
 classDiagram
    class Import
    click Import href "../Import/"
      BpmnModelElementInstance <|-- Import
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      Import : import_type
        
      Import : location
        
      Import : namespace
        
      Import : scope
        
          
    
        
        
        Import --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **Import**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [namespace](namespace.md) | 0..1 <br/> [String](String.md) | The namespace of this element | direct |
| [location](location.md) | 0..1 <br/> [String](String.md) | The location of this element | direct |
| [import_type](import_type.md) | 0..1 <br/> [String](String.md) | The import type of this element | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Definitions](Definitions.md) | [imports](imports.md) | range | [Import](Import.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Import.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:Import |
| native | fluxnova_bpm_platform:Import |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: Import
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Import.java
description: The BPMN Import element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- namespace
- location
- import_type

```
</details>

### Induced

<details>
```yaml
name: Import
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/Import.java
description: The BPMN Import element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  namespace:
    name: namespace
    description: The namespace of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Import
    domain_of:
    - Import
    range: string
  location:
    name: location
    description: The location of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Import
    domain_of:
    - Import
    range: string
  import_type:
    name: import_type
    description: The import type of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Import
    domain_of:
    - Import
    range: string
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: Import
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>