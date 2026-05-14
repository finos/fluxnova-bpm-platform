# Auto generated from fluxnova_bpm_platform.yaml by pythongen.py version: 0.0.1
# Generation date: 2026-05-14T22:44:28
# Schema: fluxnova_bpm_platform
#
# id: https://w3id.org/TD-Universe/fluxnova-bpm-platform
# description: LinkML schema for the Fluxnova BPM Platform data model, covering process definitions, runtime execution, jobs, identity, history, and collaboration entities.
# license: Apache-2.0

import dataclasses
import re
from dataclasses import dataclass
from datetime import (
    date,
    datetime,
    time
)
from typing import (
    Any,
    ClassVar,
    Dict,
    List,
    Optional,
    Union
)

from jsonasobj2 import (
    JsonObj,
    as_dict
)
from linkml_runtime.linkml_model.meta import (
    EnumDefinition,
    PermissibleValue,
    PvFormulaOptions
)
from linkml_runtime.utils.curienamespace import CurieNamespace
from linkml_runtime.utils.enumerations import EnumDefinitionImpl
from linkml_runtime.utils.formatutils import (
    camelcase,
    sfx,
    underscore
)
from linkml_runtime.utils.metamodelcore import (
    bnode,
    empty_dict,
    empty_list
)
from linkml_runtime.utils.slot import Slot
from linkml_runtime.utils.yamlutils import (
    YAMLRoot,
    extended_float,
    extended_int,
    extended_str
)
from rdflib import (
    Namespace,
    URIRef
)

from linkml_runtime.linkml_model.types import Boolean, Datetime, Float, Integer, String
from linkml_runtime.utils.metamodelcore import Bool, XSDDateTime

metamodel_version = "1.11.0"
version = "3.0.0-SNAPSHOT"

# Namespaces
BPMN = CurieNamespace('bpmn', 'http://www.omg.org/spec/BPMN/20100524/MODEL#')
DCTERMS = CurieNamespace('dcterms', 'http://purl.org/dc/terms/')
FLUXNOVA_BPM_BASE = CurieNamespace('fluxnova_bpm_base', 'https://w3id.org/TD-Universe/fluxnova-bpm-platform/base/')
FLUXNOVA_BPM_COLLABORATION = CurieNamespace('fluxnova_bpm_collaboration', 'https://w3id.org/TD-Universe/fluxnova-bpm-platform/collaboration/')
FLUXNOVA_BPM_HISTORY = CurieNamespace('fluxnova_bpm_history', 'https://w3id.org/TD-Universe/fluxnova-bpm-platform/history/')
FLUXNOVA_BPM_IDENTITY = CurieNamespace('fluxnova_bpm_identity', 'https://w3id.org/TD-Universe/fluxnova-bpm-platform/identity/')
FLUXNOVA_BPM_JOB = CurieNamespace('fluxnova_bpm_job', 'https://w3id.org/TD-Universe/fluxnova-bpm-platform/job/')
FLUXNOVA_BPM_PLATFORM = CurieNamespace('fluxnova_bpm_platform', 'https://w3id.org/TD-Universe/fluxnova-bpm-platform/')
FLUXNOVA_BPM_REPOSITORY = CurieNamespace('fluxnova_bpm_repository', 'https://w3id.org/TD-Universe/fluxnova-bpm-platform/repository/')
FLUXNOVA_BPM_RUNTIME = CurieNamespace('fluxnova_bpm_runtime', 'https://w3id.org/TD-Universe/fluxnova-bpm-platform/runtime/')
FLUXNOVA_BPMN_MODEL = CurieNamespace('fluxnova_bpmn_model', 'https://w3id.org/TD-Universe/fluxnova-bpmn-model/fluxnova_bpmn_model/')
FLUXNOVA_BPMN_MODEL_BPMNDI = CurieNamespace('fluxnova_bpmn_model_bpmndi', 'https://w3id.org/TD-Universe/fluxnova-bpmn-model/fluxnova_bpmn_model_bpmndi/')
FLUXNOVA_BPMN_MODEL_DC = CurieNamespace('fluxnova_bpmn_model_dc', 'https://w3id.org/TD-Universe/fluxnova-bpmn-model/fluxnova_bpmn_model_dc/')
FLUXNOVA_BPMN_MODEL_DI = CurieNamespace('fluxnova_bpmn_model_di', 'https://w3id.org/TD-Universe/fluxnova-bpmn-model/fluxnova_bpmn_model_di/')
FLUXNOVA_BPMN_MODEL_FLUXNOVA = CurieNamespace('fluxnova_bpmn_model_fluxnova', 'https://w3id.org/TD-Universe/fluxnova-bpmn-model/fluxnova_bpmn_model_fluxnova/')
FLUXNOVA_BPMN_MODEL_INSTANCE = CurieNamespace('fluxnova_bpmn_model_instance', 'https://w3id.org/TD-Universe/fluxnova-bpmn-model/fluxnova_bpmn_model_instance/')
FLUXNOVA_COMMON = CurieNamespace('fluxnova_common', 'https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_common/')
LINKML = CurieNamespace('linkml', 'https://w3id.org/linkml/')
SCHEMA = CurieNamespace('schema', 'http://schema.org/')
DEFAULT_ = FLUXNOVA_BPM_PLATFORM


# Types

# Class references
class ByteArrayId(extended_str):
    pass


class MeterLogId(extended_str):
    pass


class PropertyName(extended_str):
    pass


class SchemaLogEntryId(extended_str):
    pass


class TaskMeterLogId(extended_str):
    pass


class AttachmentId(extended_str):
    pass


class CommentId(extended_str):
    pass


class FilterId(extended_str):
    pass


class HistoricBatchId(extended_str):
    pass


class HistoricDecisionInputInstanceId(extended_str):
    pass


class HistoricDecisionInstanceId(extended_str):
    pass


class HistoricDecisionOutputInstanceId(extended_str):
    pass


class HistoricDetailId(extended_str):
    pass


class HistoricExternalTaskLogId(extended_str):
    pass


class HistoricIdentityLinkId(extended_str):
    pass


class HistoricIncidentId(extended_str):
    pass


class HistoricJobLogId(extended_str):
    pass


class HistoricScopeInstanceId(extended_str):
    pass


class HistoricActivityInstanceId(HistoricScopeInstanceId):
    pass


class HistoricCaseActivityInstanceId(HistoricScopeInstanceId):
    pass


class HistoricCaseInstanceId(HistoricScopeInstanceId):
    pass


class HistoricProcessInstanceId(HistoricScopeInstanceId):
    pass


class HistoricTaskInstanceId(HistoricScopeInstanceId):
    pass


class HistoricVariableInstanceId(extended_str):
    pass


class UserOperationLogEntryId(extended_str):
    pass


class AuthorizationId(extended_str):
    pass


class GroupId(extended_str):
    pass


class IdentityInfoId(extended_str):
    pass


class IdentityLinkId(extended_str):
    pass


class TenantId(extended_str):
    pass


class TenantMembershipId(extended_str):
    pass


class UserId(extended_str):
    pass


class BatchId(extended_str):
    pass


class JobId(extended_str):
    pass


class JobDefinitionId(extended_str):
    pass


class DeploymentId(extended_str):
    pass


class ResourceDefinitionId(extended_str):
    pass


class CaseDefinitionId(ResourceDefinitionId):
    pass


class DecisionDefinitionId(ResourceDefinitionId):
    pass


class DecisionRequirementsDefinitionId(ResourceDefinitionId):
    pass


class FormDefinitionId(ResourceDefinitionId):
    pass


class ProcessDefinitionId(ResourceDefinitionId):
    pass


class CaseExecutionId(extended_str):
    pass


class CaseSentryPartId(extended_str):
    pass


class EventSubscriptionId(extended_str):
    pass


class ExecutionId(extended_str):
    pass


class ExternalTaskId(extended_str):
    pass


class IncidentId(extended_str):
    pass


class TaskId(extended_str):
    pass


class VariableInstanceId(extended_str):
    pass


class DiagramId(extended_str):
    pass


class DiagramElementId(extended_str):
    pass


class EdgeId(DiagramElementId):
    pass


class LabeledEdgeId(EdgeId):
    pass


class NodeId(DiagramElementId):
    pass


class LabelId(NodeId):
    pass


class PlaneId(NodeId):
    pass


class ShapeId(NodeId):
    pass


class LabeledShapeId(ShapeId):
    pass


class StyleId(extended_str):
    pass


class BaseElementId(extended_str):
    pass


class ArtifactId(BaseElementId):
    pass


class AssignmentId(BaseElementId):
    pass


class AssociationId(ArtifactId):
    pass


class AuditingId(BaseElementId):
    pass


class CategoryValueId(BaseElementId):
    pass


class ComplexBehaviorDefinitionId(BaseElementId):
    pass


class ConversationAssociationId(BaseElementId):
    pass


class ConversationLinkId(BaseElementId):
    pass


class ConversationNodeId(BaseElementId):
    pass


class CallConversationId(ConversationNodeId):
    pass


class ConversationId(ConversationNodeId):
    pass


class CorrelationKeyId(BaseElementId):
    pass


class CorrelationPropertyBindingId(BaseElementId):
    pass


class CorrelationPropertyRetrievalExpressionId(BaseElementId):
    pass


class CorrelationSubscriptionId(BaseElementId):
    pass


class DataAssociationId(BaseElementId):
    pass


class DataInputAssociationId(DataAssociationId):
    pass


class DataOutputAssociationId(DataAssociationId):
    pass


class DataStateId(BaseElementId):
    pass


class DefinitionsId(extended_str):
    pass


class DocumentationId(extended_str):
    pass


class ExpressionId(BaseElementId):
    pass


class ActivationConditionId(ExpressionId):
    pass


class CompletionConditionId(ExpressionId):
    pass


class ConditionId(ExpressionId):
    pass


class FlowElementId(BaseElementId):
    pass


class DataObjectId(FlowElementId):
    pass


class DataObjectReferenceId(FlowElementId):
    pass


class DataStoreReferenceId(FlowElementId):
    pass


class FlowNodeId(FlowElementId):
    pass


class ActivityId(FlowNodeId):
    pass


class CallActivityId(ActivityId):
    pass


class EventId(FlowNodeId):
    pass


class CatchEventId(EventId):
    pass


class BoundaryEventId(CatchEventId):
    pass


class FormalExpressionId(ExpressionId):
    pass


class ConditionExpressionId(FormalExpressionId):
    pass


class GatewayId(FlowNodeId):
    pass


class ComplexGatewayId(GatewayId):
    pass


class EventBasedGatewayId(GatewayId):
    pass


class ExclusiveGatewayId(GatewayId):
    pass


class BpmnGroupId(ArtifactId):
    pass


class InclusiveGatewayId(GatewayId):
    pass


class InputSetId(BaseElementId):
    pass


class InteractionNodeId(extended_str):
    pass


class IntermediateCatchEventId(CatchEventId):
    pass


class IoBindingId(BaseElementId):
    pass


class IoSpecificationId(BaseElementId):
    pass


class ItemAwareElementId(BaseElementId):
    pass


class DataInputId(ItemAwareElementId):
    pass


class DataOutputId(ItemAwareElementId):
    pass


class InputDataItemId(DataInputId):
    pass


class LaneId(BaseElementId):
    pass


class LaneSetId(BaseElementId):
    pass


class LoopCardinalityId(ExpressionId):
    pass


class LoopCharacteristicsId(BaseElementId):
    pass


class MessageFlowId(BaseElementId):
    pass


class MessageFlowAssociationId(BaseElementId):
    pass


class MonitoringId(BaseElementId):
    pass


class MultiInstanceLoopCharacteristicsId(LoopCharacteristicsId):
    pass


class OperationId(BaseElementId):
    pass


class OutputDataItemId(DataOutputId):
    pass


class OutputSetId(BaseElementId):
    pass


class ParallelGatewayId(GatewayId):
    pass


class ParticipantId(BaseElementId):
    pass


class ParticipantAssociationId(BaseElementId):
    pass


class ParticipantMultiplicityId(BaseElementId):
    pass


class BpmnPropertyId(ItemAwareElementId):
    pass


class RelationshipId(BaseElementId):
    pass


class RenderingId(BaseElementId):
    pass


class ResourceAssignmentExpressionId(BaseElementId):
    pass


class ResourceParameterId(BaseElementId):
    pass


class ResourceParameterBindingId(BaseElementId):
    pass


class ResourceRoleId(BaseElementId):
    pass


class PerformerId(ResourceRoleId):
    pass


class HumanPerformerId(PerformerId):
    pass


class PotentialOwnerId(HumanPerformerId):
    pass


class RootElementId(BaseElementId):
    pass


class CallableElementId(RootElementId):
    pass


class CategoryId(RootElementId):
    pass


class CollaborationId(RootElementId):
    pass


class CorrelationPropertyId(RootElementId):
    pass


class DataStoreId(RootElementId):
    pass


class EndPointId(RootElementId):
    pass


class ErrorId(RootElementId):
    pass


class EscalationId(RootElementId):
    pass


class EventDefinitionId(RootElementId):
    pass


class CancelEventDefinitionId(EventDefinitionId):
    pass


class CompensateEventDefinitionId(EventDefinitionId):
    pass


class ConditionalEventDefinitionId(EventDefinitionId):
    pass


class ErrorEventDefinitionId(EventDefinitionId):
    pass


class EscalationEventDefinitionId(EventDefinitionId):
    pass


class GlobalConversationId(CollaborationId):
    pass


class InterfaceId(RootElementId):
    pass


class ItemDefinitionId(RootElementId):
    pass


class LinkEventDefinitionId(EventDefinitionId):
    pass


class MessageId(RootElementId):
    pass


class MessageEventDefinitionId(EventDefinitionId):
    pass


class ProcessId(CallableElementId):
    pass


class ResourceId(RootElementId):
    pass


class SequenceFlowId(FlowElementId):
    pass


class SignalId(RootElementId):
    pass


class SignalEventDefinitionId(EventDefinitionId):
    pass


class StartEventId(CatchEventId):
    pass


class SubConversationId(ConversationNodeId):
    pass


class SubProcessId(ActivityId):
    pass


class BpmnTaskId(ActivityId):
    pass


class BusinessRuleTaskId(BpmnTaskId):
    pass


class ManualTaskId(BpmnTaskId):
    pass


class ReceiveTaskId(BpmnTaskId):
    pass


class ScriptTaskId(BpmnTaskId):
    pass


class SendTaskId(BpmnTaskId):
    pass


class ServiceTaskId(BpmnTaskId):
    pass


class TerminateEventDefinitionId(EventDefinitionId):
    pass


class TextAnnotationId(ArtifactId):
    pass


class ThrowEventId(EventId):
    pass


class EndEventId(ThrowEventId):
    pass


class IntermediateThrowEventId(ThrowEventId):
    pass


class TimeCycleId(ExpressionId):
    pass


class TimeDateId(ExpressionId):
    pass


class TimeDurationId(ExpressionId):
    pass


class TimerEventDefinitionId(EventDefinitionId):
    pass


class TransactionId(SubProcessId):
    pass


class UserTaskId(BpmnTaskId):
    pass


class BpmnDiagramId(DiagramId):
    pass


class BpmnEdgeId(LabeledEdgeId):
    pass


class BpmnLabelId(LabelId):
    pass


class BpmnLabelStyleId(StyleId):
    pass


class BpmnPlaneId(PlaneId):
    pass


class BpmnShapeId(LabeledShapeId):
    pass


class FluxnovaErrorEventDefinitionId(ErrorEventDefinitionId):
    pass


@dataclass(repr=False)
class FluxnovaPlatformData(YAMLRoot):
    """
    Root container for Fluxnova BPM Platform data.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaPlatformData"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaPlatformData"
    class_name: ClassVar[str] = "FluxnovaPlatformData"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData

    deployments: Optional[Union[dict[Union[str, DeploymentId], Union[dict, "Deployment"]], list[Union[dict, "Deployment"]]]] = empty_dict()
    process_definitions: Optional[Union[dict[Union[str, ProcessDefinitionId], Union[dict, "ProcessDefinition"]], list[Union[dict, "ProcessDefinition"]]]] = empty_dict()
    executions: Optional[Union[dict[Union[str, ExecutionId], Union[dict, "Execution"]], list[Union[dict, "Execution"]]]] = empty_dict()
    tasks: Optional[Union[dict[Union[str, TaskId], Union[dict, "Task"]], list[Union[dict, "Task"]]]] = empty_dict()
    jobs: Optional[Union[dict[Union[str, JobId], Union[dict, "Job"]], list[Union[dict, "Job"]]]] = empty_dict()
    users: Optional[Union[dict[Union[str, UserId], Union[dict, "User"]], list[Union[dict, "User"]]]] = empty_dict()
    groups: Optional[Union[dict[Union[str, GroupId], Union[dict, "Group"]], list[Union[dict, "Group"]]]] = empty_dict()
    batches: Optional[Union[dict[Union[str, BatchId], Union[dict, "Batch"]], list[Union[dict, "Batch"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        self._normalize_inlined_as_list(slot_name="deployments", slot_type=Deployment, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="process_definitions", slot_type=ProcessDefinition, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="executions", slot_type=Execution, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="tasks", slot_type=Task, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="jobs", slot_type=Job, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="users", slot_type=User, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="groups", slot_type=Group, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="batches", slot_type=Batch, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ByteArray(YAMLRoot):
    """
    Byte Array entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_BASE["ByteArray"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_base:ByteArray"
    class_name: ClassVar[str] = "ByteArray"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ByteArray

    id: Union[str, ByteArrayId] = None
    name: Optional[str] = None
    deployment_id: Optional[str] = None
    bytes: Optional[str] = None
    is_generated: Optional[Union[bool, Bool]] = None
    tenant_id: Optional[str] = None
    type: Optional[int] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    root_process_instance_id: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ByteArrayId):
            self.id = ByteArrayId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.deployment_id is not None and not isinstance(self.deployment_id, str):
            self.deployment_id = str(self.deployment_id)

        if self.bytes is not None and not isinstance(self.bytes, str):
            self.bytes = str(self.bytes)

        if self.is_generated is not None and not isinstance(self.is_generated, Bool):
            self.is_generated = Bool(self.is_generated)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.type is not None and not isinstance(self.type, int):
            self.type = int(self.type)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class MeterLog(YAMLRoot):
    """
    Meter Log entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_BASE["MeterLog"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_base:MeterLog"
    class_name: ClassVar[str] = "MeterLog"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.MeterLog

    id: Union[str, MeterLogId] = None
    name: str = None
    reporter: Optional[str] = None
    value: Optional[int] = None
    timestamp: Optional[Union[str, XSDDateTime]] = None
    milliseconds: Optional[int] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, MeterLogId):
            self.id = MeterLogId(self.id)

        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if self.reporter is not None and not isinstance(self.reporter, str):
            self.reporter = str(self.reporter)

        if self.value is not None and not isinstance(self.value, int):
            self.value = int(self.value)

        if self.timestamp is not None and not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

        if self.milliseconds is not None and not isinstance(self.milliseconds, int):
            self.milliseconds = int(self.milliseconds)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Property(YAMLRoot):
    """
    Property entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_BASE["Property"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_base:Property"
    class_name: ClassVar[str] = "Property"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Property

    name: Union[str, PropertyName] = None
    value: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, PropertyName):
            self.name = PropertyName(self.name)

        if self.value is not None and not isinstance(self.value, str):
            self.value = str(self.value)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class SchemaLogEntry(YAMLRoot):
    """
    Schema Log Entry entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_BASE["SchemaLogEntry"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_base:SchemaLogEntry"
    class_name: ClassVar[str] = "SchemaLogEntry"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.SchemaLogEntry

    id: Union[str, SchemaLogEntryId] = None
    timestamp: Optional[Union[str, XSDDateTime]] = None
    version: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, SchemaLogEntryId):
            self.id = SchemaLogEntryId(self.id)

        if self.timestamp is not None and not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

        if self.version is not None and not isinstance(self.version, str):
            self.version = str(self.version)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class TaskMeterLog(YAMLRoot):
    """
    Task Meter Log entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_BASE["TaskMeterLog"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_base:TaskMeterLog"
    class_name: ClassVar[str] = "TaskMeterLog"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.TaskMeterLog

    id: Union[str, TaskMeterLogId] = None
    assignee_hash: Optional[int] = None
    timestamp: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TaskMeterLogId):
            self.id = TaskMeterLogId(self.id)

        if self.assignee_hash is not None and not isinstance(self.assignee_hash, int):
            self.assignee_hash = int(self.assignee_hash)

        if self.timestamp is not None and not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Attachment(YAMLRoot):
    """
    Any type of content that is be associated with a task or with a process instance.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_COLLABORATION["Attachment"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_collaboration:Attachment"
    class_name: ClassVar[str] = "Attachment"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Attachment

    id: Union[str, AttachmentId] = None
    user_id: Optional[str] = None
    name: Optional[str] = None
    description: Optional[str] = None
    type: Optional[str] = None
    task_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    url: Optional[str] = None
    content_id: Optional[str] = None
    tenant_id: Optional[str] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, AttachmentId):
            self.id = AttachmentId(self.id)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.description is not None and not isinstance(self.description, str):
            self.description = str(self.description)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.url is not None and not isinstance(self.url, str):
            self.url = str(self.url)

        if self.content_id is not None and not isinstance(self.content_id, str):
            self.content_id = str(self.content_id)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Comment(YAMLRoot):
    """
    User comments that form discussions around tasks.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_COLLABORATION["Comment"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_collaboration:Comment"
    class_name: ClassVar[str] = "Comment"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Comment

    id: Union[str, CommentId] = None
    event_time: Union[str, XSDDateTime] = None
    type: Optional[str] = None
    user_id: Optional[str] = None
    task_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    action: Optional[str] = None
    message: Optional[str] = None
    full_message: Optional[str] = None
    tenant_id: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CommentId):
            self.id = CommentId(self.id)

        if self._is_empty(self.event_time):
            self.MissingRequiredField("event_time")
        if not isinstance(self.event_time, XSDDateTime):
            self.event_time = XSDDateTime(self.event_time)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.action is not None and not isinstance(self.action, str):
            self.action = str(self.action)

        if self.message is not None and not isinstance(self.message, str):
            self.message = str(self.message)

        if self.full_message is not None and not isinstance(self.full_message, str):
            self.full_message = str(self.full_message)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Filter(YAMLRoot):
    """
    Filter entity in the user collaboration.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_COLLABORATION["Filter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_collaboration:Filter"
    class_name: ClassVar[str] = "Filter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Filter

    id: Union[str, FilterId] = None
    resource_type: str = None
    name: str = None
    query: str = None
    owner: Optional[str] = None
    properties: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FilterId):
            self.id = FilterId(self.id)

        if self._is_empty(self.resource_type):
            self.MissingRequiredField("resource_type")
        if not isinstance(self.resource_type, str):
            self.resource_type = str(self.resource_type)

        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if self._is_empty(self.query):
            self.MissingRequiredField("query")
        if not isinstance(self.query, str):
            self.query = str(self.query)

        if self.owner is not None and not isinstance(self.owner, str):
            self.owner = str(self.owner)

        if self.properties is not None and not isinstance(self.properties, str):
            self.properties = str(self.properties)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricBatch(YAMLRoot):
    """
    Historic representation of a org.finos.fluxnova.bpm.engine.batch.Batch.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricBatch"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricBatch"
    class_name: ClassVar[str] = "HistoricBatch"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricBatch

    id: Union[str, HistoricBatchId] = None
    start_time: Union[str, XSDDateTime] = None
    type: Optional[str] = None
    total_jobs: Optional[int] = None
    jobs_per_seed: Optional[int] = None
    invocations_per_job: Optional[int] = None
    seed_job_definition_id: Optional[str] = None
    monitor_job_definition_id: Optional[str] = None
    batch_job_definition_id: Optional[str] = None
    tenant_id: Optional[str] = None
    create_user_id: Optional[str] = None
    end_time: Optional[Union[str, XSDDateTime]] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    execution_start_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricBatchId):
            self.id = HistoricBatchId(self.id)

        if self._is_empty(self.start_time):
            self.MissingRequiredField("start_time")
        if not isinstance(self.start_time, XSDDateTime):
            self.start_time = XSDDateTime(self.start_time)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.total_jobs is not None and not isinstance(self.total_jobs, int):
            self.total_jobs = int(self.total_jobs)

        if self.jobs_per_seed is not None and not isinstance(self.jobs_per_seed, int):
            self.jobs_per_seed = int(self.jobs_per_seed)

        if self.invocations_per_job is not None and not isinstance(self.invocations_per_job, int):
            self.invocations_per_job = int(self.invocations_per_job)

        if self.seed_job_definition_id is not None and not isinstance(self.seed_job_definition_id, str):
            self.seed_job_definition_id = str(self.seed_job_definition_id)

        if self.monitor_job_definition_id is not None and not isinstance(self.monitor_job_definition_id, str):
            self.monitor_job_definition_id = str(self.monitor_job_definition_id)

        if self.batch_job_definition_id is not None and not isinstance(self.batch_job_definition_id, str):
            self.batch_job_definition_id = str(self.batch_job_definition_id)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.create_user_id is not None and not isinstance(self.create_user_id, str):
            self.create_user_id = str(self.create_user_id)

        if self.end_time is not None and not isinstance(self.end_time, XSDDateTime):
            self.end_time = XSDDateTime(self.end_time)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.execution_start_time is not None and not isinstance(self.execution_start_time, XSDDateTime):
            self.execution_start_time = XSDDateTime(self.execution_start_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricDecisionInputInstance(YAMLRoot):
    """
    Represents one input variable of a decision evaluation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricDecisionInputInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricDecisionInputInstance"
    class_name: ClassVar[str] = "HistoricDecisionInputInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricDecisionInputInstance

    id: Union[str, HistoricDecisionInputInstanceId] = None
    decision_instance_id: str = None
    clause_id: Optional[str] = None
    clause_name: Optional[str] = None
    variable_type: Optional[str] = None
    byte_array_id: Optional[str] = None
    double_value: Optional[float] = None
    long_value: Optional[int] = None
    text_value: Optional[str] = None
    text2_value: Optional[str] = None
    tenant_id: Optional[str] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    root_process_instance_id: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricDecisionInputInstanceId):
            self.id = HistoricDecisionInputInstanceId(self.id)

        if self._is_empty(self.decision_instance_id):
            self.MissingRequiredField("decision_instance_id")
        if not isinstance(self.decision_instance_id, str):
            self.decision_instance_id = str(self.decision_instance_id)

        if self.clause_id is not None and not isinstance(self.clause_id, str):
            self.clause_id = str(self.clause_id)

        if self.clause_name is not None and not isinstance(self.clause_name, str):
            self.clause_name = str(self.clause_name)

        if self.variable_type is not None and not isinstance(self.variable_type, str):
            self.variable_type = str(self.variable_type)

        if self.byte_array_id is not None and not isinstance(self.byte_array_id, str):
            self.byte_array_id = str(self.byte_array_id)

        if self.double_value is not None and not isinstance(self.double_value, float):
            self.double_value = float(self.double_value)

        if self.long_value is not None and not isinstance(self.long_value, int):
            self.long_value = int(self.long_value)

        if self.text_value is not None and not isinstance(self.text_value, str):
            self.text_value = str(self.text_value)

        if self.text2_value is not None and not isinstance(self.text2_value, str):
            self.text2_value = str(self.text2_value)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricDecisionInstance(YAMLRoot):
    """
    Represents one evaluation of a decision.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricDecisionInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricDecisionInstance"
    class_name: ClassVar[str] = "HistoricDecisionInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricDecisionInstance

    id: Union[str, HistoricDecisionInstanceId] = None
    decision_definition_id: str = None
    decision_definition_key: str = None
    evaluation_time: Union[str, XSDDateTime] = None
    decision_definition_name: Optional[str] = None
    process_definition_key: Optional[str] = None
    process_definition_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    case_definition_key: Optional[str] = None
    case_definition_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    activity_instance_id: Optional[str] = None
    activity_id: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    collect_result_value: Optional[float] = None
    user_id: Optional[str] = None
    root_decision_instance_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    decision_requirements_definition_id: Optional[str] = None
    decision_requirements_definition_key: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricDecisionInstanceId):
            self.id = HistoricDecisionInstanceId(self.id)

        if self._is_empty(self.decision_definition_id):
            self.MissingRequiredField("decision_definition_id")
        if not isinstance(self.decision_definition_id, str):
            self.decision_definition_id = str(self.decision_definition_id)

        if self._is_empty(self.decision_definition_key):
            self.MissingRequiredField("decision_definition_key")
        if not isinstance(self.decision_definition_key, str):
            self.decision_definition_key = str(self.decision_definition_key)

        if self._is_empty(self.evaluation_time):
            self.MissingRequiredField("evaluation_time")
        if not isinstance(self.evaluation_time, XSDDateTime):
            self.evaluation_time = XSDDateTime(self.evaluation_time)

        if self.decision_definition_name is not None and not isinstance(self.decision_definition_name, str):
            self.decision_definition_name = str(self.decision_definition_name)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.case_definition_key is not None and not isinstance(self.case_definition_key, str):
            self.case_definition_key = str(self.case_definition_key)

        if self.case_definition_id is not None and not isinstance(self.case_definition_id, str):
            self.case_definition_id = str(self.case_definition_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.activity_instance_id is not None and not isinstance(self.activity_instance_id, str):
            self.activity_instance_id = str(self.activity_instance_id)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.collect_result_value is not None and not isinstance(self.collect_result_value, float):
            self.collect_result_value = float(self.collect_result_value)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.root_decision_instance_id is not None and not isinstance(self.root_decision_instance_id, str):
            self.root_decision_instance_id = str(self.root_decision_instance_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.decision_requirements_definition_id is not None and not isinstance(self.decision_requirements_definition_id, str):
            self.decision_requirements_definition_id = str(self.decision_requirements_definition_id)

        if self.decision_requirements_definition_key is not None and not isinstance(self.decision_requirements_definition_key, str):
            self.decision_requirements_definition_key = str(self.decision_requirements_definition_key)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricDecisionOutputInstance(YAMLRoot):
    """
    Represents one output variable of a decision evaluation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricDecisionOutputInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricDecisionOutputInstance"
    class_name: ClassVar[str] = "HistoricDecisionOutputInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricDecisionOutputInstance

    id: Union[str, HistoricDecisionOutputInstanceId] = None
    decision_instance_id: str = None
    clause_id: Optional[str] = None
    clause_name: Optional[str] = None
    rule_id: Optional[str] = None
    rule_order: Optional[int] = None
    variable_name: Optional[str] = None
    variable_type: Optional[str] = None
    byte_array_id: Optional[str] = None
    double_value: Optional[float] = None
    long_value: Optional[int] = None
    text_value: Optional[str] = None
    text2_value: Optional[str] = None
    tenant_id: Optional[str] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    root_process_instance_id: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricDecisionOutputInstanceId):
            self.id = HistoricDecisionOutputInstanceId(self.id)

        if self._is_empty(self.decision_instance_id):
            self.MissingRequiredField("decision_instance_id")
        if not isinstance(self.decision_instance_id, str):
            self.decision_instance_id = str(self.decision_instance_id)

        if self.clause_id is not None and not isinstance(self.clause_id, str):
            self.clause_id = str(self.clause_id)

        if self.clause_name is not None and not isinstance(self.clause_name, str):
            self.clause_name = str(self.clause_name)

        if self.rule_id is not None and not isinstance(self.rule_id, str):
            self.rule_id = str(self.rule_id)

        if self.rule_order is not None and not isinstance(self.rule_order, int):
            self.rule_order = int(self.rule_order)

        if self.variable_name is not None and not isinstance(self.variable_name, str):
            self.variable_name = str(self.variable_name)

        if self.variable_type is not None and not isinstance(self.variable_type, str):
            self.variable_type = str(self.variable_type)

        if self.byte_array_id is not None and not isinstance(self.byte_array_id, str):
            self.byte_array_id = str(self.byte_array_id)

        if self.double_value is not None and not isinstance(self.double_value, float):
            self.double_value = float(self.double_value)

        if self.long_value is not None and not isinstance(self.long_value, int):
            self.long_value = int(self.long_value)

        if self.text_value is not None and not isinstance(self.text_value, str):
            self.text_value = str(self.text_value)

        if self.text2_value is not None and not isinstance(self.text2_value, str):
            self.text2_value = str(self.text2_value)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricDetail(YAMLRoot):
    """
    Base class for all kinds of information that is related to either a HistoricProcessInstance or a
    HistoricActivityInstance.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricDetail"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricDetail"
    class_name: ClassVar[str] = "HistoricDetail"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricDetail

    id: Union[str, HistoricDetailId] = None
    type: str = None
    event_time: Union[str, XSDDateTime] = None
    name: str = None
    process_definition_key: Optional[str] = None
    process_definition_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    execution_id: Optional[str] = None
    case_definition_key: Optional[str] = None
    case_definition_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    case_execution_id: Optional[str] = None
    task_id: Optional[str] = None
    activity_instance_id: Optional[str] = None
    variable_instance_id: Optional[str] = None
    variable_type: Optional[str] = None
    byte_array_id: Optional[str] = None
    double_value: Optional[float] = None
    long_value: Optional[int] = None
    text_value: Optional[str] = None
    text2_value: Optional[str] = None
    sequence_counter: Optional[int] = None
    tenant_id: Optional[str] = None
    operation_id: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    is_initial: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricDetailId):
            self.id = HistoricDetailId(self.id)

        if self._is_empty(self.type):
            self.MissingRequiredField("type")
        if not isinstance(self.type, str):
            self.type = str(self.type)

        if self._is_empty(self.event_time):
            self.MissingRequiredField("event_time")
        if not isinstance(self.event_time, XSDDateTime):
            self.event_time = XSDDateTime(self.event_time)

        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.case_definition_key is not None and not isinstance(self.case_definition_key, str):
            self.case_definition_key = str(self.case_definition_key)

        if self.case_definition_id is not None and not isinstance(self.case_definition_id, str):
            self.case_definition_id = str(self.case_definition_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, str):
            self.case_execution_id = str(self.case_execution_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.activity_instance_id is not None and not isinstance(self.activity_instance_id, str):
            self.activity_instance_id = str(self.activity_instance_id)

        if self.variable_instance_id is not None and not isinstance(self.variable_instance_id, str):
            self.variable_instance_id = str(self.variable_instance_id)

        if self.variable_type is not None and not isinstance(self.variable_type, str):
            self.variable_type = str(self.variable_type)

        if self.byte_array_id is not None and not isinstance(self.byte_array_id, str):
            self.byte_array_id = str(self.byte_array_id)

        if self.double_value is not None and not isinstance(self.double_value, float):
            self.double_value = float(self.double_value)

        if self.long_value is not None and not isinstance(self.long_value, int):
            self.long_value = int(self.long_value)

        if self.text_value is not None and not isinstance(self.text_value, str):
            self.text_value = str(self.text_value)

        if self.text2_value is not None and not isinstance(self.text2_value, str):
            self.text2_value = str(self.text2_value)

        if self.sequence_counter is not None and not isinstance(self.sequence_counter, int):
            self.sequence_counter = int(self.sequence_counter)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.operation_id is not None and not isinstance(self.operation_id, str):
            self.operation_id = str(self.operation_id)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.is_initial is not None and not isinstance(self.is_initial, Bool):
            self.is_initial = Bool(self.is_initial)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricExternalTaskLog(YAMLRoot):
    """
    The HistoricExternalTaskLog is used to have a log containing information about ExternalTask task execution. The
    log provides details about the last lifecycle state of a ExternalTask task: An instan...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricExternalTaskLog"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricExternalTaskLog"
    class_name: ClassVar[str] = "HistoricExternalTaskLog"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricExternalTaskLog

    id: Union[str, HistoricExternalTaskLogId] = None
    timestamp: Union[str, XSDDateTime] = None
    external_task_id: str = None
    priority: int = None
    retries: Optional[int] = None
    topic_name: Optional[str] = None
    worker_id: Optional[str] = None
    error_message: Optional[str] = None
    error_details_id: Optional[str] = None
    activity_id: Optional[str] = None
    activity_instance_id: Optional[str] = None
    execution_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    tenant_id: Optional[str] = None
    state: Optional[Union[str, "EntityState"]] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricExternalTaskLogId):
            self.id = HistoricExternalTaskLogId(self.id)

        if self._is_empty(self.timestamp):
            self.MissingRequiredField("timestamp")
        if not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

        if self._is_empty(self.external_task_id):
            self.MissingRequiredField("external_task_id")
        if not isinstance(self.external_task_id, str):
            self.external_task_id = str(self.external_task_id)

        if self._is_empty(self.priority):
            self.MissingRequiredField("priority")
        if not isinstance(self.priority, int):
            self.priority = int(self.priority)

        if self.retries is not None and not isinstance(self.retries, int):
            self.retries = int(self.retries)

        if self.topic_name is not None and not isinstance(self.topic_name, str):
            self.topic_name = str(self.topic_name)

        if self.worker_id is not None and not isinstance(self.worker_id, str):
            self.worker_id = str(self.worker_id)

        if self.error_message is not None and not isinstance(self.error_message, str):
            self.error_message = str(self.error_message)

        if self.error_details_id is not None and not isinstance(self.error_details_id, str):
            self.error_details_id = str(self.error_details_id)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.activity_instance_id is not None and not isinstance(self.activity_instance_id, str):
            self.activity_instance_id = str(self.activity_instance_id)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.state is not None and not isinstance(self.state, EntityState):
            self.state = EntityState(self.state)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricIdentityLink(YAMLRoot):
    """
    An historic identity link stores the association of a task with a certain identity. For example, historic identity
    link is logged on the following conditions: - a user can be an assignee/Candidate/...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricIdentityLink"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricIdentityLink"
    class_name: ClassVar[str] = "HistoricIdentityLink"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricIdentityLink

    id: Union[str, HistoricIdentityLinkId] = None
    timestamp: Union[str, XSDDateTime] = None
    type: Optional[str] = None
    user_id: Optional[str] = None
    group_id: Optional[str] = None
    task_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    operation_type: Optional[str] = None
    assigner_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    tenant_id: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricIdentityLinkId):
            self.id = HistoricIdentityLinkId(self.id)

        if self._is_empty(self.timestamp):
            self.MissingRequiredField("timestamp")
        if not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.group_id is not None and not isinstance(self.group_id, str):
            self.group_id = str(self.group_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.operation_type is not None and not isinstance(self.operation_type, str):
            self.operation_type = str(self.operation_type)

        if self.assigner_id is not None and not isinstance(self.assigner_id, str):
            self.assigner_id = str(self.assigner_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricIncident(YAMLRoot):
    """
    Represents a historic Incident incident that is stored permanently.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricIncident"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricIncident"
    class_name: ClassVar[str] = "HistoricIncident"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricIncident

    id: Union[str, HistoricIncidentId] = None
    create_time: Union[str, XSDDateTime] = None
    incident_type: str = None
    process_definition_key: Optional[str] = None
    process_definition_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    execution_id: Optional[str] = None
    end_time: Optional[Union[str, XSDDateTime]] = None
    incident_message: Optional[str] = None
    activity_id: Optional[str] = None
    failed_activity_id: Optional[str] = None
    cause_incident_id: Optional[str] = None
    root_cause_incident_id: Optional[str] = None
    configuration: Optional[str] = None
    history_configuration: Optional[str] = None
    incident_state: Optional[Union[str, "IncidentState"]] = None
    tenant_id: Optional[str] = None
    job_definition_id: Optional[str] = None
    annotation: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricIncidentId):
            self.id = HistoricIncidentId(self.id)

        if self._is_empty(self.create_time):
            self.MissingRequiredField("create_time")
        if not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self._is_empty(self.incident_type):
            self.MissingRequiredField("incident_type")
        if not isinstance(self.incident_type, str):
            self.incident_type = str(self.incident_type)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.end_time is not None and not isinstance(self.end_time, XSDDateTime):
            self.end_time = XSDDateTime(self.end_time)

        if self.incident_message is not None and not isinstance(self.incident_message, str):
            self.incident_message = str(self.incident_message)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.failed_activity_id is not None and not isinstance(self.failed_activity_id, str):
            self.failed_activity_id = str(self.failed_activity_id)

        if self.cause_incident_id is not None and not isinstance(self.cause_incident_id, str):
            self.cause_incident_id = str(self.cause_incident_id)

        if self.root_cause_incident_id is not None and not isinstance(self.root_cause_incident_id, str):
            self.root_cause_incident_id = str(self.root_cause_incident_id)

        if self.configuration is not None and not isinstance(self.configuration, str):
            self.configuration = str(self.configuration)

        if self.history_configuration is not None and not isinstance(self.history_configuration, str):
            self.history_configuration = str(self.history_configuration)

        if self.incident_state is not None and not isinstance(self.incident_state, IncidentState):
            self.incident_state = IncidentState(self.incident_state)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.job_definition_id is not None and not isinstance(self.job_definition_id, str):
            self.job_definition_id = str(self.job_definition_id)

        if self.annotation is not None and not isinstance(self.annotation, str):
            self.annotation = str(self.annotation)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricJobLog(YAMLRoot):
    """
    The HistoricJobLog is used to have a log containing information about Job job execution. The log provides details
    about the complete lifecycle of a Job job: An instance of HistoricJobLog represents...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricJobLog"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricJobLog"
    class_name: ClassVar[str] = "HistoricJobLog"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricJobLog

    id: Union[str, HistoricJobLogId] = None
    timestamp: Union[str, XSDDateTime] = None
    job_id: str = None
    job_priority: int = None
    job_due_date: Optional[Union[str, XSDDateTime]] = None
    job_retries: Optional[int] = None
    job_exception_message: Optional[str] = None
    job_exception_stack_id: Optional[str] = None
    job_state: Optional[Union[str, "JobState"]] = None
    job_definition_id: Optional[str] = None
    job_definition_type: Optional[str] = None
    job_definition_configuration: Optional[str] = None
    activity_id: Optional[str] = None
    failed_activity_id: Optional[str] = None
    execution_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    deployment_id: Optional[str] = None
    sequence_counter: Optional[int] = None
    tenant_id: Optional[str] = None
    hostname: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    batch_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricJobLogId):
            self.id = HistoricJobLogId(self.id)

        if self._is_empty(self.timestamp):
            self.MissingRequiredField("timestamp")
        if not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

        if self._is_empty(self.job_id):
            self.MissingRequiredField("job_id")
        if not isinstance(self.job_id, str):
            self.job_id = str(self.job_id)

        if self._is_empty(self.job_priority):
            self.MissingRequiredField("job_priority")
        if not isinstance(self.job_priority, int):
            self.job_priority = int(self.job_priority)

        if self.job_due_date is not None and not isinstance(self.job_due_date, XSDDateTime):
            self.job_due_date = XSDDateTime(self.job_due_date)

        if self.job_retries is not None and not isinstance(self.job_retries, int):
            self.job_retries = int(self.job_retries)

        if self.job_exception_message is not None and not isinstance(self.job_exception_message, str):
            self.job_exception_message = str(self.job_exception_message)

        if self.job_exception_stack_id is not None and not isinstance(self.job_exception_stack_id, str):
            self.job_exception_stack_id = str(self.job_exception_stack_id)

        if self.job_state is not None and not isinstance(self.job_state, JobState):
            self.job_state = JobState(self.job_state)

        if self.job_definition_id is not None and not isinstance(self.job_definition_id, str):
            self.job_definition_id = str(self.job_definition_id)

        if self.job_definition_type is not None and not isinstance(self.job_definition_type, str):
            self.job_definition_type = str(self.job_definition_type)

        if self.job_definition_configuration is not None and not isinstance(self.job_definition_configuration, str):
            self.job_definition_configuration = str(self.job_definition_configuration)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.failed_activity_id is not None and not isinstance(self.failed_activity_id, str):
            self.failed_activity_id = str(self.failed_activity_id)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.deployment_id is not None and not isinstance(self.deployment_id, str):
            self.deployment_id = str(self.deployment_id)

        if self.sequence_counter is not None and not isinstance(self.sequence_counter, int):
            self.sequence_counter = int(self.sequence_counter)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.hostname is not None and not isinstance(self.hostname, str):
            self.hostname = str(self.hostname)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.batch_id is not None and not isinstance(self.batch_id, str):
            self.batch_id = str(self.batch_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricScopeInstance(YAMLRoot):
    """
    Abstract base for historic entities with start/end time and duration.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricScopeInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricScopeInstance"
    class_name: ClassVar[str] = "HistoricScopeInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricScopeInstance

    id: Union[str, HistoricScopeInstanceId] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    start_time: Optional[Union[str, XSDDateTime]] = None
    end_time: Optional[Union[str, XSDDateTime]] = None
    duration: Optional[int] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricScopeInstanceId):
            self.id = HistoricScopeInstanceId(self.id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.start_time is not None and not isinstance(self.start_time, XSDDateTime):
            self.start_time = XSDDateTime(self.start_time)

        if self.end_time is not None and not isinstance(self.end_time, XSDDateTime):
            self.end_time = XSDDateTime(self.end_time)

        if self.duration is not None and not isinstance(self.duration, int):
            self.duration = int(self.duration)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricActivityInstance(HistoricScopeInstance):
    """
    Represents one execution of an activity and it's stored permanent for statistics, audit and other business
    intelligence purposes.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricActivityInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricActivityInstance"
    class_name: ClassVar[str] = "HistoricActivityInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricActivityInstance

    id: Union[str, HistoricActivityInstanceId] = None
    execution_id: str = None
    activity_id: str = None
    activity_type: str = None
    process_definition_id: str = None
    process_instance_id: str = None
    start_time: Union[str, XSDDateTime] = None
    parent_activity_instance_id: Optional[str] = None
    task_id: Optional[str] = None
    called_process_instance_id: Optional[str] = None
    called_case_instance_id: Optional[str] = None
    activity_name: Optional[str] = None
    assignee: Optional[str] = None
    activity_instance_state: Optional[Union[str, "ActivityInstanceState"]] = None
    sequence_counter: Optional[int] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricActivityInstanceId):
            self.id = HistoricActivityInstanceId(self.id)

        if self._is_empty(self.execution_id):
            self.MissingRequiredField("execution_id")
        if not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self._is_empty(self.activity_id):
            self.MissingRequiredField("activity_id")
        if not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self._is_empty(self.activity_type):
            self.MissingRequiredField("activity_type")
        if not isinstance(self.activity_type, str):
            self.activity_type = str(self.activity_type)

        if self._is_empty(self.process_definition_id):
            self.MissingRequiredField("process_definition_id")
        if not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self._is_empty(self.process_instance_id):
            self.MissingRequiredField("process_instance_id")
        if not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self._is_empty(self.start_time):
            self.MissingRequiredField("start_time")
        if not isinstance(self.start_time, XSDDateTime):
            self.start_time = XSDDateTime(self.start_time)

        if self.parent_activity_instance_id is not None and not isinstance(self.parent_activity_instance_id, str):
            self.parent_activity_instance_id = str(self.parent_activity_instance_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.called_process_instance_id is not None and not isinstance(self.called_process_instance_id, str):
            self.called_process_instance_id = str(self.called_process_instance_id)

        if self.called_case_instance_id is not None and not isinstance(self.called_case_instance_id, str):
            self.called_case_instance_id = str(self.called_case_instance_id)

        if self.activity_name is not None and not isinstance(self.activity_name, str):
            self.activity_name = str(self.activity_name)

        if self.assignee is not None and not isinstance(self.assignee, str):
            self.assignee = str(self.assignee)

        if self.activity_instance_state is not None and not isinstance(self.activity_instance_state, ActivityInstanceState):
            self.activity_instance_state = ActivityInstanceState(self.activity_instance_state)

        if self.sequence_counter is not None and not isinstance(self.sequence_counter, int):
            self.sequence_counter = int(self.sequence_counter)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricCaseActivityInstance(HistoricScopeInstance):
    """
    Represents one execution of a case activity which is stored permanent for statistics, audit and other business
    intelligence purposes.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricCaseActivityInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricCaseActivityInstance"
    class_name: ClassVar[str] = "HistoricCaseActivityInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricCaseActivityInstance

    id: Union[str, HistoricCaseActivityInstanceId] = None
    case_definition_id: str = None
    case_instance_id: str = None
    case_activity_id: str = None
    create_time: Union[str, XSDDateTime] = None
    parent_activity_instance_id: Optional[str] = None
    task_id: Optional[str] = None
    called_process_instance_id: Optional[str] = None
    called_case_instance_id: Optional[str] = None
    case_activity_name: Optional[str] = None
    case_activity_type: Optional[str] = None
    state: Optional[Union[str, "EntityState"]] = None
    is_required: Optional[Union[bool, Bool]] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricCaseActivityInstanceId):
            self.id = HistoricCaseActivityInstanceId(self.id)

        if self._is_empty(self.case_definition_id):
            self.MissingRequiredField("case_definition_id")
        if not isinstance(self.case_definition_id, str):
            self.case_definition_id = str(self.case_definition_id)

        if self._is_empty(self.case_instance_id):
            self.MissingRequiredField("case_instance_id")
        if not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self._is_empty(self.case_activity_id):
            self.MissingRequiredField("case_activity_id")
        if not isinstance(self.case_activity_id, str):
            self.case_activity_id = str(self.case_activity_id)

        if self._is_empty(self.create_time):
            self.MissingRequiredField("create_time")
        if not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.parent_activity_instance_id is not None and not isinstance(self.parent_activity_instance_id, str):
            self.parent_activity_instance_id = str(self.parent_activity_instance_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.called_process_instance_id is not None and not isinstance(self.called_process_instance_id, str):
            self.called_process_instance_id = str(self.called_process_instance_id)

        if self.called_case_instance_id is not None and not isinstance(self.called_case_instance_id, str):
            self.called_case_instance_id = str(self.called_case_instance_id)

        if self.case_activity_name is not None and not isinstance(self.case_activity_name, str):
            self.case_activity_name = str(self.case_activity_name)

        if self.case_activity_type is not None and not isinstance(self.case_activity_type, str):
            self.case_activity_type = str(self.case_activity_type)

        if self.state is not None and not isinstance(self.state, EntityState):
            self.state = EntityState(self.state)

        if self.is_required is not None and not isinstance(self.is_required, Bool):
            self.is_required = Bool(self.is_required)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricCaseInstance(HistoricScopeInstance):
    """
    A single execution of a case definition that is stored permanently.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricCaseInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricCaseInstance"
    class_name: ClassVar[str] = "HistoricCaseInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricCaseInstance

    id: Union[str, HistoricCaseInstanceId] = None
    case_instance_id: str = None
    case_definition_id: str = None
    create_time: Union[str, XSDDateTime] = None
    business_key: Optional[str] = None
    close_time: Optional[Union[str, XSDDateTime]] = None
    state: Optional[Union[str, "EntityState"]] = None
    create_user_id: Optional[str] = None
    super_case_instance_id: Optional[str] = None
    super_process_instance_id: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricCaseInstanceId):
            self.id = HistoricCaseInstanceId(self.id)

        if self._is_empty(self.case_instance_id):
            self.MissingRequiredField("case_instance_id")
        if not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self._is_empty(self.case_definition_id):
            self.MissingRequiredField("case_definition_id")
        if not isinstance(self.case_definition_id, str):
            self.case_definition_id = str(self.case_definition_id)

        if self._is_empty(self.create_time):
            self.MissingRequiredField("create_time")
        if not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.business_key is not None and not isinstance(self.business_key, str):
            self.business_key = str(self.business_key)

        if self.close_time is not None and not isinstance(self.close_time, XSDDateTime):
            self.close_time = XSDDateTime(self.close_time)

        if self.state is not None and not isinstance(self.state, EntityState):
            self.state = EntityState(self.state)

        if self.create_user_id is not None and not isinstance(self.create_user_id, str):
            self.create_user_id = str(self.create_user_id)

        if self.super_case_instance_id is not None and not isinstance(self.super_case_instance_id, str):
            self.super_case_instance_id = str(self.super_case_instance_id)

        if self.super_process_instance_id is not None and not isinstance(self.super_process_instance_id, str):
            self.super_process_instance_id = str(self.super_process_instance_id)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricProcessInstance(HistoricScopeInstance):
    """
    A single execution of a whole process definition that is stored permanently.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricProcessInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricProcessInstance"
    class_name: ClassVar[str] = "HistoricProcessInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricProcessInstance

    id: Union[str, HistoricProcessInstanceId] = None
    process_instance_id: str = None
    process_definition_id: str = None
    start_time: Union[str, XSDDateTime] = None
    business_key: Optional[str] = None
    start_user_id: Optional[str] = None
    start_activity_id: Optional[str] = None
    end_activity_id: Optional[str] = None
    super_process_instance_id: Optional[str] = None
    super_case_instance_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    delete_reason: Optional[str] = None
    tenant_id: Optional[str] = None
    state: Optional[Union[str, "EntityState"]] = None
    restarted_process_instance_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricProcessInstanceId):
            self.id = HistoricProcessInstanceId(self.id)

        if self._is_empty(self.process_instance_id):
            self.MissingRequiredField("process_instance_id")
        if not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self._is_empty(self.process_definition_id):
            self.MissingRequiredField("process_definition_id")
        if not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self._is_empty(self.start_time):
            self.MissingRequiredField("start_time")
        if not isinstance(self.start_time, XSDDateTime):
            self.start_time = XSDDateTime(self.start_time)

        if self.business_key is not None and not isinstance(self.business_key, str):
            self.business_key = str(self.business_key)

        if self.start_user_id is not None and not isinstance(self.start_user_id, str):
            self.start_user_id = str(self.start_user_id)

        if self.start_activity_id is not None and not isinstance(self.start_activity_id, str):
            self.start_activity_id = str(self.start_activity_id)

        if self.end_activity_id is not None and not isinstance(self.end_activity_id, str):
            self.end_activity_id = str(self.end_activity_id)

        if self.super_process_instance_id is not None and not isinstance(self.super_process_instance_id, str):
            self.super_process_instance_id = str(self.super_process_instance_id)

        if self.super_case_instance_id is not None and not isinstance(self.super_case_instance_id, str):
            self.super_case_instance_id = str(self.super_case_instance_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.delete_reason is not None and not isinstance(self.delete_reason, str):
            self.delete_reason = str(self.delete_reason)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.state is not None and not isinstance(self.state, EntityState):
            self.state = EntityState(self.state)

        if self.restarted_process_instance_id is not None and not isinstance(self.restarted_process_instance_id, str):
            self.restarted_process_instance_id = str(self.restarted_process_instance_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricTaskInstance(HistoricScopeInstance):
    """
    Represents a historic task instance (waiting, finished or deleted) that is stored permanent for statistics, audit
    and other business intelligence purposes.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricTaskInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricTaskInstance"
    class_name: ClassVar[str] = "HistoricTaskInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricTaskInstance

    id: Union[str, HistoricTaskInstanceId] = None
    priority: int = None
    start_time: Union[str, XSDDateTime] = None
    task_definition_key: Optional[str] = None
    execution_id: Optional[str] = None
    case_definition_key: Optional[str] = None
    case_definition_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    case_execution_id: Optional[str] = None
    activity_instance_id: Optional[str] = None
    name: Optional[str] = None
    parent_task_id: Optional[str] = None
    description: Optional[str] = None
    owner: Optional[str] = None
    assignee: Optional[str] = None
    delete_reason: Optional[str] = None
    due_date: Optional[Union[str, XSDDateTime]] = None
    follow_up_date: Optional[Union[str, XSDDateTime]] = None
    tenant_id: Optional[str] = None
    task_state: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricTaskInstanceId):
            self.id = HistoricTaskInstanceId(self.id)

        if self._is_empty(self.priority):
            self.MissingRequiredField("priority")
        if not isinstance(self.priority, int):
            self.priority = int(self.priority)

        if self._is_empty(self.start_time):
            self.MissingRequiredField("start_time")
        if not isinstance(self.start_time, XSDDateTime):
            self.start_time = XSDDateTime(self.start_time)

        if self.task_definition_key is not None and not isinstance(self.task_definition_key, str):
            self.task_definition_key = str(self.task_definition_key)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.case_definition_key is not None and not isinstance(self.case_definition_key, str):
            self.case_definition_key = str(self.case_definition_key)

        if self.case_definition_id is not None and not isinstance(self.case_definition_id, str):
            self.case_definition_id = str(self.case_definition_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, str):
            self.case_execution_id = str(self.case_execution_id)

        if self.activity_instance_id is not None and not isinstance(self.activity_instance_id, str):
            self.activity_instance_id = str(self.activity_instance_id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.parent_task_id is not None and not isinstance(self.parent_task_id, str):
            self.parent_task_id = str(self.parent_task_id)

        if self.description is not None and not isinstance(self.description, str):
            self.description = str(self.description)

        if self.owner is not None and not isinstance(self.owner, str):
            self.owner = str(self.owner)

        if self.assignee is not None and not isinstance(self.assignee, str):
            self.assignee = str(self.assignee)

        if self.delete_reason is not None and not isinstance(self.delete_reason, str):
            self.delete_reason = str(self.delete_reason)

        if self.due_date is not None and not isinstance(self.due_date, XSDDateTime):
            self.due_date = XSDDateTime(self.due_date)

        if self.follow_up_date is not None and not isinstance(self.follow_up_date, XSDDateTime):
            self.follow_up_date = XSDDateTime(self.follow_up_date)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.task_state is not None and not isinstance(self.task_state, str):
            self.task_state = str(self.task_state)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HistoricVariableInstance(YAMLRoot):
    """
    A single process variable containing the last value when its process instance has finished. It is only available
    when HISTORY_LEVEL is set >= AUDIT
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["HistoricVariableInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:HistoricVariableInstance"
    class_name: ClassVar[str] = "HistoricVariableInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HistoricVariableInstance

    id: Union[str, HistoricVariableInstanceId] = None
    name: str = None
    process_definition_key: Optional[str] = None
    process_definition_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    execution_id: Optional[str] = None
    case_definition_key: Optional[str] = None
    case_definition_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    case_execution_id: Optional[str] = None
    task_id: Optional[str] = None
    activity_instance_id: Optional[str] = None
    variable_type: Optional[str] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    byte_array_id: Optional[str] = None
    double_value: Optional[float] = None
    long_value: Optional[int] = None
    text_value: Optional[str] = None
    text2_value: Optional[str] = None
    tenant_id: Optional[str] = None
    state: Optional[Union[str, "EntityState"]] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HistoricVariableInstanceId):
            self.id = HistoricVariableInstanceId(self.id)

        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.case_definition_key is not None and not isinstance(self.case_definition_key, str):
            self.case_definition_key = str(self.case_definition_key)

        if self.case_definition_id is not None and not isinstance(self.case_definition_id, str):
            self.case_definition_id = str(self.case_definition_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, str):
            self.case_execution_id = str(self.case_execution_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.activity_instance_id is not None and not isinstance(self.activity_instance_id, str):
            self.activity_instance_id = str(self.activity_instance_id)

        if self.variable_type is not None and not isinstance(self.variable_type, str):
            self.variable_type = str(self.variable_type)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.byte_array_id is not None and not isinstance(self.byte_array_id, str):
            self.byte_array_id = str(self.byte_array_id)

        if self.double_value is not None and not isinstance(self.double_value, float):
            self.double_value = float(self.double_value)

        if self.long_value is not None and not isinstance(self.long_value, int):
            self.long_value = int(self.long_value)

        if self.text_value is not None and not isinstance(self.text_value, str):
            self.text_value = str(self.text_value)

        if self.text2_value is not None and not isinstance(self.text2_value, str):
            self.text2_value = str(self.text2_value)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.state is not None and not isinstance(self.state, EntityState):
            self.state = EntityState(self.state)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class UserOperationLogEntry(YAMLRoot):
    """
    Log entry about an operation performed by a user. This is used for logging actions such as creating a new task,
    completing a task, canceling a process instance, ... The type of the operation which ...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_HISTORY["UserOperationLogEntry"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_history:UserOperationLogEntry"
    class_name: ClassVar[str] = "UserOperationLogEntry"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.UserOperationLogEntry

    id: Union[str, UserOperationLogEntryId] = None
    job_id: str = None
    timestamp: Union[str, XSDDateTime] = None
    external_task_id: str = None
    deployment_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    execution_id: Optional[str] = None
    case_definition_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    case_execution_id: Optional[str] = None
    task_id: Optional[str] = None
    job_definition_id: Optional[str] = None
    batch_id: Optional[str] = None
    user_id: Optional[str] = None
    operation_type: Optional[str] = None
    operation_id: Optional[str] = None
    entity_type: Optional[str] = None
    property: Optional[str] = None
    original_value: Optional[str] = None
    new_value: Optional[str] = None
    tenant_id: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    category: Optional[str] = None
    annotation: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, UserOperationLogEntryId):
            self.id = UserOperationLogEntryId(self.id)

        if self._is_empty(self.job_id):
            self.MissingRequiredField("job_id")
        if not isinstance(self.job_id, str):
            self.job_id = str(self.job_id)

        if self._is_empty(self.timestamp):
            self.MissingRequiredField("timestamp")
        if not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

        if self._is_empty(self.external_task_id):
            self.MissingRequiredField("external_task_id")
        if not isinstance(self.external_task_id, str):
            self.external_task_id = str(self.external_task_id)

        if self.deployment_id is not None and not isinstance(self.deployment_id, str):
            self.deployment_id = str(self.deployment_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.case_definition_id is not None and not isinstance(self.case_definition_id, str):
            self.case_definition_id = str(self.case_definition_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, str):
            self.case_execution_id = str(self.case_execution_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.job_definition_id is not None and not isinstance(self.job_definition_id, str):
            self.job_definition_id = str(self.job_definition_id)

        if self.batch_id is not None and not isinstance(self.batch_id, str):
            self.batch_id = str(self.batch_id)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.operation_type is not None and not isinstance(self.operation_type, str):
            self.operation_type = str(self.operation_type)

        if self.operation_id is not None and not isinstance(self.operation_id, str):
            self.operation_id = str(self.operation_id)

        if self.entity_type is not None and not isinstance(self.entity_type, str):
            self.entity_type = str(self.entity_type)

        if self.property is not None and not isinstance(self.property, str):
            self.property = str(self.property)

        if self.original_value is not None and not isinstance(self.original_value, str):
            self.original_value = str(self.original_value)

        if self.new_value is not None and not isinstance(self.new_value, str):
            self.new_value = str(self.new_value)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.category is not None and not isinstance(self.category, str):
            self.category = str(self.category)

        if self.annotation is not None and not isinstance(self.annotation, str):
            self.annotation = str(self.annotation)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Authorization(YAMLRoot):
    """
    An Authorization assigns a set of Permission Permissions to an identity to interact with a given Resource.
    EXAMPLES: Nobody is allowed to edit process variables in the cockpit application, except t...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_IDENTITY["Authorization"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_identity:Authorization"
    class_name: ClassVar[str] = "Authorization"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Authorization

    id: Union[str, AuthorizationId] = None
    type: Union[str, "AuthorizationType"] = None
    resource_type: int = None
    group_id: Optional[str] = None
    user_id: Optional[str] = None
    resource_id: Optional[str] = None
    permissions: Optional[int] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    root_process_instance_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, AuthorizationId):
            self.id = AuthorizationId(self.id)

        if self._is_empty(self.type):
            self.MissingRequiredField("type")
        if not isinstance(self.type, AuthorizationType):
            self.type = AuthorizationType(self.type)

        if self._is_empty(self.resource_type):
            self.MissingRequiredField("resource_type")
        if not isinstance(self.resource_type, int):
            self.resource_type = int(self.resource_type)

        if self.group_id is not None and not isinstance(self.group_id, str):
            self.group_id = str(self.group_id)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.resource_id is not None and not isinstance(self.resource_id, str):
            self.resource_id = str(self.resource_id)

        if self.permissions is not None and not isinstance(self.permissions, int):
            self.permissions = int(self.permissions)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Group(YAMLRoot):
    """
    Represents a group, used in IdentityService.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_IDENTITY["Group"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_identity:Group"
    class_name: ClassVar[str] = "Group"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Group

    id: Union[str, GroupId] = None
    name: Optional[str] = None
    type: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, GroupId):
            self.id = GroupId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class IdentityInfo(YAMLRoot):
    """
    Identity Info entity in the identity and access management.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_IDENTITY["IdentityInfo"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_identity:IdentityInfo"
    class_name: ClassVar[str] = "IdentityInfo"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.IdentityInfo

    id: Union[str, IdentityInfoId] = None
    user_id: Optional[str] = None
    type: Optional[str] = None
    key: Optional[str] = None
    value: Optional[str] = None
    password: Optional[str] = None
    parent_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, IdentityInfoId):
            self.id = IdentityInfoId(self.id)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.key is not None and not isinstance(self.key, str):
            self.key = str(self.key)

        if self.value is not None and not isinstance(self.value, str):
            self.value = str(self.value)

        if self.password is not None and not isinstance(self.password, str):
            self.password = str(self.password)

        if self.parent_id is not None and not isinstance(self.parent_id, str):
            self.parent_id = str(self.parent_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class IdentityLink(YAMLRoot):
    """
    An identity link is used to associate a task with a certain identity. For example: - a user can be an assignee (=
    identity link type) for a task - a group can be a candidate-group (= identity link ...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_IDENTITY["IdentityLink"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_identity:IdentityLink"
    class_name: ClassVar[str] = "IdentityLink"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.IdentityLink

    id: Union[str, IdentityLinkId] = None
    group_id: Optional[str] = None
    type: Optional[str] = None
    user_id: Optional[str] = None
    task_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, IdentityLinkId):
            self.id = IdentityLinkId(self.id)

        if self.group_id is not None and not isinstance(self.group_id, str):
            self.group_id = str(self.group_id)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Membership(YAMLRoot):
    """
    Association entity in identity and access management.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_IDENTITY["Membership"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_identity:Membership"
    class_name: ClassVar[str] = "Membership"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Membership

    user_id: str = None
    group_id: str = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.user_id):
            self.MissingRequiredField("user_id")
        if not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self._is_empty(self.group_id):
            self.MissingRequiredField("group_id")
        if not isinstance(self.group_id, str):
            self.group_id = str(self.group_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Tenant(YAMLRoot):
    """
    Represents a tenant, used in IdentityService.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_IDENTITY["Tenant"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_identity:Tenant"
    class_name: ClassVar[str] = "Tenant"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Tenant

    id: Union[str, TenantId] = None
    name: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TenantId):
            self.id = TenantId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class TenantMembership(YAMLRoot):
    """
    Association entity in identity and access management.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_IDENTITY["TenantMembership"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_identity:TenantMembership"
    class_name: ClassVar[str] = "TenantMembership"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.TenantMembership

    id: Union[str, TenantMembershipId] = None
    tenant_id: str = None
    user_id: Optional[str] = None
    group_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TenantMembershipId):
            self.id = TenantMembershipId(self.id)

        if self._is_empty(self.tenant_id):
            self.MissingRequiredField("tenant_id")
        if not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.group_id is not None and not isinstance(self.group_id, str):
            self.group_id = str(self.group_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class User(YAMLRoot):
    """
    Represents a user, used in IdentityService.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_IDENTITY["User"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_identity:User"
    class_name: ClassVar[str] = "User"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.User

    id: Union[str, UserId] = None
    first_name: Optional[str] = None
    last_name: Optional[str] = None
    email: Optional[str] = None
    password: Optional[str] = None
    salt: Optional[str] = None
    lock_expiration_time: Optional[Union[str, XSDDateTime]] = None
    attempts: Optional[int] = None
    picture_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, UserId):
            self.id = UserId(self.id)

        if self.first_name is not None and not isinstance(self.first_name, str):
            self.first_name = str(self.first_name)

        if self.last_name is not None and not isinstance(self.last_name, str):
            self.last_name = str(self.last_name)

        if self.email is not None and not isinstance(self.email, str):
            self.email = str(self.email)

        if self.password is not None and not isinstance(self.password, str):
            self.password = str(self.password)

        if self.salt is not None and not isinstance(self.salt, str):
            self.salt = str(self.salt)

        if self.lock_expiration_time is not None and not isinstance(self.lock_expiration_time, XSDDateTime):
            self.lock_expiration_time = XSDDateTime(self.lock_expiration_time)

        if self.attempts is not None and not isinstance(self.attempts, int):
            self.attempts = int(self.attempts)

        if self.picture_id is not None and not isinstance(self.picture_id, str):
            self.picture_id = str(self.picture_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Batch(YAMLRoot):
    """
    A batch represents a number of jobs which execute a number of commands asynchronously. Batches have three types of
    jobs: Seed jobs: Create execution jobs Execution jobs: Execute the actual action M...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_JOB["Batch"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_job:Batch"
    class_name: ClassVar[str] = "Batch"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Batch

    id: Union[str, BatchId] = None
    type: Optional[str] = None
    total_jobs: Optional[int] = None
    jobs_created: Optional[int] = None
    jobs_per_seed: Optional[int] = None
    invocations_per_job: Optional[int] = None
    seed_job_definition_id: Optional[str] = None
    batch_job_definition_id: Optional[str] = None
    monitor_job_definition_id: Optional[str] = None
    suspension_state: Optional[Union[str, "SuspensionState"]] = None
    configuration: Optional[str] = None
    tenant_id: Optional[str] = None
    create_user_id: Optional[str] = None
    start_time: Optional[Union[str, XSDDateTime]] = None
    execution_start_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BatchId):
            self.id = BatchId(self.id)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.total_jobs is not None and not isinstance(self.total_jobs, int):
            self.total_jobs = int(self.total_jobs)

        if self.jobs_created is not None and not isinstance(self.jobs_created, int):
            self.jobs_created = int(self.jobs_created)

        if self.jobs_per_seed is not None and not isinstance(self.jobs_per_seed, int):
            self.jobs_per_seed = int(self.jobs_per_seed)

        if self.invocations_per_job is not None and not isinstance(self.invocations_per_job, int):
            self.invocations_per_job = int(self.invocations_per_job)

        if self.seed_job_definition_id is not None and not isinstance(self.seed_job_definition_id, str):
            self.seed_job_definition_id = str(self.seed_job_definition_id)

        if self.batch_job_definition_id is not None and not isinstance(self.batch_job_definition_id, str):
            self.batch_job_definition_id = str(self.batch_job_definition_id)

        if self.monitor_job_definition_id is not None and not isinstance(self.monitor_job_definition_id, str):
            self.monitor_job_definition_id = str(self.monitor_job_definition_id)

        if self.suspension_state is not None and not isinstance(self.suspension_state, SuspensionState):
            self.suspension_state = SuspensionState(self.suspension_state)

        if self.configuration is not None and not isinstance(self.configuration, str):
            self.configuration = str(self.configuration)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.create_user_id is not None and not isinstance(self.create_user_id, str):
            self.create_user_id = str(self.create_user_id)

        if self.start_time is not None and not isinstance(self.start_time, XSDDateTime):
            self.start_time = XSDDateTime(self.start_time)

        if self.execution_start_time is not None and not isinstance(self.execution_start_time, XSDDateTime):
            self.execution_start_time = XSDDateTime(self.execution_start_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Job(YAMLRoot):
    """
    Represents one job (timer, message, etc.).
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_JOB["Job"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_job:Job"
    class_name: ClassVar[str] = "Job"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Job

    id: Union[str, JobId] = None
    type: str = None
    suspension_state: Union[str, "SuspensionState"] = None
    priority: int = None
    lock_expiration_time: Optional[Union[str, XSDDateTime]] = None
    lock_owner: Optional[str] = None
    is_exclusive: Optional[Union[bool, Bool]] = None
    execution_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    retries: Optional[int] = None
    exception_stack_id: Optional[str] = None
    exception_message: Optional[str] = None
    failed_activity_id: Optional[str] = None
    due_date: Optional[Union[str, XSDDateTime]] = None
    repeat: Optional[str] = None
    repeat_offset: Optional[int] = None
    handler_type: Optional[str] = None
    handler_configuration: Optional[str] = None
    deployment_id: Optional[str] = None
    job_definition_id: Optional[str] = None
    sequence_counter: Optional[int] = None
    tenant_id: Optional[str] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    last_failure_log_id: Optional[str] = None
    batch_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, JobId):
            self.id = JobId(self.id)

        if self._is_empty(self.type):
            self.MissingRequiredField("type")
        if not isinstance(self.type, str):
            self.type = str(self.type)

        if self._is_empty(self.suspension_state):
            self.MissingRequiredField("suspension_state")
        if not isinstance(self.suspension_state, SuspensionState):
            self.suspension_state = SuspensionState(self.suspension_state)

        if self._is_empty(self.priority):
            self.MissingRequiredField("priority")
        if not isinstance(self.priority, int):
            self.priority = int(self.priority)

        if self.lock_expiration_time is not None and not isinstance(self.lock_expiration_time, XSDDateTime):
            self.lock_expiration_time = XSDDateTime(self.lock_expiration_time)

        if self.lock_owner is not None and not isinstance(self.lock_owner, str):
            self.lock_owner = str(self.lock_owner)

        if self.is_exclusive is not None and not isinstance(self.is_exclusive, Bool):
            self.is_exclusive = Bool(self.is_exclusive)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.retries is not None and not isinstance(self.retries, int):
            self.retries = int(self.retries)

        if self.exception_stack_id is not None and not isinstance(self.exception_stack_id, str):
            self.exception_stack_id = str(self.exception_stack_id)

        if self.exception_message is not None and not isinstance(self.exception_message, str):
            self.exception_message = str(self.exception_message)

        if self.failed_activity_id is not None and not isinstance(self.failed_activity_id, str):
            self.failed_activity_id = str(self.failed_activity_id)

        if self.due_date is not None and not isinstance(self.due_date, XSDDateTime):
            self.due_date = XSDDateTime(self.due_date)

        if self.repeat is not None and not isinstance(self.repeat, str):
            self.repeat = str(self.repeat)

        if self.repeat_offset is not None and not isinstance(self.repeat_offset, int):
            self.repeat_offset = int(self.repeat_offset)

        if self.handler_type is not None and not isinstance(self.handler_type, str):
            self.handler_type = str(self.handler_type)

        if self.handler_configuration is not None and not isinstance(self.handler_configuration, str):
            self.handler_configuration = str(self.handler_configuration)

        if self.deployment_id is not None and not isinstance(self.deployment_id, str):
            self.deployment_id = str(self.deployment_id)

        if self.job_definition_id is not None and not isinstance(self.job_definition_id, str):
            self.job_definition_id = str(self.job_definition_id)

        if self.sequence_counter is not None and not isinstance(self.sequence_counter, int):
            self.sequence_counter = int(self.sequence_counter)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.last_failure_log_id is not None and not isinstance(self.last_failure_log_id, str):
            self.last_failure_log_id = str(self.last_failure_log_id)

        if self.batch_id is not None and not isinstance(self.batch_id, str):
            self.batch_id = str(self.batch_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class JobDefinition(YAMLRoot):
    """
    A Job Definition provides details about asynchronous background processing ("Jobs") performed by the process
    engine. Each Job Definition corresponds to a Timer or Asynchronous continuation job inst...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_JOB["JobDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_job:JobDefinition"
    class_name: ClassVar[str] = "JobDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.JobDefinition

    id: Union[str, JobDefinitionId] = None
    job_type: str = None
    job_priority: int = None
    process_definition_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    activity_id: Optional[str] = None
    job_configuration: Optional[str] = None
    suspension_state: Optional[Union[str, "SuspensionState"]] = None
    tenant_id: Optional[str] = None
    deployment_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, JobDefinitionId):
            self.id = JobDefinitionId(self.id)

        if self._is_empty(self.job_type):
            self.MissingRequiredField("job_type")
        if not isinstance(self.job_type, str):
            self.job_type = str(self.job_type)

        if self._is_empty(self.job_priority):
            self.MissingRequiredField("job_priority")
        if not isinstance(self.job_priority, int):
            self.job_priority = int(self.job_priority)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.job_configuration is not None and not isinstance(self.job_configuration, str):
            self.job_configuration = str(self.job_configuration)

        if self.suspension_state is not None and not isinstance(self.suspension_state, SuspensionState):
            self.suspension_state = SuspensionState(self.suspension_state)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.deployment_id is not None and not isinstance(self.deployment_id, str):
            self.deployment_id = str(self.deployment_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Deployment(YAMLRoot):
    """
    Represents a deployment that is already present in the process repository. A deployment is a container for
    resources such as process definitions, images, forms, etc. When a deployment is 'deployed'...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_REPOSITORY["Deployment"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_repository:Deployment"
    class_name: ClassVar[str] = "Deployment"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Deployment

    id: Union[str, DeploymentId] = None
    name: Optional[str] = None
    deploy_time: Optional[Union[str, XSDDateTime]] = None
    source: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DeploymentId):
            self.id = DeploymentId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.deploy_time is not None and not isinstance(self.deploy_time, XSDDateTime):
            self.deploy_time = XSDDateTime(self.deploy_time)

        if self.source is not None and not isinstance(self.source, str):
            self.source = str(self.source)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ResourceDefinition(YAMLRoot):
    """
    Abstract base for deployable resource definitions (process, case, decision, form).
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_REPOSITORY["ResourceDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_repository:ResourceDefinition"
    class_name: ClassVar[str] = "ResourceDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ResourceDefinition

    id: Union[str, ResourceDefinitionId] = None
    key: Optional[str] = None
    name: Optional[str] = None
    version: Optional[int] = None
    category: Optional[str] = None
    deployment_id: Optional[str] = None
    resource_name: Optional[str] = None
    diagram_resource_name: Optional[str] = None
    tenant_id: Optional[str] = None
    history_time_to_live: Optional[int] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ResourceDefinitionId):
            self.id = ResourceDefinitionId(self.id)

        if self.key is not None and not isinstance(self.key, str):
            self.key = str(self.key)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.version is not None and not isinstance(self.version, int):
            self.version = int(self.version)

        if self.category is not None and not isinstance(self.category, str):
            self.category = str(self.category)

        if self.deployment_id is not None and not isinstance(self.deployment_id, str):
            self.deployment_id = str(self.deployment_id)

        if self.resource_name is not None and not isinstance(self.resource_name, str):
            self.resource_name = str(self.resource_name)

        if self.diagram_resource_name is not None and not isinstance(self.diagram_resource_name, str):
            self.diagram_resource_name = str(self.diagram_resource_name)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.history_time_to_live is not None and not isinstance(self.history_time_to_live, int):
            self.history_time_to_live = int(self.history_time_to_live)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CaseDefinition(ResourceDefinition):
    """
    A deployed case definition in the process repository.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_REPOSITORY["CaseDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_repository:CaseDefinition"
    class_name: ClassVar[str] = "CaseDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CaseDefinition

    id: Union[str, CaseDefinitionId] = None
    key: str = None
    version: int = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CaseDefinitionId):
            self.id = CaseDefinitionId(self.id)

        if self._is_empty(self.key):
            self.MissingRequiredField("key")
        if not isinstance(self.key, str):
            self.key = str(self.key)

        if self._is_empty(self.version):
            self.MissingRequiredField("version")
        if not isinstance(self.version, int):
            self.version = int(self.version)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DecisionDefinition(ResourceDefinition):
    """
    Definition of a decision resource
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_REPOSITORY["DecisionDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_repository:DecisionDefinition"
    class_name: ClassVar[str] = "DecisionDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DecisionDefinition

    id: Union[str, DecisionDefinitionId] = None
    key: str = None
    version: int = None
    decision_requirements_definition_id: Optional[str] = None
    decision_requirements_definition_key: Optional[str] = None
    version_tag: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DecisionDefinitionId):
            self.id = DecisionDefinitionId(self.id)

        if self._is_empty(self.key):
            self.MissingRequiredField("key")
        if not isinstance(self.key, str):
            self.key = str(self.key)

        if self._is_empty(self.version):
            self.MissingRequiredField("version")
        if not isinstance(self.version, int):
            self.version = int(self.version)

        if self.decision_requirements_definition_id is not None and not isinstance(self.decision_requirements_definition_id, str):
            self.decision_requirements_definition_id = str(self.decision_requirements_definition_id)

        if self.decision_requirements_definition_key is not None and not isinstance(self.decision_requirements_definition_key, str):
            self.decision_requirements_definition_key = str(self.decision_requirements_definition_key)

        if self.version_tag is not None and not isinstance(self.version_tag, str):
            self.version_tag = str(self.version_tag)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DecisionRequirementsDefinition(ResourceDefinition):
    """
    Container of DecisionDefinitions which belongs to the same decision requirements graph (i.e. DMN resource).
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_REPOSITORY["DecisionRequirementsDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_repository:DecisionRequirementsDefinition"
    class_name: ClassVar[str] = "DecisionRequirementsDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DecisionRequirementsDefinition

    id: Union[str, DecisionRequirementsDefinitionId] = None
    key: str = None
    version: int = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DecisionRequirementsDefinitionId):
            self.id = DecisionRequirementsDefinitionId(self.id)

        if self._is_empty(self.key):
            self.MissingRequiredField("key")
        if not isinstance(self.key, str):
            self.key = str(self.key)

        if self._is_empty(self.version):
            self.MissingRequiredField("version")
        if not isinstance(self.version, int):
            self.version = int(self.version)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FormDefinition(ResourceDefinition):
    """
    An object structure representing a Camunda Form used to present forms to users either when starting a process
    instance or when assigned to a User Task. Camunda Forms are usually composed with the h...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_REPOSITORY["FormDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_repository:FormDefinition"
    class_name: ClassVar[str] = "FormDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FormDefinition

    id: Union[str, FormDefinitionId] = None
    key: str = None
    version: int = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FormDefinitionId):
            self.id = FormDefinitionId(self.id)

        if self._is_empty(self.key):
            self.MissingRequiredField("key")
        if not isinstance(self.key, str):
            self.key = str(self.key)

        if self._is_empty(self.version):
            self.MissingRequiredField("version")
        if not isinstance(self.version, int):
            self.version = int(self.version)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ProcessDefinition(ResourceDefinition):
    """
    An object structure representing an executable process composed of activities and transitions. Business processes
    are often created with graphical editors that store the process definition in certa...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_REPOSITORY["ProcessDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_repository:ProcessDefinition"
    class_name: ClassVar[str] = "ProcessDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ProcessDefinition

    id: Union[str, ProcessDefinitionId] = None
    is_startable: Union[bool, Bool] = None
    key: str = None
    version: int = None
    has_start_form_key: Optional[Union[bool, Bool]] = None
    suspension_state: Optional[Union[str, "SuspensionState"]] = None
    version_tag: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ProcessDefinitionId):
            self.id = ProcessDefinitionId(self.id)

        if self._is_empty(self.is_startable):
            self.MissingRequiredField("is_startable")
        if not isinstance(self.is_startable, Bool):
            self.is_startable = Bool(self.is_startable)

        if self._is_empty(self.key):
            self.MissingRequiredField("key")
        if not isinstance(self.key, str):
            self.key = str(self.key)

        if self._is_empty(self.version):
            self.MissingRequiredField("version")
        if not isinstance(self.version, int):
            self.version = int(self.version)

        if self.has_start_form_key is not None and not isinstance(self.has_start_form_key, Bool):
            self.has_start_form_key = Bool(self.has_start_form_key)

        if self.suspension_state is not None and not isinstance(self.suspension_state, SuspensionState):
            self.suspension_state = SuspensionState(self.suspension_state)

        if self.version_tag is not None and not isinstance(self.version_tag, str):
            self.version_tag = str(self.version_tag)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CaseExecution(YAMLRoot):
    """
    Case Execution entity in the process execution runtime.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_RUNTIME["CaseExecution"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_runtime:CaseExecution"
    class_name: ClassVar[str] = "CaseExecution"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CaseExecution

    id: Union[str, CaseExecutionId] = None
    case_instance_id: Optional[str] = None
    super_case_execution_id: Optional[str] = None
    super_execution_id: Optional[str] = None
    business_key: Optional[str] = None
    parent_id: Optional[str] = None
    case_definition_id: Optional[str] = None
    activity_id: Optional[str] = None
    previous_state: Optional[int] = None
    current_state: Optional[int] = None
    is_required: Optional[Union[bool, Bool]] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CaseExecutionId):
            self.id = CaseExecutionId(self.id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.super_case_execution_id is not None and not isinstance(self.super_case_execution_id, str):
            self.super_case_execution_id = str(self.super_case_execution_id)

        if self.super_execution_id is not None and not isinstance(self.super_execution_id, str):
            self.super_execution_id = str(self.super_execution_id)

        if self.business_key is not None and not isinstance(self.business_key, str):
            self.business_key = str(self.business_key)

        if self.parent_id is not None and not isinstance(self.parent_id, str):
            self.parent_id = str(self.parent_id)

        if self.case_definition_id is not None and not isinstance(self.case_definition_id, str):
            self.case_definition_id = str(self.case_definition_id)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.previous_state is not None and not isinstance(self.previous_state, int):
            self.previous_state = int(self.previous_state)

        if self.current_state is not None and not isinstance(self.current_state, int):
            self.current_state = int(self.current_state)

        if self.is_required is not None and not isinstance(self.is_required, Bool):
            self.is_required = Bool(self.is_required)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CaseSentryPart(YAMLRoot):
    """
    Case Sentry Part entity in the process execution runtime.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_RUNTIME["CaseSentryPart"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_runtime:CaseSentryPart"
    class_name: ClassVar[str] = "CaseSentryPart"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CaseSentryPart

    id: Union[str, CaseSentryPartId] = None
    case_instance_id: Optional[str] = None
    case_execution_id: Optional[str] = None
    sentry_id: Optional[str] = None
    type: Optional[str] = None
    source_case_execution_id: Optional[str] = None
    standard_event: Optional[str] = None
    source: Optional[str] = None
    variable_event: Optional[str] = None
    variable_name: Optional[str] = None
    is_satisfied: Optional[Union[bool, Bool]] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CaseSentryPartId):
            self.id = CaseSentryPartId(self.id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, str):
            self.case_execution_id = str(self.case_execution_id)

        if self.sentry_id is not None and not isinstance(self.sentry_id, str):
            self.sentry_id = str(self.sentry_id)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.source_case_execution_id is not None and not isinstance(self.source_case_execution_id, str):
            self.source_case_execution_id = str(self.source_case_execution_id)

        if self.standard_event is not None and not isinstance(self.standard_event, str):
            self.standard_event = str(self.standard_event)

        if self.source is not None and not isinstance(self.source, str):
            self.source = str(self.source)

        if self.variable_event is not None and not isinstance(self.variable_event, str):
            self.variable_event = str(self.variable_event)

        if self.variable_name is not None and not isinstance(self.variable_name, str):
            self.variable_name = str(self.variable_name)

        if self.is_satisfied is not None and not isinstance(self.is_satisfied, Bool):
            self.is_satisfied = Bool(self.is_satisfied)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class EventSubscription(YAMLRoot):
    """
    A message event subscription exists, if an Execution waits for an event like a message.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_RUNTIME["EventSubscription"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_runtime:EventSubscription"
    class_name: ClassVar[str] = "EventSubscription"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.EventSubscription

    id: Union[str, EventSubscriptionId] = None
    event_type: str = None
    created: Union[str, XSDDateTime] = None
    event_name: Optional[str] = None
    execution_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    activity_id: Optional[str] = None
    configuration: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, EventSubscriptionId):
            self.id = EventSubscriptionId(self.id)

        if self._is_empty(self.event_type):
            self.MissingRequiredField("event_type")
        if not isinstance(self.event_type, str):
            self.event_type = str(self.event_type)

        if self._is_empty(self.created):
            self.MissingRequiredField("created")
        if not isinstance(self.created, XSDDateTime):
            self.created = XSDDateTime(self.created)

        if self.event_name is not None and not isinstance(self.event_name, str):
            self.event_name = str(self.event_name)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.configuration is not None and not isinstance(self.configuration, str):
            self.configuration = str(self.configuration)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Execution(YAMLRoot):
    """
    Represent a 'path of execution' in a process instance. Note that a ProcessInstance also is an execution.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_RUNTIME["Execution"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_runtime:Execution"
    class_name: ClassVar[str] = "Execution"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Execution

    id: Union[str, ExecutionId] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    business_key: Optional[str] = None
    parent_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    super_execution_id: Optional[str] = None
    super_case_execution_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    activity_instance_id: Optional[str] = None
    activity_id: Optional[str] = None
    is_active: Optional[Union[bool, Bool]] = None
    is_concurrent: Optional[Union[bool, Bool]] = None
    is_scope: Optional[Union[bool, Bool]] = None
    is_event_scope: Optional[Union[bool, Bool]] = None
    suspension_state: Optional[Union[str, "SuspensionState"]] = None
    cached_entity_state: Optional[int] = None
    sequence_counter: Optional[int] = None
    tenant_id: Optional[str] = None
    process_definition_key: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ExecutionId):
            self.id = ExecutionId(self.id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.business_key is not None and not isinstance(self.business_key, str):
            self.business_key = str(self.business_key)

        if self.parent_id is not None and not isinstance(self.parent_id, str):
            self.parent_id = str(self.parent_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.super_execution_id is not None and not isinstance(self.super_execution_id, str):
            self.super_execution_id = str(self.super_execution_id)

        if self.super_case_execution_id is not None and not isinstance(self.super_case_execution_id, str):
            self.super_case_execution_id = str(self.super_case_execution_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.activity_instance_id is not None and not isinstance(self.activity_instance_id, str):
            self.activity_instance_id = str(self.activity_instance_id)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.is_active is not None and not isinstance(self.is_active, Bool):
            self.is_active = Bool(self.is_active)

        if self.is_concurrent is not None and not isinstance(self.is_concurrent, Bool):
            self.is_concurrent = Bool(self.is_concurrent)

        if self.is_scope is not None and not isinstance(self.is_scope, Bool):
            self.is_scope = Bool(self.is_scope)

        if self.is_event_scope is not None and not isinstance(self.is_event_scope, Bool):
            self.is_event_scope = Bool(self.is_event_scope)

        if self.suspension_state is not None and not isinstance(self.suspension_state, SuspensionState):
            self.suspension_state = SuspensionState(self.suspension_state)

        if self.cached_entity_state is not None and not isinstance(self.cached_entity_state, int):
            self.cached_entity_state = int(self.cached_entity_state)

        if self.sequence_counter is not None and not isinstance(self.sequence_counter, int):
            self.sequence_counter = int(self.sequence_counter)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ExternalTask(YAMLRoot):
    """
    Represents an instance of an external task that is created when a service-task like activity (i.e. service task,
    send task, ...) with attribute camunda:type="external" is executed.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_RUNTIME["ExternalTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_runtime:ExternalTask"
    class_name: ClassVar[str] = "ExternalTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ExternalTask

    id: Union[str, ExternalTaskId] = None
    priority: int = None
    worker_id: Optional[str] = None
    topic_name: Optional[str] = None
    retries: Optional[int] = None
    error_message: Optional[str] = None
    error_details_id: Optional[str] = None
    lock_expiration_time: Optional[Union[str, XSDDateTime]] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    suspension_state: Optional[Union[str, "SuspensionState"]] = None
    execution_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    activity_id: Optional[str] = None
    activity_instance_id: Optional[str] = None
    tenant_id: Optional[str] = None
    last_failure_log_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ExternalTaskId):
            self.id = ExternalTaskId(self.id)

        if self._is_empty(self.priority):
            self.MissingRequiredField("priority")
        if not isinstance(self.priority, int):
            self.priority = int(self.priority)

        if self.worker_id is not None and not isinstance(self.worker_id, str):
            self.worker_id = str(self.worker_id)

        if self.topic_name is not None and not isinstance(self.topic_name, str):
            self.topic_name = str(self.topic_name)

        if self.retries is not None and not isinstance(self.retries, int):
            self.retries = int(self.retries)

        if self.error_message is not None and not isinstance(self.error_message, str):
            self.error_message = str(self.error_message)

        if self.error_details_id is not None and not isinstance(self.error_details_id, str):
            self.error_details_id = str(self.error_details_id)

        if self.lock_expiration_time is not None and not isinstance(self.lock_expiration_time, XSDDateTime):
            self.lock_expiration_time = XSDDateTime(self.lock_expiration_time)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.suspension_state is not None and not isinstance(self.suspension_state, SuspensionState):
            self.suspension_state = SuspensionState(self.suspension_state)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.activity_instance_id is not None and not isinstance(self.activity_instance_id, str):
            self.activity_instance_id = str(self.activity_instance_id)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.last_failure_log_id is not None and not isinstance(self.last_failure_log_id, str):
            self.last_failure_log_id = str(self.last_failure_log_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Incident(YAMLRoot):
    """
    An Incident represents a failure in the execution of a process instance. A possible failure could be for example a
    failed Job during the execution, so that the job retry is equal zero (job.retries ...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_RUNTIME["Incident"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_runtime:Incident"
    class_name: ClassVar[str] = "Incident"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Incident

    id: Union[str, IncidentId] = None
    incident_timestamp: Union[str, XSDDateTime] = None
    incident_type: str = None
    incident_message: Optional[str] = None
    execution_id: Optional[str] = None
    activity_id: Optional[str] = None
    failed_activity_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    cause_incident_id: Optional[str] = None
    root_cause_incident_id: Optional[str] = None
    configuration: Optional[str] = None
    tenant_id: Optional[str] = None
    job_definition_id: Optional[str] = None
    annotation: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, IncidentId):
            self.id = IncidentId(self.id)

        if self._is_empty(self.incident_timestamp):
            self.MissingRequiredField("incident_timestamp")
        if not isinstance(self.incident_timestamp, XSDDateTime):
            self.incident_timestamp = XSDDateTime(self.incident_timestamp)

        if self._is_empty(self.incident_type):
            self.MissingRequiredField("incident_type")
        if not isinstance(self.incident_type, str):
            self.incident_type = str(self.incident_type)

        if self.incident_message is not None and not isinstance(self.incident_message, str):
            self.incident_message = str(self.incident_message)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.failed_activity_id is not None and not isinstance(self.failed_activity_id, str):
            self.failed_activity_id = str(self.failed_activity_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.cause_incident_id is not None and not isinstance(self.cause_incident_id, str):
            self.cause_incident_id = str(self.cause_incident_id)

        if self.root_cause_incident_id is not None and not isinstance(self.root_cause_incident_id, str):
            self.root_cause_incident_id = str(self.root_cause_incident_id)

        if self.configuration is not None and not isinstance(self.configuration, str):
            self.configuration = str(self.configuration)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.job_definition_id is not None and not isinstance(self.job_definition_id, str):
            self.job_definition_id = str(self.job_definition_id)

        if self.annotation is not None and not isinstance(self.annotation, str):
            self.annotation = str(self.annotation)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Task(YAMLRoot):
    """
    Represents one task for a human user.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_RUNTIME["Task"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_runtime:Task"
    class_name: ClassVar[str] = "Task"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Task

    id: Union[str, TaskId] = None
    priority: int = None
    execution_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    case_execution_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    case_definition_id: Optional[str] = None
    name: Optional[str] = None
    parent_task_id: Optional[str] = None
    description: Optional[str] = None
    task_definition_key: Optional[str] = None
    owner: Optional[str] = None
    assignee: Optional[str] = None
    delegation_state: Optional[Union[str, "DelegationState"]] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    last_updated: Optional[Union[str, XSDDateTime]] = None
    due_date: Optional[Union[str, XSDDateTime]] = None
    follow_up_date: Optional[Union[str, XSDDateTime]] = None
    suspension_state: Optional[Union[str, "SuspensionState"]] = None
    tenant_id: Optional[str] = None
    task_state: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TaskId):
            self.id = TaskId(self.id)

        if self._is_empty(self.priority):
            self.MissingRequiredField("priority")
        if not isinstance(self.priority, int):
            self.priority = int(self.priority)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, str):
            self.case_execution_id = str(self.case_execution_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.case_definition_id is not None and not isinstance(self.case_definition_id, str):
            self.case_definition_id = str(self.case_definition_id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.parent_task_id is not None and not isinstance(self.parent_task_id, str):
            self.parent_task_id = str(self.parent_task_id)

        if self.description is not None and not isinstance(self.description, str):
            self.description = str(self.description)

        if self.task_definition_key is not None and not isinstance(self.task_definition_key, str):
            self.task_definition_key = str(self.task_definition_key)

        if self.owner is not None and not isinstance(self.owner, str):
            self.owner = str(self.owner)

        if self.assignee is not None and not isinstance(self.assignee, str):
            self.assignee = str(self.assignee)

        if self.delegation_state is not None and not isinstance(self.delegation_state, DelegationState):
            self.delegation_state = DelegationState(self.delegation_state)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.last_updated is not None and not isinstance(self.last_updated, XSDDateTime):
            self.last_updated = XSDDateTime(self.last_updated)

        if self.due_date is not None and not isinstance(self.due_date, XSDDateTime):
            self.due_date = XSDDateTime(self.due_date)

        if self.follow_up_date is not None and not isinstance(self.follow_up_date, XSDDateTime):
            self.follow_up_date = XSDDateTime(self.follow_up_date)

        if self.suspension_state is not None and not isinstance(self.suspension_state, SuspensionState):
            self.suspension_state = SuspensionState(self.suspension_state)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.task_state is not None and not isinstance(self.task_state, str):
            self.task_state = str(self.task_state)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class VariableInstance(YAMLRoot):
    """
    A VariableInstance represents a variable in the execution of a process instance.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_RUNTIME["VariableInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_runtime:VariableInstance"
    class_name: ClassVar[str] = "VariableInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.VariableInstance

    id: Union[str, VariableInstanceId] = None
    type: str = None
    name: str = None
    variable_scope_id: str = None
    execution_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    case_execution_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    task_id: Optional[str] = None
    batch_id: Optional[str] = None
    byte_array_id: Optional[str] = None
    double_value: Optional[float] = None
    long_value: Optional[int] = None
    text_value: Optional[str] = None
    text2_value: Optional[str] = None
    sequence_counter: Optional[int] = None
    is_concurrent_local: Optional[Union[bool, Bool]] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, VariableInstanceId):
            self.id = VariableInstanceId(self.id)

        if self._is_empty(self.type):
            self.MissingRequiredField("type")
        if not isinstance(self.type, str):
            self.type = str(self.type)

        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if self._is_empty(self.variable_scope_id):
            self.MissingRequiredField("variable_scope_id")
        if not isinstance(self.variable_scope_id, str):
            self.variable_scope_id = str(self.variable_scope_id)

        if self.execution_id is not None and not isinstance(self.execution_id, str):
            self.execution_id = str(self.execution_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, str):
            self.case_execution_id = str(self.case_execution_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.batch_id is not None and not isinstance(self.batch_id, str):
            self.batch_id = str(self.batch_id)

        if self.byte_array_id is not None and not isinstance(self.byte_array_id, str):
            self.byte_array_id = str(self.byte_array_id)

        if self.double_value is not None and not isinstance(self.double_value, float):
            self.double_value = float(self.double_value)

        if self.long_value is not None and not isinstance(self.long_value, int):
            self.long_value = int(self.long_value)

        if self.text_value is not None and not isinstance(self.text_value, str):
            self.text_value = str(self.text_value)

        if self.text2_value is not None and not isinstance(self.text2_value, str):
            self.text2_value = str(self.text2_value)

        if self.sequence_counter is not None and not isinstance(self.sequence_counter, int):
            self.sequence_counter = int(self.sequence_counter)

        if self.is_concurrent_local is not None and not isinstance(self.is_concurrent_local, Bool):
            self.is_concurrent_local = Bool(self.is_concurrent_local)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnModelInstance(YAMLRoot):
    """
    Root container for a parsed BPMN model, providing access to the Definitions element.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL["BpmnModelInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model:BpmnModelInstance"
    class_name: ClassVar[str] = "BpmnModelInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnModelInstance

    definitions: Optional[Union[str, DefinitionsId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.definitions is not None and not isinstance(self.definitions, DefinitionsId):
            self.definitions = DefinitionsId(self.definitions)

        super().__post_init__(**kwargs)


class BpmnModelType(YAMLRoot):
    """
    Enumeration-like interface representing the BPMN model type.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL["BpmnModelType"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model:BpmnModelType"
    class_name: ClassVar[str] = "BpmnModelType"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnModelType


@dataclass(repr=False)
class BpmnModelElementInstance(YAMLRoot):
    """
    Interface implemented by all elements in a BPMN Model
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["BpmnModelElementInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:BpmnModelElementInstance"
    class_name: ClassVar[str] = "BpmnModelElementInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnModelElementInstance

    scope: Optional[Union[dict, "BpmnModelElementInstance"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.scope is not None and not isinstance(self.scope, BpmnModelElementInstance):
            self.scope = BpmnModelElementInstance(**as_dict(self.scope))

        if self.scope is not None and not isinstance(self.scope, Bool):
            self.scope = Bool(self.scope)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Bounds(BpmnModelElementInstance):
    """
    The DC bounds element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DC["Bounds"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_dc:Bounds"
    class_name: ClassVar[str] = "Bounds"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Bounds

    x: Optional[float] = None
    y: Optional[float] = None
    width: Optional[float] = None
    height: Optional[float] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.x is not None and not isinstance(self.x, float):
            self.x = float(self.x)

        if self.y is not None and not isinstance(self.y, float):
            self.y = float(self.y)

        if self.width is not None and not isinstance(self.width, float):
            self.width = float(self.width)

        if self.height is not None and not isinstance(self.height, float):
            self.height = float(self.height)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Font(BpmnModelElementInstance):
    """
    The DC font element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DC["Font"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_dc:Font"
    class_name: ClassVar[str] = "Font"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Font

    name: Optional[str] = None
    size: Optional[float] = None
    bold: Optional[Union[bool, Bool]] = None
    italic: Optional[Union[bool, Bool]] = None
    underline: Optional[Union[bool, Bool]] = None
    strike_through: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.size is not None and not isinstance(self.size, float):
            self.size = float(self.size)

        if self.bold is not None and not isinstance(self.bold, Bool):
            self.bold = Bool(self.bold)

        if self.italic is not None and not isinstance(self.italic, Bool):
            self.italic = Bool(self.italic)

        if self.underline is not None and not isinstance(self.underline, Bool):
            self.underline = Bool(self.underline)

        if self.strike_through is not None and not isinstance(self.strike_through, Bool):
            self.strike_through = Bool(self.strike_through)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Point(BpmnModelElementInstance):
    """
    The DC point element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DC["Point"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_dc:Point"
    class_name: ClassVar[str] = "Point"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Point

    x: Optional[float] = None
    y: Optional[float] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.x is not None and not isinstance(self.x, float):
            self.x = float(self.x)

        if self.y is not None and not isinstance(self.y, float):
            self.y = float(self.y)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Diagram(BpmnModelElementInstance):
    """
    The DI Diagram element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["Diagram"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:Diagram"
    class_name: ClassVar[str] = "Diagram"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Diagram

    id: Union[str, DiagramId] = None
    name: Optional[str] = None
    documentation: Optional[str] = None
    resolution: Optional[float] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DiagramId):
            self.id = DiagramId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.documentation is not None and not isinstance(self.documentation, str):
            self.documentation = str(self.documentation)

        if self.resolution is not None and not isinstance(self.resolution, float):
            self.resolution = float(self.resolution)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DiagramElement(BpmnModelElementInstance):
    """
    The DI DiagramElement element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["DiagramElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:DiagramElement"
    class_name: ClassVar[str] = "DiagramElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiagramElement

    id: Union[str, DiagramElementId] = None
    extension: Optional[Union[dict, "Extension"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DiagramElementId):
            self.id = DiagramElementId(self.id)

        if self.extension is not None and not isinstance(self.extension, Extension):
            self.extension = Extension(**as_dict(self.extension))

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Edge(DiagramElement):
    """
    The DI Edge element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["Edge"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:Edge"
    class_name: ClassVar[str] = "Edge"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Edge

    id: Union[str, EdgeId] = None
    waypoints: Optional[Union[Union[dict, "Waypoint"], list[Union[dict, "Waypoint"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, EdgeId):
            self.id = EdgeId(self.id)

        if not isinstance(self.waypoints, list):
            self.waypoints = [self.waypoints] if self.waypoints is not None else []
        self.waypoints = [v if isinstance(v, Waypoint) else Waypoint(**as_dict(v)) for v in self.waypoints]

        super().__post_init__(**kwargs)


class Extension(BpmnModelElementInstance):
    """
    The DI extension element of the DI DiagramElement type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["Extension"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:Extension"
    class_name: ClassVar[str] = "Extension"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Extension


@dataclass(repr=False)
class LabeledEdge(Edge):
    """
    The DI LabeledEdge element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["LabeledEdge"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:LabeledEdge"
    class_name: ClassVar[str] = "LabeledEdge"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.LabeledEdge

    id: Union[str, LabeledEdgeId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, LabeledEdgeId):
            self.id = LabeledEdgeId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Node(DiagramElement):
    """
    The DI Node element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["Node"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:Node"
    class_name: ClassVar[str] = "Node"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Node

    id: Union[str, NodeId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, NodeId):
            self.id = NodeId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Label(Node):
    """
    The DI Label element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["Label"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:Label"
    class_name: ClassVar[str] = "Label"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Label

    id: Union[str, LabelId] = None
    bounds: Optional[Union[dict, Bounds]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, LabelId):
            self.id = LabelId(self.id)

        if self.bounds is not None and not isinstance(self.bounds, Bounds):
            self.bounds = Bounds(**as_dict(self.bounds))

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Plane(Node):
    """
    The DI Plane element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["Plane"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:Plane"
    class_name: ClassVar[str] = "Plane"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Plane

    id: Union[str, PlaneId] = None
    diagram_elements: Optional[Union[dict[Union[str, DiagramElementId], Union[dict, DiagramElement]], list[Union[dict, DiagramElement]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, PlaneId):
            self.id = PlaneId(self.id)

        self._normalize_inlined_as_list(slot_name="diagram_elements", slot_type=DiagramElement, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Shape(Node):
    """
    The DI Shape element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["Shape"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:Shape"
    class_name: ClassVar[str] = "Shape"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Shape

    id: Union[str, ShapeId] = None
    bounds: Optional[Union[dict, Bounds]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ShapeId):
            self.id = ShapeId(self.id)

        if self.bounds is not None and not isinstance(self.bounds, Bounds):
            self.bounds = Bounds(**as_dict(self.bounds))

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class LabeledShape(Shape):
    """
    The DI LabeledShape element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["LabeledShape"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:LabeledShape"
    class_name: ClassVar[str] = "LabeledShape"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.LabeledShape

    id: Union[str, LabeledShapeId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, LabeledShapeId):
            self.id = LabeledShapeId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Style(BpmnModelElementInstance):
    """
    The DI Style element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["Style"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:Style"
    class_name: ClassVar[str] = "Style"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Style

    id: Union[str, StyleId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, StyleId):
            self.id = StyleId(self.id)

        super().__post_init__(**kwargs)


class Waypoint(Point):
    """
    The DI waypoint element of the DI Edge type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_DI["Waypoint"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_di:Waypoint"
    class_name: ClassVar[str] = "Waypoint"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Waypoint


@dataclass(repr=False)
class BaseElement(BpmnModelElementInstance):
    """
    The BPMN baseElement element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["BaseElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:BaseElement"
    class_name: ClassVar[str] = "BaseElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BaseElement

    id: Union[str, BaseElementId] = None
    documentations: Optional[Union[dict[Union[str, DocumentationId], Union[dict, "Documentation"]], list[Union[dict, "Documentation"]]]] = empty_dict()
    extension_elements: Optional[Union[dict, "ExtensionElements"]] = None
    diagram_element: Optional[Union[str, DiagramElementId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BaseElementId):
            self.id = BaseElementId(self.id)

        self._normalize_inlined_as_list(slot_name="documentations", slot_type=Documentation, key_name="id", keyed=True)

        if self.extension_elements is not None and not isinstance(self.extension_elements, ExtensionElements):
            self.extension_elements = ExtensionElements(**as_dict(self.extension_elements))

        if self.diagram_element is not None and not isinstance(self.diagram_element, DiagramElementId):
            self.diagram_element = DiagramElementId(self.diagram_element)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Artifact(BaseElement):
    """
    The BPMN artifact element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Artifact"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Artifact"
    class_name: ClassVar[str] = "Artifact"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Artifact

    id: Union[str, ArtifactId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ArtifactId):
            self.id = ArtifactId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Assignment(BaseElement):
    """
    The BPMN assignment element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Assignment"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Assignment"
    class_name: ClassVar[str] = "Assignment"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Assignment

    id: Union[str, AssignmentId] = None
    from_: Optional[str] = None
    to_: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, AssignmentId):
            self.id = AssignmentId(self.id)

        if self.from_ is not None and not isinstance(self.from_, str):
            self.from_ = str(self.from_)

        if self.to_ is not None and not isinstance(self.to_, str):
            self.to_ = str(self.to_)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Association(Artifact):
    """
    The BPMN association element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Association"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Association"
    class_name: ClassVar[str] = "Association"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Association

    id: Union[str, AssociationId] = None
    source: Optional[Union[str, BaseElementId]] = None
    target: Optional[Union[str, BaseElementId]] = None
    association_direction: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, AssociationId):
            self.id = AssociationId(self.id)

        if self.source is not None and not isinstance(self.source, BaseElementId):
            self.source = BaseElementId(self.source)

        if self.target is not None and not isinstance(self.target, BaseElementId):
            self.target = BaseElementId(self.target)

        if self.association_direction is not None and not isinstance(self.association_direction, str):
            self.association_direction = str(self.association_direction)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Auditing(BaseElement):
    """
    The BPMN auditing element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Auditing"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Auditing"
    class_name: ClassVar[str] = "Auditing"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Auditing

    id: Union[str, AuditingId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, AuditingId):
            self.id = AuditingId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CategoryValue(BaseElement):
    """
    The BPMN categoryValue element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CategoryValue"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CategoryValue"
    class_name: ClassVar[str] = "CategoryValue"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CategoryValue

    id: Union[str, CategoryValueId] = None
    value: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CategoryValueId):
            self.id = CategoryValueId(self.id)

        if self.value is not None and not isinstance(self.value, str):
            self.value = str(self.value)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ComplexBehaviorDefinition(BaseElement):
    """
    Note: Currently not implemented, because both child elements are defined with a name already used in the BPMN
    model API and it is currently not supported by the model API to define elements with th...
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ComplexBehaviorDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ComplexBehaviorDefinition"
    class_name: ClassVar[str] = "ComplexBehaviorDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ComplexBehaviorDefinition

    id: Union[str, ComplexBehaviorDefinitionId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ComplexBehaviorDefinitionId):
            self.id = ComplexBehaviorDefinitionId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ConversationAssociation(BaseElement):
    """
    The BPMN conversationAssociation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ConversationAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ConversationAssociation"
    class_name: ClassVar[str] = "ConversationAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ConversationAssociation

    id: Union[str, ConversationAssociationId] = None
    inner_conversation_node: Optional[Union[str, ConversationNodeId]] = None
    outer_conversation_node: Optional[Union[str, ConversationNodeId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ConversationAssociationId):
            self.id = ConversationAssociationId(self.id)

        if self.inner_conversation_node is not None and not isinstance(self.inner_conversation_node, ConversationNodeId):
            self.inner_conversation_node = ConversationNodeId(self.inner_conversation_node)

        if self.outer_conversation_node is not None and not isinstance(self.outer_conversation_node, ConversationNodeId):
            self.outer_conversation_node = ConversationNodeId(self.outer_conversation_node)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ConversationLink(BaseElement):
    """
    The BPMN conversationLink element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ConversationLink"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ConversationLink"
    class_name: ClassVar[str] = "ConversationLink"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ConversationLink

    id: Union[str, ConversationLinkId] = None
    name: Optional[str] = None
    source: Optional[Union[str, InteractionNodeId]] = None
    target: Optional[Union[str, InteractionNodeId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ConversationLinkId):
            self.id = ConversationLinkId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.source is not None and not isinstance(self.source, InteractionNodeId):
            self.source = InteractionNodeId(self.source)

        if self.target is not None and not isinstance(self.target, InteractionNodeId):
            self.target = InteractionNodeId(self.target)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ConversationNode(BaseElement):
    """
    The BPMN conversationNode element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ConversationNode"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ConversationNode"
    class_name: ClassVar[str] = "ConversationNode"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ConversationNode

    id: Union[str, ConversationNodeId] = None
    name: Optional[str] = None
    participants: Optional[Union[dict[Union[str, ParticipantId], Union[dict, "Participant"]], list[Union[dict, "Participant"]]]] = empty_dict()
    message_flows: Optional[Union[dict[Union[str, MessageFlowId], Union[dict, "MessageFlow"]], list[Union[dict, "MessageFlow"]]]] = empty_dict()
    correlation_keys: Optional[Union[dict[Union[str, CorrelationKeyId], Union[dict, "CorrelationKey"]], list[Union[dict, "CorrelationKey"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ConversationNodeId):
            self.id = ConversationNodeId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        self._normalize_inlined_as_list(slot_name="participants", slot_type=Participant, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="message_flows", slot_type=MessageFlow, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="correlation_keys", slot_type=CorrelationKey, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CallConversation(ConversationNode):
    """
    The BPMN callConversation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CallConversation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CallConversation"
    class_name: ClassVar[str] = "CallConversation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CallConversation

    id: Union[str, CallConversationId] = None
    called_collaboration: Optional[Union[str, GlobalConversationId]] = None
    participant_associations: Optional[Union[dict[Union[str, ParticipantAssociationId], Union[dict, "ParticipantAssociation"]], list[Union[dict, "ParticipantAssociation"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CallConversationId):
            self.id = CallConversationId(self.id)

        if self.called_collaboration is not None and not isinstance(self.called_collaboration, GlobalConversationId):
            self.called_collaboration = GlobalConversationId(self.called_collaboration)

        self._normalize_inlined_as_list(slot_name="participant_associations", slot_type=ParticipantAssociation, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Conversation(ConversationNode):
    """
    The BPMN conversation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Conversation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Conversation"
    class_name: ClassVar[str] = "Conversation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Conversation

    id: Union[str, ConversationId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ConversationId):
            self.id = ConversationId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CorrelationKey(BaseElement):
    """
    The BPMN correlationKey element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CorrelationKey"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CorrelationKey"
    class_name: ClassVar[str] = "CorrelationKey"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CorrelationKey

    id: Union[str, CorrelationKeyId] = None
    name: Optional[str] = None
    correlation_properties: Optional[Union[dict[Union[str, CorrelationPropertyId], Union[dict, "CorrelationProperty"]], list[Union[dict, "CorrelationProperty"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CorrelationKeyId):
            self.id = CorrelationKeyId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        self._normalize_inlined_as_list(slot_name="correlation_properties", slot_type=CorrelationProperty, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CorrelationPropertyBinding(BaseElement):
    """
    The BPMN correlationPropertyBinding element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CorrelationPropertyBinding"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CorrelationPropertyBinding"
    class_name: ClassVar[str] = "CorrelationPropertyBinding"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CorrelationPropertyBinding

    id: Union[str, CorrelationPropertyBindingId] = None
    correlation_property: Optional[Union[str, CorrelationPropertyId]] = None
    data_path: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CorrelationPropertyBindingId):
            self.id = CorrelationPropertyBindingId(self.id)

        if self.correlation_property is not None and not isinstance(self.correlation_property, CorrelationPropertyId):
            self.correlation_property = CorrelationPropertyId(self.correlation_property)

        if self.data_path is not None and not isinstance(self.data_path, str):
            self.data_path = str(self.data_path)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CorrelationPropertyRetrievalExpression(BaseElement):
    """
    The BPMN correlationPropertyRetrievalExpression element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CorrelationPropertyRetrievalExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CorrelationPropertyRetrievalExpression"
    class_name: ClassVar[str] = "CorrelationPropertyRetrievalExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CorrelationPropertyRetrievalExpression

    id: Union[str, CorrelationPropertyRetrievalExpressionId] = None
    message: Optional[Union[str, MessageId]] = None
    message_path: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CorrelationPropertyRetrievalExpressionId):
            self.id = CorrelationPropertyRetrievalExpressionId(self.id)

        if self.message is not None and not isinstance(self.message, MessageId):
            self.message = MessageId(self.message)

        if self.message_path is not None and not isinstance(self.message_path, str):
            self.message_path = str(self.message_path)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CorrelationSubscription(BaseElement):
    """
    The BPMN correlationSubscription element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CorrelationSubscription"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CorrelationSubscription"
    class_name: ClassVar[str] = "CorrelationSubscription"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CorrelationSubscription

    id: Union[str, CorrelationSubscriptionId] = None
    correlation_key: Optional[Union[str, CorrelationKeyId]] = None
    correlation_property_bindings: Optional[Union[dict[Union[str, CorrelationPropertyBindingId], Union[dict, CorrelationPropertyBinding]], list[Union[dict, CorrelationPropertyBinding]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CorrelationSubscriptionId):
            self.id = CorrelationSubscriptionId(self.id)

        if self.correlation_key is not None and not isinstance(self.correlation_key, CorrelationKeyId):
            self.correlation_key = CorrelationKeyId(self.correlation_key)

        self._normalize_inlined_as_list(slot_name="correlation_property_bindings", slot_type=CorrelationPropertyBinding, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataAssociation(BaseElement):
    """
    The BPMN dataAssociation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataAssociation"
    class_name: ClassVar[str] = "DataAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataAssociation

    id: Union[str, DataAssociationId] = None
    sources: Optional[Union[dict[Union[str, ItemAwareElementId], Union[dict, "ItemAwareElement"]], list[Union[dict, "ItemAwareElement"]]]] = empty_dict()
    target: Optional[Union[str, ItemAwareElementId]] = None
    transformation: Optional[Union[str, FormalExpressionId]] = None
    assignments: Optional[Union[dict[Union[str, AssignmentId], Union[dict, Assignment]], list[Union[dict, Assignment]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataAssociationId):
            self.id = DataAssociationId(self.id)

        self._normalize_inlined_as_list(slot_name="sources", slot_type=ItemAwareElement, key_name="id", keyed=True)

        if self.target is not None and not isinstance(self.target, ItemAwareElementId):
            self.target = ItemAwareElementId(self.target)

        if self.transformation is not None and not isinstance(self.transformation, FormalExpressionId):
            self.transformation = FormalExpressionId(self.transformation)

        self._normalize_inlined_as_list(slot_name="assignments", slot_type=Assignment, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataInputAssociation(DataAssociation):
    """
    The BPMN dataInputAssociation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataInputAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataInputAssociation"
    class_name: ClassVar[str] = "DataInputAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataInputAssociation

    id: Union[str, DataInputAssociationId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataInputAssociationId):
            self.id = DataInputAssociationId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataOutputAssociation(DataAssociation):
    """
    The BPMN dataOutputAssociation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataOutputAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataOutputAssociation"
    class_name: ClassVar[str] = "DataOutputAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataOutputAssociation

    id: Union[str, DataOutputAssociationId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataOutputAssociationId):
            self.id = DataOutputAssociationId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataState(BaseElement):
    """
    The BPMN dataState element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataState"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataState"
    class_name: ClassVar[str] = "DataState"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataState

    id: Union[str, DataStateId] = None
    name: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataStateId):
            self.id = DataStateId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Definitions(BpmnModelElementInstance):
    """
    The BPMN definitions element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Definitions"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Definitions"
    class_name: ClassVar[str] = "Definitions"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Definitions

    id: Union[str, DefinitionsId] = None
    name: Optional[str] = None
    target_namespace: Optional[str] = None
    expression_language: Optional[str] = None
    type_language: Optional[str] = None
    exporter: Optional[str] = None
    exporter_version: Optional[str] = None
    imports: Optional[Union[Union[dict, "Import"], list[Union[dict, "Import"]]]] = empty_list()
    extensions: Optional[Union[Union[dict, Extension], list[Union[dict, Extension]]]] = empty_list()
    root_elements: Optional[Union[dict[Union[str, RootElementId], Union[dict, "RootElement"]], list[Union[dict, "RootElement"]]]] = empty_dict()
    bpm_diagrams: Optional[Union[str, list[str]]] = empty_list()
    relationships: Optional[Union[dict[Union[str, RelationshipId], Union[dict, "Relationship"]], list[Union[dict, "Relationship"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DefinitionsId):
            self.id = DefinitionsId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.target_namespace is not None and not isinstance(self.target_namespace, str):
            self.target_namespace = str(self.target_namespace)

        if self.expression_language is not None and not isinstance(self.expression_language, str):
            self.expression_language = str(self.expression_language)

        if self.type_language is not None and not isinstance(self.type_language, str):
            self.type_language = str(self.type_language)

        if self.exporter is not None and not isinstance(self.exporter, str):
            self.exporter = str(self.exporter)

        if self.exporter_version is not None and not isinstance(self.exporter_version, str):
            self.exporter_version = str(self.exporter_version)

        if not isinstance(self.imports, list):
            self.imports = [self.imports] if self.imports is not None else []
        self.imports = [v if isinstance(v, Import) else Import(**as_dict(v)) for v in self.imports]

        if not isinstance(self.extensions, list):
            self.extensions = [self.extensions] if self.extensions is not None else []
        self.extensions = [v if isinstance(v, Extension) else Extension(**as_dict(v)) for v in self.extensions]

        self._normalize_inlined_as_list(slot_name="root_elements", slot_type=RootElement, key_name="id", keyed=True)

        if not isinstance(self.bpm_diagrams, list):
            self.bpm_diagrams = [self.bpm_diagrams] if self.bpm_diagrams is not None else []
        self.bpm_diagrams = [v if isinstance(v, str) else str(v) for v in self.bpm_diagrams]

        self._normalize_inlined_as_list(slot_name="relationships", slot_type=Relationship, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Documentation(BpmnModelElementInstance):
    """
    The BPMN documentation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Documentation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Documentation"
    class_name: ClassVar[str] = "Documentation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Documentation

    id: Union[str, DocumentationId] = None
    text_format: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DocumentationId):
            self.id = DocumentationId(self.id)

        if self.text_format is not None and not isinstance(self.text_format, str):
            self.text_format = str(self.text_format)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Expression(BaseElement):
    """
    The BPMN expression element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Expression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Expression"
    class_name: ClassVar[str] = "Expression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Expression

    id: Union[str, ExpressionId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ExpressionId):
            self.id = ExpressionId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ActivationCondition(Expression):
    """
    The BPMN element activationCondition of the BPMN tComplexGateway type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ActivationCondition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ActivationCondition"
    class_name: ClassVar[str] = "ActivationCondition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ActivationCondition

    id: Union[str, ActivationConditionId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ActivationConditionId):
            self.id = ActivationConditionId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CompletionCondition(Expression):
    """
    The BPMN 2.0 completionCondition element from the tMultiInstanceLoopCharacteristics type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CompletionCondition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CompletionCondition"
    class_name: ClassVar[str] = "CompletionCondition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CompletionCondition

    id: Union[str, CompletionConditionId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CompletionConditionId):
            self.id = CompletionConditionId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Condition(Expression):
    """
    The BPMN condition element of the BPMN tConditionalEventDefinition type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Condition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Condition"
    class_name: ClassVar[str] = "Condition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Condition

    id: Union[str, ConditionId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ConditionId):
            self.id = ConditionId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ExtensionElements(BpmnModelElementInstance):
    """
    The BPMN extensionElements element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ExtensionElements"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ExtensionElements"
    class_name: ClassVar[str] = "ExtensionElements"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ExtensionElements

    elements: Optional[Union[str, list[str]]] = empty_list()
    elements_query: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.elements, list):
            self.elements = [self.elements] if self.elements is not None else []
        self.elements = [v if isinstance(v, str) else str(v) for v in self.elements]

        if self.elements_query is not None and not isinstance(self.elements_query, str):
            self.elements_query = str(self.elements_query)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FlowElement(BaseElement):
    """
    The BPMN flowElement element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["FlowElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:FlowElement"
    class_name: ClassVar[str] = "FlowElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FlowElement

    id: Union[str, FlowElementId] = None
    name: Optional[str] = None
    auditing: Optional[Union[str, AuditingId]] = None
    monitoring: Optional[Union[str, MonitoringId]] = None
    category_value_refs: Optional[Union[dict[Union[str, CategoryValueId], Union[dict, CategoryValue]], list[Union[dict, CategoryValue]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FlowElementId):
            self.id = FlowElementId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.auditing is not None and not isinstance(self.auditing, AuditingId):
            self.auditing = AuditingId(self.auditing)

        if self.monitoring is not None and not isinstance(self.monitoring, MonitoringId):
            self.monitoring = MonitoringId(self.monitoring)

        self._normalize_inlined_as_list(slot_name="category_value_refs", slot_type=CategoryValue, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataObject(FlowElement):
    """
    The BPMN dataObject element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataObject"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataObject"
    class_name: ClassVar[str] = "DataObject"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataObject

    id: Union[str, DataObjectId] = None
    scope: Optional[Union[bool, Bool]] = None
    documentations: Optional[Union[dict[Union[str, DocumentationId], Union[dict, Documentation]], list[Union[dict, Documentation]]]] = empty_dict()
    extension_elements: Optional[Union[dict, ExtensionElements]] = None
    diagram_element: Optional[Union[str, DiagramElementId]] = None
    collection: Optional[Union[bool, Bool]] = None
    item_subject: Optional[Union[str, ItemDefinitionId]] = None
    data_state: Optional[Union[str, DataStateId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataObjectId):
            self.id = DataObjectId(self.id)

        if self.scope is not None and not isinstance(self.scope, Bool):
            self.scope = Bool(self.scope)

        self._normalize_inlined_as_list(slot_name="documentations", slot_type=Documentation, key_name="id", keyed=True)

        if self.extension_elements is not None and not isinstance(self.extension_elements, ExtensionElements):
            self.extension_elements = ExtensionElements(**as_dict(self.extension_elements))

        if self.diagram_element is not None and not isinstance(self.diagram_element, DiagramElementId):
            self.diagram_element = DiagramElementId(self.diagram_element)

        if self.collection is not None and not isinstance(self.collection, Bool):
            self.collection = Bool(self.collection)

        if self.item_subject is not None and not isinstance(self.item_subject, ItemDefinitionId):
            self.item_subject = ItemDefinitionId(self.item_subject)

        if self.data_state is not None and not isinstance(self.data_state, DataStateId):
            self.data_state = DataStateId(self.data_state)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataObjectReference(FlowElement):
    """
    The BPMN dataObjectReference element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataObjectReference"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataObjectReference"
    class_name: ClassVar[str] = "DataObjectReference"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataObjectReference

    id: Union[str, DataObjectReferenceId] = None
    scope: Optional[Union[bool, Bool]] = None
    documentations: Optional[Union[dict[Union[str, DocumentationId], Union[dict, Documentation]], list[Union[dict, Documentation]]]] = empty_dict()
    extension_elements: Optional[Union[dict, ExtensionElements]] = None
    diagram_element: Optional[Union[str, DiagramElementId]] = None
    data_object: Optional[Union[str, DataObjectId]] = None
    item_subject: Optional[Union[str, ItemDefinitionId]] = None
    data_state: Optional[Union[str, DataStateId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataObjectReferenceId):
            self.id = DataObjectReferenceId(self.id)

        if self.scope is not None and not isinstance(self.scope, Bool):
            self.scope = Bool(self.scope)

        self._normalize_inlined_as_list(slot_name="documentations", slot_type=Documentation, key_name="id", keyed=True)

        if self.extension_elements is not None and not isinstance(self.extension_elements, ExtensionElements):
            self.extension_elements = ExtensionElements(**as_dict(self.extension_elements))

        if self.diagram_element is not None and not isinstance(self.diagram_element, DiagramElementId):
            self.diagram_element = DiagramElementId(self.diagram_element)

        if self.data_object is not None and not isinstance(self.data_object, DataObjectId):
            self.data_object = DataObjectId(self.data_object)

        if self.item_subject is not None and not isinstance(self.item_subject, ItemDefinitionId):
            self.item_subject = ItemDefinitionId(self.item_subject)

        if self.data_state is not None and not isinstance(self.data_state, DataStateId):
            self.data_state = DataStateId(self.data_state)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataStoreReference(FlowElement):
    """
    The BPMN dataStoreReference element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataStoreReference"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataStoreReference"
    class_name: ClassVar[str] = "DataStoreReference"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataStoreReference

    id: Union[str, DataStoreReferenceId] = None
    scope: Optional[Union[bool, Bool]] = None
    documentations: Optional[Union[dict[Union[str, DocumentationId], Union[dict, Documentation]], list[Union[dict, Documentation]]]] = empty_dict()
    extension_elements: Optional[Union[dict, ExtensionElements]] = None
    diagram_element: Optional[Union[str, DiagramElementId]] = None
    data_store: Optional[Union[str, DataStoreId]] = None
    item_subject: Optional[Union[str, ItemDefinitionId]] = None
    data_state: Optional[Union[str, DataStateId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataStoreReferenceId):
            self.id = DataStoreReferenceId(self.id)

        if self.scope is not None and not isinstance(self.scope, Bool):
            self.scope = Bool(self.scope)

        self._normalize_inlined_as_list(slot_name="documentations", slot_type=Documentation, key_name="id", keyed=True)

        if self.extension_elements is not None and not isinstance(self.extension_elements, ExtensionElements):
            self.extension_elements = ExtensionElements(**as_dict(self.extension_elements))

        if self.diagram_element is not None and not isinstance(self.diagram_element, DiagramElementId):
            self.diagram_element = DiagramElementId(self.diagram_element)

        if self.data_store is not None and not isinstance(self.data_store, DataStoreId):
            self.data_store = DataStoreId(self.data_store)

        if self.item_subject is not None and not isinstance(self.item_subject, ItemDefinitionId):
            self.item_subject = ItemDefinitionId(self.item_subject)

        if self.data_state is not None and not isinstance(self.data_state, DataStateId):
            self.data_state = DataStateId(self.data_state)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FlowNode(FlowElement):
    """
    The BPMN flowNode element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["FlowNode"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:FlowNode"
    class_name: ClassVar[str] = "FlowNode"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FlowNode

    id: Union[str, FlowNodeId] = None
    incoming: Optional[Union[dict[Union[str, SequenceFlowId], Union[dict, "SequenceFlow"]], list[Union[dict, "SequenceFlow"]]]] = empty_dict()
    outgoing: Optional[Union[dict[Union[str, SequenceFlowId], Union[dict, "SequenceFlow"]], list[Union[dict, "SequenceFlow"]]]] = empty_dict()
    previous_nodes: Optional[Union[str, FlowNodeId]] = None
    succeeding_nodes: Optional[Union[str, FlowNodeId]] = None
    fluxnova_async_before: Optional[Union[bool, Bool]] = None
    fluxnova_async_after: Optional[Union[bool, Bool]] = None
    fluxnova_exclusive: Optional[Union[bool, Bool]] = None
    fluxnova_job_priority: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FlowNodeId):
            self.id = FlowNodeId(self.id)

        self._normalize_inlined_as_list(slot_name="incoming", slot_type=SequenceFlow, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="outgoing", slot_type=SequenceFlow, key_name="id", keyed=True)

        if self.previous_nodes is not None and not isinstance(self.previous_nodes, FlowNodeId):
            self.previous_nodes = FlowNodeId(self.previous_nodes)

        if self.succeeding_nodes is not None and not isinstance(self.succeeding_nodes, FlowNodeId):
            self.succeeding_nodes = FlowNodeId(self.succeeding_nodes)

        if self.fluxnova_async_before is not None and not isinstance(self.fluxnova_async_before, Bool):
            self.fluxnova_async_before = Bool(self.fluxnova_async_before)

        if self.fluxnova_async_after is not None and not isinstance(self.fluxnova_async_after, Bool):
            self.fluxnova_async_after = Bool(self.fluxnova_async_after)

        if self.fluxnova_exclusive is not None and not isinstance(self.fluxnova_exclusive, Bool):
            self.fluxnova_exclusive = Bool(self.fluxnova_exclusive)

        if self.fluxnova_job_priority is not None and not isinstance(self.fluxnova_job_priority, str):
            self.fluxnova_job_priority = str(self.fluxnova_job_priority)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Activity(FlowNode):
    """
    The BPMN activity element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Activity"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Activity"
    class_name: ClassVar[str] = "Activity"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Activity

    id: Union[str, ActivityId] = None
    for_compensation: Optional[Union[bool, Bool]] = None
    start_quantity: Optional[int] = None
    completion_quantity: Optional[int] = None
    default: Optional[Union[str, SequenceFlowId]] = None
    io_specification: Optional[Union[str, IoSpecificationId]] = None
    properties: Optional[Union[dict[Union[str, BpmnPropertyId], Union[dict, "BpmnProperty"]], list[Union[dict, "BpmnProperty"]]]] = empty_dict()
    data_input_associations: Optional[Union[dict[Union[str, DataInputAssociationId], Union[dict, DataInputAssociation]], list[Union[dict, DataInputAssociation]]]] = empty_dict()
    data_output_associations: Optional[Union[dict[Union[str, DataOutputAssociationId], Union[dict, DataOutputAssociation]], list[Union[dict, DataOutputAssociation]]]] = empty_dict()
    resource_roles: Optional[Union[dict[Union[str, ResourceRoleId], Union[dict, "ResourceRole"]], list[Union[dict, "ResourceRole"]]]] = empty_dict()
    loop_characteristics: Optional[Union[str, LoopCharacteristicsId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ActivityId):
            self.id = ActivityId(self.id)

        if self.for_compensation is not None and not isinstance(self.for_compensation, Bool):
            self.for_compensation = Bool(self.for_compensation)

        if self.start_quantity is not None and not isinstance(self.start_quantity, int):
            self.start_quantity = int(self.start_quantity)

        if self.completion_quantity is not None and not isinstance(self.completion_quantity, int):
            self.completion_quantity = int(self.completion_quantity)

        if self.default is not None and not isinstance(self.default, SequenceFlowId):
            self.default = SequenceFlowId(self.default)

        if self.io_specification is not None and not isinstance(self.io_specification, IoSpecificationId):
            self.io_specification = IoSpecificationId(self.io_specification)

        self._normalize_inlined_as_list(slot_name="properties", slot_type=BpmnProperty, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="data_input_associations", slot_type=DataInputAssociation, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="data_output_associations", slot_type=DataOutputAssociation, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="resource_roles", slot_type=ResourceRole, key_name="id", keyed=True)

        if self.loop_characteristics is not None and not isinstance(self.loop_characteristics, LoopCharacteristicsId):
            self.loop_characteristics = LoopCharacteristicsId(self.loop_characteristics)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CallActivity(Activity):
    """
    The BPMN callActivity element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CallActivity"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CallActivity"
    class_name: ClassVar[str] = "CallActivity"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CallActivity

    id: Union[str, CallActivityId] = None
    called_element: Optional[str] = None
    fluxnova_async: Optional[Union[bool, Bool]] = None
    fluxnova_called_element_binding: Optional[str] = None
    fluxnova_called_element_version: Optional[str] = None
    fluxnova_called_element_version_tag: Optional[str] = None
    fluxnova_case_ref: Optional[str] = None
    fluxnova_case_binding: Optional[str] = None
    fluxnova_case_version: Optional[str] = None
    fluxnova_called_element_tenant_id: Optional[str] = None
    fluxnova_case_tenant_id: Optional[str] = None
    fluxnova_variable_mapping_class: Optional[str] = None
    fluxnova_variable_mapping_delegate_expression: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CallActivityId):
            self.id = CallActivityId(self.id)

        if self.called_element is not None and not isinstance(self.called_element, str):
            self.called_element = str(self.called_element)

        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        if self.fluxnova_called_element_binding is not None and not isinstance(self.fluxnova_called_element_binding, str):
            self.fluxnova_called_element_binding = str(self.fluxnova_called_element_binding)

        if self.fluxnova_called_element_version is not None and not isinstance(self.fluxnova_called_element_version, str):
            self.fluxnova_called_element_version = str(self.fluxnova_called_element_version)

        if self.fluxnova_called_element_version_tag is not None and not isinstance(self.fluxnova_called_element_version_tag, str):
            self.fluxnova_called_element_version_tag = str(self.fluxnova_called_element_version_tag)

        if self.fluxnova_case_ref is not None and not isinstance(self.fluxnova_case_ref, str):
            self.fluxnova_case_ref = str(self.fluxnova_case_ref)

        if self.fluxnova_case_binding is not None and not isinstance(self.fluxnova_case_binding, str):
            self.fluxnova_case_binding = str(self.fluxnova_case_binding)

        if self.fluxnova_case_version is not None and not isinstance(self.fluxnova_case_version, str):
            self.fluxnova_case_version = str(self.fluxnova_case_version)

        if self.fluxnova_called_element_tenant_id is not None and not isinstance(self.fluxnova_called_element_tenant_id, str):
            self.fluxnova_called_element_tenant_id = str(self.fluxnova_called_element_tenant_id)

        if self.fluxnova_case_tenant_id is not None and not isinstance(self.fluxnova_case_tenant_id, str):
            self.fluxnova_case_tenant_id = str(self.fluxnova_case_tenant_id)

        if self.fluxnova_variable_mapping_class is not None and not isinstance(self.fluxnova_variable_mapping_class, str):
            self.fluxnova_variable_mapping_class = str(self.fluxnova_variable_mapping_class)

        if self.fluxnova_variable_mapping_delegate_expression is not None and not isinstance(self.fluxnova_variable_mapping_delegate_expression, str):
            self.fluxnova_variable_mapping_delegate_expression = str(self.fluxnova_variable_mapping_delegate_expression)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Event(FlowNode):
    """
    The BPMN event element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Event"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Event"
    class_name: ClassVar[str] = "Event"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Event

    id: Union[str, EventId] = None
    properties: Optional[Union[dict[Union[str, BpmnPropertyId], Union[dict, "BpmnProperty"]], list[Union[dict, "BpmnProperty"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, EventId):
            self.id = EventId(self.id)

        self._normalize_inlined_as_list(slot_name="properties", slot_type=BpmnProperty, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CatchEvent(Event):
    """
    The BPMN catchEvent element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CatchEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CatchEvent"
    class_name: ClassVar[str] = "CatchEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CatchEvent

    id: Union[str, CatchEventId] = None
    parallel_multiple: Optional[Union[bool, Bool]] = None
    data_outputs: Optional[Union[dict[Union[str, DataOutputId], Union[dict, "DataOutput"]], list[Union[dict, "DataOutput"]]]] = empty_dict()
    data_output_associations: Optional[Union[dict[Union[str, DataOutputAssociationId], Union[dict, DataOutputAssociation]], list[Union[dict, DataOutputAssociation]]]] = empty_dict()
    output_set: Optional[Union[str, OutputSetId]] = None
    event_definitions: Optional[Union[dict[Union[str, EventDefinitionId], Union[dict, "EventDefinition"]], list[Union[dict, "EventDefinition"]]]] = empty_dict()
    event_definition_refs: Optional[Union[dict[Union[str, EventDefinitionId], Union[dict, "EventDefinition"]], list[Union[dict, "EventDefinition"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CatchEventId):
            self.id = CatchEventId(self.id)

        if self.parallel_multiple is not None and not isinstance(self.parallel_multiple, Bool):
            self.parallel_multiple = Bool(self.parallel_multiple)

        self._normalize_inlined_as_list(slot_name="data_outputs", slot_type=DataOutput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="data_output_associations", slot_type=DataOutputAssociation, key_name="id", keyed=True)

        if self.output_set is not None and not isinstance(self.output_set, OutputSetId):
            self.output_set = OutputSetId(self.output_set)

        self._normalize_inlined_as_list(slot_name="event_definitions", slot_type=EventDefinition, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="event_definition_refs", slot_type=EventDefinition, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BoundaryEvent(CatchEvent):
    """
    The BPMN boundaryEvent element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["BoundaryEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:BoundaryEvent"
    class_name: ClassVar[str] = "BoundaryEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BoundaryEvent

    id: Union[str, BoundaryEventId] = None
    attached_to: Optional[Union[str, ActivityId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BoundaryEventId):
            self.id = BoundaryEventId(self.id)

        if self.attached_to is not None and not isinstance(self.attached_to, ActivityId):
            self.attached_to = ActivityId(self.attached_to)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FormalExpression(Expression):
    """
    The BPMN formalExpression element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["FormalExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:FormalExpression"
    class_name: ClassVar[str] = "FormalExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FormalExpression

    id: Union[str, FormalExpressionId] = None
    language: Optional[str] = None
    evaluates_to_type: Optional[Union[str, ItemDefinitionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FormalExpressionId):
            self.id = FormalExpressionId(self.id)

        if self.language is not None and not isinstance(self.language, str):
            self.language = str(self.language)

        if self.evaluates_to_type is not None and not isinstance(self.evaluates_to_type, ItemDefinitionId):
            self.evaluates_to_type = ItemDefinitionId(self.evaluates_to_type)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ConditionExpression(FormalExpression):
    """
    The BPMN conditionExpression element of the BPMN tSequenceFlow type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ConditionExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ConditionExpression"
    class_name: ClassVar[str] = "ConditionExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ConditionExpression

    id: Union[str, ConditionExpressionId] = None
    type: Optional[str] = None
    fluxnova_resource: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ConditionExpressionId):
            self.id = ConditionExpressionId(self.id)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.fluxnova_resource is not None and not isinstance(self.fluxnova_resource, str):
            self.fluxnova_resource = str(self.fluxnova_resource)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Gateway(FlowNode):
    """
    The BPMN gateway element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Gateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Gateway"
    class_name: ClassVar[str] = "Gateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Gateway

    id: Union[str, GatewayId] = None
    gateway_direction: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, GatewayId):
            self.id = GatewayId(self.id)

        if self.gateway_direction is not None and not isinstance(self.gateway_direction, str):
            self.gateway_direction = str(self.gateway_direction)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ComplexGateway(Gateway):
    """
    The BPMN complexGateway element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ComplexGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ComplexGateway"
    class_name: ClassVar[str] = "ComplexGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ComplexGateway

    id: Union[str, ComplexGatewayId] = None
    default: Optional[Union[str, SequenceFlowId]] = None
    activation_condition: Optional[Union[str, ActivationConditionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ComplexGatewayId):
            self.id = ComplexGatewayId(self.id)

        if self.default is not None and not isinstance(self.default, SequenceFlowId):
            self.default = SequenceFlowId(self.default)

        if self.activation_condition is not None and not isinstance(self.activation_condition, ActivationConditionId):
            self.activation_condition = ActivationConditionId(self.activation_condition)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class EventBasedGateway(Gateway):
    """
    The BPMN eventBasedGateway element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["EventBasedGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:EventBasedGateway"
    class_name: ClassVar[str] = "EventBasedGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.EventBasedGateway

    id: Union[str, EventBasedGatewayId] = None
    instantiate: Optional[Union[bool, Bool]] = None
    event_gateway_type: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, EventBasedGatewayId):
            self.id = EventBasedGatewayId(self.id)

        if self.instantiate is not None and not isinstance(self.instantiate, Bool):
            self.instantiate = Bool(self.instantiate)

        if self.event_gateway_type is not None and not isinstance(self.event_gateway_type, str):
            self.event_gateway_type = str(self.event_gateway_type)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ExclusiveGateway(Gateway):
    """
    The BPMN exclusiveGateway element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ExclusiveGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ExclusiveGateway"
    class_name: ClassVar[str] = "ExclusiveGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ExclusiveGateway

    id: Union[str, ExclusiveGatewayId] = None
    default: Optional[Union[str, SequenceFlowId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ExclusiveGatewayId):
            self.id = ExclusiveGatewayId(self.id)

        if self.default is not None and not isinstance(self.default, SequenceFlowId):
            self.default = SequenceFlowId(self.default)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnGroup(Artifact):
    """
    An artifact that visually groups flow elements without affecting the process semantics.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["BpmnGroup"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:BpmnGroup"
    class_name: ClassVar[str] = "BpmnGroup"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnGroup

    id: Union[str, BpmnGroupId] = None
    category: Optional[Union[str, CategoryValueId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BpmnGroupId):
            self.id = BpmnGroupId(self.id)

        if self.category is not None and not isinstance(self.category, CategoryValueId):
            self.category = CategoryValueId(self.category)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Import(BpmnModelElementInstance):
    """
    The BPMN Import element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Import"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Import"
    class_name: ClassVar[str] = "Import"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Import

    namespace: Optional[str] = None
    location: Optional[str] = None
    import_type: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.namespace is not None and not isinstance(self.namespace, str):
            self.namespace = str(self.namespace)

        if self.location is not None and not isinstance(self.location, str):
            self.location = str(self.location)

        if self.import_type is not None and not isinstance(self.import_type, str):
            self.import_type = str(self.import_type)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class InclusiveGateway(Gateway):
    """
    The BPMN inclusiveGateway element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["InclusiveGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:InclusiveGateway"
    class_name: ClassVar[str] = "InclusiveGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.InclusiveGateway

    id: Union[str, InclusiveGatewayId] = None
    default: Optional[Union[str, SequenceFlowId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, InclusiveGatewayId):
            self.id = InclusiveGatewayId(self.id)

        if self.default is not None and not isinstance(self.default, SequenceFlowId):
            self.default = SequenceFlowId(self.default)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class InputSet(BaseElement):
    """
    The BPMN inputSet element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["InputSet"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:InputSet"
    class_name: ClassVar[str] = "InputSet"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.InputSet

    id: Union[str, InputSetId] = None
    name: Optional[str] = None
    data_inputs: Optional[Union[dict[Union[str, DataInputId], Union[dict, "DataInput"]], list[Union[dict, "DataInput"]]]] = empty_dict()
    optional_inputs: Optional[Union[dict[Union[str, DataInputId], Union[dict, "DataInput"]], list[Union[dict, "DataInput"]]]] = empty_dict()
    while_executing_input: Optional[Union[dict[Union[str, DataInputId], Union[dict, "DataInput"]], list[Union[dict, "DataInput"]]]] = empty_dict()
    output_sets: Optional[Union[dict[Union[str, OutputSetId], Union[dict, "OutputSet"]], list[Union[dict, "OutputSet"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, InputSetId):
            self.id = InputSetId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        self._normalize_inlined_as_list(slot_name="data_inputs", slot_type=DataInput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="optional_inputs", slot_type=DataInput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="while_executing_input", slot_type=DataInput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="output_sets", slot_type=OutputSet, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class InteractionNode(YAMLRoot):
    """
    The BPMN interactionNode interface
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["InteractionNode"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:InteractionNode"
    class_name: ClassVar[str] = "InteractionNode"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.InteractionNode

    id: Union[str, InteractionNodeId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, InteractionNodeId):
            self.id = InteractionNodeId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class IntermediateCatchEvent(CatchEvent):
    """
    The BPMN intermediateCatchEvent element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["IntermediateCatchEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:IntermediateCatchEvent"
    class_name: ClassVar[str] = "IntermediateCatchEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.IntermediateCatchEvent

    id: Union[str, IntermediateCatchEventId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, IntermediateCatchEventId):
            self.id = IntermediateCatchEventId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class IoBinding(BaseElement):
    """
    The BPMN ioBinding element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["IoBinding"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:IoBinding"
    class_name: ClassVar[str] = "IoBinding"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.IoBinding

    id: Union[str, IoBindingId] = None
    operation: Optional[Union[str, OperationId]] = None
    input_data: Optional[Union[str, DataInputId]] = None
    output_data: Optional[Union[str, DataOutputId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, IoBindingId):
            self.id = IoBindingId(self.id)

        if self.operation is not None and not isinstance(self.operation, OperationId):
            self.operation = OperationId(self.operation)

        if self.input_data is not None and not isinstance(self.input_data, DataInputId):
            self.input_data = DataInputId(self.input_data)

        if self.output_data is not None and not isinstance(self.output_data, DataOutputId):
            self.output_data = DataOutputId(self.output_data)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class IoSpecification(BaseElement):
    """
    The BPMN inputOutputSpecification element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["IoSpecification"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:IoSpecification"
    class_name: ClassVar[str] = "IoSpecification"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.IoSpecification

    id: Union[str, IoSpecificationId] = None
    data_inputs: Optional[Union[dict[Union[str, DataInputId], Union[dict, "DataInput"]], list[Union[dict, "DataInput"]]]] = empty_dict()
    data_outputs: Optional[Union[dict[Union[str, DataOutputId], Union[dict, "DataOutput"]], list[Union[dict, "DataOutput"]]]] = empty_dict()
    input_sets: Optional[Union[dict[Union[str, InputSetId], Union[dict, InputSet]], list[Union[dict, InputSet]]]] = empty_dict()
    output_sets: Optional[Union[dict[Union[str, OutputSetId], Union[dict, "OutputSet"]], list[Union[dict, "OutputSet"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, IoSpecificationId):
            self.id = IoSpecificationId(self.id)

        self._normalize_inlined_as_list(slot_name="data_inputs", slot_type=DataInput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="data_outputs", slot_type=DataOutput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="input_sets", slot_type=InputSet, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="output_sets", slot_type=OutputSet, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ItemAwareElement(BaseElement):
    """
    The BPMN itemAwareElement element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ItemAwareElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ItemAwareElement"
    class_name: ClassVar[str] = "ItemAwareElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ItemAwareElement

    id: Union[str, ItemAwareElementId] = None
    item_subject: Optional[Union[str, ItemDefinitionId]] = None
    data_state: Optional[Union[str, DataStateId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ItemAwareElementId):
            self.id = ItemAwareElementId(self.id)

        if self.item_subject is not None and not isinstance(self.item_subject, ItemDefinitionId):
            self.item_subject = ItemDefinitionId(self.item_subject)

        if self.data_state is not None and not isinstance(self.data_state, DataStateId):
            self.data_state = DataStateId(self.data_state)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataInput(ItemAwareElement):
    """
    The BPMN dataInput element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataInput"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataInput"
    class_name: ClassVar[str] = "DataInput"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataInput

    id: Union[str, DataInputId] = None
    name: Optional[str] = None
    collection: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataInputId):
            self.id = DataInputId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.collection is not None and not isinstance(self.collection, Bool):
            self.collection = Bool(self.collection)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataOutput(ItemAwareElement):
    """
    The BPMN dataOutput element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataOutput"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataOutput"
    class_name: ClassVar[str] = "DataOutput"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataOutput

    id: Union[str, DataOutputId] = None
    name: Optional[str] = None
    collection: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataOutputId):
            self.id = DataOutputId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.collection is not None and not isinstance(self.collection, Bool):
            self.collection = Bool(self.collection)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class InputDataItem(DataInput):
    """
    The BPMN 2.0 inputDataItem from the tMultiInstanceLoopCharacteristics type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["InputDataItem"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:InputDataItem"
    class_name: ClassVar[str] = "InputDataItem"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.InputDataItem

    id: Union[str, InputDataItemId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, InputDataItemId):
            self.id = InputDataItemId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Lane(BaseElement):
    """
    The BPMN lane element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Lane"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Lane"
    class_name: ClassVar[str] = "Lane"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Lane

    id: Union[str, LaneId] = None
    name: Optional[str] = None
    partition_element: Optional[str] = None
    partition_element_child: Optional[str] = None
    flow_node_refs: Optional[Union[dict[Union[str, FlowNodeId], Union[dict, FlowNode]], list[Union[dict, FlowNode]]]] = empty_dict()
    child_lane_set: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, LaneId):
            self.id = LaneId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.partition_element is not None and not isinstance(self.partition_element, str):
            self.partition_element = str(self.partition_element)

        if self.partition_element_child is not None and not isinstance(self.partition_element_child, str):
            self.partition_element_child = str(self.partition_element_child)

        self._normalize_inlined_as_list(slot_name="flow_node_refs", slot_type=FlowNode, key_name="id", keyed=True)

        if self.child_lane_set is not None and not isinstance(self.child_lane_set, str):
            self.child_lane_set = str(self.child_lane_set)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class LaneSet(BaseElement):
    """
    The BPMN laneSet element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["LaneSet"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:LaneSet"
    class_name: ClassVar[str] = "LaneSet"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.LaneSet

    id: Union[str, LaneSetId] = None
    name: Optional[str] = None
    lanes: Optional[Union[dict[Union[str, LaneId], Union[dict, Lane]], list[Union[dict, Lane]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, LaneSetId):
            self.id = LaneSetId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        self._normalize_inlined_as_list(slot_name="lanes", slot_type=Lane, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class LoopCardinality(Expression):
    """
    The loopCardinality element from the tMultiInstanceLoopCharacteristics complex type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["LoopCardinality"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:LoopCardinality"
    class_name: ClassVar[str] = "LoopCardinality"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.LoopCardinality

    id: Union[str, LoopCardinalityId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, LoopCardinalityId):
            self.id = LoopCardinalityId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class LoopCharacteristics(BaseElement):
    """
    The BPMN loopCharacteristics element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["LoopCharacteristics"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:LoopCharacteristics"
    class_name: ClassVar[str] = "LoopCharacteristics"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.LoopCharacteristics

    id: Union[str, LoopCharacteristicsId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, LoopCharacteristicsId):
            self.id = LoopCharacteristicsId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class MessageFlow(BaseElement):
    """
    The BPMN messageFlow element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["MessageFlow"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:MessageFlow"
    class_name: ClassVar[str] = "MessageFlow"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.MessageFlow

    id: Union[str, MessageFlowId] = None
    name: Optional[str] = None
    source: Optional[Union[str, InteractionNodeId]] = None
    target: Optional[Union[str, InteractionNodeId]] = None
    message: Optional[Union[str, MessageId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, MessageFlowId):
            self.id = MessageFlowId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.source is not None and not isinstance(self.source, InteractionNodeId):
            self.source = InteractionNodeId(self.source)

        if self.target is not None and not isinstance(self.target, InteractionNodeId):
            self.target = InteractionNodeId(self.target)

        if self.message is not None and not isinstance(self.message, MessageId):
            self.message = MessageId(self.message)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class MessageFlowAssociation(BaseElement):
    """
    The BPMN messageFlowAssociation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["MessageFlowAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:MessageFlowAssociation"
    class_name: ClassVar[str] = "MessageFlowAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.MessageFlowAssociation

    id: Union[str, MessageFlowAssociationId] = None
    inner_message_flow: Optional[Union[str, MessageFlowId]] = None
    outer_message_flow: Optional[Union[str, MessageFlowId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, MessageFlowAssociationId):
            self.id = MessageFlowAssociationId(self.id)

        if self.inner_message_flow is not None and not isinstance(self.inner_message_flow, MessageFlowId):
            self.inner_message_flow = MessageFlowId(self.inner_message_flow)

        if self.outer_message_flow is not None and not isinstance(self.outer_message_flow, MessageFlowId):
            self.outer_message_flow = MessageFlowId(self.outer_message_flow)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Monitoring(BaseElement):
    """
    The BPMN monitoring element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Monitoring"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Monitoring"
    class_name: ClassVar[str] = "Monitoring"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Monitoring

    id: Union[str, MonitoringId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, MonitoringId):
            self.id = MonitoringId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class MultiInstanceLoopCharacteristics(LoopCharacteristics):
    """
    The BPMN 2.0 multiInstanceLoopCharacteristics element type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["MultiInstanceLoopCharacteristics"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:MultiInstanceLoopCharacteristics"
    class_name: ClassVar[str] = "MultiInstanceLoopCharacteristics"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.MultiInstanceLoopCharacteristics

    id: Union[str, MultiInstanceLoopCharacteristicsId] = None
    loop_cardinality: Optional[Union[str, LoopCardinalityId]] = None
    loop_data_input_ref: Optional[Union[str, DataInputId]] = None
    loop_data_output_ref: Optional[Union[str, DataOutputId]] = None
    input_data_item: Optional[Union[str, InputDataItemId]] = None
    output_data_item: Optional[Union[str, OutputDataItemId]] = None
    complex_behavior_definitions: Optional[Union[dict[Union[str, ComplexBehaviorDefinitionId], Union[dict, ComplexBehaviorDefinition]], list[Union[dict, ComplexBehaviorDefinition]]]] = empty_dict()
    completion_condition: Optional[Union[str, CompletionConditionId]] = None
    sequential: Optional[Union[bool, Bool]] = None
    behavior: Optional[str] = None
    one_behavior_event_ref: Optional[Union[str, EventDefinitionId]] = None
    none_behavior_event_ref: Optional[Union[str, EventDefinitionId]] = None
    fluxnova_collection: Optional[str] = None
    fluxnova_element_variable: Optional[str] = None
    fluxnova_async_before: Optional[Union[bool, Bool]] = None
    fluxnova_async_after: Optional[Union[bool, Bool]] = None
    fluxnova_exclusive: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, MultiInstanceLoopCharacteristicsId):
            self.id = MultiInstanceLoopCharacteristicsId(self.id)

        if self.loop_cardinality is not None and not isinstance(self.loop_cardinality, LoopCardinalityId):
            self.loop_cardinality = LoopCardinalityId(self.loop_cardinality)

        if self.loop_data_input_ref is not None and not isinstance(self.loop_data_input_ref, DataInputId):
            self.loop_data_input_ref = DataInputId(self.loop_data_input_ref)

        if self.loop_data_output_ref is not None and not isinstance(self.loop_data_output_ref, DataOutputId):
            self.loop_data_output_ref = DataOutputId(self.loop_data_output_ref)

        if self.input_data_item is not None and not isinstance(self.input_data_item, InputDataItemId):
            self.input_data_item = InputDataItemId(self.input_data_item)

        if self.output_data_item is not None and not isinstance(self.output_data_item, OutputDataItemId):
            self.output_data_item = OutputDataItemId(self.output_data_item)

        self._normalize_inlined_as_list(slot_name="complex_behavior_definitions", slot_type=ComplexBehaviorDefinition, key_name="id", keyed=True)

        if self.completion_condition is not None and not isinstance(self.completion_condition, CompletionConditionId):
            self.completion_condition = CompletionConditionId(self.completion_condition)

        if self.sequential is not None and not isinstance(self.sequential, Bool):
            self.sequential = Bool(self.sequential)

        if self.behavior is not None and not isinstance(self.behavior, str):
            self.behavior = str(self.behavior)

        if self.one_behavior_event_ref is not None and not isinstance(self.one_behavior_event_ref, EventDefinitionId):
            self.one_behavior_event_ref = EventDefinitionId(self.one_behavior_event_ref)

        if self.none_behavior_event_ref is not None and not isinstance(self.none_behavior_event_ref, EventDefinitionId):
            self.none_behavior_event_ref = EventDefinitionId(self.none_behavior_event_ref)

        if self.fluxnova_collection is not None and not isinstance(self.fluxnova_collection, str):
            self.fluxnova_collection = str(self.fluxnova_collection)

        if self.fluxnova_element_variable is not None and not isinstance(self.fluxnova_element_variable, str):
            self.fluxnova_element_variable = str(self.fluxnova_element_variable)

        if self.fluxnova_async_before is not None and not isinstance(self.fluxnova_async_before, Bool):
            self.fluxnova_async_before = Bool(self.fluxnova_async_before)

        if self.fluxnova_async_after is not None and not isinstance(self.fluxnova_async_after, Bool):
            self.fluxnova_async_after = Bool(self.fluxnova_async_after)

        if self.fluxnova_exclusive is not None and not isinstance(self.fluxnova_exclusive, Bool):
            self.fluxnova_exclusive = Bool(self.fluxnova_exclusive)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Operation(BaseElement):
    """
    The BPMN operation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Operation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Operation"
    class_name: ClassVar[str] = "Operation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Operation

    id: Union[str, OperationId] = None
    name: Optional[str] = None
    implementation_ref: Optional[str] = None
    in_message: Optional[Union[str, MessageId]] = None
    out_message: Optional[Union[str, MessageId]] = None
    errors: Optional[Union[dict[Union[str, ErrorId], Union[dict, "Error"]], list[Union[dict, "Error"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, OperationId):
            self.id = OperationId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.implementation_ref is not None and not isinstance(self.implementation_ref, str):
            self.implementation_ref = str(self.implementation_ref)

        if self.in_message is not None and not isinstance(self.in_message, MessageId):
            self.in_message = MessageId(self.in_message)

        if self.out_message is not None and not isinstance(self.out_message, MessageId):
            self.out_message = MessageId(self.out_message)

        self._normalize_inlined_as_list(slot_name="errors", slot_type=Error, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class OutputDataItem(DataOutput):
    """
    The BPMN 2.0 outputDataItem from the tMultiInstanceLoopCharacteristics type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["OutputDataItem"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:OutputDataItem"
    class_name: ClassVar[str] = "OutputDataItem"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.OutputDataItem

    id: Union[str, OutputDataItemId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, OutputDataItemId):
            self.id = OutputDataItemId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class OutputSet(BaseElement):
    """
    The BPMN outputSet element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["OutputSet"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:OutputSet"
    class_name: ClassVar[str] = "OutputSet"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.OutputSet

    id: Union[str, OutputSetId] = None
    name: Optional[str] = None
    data_output_refs: Optional[Union[dict[Union[str, DataOutputId], Union[dict, DataOutput]], list[Union[dict, DataOutput]]]] = empty_dict()
    optional_output_refs: Optional[Union[dict[Union[str, DataOutputId], Union[dict, DataOutput]], list[Union[dict, DataOutput]]]] = empty_dict()
    while_executing_output_refs: Optional[Union[dict[Union[str, DataOutputId], Union[dict, DataOutput]], list[Union[dict, DataOutput]]]] = empty_dict()
    input_set_refs: Optional[Union[dict[Union[str, InputSetId], Union[dict, InputSet]], list[Union[dict, InputSet]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, OutputSetId):
            self.id = OutputSetId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        self._normalize_inlined_as_list(slot_name="data_output_refs", slot_type=DataOutput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="optional_output_refs", slot_type=DataOutput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="while_executing_output_refs", slot_type=DataOutput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="input_set_refs", slot_type=InputSet, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ParallelGateway(Gateway):
    """
    The BPMN parallelGateway element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ParallelGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ParallelGateway"
    class_name: ClassVar[str] = "ParallelGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ParallelGateway

    id: Union[str, ParallelGatewayId] = None
    fluxnova_async: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ParallelGatewayId):
            self.id = ParallelGatewayId(self.id)

        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Participant(BaseElement):
    """
    The BPMN participant element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Participant"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Participant"
    class_name: ClassVar[str] = "Participant"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Participant

    id: Union[str, ParticipantId] = None
    name: Optional[str] = None
    process: Optional[Union[str, ProcessId]] = None
    interfaces: Optional[Union[dict[Union[str, InterfaceId], Union[dict, "Interface"]], list[Union[dict, "Interface"]]]] = empty_dict()
    end_points: Optional[Union[dict[Union[str, EndPointId], Union[dict, "EndPoint"]], list[Union[dict, "EndPoint"]]]] = empty_dict()
    participant_multiplicity: Optional[Union[str, ParticipantMultiplicityId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ParticipantId):
            self.id = ParticipantId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.process is not None and not isinstance(self.process, ProcessId):
            self.process = ProcessId(self.process)

        self._normalize_inlined_as_list(slot_name="interfaces", slot_type=Interface, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="end_points", slot_type=EndPoint, key_name="id", keyed=True)

        if self.participant_multiplicity is not None and not isinstance(self.participant_multiplicity, ParticipantMultiplicityId):
            self.participant_multiplicity = ParticipantMultiplicityId(self.participant_multiplicity)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ParticipantAssociation(BaseElement):
    """
    The BPMN participantAssociation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ParticipantAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ParticipantAssociation"
    class_name: ClassVar[str] = "ParticipantAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ParticipantAssociation

    id: Union[str, ParticipantAssociationId] = None
    inner_participant: Optional[Union[str, ParticipantId]] = None
    outer_participant: Optional[Union[str, ParticipantId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ParticipantAssociationId):
            self.id = ParticipantAssociationId(self.id)

        if self.inner_participant is not None and not isinstance(self.inner_participant, ParticipantId):
            self.inner_participant = ParticipantId(self.inner_participant)

        if self.outer_participant is not None and not isinstance(self.outer_participant, ParticipantId):
            self.outer_participant = ParticipantId(self.outer_participant)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ParticipantMultiplicity(BaseElement):
    """
    The BPMN participantMultiplicity element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ParticipantMultiplicity"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ParticipantMultiplicity"
    class_name: ClassVar[str] = "ParticipantMultiplicity"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ParticipantMultiplicity

    id: Union[str, ParticipantMultiplicityId] = None
    minimum: Optional[int] = None
    maximum: Optional[int] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ParticipantMultiplicityId):
            self.id = ParticipantMultiplicityId(self.id)

        if self.minimum is not None and not isinstance(self.minimum, int):
            self.minimum = int(self.minimum)

        if self.maximum is not None and not isinstance(self.maximum, int):
            self.maximum = int(self.maximum)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnProperty(ItemAwareElement):
    """
    The BPMN property element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["BpmnProperty"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:BpmnProperty"
    class_name: ClassVar[str] = "BpmnProperty"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnProperty

    id: Union[str, BpmnPropertyId] = None
    name: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BpmnPropertyId):
            self.id = BpmnPropertyId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Relationship(BaseElement):
    """
    The BPMN relationship element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Relationship"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Relationship"
    class_name: ClassVar[str] = "Relationship"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Relationship

    id: Union[str, RelationshipId] = None
    type: Optional[str] = None
    direction: Optional[str] = None
    sources: Optional[Union[str, list[str]]] = empty_list()
    targets: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, RelationshipId):
            self.id = RelationshipId(self.id)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.direction is not None and not isinstance(self.direction, str):
            self.direction = str(self.direction)

        if not isinstance(self.sources, list):
            self.sources = [self.sources] if self.sources is not None else []
        self.sources = [v if isinstance(v, str) else str(v) for v in self.sources]

        if not isinstance(self.targets, list):
            self.targets = [self.targets] if self.targets is not None else []
        self.targets = [v if isinstance(v, str) else str(v) for v in self.targets]

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Rendering(BaseElement):
    """
    The BPMN rendering element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Rendering"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Rendering"
    class_name: ClassVar[str] = "Rendering"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Rendering

    id: Union[str, RenderingId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, RenderingId):
            self.id = RenderingId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ResourceAssignmentExpression(BaseElement):
    """
    The BPMN resourceAssignmentExpression element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ResourceAssignmentExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ResourceAssignmentExpression"
    class_name: ClassVar[str] = "ResourceAssignmentExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ResourceAssignmentExpression

    id: Union[str, ResourceAssignmentExpressionId] = None
    expression: Optional[Union[str, ExpressionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ResourceAssignmentExpressionId):
            self.id = ResourceAssignmentExpressionId(self.id)

        if self.expression is not None and not isinstance(self.expression, ExpressionId):
            self.expression = ExpressionId(self.expression)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ResourceParameter(BaseElement):
    """
    The BPMN resourceParameter element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ResourceParameter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ResourceParameter"
    class_name: ClassVar[str] = "ResourceParameter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ResourceParameter

    id: Union[str, ResourceParameterId] = None
    name: Optional[str] = None
    type: Optional[Union[str, ItemDefinitionId]] = None
    required: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ResourceParameterId):
            self.id = ResourceParameterId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.type is not None and not isinstance(self.type, ItemDefinitionId):
            self.type = ItemDefinitionId(self.type)

        if self.required is not None and not isinstance(self.required, Bool):
            self.required = Bool(self.required)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ResourceParameterBinding(BaseElement):
    """
    The BPMN resourceParameterBinding element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ResourceParameterBinding"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ResourceParameterBinding"
    class_name: ClassVar[str] = "ResourceParameterBinding"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ResourceParameterBinding

    id: Union[str, ResourceParameterBindingId] = None
    parameter: Optional[Union[str, ResourceParameterId]] = None
    expression: Optional[Union[str, ExpressionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ResourceParameterBindingId):
            self.id = ResourceParameterBindingId(self.id)

        if self.parameter is not None and not isinstance(self.parameter, ResourceParameterId):
            self.parameter = ResourceParameterId(self.parameter)

        if self.expression is not None and not isinstance(self.expression, ExpressionId):
            self.expression = ExpressionId(self.expression)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ResourceRole(BaseElement):
    """
    The BPMN resourceRole element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ResourceRole"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ResourceRole"
    class_name: ClassVar[str] = "ResourceRole"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ResourceRole

    id: Union[str, ResourceRoleId] = None
    name: Optional[str] = None
    resource: Optional[Union[str, ResourceId]] = None
    resource_parameter_binding: Optional[Union[dict[Union[str, ResourceParameterBindingId], Union[dict, ResourceParameterBinding]], list[Union[dict, ResourceParameterBinding]]]] = empty_dict()
    resource_assignment_expression: Optional[Union[str, ResourceAssignmentExpressionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ResourceRoleId):
            self.id = ResourceRoleId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.resource is not None and not isinstance(self.resource, ResourceId):
            self.resource = ResourceId(self.resource)

        self._normalize_inlined_as_list(slot_name="resource_parameter_binding", slot_type=ResourceParameterBinding, key_name="id", keyed=True)

        if self.resource_assignment_expression is not None and not isinstance(self.resource_assignment_expression, ResourceAssignmentExpressionId):
            self.resource_assignment_expression = ResourceAssignmentExpressionId(self.resource_assignment_expression)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Performer(ResourceRole):
    """
    The BPMN performer element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Performer"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Performer"
    class_name: ClassVar[str] = "Performer"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Performer

    id: Union[str, PerformerId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, PerformerId):
            self.id = PerformerId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class HumanPerformer(Performer):
    """
    The BPMN humanPerformer element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["HumanPerformer"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:HumanPerformer"
    class_name: ClassVar[str] = "HumanPerformer"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.HumanPerformer

    id: Union[str, HumanPerformerId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, HumanPerformerId):
            self.id = HumanPerformerId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class PotentialOwner(HumanPerformer):
    """
    The BPMN potentialOwner element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["PotentialOwner"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:PotentialOwner"
    class_name: ClassVar[str] = "PotentialOwner"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.PotentialOwner

    id: Union[str, PotentialOwnerId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, PotentialOwnerId):
            self.id = PotentialOwnerId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class RootElement(BaseElement):
    """
    The BPMN rootElement element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["RootElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:RootElement"
    class_name: ClassVar[str] = "RootElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.RootElement

    id: Union[str, RootElementId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, RootElementId):
            self.id = RootElementId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CallableElement(RootElement):
    """
    The BPMN callableElement element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CallableElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CallableElement"
    class_name: ClassVar[str] = "CallableElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CallableElement

    id: Union[str, CallableElementId] = None
    name: Optional[str] = None
    supported_interfaces: Optional[Union[dict[Union[str, InterfaceId], Union[dict, "Interface"]], list[Union[dict, "Interface"]]]] = empty_dict()
    io_specification: Optional[Union[str, IoSpecificationId]] = None
    io_bindings: Optional[Union[dict[Union[str, IoBindingId], Union[dict, IoBinding]], list[Union[dict, IoBinding]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CallableElementId):
            self.id = CallableElementId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        self._normalize_inlined_as_list(slot_name="supported_interfaces", slot_type=Interface, key_name="id", keyed=True)

        if self.io_specification is not None and not isinstance(self.io_specification, IoSpecificationId):
            self.io_specification = IoSpecificationId(self.io_specification)

        self._normalize_inlined_as_list(slot_name="io_bindings", slot_type=IoBinding, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Category(RootElement):
    """
    A named grouping used to categorise BPMN elements via CategoryValue references.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Category"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Category"
    class_name: ClassVar[str] = "Category"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Category

    id: Union[str, CategoryId] = None
    name: Optional[str] = None
    category_values: Optional[Union[dict[Union[str, CategoryValueId], Union[dict, CategoryValue]], list[Union[dict, CategoryValue]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CategoryId):
            self.id = CategoryId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        self._normalize_inlined_as_list(slot_name="category_values", slot_type=CategoryValue, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Collaboration(RootElement):
    """
    The BPMN collaboration element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Collaboration"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Collaboration"
    class_name: ClassVar[str] = "Collaboration"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Collaboration

    id: Union[str, CollaborationId] = None
    name: Optional[str] = None
    closed: Optional[Union[bool, Bool]] = None
    participants: Optional[Union[dict[Union[str, ParticipantId], Union[dict, Participant]], list[Union[dict, Participant]]]] = empty_dict()
    message_flows: Optional[Union[dict[Union[str, MessageFlowId], Union[dict, MessageFlow]], list[Union[dict, MessageFlow]]]] = empty_dict()
    artifacts: Optional[Union[dict[Union[str, ArtifactId], Union[dict, Artifact]], list[Union[dict, Artifact]]]] = empty_dict()
    conversation_nodes: Optional[Union[dict[Union[str, ConversationNodeId], Union[dict, ConversationNode]], list[Union[dict, ConversationNode]]]] = empty_dict()
    conversation_associations: Optional[Union[dict[Union[str, ConversationAssociationId], Union[dict, ConversationAssociation]], list[Union[dict, ConversationAssociation]]]] = empty_dict()
    participant_associations: Optional[Union[dict[Union[str, ParticipantAssociationId], Union[dict, ParticipantAssociation]], list[Union[dict, ParticipantAssociation]]]] = empty_dict()
    message_flow_associations: Optional[Union[dict[Union[str, MessageFlowAssociationId], Union[dict, MessageFlowAssociation]], list[Union[dict, MessageFlowAssociation]]]] = empty_dict()
    correlation_keys: Optional[Union[dict[Union[str, CorrelationKeyId], Union[dict, CorrelationKey]], list[Union[dict, CorrelationKey]]]] = empty_dict()
    conversation_links: Optional[Union[dict[Union[str, ConversationLinkId], Union[dict, ConversationLink]], list[Union[dict, ConversationLink]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CollaborationId):
            self.id = CollaborationId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.closed is not None and not isinstance(self.closed, Bool):
            self.closed = Bool(self.closed)

        self._normalize_inlined_as_list(slot_name="participants", slot_type=Participant, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="message_flows", slot_type=MessageFlow, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="artifacts", slot_type=Artifact, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="conversation_nodes", slot_type=ConversationNode, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="conversation_associations", slot_type=ConversationAssociation, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="participant_associations", slot_type=ParticipantAssociation, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="message_flow_associations", slot_type=MessageFlowAssociation, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="correlation_keys", slot_type=CorrelationKey, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="conversation_links", slot_type=ConversationLink, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CorrelationProperty(RootElement):
    """
    The BPMN correlationProperty element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CorrelationProperty"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CorrelationProperty"
    class_name: ClassVar[str] = "CorrelationProperty"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CorrelationProperty

    id: Union[str, CorrelationPropertyId] = None
    name: Optional[str] = None
    type: Optional[Union[str, ItemDefinitionId]] = None
    correlation_property_retrieval_expressions: Optional[Union[dict[Union[str, CorrelationPropertyRetrievalExpressionId], Union[dict, CorrelationPropertyRetrievalExpression]], list[Union[dict, CorrelationPropertyRetrievalExpression]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CorrelationPropertyId):
            self.id = CorrelationPropertyId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.type is not None and not isinstance(self.type, ItemDefinitionId):
            self.type = ItemDefinitionId(self.type)

        self._normalize_inlined_as_list(slot_name="correlation_property_retrieval_expressions", slot_type=CorrelationPropertyRetrievalExpression, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class DataStore(RootElement):
    """
    The BPMN dataStore element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["DataStore"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:DataStore"
    class_name: ClassVar[str] = "DataStore"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DataStore

    id: Union[str, DataStoreId] = None
    scope: Optional[Union[bool, Bool]] = None
    documentations: Optional[Union[dict[Union[str, DocumentationId], Union[dict, Documentation]], list[Union[dict, Documentation]]]] = empty_dict()
    extension_elements: Optional[Union[dict, ExtensionElements]] = None
    diagram_element: Optional[Union[str, DiagramElementId]] = None
    name: Optional[str] = None
    capacity: Optional[int] = None
    unlimited: Optional[Union[bool, Bool]] = None
    item_subject: Optional[Union[str, ItemDefinitionId]] = None
    data_state: Optional[Union[str, DataStateId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, DataStoreId):
            self.id = DataStoreId(self.id)

        if self.scope is not None and not isinstance(self.scope, Bool):
            self.scope = Bool(self.scope)

        self._normalize_inlined_as_list(slot_name="documentations", slot_type=Documentation, key_name="id", keyed=True)

        if self.extension_elements is not None and not isinstance(self.extension_elements, ExtensionElements):
            self.extension_elements = ExtensionElements(**as_dict(self.extension_elements))

        if self.diagram_element is not None and not isinstance(self.diagram_element, DiagramElementId):
            self.diagram_element = DiagramElementId(self.diagram_element)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.capacity is not None and not isinstance(self.capacity, int):
            self.capacity = int(self.capacity)

        if self.unlimited is not None and not isinstance(self.unlimited, Bool):
            self.unlimited = Bool(self.unlimited)

        if self.item_subject is not None and not isinstance(self.item_subject, ItemDefinitionId):
            self.item_subject = ItemDefinitionId(self.item_subject)

        if self.data_state is not None and not isinstance(self.data_state, DataStateId):
            self.data_state = DataStateId(self.data_state)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class EndPoint(RootElement):
    """
    The BPMN endPoint element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["EndPoint"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:EndPoint"
    class_name: ClassVar[str] = "EndPoint"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.EndPoint

    id: Union[str, EndPointId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, EndPointId):
            self.id = EndPointId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Error(RootElement):
    """
    The BPMN error element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Error"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Error"
    class_name: ClassVar[str] = "Error"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Error

    id: Union[str, ErrorId] = None
    name: Optional[str] = None
    error_code: Optional[str] = None
    fluxnova_error_message: Optional[str] = None
    structure: Optional[Union[str, ItemDefinitionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ErrorId):
            self.id = ErrorId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.error_code is not None and not isinstance(self.error_code, str):
            self.error_code = str(self.error_code)

        if self.fluxnova_error_message is not None and not isinstance(self.fluxnova_error_message, str):
            self.fluxnova_error_message = str(self.fluxnova_error_message)

        if self.structure is not None and not isinstance(self.structure, ItemDefinitionId):
            self.structure = ItemDefinitionId(self.structure)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Escalation(RootElement):
    """
    The BPMN escalation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Escalation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Escalation"
    class_name: ClassVar[str] = "Escalation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Escalation

    id: Union[str, EscalationId] = None
    name: Optional[str] = None
    escalation_code: Optional[str] = None
    structure: Optional[Union[str, ItemDefinitionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, EscalationId):
            self.id = EscalationId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.escalation_code is not None and not isinstance(self.escalation_code, str):
            self.escalation_code = str(self.escalation_code)

        if self.structure is not None and not isinstance(self.structure, ItemDefinitionId):
            self.structure = ItemDefinitionId(self.structure)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class EventDefinition(RootElement):
    """
    The BPMN eventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["EventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:EventDefinition"
    class_name: ClassVar[str] = "EventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.EventDefinition

    id: Union[str, EventDefinitionId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, EventDefinitionId):
            self.id = EventDefinitionId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CancelEventDefinition(EventDefinition):
    """
    The BPMN cancelEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CancelEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CancelEventDefinition"
    class_name: ClassVar[str] = "CancelEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CancelEventDefinition

    id: Union[str, CancelEventDefinitionId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CancelEventDefinitionId):
            self.id = CancelEventDefinitionId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class CompensateEventDefinition(EventDefinition):
    """
    The BPMN compensateEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["CompensateEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:CompensateEventDefinition"
    class_name: ClassVar[str] = "CompensateEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.CompensateEventDefinition

    id: Union[str, CompensateEventDefinitionId] = None
    wait_for_completion: Optional[Union[bool, Bool]] = None
    activity: Optional[Union[str, ActivityId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, CompensateEventDefinitionId):
            self.id = CompensateEventDefinitionId(self.id)

        if self.wait_for_completion is not None and not isinstance(self.wait_for_completion, Bool):
            self.wait_for_completion = Bool(self.wait_for_completion)

        if self.activity is not None and not isinstance(self.activity, ActivityId):
            self.activity = ActivityId(self.activity)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ConditionalEventDefinition(EventDefinition):
    """
    The BPMN conditionalEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ConditionalEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ConditionalEventDefinition"
    class_name: ClassVar[str] = "ConditionalEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ConditionalEventDefinition

    id: Union[str, ConditionalEventDefinitionId] = None
    condition: Optional[Union[str, ConditionId]] = None
    fluxnova_variable_name: Optional[str] = None
    fluxnova_variable_events: Optional[str] = None
    fluxnova_variable_events_list: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ConditionalEventDefinitionId):
            self.id = ConditionalEventDefinitionId(self.id)

        if self.condition is not None and not isinstance(self.condition, ConditionId):
            self.condition = ConditionId(self.condition)

        if self.fluxnova_variable_name is not None and not isinstance(self.fluxnova_variable_name, str):
            self.fluxnova_variable_name = str(self.fluxnova_variable_name)

        if self.fluxnova_variable_events is not None and not isinstance(self.fluxnova_variable_events, str):
            self.fluxnova_variable_events = str(self.fluxnova_variable_events)

        if not isinstance(self.fluxnova_variable_events_list, list):
            self.fluxnova_variable_events_list = [self.fluxnova_variable_events_list] if self.fluxnova_variable_events_list is not None else []
        self.fluxnova_variable_events_list = [v if isinstance(v, str) else str(v) for v in self.fluxnova_variable_events_list]

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ErrorEventDefinition(EventDefinition):
    """
    The BPMN errorEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ErrorEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ErrorEventDefinition"
    class_name: ClassVar[str] = "ErrorEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ErrorEventDefinition

    id: Union[str, ErrorEventDefinitionId] = None
    error: Optional[Union[str, ErrorId]] = None
    fluxnova_error_code_variable: Optional[str] = None
    fluxnova_error_message_variable: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ErrorEventDefinitionId):
            self.id = ErrorEventDefinitionId(self.id)

        if self.error is not None and not isinstance(self.error, ErrorId):
            self.error = ErrorId(self.error)

        if self.fluxnova_error_code_variable is not None and not isinstance(self.fluxnova_error_code_variable, str):
            self.fluxnova_error_code_variable = str(self.fluxnova_error_code_variable)

        if self.fluxnova_error_message_variable is not None and not isinstance(self.fluxnova_error_message_variable, str):
            self.fluxnova_error_message_variable = str(self.fluxnova_error_message_variable)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class EscalationEventDefinition(EventDefinition):
    """
    The BPMN escalationEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["EscalationEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:EscalationEventDefinition"
    class_name: ClassVar[str] = "EscalationEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.EscalationEventDefinition

    id: Union[str, EscalationEventDefinitionId] = None
    escalation: Optional[Union[str, EscalationId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, EscalationEventDefinitionId):
            self.id = EscalationEventDefinitionId(self.id)

        if self.escalation is not None and not isinstance(self.escalation, EscalationId):
            self.escalation = EscalationId(self.escalation)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class GlobalConversation(Collaboration):
    """
    The BPMN globalConversation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["GlobalConversation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:GlobalConversation"
    class_name: ClassVar[str] = "GlobalConversation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.GlobalConversation

    id: Union[str, GlobalConversationId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, GlobalConversationId):
            self.id = GlobalConversationId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Interface(RootElement):
    """
    The BPMN interface element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Interface"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Interface"
    class_name: ClassVar[str] = "Interface"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Interface

    id: Union[str, InterfaceId] = None
    name: Optional[str] = None
    implementation_ref: Optional[str] = None
    operations: Optional[Union[dict[Union[str, OperationId], Union[dict, Operation]], list[Union[dict, Operation]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, InterfaceId):
            self.id = InterfaceId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.implementation_ref is not None and not isinstance(self.implementation_ref, str):
            self.implementation_ref = str(self.implementation_ref)

        self._normalize_inlined_as_list(slot_name="operations", slot_type=Operation, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ItemDefinition(RootElement):
    """
    The BPMN itemDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ItemDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ItemDefinition"
    class_name: ClassVar[str] = "ItemDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ItemDefinition

    id: Union[str, ItemDefinitionId] = None
    structure_ref: Optional[str] = None
    collection: Optional[Union[bool, Bool]] = None
    item_kind: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ItemDefinitionId):
            self.id = ItemDefinitionId(self.id)

        if self.structure_ref is not None and not isinstance(self.structure_ref, str):
            self.structure_ref = str(self.structure_ref)

        if self.collection is not None and not isinstance(self.collection, Bool):
            self.collection = Bool(self.collection)

        if self.item_kind is not None and not isinstance(self.item_kind, str):
            self.item_kind = str(self.item_kind)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class LinkEventDefinition(EventDefinition):
    """
    The BPMN linkEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["LinkEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:LinkEventDefinition"
    class_name: ClassVar[str] = "LinkEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.LinkEventDefinition

    id: Union[str, LinkEventDefinitionId] = None
    name: Optional[str] = None
    sources: Optional[Union[dict[Union[str, LinkEventDefinitionId], Union[dict, "LinkEventDefinition"]], list[Union[dict, "LinkEventDefinition"]]]] = empty_dict()
    target: Optional[Union[str, LinkEventDefinitionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, LinkEventDefinitionId):
            self.id = LinkEventDefinitionId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        self._normalize_inlined_as_list(slot_name="sources", slot_type=LinkEventDefinition, key_name="id", keyed=True)

        if self.target is not None and not isinstance(self.target, LinkEventDefinitionId):
            self.target = LinkEventDefinitionId(self.target)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Message(RootElement):
    """
    The BPMN message element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Message"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Message"
    class_name: ClassVar[str] = "Message"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Message

    id: Union[str, MessageId] = None
    name: Optional[str] = None
    item: Optional[Union[str, ItemDefinitionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, MessageId):
            self.id = MessageId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.item is not None and not isinstance(self.item, ItemDefinitionId):
            self.item = ItemDefinitionId(self.item)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class MessageEventDefinition(EventDefinition):
    """
    The BPMN messageEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["MessageEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:MessageEventDefinition"
    class_name: ClassVar[str] = "MessageEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.MessageEventDefinition

    id: Union[str, MessageEventDefinitionId] = None
    message: Optional[Union[str, MessageId]] = None
    operation: Optional[Union[str, OperationId]] = None
    fluxnova_class: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_topic: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, MessageEventDefinitionId):
            self.id = MessageEventDefinitionId(self.id)

        if self.message is not None and not isinstance(self.message, MessageId):
            self.message = MessageId(self.message)

        if self.operation is not None and not isinstance(self.operation, OperationId):
            self.operation = OperationId(self.operation)

        if self.fluxnova_class is not None and not isinstance(self.fluxnova_class, str):
            self.fluxnova_class = str(self.fluxnova_class)

        if self.fluxnova_delegate_expression is not None and not isinstance(self.fluxnova_delegate_expression, str):
            self.fluxnova_delegate_expression = str(self.fluxnova_delegate_expression)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_result_variable is not None and not isinstance(self.fluxnova_result_variable, str):
            self.fluxnova_result_variable = str(self.fluxnova_result_variable)

        if self.fluxnova_topic is not None and not isinstance(self.fluxnova_topic, str):
            self.fluxnova_topic = str(self.fluxnova_topic)

        if self.fluxnova_type is not None and not isinstance(self.fluxnova_type, str):
            self.fluxnova_type = str(self.fluxnova_type)

        if self.fluxnova_task_priority is not None and not isinstance(self.fluxnova_task_priority, str):
            self.fluxnova_task_priority = str(self.fluxnova_task_priority)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Process(CallableElement):
    """
    The BPMN process element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Process"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Process"
    class_name: ClassVar[str] = "Process"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Process

    id: Union[str, ProcessId] = None
    process_type: Optional[str] = None
    closed: Optional[Union[bool, Bool]] = None
    executable: Optional[Union[bool, Bool]] = None
    auditing: Optional[Union[str, AuditingId]] = None
    monitoring: Optional[Union[str, MonitoringId]] = None
    properties: Optional[Union[dict[Union[str, BpmnPropertyId], Union[dict, BpmnProperty]], list[Union[dict, BpmnProperty]]]] = empty_dict()
    lane_sets: Optional[Union[dict[Union[str, LaneSetId], Union[dict, LaneSet]], list[Union[dict, LaneSet]]]] = empty_dict()
    flow_elements: Optional[Union[dict[Union[str, FlowElementId], Union[dict, FlowElement]], list[Union[dict, FlowElement]]]] = empty_dict()
    artifacts: Optional[Union[dict[Union[str, ArtifactId], Union[dict, Artifact]], list[Union[dict, Artifact]]]] = empty_dict()
    correlation_subscriptions: Optional[Union[dict[Union[str, CorrelationSubscriptionId], Union[dict, CorrelationSubscription]], list[Union[dict, CorrelationSubscription]]]] = empty_dict()
    resource_roles: Optional[Union[dict[Union[str, ResourceRoleId], Union[dict, ResourceRole]], list[Union[dict, ResourceRole]]]] = empty_dict()
    supports: Optional[Union[dict[Union[str, ProcessId], Union[dict, "Process"]], list[Union[dict, "Process"]]]] = empty_dict()
    fluxnova_candidate_starter_groups: Optional[str] = None
    fluxnova_candidate_starter_groups_list: Optional[Union[str, list[str]]] = empty_list()
    fluxnova_candidate_starter_users: Optional[str] = None
    fluxnova_candidate_starter_users_list: Optional[Union[str, list[str]]] = empty_list()
    fluxnova_job_priority: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None
    fluxnova_history_time_to_live: Optional[int] = None
    fluxnova_history_time_to_live_string: Optional[str] = None
    fluxnova_startable_in_tasklist: Optional[Union[bool, Bool]] = None
    fluxnova_version_tag: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ProcessId):
            self.id = ProcessId(self.id)

        if self.process_type is not None and not isinstance(self.process_type, str):
            self.process_type = str(self.process_type)

        if self.closed is not None and not isinstance(self.closed, Bool):
            self.closed = Bool(self.closed)

        if self.executable is not None and not isinstance(self.executable, Bool):
            self.executable = Bool(self.executable)

        if self.auditing is not None and not isinstance(self.auditing, AuditingId):
            self.auditing = AuditingId(self.auditing)

        if self.monitoring is not None and not isinstance(self.monitoring, MonitoringId):
            self.monitoring = MonitoringId(self.monitoring)

        self._normalize_inlined_as_list(slot_name="properties", slot_type=BpmnProperty, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="lane_sets", slot_type=LaneSet, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="flow_elements", slot_type=FlowElement, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="artifacts", slot_type=Artifact, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="correlation_subscriptions", slot_type=CorrelationSubscription, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="resource_roles", slot_type=ResourceRole, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="supports", slot_type=Process, key_name="id", keyed=True)

        if self.fluxnova_candidate_starter_groups is not None and not isinstance(self.fluxnova_candidate_starter_groups, str):
            self.fluxnova_candidate_starter_groups = str(self.fluxnova_candidate_starter_groups)

        if not isinstance(self.fluxnova_candidate_starter_groups_list, list):
            self.fluxnova_candidate_starter_groups_list = [self.fluxnova_candidate_starter_groups_list] if self.fluxnova_candidate_starter_groups_list is not None else []
        self.fluxnova_candidate_starter_groups_list = [v if isinstance(v, str) else str(v) for v in self.fluxnova_candidate_starter_groups_list]

        if self.fluxnova_candidate_starter_users is not None and not isinstance(self.fluxnova_candidate_starter_users, str):
            self.fluxnova_candidate_starter_users = str(self.fluxnova_candidate_starter_users)

        if not isinstance(self.fluxnova_candidate_starter_users_list, list):
            self.fluxnova_candidate_starter_users_list = [self.fluxnova_candidate_starter_users_list] if self.fluxnova_candidate_starter_users_list is not None else []
        self.fluxnova_candidate_starter_users_list = [v if isinstance(v, str) else str(v) for v in self.fluxnova_candidate_starter_users_list]

        if self.fluxnova_job_priority is not None and not isinstance(self.fluxnova_job_priority, str):
            self.fluxnova_job_priority = str(self.fluxnova_job_priority)

        if self.fluxnova_task_priority is not None and not isinstance(self.fluxnova_task_priority, str):
            self.fluxnova_task_priority = str(self.fluxnova_task_priority)

        if self.fluxnova_history_time_to_live is not None and not isinstance(self.fluxnova_history_time_to_live, int):
            self.fluxnova_history_time_to_live = int(self.fluxnova_history_time_to_live)

        if self.fluxnova_history_time_to_live_string is not None and not isinstance(self.fluxnova_history_time_to_live_string, str):
            self.fluxnova_history_time_to_live_string = str(self.fluxnova_history_time_to_live_string)

        if self.fluxnova_startable_in_tasklist is not None and not isinstance(self.fluxnova_startable_in_tasklist, Bool):
            self.fluxnova_startable_in_tasklist = Bool(self.fluxnova_startable_in_tasklist)

        if self.fluxnova_version_tag is not None and not isinstance(self.fluxnova_version_tag, str):
            self.fluxnova_version_tag = str(self.fluxnova_version_tag)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Resource(RootElement):
    """
    The BPMN resource element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Resource"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Resource"
    class_name: ClassVar[str] = "Resource"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Resource

    id: Union[str, ResourceId] = None
    name: Optional[str] = None
    resource_parameters: Optional[Union[dict[Union[str, ResourceParameterId], Union[dict, ResourceParameter]], list[Union[dict, ResourceParameter]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ResourceId):
            self.id = ResourceId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        self._normalize_inlined_as_list(slot_name="resource_parameters", slot_type=ResourceParameter, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


class Script(BpmnModelElementInstance):
    """
    The BPMN script element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Script"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Script"
    class_name: ClassVar[str] = "Script"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Script


@dataclass(repr=False)
class SequenceFlow(FlowElement):
    """
    The BPMN sequenceFlow element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["SequenceFlow"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:SequenceFlow"
    class_name: ClassVar[str] = "SequenceFlow"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.SequenceFlow

    id: Union[str, SequenceFlowId] = None
    source: Optional[Union[str, FlowNodeId]] = None
    target: Optional[Union[str, FlowNodeId]] = None
    immediate: Optional[Union[bool, Bool]] = None
    condition_expression: Optional[Union[str, ConditionExpressionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, SequenceFlowId):
            self.id = SequenceFlowId(self.id)

        if self.source is not None and not isinstance(self.source, FlowNodeId):
            self.source = FlowNodeId(self.source)

        if self.target is not None and not isinstance(self.target, FlowNodeId):
            self.target = FlowNodeId(self.target)

        if self.immediate is not None and not isinstance(self.immediate, Bool):
            self.immediate = Bool(self.immediate)

        if self.condition_expression is not None and not isinstance(self.condition_expression, ConditionExpressionId):
            self.condition_expression = ConditionExpressionId(self.condition_expression)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Signal(RootElement):
    """
    The BPMN signal element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Signal"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Signal"
    class_name: ClassVar[str] = "Signal"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Signal

    id: Union[str, SignalId] = None
    name: Optional[str] = None
    structure: Optional[Union[str, ItemDefinitionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, SignalId):
            self.id = SignalId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.structure is not None and not isinstance(self.structure, ItemDefinitionId):
            self.structure = ItemDefinitionId(self.structure)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class SignalEventDefinition(EventDefinition):
    """
    The BPMN signalEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["SignalEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:SignalEventDefinition"
    class_name: ClassVar[str] = "SignalEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.SignalEventDefinition

    id: Union[str, SignalEventDefinitionId] = None
    signal: Optional[Union[str, SignalId]] = None
    fluxnova_async: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, SignalEventDefinitionId):
            self.id = SignalEventDefinitionId(self.id)

        if self.signal is not None and not isinstance(self.signal, SignalId):
            self.signal = SignalId(self.signal)

        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class StartEvent(CatchEvent):
    """
    The BPMN startEvent element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["StartEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:StartEvent"
    class_name: ClassVar[str] = "StartEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.StartEvent

    id: Union[str, StartEventId] = None
    interrupting: Optional[Union[bool, Bool]] = None
    fluxnova_async: Optional[Union[bool, Bool]] = None
    fluxnova_form_handler_class: Optional[str] = None
    fluxnova_form_key: Optional[str] = None
    fluxnova_form_ref: Optional[str] = None
    fluxnova_form_ref_binding: Optional[str] = None
    fluxnova_form_ref_version: Optional[str] = None
    fluxnova_initiator: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, StartEventId):
            self.id = StartEventId(self.id)

        if self.interrupting is not None and not isinstance(self.interrupting, Bool):
            self.interrupting = Bool(self.interrupting)

        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        if self.fluxnova_form_handler_class is not None and not isinstance(self.fluxnova_form_handler_class, str):
            self.fluxnova_form_handler_class = str(self.fluxnova_form_handler_class)

        if self.fluxnova_form_key is not None and not isinstance(self.fluxnova_form_key, str):
            self.fluxnova_form_key = str(self.fluxnova_form_key)

        if self.fluxnova_form_ref is not None and not isinstance(self.fluxnova_form_ref, str):
            self.fluxnova_form_ref = str(self.fluxnova_form_ref)

        if self.fluxnova_form_ref_binding is not None and not isinstance(self.fluxnova_form_ref_binding, str):
            self.fluxnova_form_ref_binding = str(self.fluxnova_form_ref_binding)

        if self.fluxnova_form_ref_version is not None and not isinstance(self.fluxnova_form_ref_version, str):
            self.fluxnova_form_ref_version = str(self.fluxnova_form_ref_version)

        if self.fluxnova_initiator is not None and not isinstance(self.fluxnova_initiator, str):
            self.fluxnova_initiator = str(self.fluxnova_initiator)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class SubConversation(ConversationNode):
    """
    The BPMN subConversation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["SubConversation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:SubConversation"
    class_name: ClassVar[str] = "SubConversation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.SubConversation

    id: Union[str, SubConversationId] = None
    conversation_nodes: Optional[Union[dict[Union[str, ConversationNodeId], Union[dict, ConversationNode]], list[Union[dict, ConversationNode]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, SubConversationId):
            self.id = SubConversationId(self.id)

        self._normalize_inlined_as_list(slot_name="conversation_nodes", slot_type=ConversationNode, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class SubProcess(Activity):
    """
    The BPMN subProcess element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["SubProcess"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:SubProcess"
    class_name: ClassVar[str] = "SubProcess"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.SubProcess

    id: Union[str, SubProcessId] = None
    lane_sets: Optional[Union[dict[Union[str, LaneSetId], Union[dict, LaneSet]], list[Union[dict, LaneSet]]]] = empty_dict()
    flow_elements: Optional[Union[dict[Union[str, FlowElementId], Union[dict, FlowElement]], list[Union[dict, FlowElement]]]] = empty_dict()
    artifacts: Optional[Union[dict[Union[str, ArtifactId], Union[dict, Artifact]], list[Union[dict, Artifact]]]] = empty_dict()
    fluxnova_async: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, SubProcessId):
            self.id = SubProcessId(self.id)

        self._normalize_inlined_as_list(slot_name="lane_sets", slot_type=LaneSet, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="flow_elements", slot_type=FlowElement, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="artifacts", slot_type=Artifact, key_name="id", keyed=True)

        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnTask(Activity):
    """
    The BPMN task element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["BpmnTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:BpmnTask"
    class_name: ClassVar[str] = "BpmnTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTask

    id: Union[str, BpmnTaskId] = None
    fluxnova_async: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BpmnTaskId):
            self.id = BpmnTaskId(self.id)

        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BusinessRuleTask(BpmnTask):
    """
    The BPMN businessRuleTask element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["BusinessRuleTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:BusinessRuleTask"
    class_name: ClassVar[str] = "BusinessRuleTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BusinessRuleTask

    id: Union[str, BusinessRuleTaskId] = None
    implementation: Optional[str] = None
    fluxnova_class: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_topic: Optional[str] = None
    fluxnova_decision_ref: Optional[str] = None
    fluxnova_decision_ref_binding: Optional[str] = None
    fluxnova_decision_ref_version: Optional[str] = None
    fluxnova_decision_ref_version_tag: Optional[str] = None
    fluxnova_decision_ref_tenant_id: Optional[str] = None
    fluxnova_map_decision_result: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BusinessRuleTaskId):
            self.id = BusinessRuleTaskId(self.id)

        if self.implementation is not None and not isinstance(self.implementation, str):
            self.implementation = str(self.implementation)

        if self.fluxnova_class is not None and not isinstance(self.fluxnova_class, str):
            self.fluxnova_class = str(self.fluxnova_class)

        if self.fluxnova_delegate_expression is not None and not isinstance(self.fluxnova_delegate_expression, str):
            self.fluxnova_delegate_expression = str(self.fluxnova_delegate_expression)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_result_variable is not None and not isinstance(self.fluxnova_result_variable, str):
            self.fluxnova_result_variable = str(self.fluxnova_result_variable)

        if self.fluxnova_type is not None and not isinstance(self.fluxnova_type, str):
            self.fluxnova_type = str(self.fluxnova_type)

        if self.fluxnova_topic is not None and not isinstance(self.fluxnova_topic, str):
            self.fluxnova_topic = str(self.fluxnova_topic)

        if self.fluxnova_decision_ref is not None and not isinstance(self.fluxnova_decision_ref, str):
            self.fluxnova_decision_ref = str(self.fluxnova_decision_ref)

        if self.fluxnova_decision_ref_binding is not None and not isinstance(self.fluxnova_decision_ref_binding, str):
            self.fluxnova_decision_ref_binding = str(self.fluxnova_decision_ref_binding)

        if self.fluxnova_decision_ref_version is not None and not isinstance(self.fluxnova_decision_ref_version, str):
            self.fluxnova_decision_ref_version = str(self.fluxnova_decision_ref_version)

        if self.fluxnova_decision_ref_version_tag is not None and not isinstance(self.fluxnova_decision_ref_version_tag, str):
            self.fluxnova_decision_ref_version_tag = str(self.fluxnova_decision_ref_version_tag)

        if self.fluxnova_decision_ref_tenant_id is not None and not isinstance(self.fluxnova_decision_ref_tenant_id, str):
            self.fluxnova_decision_ref_tenant_id = str(self.fluxnova_decision_ref_tenant_id)

        if self.fluxnova_map_decision_result is not None and not isinstance(self.fluxnova_map_decision_result, str):
            self.fluxnova_map_decision_result = str(self.fluxnova_map_decision_result)

        if self.fluxnova_task_priority is not None and not isinstance(self.fluxnova_task_priority, str):
            self.fluxnova_task_priority = str(self.fluxnova_task_priority)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ManualTask(BpmnTask):
    """
    The BPMN manualTask element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ManualTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ManualTask"
    class_name: ClassVar[str] = "ManualTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ManualTask

    id: Union[str, ManualTaskId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ManualTaskId):
            self.id = ManualTaskId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ReceiveTask(BpmnTask):
    """
    The BPMN receiveTask element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ReceiveTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ReceiveTask"
    class_name: ClassVar[str] = "ReceiveTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ReceiveTask

    id: Union[str, ReceiveTaskId] = None
    implementation: Optional[str] = None
    message: Optional[Union[str, MessageId]] = None
    operation: Optional[Union[str, OperationId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ReceiveTaskId):
            self.id = ReceiveTaskId(self.id)

        if self.implementation is not None and not isinstance(self.implementation, str):
            self.implementation = str(self.implementation)

        if self.message is not None and not isinstance(self.message, MessageId):
            self.message = MessageId(self.message)

        if self.operation is not None and not isinstance(self.operation, OperationId):
            self.operation = OperationId(self.operation)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ScriptTask(BpmnTask):
    """
    The BPMN scriptTask element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ScriptTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ScriptTask"
    class_name: ClassVar[str] = "ScriptTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ScriptTask

    id: Union[str, ScriptTaskId] = None
    script_format: Optional[str] = None
    script: Optional[Union[dict, Script]] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_resource: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ScriptTaskId):
            self.id = ScriptTaskId(self.id)

        if self.script_format is not None and not isinstance(self.script_format, str):
            self.script_format = str(self.script_format)

        if self.script is not None and not isinstance(self.script, Script):
            self.script = Script(**as_dict(self.script))

        if self.fluxnova_result_variable is not None and not isinstance(self.fluxnova_result_variable, str):
            self.fluxnova_result_variable = str(self.fluxnova_result_variable)

        if self.fluxnova_resource is not None and not isinstance(self.fluxnova_resource, str):
            self.fluxnova_resource = str(self.fluxnova_resource)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class SendTask(BpmnTask):
    """
    The BPMN sendTask element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["SendTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:SendTask"
    class_name: ClassVar[str] = "SendTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.SendTask

    id: Union[str, SendTaskId] = None
    implementation: Optional[str] = None
    message: Optional[Union[str, MessageId]] = None
    operation: Optional[Union[str, OperationId]] = None
    fluxnova_class: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_topic: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, SendTaskId):
            self.id = SendTaskId(self.id)

        if self.implementation is not None and not isinstance(self.implementation, str):
            self.implementation = str(self.implementation)

        if self.message is not None and not isinstance(self.message, MessageId):
            self.message = MessageId(self.message)

        if self.operation is not None and not isinstance(self.operation, OperationId):
            self.operation = OperationId(self.operation)

        if self.fluxnova_class is not None and not isinstance(self.fluxnova_class, str):
            self.fluxnova_class = str(self.fluxnova_class)

        if self.fluxnova_delegate_expression is not None and not isinstance(self.fluxnova_delegate_expression, str):
            self.fluxnova_delegate_expression = str(self.fluxnova_delegate_expression)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_result_variable is not None and not isinstance(self.fluxnova_result_variable, str):
            self.fluxnova_result_variable = str(self.fluxnova_result_variable)

        if self.fluxnova_type is not None and not isinstance(self.fluxnova_type, str):
            self.fluxnova_type = str(self.fluxnova_type)

        if self.fluxnova_topic is not None and not isinstance(self.fluxnova_topic, str):
            self.fluxnova_topic = str(self.fluxnova_topic)

        if self.fluxnova_task_priority is not None and not isinstance(self.fluxnova_task_priority, str):
            self.fluxnova_task_priority = str(self.fluxnova_task_priority)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ServiceTask(BpmnTask):
    """
    The BPMN serviceTask element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ServiceTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ServiceTask"
    class_name: ClassVar[str] = "ServiceTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ServiceTask

    id: Union[str, ServiceTaskId] = None
    implementation: Optional[str] = None
    operation: Optional[Union[str, OperationId]] = None
    fluxnova_class: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_topic: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ServiceTaskId):
            self.id = ServiceTaskId(self.id)

        if self.implementation is not None and not isinstance(self.implementation, str):
            self.implementation = str(self.implementation)

        if self.operation is not None and not isinstance(self.operation, OperationId):
            self.operation = OperationId(self.operation)

        if self.fluxnova_class is not None and not isinstance(self.fluxnova_class, str):
            self.fluxnova_class = str(self.fluxnova_class)

        if self.fluxnova_delegate_expression is not None and not isinstance(self.fluxnova_delegate_expression, str):
            self.fluxnova_delegate_expression = str(self.fluxnova_delegate_expression)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_result_variable is not None and not isinstance(self.fluxnova_result_variable, str):
            self.fluxnova_result_variable = str(self.fluxnova_result_variable)

        if self.fluxnova_type is not None and not isinstance(self.fluxnova_type, str):
            self.fluxnova_type = str(self.fluxnova_type)

        if self.fluxnova_topic is not None and not isinstance(self.fluxnova_topic, str):
            self.fluxnova_topic = str(self.fluxnova_topic)

        if self.fluxnova_task_priority is not None and not isinstance(self.fluxnova_task_priority, str):
            self.fluxnova_task_priority = str(self.fluxnova_task_priority)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class TerminateEventDefinition(EventDefinition):
    """
    The BPMN terminateEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["TerminateEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:TerminateEventDefinition"
    class_name: ClassVar[str] = "TerminateEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.TerminateEventDefinition

    id: Union[str, TerminateEventDefinitionId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TerminateEventDefinitionId):
            self.id = TerminateEventDefinitionId(self.id)

        super().__post_init__(**kwargs)


class Text(BpmnModelElementInstance):
    """
    The BPMN 2.0 text element from the tTextAnnotation complex type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Text"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Text"
    class_name: ClassVar[str] = "Text"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Text


@dataclass(repr=False)
class TextAnnotation(Artifact):
    """
    The BPMN 2.0 textAnnotation element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["TextAnnotation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:TextAnnotation"
    class_name: ClassVar[str] = "TextAnnotation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.TextAnnotation

    id: Union[str, TextAnnotationId] = None
    text_format: Optional[str] = None
    text: Optional[Union[dict, Text]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TextAnnotationId):
            self.id = TextAnnotationId(self.id)

        if self.text_format is not None and not isinstance(self.text_format, str):
            self.text_format = str(self.text_format)

        if self.text is not None and not isinstance(self.text, Text):
            self.text = Text(**as_dict(self.text))

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class ThrowEvent(Event):
    """
    The BPMN throwEvent element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["ThrowEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:ThrowEvent"
    class_name: ClassVar[str] = "ThrowEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.ThrowEvent

    id: Union[str, ThrowEventId] = None
    data_inputs: Optional[Union[dict[Union[str, DataInputId], Union[dict, DataInput]], list[Union[dict, DataInput]]]] = empty_dict()
    data_input_associations: Optional[Union[dict[Union[str, DataInputAssociationId], Union[dict, DataInputAssociation]], list[Union[dict, DataInputAssociation]]]] = empty_dict()
    input_set: Optional[Union[str, InputSetId]] = None
    event_definitions: Optional[Union[dict[Union[str, EventDefinitionId], Union[dict, EventDefinition]], list[Union[dict, EventDefinition]]]] = empty_dict()
    event_definition_refs: Optional[Union[dict[Union[str, EventDefinitionId], Union[dict, EventDefinition]], list[Union[dict, EventDefinition]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, ThrowEventId):
            self.id = ThrowEventId(self.id)

        self._normalize_inlined_as_list(slot_name="data_inputs", slot_type=DataInput, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="data_input_associations", slot_type=DataInputAssociation, key_name="id", keyed=True)

        if self.input_set is not None and not isinstance(self.input_set, InputSetId):
            self.input_set = InputSetId(self.input_set)

        self._normalize_inlined_as_list(slot_name="event_definitions", slot_type=EventDefinition, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="event_definition_refs", slot_type=EventDefinition, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class EndEvent(ThrowEvent):
    """
    The BPMN endEvent element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["EndEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:EndEvent"
    class_name: ClassVar[str] = "EndEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.EndEvent

    id: Union[str, EndEventId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, EndEventId):
            self.id = EndEventId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class IntermediateThrowEvent(ThrowEvent):
    """
    The BPMN intermediateThrowEvent element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["IntermediateThrowEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:IntermediateThrowEvent"
    class_name: ClassVar[str] = "IntermediateThrowEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.IntermediateThrowEvent

    id: Union[str, IntermediateThrowEventId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, IntermediateThrowEventId):
            self.id = IntermediateThrowEventId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class TimeCycle(Expression):
    """
    The BPMN timeCycle element of the BPMN tTimerEventDefinition type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["TimeCycle"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:TimeCycle"
    class_name: ClassVar[str] = "TimeCycle"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.TimeCycle

    id: Union[str, TimeCycleId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TimeCycleId):
            self.id = TimeCycleId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class TimeDate(Expression):
    """
    The BPMN timeDate element of the BPMN tTimerEventDefinition type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["TimeDate"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:TimeDate"
    class_name: ClassVar[str] = "TimeDate"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.TimeDate

    id: Union[str, TimeDateId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TimeDateId):
            self.id = TimeDateId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class TimeDuration(Expression):
    """
    The BPMN timeDuration element of the BPMN tTimerEventDefinition type
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["TimeDuration"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:TimeDuration"
    class_name: ClassVar[str] = "TimeDuration"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.TimeDuration

    id: Union[str, TimeDurationId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TimeDurationId):
            self.id = TimeDurationId(self.id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class TimerEventDefinition(EventDefinition):
    """
    The BPMN timerEventDefinition element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["TimerEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:TimerEventDefinition"
    class_name: ClassVar[str] = "TimerEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.TimerEventDefinition

    id: Union[str, TimerEventDefinitionId] = None
    time_date: Optional[Union[str, TimeDateId]] = None
    time_duration: Optional[Union[str, TimeDurationId]] = None
    time_cycle: Optional[Union[str, TimeCycleId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TimerEventDefinitionId):
            self.id = TimerEventDefinitionId(self.id)

        if self.time_date is not None and not isinstance(self.time_date, TimeDateId):
            self.time_date = TimeDateId(self.time_date)

        if self.time_duration is not None and not isinstance(self.time_duration, TimeDurationId):
            self.time_duration = TimeDurationId(self.time_duration)

        if self.time_cycle is not None and not isinstance(self.time_cycle, TimeCycleId):
            self.time_cycle = TimeCycleId(self.time_cycle)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class Transaction(SubProcess):
    """
    A sub-process that executes as an atomic unit with compensation support.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["Transaction"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:Transaction"
    class_name: ClassVar[str] = "Transaction"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.Transaction

    id: Union[str, TransactionId] = None
    method: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, TransactionId):
            self.id = TransactionId(self.id)

        if self.method is not None and not isinstance(self.method, str):
            self.method = str(self.method)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class UserTask(BpmnTask):
    """
    The BPMN userTask element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_INSTANCE["UserTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_instance:UserTask"
    class_name: ClassVar[str] = "UserTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.UserTask

    id: Union[str, UserTaskId] = None
    implementation: Optional[str] = None
    renderings: Optional[Union[dict[Union[str, RenderingId], Union[dict, Rendering]], list[Union[dict, Rendering]]]] = empty_dict()
    fluxnova_assignee: Optional[str] = None
    fluxnova_candidate_groups: Optional[str] = None
    fluxnova_candidate_groups_list: Optional[Union[str, list[str]]] = empty_list()
    fluxnova_candidate_users: Optional[str] = None
    fluxnova_candidate_users_list: Optional[Union[str, list[str]]] = empty_list()
    fluxnova_due_date: Optional[str] = None
    fluxnova_follow_up_date: Optional[str] = None
    fluxnova_form_handler_class: Optional[str] = None
    fluxnova_form_key: Optional[str] = None
    fluxnova_form_ref: Optional[str] = None
    fluxnova_form_ref_binding: Optional[str] = None
    fluxnova_form_ref_version: Optional[str] = None
    fluxnova_priority: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, UserTaskId):
            self.id = UserTaskId(self.id)

        if self.implementation is not None and not isinstance(self.implementation, str):
            self.implementation = str(self.implementation)

        self._normalize_inlined_as_list(slot_name="renderings", slot_type=Rendering, key_name="id", keyed=True)

        if self.fluxnova_assignee is not None and not isinstance(self.fluxnova_assignee, str):
            self.fluxnova_assignee = str(self.fluxnova_assignee)

        if self.fluxnova_candidate_groups is not None and not isinstance(self.fluxnova_candidate_groups, str):
            self.fluxnova_candidate_groups = str(self.fluxnova_candidate_groups)

        if not isinstance(self.fluxnova_candidate_groups_list, list):
            self.fluxnova_candidate_groups_list = [self.fluxnova_candidate_groups_list] if self.fluxnova_candidate_groups_list is not None else []
        self.fluxnova_candidate_groups_list = [v if isinstance(v, str) else str(v) for v in self.fluxnova_candidate_groups_list]

        if self.fluxnova_candidate_users is not None and not isinstance(self.fluxnova_candidate_users, str):
            self.fluxnova_candidate_users = str(self.fluxnova_candidate_users)

        if not isinstance(self.fluxnova_candidate_users_list, list):
            self.fluxnova_candidate_users_list = [self.fluxnova_candidate_users_list] if self.fluxnova_candidate_users_list is not None else []
        self.fluxnova_candidate_users_list = [v if isinstance(v, str) else str(v) for v in self.fluxnova_candidate_users_list]

        if self.fluxnova_due_date is not None and not isinstance(self.fluxnova_due_date, str):
            self.fluxnova_due_date = str(self.fluxnova_due_date)

        if self.fluxnova_follow_up_date is not None and not isinstance(self.fluxnova_follow_up_date, str):
            self.fluxnova_follow_up_date = str(self.fluxnova_follow_up_date)

        if self.fluxnova_form_handler_class is not None and not isinstance(self.fluxnova_form_handler_class, str):
            self.fluxnova_form_handler_class = str(self.fluxnova_form_handler_class)

        if self.fluxnova_form_key is not None and not isinstance(self.fluxnova_form_key, str):
            self.fluxnova_form_key = str(self.fluxnova_form_key)

        if self.fluxnova_form_ref is not None and not isinstance(self.fluxnova_form_ref, str):
            self.fluxnova_form_ref = str(self.fluxnova_form_ref)

        if self.fluxnova_form_ref_binding is not None and not isinstance(self.fluxnova_form_ref_binding, str):
            self.fluxnova_form_ref_binding = str(self.fluxnova_form_ref_binding)

        if self.fluxnova_form_ref_version is not None and not isinstance(self.fluxnova_form_ref_version, str):
            self.fluxnova_form_ref_version = str(self.fluxnova_form_ref_version)

        if self.fluxnova_priority is not None and not isinstance(self.fluxnova_priority, str):
            self.fluxnova_priority = str(self.fluxnova_priority)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnDiagram(Diagram):
    """
    The BPMNDI BPMNDiagram element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_BPMNDI["BpmnDiagram"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_bpmndi:BpmnDiagram"
    class_name: ClassVar[str] = "BpmnDiagram"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDiagram

    id: Union[str, BpmnDiagramId] = None
    bpmn_plane: Optional[Union[str, BpmnPlaneId]] = None
    bpmn_label_styles: Optional[Union[dict[Union[str, BpmnLabelStyleId], Union[dict, "BpmnLabelStyle"]], list[Union[dict, "BpmnLabelStyle"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BpmnDiagramId):
            self.id = BpmnDiagramId(self.id)

        if self.bpmn_plane is not None and not isinstance(self.bpmn_plane, BpmnPlaneId):
            self.bpmn_plane = BpmnPlaneId(self.bpmn_plane)

        self._normalize_inlined_as_list(slot_name="bpmn_label_styles", slot_type=BpmnLabelStyle, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnEdge(LabeledEdge):
    """
    The BPMNDI BPMNEdge element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_BPMNDI["BpmnEdge"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_bpmndi:BpmnEdge"
    class_name: ClassVar[str] = "BpmnEdge"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnEdge

    id: Union[str, BpmnEdgeId] = None
    bpmn_element: Optional[str] = None
    source_element: Optional[Union[str, DiagramElementId]] = None
    target_element: Optional[Union[str, DiagramElementId]] = None
    message_visible_kind: Optional[Union[str, "MessageVisibleKind"]] = None
    bpmn_label: Optional[Union[str, BpmnLabelId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BpmnEdgeId):
            self.id = BpmnEdgeId(self.id)

        if self.bpmn_element is not None and not isinstance(self.bpmn_element, str):
            self.bpmn_element = str(self.bpmn_element)

        if self.source_element is not None and not isinstance(self.source_element, DiagramElementId):
            self.source_element = DiagramElementId(self.source_element)

        if self.target_element is not None and not isinstance(self.target_element, DiagramElementId):
            self.target_element = DiagramElementId(self.target_element)

        if self.message_visible_kind is not None and not isinstance(self.message_visible_kind, MessageVisibleKind):
            self.message_visible_kind = MessageVisibleKind(self.message_visible_kind)

        if self.bpmn_label is not None and not isinstance(self.bpmn_label, BpmnLabelId):
            self.bpmn_label = BpmnLabelId(self.bpmn_label)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnLabel(Label):
    """
    The BPMNDI BPMNLabel element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_BPMNDI["BpmnLabel"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_bpmndi:BpmnLabel"
    class_name: ClassVar[str] = "BpmnLabel"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnLabel

    id: Union[str, BpmnLabelId] = None
    label_style: Optional[Union[str, BpmnLabelStyleId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BpmnLabelId):
            self.id = BpmnLabelId(self.id)

        if self.label_style is not None and not isinstance(self.label_style, BpmnLabelStyleId):
            self.label_style = BpmnLabelStyleId(self.label_style)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnLabelStyle(Style):
    """
    The BPMNDI BPMNLabelStyle element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_BPMNDI["BpmnLabelStyle"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_bpmndi:BpmnLabelStyle"
    class_name: ClassVar[str] = "BpmnLabelStyle"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnLabelStyle

    id: Union[str, BpmnLabelStyleId] = None
    font: Optional[Union[dict, Font]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BpmnLabelStyleId):
            self.id = BpmnLabelStyleId(self.id)

        if self.font is not None and not isinstance(self.font, Font):
            self.font = Font(**as_dict(self.font))

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnPlane(Plane):
    """
    The BPMNDI BPMNPlane element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_BPMNDI["BpmnPlane"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_bpmndi:BpmnPlane"
    class_name: ClassVar[str] = "BpmnPlane"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnPlane

    id: Union[str, BpmnPlaneId] = None
    bpmn_element: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BpmnPlaneId):
            self.id = BpmnPlaneId(self.id)

        if self.bpmn_element is not None and not isinstance(self.bpmn_element, str):
            self.bpmn_element = str(self.bpmn_element)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnShape(LabeledShape):
    """
    The BPMNDI BPMNShape element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_BPMNDI["BpmnShape"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_bpmndi:BpmnShape"
    class_name: ClassVar[str] = "BpmnShape"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnShape

    id: Union[str, BpmnShapeId] = None
    bpmn_element: Optional[str] = None
    horizontal: Optional[Union[bool, Bool]] = None
    expanded: Optional[Union[bool, Bool]] = None
    marker_visible: Optional[Union[bool, Bool]] = None
    message_visible: Optional[Union[bool, Bool]] = None
    participant_band_kind: Optional[Union[str, "ParticipantBandKind"]] = None
    choreography_activity_shape: Optional[Union[str, BpmnShapeId]] = None
    bpmn_label: Optional[Union[str, BpmnLabelId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, BpmnShapeId):
            self.id = BpmnShapeId(self.id)

        if self.bpmn_element is not None and not isinstance(self.bpmn_element, str):
            self.bpmn_element = str(self.bpmn_element)

        if self.horizontal is not None and not isinstance(self.horizontal, Bool):
            self.horizontal = Bool(self.horizontal)

        if self.expanded is not None and not isinstance(self.expanded, Bool):
            self.expanded = Bool(self.expanded)

        if self.marker_visible is not None and not isinstance(self.marker_visible, Bool):
            self.marker_visible = Bool(self.marker_visible)

        if self.message_visible is not None and not isinstance(self.message_visible, Bool):
            self.message_visible = Bool(self.message_visible)

        if self.participant_band_kind is not None and not isinstance(self.participant_band_kind, ParticipantBandKind):
            self.participant_band_kind = ParticipantBandKind(self.participant_band_kind)

        if self.choreography_activity_shape is not None and not isinstance(self.choreography_activity_shape, BpmnShapeId):
            self.choreography_activity_shape = BpmnShapeId(self.choreography_activity_shape)

        if self.bpmn_label is not None and not isinstance(self.bpmn_label, BpmnLabelId):
            self.bpmn_label = BpmnLabelId(self.bpmn_label)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaConnector(BpmnModelElementInstance):
    """
    The BPMN connector camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaConnector"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaConnector"
    class_name: ClassVar[str] = "FluxnovaConnector"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaConnector

    fluxnova_connector_id: Optional[Union[dict, "FluxnovaConnectorId"]] = None
    fluxnova_input_output: Optional[Union[dict, "FluxnovaInputOutput"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_connector_id is not None and not isinstance(self.fluxnova_connector_id, FluxnovaConnectorId):
            self.fluxnova_connector_id = FluxnovaConnectorId(**as_dict(self.fluxnova_connector_id))

        if self.fluxnova_input_output is not None and not isinstance(self.fluxnova_input_output, FluxnovaInputOutput):
            self.fluxnova_input_output = FluxnovaInputOutput(**as_dict(self.fluxnova_input_output))

        super().__post_init__(**kwargs)


class FluxnovaConnectorId(BpmnModelElementInstance):
    """
    The BPMN connectorId camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaConnectorId"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaConnectorId"
    class_name: ClassVar[str] = "FluxnovaConnectorId"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaConnectorId


@dataclass(repr=False)
class FluxnovaConstraint(BpmnModelElementInstance):
    """
    The BPMN constraint camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaConstraint"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaConstraint"
    class_name: ClassVar[str] = "FluxnovaConstraint"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaConstraint

    fluxnova_name: Optional[str] = None
    fluxnova_config: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_name is not None and not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.fluxnova_config is not None and not isinstance(self.fluxnova_config, str):
            self.fluxnova_config = str(self.fluxnova_config)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaEntry(BpmnModelElementInstance):
    """
    The BPMN camundaEntry camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaEntry"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaEntry"
    class_name: ClassVar[str] = "FluxnovaEntry"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaEntry

    fluxnova_key: Optional[str] = None
    value: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_key is not None and not isinstance(self.fluxnova_key, str):
            self.fluxnova_key = str(self.fluxnova_key)

        if self.value is not None and not isinstance(self.value, str):
            self.value = str(self.value)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaErrorEventDefinition(ErrorEventDefinition):
    """
    Fluxnova extension that augments an end event error definition with engine-specific variables.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaErrorEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaErrorEventDefinition"
    class_name: ClassVar[str] = "FluxnovaErrorEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaErrorEventDefinition

    id: Union[str, FluxnovaErrorEventDefinitionId] = None
    fluxnova_expression: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaErrorEventDefinitionId):
            self.id = FluxnovaErrorEventDefinitionId(self.id)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaExecutionListener(BpmnModelElementInstance):
    """
    The BPMN executionListener camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaExecutionListener"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaExecutionListener"
    class_name: ClassVar[str] = "FluxnovaExecutionListener"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaExecutionListener

    fluxnova_event: Optional[str] = None
    fluxnova_class: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_fields: Optional[Union[Union[dict, "FluxnovaField"], list[Union[dict, "FluxnovaField"]]]] = empty_list()
    fluxnova_script: Optional[Union[dict, "FluxnovaScript"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_event is not None and not isinstance(self.fluxnova_event, str):
            self.fluxnova_event = str(self.fluxnova_event)

        if self.fluxnova_class is not None and not isinstance(self.fluxnova_class, str):
            self.fluxnova_class = str(self.fluxnova_class)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_delegate_expression is not None and not isinstance(self.fluxnova_delegate_expression, str):
            self.fluxnova_delegate_expression = str(self.fluxnova_delegate_expression)

        if not isinstance(self.fluxnova_fields, list):
            self.fluxnova_fields = [self.fluxnova_fields] if self.fluxnova_fields is not None else []
        self.fluxnova_fields = [v if isinstance(v, FluxnovaField) else FluxnovaField(**as_dict(v)) for v in self.fluxnova_fields]

        if self.fluxnova_script is not None and not isinstance(self.fluxnova_script, FluxnovaScript):
            self.fluxnova_script = FluxnovaScript(**as_dict(self.fluxnova_script))

        super().__post_init__(**kwargs)


class FluxnovaExpression(BpmnModelElementInstance):
    """
    The BPMN expression camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaExpression"
    class_name: ClassVar[str] = "FluxnovaExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaExpression


class FluxnovaFailedJobRetryTimeCycle(BpmnModelElementInstance):
    """
    The BPMN failedJobRetryTimeCycle camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaFailedJobRetryTimeCycle"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaFailedJobRetryTimeCycle"
    class_name: ClassVar[str] = "FluxnovaFailedJobRetryTimeCycle"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFailedJobRetryTimeCycle


@dataclass(repr=False)
class FluxnovaField(BpmnModelElementInstance):
    """
    The BPMN field camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaField"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaField"
    class_name: ClassVar[str] = "FluxnovaField"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaField

    fluxnova_name: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_string_value: Optional[str] = None
    fluxnova_string: Optional[Union[dict, "FluxnovaString"]] = None
    fluxnova_expression_child: Optional[Union[dict, FluxnovaExpression]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_name is not None and not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_string_value is not None and not isinstance(self.fluxnova_string_value, str):
            self.fluxnova_string_value = str(self.fluxnova_string_value)

        if self.fluxnova_string is not None and not isinstance(self.fluxnova_string, FluxnovaString):
            self.fluxnova_string = FluxnovaString(**as_dict(self.fluxnova_string))

        if self.fluxnova_expression_child is not None and not isinstance(self.fluxnova_expression_child, FluxnovaExpression):
            self.fluxnova_expression_child = FluxnovaExpression(**as_dict(self.fluxnova_expression_child))

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaFormData(BpmnModelElementInstance):
    """
    The BPMN formData camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaFormData"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaFormData"
    class_name: ClassVar[str] = "FluxnovaFormData"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFormData

    fluxnova_form_fields: Optional[Union[Union[dict, "FluxnovaFormField"], list[Union[dict, "FluxnovaFormField"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.fluxnova_form_fields, list):
            self.fluxnova_form_fields = [self.fluxnova_form_fields] if self.fluxnova_form_fields is not None else []
        self.fluxnova_form_fields = [v if isinstance(v, FluxnovaFormField) else FluxnovaFormField(**as_dict(v)) for v in self.fluxnova_form_fields]

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaFormField(BpmnModelElementInstance):
    """
    The BPMN formField camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaFormField"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaFormField"
    class_name: ClassVar[str] = "FluxnovaFormField"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFormField

    fluxnova_id: Optional[str] = None
    fluxnova_label: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_date_pattern: Optional[str] = None
    fluxnova_default_value: Optional[str] = None
    fluxnova_properties: Optional[Union[dict, "FluxnovaProperties"]] = None
    fluxnova_validation: Optional[Union[dict, "FluxnovaValidation"]] = None
    fluxnova_values: Optional[Union[Union[dict, "FluxnovaValue"], list[Union[dict, "FluxnovaValue"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_id is not None and not isinstance(self.fluxnova_id, str):
            self.fluxnova_id = str(self.fluxnova_id)

        if self.fluxnova_label is not None and not isinstance(self.fluxnova_label, str):
            self.fluxnova_label = str(self.fluxnova_label)

        if self.fluxnova_type is not None and not isinstance(self.fluxnova_type, str):
            self.fluxnova_type = str(self.fluxnova_type)

        if self.fluxnova_date_pattern is not None and not isinstance(self.fluxnova_date_pattern, str):
            self.fluxnova_date_pattern = str(self.fluxnova_date_pattern)

        if self.fluxnova_default_value is not None and not isinstance(self.fluxnova_default_value, str):
            self.fluxnova_default_value = str(self.fluxnova_default_value)

        if self.fluxnova_properties is not None and not isinstance(self.fluxnova_properties, FluxnovaProperties):
            self.fluxnova_properties = FluxnovaProperties(**as_dict(self.fluxnova_properties))

        if self.fluxnova_validation is not None and not isinstance(self.fluxnova_validation, FluxnovaValidation):
            self.fluxnova_validation = FluxnovaValidation(**as_dict(self.fluxnova_validation))

        if not isinstance(self.fluxnova_values, list):
            self.fluxnova_values = [self.fluxnova_values] if self.fluxnova_values is not None else []
        self.fluxnova_values = [v if isinstance(v, FluxnovaValue) else FluxnovaValue(**as_dict(v)) for v in self.fluxnova_values]

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaFormProperty(BpmnModelElementInstance):
    """
    The BPMN formProperty camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaFormProperty"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaFormProperty"
    class_name: ClassVar[str] = "FluxnovaFormProperty"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFormProperty

    fluxnova_id: Optional[str] = None
    fluxnova_name: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_required: Optional[Union[bool, Bool]] = None
    fluxnova_readable: Optional[Union[bool, Bool]] = None
    fluxnova_writeable: Optional[Union[bool, Bool]] = None
    fluxnova_variable: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_date_pattern: Optional[str] = None
    fluxnova_default: Optional[str] = None
    fluxnova_values: Optional[Union[Union[dict, "FluxnovaValue"], list[Union[dict, "FluxnovaValue"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_id is not None and not isinstance(self.fluxnova_id, str):
            self.fluxnova_id = str(self.fluxnova_id)

        if self.fluxnova_name is not None and not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.fluxnova_type is not None and not isinstance(self.fluxnova_type, str):
            self.fluxnova_type = str(self.fluxnova_type)

        if self.fluxnova_required is not None and not isinstance(self.fluxnova_required, Bool):
            self.fluxnova_required = Bool(self.fluxnova_required)

        if self.fluxnova_readable is not None and not isinstance(self.fluxnova_readable, Bool):
            self.fluxnova_readable = Bool(self.fluxnova_readable)

        if self.fluxnova_writeable is not None and not isinstance(self.fluxnova_writeable, Bool):
            self.fluxnova_writeable = Bool(self.fluxnova_writeable)

        if self.fluxnova_variable is not None and not isinstance(self.fluxnova_variable, str):
            self.fluxnova_variable = str(self.fluxnova_variable)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_date_pattern is not None and not isinstance(self.fluxnova_date_pattern, str):
            self.fluxnova_date_pattern = str(self.fluxnova_date_pattern)

        if self.fluxnova_default is not None and not isinstance(self.fluxnova_default, str):
            self.fluxnova_default = str(self.fluxnova_default)

        if not isinstance(self.fluxnova_values, list):
            self.fluxnova_values = [self.fluxnova_values] if self.fluxnova_values is not None else []
        self.fluxnova_values = [v if isinstance(v, FluxnovaValue) else FluxnovaValue(**as_dict(v)) for v in self.fluxnova_values]

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaGenericValueElement(YAMLRoot):
    """
    A helper interface for camunda extension elements which hold a generic child element like camunda:inputParameter,
    camunda:outputParameter and camunda:entry.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaGenericValueElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaGenericValueElement"
    class_name: ClassVar[str] = "FluxnovaGenericValueElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaGenericValueElement

    value: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.value is not None and not isinstance(self.value, str):
            self.value = str(self.value)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaIn(BpmnModelElementInstance):
    """
    The BPMN in camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaIn"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaIn"
    class_name: ClassVar[str] = "FluxnovaIn"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaIn

    fluxnova_source: Optional[str] = None
    fluxnova_source_expression: Optional[str] = None
    fluxnova_variables: Optional[str] = None
    fluxnova_target: Optional[str] = None
    fluxnova_business_key: Optional[str] = None
    fluxnova_local: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_source is not None and not isinstance(self.fluxnova_source, str):
            self.fluxnova_source = str(self.fluxnova_source)

        if self.fluxnova_source_expression is not None and not isinstance(self.fluxnova_source_expression, str):
            self.fluxnova_source_expression = str(self.fluxnova_source_expression)

        if self.fluxnova_variables is not None and not isinstance(self.fluxnova_variables, str):
            self.fluxnova_variables = str(self.fluxnova_variables)

        if self.fluxnova_target is not None and not isinstance(self.fluxnova_target, str):
            self.fluxnova_target = str(self.fluxnova_target)

        if self.fluxnova_business_key is not None and not isinstance(self.fluxnova_business_key, str):
            self.fluxnova_business_key = str(self.fluxnova_business_key)

        if self.fluxnova_local is not None and not isinstance(self.fluxnova_local, Bool):
            self.fluxnova_local = Bool(self.fluxnova_local)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaInputOutput(BpmnModelElementInstance):
    """
    The BPMN inputOutput camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaInputOutput"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaInputOutput"
    class_name: ClassVar[str] = "FluxnovaInputOutput"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaInputOutput

    fluxnova_input_parameters: Optional[Union[Union[dict, "FluxnovaInputParameter"], list[Union[dict, "FluxnovaInputParameter"]]]] = empty_list()
    fluxnova_output_parameters: Optional[Union[Union[dict, "FluxnovaOutputParameter"], list[Union[dict, "FluxnovaOutputParameter"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.fluxnova_input_parameters, list):
            self.fluxnova_input_parameters = [self.fluxnova_input_parameters] if self.fluxnova_input_parameters is not None else []
        self.fluxnova_input_parameters = [v if isinstance(v, FluxnovaInputParameter) else FluxnovaInputParameter(**as_dict(v)) for v in self.fluxnova_input_parameters]

        if not isinstance(self.fluxnova_output_parameters, list):
            self.fluxnova_output_parameters = [self.fluxnova_output_parameters] if self.fluxnova_output_parameters is not None else []
        self.fluxnova_output_parameters = [v if isinstance(v, FluxnovaOutputParameter) else FluxnovaOutputParameter(**as_dict(v)) for v in self.fluxnova_output_parameters]

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaInputParameter(BpmnModelElementInstance):
    """
    The BPMN inputParameter camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaInputParameter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaInputParameter"
    class_name: ClassVar[str] = "FluxnovaInputParameter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaInputParameter

    fluxnova_name: Optional[str] = None
    value: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_name is not None and not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.value is not None and not isinstance(self.value, str):
            self.value = str(self.value)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaList(BpmnModelElementInstance):
    """
    The BPMN camundaList extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaList"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaList"
    class_name: ClassVar[str] = "FluxnovaList"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaList

    values: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.values is not None and not isinstance(self.values, str):
            self.values = str(self.values)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaMap(BpmnModelElementInstance):
    """
    The BPMN camundaMap extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaMap"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaMap"
    class_name: ClassVar[str] = "FluxnovaMap"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaMap

    fluxnova_entries: Optional[Union[Union[dict, FluxnovaEntry], list[Union[dict, FluxnovaEntry]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.fluxnova_entries, list):
            self.fluxnova_entries = [self.fluxnova_entries] if self.fluxnova_entries is not None else []
        self.fluxnova_entries = [v if isinstance(v, FluxnovaEntry) else FluxnovaEntry(**as_dict(v)) for v in self.fluxnova_entries]

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaOut(BpmnModelElementInstance):
    """
    The BPMN out camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaOut"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaOut"
    class_name: ClassVar[str] = "FluxnovaOut"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaOut

    fluxnova_source: Optional[str] = None
    fluxnova_source_expression: Optional[str] = None
    fluxnova_variables: Optional[str] = None
    fluxnova_target: Optional[str] = None
    fluxnova_local: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_source is not None and not isinstance(self.fluxnova_source, str):
            self.fluxnova_source = str(self.fluxnova_source)

        if self.fluxnova_source_expression is not None and not isinstance(self.fluxnova_source_expression, str):
            self.fluxnova_source_expression = str(self.fluxnova_source_expression)

        if self.fluxnova_variables is not None and not isinstance(self.fluxnova_variables, str):
            self.fluxnova_variables = str(self.fluxnova_variables)

        if self.fluxnova_target is not None and not isinstance(self.fluxnova_target, str):
            self.fluxnova_target = str(self.fluxnova_target)

        if self.fluxnova_local is not None and not isinstance(self.fluxnova_local, Bool):
            self.fluxnova_local = Bool(self.fluxnova_local)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaOutputParameter(BpmnModelElementInstance):
    """
    The BPMN outputParameter camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaOutputParameter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaOutputParameter"
    class_name: ClassVar[str] = "FluxnovaOutputParameter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaOutputParameter

    fluxnova_name: Optional[str] = None
    value: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_name is not None and not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.value is not None and not isinstance(self.value, str):
            self.value = str(self.value)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaPotentialStarter(BpmnModelElementInstance):
    """
    The BPMN potentialStarter camunda extension
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaPotentialStarter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaPotentialStarter"
    class_name: ClassVar[str] = "FluxnovaPotentialStarter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaPotentialStarter

    resource_assignment_expression: Optional[Union[str, ResourceAssignmentExpressionId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.resource_assignment_expression is not None and not isinstance(self.resource_assignment_expression, ResourceAssignmentExpressionId):
            self.resource_assignment_expression = ResourceAssignmentExpressionId(self.resource_assignment_expression)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaProperties(BpmnModelElementInstance):
    """
    The BPMN properties camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaProperties"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaProperties"
    class_name: ClassVar[str] = "FluxnovaProperties"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaProperties

    fluxnova_properties: Optional[Union[dict, "FluxnovaProperty"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_properties is not None and not isinstance(self.fluxnova_properties, FluxnovaProperty):
            self.fluxnova_properties = FluxnovaProperty(**as_dict(self.fluxnova_properties))

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaProperty(BpmnModelElementInstance):
    """
    The BPMN property camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaProperty"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaProperty"
    class_name: ClassVar[str] = "FluxnovaProperty"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaProperty

    fluxnova_id: Optional[str] = None
    fluxnova_name: Optional[str] = None
    fluxnova_value: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_id is not None and not isinstance(self.fluxnova_id, str):
            self.fluxnova_id = str(self.fluxnova_id)

        if self.fluxnova_name is not None and not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.fluxnova_value is not None and not isinstance(self.fluxnova_value, str):
            self.fluxnova_value = str(self.fluxnova_value)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaScript(BpmnModelElementInstance):
    """
    The BPMN script camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaScript"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaScript"
    class_name: ClassVar[str] = "FluxnovaScript"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaScript

    fluxnova_script_format: Optional[str] = None
    fluxnova_resource: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_script_format is not None and not isinstance(self.fluxnova_script_format, str):
            self.fluxnova_script_format = str(self.fluxnova_script_format)

        if self.fluxnova_resource is not None and not isinstance(self.fluxnova_resource, str):
            self.fluxnova_resource = str(self.fluxnova_resource)

        super().__post_init__(**kwargs)


class FluxnovaString(BpmnModelElementInstance):
    """
    The BPMN string camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaString"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaString"
    class_name: ClassVar[str] = "FluxnovaString"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaString


@dataclass(repr=False)
class FluxnovaTaskListener(BpmnModelElementInstance):
    """
    The BPMN taskListener camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaTaskListener"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaTaskListener"
    class_name: ClassVar[str] = "FluxnovaTaskListener"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaTaskListener

    fluxnova_event: Optional[str] = None
    fluxnova_class: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_fields: Optional[Union[Union[dict, FluxnovaField], list[Union[dict, FluxnovaField]]]] = empty_list()
    fluxnova_script: Optional[Union[dict, FluxnovaScript]] = None
    timeouts: Optional[Union[dict[Union[str, TimerEventDefinitionId], Union[dict, TimerEventDefinition]], list[Union[dict, TimerEventDefinition]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_event is not None and not isinstance(self.fluxnova_event, str):
            self.fluxnova_event = str(self.fluxnova_event)

        if self.fluxnova_class is not None and not isinstance(self.fluxnova_class, str):
            self.fluxnova_class = str(self.fluxnova_class)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_delegate_expression is not None and not isinstance(self.fluxnova_delegate_expression, str):
            self.fluxnova_delegate_expression = str(self.fluxnova_delegate_expression)

        if not isinstance(self.fluxnova_fields, list):
            self.fluxnova_fields = [self.fluxnova_fields] if self.fluxnova_fields is not None else []
        self.fluxnova_fields = [v if isinstance(v, FluxnovaField) else FluxnovaField(**as_dict(v)) for v in self.fluxnova_fields]

        if self.fluxnova_script is not None and not isinstance(self.fluxnova_script, FluxnovaScript):
            self.fluxnova_script = FluxnovaScript(**as_dict(self.fluxnova_script))

        self._normalize_inlined_as_list(slot_name="timeouts", slot_type=TimerEventDefinition, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaValidation(BpmnModelElementInstance):
    """
    The BPMN validation camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaValidation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaValidation"
    class_name: ClassVar[str] = "FluxnovaValidation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaValidation

    fluxnova_constraints: Optional[Union[Union[dict, FluxnovaConstraint], list[Union[dict, FluxnovaConstraint]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.fluxnova_constraints, list):
            self.fluxnova_constraints = [self.fluxnova_constraints] if self.fluxnova_constraints is not None else []
        self.fluxnova_constraints = [v if isinstance(v, FluxnovaConstraint) else FluxnovaConstraint(**as_dict(v)) for v in self.fluxnova_constraints]

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaValue(BpmnModelElementInstance):
    """
    The BPMN value camunda extension element
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPMN_MODEL_FLUXNOVA["FluxnovaValue"]
    class_class_curie: ClassVar[str] = "fluxnova_bpmn_model_fluxnova:FluxnovaValue"
    class_name: ClassVar[str] = "FluxnovaValue"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaValue

    fluxnova_id: Optional[str] = None
    fluxnova_name: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_id is not None and not isinstance(self.fluxnova_id, str):
            self.fluxnova_id = str(self.fluxnova_id)

        if self.fluxnova_name is not None and not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        super().__post_init__(**kwargs)


# Enumerations
class SuspensionState(EnumDefinitionImpl):
    """
    Whether an entity is active or suspended.
    """
    ACTIVE = PermissibleValue(
        text="ACTIVE",
        description="The entity is active.",
        meaning=FLUXNOVA_BPM_PLATFORM["SuspensionState/1"])
    SUSPENDED = PermissibleValue(
        text="SUSPENDED",
        description="The entity is suspended.",
        meaning=FLUXNOVA_BPM_PLATFORM["SuspensionState/2"])

    _defn = EnumDefinition(
        name="SuspensionState",
        description="Whether an entity is active or suspended.",
    )

class DelegationState(EnumDefinitionImpl):
    """
    Delegation states of a task.
    """
    PENDING = PermissibleValue(
        text="PENDING",
        description="The task has been delegated and is awaiting resolution.")
    RESOLVED = PermissibleValue(
        text="RESOLVED",
        description="The delegated task has been resolved by the assignee.")

    _defn = EnumDefinition(
        name="DelegationState",
        description="Delegation states of a task.",
    )

class ActivityInstanceState(EnumDefinitionImpl):
    """
    State of an activity instance.
    """
    DEFAULT = PermissibleValue(
        text="DEFAULT",
        description="The activity instance is running normally.",
        meaning=FLUXNOVA_BPM_PLATFORM["ActivityInstanceState/0"])
    SCOPE_COMPLETE = PermissibleValue(
        text="SCOPE_COMPLETE",
        description="The scope of the activity instance is complete.",
        meaning=FLUXNOVA_BPM_PLATFORM["ActivityInstanceState/1"])
    CANCELED = PermissibleValue(
        text="CANCELED",
        description="The activity instance was canceled.",
        meaning=FLUXNOVA_BPM_PLATFORM["ActivityInstanceState/2"])
    STARTING = PermissibleValue(
        text="STARTING",
        description="The activity instance is starting.",
        meaning=FLUXNOVA_BPM_PLATFORM["ActivityInstanceState/3"])
    ENDING = PermissibleValue(
        text="ENDING",
        description="The activity instance is ending.",
        meaning=FLUXNOVA_BPM_PLATFORM["ActivityInstanceState/4"])

    _defn = EnumDefinition(
        name="ActivityInstanceState",
        description="State of an activity instance.",
    )

class IncidentState(EnumDefinitionImpl):
    """
    State of a historic incident.
    """
    OPEN = PermissibleValue(
        text="OPEN",
        description="The incident is open.")
    DELETED = PermissibleValue(
        text="DELETED",
        description="The incident has been deleted.")
    RESOLVED = PermissibleValue(
        text="RESOLVED",
        description="The incident has been resolved.")

    _defn = EnumDefinition(
        name="IncidentState",
        description="State of a historic incident.",
    )

class JobState(EnumDefinitionImpl):
    """
    State of a historic job log entry.
    """
    CREATED = PermissibleValue(
        text="CREATED",
        description="The job was created.")
    FAILED = PermissibleValue(
        text="FAILED",
        description="The job execution failed.")
    SUCCESSFUL = PermissibleValue(
        text="SUCCESSFUL",
        description="The job executed successfully.")
    DELETED = PermissibleValue(
        text="DELETED",
        description="The job was deleted.")

    _defn = EnumDefinition(
        name="JobState",
        description="State of a historic job log entry.",
    )

class EntityState(EnumDefinitionImpl):
    """
    General state of an entity (e.g. variable, process instance).
    """
    ACTIVE = PermissibleValue(
        text="ACTIVE",
        description="Active.")
    SUSPENDED = PermissibleValue(
        text="SUSPENDED",
        description="Suspended.")
    COMPLETED = PermissibleValue(
        text="COMPLETED",
        description="Completed.")
    EXTERNALLY_TERMINATED = PermissibleValue(
        text="EXTERNALLY_TERMINATED",
        description="Terminated externally.")
    INTERNALLY_TERMINATED = PermissibleValue(
        text="INTERNALLY_TERMINATED",
        description="Terminated internally.")

    _defn = EnumDefinition(
        name="EntityState",
        description="General state of an entity (e.g. variable, process instance).",
    )

class AuthorizationType(EnumDefinitionImpl):
    """
    Type of authorization rule.
    """
    GLOBAL = PermissibleValue(
        text="GLOBAL",
        description="Applies to all users.",
        meaning=FLUXNOVA_BPM_PLATFORM["AuthorizationType/0"])
    GRANT = PermissibleValue(
        text="GRANT",
        description="Grants permission.",
        meaning=FLUXNOVA_BPM_PLATFORM["AuthorizationType/1"])
    REVOKE = PermissibleValue(
        text="REVOKE",
        description="Revokes permission.",
        meaning=FLUXNOVA_BPM_PLATFORM["AuthorizationType/2"])

    _defn = EnumDefinition(
        name="AuthorizationType",
        description="Type of authorization rule.",
    )

class AssociationDirection(EnumDefinitionImpl):
    """
    The BPMN tAssociationDirection type
    """
    One = PermissibleValue(
        text="One",
        description="One")
    Both = PermissibleValue(
        text="Both",
        description="Both")

    _defn = EnumDefinition(
        name="AssociationDirection",
        description="The BPMN tAssociationDirection type",
    )

    @classmethod
    def _addvals(cls):
        setattr(cls, "None",
            PermissibleValue(
                text="None",
                description="None"))

class EventBasedGatewayType(EnumDefinitionImpl):
    """
    The BPMN tEventBasedGatewayType simpleType
    """
    Exclusive = PermissibleValue(
        text="Exclusive",
        description="Exclusive")
    Parallel = PermissibleValue(
        text="Parallel",
        description="Parallel")

    _defn = EnumDefinition(
        name="EventBasedGatewayType",
        description="The BPMN tEventBasedGatewayType simpleType",
    )

class GatewayDirection(EnumDefinitionImpl):
    """
    The BPMN tGatewayDirection simpleType
    """
    Unspecified = PermissibleValue(
        text="Unspecified",
        description="Unspecified")
    Converging = PermissibleValue(
        text="Converging",
        description="Converging")
    Diverging = PermissibleValue(
        text="Diverging",
        description="Diverging")
    Mixed = PermissibleValue(
        text="Mixed",
        description="Mixed")

    _defn = EnumDefinition(
        name="GatewayDirection",
        description="The BPMN tGatewayDirection simpleType",
    )

class ItemKind(EnumDefinitionImpl):
    """
    The BPMN tItemKind simple type
    """
    Information = PermissibleValue(
        text="Information",
        description="Information")
    Physical = PermissibleValue(
        text="Physical",
        description="Physical")

    _defn = EnumDefinition(
        name="ItemKind",
        description="The BPMN tItemKind simple type",
    )

class MultiInstanceFlowCondition(EnumDefinitionImpl):
    """
    The BPMN 2.0 tMultiInstanceFlowCondition simple type
    """
    One = PermissibleValue(
        text="One",
        description="One")
    All = PermissibleValue(
        text="All",
        description="All")
    Complex = PermissibleValue(
        text="Complex",
        description="Complex")

    _defn = EnumDefinition(
        name="MultiInstanceFlowCondition",
        description="The BPMN 2.0 tMultiInstanceFlowCondition simple type",
    )

    @classmethod
    def _addvals(cls):
        setattr(cls, "None",
            PermissibleValue(
                text="None",
                description="None"))

class ProcessType(EnumDefinitionImpl):
    """
    The BPMN tProcessType simple type
    """
    Public = PermissibleValue(
        text="Public",
        description="Public")
    Private = PermissibleValue(
        text="Private",
        description="Private")

    _defn = EnumDefinition(
        name="ProcessType",
        description="The BPMN tProcessType simple type",
    )

    @classmethod
    def _addvals(cls):
        setattr(cls, "None",
            PermissibleValue(
                text="None",
                description="None"))

class RelationshipDirection(EnumDefinitionImpl):
    """
    The BPMN tRelationshipDirection type
    """
    Forward = PermissibleValue(
        text="Forward",
        description="Forward")
    Backward = PermissibleValue(
        text="Backward",
        description="Backward")
    Both = PermissibleValue(
        text="Both",
        description="Both")

    _defn = EnumDefinition(
        name="RelationshipDirection",
        description="The BPMN tRelationshipDirection type",
    )

    @classmethod
    def _addvals(cls):
        setattr(cls, "None",
            PermissibleValue(
                text="None",
                description="None"))

class TransactionMethod(EnumDefinitionImpl):
    """
    BPMN TransactionMethod enumeration.
    """
    Compensate = PermissibleValue(
        text="Compensate",
        description="Compensate")
    Image = PermissibleValue(
        text="Image",
        description="Image")
    Store = PermissibleValue(
        text="Store",
        description="Store")

    _defn = EnumDefinition(
        name="TransactionMethod",
        description="BPMN TransactionMethod enumeration.",
    )

class MessageVisibleKind(EnumDefinitionImpl):
    """
    The BPMNDI MessageVisibleKind simpleType
    """
    initiating = PermissibleValue(
        text="initiating",
        description="Initiating")
    non_initiating = PermissibleValue(
        text="non_initiating",
        description="Non initiating")

    _defn = EnumDefinition(
        name="MessageVisibleKind",
        description="The BPMNDI MessageVisibleKind simpleType",
    )

class ParticipantBandKind(EnumDefinitionImpl):
    """
    The BPMNDI ParticipantBandKind simpleType
    """
    top_initiating = PermissibleValue(
        text="top_initiating",
        description="Top initiating")
    middle_initiating = PermissibleValue(
        text="middle_initiating",
        description="Middle initiating")
    bottom_initiating = PermissibleValue(
        text="bottom_initiating",
        description="Bottom initiating")
    top_non_initiating = PermissibleValue(
        text="top_non_initiating",
        description="Top non initiating")
    middle_non_initiating = PermissibleValue(
        text="middle_non_initiating",
        description="Middle non initiating")
    bottom_non_initiating = PermissibleValue(
        text="bottom_non_initiating",
        description="Bottom non initiating")

    _defn = EnumDefinition(
        name="ParticipantBandKind",
        description="The BPMNDI ParticipantBandKind simpleType",
    )

# Slots
class slots:
    pass

slots.deployments = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployments, name="deployments", curie=FLUXNOVA_BPM_PLATFORM.curie('deployments'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.deployments, domain=None, range=Optional[Union[dict[Union[str, DeploymentId], Union[dict, Deployment]], list[Union[dict, Deployment]]]])

slots.process_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definitions, name="process_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process_definitions, domain=None, range=Optional[Union[dict[Union[str, ProcessDefinitionId], Union[dict, ProcessDefinition]], list[Union[dict, ProcessDefinition]]]])

slots.executions = Slot(uri=FLUXNOVA_BPM_PLATFORM.executions, name="executions", curie=FLUXNOVA_BPM_PLATFORM.curie('executions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.executions, domain=None, range=Optional[Union[dict[Union[str, ExecutionId], Union[dict, Execution]], list[Union[dict, Execution]]]])

slots.tasks = Slot(uri=FLUXNOVA_BPM_PLATFORM.tasks, name="tasks", curie=FLUXNOVA_BPM_PLATFORM.curie('tasks'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.tasks, domain=None, range=Optional[Union[dict[Union[str, TaskId], Union[dict, Task]], list[Union[dict, Task]]]])

slots.jobs = Slot(uri=FLUXNOVA_BPM_PLATFORM.jobs, name="jobs", curie=FLUXNOVA_BPM_PLATFORM.curie('jobs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.jobs, domain=None, range=Optional[Union[dict[Union[str, JobId], Union[dict, Job]], list[Union[dict, Job]]]])

slots.users = Slot(uri=FLUXNOVA_BPM_PLATFORM.users, name="users", curie=FLUXNOVA_BPM_PLATFORM.curie('users'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.users, domain=None, range=Optional[Union[dict[Union[str, UserId], Union[dict, User]], list[Union[dict, User]]]])

slots.groups = Slot(uri=FLUXNOVA_BPM_PLATFORM.groups, name="groups", curie=FLUXNOVA_BPM_PLATFORM.curie('groups'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.groups, domain=None, range=Optional[Union[dict[Union[str, GroupId], Union[dict, Group]], list[Union[dict, Group]]]])

slots.batches = Slot(uri=FLUXNOVA_BPM_PLATFORM.batches, name="batches", curie=FLUXNOVA_BPM_PLATFORM.curie('batches'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.batches, domain=None, range=Optional[Union[dict[Union[str, BatchId], Union[dict, Batch]], list[Union[dict, Batch]]]])

slots.id = Slot(uri=SCHEMA.identifier, name="id", curie=SCHEMA.curie('identifier'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.id, domain=None, range=URIRef)

slots.name = Slot(uri=SCHEMA.name, name="name", curie=SCHEMA.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.name, domain=None, range=Optional[str])

slots.category = Slot(uri=FLUXNOVA_COMMON.category, name="category", curie=FLUXNOVA_COMMON.curie('category'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.category, domain=None, range=Optional[str])

slots.message = Slot(uri=FLUXNOVA_COMMON.message, name="message", curie=FLUXNOVA_COMMON.curie('message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.message, domain=None, range=Optional[str])

slots.properties = Slot(uri=FLUXNOVA_COMMON.properties, name="properties", curie=FLUXNOVA_COMMON.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.properties, domain=None, range=Optional[str])

slots.source = Slot(uri=FLUXNOVA_COMMON.source, name="source", curie=FLUXNOVA_COMMON.curie('source'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.source, domain=None, range=Optional[str])

slots.type = Slot(uri=FLUXNOVA_COMMON.type, name="type", curie=FLUXNOVA_COMMON.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.type, domain=None, range=Optional[str])

slots.value = Slot(uri=FLUXNOVA_COMMON.value, name="value", curie=FLUXNOVA_COMMON.curie('value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.value, domain=None, range=Optional[str])

slots.assignee_hash = Slot(uri=FLUXNOVA_BPM_BASE.assignee_hash, name="assignee_hash", curie=FLUXNOVA_BPM_BASE.curie('assignee_hash'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.assignee_hash, domain=None, range=Optional[int])

slots.bytes = Slot(uri=FLUXNOVA_BPM_BASE.bytes, name="bytes", curie=FLUXNOVA_BPM_BASE.curie('bytes'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bytes, domain=None, range=Optional[str])

slots.create_time = Slot(uri=FLUXNOVA_BPM_BASE.create_time, name="create_time", curie=FLUXNOVA_BPM_BASE.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.create_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.deployment_id = Slot(uri=FLUXNOVA_BPM_BASE.deployment_id, name="deployment_id", curie=FLUXNOVA_BPM_BASE.curie('deployment_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.deployment_id, domain=None, range=Optional[str])

slots.is_generated = Slot(uri=FLUXNOVA_BPM_BASE.is_generated, name="is_generated", curie=FLUXNOVA_BPM_BASE.curie('is_generated'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_generated, domain=None, range=Optional[Union[bool, Bool]])

slots.milliseconds = Slot(uri=FLUXNOVA_BPM_BASE.milliseconds, name="milliseconds", curie=FLUXNOVA_BPM_BASE.curie('milliseconds'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.milliseconds, domain=None, range=Optional[int])

slots.removal_time = Slot(uri=FLUXNOVA_BPM_BASE.removal_time, name="removal_time", curie=FLUXNOVA_BPM_BASE.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.removal_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.reporter = Slot(uri=FLUXNOVA_BPM_BASE.reporter, name="reporter", curie=FLUXNOVA_BPM_BASE.curie('reporter'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.reporter, domain=None, range=Optional[str])

slots.root_process_instance_id = Slot(uri=FLUXNOVA_BPM_BASE.root_process_instance_id, name="root_process_instance_id", curie=FLUXNOVA_BPM_BASE.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, domain=None, range=Optional[str])

slots.tenant_id = Slot(uri=FLUXNOVA_BPM_BASE.tenant_id, name="tenant_id", curie=FLUXNOVA_BPM_BASE.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.tenant_id, domain=None, range=Optional[str])

slots.timestamp = Slot(uri=FLUXNOVA_BPM_BASE.timestamp, name="timestamp", curie=FLUXNOVA_BPM_BASE.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.timestamp, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.version = Slot(uri=FLUXNOVA_BPM_BASE.version, name="version", curie=FLUXNOVA_BPM_BASE.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.version, domain=None, range=Optional[int])

slots.action = Slot(uri=FLUXNOVA_BPM_COLLABORATION.action, name="action", curie=FLUXNOVA_BPM_COLLABORATION.curie('action'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.action, domain=None, range=Optional[str])

slots.content_id = Slot(uri=FLUXNOVA_BPM_COLLABORATION.content_id, name="content_id", curie=FLUXNOVA_BPM_COLLABORATION.curie('content_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.content_id, domain=None, range=Optional[str])

slots.event_time = Slot(uri=FLUXNOVA_BPM_COLLABORATION.event_time, name="event_time", curie=FLUXNOVA_BPM_COLLABORATION.curie('event_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_time, domain=None, range=Union[str, XSDDateTime])

slots.full_message = Slot(uri=FLUXNOVA_BPM_COLLABORATION.full_message, name="full_message", curie=FLUXNOVA_BPM_COLLABORATION.curie('full_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.full_message, domain=None, range=Optional[str])

slots.query = Slot(uri=FLUXNOVA_BPM_COLLABORATION.query, name="query", curie=FLUXNOVA_BPM_COLLABORATION.curie('query'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.query, domain=None, range=str)

slots.url = Slot(uri=FLUXNOVA_BPM_COLLABORATION.url, name="url", curie=FLUXNOVA_BPM_COLLABORATION.curie('url'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.url, domain=None, range=Optional[str])

slots.activity_instance_state = Slot(uri=FLUXNOVA_BPM_HISTORY.activity_instance_state, name="activity_instance_state", curie=FLUXNOVA_BPM_HISTORY.curie('activity_instance_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_instance_state, domain=None, range=Optional[Union[str, "ActivityInstanceState"]])

slots.activity_name = Slot(uri=FLUXNOVA_BPM_HISTORY.activity_name, name="activity_name", curie=FLUXNOVA_BPM_HISTORY.curie('activity_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_name, domain=None, range=Optional[str])

slots.activity_type = Slot(uri=FLUXNOVA_BPM_HISTORY.activity_type, name="activity_type", curie=FLUXNOVA_BPM_HISTORY.curie('activity_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_type, domain=None, range=str)

slots.assigner_id = Slot(uri=FLUXNOVA_BPM_HISTORY.assigner_id, name="assigner_id", curie=FLUXNOVA_BPM_HISTORY.curie('assigner_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.assigner_id, domain=None, range=Optional[str])

slots.called_case_instance_id = Slot(uri=FLUXNOVA_BPM_HISTORY.called_case_instance_id, name="called_case_instance_id", curie=FLUXNOVA_BPM_HISTORY.curie('called_case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.called_case_instance_id, domain=None, range=Optional[str])

slots.called_process_instance_id = Slot(uri=FLUXNOVA_BPM_HISTORY.called_process_instance_id, name="called_process_instance_id", curie=FLUXNOVA_BPM_HISTORY.curie('called_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.called_process_instance_id, domain=None, range=Optional[str])

slots.case_activity_id = Slot(uri=FLUXNOVA_BPM_HISTORY.case_activity_id, name="case_activity_id", curie=FLUXNOVA_BPM_HISTORY.curie('case_activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_activity_id, domain=None, range=str)

slots.case_activity_name = Slot(uri=FLUXNOVA_BPM_HISTORY.case_activity_name, name="case_activity_name", curie=FLUXNOVA_BPM_HISTORY.curie('case_activity_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_activity_name, domain=None, range=Optional[str])

slots.case_activity_type = Slot(uri=FLUXNOVA_BPM_HISTORY.case_activity_type, name="case_activity_type", curie=FLUXNOVA_BPM_HISTORY.curie('case_activity_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_activity_type, domain=None, range=Optional[str])

slots.case_definition_key = Slot(uri=FLUXNOVA_BPM_HISTORY.case_definition_key, name="case_definition_key", curie=FLUXNOVA_BPM_HISTORY.curie('case_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_definition_key, domain=None, range=Optional[str])

slots.clause_id = Slot(uri=FLUXNOVA_BPM_HISTORY.clause_id, name="clause_id", curie=FLUXNOVA_BPM_HISTORY.curie('clause_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.clause_id, domain=None, range=Optional[str])

slots.clause_name = Slot(uri=FLUXNOVA_BPM_HISTORY.clause_name, name="clause_name", curie=FLUXNOVA_BPM_HISTORY.curie('clause_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.clause_name, domain=None, range=Optional[str])

slots.close_time = Slot(uri=FLUXNOVA_BPM_HISTORY.close_time, name="close_time", curie=FLUXNOVA_BPM_HISTORY.curie('close_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.close_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.collect_result_value = Slot(uri=FLUXNOVA_BPM_HISTORY.collect_result_value, name="collect_result_value", curie=FLUXNOVA_BPM_HISTORY.curie('collect_result_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.collect_result_value, domain=None, range=Optional[float])

slots.decision_definition_id = Slot(uri=FLUXNOVA_BPM_HISTORY.decision_definition_id, name="decision_definition_id", curie=FLUXNOVA_BPM_HISTORY.curie('decision_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_definition_id, domain=None, range=str)

slots.decision_definition_key = Slot(uri=FLUXNOVA_BPM_HISTORY.decision_definition_key, name="decision_definition_key", curie=FLUXNOVA_BPM_HISTORY.curie('decision_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_definition_key, domain=None, range=str)

slots.decision_definition_name = Slot(uri=FLUXNOVA_BPM_HISTORY.decision_definition_name, name="decision_definition_name", curie=FLUXNOVA_BPM_HISTORY.curie('decision_definition_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_definition_name, domain=None, range=Optional[str])

slots.decision_instance_id = Slot(uri=FLUXNOVA_BPM_HISTORY.decision_instance_id, name="decision_instance_id", curie=FLUXNOVA_BPM_HISTORY.curie('decision_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_instance_id, domain=None, range=str)

slots.delete_reason = Slot(uri=FLUXNOVA_BPM_HISTORY.delete_reason, name="delete_reason", curie=FLUXNOVA_BPM_HISTORY.curie('delete_reason'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.delete_reason, domain=None, range=Optional[str])

slots.duration = Slot(uri=FLUXNOVA_BPM_HISTORY.duration, name="duration", curie=FLUXNOVA_BPM_HISTORY.curie('duration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.duration, domain=None, range=Optional[int])

slots.end_activity_id = Slot(uri=FLUXNOVA_BPM_HISTORY.end_activity_id, name="end_activity_id", curie=FLUXNOVA_BPM_HISTORY.curie('end_activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.end_activity_id, domain=None, range=Optional[str])

slots.end_time = Slot(uri=FLUXNOVA_BPM_HISTORY.end_time, name="end_time", curie=FLUXNOVA_BPM_HISTORY.curie('end_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.end_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.entity_type = Slot(uri=FLUXNOVA_BPM_HISTORY.entity_type, name="entity_type", curie=FLUXNOVA_BPM_HISTORY.curie('entity_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.entity_type, domain=None, range=Optional[str])

slots.evaluation_time = Slot(uri=FLUXNOVA_BPM_HISTORY.evaluation_time, name="evaluation_time", curie=FLUXNOVA_BPM_HISTORY.curie('evaluation_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.evaluation_time, domain=None, range=Union[str, XSDDateTime])

slots.external_task_id = Slot(uri=FLUXNOVA_BPM_HISTORY.external_task_id, name="external_task_id", curie=FLUXNOVA_BPM_HISTORY.curie('external_task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.external_task_id, domain=None, range=str)

slots.history_configuration = Slot(uri=FLUXNOVA_BPM_HISTORY.history_configuration, name="history_configuration", curie=FLUXNOVA_BPM_HISTORY.curie('history_configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.history_configuration, domain=None, range=Optional[str])

slots.hostname = Slot(uri=FLUXNOVA_BPM_HISTORY.hostname, name="hostname", curie=FLUXNOVA_BPM_HISTORY.curie('hostname'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.hostname, domain=None, range=Optional[str])

slots.incident_state = Slot(uri=FLUXNOVA_BPM_HISTORY.incident_state, name="incident_state", curie=FLUXNOVA_BPM_HISTORY.curie('incident_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incident_state, domain=None, range=Optional[Union[str, "IncidentState"]])

slots.is_initial = Slot(uri=FLUXNOVA_BPM_HISTORY.is_initial, name="is_initial", curie=FLUXNOVA_BPM_HISTORY.curie('is_initial'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_initial, domain=None, range=Optional[Union[bool, Bool]])

slots.job_definition_configuration = Slot(uri=FLUXNOVA_BPM_HISTORY.job_definition_configuration, name="job_definition_configuration", curie=FLUXNOVA_BPM_HISTORY.curie('job_definition_configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_definition_configuration, domain=None, range=Optional[str])

slots.job_definition_type = Slot(uri=FLUXNOVA_BPM_HISTORY.job_definition_type, name="job_definition_type", curie=FLUXNOVA_BPM_HISTORY.curie('job_definition_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_definition_type, domain=None, range=Optional[str])

slots.job_due_date = Slot(uri=FLUXNOVA_BPM_HISTORY.job_due_date, name="job_due_date", curie=FLUXNOVA_BPM_HISTORY.curie('job_due_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_due_date, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.job_exception_message = Slot(uri=FLUXNOVA_BPM_HISTORY.job_exception_message, name="job_exception_message", curie=FLUXNOVA_BPM_HISTORY.curie('job_exception_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_exception_message, domain=None, range=Optional[str])

slots.job_exception_stack_id = Slot(uri=FLUXNOVA_BPM_HISTORY.job_exception_stack_id, name="job_exception_stack_id", curie=FLUXNOVA_BPM_HISTORY.curie('job_exception_stack_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_exception_stack_id, domain=None, range=Optional[str])

slots.job_id = Slot(uri=FLUXNOVA_BPM_HISTORY.job_id, name="job_id", curie=FLUXNOVA_BPM_HISTORY.curie('job_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_id, domain=None, range=str)

slots.job_retries = Slot(uri=FLUXNOVA_BPM_HISTORY.job_retries, name="job_retries", curie=FLUXNOVA_BPM_HISTORY.curie('job_retries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_retries, domain=None, range=Optional[int])

slots.job_state = Slot(uri=FLUXNOVA_BPM_HISTORY.job_state, name="job_state", curie=FLUXNOVA_BPM_HISTORY.curie('job_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_state, domain=None, range=Optional[Union[str, "JobState"]])

slots.new_value = Slot(uri=FLUXNOVA_BPM_HISTORY.new_value, name="new_value", curie=FLUXNOVA_BPM_HISTORY.curie('new_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.new_value, domain=None, range=Optional[str])

slots.operation_id = Slot(uri=FLUXNOVA_BPM_HISTORY.operation_id, name="operation_id", curie=FLUXNOVA_BPM_HISTORY.curie('operation_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.operation_id, domain=None, range=Optional[str])

slots.operation_type = Slot(uri=FLUXNOVA_BPM_HISTORY.operation_type, name="operation_type", curie=FLUXNOVA_BPM_HISTORY.curie('operation_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.operation_type, domain=None, range=Optional[str])

slots.original_value = Slot(uri=FLUXNOVA_BPM_HISTORY.original_value, name="original_value", curie=FLUXNOVA_BPM_HISTORY.curie('original_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.original_value, domain=None, range=Optional[str])

slots.parent_activity_instance_id = Slot(uri=FLUXNOVA_BPM_HISTORY.parent_activity_instance_id, name="parent_activity_instance_id", curie=FLUXNOVA_BPM_HISTORY.curie('parent_activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.parent_activity_instance_id, domain=None, range=Optional[str])

slots.property = Slot(uri=FLUXNOVA_BPM_HISTORY.property, name="property", curie=FLUXNOVA_BPM_HISTORY.curie('property'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.property, domain=None, range=Optional[str])

slots.restarted_process_instance_id = Slot(uri=FLUXNOVA_BPM_HISTORY.restarted_process_instance_id, name="restarted_process_instance_id", curie=FLUXNOVA_BPM_HISTORY.curie('restarted_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.restarted_process_instance_id, domain=None, range=Optional[str])

slots.root_decision_instance_id = Slot(uri=FLUXNOVA_BPM_HISTORY.root_decision_instance_id, name="root_decision_instance_id", curie=FLUXNOVA_BPM_HISTORY.curie('root_decision_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.root_decision_instance_id, domain=None, range=Optional[str])

slots.rule_id = Slot(uri=FLUXNOVA_BPM_HISTORY.rule_id, name="rule_id", curie=FLUXNOVA_BPM_HISTORY.curie('rule_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.rule_id, domain=None, range=Optional[str])

slots.rule_order = Slot(uri=FLUXNOVA_BPM_HISTORY.rule_order, name="rule_order", curie=FLUXNOVA_BPM_HISTORY.curie('rule_order'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.rule_order, domain=None, range=Optional[int])

slots.start_activity_id = Slot(uri=FLUXNOVA_BPM_HISTORY.start_activity_id, name="start_activity_id", curie=FLUXNOVA_BPM_HISTORY.curie('start_activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.start_activity_id, domain=None, range=Optional[str])

slots.start_user_id = Slot(uri=FLUXNOVA_BPM_HISTORY.start_user_id, name="start_user_id", curie=FLUXNOVA_BPM_HISTORY.curie('start_user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.start_user_id, domain=None, range=Optional[str])

slots.state = Slot(uri=FLUXNOVA_BPM_HISTORY.state, name="state", curie=FLUXNOVA_BPM_HISTORY.curie('state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.state, domain=None, range=Optional[Union[str, "EntityState"]])

slots.super_case_instance_id = Slot(uri=FLUXNOVA_BPM_HISTORY.super_case_instance_id, name="super_case_instance_id", curie=FLUXNOVA_BPM_HISTORY.curie('super_case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.super_case_instance_id, domain=None, range=Optional[str])

slots.super_process_instance_id = Slot(uri=FLUXNOVA_BPM_HISTORY.super_process_instance_id, name="super_process_instance_id", curie=FLUXNOVA_BPM_HISTORY.curie('super_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.super_process_instance_id, domain=None, range=Optional[str])

slots.variable_instance_id = Slot(uri=FLUXNOVA_BPM_HISTORY.variable_instance_id, name="variable_instance_id", curie=FLUXNOVA_BPM_HISTORY.curie('variable_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_instance_id, domain=None, range=Optional[str])

slots.variable_type = Slot(uri=FLUXNOVA_BPM_HISTORY.variable_type, name="variable_type", curie=FLUXNOVA_BPM_HISTORY.curie('variable_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_type, domain=None, range=Optional[str])

slots.attempts = Slot(uri=FLUXNOVA_BPM_IDENTITY.attempts, name="attempts", curie=FLUXNOVA_BPM_IDENTITY.curie('attempts'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.attempts, domain=None, range=Optional[int])

slots.email = Slot(uri=FLUXNOVA_BPM_IDENTITY.email, name="email", curie=FLUXNOVA_BPM_IDENTITY.curie('email'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.email, domain=None, range=Optional[str])

slots.first_name = Slot(uri=FLUXNOVA_BPM_IDENTITY.first_name, name="first_name", curie=FLUXNOVA_BPM_IDENTITY.curie('first_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.first_name, domain=None, range=Optional[str])

slots.group_id = Slot(uri=FLUXNOVA_BPM_IDENTITY.group_id, name="group_id", curie=FLUXNOVA_BPM_IDENTITY.curie('group_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.group_id, domain=None, range=Optional[str])

slots.last_name = Slot(uri=FLUXNOVA_BPM_IDENTITY.last_name, name="last_name", curie=FLUXNOVA_BPM_IDENTITY.curie('last_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.last_name, domain=None, range=Optional[str])

slots.password = Slot(uri=FLUXNOVA_BPM_IDENTITY.password, name="password", curie=FLUXNOVA_BPM_IDENTITY.curie('password'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.password, domain=None, range=Optional[str])

slots.permissions = Slot(uri=FLUXNOVA_BPM_IDENTITY.permissions, name="permissions", curie=FLUXNOVA_BPM_IDENTITY.curie('permissions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.permissions, domain=None, range=Optional[int])

slots.picture_id = Slot(uri=FLUXNOVA_BPM_IDENTITY.picture_id, name="picture_id", curie=FLUXNOVA_BPM_IDENTITY.curie('picture_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.picture_id, domain=None, range=Optional[str])

slots.resource_id = Slot(uri=FLUXNOVA_BPM_IDENTITY.resource_id, name="resource_id", curie=FLUXNOVA_BPM_IDENTITY.curie('resource_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_id, domain=None, range=Optional[str])

slots.resource_type = Slot(uri=FLUXNOVA_BPM_IDENTITY.resource_type, name="resource_type", curie=FLUXNOVA_BPM_IDENTITY.curie('resource_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_type, domain=None, range=int)

slots.salt = Slot(uri=FLUXNOVA_BPM_IDENTITY.salt, name="salt", curie=FLUXNOVA_BPM_IDENTITY.curie('salt'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.salt, domain=None, range=Optional[str])

slots.user_id = Slot(uri=FLUXNOVA_BPM_IDENTITY.user_id, name="user_id", curie=FLUXNOVA_BPM_IDENTITY.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.user_id, domain=None, range=Optional[str])

slots.batch_job_definition_id = Slot(uri=FLUXNOVA_BPM_JOB.batch_job_definition_id, name="batch_job_definition_id", curie=FLUXNOVA_BPM_JOB.curie('batch_job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.batch_job_definition_id, domain=None, range=Optional[str])

slots.create_user_id = Slot(uri=FLUXNOVA_BPM_JOB.create_user_id, name="create_user_id", curie=FLUXNOVA_BPM_JOB.curie('create_user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.create_user_id, domain=None, range=Optional[str])

slots.exception_message = Slot(uri=FLUXNOVA_BPM_JOB.exception_message, name="exception_message", curie=FLUXNOVA_BPM_JOB.curie('exception_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.exception_message, domain=None, range=Optional[str])

slots.exception_stack_id = Slot(uri=FLUXNOVA_BPM_JOB.exception_stack_id, name="exception_stack_id", curie=FLUXNOVA_BPM_JOB.curie('exception_stack_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.exception_stack_id, domain=None, range=Optional[str])

slots.execution_start_time = Slot(uri=FLUXNOVA_BPM_JOB.execution_start_time, name="execution_start_time", curie=FLUXNOVA_BPM_JOB.curie('execution_start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.execution_start_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.handler_configuration = Slot(uri=FLUXNOVA_BPM_JOB.handler_configuration, name="handler_configuration", curie=FLUXNOVA_BPM_JOB.curie('handler_configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.handler_configuration, domain=None, range=Optional[str])

slots.handler_type = Slot(uri=FLUXNOVA_BPM_JOB.handler_type, name="handler_type", curie=FLUXNOVA_BPM_JOB.curie('handler_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.handler_type, domain=None, range=Optional[str])

slots.invocations_per_job = Slot(uri=FLUXNOVA_BPM_JOB.invocations_per_job, name="invocations_per_job", curie=FLUXNOVA_BPM_JOB.curie('invocations_per_job'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.invocations_per_job, domain=None, range=Optional[int])

slots.is_exclusive = Slot(uri=FLUXNOVA_BPM_JOB.is_exclusive, name="is_exclusive", curie=FLUXNOVA_BPM_JOB.curie('is_exclusive'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_exclusive, domain=None, range=Optional[Union[bool, Bool]])

slots.job_configuration = Slot(uri=FLUXNOVA_BPM_JOB.job_configuration, name="job_configuration", curie=FLUXNOVA_BPM_JOB.curie('job_configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_configuration, domain=None, range=Optional[str])

slots.job_priority = Slot(uri=FLUXNOVA_BPM_JOB.job_priority, name="job_priority", curie=FLUXNOVA_BPM_JOB.curie('job_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_priority, domain=None, range=int)

slots.job_type = Slot(uri=FLUXNOVA_BPM_JOB.job_type, name="job_type", curie=FLUXNOVA_BPM_JOB.curie('job_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_type, domain=None, range=str)

slots.jobs_created = Slot(uri=FLUXNOVA_BPM_JOB.jobs_created, name="jobs_created", curie=FLUXNOVA_BPM_JOB.curie('jobs_created'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.jobs_created, domain=None, range=Optional[int])

slots.jobs_per_seed = Slot(uri=FLUXNOVA_BPM_JOB.jobs_per_seed, name="jobs_per_seed", curie=FLUXNOVA_BPM_JOB.curie('jobs_per_seed'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.jobs_per_seed, domain=None, range=Optional[int])

slots.lock_owner = Slot(uri=FLUXNOVA_BPM_JOB.lock_owner, name="lock_owner", curie=FLUXNOVA_BPM_JOB.curie('lock_owner'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.lock_owner, domain=None, range=Optional[str])

slots.monitor_job_definition_id = Slot(uri=FLUXNOVA_BPM_JOB.monitor_job_definition_id, name="monitor_job_definition_id", curie=FLUXNOVA_BPM_JOB.curie('monitor_job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.monitor_job_definition_id, domain=None, range=Optional[str])

slots.repeat = Slot(uri=FLUXNOVA_BPM_JOB.repeat, name="repeat", curie=FLUXNOVA_BPM_JOB.curie('repeat'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.repeat, domain=None, range=Optional[str])

slots.repeat_offset = Slot(uri=FLUXNOVA_BPM_JOB.repeat_offset, name="repeat_offset", curie=FLUXNOVA_BPM_JOB.curie('repeat_offset'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.repeat_offset, domain=None, range=Optional[int])

slots.seed_job_definition_id = Slot(uri=FLUXNOVA_BPM_JOB.seed_job_definition_id, name="seed_job_definition_id", curie=FLUXNOVA_BPM_JOB.curie('seed_job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.seed_job_definition_id, domain=None, range=Optional[str])

slots.start_time = Slot(uri=FLUXNOVA_BPM_JOB.start_time, name="start_time", curie=FLUXNOVA_BPM_JOB.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.start_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.total_jobs = Slot(uri=FLUXNOVA_BPM_JOB.total_jobs, name="total_jobs", curie=FLUXNOVA_BPM_JOB.curie('total_jobs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.total_jobs, domain=None, range=Optional[int])

slots.decision_requirements_definition_id = Slot(uri=FLUXNOVA_BPM_REPOSITORY.decision_requirements_definition_id, name="decision_requirements_definition_id", curie=FLUXNOVA_BPM_REPOSITORY.curie('decision_requirements_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_id, domain=None, range=Optional[str])

slots.decision_requirements_definition_key = Slot(uri=FLUXNOVA_BPM_REPOSITORY.decision_requirements_definition_key, name="decision_requirements_definition_key", curie=FLUXNOVA_BPM_REPOSITORY.curie('decision_requirements_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_key, domain=None, range=Optional[str])

slots.deploy_time = Slot(uri=FLUXNOVA_BPM_REPOSITORY.deploy_time, name="deploy_time", curie=FLUXNOVA_BPM_REPOSITORY.curie('deploy_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.deploy_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.diagram_resource_name = Slot(uri=FLUXNOVA_BPM_REPOSITORY.diagram_resource_name, name="diagram_resource_name", curie=FLUXNOVA_BPM_REPOSITORY.curie('diagram_resource_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diagram_resource_name, domain=None, range=Optional[str])

slots.has_start_form_key = Slot(uri=FLUXNOVA_BPM_REPOSITORY.has_start_form_key, name="has_start_form_key", curie=FLUXNOVA_BPM_REPOSITORY.curie('has_start_form_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.has_start_form_key, domain=None, range=Optional[Union[bool, Bool]])

slots.history_time_to_live = Slot(uri=FLUXNOVA_BPM_REPOSITORY.history_time_to_live, name="history_time_to_live", curie=FLUXNOVA_BPM_REPOSITORY.curie('history_time_to_live'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.history_time_to_live, domain=None, range=Optional[int])

slots.is_startable = Slot(uri=FLUXNOVA_BPM_REPOSITORY.is_startable, name="is_startable", curie=FLUXNOVA_BPM_REPOSITORY.curie('is_startable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_startable, domain=None, range=Union[bool, Bool])

slots.key = Slot(uri=FLUXNOVA_BPM_REPOSITORY.key, name="key", curie=FLUXNOVA_BPM_REPOSITORY.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.key, domain=None, range=Optional[str])

slots.resource_name = Slot(uri=FLUXNOVA_BPM_REPOSITORY.resource_name, name="resource_name", curie=FLUXNOVA_BPM_REPOSITORY.curie('resource_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_name, domain=None, range=Optional[str])

slots.suspension_state = Slot(uri=FLUXNOVA_BPM_REPOSITORY.suspension_state, name="suspension_state", curie=FLUXNOVA_BPM_REPOSITORY.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.suspension_state, domain=None, range=Optional[Union[str, "SuspensionState"]])

slots.version_tag = Slot(uri=FLUXNOVA_BPM_REPOSITORY.version_tag, name="version_tag", curie=FLUXNOVA_BPM_REPOSITORY.curie('version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.version_tag, domain=None, range=Optional[str])

slots.activity_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.activity_id, name="activity_id", curie=FLUXNOVA_BPM_RUNTIME.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_id, domain=None, range=Optional[str])

slots.activity_instance_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.activity_instance_id, name="activity_instance_id", curie=FLUXNOVA_BPM_RUNTIME.curie('activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_instance_id, domain=None, range=Optional[str])

slots.annotation = Slot(uri=FLUXNOVA_BPM_RUNTIME.annotation, name="annotation", curie=FLUXNOVA_BPM_RUNTIME.curie('annotation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.annotation, domain=None, range=Optional[str])

slots.assignee = Slot(uri=FLUXNOVA_BPM_RUNTIME.assignee, name="assignee", curie=FLUXNOVA_BPM_RUNTIME.curie('assignee'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.assignee, domain=None, range=Optional[str])

slots.batch_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.batch_id, name="batch_id", curie=FLUXNOVA_BPM_RUNTIME.curie('batch_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.batch_id, domain=None, range=Optional[str])

slots.business_key = Slot(uri=FLUXNOVA_BPM_RUNTIME.business_key, name="business_key", curie=FLUXNOVA_BPM_RUNTIME.curie('business_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.business_key, domain=None, range=Optional[str])

slots.byte_array_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.byte_array_id, name="byte_array_id", curie=FLUXNOVA_BPM_RUNTIME.curie('byte_array_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.byte_array_id, domain=None, range=Optional[str])

slots.cached_entity_state = Slot(uri=FLUXNOVA_BPM_RUNTIME.cached_entity_state, name="cached_entity_state", curie=FLUXNOVA_BPM_RUNTIME.curie('cached_entity_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.cached_entity_state, domain=None, range=Optional[int])

slots.case_definition_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.case_definition_id, name="case_definition_id", curie=FLUXNOVA_BPM_RUNTIME.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, domain=None, range=Optional[str])

slots.case_execution_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.case_execution_id, name="case_execution_id", curie=FLUXNOVA_BPM_RUNTIME.curie('case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, domain=None, range=Optional[str])

slots.case_instance_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.case_instance_id, name="case_instance_id", curie=FLUXNOVA_BPM_RUNTIME.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, domain=None, range=Optional[str])

slots.cause_incident_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.cause_incident_id, name="cause_incident_id", curie=FLUXNOVA_BPM_RUNTIME.curie('cause_incident_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.cause_incident_id, domain=None, range=Optional[str])

slots.configuration = Slot(uri=FLUXNOVA_BPM_RUNTIME.configuration, name="configuration", curie=FLUXNOVA_BPM_RUNTIME.curie('configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.configuration, domain=None, range=Optional[str])

slots.created = Slot(uri=FLUXNOVA_BPM_RUNTIME.created, name="created", curie=FLUXNOVA_BPM_RUNTIME.curie('created'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.created, domain=None, range=Union[str, XSDDateTime])

slots.current_state = Slot(uri=FLUXNOVA_BPM_RUNTIME.current_state, name="current_state", curie=FLUXNOVA_BPM_RUNTIME.curie('current_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.current_state, domain=None, range=Optional[int])

slots.delegation_state = Slot(uri=FLUXNOVA_BPM_RUNTIME.delegation_state, name="delegation_state", curie=FLUXNOVA_BPM_RUNTIME.curie('delegation_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.delegation_state, domain=None, range=Optional[Union[str, "DelegationState"]])

slots.description = Slot(uri=SCHEMA.description, name="description", curie=SCHEMA.curie('description'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.description, domain=None, range=Optional[str])

slots.double_value = Slot(uri=FLUXNOVA_BPM_RUNTIME.double_value, name="double_value", curie=FLUXNOVA_BPM_RUNTIME.curie('double_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.double_value, domain=None, range=Optional[float])

slots.due_date = Slot(uri=FLUXNOVA_BPM_RUNTIME.due_date, name="due_date", curie=FLUXNOVA_BPM_RUNTIME.curie('due_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.due_date, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.error_details_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.error_details_id, name="error_details_id", curie=FLUXNOVA_BPM_RUNTIME.curie('error_details_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.error_details_id, domain=None, range=Optional[str])

slots.error_message = Slot(uri=FLUXNOVA_BPM_RUNTIME.error_message, name="error_message", curie=FLUXNOVA_BPM_RUNTIME.curie('error_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.error_message, domain=None, range=Optional[str])

slots.event_name = Slot(uri=FLUXNOVA_BPM_RUNTIME.event_name, name="event_name", curie=FLUXNOVA_BPM_RUNTIME.curie('event_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_name, domain=None, range=Optional[str])

slots.event_type = Slot(uri=FLUXNOVA_BPM_RUNTIME.event_type, name="event_type", curie=FLUXNOVA_BPM_RUNTIME.curie('event_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_type, domain=None, range=str)

slots.execution_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.execution_id, name="execution_id", curie=FLUXNOVA_BPM_RUNTIME.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.execution_id, domain=None, range=Optional[str])

slots.failed_activity_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.failed_activity_id, name="failed_activity_id", curie=FLUXNOVA_BPM_RUNTIME.curie('failed_activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.failed_activity_id, domain=None, range=Optional[str])

slots.follow_up_date = Slot(uri=FLUXNOVA_BPM_RUNTIME.follow_up_date, name="follow_up_date", curie=FLUXNOVA_BPM_RUNTIME.curie('follow_up_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.follow_up_date, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.incident_message = Slot(uri=FLUXNOVA_BPM_RUNTIME.incident_message, name="incident_message", curie=FLUXNOVA_BPM_RUNTIME.curie('incident_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incident_message, domain=None, range=Optional[str])

slots.incident_timestamp = Slot(uri=FLUXNOVA_BPM_RUNTIME.incident_timestamp, name="incident_timestamp", curie=FLUXNOVA_BPM_RUNTIME.curie('incident_timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incident_timestamp, domain=None, range=Union[str, XSDDateTime])

slots.incident_type = Slot(uri=FLUXNOVA_BPM_RUNTIME.incident_type, name="incident_type", curie=FLUXNOVA_BPM_RUNTIME.curie('incident_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incident_type, domain=None, range=str)

slots.is_active = Slot(uri=FLUXNOVA_BPM_RUNTIME.is_active, name="is_active", curie=FLUXNOVA_BPM_RUNTIME.curie('is_active'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_active, domain=None, range=Optional[Union[bool, Bool]])

slots.is_concurrent = Slot(uri=FLUXNOVA_BPM_RUNTIME.is_concurrent, name="is_concurrent", curie=FLUXNOVA_BPM_RUNTIME.curie('is_concurrent'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_concurrent, domain=None, range=Optional[Union[bool, Bool]])

slots.is_concurrent_local = Slot(uri=FLUXNOVA_BPM_RUNTIME.is_concurrent_local, name="is_concurrent_local", curie=FLUXNOVA_BPM_RUNTIME.curie('is_concurrent_local'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_concurrent_local, domain=None, range=Optional[Union[bool, Bool]])

slots.is_event_scope = Slot(uri=FLUXNOVA_BPM_RUNTIME.is_event_scope, name="is_event_scope", curie=FLUXNOVA_BPM_RUNTIME.curie('is_event_scope'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_event_scope, domain=None, range=Optional[Union[bool, Bool]])

slots.is_required = Slot(uri=FLUXNOVA_BPM_RUNTIME.is_required, name="is_required", curie=FLUXNOVA_BPM_RUNTIME.curie('is_required'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_required, domain=None, range=Optional[Union[bool, Bool]])

slots.is_satisfied = Slot(uri=FLUXNOVA_BPM_RUNTIME.is_satisfied, name="is_satisfied", curie=FLUXNOVA_BPM_RUNTIME.curie('is_satisfied'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_satisfied, domain=None, range=Optional[Union[bool, Bool]])

slots.is_scope = Slot(uri=FLUXNOVA_BPM_RUNTIME.is_scope, name="is_scope", curie=FLUXNOVA_BPM_RUNTIME.curie('is_scope'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_scope, domain=None, range=Optional[Union[bool, Bool]])

slots.job_definition_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.job_definition_id, name="job_definition_id", curie=FLUXNOVA_BPM_RUNTIME.curie('job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_definition_id, domain=None, range=Optional[str])

slots.last_failure_log_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.last_failure_log_id, name="last_failure_log_id", curie=FLUXNOVA_BPM_RUNTIME.curie('last_failure_log_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.last_failure_log_id, domain=None, range=Optional[str])

slots.last_updated = Slot(uri=FLUXNOVA_BPM_RUNTIME.last_updated, name="last_updated", curie=FLUXNOVA_BPM_RUNTIME.curie('last_updated'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.last_updated, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.lock_expiration_time = Slot(uri=FLUXNOVA_BPM_RUNTIME.lock_expiration_time, name="lock_expiration_time", curie=FLUXNOVA_BPM_RUNTIME.curie('lock_expiration_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.lock_expiration_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.long_value = Slot(uri=FLUXNOVA_BPM_RUNTIME.long_value, name="long_value", curie=FLUXNOVA_BPM_RUNTIME.curie('long_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.long_value, domain=None, range=Optional[int])

slots.owner = Slot(uri=FLUXNOVA_BPM_RUNTIME.owner, name="owner", curie=FLUXNOVA_BPM_RUNTIME.curie('owner'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.owner, domain=None, range=Optional[str])

slots.parent_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.parent_id, name="parent_id", curie=FLUXNOVA_BPM_RUNTIME.curie('parent_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.parent_id, domain=None, range=Optional[str])

slots.parent_task_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.parent_task_id, name="parent_task_id", curie=FLUXNOVA_BPM_RUNTIME.curie('parent_task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.parent_task_id, domain=None, range=Optional[str])

slots.previous_state = Slot(uri=FLUXNOVA_BPM_RUNTIME.previous_state, name="previous_state", curie=FLUXNOVA_BPM_RUNTIME.curie('previous_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.previous_state, domain=None, range=Optional[int])

slots.priority = Slot(uri=FLUXNOVA_BPM_RUNTIME.priority, name="priority", curie=FLUXNOVA_BPM_RUNTIME.curie('priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.priority, domain=None, range=int)

slots.process_definition_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.process_definition_id, name="process_definition_id", curie=FLUXNOVA_BPM_RUNTIME.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, domain=None, range=Optional[str])

slots.process_definition_key = Slot(uri=FLUXNOVA_BPM_RUNTIME.process_definition_key, name="process_definition_key", curie=FLUXNOVA_BPM_RUNTIME.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, domain=None, range=Optional[str])

slots.process_instance_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.process_instance_id, name="process_instance_id", curie=FLUXNOVA_BPM_RUNTIME.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, domain=None, range=Optional[str])

slots.retries = Slot(uri=FLUXNOVA_BPM_RUNTIME.retries, name="retries", curie=FLUXNOVA_BPM_RUNTIME.curie('retries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.retries, domain=None, range=Optional[int])

slots.root_cause_incident_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.root_cause_incident_id, name="root_cause_incident_id", curie=FLUXNOVA_BPM_RUNTIME.curie('root_cause_incident_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.root_cause_incident_id, domain=None, range=Optional[str])

slots.sentry_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.sentry_id, name="sentry_id", curie=FLUXNOVA_BPM_RUNTIME.curie('sentry_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.sentry_id, domain=None, range=Optional[str])

slots.sequence_counter = Slot(uri=FLUXNOVA_BPM_RUNTIME.sequence_counter, name="sequence_counter", curie=FLUXNOVA_BPM_RUNTIME.curie('sequence_counter'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.sequence_counter, domain=None, range=Optional[int])

slots.source_case_execution_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.source_case_execution_id, name="source_case_execution_id", curie=FLUXNOVA_BPM_RUNTIME.curie('source_case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.source_case_execution_id, domain=None, range=Optional[str])

slots.standard_event = Slot(uri=FLUXNOVA_BPM_RUNTIME.standard_event, name="standard_event", curie=FLUXNOVA_BPM_RUNTIME.curie('standard_event'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.standard_event, domain=None, range=Optional[str])

slots.super_case_execution_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.super_case_execution_id, name="super_case_execution_id", curie=FLUXNOVA_BPM_RUNTIME.curie('super_case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.super_case_execution_id, domain=None, range=Optional[str])

slots.super_execution_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.super_execution_id, name="super_execution_id", curie=FLUXNOVA_BPM_RUNTIME.curie('super_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.super_execution_id, domain=None, range=Optional[str])

slots.task_definition_key = Slot(uri=FLUXNOVA_BPM_RUNTIME.task_definition_key, name="task_definition_key", curie=FLUXNOVA_BPM_RUNTIME.curie('task_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.task_definition_key, domain=None, range=Optional[str])

slots.task_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.task_id, name="task_id", curie=FLUXNOVA_BPM_RUNTIME.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.task_id, domain=None, range=Optional[str])

slots.task_state = Slot(uri=FLUXNOVA_BPM_RUNTIME.task_state, name="task_state", curie=FLUXNOVA_BPM_RUNTIME.curie('task_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.task_state, domain=None, range=Optional[str])

slots.text2_value = Slot(uri=FLUXNOVA_BPM_RUNTIME.text2_value, name="text2_value", curie=FLUXNOVA_BPM_RUNTIME.curie('text2_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.text2_value, domain=None, range=Optional[str])

slots.text_value = Slot(uri=FLUXNOVA_BPM_RUNTIME.text_value, name="text_value", curie=FLUXNOVA_BPM_RUNTIME.curie('text_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.text_value, domain=None, range=Optional[str])

slots.topic_name = Slot(uri=FLUXNOVA_BPM_RUNTIME.topic_name, name="topic_name", curie=FLUXNOVA_BPM_RUNTIME.curie('topic_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.topic_name, domain=None, range=Optional[str])

slots.variable_event = Slot(uri=FLUXNOVA_BPM_RUNTIME.variable_event, name="variable_event", curie=FLUXNOVA_BPM_RUNTIME.curie('variable_event'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_event, domain=None, range=Optional[str])

slots.variable_name = Slot(uri=FLUXNOVA_BPM_RUNTIME.variable_name, name="variable_name", curie=FLUXNOVA_BPM_RUNTIME.curie('variable_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_name, domain=None, range=Optional[str])

slots.variable_scope_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.variable_scope_id, name="variable_scope_id", curie=FLUXNOVA_BPM_RUNTIME.curie('variable_scope_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_scope_id, domain=None, range=str)

slots.worker_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.worker_id, name="worker_id", curie=FLUXNOVA_BPM_RUNTIME.curie('worker_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.worker_id, domain=None, range=Optional[str])

slots.definitions = Slot(uri=FLUXNOVA_BPMN_MODEL.definitions, name="definitions", curie=FLUXNOVA_BPMN_MODEL.curie('definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.definitions, domain=None, range=Optional[Union[str, DefinitionsId]])

slots.x = Slot(uri=FLUXNOVA_BPMN_MODEL_DC.x, name="x", curie=FLUXNOVA_BPMN_MODEL_DC.curie('x'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.x, domain=None, range=Optional[float])

slots.y = Slot(uri=FLUXNOVA_BPMN_MODEL_DC.y, name="y", curie=FLUXNOVA_BPMN_MODEL_DC.curie('y'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.y, domain=None, range=Optional[float])

slots.width = Slot(uri=FLUXNOVA_BPMN_MODEL_DC.width, name="width", curie=FLUXNOVA_BPMN_MODEL_DC.curie('width'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.width, domain=None, range=Optional[float])

slots.height = Slot(uri=FLUXNOVA_BPMN_MODEL_DC.height, name="height", curie=FLUXNOVA_BPMN_MODEL_DC.curie('height'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.height, domain=None, range=Optional[float])

slots.size = Slot(uri=FLUXNOVA_BPMN_MODEL_DC.size, name="size", curie=FLUXNOVA_BPMN_MODEL_DC.curie('size'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.size, domain=None, range=Optional[float])

slots.bold = Slot(uri=FLUXNOVA_BPMN_MODEL_DC.bold, name="bold", curie=FLUXNOVA_BPMN_MODEL_DC.curie('bold'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bold, domain=None, range=Optional[Union[bool, Bool]])

slots.italic = Slot(uri=FLUXNOVA_BPMN_MODEL_DC.italic, name="italic", curie=FLUXNOVA_BPMN_MODEL_DC.curie('italic'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.italic, domain=None, range=Optional[Union[bool, Bool]])

slots.underline = Slot(uri=FLUXNOVA_BPMN_MODEL_DC.underline, name="underline", curie=FLUXNOVA_BPMN_MODEL_DC.curie('underline'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.underline, domain=None, range=Optional[Union[bool, Bool]])

slots.strike_through = Slot(uri=FLUXNOVA_BPMN_MODEL_DC.strike_through, name="strike_through", curie=FLUXNOVA_BPMN_MODEL_DC.curie('strike_through'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.strike_through, domain=None, range=Optional[Union[bool, Bool]])

slots.documentation = Slot(uri=FLUXNOVA_BPMN_MODEL_DI.documentation, name="documentation", curie=FLUXNOVA_BPMN_MODEL_DI.curie('documentation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.documentation, domain=None, range=Optional[str])

slots.resolution = Slot(uri=FLUXNOVA_BPMN_MODEL_DI.resolution, name="resolution", curie=FLUXNOVA_BPMN_MODEL_DI.curie('resolution'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resolution, domain=None, range=Optional[float])

slots.extension = Slot(uri=FLUXNOVA_BPMN_MODEL_DI.extension, name="extension", curie=FLUXNOVA_BPMN_MODEL_DI.curie('extension'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.extension, domain=None, range=Optional[Union[dict, Extension]])

slots.waypoints = Slot(uri=FLUXNOVA_BPMN_MODEL_DI.waypoints, name="waypoints", curie=FLUXNOVA_BPMN_MODEL_DI.curie('waypoints'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.waypoints, domain=None, range=Optional[Union[Union[dict, Waypoint], list[Union[dict, Waypoint]]]])

slots.bounds = Slot(uri=FLUXNOVA_BPMN_MODEL_DI.bounds, name="bounds", curie=FLUXNOVA_BPMN_MODEL_DI.curie('bounds'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bounds, domain=None, range=Optional[Union[dict, Bounds]])

slots.diagram_elements = Slot(uri=FLUXNOVA_BPMN_MODEL_DI.diagram_elements, name="diagram_elements", curie=FLUXNOVA_BPMN_MODEL_DI.curie('diagram_elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diagram_elements, domain=None, range=Optional[Union[dict[Union[str, DiagramElementId], Union[dict, DiagramElement]], list[Union[dict, DiagramElement]]]])

slots.for_compensation = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.for_compensation, name="for_compensation", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('for_compensation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.for_compensation, domain=None, range=Optional[Union[bool, Bool]])

slots.start_quantity = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.start_quantity, name="start_quantity", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('start_quantity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.start_quantity, domain=None, range=Optional[int])

slots.completion_quantity = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.completion_quantity, name="completion_quantity", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('completion_quantity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.completion_quantity, domain=None, range=Optional[int])

slots.default = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.default, name="default", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('default'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.default, domain=None, range=Optional[Union[str, SequenceFlowId]])

slots.io_specification = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.io_specification, name="io_specification", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('io_specification'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.io_specification, domain=None, range=Optional[Union[str, IoSpecificationId]])

slots.data_input_associations = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.data_input_associations, name="data_input_associations", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('data_input_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.data_input_associations, domain=None, range=Optional[Union[dict[Union[str, DataInputAssociationId], Union[dict, DataInputAssociation]], list[Union[dict, DataInputAssociation]]]])

slots.data_output_associations = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.data_output_associations, name="data_output_associations", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('data_output_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.data_output_associations, domain=None, range=Optional[Union[dict[Union[str, DataOutputAssociationId], Union[dict, DataOutputAssociation]], list[Union[dict, DataOutputAssociation]]]])

slots.resource_roles = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.resource_roles, name="resource_roles", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('resource_roles'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_roles, domain=None, range=Optional[Union[dict[Union[str, ResourceRoleId], Union[dict, ResourceRole]], list[Union[dict, ResourceRole]]]])

slots.loop_characteristics = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.loop_characteristics, name="loop_characteristics", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('loop_characteristics'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.loop_characteristics, domain=None, range=Optional[Union[str, LoopCharacteristicsId]])

slots.from_ = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.from_, name="from_", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('from_'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.from_, domain=None, range=Optional[str])

slots.to_ = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.to_, name="to_", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('to_'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.to_, domain=None, range=Optional[str])

slots.target = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.target, name="target", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.target, domain=None, range=Optional[Union[str, BaseElementId]])

slots.association_direction = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.association_direction, name="association_direction", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('association_direction'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.association_direction, domain=None, range=Optional[str])

slots.documentations = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.documentations, name="documentations", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('documentations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.documentations, domain=None, range=Optional[Union[dict[Union[str, DocumentationId], Union[dict, Documentation]], list[Union[dict, Documentation]]]])

slots.extension_elements = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.extension_elements, name="extension_elements", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('extension_elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.extension_elements, domain=None, range=Optional[Union[dict, ExtensionElements]])

slots.diagram_element = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.diagram_element, name="diagram_element", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('diagram_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diagram_element, domain=None, range=Optional[Union[str, DiagramElementId]])

slots.attached_to = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.attached_to, name="attached_to", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('attached_to'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.attached_to, domain=None, range=Optional[Union[str, ActivityId]])

slots.scope = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.scope, name="scope", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('scope'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.scope, domain=None, range=Optional[Union[bool, Bool]])

slots.implementation = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.implementation, name="implementation", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('implementation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.implementation, domain=None, range=Optional[str])

slots.fluxnova_class = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_class, name="fluxnova_class", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_class, domain=None, range=Optional[str])

slots.fluxnova_delegate_expression = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_delegate_expression, name="fluxnova_delegate_expression", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_delegate_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_delegate_expression, domain=None, range=Optional[str])

slots.fluxnova_expression = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_expression, name="fluxnova_expression", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, domain=None, range=Optional[str])

slots.fluxnova_result_variable = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_result_variable, name="fluxnova_result_variable", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_result_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_result_variable, domain=None, range=Optional[str])

slots.fluxnova_type = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_type, name="fluxnova_type", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_type, domain=None, range=Optional[str])

slots.fluxnova_topic = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_topic, name="fluxnova_topic", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_topic'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_topic, domain=None, range=Optional[str])

slots.fluxnova_decision_ref = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_decision_ref, name="fluxnova_decision_ref", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_decision_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref, domain=None, range=Optional[str])

slots.fluxnova_decision_ref_binding = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_decision_ref_binding, name="fluxnova_decision_ref_binding", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_decision_ref_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref_binding, domain=None, range=Optional[str])

slots.fluxnova_decision_ref_version = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_decision_ref_version, name="fluxnova_decision_ref_version", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_decision_ref_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref_version, domain=None, range=Optional[str])

slots.fluxnova_decision_ref_version_tag = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_decision_ref_version_tag, name="fluxnova_decision_ref_version_tag", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_decision_ref_version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref_version_tag, domain=None, range=Optional[str])

slots.fluxnova_decision_ref_tenant_id = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_decision_ref_tenant_id, name="fluxnova_decision_ref_tenant_id", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_decision_ref_tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref_tenant_id, domain=None, range=Optional[str])

slots.fluxnova_map_decision_result = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_map_decision_result, name="fluxnova_map_decision_result", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_map_decision_result'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_map_decision_result, domain=None, range=Optional[str])

slots.fluxnova_task_priority = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_task_priority, name="fluxnova_task_priority", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_task_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_task_priority, domain=None, range=Optional[str])

slots.called_element = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.called_element, name="called_element", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('called_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.called_element, domain=None, range=Optional[str])

slots.fluxnova_async = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_async, name="fluxnova_async", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_async'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_called_element_binding = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_called_element_binding, name="fluxnova_called_element_binding", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_called_element_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_called_element_binding, domain=None, range=Optional[str])

slots.fluxnova_called_element_version = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_called_element_version, name="fluxnova_called_element_version", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_called_element_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_called_element_version, domain=None, range=Optional[str])

slots.fluxnova_called_element_version_tag = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_called_element_version_tag, name="fluxnova_called_element_version_tag", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_called_element_version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_called_element_version_tag, domain=None, range=Optional[str])

slots.fluxnova_case_ref = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_case_ref, name="fluxnova_case_ref", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_case_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_case_ref, domain=None, range=Optional[str])

slots.fluxnova_case_binding = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_case_binding, name="fluxnova_case_binding", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_case_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_case_binding, domain=None, range=Optional[str])

slots.fluxnova_case_version = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_case_version, name="fluxnova_case_version", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_case_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_case_version, domain=None, range=Optional[str])

slots.fluxnova_called_element_tenant_id = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_called_element_tenant_id, name="fluxnova_called_element_tenant_id", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_called_element_tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_called_element_tenant_id, domain=None, range=Optional[str])

slots.fluxnova_case_tenant_id = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_case_tenant_id, name="fluxnova_case_tenant_id", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_case_tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_case_tenant_id, domain=None, range=Optional[str])

slots.fluxnova_variable_mapping_class = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_variable_mapping_class, name="fluxnova_variable_mapping_class", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_variable_mapping_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable_mapping_class, domain=None, range=Optional[str])

slots.fluxnova_variable_mapping_delegate_expression = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_variable_mapping_delegate_expression, name="fluxnova_variable_mapping_delegate_expression", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_variable_mapping_delegate_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable_mapping_delegate_expression, domain=None, range=Optional[str])

slots.called_collaboration = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.called_collaboration, name="called_collaboration", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('called_collaboration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.called_collaboration, domain=None, range=Optional[Union[str, GlobalConversationId]])

slots.participant_associations = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.participant_associations, name="participant_associations", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('participant_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.participant_associations, domain=None, range=Optional[Union[dict[Union[str, ParticipantAssociationId], Union[dict, ParticipantAssociation]], list[Union[dict, ParticipantAssociation]]]])

slots.supported_interfaces = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.supported_interfaces, name="supported_interfaces", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('supported_interfaces'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.supported_interfaces, domain=None, range=Optional[Union[dict[Union[str, InterfaceId], Union[dict, Interface]], list[Union[dict, Interface]]]])

slots.io_bindings = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.io_bindings, name="io_bindings", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('io_bindings'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.io_bindings, domain=None, range=Optional[Union[dict[Union[str, IoBindingId], Union[dict, IoBinding]], list[Union[dict, IoBinding]]]])

slots.parallel_multiple = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.parallel_multiple, name="parallel_multiple", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('parallel_multiple'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.parallel_multiple, domain=None, range=Optional[Union[bool, Bool]])

slots.data_outputs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.data_outputs, name="data_outputs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('data_outputs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.data_outputs, domain=None, range=Optional[Union[dict[Union[str, DataOutputId], Union[dict, DataOutput]], list[Union[dict, DataOutput]]]])

slots.output_set = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.output_set, name="output_set", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('output_set'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.output_set, domain=None, range=Optional[Union[str, OutputSetId]])

slots.event_definitions = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.event_definitions, name="event_definitions", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('event_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_definitions, domain=None, range=Optional[Union[dict[Union[str, EventDefinitionId], Union[dict, EventDefinition]], list[Union[dict, EventDefinition]]]])

slots.event_definition_refs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.event_definition_refs, name="event_definition_refs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('event_definition_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_definition_refs, domain=None, range=Optional[Union[dict[Union[str, EventDefinitionId], Union[dict, EventDefinition]], list[Union[dict, EventDefinition]]]])

slots.category_values = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.category_values, name="category_values", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('category_values'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.category_values, domain=None, range=Optional[Union[dict[Union[str, CategoryValueId], Union[dict, CategoryValue]], list[Union[dict, CategoryValue]]]])

slots.closed = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.closed, name="closed", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('closed'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.closed, domain=None, range=Optional[Union[bool, Bool]])

slots.participants = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.participants, name="participants", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('participants'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.participants, domain=None, range=Optional[Union[dict[Union[str, ParticipantId], Union[dict, Participant]], list[Union[dict, Participant]]]])

slots.message_flows = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.message_flows, name="message_flows", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('message_flows'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.message_flows, domain=None, range=Optional[Union[dict[Union[str, MessageFlowId], Union[dict, MessageFlow]], list[Union[dict, MessageFlow]]]])

slots.artifacts = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.artifacts, name="artifacts", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('artifacts'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.artifacts, domain=None, range=Optional[Union[dict[Union[str, ArtifactId], Union[dict, Artifact]], list[Union[dict, Artifact]]]])

slots.conversation_nodes = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.conversation_nodes, name="conversation_nodes", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('conversation_nodes'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.conversation_nodes, domain=None, range=Optional[Union[dict[Union[str, ConversationNodeId], Union[dict, ConversationNode]], list[Union[dict, ConversationNode]]]])

slots.conversation_associations = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.conversation_associations, name="conversation_associations", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('conversation_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.conversation_associations, domain=None, range=Optional[Union[dict[Union[str, ConversationAssociationId], Union[dict, ConversationAssociation]], list[Union[dict, ConversationAssociation]]]])

slots.message_flow_associations = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.message_flow_associations, name="message_flow_associations", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('message_flow_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.message_flow_associations, domain=None, range=Optional[Union[dict[Union[str, MessageFlowAssociationId], Union[dict, MessageFlowAssociation]], list[Union[dict, MessageFlowAssociation]]]])

slots.correlation_keys = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.correlation_keys, name="correlation_keys", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('correlation_keys'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.correlation_keys, domain=None, range=Optional[Union[dict[Union[str, CorrelationKeyId], Union[dict, CorrelationKey]], list[Union[dict, CorrelationKey]]]])

slots.conversation_links = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.conversation_links, name="conversation_links", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('conversation_links'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.conversation_links, domain=None, range=Optional[Union[dict[Union[str, ConversationLinkId], Union[dict, ConversationLink]], list[Union[dict, ConversationLink]]]])

slots.wait_for_completion = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.wait_for_completion, name="wait_for_completion", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('wait_for_completion'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.wait_for_completion, domain=None, range=Optional[Union[bool, Bool]])

slots.activity = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.activity, name="activity", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('activity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity, domain=None, range=Optional[Union[str, ActivityId]])

slots.activation_condition = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.activation_condition, name="activation_condition", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('activation_condition'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activation_condition, domain=None, range=Optional[Union[str, ActivationConditionId]])

slots.fluxnova_resource = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_resource, name="fluxnova_resource", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_resource'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_resource, domain=None, range=Optional[str])

slots.condition = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.condition, name="condition", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('condition'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.condition, domain=None, range=Optional[Union[str, ConditionId]])

slots.fluxnova_variable_name = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_variable_name, name="fluxnova_variable_name", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_variable_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable_name, domain=None, range=Optional[str])

slots.fluxnova_variable_events = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_variable_events, name="fluxnova_variable_events", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_variable_events'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable_events, domain=None, range=Optional[str])

slots.fluxnova_variable_events_list = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_variable_events_list, name="fluxnova_variable_events_list", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_variable_events_list'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable_events_list, domain=None, range=Optional[Union[str, list[str]]])

slots.inner_conversation_node = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.inner_conversation_node, name="inner_conversation_node", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('inner_conversation_node'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.inner_conversation_node, domain=None, range=Optional[Union[str, ConversationNodeId]])

slots.outer_conversation_node = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.outer_conversation_node, name="outer_conversation_node", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('outer_conversation_node'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.outer_conversation_node, domain=None, range=Optional[Union[str, ConversationNodeId]])

slots.correlation_properties = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.correlation_properties, name="correlation_properties", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('correlation_properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.correlation_properties, domain=None, range=Optional[Union[dict[Union[str, CorrelationPropertyId], Union[dict, CorrelationProperty]], list[Union[dict, CorrelationProperty]]]])

slots.correlation_property_retrieval_expressions = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.correlation_property_retrieval_expressions, name="correlation_property_retrieval_expressions", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('correlation_property_retrieval_expressions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.correlation_property_retrieval_expressions, domain=None, range=Optional[Union[dict[Union[str, CorrelationPropertyRetrievalExpressionId], Union[dict, CorrelationPropertyRetrievalExpression]], list[Union[dict, CorrelationPropertyRetrievalExpression]]]])

slots.correlation_property = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.correlation_property, name="correlation_property", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('correlation_property'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.correlation_property, domain=None, range=Optional[Union[str, CorrelationPropertyId]])

slots.data_path = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.data_path, name="data_path", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('data_path'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.data_path, domain=None, range=Optional[str])

slots.message_path = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.message_path, name="message_path", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('message_path'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.message_path, domain=None, range=Optional[str])

slots.correlation_key = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.correlation_key, name="correlation_key", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('correlation_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.correlation_key, domain=None, range=Optional[Union[str, CorrelationKeyId]])

slots.correlation_property_bindings = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.correlation_property_bindings, name="correlation_property_bindings", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('correlation_property_bindings'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.correlation_property_bindings, domain=None, range=Optional[Union[dict[Union[str, CorrelationPropertyBindingId], Union[dict, CorrelationPropertyBinding]], list[Union[dict, CorrelationPropertyBinding]]]])

slots.sources = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.sources, name="sources", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('sources'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.sources, domain=None, range=Optional[Union[dict[Union[str, ItemAwareElementId], Union[dict, ItemAwareElement]], list[Union[dict, ItemAwareElement]]]])

slots.transformation = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.transformation, name="transformation", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('transformation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.transformation, domain=None, range=Optional[Union[str, FormalExpressionId]])

slots.assignments = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.assignments, name="assignments", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('assignments'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.assignments, domain=None, range=Optional[Union[dict[Union[str, AssignmentId], Union[dict, Assignment]], list[Union[dict, Assignment]]]])

slots.collection = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.collection, name="collection", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('collection'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.collection, domain=None, range=Optional[Union[bool, Bool]])

slots.data_object = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.data_object, name="data_object", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('data_object'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.data_object, domain=None, range=Optional[Union[str, DataObjectId]])

slots.capacity = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.capacity, name="capacity", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('capacity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.capacity, domain=None, range=Optional[int])

slots.unlimited = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.unlimited, name="unlimited", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('unlimited'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.unlimited, domain=None, range=Optional[Union[bool, Bool]])

slots.data_store = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.data_store, name="data_store", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('data_store'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.data_store, domain=None, range=Optional[Union[str, DataStoreId]])

slots.target_namespace = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.target_namespace, name="target_namespace", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('target_namespace'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.target_namespace, domain=None, range=Optional[str])

slots.expression_language = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.expression_language, name="expression_language", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('expression_language'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.expression_language, domain=None, range=Optional[str])

slots.type_language = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.type_language, name="type_language", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('type_language'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.type_language, domain=None, range=Optional[str])

slots.exporter = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.exporter, name="exporter", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('exporter'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.exporter, domain=None, range=Optional[str])

slots.exporter_version = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.exporter_version, name="exporter_version", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('exporter_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.exporter_version, domain=None, range=Optional[str])

slots.imports = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.imports, name="imports", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('imports'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.imports, domain=None, range=Optional[Union[Union[dict, Import], list[Union[dict, Import]]]])

slots.extensions = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.extensions, name="extensions", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('extensions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.extensions, domain=None, range=Optional[Union[Union[dict, Extension], list[Union[dict, Extension]]]])

slots.root_elements = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.root_elements, name="root_elements", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('root_elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.root_elements, domain=None, range=Optional[Union[dict[Union[str, RootElementId], Union[dict, RootElement]], list[Union[dict, RootElement]]]])

slots.bpm_diagrams = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.bpm_diagrams, name="bpm_diagrams", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('bpm_diagrams'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpm_diagrams, domain=None, range=Optional[Union[str, list[str]]])

slots.relationships = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.relationships, name="relationships", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('relationships'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.relationships, domain=None, range=Optional[Union[dict[Union[str, RelationshipId], Union[dict, Relationship]], list[Union[dict, Relationship]]]])

slots.text_format = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.text_format, name="text_format", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('text_format'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.text_format, domain=None, range=Optional[str])

slots.error_code = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.error_code, name="error_code", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('error_code'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.error_code, domain=None, range=Optional[str])

slots.fluxnova_error_message = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_error_message, name="fluxnova_error_message", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_error_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_error_message, domain=None, range=Optional[str])

slots.structure = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.structure, name="structure", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('structure'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.structure, domain=None, range=Optional[Union[str, ItemDefinitionId]])

slots.error = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.error, name="error", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('error'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.error, domain=None, range=Optional[Union[str, ErrorId]])

slots.fluxnova_error_code_variable = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_error_code_variable, name="fluxnova_error_code_variable", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_error_code_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_error_code_variable, domain=None, range=Optional[str])

slots.fluxnova_error_message_variable = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_error_message_variable, name="fluxnova_error_message_variable", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_error_message_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_error_message_variable, domain=None, range=Optional[str])

slots.escalation_code = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.escalation_code, name="escalation_code", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('escalation_code'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.escalation_code, domain=None, range=Optional[str])

slots.escalation = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.escalation, name="escalation", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('escalation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.escalation, domain=None, range=Optional[Union[str, EscalationId]])

slots.instantiate = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.instantiate, name="instantiate", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('instantiate'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.instantiate, domain=None, range=Optional[Union[bool, Bool]])

slots.event_gateway_type = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.event_gateway_type, name="event_gateway_type", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('event_gateway_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_gateway_type, domain=None, range=Optional[str])

slots.elements = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.elements, name="elements", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.elements, domain=None, range=Optional[Union[str, list[str]]])

slots.elements_query = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.elements_query, name="elements_query", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('elements_query'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.elements_query, domain=None, range=Optional[str])

slots.auditing = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.auditing, name="auditing", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('auditing'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.auditing, domain=None, range=Optional[Union[str, AuditingId]])

slots.monitoring = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.monitoring, name="monitoring", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('monitoring'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.monitoring, domain=None, range=Optional[Union[str, MonitoringId]])

slots.category_value_refs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.category_value_refs, name="category_value_refs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('category_value_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.category_value_refs, domain=None, range=Optional[Union[dict[Union[str, CategoryValueId], Union[dict, CategoryValue]], list[Union[dict, CategoryValue]]]])

slots.incoming = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.incoming, name="incoming", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('incoming'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incoming, domain=None, range=Optional[Union[dict[Union[str, SequenceFlowId], Union[dict, SequenceFlow]], list[Union[dict, SequenceFlow]]]])

slots.outgoing = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.outgoing, name="outgoing", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('outgoing'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.outgoing, domain=None, range=Optional[Union[dict[Union[str, SequenceFlowId], Union[dict, SequenceFlow]], list[Union[dict, SequenceFlow]]]])

slots.previous_nodes = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.previous_nodes, name="previous_nodes", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('previous_nodes'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.previous_nodes, domain=None, range=Optional[Union[str, FlowNodeId]])

slots.succeeding_nodes = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.succeeding_nodes, name="succeeding_nodes", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('succeeding_nodes'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.succeeding_nodes, domain=None, range=Optional[Union[str, FlowNodeId]])

slots.fluxnova_async_before = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_async_before, name="fluxnova_async_before", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_async_before'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async_before, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_async_after = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_async_after, name="fluxnova_async_after", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_async_after'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async_after, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_exclusive = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_exclusive, name="fluxnova_exclusive", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_exclusive'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_exclusive, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_job_priority = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_job_priority, name="fluxnova_job_priority", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_job_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_job_priority, domain=None, range=Optional[str])

slots.language = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.language, name="language", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('language'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.language, domain=None, range=Optional[str])

slots.evaluates_to_type = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.evaluates_to_type, name="evaluates_to_type", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('evaluates_to_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.evaluates_to_type, domain=None, range=Optional[Union[str, ItemDefinitionId]])

slots.gateway_direction = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.gateway_direction, name="gateway_direction", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('gateway_direction'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.gateway_direction, domain=None, range=Optional[str])

slots.namespace = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.namespace, name="namespace", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('namespace'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.namespace, domain=None, range=Optional[str])

slots.location = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.location, name="location", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('location'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.location, domain=None, range=Optional[str])

slots.import_type = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.import_type, name="import_type", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('import_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.import_type, domain=None, range=Optional[str])

slots.data_inputs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.data_inputs, name="data_inputs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('data_inputs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.data_inputs, domain=None, range=Optional[Union[dict[Union[str, DataInputId], Union[dict, DataInput]], list[Union[dict, DataInput]]]])

slots.optional_inputs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.optional_inputs, name="optional_inputs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('optional_inputs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.optional_inputs, domain=None, range=Optional[Union[dict[Union[str, DataInputId], Union[dict, DataInput]], list[Union[dict, DataInput]]]])

slots.while_executing_input = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.while_executing_input, name="while_executing_input", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('while_executing_input'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.while_executing_input, domain=None, range=Optional[Union[dict[Union[str, DataInputId], Union[dict, DataInput]], list[Union[dict, DataInput]]]])

slots.output_sets = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.output_sets, name="output_sets", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('output_sets'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.output_sets, domain=None, range=Optional[Union[dict[Union[str, OutputSetId], Union[dict, OutputSet]], list[Union[dict, OutputSet]]]])

slots.implementation_ref = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.implementation_ref, name="implementation_ref", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('implementation_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.implementation_ref, domain=None, range=Optional[str])

slots.operations = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.operations, name="operations", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('operations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.operations, domain=None, range=Optional[Union[dict[Union[str, OperationId], Union[dict, Operation]], list[Union[dict, Operation]]]])

slots.operation = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.operation, name="operation", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('operation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.operation, domain=None, range=Optional[Union[str, OperationId]])

slots.input_data = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.input_data, name="input_data", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('input_data'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.input_data, domain=None, range=Optional[Union[str, DataInputId]])

slots.output_data = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.output_data, name="output_data", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('output_data'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.output_data, domain=None, range=Optional[Union[str, DataOutputId]])

slots.input_sets = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.input_sets, name="input_sets", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('input_sets'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.input_sets, domain=None, range=Optional[Union[dict[Union[str, InputSetId], Union[dict, InputSet]], list[Union[dict, InputSet]]]])

slots.item_subject = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.item_subject, name="item_subject", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('item_subject'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.item_subject, domain=None, range=Optional[Union[str, ItemDefinitionId]])

slots.data_state = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.data_state, name="data_state", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('data_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.data_state, domain=None, range=Optional[Union[str, DataStateId]])

slots.structure_ref = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.structure_ref, name="structure_ref", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('structure_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.structure_ref, domain=None, range=Optional[str])

slots.item_kind = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.item_kind, name="item_kind", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('item_kind'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.item_kind, domain=None, range=Optional[str])

slots.partition_element = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.partition_element, name="partition_element", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('partition_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.partition_element, domain=None, range=Optional[str])

slots.partition_element_child = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.partition_element_child, name="partition_element_child", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('partition_element_child'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.partition_element_child, domain=None, range=Optional[str])

slots.flow_node_refs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.flow_node_refs, name="flow_node_refs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('flow_node_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.flow_node_refs, domain=None, range=Optional[Union[dict[Union[str, FlowNodeId], Union[dict, FlowNode]], list[Union[dict, FlowNode]]]])

slots.child_lane_set = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.child_lane_set, name="child_lane_set", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('child_lane_set'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.child_lane_set, domain=None, range=Optional[str])

slots.lanes = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.lanes, name="lanes", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('lanes'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.lanes, domain=None, range=Optional[Union[dict[Union[str, LaneId], Union[dict, Lane]], list[Union[dict, Lane]]]])

slots.item = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.item, name="item", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('item'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.item, domain=None, range=Optional[Union[str, ItemDefinitionId]])

slots.inner_message_flow = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.inner_message_flow, name="inner_message_flow", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('inner_message_flow'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.inner_message_flow, domain=None, range=Optional[Union[str, MessageFlowId]])

slots.outer_message_flow = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.outer_message_flow, name="outer_message_flow", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('outer_message_flow'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.outer_message_flow, domain=None, range=Optional[Union[str, MessageFlowId]])

slots.loop_cardinality = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.loop_cardinality, name="loop_cardinality", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('loop_cardinality'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.loop_cardinality, domain=None, range=Optional[Union[str, LoopCardinalityId]])

slots.loop_data_input_ref = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.loop_data_input_ref, name="loop_data_input_ref", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('loop_data_input_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.loop_data_input_ref, domain=None, range=Optional[Union[str, DataInputId]])

slots.loop_data_output_ref = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.loop_data_output_ref, name="loop_data_output_ref", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('loop_data_output_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.loop_data_output_ref, domain=None, range=Optional[Union[str, DataOutputId]])

slots.input_data_item = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.input_data_item, name="input_data_item", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('input_data_item'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.input_data_item, domain=None, range=Optional[Union[str, InputDataItemId]])

slots.output_data_item = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.output_data_item, name="output_data_item", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('output_data_item'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.output_data_item, domain=None, range=Optional[Union[str, OutputDataItemId]])

slots.complex_behavior_definitions = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.complex_behavior_definitions, name="complex_behavior_definitions", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('complex_behavior_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.complex_behavior_definitions, domain=None, range=Optional[Union[dict[Union[str, ComplexBehaviorDefinitionId], Union[dict, ComplexBehaviorDefinition]], list[Union[dict, ComplexBehaviorDefinition]]]])

slots.completion_condition = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.completion_condition, name="completion_condition", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('completion_condition'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.completion_condition, domain=None, range=Optional[Union[str, CompletionConditionId]])

slots.sequential = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.sequential, name="sequential", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('sequential'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.sequential, domain=None, range=Optional[Union[bool, Bool]])

slots.behavior = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.behavior, name="behavior", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('behavior'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.behavior, domain=None, range=Optional[str])

slots.one_behavior_event_ref = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.one_behavior_event_ref, name="one_behavior_event_ref", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('one_behavior_event_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.one_behavior_event_ref, domain=None, range=Optional[Union[str, EventDefinitionId]])

slots.none_behavior_event_ref = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.none_behavior_event_ref, name="none_behavior_event_ref", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('none_behavior_event_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.none_behavior_event_ref, domain=None, range=Optional[Union[str, EventDefinitionId]])

slots.fluxnova_collection = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_collection, name="fluxnova_collection", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_collection'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_collection, domain=None, range=Optional[str])

slots.fluxnova_element_variable = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_element_variable, name="fluxnova_element_variable", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_element_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_element_variable, domain=None, range=Optional[str])

slots.in_message = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.in_message, name="in_message", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('in_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.in_message, domain=None, range=Optional[Union[str, MessageId]])

slots.out_message = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.out_message, name="out_message", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('out_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.out_message, domain=None, range=Optional[Union[str, MessageId]])

slots.errors = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.errors, name="errors", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('errors'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.errors, domain=None, range=Optional[Union[dict[Union[str, ErrorId], Union[dict, Error]], list[Union[dict, Error]]]])

slots.data_output_refs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.data_output_refs, name="data_output_refs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('data_output_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.data_output_refs, domain=None, range=Optional[Union[dict[Union[str, DataOutputId], Union[dict, DataOutput]], list[Union[dict, DataOutput]]]])

slots.optional_output_refs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.optional_output_refs, name="optional_output_refs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('optional_output_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.optional_output_refs, domain=None, range=Optional[Union[dict[Union[str, DataOutputId], Union[dict, DataOutput]], list[Union[dict, DataOutput]]]])

slots.while_executing_output_refs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.while_executing_output_refs, name="while_executing_output_refs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('while_executing_output_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.while_executing_output_refs, domain=None, range=Optional[Union[dict[Union[str, DataOutputId], Union[dict, DataOutput]], list[Union[dict, DataOutput]]]])

slots.input_set_refs = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.input_set_refs, name="input_set_refs", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('input_set_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.input_set_refs, domain=None, range=Optional[Union[dict[Union[str, InputSetId], Union[dict, InputSet]], list[Union[dict, InputSet]]]])

slots.process = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.process, name="process", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('process'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process, domain=None, range=Optional[Union[str, ProcessId]])

slots.interfaces = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.interfaces, name="interfaces", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('interfaces'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.interfaces, domain=None, range=Optional[Union[dict[Union[str, InterfaceId], Union[dict, Interface]], list[Union[dict, Interface]]]])

slots.end_points = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.end_points, name="end_points", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('end_points'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.end_points, domain=None, range=Optional[Union[dict[Union[str, EndPointId], Union[dict, EndPoint]], list[Union[dict, EndPoint]]]])

slots.participant_multiplicity = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.participant_multiplicity, name="participant_multiplicity", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('participant_multiplicity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.participant_multiplicity, domain=None, range=Optional[Union[str, ParticipantMultiplicityId]])

slots.inner_participant = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.inner_participant, name="inner_participant", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('inner_participant'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.inner_participant, domain=None, range=Optional[Union[str, ParticipantId]])

slots.outer_participant = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.outer_participant, name="outer_participant", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('outer_participant'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.outer_participant, domain=None, range=Optional[Union[str, ParticipantId]])

slots.minimum = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.minimum, name="minimum", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('minimum'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.minimum, domain=None, range=Optional[int])

slots.maximum = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.maximum, name="maximum", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('maximum'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.maximum, domain=None, range=Optional[int])

slots.process_type = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.process_type, name="process_type", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('process_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process_type, domain=None, range=Optional[str])

slots.executable = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.executable, name="executable", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('executable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.executable, domain=None, range=Optional[Union[bool, Bool]])

slots.lane_sets = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.lane_sets, name="lane_sets", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('lane_sets'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.lane_sets, domain=None, range=Optional[Union[dict[Union[str, LaneSetId], Union[dict, LaneSet]], list[Union[dict, LaneSet]]]])

slots.flow_elements = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.flow_elements, name="flow_elements", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('flow_elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.flow_elements, domain=None, range=Optional[Union[dict[Union[str, FlowElementId], Union[dict, FlowElement]], list[Union[dict, FlowElement]]]])

slots.correlation_subscriptions = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.correlation_subscriptions, name="correlation_subscriptions", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('correlation_subscriptions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.correlation_subscriptions, domain=None, range=Optional[Union[dict[Union[str, CorrelationSubscriptionId], Union[dict, CorrelationSubscription]], list[Union[dict, CorrelationSubscription]]]])

slots.supports = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.supports, name="supports", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('supports'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.supports, domain=None, range=Optional[Union[dict[Union[str, ProcessId], Union[dict, Process]], list[Union[dict, Process]]]])

slots.fluxnova_candidate_starter_groups = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_candidate_starter_groups, name="fluxnova_candidate_starter_groups", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_candidate_starter_groups'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_starter_groups, domain=None, range=Optional[str])

slots.fluxnova_candidate_starter_groups_list = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_candidate_starter_groups_list, name="fluxnova_candidate_starter_groups_list", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_candidate_starter_groups_list'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_starter_groups_list, domain=None, range=Optional[Union[str, list[str]]])

slots.fluxnova_candidate_starter_users = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_candidate_starter_users, name="fluxnova_candidate_starter_users", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_candidate_starter_users'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_starter_users, domain=None, range=Optional[str])

slots.fluxnova_candidate_starter_users_list = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_candidate_starter_users_list, name="fluxnova_candidate_starter_users_list", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_candidate_starter_users_list'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_starter_users_list, domain=None, range=Optional[Union[str, list[str]]])

slots.fluxnova_history_time_to_live = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_history_time_to_live, name="fluxnova_history_time_to_live", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_history_time_to_live'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_history_time_to_live, domain=None, range=Optional[int])

slots.fluxnova_history_time_to_live_string = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_history_time_to_live_string, name="fluxnova_history_time_to_live_string", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_history_time_to_live_string'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_history_time_to_live_string, domain=None, range=Optional[str])

slots.fluxnova_startable_in_tasklist = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_startable_in_tasklist, name="fluxnova_startable_in_tasklist", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_startable_in_tasklist'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_startable_in_tasklist, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_version_tag = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_version_tag, name="fluxnova_version_tag", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_version_tag, domain=None, range=Optional[str])

slots.direction = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.direction, name="direction", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('direction'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.direction, domain=None, range=Optional[str])

slots.targets = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.targets, name="targets", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('targets'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.targets, domain=None, range=Optional[Union[str, list[str]]])

slots.resource_parameters = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.resource_parameters, name="resource_parameters", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('resource_parameters'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_parameters, domain=None, range=Optional[Union[dict[Union[str, ResourceParameterId], Union[dict, ResourceParameter]], list[Union[dict, ResourceParameter]]]])

slots.expression = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.expression, name="expression", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.expression, domain=None, range=Optional[Union[str, ExpressionId]])

slots.required = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.required, name="required", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('required'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.required, domain=None, range=Optional[Union[bool, Bool]])

slots.parameter = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.parameter, name="parameter", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('parameter'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.parameter, domain=None, range=Optional[Union[str, ResourceParameterId]])

slots.resource = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.resource, name="resource", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('resource'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource, domain=None, range=Optional[Union[str, ResourceId]])

slots.resource_parameter_binding = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.resource_parameter_binding, name="resource_parameter_binding", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('resource_parameter_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_parameter_binding, domain=None, range=Optional[Union[dict[Union[str, ResourceParameterBindingId], Union[dict, ResourceParameterBinding]], list[Union[dict, ResourceParameterBinding]]]])

slots.resource_assignment_expression = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.resource_assignment_expression, name="resource_assignment_expression", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('resource_assignment_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_assignment_expression, domain=None, range=Optional[Union[str, ResourceAssignmentExpressionId]])

slots.script_format = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.script_format, name="script_format", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('script_format'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.script_format, domain=None, range=Optional[str])

slots.script = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.script, name="script", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('script'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.script, domain=None, range=Optional[Union[dict, Script]])

slots.immediate = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.immediate, name="immediate", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('immediate'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.immediate, domain=None, range=Optional[Union[bool, Bool]])

slots.condition_expression = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.condition_expression, name="condition_expression", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('condition_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.condition_expression, domain=None, range=Optional[Union[str, ConditionExpressionId]])

slots.signal = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.signal, name="signal", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('signal'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.signal, domain=None, range=Optional[Union[str, SignalId]])

slots.interrupting = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.interrupting, name="interrupting", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('interrupting'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.interrupting, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_form_handler_class = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_form_handler_class, name="fluxnova_form_handler_class", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_form_handler_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_handler_class, domain=None, range=Optional[str])

slots.fluxnova_form_key = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_form_key, name="fluxnova_form_key", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_form_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_key, domain=None, range=Optional[str])

slots.fluxnova_form_ref = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_form_ref, name="fluxnova_form_ref", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_form_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_ref, domain=None, range=Optional[str])

slots.fluxnova_form_ref_binding = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_form_ref_binding, name="fluxnova_form_ref_binding", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_form_ref_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_ref_binding, domain=None, range=Optional[str])

slots.fluxnova_form_ref_version = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_form_ref_version, name="fluxnova_form_ref_version", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_form_ref_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_ref_version, domain=None, range=Optional[str])

slots.fluxnova_initiator = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_initiator, name="fluxnova_initiator", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_initiator'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_initiator, domain=None, range=Optional[str])

slots.text = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.text, name="text", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('text'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.text, domain=None, range=Optional[Union[dict, Text]])

slots.input_set = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.input_set, name="input_set", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('input_set'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.input_set, domain=None, range=Optional[Union[str, InputSetId]])

slots.time_date = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.time_date, name="time_date", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('time_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.time_date, domain=None, range=Optional[Union[str, TimeDateId]])

slots.time_duration = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.time_duration, name="time_duration", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('time_duration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.time_duration, domain=None, range=Optional[Union[str, TimeDurationId]])

slots.time_cycle = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.time_cycle, name="time_cycle", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('time_cycle'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.time_cycle, domain=None, range=Optional[Union[str, TimeCycleId]])

slots.method = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.method, name="method", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('method'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.method, domain=None, range=Optional[str])

slots.renderings = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.renderings, name="renderings", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('renderings'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.renderings, domain=None, range=Optional[Union[dict[Union[str, RenderingId], Union[dict, Rendering]], list[Union[dict, Rendering]]]])

slots.fluxnova_assignee = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_assignee, name="fluxnova_assignee", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_assignee'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_assignee, domain=None, range=Optional[str])

slots.fluxnova_candidate_groups = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_candidate_groups, name="fluxnova_candidate_groups", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_candidate_groups'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_groups, domain=None, range=Optional[str])

slots.fluxnova_candidate_groups_list = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_candidate_groups_list, name="fluxnova_candidate_groups_list", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_candidate_groups_list'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_groups_list, domain=None, range=Optional[Union[str, list[str]]])

slots.fluxnova_candidate_users = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_candidate_users, name="fluxnova_candidate_users", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_candidate_users'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_users, domain=None, range=Optional[str])

slots.fluxnova_candidate_users_list = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_candidate_users_list, name="fluxnova_candidate_users_list", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_candidate_users_list'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_users_list, domain=None, range=Optional[Union[str, list[str]]])

slots.fluxnova_due_date = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_due_date, name="fluxnova_due_date", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_due_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_due_date, domain=None, range=Optional[str])

slots.fluxnova_follow_up_date = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_follow_up_date, name="fluxnova_follow_up_date", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_follow_up_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_follow_up_date, domain=None, range=Optional[str])

slots.fluxnova_priority = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.fluxnova_priority, name="fluxnova_priority", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('fluxnova_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_priority, domain=None, range=Optional[str])

slots.bpmn_plane = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.bpmn_plane, name="bpmn_plane", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('bpmn_plane'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmn_plane, domain=None, range=Optional[Union[str, BpmnPlaneId]])

slots.bpmn_label_styles = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.bpmn_label_styles, name="bpmn_label_styles", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('bpmn_label_styles'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmn_label_styles, domain=None, range=Optional[Union[dict[Union[str, BpmnLabelStyleId], Union[dict, BpmnLabelStyle]], list[Union[dict, BpmnLabelStyle]]]])

slots.bpmn_element = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.bpmn_element, name="bpmn_element", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('bpmn_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmn_element, domain=None, range=Optional[str])

slots.source_element = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.source_element, name="source_element", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('source_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.source_element, domain=None, range=Optional[Union[str, DiagramElementId]])

slots.target_element = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.target_element, name="target_element", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('target_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.target_element, domain=None, range=Optional[Union[str, DiagramElementId]])

slots.message_visible_kind = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.message_visible_kind, name="message_visible_kind", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('message_visible_kind'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.message_visible_kind, domain=None, range=Optional[Union[str, "MessageVisibleKind"]])

slots.bpmn_label = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.bpmn_label, name="bpmn_label", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('bpmn_label'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmn_label, domain=None, range=Optional[Union[str, BpmnLabelId]])

slots.label_style = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.label_style, name="label_style", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('label_style'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.label_style, domain=None, range=Optional[Union[str, BpmnLabelStyleId]])

slots.font = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.font, name="font", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('font'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.font, domain=None, range=Optional[Union[dict, Font]])

slots.horizontal = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.horizontal, name="horizontal", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('horizontal'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.horizontal, domain=None, range=Optional[Union[bool, Bool]])

slots.expanded = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.expanded, name="expanded", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('expanded'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.expanded, domain=None, range=Optional[Union[bool, Bool]])

slots.marker_visible = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.marker_visible, name="marker_visible", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('marker_visible'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.marker_visible, domain=None, range=Optional[Union[bool, Bool]])

slots.message_visible = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.message_visible, name="message_visible", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('message_visible'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.message_visible, domain=None, range=Optional[Union[bool, Bool]])

slots.participant_band_kind = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.participant_band_kind, name="participant_band_kind", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('participant_band_kind'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.participant_band_kind, domain=None, range=Optional[Union[str, "ParticipantBandKind"]])

slots.choreography_activity_shape = Slot(uri=FLUXNOVA_BPMN_MODEL_BPMNDI.choreography_activity_shape, name="choreography_activity_shape", curie=FLUXNOVA_BPMN_MODEL_BPMNDI.curie('choreography_activity_shape'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.choreography_activity_shape, domain=None, range=Optional[Union[str, BpmnShapeId]])

slots.fluxnova_connector_id = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_connector_id, name="fluxnova_connector_id", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_connector_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_connector_id, domain=None, range=Optional[Union[dict, FluxnovaConnectorId]])

slots.fluxnova_input_output = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_input_output, name="fluxnova_input_output", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_input_output'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_input_output, domain=None, range=Optional[Union[dict, FluxnovaInputOutput]])

slots.fluxnova_name = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_name, name="fluxnova_name", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_name, domain=None, range=Optional[str])

slots.fluxnova_config = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_config, name="fluxnova_config", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_config'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_config, domain=None, range=Optional[str])

slots.fluxnova_key = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_key, name="fluxnova_key", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_key, domain=None, range=Optional[str])

slots.fluxnova_event = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_event, name="fluxnova_event", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_event'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_event, domain=None, range=Optional[str])

slots.fluxnova_fields = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_fields, name="fluxnova_fields", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_fields'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_fields, domain=None, range=Optional[Union[Union[dict, FluxnovaField], list[Union[dict, FluxnovaField]]]])

slots.fluxnova_script = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_script, name="fluxnova_script", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_script'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_script, domain=None, range=Optional[Union[dict, FluxnovaScript]])

slots.fluxnova_string_value = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_string_value, name="fluxnova_string_value", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_string_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_string_value, domain=None, range=Optional[str])

slots.fluxnova_string = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_string, name="fluxnova_string", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_string'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_string, domain=None, range=Optional[Union[dict, FluxnovaString]])

slots.fluxnova_expression_child = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_expression_child, name="fluxnova_expression_child", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_expression_child'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression_child, domain=None, range=Optional[Union[dict, FluxnovaExpression]])

slots.fluxnova_form_fields = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_form_fields, name="fluxnova_form_fields", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_form_fields'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_fields, domain=None, range=Optional[Union[Union[dict, FluxnovaFormField], list[Union[dict, FluxnovaFormField]]]])

slots.fluxnova_id = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_id, name="fluxnova_id", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_id, domain=None, range=Optional[str])

slots.fluxnova_label = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_label, name="fluxnova_label", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_label'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_label, domain=None, range=Optional[str])

slots.fluxnova_date_pattern = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_date_pattern, name="fluxnova_date_pattern", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_date_pattern'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_date_pattern, domain=None, range=Optional[str])

slots.fluxnova_default_value = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_default_value, name="fluxnova_default_value", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_default_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_default_value, domain=None, range=Optional[str])

slots.fluxnova_properties = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_properties, name="fluxnova_properties", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_properties, domain=None, range=Optional[Union[dict, FluxnovaProperties]])

slots.fluxnova_validation = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_validation, name="fluxnova_validation", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_validation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_validation, domain=None, range=Optional[Union[dict, FluxnovaValidation]])

slots.fluxnova_values = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_values, name="fluxnova_values", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_values'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_values, domain=None, range=Optional[Union[Union[dict, FluxnovaValue], list[Union[dict, FluxnovaValue]]]])

slots.fluxnova_required = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_required, name="fluxnova_required", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_required'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_required, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_readable = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_readable, name="fluxnova_readable", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_readable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_readable, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_writeable = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_writeable, name="fluxnova_writeable", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_writeable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_writeable, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_variable = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_variable, name="fluxnova_variable", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable, domain=None, range=Optional[str])

slots.fluxnova_default = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_default, name="fluxnova_default", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_default'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_default, domain=None, range=Optional[str])

slots.fluxnova_source = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_source, name="fluxnova_source", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_source'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_source, domain=None, range=Optional[str])

slots.fluxnova_source_expression = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_source_expression, name="fluxnova_source_expression", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_source_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_source_expression, domain=None, range=Optional[str])

slots.fluxnova_variables = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_variables, name="fluxnova_variables", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_variables'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variables, domain=None, range=Optional[str])

slots.fluxnova_target = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_target, name="fluxnova_target", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_target, domain=None, range=Optional[str])

slots.fluxnova_business_key = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_business_key, name="fluxnova_business_key", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_business_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_business_key, domain=None, range=Optional[str])

slots.fluxnova_local = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_local, name="fluxnova_local", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_local'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_local, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnova_input_parameters = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_input_parameters, name="fluxnova_input_parameters", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_input_parameters'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_input_parameters, domain=None, range=Optional[Union[Union[dict, FluxnovaInputParameter], list[Union[dict, FluxnovaInputParameter]]]])

slots.fluxnova_output_parameters = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_output_parameters, name="fluxnova_output_parameters", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_output_parameters'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_output_parameters, domain=None, range=Optional[Union[Union[dict, FluxnovaOutputParameter], list[Union[dict, FluxnovaOutputParameter]]]])

slots.values = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.values, name="values", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('values'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.values, domain=None, range=Optional[str])

slots.fluxnova_entries = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_entries, name="fluxnova_entries", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_entries, domain=None, range=Optional[Union[Union[dict, FluxnovaEntry], list[Union[dict, FluxnovaEntry]]]])

slots.fluxnova_value = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_value, name="fluxnova_value", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_value, domain=None, range=Optional[str])

slots.fluxnova_script_format = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_script_format, name="fluxnova_script_format", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_script_format'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_script_format, domain=None, range=Optional[str])

slots.timeouts = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.timeouts, name="timeouts", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('timeouts'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.timeouts, domain=None, range=Optional[Union[dict[Union[str, TimerEventDefinitionId], Union[dict, TimerEventDefinition]], list[Union[dict, TimerEventDefinition]]]])

slots.fluxnova_constraints = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_constraints, name="fluxnova_constraints", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_constraints'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnova_constraints, domain=None, range=Optional[Union[Union[dict, FluxnovaConstraint], list[Union[dict, FluxnovaConstraint]]]])

slots.FluxnovaPlatformData_deployments = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployments, name="FluxnovaPlatformData_deployments", curie=FLUXNOVA_BPM_PLATFORM.curie('deployments'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_deployments, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, DeploymentId], Union[dict, "Deployment"]], list[Union[dict, "Deployment"]]]])

slots.FluxnovaPlatformData_process_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definitions, name="FluxnovaPlatformData_process_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_process_definitions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, ProcessDefinitionId], Union[dict, "ProcessDefinition"]], list[Union[dict, "ProcessDefinition"]]]])

slots.FluxnovaPlatformData_executions = Slot(uri=FLUXNOVA_BPM_PLATFORM.executions, name="FluxnovaPlatformData_executions", curie=FLUXNOVA_BPM_PLATFORM.curie('executions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_executions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, ExecutionId], Union[dict, "Execution"]], list[Union[dict, "Execution"]]]])

slots.FluxnovaPlatformData_tasks = Slot(uri=FLUXNOVA_BPM_PLATFORM.tasks, name="FluxnovaPlatformData_tasks", curie=FLUXNOVA_BPM_PLATFORM.curie('tasks'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_tasks, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, TaskId], Union[dict, "Task"]], list[Union[dict, "Task"]]]])

slots.FluxnovaPlatformData_jobs = Slot(uri=FLUXNOVA_BPM_PLATFORM.jobs, name="FluxnovaPlatformData_jobs", curie=FLUXNOVA_BPM_PLATFORM.curie('jobs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_jobs, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, JobId], Union[dict, "Job"]], list[Union[dict, "Job"]]]])

slots.FluxnovaPlatformData_users = Slot(uri=FLUXNOVA_BPM_PLATFORM.users, name="FluxnovaPlatformData_users", curie=FLUXNOVA_BPM_PLATFORM.curie('users'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_users, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, UserId], Union[dict, "User"]], list[Union[dict, "User"]]]])

slots.FluxnovaPlatformData_groups = Slot(uri=FLUXNOVA_BPM_PLATFORM.groups, name="FluxnovaPlatformData_groups", curie=FLUXNOVA_BPM_PLATFORM.curie('groups'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_groups, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, GroupId], Union[dict, "Group"]], list[Union[dict, "Group"]]]])

slots.FluxnovaPlatformData_batches = Slot(uri=FLUXNOVA_BPM_PLATFORM.batches, name="FluxnovaPlatformData_batches", curie=FLUXNOVA_BPM_PLATFORM.curie('batches'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_batches, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, BatchId], Union[dict, "Batch"]], list[Union[dict, "Batch"]]]])

slots.ByteArray_type = Slot(uri=FLUXNOVA_COMMON.type, name="ByteArray_type", curie=FLUXNOVA_COMMON.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.ByteArray_type, domain=ByteArray, range=Optional[int])

slots.MeterLog_name = Slot(uri=SCHEMA.name, name="MeterLog_name", curie=SCHEMA.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.MeterLog_name, domain=MeterLog, range=str)

slots.MeterLog_value = Slot(uri=FLUXNOVA_COMMON.value, name="MeterLog_value", curie=FLUXNOVA_COMMON.curie('value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.MeterLog_value, domain=MeterLog, range=Optional[int])

slots.Property_name = Slot(uri=SCHEMA.name, name="Property_name", curie=SCHEMA.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Property_name, domain=Property, range=Union[str, PropertyName])

slots.SchemaLogEntry_version = Slot(uri=FLUXNOVA_BPM_BASE.version, name="SchemaLogEntry_version", curie=FLUXNOVA_BPM_BASE.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.SchemaLogEntry_version, domain=SchemaLogEntry, range=Optional[str])

slots.Filter_resource_type = Slot(uri=FLUXNOVA_BPM_IDENTITY.resource_type, name="Filter_resource_type", curie=FLUXNOVA_BPM_IDENTITY.curie('resource_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Filter_resource_type, domain=Filter, range=str)

slots.Filter_name = Slot(uri=SCHEMA.name, name="Filter_name", curie=SCHEMA.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Filter_name, domain=Filter, range=str)

slots.HistoricActivityInstance_process_definition_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.process_definition_id, name="HistoricActivityInstance_process_definition_id", curie=FLUXNOVA_BPM_RUNTIME.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricActivityInstance_process_definition_id, domain=HistoricActivityInstance, range=str)

slots.HistoricActivityInstance_process_instance_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.process_instance_id, name="HistoricActivityInstance_process_instance_id", curie=FLUXNOVA_BPM_RUNTIME.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricActivityInstance_process_instance_id, domain=HistoricActivityInstance, range=str)

slots.HistoricActivityInstance_execution_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.execution_id, name="HistoricActivityInstance_execution_id", curie=FLUXNOVA_BPM_RUNTIME.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricActivityInstance_execution_id, domain=HistoricActivityInstance, range=str)

slots.HistoricActivityInstance_activity_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.activity_id, name="HistoricActivityInstance_activity_id", curie=FLUXNOVA_BPM_RUNTIME.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricActivityInstance_activity_id, domain=HistoricActivityInstance, range=str)

slots.HistoricActivityInstance_start_time = Slot(uri=FLUXNOVA_BPM_JOB.start_time, name="HistoricActivityInstance_start_time", curie=FLUXNOVA_BPM_JOB.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricActivityInstance_start_time, domain=HistoricActivityInstance, range=Union[str, XSDDateTime])

slots.HistoricBatch_start_time = Slot(uri=FLUXNOVA_BPM_JOB.start_time, name="HistoricBatch_start_time", curie=FLUXNOVA_BPM_JOB.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricBatch_start_time, domain=HistoricBatch, range=Union[str, XSDDateTime])

slots.HistoricCaseActivityInstance_case_definition_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.case_definition_id, name="HistoricCaseActivityInstance_case_definition_id", curie=FLUXNOVA_BPM_RUNTIME.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricCaseActivityInstance_case_definition_id, domain=HistoricCaseActivityInstance, range=str)

slots.HistoricCaseActivityInstance_case_instance_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.case_instance_id, name="HistoricCaseActivityInstance_case_instance_id", curie=FLUXNOVA_BPM_RUNTIME.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricCaseActivityInstance_case_instance_id, domain=HistoricCaseActivityInstance, range=str)

slots.HistoricCaseActivityInstance_create_time = Slot(uri=FLUXNOVA_BPM_BASE.create_time, name="HistoricCaseActivityInstance_create_time", curie=FLUXNOVA_BPM_BASE.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricCaseActivityInstance_create_time, domain=HistoricCaseActivityInstance, range=Union[str, XSDDateTime])

slots.HistoricCaseInstance_case_instance_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.case_instance_id, name="HistoricCaseInstance_case_instance_id", curie=FLUXNOVA_BPM_RUNTIME.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricCaseInstance_case_instance_id, domain=HistoricCaseInstance, range=str)

slots.HistoricCaseInstance_case_definition_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.case_definition_id, name="HistoricCaseInstance_case_definition_id", curie=FLUXNOVA_BPM_RUNTIME.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricCaseInstance_case_definition_id, domain=HistoricCaseInstance, range=str)

slots.HistoricCaseInstance_create_time = Slot(uri=FLUXNOVA_BPM_BASE.create_time, name="HistoricCaseInstance_create_time", curie=FLUXNOVA_BPM_BASE.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricCaseInstance_create_time, domain=HistoricCaseInstance, range=Union[str, XSDDateTime])

slots.HistoricDetail_type = Slot(uri=FLUXNOVA_COMMON.type, name="HistoricDetail_type", curie=FLUXNOVA_COMMON.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricDetail_type, domain=HistoricDetail, range=str)

slots.HistoricDetail_name = Slot(uri=SCHEMA.name, name="HistoricDetail_name", curie=SCHEMA.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricDetail_name, domain=HistoricDetail, range=str)

slots.HistoricExternalTaskLog_timestamp = Slot(uri=FLUXNOVA_BPM_BASE.timestamp, name="HistoricExternalTaskLog_timestamp", curie=FLUXNOVA_BPM_BASE.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricExternalTaskLog_timestamp, domain=HistoricExternalTaskLog, range=Union[str, XSDDateTime])

slots.HistoricIdentityLink_timestamp = Slot(uri=FLUXNOVA_BPM_BASE.timestamp, name="HistoricIdentityLink_timestamp", curie=FLUXNOVA_BPM_BASE.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricIdentityLink_timestamp, domain=HistoricIdentityLink, range=Union[str, XSDDateTime])

slots.HistoricIncident_create_time = Slot(uri=FLUXNOVA_BPM_BASE.create_time, name="HistoricIncident_create_time", curie=FLUXNOVA_BPM_BASE.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricIncident_create_time, domain=HistoricIncident, range=Union[str, XSDDateTime])

slots.HistoricJobLog_timestamp = Slot(uri=FLUXNOVA_BPM_BASE.timestamp, name="HistoricJobLog_timestamp", curie=FLUXNOVA_BPM_BASE.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricJobLog_timestamp, domain=HistoricJobLog, range=Union[str, XSDDateTime])

slots.HistoricProcessInstance_process_instance_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.process_instance_id, name="HistoricProcessInstance_process_instance_id", curie=FLUXNOVA_BPM_RUNTIME.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricProcessInstance_process_instance_id, domain=HistoricProcessInstance, range=str)

slots.HistoricProcessInstance_process_definition_id = Slot(uri=FLUXNOVA_BPM_RUNTIME.process_definition_id, name="HistoricProcessInstance_process_definition_id", curie=FLUXNOVA_BPM_RUNTIME.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricProcessInstance_process_definition_id, domain=HistoricProcessInstance, range=str)

slots.HistoricProcessInstance_start_time = Slot(uri=FLUXNOVA_BPM_JOB.start_time, name="HistoricProcessInstance_start_time", curie=FLUXNOVA_BPM_JOB.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricProcessInstance_start_time, domain=HistoricProcessInstance, range=Union[str, XSDDateTime])

slots.HistoricTaskInstance_start_time = Slot(uri=FLUXNOVA_BPM_JOB.start_time, name="HistoricTaskInstance_start_time", curie=FLUXNOVA_BPM_JOB.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricTaskInstance_start_time, domain=HistoricTaskInstance, range=Union[str, XSDDateTime])

slots.HistoricVariableInstance_name = Slot(uri=SCHEMA.name, name="HistoricVariableInstance_name", curie=SCHEMA.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.HistoricVariableInstance_name, domain=HistoricVariableInstance, range=str)

slots.UserOperationLogEntry_timestamp = Slot(uri=FLUXNOVA_BPM_BASE.timestamp, name="UserOperationLogEntry_timestamp", curie=FLUXNOVA_BPM_BASE.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.UserOperationLogEntry_timestamp, domain=UserOperationLogEntry, range=Union[str, XSDDateTime])

slots.Authorization_type = Slot(uri=FLUXNOVA_COMMON.type, name="Authorization_type", curie=FLUXNOVA_COMMON.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Authorization_type, domain=Authorization, range=Union[str, "AuthorizationType"])

slots.Membership_user_id = Slot(uri=FLUXNOVA_BPM_IDENTITY.user_id, name="Membership_user_id", curie=FLUXNOVA_BPM_IDENTITY.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Membership_user_id, domain=Membership, range=str)

slots.Membership_group_id = Slot(uri=FLUXNOVA_BPM_IDENTITY.group_id, name="Membership_group_id", curie=FLUXNOVA_BPM_IDENTITY.curie('group_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Membership_group_id, domain=Membership, range=str)

slots.TenantMembership_tenant_id = Slot(uri=FLUXNOVA_BPM_BASE.tenant_id, name="TenantMembership_tenant_id", curie=FLUXNOVA_BPM_BASE.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.TenantMembership_tenant_id, domain=TenantMembership, range=str)

slots.Job_type = Slot(uri=FLUXNOVA_COMMON.type, name="Job_type", curie=FLUXNOVA_COMMON.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Job_type, domain=Job, range=str)

slots.Job_suspension_state = Slot(uri=FLUXNOVA_BPM_REPOSITORY.suspension_state, name="Job_suspension_state", curie=FLUXNOVA_BPM_REPOSITORY.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Job_suspension_state, domain=Job, range=Union[str, "SuspensionState"])

slots.CaseDefinition_key = Slot(uri=FLUXNOVA_BPM_REPOSITORY.key, name="CaseDefinition_key", curie=FLUXNOVA_BPM_REPOSITORY.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.CaseDefinition_key, domain=CaseDefinition, range=str)

slots.CaseDefinition_version = Slot(uri=FLUXNOVA_BPM_BASE.version, name="CaseDefinition_version", curie=FLUXNOVA_BPM_BASE.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.CaseDefinition_version, domain=CaseDefinition, range=int)

slots.DecisionDefinition_key = Slot(uri=FLUXNOVA_BPM_REPOSITORY.key, name="DecisionDefinition_key", curie=FLUXNOVA_BPM_REPOSITORY.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.DecisionDefinition_key, domain=DecisionDefinition, range=str)

slots.DecisionDefinition_version = Slot(uri=FLUXNOVA_BPM_BASE.version, name="DecisionDefinition_version", curie=FLUXNOVA_BPM_BASE.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.DecisionDefinition_version, domain=DecisionDefinition, range=int)

slots.DecisionRequirementsDefinition_key = Slot(uri=FLUXNOVA_BPM_REPOSITORY.key, name="DecisionRequirementsDefinition_key", curie=FLUXNOVA_BPM_REPOSITORY.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.DecisionRequirementsDefinition_key, domain=DecisionRequirementsDefinition, range=str)

slots.DecisionRequirementsDefinition_version = Slot(uri=FLUXNOVA_BPM_BASE.version, name="DecisionRequirementsDefinition_version", curie=FLUXNOVA_BPM_BASE.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.DecisionRequirementsDefinition_version, domain=DecisionRequirementsDefinition, range=int)

slots.FormDefinition_key = Slot(uri=FLUXNOVA_BPM_REPOSITORY.key, name="FormDefinition_key", curie=FLUXNOVA_BPM_REPOSITORY.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FormDefinition_key, domain=FormDefinition, range=str)

slots.FormDefinition_version = Slot(uri=FLUXNOVA_BPM_BASE.version, name="FormDefinition_version", curie=FLUXNOVA_BPM_BASE.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FormDefinition_version, domain=FormDefinition, range=int)

slots.ProcessDefinition_key = Slot(uri=FLUXNOVA_BPM_REPOSITORY.key, name="ProcessDefinition_key", curie=FLUXNOVA_BPM_REPOSITORY.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.ProcessDefinition_key, domain=ProcessDefinition, range=str)

slots.ProcessDefinition_version = Slot(uri=FLUXNOVA_BPM_BASE.version, name="ProcessDefinition_version", curie=FLUXNOVA_BPM_BASE.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.ProcessDefinition_version, domain=ProcessDefinition, range=int)

slots.VariableInstance_type = Slot(uri=FLUXNOVA_COMMON.type, name="VariableInstance_type", curie=FLUXNOVA_COMMON.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.VariableInstance_type, domain=VariableInstance, range=str)

slots.VariableInstance_name = Slot(uri=SCHEMA.name, name="VariableInstance_name", curie=SCHEMA.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.VariableInstance_name, domain=VariableInstance, range=str)

slots.Activity_properties = Slot(uri=FLUXNOVA_COMMON.properties, name="Activity_properties", curie=FLUXNOVA_COMMON.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Activity_properties, domain=Activity, range=Optional[Union[dict[Union[str, BpmnPropertyId], Union[dict, "BpmnProperty"]], list[Union[dict, "BpmnProperty"]]]])

slots.Association_source = Slot(uri=FLUXNOVA_COMMON.source, name="Association_source", curie=FLUXNOVA_COMMON.curie('source'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Association_source, domain=Association, range=Optional[Union[str, BaseElementId]])

slots.BpmnModelElementInstance_scope = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.scope, name="BpmnModelElementInstance_scope", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('scope'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.BpmnModelElementInstance_scope, domain=BpmnModelElementInstance, range=Optional[Union[dict, "BpmnModelElementInstance"]])

slots.ConversationLink_source = Slot(uri=FLUXNOVA_COMMON.source, name="ConversationLink_source", curie=FLUXNOVA_COMMON.curie('source'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.ConversationLink_source, domain=ConversationLink, range=Optional[Union[str, InteractionNodeId]])

slots.ConversationLink_target = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.target, name="ConversationLink_target", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.ConversationLink_target, domain=ConversationLink, range=Optional[Union[str, InteractionNodeId]])

slots.CorrelationProperty_type = Slot(uri=FLUXNOVA_COMMON.type, name="CorrelationProperty_type", curie=FLUXNOVA_COMMON.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.CorrelationProperty_type, domain=CorrelationProperty, range=Optional[Union[str, ItemDefinitionId]])

slots.CorrelationPropertyRetrievalExpression_message = Slot(uri=FLUXNOVA_COMMON.message, name="CorrelationPropertyRetrievalExpression_message", curie=FLUXNOVA_COMMON.curie('message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.CorrelationPropertyRetrievalExpression_message, domain=CorrelationPropertyRetrievalExpression, range=Optional[Union[str, MessageId]])

slots.DataAssociation_target = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.target, name="DataAssociation_target", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.DataAssociation_target, domain=DataAssociation, range=Optional[Union[str, ItemAwareElementId]])

slots.Event_properties = Slot(uri=FLUXNOVA_COMMON.properties, name="Event_properties", curie=FLUXNOVA_COMMON.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Event_properties, domain=Event, range=Optional[Union[dict[Union[str, BpmnPropertyId], Union[dict, "BpmnProperty"]], list[Union[dict, "BpmnProperty"]]]])

slots.BpmnGroup_category = Slot(uri=FLUXNOVA_COMMON.category, name="BpmnGroup_category", curie=FLUXNOVA_COMMON.curie('category'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.BpmnGroup_category, domain=BpmnGroup, range=Optional[Union[str, CategoryValueId]])

slots.LinkEventDefinition_sources = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.sources, name="LinkEventDefinition_sources", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('sources'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.LinkEventDefinition_sources, domain=LinkEventDefinition, range=Optional[Union[dict[Union[str, LinkEventDefinitionId], Union[dict, "LinkEventDefinition"]], list[Union[dict, "LinkEventDefinition"]]]])

slots.LinkEventDefinition_target = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.target, name="LinkEventDefinition_target", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.LinkEventDefinition_target, domain=LinkEventDefinition, range=Optional[Union[str, LinkEventDefinitionId]])

slots.MessageEventDefinition_message = Slot(uri=FLUXNOVA_COMMON.message, name="MessageEventDefinition_message", curie=FLUXNOVA_COMMON.curie('message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.MessageEventDefinition_message, domain=MessageEventDefinition, range=Optional[Union[str, MessageId]])

slots.MessageFlow_source = Slot(uri=FLUXNOVA_COMMON.source, name="MessageFlow_source", curie=FLUXNOVA_COMMON.curie('source'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.MessageFlow_source, domain=MessageFlow, range=Optional[Union[str, InteractionNodeId]])

slots.MessageFlow_target = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.target, name="MessageFlow_target", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.MessageFlow_target, domain=MessageFlow, range=Optional[Union[str, InteractionNodeId]])

slots.MessageFlow_message = Slot(uri=FLUXNOVA_COMMON.message, name="MessageFlow_message", curie=FLUXNOVA_COMMON.curie('message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.MessageFlow_message, domain=MessageFlow, range=Optional[Union[str, MessageId]])

slots.Process_properties = Slot(uri=FLUXNOVA_COMMON.properties, name="Process_properties", curie=FLUXNOVA_COMMON.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Process_properties, domain=Process, range=Optional[Union[dict[Union[str, BpmnPropertyId], Union[dict, BpmnProperty]], list[Union[dict, BpmnProperty]]]])

slots.ReceiveTask_message = Slot(uri=FLUXNOVA_COMMON.message, name="ReceiveTask_message", curie=FLUXNOVA_COMMON.curie('message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.ReceiveTask_message, domain=ReceiveTask, range=Optional[Union[str, MessageId]])

slots.Relationship_sources = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.sources, name="Relationship_sources", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('sources'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.Relationship_sources, domain=Relationship, range=Optional[Union[str, list[str]]])

slots.ResourceParameter_type = Slot(uri=FLUXNOVA_COMMON.type, name="ResourceParameter_type", curie=FLUXNOVA_COMMON.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.ResourceParameter_type, domain=ResourceParameter, range=Optional[Union[str, ItemDefinitionId]])

slots.SendTask_message = Slot(uri=FLUXNOVA_COMMON.message, name="SendTask_message", curie=FLUXNOVA_COMMON.curie('message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.SendTask_message, domain=SendTask, range=Optional[Union[str, MessageId]])

slots.SequenceFlow_source = Slot(uri=FLUXNOVA_COMMON.source, name="SequenceFlow_source", curie=FLUXNOVA_COMMON.curie('source'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.SequenceFlow_source, domain=SequenceFlow, range=Optional[Union[str, FlowNodeId]])

slots.SequenceFlow_target = Slot(uri=FLUXNOVA_BPMN_MODEL_INSTANCE.target, name="SequenceFlow_target", curie=FLUXNOVA_BPMN_MODEL_INSTANCE.curie('target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.SequenceFlow_target, domain=SequenceFlow, range=Optional[Union[str, FlowNodeId]])

slots.FluxnovaProperties_fluxnova_properties = Slot(uri=FLUXNOVA_BPMN_MODEL_FLUXNOVA.fluxnova_properties, name="FluxnovaProperties_fluxnova_properties", curie=FLUXNOVA_BPMN_MODEL_FLUXNOVA.curie('fluxnova_properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaProperties_fluxnova_properties, domain=FluxnovaProperties, range=Optional[Union[dict, "FluxnovaProperty"]])
