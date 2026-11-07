---
type: Playbook
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/playbooks/regenerate-and-test
genre: how-to
title: Regenerate the schema and run the tests
description: "How to change the schema: edit a converter or the BPMN descriptions, rewrite the modules with just gen-schema, regenerate, refresh the adapt copy and run just lint and just test."
resource: .linkml/project.justfile
about:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/fluxnova-linkml-schema
sources:
  - id: contributing.md
    resource: .linkml/CONTRIBUTING.md
    title: Before opening a pull request
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 3df3328c039273a942c11877ac9ec2d77f4e5022
status: draft
verified:
  - by: process:ktl-librarian
    at: "2026-11-07T03:43:36Z"
---

# Regenerate the schema and run the tests

1. Change a converter, or a description in `scripts/bpmn_descriptions.yaml`, never a module.[^contributing.md]
2. From `.linkml/`, run `just gen-schema`, `just gen-project`, `just gen-doc` and `just lokf-adapt`, and commit the output.[^contributing.md]
3. Run `just lint` and `just test`. `just check-schema` fails when a module differs from what FINOS's tree gives.[^contributing.md]

[^contributing.md]: .linkml/CONTRIBUTING.md, Before opening a pull request
