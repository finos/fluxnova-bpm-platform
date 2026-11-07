# fluxnova-bpm-platform

This project is a LinkML model of Fluxnova 3.1.1, FINOS's BPM platform: the tables its process engine keeps, and the BPMN 2.0 elements its model API reads, with Fluxnova's extension elements. Two converters write every module from FINOS's tree, and the tests hold each table, column, foreign key, state code and element to those sources.

- [Schema documentation](elements/index.md), generated from the schema
- [About](about.md): where each module comes from, how it renders its source and what it leaves out
- [`fluxnova_bpm_platform.yaml`](schema/fluxnova_bpm_platform.yaml): the schema, its modules merged
