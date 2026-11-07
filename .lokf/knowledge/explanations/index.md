# Explanations

* [How the fork is laid out](fork-layout.md) - Why this repository keeps FINOS's tree unchanged at its root and puts the schema project in `.linkml/`, the bundle in `.lokf/` and the site in `website/`, and what links it adds.
* [Modelling choices](modelling-choices.md) - How the schema renders its sources: integer state codes as bounded integers, foreign keys as references, BPMN references as strings, polymorphic children by element_type, and the prefixes on names.
* [What the schema leaves out](what-is-left-out.md) - What the schema does not model: the engine's computed columns and the columns' lengths, the CMMN and DMN models, what the BPMN model API does not register, the rest of Fluxnova, and what the first release removed from the old sidecar.
