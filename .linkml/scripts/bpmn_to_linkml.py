#!/usr/bin/env python3
"""Write the BPMN modules of the schema from Fluxnova's BPMN model API.

The model API registers every element it reads and writes in a ``registerType``
method of its ``*Impl`` class. The method states the element's XML name and namespace,
its parent type, whether it is abstract, its attributes (type, namespace, whether
required, default) and its child elements (how many, and whether a child holds a
reference to another element). This script reads those methods from FINOS's tree beside
``.linkml/`` and writes one class per registered element type, with:

- the element's XML name and namespace as annotations, and an exact mapping to the
  element's IRI, which is its namespace and name joined by ``#``;
- each attribute as a class attribute, typed as the model API types it;
- each child element as a slot whose range is the child's class, inlined;
- each reference, by id or QName, as a string that names the element it refers to in
  a ``refers_to`` annotation, since BPMN lets an element have no id;
- character content as ``text_content`` where the BPMN XML Schema included with the model
  API (Semantic.xsd) makes the element's type mixed, and on the extension elements the
  engine reads as text.

Descriptions come from scripts/bpmn_descriptions.yaml, in this project's own words.
Usage::

    python scripts/bpmn_to_linkml.py            # write the modules
    python scripts/bpmn_to_linkml.py --check    # fail if a module would change
"""

from __future__ import annotations

import argparse
import re
import sys
import xml.etree.ElementTree as ET
from dataclasses import dataclass, field
from pathlib import Path

import yaml

sys.path.insert(0, str(Path(__file__).resolve().parent))
from edition import EDITION  # noqa: E402
from schema_yaml import dump_schema  # noqa: E402

PROJECT_ROOT = Path(__file__).resolve().parent.parent
# FINOS's tree, which holds the sources this script reads.
REPO_ROOT = PROJECT_ROOT.parent
MODEL_API = REPO_ROOT / "model-api/bpmn-model/src/main"
JAVA_ROOT = MODEL_API / "java/org/finos/fluxnova/bpm/model/bpmn"
CONSTANTS = JAVA_ROOT / "impl/BpmnModelConstants.java"
IMPL_ROOT = JAVA_ROOT / "impl/instance"
SEMANTIC_XSD = (
    MODEL_API / "resources/org/finos/fluxnova/bpm/model/bpmn/schema/Semantic.xsd"
)
DESCRIPTIONS = PROJECT_ROOT / "scripts/bpmn_descriptions.yaml"
SCHEMA_DIR = PROJECT_ROOT / "src/fluxnova_bpm_platform/schema"

SCHEMA_ID = "https://w3id.org/lmodel/fluxnova-bpm-platform"
PREFIX = "fluxnova_bpm_platform"
SOURCE_PATH = "model-api/bpmn-model/src/main"
XSD_NS = "{http://www.w3.org/2001/XMLSchema}"

# Each namespace the model API registers an element in, by the constant's name: the
# prefix the schema binds for it, and the module its elements go to. Camunda's
# namespace is where the model API registers the extension elements; Bpmn.java reads
# Fluxnova's own namespace (and Activiti's, deprecated) as an alternative to it.
NAMESPACES = {
    "BPMN20_NS": ("bpmn", "http://www.omg.org/spec/BPMN/20100524/MODEL", "semantic"),
    "BPMNDI_NS": ("bpmndi", "http://www.omg.org/spec/BPMN/20100524/DI", "bpmndi"),
    "DI_NS": ("omgdi", "http://www.omg.org/spec/DD/20100524/DI", "di"),
    "DC_NS": ("omgdc", "http://www.omg.org/spec/DD/20100524/DC", "dc"),
    "CAMUNDA_NS": ("camunda", "http://camunda.org/schema/1.0/bpmn", "extension"),
    "FLUXNOVA_NS": (
        "fluxnova",
        "http://fluxnova.finos.org/schema/1.0/bpmn",
        "extension",
    ),
}
EXTENSION_NAMESPACES = {"CAMUNDA_NS", "FLUXNOVA_NS"}
# A condition expression's xsi:type, which says which kind of expression it holds.
XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance"

# The modules, in import order, with the class-name prefix each gives its classes.
MODULES = {
    "core": ("Bpmn", "The base every BPMN element class shares."),
    "dc": ("Dc", "Diagram Common: the bounds, points and fonts diagrams use."),
    "di": ("Di", "Diagram Interchange: the generic diagrams, shapes and edges."),
    "bpmndi": (
        "",
        "BPMN Diagram Interchange: how a BPMN diagram lays its elements out.",
    ),
    "semantic": (
        "Bpmn",
        "The BPMN 2.0 elements of a process, collaboration or definitions document.",
    ),
    "extension": (
        "",
        "Fluxnova's extension elements, which sit in a BPMN element's extensionElements.",
    ),
}
MODULE_TITLES = {
    "core": "Fluxnova BPMN core",
    "dc": "Fluxnova BPMN diagram common",
    "di": "Fluxnova BPMN diagram interchange",
    "bpmndi": "Fluxnova BPMN diagram interchange for BPMN",
    "semantic": "Fluxnova BPMN semantic elements",
    "extension": "Fluxnova BPMN extension elements",
}
MODULE_IMPORTS = {
    "core": [],
    "dc": ["core"],
    "di": ["dc"],
    "bpmndi": ["di"],
    "semantic": ["bpmndi"],
    "extension": ["semantic"],
}

# The base class every element class has when the model API names no parent.
ROOT_CLASS = "BpmnModelElementInstance"

# Extension elements whose content the engine reads as text: BpmnParseUtil reads an
# input or output parameter's and a script's text, and BpmnParse a field's string
# and expression, a failedJobRetryTimeCycle's and a connectorId's.
EXTENSION_TEXT = {
    "FluxnovaConnectorId",
    "FluxnovaEntry",
    "FluxnovaExpression",
    "FluxnovaFailedJobRetryTimeCycle",
    "FluxnovaInputParameter",
    "FluxnovaOutputParameter",
    "FluxnovaScript",
    "FluxnovaString",
    "FluxnovaValue",
}

# Elements whose children the model API reads from the document, not from
# registerType: each gets a slot, by the name of the model API's getter, that
# ranges over the root class, so element_type names the class of each child,
# which XML writes under its own name. BPMN's XML Schema gives extensionElements
# an xsd:any, and ExtensionElements.getElements() returns its children. An input
# or output parameter and a map's entry hold one script, list or map as their
# value (FluxnovaGenericValueElementImpl.getValue()), and a list holds values,
# scripts, lists and maps (FluxnovaListImpl.getValues()): the slot admits only
# those, as the engine's BpmnParseUtil reads them. By the element's Java name:
# the slot, whether it holds many, and the classes it admits.
_VALUE = ("FluxnovaScript", "FluxnovaList", "FluxnovaMap")
ANY_CONTENT = {
    "ExtensionElements": ("elements", True, ()),
    "FluxnovaInputParameter": ("value", False, _VALUE),
    "FluxnovaOutputParameter": ("value", False, _VALUE),
    "FluxnovaEntry": ("value", False, _VALUE),
    "FluxnovaList": ("values", True, ("FluxnovaValue", *_VALUE)),
}

# Child slots renamed from their XML names: an assignment's from and to, since from
# is a Python keyword and a slot LOKF defines with another meaning. The annotation
# xml_name keeps the element's name.
CHILD_RENAMES = {"from": "from_expression", "to": "to_expression"}

# Slot names LOKF 0.9.0 defines with another meaning. A BPMN slot of one of these
# names takes the prefix bpmn_, so that the knowledge bundle's adapt copy, which
# is beside lokf.yaml, keeps each key's one meaning; tests/test_schema_rules.py
# fails on a new one. The annotation xml_name keeps the XML name.
LOKF_NAMES = {
    "constraints",
    "definition",
    "documentation",
    "fields",
    "id",
    "resource",
    "sources",
    "target",
}


def apart_from_lokf(name: str) -> str:
    return f"bpmn_{name}" if name in LOKF_NAMES else name


ATTRIBUTE_RANGES = {
    "string": "string",
    "boolean": "boolean",
    "integer": "integer",
    "double": "double",
}
REFERENCE_MODIFIERS = {
    "qNameAttributeReference": "qname",
    "idAttributeReference": "id",
    "idAttributeReferenceCollection": "id",
    "qNameElementReference": "qname",
    "qNameElementReferenceCollection": "qname",
    "idElementReference": "id",
    "idElementReferenceCollection": "id",
    "uriElementReference": "uri",
}


@dataclass
class Attribute:
    xml_name: str
    kind: str
    namespace: str = ""
    required: bool = False
    default: str | None = None
    enum: str | None = None
    reference: str | None = None
    reference_kind: str | None = None
    collection: bool = False
    is_id: bool = False


@dataclass
class Child:
    type_name: str
    collection: bool
    required: bool = False
    min_occurs: int | None = None
    max_occurs: int | None = None
    reference: str | None = None
    reference_kind: str | None = None


@dataclass
class ElementType:
    java_name: str
    xml_name: str
    namespace: str
    parent: str | None
    abstract: bool
    source: Path
    attributes: list[Attribute] = field(default_factory=list)
    children: list[Child] = field(default_factory=list)


def read_constants(path: Path = CONSTANTS) -> dict[str, str]:
    """Each String constant of BpmnModelConstants, by name."""
    text = path.read_text(encoding="utf-8")
    pattern = r'public\s+static\s+final\s+String\s+(\w+)\s*=\s*"([^"]*)"\s*;'
    return dict(re.findall(pattern, text))


def _strip_comments(text: str) -> str:
    text = re.sub(r"/\*.*?\*/", "", text, flags=re.DOTALL)
    return re.sub(r"//[^\n]*", "", text)


def _balanced(text: str, start: int) -> int:
    """The index just past the parenthesis that closes the one at ``start``."""
    depth = 0
    for index in range(start, len(text)):
        if text[index] == "(":
            depth += 1
        elif text[index] == ")":
            depth -= 1
            if depth == 0:
                return index + 1
    raise ValueError("unbalanced parentheses")


def _register_body(text: str) -> str | None:
    """The body of registerType, with comments and the instance provider removed."""
    text = _strip_comments(text)
    match = re.search(r"static\s+void\s+registerType\s*\([^)]*\)\s*\{", text)
    if not match:
        return None
    depth, index = 1, match.end()
    while depth:
        depth += {"{": 1, "}": -1}.get(text[index], 0)
        index += 1
    body = text[match.end() : index - 1]
    while (found := body.find(".instanceProvider(")) != -1:
        open_at = found + len(".instanceProvider")
        body = body[:found] + body[_balanced(body, open_at) :]
    return body


def _calls(statement: str) -> list[tuple[str, list[str]]]:
    """Each method call of a builder chain, in order, with its arguments."""
    calls = []
    for match in re.finditer(r"(\w+)\s*\(", statement):
        end = _balanced(statement, match.end() - 1)
        inner = statement[match.end() : end - 1]
        args = [a.strip() for a in inner.split(",")] if inner.strip() else []
        calls.append((match.group(1), args))
    return calls


def _class_arg(arg: str) -> str:
    return arg.removesuffix(".class").strip()


def _constant(arg: str, constants: dict[str, str]) -> str:
    """The value of a constant, named bare or as BpmnModelConstants.NAME, or a literal."""
    arg = arg.strip()
    if arg.startswith('"'):
        return arg.strip('"')
    return constants[arg.removeprefix("BpmnModelConstants.")]


def _literal(arg: str, constants: dict[str, str]) -> str:
    """A default value as the text an XML document would carry."""
    arg = arg.strip()
    if arg.startswith('"'):
        return arg.strip('"')
    if arg.removeprefix("BpmnModelConstants.") in constants:
        return _constant(arg, constants)
    if "." in arg:  # an enum constant, such as ProcessType.None
        return arg.split(".")[-1]
    return arg


JAVA_SOURCE_ROOT = MODEL_API / "java"


def _fqn(path: Path) -> str:
    return (
        path.relative_to(JAVA_SOURCE_ROOT).with_suffix("").as_posix().replace("/", ".")
    )


class Resolver:
    """Resolves a simple Java type name, as one file uses it, to its full name."""

    def __init__(self) -> None:
        self.known = {_fqn(p) for p in JAVA_ROOT.rglob("*.java")}

    def for_file(self, path: Path, text: str):
        package = _fqn(path).rsplit(".", 1)[0]
        explicit = {}
        wildcards = []
        for match in re.finditer(
            r"^import\s+(?!static)([\w.]+?)(\.\*)?\s*;", text, flags=re.MULTILINE
        ):
            if match.group(2):
                wildcards.append(match.group(1))
            else:
                explicit[match.group(1).rsplit(".", 1)[-1]] = match.group(1)

        def resolve(simple: str) -> str:
            if simple in explicit:
                return explicit[simple]
            for candidate in [package, *wildcards]:
                if f"{candidate}.{simple}" in self.known:
                    return f"{candidate}.{simple}"
            raise KeyError(f"{path.name}: cannot resolve {simple}")

        return resolve


def parse_impl(
    path: Path, constants: dict[str, str], resolver: Resolver
) -> ElementType | None:
    """The element type one Impl class registers, or None if it registers none."""
    text = path.read_text(encoding="utf-8")
    body = _register_body(text)
    if body is None or "defineType" not in body:
        return None
    resolve = resolver.for_file(path, text)

    def cls(arg: str) -> str:
        return resolve(_class_arg(arg))

    element: ElementType | None = None
    for statement in body.split(";"):
        calls = _calls(statement)
        names = [name for name, _ in calls]
        if "defineType" in names:
            args = dict(calls)["defineType"]
            element = ElementType(
                java_name=cls(args[0]),
                xml_name=_constant(args[1], constants),
                namespace="",
                parent=None,
                abstract=False,
                source=path,
            )
            for name, args in calls:
                if name == "namespaceUri":
                    element.namespace = args[0].removeprefix("BpmnModelConstants.")
                elif name == "extendsType":
                    element.parent = cls(args[0])
                elif name == "abstractType":
                    element.abstract = True
            continue
        if element is None:
            continue
        current: Attribute | Child | None = None
        for name, args in calls:
            kind = name.removesuffix("Attribute")
            if name.endswith("Attribute") and kind in (
                "string",
                "boolean",
                "integer",
                "double",
                "enum",
                "namedEnum",
            ):
                current = Attribute(xml_name=_constant(args[0], constants), kind=kind)
                if kind in ("enum", "namedEnum"):
                    current.enum = cls(args[1])
                element.attributes.append(current)
            elif name in ("element", "elementCollection"):
                current = Child(
                    type_name=cls(args[0]), collection=name == "elementCollection"
                )
                element.children.append(current)
            elif current is None:
                continue
            elif name == "namespace":
                current.namespace = args[0].removeprefix("BpmnModelConstants.")
            elif name == "required":
                current.required = True
            elif name == "defaultValue":
                current.default = _literal(args[0], constants)
            elif name == "idAttribute":
                current.is_id = True
            elif name in REFERENCE_MODIFIERS:
                current.reference = cls(args[0])
                current.reference_kind = REFERENCE_MODIFIERS[name]
                if name.endswith("Collection"):
                    current.collection = True
            elif name == "minOccurs":
                current.min_occurs = int(args[0])
            elif name == "maxOccurs":
                current.max_occurs = int(args[0])
    return element


def read_types(
    root: Path = IMPL_ROOT, constants: dict[str, str] | None = None
) -> dict[str, ElementType]:
    """Every element type the model API registers, by its full Java name."""
    constants = constants if constants is not None else read_constants()
    resolver = Resolver()
    types: dict[str, ElementType] = {}
    for path in sorted(root.rglob("*.java")):
        element = parse_impl(path, constants, resolver)
        if element is not None:
            if element.java_name in types:
                raise ValueError(f"{element.java_name} is registered twice")
            types[element.java_name] = element
    return types


def read_enums(names: set[str]) -> dict[str, dict[str, str]]:
    """Each named enum's values, by its full Java name: each Java constant's name, and
    the text an XML document writes for it."""
    enums = {}
    for fqn in sorted(names):
        name = fqn.rsplit(".", 1)[-1]
        path = JAVA_SOURCE_ROOT / (fqn.replace(".", "/") + ".java")
        text = _strip_comments(path.read_text(encoding="utf-8"))
        body = text[text.index("{", text.index(f"enum {name}")) + 1 :]
        body = body.split(";")[0] if ";" in body else body.rsplit("}", 1)[0]
        values = {}
        for match in re.finditer(
            r'(\w+)\s*(?:\(\s*"([^"]*)"\s*\))?\s*(?:,|$)', body.strip()
        ):
            values[match.group(1)] = match.group(2) or match.group(1)
        enums[fqn] = values
    return enums


def mixed_elements(path: Path = SEMANTIC_XSD) -> set[str]:
    """The global elements of the BPMN XML Schema whose type holds character content."""
    root = ET.parse(path).getroot()
    types = {t.get("name"): t for t in root.iter(f"{XSD_NS}complexType")}

    def mixed(name: str | None) -> bool:
        node = types.get((name or "").split(":")[-1])
        if node is None:
            return False
        if node.get("mixed") == "true":
            return True
        base = node.find(f"{XSD_NS}complexContent/{XSD_NS}extension")
        return base is not None and mixed(base.get("base"))

    return {
        e.get("name") for e in root.findall(f"{XSD_NS}element") if mixed(e.get("type"))
    }


def snake(name: str) -> str:
    name = re.sub(r"(?<=[a-z0-9])(?=[A-Z])", "_", name)
    name = re.sub(r"(?<=[A-Z])(?=[A-Z][a-z])", "_", name)
    return name.lower()


def plural(name: str) -> str:
    if name.endswith(("s", "_refs")) or name in (
        "incoming",
        "outgoing",
        "documentation",
    ):
        return name
    if re.search(r"[^aeiou]y$", name):
        return name[:-1] + "ies"
    if name.endswith(("x", "ch", "sh")):
        return name + "es"
    return name + "s"


class Converter:
    def __init__(self) -> None:
        self.constants = read_constants()
        self.types = read_types(constants=self.constants)
        self.resolver = Resolver()
        # A type the model API registers with no XML name, such as InteractionNode,
        # is a mixin of the element types whose Java interfaces extend it.
        self.mixins = {
            name for name, element in self.types.items() if not element.xml_name
        }
        self.descriptions = yaml.safe_load(DESCRIPTIONS.read_text(encoding="utf-8"))
        self.mixed = mixed_elements()
        enum_names = {
            a.enum for t in self.types.values() for a in t.attributes if a.enum
        }
        self.enums = read_enums(enum_names)
        # A type used only as a child that holds a reference, such as Incoming, is
        # the reference itself: it gets a slot, not a class.
        held = {
            c.type_name for t in self.types.values() for c in t.children if c.reference
        }
        plain = {
            c.type_name
            for t in self.types.values()
            for c in t.children
            if not c.reference
        }
        self.holders = {
            name
            for name in held - plain
            if not self.types[name].attributes
            and not self.types[name].children
            and self.types[name].parent is None
        }

    # -- names ---------------------------------------------------------------

    def module_of(self, java_name: str) -> str:
        element = self.types[java_name]
        if element.namespace in EXTENSION_NAMESPACES:
            return "extension"
        return NAMESPACES[element.namespace][2]

    def class_name(self, java_name: str) -> str:
        simple = java_name.rsplit(".", 1)[-1]
        prefix = MODULES[self.module_of(java_name)][0]
        if prefix and re.match(f"{prefix}[A-Z]", simple):
            return simple
        return prefix + simple

    def element_iri(self, namespace: str, xml_name: str) -> list[str]:
        """The CURIEs that name an element or extension attribute."""
        if namespace == "CAMUNDA_NS":
            return [f"fluxnova:{xml_name}", f"camunda:{xml_name}"]
        return [f"{NAMESPACES[namespace][0]}:{xml_name}"]

    def has_text(self, java_name: str) -> bool:
        if java_name.rsplit(".", 1)[-1] in EXTENSION_TEXT:
            return True
        element = self.types[java_name]
        while element is not None:
            if element.namespace == "BPMN20_NS" and element.xml_name in self.mixed:
                return True
            element = self.types.get(element.parent) if element.parent else None
        return False

    # -- descriptions ----------------------------------------------------------

    def interface_parents(self, java_name: str) -> set[str]:
        """The types the element's Java interface extends, by full name."""
        path = JAVA_SOURCE_ROOT / (java_name.replace(".", "/") + ".java")
        if not path.is_file():
            return set()
        text = _strip_comments(path.read_text(encoding="utf-8"))
        match = re.search(r"interface\s+\w+(?:<[^>]*>)?\s+extends\s+([^{]+)\{", text)
        if not match:
            return set()
        resolve = self.resolver.for_file(path, text)
        found = set()
        for name in match.group(1).split(","):
            name = re.sub(r"<.*", "", name).strip()
            try:
                found.add(resolve(name))
            except KeyError:
                continue
        return found

    def class_description(self, java_name: str) -> str:
        element = self.types[java_name]
        local = element.xml_name or java_name.rsplit(".", 1)[-1]
        key = f"{NAMESPACES[element.namespace][0]}:{local}"
        found = self.descriptions["classes"].get(key)
        if not found:
            raise KeyError(f"no description for the class of {key}")
        return found

    def slot_description(self, owner: str, slot: str) -> str:
        found = self.descriptions["slots"].get(f"{owner}.{slot}") or self.descriptions[
            "slots"
        ].get(slot)
        if not found:
            raise KeyError(f"no description for {owner}.{slot}")
        return found

    # -- the schema ------------------------------------------------------------

    def attribute_slot(
        self, owner: str, element: ElementType, attribute: Attribute
    ) -> tuple[str, dict]:
        extension = attribute.namespace in EXTENSION_NAMESPACES
        name = snake(attribute.xml_name)
        if extension:
            name = f"fluxnova_{name}"
        elif attribute.namespace == "XSI_NS":
            name = f"xsi_{name}"
        slot: dict = {"description": self.slot_description(owner, name)}
        name = apart_from_lokf(name)
        if attribute.enum:
            slot["range"] = self.enum_name(attribute.enum)
        elif attribute.reference:
            slot["range"] = "string"
        else:
            slot["range"] = ATTRIBUTE_RANGES[attribute.kind]
        if attribute.collection:
            slot["multivalued"] = True
        if attribute.required:
            slot["required"] = True
        if attribute.default is not None and attribute.enum:
            text = self.enums[attribute.enum][attribute.default]
            slot["ifabsent"] = f"{slot['range']}({text})"
        elif attribute.default is not None:
            slot["ifabsent"] = self.ifabsent(slot["range"], attribute.default)
        annotations = {"xml_name": attribute.xml_name}
        if extension:
            slot["exact_mappings"] = self.element_iri(
                attribute.namespace, attribute.xml_name
            )
            annotations["xml_namespace"] = NAMESPACES[attribute.namespace][1]
        if attribute.reference:
            annotations["refers_to"] = self.class_name(attribute.reference)
            annotations["reference_kind"] = attribute.reference_kind
        if attribute.namespace == "XSI_NS":
            annotations["xml_namespace"] = XSI_NAMESPACE
        if attribute.is_id:
            annotations["xml_id"] = "true"
        slot["annotations"] = annotations
        return name, slot

    def child_slot(self, owner: str, child: Child) -> tuple[str, dict]:
        held = self.types[child.type_name]
        name = CHILD_RENAMES.get(snake(held.xml_name), snake(held.xml_name))
        if child.collection:
            name = plural(name)
        slot: dict = {"description": self.slot_description(owner, name)}
        name = apart_from_lokf(name)
        if child.reference:
            slot["range"] = "string"
        else:
            slot["range"] = self.class_name(child.type_name)
            slot["inlined"] = True
        if child.collection:
            slot["multivalued"] = True
            if not child.reference:
                slot["inlined_as_list"] = True
        if child.required or (child.min_occurs or 0) > 0:
            slot["required"] = True
        if child.collection and child.min_occurs and child.min_occurs > 1:
            slot["minimum_cardinality"] = child.min_occurs
        if child.collection and child.max_occurs is not None:
            slot["maximum_cardinality"] = child.max_occurs
        annotations = {"xml_name": held.xml_name}
        if held.namespace in EXTENSION_NAMESPACES:
            annotations["xml_namespace"] = NAMESPACES[held.namespace][1]
        if child.reference:
            annotations["refers_to"] = self.class_name(child.reference)
            annotations["reference_kind"] = child.reference_kind
        slot["annotations"] = annotations
        return name, slot

    @staticmethod
    def enum_name(java_name: str) -> str:
        return f"Bpmn{java_name.rsplit('.', 1)[-1]}"

    @staticmethod
    def enum_module(java_name: str) -> str:
        return "bpmndi" if ".instance.bpmndi." in java_name else "semantic"

    @staticmethod
    def ifabsent(range_: str, value: str) -> str:
        if range_ == "boolean":
            return "true" if value == "true" else "false"
        if range_ == "integer":
            return f"int({value})"
        if range_ == "double":
            return f"float({value})"
        return f"string({value})"

    def build_class(self, java_name: str) -> dict:
        element = self.types[java_name]
        owner = self.class_name(java_name)
        cls: dict = {"description": self.class_description(java_name)}
        if element.abstract:
            cls["abstract"] = True
        parent = element.parent
        if java_name in self.mixins:
            cls["mixin"] = True
        else:
            cls["is_a"] = self.class_name(parent) if parent else ROOT_CLASS
        mixins = [
            self.class_name(m)
            for m in sorted(self.mixins)
            if m != java_name and m in self.interface_parents(java_name) and m != parent
        ]
        if mixins:
            cls["mixins"] = mixins
        if element.xml_name:
            cls["exact_mappings"] = self.element_iri(
                element.namespace, element.xml_name
            )
        cls["annotations"] = {
            "xml_name": element.xml_name,
            "xml_namespace": NAMESPACES[element.namespace][1],
            "source_file": element.source.relative_to(REPO_ROOT).as_posix(),
        }
        if not element.xml_name:
            del cls["annotations"]["xml_name"]
        cls["in_subset"] = [f"bpmn_{self.module_of(java_name)}"]
        attributes: dict = {}
        for attribute in element.attributes:
            name, slot = self.attribute_slot(owner, element, attribute)
            attributes[name] = slot
        for child in element.children:
            name, slot = self.child_slot(owner, child)
            if name in attributes:
                raise ValueError(f"{owner} has two slots named {name}")
            attributes[name] = slot
        simple = java_name.rsplit(".", 1)[-1]
        if simple in ANY_CONTENT:
            name, many, admitted = ANY_CONTENT[simple]
            slot = {
                "description": self.slot_description(owner, name),
                "range": ROOT_CLASS,
                "inlined": True,
            }
            if many:
                slot["multivalued"] = True
                slot["inlined_as_list"] = True
            if admitted:
                slot["any_of"] = [{"range": c} for c in admitted]
            attributes[name] = slot
        if self.has_text(java_name) and not self._inherits_text(java_name):
            attributes["text_content"] = {
                "description": self.slot_description(owner, "text_content"),
                "range": "string",
            }
        if attributes:
            cls["attributes"] = attributes
        return cls

    def _inherits_text(self, java_name: str) -> bool:
        parent = self.types[java_name].parent
        return bool(parent) and self.has_text(parent)

    def build_enums(self, module: str) -> dict:
        enums = {}
        for java_name, values in sorted(self.enums.items()):
            if self.enum_module(java_name) != module:
                continue
            key = f"enum:{java_name.rsplit('.', 1)[-1]}"
            enum: dict = {
                "description": self.descriptions["enums"][key],
                "permissible_values": {},
            }
            for value in values.values():
                pv: dict = {"description": self.descriptions["enums"][f"{key}.{value}"]}
                if not re.fullmatch(r"[A-Za-z][A-Za-z0-9_]*", value):
                    pv["title"] = re.sub(r"[^A-Za-z0-9]", "", value)
                enum["permissible_values"][value] = pv
            enums[self.enum_name(java_name)] = enum
        return enums

    def header(self, module: str) -> dict:
        name = f"fluxnova_bpmn_{module}"
        source = f"https://github.com/finos/fluxnova-bpm-platform/tree/{EDITION['commit']}/{SOURCE_PATH}"
        header: dict = {
            "id": f"{SCHEMA_ID}/{name}",
            "name": name,
            "title": MODULE_TITLES[module],
            "description": MODULES[module][1],
            "version": EDITION["version"],
            "source": source,
            "license": "Apache-2.0",
            "see_also": ["https://lmodel.github.io/fluxnova-bpm-platform"],
            "prefixes": {
                PREFIX: f"{SCHEMA_ID}/",
                "linkml": "https://w3id.org/linkml/",
            },
            "default_prefix": PREFIX,
            "default_range": "string",
        }
        for key, (prefix, iri, home) in NAMESPACES.items():
            if home == module or (
                module == "extension" and key in EXTENSION_NAMESPACES
            ):
                header["prefixes"][prefix] = iri + "#"
        header["imports"] = ["linkml:types"] + [
            f"fluxnova_bpmn_{m}" for m in MODULE_IMPORTS[module]
        ]
        return header

    def build_modules(self) -> dict[str, dict]:
        modules = {m: self.header(m) for m in MODULES}
        modules["core"]["subsets"] = {
            f"bpmn_{m}": {"description": MODULES[m][1]} for m in MODULES if m != "core"
        }
        modules["core"]["classes"] = {
            ROOT_CLASS: {
                "description": self.descriptions["classes"][ROOT_CLASS],
                "abstract": True,
                "attributes": {
                    "element_type": {
                        "description": self.slot_description(
                            ROOT_CLASS, "element_type"
                        ),
                        "designates_type": True,
                        "range": "string",
                    }
                },
            }
        }
        for module in ("bpmndi", "semantic"):
            modules[module]["enums"] = self.build_enums(module)
        for java_name in sorted(self.types, key=self.class_name):
            if java_name in self.holders:
                continue
            module = self.module_of(java_name)
            modules[module].setdefault("classes", {})[self.class_name(java_name)] = (
                self.build_class(java_name)
            )
        return modules


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    parser.add_argument(
        "--check", action="store_true", help="fail if a module would change"
    )
    args = parser.parse_args(argv)
    modules = Converter().build_modules()
    changed = []
    for module, schema in modules.items():
        path = SCHEMA_DIR / f"fluxnova_bpmn_{module}.yaml"
        text = dump_schema(schema, generated_by="scripts/bpmn_to_linkml.py")
        if args.check:
            if not path.is_file() or path.read_text(encoding="utf-8") != text:
                changed.append(path.name)
        else:
            path.write_text(text, encoding="utf-8")
    if changed:
        print("These modules differ from what the model API gives:", ", ".join(changed))
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
