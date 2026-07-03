#!/usr/bin/env python3
"""
Wrapper for linkml gen-yaml that patches SafeDumper before running.

linkml-runtime 1.11.0 (PyPI release) omits the line:
    yaml.SafeDumper.add_multi_representer(JsonObj, root_representer)
so gen-yaml raises:
    yaml.representer.RepresenterError: cannot represent an object,
        JsonObj(metadata_scheme=Annotation({...}))
for any slot whose annotations are stored as a JsonObj by the schema loader.

The fix was added between 1.11.0 and 1.11.0rc1.post104.dev0; until a patched
release is on PyPI, this wrapper registers the missing representer first.

See ISSUE.md - Issue #1 / Bug #5 for full analysis.
"""
import sys
import yaml
from linkml_runtime.utils.yamlutils import root_representer
from jsonasobj2 import JsonObj

# Backport fix: register JsonObj representer missing from linkml-runtime 1.11.0
if JsonObj not in yaml.SafeDumper.yaml_multi_representers:
    yaml.SafeDumper.add_multi_representer(JsonObj, root_representer)

from linkml.generators.yamlgen import cli  # noqa: E402 (import after patch)

if __name__ == "__main__":
    cli()
