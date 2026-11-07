## Add your own just recipes here. This is imported by the main justfile.

# Overriding recipes from the root justfile by adding a recipe with the same
# name in this file is not possible until a known issue in just is fixed,
# https://github.com/casey/just/issues/2540

# ============== Schema generation (reproducible) ==============

# Generate platform LinkML schema from H2 DDL + Javadoc sources
[group('schema generation')]
gen-linkml *FLAGS:
    uv run python scripts/fluxnova_to_linkml.py {{FLAGS}}

# Generate BPMN model LinkML schema from BPMN Java interfaces
[group('schema generation')]
gen-bpmn-model *FLAGS:
    uv run python scripts/fluxnova_bpmn_model_to_linkml.py {{FLAGS}}

# Regenerate ALL transformer-produced LinkML schemas (reproducible)
[group('schema generation')]
gen-linkml-all: gen-bpmn-model gen-linkml

# ============== Schema validation ==============

# Lint all generated LinkML schema files
[group('schema validation')]
lint-schema:
    uv run linkml-lint src/fluxnova_bpm_platform/schema/

# Cross-validate generated schema against MyBatis ORM mappings
[group('schema validation')]
validate-mybatis:
    uv run python scripts/fluxnova_mybatis_enrichment.py

# Run focused pytest scope for the schema transformers
[group('schema validation')]
test-transformers:
    uv run python -m pytest tests/test_fluxnova_to_linkml.py tests/test_schema.py -q

# Full schema reproducibility gate: regenerate -> lint -> cross-validate -> test
[group('schema validation')]
verify-schema: gen-linkml-all lint-schema validate-mybatis test-transformers

# ---- linkml-sidecar: the linkml_schema doorway (kept across `just update`) ----
# The schema folder under an ordinary, visible name at the host root, for
# folder pickers and file managers that hide dot-folders. Git carries the
# link; a sync service does not, so this recipe recreates it on a machine
# where it is missing. POSIX only; on Windows run, from the host root,
# mklink /J linkml_schema .linkml\src\fluxnova_bpm_platform\schema

# Create (or recreate) the linkml_schema link at the host root, to .linkml/src/fluxnova_bpm_platform/schema
[group('sidecar')]
linkml-link:
    #!/usr/bin/env bash
    set -euo pipefail
    target=".linkml/src/{{schema_name}}/schema"
    [ -d "../$target" ] || { echo "no $target to link to" >&2; exit 1; }
    if [ -L ../linkml_schema ]; then
      if [ "$(readlink ../linkml_schema)" = "$target" ]; then echo "linkml_schema already present - nothing to link"; exit 0; fi
      echo "../linkml_schema is a link elsewhere ($(readlink ../linkml_schema)) - remove it and re-run" >&2; exit 1
    fi
    if [ -e ../linkml_schema ]; then echo "../linkml_schema exists and is not a link - leaving it alone" >&2; exit 1; fi
    ln -s "$target" ../linkml_schema && echo "linked linkml_schema -> $target"
