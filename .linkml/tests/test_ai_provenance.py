"""Unit tests for the Fluxnova AI Workflow Provenance overlay schema.

Covers:

* Structural conformance via SchemaView (classes, inheritance, slot ranges,
  enum coverage, ontology mappings).
* Validation of curated valid fixtures against the AI overlay schema via
  ``linkml-validate``.
* Rejection of curated invalid fixtures by the same validator.

The AI provenance overlay is opt-in and NOT imported by
``fluxnova_bpm_platform.yaml``; these tests therefore validate against the
overlay schema directly under
``src/fluxnova_bpm_platform/schema/provenance/fluxnova_bpm_ai_provenance.yaml``
and live in their own fixture tree under ``tests/data/ai_provenance/`` so
they do not interfere with the master-schema parametrized tests in
``tests/test_data.py``.
"""

from __future__ import annotations

import glob
import os
import subprocess
from pathlib import Path

import pytest
from linkml_runtime.utils.schemaview import SchemaView


REPO_ROOT = Path(__file__).resolve().parent.parent
AI_OVERLAY_PATH = (
    REPO_ROOT
    / "src"
    / "fluxnova_bpm_platform"
    / "schema"
    / "provenance"
    / "fluxnova_bpm_ai_provenance.yaml"
)

DATA_DIR_VALID = Path(__file__).parent / "data" / "ai_provenance" / "valid"
DATA_DIR_INVALID = Path(__file__).parent / "data" / "ai_provenance" / "invalid"

VALID_FIXTURES = sorted(glob.glob(os.path.join(DATA_DIR_VALID, "*.yaml")))
INVALID_FIXTURES = sorted(glob.glob(os.path.join(DATA_DIR_INVALID, "*.yaml")))


# ---------------------------------------------------------------------------
# Shared fixtures
# ---------------------------------------------------------------------------


@pytest.fixture(scope="module")
def sv() -> SchemaView:
    """Module-scoped SchemaView over the AI provenance overlay."""
    assert AI_OVERLAY_PATH.exists(), (
        f"AI provenance overlay missing at {AI_OVERLAY_PATH}"
    )
    return SchemaView(str(AI_OVERLAY_PATH))


def _validate(filepath: str, target_class: str) -> subprocess.CompletedProcess:
    """Run ``linkml-validate`` against the AI overlay for a fixture."""
    return subprocess.run(
        [
            "linkml-validate",
            "--schema",
            str(AI_OVERLAY_PATH),
            "--target-class",
            target_class,
            filepath,
        ],
        capture_output=True,
        text=True,
    )


# ---------------------------------------------------------------------------
# Structural tests
# ---------------------------------------------------------------------------


class TestAiProvenanceStructure:
    """Schema-level structural conformance of the AI provenance overlay."""

    EXPECTED_CLASSES = {
        "AiAgent",
        "AiModelDescriptor",
        "AiModelInvocation",
        "PromptMessage",
        "ToolCall",
        "EvaluationResult",
        "AiDataset",
        "ModelArtifact",
    }

    EXPECTED_ENUMS = {
        "MessageRole",
        "AiModality",
        "AiInvocationKind",
        "SafetyFlag",
        "DatasetKind",
        "EvaluatorKind",
    }

    def test_all_expected_classes_present(self, sv):
        present = set(sv.all_classes(imports=False).keys())
        missing = self.EXPECTED_CLASSES - present
        assert not missing, (
            f"AI overlay is missing classes: {sorted(missing)}"
        )

    def test_all_expected_enums_present(self, sv):
        present = set(sv.all_enums(imports=False).keys())
        missing = self.EXPECTED_ENUMS - present
        assert not missing, (
            f"AI overlay is missing enums: {sorted(missing)}"
        )

    @pytest.mark.parametrize(
        "subclass,expected_ancestor",
        [
            ("AiAgent", "Agent"),
            ("AiModelDescriptor", "RuntimeComponent"),
            ("AiModelInvocation", "StepRun"),
            ("AiDataset", "WorkflowArtifact"),
            ("ModelArtifact", "WorkflowArtifact"),
            ("PromptMessage", "NamedThing"),
            ("ToolCall", "NamedThing"),
            ("EvaluationResult", "NamedThing"),
        ],
    )
    def test_inheritance_alignment(self, sv, subclass, expected_ancestor):
        assert sv.get_class(subclass) is not None, f"{subclass} not found"
        ancestors = sv.class_ancestors(subclass)
        assert expected_ancestor in ancestors, (
            f"{subclass} should inherit from {expected_ancestor} "
            f"(ancestors: {ancestors})"
        )

    def test_ai_model_invocation_inherits_step_run_slots(self, sv):
        """AiModelInvocation must expose StepRun's lifecycle slots."""
        induced = {s.name for s in sv.class_induced_slots("AiModelInvocation")}
        for slot in (
            "status",
            "started_at",
            "ended_at",
            "workflow_run",
            "sequence_no",
        ):
            assert slot in induced, (
                f"AiModelInvocation missing inherited StepRun slot '{slot}'"
            )

    def test_invocation_owns_ai_specific_slots(self, sv):
        induced = {s.name for s in sv.class_induced_slots("AiModelInvocation")}
        for slot in (
            "invoked_model",
            "invocation_kind",
            "prompt_messages",
            "tool_calls",
            "response_message",
            "temperature",
            "top_p",
            "max_tokens",
            "total_input_tokens",
            "total_output_tokens",
            "cost_usd",
            "safety_flags",
            "evaluation_results",
        ):
            assert slot in induced, (
                f"AiModelInvocation missing AI-specific slot '{slot}'"
            )

    @pytest.mark.parametrize(
        "slot_name,expected_range",
        [
            ("invoked_model", "AiAgent"),
            ("invocation_kind", "AiInvocationKind"),
            ("prompt_messages", "PromptMessage"),
            ("tool_calls", "ToolCall"),
            ("response_message", "PromptMessage"),
            ("evaluation_results", "EvaluationResult"),
            ("message_role", "MessageRole"),
            ("evaluator_kind", "EvaluatorKind"),
            ("dataset_kind", "DatasetKind"),
            ("safety_flags", "SafetyFlag"),
            ("input_modalities", "AiModality"),
            ("output_modalities", "AiModality"),
            ("parent_invocation", "AiModelInvocation"),
            ("evaluated_invocation", "AiModelInvocation"),
            ("base_model", "ModelArtifact"),
            ("result_artifact", "WorkflowArtifact"),
            ("called_step_run", "StepRun"),
            ("training_datasets", "AiDataset"),
        ],
    )
    def test_slot_ranges(self, sv, slot_name, expected_range):
        slot = sv.get_slot(slot_name)
        assert slot is not None, f"Slot {slot_name} not found"
        assert slot.range == expected_range, (
            f"{slot_name} range={slot.range!r}, expected {expected_range!r}"
        )

    @pytest.mark.parametrize(
        "slot_name",
        [
            "prompt_messages",
            "tool_calls",
            "evaluation_results",
            "input_modalities",
            "output_modalities",
            "safety_flags",
            "supported_languages",
            "training_datasets",
        ],
    )
    def test_multivalued_slots(self, sv, slot_name):
        slot = sv.get_slot(slot_name)
        assert slot is not None, f"Slot {slot_name} not found"
        assert slot.multivalued is True, (
            f"Slot {slot_name} should be multivalued"
        )

    @pytest.mark.parametrize(
        "slot_name,expected_inlined_as_list",
        [
            ("prompt_messages", True),
            ("tool_calls", True),
            ("evaluation_results", True),
        ],
    )
    def test_inlined_as_list_slots(self, sv, slot_name,
                                   expected_inlined_as_list):
        slot = sv.get_slot(slot_name)
        assert slot.inlined_as_list is expected_inlined_as_list, (
            f"Slot {slot_name} inlined_as_list="
            f"{slot.inlined_as_list}, expected {expected_inlined_as_list}"
        )

    def test_message_role_enum_values(self, sv):
        enum = sv.get_enum("MessageRole")
        assert set(enum.permissible_values.keys()) == {
            "SYSTEM", "USER", "ASSISTANT", "TOOL",
        }

    def test_invocation_kind_enum_values(self, sv):
        enum = sv.get_enum("AiInvocationKind")
        assert set(enum.permissible_values.keys()) == {
            "CHAT_COMPLETION",
            "COMPLETION",
            "EMBEDDING",
            "TOOL_USE",
            "AGENT_LOOP",
            "RETRIEVAL",
            "GUARDRAIL",
        }

    def test_safety_flag_enum_contains_core_flags(self, sv):
        enum = sv.get_enum("SafetyFlag")
        for value in (
            "POLICY_VIOLATION",
            "HALLUCINATION_SUSPECTED",
            "JAILBREAK_ATTEMPT",
            "PII_LEAK",
            "PROMPT_INJECTION",
            "TOXICITY",
        ):
            assert value in enum.permissible_values, (
                f"Missing SafetyFlag permissible value: {value}"
            )

    def test_evaluator_kind_enum_values(self, sv):
        enum = sv.get_enum("EvaluatorKind")
        assert set(enum.permissible_values.keys()) == {
            "HUMAN_REVIEW",
            "LLM_AS_JUDGE",
            "METRIC",
            "GUARDRAIL",
            "STATIC_RULE",
        }

    def test_dataset_kind_enum_values(self, sv):
        enum = sv.get_enum("DatasetKind")
        assert set(enum.permissible_values.keys()) == {
            "TRAINING",
            "FINE_TUNING",
            "EVALUATION",
            "RAG_CORPUS",
            "GROUND_TRUTH",
        }

    def test_ai_modality_enum_values(self, sv):
        enum = sv.get_enum("AiModality")
        assert set(enum.permissible_values.keys()) == {
            "TEXT", "IMAGE", "AUDIO", "VIDEO", "MULTIMODAL", "EMBEDDING",
        }

    def test_prov_mappings_on_invocation(self, sv):
        cls = sv.get_class("AiModelInvocation")
        assert "prov:Activity" in (cls.exact_mappings or []), (
            "AiModelInvocation must align with prov:Activity"
        )

    def test_nexus_mappings_on_agent_and_model_descriptor(self, sv):
        agent = sv.get_class("AiAgent")
        assert "nexus:AiAgent" in (agent.exact_mappings or []), (
            "AiAgent must align with nexus:AiAgent"
        )
        descriptor = sv.get_class("AiModelDescriptor")
        descriptor_mappings = set(descriptor.exact_mappings or [])
        assert any(m.startswith("nexus:") for m in descriptor_mappings), (
            f"AiModelDescriptor missing nexus mapping: {descriptor_mappings}"
        )

    def test_invoked_model_aligns_with_prov_was_associated_with(self, sv):
        slot = sv.get_slot("invoked_model")
        assert slot.slot_uri == "prov:wasAssociatedWith", (
            f"invoked_model.slot_uri={slot.slot_uri}, "
            "expected prov:wasAssociatedWith"
        )

    def test_base_model_aligns_with_prov_was_derived_from(self, sv):
        slot = sv.get_slot("base_model")
        assert slot.slot_uri == "prov:wasDerivedFrom"

    def test_subset_membership(self, sv):
        prospective = {"AiAgent", "AiModelDescriptor", "AiDataset",
                       "ModelArtifact"}
        retrospective = {"AiModelInvocation", "PromptMessage", "ToolCall",
                         "EvaluationResult"}
        for cls_name in prospective:
            cls = sv.get_class(cls_name)
            assert "ai_prospective" in (cls.in_subset or []), (
                f"{cls_name} should be in 'ai_prospective' subset"
            )
        for cls_name in retrospective:
            cls = sv.get_class(cls_name)
            assert "ai_retrospective" in (cls.in_subset or []), (
                f"{cls_name} should be in 'ai_retrospective' subset"
            )


# ---------------------------------------------------------------------------
# Fixture validation
# ---------------------------------------------------------------------------


class TestValidAiFixtures:
    """Curated valid fixtures must pass linkml-validate."""

    def test_fixtures_present(self):
        assert VALID_FIXTURES, (
            f"No valid AI provenance fixtures found under {DATA_DIR_VALID}"
        )

    @pytest.mark.parametrize(
        "filepath",
        VALID_FIXTURES,
        ids=[Path(f).name for f in VALID_FIXTURES],
    )
    def test_fixture_validates_clean(self, filepath):
        target_class = Path(filepath).stem.split("-")[0]
        result = _validate(filepath, target_class)
        assert result.returncode == 0, (
            f"Expected {Path(filepath).name} to validate clean against the "
            f"AI overlay (target_class={target_class}).\n"
            f"stdout:\n{result.stdout}\nstderr:\n{result.stderr}"
        )


class TestInvalidAiFixtures:
    """Curated invalid fixtures must fail linkml-validate."""

    def test_fixtures_present(self):
        assert INVALID_FIXTURES, (
            f"No invalid AI provenance fixtures found under {DATA_DIR_INVALID}"
        )

    @pytest.mark.parametrize(
        "filepath",
        INVALID_FIXTURES,
        ids=[Path(f).name for f in INVALID_FIXTURES],
    )
    def test_fixture_fails_validation(self, filepath):
        target_class = Path(filepath).stem.split("-")[0]
        result = _validate(filepath, target_class)
        assert result.returncode != 0, (
            f"Expected {Path(filepath).name} to FAIL validation against the "
            f"AI overlay (target_class={target_class}), but it passed.\n"
            f"stdout:\n{result.stdout}\nstderr:\n{result.stderr}"
        )
