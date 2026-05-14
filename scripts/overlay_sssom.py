#!/usr/bin/env python3
"""Apply SSSOM mapping files to LinkML schema YAML files in-place.

Reads every ``fluxnova-*.sssom.tsv`` in *mappings_dir*, then for each schema
YAML in *schema_dir* whose ``default_prefix`` matches a subject-prefix in the
SSSOM rows, injects or merges ``*_mappings`` entries and updates ``prefixes``.

Design guarantees (determinism):
  - SSSOM files consumed in sorted filename order.
  - Applied mapping lists are sorted and deduplicated.
  - Schema ``prefixes`` block updated in-place; existing keys are never removed.
  - Files written only when content actually changes (idempotent).
  - ruamel.yaml used for round-trip YAML: comments and block structure preserved.

Usage::

    python scripts/overlay_sssom.py
    python scripts/overlay_sssom.py --dry-run
    python scripts/overlay_sssom.py --mappings-dir path/to/mappings \\
                                    --schema-dir   path/to/schema
"""

import argparse
import re
import sys
from collections import defaultdict
from pathlib import Path

from ruamel.yaml import YAML
from ruamel.yaml.comments import CommentedMap, CommentedSeq

# ── Constants ─────────────────────────────────────────────────────────────────

DEFAULT_MAPPINGS_DIR = Path("src/fluxnova_bpm_platform/mappings")
DEFAULT_SCHEMA_DIR   = Path("src/fluxnova_bpm_platform/schema")

# SSSOM skos predicate → LinkML *_mappings key
SKOS_TO_LINKML: dict[str, str] = {
    "skos:exactMatch":   "exact_mappings",
    "skos:closeMatch":   "close_mappings",
    "skos:broadMatch":   "broad_mappings",
    "skos:narrowMatch":  "narrow_mappings",
    "skos:relatedMatch": "related_mappings",
}
LINKML_MAPPING_KEYS = list(SKOS_TO_LINKML.values())

# ── SSSOM parsing ─────────────────────────────────────────────────────────────

def _parse_sssom_meta(lines: list[str]) -> tuple[dict[str, str], dict[str, str]]:
    """Parse the ``#`` comment block of an SSSOM file.

    Returns ``(meta, curie_map)`` where *meta* holds top-level scalar keys and
    *curie_map* maps prefix → URI.
    """
    meta: dict[str, str] = {}
    curie_map: dict[str, str] = {}
    in_curie = False
    for line in lines:
        if not line.startswith("#"):
            break
        stripped = line[1:].strip()
        if stripped == "curie_map:":
            in_curie = True
            continue
        if in_curie:
            m = re.match(r"(\S+):\s+\"([^\"]+)\"", stripped)
            if m:
                curie_map[m.group(1)] = m.group(2)
                continue
            # next top-level key ends the block
            if stripped and not stripped.startswith(" "):
                in_curie = False
        m = re.match(r"(\S+):\s+\"([^\"]+)\"", stripped)
        if m:
            meta[m.group(1)] = m.group(2)
        # list value  creator_id: ["..."]
        m2 = re.match(r"(\S+):\s+\[\"?([^\"\\]]+)\"?\]", stripped)
        if m2 and m2.group(1) not in meta:
            meta[m2.group(1)] = m2.group(2)
    return meta, curie_map


def load_sssom_files(mappings_dir: Path) -> tuple[
    # index: subject_prefix → element_local → linkml_key → sorted[object_ids]
    dict[str, dict[str, dict[str, list[str]]]],
    # curie registry: subject_prefix → {obj_prefix → uri}
    dict[str, dict[str, str]],
]:
    """Load all ``fluxnova-*.sssom.tsv`` files in *mappings_dir* (sorted).

    Returns a nested mapping index and a curie registry for namespace injection.
    """
    # index[subject_prefix][element_local][linkml_key] = [object_curie, ...]
    index: dict[str, dict[str, dict[str, set[str]]]] = defaultdict(
        lambda: defaultdict(lambda: defaultdict(set))
    )
    # curie_registry[subject_prefix] = {prefix: uri, ...}
    curie_registry: dict[str, dict[str, str]] = defaultdict(dict)

    sssom_files = sorted(mappings_dir.glob("fluxnova-*.sssom.tsv"))
    if not sssom_files:
        return {}, {}

    for tsv_path in sssom_files:
        raw_lines = tsv_path.read_text(encoding="utf-8").splitlines()
        _, curie_map = _parse_sssom_meta(raw_lines)

        # Find column header line
        header: list[str] | None = None
        for line in raw_lines:
            if not line.startswith("#") and line.strip():
                header = line.split("\t")
                break
        if not header:
            continue

        col = {name: idx for idx, name in enumerate(header)}
        needed = {"subject_id", "predicate_id", "object_id"}
        if not needed.issubset(col.keys()):
            continue

        for line in raw_lines:
            if line.startswith("#") or not line.strip():
                continue
            parts = line.split("\t")
            if parts[0] == "subject_id":
                continue  # skip header row
            if len(parts) <= max(col["subject_id"], col["predicate_id"], col["object_id"]):
                continue

            subject_id  = parts[col["subject_id"]].strip()
            predicate   = parts[col["predicate_id"]].strip()
            object_id   = parts[col["object_id"]].strip()

            if not subject_id or not predicate or not object_id:
                continue
            if predicate not in SKOS_TO_LINKML:
                continue
            if ":" not in subject_id:
                continue

            linkml_key   = SKOS_TO_LINKML[predicate]
            subj_prefix, element_local = subject_id.split(":", 1)

            index[subj_prefix][element_local][linkml_key].add(object_id)
            # register all curie_map entries under the subject prefix's scope
            curie_registry[subj_prefix].update(curie_map)

    # Convert sets to sorted lists for determinism
    frozen: dict[str, dict[str, dict[str, list[str]]]] = {}
    for sp, elements in index.items():
        frozen[sp] = {}
        for el, keys in elements.items():
            frozen[sp][el] = {k: sorted(v) for k, v in keys.items()}

    return frozen, dict(curie_registry)


# ── Schema patching ───────────────────────────────────────────────────────────

def _merge_mapping_list(node: CommentedMap, key: str, new_values: list[str]) -> bool:
    """Merge *new_values* into ``node[key]`` (a YAML sequence).

    Returns True if the node was modified.
    """
    existing: list[str] = list(node.get(key) or [])
    merged   = sorted(set(existing) | set(new_values))
    if merged == existing:
        return False
    seq = CommentedSeq(merged)
    seq.fa.set_flow_style()
    node[key] = seq
    return True


def _apply_to_element(
    element: CommentedMap,
    element_local: str,
    mappings: dict[str, dict[str, list[str]]],
) -> bool:
    """Apply *_mappings entries to a single class, slot, or attribute node.

    *element_local* is the bare name (after the prefix colon).
    Returns True if modified.
    """
    changed = False
    if element_local not in mappings:
        return False
    for linkml_key, values in mappings[element_local].items():
        if _merge_mapping_list(element, linkml_key, values):
            changed = True
    return changed


def _apply_enum_values(
    enum_def: CommentedMap,
    enum_name: str,
    mappings: dict[str, dict[str, list[str]]],
) -> bool:
    """Apply mappings to enum permissible_values nodes.

    SSSOM subject locals for enum values are encoded as ``EnumName/ValueName``.
    """
    changed = False
    pv = enum_def.get("permissible_values") or {}
    for val_name, val_def in pv.items():
        if not isinstance(val_def, CommentedMap):
            continue
        local = f"{enum_name}/{val_name}"
        if local in mappings:
            for linkml_key, values in mappings[local].items():
                if _merge_mapping_list(val_def, linkml_key, values):
                    changed = True
    return changed


def _ensure_prefixes(
    schema: CommentedMap,
    used_obj_prefixes: set[str],
    curie_scope: dict[str, str],
) -> bool:
    """Add any missing prefix declarations to *schema['prefixes']*.

    *used_obj_prefixes* – prefixes extracted from applied object_id CURIEs.
    *curie_scope*       – prefix → URI from the SSSOM curie_map.
    Returns True if modified.
    """
    if "prefixes" not in schema:
        schema["prefixes"] = CommentedMap()
    pfx_block = schema["prefixes"]
    changed = False
    for pfx in sorted(used_obj_prefixes):
        if pfx in pfx_block:
            continue
        uri = curie_scope.get(pfx)
        if uri:
            pfx_block[pfx] = uri
            changed = True
    return changed


def patch_schema(
    schema_path: Path,
    index: dict[str, dict[str, dict[str, list[str]]]],
    curie_registry: dict[str, dict[str, str]],
    dry_run: bool,
    yaml: YAML,
) -> int:
    """Read, patch, and (unless *dry_run*) write back *schema_path*.

    Returns the number of elements modified (0 = no change).
    """
    data: CommentedMap = yaml.load(schema_path)
    if not isinstance(data, CommentedMap):
        return 0

    default_prefix = data.get("default_prefix") or ""
    if not default_prefix or default_prefix not in index:
        return 0

    element_mappings = index[default_prefix]
    curie_scope      = curie_registry.get(default_prefix, {})
    changed_count    = 0
    used_obj_prefixes: set[str] = set()

    # Collect target prefixes that will actually be injected
    def _collect_target_prefixes(local: str) -> None:
        if local not in element_mappings:
            return
        for values in element_mappings[local].values():
            for v in values:
                if ":" in v and not v.startswith("http"):
                    used_obj_prefixes.add(v.split(":")[0])

    # ── Classes ──────────────────────────────────────────────────────────────
    for cls_name, cls_def in (data.get("classes") or {}).items():
        if not isinstance(cls_def, CommentedMap):
            continue
        _collect_target_prefixes(cls_name)
        if _apply_to_element(cls_def, cls_name, element_mappings):
            changed_count += 1
        # Attributes inside class
        for attr_name, attr_def in (cls_def.get("attributes") or {}).items():
            if not isinstance(attr_def, CommentedMap):
                continue
            _collect_target_prefixes(attr_name)
            if _apply_to_element(attr_def, attr_name, element_mappings):
                changed_count += 1

    # ── Slots ─────────────────────────────────────────────────────────────────
    for slot_name, slot_def in (data.get("slots") or {}).items():
        if not isinstance(slot_def, CommentedMap):
            continue
        _collect_target_prefixes(slot_name)
        if _apply_to_element(slot_def, slot_name, element_mappings):
            changed_count += 1

    # ── Enum values ───────────────────────────────────────────────────────────
    for enum_name, enum_def in (data.get("enums") or {}).items():
        if not isinstance(enum_def, CommentedMap):
            continue
        # collect prefixes for all enum values
        for val_name in (enum_def.get("permissible_values") or {}):
            _collect_target_prefixes(f"{enum_name}/{val_name}")
        if _apply_enum_values(enum_def, enum_name, element_mappings):
            changed_count += 1

    # ── Types ─────────────────────────────────────────────────────────────────
    for type_name, type_def in (data.get("types") or {}).items():
        if not isinstance(type_def, CommentedMap):
            continue
        _collect_target_prefixes(type_name)
        if _apply_to_element(type_def, type_name, element_mappings):
            changed_count += 1

    # ── Prefix declarations ───────────────────────────────────────────────────
    if used_obj_prefixes and _ensure_prefixes(data, used_obj_prefixes, curie_scope):
        changed_count += 1

    if changed_count and not dry_run:
        yaml.dump(data, schema_path)

    return changed_count


# ── CLI ───────────────────────────────────────────────────────────────────────

def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(
        description="Overlay SSSOM mappings onto LinkML schema YAML files."
    )
    parser.add_argument(
        "--mappings-dir",
        type=Path,
        default=DEFAULT_MAPPINGS_DIR,
        help=f"Directory containing fluxnova-*.sssom.tsv files (default: {DEFAULT_MAPPINGS_DIR})",
    )
    parser.add_argument(
        "--schema-dir",
        type=Path,
        default=DEFAULT_SCHEMA_DIR,
        help=f"Directory containing LinkML schema YAML files (default: {DEFAULT_SCHEMA_DIR})",
    )
    parser.add_argument(
        "--dry-run",
        action="store_true",
        help="Report changes without writing any files.",
    )
    parser.add_argument(
        "--verbose", "-v",
        action="store_true",
        help="Print per-file detail.",
    )
    args = parser.parse_args(argv)

    if not args.mappings_dir.is_dir():
        print(f"ERROR: mappings directory not found: {args.mappings_dir}", file=sys.stderr)
        return 1
    if not args.schema_dir.is_dir():
        print(f"ERROR: schema directory not found: {args.schema_dir}", file=sys.stderr)
        return 1

    print(f"overlay-sssom-mappings: loading SSSOM files from {args.mappings_dir} …")
    index, curie_registry = load_sssom_files(args.mappings_dir)

    if not index:
        print("  No SSSOM rows found — nothing to apply.")
        return 0

    covered_prefixes = sorted(index.keys())
    total_elements   = sum(len(v) for v in index.values())
    print(
        f"  Loaded {total_elements} element mappings across "
        f"{len(covered_prefixes)} subject prefixes: {covered_prefixes}"
    )

    yaml_rt = YAML()
    yaml_rt.preserve_quotes = True
    yaml_rt.default_flow_style = False
    yaml_rt.width = 120

    schema_files = sorted(args.schema_dir.glob("*.yaml"))
    touched = 0
    skipped = 0

    for schema_path in schema_files:
        n = patch_schema(schema_path, index, curie_registry, args.dry_run, yaml_rt)
        if n:
            status = "DRY-RUN" if args.dry_run else "updated"
            print(f"  {status}: {schema_path.name}  ({n} element(s) modified)")
            touched += 1
        else:
            skipped += 1
            if args.verbose:
                print(f"  unchanged: {schema_path.name}")

    if args.dry_run:
        print(f"\n[dry-run] Would update {touched} schema file(s); {skipped} unchanged.")
    else:
        print(f"\noverlay-sssom-mappings: updated {touched} schema file(s); {skipped} unchanged.")

    return 0


if __name__ == "__main__":
    sys.exit(main())
