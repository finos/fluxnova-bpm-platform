"""Writes a schema the converters build as YAML, the same way on every run."""

from __future__ import annotations

import yaml


class _Dumper(yaml.SafeDumper):
    """Indents a list under its key, as yamllint's default asks."""

    def increase_indent(self, flow=False, indentless=False):
        return super().increase_indent(flow, False)


def _str(dumper: yaml.SafeDumper, data: str) -> yaml.Node:
    style = "|" if "\n" in data else None
    return dumper.represent_scalar("tag:yaml.org,2002:str", data, style=style)


_Dumper.add_representer(str, _str)

# Top-level keys, and the entries under these, are set apart by a blank line.
_SPACED = ("subsets", "types", "enums", "slots", "classes")


def dump_schema(schema: dict, generated_by: str) -> str:
    """The schema as YAML, with a header line naming the script that writes it."""
    lines = [
        "---",
        f"# Written by {generated_by} from FINOS's tree; edit the script, not this file.",
    ]
    for key, value in schema.items():
        block = yaml.dump(
            {key: value},
            Dumper=_Dumper,
            sort_keys=False,
            allow_unicode=True,
            width=88,
            default_flow_style=False,
        ).rstrip("\n")
        if key in _SPACED and isinstance(value, dict):
            entries = block.split("\n")
            out = [entries[0]]
            for line in entries[1:]:
                if (
                    line.startswith("  ")
                    and not line.startswith("   ")
                    and len(out) > 1
                ):
                    out.append("")
                out.append(line)
            block = "\n".join(out)
        if key in ("prefixes", "imports", "annotations", *_SPACED) or lines[-1] == "":
            lines.append("")
        lines.append(block)
    return "\n".join(lines).replace("\n\n\n", "\n\n") + "\n"
