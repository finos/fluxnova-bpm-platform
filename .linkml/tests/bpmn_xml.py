"""Read a BPMN XML file into the schema's shape, so that FINOS's files validate.

The reader finds each element's class by the ``xml_namespace`` and ``xml_name``
annotations the converter writes, and each attribute's and child's slot by its
``xml_name``. The reader puts a child in the slot whose range is its class or an
ancestor, with ``element_type`` naming its class where the two differ. A child that
only holds a reference, such as ``incoming``, gives its text to the slot of its name.
The reader reads Fluxnova's namespace, and Activiti's, which is deprecated, as
Camunda's, as the model API does. The schema models only the namespaces the model API
registers, so the reader leaves out, and counts in ``Reader.skipped``, the
attributes and elements of any other, which BPMN admits as foreign content.
"""

from __future__ import annotations

import xml.etree.ElementTree as ET
from collections import Counter
from functools import lru_cache

from linkml_runtime.utils.formatutils import items
from linkml_runtime.utils.schemaview import SchemaView

CAMUNDA = "http://camunda.org/schema/1.0/bpmn"
FLUXNOVA = "http://fluxnova.finos.org/schema/1.0/bpmn"
ACTIVITI = "http://activiti.org/bpmn"
XSI = "http://www.w3.org/2001/XMLSchema-instance"
ROOT = "BpmnModelElementInstance"


def _split(tag: str) -> tuple[str, str]:
    if tag.startswith("{"):
        namespace, local = tag[1:].split("}", 1)
        return namespace, local
    return "", tag


class Reader:
    def __init__(self, view: SchemaView) -> None:
        self.view = view
        self.classes: dict[tuple[str, str], str] = {}
        for cls in view.all_classes().values():
            notes = {k: v.value for k, v in cls.annotations.items()}
            if "xml_name" in notes:
                self.classes[(notes["xml_namespace"], notes["xml_name"])] = cls.name
        self.namespaces = {ns for ns, _ in self.classes} | {XSI}
        self.skipped: Counter[str] = Counter()

    @lru_cache(maxsize=None)
    def _slots(self, cls: str) -> tuple:
        return tuple(self.view.class_induced_slots(cls))

    @lru_cache(maxsize=None)
    def _ancestors(self, cls: str) -> frozenset[str]:
        return frozenset(self.view.class_ancestors(cls))

    @staticmethod
    def _note(slot, key: str) -> str | None:
        for tag, annotation in items(slot.annotations):
            if tag == key:
                return annotation.value
        return None

    def _namespace(self, namespace: str) -> str:
        return CAMUNDA if namespace in (FLUXNOVA, ACTIVITI) else namespace

    def _value(self, slot, text: str):
        if slot.range == "boolean":
            return text.strip() == "true"
        if slot.range == "integer":
            return int(text)
        if slot.range in ("double", "float"):
            return float(text)
        return text

    def read(self, element: ET.Element) -> tuple[str, dict]:
        """An element's class and its content, as a document of that class."""
        written, local = _split(element.tag)
        home = self._namespace(written)
        cls = self.classes.get((home, local)) or self.classes[(written, local)]
        slots = self._slots(cls)
        doc: dict = {}
        for name, text in element.attrib.items():
            raw, local = _split(name)
            namespace = self._namespace(raw)
            if namespace and namespace not in self.namespaces:
                self.skipped[f"attribute {{{namespace}}}{local}"] += 1
                continue
            # An attribute without a prefix is in its element's namespace when the
            # model API registers it there, as an extension element's own are.
            wanted = {raw, namespace} if namespace else {"", home, written}
            slot = next(
                (
                    s
                    for s in slots
                    if self._note(s, "xml_name") == local
                    and (self._note(s, "xml_namespace") or "") in wanted
                ),
                None,
            )
            if slot is None and namespace == XSI:
                # xsi:type and xsi:schemaLocation belong to XML Schema, which lets
                # them stand on any element. A class models one only where the
                # model API reads it, as a condition's xsi:type.
                self.skipped[f"attribute {{{namespace}}}{local}"] += 1
                continue
            if slot is None:
                raise KeyError(f"{cls} has no attribute {{{namespace}}}{local}")
            if slot.multivalued:
                doc[slot.name] = [self._value(slot, t) for t in text.split()]
            else:
                doc[slot.name] = self._value(slot, text)
        for child in element:
            if not isinstance(child.tag, str):
                continue  # a comment or a processing instruction
            namespace, local = _split(child.tag)
            namespace = self._namespace(namespace)
            if namespace not in self.namespaces:
                self.skipped[f"element {{{namespace}}}{local}"] += 1
                continue
            holder = next(
                (
                    s
                    for s in slots
                    if self._note(s, "refers_to") and self._note(s, "xml_name") == local
                ),
                None,
            )
            if holder is not None:
                self._add(doc, holder, (child.text or "").strip())
                continue
            child_cls, content = self.read(child)
            lineage = self._ancestors(child_cls)
            candidates = [s for s in slots if s.range in lineage]
            named = [s for s in candidates if self._note(s, "xml_name") == local]
            if not candidates:
                raise KeyError(f"{cls} has no child {child_cls}")
            slot = (named or candidates)[0]
            if slot.range != child_cls:
                content = {"element_type": child_cls, **content}
            self._add(doc, slot, content)
        text = (element.text or "").strip()
        if text:
            if not any(s.name == "text_content" for s in slots):
                raise KeyError(f"{cls} has no text")
            doc["text_content"] = text
        return cls, doc

    @staticmethod
    def _add(doc: dict, slot, value) -> None:
        if slot.multivalued:
            doc.setdefault(slot.name, []).append(value)
        elif slot.name in doc:
            raise ValueError(f"{slot.name} appears twice")
        else:
            doc[slot.name] = value
