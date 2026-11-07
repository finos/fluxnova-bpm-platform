<a href="https://github.com/linkml/linkml-project-copier"><img src="https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/copier-org/copier/master/img/badge/badge-grayscale-inverted-border-teal.json" alt="Copier Badge" style="max-width:100%;"/></a>

# fluxnova-bpm-platform

FINOS Fluxnova BPM Platform 3.1.1 (LinkML)

> **Only want to ask?** Install `ktl-docent` into any agent you use, by a route from [the install page](https://w3id.org/ktl/docs/install/), and ask it about this project. It answers from the bundle and says how far each answer has been checked.
>
> **Agents:** if `.lokf/knowledge/index.md` exists, read it first. `llms.txt` says how to weigh it.

## Documentation Website

[https://lmodel.github.io/fluxnova-bpm-platform](https://lmodel.github.io/fluxnova-bpm-platform)

## What it models

The schema models [Fluxnova](https://fluxnova.finos.org/) 3.1.1, FINOS's BPM platform: the tables its process engine keeps, one class per table, and the BPMN 2.0 elements its model API reads, with Fluxnova's extension elements. Two converters write every module from FINOS's tree: [scripts/fluxnova_to_linkml.py](scripts/fluxnova_to_linkml.py) from the engine's H2 DDL and the Javadoc of its Java API, and [scripts/bpmn_to_linkml.py](scripts/bpmn_to_linkml.py) from the model API's `registerType` methods.

This repository is a fork of [finos/fluxnova-bpm-platform](https://github.com/finos/fluxnova-bpm-platform). FINOS's tree is unchanged at the repository's root, and this project's folders are beside it: this folder, `.lokf/` and `website/`. A weekly workflow opens an issue when FINOS tags a release or its main moves.

## Mappings

* **BPMN 2.0, BPMN DI, DC and DI**: the `exact_mappings` of each BPMN class name the element it renders, such as `bpmn:userTask`, the XML namespace and the element's name joined by `#`. `tests/test_sources.py` checks every registered element.
* **Fluxnova's extension elements and attributes**: `exact_mappings` name both `fluxnova:` and `camunda:`, since the model API registers them in Camunda's namespace and reads Fluxnova's as the same.

## Repository Structure

* [docs/](docs/): the website's own pages
* [project/](project/): generated project files (do not edit them)
* [scripts/](scripts/): the two converters, the BPMN descriptions, the pins, the upstream watch and the sidecar's preflight
* [src/fluxnova_bpm_platform/schema/](src/fluxnova_bpm_platform/schema): the LinkML schema, which the converters write, also at `linkml_schema/` in the repository's root
* [src/fluxnova_bpm_platform/datamodel/](src/fluxnova_bpm_platform/datamodel): the generated Python datamodel
* [tests/](tests/): Python tests, with example data in [data/](tests/data) and the neighbours' adapt copies in [neighbours/](tests/neighbours)

The knowledge bundle is in `.lokf/` and the website in `website/`, at the repository's root.

## Developer Tools

Run `just` from this folder to list the project's [just](https://github.com/casey/just/) recipes. `just gen-schema` rewrites the modules from FINOS's tree and `just check-schema` says when they differ. Never run `just setup`, which nests a repository.

## Knowledge Trust Ladder (KTL)

`.lokf/` holds this project's [KTL](https://w3id.org/ktl/) sidecar. Its domain schema, `.lokf/schema/fluxnova_bpm_platform.yaml`, is the copy `just lokf-adapt` writes from `src/fluxnova_bpm_platform/schema/fluxnova_bpm_platform.yaml`, and `just lokf-adapt-check` says when it is stale. Edit the source, never the copy. Once `KNOWLEDGE_RELEASE_ENABLED` is `true`, a release carries the copy as `schema-<tag>-fluxnova-bpm-platform.yaml`.

In Obsidian, add these to the *Known LOKF types* setting of the KTL Registrar and KTL Curator plugins:

```text
FluxnovaAttachment, FluxnovaAuthorization, FluxnovaBatch, FluxnovaByteArray, FluxnovaCaseDefinition, FluxnovaCaseExecution, FluxnovaCaseSentryPart, FluxnovaComment, FluxnovaConfiguration, FluxnovaDecisionDefinition, FluxnovaDecisionRequirementsDefinition, FluxnovaDeployment, FluxnovaEventSubscription, FluxnovaExecution, FluxnovaExternalTask, FluxnovaFilter, FluxnovaFormDefinition, FluxnovaGroup, FluxnovaHistoricActivityInstance, FluxnovaHistoricBatch, FluxnovaHistoricCaseActivityInstance, FluxnovaHistoricCaseInstance, FluxnovaHistoricDecisionInputInstance, FluxnovaHistoricDecisionInstance, FluxnovaHistoricDecisionOutputInstance, FluxnovaHistoricDetail, FluxnovaHistoricExternalTaskLog, FluxnovaHistoricIdentityLink, FluxnovaHistoricIncident, FluxnovaHistoricJobLog, FluxnovaHistoricProcessInstance, FluxnovaHistoricTaskInstance, FluxnovaHistoricVariableInstance, FluxnovaIdentityInfo, FluxnovaIdentityLink, FluxnovaIncident, FluxnovaJob, FluxnovaJobDefinition, FluxnovaMeterLog, FluxnovaProcessDefinition, FluxnovaSchemaLogEntry, FluxnovaTask, FluxnovaTaskMeterLog, FluxnovaTenant, FluxnovaTenantMembership, FluxnovaUser, FluxnovaUserOperationLogEntry, FluxnovaVariableInstance
```

In the copy, every class that carries the schema's identifier, `id`, descends from LOKF's `Concept`, so a concept's id is the table row's; the BPMN classes carry none and are not concept types. Ten engine slots whose names LOKF defines, such as `name`, `description` and `type`, take the `fluxnova_bpm_platform_` prefix in the copy, and BPMN slots of such names, such as `id`, carry `bpmn_` in the schema itself. Every class carries the `Fluxnova`, `Bpmn`, `Di` or `Dc` prefix, so no class name is also a neighbour's. Column names are ordinary words, so the copy shares some keys with other lmodel copies, which `tests/test_schema_rules.py` lists.

## Credits

This project uses the template [linkml-project-copier](https://github.com/linkml/linkml-project-copier) published under [10.5281/zenodo.15163584](https://doi.org/10.5281/zenodo.15163584).

## License

The schema project is under the [Apache License 2.0](LICENSE), and the bundle under CC BY 4.0.

Fluxnova and FINOS's tree are FINOS's, under the [Apache License 2.0](../LICENSE). Where the engine's Javadoc describes a class or slot, the schema takes its description from it, under the same terms, and BPMN is the Object Management Group's. [NOTICE](NOTICE) says what comes from where. This project is not a FINOS project, and neither FINOS nor OMG endorses it.
