# Auto generated from fluxnova_bpm_platform.yaml by pythongen.py version: 0.0.1
# Schema: fluxnova_bpm_platform
#
# id: https://w3id.org/lmodel/fluxnova-bpm-platform
# description: The tables Fluxnova's process engine keeps, and the BPMN elements its model API reads, as of Fluxnova 3.1.1.
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

from linkml_runtime.linkml_model.types import Boolean, Datetime, Double, Float, Integer, String
from linkml_runtime.utils.metamodelcore import Bool, XSDDateTime

metamodel_version = "1.12.0"
version = "3.1.1"

# Namespaces
BPMN = CurieNamespace('bpmn', 'http://www.omg.org/spec/BPMN/20100524/MODEL#')
BPMNDI = CurieNamespace('bpmndi', 'http://www.omg.org/spec/BPMN/20100524/DI#')
CAMUNDA = CurieNamespace('camunda', 'http://camunda.org/schema/1.0/bpmn#')
FLUXNOVA = CurieNamespace('fluxnova', 'http://fluxnova.finos.org/schema/1.0/bpmn#')
FLUXNOVA_BPM_PLATFORM = CurieNamespace('fluxnova_bpm_platform', 'https://w3id.org/lmodel/fluxnova-bpm-platform/')
LINKML = CurieNamespace('linkml', 'https://w3id.org/linkml/')
OMGDC = CurieNamespace('omgdc', 'http://www.omg.org/spec/DD/20100524/DC#')
OMGDI = CurieNamespace('omgdi', 'http://www.omg.org/spec/DD/20100524/DI#')
DEFAULT_ = FLUXNOVA_BPM_PLATFORM


# Types

# Class references
class FluxnovaAttachmentId(extended_str):
    pass


class FluxnovaAuthorizationId(extended_str):
    pass


class FluxnovaBatchId(extended_str):
    pass


class FluxnovaByteArrayId(extended_str):
    pass


class FluxnovaCaseExecutionId(extended_str):
    pass


class FluxnovaCaseSentryPartId(extended_str):
    pass


class FluxnovaCommentId(extended_str):
    pass


class FluxnovaConfigurationId(extended_str):
    pass


class FluxnovaDeploymentId(extended_str):
    pass


class FluxnovaEventSubscriptionId(extended_str):
    pass


class FluxnovaExecutionId(extended_str):
    pass


class FluxnovaExternalTaskId(extended_str):
    pass


class FluxnovaFilterId(extended_str):
    pass


class FluxnovaGroupId(extended_str):
    pass


class FluxnovaHistoricBatchId(extended_str):
    pass


class FluxnovaHistoricDecisionInputInstanceId(extended_str):
    pass


class FluxnovaHistoricDecisionInstanceId(extended_str):
    pass


class FluxnovaHistoricDecisionOutputInstanceId(extended_str):
    pass


class FluxnovaHistoricDetailId(extended_str):
    pass


class FluxnovaHistoricExternalTaskLogId(extended_str):
    pass


class FluxnovaHistoricIdentityLinkId(extended_str):
    pass


class FluxnovaHistoricIncidentId(extended_str):
    pass


class FluxnovaHistoricJobLogId(extended_str):
    pass


class FluxnovaHistoricScopeInstanceId(extended_str):
    pass


class FluxnovaHistoricActivityInstanceId(FluxnovaHistoricScopeInstanceId):
    pass


class FluxnovaHistoricCaseActivityInstanceId(FluxnovaHistoricScopeInstanceId):
    pass


class FluxnovaHistoricCaseInstanceId(FluxnovaHistoricScopeInstanceId):
    pass


class FluxnovaHistoricProcessInstanceId(FluxnovaHistoricScopeInstanceId):
    pass


class FluxnovaHistoricTaskInstanceId(FluxnovaHistoricScopeInstanceId):
    pass


class FluxnovaHistoricVariableInstanceId(extended_str):
    pass


class FluxnovaIdentityInfoId(extended_str):
    pass


class FluxnovaIdentityLinkId(extended_str):
    pass


class FluxnovaIncidentId(extended_str):
    pass


class FluxnovaJobId(extended_str):
    pass


class FluxnovaJobDefinitionId(extended_str):
    pass


class FluxnovaMeterLogId(extended_str):
    pass


class FluxnovaEnginePropertyName(extended_str):
    pass


class FluxnovaResourceDefinitionId(extended_str):
    pass


class FluxnovaCaseDefinitionId(FluxnovaResourceDefinitionId):
    pass


class FluxnovaDecisionDefinitionId(FluxnovaResourceDefinitionId):
    pass


class FluxnovaDecisionRequirementsDefinitionId(FluxnovaResourceDefinitionId):
    pass


class FluxnovaFormDefinitionId(FluxnovaResourceDefinitionId):
    pass


class FluxnovaProcessDefinitionId(FluxnovaResourceDefinitionId):
    pass


class FluxnovaSchemaLogEntryId(extended_str):
    pass


class FluxnovaTaskId(extended_str):
    pass


class FluxnovaTaskMeterLogId(extended_str):
    pass


class FluxnovaTenantId(extended_str):
    pass


class FluxnovaTenantMembershipId(extended_str):
    pass


class FluxnovaUserId(extended_str):
    pass


class FluxnovaUserOperationLogEntryId(extended_str):
    pass


class FluxnovaVariableInstanceId(extended_str):
    pass


@dataclass(repr=False)
class FluxnovaPlatformData(YAMLRoot):
    """
    Root container for Fluxnova BPM Platform data: a list of rows for each of the engine's tables.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaPlatformData"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaPlatformData"
    class_name: ClassVar[str] = "FluxnovaPlatformData"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData

    attachments: Optional[Union[dict[Union[str, FluxnovaAttachmentId], Union[dict, "FluxnovaAttachment"]], list[Union[dict, "FluxnovaAttachment"]]]] = empty_dict()
    authorization_entries: Optional[Union[dict[Union[str, FluxnovaAuthorizationId], Union[dict, "FluxnovaAuthorization"]], list[Union[dict, "FluxnovaAuthorization"]]]] = empty_dict()
    batches: Optional[Union[dict[Union[str, FluxnovaBatchId], Union[dict, "FluxnovaBatch"]], list[Union[dict, "FluxnovaBatch"]]]] = empty_dict()
    byte_arrays: Optional[Union[dict[Union[str, FluxnovaByteArrayId], Union[dict, "FluxnovaByteArray"]], list[Union[dict, "FluxnovaByteArray"]]]] = empty_dict()
    case_definitions: Optional[Union[dict[Union[str, FluxnovaCaseDefinitionId], Union[dict, "FluxnovaCaseDefinition"]], list[Union[dict, "FluxnovaCaseDefinition"]]]] = empty_dict()
    case_executions: Optional[Union[dict[Union[str, FluxnovaCaseExecutionId], Union[dict, "FluxnovaCaseExecution"]], list[Union[dict, "FluxnovaCaseExecution"]]]] = empty_dict()
    case_sentry_parts: Optional[Union[dict[Union[str, FluxnovaCaseSentryPartId], Union[dict, "FluxnovaCaseSentryPart"]], list[Union[dict, "FluxnovaCaseSentryPart"]]]] = empty_dict()
    comment_entries: Optional[Union[dict[Union[str, FluxnovaCommentId], Union[dict, "FluxnovaComment"]], list[Union[dict, "FluxnovaComment"]]]] = empty_dict()
    configuration_entries: Optional[Union[dict[Union[str, FluxnovaConfigurationId], Union[dict, "FluxnovaConfiguration"]], list[Union[dict, "FluxnovaConfiguration"]]]] = empty_dict()
    decision_definitions: Optional[Union[dict[Union[str, FluxnovaDecisionDefinitionId], Union[dict, "FluxnovaDecisionDefinition"]], list[Union[dict, "FluxnovaDecisionDefinition"]]]] = empty_dict()
    decision_requirements_definitions: Optional[Union[dict[Union[str, FluxnovaDecisionRequirementsDefinitionId], Union[dict, "FluxnovaDecisionRequirementsDefinition"]], list[Union[dict, "FluxnovaDecisionRequirementsDefinition"]]]] = empty_dict()
    deployments: Optional[Union[dict[Union[str, FluxnovaDeploymentId], Union[dict, "FluxnovaDeployment"]], list[Union[dict, "FluxnovaDeployment"]]]] = empty_dict()
    engine_properties: Optional[Union[dict[Union[str, FluxnovaEnginePropertyName], Union[dict, "FluxnovaEngineProperty"]], list[Union[dict, "FluxnovaEngineProperty"]]]] = empty_dict()
    event_subscriptions: Optional[Union[dict[Union[str, FluxnovaEventSubscriptionId], Union[dict, "FluxnovaEventSubscription"]], list[Union[dict, "FluxnovaEventSubscription"]]]] = empty_dict()
    executions: Optional[Union[dict[Union[str, FluxnovaExecutionId], Union[dict, "FluxnovaExecution"]], list[Union[dict, "FluxnovaExecution"]]]] = empty_dict()
    external_tasks: Optional[Union[dict[Union[str, FluxnovaExternalTaskId], Union[dict, "FluxnovaExternalTask"]], list[Union[dict, "FluxnovaExternalTask"]]]] = empty_dict()
    filter_entries: Optional[Union[dict[Union[str, FluxnovaFilterId], Union[dict, "FluxnovaFilter"]], list[Union[dict, "FluxnovaFilter"]]]] = empty_dict()
    form_definitions: Optional[Union[dict[Union[str, FluxnovaFormDefinitionId], Union[dict, "FluxnovaFormDefinition"]], list[Union[dict, "FluxnovaFormDefinition"]]]] = empty_dict()
    groups: Optional[Union[dict[Union[str, FluxnovaGroupId], Union[dict, "FluxnovaGroup"]], list[Union[dict, "FluxnovaGroup"]]]] = empty_dict()
    historic_activity_instances: Optional[Union[dict[Union[str, FluxnovaHistoricActivityInstanceId], Union[dict, "FluxnovaHistoricActivityInstance"]], list[Union[dict, "FluxnovaHistoricActivityInstance"]]]] = empty_dict()
    historic_batches: Optional[Union[dict[Union[str, FluxnovaHistoricBatchId], Union[dict, "FluxnovaHistoricBatch"]], list[Union[dict, "FluxnovaHistoricBatch"]]]] = empty_dict()
    historic_case_activity_instances: Optional[Union[dict[Union[str, FluxnovaHistoricCaseActivityInstanceId], Union[dict, "FluxnovaHistoricCaseActivityInstance"]], list[Union[dict, "FluxnovaHistoricCaseActivityInstance"]]]] = empty_dict()
    historic_case_instances: Optional[Union[dict[Union[str, FluxnovaHistoricCaseInstanceId], Union[dict, "FluxnovaHistoricCaseInstance"]], list[Union[dict, "FluxnovaHistoricCaseInstance"]]]] = empty_dict()
    historic_decision_input_instances: Optional[Union[dict[Union[str, FluxnovaHistoricDecisionInputInstanceId], Union[dict, "FluxnovaHistoricDecisionInputInstance"]], list[Union[dict, "FluxnovaHistoricDecisionInputInstance"]]]] = empty_dict()
    historic_decision_instances: Optional[Union[dict[Union[str, FluxnovaHistoricDecisionInstanceId], Union[dict, "FluxnovaHistoricDecisionInstance"]], list[Union[dict, "FluxnovaHistoricDecisionInstance"]]]] = empty_dict()
    historic_decision_output_instances: Optional[Union[dict[Union[str, FluxnovaHistoricDecisionOutputInstanceId], Union[dict, "FluxnovaHistoricDecisionOutputInstance"]], list[Union[dict, "FluxnovaHistoricDecisionOutputInstance"]]]] = empty_dict()
    historic_details: Optional[Union[dict[Union[str, FluxnovaHistoricDetailId], Union[dict, "FluxnovaHistoricDetail"]], list[Union[dict, "FluxnovaHistoricDetail"]]]] = empty_dict()
    historic_external_task_logs: Optional[Union[dict[Union[str, FluxnovaHistoricExternalTaskLogId], Union[dict, "FluxnovaHistoricExternalTaskLog"]], list[Union[dict, "FluxnovaHistoricExternalTaskLog"]]]] = empty_dict()
    historic_identity_links: Optional[Union[dict[Union[str, FluxnovaHistoricIdentityLinkId], Union[dict, "FluxnovaHistoricIdentityLink"]], list[Union[dict, "FluxnovaHistoricIdentityLink"]]]] = empty_dict()
    historic_incidents: Optional[Union[dict[Union[str, FluxnovaHistoricIncidentId], Union[dict, "FluxnovaHistoricIncident"]], list[Union[dict, "FluxnovaHistoricIncident"]]]] = empty_dict()
    historic_job_logs: Optional[Union[dict[Union[str, FluxnovaHistoricJobLogId], Union[dict, "FluxnovaHistoricJobLog"]], list[Union[dict, "FluxnovaHistoricJobLog"]]]] = empty_dict()
    historic_process_instances: Optional[Union[dict[Union[str, FluxnovaHistoricProcessInstanceId], Union[dict, "FluxnovaHistoricProcessInstance"]], list[Union[dict, "FluxnovaHistoricProcessInstance"]]]] = empty_dict()
    historic_task_instances: Optional[Union[dict[Union[str, FluxnovaHistoricTaskInstanceId], Union[dict, "FluxnovaHistoricTaskInstance"]], list[Union[dict, "FluxnovaHistoricTaskInstance"]]]] = empty_dict()
    historic_variable_instances: Optional[Union[dict[Union[str, FluxnovaHistoricVariableInstanceId], Union[dict, "FluxnovaHistoricVariableInstance"]], list[Union[dict, "FluxnovaHistoricVariableInstance"]]]] = empty_dict()
    identity_infos: Optional[Union[dict[Union[str, FluxnovaIdentityInfoId], Union[dict, "FluxnovaIdentityInfo"]], list[Union[dict, "FluxnovaIdentityInfo"]]]] = empty_dict()
    identity_links: Optional[Union[dict[Union[str, FluxnovaIdentityLinkId], Union[dict, "FluxnovaIdentityLink"]], list[Union[dict, "FluxnovaIdentityLink"]]]] = empty_dict()
    incidents: Optional[Union[dict[Union[str, FluxnovaIncidentId], Union[dict, "FluxnovaIncident"]], list[Union[dict, "FluxnovaIncident"]]]] = empty_dict()
    job_definitions: Optional[Union[dict[Union[str, FluxnovaJobDefinitionId], Union[dict, "FluxnovaJobDefinition"]], list[Union[dict, "FluxnovaJobDefinition"]]]] = empty_dict()
    jobs: Optional[Union[dict[Union[str, FluxnovaJobId], Union[dict, "FluxnovaJob"]], list[Union[dict, "FluxnovaJob"]]]] = empty_dict()
    memberships: Optional[Union[Union[dict, "FluxnovaMembership"], list[Union[dict, "FluxnovaMembership"]]]] = empty_list()
    meter_logs: Optional[Union[dict[Union[str, FluxnovaMeterLogId], Union[dict, "FluxnovaMeterLog"]], list[Union[dict, "FluxnovaMeterLog"]]]] = empty_dict()
    process_definitions: Optional[Union[dict[Union[str, FluxnovaProcessDefinitionId], Union[dict, "FluxnovaProcessDefinition"]], list[Union[dict, "FluxnovaProcessDefinition"]]]] = empty_dict()
    schema_log_entries: Optional[Union[dict[Union[str, FluxnovaSchemaLogEntryId], Union[dict, "FluxnovaSchemaLogEntry"]], list[Union[dict, "FluxnovaSchemaLogEntry"]]]] = empty_dict()
    task_meter_logs: Optional[Union[dict[Union[str, FluxnovaTaskMeterLogId], Union[dict, "FluxnovaTaskMeterLog"]], list[Union[dict, "FluxnovaTaskMeterLog"]]]] = empty_dict()
    tasks: Optional[Union[dict[Union[str, FluxnovaTaskId], Union[dict, "FluxnovaTask"]], list[Union[dict, "FluxnovaTask"]]]] = empty_dict()
    tenant_memberships: Optional[Union[dict[Union[str, FluxnovaTenantMembershipId], Union[dict, "FluxnovaTenantMembership"]], list[Union[dict, "FluxnovaTenantMembership"]]]] = empty_dict()
    tenants: Optional[Union[dict[Union[str, FluxnovaTenantId], Union[dict, "FluxnovaTenant"]], list[Union[dict, "FluxnovaTenant"]]]] = empty_dict()
    user_operation_log_entries: Optional[Union[dict[Union[str, FluxnovaUserOperationLogEntryId], Union[dict, "FluxnovaUserOperationLogEntry"]], list[Union[dict, "FluxnovaUserOperationLogEntry"]]]] = empty_dict()
    users: Optional[Union[dict[Union[str, FluxnovaUserId], Union[dict, "FluxnovaUser"]], list[Union[dict, "FluxnovaUser"]]]] = empty_dict()
    variable_instances: Optional[Union[dict[Union[str, FluxnovaVariableInstanceId], Union[dict, "FluxnovaVariableInstance"]], list[Union[dict, "FluxnovaVariableInstance"]]]] = empty_dict()

    def __post_init__(self, *_: str, **kwargs: Any):
        self._normalize_inlined_as_list(slot_name="attachments", slot_type=FluxnovaAttachment, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="authorization_entries", slot_type=FluxnovaAuthorization, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="batches", slot_type=FluxnovaBatch, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="byte_arrays", slot_type=FluxnovaByteArray, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="case_definitions", slot_type=FluxnovaCaseDefinition, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="case_executions", slot_type=FluxnovaCaseExecution, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="case_sentry_parts", slot_type=FluxnovaCaseSentryPart, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="comment_entries", slot_type=FluxnovaComment, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="configuration_entries", slot_type=FluxnovaConfiguration, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="decision_definitions", slot_type=FluxnovaDecisionDefinition, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="decision_requirements_definitions", slot_type=FluxnovaDecisionRequirementsDefinition, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="deployments", slot_type=FluxnovaDeployment, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="engine_properties", slot_type=FluxnovaEngineProperty, key_name="name", keyed=True)

        self._normalize_inlined_as_list(slot_name="event_subscriptions", slot_type=FluxnovaEventSubscription, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="executions", slot_type=FluxnovaExecution, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="external_tasks", slot_type=FluxnovaExternalTask, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="filter_entries", slot_type=FluxnovaFilter, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="form_definitions", slot_type=FluxnovaFormDefinition, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="groups", slot_type=FluxnovaGroup, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_activity_instances", slot_type=FluxnovaHistoricActivityInstance, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_batches", slot_type=FluxnovaHistoricBatch, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_case_activity_instances", slot_type=FluxnovaHistoricCaseActivityInstance, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_case_instances", slot_type=FluxnovaHistoricCaseInstance, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_decision_input_instances", slot_type=FluxnovaHistoricDecisionInputInstance, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_decision_instances", slot_type=FluxnovaHistoricDecisionInstance, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_decision_output_instances", slot_type=FluxnovaHistoricDecisionOutputInstance, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_details", slot_type=FluxnovaHistoricDetail, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_external_task_logs", slot_type=FluxnovaHistoricExternalTaskLog, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_identity_links", slot_type=FluxnovaHistoricIdentityLink, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_incidents", slot_type=FluxnovaHistoricIncident, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_job_logs", slot_type=FluxnovaHistoricJobLog, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_process_instances", slot_type=FluxnovaHistoricProcessInstance, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_task_instances", slot_type=FluxnovaHistoricTaskInstance, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="historic_variable_instances", slot_type=FluxnovaHistoricVariableInstance, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="identity_infos", slot_type=FluxnovaIdentityInfo, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="identity_links", slot_type=FluxnovaIdentityLink, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="incidents", slot_type=FluxnovaIncident, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="job_definitions", slot_type=FluxnovaJobDefinition, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="jobs", slot_type=FluxnovaJob, key_name="id", keyed=True)

        if not isinstance(self.memberships, list):
            self.memberships = [self.memberships] if self.memberships is not None else []
        self.memberships = [v if isinstance(v, FluxnovaMembership) else FluxnovaMembership(**as_dict(v)) for v in self.memberships]

        self._normalize_inlined_as_list(slot_name="meter_logs", slot_type=FluxnovaMeterLog, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="process_definitions", slot_type=FluxnovaProcessDefinition, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="schema_log_entries", slot_type=FluxnovaSchemaLogEntry, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="task_meter_logs", slot_type=FluxnovaTaskMeterLog, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="tasks", slot_type=FluxnovaTask, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="tenant_memberships", slot_type=FluxnovaTenantMembership, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="tenants", slot_type=FluxnovaTenant, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="user_operation_log_entries", slot_type=FluxnovaUserOperationLogEntry, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="users", slot_type=FluxnovaUser, key_name="id", keyed=True)

        self._normalize_inlined_as_list(slot_name="variable_instances", slot_type=FluxnovaVariableInstance, key_name="id", keyed=True)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaAttachment(YAMLRoot):
    """
    Any type of content that is be associated with a task or with a process instance.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaAttachment"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaAttachment"
    class_name: ClassVar[str] = "FluxnovaAttachment"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment

    id: Union[str, FluxnovaAttachmentId] = None
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
    created_by: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaAttachmentId):
            self.id = FluxnovaAttachmentId(self.id)

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

        if self.created_by is not None and not isinstance(self.created_by, str):
            self.created_by = str(self.created_by)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaAuthorization(YAMLRoot):
    """
    An Authorization assigns a set of Permissions to an identity to interact with a given Resource.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaAuthorization"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaAuthorization"
    class_name: ClassVar[str] = "FluxnovaAuthorization"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaAuthorization

    id: Union[str, FluxnovaAuthorizationId] = None
    type: int = None
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
        if not isinstance(self.id, FluxnovaAuthorizationId):
            self.id = FluxnovaAuthorizationId(self.id)

        if self._is_empty(self.type):
            self.MissingRequiredField("type")
        if not isinstance(self.type, int):
            self.type = int(self.type)

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
class FluxnovaBatch(YAMLRoot):
    """
    A batch represents a number of jobs which execute a number of commands asynchronously.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaBatch"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaBatch"
    class_name: ClassVar[str] = "FluxnovaBatch"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaBatch

    id: Union[str, FluxnovaBatchId] = None
    type: Optional[str] = None
    total_jobs: Optional[int] = None
    jobs_created: Optional[int] = None
    jobs_per_seed: Optional[int] = None
    invocations_per_job: Optional[int] = None
    seed_job_definition_id: Optional[Union[str, FluxnovaJobDefinitionId]] = None
    batch_job_definition_id: Optional[Union[str, FluxnovaJobDefinitionId]] = None
    monitor_job_definition_id: Optional[Union[str, FluxnovaJobDefinitionId]] = None
    suspension_state: Optional[int] = None
    configuration: Optional[str] = None
    tenant_id: Optional[str] = None
    create_user_id: Optional[str] = None
    start_time: Optional[Union[str, XSDDateTime]] = None
    execution_start_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaBatchId):
            self.id = FluxnovaBatchId(self.id)

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

        if self.seed_job_definition_id is not None and not isinstance(self.seed_job_definition_id, FluxnovaJobDefinitionId):
            self.seed_job_definition_id = FluxnovaJobDefinitionId(self.seed_job_definition_id)

        if self.batch_job_definition_id is not None and not isinstance(self.batch_job_definition_id, FluxnovaJobDefinitionId):
            self.batch_job_definition_id = FluxnovaJobDefinitionId(self.batch_job_definition_id)

        if self.monitor_job_definition_id is not None and not isinstance(self.monitor_job_definition_id, FluxnovaJobDefinitionId):
            self.monitor_job_definition_id = FluxnovaJobDefinitionId(self.monitor_job_definition_id)

        if self.suspension_state is not None and not isinstance(self.suspension_state, int):
            self.suspension_state = int(self.suspension_state)

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
class FluxnovaByteArray(YAMLRoot):
    """
    Byte Array entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaByteArray"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaByteArray"
    class_name: ClassVar[str] = "FluxnovaByteArray"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaByteArray

    id: Union[str, FluxnovaByteArrayId] = None
    name: Optional[str] = None
    deployment_id: Optional[Union[str, FluxnovaDeploymentId]] = None
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
        if not isinstance(self.id, FluxnovaByteArrayId):
            self.id = FluxnovaByteArrayId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.deployment_id is not None and not isinstance(self.deployment_id, FluxnovaDeploymentId):
            self.deployment_id = FluxnovaDeploymentId(self.deployment_id)

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
class FluxnovaCaseExecution(YAMLRoot):
    """
    Case Execution entity in the process execution runtime.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaCaseExecution"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaCaseExecution"
    class_name: ClassVar[str] = "FluxnovaCaseExecution"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaCaseExecution

    id: Union[str, FluxnovaCaseExecutionId] = None
    case_instance_id: Optional[Union[str, FluxnovaCaseExecutionId]] = None
    super_case_execution_id: Optional[str] = None
    super_execution_id: Optional[str] = None
    business_key: Optional[str] = None
    parent_id: Optional[Union[str, FluxnovaCaseExecutionId]] = None
    case_definition_id: Optional[Union[str, FluxnovaCaseDefinitionId]] = None
    activity_id: Optional[str] = None
    previous_state: Optional[int] = None
    current_state: Optional[int] = None
    is_required: Optional[Union[bool, Bool]] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaCaseExecutionId):
            self.id = FluxnovaCaseExecutionId(self.id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, FluxnovaCaseExecutionId):
            self.case_instance_id = FluxnovaCaseExecutionId(self.case_instance_id)

        if self.super_case_execution_id is not None and not isinstance(self.super_case_execution_id, str):
            self.super_case_execution_id = str(self.super_case_execution_id)

        if self.super_execution_id is not None and not isinstance(self.super_execution_id, str):
            self.super_execution_id = str(self.super_execution_id)

        if self.business_key is not None and not isinstance(self.business_key, str):
            self.business_key = str(self.business_key)

        if self.parent_id is not None and not isinstance(self.parent_id, FluxnovaCaseExecutionId):
            self.parent_id = FluxnovaCaseExecutionId(self.parent_id)

        if self.case_definition_id is not None and not isinstance(self.case_definition_id, FluxnovaCaseDefinitionId):
            self.case_definition_id = FluxnovaCaseDefinitionId(self.case_definition_id)

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
class FluxnovaCaseSentryPart(YAMLRoot):
    """
    Case Sentry Part entity in the process execution runtime.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaCaseSentryPart"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaCaseSentryPart"
    class_name: ClassVar[str] = "FluxnovaCaseSentryPart"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaCaseSentryPart

    id: Union[str, FluxnovaCaseSentryPartId] = None
    case_instance_id: Optional[Union[str, FluxnovaCaseExecutionId]] = None
    case_execution_id: Optional[Union[str, FluxnovaCaseExecutionId]] = None
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
        if not isinstance(self.id, FluxnovaCaseSentryPartId):
            self.id = FluxnovaCaseSentryPartId(self.id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, FluxnovaCaseExecutionId):
            self.case_instance_id = FluxnovaCaseExecutionId(self.case_instance_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, FluxnovaCaseExecutionId):
            self.case_execution_id = FluxnovaCaseExecutionId(self.case_execution_id)

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
class FluxnovaComment(YAMLRoot):
    """
    User comments that form discussions around tasks.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaComment"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaComment"
    class_name: ClassVar[str] = "FluxnovaComment"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaComment

    id: Union[str, FluxnovaCommentId] = None
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
        if not isinstance(self.id, FluxnovaCommentId):
            self.id = FluxnovaCommentId(self.id)

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
class FluxnovaConfiguration(YAMLRoot):
    """
    A process configuration entry: a key/value pair which is either global or scoped to a single tenant.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaConfiguration"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaConfiguration"
    class_name: ClassVar[str] = "FluxnovaConfiguration"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaConfiguration

    id: Union[str, FluxnovaConfigurationId] = None
    configuration_key: str = None
    configuration_value: str = None
    version: int = 1
    status: Union[str, "ConfigurationStatus"] = 'ACTIVE'
    tenant_id: Optional[str] = None
    created_by: Optional[str] = None
    created_at: Optional[Union[str, XSDDateTime]] = None
    updated_by: Optional[str] = None
    updated_at: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaConfigurationId):
            self.id = FluxnovaConfigurationId(self.id)

        if self._is_empty(self.configuration_key):
            self.MissingRequiredField("configuration_key")
        if not isinstance(self.configuration_key, str):
            self.configuration_key = str(self.configuration_key)

        if self._is_empty(self.configuration_value):
            self.MissingRequiredField("configuration_value")
        if not isinstance(self.configuration_value, str):
            self.configuration_value = str(self.configuration_value)

        if self._is_empty(self.version):
            self.MissingRequiredField("version")
        if not isinstance(self.version, int):
            self.version = int(self.version)

        if self._is_empty(self.status):
            self.MissingRequiredField("status")
        if not isinstance(self.status, ConfigurationStatus):
            self.status = ConfigurationStatus(self.status)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.created_by is not None and not isinstance(self.created_by, str):
            self.created_by = str(self.created_by)

        if self.created_at is not None and not isinstance(self.created_at, XSDDateTime):
            self.created_at = XSDDateTime(self.created_at)

        if self.updated_by is not None and not isinstance(self.updated_by, str):
            self.updated_by = str(self.updated_by)

        if self.updated_at is not None and not isinstance(self.updated_at, XSDDateTime):
            self.updated_at = XSDDateTime(self.updated_at)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaDeployment(YAMLRoot):
    """
    Represents a deployment that is already present in the process repository.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaDeployment"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaDeployment"
    class_name: ClassVar[str] = "FluxnovaDeployment"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaDeployment

    id: Union[str, FluxnovaDeploymentId] = None
    name: Optional[str] = None
    deploy_time: Optional[Union[str, XSDDateTime]] = None
    source: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaDeploymentId):
            self.id = FluxnovaDeploymentId(self.id)

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
class FluxnovaEventSubscription(YAMLRoot):
    """
    A message event subscription exists, if an Execution waits for an event like a message.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaEventSubscription"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaEventSubscription"
    class_name: ClassVar[str] = "FluxnovaEventSubscription"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaEventSubscription

    id: Union[str, FluxnovaEventSubscriptionId] = None
    event_type: str = None
    created: Union[str, XSDDateTime] = None
    event_name: Optional[str] = None
    execution_id: Optional[Union[str, FluxnovaExecutionId]] = None
    process_instance_id: Optional[str] = None
    activity_id: Optional[str] = None
    configuration: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaEventSubscriptionId):
            self.id = FluxnovaEventSubscriptionId(self.id)

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

        if self.execution_id is not None and not isinstance(self.execution_id, FluxnovaExecutionId):
            self.execution_id = FluxnovaExecutionId(self.execution_id)

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
class FluxnovaExecution(YAMLRoot):
    """
    Represent a 'path of execution' in a process instance.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaExecution"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaExecution"
    class_name: ClassVar[str] = "FluxnovaExecution"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaExecution

    id: Union[str, FluxnovaExecutionId] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[Union[str, FluxnovaExecutionId]] = None
    business_key: Optional[str] = None
    parent_id: Optional[Union[str, FluxnovaExecutionId]] = None
    process_definition_id: Optional[Union[str, FluxnovaProcessDefinitionId]] = None
    super_execution_id: Optional[Union[str, FluxnovaExecutionId]] = None
    super_case_execution_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    activity_instance_id: Optional[str] = None
    activity_id: Optional[str] = None
    is_active: Optional[Union[bool, Bool]] = None
    is_concurrent: Optional[Union[bool, Bool]] = None
    is_scope: Optional[Union[bool, Bool]] = None
    is_event_scope: Optional[Union[bool, Bool]] = None
    suspension_state: Optional[int] = None
    cached_entity_state: Optional[int] = None
    sequence_counter: Optional[int] = None
    tenant_id: Optional[str] = None
    process_definition_key: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaExecutionId):
            self.id = FluxnovaExecutionId(self.id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, FluxnovaExecutionId):
            self.process_instance_id = FluxnovaExecutionId(self.process_instance_id)

        if self.business_key is not None and not isinstance(self.business_key, str):
            self.business_key = str(self.business_key)

        if self.parent_id is not None and not isinstance(self.parent_id, FluxnovaExecutionId):
            self.parent_id = FluxnovaExecutionId(self.parent_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, FluxnovaProcessDefinitionId):
            self.process_definition_id = FluxnovaProcessDefinitionId(self.process_definition_id)

        if self.super_execution_id is not None and not isinstance(self.super_execution_id, FluxnovaExecutionId):
            self.super_execution_id = FluxnovaExecutionId(self.super_execution_id)

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

        if self.suspension_state is not None and not isinstance(self.suspension_state, int):
            self.suspension_state = int(self.suspension_state)

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
class FluxnovaExternalTask(YAMLRoot):
    """
    Represents an instance of an external task that is created when a service-task like activity (i.e. service task,
    send task, ...) with attribute camunda:type="external" is executed.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaExternalTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaExternalTask"
    class_name: ClassVar[str] = "FluxnovaExternalTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaExternalTask

    id: Union[str, FluxnovaExternalTaskId] = None
    priority: int = 0
    worker_id: Optional[str] = None
    topic_name: Optional[str] = None
    retries: Optional[int] = None
    error_message: Optional[str] = None
    error_details_id: Optional[Union[str, FluxnovaByteArrayId]] = None
    lock_expiration_time: Optional[Union[str, XSDDateTime]] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    suspension_state: Optional[int] = None
    execution_id: Optional[Union[str, FluxnovaExecutionId]] = None
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
        if not isinstance(self.id, FluxnovaExternalTaskId):
            self.id = FluxnovaExternalTaskId(self.id)

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

        if self.error_details_id is not None and not isinstance(self.error_details_id, FluxnovaByteArrayId):
            self.error_details_id = FluxnovaByteArrayId(self.error_details_id)

        if self.lock_expiration_time is not None and not isinstance(self.lock_expiration_time, XSDDateTime):
            self.lock_expiration_time = XSDDateTime(self.lock_expiration_time)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.suspension_state is not None and not isinstance(self.suspension_state, int):
            self.suspension_state = int(self.suspension_state)

        if self.execution_id is not None and not isinstance(self.execution_id, FluxnovaExecutionId):
            self.execution_id = FluxnovaExecutionId(self.execution_id)

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
class FluxnovaFilter(YAMLRoot):
    """
    Filter entity in the user collaboration.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaFilter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaFilter"
    class_name: ClassVar[str] = "FluxnovaFilter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFilter

    id: Union[str, FluxnovaFilterId] = None
    resource_type: str = None
    name: str = None
    query: str = None
    owner: Optional[str] = None
    properties: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaFilterId):
            self.id = FluxnovaFilterId(self.id)

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
class FluxnovaGroup(YAMLRoot):
    """
    Represents a group, used in IdentityService.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaGroup"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaGroup"
    class_name: ClassVar[str] = "FluxnovaGroup"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaGroup

    id: Union[str, FluxnovaGroupId] = None
    name: Optional[str] = None
    type: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaGroupId):
            self.id = FluxnovaGroupId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaHistoricBatch(YAMLRoot):
    """
    Historic representation of a Batch.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricBatch"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricBatch"
    class_name: ClassVar[str] = "FluxnovaHistoricBatch"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricBatch

    id: Union[str, FluxnovaHistoricBatchId] = None
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
        if not isinstance(self.id, FluxnovaHistoricBatchId):
            self.id = FluxnovaHistoricBatchId(self.id)

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
class FluxnovaHistoricDecisionInputInstance(YAMLRoot):
    """
    Represents one input variable of a decision evaluation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricDecisionInputInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricDecisionInputInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricDecisionInputInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInputInstance

    id: Union[str, FluxnovaHistoricDecisionInputInstanceId] = None
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
        if not isinstance(self.id, FluxnovaHistoricDecisionInputInstanceId):
            self.id = FluxnovaHistoricDecisionInputInstanceId(self.id)

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
class FluxnovaHistoricDecisionInstance(YAMLRoot):
    """
    Represents one evaluation of a decision.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricDecisionInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricDecisionInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricDecisionInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance

    id: Union[str, FluxnovaHistoricDecisionInstanceId] = None
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
        if not isinstance(self.id, FluxnovaHistoricDecisionInstanceId):
            self.id = FluxnovaHistoricDecisionInstanceId(self.id)

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
class FluxnovaHistoricDecisionOutputInstance(YAMLRoot):
    """
    Represents one output variable of a decision evaluation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricDecisionOutputInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricDecisionOutputInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricDecisionOutputInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionOutputInstance

    id: Union[str, FluxnovaHistoricDecisionOutputInstanceId] = None
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
        if not isinstance(self.id, FluxnovaHistoricDecisionOutputInstanceId):
            self.id = FluxnovaHistoricDecisionOutputInstanceId(self.id)

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
class FluxnovaHistoricDetail(YAMLRoot):
    """
    Base class for all kinds of information that is related to either a HistoricProcessInstance or a
    HistoricActivityInstance.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricDetail"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricDetail"
    class_name: ClassVar[str] = "FluxnovaHistoricDetail"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail

    id: Union[str, FluxnovaHistoricDetailId] = None
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
        if not isinstance(self.id, FluxnovaHistoricDetailId):
            self.id = FluxnovaHistoricDetailId(self.id)

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
class FluxnovaHistoricExternalTaskLog(YAMLRoot):
    """
    The HistoricExternalTaskLog is used to have a log containing information about task execution.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricExternalTaskLog"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricExternalTaskLog"
    class_name: ClassVar[str] = "FluxnovaHistoricExternalTaskLog"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog

    id: Union[str, FluxnovaHistoricExternalTaskLogId] = None
    timestamp: Union[str, XSDDateTime] = None
    external_task_id: str = None
    priority: int = 0
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
    state: Optional[int] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaHistoricExternalTaskLogId):
            self.id = FluxnovaHistoricExternalTaskLogId(self.id)

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

        if self.state is not None and not isinstance(self.state, int):
            self.state = int(self.state)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaHistoricIdentityLink(YAMLRoot):
    """
    An historic identity link stores the association of a task with a certain identity.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricIdentityLink"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricIdentityLink"
    class_name: ClassVar[str] = "FluxnovaHistoricIdentityLink"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink

    id: Union[str, FluxnovaHistoricIdentityLinkId] = None
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
        if not isinstance(self.id, FluxnovaHistoricIdentityLinkId):
            self.id = FluxnovaHistoricIdentityLinkId(self.id)

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
class FluxnovaHistoricIncident(YAMLRoot):
    """
    Represents a historic incident that is stored permanently.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricIncident"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricIncident"
    class_name: ClassVar[str] = "FluxnovaHistoricIncident"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident

    id: Union[str, FluxnovaHistoricIncidentId] = None
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
    incident_state: Optional[int] = None
    tenant_id: Optional[str] = None
    job_definition_id: Optional[str] = None
    annotation: Optional[str] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaHistoricIncidentId):
            self.id = FluxnovaHistoricIncidentId(self.id)

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

        if self.incident_state is not None and not isinstance(self.incident_state, int):
            self.incident_state = int(self.incident_state)

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
class FluxnovaHistoricJobLog(YAMLRoot):
    """
    The HistoricJobLog is used to have a log containing information about job execution.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricJobLog"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricJobLog"
    class_name: ClassVar[str] = "FluxnovaHistoricJobLog"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog

    id: Union[str, FluxnovaHistoricJobLogId] = None
    timestamp: Union[str, XSDDateTime] = None
    job_id: str = None
    job_priority: int = 0
    job_due_date: Optional[Union[str, XSDDateTime]] = None
    job_retries: Optional[int] = None
    job_exception_message: Optional[str] = None
    job_exception_stack_id: Optional[str] = None
    job_state: Optional[int] = None
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
        if not isinstance(self.id, FluxnovaHistoricJobLogId):
            self.id = FluxnovaHistoricJobLogId(self.id)

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

        if self.job_state is not None and not isinstance(self.job_state, int):
            self.job_state = int(self.job_state)

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
class FluxnovaHistoricScopeInstance(YAMLRoot):
    """
    Abstract base of the historic process, activity, task, case and case activity instances, with the columns all five
    tables have.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricScopeInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricScopeInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricScopeInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricScopeInstance

    id: Union[str, FluxnovaHistoricScopeInstanceId] = None
    duration: Optional[int] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaHistoricScopeInstanceId):
            self.id = FluxnovaHistoricScopeInstanceId(self.id)

        if self.duration is not None and not isinstance(self.duration, int):
            self.duration = int(self.duration)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaHistoricActivityInstance(FluxnovaHistoricScopeInstance):
    """
    Represents one execution of an activity and it's stored permanent for statistics, audit and other business
    intelligence purposes.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricActivityInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricActivityInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricActivityInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance

    id: Union[str, FluxnovaHistoricActivityInstanceId] = None
    process_definition_id: str = None
    process_instance_id: str = None
    execution_id: str = None
    activity_id: str = None
    activity_type: str = None
    start_time: Union[str, XSDDateTime] = None
    parent_activity_instance_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    task_id: Optional[str] = None
    called_process_instance_id: Optional[str] = None
    called_case_instance_id: Optional[str] = None
    activity_name: Optional[str] = None
    assignee: Optional[str] = None
    end_time: Optional[Union[str, XSDDateTime]] = None
    activity_instance_state: Optional[int] = None
    sequence_counter: Optional[int] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaHistoricActivityInstanceId):
            self.id = FluxnovaHistoricActivityInstanceId(self.id)

        if self._is_empty(self.process_definition_id):
            self.MissingRequiredField("process_definition_id")
        if not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self._is_empty(self.process_instance_id):
            self.MissingRequiredField("process_instance_id")
        if not isinstance(self.process_instance_id, str):
            self.process_instance_id = str(self.process_instance_id)

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

        if self._is_empty(self.start_time):
            self.MissingRequiredField("start_time")
        if not isinstance(self.start_time, XSDDateTime):
            self.start_time = XSDDateTime(self.start_time)

        if self.parent_activity_instance_id is not None and not isinstance(self.parent_activity_instance_id, str):
            self.parent_activity_instance_id = str(self.parent_activity_instance_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

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

        if self.end_time is not None and not isinstance(self.end_time, XSDDateTime):
            self.end_time = XSDDateTime(self.end_time)

        if self.activity_instance_state is not None and not isinstance(self.activity_instance_state, int):
            self.activity_instance_state = int(self.activity_instance_state)

        if self.sequence_counter is not None and not isinstance(self.sequence_counter, int):
            self.sequence_counter = int(self.sequence_counter)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaHistoricCaseActivityInstance(FluxnovaHistoricScopeInstance):
    """
    Represents one execution of a case activity which is stored permanent for statistics, audit and other business
    intelligence purposes.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricCaseActivityInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricCaseActivityInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricCaseActivityInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance

    id: Union[str, FluxnovaHistoricCaseActivityInstanceId] = None
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
    end_time: Optional[Union[str, XSDDateTime]] = None
    state: Optional[int] = None
    is_required: Optional[Union[bool, Bool]] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaHistoricCaseActivityInstanceId):
            self.id = FluxnovaHistoricCaseActivityInstanceId(self.id)

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

        if self.end_time is not None and not isinstance(self.end_time, XSDDateTime):
            self.end_time = XSDDateTime(self.end_time)

        if self.state is not None and not isinstance(self.state, int):
            self.state = int(self.state)

        if self.is_required is not None and not isinstance(self.is_required, Bool):
            self.is_required = Bool(self.is_required)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaHistoricCaseInstance(FluxnovaHistoricScopeInstance):
    """
    A single execution of a case definition that is stored permanently.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricCaseInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricCaseInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricCaseInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseInstance

    id: Union[str, FluxnovaHistoricCaseInstanceId] = None
    case_instance_id: str = None
    case_definition_id: str = None
    create_time: Union[str, XSDDateTime] = None
    business_key: Optional[str] = None
    close_time: Optional[Union[str, XSDDateTime]] = None
    state: Optional[int] = None
    create_user_id: Optional[str] = None
    super_case_instance_id: Optional[str] = None
    super_process_instance_id: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaHistoricCaseInstanceId):
            self.id = FluxnovaHistoricCaseInstanceId(self.id)

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

        if self.state is not None and not isinstance(self.state, int):
            self.state = int(self.state)

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
class FluxnovaHistoricProcessInstance(FluxnovaHistoricScopeInstance):
    """
    A single execution of a whole process definition that is stored permanently.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricProcessInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricProcessInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricProcessInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance

    id: Union[str, FluxnovaHistoricProcessInstanceId] = None
    process_instance_id: str = None
    process_definition_id: str = None
    start_time: Union[str, XSDDateTime] = None
    business_key: Optional[str] = None
    process_definition_key: Optional[str] = None
    end_time: Optional[Union[str, XSDDateTime]] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    start_user_id: Optional[str] = None
    start_activity_id: Optional[str] = None
    end_activity_id: Optional[str] = None
    super_process_instance_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    super_case_instance_id: Optional[str] = None
    case_instance_id: Optional[str] = None
    delete_reason: Optional[str] = None
    state: Optional[Union[str, "HistoricProcessInstanceState"]] = None
    restarted_process_instance_id: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaHistoricProcessInstanceId):
            self.id = FluxnovaHistoricProcessInstanceId(self.id)

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

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.end_time is not None and not isinstance(self.end_time, XSDDateTime):
            self.end_time = XSDDateTime(self.end_time)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.start_user_id is not None and not isinstance(self.start_user_id, str):
            self.start_user_id = str(self.start_user_id)

        if self.start_activity_id is not None and not isinstance(self.start_activity_id, str):
            self.start_activity_id = str(self.start_activity_id)

        if self.end_activity_id is not None and not isinstance(self.end_activity_id, str):
            self.end_activity_id = str(self.end_activity_id)

        if self.super_process_instance_id is not None and not isinstance(self.super_process_instance_id, str):
            self.super_process_instance_id = str(self.super_process_instance_id)

        if self.root_process_instance_id is not None and not isinstance(self.root_process_instance_id, str):
            self.root_process_instance_id = str(self.root_process_instance_id)

        if self.super_case_instance_id is not None and not isinstance(self.super_case_instance_id, str):
            self.super_case_instance_id = str(self.super_case_instance_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.delete_reason is not None and not isinstance(self.delete_reason, str):
            self.delete_reason = str(self.delete_reason)

        if self.state is not None and not isinstance(self.state, HistoricProcessInstanceState):
            self.state = HistoricProcessInstanceState(self.state)

        if self.restarted_process_instance_id is not None and not isinstance(self.restarted_process_instance_id, str):
            self.restarted_process_instance_id = str(self.restarted_process_instance_id)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaHistoricTaskInstance(FluxnovaHistoricScopeInstance):
    """
    Represents a historic task instance (waiting, finished or deleted) that is stored permanent for statistics, audit
    and other business intelligence purposes.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricTaskInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricTaskInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricTaskInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance

    id: Union[str, FluxnovaHistoricTaskInstanceId] = None
    start_time: Union[str, XSDDateTime] = None
    task_definition_key: Optional[str] = None
    process_definition_key: Optional[str] = None
    process_definition_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
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
    end_time: Optional[Union[str, XSDDateTime]] = None
    delete_reason: Optional[str] = None
    priority: Optional[int] = None
    due_date: Optional[Union[str, XSDDateTime]] = None
    follow_up_date: Optional[Union[str, XSDDateTime]] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    task_state: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaHistoricTaskInstanceId):
            self.id = FluxnovaHistoricTaskInstanceId(self.id)

        if self._is_empty(self.start_time):
            self.MissingRequiredField("start_time")
        if not isinstance(self.start_time, XSDDateTime):
            self.start_time = XSDDateTime(self.start_time)

        if self.task_definition_key is not None and not isinstance(self.task_definition_key, str):
            self.task_definition_key = str(self.task_definition_key)

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

        if self.end_time is not None and not isinstance(self.end_time, XSDDateTime):
            self.end_time = XSDDateTime(self.end_time)

        if self.delete_reason is not None and not isinstance(self.delete_reason, str):
            self.delete_reason = str(self.delete_reason)

        if self.priority is not None and not isinstance(self.priority, int):
            self.priority = int(self.priority)

        if self.due_date is not None and not isinstance(self.due_date, XSDDateTime):
            self.due_date = XSDDateTime(self.due_date)

        if self.follow_up_date is not None and not isinstance(self.follow_up_date, XSDDateTime):
            self.follow_up_date = XSDDateTime(self.follow_up_date)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.task_state is not None and not isinstance(self.task_state, str):
            self.task_state = str(self.task_state)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaHistoricVariableInstance(YAMLRoot):
    """
    A single process variable containing the last value when its process instance has finished.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaHistoricVariableInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaHistoricVariableInstance"
    class_name: ClassVar[str] = "FluxnovaHistoricVariableInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance

    id: Union[str, FluxnovaHistoricVariableInstanceId] = None
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
    state: Optional[Union[str, "HistoricVariableInstanceState"]] = None
    removal_time: Optional[Union[str, XSDDateTime]] = None
    restricted: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaHistoricVariableInstanceId):
            self.id = FluxnovaHistoricVariableInstanceId(self.id)

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

        if self.state is not None and not isinstance(self.state, HistoricVariableInstanceState):
            self.state = HistoricVariableInstanceState(self.state)

        if self.removal_time is not None and not isinstance(self.removal_time, XSDDateTime):
            self.removal_time = XSDDateTime(self.removal_time)

        if self.restricted is not None and not isinstance(self.restricted, Bool):
            self.restricted = Bool(self.restricted)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaIdentityInfo(YAMLRoot):
    """
    Identity Info entity in the identity and access management.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaIdentityInfo"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaIdentityInfo"
    class_name: ClassVar[str] = "FluxnovaIdentityInfo"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaIdentityInfo

    id: Union[str, FluxnovaIdentityInfoId] = None
    user_id: Optional[str] = None
    type: Optional[str] = None
    key: Optional[str] = None
    value: Optional[str] = None
    password: Optional[str] = None
    parent_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaIdentityInfoId):
            self.id = FluxnovaIdentityInfoId(self.id)

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
class FluxnovaIdentityLink(YAMLRoot):
    """
    An identity link is used to associate a task with a certain identity.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaIdentityLink"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaIdentityLink"
    class_name: ClassVar[str] = "FluxnovaIdentityLink"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaIdentityLink

    id: Union[str, FluxnovaIdentityLinkId] = None
    group_id: Optional[str] = None
    type: Optional[str] = None
    user_id: Optional[str] = None
    task_id: Optional[Union[str, FluxnovaTaskId]] = None
    process_definition_id: Optional[Union[str, FluxnovaProcessDefinitionId]] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaIdentityLinkId):
            self.id = FluxnovaIdentityLinkId(self.id)

        if self.group_id is not None and not isinstance(self.group_id, str):
            self.group_id = str(self.group_id)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.user_id is not None and not isinstance(self.user_id, str):
            self.user_id = str(self.user_id)

        if self.task_id is not None and not isinstance(self.task_id, FluxnovaTaskId):
            self.task_id = FluxnovaTaskId(self.task_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, FluxnovaProcessDefinitionId):
            self.process_definition_id = FluxnovaProcessDefinitionId(self.process_definition_id)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaIncident(YAMLRoot):
    """
    An Incident represents a failure in the execution of a process instance.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaIncident"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaIncident"
    class_name: ClassVar[str] = "FluxnovaIncident"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaIncident

    id: Union[str, FluxnovaIncidentId] = None
    incident_timestamp: Union[str, XSDDateTime] = None
    incident_type: str = None
    incident_message: Optional[str] = None
    execution_id: Optional[Union[str, FluxnovaExecutionId]] = None
    activity_id: Optional[str] = None
    failed_activity_id: Optional[str] = None
    process_instance_id: Optional[Union[str, FluxnovaExecutionId]] = None
    process_definition_id: Optional[Union[str, FluxnovaProcessDefinitionId]] = None
    cause_incident_id: Optional[Union[str, FluxnovaIncidentId]] = None
    root_cause_incident_id: Optional[Union[str, FluxnovaIncidentId]] = None
    configuration: Optional[str] = None
    tenant_id: Optional[str] = None
    job_definition_id: Optional[Union[str, FluxnovaJobDefinitionId]] = None
    annotation: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaIncidentId):
            self.id = FluxnovaIncidentId(self.id)

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

        if self.execution_id is not None and not isinstance(self.execution_id, FluxnovaExecutionId):
            self.execution_id = FluxnovaExecutionId(self.execution_id)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.failed_activity_id is not None and not isinstance(self.failed_activity_id, str):
            self.failed_activity_id = str(self.failed_activity_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, FluxnovaExecutionId):
            self.process_instance_id = FluxnovaExecutionId(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, FluxnovaProcessDefinitionId):
            self.process_definition_id = FluxnovaProcessDefinitionId(self.process_definition_id)

        if self.cause_incident_id is not None and not isinstance(self.cause_incident_id, FluxnovaIncidentId):
            self.cause_incident_id = FluxnovaIncidentId(self.cause_incident_id)

        if self.root_cause_incident_id is not None and not isinstance(self.root_cause_incident_id, FluxnovaIncidentId):
            self.root_cause_incident_id = FluxnovaIncidentId(self.root_cause_incident_id)

        if self.configuration is not None and not isinstance(self.configuration, str):
            self.configuration = str(self.configuration)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.job_definition_id is not None and not isinstance(self.job_definition_id, FluxnovaJobDefinitionId):
            self.job_definition_id = FluxnovaJobDefinitionId(self.job_definition_id)

        if self.annotation is not None and not isinstance(self.annotation, str):
            self.annotation = str(self.annotation)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaJob(YAMLRoot):
    """
    Represents one job (timer, message, etc.).
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaJob"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaJob"
    class_name: ClassVar[str] = "FluxnovaJob"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaJob

    id: Union[str, FluxnovaJobId] = None
    type: str = None
    suspension_state: int = 1
    priority: int = 0
    lock_expiration_time: Optional[Union[str, XSDDateTime]] = None
    lock_owner: Optional[str] = None
    is_exclusive: Optional[Union[bool, Bool]] = None
    execution_id: Optional[str] = None
    root_process_instance_id: Optional[str] = None
    process_instance_id: Optional[str] = None
    process_definition_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    retries: Optional[int] = None
    exception_stack_id: Optional[Union[str, FluxnovaByteArrayId]] = None
    exception_message: Optional[str] = None
    failed_activity_id: Optional[str] = None
    due_date: Optional[Union[str, XSDDateTime]] = None
    repeat: Optional[str] = None
    repeat_offset: Optional[int] = 0
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
        if not isinstance(self.id, FluxnovaJobId):
            self.id = FluxnovaJobId(self.id)

        if self._is_empty(self.type):
            self.MissingRequiredField("type")
        if not isinstance(self.type, str):
            self.type = str(self.type)

        if self._is_empty(self.suspension_state):
            self.MissingRequiredField("suspension_state")
        if not isinstance(self.suspension_state, int):
            self.suspension_state = int(self.suspension_state)

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

        if self.exception_stack_id is not None and not isinstance(self.exception_stack_id, FluxnovaByteArrayId):
            self.exception_stack_id = FluxnovaByteArrayId(self.exception_stack_id)

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
class FluxnovaJobDefinition(YAMLRoot):
    """
    A Job Definition provides details about asynchronous background processing ("Jobs") performed by the process
    engine.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaJobDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaJobDefinition"
    class_name: ClassVar[str] = "FluxnovaJobDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaJobDefinition

    id: Union[str, FluxnovaJobDefinitionId] = None
    job_type: str = None
    process_definition_id: Optional[str] = None
    process_definition_key: Optional[str] = None
    activity_id: Optional[str] = None
    job_configuration: Optional[str] = None
    suspension_state: Optional[int] = None
    job_priority: Optional[int] = None
    tenant_id: Optional[str] = None
    deployment_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaJobDefinitionId):
            self.id = FluxnovaJobDefinitionId(self.id)

        if self._is_empty(self.job_type):
            self.MissingRequiredField("job_type")
        if not isinstance(self.job_type, str):
            self.job_type = str(self.job_type)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.process_definition_key is not None and not isinstance(self.process_definition_key, str):
            self.process_definition_key = str(self.process_definition_key)

        if self.activity_id is not None and not isinstance(self.activity_id, str):
            self.activity_id = str(self.activity_id)

        if self.job_configuration is not None and not isinstance(self.job_configuration, str):
            self.job_configuration = str(self.job_configuration)

        if self.suspension_state is not None and not isinstance(self.suspension_state, int):
            self.suspension_state = int(self.suspension_state)

        if self.job_priority is not None and not isinstance(self.job_priority, int):
            self.job_priority = int(self.job_priority)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.deployment_id is not None and not isinstance(self.deployment_id, str):
            self.deployment_id = str(self.deployment_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaMembership(YAMLRoot):
    """
    Association entity in identity and access management.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaMembership"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaMembership"
    class_name: ClassVar[str] = "FluxnovaMembership"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaMembership

    user_id: Union[str, FluxnovaUserId] = None
    group_id: Union[str, FluxnovaGroupId] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.user_id):
            self.MissingRequiredField("user_id")
        if not isinstance(self.user_id, FluxnovaUserId):
            self.user_id = FluxnovaUserId(self.user_id)

        if self._is_empty(self.group_id):
            self.MissingRequiredField("group_id")
        if not isinstance(self.group_id, FluxnovaGroupId):
            self.group_id = FluxnovaGroupId(self.group_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaMeterLog(YAMLRoot):
    """
    Meter Log entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaMeterLog"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaMeterLog"
    class_name: ClassVar[str] = "FluxnovaMeterLog"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaMeterLog

    id: Union[str, FluxnovaMeterLogId] = None
    name: str = None
    reporter: Optional[str] = None
    value: Optional[int] = None
    timestamp: Optional[Union[str, XSDDateTime]] = None
    milliseconds: Optional[int] = 0

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaMeterLogId):
            self.id = FluxnovaMeterLogId(self.id)

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
class FluxnovaEngineProperty(YAMLRoot):
    """
    Property entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaEngineProperty"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaEngineProperty"
    class_name: ClassVar[str] = "FluxnovaEngineProperty"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaEngineProperty

    name: Union[str, FluxnovaEnginePropertyName] = None
    value: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, FluxnovaEnginePropertyName):
            self.name = FluxnovaEnginePropertyName(self.name)

        if self.value is not None and not isinstance(self.value, str):
            self.value = str(self.value)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaResourceDefinition(YAMLRoot):
    """
    Abstract base of the process, case, decision, decision requirements and form definitions, with the columns all
    five tables have.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaResourceDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaResourceDefinition"
    class_name: ClassVar[str] = "FluxnovaResourceDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaResourceDefinition

    id: Union[str, FluxnovaResourceDefinitionId] = None
    key: Optional[str] = None
    version: Optional[int] = None
    deployment_id: Optional[str] = None
    resource_name: Optional[str] = None
    tenant_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaResourceDefinitionId):
            self.id = FluxnovaResourceDefinitionId(self.id)

        if self.key is not None and not isinstance(self.key, str):
            self.key = str(self.key)

        if self.version is not None and not isinstance(self.version, int):
            self.version = int(self.version)

        if self.deployment_id is not None and not isinstance(self.deployment_id, str):
            self.deployment_id = str(self.deployment_id)

        if self.resource_name is not None and not isinstance(self.resource_name, str):
            self.resource_name = str(self.resource_name)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaCaseDefinition(FluxnovaResourceDefinition):
    """
    A deployed case definition in the process repository.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaCaseDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaCaseDefinition"
    class_name: ClassVar[str] = "FluxnovaCaseDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaCaseDefinition

    id: Union[str, FluxnovaCaseDefinitionId] = None
    key: str = None
    version: int = None
    category: Optional[str] = None
    name: Optional[str] = None
    diagram_resource_name: Optional[str] = None
    history_time_to_live: Optional[int] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaCaseDefinitionId):
            self.id = FluxnovaCaseDefinitionId(self.id)

        if self._is_empty(self.key):
            self.MissingRequiredField("key")
        if not isinstance(self.key, str):
            self.key = str(self.key)

        if self._is_empty(self.version):
            self.MissingRequiredField("version")
        if not isinstance(self.version, int):
            self.version = int(self.version)

        if self.category is not None and not isinstance(self.category, str):
            self.category = str(self.category)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.diagram_resource_name is not None and not isinstance(self.diagram_resource_name, str):
            self.diagram_resource_name = str(self.diagram_resource_name)

        if self.history_time_to_live is not None and not isinstance(self.history_time_to_live, int):
            self.history_time_to_live = int(self.history_time_to_live)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaDecisionDefinition(FluxnovaResourceDefinition):
    """
    Definition of a decision resource.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaDecisionDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaDecisionDefinition"
    class_name: ClassVar[str] = "FluxnovaDecisionDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionDefinition

    id: Union[str, FluxnovaDecisionDefinitionId] = None
    key: str = None
    version: int = None
    category: Optional[str] = None
    name: Optional[str] = None
    diagram_resource_name: Optional[str] = None
    decision_requirements_definition_id: Optional[Union[str, FluxnovaDecisionRequirementsDefinitionId]] = None
    decision_requirements_definition_key: Optional[str] = None
    history_time_to_live: Optional[int] = None
    version_tag: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaDecisionDefinitionId):
            self.id = FluxnovaDecisionDefinitionId(self.id)

        if self._is_empty(self.key):
            self.MissingRequiredField("key")
        if not isinstance(self.key, str):
            self.key = str(self.key)

        if self._is_empty(self.version):
            self.MissingRequiredField("version")
        if not isinstance(self.version, int):
            self.version = int(self.version)

        if self.category is not None and not isinstance(self.category, str):
            self.category = str(self.category)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.diagram_resource_name is not None and not isinstance(self.diagram_resource_name, str):
            self.diagram_resource_name = str(self.diagram_resource_name)

        if self.decision_requirements_definition_id is not None and not isinstance(self.decision_requirements_definition_id, FluxnovaDecisionRequirementsDefinitionId):
            self.decision_requirements_definition_id = FluxnovaDecisionRequirementsDefinitionId(self.decision_requirements_definition_id)

        if self.decision_requirements_definition_key is not None and not isinstance(self.decision_requirements_definition_key, str):
            self.decision_requirements_definition_key = str(self.decision_requirements_definition_key)

        if self.history_time_to_live is not None and not isinstance(self.history_time_to_live, int):
            self.history_time_to_live = int(self.history_time_to_live)

        if self.version_tag is not None and not isinstance(self.version_tag, str):
            self.version_tag = str(self.version_tag)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaDecisionRequirementsDefinition(FluxnovaResourceDefinition):
    """
    Container of DecisionDefinitions which belongs to the same decision requirements graph (i.e. DMN resource).
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaDecisionRequirementsDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaDecisionRequirementsDefinition"
    class_name: ClassVar[str] = "FluxnovaDecisionRequirementsDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionRequirementsDefinition

    id: Union[str, FluxnovaDecisionRequirementsDefinitionId] = None
    key: str = None
    version: int = None
    category: Optional[str] = None
    name: Optional[str] = None
    diagram_resource_name: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaDecisionRequirementsDefinitionId):
            self.id = FluxnovaDecisionRequirementsDefinitionId(self.id)

        if self._is_empty(self.key):
            self.MissingRequiredField("key")
        if not isinstance(self.key, str):
            self.key = str(self.key)

        if self._is_empty(self.version):
            self.MissingRequiredField("version")
        if not isinstance(self.version, int):
            self.version = int(self.version)

        if self.category is not None and not isinstance(self.category, str):
            self.category = str(self.category)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.diagram_resource_name is not None and not isinstance(self.diagram_resource_name, str):
            self.diagram_resource_name = str(self.diagram_resource_name)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaFormDefinition(FluxnovaResourceDefinition):
    """
    An object structure representing a Camunda Form used to present forms to users either when starting a process
    instance or when assigned to a User Task.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaFormDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaFormDefinition"
    class_name: ClassVar[str] = "FluxnovaFormDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFormDefinition

    id: Union[str, FluxnovaFormDefinitionId] = None
    key: str = None
    version: int = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaFormDefinitionId):
            self.id = FluxnovaFormDefinitionId(self.id)

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
class FluxnovaProcessDefinition(FluxnovaResourceDefinition):
    """
    An object structure representing an executable process composed of activities and transitions.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaProcessDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaProcessDefinition"
    class_name: ClassVar[str] = "FluxnovaProcessDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaProcessDefinition

    id: Union[str, FluxnovaProcessDefinitionId] = None
    key: str = None
    version: int = None
    is_startable: Union[bool, Bool] = True
    category: Optional[str] = None
    name: Optional[str] = None
    diagram_resource_name: Optional[str] = None
    has_start_form_key: Optional[Union[bool, Bool]] = None
    suspension_state: Optional[int] = None
    version_tag: Optional[str] = None
    history_time_to_live: Optional[int] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaProcessDefinitionId):
            self.id = FluxnovaProcessDefinitionId(self.id)

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

        if self.category is not None and not isinstance(self.category, str):
            self.category = str(self.category)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.diagram_resource_name is not None and not isinstance(self.diagram_resource_name, str):
            self.diagram_resource_name = str(self.diagram_resource_name)

        if self.has_start_form_key is not None and not isinstance(self.has_start_form_key, Bool):
            self.has_start_form_key = Bool(self.has_start_form_key)

        if self.suspension_state is not None and not isinstance(self.suspension_state, int):
            self.suspension_state = int(self.suspension_state)

        if self.version_tag is not None and not isinstance(self.version_tag, str):
            self.version_tag = str(self.version_tag)

        if self.history_time_to_live is not None and not isinstance(self.history_time_to_live, int):
            self.history_time_to_live = int(self.history_time_to_live)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaSchemaLogEntry(YAMLRoot):
    """
    Schema Log Entry entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaSchemaLogEntry"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaSchemaLogEntry"
    class_name: ClassVar[str] = "FluxnovaSchemaLogEntry"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaSchemaLogEntry

    id: Union[str, FluxnovaSchemaLogEntryId] = None
    timestamp: Optional[Union[str, XSDDateTime]] = None
    version: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaSchemaLogEntryId):
            self.id = FluxnovaSchemaLogEntryId(self.id)

        if self.timestamp is not None and not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

        if self.version is not None and not isinstance(self.version, str):
            self.version = str(self.version)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaTask(YAMLRoot):
    """
    Represents one task for a human user.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaTask"
    class_name: ClassVar[str] = "FluxnovaTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaTask

    id: Union[str, FluxnovaTaskId] = None
    execution_id: Optional[Union[str, FluxnovaExecutionId]] = None
    process_instance_id: Optional[Union[str, FluxnovaExecutionId]] = None
    process_definition_id: Optional[Union[str, FluxnovaProcessDefinitionId]] = None
    case_execution_id: Optional[Union[str, FluxnovaCaseExecutionId]] = None
    case_instance_id: Optional[str] = None
    case_definition_id: Optional[Union[str, FluxnovaCaseDefinitionId]] = None
    name: Optional[str] = None
    parent_task_id: Optional[str] = None
    description: Optional[str] = None
    task_definition_key: Optional[str] = None
    owner: Optional[str] = None
    assignee: Optional[str] = None
    delegation_state: Optional[Union[str, "DelegationState"]] = None
    priority: Optional[int] = None
    create_time: Optional[Union[str, XSDDateTime]] = None
    last_updated: Optional[Union[str, XSDDateTime]] = None
    due_date: Optional[Union[str, XSDDateTime]] = None
    follow_up_date: Optional[Union[str, XSDDateTime]] = None
    suspension_state: Optional[int] = None
    tenant_id: Optional[str] = None
    task_state: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaTaskId):
            self.id = FluxnovaTaskId(self.id)

        if self.execution_id is not None and not isinstance(self.execution_id, FluxnovaExecutionId):
            self.execution_id = FluxnovaExecutionId(self.execution_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, FluxnovaExecutionId):
            self.process_instance_id = FluxnovaExecutionId(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, FluxnovaProcessDefinitionId):
            self.process_definition_id = FluxnovaProcessDefinitionId(self.process_definition_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, FluxnovaCaseExecutionId):
            self.case_execution_id = FluxnovaCaseExecutionId(self.case_execution_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, str):
            self.case_instance_id = str(self.case_instance_id)

        if self.case_definition_id is not None and not isinstance(self.case_definition_id, FluxnovaCaseDefinitionId):
            self.case_definition_id = FluxnovaCaseDefinitionId(self.case_definition_id)

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

        if self.priority is not None and not isinstance(self.priority, int):
            self.priority = int(self.priority)

        if self.create_time is not None and not isinstance(self.create_time, XSDDateTime):
            self.create_time = XSDDateTime(self.create_time)

        if self.last_updated is not None and not isinstance(self.last_updated, XSDDateTime):
            self.last_updated = XSDDateTime(self.last_updated)

        if self.due_date is not None and not isinstance(self.due_date, XSDDateTime):
            self.due_date = XSDDateTime(self.due_date)

        if self.follow_up_date is not None and not isinstance(self.follow_up_date, XSDDateTime):
            self.follow_up_date = XSDDateTime(self.follow_up_date)

        if self.suspension_state is not None and not isinstance(self.suspension_state, int):
            self.suspension_state = int(self.suspension_state)

        if self.tenant_id is not None and not isinstance(self.tenant_id, str):
            self.tenant_id = str(self.tenant_id)

        if self.task_state is not None and not isinstance(self.task_state, str):
            self.task_state = str(self.task_state)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaTaskMeterLog(YAMLRoot):
    """
    Task Meter Log entity in the engine infrastructure.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaTaskMeterLog"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaTaskMeterLog"
    class_name: ClassVar[str] = "FluxnovaTaskMeterLog"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaTaskMeterLog

    id: Union[str, FluxnovaTaskMeterLogId] = None
    assignee_hash: Optional[int] = None
    timestamp: Optional[Union[str, XSDDateTime]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaTaskMeterLogId):
            self.id = FluxnovaTaskMeterLogId(self.id)

        if self.assignee_hash is not None and not isinstance(self.assignee_hash, int):
            self.assignee_hash = int(self.assignee_hash)

        if self.timestamp is not None and not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaTenant(YAMLRoot):
    """
    Represents a tenant, used in IdentityService.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaTenant"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaTenant"
    class_name: ClassVar[str] = "FluxnovaTenant"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaTenant

    id: Union[str, FluxnovaTenantId] = None
    name: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaTenantId):
            self.id = FluxnovaTenantId(self.id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaTenantMembership(YAMLRoot):
    """
    Association entity in identity and access management.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaTenantMembership"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaTenantMembership"
    class_name: ClassVar[str] = "FluxnovaTenantMembership"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaTenantMembership

    id: Union[str, FluxnovaTenantMembershipId] = None
    tenant_id: Union[str, FluxnovaTenantId] = None
    user_id: Optional[Union[str, FluxnovaUserId]] = None
    group_id: Optional[Union[str, FluxnovaGroupId]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaTenantMembershipId):
            self.id = FluxnovaTenantMembershipId(self.id)

        if self._is_empty(self.tenant_id):
            self.MissingRequiredField("tenant_id")
        if not isinstance(self.tenant_id, FluxnovaTenantId):
            self.tenant_id = FluxnovaTenantId(self.tenant_id)

        if self.user_id is not None and not isinstance(self.user_id, FluxnovaUserId):
            self.user_id = FluxnovaUserId(self.user_id)

        if self.group_id is not None and not isinstance(self.group_id, FluxnovaGroupId):
            self.group_id = FluxnovaGroupId(self.group_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaUser(YAMLRoot):
    """
    Represents a user, used in IdentityService.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaUser"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaUser"
    class_name: ClassVar[str] = "FluxnovaUser"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaUser

    id: Union[str, FluxnovaUserId] = None
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
        if not isinstance(self.id, FluxnovaUserId):
            self.id = FluxnovaUserId(self.id)

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
class FluxnovaUserOperationLogEntry(YAMLRoot):
    """
    Log entry about an operation performed by a user.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaUserOperationLogEntry"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaUserOperationLogEntry"
    class_name: ClassVar[str] = "FluxnovaUserOperationLogEntry"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry

    id: Union[str, FluxnovaUserOperationLogEntryId] = None
    timestamp: Union[str, XSDDateTime] = None
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
    job_id: Optional[str] = None
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
    external_task_id: Optional[str] = None
    annotation: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaUserOperationLogEntryId):
            self.id = FluxnovaUserOperationLogEntryId(self.id)

        if self._is_empty(self.timestamp):
            self.MissingRequiredField("timestamp")
        if not isinstance(self.timestamp, XSDDateTime):
            self.timestamp = XSDDateTime(self.timestamp)

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

        if self.job_id is not None and not isinstance(self.job_id, str):
            self.job_id = str(self.job_id)

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

        if self.external_task_id is not None and not isinstance(self.external_task_id, str):
            self.external_task_id = str(self.external_task_id)

        if self.annotation is not None and not isinstance(self.annotation, str):
            self.annotation = str(self.annotation)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class FluxnovaVariableInstance(YAMLRoot):
    """
    A VariableInstance represents a variable in the execution of a process instance.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaVariableInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaVariableInstance"
    class_name: ClassVar[str] = "FluxnovaVariableInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance

    id: Union[str, FluxnovaVariableInstanceId] = None
    type: str = None
    name: str = None
    variable_scope_id: str = None
    execution_id: Optional[Union[str, FluxnovaExecutionId]] = None
    process_instance_id: Optional[Union[str, FluxnovaExecutionId]] = None
    process_definition_id: Optional[str] = None
    case_execution_id: Optional[Union[str, FluxnovaCaseExecutionId]] = None
    case_instance_id: Optional[Union[str, FluxnovaCaseExecutionId]] = None
    task_id: Optional[str] = None
    batch_id: Optional[Union[str, FluxnovaBatchId]] = None
    byte_array_id: Optional[Union[str, FluxnovaByteArrayId]] = None
    double_value: Optional[float] = None
    long_value: Optional[int] = None
    text_value: Optional[str] = None
    text2_value: Optional[str] = None
    sequence_counter: Optional[int] = None
    is_concurrent_local: Optional[Union[bool, Bool]] = None
    tenant_id: Optional[str] = None
    restricted: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.id):
            self.MissingRequiredField("id")
        if not isinstance(self.id, FluxnovaVariableInstanceId):
            self.id = FluxnovaVariableInstanceId(self.id)

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

        if self.execution_id is not None and not isinstance(self.execution_id, FluxnovaExecutionId):
            self.execution_id = FluxnovaExecutionId(self.execution_id)

        if self.process_instance_id is not None and not isinstance(self.process_instance_id, FluxnovaExecutionId):
            self.process_instance_id = FluxnovaExecutionId(self.process_instance_id)

        if self.process_definition_id is not None and not isinstance(self.process_definition_id, str):
            self.process_definition_id = str(self.process_definition_id)

        if self.case_execution_id is not None and not isinstance(self.case_execution_id, FluxnovaCaseExecutionId):
            self.case_execution_id = FluxnovaCaseExecutionId(self.case_execution_id)

        if self.case_instance_id is not None and not isinstance(self.case_instance_id, FluxnovaCaseExecutionId):
            self.case_instance_id = FluxnovaCaseExecutionId(self.case_instance_id)

        if self.task_id is not None and not isinstance(self.task_id, str):
            self.task_id = str(self.task_id)

        if self.batch_id is not None and not isinstance(self.batch_id, FluxnovaBatchId):
            self.batch_id = FluxnovaBatchId(self.batch_id)

        if self.byte_array_id is not None and not isinstance(self.byte_array_id, FluxnovaByteArrayId):
            self.byte_array_id = FluxnovaByteArrayId(self.byte_array_id)

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

        if self.restricted is not None and not isinstance(self.restricted, Bool):
            self.restricted = Bool(self.restricted)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnInteractionNode(YAMLRoot):
    """
    An element a message flow or conversation link can connect, such as a participant, task or event.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnInteractionNode"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnInteractionNode"
    class_name: ClassVar[str] = "BpmnInteractionNode"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnInteractionNode

    bpmn_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bpmn_id is not None and not isinstance(self.bpmn_id, str):
            self.bpmn_id = str(self.bpmn_id)

        super().__post_init__(**kwargs)


@dataclass(repr=False)
class BpmnModelElementInstance(YAMLRoot):
    """
    Any element of a BPMN document that Fluxnova's model API reads, the base of every BPMN class here.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnModelElementInstance"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnModelElementInstance"
    class_name: ClassVar[str] = "BpmnModelElementInstance"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnModelElementInstance

    element_type: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        self.element_type = str(self.class_name)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


    def __new__(cls, *args, **kwargs):

        type_designator = "element_type"
        if not type_designator in kwargs:
            return super().__new__(cls,*args,**kwargs)
        else:
            type_designator_value = kwargs[type_designator]
            target_cls = cls._class_for("class_name", type_designator_value)


            if target_cls is None:
                raise ValueError(f"Wrong type designator value: class {cls.__name__} "
                                 f"has no subclass with ['class_name']='{kwargs[type_designator]}'")
            return super().__new__(target_cls,*args,**kwargs)



@dataclass(repr=False)
class FluxnovaConnector(BpmnModelElementInstance):
    """
    A connector that a service task or message event calls, with its id and its inputs and outputs.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaConnector"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaConnector"
    class_name: ClassVar[str] = "FluxnovaConnector"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaConnector

    connector_id: Union[dict, "FluxnovaConnectorId"] = None
    input_output: Optional[Union[dict, "FluxnovaInputOutput"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.connector_id):
            self.MissingRequiredField("connector_id")
        if not isinstance(self.connector_id, FluxnovaConnectorId):
            self.connector_id = FluxnovaConnectorId(**as_dict(self.connector_id))

        if self.input_output is not None and not isinstance(self.input_output, FluxnovaInputOutput):
            self.input_output = FluxnovaInputOutput(**as_dict(self.input_output))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaConnectorId(BpmnModelElementInstance):
    """
    The id of the connector to call.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaConnectorId"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaConnectorId"
    class_name: ClassVar[str] = "FluxnovaConnectorId"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaConnectorId

    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaConstraint(BpmnModelElementInstance):
    """
    A rule a form field's value must meet, such as required or a maximum length.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaConstraint"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaConstraint"
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
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaEntry(BpmnModelElementInstance):
    """
    One key and value of a map.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaEntry"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaEntry"
    class_name: ClassVar[str] = "FluxnovaEntry"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaEntry

    fluxnova_key: str = None
    value: Optional[Union[dict, "FluxnovaScript", "FluxnovaList", "FluxnovaMap"]] = None
    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.fluxnova_key):
            self.MissingRequiredField("fluxnova_key")
        if not isinstance(self.fluxnova_key, str):
            self.fluxnova_key = str(self.fluxnova_key)

        if self.value is not None and not isinstance(self.value, (FluxnovaScript, FluxnovaList, FluxnovaMap)):
            value = self.value
            for _coerce in (lambda: FluxnovaScript(**as_dict(value)), lambda: FluxnovaList(**as_dict(value)), lambda: FluxnovaMap(**as_dict(value))):
                try:
                    self.value = _coerce()
                    break
                except (ValueError, TypeError):
                    continue
            else:
                raise ValueError(f"None of the candidate types Union[FluxnovaScript, FluxnovaList, FluxnovaMap] could be constructed from {value!r} for slot value")

        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaErrorEventDefinition(BpmnModelElementInstance):
    """
    An error event definition on an external service task, raised when its expression holds.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaErrorEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaErrorEventDefinition"
    class_name: ClassVar[str] = "FluxnovaErrorEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaErrorEventDefinition

    fluxnova_expression: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaExecutionListener(BpmnModelElementInstance):
    """
    Code the engine runs when an execution passes an event of an element, such as its start or end.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaExecutionListener"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaExecutionListener"
    class_name: ClassVar[str] = "FluxnovaExecutionListener"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaExecutionListener

    fluxnova_event: Optional[str] = None
    fluxnova_class: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    bpmn_fields: Optional[Union[Union[dict, "FluxnovaField"], list[Union[dict, "FluxnovaField"]]]] = empty_list()
    script: Optional[Union[dict, "FluxnovaScript"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_event is not None and not isinstance(self.fluxnova_event, str):
            self.fluxnova_event = str(self.fluxnova_event)

        if self.fluxnova_class is not None and not isinstance(self.fluxnova_class, str):
            self.fluxnova_class = str(self.fluxnova_class)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_delegate_expression is not None and not isinstance(self.fluxnova_delegate_expression, str):
            self.fluxnova_delegate_expression = str(self.fluxnova_delegate_expression)

        if not isinstance(self.bpmn_fields, list):
            self.bpmn_fields = [self.bpmn_fields] if self.bpmn_fields is not None else []
        self.bpmn_fields = [v if isinstance(v, FluxnovaField) else FluxnovaField(**as_dict(v)) for v in self.bpmn_fields]

        if self.script is not None and not isinstance(self.script, FluxnovaScript):
            self.script = FluxnovaScript(**as_dict(self.script))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaExpression(BpmnModelElementInstance):
    """
    An expression a field injects.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaExpression"
    class_name: ClassVar[str] = "FluxnovaExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaExpression

    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaFailedJobRetryTimeCycle(BpmnModelElementInstance):
    """
    How often, and how many times, the engine retries a failed job.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaFailedJobRetryTimeCycle"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaFailedJobRetryTimeCycle"
    class_name: ClassVar[str] = "FluxnovaFailedJobRetryTimeCycle"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFailedJobRetryTimeCycle

    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaField(BpmnModelElementInstance):
    """
    A value injected into a field of a delegate class, as a string or an expression.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaField"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaField"
    class_name: ClassVar[str] = "FluxnovaField"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaField

    fluxnova_name: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_string_value: Optional[str] = None
    expression: Optional[Union[dict, FluxnovaExpression]] = None
    string: Optional[Union[dict, "FluxnovaString"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_name is not None and not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_string_value is not None and not isinstance(self.fluxnova_string_value, str):
            self.fluxnova_string_value = str(self.fluxnova_string_value)

        if self.expression is not None and not isinstance(self.expression, FluxnovaExpression):
            self.expression = FluxnovaExpression(**as_dict(self.expression))

        if self.string is not None and not isinstance(self.string, FluxnovaString):
            self.string = FluxnovaString(**as_dict(self.string))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaFormData(BpmnModelElementInstance):
    """
    The form fields of a generated task or start form.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaFormData"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaFormData"
    class_name: ClassVar[str] = "FluxnovaFormData"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFormData

    form_fields: Optional[Union[Union[dict, "FluxnovaFormField"], list[Union[dict, "FluxnovaFormField"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.form_fields, list):
            self.form_fields = [self.form_fields] if self.form_fields is not None else []
        self.form_fields = [v if isinstance(v, FluxnovaFormField) else FluxnovaFormField(**as_dict(v)) for v in self.form_fields]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaFormField(BpmnModelElementInstance):
    """
    One field of a generated form.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaFormField"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaFormField"
    class_name: ClassVar[str] = "FluxnovaFormField"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFormField

    fluxnova_id: Optional[str] = None
    fluxnova_label: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_date_pattern: Optional[str] = None
    fluxnova_default_value: Optional[str] = None
    properties: Optional[Union[dict, "FluxnovaProperties"]] = None
    validation: Optional[Union[dict, "FluxnovaValidation"]] = None
    values: Optional[Union[Union[dict, "FluxnovaValue"], list[Union[dict, "FluxnovaValue"]]]] = empty_list()

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

        if self.properties is not None and not isinstance(self.properties, FluxnovaProperties):
            self.properties = FluxnovaProperties(**as_dict(self.properties))

        if self.validation is not None and not isinstance(self.validation, FluxnovaValidation):
            self.validation = FluxnovaValidation(**as_dict(self.validation))

        if not isinstance(self.values, list):
            self.values = [self.values] if self.values is not None else []
        self.values = [v if isinstance(v, FluxnovaValue) else FluxnovaValue(**as_dict(v)) for v in self.values]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaFormProperty(BpmnModelElementInstance):
    """
    A form property, the older way of declaring a generated form's fields.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaFormProperty"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaFormProperty"
    class_name: ClassVar[str] = "FluxnovaFormProperty"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaFormProperty

    fluxnova_id: Optional[str] = None
    fluxnova_name: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_required: Optional[Union[bool, Bool]] = False
    fluxnova_readable: Optional[Union[bool, Bool]] = True
    fluxnova_writeable: Optional[Union[bool, Bool]] = True
    fluxnova_variable: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_date_pattern: Optional[str] = None
    fluxnova_default: Optional[str] = None
    values: Optional[Union[Union[dict, "FluxnovaValue"], list[Union[dict, "FluxnovaValue"]]]] = empty_list()

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

        if not isinstance(self.values, list):
            self.values = [self.values] if self.values is not None else []
        self.values = [v if isinstance(v, FluxnovaValue) else FluxnovaValue(**as_dict(v)) for v in self.values]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaIn(BpmnModelElementInstance):
    """
    A variable or business key passed into a called process or case.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaIn"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaIn"
    class_name: ClassVar[str] = "FluxnovaIn"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaIn

    fluxnova_source: Optional[str] = None
    fluxnova_source_expression: Optional[str] = None
    fluxnova_variables: Optional[str] = None
    fluxnova_target: Optional[str] = None
    fluxnova_business_key: Optional[str] = None
    fluxnova_local: Optional[Union[bool, Bool]] = None
    fluxnova_restricted: Optional[Union[bool, Bool]] = None

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

        if self.fluxnova_restricted is not None and not isinstance(self.fluxnova_restricted, Bool):
            self.fluxnova_restricted = Bool(self.fluxnova_restricted)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaInputOutput(BpmnModelElementInstance):
    """
    The input and output parameters of an activity or connector.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaInputOutput"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaInputOutput"
    class_name: ClassVar[str] = "FluxnovaInputOutput"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaInputOutput

    input_parameters: Optional[Union[Union[dict, "FluxnovaInputParameter"], list[Union[dict, "FluxnovaInputParameter"]]]] = empty_list()
    output_parameters: Optional[Union[Union[dict, "FluxnovaOutputParameter"], list[Union[dict, "FluxnovaOutputParameter"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        self._normalize_inlined_as_list(slot_name="input_parameters", slot_type=FluxnovaInputParameter, key_name="fluxnova_name", keyed=False)

        self._normalize_inlined_as_list(slot_name="output_parameters", slot_type=FluxnovaOutputParameter, key_name="fluxnova_name", keyed=False)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaInputParameter(BpmnModelElementInstance):
    """
    A variable set in an activity's scope before it starts.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaInputParameter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaInputParameter"
    class_name: ClassVar[str] = "FluxnovaInputParameter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaInputParameter

    fluxnova_name: str = None
    fluxnova_restricted: Optional[Union[bool, Bool]] = None
    fluxnova_is_transient: Optional[Union[bool, Bool]] = False
    value: Optional[Union[dict, "FluxnovaScript", "FluxnovaList", "FluxnovaMap"]] = None
    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.fluxnova_name):
            self.MissingRequiredField("fluxnova_name")
        if not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.fluxnova_restricted is not None and not isinstance(self.fluxnova_restricted, Bool):
            self.fluxnova_restricted = Bool(self.fluxnova_restricted)

        if self.fluxnova_is_transient is not None and not isinstance(self.fluxnova_is_transient, Bool):
            self.fluxnova_is_transient = Bool(self.fluxnova_is_transient)

        if self.value is not None and not isinstance(self.value, (FluxnovaScript, FluxnovaList, FluxnovaMap)):
            value = self.value
            for _coerce in (lambda: FluxnovaScript(**as_dict(value)), lambda: FluxnovaList(**as_dict(value)), lambda: FluxnovaMap(**as_dict(value))):
                try:
                    self.value = _coerce()
                    break
                except (ValueError, TypeError):
                    continue
            else:
                raise ValueError(f"None of the candidate types Union[FluxnovaScript, FluxnovaList, FluxnovaMap] could be constructed from {value!r} for slot value")

        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaList(BpmnModelElementInstance):
    """
    A list value of a parameter.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaList"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaList"
    class_name: ClassVar[str] = "FluxnovaList"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaList

    values: Optional[Union[Union[dict, BpmnModelElementInstance], list[Union[dict, BpmnModelElementInstance]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.values, list):
            self.values = [self.values] if self.values is not None else []
        self.values = [v if isinstance(v, BpmnModelElementInstance) else BpmnModelElementInstance(**as_dict(v)) for v in self.values]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaMap(BpmnModelElementInstance):
    """
    A map value of a parameter.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaMap"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaMap"
    class_name: ClassVar[str] = "FluxnovaMap"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaMap

    entries: Optional[Union[Union[dict, FluxnovaEntry], list[Union[dict, FluxnovaEntry]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        self._normalize_inlined_as_list(slot_name="entries", slot_type=FluxnovaEntry, key_name="fluxnova_key", keyed=False)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaOut(BpmnModelElementInstance):
    """
    A variable passed back from a called process or case.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaOut"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaOut"
    class_name: ClassVar[str] = "FluxnovaOut"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaOut

    fluxnova_source: Optional[str] = None
    fluxnova_source_expression: Optional[str] = None
    fluxnova_variables: Optional[str] = None
    fluxnova_target: Optional[str] = None
    fluxnova_local: Optional[Union[bool, Bool]] = None
    fluxnova_restricted: Optional[Union[bool, Bool]] = None

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

        if self.fluxnova_restricted is not None and not isinstance(self.fluxnova_restricted, Bool):
            self.fluxnova_restricted = Bool(self.fluxnova_restricted)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaOutputParameter(BpmnModelElementInstance):
    """
    A variable set outside an activity once it ends.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaOutputParameter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaOutputParameter"
    class_name: ClassVar[str] = "FluxnovaOutputParameter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaOutputParameter

    fluxnova_name: str = None
    fluxnova_restricted: Optional[Union[bool, Bool]] = None
    fluxnova_is_transient: Optional[Union[bool, Bool]] = False
    value: Optional[Union[dict, "FluxnovaScript", FluxnovaList, FluxnovaMap]] = None
    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.fluxnova_name):
            self.MissingRequiredField("fluxnova_name")
        if not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.fluxnova_restricted is not None and not isinstance(self.fluxnova_restricted, Bool):
            self.fluxnova_restricted = Bool(self.fluxnova_restricted)

        if self.fluxnova_is_transient is not None and not isinstance(self.fluxnova_is_transient, Bool):
            self.fluxnova_is_transient = Bool(self.fluxnova_is_transient)

        if self.value is not None and not isinstance(self.value, (FluxnovaScript, FluxnovaList, FluxnovaMap)):
            value = self.value
            for _coerce in (lambda: FluxnovaScript(**as_dict(value)), lambda: FluxnovaList(**as_dict(value)), lambda: FluxnovaMap(**as_dict(value))):
                try:
                    self.value = _coerce()
                    break
                except (ValueError, TypeError):
                    continue
            else:
                raise ValueError(f"None of the candidate types Union[FluxnovaScript, FluxnovaList, FluxnovaMap] could be constructed from {value!r} for slot value")

        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaPotentialStarter(BpmnModelElementInstance):
    """
    The users or groups who may start a process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaPotentialStarter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaPotentialStarter"
    class_name: ClassVar[str] = "FluxnovaPotentialStarter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaPotentialStarter

    resource_assignment_expression: Optional[Union[dict, "BpmnResourceAssignmentExpression"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.resource_assignment_expression is not None and not isinstance(self.resource_assignment_expression, BpmnResourceAssignmentExpression):
            self.resource_assignment_expression = BpmnResourceAssignmentExpression(**as_dict(self.resource_assignment_expression))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaProperties(BpmnModelElementInstance):
    """
    A set of key and value properties on an element.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaProperties"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaProperties"
    class_name: ClassVar[str] = "FluxnovaProperties"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaProperties

    properties: Optional[Union[Union[dict, "FluxnovaProperty"], list[Union[dict, "FluxnovaProperty"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.properties, list):
            self.properties = [self.properties] if self.properties is not None else []
        self.properties = [v if isinstance(v, FluxnovaProperty) else FluxnovaProperty(**as_dict(v)) for v in self.properties]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaProperty(BpmnModelElementInstance):
    """
    One key and value property.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaProperty"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaProperty"
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
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaScript(BpmnModelElementInstance):
    """
    A script whose result is a value, such as a parameter's or a listener's.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaScript"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaScript"
    class_name: ClassVar[str] = "FluxnovaScript"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaScript

    script_format: str = None
    bpmn_resource: Optional[str] = None
    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.script_format):
            self.MissingRequiredField("script_format")
        if not isinstance(self.script_format, str):
            self.script_format = str(self.script_format)

        if self.bpmn_resource is not None and not isinstance(self.bpmn_resource, str):
            self.bpmn_resource = str(self.bpmn_resource)

        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaString(BpmnModelElementInstance):
    """
    A string a field injects.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaString"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaString"
    class_name: ClassVar[str] = "FluxnovaString"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaString

    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaTaskListener(BpmnModelElementInstance):
    """
    Code the engine runs when a user task reaches an event, such as its creation or completion.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaTaskListener"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaTaskListener"
    class_name: ClassVar[str] = "FluxnovaTaskListener"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaTaskListener

    fluxnova_event: Optional[str] = None
    fluxnova_class: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    bpmn_fields: Optional[Union[Union[dict, FluxnovaField], list[Union[dict, FluxnovaField]]]] = empty_list()
    script: Optional[Union[dict, FluxnovaScript]] = None
    timer_event_definition: Optional[Union[dict, "BpmnTimerEventDefinition"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_event is not None and not isinstance(self.fluxnova_event, str):
            self.fluxnova_event = str(self.fluxnova_event)

        if self.fluxnova_class is not None and not isinstance(self.fluxnova_class, str):
            self.fluxnova_class = str(self.fluxnova_class)

        if self.fluxnova_expression is not None and not isinstance(self.fluxnova_expression, str):
            self.fluxnova_expression = str(self.fluxnova_expression)

        if self.fluxnova_delegate_expression is not None and not isinstance(self.fluxnova_delegate_expression, str):
            self.fluxnova_delegate_expression = str(self.fluxnova_delegate_expression)

        if not isinstance(self.bpmn_fields, list):
            self.bpmn_fields = [self.bpmn_fields] if self.bpmn_fields is not None else []
        self.bpmn_fields = [v if isinstance(v, FluxnovaField) else FluxnovaField(**as_dict(v)) for v in self.bpmn_fields]

        if self.script is not None and not isinstance(self.script, FluxnovaScript):
            self.script = FluxnovaScript(**as_dict(self.script))

        if self.timer_event_definition is not None and not isinstance(self.timer_event_definition, BpmnTimerEventDefinition):
            self.timer_event_definition = BpmnTimerEventDefinition(**as_dict(self.timer_event_definition))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaValidation(BpmnModelElementInstance):
    """
    The constraints of a form field.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaValidation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaValidation"
    class_name: ClassVar[str] = "FluxnovaValidation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaValidation

    bpmn_constraints: Optional[Union[Union[dict, FluxnovaConstraint], list[Union[dict, FluxnovaConstraint]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.bpmn_constraints, list):
            self.bpmn_constraints = [self.bpmn_constraints] if self.bpmn_constraints is not None else []
        self.bpmn_constraints = [v if isinstance(v, FluxnovaConstraint) else FluxnovaConstraint(**as_dict(v)) for v in self.bpmn_constraints]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class FluxnovaValue(BpmnModelElementInstance):
    """
    One option of an enumerated form field.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["FluxnovaValue"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:FluxnovaValue"
    class_name: ClassVar[str] = "FluxnovaValue"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.FluxnovaValue

    fluxnova_id: Optional[str] = None
    fluxnova_name: Optional[str] = None
    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_id is not None and not isinstance(self.fluxnova_id, str):
            self.fluxnova_id = str(self.fluxnova_id)

        if self.fluxnova_name is not None and not isinstance(self.fluxnova_name, str):
            self.fluxnova_name = str(self.fluxnova_name)

        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnBaseElement(BpmnModelElementInstance):
    """
    The base of nearly every BPMN element, giving it an id, documentation and extensions.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnBaseElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnBaseElement"
    class_name: ClassVar[str] = "BpmnBaseElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnBaseElement

    bpmn_id: Optional[str] = None
    bpmn_documentation: Optional[Union[Union[dict, "BpmnDocumentation"], list[Union[dict, "BpmnDocumentation"]]]] = empty_list()
    extension_elements: Optional[Union[dict, "BpmnExtensionElements"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bpmn_id is not None and not isinstance(self.bpmn_id, str):
            self.bpmn_id = str(self.bpmn_id)

        if not isinstance(self.bpmn_documentation, list):
            self.bpmn_documentation = [self.bpmn_documentation] if self.bpmn_documentation is not None else []
        self.bpmn_documentation = [v if isinstance(v, BpmnDocumentation) else BpmnDocumentation(**as_dict(v)) for v in self.bpmn_documentation]

        if self.extension_elements is not None and not isinstance(self.extension_elements, BpmnExtensionElements):
            self.extension_elements = BpmnExtensionElements(**as_dict(self.extension_elements))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnArtifact(BpmnBaseElement):
    """
    An element that adds information to a diagram without changing how the process runs.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnArtifact"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnArtifact"
    class_name: ClassVar[str] = "BpmnArtifact"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnArtifact


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnAssignment(BpmnBaseElement):
    """
    A copy of a value from one expression to another within a data association.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnAssignment"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnAssignment"
    class_name: ClassVar[str] = "BpmnAssignment"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnAssignment

    from_expression: Union[dict, "BpmnFrom"] = None
    to_expression: Union[dict, "BpmnTo"] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.from_expression):
            self.MissingRequiredField("from_expression")
        if not isinstance(self.from_expression, BpmnFrom):
            self.from_expression = BpmnFrom(**as_dict(self.from_expression))

        if self._is_empty(self.to_expression):
            self.MissingRequiredField("to_expression")
        if not isinstance(self.to_expression, BpmnTo):
            self.to_expression = BpmnTo(**as_dict(self.to_expression))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnAssociation(BpmnArtifact):
    """
    A link between an artifact, such as a text annotation, and another element.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnAssociation"
    class_name: ClassVar[str] = "BpmnAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnAssociation

    source_ref: str = None
    target_ref: str = None
    association_direction: Optional[Union[str, "BpmnAssociationDirection"]] = 'None'

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.source_ref):
            self.MissingRequiredField("source_ref")
        if not isinstance(self.source_ref, str):
            self.source_ref = str(self.source_ref)

        if self._is_empty(self.target_ref):
            self.MissingRequiredField("target_ref")
        if not isinstance(self.target_ref, str):
            self.target_ref = str(self.target_ref)

        if self.association_direction is not None and not isinstance(self.association_direction, BpmnAssociationDirection):
            self.association_direction = BpmnAssociationDirection(self.association_direction)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnAuditing(BpmnBaseElement):
    """
    A hook for auditing a process or flow element, left to the implementation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnAuditing"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnAuditing"
    class_name: ClassVar[str] = "BpmnAuditing"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnAuditing


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCategoryValue(BpmnBaseElement):
    """
    One value of a category, which a group shows.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCategoryValue"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCategoryValue"
    class_name: ClassVar[str] = "BpmnCategoryValue"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCategoryValue

    value: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.value is not None and not isinstance(self.value, str):
            self.value = str(self.value)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnComplexBehaviorDefinition(BpmnBaseElement):
    """
    A rule of a multi-instance activity that throws an event when its condition holds as instances complete.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnComplexBehaviorDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnComplexBehaviorDefinition"
    class_name: ClassVar[str] = "BpmnComplexBehaviorDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnComplexBehaviorDefinition


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnConversationAssociation(BpmnBaseElement):
    """
    A link between a conversation node and one that refines it.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnConversationAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnConversationAssociation"
    class_name: ClassVar[str] = "BpmnConversationAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnConversationAssociation

    inner_conversation_node_ref: str = None
    outer_conversation_node_ref: str = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.inner_conversation_node_ref):
            self.MissingRequiredField("inner_conversation_node_ref")
        if not isinstance(self.inner_conversation_node_ref, str):
            self.inner_conversation_node_ref = str(self.inner_conversation_node_ref)

        if self._is_empty(self.outer_conversation_node_ref):
            self.MissingRequiredField("outer_conversation_node_ref")
        if not isinstance(self.outer_conversation_node_ref, str):
            self.outer_conversation_node_ref = str(self.outer_conversation_node_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnConversationLink(BpmnBaseElement):
    """
    A link between a participant and a conversation node.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnConversationLink"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnConversationLink"
    class_name: ClassVar[str] = "BpmnConversationLink"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnConversationLink

    source_ref: str = None
    target_ref: str = None
    name: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.source_ref):
            self.MissingRequiredField("source_ref")
        if not isinstance(self.source_ref, str):
            self.source_ref = str(self.source_ref)

        if self._is_empty(self.target_ref):
            self.MissingRequiredField("target_ref")
        if not isinstance(self.target_ref, str):
            self.target_ref = str(self.target_ref)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnConversationNode(BpmnBaseElement):
    """
    Any node of a conversation diagram, such as a conversation or sub-conversation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnConversationNode"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnConversationNode"
    class_name: ClassVar[str] = "BpmnConversationNode"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnConversationNode

    name: Optional[str] = None
    participant_refs: Optional[Union[str, list[str]]] = empty_list()
    message_flow_refs: Optional[Union[str, list[str]]] = empty_list()
    correlation_keys: Optional[Union[Union[dict, "BpmnCorrelationKey"], list[Union[dict, "BpmnCorrelationKey"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if not isinstance(self.participant_refs, list):
            self.participant_refs = [self.participant_refs] if self.participant_refs is not None else []
        self.participant_refs = [v if isinstance(v, str) else str(v) for v in self.participant_refs]

        if not isinstance(self.message_flow_refs, list):
            self.message_flow_refs = [self.message_flow_refs] if self.message_flow_refs is not None else []
        self.message_flow_refs = [v if isinstance(v, str) else str(v) for v in self.message_flow_refs]

        if not isinstance(self.correlation_keys, list):
            self.correlation_keys = [self.correlation_keys] if self.correlation_keys is not None else []
        self.correlation_keys = [v if isinstance(v, BpmnCorrelationKey) else BpmnCorrelationKey(**as_dict(v)) for v in self.correlation_keys]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCallConversation(BpmnConversationNode):
    """
    A conversation that calls a collaboration or global conversation defined elsewhere.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCallConversation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCallConversation"
    class_name: ClassVar[str] = "BpmnCallConversation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCallConversation

    called_collaboration_ref: Optional[str] = None
    participant_associations: Optional[Union[Union[dict, "BpmnParticipantAssociation"], list[Union[dict, "BpmnParticipantAssociation"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.called_collaboration_ref is not None and not isinstance(self.called_collaboration_ref, str):
            self.called_collaboration_ref = str(self.called_collaboration_ref)

        self._normalize_inlined_as_list(slot_name="participant_associations", slot_type=BpmnParticipantAssociation, key_name="inner_participant_ref", keyed=False)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnConversation(BpmnConversationNode):
    """
    A set of message flows between participants that belong together.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnConversation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnConversation"
    class_name: ClassVar[str] = "BpmnConversation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnConversation


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCorrelationKey(BpmnBaseElement):
    """
    A set of correlation properties that together identify a conversation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCorrelationKey"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCorrelationKey"
    class_name: ClassVar[str] = "BpmnCorrelationKey"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCorrelationKey

    name: Optional[str] = None
    correlation_property_refs: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if not isinstance(self.correlation_property_refs, list):
            self.correlation_property_refs = [self.correlation_property_refs] if self.correlation_property_refs is not None else []
        self.correlation_property_refs = [v if isinstance(v, str) else str(v) for v in self.correlation_property_refs]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCorrelationPropertyBinding(BpmnBaseElement):
    """
    The expression that gives a correlation property its value in a process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCorrelationPropertyBinding"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCorrelationPropertyBinding"
    class_name: ClassVar[str] = "BpmnCorrelationPropertyBinding"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCorrelationPropertyBinding

    correlation_property_ref: str = None
    data_path: Union[dict, "BpmnDataPath"] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.correlation_property_ref):
            self.MissingRequiredField("correlation_property_ref")
        if not isinstance(self.correlation_property_ref, str):
            self.correlation_property_ref = str(self.correlation_property_ref)

        if self._is_empty(self.data_path):
            self.MissingRequiredField("data_path")
        if not isinstance(self.data_path, BpmnDataPath):
            self.data_path = BpmnDataPath(**as_dict(self.data_path))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCorrelationPropertyRetrievalExpression(BpmnBaseElement):
    """
    The expression that reads a correlation property from one message.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCorrelationPropertyRetrievalExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCorrelationPropertyRetrievalExpression"
    class_name: ClassVar[str] = "BpmnCorrelationPropertyRetrievalExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCorrelationPropertyRetrievalExpression

    message_ref: str = None
    message_path: Union[dict, "BpmnMessagePath"] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.message_ref):
            self.MissingRequiredField("message_ref")
        if not isinstance(self.message_ref, str):
            self.message_ref = str(self.message_ref)

        if self._is_empty(self.message_path):
            self.MissingRequiredField("message_path")
        if not isinstance(self.message_path, BpmnMessagePath):
            self.message_path = BpmnMessagePath(**as_dict(self.message_path))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCorrelationSubscription(BpmnBaseElement):
    """
    How a process instance subscribes to messages by a correlation key.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCorrelationSubscription"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCorrelationSubscription"
    class_name: ClassVar[str] = "BpmnCorrelationSubscription"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCorrelationSubscription

    correlation_key_ref: str = None
    correlation_property_bindings: Optional[Union[Union[dict, BpmnCorrelationPropertyBinding], list[Union[dict, BpmnCorrelationPropertyBinding]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.correlation_key_ref):
            self.MissingRequiredField("correlation_key_ref")
        if not isinstance(self.correlation_key_ref, str):
            self.correlation_key_ref = str(self.correlation_key_ref)

        self._normalize_inlined_as_list(slot_name="correlation_property_bindings", slot_type=BpmnCorrelationPropertyBinding, key_name="correlation_property_ref", keyed=False)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataAssociation(BpmnBaseElement):
    """
    A copy of data from sources to a target as an activity or event runs.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataAssociation"
    class_name: ClassVar[str] = "BpmnDataAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataAssociation

    target_ref: str = None
    source_refs: Optional[Union[str, list[str]]] = empty_list()
    transformation: Optional[Union[dict, "BpmnTransformation"]] = None
    assignments: Optional[Union[Union[dict, BpmnAssignment], list[Union[dict, BpmnAssignment]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.target_ref):
            self.MissingRequiredField("target_ref")
        if not isinstance(self.target_ref, str):
            self.target_ref = str(self.target_ref)

        if not isinstance(self.source_refs, list):
            self.source_refs = [self.source_refs] if self.source_refs is not None else []
        self.source_refs = [v if isinstance(v, str) else str(v) for v in self.source_refs]

        if self.transformation is not None and not isinstance(self.transformation, BpmnTransformation):
            self.transformation = BpmnTransformation(**as_dict(self.transformation))

        if not isinstance(self.assignments, list):
            self.assignments = [self.assignments] if self.assignments is not None else []
        self.assignments = [v if isinstance(v, BpmnAssignment) else BpmnAssignment(**as_dict(v)) for v in self.assignments]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataInputAssociation(BpmnDataAssociation):
    """
    A data association that feeds a data input.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataInputAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataInputAssociation"
    class_name: ClassVar[str] = "BpmnDataInputAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataInputAssociation

    target_ref: str = None

    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataOutputAssociation(BpmnDataAssociation):
    """
    A data association that carries a data output on.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataOutputAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataOutputAssociation"
    class_name: ClassVar[str] = "BpmnDataOutputAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataOutputAssociation

    target_ref: str = None

    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataState(BpmnBaseElement):
    """
    The state of a data object or data store, such as draft or approved.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataState"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataState"
    class_name: ClassVar[str] = "BpmnDataState"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataState

    name: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDefinitions(BpmnModelElementInstance):
    """
    The root of a BPMN document, which holds its processes, collaborations and diagrams.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDefinitions"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDefinitions"
    class_name: ClassVar[str] = "BpmnDefinitions"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDefinitions

    target_namespace: str = None
    bpmn_id: Optional[str] = None
    name: Optional[str] = None
    expression_language: Optional[str] = "http://www.w3.org/1999/XPath"
    type_language: Optional[str] = "http://www.w3.org/2001/XMLSchema"
    exporter: Optional[str] = None
    exporter_version: Optional[str] = None
    imports: Optional[Union[Union[dict, "BpmnImport"], list[Union[dict, "BpmnImport"]]]] = empty_list()
    extensions: Optional[Union[Union[dict, "BpmnExtension"], list[Union[dict, "BpmnExtension"]]]] = empty_list()
    root_elements: Optional[Union[Union[dict, "BpmnRootElement"], list[Union[dict, "BpmnRootElement"]]]] = empty_list()
    bpmn_diagrams: Optional[Union[Union[dict, "BpmnDiagram"], list[Union[dict, "BpmnDiagram"]]]] = empty_list()
    relationships: Optional[Union[Union[dict, "BpmnRelationship"], list[Union[dict, "BpmnRelationship"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.target_namespace):
            self.MissingRequiredField("target_namespace")
        if not isinstance(self.target_namespace, str):
            self.target_namespace = str(self.target_namespace)

        if self.bpmn_id is not None and not isinstance(self.bpmn_id, str):
            self.bpmn_id = str(self.bpmn_id)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.expression_language is not None and not isinstance(self.expression_language, str):
            self.expression_language = str(self.expression_language)

        if self.type_language is not None and not isinstance(self.type_language, str):
            self.type_language = str(self.type_language)

        if self.exporter is not None and not isinstance(self.exporter, str):
            self.exporter = str(self.exporter)

        if self.exporter_version is not None and not isinstance(self.exporter_version, str):
            self.exporter_version = str(self.exporter_version)

        self._normalize_inlined_as_list(slot_name="imports", slot_type=BpmnImport, key_name="namespace", keyed=False)

        if not isinstance(self.extensions, list):
            self.extensions = [self.extensions] if self.extensions is not None else []
        self.extensions = [v if isinstance(v, BpmnExtension) else BpmnExtension(**as_dict(v)) for v in self.extensions]

        if not isinstance(self.root_elements, list):
            self.root_elements = [self.root_elements] if self.root_elements is not None else []
        self.root_elements = [v if isinstance(v, BpmnRootElement) else BpmnRootElement(**as_dict(v)) for v in self.root_elements]

        if not isinstance(self.bpmn_diagrams, list):
            self.bpmn_diagrams = [self.bpmn_diagrams] if self.bpmn_diagrams is not None else []
        self.bpmn_diagrams = [v if isinstance(v, BpmnDiagram) else BpmnDiagram(**as_dict(v)) for v in self.bpmn_diagrams]

        self._normalize_inlined_as_list(slot_name="relationships", slot_type=BpmnRelationship, key_name="type", keyed=False)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDocumentation(BpmnModelElementInstance):
    """
    Text that documents an element.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDocumentation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDocumentation"
    class_name: ClassVar[str] = "BpmnDocumentation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDocumentation

    bpmn_id: Optional[str] = None
    text_format: Optional[str] = "text/plain"
    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bpmn_id is not None and not isinstance(self.bpmn_id, str):
            self.bpmn_id = str(self.bpmn_id)

        if self.text_format is not None and not isinstance(self.text_format, str):
            self.text_format = str(self.text_format)

        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnExpression(BpmnBaseElement):
    """
    An expression whose language and body the model leaves open.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnExpression"
    class_name: ClassVar[str] = "BpmnExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnExpression

    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnActivationCondition(BpmnExpression):
    """
    The condition a complex gateway checks to decide when enough incoming flows have arrived to continue.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnActivationCondition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnActivationCondition"
    class_name: ClassVar[str] = "BpmnActivationCondition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnActivationCondition


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnCompletionCondition(BpmnExpression):
    """
    The condition that ends a multi-instance activity or an ad-hoc sub-process early.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCompletionCondition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCompletionCondition"
    class_name: ClassVar[str] = "BpmnCompletionCondition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCompletionCondition


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnCondition(BpmnExpression):
    """
    The expression a conditional event evaluates.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCondition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCondition"
    class_name: ClassVar[str] = "BpmnCondition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCondition


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnExtension(BpmnModelElementInstance):
    """
    A declaration that a document uses an extension, by its definition.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnExtension"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnExtension"
    class_name: ClassVar[str] = "BpmnExtension"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnExtension

    bpmn_definition: Optional[str] = None
    must_understand: Optional[Union[bool, Bool]] = False
    bpmn_documentation: Optional[Union[Union[dict, BpmnDocumentation], list[Union[dict, BpmnDocumentation]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bpmn_definition is not None and not isinstance(self.bpmn_definition, str):
            self.bpmn_definition = str(self.bpmn_definition)

        if self.must_understand is not None and not isinstance(self.must_understand, Bool):
            self.must_understand = Bool(self.must_understand)

        if not isinstance(self.bpmn_documentation, list):
            self.bpmn_documentation = [self.bpmn_documentation] if self.bpmn_documentation is not None else []
        self.bpmn_documentation = [v if isinstance(v, BpmnDocumentation) else BpmnDocumentation(**as_dict(v)) for v in self.bpmn_documentation]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnExtensionElements(BpmnModelElementInstance):
    """
    The container for an element's extension content, such as Fluxnova's settings.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnExtensionElements"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnExtensionElements"
    class_name: ClassVar[str] = "BpmnExtensionElements"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnExtensionElements

    elements: Optional[Union[Union[dict, BpmnModelElementInstance], list[Union[dict, BpmnModelElementInstance]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.elements, list):
            self.elements = [self.elements] if self.elements is not None else []
        self.elements = [v if isinstance(v, BpmnModelElementInstance) else BpmnModelElementInstance(**as_dict(v)) for v in self.elements]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnFlowElement(BpmnBaseElement):
    """
    An element that takes part in the flow of a process, such as an activity or sequence flow.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnFlowElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnFlowElement"
    class_name: ClassVar[str] = "BpmnFlowElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnFlowElement

    name: Optional[str] = None
    auditing: Optional[Union[dict, BpmnAuditing]] = None
    monitoring: Optional[Union[dict, "BpmnMonitoring"]] = None
    category_value_refs: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.auditing is not None and not isinstance(self.auditing, BpmnAuditing):
            self.auditing = BpmnAuditing(**as_dict(self.auditing))

        if self.monitoring is not None and not isinstance(self.monitoring, BpmnMonitoring):
            self.monitoring = BpmnMonitoring(**as_dict(self.monitoring))

        if not isinstance(self.category_value_refs, list):
            self.category_value_refs = [self.category_value_refs] if self.category_value_refs is not None else []
        self.category_value_refs = [v if isinstance(v, str) else str(v) for v in self.category_value_refs]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataObject(BpmnFlowElement):
    """
    Data a process creates or uses while it runs.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataObject"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataObject"
    class_name: ClassVar[str] = "BpmnDataObject"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataObject

    item_subject_ref: Optional[str] = None
    is_collection: Optional[Union[bool, Bool]] = False
    data_state: Optional[Union[dict, BpmnDataState]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.item_subject_ref is not None and not isinstance(self.item_subject_ref, str):
            self.item_subject_ref = str(self.item_subject_ref)

        if self.is_collection is not None and not isinstance(self.is_collection, Bool):
            self.is_collection = Bool(self.is_collection)

        if self.data_state is not None and not isinstance(self.data_state, BpmnDataState):
            self.data_state = BpmnDataState(**as_dict(self.data_state))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataObjectReference(BpmnFlowElement):
    """
    A use of a data object at one place in a process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataObjectReference"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataObjectReference"
    class_name: ClassVar[str] = "BpmnDataObjectReference"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataObjectReference

    item_subject_ref: Optional[str] = None
    data_object_ref: Optional[str] = None
    data_state: Optional[Union[dict, BpmnDataState]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.item_subject_ref is not None and not isinstance(self.item_subject_ref, str):
            self.item_subject_ref = str(self.item_subject_ref)

        if self.data_object_ref is not None and not isinstance(self.data_object_ref, str):
            self.data_object_ref = str(self.data_object_ref)

        if self.data_state is not None and not isinstance(self.data_state, BpmnDataState):
            self.data_state = BpmnDataState(**as_dict(self.data_state))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataStoreReference(BpmnFlowElement):
    """
    A use of a data store at one place in a process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataStoreReference"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataStoreReference"
    class_name: ClassVar[str] = "BpmnDataStoreReference"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataStoreReference

    item_subject_ref: Optional[str] = None
    data_store_ref: Optional[str] = None
    data_state: Optional[Union[dict, BpmnDataState]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.item_subject_ref is not None and not isinstance(self.item_subject_ref, str):
            self.item_subject_ref = str(self.item_subject_ref)

        if self.data_store_ref is not None and not isinstance(self.data_store_ref, str):
            self.data_store_ref = str(self.data_store_ref)

        if self.data_state is not None and not isinstance(self.data_state, BpmnDataState):
            self.data_state = BpmnDataState(**as_dict(self.data_state))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnFlowNode(BpmnFlowElement):
    """
    A flow element that sequence flows connect, such as an activity, event or gateway.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnFlowNode"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnFlowNode"
    class_name: ClassVar[str] = "BpmnFlowNode"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnFlowNode

    fluxnova_async_after: Optional[Union[bool, Bool]] = False
    fluxnova_async_before: Optional[Union[bool, Bool]] = False
    fluxnova_exclusive: Optional[Union[bool, Bool]] = True
    fluxnova_job_priority: Optional[str] = None
    incoming: Optional[Union[str, list[str]]] = empty_list()
    outgoing: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_async_after is not None and not isinstance(self.fluxnova_async_after, Bool):
            self.fluxnova_async_after = Bool(self.fluxnova_async_after)

        if self.fluxnova_async_before is not None and not isinstance(self.fluxnova_async_before, Bool):
            self.fluxnova_async_before = Bool(self.fluxnova_async_before)

        if self.fluxnova_exclusive is not None and not isinstance(self.fluxnova_exclusive, Bool):
            self.fluxnova_exclusive = Bool(self.fluxnova_exclusive)

        if self.fluxnova_job_priority is not None and not isinstance(self.fluxnova_job_priority, str):
            self.fluxnova_job_priority = str(self.fluxnova_job_priority)

        if not isinstance(self.incoming, list):
            self.incoming = [self.incoming] if self.incoming is not None else []
        self.incoming = [v if isinstance(v, str) else str(v) for v in self.incoming]

        if not isinstance(self.outgoing, list):
            self.outgoing = [self.outgoing] if self.outgoing is not None else []
        self.outgoing = [v if isinstance(v, str) else str(v) for v in self.outgoing]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnActivity(BpmnFlowNode):
    """
    Work a process performs, either a task or a sub-process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnActivity"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnActivity"
    class_name: ClassVar[str] = "BpmnActivity"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnActivity

    is_for_compensation: Optional[Union[bool, Bool]] = False
    start_quantity: Optional[int] = 1
    completion_quantity: Optional[int] = 1
    default: Optional[str] = None
    io_specification: Optional[Union[dict, "BpmnIoSpecification"]] = None
    properties: Optional[Union[Union[dict, "BpmnProperty"], list[Union[dict, "BpmnProperty"]]]] = empty_list()
    data_input_associations: Optional[Union[Union[dict, BpmnDataInputAssociation], list[Union[dict, BpmnDataInputAssociation]]]] = empty_list()
    data_output_associations: Optional[Union[Union[dict, BpmnDataOutputAssociation], list[Union[dict, BpmnDataOutputAssociation]]]] = empty_list()
    resource_roles: Optional[Union[Union[dict, "BpmnResourceRole"], list[Union[dict, "BpmnResourceRole"]]]] = empty_list()
    loop_characteristics: Optional[Union[dict, "BpmnLoopCharacteristics"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.is_for_compensation is not None and not isinstance(self.is_for_compensation, Bool):
            self.is_for_compensation = Bool(self.is_for_compensation)

        if self.start_quantity is not None and not isinstance(self.start_quantity, int):
            self.start_quantity = int(self.start_quantity)

        if self.completion_quantity is not None and not isinstance(self.completion_quantity, int):
            self.completion_quantity = int(self.completion_quantity)

        if self.default is not None and not isinstance(self.default, str):
            self.default = str(self.default)

        if self.io_specification is not None and not isinstance(self.io_specification, BpmnIoSpecification):
            self.io_specification = BpmnIoSpecification(**as_dict(self.io_specification))

        if not isinstance(self.properties, list):
            self.properties = [self.properties] if self.properties is not None else []
        self.properties = [v if isinstance(v, BpmnProperty) else BpmnProperty(**as_dict(v)) for v in self.properties]

        self._normalize_inlined_as_list(slot_name="data_input_associations", slot_type=BpmnDataInputAssociation, key_name="target_ref", keyed=False)

        self._normalize_inlined_as_list(slot_name="data_output_associations", slot_type=BpmnDataOutputAssociation, key_name="target_ref", keyed=False)

        if not isinstance(self.resource_roles, list):
            self.resource_roles = [self.resource_roles] if self.resource_roles is not None else []
        self.resource_roles = [v if isinstance(v, BpmnResourceRole) else BpmnResourceRole(**as_dict(v)) for v in self.resource_roles]

        if self.loop_characteristics is not None and not isinstance(self.loop_characteristics, BpmnLoopCharacteristics):
            self.loop_characteristics = BpmnLoopCharacteristics(**as_dict(self.loop_characteristics))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCallActivity(BpmnActivity):
    """
    An activity that calls a separate process or global task.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCallActivity"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCallActivity"
    class_name: ClassVar[str] = "BpmnCallActivity"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCallActivity

    called_element: Optional[str] = None
    fluxnova_async: Optional[Union[bool, Bool]] = False
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
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnEvent(BpmnFlowNode):
    """
    Something that happens while a process runs, such as a start, a message or a timer.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnEvent"
    class_name: ClassVar[str] = "BpmnEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnEvent

    properties: Optional[Union[Union[dict, "BpmnProperty"], list[Union[dict, "BpmnProperty"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.properties, list):
            self.properties = [self.properties] if self.properties is not None else []
        self.properties = [v if isinstance(v, BpmnProperty) else BpmnProperty(**as_dict(v)) for v in self.properties]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCatchEvent(BpmnEvent):
    """
    An event that waits for a trigger, such as a start or intermediate catch event.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCatchEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCatchEvent"
    class_name: ClassVar[str] = "BpmnCatchEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCatchEvent

    parallel_multiple: Optional[Union[bool, Bool]] = False
    data_outputs: Optional[Union[Union[dict, "BpmnDataOutput"], list[Union[dict, "BpmnDataOutput"]]]] = empty_list()
    data_output_associations: Optional[Union[Union[dict, BpmnDataOutputAssociation], list[Union[dict, BpmnDataOutputAssociation]]]] = empty_list()
    output_set: Optional[Union[dict, "BpmnOutputSet"]] = None
    event_definitions: Optional[Union[Union[dict, "BpmnEventDefinition"], list[Union[dict, "BpmnEventDefinition"]]]] = empty_list()
    event_definition_refs: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.parallel_multiple is not None and not isinstance(self.parallel_multiple, Bool):
            self.parallel_multiple = Bool(self.parallel_multiple)

        if not isinstance(self.data_outputs, list):
            self.data_outputs = [self.data_outputs] if self.data_outputs is not None else []
        self.data_outputs = [v if isinstance(v, BpmnDataOutput) else BpmnDataOutput(**as_dict(v)) for v in self.data_outputs]

        self._normalize_inlined_as_list(slot_name="data_output_associations", slot_type=BpmnDataOutputAssociation, key_name="target_ref", keyed=False)

        if self.output_set is not None and not isinstance(self.output_set, BpmnOutputSet):
            self.output_set = BpmnOutputSet(**as_dict(self.output_set))

        if not isinstance(self.event_definitions, list):
            self.event_definitions = [self.event_definitions] if self.event_definitions is not None else []
        self.event_definitions = [v if isinstance(v, BpmnEventDefinition) else BpmnEventDefinition(**as_dict(v)) for v in self.event_definitions]

        if not isinstance(self.event_definition_refs, list):
            self.event_definition_refs = [self.event_definition_refs] if self.event_definition_refs is not None else []
        self.event_definition_refs = [v if isinstance(v, str) else str(v) for v in self.event_definition_refs]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnBoundaryEvent(BpmnCatchEvent):
    """
    An event attached to the boundary of an activity, which can interrupt it.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnBoundaryEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnBoundaryEvent"
    class_name: ClassVar[str] = "BpmnBoundaryEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnBoundaryEvent

    attached_to_ref: str = None
    cancel_activity: Optional[Union[bool, Bool]] = True

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.attached_to_ref):
            self.MissingRequiredField("attached_to_ref")
        if not isinstance(self.attached_to_ref, str):
            self.attached_to_ref = str(self.attached_to_ref)

        if self.cancel_activity is not None and not isinstance(self.cancel_activity, Bool):
            self.cancel_activity = Bool(self.cancel_activity)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnFormalExpression(BpmnExpression):
    """
    An expression in a stated language, with the type it evaluates to.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnFormalExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnFormalExpression"
    class_name: ClassVar[str] = "BpmnFormalExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnFormalExpression

    language: Optional[str] = None
    evaluates_to_type_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.language is not None and not isinstance(self.language, str):
            self.language = str(self.language)

        if self.evaluates_to_type_ref is not None and not isinstance(self.evaluates_to_type_ref, str):
            self.evaluates_to_type_ref = str(self.evaluates_to_type_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnConditionExpression(BpmnFormalExpression):
    """
    The expression that decides whether a sequence flow is taken.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnConditionExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnConditionExpression"
    class_name: ClassVar[str] = "BpmnConditionExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnConditionExpression

    xsi_type: Optional[str] = "tFormalExpression"
    fluxnova_resource: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.xsi_type is not None and not isinstance(self.xsi_type, str):
            self.xsi_type = str(self.xsi_type)

        if self.fluxnova_resource is not None and not isinstance(self.fluxnova_resource, str):
            self.fluxnova_resource = str(self.fluxnova_resource)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnDataPath(BpmnFormalExpression):
    """
    The expression that finds a correlation property's value in process data.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataPath"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataPath"
    class_name: ClassVar[str] = "BpmnDataPath"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataPath


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnFrom(BpmnExpression):
    """
    The expression an assignment copies a value from.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnFrom"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnFrom"
    class_name: ClassVar[str] = "BpmnFrom"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnFrom


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnGateway(BpmnFlowNode):
    """
    A point where a process's flows split or join.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnGateway"
    class_name: ClassVar[str] = "BpmnGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnGateway

    gateway_direction: Optional[Union[str, "BpmnGatewayDirection"]] = 'Unspecified'

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.gateway_direction is not None and not isinstance(self.gateway_direction, BpmnGatewayDirection):
            self.gateway_direction = BpmnGatewayDirection(self.gateway_direction)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnComplexGateway(BpmnGateway):
    """
    A gateway that splits or joins flows by conditions of its own.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnComplexGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnComplexGateway"
    class_name: ClassVar[str] = "BpmnComplexGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnComplexGateway

    default: Optional[str] = None
    activation_condition: Optional[Union[dict, BpmnActivationCondition]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.default is not None and not isinstance(self.default, str):
            self.default = str(self.default)

        if self.activation_condition is not None and not isinstance(self.activation_condition, BpmnActivationCondition):
            self.activation_condition = BpmnActivationCondition(**as_dict(self.activation_condition))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnEventBasedGateway(BpmnGateway):
    """
    A gateway that takes the path of whichever following event happens first.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnEventBasedGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnEventBasedGateway"
    class_name: ClassVar[str] = "BpmnEventBasedGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnEventBasedGateway

    instantiate: Optional[Union[bool, Bool]] = False
    event_gateway_type: Optional[Union[str, "BpmnEventBasedGatewayType"]] = 'Exclusive'

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.instantiate is not None and not isinstance(self.instantiate, Bool):
            self.instantiate = Bool(self.instantiate)

        if self.event_gateway_type is not None and not isinstance(self.event_gateway_type, BpmnEventBasedGatewayType):
            self.event_gateway_type = BpmnEventBasedGatewayType(self.event_gateway_type)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnExclusiveGateway(BpmnGateway):
    """
    A gateway that takes exactly one of its outgoing flows.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnExclusiveGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnExclusiveGateway"
    class_name: ClassVar[str] = "BpmnExclusiveGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnExclusiveGateway

    default: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.default is not None and not isinstance(self.default, str):
            self.default = str(self.default)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnGroup(BpmnArtifact):
    """
    An artifact that draws a box around elements of one category value.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnGroup"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnGroup"
    class_name: ClassVar[str] = "BpmnGroup"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnGroup

    category_value_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.category_value_ref is not None and not isinstance(self.category_value_ref, str):
            self.category_value_ref = str(self.category_value_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnImport(BpmnModelElementInstance):
    """
    A document the definitions import elements from.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnImport"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnImport"
    class_name: ClassVar[str] = "BpmnImport"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnImport

    namespace: str = None
    location: str = None
    import_type: str = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.namespace):
            self.MissingRequiredField("namespace")
        if not isinstance(self.namespace, str):
            self.namespace = str(self.namespace)

        if self._is_empty(self.location):
            self.MissingRequiredField("location")
        if not isinstance(self.location, str):
            self.location = str(self.location)

        if self._is_empty(self.import_type):
            self.MissingRequiredField("import_type")
        if not isinstance(self.import_type, str):
            self.import_type = str(self.import_type)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnInclusiveGateway(BpmnGateway):
    """
    A gateway that takes every outgoing flow whose condition holds.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnInclusiveGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnInclusiveGateway"
    class_name: ClassVar[str] = "BpmnInclusiveGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnInclusiveGateway

    default: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.default is not None and not isinstance(self.default, str):
            self.default = str(self.default)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnInputSet(BpmnBaseElement):
    """
    A set of data inputs that is enough for an activity or event to start.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnInputSet"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnInputSet"
    class_name: ClassVar[str] = "BpmnInputSet"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnInputSet

    name: Optional[str] = None
    data_input_refs: Optional[Union[str, list[str]]] = empty_list()
    optional_input_refs: Optional[Union[str, list[str]]] = empty_list()
    while_executing_input_refs: Optional[Union[str, list[str]]] = empty_list()
    output_set_refs: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if not isinstance(self.data_input_refs, list):
            self.data_input_refs = [self.data_input_refs] if self.data_input_refs is not None else []
        self.data_input_refs = [v if isinstance(v, str) else str(v) for v in self.data_input_refs]

        if not isinstance(self.optional_input_refs, list):
            self.optional_input_refs = [self.optional_input_refs] if self.optional_input_refs is not None else []
        self.optional_input_refs = [v if isinstance(v, str) else str(v) for v in self.optional_input_refs]

        if not isinstance(self.while_executing_input_refs, list):
            self.while_executing_input_refs = [self.while_executing_input_refs] if self.while_executing_input_refs is not None else []
        self.while_executing_input_refs = [v if isinstance(v, str) else str(v) for v in self.while_executing_input_refs]

        if not isinstance(self.output_set_refs, list):
            self.output_set_refs = [self.output_set_refs] if self.output_set_refs is not None else []
        self.output_set_refs = [v if isinstance(v, str) else str(v) for v in self.output_set_refs]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnIntermediateCatchEvent(BpmnCatchEvent):
    """
    An event on a process's path that waits for a trigger.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnIntermediateCatchEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnIntermediateCatchEvent"
    class_name: ClassVar[str] = "BpmnIntermediateCatchEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnIntermediateCatchEvent


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnIoBinding(BpmnBaseElement):
    """
    A link between an operation's messages and a callable element's input and output sets.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnIoBinding"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnIoBinding"
    class_name: ClassVar[str] = "BpmnIoBinding"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnIoBinding

    operation_ref: str = None
    input_data_ref: str = None
    output_data_ref: str = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.operation_ref):
            self.MissingRequiredField("operation_ref")
        if not isinstance(self.operation_ref, str):
            self.operation_ref = str(self.operation_ref)

        if self._is_empty(self.input_data_ref):
            self.MissingRequiredField("input_data_ref")
        if not isinstance(self.input_data_ref, str):
            self.input_data_ref = str(self.input_data_ref)

        if self._is_empty(self.output_data_ref):
            self.MissingRequiredField("output_data_ref")
        if not isinstance(self.output_data_ref, str):
            self.output_data_ref = str(self.output_data_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnIoSpecification(BpmnBaseElement):
    """
    The data inputs and outputs of an activity or process, and their sets.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnIoSpecification"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnIoSpecification"
    class_name: ClassVar[str] = "BpmnIoSpecification"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnIoSpecification

    input_sets: Union[Union[dict, BpmnInputSet], list[Union[dict, BpmnInputSet]]] = None
    output_sets: Union[Union[dict, "BpmnOutputSet"], list[Union[dict, "BpmnOutputSet"]]] = None
    data_inputs: Optional[Union[Union[dict, "BpmnDataInput"], list[Union[dict, "BpmnDataInput"]]]] = empty_list()
    data_outputs: Optional[Union[Union[dict, "BpmnDataOutput"], list[Union[dict, "BpmnDataOutput"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.input_sets):
            self.MissingRequiredField("input_sets")
        if not isinstance(self.input_sets, list):
            self.input_sets = [self.input_sets] if self.input_sets is not None else []
        self.input_sets = [v if isinstance(v, BpmnInputSet) else BpmnInputSet(**as_dict(v)) for v in self.input_sets]

        if self._is_empty(self.output_sets):
            self.MissingRequiredField("output_sets")
        if not isinstance(self.output_sets, list):
            self.output_sets = [self.output_sets] if self.output_sets is not None else []
        self.output_sets = [v if isinstance(v, BpmnOutputSet) else BpmnOutputSet(**as_dict(v)) for v in self.output_sets]

        if not isinstance(self.data_inputs, list):
            self.data_inputs = [self.data_inputs] if self.data_inputs is not None else []
        self.data_inputs = [v if isinstance(v, BpmnDataInput) else BpmnDataInput(**as_dict(v)) for v in self.data_inputs]

        if not isinstance(self.data_outputs, list):
            self.data_outputs = [self.data_outputs] if self.data_outputs is not None else []
        self.data_outputs = [v if isinstance(v, BpmnDataOutput) else BpmnDataOutput(**as_dict(v)) for v in self.data_outputs]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnItemAwareElement(BpmnBaseElement):
    """
    An element that holds data of an item definition, such as a data object or data input.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnItemAwareElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnItemAwareElement"
    class_name: ClassVar[str] = "BpmnItemAwareElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnItemAwareElement

    item_subject_ref: Optional[str] = None
    data_state: Optional[Union[dict, BpmnDataState]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.item_subject_ref is not None and not isinstance(self.item_subject_ref, str):
            self.item_subject_ref = str(self.item_subject_ref)

        if self.data_state is not None and not isinstance(self.data_state, BpmnDataState):
            self.data_state = BpmnDataState(**as_dict(self.data_state))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataInput(BpmnItemAwareElement):
    """
    A piece of data an activity, process or event needs.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataInput"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataInput"
    class_name: ClassVar[str] = "BpmnDataInput"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataInput

    name: Optional[str] = None
    is_collection: Optional[Union[bool, Bool]] = False

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.is_collection is not None and not isinstance(self.is_collection, Bool):
            self.is_collection = Bool(self.is_collection)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataOutput(BpmnItemAwareElement):
    """
    A piece of data an activity, process or event produces.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataOutput"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataOutput"
    class_name: ClassVar[str] = "BpmnDataOutput"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataOutput

    name: Optional[str] = None
    is_collection: Optional[Union[bool, Bool]] = False

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.is_collection is not None and not isinstance(self.is_collection, Bool):
            self.is_collection = Bool(self.is_collection)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnInputDataItem(BpmnDataInput):
    """
    The data input each instance of a multi-instance activity receives.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnInputDataItem"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnInputDataItem"
    class_name: ClassVar[str] = "BpmnInputDataItem"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnInputDataItem


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnLane(BpmnBaseElement):
    """
    A partition of a process that groups flow nodes, often by who performs them.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnLane"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnLane"
    class_name: ClassVar[str] = "BpmnLane"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnLane

    name: Optional[str] = None
    partition_element_ref: Optional[str] = None
    partition_element: Optional[Union[dict, "BpmnPartitionElement"]] = None
    flow_node_refs: Optional[Union[str, list[str]]] = empty_list()
    child_lane_set: Optional[Union[dict, "BpmnChildLaneSet"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.partition_element_ref is not None and not isinstance(self.partition_element_ref, str):
            self.partition_element_ref = str(self.partition_element_ref)

        if self.partition_element is not None and not isinstance(self.partition_element, BpmnPartitionElement):
            self.partition_element = BpmnPartitionElement(**as_dict(self.partition_element))

        if not isinstance(self.flow_node_refs, list):
            self.flow_node_refs = [self.flow_node_refs] if self.flow_node_refs is not None else []
        self.flow_node_refs = [v if isinstance(v, str) else str(v) for v in self.flow_node_refs]

        if self.child_lane_set is not None and not isinstance(self.child_lane_set, BpmnChildLaneSet):
            self.child_lane_set = BpmnChildLaneSet(**as_dict(self.child_lane_set))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnLaneSet(BpmnBaseElement):
    """
    The lanes that divide a process or sub-process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnLaneSet"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnLaneSet"
    class_name: ClassVar[str] = "BpmnLaneSet"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnLaneSet

    name: Optional[str] = None
    lanes: Optional[Union[Union[dict, BpmnLane], list[Union[dict, BpmnLane]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if not isinstance(self.lanes, list):
            self.lanes = [self.lanes] if self.lanes is not None else []
        self.lanes = [v if isinstance(v, BpmnLane) else BpmnLane(**as_dict(v)) for v in self.lanes]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnChildLaneSet(BpmnLaneSet):
    """
    The lanes a lane is divided into.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnChildLaneSet"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnChildLaneSet"
    class_name: ClassVar[str] = "BpmnChildLaneSet"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnChildLaneSet


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnLoopCardinality(BpmnExpression):
    """
    The expression that says how many instances a multi-instance activity creates.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnLoopCardinality"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnLoopCardinality"
    class_name: ClassVar[str] = "BpmnLoopCardinality"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnLoopCardinality


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnLoopCharacteristics(BpmnBaseElement):
    """
    How an activity repeats.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnLoopCharacteristics"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnLoopCharacteristics"
    class_name: ClassVar[str] = "BpmnLoopCharacteristics"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnLoopCharacteristics


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnMessageFlow(BpmnBaseElement):
    """
    The path of a message between two participants.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnMessageFlow"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnMessageFlow"
    class_name: ClassVar[str] = "BpmnMessageFlow"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnMessageFlow

    source_ref: str = None
    target_ref: str = None
    name: Optional[str] = None
    message_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.source_ref):
            self.MissingRequiredField("source_ref")
        if not isinstance(self.source_ref, str):
            self.source_ref = str(self.source_ref)

        if self._is_empty(self.target_ref):
            self.MissingRequiredField("target_ref")
        if not isinstance(self.target_ref, str):
            self.target_ref = str(self.target_ref)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.message_ref is not None and not isinstance(self.message_ref, str):
            self.message_ref = str(self.message_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnMessageFlowAssociation(BpmnBaseElement):
    """
    A link between a message flow and one that refines it.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnMessageFlowAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnMessageFlowAssociation"
    class_name: ClassVar[str] = "BpmnMessageFlowAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnMessageFlowAssociation

    inner_message_flow_ref: str = None
    outer_message_flow_ref: str = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.inner_message_flow_ref):
            self.MissingRequiredField("inner_message_flow_ref")
        if not isinstance(self.inner_message_flow_ref, str):
            self.inner_message_flow_ref = str(self.inner_message_flow_ref)

        if self._is_empty(self.outer_message_flow_ref):
            self.MissingRequiredField("outer_message_flow_ref")
        if not isinstance(self.outer_message_flow_ref, str):
            self.outer_message_flow_ref = str(self.outer_message_flow_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnMessagePath(BpmnFormalExpression):
    """
    The expression that finds a correlation property's value in a message.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnMessagePath"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnMessagePath"
    class_name: ClassVar[str] = "BpmnMessagePath"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnMessagePath


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnMonitoring(BpmnBaseElement):
    """
    A hook for monitoring a process or flow element, left to the implementation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnMonitoring"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnMonitoring"
    class_name: ClassVar[str] = "BpmnMonitoring"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnMonitoring


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnMultiInstanceLoopCharacteristics(BpmnLoopCharacteristics):
    """
    How an activity runs once for each item of a collection, in sequence or in parallel.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnMultiInstanceLoopCharacteristics"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnMultiInstanceLoopCharacteristics"
    class_name: ClassVar[str] = "BpmnMultiInstanceLoopCharacteristics"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnMultiInstanceLoopCharacteristics

    is_sequential: Optional[Union[bool, Bool]] = False
    behavior: Optional[Union[str, "BpmnMultiInstanceFlowCondition"]] = 'All'
    one_behavior_event_ref: Optional[str] = None
    none_behavior_event_ref: Optional[str] = None
    fluxnova_async_after: Optional[Union[bool, Bool]] = False
    fluxnova_async_before: Optional[Union[bool, Bool]] = False
    fluxnova_exclusive: Optional[Union[bool, Bool]] = True
    fluxnova_collection: Optional[str] = None
    fluxnova_element_variable: Optional[str] = None
    loop_cardinality: Optional[Union[dict, BpmnLoopCardinality]] = None
    loop_data_input_ref: Optional[str] = None
    loop_data_output_ref: Optional[str] = None
    output_data_item: Optional[Union[dict, "BpmnOutputDataItem"]] = None
    input_data_item: Optional[Union[dict, BpmnInputDataItem]] = None
    complex_behavior_definitions: Optional[Union[Union[dict, BpmnComplexBehaviorDefinition], list[Union[dict, BpmnComplexBehaviorDefinition]]]] = empty_list()
    completion_condition: Optional[Union[dict, BpmnCompletionCondition]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.is_sequential is not None and not isinstance(self.is_sequential, Bool):
            self.is_sequential = Bool(self.is_sequential)

        if self.behavior is not None and not isinstance(self.behavior, BpmnMultiInstanceFlowCondition):
            self.behavior = BpmnMultiInstanceFlowCondition(self.behavior)

        if self.one_behavior_event_ref is not None and not isinstance(self.one_behavior_event_ref, str):
            self.one_behavior_event_ref = str(self.one_behavior_event_ref)

        if self.none_behavior_event_ref is not None and not isinstance(self.none_behavior_event_ref, str):
            self.none_behavior_event_ref = str(self.none_behavior_event_ref)

        if self.fluxnova_async_after is not None and not isinstance(self.fluxnova_async_after, Bool):
            self.fluxnova_async_after = Bool(self.fluxnova_async_after)

        if self.fluxnova_async_before is not None and not isinstance(self.fluxnova_async_before, Bool):
            self.fluxnova_async_before = Bool(self.fluxnova_async_before)

        if self.fluxnova_exclusive is not None and not isinstance(self.fluxnova_exclusive, Bool):
            self.fluxnova_exclusive = Bool(self.fluxnova_exclusive)

        if self.fluxnova_collection is not None and not isinstance(self.fluxnova_collection, str):
            self.fluxnova_collection = str(self.fluxnova_collection)

        if self.fluxnova_element_variable is not None and not isinstance(self.fluxnova_element_variable, str):
            self.fluxnova_element_variable = str(self.fluxnova_element_variable)

        if self.loop_cardinality is not None and not isinstance(self.loop_cardinality, BpmnLoopCardinality):
            self.loop_cardinality = BpmnLoopCardinality(**as_dict(self.loop_cardinality))

        if self.loop_data_input_ref is not None and not isinstance(self.loop_data_input_ref, str):
            self.loop_data_input_ref = str(self.loop_data_input_ref)

        if self.loop_data_output_ref is not None and not isinstance(self.loop_data_output_ref, str):
            self.loop_data_output_ref = str(self.loop_data_output_ref)

        if self.output_data_item is not None and not isinstance(self.output_data_item, BpmnOutputDataItem):
            self.output_data_item = BpmnOutputDataItem(**as_dict(self.output_data_item))

        if self.input_data_item is not None and not isinstance(self.input_data_item, BpmnInputDataItem):
            self.input_data_item = BpmnInputDataItem(**as_dict(self.input_data_item))

        if not isinstance(self.complex_behavior_definitions, list):
            self.complex_behavior_definitions = [self.complex_behavior_definitions] if self.complex_behavior_definitions is not None else []
        self.complex_behavior_definitions = [v if isinstance(v, BpmnComplexBehaviorDefinition) else BpmnComplexBehaviorDefinition(**as_dict(v)) for v in self.complex_behavior_definitions]

        if self.completion_condition is not None and not isinstance(self.completion_condition, BpmnCompletionCondition):
            self.completion_condition = BpmnCompletionCondition(**as_dict(self.completion_condition))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnOperation(BpmnBaseElement):
    """
    An operation of an interface, with the messages it takes and returns.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnOperation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnOperation"
    class_name: ClassVar[str] = "BpmnOperation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnOperation

    name: str = None
    in_message_ref: str = None
    implementation_ref: Optional[str] = None
    out_message_ref: Optional[str] = None
    error_refs: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if self._is_empty(self.in_message_ref):
            self.MissingRequiredField("in_message_ref")
        if not isinstance(self.in_message_ref, str):
            self.in_message_ref = str(self.in_message_ref)

        if self.implementation_ref is not None and not isinstance(self.implementation_ref, str):
            self.implementation_ref = str(self.implementation_ref)

        if self.out_message_ref is not None and not isinstance(self.out_message_ref, str):
            self.out_message_ref = str(self.out_message_ref)

        if not isinstance(self.error_refs, list):
            self.error_refs = [self.error_refs] if self.error_refs is not None else []
        self.error_refs = [v if isinstance(v, str) else str(v) for v in self.error_refs]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnOutputDataItem(BpmnDataOutput):
    """
    The data output each instance of a multi-instance activity produces.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnOutputDataItem"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnOutputDataItem"
    class_name: ClassVar[str] = "BpmnOutputDataItem"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnOutputDataItem


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnOutputSet(BpmnBaseElement):
    """
    A set of data outputs an activity or event produces together.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnOutputSet"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnOutputSet"
    class_name: ClassVar[str] = "BpmnOutputSet"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnOutputSet

    name: Optional[str] = None
    data_output_refs: Optional[Union[str, list[str]]] = empty_list()
    optional_output_refs: Optional[Union[str, list[str]]] = empty_list()
    while_executing_output_refs: Optional[Union[str, list[str]]] = empty_list()
    input_set_refs: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if not isinstance(self.data_output_refs, list):
            self.data_output_refs = [self.data_output_refs] if self.data_output_refs is not None else []
        self.data_output_refs = [v if isinstance(v, str) else str(v) for v in self.data_output_refs]

        if not isinstance(self.optional_output_refs, list):
            self.optional_output_refs = [self.optional_output_refs] if self.optional_output_refs is not None else []
        self.optional_output_refs = [v if isinstance(v, str) else str(v) for v in self.optional_output_refs]

        if not isinstance(self.while_executing_output_refs, list):
            self.while_executing_output_refs = [self.while_executing_output_refs] if self.while_executing_output_refs is not None else []
        self.while_executing_output_refs = [v if isinstance(v, str) else str(v) for v in self.while_executing_output_refs]

        if not isinstance(self.input_set_refs, list):
            self.input_set_refs = [self.input_set_refs] if self.input_set_refs is not None else []
        self.input_set_refs = [v if isinstance(v, str) else str(v) for v in self.input_set_refs]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnParallelGateway(BpmnGateway):
    """
    A gateway that takes all its outgoing flows, or waits for all its incoming ones.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnParallelGateway"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnParallelGateway"
    class_name: ClassVar[str] = "BpmnParallelGateway"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnParallelGateway

    fluxnova_async: Optional[Union[bool, Bool]] = False

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnParticipant(BpmnBaseElement):
    """
    A party in a collaboration, usually drawn as a pool, and the process it runs.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnParticipant"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnParticipant"
    class_name: ClassVar[str] = "BpmnParticipant"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnParticipant

    name: Optional[str] = None
    process_ref: Optional[str] = None
    interface_refs: Optional[Union[str, list[str]]] = empty_list()
    end_point_refs: Optional[Union[str, list[str]]] = empty_list()
    participant_multiplicity: Optional[Union[dict, "BpmnParticipantMultiplicity"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.process_ref is not None and not isinstance(self.process_ref, str):
            self.process_ref = str(self.process_ref)

        if not isinstance(self.interface_refs, list):
            self.interface_refs = [self.interface_refs] if self.interface_refs is not None else []
        self.interface_refs = [v if isinstance(v, str) else str(v) for v in self.interface_refs]

        if not isinstance(self.end_point_refs, list):
            self.end_point_refs = [self.end_point_refs] if self.end_point_refs is not None else []
        self.end_point_refs = [v if isinstance(v, str) else str(v) for v in self.end_point_refs]

        if self.participant_multiplicity is not None and not isinstance(self.participant_multiplicity, BpmnParticipantMultiplicity):
            self.participant_multiplicity = BpmnParticipantMultiplicity(**as_dict(self.participant_multiplicity))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnParticipantAssociation(BpmnBaseElement):
    """
    A link between a participant and one that a called collaboration defines.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnParticipantAssociation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnParticipantAssociation"
    class_name: ClassVar[str] = "BpmnParticipantAssociation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnParticipantAssociation

    inner_participant_ref: str = None
    outer_participant_ref: str = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.inner_participant_ref):
            self.MissingRequiredField("inner_participant_ref")
        if not isinstance(self.inner_participant_ref, str):
            self.inner_participant_ref = str(self.inner_participant_ref)

        if self._is_empty(self.outer_participant_ref):
            self.MissingRequiredField("outer_participant_ref")
        if not isinstance(self.outer_participant_ref, str):
            self.outer_participant_ref = str(self.outer_participant_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnParticipantMultiplicity(BpmnBaseElement):
    """
    How many instances of a participant take part, from a minimum to a maximum.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnParticipantMultiplicity"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnParticipantMultiplicity"
    class_name: ClassVar[str] = "BpmnParticipantMultiplicity"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnParticipantMultiplicity

    minimum: Optional[int] = 0
    maximum: Optional[int] = 1

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.minimum is not None and not isinstance(self.minimum, int):
            self.minimum = int(self.minimum)

        if self.maximum is not None and not isinstance(self.maximum, int):
            self.maximum = int(self.maximum)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnPartitionElement(BpmnBaseElement):
    """
    The element a lane stands for, such as a performer.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnPartitionElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnPartitionElement"
    class_name: ClassVar[str] = "BpmnPartitionElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnPartitionElement


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnProperty(BpmnItemAwareElement):
    """
    A variable of a process, activity or event.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnProperty"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnProperty"
    class_name: ClassVar[str] = "BpmnProperty"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnProperty

    name: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnRelationship(BpmnBaseElement):
    """
    An informal link between elements of different models.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnRelationship"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnRelationship"
    class_name: ClassVar[str] = "BpmnRelationship"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnRelationship

    type: str = None
    bpmn_sources: Union[Union[dict, "BpmnSource"], list[Union[dict, "BpmnSource"]]] = None
    targets: Union[Union[dict, "BpmnTarget"], list[Union[dict, "BpmnTarget"]]] = None
    direction: Optional[Union[str, "BpmnRelationshipDirection"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.type):
            self.MissingRequiredField("type")
        if not isinstance(self.type, str):
            self.type = str(self.type)

        if self._is_empty(self.bpmn_sources):
            self.MissingRequiredField("bpmn_sources")
        if not isinstance(self.bpmn_sources, list):
            self.bpmn_sources = [self.bpmn_sources] if self.bpmn_sources is not None else []
        self.bpmn_sources = [v if isinstance(v, BpmnSource) else BpmnSource(**as_dict(v)) for v in self.bpmn_sources]

        if self._is_empty(self.targets):
            self.MissingRequiredField("targets")
        if not isinstance(self.targets, list):
            self.targets = [self.targets] if self.targets is not None else []
        self.targets = [v if isinstance(v, BpmnTarget) else BpmnTarget(**as_dict(v)) for v in self.targets]

        if self.direction is not None and not isinstance(self.direction, BpmnRelationshipDirection):
            self.direction = BpmnRelationshipDirection(self.direction)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnRendering(BpmnBaseElement):
    """
    A hint for how a user task appears to the person who performs it.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnRendering"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnRendering"
    class_name: ClassVar[str] = "BpmnRendering"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnRendering


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnResourceAssignmentExpression(BpmnBaseElement):
    """
    The expression that chooses who performs an activity.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnResourceAssignmentExpression"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnResourceAssignmentExpression"
    class_name: ClassVar[str] = "BpmnResourceAssignmentExpression"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnResourceAssignmentExpression

    expression: Union[dict, BpmnExpression] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.expression):
            self.MissingRequiredField("expression")
        if not isinstance(self.expression, BpmnExpression):
            self.expression = BpmnExpression(**as_dict(self.expression))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnResourceParameter(BpmnBaseElement):
    """
    A parameter that narrows which resources a resource stands for.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnResourceParameter"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnResourceParameter"
    class_name: ClassVar[str] = "BpmnResourceParameter"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnResourceParameter

    name: Optional[str] = None
    type: Optional[str] = None
    is_required: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        if self.is_required is not None and not isinstance(self.is_required, Bool):
            self.is_required = Bool(self.is_required)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnResourceParameterBinding(BpmnBaseElement):
    """
    The value a resource role gives a resource parameter.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnResourceParameterBinding"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnResourceParameterBinding"
    class_name: ClassVar[str] = "BpmnResourceParameterBinding"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnResourceParameterBinding

    parameter_ref: str = None
    expression: Union[dict, BpmnExpression] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.parameter_ref):
            self.MissingRequiredField("parameter_ref")
        if not isinstance(self.parameter_ref, str):
            self.parameter_ref = str(self.parameter_ref)

        if self._is_empty(self.expression):
            self.MissingRequiredField("expression")
        if not isinstance(self.expression, BpmnExpression):
            self.expression = BpmnExpression(**as_dict(self.expression))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnResourceRole(BpmnBaseElement):
    """
    The role a resource plays in an activity or process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnResourceRole"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnResourceRole"
    class_name: ClassVar[str] = "BpmnResourceRole"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnResourceRole

    name: Optional[str] = None
    resource_ref: Optional[str] = None
    resource_parameter_bindings: Optional[Union[Union[dict, BpmnResourceParameterBinding], list[Union[dict, BpmnResourceParameterBinding]]]] = empty_list()
    resource_assignment_expression: Optional[Union[dict, BpmnResourceAssignmentExpression]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.resource_ref is not None and not isinstance(self.resource_ref, str):
            self.resource_ref = str(self.resource_ref)

        self._normalize_inlined_as_list(slot_name="resource_parameter_bindings", slot_type=BpmnResourceParameterBinding, key_name="parameter_ref", keyed=False)

        if self.resource_assignment_expression is not None and not isinstance(self.resource_assignment_expression, BpmnResourceAssignmentExpression):
            self.resource_assignment_expression = BpmnResourceAssignmentExpression(**as_dict(self.resource_assignment_expression))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnPerformer(BpmnResourceRole):
    """
    The resource that performs an activity.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnPerformer"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnPerformer"
    class_name: ClassVar[str] = "BpmnPerformer"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnPerformer


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnHumanPerformer(BpmnPerformer):
    """
    The person who performs an activity.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnHumanPerformer"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnHumanPerformer"
    class_name: ClassVar[str] = "BpmnHumanPerformer"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnHumanPerformer


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnPotentialOwner(BpmnHumanPerformer):
    """
    A person who may claim and perform a user task.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnPotentialOwner"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnPotentialOwner"
    class_name: ClassVar[str] = "BpmnPotentialOwner"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnPotentialOwner


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnRootElement(BpmnBaseElement):
    """
    An element that can sit directly in a document's definitions, such as a process or message.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnRootElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnRootElement"
    class_name: ClassVar[str] = "BpmnRootElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnRootElement


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCallableElement(BpmnRootElement):
    """
    An element another process can call, such as a process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCallableElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCallableElement"
    class_name: ClassVar[str] = "BpmnCallableElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCallableElement

    name: Optional[str] = None
    supported_interface_refs: Optional[Union[str, list[str]]] = empty_list()
    io_specification: Optional[Union[dict, BpmnIoSpecification]] = None
    io_bindings: Optional[Union[Union[dict, BpmnIoBinding], list[Union[dict, BpmnIoBinding]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if not isinstance(self.supported_interface_refs, list):
            self.supported_interface_refs = [self.supported_interface_refs] if self.supported_interface_refs is not None else []
        self.supported_interface_refs = [v if isinstance(v, str) else str(v) for v in self.supported_interface_refs]

        if self.io_specification is not None and not isinstance(self.io_specification, BpmnIoSpecification):
            self.io_specification = BpmnIoSpecification(**as_dict(self.io_specification))

        self._normalize_inlined_as_list(slot_name="io_bindings", slot_type=BpmnIoBinding, key_name="operation_ref", keyed=False)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCategory(BpmnRootElement):
    """
    A named set of category values that groups elements.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCategory"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCategory"
    class_name: ClassVar[str] = "BpmnCategory"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCategory

    name: str = None
    category_values: Optional[Union[Union[dict, BpmnCategoryValue], list[Union[dict, BpmnCategoryValue]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if not isinstance(self.category_values, list):
            self.category_values = [self.category_values] if self.category_values is not None else []
        self.category_values = [v if isinstance(v, BpmnCategoryValue) else BpmnCategoryValue(**as_dict(v)) for v in self.category_values]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCollaboration(BpmnRootElement):
    """
    The participants of a model and the messages and conversations between them.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCollaboration"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCollaboration"
    class_name: ClassVar[str] = "BpmnCollaboration"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCollaboration

    name: Optional[str] = None
    is_closed: Optional[Union[bool, Bool]] = False
    participants: Optional[Union[Union[dict, BpmnParticipant], list[Union[dict, BpmnParticipant]]]] = empty_list()
    message_flows: Optional[Union[Union[dict, BpmnMessageFlow], list[Union[dict, BpmnMessageFlow]]]] = empty_list()
    artifacts: Optional[Union[Union[dict, BpmnArtifact], list[Union[dict, BpmnArtifact]]]] = empty_list()
    conversation_nodes: Optional[Union[Union[dict, BpmnConversationNode], list[Union[dict, BpmnConversationNode]]]] = empty_list()
    conversation_associations: Optional[Union[Union[dict, BpmnConversationAssociation], list[Union[dict, BpmnConversationAssociation]]]] = empty_list()
    participant_associations: Optional[Union[Union[dict, BpmnParticipantAssociation], list[Union[dict, BpmnParticipantAssociation]]]] = empty_list()
    message_flow_associations: Optional[Union[Union[dict, BpmnMessageFlowAssociation], list[Union[dict, BpmnMessageFlowAssociation]]]] = empty_list()
    correlation_keys: Optional[Union[Union[dict, BpmnCorrelationKey], list[Union[dict, BpmnCorrelationKey]]]] = empty_list()
    conversation_links: Optional[Union[Union[dict, BpmnConversationLink], list[Union[dict, BpmnConversationLink]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.is_closed is not None and not isinstance(self.is_closed, Bool):
            self.is_closed = Bool(self.is_closed)

        if not isinstance(self.participants, list):
            self.participants = [self.participants] if self.participants is not None else []
        self.participants = [v if isinstance(v, BpmnParticipant) else BpmnParticipant(**as_dict(v)) for v in self.participants]

        self._normalize_inlined_as_list(slot_name="message_flows", slot_type=BpmnMessageFlow, key_name="source_ref", keyed=False)

        if not isinstance(self.artifacts, list):
            self.artifacts = [self.artifacts] if self.artifacts is not None else []
        self.artifacts = [v if isinstance(v, BpmnArtifact) else BpmnArtifact(**as_dict(v)) for v in self.artifacts]

        if not isinstance(self.conversation_nodes, list):
            self.conversation_nodes = [self.conversation_nodes] if self.conversation_nodes is not None else []
        self.conversation_nodes = [v if isinstance(v, BpmnConversationNode) else BpmnConversationNode(**as_dict(v)) for v in self.conversation_nodes]

        self._normalize_inlined_as_list(slot_name="conversation_associations", slot_type=BpmnConversationAssociation, key_name="inner_conversation_node_ref", keyed=False)

        self._normalize_inlined_as_list(slot_name="participant_associations", slot_type=BpmnParticipantAssociation, key_name="inner_participant_ref", keyed=False)

        self._normalize_inlined_as_list(slot_name="message_flow_associations", slot_type=BpmnMessageFlowAssociation, key_name="inner_message_flow_ref", keyed=False)

        if not isinstance(self.correlation_keys, list):
            self.correlation_keys = [self.correlation_keys] if self.correlation_keys is not None else []
        self.correlation_keys = [v if isinstance(v, BpmnCorrelationKey) else BpmnCorrelationKey(**as_dict(v)) for v in self.correlation_keys]

        self._normalize_inlined_as_list(slot_name="conversation_links", slot_type=BpmnConversationLink, key_name="source_ref", keyed=False)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCorrelationProperty(BpmnRootElement):
    """
    A value read from messages that ties them to one conversation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCorrelationProperty"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCorrelationProperty"
    class_name: ClassVar[str] = "BpmnCorrelationProperty"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCorrelationProperty

    correlation_property_retrieval_expressions: Union[Union[dict, BpmnCorrelationPropertyRetrievalExpression], list[Union[dict, BpmnCorrelationPropertyRetrievalExpression]]] = None
    name: Optional[str] = None
    type: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.correlation_property_retrieval_expressions):
            self.MissingRequiredField("correlation_property_retrieval_expressions")
        self._normalize_inlined_as_list(slot_name="correlation_property_retrieval_expressions", slot_type=BpmnCorrelationPropertyRetrievalExpression, key_name="message_ref", keyed=False)

        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.type is not None and not isinstance(self.type, str):
            self.type = str(self.type)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDataStore(BpmnRootElement):
    """
    Data that lasts beyond one process instance, such as a database.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDataStore"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDataStore"
    class_name: ClassVar[str] = "BpmnDataStore"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDataStore

    name: Optional[str] = None
    capacity: Optional[int] = None
    is_unlimited: Optional[Union[bool, Bool]] = True
    item_subject_ref: Optional[str] = None
    data_state: Optional[Union[dict, BpmnDataState]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.capacity is not None and not isinstance(self.capacity, int):
            self.capacity = int(self.capacity)

        if self.is_unlimited is not None and not isinstance(self.is_unlimited, Bool):
            self.is_unlimited = Bool(self.is_unlimited)

        if self.item_subject_ref is not None and not isinstance(self.item_subject_ref, str):
            self.item_subject_ref = str(self.item_subject_ref)

        if self.data_state is not None and not isinstance(self.data_state, BpmnDataState):
            self.data_state = BpmnDataState(**as_dict(self.data_state))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnEndPoint(BpmnRootElement):
    """
    A place where a participant can be reached for messages.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnEndPoint"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnEndPoint"
    class_name: ClassVar[str] = "BpmnEndPoint"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnEndPoint


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnError(BpmnRootElement):
    """
    An error that an activity can throw and an event can catch.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnError"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnError"
    class_name: ClassVar[str] = "BpmnError"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnError

    name: Optional[str] = None
    error_code: Optional[str] = None
    fluxnova_error_message: Optional[str] = None
    structure_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.error_code is not None and not isinstance(self.error_code, str):
            self.error_code = str(self.error_code)

        if self.fluxnova_error_message is not None and not isinstance(self.fluxnova_error_message, str):
            self.fluxnova_error_message = str(self.fluxnova_error_message)

        if self.structure_ref is not None and not isinstance(self.structure_ref, str):
            self.structure_ref = str(self.structure_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnEscalation(BpmnRootElement):
    """
    An escalation that an activity can throw and an event can catch.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnEscalation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnEscalation"
    class_name: ClassVar[str] = "BpmnEscalation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnEscalation

    name: Optional[str] = None
    escalation_code: Optional[str] = None
    structure_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.escalation_code is not None and not isinstance(self.escalation_code, str):
            self.escalation_code = str(self.escalation_code)

        if self.structure_ref is not None and not isinstance(self.structure_ref, str):
            self.structure_ref = str(self.structure_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnEventDefinition(BpmnRootElement):
    """
    What triggers an event, such as a message, timer or signal.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnEventDefinition"
    class_name: ClassVar[str] = "BpmnEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnEventDefinition


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnCancelEventDefinition(BpmnEventDefinition):
    """
    The trigger of an event that cancels a transaction sub-process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCancelEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCancelEventDefinition"
    class_name: ClassVar[str] = "BpmnCancelEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCancelEventDefinition


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnCompensateEventDefinition(BpmnEventDefinition):
    """
    The trigger of an event that starts or catches compensation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnCompensateEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnCompensateEventDefinition"
    class_name: ClassVar[str] = "BpmnCompensateEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnCompensateEventDefinition

    wait_for_completion: Optional[Union[bool, Bool]] = None
    activity_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.wait_for_completion is not None and not isinstance(self.wait_for_completion, Bool):
            self.wait_for_completion = Bool(self.wait_for_completion)

        if self.activity_ref is not None and not isinstance(self.activity_ref, str):
            self.activity_ref = str(self.activity_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnConditionalEventDefinition(BpmnEventDefinition):
    """
    The trigger of an event that fires when a condition becomes true.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnConditionalEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnConditionalEventDefinition"
    class_name: ClassVar[str] = "BpmnConditionalEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnConditionalEventDefinition

    condition: Union[dict, BpmnCondition] = None
    fluxnova_variable_name: Optional[str] = None
    fluxnova_variable_events: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.condition):
            self.MissingRequiredField("condition")
        if not isinstance(self.condition, BpmnCondition):
            self.condition = BpmnCondition(**as_dict(self.condition))

        if self.fluxnova_variable_name is not None and not isinstance(self.fluxnova_variable_name, str):
            self.fluxnova_variable_name = str(self.fluxnova_variable_name)

        if self.fluxnova_variable_events is not None and not isinstance(self.fluxnova_variable_events, str):
            self.fluxnova_variable_events = str(self.fluxnova_variable_events)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnErrorEventDefinition(BpmnEventDefinition):
    """
    The trigger of an event that throws or catches an error.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnErrorEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnErrorEventDefinition"
    class_name: ClassVar[str] = "BpmnErrorEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnErrorEventDefinition

    error_ref: Optional[str] = None
    fluxnova_error_code_variable: Optional[str] = None
    fluxnova_error_message_variable: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.error_ref is not None and not isinstance(self.error_ref, str):
            self.error_ref = str(self.error_ref)

        if self.fluxnova_error_code_variable is not None and not isinstance(self.fluxnova_error_code_variable, str):
            self.fluxnova_error_code_variable = str(self.fluxnova_error_code_variable)

        if self.fluxnova_error_message_variable is not None and not isinstance(self.fluxnova_error_message_variable, str):
            self.fluxnova_error_message_variable = str(self.fluxnova_error_message_variable)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnEscalationEventDefinition(BpmnEventDefinition):
    """
    The trigger of an event that throws or catches an escalation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnEscalationEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnEscalationEventDefinition"
    class_name: ClassVar[str] = "BpmnEscalationEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnEscalationEventDefinition

    escalation_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.escalation_ref is not None and not isinstance(self.escalation_ref, str):
            self.escalation_ref = str(self.escalation_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnGlobalConversation(BpmnCollaboration):
    """
    A conversation defined on its own so that collaborations can call it.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnGlobalConversation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnGlobalConversation"
    class_name: ClassVar[str] = "BpmnGlobalConversation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnGlobalConversation


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnInterface(BpmnRootElement):
    """
    A set of operations a participant offers.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnInterface"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnInterface"
    class_name: ClassVar[str] = "BpmnInterface"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnInterface

    name: str = None
    operations: Union[Union[dict, BpmnOperation], list[Union[dict, BpmnOperation]]] = None
    implementation_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if self._is_empty(self.operations):
            self.MissingRequiredField("operations")
        self._normalize_inlined_as_list(slot_name="operations", slot_type=BpmnOperation, key_name="name", keyed=False)

        if self.implementation_ref is not None and not isinstance(self.implementation_ref, str):
            self.implementation_ref = str(self.implementation_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnItemDefinition(BpmnRootElement):
    """
    The type of data an element holds or a message carries.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnItemDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnItemDefinition"
    class_name: ClassVar[str] = "BpmnItemDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnItemDefinition

    structure_ref: Optional[str] = None
    is_collection: Optional[Union[bool, Bool]] = False
    item_kind: Optional[Union[str, "BpmnItemKind"]] = 'Information'

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.structure_ref is not None and not isinstance(self.structure_ref, str):
            self.structure_ref = str(self.structure_ref)

        if self.is_collection is not None and not isinstance(self.is_collection, Bool):
            self.is_collection = Bool(self.is_collection)

        if self.item_kind is not None and not isinstance(self.item_kind, BpmnItemKind):
            self.item_kind = BpmnItemKind(self.item_kind)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnLinkEventDefinition(BpmnEventDefinition):
    """
    The trigger of a pair of events that join two paths of a process like a jump.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnLinkEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnLinkEventDefinition"
    class_name: ClassVar[str] = "BpmnLinkEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnLinkEventDefinition

    name: str = None
    bpmn_sources: Optional[Union[str, list[str]]] = empty_list()
    bpmn_target: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if not isinstance(self.bpmn_sources, list):
            self.bpmn_sources = [self.bpmn_sources] if self.bpmn_sources is not None else []
        self.bpmn_sources = [v if isinstance(v, str) else str(v) for v in self.bpmn_sources]

        if self.bpmn_target is not None and not isinstance(self.bpmn_target, str):
            self.bpmn_target = str(self.bpmn_target)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnMessage(BpmnRootElement):
    """
    What one participant sends another.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnMessage"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnMessage"
    class_name: ClassVar[str] = "BpmnMessage"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnMessage

    name: Optional[str] = None
    item_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.item_ref is not None and not isinstance(self.item_ref, str):
            self.item_ref = str(self.item_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnMessageEventDefinition(BpmnEventDefinition):
    """
    The trigger of an event that sends or receives a message.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnMessageEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnMessageEventDefinition"
    class_name: ClassVar[str] = "BpmnMessageEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnMessageEventDefinition

    message_ref: Optional[str] = None
    fluxnova_class: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_topic: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None
    operation_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.message_ref is not None and not isinstance(self.message_ref, str):
            self.message_ref = str(self.message_ref)

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

        if self.operation_ref is not None and not isinstance(self.operation_ref, str):
            self.operation_ref = str(self.operation_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnProcess(BpmnCallableElement):
    """
    A sequence of activities, events and gateways that a participant performs.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnProcess"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnProcess"
    class_name: ClassVar[str] = "BpmnProcess"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnProcess

    process_type: Optional[Union[str, "BpmnProcessType"]] = 'None'
    is_closed: Optional[Union[bool, Bool]] = False
    is_executable: Optional[Union[bool, Bool]] = None
    fluxnova_candidate_starter_groups: Optional[str] = None
    fluxnova_candidate_starter_users: Optional[str] = None
    fluxnova_job_priority: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None
    fluxnova_history_time_to_live: Optional[str] = None
    fluxnova_is_startable_in_tasklist: Optional[Union[bool, Bool]] = True
    fluxnova_version_tag: Optional[str] = None
    auditing: Optional[Union[dict, BpmnAuditing]] = None
    monitoring: Optional[Union[dict, BpmnMonitoring]] = None
    properties: Optional[Union[Union[dict, BpmnProperty], list[Union[dict, BpmnProperty]]]] = empty_list()
    lane_sets: Optional[Union[Union[dict, BpmnLaneSet], list[Union[dict, BpmnLaneSet]]]] = empty_list()
    flow_elements: Optional[Union[Union[dict, BpmnFlowElement], list[Union[dict, BpmnFlowElement]]]] = empty_list()
    artifacts: Optional[Union[Union[dict, BpmnArtifact], list[Union[dict, BpmnArtifact]]]] = empty_list()
    resource_roles: Optional[Union[Union[dict, BpmnResourceRole], list[Union[dict, BpmnResourceRole]]]] = empty_list()
    correlation_subscriptions: Optional[Union[Union[dict, BpmnCorrelationSubscription], list[Union[dict, BpmnCorrelationSubscription]]]] = empty_list()
    supports: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.process_type is not None and not isinstance(self.process_type, BpmnProcessType):
            self.process_type = BpmnProcessType(self.process_type)

        if self.is_closed is not None and not isinstance(self.is_closed, Bool):
            self.is_closed = Bool(self.is_closed)

        if self.is_executable is not None and not isinstance(self.is_executable, Bool):
            self.is_executable = Bool(self.is_executable)

        if self.fluxnova_candidate_starter_groups is not None and not isinstance(self.fluxnova_candidate_starter_groups, str):
            self.fluxnova_candidate_starter_groups = str(self.fluxnova_candidate_starter_groups)

        if self.fluxnova_candidate_starter_users is not None and not isinstance(self.fluxnova_candidate_starter_users, str):
            self.fluxnova_candidate_starter_users = str(self.fluxnova_candidate_starter_users)

        if self.fluxnova_job_priority is not None and not isinstance(self.fluxnova_job_priority, str):
            self.fluxnova_job_priority = str(self.fluxnova_job_priority)

        if self.fluxnova_task_priority is not None and not isinstance(self.fluxnova_task_priority, str):
            self.fluxnova_task_priority = str(self.fluxnova_task_priority)

        if self.fluxnova_history_time_to_live is not None and not isinstance(self.fluxnova_history_time_to_live, str):
            self.fluxnova_history_time_to_live = str(self.fluxnova_history_time_to_live)

        if self.fluxnova_is_startable_in_tasklist is not None and not isinstance(self.fluxnova_is_startable_in_tasklist, Bool):
            self.fluxnova_is_startable_in_tasklist = Bool(self.fluxnova_is_startable_in_tasklist)

        if self.fluxnova_version_tag is not None and not isinstance(self.fluxnova_version_tag, str):
            self.fluxnova_version_tag = str(self.fluxnova_version_tag)

        if self.auditing is not None and not isinstance(self.auditing, BpmnAuditing):
            self.auditing = BpmnAuditing(**as_dict(self.auditing))

        if self.monitoring is not None and not isinstance(self.monitoring, BpmnMonitoring):
            self.monitoring = BpmnMonitoring(**as_dict(self.monitoring))

        if not isinstance(self.properties, list):
            self.properties = [self.properties] if self.properties is not None else []
        self.properties = [v if isinstance(v, BpmnProperty) else BpmnProperty(**as_dict(v)) for v in self.properties]

        if not isinstance(self.lane_sets, list):
            self.lane_sets = [self.lane_sets] if self.lane_sets is not None else []
        self.lane_sets = [v if isinstance(v, BpmnLaneSet) else BpmnLaneSet(**as_dict(v)) for v in self.lane_sets]

        if not isinstance(self.flow_elements, list):
            self.flow_elements = [self.flow_elements] if self.flow_elements is not None else []
        self.flow_elements = [v if isinstance(v, BpmnFlowElement) else BpmnFlowElement(**as_dict(v)) for v in self.flow_elements]

        if not isinstance(self.artifacts, list):
            self.artifacts = [self.artifacts] if self.artifacts is not None else []
        self.artifacts = [v if isinstance(v, BpmnArtifact) else BpmnArtifact(**as_dict(v)) for v in self.artifacts]

        if not isinstance(self.resource_roles, list):
            self.resource_roles = [self.resource_roles] if self.resource_roles is not None else []
        self.resource_roles = [v if isinstance(v, BpmnResourceRole) else BpmnResourceRole(**as_dict(v)) for v in self.resource_roles]

        self._normalize_inlined_as_list(slot_name="correlation_subscriptions", slot_type=BpmnCorrelationSubscription, key_name="correlation_key_ref", keyed=False)

        if not isinstance(self.supports, list):
            self.supports = [self.supports] if self.supports is not None else []
        self.supports = [v if isinstance(v, str) else str(v) for v in self.supports]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnResource(BpmnRootElement):
    """
    A resource, such as a person or role, that can perform activities.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnResource"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnResource"
    class_name: ClassVar[str] = "BpmnResource"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnResource

    name: str = None
    resource_parameters: Optional[Union[Union[dict, BpmnResourceParameter], list[Union[dict, BpmnResourceParameter]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.name):
            self.MissingRequiredField("name")
        if not isinstance(self.name, str):
            self.name = str(self.name)

        if not isinstance(self.resource_parameters, list):
            self.resource_parameters = [self.resource_parameters] if self.resource_parameters is not None else []
        self.resource_parameters = [v if isinstance(v, BpmnResourceParameter) else BpmnResourceParameter(**as_dict(v)) for v in self.resource_parameters]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnScript(BpmnModelElementInstance):
    """
    The body of a script task's script.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnScript"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnScript"
    class_name: ClassVar[str] = "BpmnScript"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnScript

    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnSequenceFlow(BpmnFlowElement):
    """
    The order of two flow nodes in a process, from a source to a target.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnSequenceFlow"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnSequenceFlow"
    class_name: ClassVar[str] = "BpmnSequenceFlow"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnSequenceFlow

    source_ref: str = None
    target_ref: str = None
    is_immediate: Optional[Union[bool, Bool]] = None
    condition_expression: Optional[Union[dict, BpmnConditionExpression]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.source_ref):
            self.MissingRequiredField("source_ref")
        if not isinstance(self.source_ref, str):
            self.source_ref = str(self.source_ref)

        if self._is_empty(self.target_ref):
            self.MissingRequiredField("target_ref")
        if not isinstance(self.target_ref, str):
            self.target_ref = str(self.target_ref)

        if self.is_immediate is not None and not isinstance(self.is_immediate, Bool):
            self.is_immediate = Bool(self.is_immediate)

        if self.condition_expression is not None and not isinstance(self.condition_expression, BpmnConditionExpression):
            self.condition_expression = BpmnConditionExpression(**as_dict(self.condition_expression))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnSignal(BpmnRootElement):
    """
    A signal that is broadcast to every event waiting for it.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnSignal"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnSignal"
    class_name: ClassVar[str] = "BpmnSignal"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnSignal

    name: Optional[str] = None
    structure_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.structure_ref is not None and not isinstance(self.structure_ref, str):
            self.structure_ref = str(self.structure_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnSignalEventDefinition(BpmnEventDefinition):
    """
    The trigger of an event that sends or receives a signal.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnSignalEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnSignalEventDefinition"
    class_name: ClassVar[str] = "BpmnSignalEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnSignalEventDefinition

    signal_ref: Optional[str] = None
    fluxnova_async: Optional[Union[bool, Bool]] = False

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.signal_ref is not None and not isinstance(self.signal_ref, str):
            self.signal_ref = str(self.signal_ref)

        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnSource(BpmnModelElementInstance):
    """
    An element a relationship starts from.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnSource"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnSource"
    class_name: ClassVar[str] = "BpmnSource"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnSource


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnStartEvent(BpmnCatchEvent):
    """
    An event that starts a process or sub-process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnStartEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnStartEvent"
    class_name: ClassVar[str] = "BpmnStartEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnStartEvent

    is_interrupting: Optional[Union[bool, Bool]] = True
    fluxnova_async: Optional[Union[bool, Bool]] = False
    fluxnova_form_handler_class: Optional[str] = None
    fluxnova_form_key: Optional[str] = None
    fluxnova_form_ref: Optional[str] = None
    fluxnova_form_ref_binding: Optional[str] = None
    fluxnova_form_ref_version: Optional[str] = None
    fluxnova_initiator: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.is_interrupting is not None and not isinstance(self.is_interrupting, Bool):
            self.is_interrupting = Bool(self.is_interrupting)

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
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnSubConversation(BpmnConversationNode):
    """
    A conversation node that groups other conversation nodes.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnSubConversation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnSubConversation"
    class_name: ClassVar[str] = "BpmnSubConversation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnSubConversation

    conversation_nodes: Optional[Union[Union[dict, BpmnConversationNode], list[Union[dict, BpmnConversationNode]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.conversation_nodes, list):
            self.conversation_nodes = [self.conversation_nodes] if self.conversation_nodes is not None else []
        self.conversation_nodes = [v if isinstance(v, BpmnConversationNode) else BpmnConversationNode(**as_dict(v)) for v in self.conversation_nodes]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnSubProcess(BpmnActivity):
    """
    An activity that holds a process of its own.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnSubProcess"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnSubProcess"
    class_name: ClassVar[str] = "BpmnSubProcess"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnSubProcess

    triggered_by_event: Optional[Union[bool, Bool]] = False
    fluxnova_async: Optional[Union[bool, Bool]] = False
    lane_sets: Optional[Union[Union[dict, BpmnLaneSet], list[Union[dict, BpmnLaneSet]]]] = empty_list()
    flow_elements: Optional[Union[Union[dict, BpmnFlowElement], list[Union[dict, BpmnFlowElement]]]] = empty_list()
    artifacts: Optional[Union[Union[dict, BpmnArtifact], list[Union[dict, BpmnArtifact]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.triggered_by_event is not None and not isinstance(self.triggered_by_event, Bool):
            self.triggered_by_event = Bool(self.triggered_by_event)

        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        if not isinstance(self.lane_sets, list):
            self.lane_sets = [self.lane_sets] if self.lane_sets is not None else []
        self.lane_sets = [v if isinstance(v, BpmnLaneSet) else BpmnLaneSet(**as_dict(v)) for v in self.lane_sets]

        if not isinstance(self.flow_elements, list):
            self.flow_elements = [self.flow_elements] if self.flow_elements is not None else []
        self.flow_elements = [v if isinstance(v, BpmnFlowElement) else BpmnFlowElement(**as_dict(v)) for v in self.flow_elements]

        if not isinstance(self.artifacts, list):
            self.artifacts = [self.artifacts] if self.artifacts is not None else []
        self.artifacts = [v if isinstance(v, BpmnArtifact) else BpmnArtifact(**as_dict(v)) for v in self.artifacts]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnAdHocSubProcess(BpmnSubProcess):
    """
    A sub-process whose inner activities run in no fixed order, as its performers choose.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnAdHocSubProcess"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnAdHocSubProcess"
    class_name: ClassVar[str] = "BpmnAdHocSubProcess"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnAdHocSubProcess

    ordering: Optional[str] = "Parallel"
    cancel_remaining_instances: Optional[Union[bool, Bool]] = True
    completion_condition: Optional[Union[dict, BpmnCompletionCondition]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.ordering is not None and not isinstance(self.ordering, str):
            self.ordering = str(self.ordering)

        if self.cancel_remaining_instances is not None and not isinstance(self.cancel_remaining_instances, Bool):
            self.cancel_remaining_instances = Bool(self.cancel_remaining_instances)

        if self.completion_condition is not None and not isinstance(self.completion_condition, BpmnCompletionCondition):
            self.completion_condition = BpmnCompletionCondition(**as_dict(self.completion_condition))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnTarget(BpmnModelElementInstance):
    """
    An element a relationship leads to.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTarget"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTarget"
    class_name: ClassVar[str] = "BpmnTarget"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTarget


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnTask(BpmnActivity):
    """
    An atomic activity, one that is not broken down further.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTask"
    class_name: ClassVar[str] = "BpmnTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTask

    fluxnova_async: Optional[Union[bool, Bool]] = False

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.fluxnova_async is not None and not isinstance(self.fluxnova_async, Bool):
            self.fluxnova_async = Bool(self.fluxnova_async)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnBusinessRuleTask(BpmnTask):
    """
    A task that hands data to a business rules engine and receives its result.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnBusinessRuleTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnBusinessRuleTask"
    class_name: ClassVar[str] = "BpmnBusinessRuleTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnBusinessRuleTask

    implementation: Optional[str] = "##unspecified"
    fluxnova_class: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_topic: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_decision_ref: Optional[str] = None
    fluxnova_decision_ref_binding: Optional[str] = None
    fluxnova_decision_ref_version: Optional[str] = None
    fluxnova_decision_ref_version_tag: Optional[str] = None
    fluxnova_decision_ref_tenant_id: Optional[str] = None
    fluxnova_map_decision_result: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
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

        if self.fluxnova_topic is not None and not isinstance(self.fluxnova_topic, str):
            self.fluxnova_topic = str(self.fluxnova_topic)

        if self.fluxnova_type is not None and not isinstance(self.fluxnova_type, str):
            self.fluxnova_type = str(self.fluxnova_type)

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
        self.unknown_element_type = str(self.class_name)


class BpmnManualTask(BpmnTask):
    """
    A task done by a person without any system's help.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnManualTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnManualTask"
    class_name: ClassVar[str] = "BpmnManualTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnManualTask


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnReceiveTask(BpmnTask):
    """
    A task that waits for a message.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnReceiveTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnReceiveTask"
    class_name: ClassVar[str] = "BpmnReceiveTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnReceiveTask

    implementation: Optional[str] = "##WebService"
    instantiate: Optional[Union[bool, Bool]] = False
    message_ref: Optional[str] = None
    operation_ref: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.implementation is not None and not isinstance(self.implementation, str):
            self.implementation = str(self.implementation)

        if self.instantiate is not None and not isinstance(self.instantiate, Bool):
            self.instantiate = Bool(self.instantiate)

        if self.message_ref is not None and not isinstance(self.message_ref, str):
            self.message_ref = str(self.message_ref)

        if self.operation_ref is not None and not isinstance(self.operation_ref, str):
            self.operation_ref = str(self.operation_ref)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnScriptTask(BpmnTask):
    """
    A task that runs a script.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnScriptTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnScriptTask"
    class_name: ClassVar[str] = "BpmnScriptTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnScriptTask

    script_format: Optional[str] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_resource: Optional[str] = None
    script: Optional[Union[dict, BpmnScript]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.script_format is not None and not isinstance(self.script_format, str):
            self.script_format = str(self.script_format)

        if self.fluxnova_result_variable is not None and not isinstance(self.fluxnova_result_variable, str):
            self.fluxnova_result_variable = str(self.fluxnova_result_variable)

        if self.fluxnova_resource is not None and not isinstance(self.fluxnova_resource, str):
            self.fluxnova_resource = str(self.fluxnova_resource)

        if self.script is not None and not isinstance(self.script, BpmnScript):
            self.script = BpmnScript(**as_dict(self.script))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnSendTask(BpmnTask):
    """
    A task that sends a message.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnSendTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnSendTask"
    class_name: ClassVar[str] = "BpmnSendTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnSendTask

    implementation: Optional[str] = "##WebService"
    message_ref: Optional[str] = None
    operation_ref: Optional[str] = None
    fluxnova_class: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_topic: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.implementation is not None and not isinstance(self.implementation, str):
            self.implementation = str(self.implementation)

        if self.message_ref is not None and not isinstance(self.message_ref, str):
            self.message_ref = str(self.message_ref)

        if self.operation_ref is not None and not isinstance(self.operation_ref, str):
            self.operation_ref = str(self.operation_ref)

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
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnServiceTask(BpmnTask):
    """
    A task that calls a service, such as a web service or application code.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnServiceTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnServiceTask"
    class_name: ClassVar[str] = "BpmnServiceTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnServiceTask

    implementation: Optional[str] = "##WebService"
    operation_ref: Optional[str] = None
    fluxnova_class: Optional[str] = None
    fluxnova_delegate_expression: Optional[str] = None
    fluxnova_expression: Optional[str] = None
    fluxnova_result_variable: Optional[str] = None
    fluxnova_topic: Optional[str] = None
    fluxnova_type: Optional[str] = None
    fluxnova_task_priority: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.implementation is not None and not isinstance(self.implementation, str):
            self.implementation = str(self.implementation)

        if self.operation_ref is not None and not isinstance(self.operation_ref, str):
            self.operation_ref = str(self.operation_ref)

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
        self.unknown_element_type = str(self.class_name)


class BpmnTerminateEventDefinition(BpmnEventDefinition):
    """
    The trigger of an end event that ends the whole process instance at once.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTerminateEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTerminateEventDefinition"
    class_name: ClassVar[str] = "BpmnTerminateEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTerminateEventDefinition


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnText(BpmnModelElementInstance):
    """
    The text of a text annotation.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnText"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnText"
    class_name: ClassVar[str] = "BpmnText"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnText

    text_content: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.text_content is not None and not isinstance(self.text_content, str):
            self.text_content = str(self.text_content)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnTextAnnotation(BpmnArtifact):
    """
    An artifact that adds a note to a diagram.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTextAnnotation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTextAnnotation"
    class_name: ClassVar[str] = "BpmnTextAnnotation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTextAnnotation

    text_format: Optional[str] = "text/plain"
    text: Optional[Union[dict, BpmnText]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.text_format is not None and not isinstance(self.text_format, str):
            self.text_format = str(self.text_format)

        if self.text is not None and not isinstance(self.text, BpmnText):
            self.text = BpmnText(**as_dict(self.text))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnThrowEvent(BpmnEvent):
    """
    An event that throws a trigger, such as an end or intermediate throw event.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnThrowEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnThrowEvent"
    class_name: ClassVar[str] = "BpmnThrowEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnThrowEvent

    data_inputs: Optional[Union[Union[dict, BpmnDataInput], list[Union[dict, BpmnDataInput]]]] = empty_list()
    data_input_associations: Optional[Union[Union[dict, BpmnDataInputAssociation], list[Union[dict, BpmnDataInputAssociation]]]] = empty_list()
    input_set: Optional[Union[dict, BpmnInputSet]] = None
    event_definitions: Optional[Union[Union[dict, BpmnEventDefinition], list[Union[dict, BpmnEventDefinition]]]] = empty_list()
    event_definition_refs: Optional[Union[str, list[str]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.data_inputs, list):
            self.data_inputs = [self.data_inputs] if self.data_inputs is not None else []
        self.data_inputs = [v if isinstance(v, BpmnDataInput) else BpmnDataInput(**as_dict(v)) for v in self.data_inputs]

        self._normalize_inlined_as_list(slot_name="data_input_associations", slot_type=BpmnDataInputAssociation, key_name="target_ref", keyed=False)

        if self.input_set is not None and not isinstance(self.input_set, BpmnInputSet):
            self.input_set = BpmnInputSet(**as_dict(self.input_set))

        if not isinstance(self.event_definitions, list):
            self.event_definitions = [self.event_definitions] if self.event_definitions is not None else []
        self.event_definitions = [v if isinstance(v, BpmnEventDefinition) else BpmnEventDefinition(**as_dict(v)) for v in self.event_definitions]

        if not isinstance(self.event_definition_refs, list):
            self.event_definition_refs = [self.event_definition_refs] if self.event_definition_refs is not None else []
        self.event_definition_refs = [v if isinstance(v, str) else str(v) for v in self.event_definition_refs]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnEndEvent(BpmnThrowEvent):
    """
    An event that ends a path of a process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnEndEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnEndEvent"
    class_name: ClassVar[str] = "BpmnEndEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnEndEvent


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnIntermediateThrowEvent(BpmnThrowEvent):
    """
    An event on a process's path that throws a trigger.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnIntermediateThrowEvent"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnIntermediateThrowEvent"
    class_name: ClassVar[str] = "BpmnIntermediateThrowEvent"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnIntermediateThrowEvent


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnTimeCycle(BpmnExpression):
    """
    The expression for a timer that fires repeatedly.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTimeCycle"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTimeCycle"
    class_name: ClassVar[str] = "BpmnTimeCycle"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTimeCycle


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnTimeDate(BpmnExpression):
    """
    The expression for a timer that fires at a point in time.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTimeDate"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTimeDate"
    class_name: ClassVar[str] = "BpmnTimeDate"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTimeDate


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnTimeDuration(BpmnExpression):
    """
    The expression for a timer that fires once a duration has passed.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTimeDuration"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTimeDuration"
    class_name: ClassVar[str] = "BpmnTimeDuration"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTimeDuration


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnTimerEventDefinition(BpmnEventDefinition):
    """
    The trigger of an event that fires at a time, after a duration or on a cycle.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTimerEventDefinition"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTimerEventDefinition"
    class_name: ClassVar[str] = "BpmnTimerEventDefinition"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTimerEventDefinition

    time_date: Optional[Union[dict, BpmnTimeDate]] = None
    time_duration: Optional[Union[dict, BpmnTimeDuration]] = None
    time_cycle: Optional[Union[dict, BpmnTimeCycle]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.time_date is not None and not isinstance(self.time_date, BpmnTimeDate):
            self.time_date = BpmnTimeDate(**as_dict(self.time_date))

        if self.time_duration is not None and not isinstance(self.time_duration, BpmnTimeDuration):
            self.time_duration = BpmnTimeDuration(**as_dict(self.time_duration))

        if self.time_cycle is not None and not isinstance(self.time_cycle, BpmnTimeCycle):
            self.time_cycle = BpmnTimeCycle(**as_dict(self.time_cycle))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnTo(BpmnExpression):
    """
    The expression an assignment copies a value to.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTo"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTo"
    class_name: ClassVar[str] = "BpmnTo"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTo


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnTransaction(BpmnSubProcess):
    """
    A sub-process whose activities succeed or are undone together.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTransaction"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTransaction"
    class_name: ClassVar[str] = "BpmnTransaction"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTransaction

    method: Optional[Union[str, "BpmnTransactionMethod"]] = '##Compensate'

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.method is not None and not isinstance(self.method, BpmnTransactionMethod):
            self.method = BpmnTransactionMethod(self.method)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class BpmnTransformation(BpmnFormalExpression):
    """
    The expression that changes data as a data association copies it.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnTransformation"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnTransformation"
    class_name: ClassVar[str] = "BpmnTransformation"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnTransformation


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnUserTask(BpmnTask):
    """
    A task a person performs with the help of a software application.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnUserTask"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnUserTask"
    class_name: ClassVar[str] = "BpmnUserTask"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnUserTask

    implementation: Optional[str] = "##unspecified"
    fluxnova_assignee: Optional[str] = None
    fluxnova_candidate_groups: Optional[str] = None
    fluxnova_candidate_users: Optional[str] = None
    fluxnova_due_date: Optional[str] = None
    fluxnova_follow_up_date: Optional[str] = None
    fluxnova_form_handler_class: Optional[str] = None
    fluxnova_form_key: Optional[str] = None
    fluxnova_form_ref: Optional[str] = None
    fluxnova_form_ref_binding: Optional[str] = None
    fluxnova_form_ref_version: Optional[str] = None
    fluxnova_priority: Optional[str] = None
    renderings: Optional[Union[Union[dict, BpmnRendering], list[Union[dict, BpmnRendering]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.implementation is not None and not isinstance(self.implementation, str):
            self.implementation = str(self.implementation)

        if self.fluxnova_assignee is not None and not isinstance(self.fluxnova_assignee, str):
            self.fluxnova_assignee = str(self.fluxnova_assignee)

        if self.fluxnova_candidate_groups is not None and not isinstance(self.fluxnova_candidate_groups, str):
            self.fluxnova_candidate_groups = str(self.fluxnova_candidate_groups)

        if self.fluxnova_candidate_users is not None and not isinstance(self.fluxnova_candidate_users, str):
            self.fluxnova_candidate_users = str(self.fluxnova_candidate_users)

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

        if not isinstance(self.renderings, list):
            self.renderings = [self.renderings] if self.renderings is not None else []
        self.renderings = [v if isinstance(v, BpmnRendering) else BpmnRendering(**as_dict(v)) for v in self.renderings]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiDiagram(BpmnModelElementInstance):
    """
    A diagram of a model, the root of what Diagram Interchange draws.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiDiagram"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiDiagram"
    class_name: ClassVar[str] = "DiDiagram"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiDiagram

    name: Optional[str] = None
    bpmn_documentation: Optional[str] = None
    resolution: Optional[float] = None
    bpmn_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.bpmn_documentation is not None and not isinstance(self.bpmn_documentation, str):
            self.bpmn_documentation = str(self.bpmn_documentation)

        if self.resolution is not None and not isinstance(self.resolution, float):
            self.resolution = float(self.resolution)

        if self.bpmn_id is not None and not isinstance(self.bpmn_id, str):
            self.bpmn_id = str(self.bpmn_id)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnDiagram(DiDiagram):
    """
    A diagram of BPMN elements, with its plane and the label styles it uses.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnDiagram"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnDiagram"
    class_name: ClassVar[str] = "BpmnDiagram"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnDiagram

    bpmn_plane: Union[dict, "BpmnPlane"] = None
    bpmn_label_styles: Optional[Union[Union[dict, "BpmnLabelStyle"], list[Union[dict, "BpmnLabelStyle"]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.bpmn_plane):
            self.MissingRequiredField("bpmn_plane")
        if not isinstance(self.bpmn_plane, BpmnPlane):
            self.bpmn_plane = BpmnPlane(**as_dict(self.bpmn_plane))

        if not isinstance(self.bpmn_label_styles, list):
            self.bpmn_label_styles = [self.bpmn_label_styles] if self.bpmn_label_styles is not None else []
        self.bpmn_label_styles = [v if isinstance(v, BpmnLabelStyle) else BpmnLabelStyle(**as_dict(v)) for v in self.bpmn_label_styles]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiDiagramElement(BpmnModelElementInstance):
    """
    Any element drawn on a diagram.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiDiagramElement"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiDiagramElement"
    class_name: ClassVar[str] = "DiDiagramElement"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiDiagramElement

    bpmn_id: Optional[str] = None
    extension: Optional[Union[dict, "DiExtension"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bpmn_id is not None and not isinstance(self.bpmn_id, str):
            self.bpmn_id = str(self.bpmn_id)

        if self.extension is not None and not isinstance(self.extension, DiExtension):
            self.extension = DiExtension(**as_dict(self.extension))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiEdge(DiDiagramElement):
    """
    A diagram element drawn as a line through waypoints between two elements.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiEdge"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiEdge"
    class_name: ClassVar[str] = "DiEdge"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiEdge

    waypoints: Union[Union[dict, "DiWaypoint"], list[Union[dict, "DiWaypoint"]]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.waypoints):
            self.MissingRequiredField("waypoints")
        self._normalize_inlined_as_list(slot_name="waypoints", slot_type=DiWaypoint, key_name="x", keyed=False)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class DiExtension(BpmnModelElementInstance):
    """
    Tool-specific content attached to a diagram element.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiExtension"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiExtension"
    class_name: ClassVar[str] = "DiExtension"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiExtension


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiLabeledEdge(DiEdge):
    """
    An edge that can carry labels.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiLabeledEdge"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiLabeledEdge"
    class_name: ClassVar[str] = "DiLabeledEdge"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiLabeledEdge

    waypoints: Union[Union[dict, "DiWaypoint"], list[Union[dict, "DiWaypoint"]]] = None

    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnEdge(DiLabeledEdge):
    """
    The line that draws a connecting BPMN element, such as a sequence flow, message flow or association.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnEdge"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnEdge"
    class_name: ClassVar[str] = "BpmnEdge"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnEdge

    waypoints: Union[Union[dict, "DiWaypoint"], list[Union[dict, "DiWaypoint"]]] = None
    bpmn_element: Optional[str] = None
    source_element: Optional[str] = None
    target_element: Optional[str] = None
    message_visible_kind: Optional[Union[str, "BpmnMessageVisibleKind"]] = None
    bpmn_label: Optional[Union[dict, "BpmnLabel"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bpmn_element is not None and not isinstance(self.bpmn_element, str):
            self.bpmn_element = str(self.bpmn_element)

        if self.source_element is not None and not isinstance(self.source_element, str):
            self.source_element = str(self.source_element)

        if self.target_element is not None and not isinstance(self.target_element, str):
            self.target_element = str(self.target_element)

        if self.message_visible_kind is not None and not isinstance(self.message_visible_kind, BpmnMessageVisibleKind):
            self.message_visible_kind = BpmnMessageVisibleKind(self.message_visible_kind)

        if self.bpmn_label is not None and not isinstance(self.bpmn_label, BpmnLabel):
            self.bpmn_label = BpmnLabel(**as_dict(self.bpmn_label))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


class DiNode(DiDiagramElement):
    """
    A diagram element that other elements can connect to.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiNode"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiNode"
    class_name: ClassVar[str] = "DiNode"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiNode


    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiLabel(DiNode):
    """
    A diagram element that shows text, placed by its bounds.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiLabel"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiLabel"
    class_name: ClassVar[str] = "DiLabel"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiLabel

    bounds: Optional[Union[dict, "DcBounds"]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bounds is not None and not isinstance(self.bounds, DcBounds):
            self.bounds = DcBounds(**as_dict(self.bounds))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnLabel(DiLabel):
    """
    The label of a BPMN shape or edge, where its text is drawn.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnLabel"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnLabel"
    class_name: ClassVar[str] = "BpmnLabel"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnLabel

    label_style: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.label_style is not None and not isinstance(self.label_style, str):
            self.label_style = str(self.label_style)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiPlane(DiNode):
    """
    A diagram's drawing surface, which holds its shapes and edges.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiPlane"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiPlane"
    class_name: ClassVar[str] = "DiPlane"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiPlane

    diagram_elements: Optional[Union[Union[dict, DiDiagramElement], list[Union[dict, DiDiagramElement]]]] = empty_list()

    def __post_init__(self, *_: str, **kwargs: Any):
        if not isinstance(self.diagram_elements, list):
            self.diagram_elements = [self.diagram_elements] if self.diagram_elements is not None else []
        self.diagram_elements = [v if isinstance(v, DiDiagramElement) else DiDiagramElement(**as_dict(v)) for v in self.diagram_elements]

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnPlane(DiPlane):
    """
    The plane of a BPMN diagram, drawing one process, collaboration or sub-process.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnPlane"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnPlane"
    class_name: ClassVar[str] = "BpmnPlane"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnPlane

    bpmn_element: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bpmn_element is not None and not isinstance(self.bpmn_element, str):
            self.bpmn_element = str(self.bpmn_element)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiShape(DiNode):
    """
    A diagram element drawn as a figure inside its bounds.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiShape"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiShape"
    class_name: ClassVar[str] = "DiShape"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiShape

    bounds: Union[dict, "DcBounds"] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.bounds):
            self.MissingRequiredField("bounds")
        if not isinstance(self.bounds, DcBounds):
            self.bounds = DcBounds(**as_dict(self.bounds))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiLabeledShape(DiShape):
    """
    A shape that can carry labels.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiLabeledShape"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiLabeledShape"
    class_name: ClassVar[str] = "DiLabeledShape"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiLabeledShape

    bounds: Union[dict, "DcBounds"] = None

    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnShape(DiLabeledShape):
    """
    The figure that draws a BPMN element such as a task, event, gateway, pool or lane.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnShape"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnShape"
    class_name: ClassVar[str] = "BpmnShape"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnShape

    bounds: Union[dict, "DcBounds"] = None
    bpmn_element: Optional[str] = None
    is_horizontal: Optional[Union[bool, Bool]] = None
    is_expanded: Optional[Union[bool, Bool]] = None
    is_marker_visible: Optional[Union[bool, Bool]] = None
    is_message_visible: Optional[Union[bool, Bool]] = None
    participant_band_kind: Optional[Union[str, "BpmnParticipantBandKind"]] = None
    choreography_activity_shape: Optional[str] = None
    bpmn_label: Optional[Union[dict, BpmnLabel]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bpmn_element is not None and not isinstance(self.bpmn_element, str):
            self.bpmn_element = str(self.bpmn_element)

        if self.is_horizontal is not None and not isinstance(self.is_horizontal, Bool):
            self.is_horizontal = Bool(self.is_horizontal)

        if self.is_expanded is not None and not isinstance(self.is_expanded, Bool):
            self.is_expanded = Bool(self.is_expanded)

        if self.is_marker_visible is not None and not isinstance(self.is_marker_visible, Bool):
            self.is_marker_visible = Bool(self.is_marker_visible)

        if self.is_message_visible is not None and not isinstance(self.is_message_visible, Bool):
            self.is_message_visible = Bool(self.is_message_visible)

        if self.participant_band_kind is not None and not isinstance(self.participant_band_kind, BpmnParticipantBandKind):
            self.participant_band_kind = BpmnParticipantBandKind(self.participant_band_kind)

        if self.choreography_activity_shape is not None and not isinstance(self.choreography_activity_shape, str):
            self.choreography_activity_shape = str(self.choreography_activity_shape)

        if self.bpmn_label is not None and not isinstance(self.bpmn_label, BpmnLabel):
            self.bpmn_label = BpmnLabel(**as_dict(self.bpmn_label))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiStyle(BpmnModelElementInstance):
    """
    How a diagram element looks, such as its font or colour.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiStyle"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiStyle"
    class_name: ClassVar[str] = "DiStyle"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiStyle

    bpmn_id: Optional[str] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.bpmn_id is not None and not isinstance(self.bpmn_id, str):
            self.bpmn_id = str(self.bpmn_id)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class BpmnLabelStyle(DiStyle):
    """
    A font that BPMN labels share.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["BpmnLabelStyle"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:BpmnLabelStyle"
    class_name: ClassVar[str] = "BpmnLabelStyle"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.BpmnLabelStyle

    font: Union[dict, "DcFont"] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.font):
            self.MissingRequiredField("font")
        if not isinstance(self.font, DcFont):
            self.font = DcFont(**as_dict(self.font))

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DcBounds(BpmnModelElementInstance):
    """
    A rectangle, by its top-left corner and its size, that places a shape on a diagram.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DcBounds"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DcBounds"
    class_name: ClassVar[str] = "DcBounds"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DcBounds

    x: float = None
    y: float = None
    width: float = None
    height: float = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.x):
            self.MissingRequiredField("x")
        if not isinstance(self.x, float):
            self.x = float(self.x)

        if self._is_empty(self.y):
            self.MissingRequiredField("y")
        if not isinstance(self.y, float):
            self.y = float(self.y)

        if self._is_empty(self.width):
            self.MissingRequiredField("width")
        if not isinstance(self.width, float):
            self.width = float(self.width)

        if self._is_empty(self.height):
            self.MissingRequiredField("height")
        if not isinstance(self.height, float):
            self.height = float(self.height)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DcFont(BpmnModelElementInstance):
    """
    The font a diagram label is drawn in.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DcFont"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DcFont"
    class_name: ClassVar[str] = "DcFont"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DcFont

    name: Optional[str] = None
    size: Optional[float] = None
    is_bold: Optional[Union[bool, Bool]] = None
    is_italic: Optional[Union[bool, Bool]] = None
    is_underline: Optional[Union[bool, Bool]] = None
    is_strike_through: Optional[Union[bool, Bool]] = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self.name is not None and not isinstance(self.name, str):
            self.name = str(self.name)

        if self.size is not None and not isinstance(self.size, float):
            self.size = float(self.size)

        if self.is_bold is not None and not isinstance(self.is_bold, Bool):
            self.is_bold = Bool(self.is_bold)

        if self.is_italic is not None and not isinstance(self.is_italic, Bool):
            self.is_italic = Bool(self.is_italic)

        if self.is_underline is not None and not isinstance(self.is_underline, Bool):
            self.is_underline = Bool(self.is_underline)

        if self.is_strike_through is not None and not isinstance(self.is_strike_through, Bool):
            self.is_strike_through = Bool(self.is_strike_through)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DcPoint(BpmnModelElementInstance):
    """
    A point on a diagram, by its x and y coordinates.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DcPoint"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DcPoint"
    class_name: ClassVar[str] = "DcPoint"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DcPoint

    x: float = None
    y: float = None

    def __post_init__(self, *_: str, **kwargs: Any):
        if self._is_empty(self.x):
            self.MissingRequiredField("x")
        if not isinstance(self.x, float):
            self.x = float(self.x)

        if self._is_empty(self.y):
            self.MissingRequiredField("y")
        if not isinstance(self.y, float):
            self.y = float(self.y)

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


@dataclass(repr=False)
class DiWaypoint(DcPoint):
    """
    A point an edge passes through.
    """
    _inherited_slots: ClassVar[list[str]] = []

    class_class_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM["DiWaypoint"]
    class_class_curie: ClassVar[str] = "fluxnova_bpm_platform:DiWaypoint"
    class_name: ClassVar[str] = "DiWaypoint"
    class_model_uri: ClassVar[URIRef] = FLUXNOVA_BPM_PLATFORM.DiWaypoint

    x: float = None
    y: float = None

    def __post_init__(self, *_: str, **kwargs: Any):

        super().__post_init__(**kwargs)
        self.unknown_element_type = str(self.class_name)


# Enumerations
class HistoricProcessInstanceState(EnumDefinitionImpl):
    """
    The state a historic process instance records.
    """
    ACTIVE = PermissibleValue(
        text="ACTIVE",
        description="The process instance is running.")
    SUSPENDED = PermissibleValue(
        text="SUSPENDED",
        description="The process instance is suspended.")
    COMPLETED = PermissibleValue(
        text="COMPLETED",
        description="The process instance reached an end event.")
    EXTERNALLY_TERMINATED = PermissibleValue(
        text="EXTERNALLY_TERMINATED",
        description="The process instance was ended from outside, such as through the REST API.")
    INTERNALLY_TERMINATED = PermissibleValue(
        text="INTERNALLY_TERMINATED",
        description="The process instance was ended from within, such as by a terminate end event.")

    _defn = EnumDefinition(
        name="HistoricProcessInstanceState",
        description="The state a historic process instance records.",
    )

class HistoricVariableInstanceState(EnumDefinitionImpl):
    """
    Whether a historic variable instance still exists.
    """
    CREATED = PermissibleValue(
        text="CREATED",
        description="The variable exists.")
    DELETED = PermissibleValue(
        text="DELETED",
        description="The variable was deleted.")

    _defn = EnumDefinition(
        name="HistoricVariableInstanceState",
        description="Whether a historic variable instance still exists.",
    )

class ConfigurationStatus(EnumDefinitionImpl):
    """
    Whether a configuration entry is in effect.
    """
    ACTIVE = PermissibleValue(
        text="ACTIVE",
        description="The entry is in effect.")
    INACTIVE = PermissibleValue(
        text="INACTIVE",
        description="A newer version of the entry replaced it.")
    DELETED = PermissibleValue(
        text="DELETED",
        description="The entry was deleted, and is kept.")

    _defn = EnumDefinition(
        name="ConfigurationStatus",
        description="Whether a configuration entry is in effect.",
    )

class DelegationState(EnumDefinitionImpl):
    """
    Where a delegated task stands.
    """
    PENDING = PermissibleValue(
        text="PENDING",
        description="The task was delegated and waits for the delegate to resolve it.")
    RESOLVED = PermissibleValue(
        text="RESOLVED",
        description="The delegate resolved the task and handed it back to its owner.")

    _defn = EnumDefinition(
        name="DelegationState",
        description="Where a delegated task stands.",
    )

class BpmnAssociationDirection(EnumDefinitionImpl):
    """
    Which ends of an association an arrow is drawn at.
    """
    One = PermissibleValue(
        text="One",
        description="An arrow points at the target.")
    Both = PermissibleValue(
        text="Both",
        description="Arrows point at both ends.")

    _defn = EnumDefinition(
        name="BpmnAssociationDirection",
        description="Which ends of an association an arrow is drawn at.",
    )

    @classmethod
    def _addvals(cls):
        setattr(cls, "None",
            PermissibleValue(
                text="None",
                description="No arrow is drawn."))

class BpmnEventBasedGatewayType(EnumDefinitionImpl):
    """
    How an event-based gateway that starts a process waits for its events.
    """
    Exclusive = PermissibleValue(
        text="Exclusive",
        description="The first event starts the instance, and the others are no longer waited for.")
    Parallel = PermissibleValue(
        text="Parallel",
        description="Each event starts an instance, or joins the one already started.")

    _defn = EnumDefinition(
        name="BpmnEventBasedGatewayType",
        description="How an event-based gateway that starts a process waits for its events.",
    )

class BpmnGatewayDirection(EnumDefinitionImpl):
    """
    Whether a gateway splits flows, joins them or does both.
    """
    Unspecified = PermissibleValue(
        text="Unspecified",
        description="The model does not say.")
    Converging = PermissibleValue(
        text="Converging",
        description="The gateway joins incoming flows into one.")
    Diverging = PermissibleValue(
        text="Diverging",
        description="The gateway splits one flow into several.")
    Mixed = PermissibleValue(
        text="Mixed",
        description="The gateway both joins and splits.")

    _defn = EnumDefinition(
        name="BpmnGatewayDirection",
        description="Whether a gateway splits flows, joins them or does both.",
    )

class BpmnItemKind(EnumDefinitionImpl):
    """
    Whether an item is information or a physical thing.
    """
    Information = PermissibleValue(
        text="Information",
        description="The item is information.")
    Physical = PermissibleValue(
        text="Physical",
        description="The item is a physical thing.")

    _defn = EnumDefinition(
        name="BpmnItemKind",
        description="Whether an item is information or a physical thing.",
    )

class BpmnMultiInstanceFlowCondition(EnumDefinitionImpl):
    """
    When a multi-instance activity throws an event as its instances complete.
    """
    One = PermissibleValue(
        text="One",
        description="An event is thrown when the first instance completes.")
    All = PermissibleValue(
        text="All",
        description="No event is thrown.")
    Complex = PermissibleValue(
        text="Complex",
        description="The complex behavior definitions decide which events are thrown.")

    _defn = EnumDefinition(
        name="BpmnMultiInstanceFlowCondition",
        description="When a multi-instance activity throws an event as its instances complete.",
    )

    @classmethod
    def _addvals(cls):
        setattr(cls, "None",
            PermissibleValue(
                text="None",
                description="An event is thrown for each instance that completes."))

class BpmnProcessType(EnumDefinitionImpl):
    """
    Whether a process is private to its participant, public, or neither.
    """
    Public = PermissibleValue(
        text="Public",
        description="The process shows only what its participant exchanges with others.")
    Private = PermissibleValue(
        text="Private",
        description="The process is internal to its participant.")

    _defn = EnumDefinition(
        name="BpmnProcessType",
        description="Whether a process is private to its participant, public, or neither.",
    )

    @classmethod
    def _addvals(cls):
        setattr(cls, "None",
            PermissibleValue(
                text="None",
                description="The model does not say."))

class BpmnRelationshipDirection(EnumDefinitionImpl):
    """
    Which way a relationship points.
    """
    Forward = PermissibleValue(
        text="Forward",
        description="From its sources to its targets.")
    Backward = PermissibleValue(
        text="Backward",
        description="From its targets to its sources.")
    Both = PermissibleValue(
        text="Both",
        description="Both ways.")

    _defn = EnumDefinition(
        name="BpmnRelationshipDirection",
        description="Which way a relationship points.",
    )

    @classmethod
    def _addvals(cls):
        setattr(cls, "None",
            PermissibleValue(
                text="None",
                description="It has no direction."))

class BpmnTransactionMethod(EnumDefinitionImpl):
    """
    How a transaction commits or cancels, by the three values BPMN keeps from BPMN 1.1.
    """
    _defn = EnumDefinition(
        name="BpmnTransactionMethod",
        description="How a transaction commits or cancels, by the three values BPMN keeps from BPMN 1.1.",
    )

    @classmethod
    def _addvals(cls):
        setattr(cls, "##Compensate",
            PermissibleValue(
                text="##Compensate",
                title="Compensate",
                description="The transaction is cancelled by compensation; the default."))
        setattr(cls, "##Image",
            PermissibleValue(
                text="##Image",
                title="Image",
                description="The method BPMN 1.1 called image."))
        setattr(cls, "##Store",
            PermissibleValue(
                text="##Store",
                title="Store",
                description="The method BPMN 1.1 called store."))

class BpmnMessageVisibleKind(EnumDefinitionImpl):
    """
    Whether the message on a message flow is drawn as the one that starts the exchange.
    """
    initiating = PermissibleValue(
        text="initiating",
        description="The message starts the exchange.")
    non_initiating = PermissibleValue(
        text="non_initiating",
        description="The message answers one that started the exchange.")

    _defn = EnumDefinition(
        name="BpmnMessageVisibleKind",
        description="Whether the message on a message flow is drawn as the one that starts the exchange.",
    )

class BpmnParticipantBandKind(EnumDefinitionImpl):
    """
    Where a participant band sits on a choreography activity, and whether its participant initiates.
    """
    top_initiating = PermissibleValue(
        text="top_initiating",
        description="The top band, of the initiating participant.")
    middle_initiating = PermissibleValue(
        text="middle_initiating",
        description="A middle band, of the initiating participant.")
    bottom_initiating = PermissibleValue(
        text="bottom_initiating",
        description="The bottom band, of the initiating participant.")
    top_non_initiating = PermissibleValue(
        text="top_non_initiating",
        description="The top band, of a participant that does not initiate.")
    middle_non_initiating = PermissibleValue(
        text="middle_non_initiating",
        description="A middle band, of a participant that does not initiate.")
    bottom_non_initiating = PermissibleValue(
        text="bottom_non_initiating",
        description="The bottom band, of a participant that does not initiate.")

    _defn = EnumDefinition(
        name="BpmnParticipantBandKind",
        description="Where a participant band sits on a choreography activity, and whether its participant initiates.",
    )

# Slots
class slots:
    pass

slots.attachments = Slot(uri=FLUXNOVA_BPM_PLATFORM.attachments, name="attachments", curie=FLUXNOVA_BPM_PLATFORM.curie('attachments'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.attachments, domain=None, range=Optional[Union[dict[Union[str, FluxnovaAttachmentId], Union[dict, FluxnovaAttachment]], list[Union[dict, FluxnovaAttachment]]]])

slots.authorization_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.authorization_entries, name="authorization_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('authorization_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.authorization_entries, domain=None, range=Optional[Union[dict[Union[str, FluxnovaAuthorizationId], Union[dict, FluxnovaAuthorization]], list[Union[dict, FluxnovaAuthorization]]]])

slots.batches = Slot(uri=FLUXNOVA_BPM_PLATFORM.batches, name="batches", curie=FLUXNOVA_BPM_PLATFORM.curie('batches'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.batches, domain=None, range=Optional[Union[dict[Union[str, FluxnovaBatchId], Union[dict, FluxnovaBatch]], list[Union[dict, FluxnovaBatch]]]])

slots.byte_arrays = Slot(uri=FLUXNOVA_BPM_PLATFORM.byte_arrays, name="byte_arrays", curie=FLUXNOVA_BPM_PLATFORM.curie('byte_arrays'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.byte_arrays, domain=None, range=Optional[Union[dict[Union[str, FluxnovaByteArrayId], Union[dict, FluxnovaByteArray]], list[Union[dict, FluxnovaByteArray]]]])

slots.case_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definitions, name="case_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_definitions, domain=None, range=Optional[Union[dict[Union[str, FluxnovaCaseDefinitionId], Union[dict, FluxnovaCaseDefinition]], list[Union[dict, FluxnovaCaseDefinition]]]])

slots.case_executions = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_executions, name="case_executions", curie=FLUXNOVA_BPM_PLATFORM.curie('case_executions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_executions, domain=None, range=Optional[Union[dict[Union[str, FluxnovaCaseExecutionId], Union[dict, FluxnovaCaseExecution]], list[Union[dict, FluxnovaCaseExecution]]]])

slots.case_sentry_parts = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_sentry_parts, name="case_sentry_parts", curie=FLUXNOVA_BPM_PLATFORM.curie('case_sentry_parts'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_sentry_parts, domain=None, range=Optional[Union[dict[Union[str, FluxnovaCaseSentryPartId], Union[dict, FluxnovaCaseSentryPart]], list[Union[dict, FluxnovaCaseSentryPart]]]])

slots.comment_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.comment_entries, name="comment_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('comment_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.comment_entries, domain=None, range=Optional[Union[dict[Union[str, FluxnovaCommentId], Union[dict, FluxnovaComment]], list[Union[dict, FluxnovaComment]]]])

slots.configuration_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.configuration_entries, name="configuration_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('configuration_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.configuration_entries, domain=None, range=Optional[Union[dict[Union[str, FluxnovaConfigurationId], Union[dict, FluxnovaConfiguration]], list[Union[dict, FluxnovaConfiguration]]]])

slots.decision_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_definitions, name="decision_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_definitions, domain=None, range=Optional[Union[dict[Union[str, FluxnovaDecisionDefinitionId], Union[dict, FluxnovaDecisionDefinition]], list[Union[dict, FluxnovaDecisionDefinition]]]])

slots.decision_requirements_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definitions, name="decision_requirements_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_requirements_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definitions, domain=None, range=Optional[Union[dict[Union[str, FluxnovaDecisionRequirementsDefinitionId], Union[dict, FluxnovaDecisionRequirementsDefinition]], list[Union[dict, FluxnovaDecisionRequirementsDefinition]]]])

slots.deployments = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployments, name="deployments", curie=FLUXNOVA_BPM_PLATFORM.curie('deployments'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.deployments, domain=None, range=Optional[Union[dict[Union[str, FluxnovaDeploymentId], Union[dict, FluxnovaDeployment]], list[Union[dict, FluxnovaDeployment]]]])

slots.engine_properties = Slot(uri=FLUXNOVA_BPM_PLATFORM.engine_properties, name="engine_properties", curie=FLUXNOVA_BPM_PLATFORM.curie('engine_properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.engine_properties, domain=None, range=Optional[Union[dict[Union[str, FluxnovaEnginePropertyName], Union[dict, FluxnovaEngineProperty]], list[Union[dict, FluxnovaEngineProperty]]]])

slots.event_subscriptions = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_subscriptions, name="event_subscriptions", curie=FLUXNOVA_BPM_PLATFORM.curie('event_subscriptions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_subscriptions, domain=None, range=Optional[Union[dict[Union[str, FluxnovaEventSubscriptionId], Union[dict, FluxnovaEventSubscription]], list[Union[dict, FluxnovaEventSubscription]]]])

slots.executions = Slot(uri=FLUXNOVA_BPM_PLATFORM.executions, name="executions", curie=FLUXNOVA_BPM_PLATFORM.curie('executions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.executions, domain=None, range=Optional[Union[dict[Union[str, FluxnovaExecutionId], Union[dict, FluxnovaExecution]], list[Union[dict, FluxnovaExecution]]]])

slots.external_tasks = Slot(uri=FLUXNOVA_BPM_PLATFORM.external_tasks, name="external_tasks", curie=FLUXNOVA_BPM_PLATFORM.curie('external_tasks'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.external_tasks, domain=None, range=Optional[Union[dict[Union[str, FluxnovaExternalTaskId], Union[dict, FluxnovaExternalTask]], list[Union[dict, FluxnovaExternalTask]]]])

slots.filter_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.filter_entries, name="filter_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('filter_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.filter_entries, domain=None, range=Optional[Union[dict[Union[str, FluxnovaFilterId], Union[dict, FluxnovaFilter]], list[Union[dict, FluxnovaFilter]]]])

slots.form_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.form_definitions, name="form_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('form_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.form_definitions, domain=None, range=Optional[Union[dict[Union[str, FluxnovaFormDefinitionId], Union[dict, FluxnovaFormDefinition]], list[Union[dict, FluxnovaFormDefinition]]]])

slots.groups = Slot(uri=FLUXNOVA_BPM_PLATFORM.groups, name="groups", curie=FLUXNOVA_BPM_PLATFORM.curie('groups'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.groups, domain=None, range=Optional[Union[dict[Union[str, FluxnovaGroupId], Union[dict, FluxnovaGroup]], list[Union[dict, FluxnovaGroup]]]])

slots.historic_activity_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_activity_instances, name="historic_activity_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_activity_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_activity_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricActivityInstanceId], Union[dict, FluxnovaHistoricActivityInstance]], list[Union[dict, FluxnovaHistoricActivityInstance]]]])

slots.historic_batches = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_batches, name="historic_batches", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_batches'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_batches, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricBatchId], Union[dict, FluxnovaHistoricBatch]], list[Union[dict, FluxnovaHistoricBatch]]]])

slots.historic_case_activity_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_case_activity_instances, name="historic_case_activity_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_case_activity_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_case_activity_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricCaseActivityInstanceId], Union[dict, FluxnovaHistoricCaseActivityInstance]], list[Union[dict, FluxnovaHistoricCaseActivityInstance]]]])

slots.historic_case_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_case_instances, name="historic_case_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_case_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_case_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricCaseInstanceId], Union[dict, FluxnovaHistoricCaseInstance]], list[Union[dict, FluxnovaHistoricCaseInstance]]]])

slots.historic_decision_input_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_decision_input_instances, name="historic_decision_input_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_decision_input_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_decision_input_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricDecisionInputInstanceId], Union[dict, FluxnovaHistoricDecisionInputInstance]], list[Union[dict, FluxnovaHistoricDecisionInputInstance]]]])

slots.historic_decision_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_decision_instances, name="historic_decision_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_decision_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_decision_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricDecisionInstanceId], Union[dict, FluxnovaHistoricDecisionInstance]], list[Union[dict, FluxnovaHistoricDecisionInstance]]]])

slots.historic_decision_output_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_decision_output_instances, name="historic_decision_output_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_decision_output_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_decision_output_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricDecisionOutputInstanceId], Union[dict, FluxnovaHistoricDecisionOutputInstance]], list[Union[dict, FluxnovaHistoricDecisionOutputInstance]]]])

slots.historic_details = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_details, name="historic_details", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_details'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_details, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricDetailId], Union[dict, FluxnovaHistoricDetail]], list[Union[dict, FluxnovaHistoricDetail]]]])

slots.historic_external_task_logs = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_external_task_logs, name="historic_external_task_logs", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_external_task_logs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_external_task_logs, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricExternalTaskLogId], Union[dict, FluxnovaHistoricExternalTaskLog]], list[Union[dict, FluxnovaHistoricExternalTaskLog]]]])

slots.historic_identity_links = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_identity_links, name="historic_identity_links", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_identity_links'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_identity_links, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricIdentityLinkId], Union[dict, FluxnovaHistoricIdentityLink]], list[Union[dict, FluxnovaHistoricIdentityLink]]]])

slots.historic_incidents = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_incidents, name="historic_incidents", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_incidents'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_incidents, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricIncidentId], Union[dict, FluxnovaHistoricIncident]], list[Union[dict, FluxnovaHistoricIncident]]]])

slots.historic_job_logs = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_job_logs, name="historic_job_logs", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_job_logs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_job_logs, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricJobLogId], Union[dict, FluxnovaHistoricJobLog]], list[Union[dict, FluxnovaHistoricJobLog]]]])

slots.historic_process_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_process_instances, name="historic_process_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_process_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_process_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricProcessInstanceId], Union[dict, FluxnovaHistoricProcessInstance]], list[Union[dict, FluxnovaHistoricProcessInstance]]]])

slots.historic_task_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_task_instances, name="historic_task_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_task_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_task_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricTaskInstanceId], Union[dict, FluxnovaHistoricTaskInstance]], list[Union[dict, FluxnovaHistoricTaskInstance]]]])

slots.historic_variable_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_variable_instances, name="historic_variable_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_variable_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.historic_variable_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaHistoricVariableInstanceId], Union[dict, FluxnovaHistoricVariableInstance]], list[Union[dict, FluxnovaHistoricVariableInstance]]]])

slots.identity_infos = Slot(uri=FLUXNOVA_BPM_PLATFORM.identity_infos, name="identity_infos", curie=FLUXNOVA_BPM_PLATFORM.curie('identity_infos'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.identity_infos, domain=None, range=Optional[Union[dict[Union[str, FluxnovaIdentityInfoId], Union[dict, FluxnovaIdentityInfo]], list[Union[dict, FluxnovaIdentityInfo]]]])

slots.identity_links = Slot(uri=FLUXNOVA_BPM_PLATFORM.identity_links, name="identity_links", curie=FLUXNOVA_BPM_PLATFORM.curie('identity_links'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.identity_links, domain=None, range=Optional[Union[dict[Union[str, FluxnovaIdentityLinkId], Union[dict, FluxnovaIdentityLink]], list[Union[dict, FluxnovaIdentityLink]]]])

slots.incidents = Slot(uri=FLUXNOVA_BPM_PLATFORM.incidents, name="incidents", curie=FLUXNOVA_BPM_PLATFORM.curie('incidents'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incidents, domain=None, range=Optional[Union[dict[Union[str, FluxnovaIncidentId], Union[dict, FluxnovaIncident]], list[Union[dict, FluxnovaIncident]]]])

slots.job_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definitions, name="job_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_definitions, domain=None, range=Optional[Union[dict[Union[str, FluxnovaJobDefinitionId], Union[dict, FluxnovaJobDefinition]], list[Union[dict, FluxnovaJobDefinition]]]])

slots.jobs = Slot(uri=FLUXNOVA_BPM_PLATFORM.jobs, name="jobs", curie=FLUXNOVA_BPM_PLATFORM.curie('jobs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.jobs, domain=None, range=Optional[Union[dict[Union[str, FluxnovaJobId], Union[dict, FluxnovaJob]], list[Union[dict, FluxnovaJob]]]])

slots.memberships = Slot(uri=FLUXNOVA_BPM_PLATFORM.memberships, name="memberships", curie=FLUXNOVA_BPM_PLATFORM.curie('memberships'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.memberships, domain=None, range=Optional[Union[Union[dict, FluxnovaMembership], list[Union[dict, FluxnovaMembership]]]])

slots.meter_logs = Slot(uri=FLUXNOVA_BPM_PLATFORM.meter_logs, name="meter_logs", curie=FLUXNOVA_BPM_PLATFORM.curie('meter_logs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.meter_logs, domain=None, range=Optional[Union[dict[Union[str, FluxnovaMeterLogId], Union[dict, FluxnovaMeterLog]], list[Union[dict, FluxnovaMeterLog]]]])

slots.process_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definitions, name="process_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process_definitions, domain=None, range=Optional[Union[dict[Union[str, FluxnovaProcessDefinitionId], Union[dict, FluxnovaProcessDefinition]], list[Union[dict, FluxnovaProcessDefinition]]]])

slots.schema_log_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.schema_log_entries, name="schema_log_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('schema_log_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.schema_log_entries, domain=None, range=Optional[Union[dict[Union[str, FluxnovaSchemaLogEntryId], Union[dict, FluxnovaSchemaLogEntry]], list[Union[dict, FluxnovaSchemaLogEntry]]]])

slots.task_meter_logs = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_meter_logs, name="task_meter_logs", curie=FLUXNOVA_BPM_PLATFORM.curie('task_meter_logs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.task_meter_logs, domain=None, range=Optional[Union[dict[Union[str, FluxnovaTaskMeterLogId], Union[dict, FluxnovaTaskMeterLog]], list[Union[dict, FluxnovaTaskMeterLog]]]])

slots.tasks = Slot(uri=FLUXNOVA_BPM_PLATFORM.tasks, name="tasks", curie=FLUXNOVA_BPM_PLATFORM.curie('tasks'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.tasks, domain=None, range=Optional[Union[dict[Union[str, FluxnovaTaskId], Union[dict, FluxnovaTask]], list[Union[dict, FluxnovaTask]]]])

slots.tenant_memberships = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_memberships, name="tenant_memberships", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_memberships'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.tenant_memberships, domain=None, range=Optional[Union[dict[Union[str, FluxnovaTenantMembershipId], Union[dict, FluxnovaTenantMembership]], list[Union[dict, FluxnovaTenantMembership]]]])

slots.tenants = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenants, name="tenants", curie=FLUXNOVA_BPM_PLATFORM.curie('tenants'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.tenants, domain=None, range=Optional[Union[dict[Union[str, FluxnovaTenantId], Union[dict, FluxnovaTenant]], list[Union[dict, FluxnovaTenant]]]])

slots.user_operation_log_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_operation_log_entries, name="user_operation_log_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('user_operation_log_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.user_operation_log_entries, domain=None, range=Optional[Union[dict[Union[str, FluxnovaUserOperationLogEntryId], Union[dict, FluxnovaUserOperationLogEntry]], list[Union[dict, FluxnovaUserOperationLogEntry]]]])

slots.users = Slot(uri=FLUXNOVA_BPM_PLATFORM.users, name="users", curie=FLUXNOVA_BPM_PLATFORM.curie('users'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.users, domain=None, range=Optional[Union[dict[Union[str, FluxnovaUserId], Union[dict, FluxnovaUser]], list[Union[dict, FluxnovaUser]]]])

slots.variable_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.variable_instances, name="variable_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('variable_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_instances, domain=None, range=Optional[Union[dict[Union[str, FluxnovaVariableInstanceId], Union[dict, FluxnovaVariableInstance]], list[Union[dict, FluxnovaVariableInstance]]]])

slots.action = Slot(uri=FLUXNOVA_BPM_PLATFORM.action, name="action", curie=FLUXNOVA_BPM_PLATFORM.curie('action'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.action, domain=None, range=Optional[str])

slots.activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_id, name="activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_id, domain=None, range=Optional[str])

slots.activity_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_instance_id, name="activity_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_instance_id, domain=None, range=Optional[str])

slots.activity_instance_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_instance_state, name="activity_instance_state", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_instance_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_instance_state, domain=None, range=Optional[int])

slots.activity_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_name, name="activity_name", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_name, domain=None, range=Optional[str])

slots.activity_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_type, name="activity_type", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.activity_type, domain=None, range=str)

slots.annotation = Slot(uri=FLUXNOVA_BPM_PLATFORM.annotation, name="annotation", curie=FLUXNOVA_BPM_PLATFORM.curie('annotation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.annotation, domain=None, range=Optional[str])

slots.assignee = Slot(uri=FLUXNOVA_BPM_PLATFORM.assignee, name="assignee", curie=FLUXNOVA_BPM_PLATFORM.curie('assignee'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.assignee, domain=None, range=Optional[str])

slots.assignee_hash = Slot(uri=FLUXNOVA_BPM_PLATFORM.assignee_hash, name="assignee_hash", curie=FLUXNOVA_BPM_PLATFORM.curie('assignee_hash'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.assignee_hash, domain=None, range=Optional[int])

slots.assigner_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.assigner_id, name="assigner_id", curie=FLUXNOVA_BPM_PLATFORM.curie('assigner_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.assigner_id, domain=None, range=Optional[str])

slots.attempts = Slot(uri=FLUXNOVA_BPM_PLATFORM.attempts, name="attempts", curie=FLUXNOVA_BPM_PLATFORM.curie('attempts'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.attempts, domain=None, range=Optional[int])

slots.batch_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.batch_id, name="batch_id", curie=FLUXNOVA_BPM_PLATFORM.curie('batch_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.batch_id, domain=None, range=Optional[str])

slots.batch_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.batch_job_definition_id, name="batch_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('batch_job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.batch_job_definition_id, domain=None, range=Optional[str])

slots.business_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.business_key, name="business_key", curie=FLUXNOVA_BPM_PLATFORM.curie('business_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.business_key, domain=None, range=Optional[str])

slots.byte_array_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.byte_array_id, name="byte_array_id", curie=FLUXNOVA_BPM_PLATFORM.curie('byte_array_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.byte_array_id, domain=None, range=Optional[str])

slots.bytes = Slot(uri=FLUXNOVA_BPM_PLATFORM.bytes, name="bytes", curie=FLUXNOVA_BPM_PLATFORM.curie('bytes'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bytes, domain=None, range=Optional[str])

slots.cached_entity_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.cached_entity_state, name="cached_entity_state", curie=FLUXNOVA_BPM_PLATFORM.curie('cached_entity_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.cached_entity_state, domain=None, range=Optional[int])

slots.called_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.called_case_instance_id, name="called_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('called_case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.called_case_instance_id, domain=None, range=Optional[str])

slots.called_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.called_process_instance_id, name="called_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('called_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.called_process_instance_id, domain=None, range=Optional[str])

slots.case_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_activity_id, name="case_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_activity_id, domain=None, range=str)

slots.case_activity_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_activity_name, name="case_activity_name", curie=FLUXNOVA_BPM_PLATFORM.curie('case_activity_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_activity_name, domain=None, range=Optional[str])

slots.case_activity_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_activity_type, name="case_activity_type", curie=FLUXNOVA_BPM_PLATFORM.curie('case_activity_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_activity_type, domain=None, range=Optional[str])

slots.case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, domain=None, range=Optional[str])

slots.case_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_key, name="case_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_definition_key, domain=None, range=Optional[str])

slots.case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, name="case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, domain=None, range=Optional[str])

slots.case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, domain=None, range=Optional[str])

slots.category = Slot(uri=FLUXNOVA_BPM_PLATFORM.category, name="category", curie=FLUXNOVA_BPM_PLATFORM.curie('category'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.category, domain=None, range=Optional[str])

slots.cause_incident_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.cause_incident_id, name="cause_incident_id", curie=FLUXNOVA_BPM_PLATFORM.curie('cause_incident_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.cause_incident_id, domain=None, range=Optional[str])

slots.clause_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.clause_id, name="clause_id", curie=FLUXNOVA_BPM_PLATFORM.curie('clause_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.clause_id, domain=None, range=Optional[str])

slots.clause_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.clause_name, name="clause_name", curie=FLUXNOVA_BPM_PLATFORM.curie('clause_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.clause_name, domain=None, range=Optional[str])

slots.close_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.close_time, name="close_time", curie=FLUXNOVA_BPM_PLATFORM.curie('close_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.close_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.collect_result_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.collect_result_value, name="collect_result_value", curie=FLUXNOVA_BPM_PLATFORM.curie('collect_result_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.collect_result_value, domain=None, range=Optional[float])

slots.configuration = Slot(uri=FLUXNOVA_BPM_PLATFORM.configuration, name="configuration", curie=FLUXNOVA_BPM_PLATFORM.curie('configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.configuration, domain=None, range=Optional[str])

slots.configuration_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.configuration_key, name="configuration_key", curie=FLUXNOVA_BPM_PLATFORM.curie('configuration_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.configuration_key, domain=None, range=str)

slots.configuration_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.configuration_value, name="configuration_value", curie=FLUXNOVA_BPM_PLATFORM.curie('configuration_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.configuration_value, domain=None, range=str)

slots.content_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.content_id, name="content_id", curie=FLUXNOVA_BPM_PLATFORM.curie('content_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.content_id, domain=None, range=Optional[str])

slots.create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.create_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.create_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_user_id, name="create_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('create_user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.create_user_id, domain=None, range=Optional[str])

slots.created = Slot(uri=FLUXNOVA_BPM_PLATFORM.created, name="created", curie=FLUXNOVA_BPM_PLATFORM.curie('created'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.created, domain=None, range=Union[str, XSDDateTime])

slots.created_at = Slot(uri=FLUXNOVA_BPM_PLATFORM.created_at, name="created_at", curie=FLUXNOVA_BPM_PLATFORM.curie('created_at'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.created_at, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.created_by = Slot(uri=FLUXNOVA_BPM_PLATFORM.created_by, name="created_by", curie=FLUXNOVA_BPM_PLATFORM.curie('created_by'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.created_by, domain=None, range=Optional[str])

slots.current_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.current_state, name="current_state", curie=FLUXNOVA_BPM_PLATFORM.curie('current_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.current_state, domain=None, range=Optional[int])

slots.decision_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_definition_id, name="decision_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_definition_id, domain=None, range=str)

slots.decision_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_definition_key, name="decision_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_definition_key, domain=None, range=str)

slots.decision_definition_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_definition_name, name="decision_definition_name", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_definition_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_definition_name, domain=None, range=Optional[str])

slots.decision_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_instance_id, name="decision_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_instance_id, domain=None, range=str)

slots.decision_requirements_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_id, name="decision_requirements_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_requirements_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_id, domain=None, range=Optional[str])

slots.decision_requirements_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_key, name="decision_requirements_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_requirements_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_key, domain=None, range=Optional[str])

slots.delegation_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.delegation_state, name="delegation_state", curie=FLUXNOVA_BPM_PLATFORM.curie('delegation_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.delegation_state, domain=None, range=Optional[Union[str, "DelegationState"]])

slots.delete_reason = Slot(uri=FLUXNOVA_BPM_PLATFORM.delete_reason, name="delete_reason", curie=FLUXNOVA_BPM_PLATFORM.curie('delete_reason'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.delete_reason, domain=None, range=Optional[str])

slots.deploy_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.deploy_time, name="deploy_time", curie=FLUXNOVA_BPM_PLATFORM.curie('deploy_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.deploy_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.deployment_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployment_id, name="deployment_id", curie=FLUXNOVA_BPM_PLATFORM.curie('deployment_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.deployment_id, domain=None, range=Optional[str])

slots.description = Slot(uri=FLUXNOVA_BPM_PLATFORM.description, name="description", curie=FLUXNOVA_BPM_PLATFORM.curie('description'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.description, domain=None, range=Optional[str])

slots.diagram_resource_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.diagram_resource_name, name="diagram_resource_name", curie=FLUXNOVA_BPM_PLATFORM.curie('diagram_resource_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diagram_resource_name, domain=None, range=Optional[str])

slots.double_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.double_value, name="double_value", curie=FLUXNOVA_BPM_PLATFORM.curie('double_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.double_value, domain=None, range=Optional[float])

slots.due_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.due_date, name="due_date", curie=FLUXNOVA_BPM_PLATFORM.curie('due_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.due_date, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.duration = Slot(uri=FLUXNOVA_BPM_PLATFORM.duration, name="duration", curie=FLUXNOVA_BPM_PLATFORM.curie('duration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.duration, domain=None, range=Optional[int])

slots.email = Slot(uri=FLUXNOVA_BPM_PLATFORM.email, name="email", curie=FLUXNOVA_BPM_PLATFORM.curie('email'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.email, domain=None, range=Optional[str])

slots.end_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.end_activity_id, name="end_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('end_activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.end_activity_id, domain=None, range=Optional[str])

slots.end_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.end_time, name="end_time", curie=FLUXNOVA_BPM_PLATFORM.curie('end_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.end_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.entity_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.entity_type, name="entity_type", curie=FLUXNOVA_BPM_PLATFORM.curie('entity_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.entity_type, domain=None, range=Optional[str])

slots.error_details_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.error_details_id, name="error_details_id", curie=FLUXNOVA_BPM_PLATFORM.curie('error_details_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.error_details_id, domain=None, range=Optional[str])

slots.error_message = Slot(uri=FLUXNOVA_BPM_PLATFORM.error_message, name="error_message", curie=FLUXNOVA_BPM_PLATFORM.curie('error_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.error_message, domain=None, range=Optional[str])

slots.evaluation_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.evaluation_time, name="evaluation_time", curie=FLUXNOVA_BPM_PLATFORM.curie('evaluation_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.evaluation_time, domain=None, range=Union[str, XSDDateTime])

slots.event_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_name, name="event_name", curie=FLUXNOVA_BPM_PLATFORM.curie('event_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_name, domain=None, range=Optional[str])

slots.event_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_time, name="event_time", curie=FLUXNOVA_BPM_PLATFORM.curie('event_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_time, domain=None, range=Union[str, XSDDateTime])

slots.event_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_type, name="event_type", curie=FLUXNOVA_BPM_PLATFORM.curie('event_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.event_type, domain=None, range=str)

slots.exception_message = Slot(uri=FLUXNOVA_BPM_PLATFORM.exception_message, name="exception_message", curie=FLUXNOVA_BPM_PLATFORM.curie('exception_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.exception_message, domain=None, range=Optional[str])

slots.exception_stack_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.exception_stack_id, name="exception_stack_id", curie=FLUXNOVA_BPM_PLATFORM.curie('exception_stack_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.exception_stack_id, domain=None, range=Optional[str])

slots.execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.execution_id, domain=None, range=Optional[str])

slots.execution_start_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_start_time, name="execution_start_time", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.execution_start_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.external_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.external_task_id, name="external_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('external_task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.external_task_id, domain=None, range=Optional[str])

slots.failed_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.failed_activity_id, name="failed_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('failed_activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.failed_activity_id, domain=None, range=Optional[str])

slots.first_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.first_name, name="first_name", curie=FLUXNOVA_BPM_PLATFORM.curie('first_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.first_name, domain=None, range=Optional[str])

slots.follow_up_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.follow_up_date, name="follow_up_date", curie=FLUXNOVA_BPM_PLATFORM.curie('follow_up_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.follow_up_date, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.full_message = Slot(uri=FLUXNOVA_BPM_PLATFORM.full_message, name="full_message", curie=FLUXNOVA_BPM_PLATFORM.curie('full_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.full_message, domain=None, range=Optional[str])

slots.group_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.group_id, name="group_id", curie=FLUXNOVA_BPM_PLATFORM.curie('group_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.group_id, domain=None, range=Optional[str])

slots.handler_configuration = Slot(uri=FLUXNOVA_BPM_PLATFORM.handler_configuration, name="handler_configuration", curie=FLUXNOVA_BPM_PLATFORM.curie('handler_configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.handler_configuration, domain=None, range=Optional[str])

slots.handler_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.handler_type, name="handler_type", curie=FLUXNOVA_BPM_PLATFORM.curie('handler_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.handler_type, domain=None, range=Optional[str])

slots.has_start_form_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.has_start_form_key, name="has_start_form_key", curie=FLUXNOVA_BPM_PLATFORM.curie('has_start_form_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.has_start_form_key, domain=None, range=Optional[Union[bool, Bool]])

slots.history_configuration = Slot(uri=FLUXNOVA_BPM_PLATFORM.history_configuration, name="history_configuration", curie=FLUXNOVA_BPM_PLATFORM.curie('history_configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.history_configuration, domain=None, range=Optional[str])

slots.history_time_to_live = Slot(uri=FLUXNOVA_BPM_PLATFORM.history_time_to_live, name="history_time_to_live", curie=FLUXNOVA_BPM_PLATFORM.curie('history_time_to_live'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.history_time_to_live, domain=None, range=Optional[int])

slots.hostname = Slot(uri=FLUXNOVA_BPM_PLATFORM.hostname, name="hostname", curie=FLUXNOVA_BPM_PLATFORM.curie('hostname'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.hostname, domain=None, range=Optional[str])

slots.id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.id, domain=None, range=URIRef)

slots.incident_message = Slot(uri=FLUXNOVA_BPM_PLATFORM.incident_message, name="incident_message", curie=FLUXNOVA_BPM_PLATFORM.curie('incident_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incident_message, domain=None, range=Optional[str])

slots.incident_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.incident_state, name="incident_state", curie=FLUXNOVA_BPM_PLATFORM.curie('incident_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incident_state, domain=None, range=Optional[int])

slots.incident_timestamp = Slot(uri=FLUXNOVA_BPM_PLATFORM.incident_timestamp, name="incident_timestamp", curie=FLUXNOVA_BPM_PLATFORM.curie('incident_timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incident_timestamp, domain=None, range=Union[str, XSDDateTime])

slots.incident_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.incident_type, name="incident_type", curie=FLUXNOVA_BPM_PLATFORM.curie('incident_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.incident_type, domain=None, range=str)

slots.invocations_per_job = Slot(uri=FLUXNOVA_BPM_PLATFORM.invocations_per_job, name="invocations_per_job", curie=FLUXNOVA_BPM_PLATFORM.curie('invocations_per_job'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.invocations_per_job, domain=None, range=Optional[int])

slots.is_active = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_active, name="is_active", curie=FLUXNOVA_BPM_PLATFORM.curie('is_active'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_active, domain=None, range=Optional[Union[bool, Bool]])

slots.is_concurrent = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_concurrent, name="is_concurrent", curie=FLUXNOVA_BPM_PLATFORM.curie('is_concurrent'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_concurrent, domain=None, range=Optional[Union[bool, Bool]])

slots.is_concurrent_local = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_concurrent_local, name="is_concurrent_local", curie=FLUXNOVA_BPM_PLATFORM.curie('is_concurrent_local'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_concurrent_local, domain=None, range=Optional[Union[bool, Bool]])

slots.is_event_scope = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_event_scope, name="is_event_scope", curie=FLUXNOVA_BPM_PLATFORM.curie('is_event_scope'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_event_scope, domain=None, range=Optional[Union[bool, Bool]])

slots.is_exclusive = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_exclusive, name="is_exclusive", curie=FLUXNOVA_BPM_PLATFORM.curie('is_exclusive'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_exclusive, domain=None, range=Optional[Union[bool, Bool]])

slots.is_generated = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_generated, name="is_generated", curie=FLUXNOVA_BPM_PLATFORM.curie('is_generated'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_generated, domain=None, range=Optional[Union[bool, Bool]])

slots.is_initial = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_initial, name="is_initial", curie=FLUXNOVA_BPM_PLATFORM.curie('is_initial'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_initial, domain=None, range=Optional[Union[bool, Bool]])

slots.is_required = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_required, name="is_required", curie=FLUXNOVA_BPM_PLATFORM.curie('is_required'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_required, domain=None, range=Optional[Union[bool, Bool]])

slots.is_satisfied = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_satisfied, name="is_satisfied", curie=FLUXNOVA_BPM_PLATFORM.curie('is_satisfied'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_satisfied, domain=None, range=Optional[Union[bool, Bool]])

slots.is_scope = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_scope, name="is_scope", curie=FLUXNOVA_BPM_PLATFORM.curie('is_scope'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_scope, domain=None, range=Optional[Union[bool, Bool]])

slots.is_startable = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_startable, name="is_startable", curie=FLUXNOVA_BPM_PLATFORM.curie('is_startable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.is_startable, domain=None, range=Union[bool, Bool])

slots.job_configuration = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_configuration, name="job_configuration", curie=FLUXNOVA_BPM_PLATFORM.curie('job_configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_configuration, domain=None, range=Optional[str])

slots.job_definition_configuration = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definition_configuration, name="job_definition_configuration", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definition_configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_definition_configuration, domain=None, range=Optional[str])

slots.job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definition_id, name="job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_definition_id, domain=None, range=Optional[str])

slots.job_definition_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definition_type, name="job_definition_type", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definition_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_definition_type, domain=None, range=Optional[str])

slots.job_due_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_due_date, name="job_due_date", curie=FLUXNOVA_BPM_PLATFORM.curie('job_due_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_due_date, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.job_exception_message = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_exception_message, name="job_exception_message", curie=FLUXNOVA_BPM_PLATFORM.curie('job_exception_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_exception_message, domain=None, range=Optional[str])

slots.job_exception_stack_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_exception_stack_id, name="job_exception_stack_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_exception_stack_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_exception_stack_id, domain=None, range=Optional[str])

slots.job_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_id, name="job_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_id, domain=None, range=Optional[str])

slots.job_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_priority, name="job_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('job_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_priority, domain=None, range=Optional[int])

slots.job_retries = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_retries, name="job_retries", curie=FLUXNOVA_BPM_PLATFORM.curie('job_retries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_retries, domain=None, range=Optional[int])

slots.job_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_state, name="job_state", curie=FLUXNOVA_BPM_PLATFORM.curie('job_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_state, domain=None, range=Optional[int])

slots.job_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_type, name="job_type", curie=FLUXNOVA_BPM_PLATFORM.curie('job_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.job_type, domain=None, range=str)

slots.jobs_created = Slot(uri=FLUXNOVA_BPM_PLATFORM.jobs_created, name="jobs_created", curie=FLUXNOVA_BPM_PLATFORM.curie('jobs_created'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.jobs_created, domain=None, range=Optional[int])

slots.jobs_per_seed = Slot(uri=FLUXNOVA_BPM_PLATFORM.jobs_per_seed, name="jobs_per_seed", curie=FLUXNOVA_BPM_PLATFORM.curie('jobs_per_seed'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.jobs_per_seed, domain=None, range=Optional[int])

slots.key = Slot(uri=FLUXNOVA_BPM_PLATFORM.key, name="key", curie=FLUXNOVA_BPM_PLATFORM.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.key, domain=None, range=Optional[str])

slots.last_failure_log_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.last_failure_log_id, name="last_failure_log_id", curie=FLUXNOVA_BPM_PLATFORM.curie('last_failure_log_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.last_failure_log_id, domain=None, range=Optional[str])

slots.last_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.last_name, name="last_name", curie=FLUXNOVA_BPM_PLATFORM.curie('last_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.last_name, domain=None, range=Optional[str])

slots.last_updated = Slot(uri=FLUXNOVA_BPM_PLATFORM.last_updated, name="last_updated", curie=FLUXNOVA_BPM_PLATFORM.curie('last_updated'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.last_updated, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.lock_expiration_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.lock_expiration_time, name="lock_expiration_time", curie=FLUXNOVA_BPM_PLATFORM.curie('lock_expiration_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.lock_expiration_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.lock_owner = Slot(uri=FLUXNOVA_BPM_PLATFORM.lock_owner, name="lock_owner", curie=FLUXNOVA_BPM_PLATFORM.curie('lock_owner'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.lock_owner, domain=None, range=Optional[str])

slots.long_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.long_value, name="long_value", curie=FLUXNOVA_BPM_PLATFORM.curie('long_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.long_value, domain=None, range=Optional[int])

slots.message = Slot(uri=FLUXNOVA_BPM_PLATFORM.message, name="message", curie=FLUXNOVA_BPM_PLATFORM.curie('message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.message, domain=None, range=Optional[str])

slots.milliseconds = Slot(uri=FLUXNOVA_BPM_PLATFORM.milliseconds, name="milliseconds", curie=FLUXNOVA_BPM_PLATFORM.curie('milliseconds'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.milliseconds, domain=None, range=Optional[int])

slots.monitor_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.monitor_job_definition_id, name="monitor_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('monitor_job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.monitor_job_definition_id, domain=None, range=Optional[str])

slots.name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.name, domain=None, range=Optional[str])

slots.new_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.new_value, name="new_value", curie=FLUXNOVA_BPM_PLATFORM.curie('new_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.new_value, domain=None, range=Optional[str])

slots.operation_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_id, name="operation_id", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.operation_id, domain=None, range=Optional[str])

slots.operation_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_type, name="operation_type", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.operation_type, domain=None, range=Optional[str])

slots.original_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.original_value, name="original_value", curie=FLUXNOVA_BPM_PLATFORM.curie('original_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.original_value, domain=None, range=Optional[str])

slots.owner = Slot(uri=FLUXNOVA_BPM_PLATFORM.owner, name="owner", curie=FLUXNOVA_BPM_PLATFORM.curie('owner'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.owner, domain=None, range=Optional[str])

slots.parent_activity_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.parent_activity_instance_id, name="parent_activity_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('parent_activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.parent_activity_instance_id, domain=None, range=Optional[str])

slots.parent_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.parent_id, name="parent_id", curie=FLUXNOVA_BPM_PLATFORM.curie('parent_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.parent_id, domain=None, range=Optional[str])

slots.parent_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.parent_task_id, name="parent_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('parent_task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.parent_task_id, domain=None, range=Optional[str])

slots.password = Slot(uri=FLUXNOVA_BPM_PLATFORM.password, name="password", curie=FLUXNOVA_BPM_PLATFORM.curie('password'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.password, domain=None, range=Optional[str])

slots.permissions = Slot(uri=FLUXNOVA_BPM_PLATFORM.permissions, name="permissions", curie=FLUXNOVA_BPM_PLATFORM.curie('permissions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.permissions, domain=None, range=Optional[int])

slots.picture_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.picture_id, name="picture_id", curie=FLUXNOVA_BPM_PLATFORM.curie('picture_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.picture_id, domain=None, range=Optional[str])

slots.previous_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.previous_state, name="previous_state", curie=FLUXNOVA_BPM_PLATFORM.curie('previous_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.previous_state, domain=None, range=Optional[int])

slots.priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.priority, name="priority", curie=FLUXNOVA_BPM_PLATFORM.curie('priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.priority, domain=None, range=Optional[int])

slots.process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, domain=None, range=Optional[str])

slots.process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, domain=None, range=Optional[str])

slots.process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, domain=None, range=Optional[str])

slots.properties = Slot(uri=FLUXNOVA_BPM_PLATFORM.properties, name="properties", curie=FLUXNOVA_BPM_PLATFORM.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.properties, domain=None, range=Optional[str])

slots.property = Slot(uri=FLUXNOVA_BPM_PLATFORM.property, name="property", curie=FLUXNOVA_BPM_PLATFORM.curie('property'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.property, domain=None, range=Optional[str])

slots.query = Slot(uri=FLUXNOVA_BPM_PLATFORM.query, name="query", curie=FLUXNOVA_BPM_PLATFORM.curie('query'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.query, domain=None, range=str)

slots.removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.removal_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.repeat = Slot(uri=FLUXNOVA_BPM_PLATFORM.repeat, name="repeat", curie=FLUXNOVA_BPM_PLATFORM.curie('repeat'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.repeat, domain=None, range=Optional[str])

slots.repeat_offset = Slot(uri=FLUXNOVA_BPM_PLATFORM.repeat_offset, name="repeat_offset", curie=FLUXNOVA_BPM_PLATFORM.curie('repeat_offset'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.repeat_offset, domain=None, range=Optional[int])

slots.reporter = Slot(uri=FLUXNOVA_BPM_PLATFORM.reporter, name="reporter", curie=FLUXNOVA_BPM_PLATFORM.curie('reporter'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.reporter, domain=None, range=Optional[str])

slots.resource_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_id, name="resource_id", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_id, domain=None, range=Optional[str])

slots.resource_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_name, name="resource_name", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_name, domain=None, range=Optional[str])

slots.resource_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_type, name="resource_type", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.resource_type, domain=None, range=int)

slots.restarted_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.restarted_process_instance_id, name="restarted_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('restarted_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.restarted_process_instance_id, domain=None, range=Optional[str])

slots.restricted = Slot(uri=FLUXNOVA_BPM_PLATFORM.restricted, name="restricted", curie=FLUXNOVA_BPM_PLATFORM.curie('restricted'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.restricted, domain=None, range=Optional[Union[bool, Bool]])

slots.retries = Slot(uri=FLUXNOVA_BPM_PLATFORM.retries, name="retries", curie=FLUXNOVA_BPM_PLATFORM.curie('retries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.retries, domain=None, range=Optional[int])

slots.root_cause_incident_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_cause_incident_id, name="root_cause_incident_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_cause_incident_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.root_cause_incident_id, domain=None, range=Optional[str])

slots.root_decision_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_decision_instance_id, name="root_decision_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_decision_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.root_decision_instance_id, domain=None, range=Optional[str])

slots.root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, domain=None, range=Optional[str])

slots.rule_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.rule_id, name="rule_id", curie=FLUXNOVA_BPM_PLATFORM.curie('rule_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.rule_id, domain=None, range=Optional[str])

slots.rule_order = Slot(uri=FLUXNOVA_BPM_PLATFORM.rule_order, name="rule_order", curie=FLUXNOVA_BPM_PLATFORM.curie('rule_order'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.rule_order, domain=None, range=Optional[int])

slots.salt = Slot(uri=FLUXNOVA_BPM_PLATFORM.salt, name="salt", curie=FLUXNOVA_BPM_PLATFORM.curie('salt'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.salt, domain=None, range=Optional[str])

slots.seed_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.seed_job_definition_id, name="seed_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('seed_job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.seed_job_definition_id, domain=None, range=Optional[str])

slots.sentry_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.sentry_id, name="sentry_id", curie=FLUXNOVA_BPM_PLATFORM.curie('sentry_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.sentry_id, domain=None, range=Optional[str])

slots.sequence_counter = Slot(uri=FLUXNOVA_BPM_PLATFORM.sequence_counter, name="sequence_counter", curie=FLUXNOVA_BPM_PLATFORM.curie('sequence_counter'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.sequence_counter, domain=None, range=Optional[int])

slots.source = Slot(uri=FLUXNOVA_BPM_PLATFORM.source, name="source", curie=FLUXNOVA_BPM_PLATFORM.curie('source'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.source, domain=None, range=Optional[str])

slots.source_case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.source_case_execution_id, name="source_case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('source_case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.source_case_execution_id, domain=None, range=Optional[str])

slots.standard_event = Slot(uri=FLUXNOVA_BPM_PLATFORM.standard_event, name="standard_event", curie=FLUXNOVA_BPM_PLATFORM.curie('standard_event'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.standard_event, domain=None, range=Optional[str])

slots.start_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.start_activity_id, name="start_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('start_activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.start_activity_id, domain=None, range=Optional[str])

slots.start_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.start_time, name="start_time", curie=FLUXNOVA_BPM_PLATFORM.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.start_time, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.start_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.start_user_id, name="start_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('start_user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.start_user_id, domain=None, range=Optional[str])

slots.state = Slot(uri=FLUXNOVA_BPM_PLATFORM.state, name="state", curie=FLUXNOVA_BPM_PLATFORM.curie('state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.state, domain=None, range=Optional[int])

slots.status = Slot(uri=FLUXNOVA_BPM_PLATFORM.status, name="status", curie=FLUXNOVA_BPM_PLATFORM.curie('status'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.status, domain=None, range=Union[str, "ConfigurationStatus"])

slots.super_case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.super_case_execution_id, name="super_case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('super_case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.super_case_execution_id, domain=None, range=Optional[str])

slots.super_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.super_case_instance_id, name="super_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('super_case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.super_case_instance_id, domain=None, range=Optional[str])

slots.super_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.super_execution_id, name="super_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('super_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.super_execution_id, domain=None, range=Optional[str])

slots.super_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.super_process_instance_id, name="super_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('super_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.super_process_instance_id, domain=None, range=Optional[str])

slots.suspension_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.suspension_state, name="suspension_state", curie=FLUXNOVA_BPM_PLATFORM.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.suspension_state, domain=None, range=Optional[int])

slots.task_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_definition_key, name="task_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('task_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.task_definition_key, domain=None, range=Optional[str])

slots.task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.task_id, domain=None, range=Optional[str])

slots.task_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_state, name="task_state", curie=FLUXNOVA_BPM_PLATFORM.curie('task_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.task_state, domain=None, range=Optional[str])

slots.tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.tenant_id, domain=None, range=Optional[str])

slots.text2_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.text2_value, name="text2_value", curie=FLUXNOVA_BPM_PLATFORM.curie('text2_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.text2_value, domain=None, range=Optional[str])

slots.text_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_value, name="text_value", curie=FLUXNOVA_BPM_PLATFORM.curie('text_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.text_value, domain=None, range=Optional[str])

slots.timestamp = Slot(uri=FLUXNOVA_BPM_PLATFORM.timestamp, name="timestamp", curie=FLUXNOVA_BPM_PLATFORM.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.timestamp, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.topic_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.topic_name, name="topic_name", curie=FLUXNOVA_BPM_PLATFORM.curie('topic_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.topic_name, domain=None, range=Optional[str])

slots.total_jobs = Slot(uri=FLUXNOVA_BPM_PLATFORM.total_jobs, name="total_jobs", curie=FLUXNOVA_BPM_PLATFORM.curie('total_jobs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.total_jobs, domain=None, range=Optional[int])

slots.type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.type, domain=None, range=Optional[str])

slots.updated_at = Slot(uri=FLUXNOVA_BPM_PLATFORM.updated_at, name="updated_at", curie=FLUXNOVA_BPM_PLATFORM.curie('updated_at'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.updated_at, domain=None, range=Optional[Union[str, XSDDateTime]])

slots.updated_by = Slot(uri=FLUXNOVA_BPM_PLATFORM.updated_by, name="updated_by", curie=FLUXNOVA_BPM_PLATFORM.curie('updated_by'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.updated_by, domain=None, range=Optional[str])

slots.url = Slot(uri=FLUXNOVA_BPM_PLATFORM.url, name="url", curie=FLUXNOVA_BPM_PLATFORM.curie('url'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.url, domain=None, range=Optional[str])

slots.user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_id, name="user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.user_id, domain=None, range=Optional[str])

slots.value = Slot(uri=FLUXNOVA_BPM_PLATFORM.value, name="value", curie=FLUXNOVA_BPM_PLATFORM.curie('value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.value, domain=None, range=Optional[str])

slots.variable_event = Slot(uri=FLUXNOVA_BPM_PLATFORM.variable_event, name="variable_event", curie=FLUXNOVA_BPM_PLATFORM.curie('variable_event'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_event, domain=None, range=Optional[str])

slots.variable_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.variable_instance_id, name="variable_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('variable_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_instance_id, domain=None, range=Optional[str])

slots.variable_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.variable_name, name="variable_name", curie=FLUXNOVA_BPM_PLATFORM.curie('variable_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_name, domain=None, range=Optional[str])

slots.variable_scope_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.variable_scope_id, name="variable_scope_id", curie=FLUXNOVA_BPM_PLATFORM.curie('variable_scope_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_scope_id, domain=None, range=str)

slots.variable_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.variable_type, name="variable_type", curie=FLUXNOVA_BPM_PLATFORM.curie('variable_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.variable_type, domain=None, range=Optional[str])

slots.version = Slot(uri=FLUXNOVA_BPM_PLATFORM.version, name="version", curie=FLUXNOVA_BPM_PLATFORM.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.version, domain=None, range=Optional[int])

slots.version_tag = Slot(uri=FLUXNOVA_BPM_PLATFORM.version_tag, name="version_tag", curie=FLUXNOVA_BPM_PLATFORM.curie('version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.version_tag, domain=None, range=Optional[str])

slots.worker_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.worker_id, name="worker_id", curie=FLUXNOVA_BPM_PLATFORM.curie('worker_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.worker_id, domain=None, range=Optional[str])

slots.fluxnovaConnector__connector_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.connector_id, name="fluxnovaConnector__connector_id", curie=FLUXNOVA_BPM_PLATFORM.curie('connector_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaConnector__connector_id, domain=None, range=Union[dict, FluxnovaConnectorId])

slots.fluxnovaConnector__input_output = Slot(uri=FLUXNOVA_BPM_PLATFORM.input_output, name="fluxnovaConnector__input_output", curie=FLUXNOVA_BPM_PLATFORM.curie('input_output'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaConnector__input_output, domain=None, range=Optional[Union[dict, FluxnovaInputOutput]])

slots.fluxnovaConnectorId__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="fluxnovaConnectorId__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaConnectorId__text_content, domain=None, range=Optional[str])

slots.fluxnovaConstraint__fluxnova_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_name, name="fluxnovaConstraint__fluxnova_name", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaConstraint__fluxnova_name, domain=None, range=Optional[str])

slots.fluxnovaConstraint__fluxnova_config = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_config, name="fluxnovaConstraint__fluxnova_config", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_config'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaConstraint__fluxnova_config, domain=None, range=Optional[str])

slots.fluxnovaEntry__fluxnova_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_key, name="fluxnovaEntry__fluxnova_key", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaEntry__fluxnova_key, domain=None, range=str)

slots.fluxnovaEntry__value = Slot(uri=FLUXNOVA_BPM_PLATFORM.value, name="fluxnovaEntry__value", curie=FLUXNOVA_BPM_PLATFORM.curie('value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaEntry__value, domain=None, range=Optional[Union[dict, FluxnovaScript, FluxnovaList, FluxnovaMap]])

slots.fluxnovaEntry__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="fluxnovaEntry__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaEntry__text_content, domain=None, range=Optional[str])

slots.fluxnovaErrorEventDefinition__fluxnova_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, name="fluxnovaErrorEventDefinition__fluxnova_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaErrorEventDefinition__fluxnova_expression, domain=None, range=Optional[str])

slots.fluxnovaExecutionListener__fluxnova_event = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_event, name="fluxnovaExecutionListener__fluxnova_event", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_event'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaExecutionListener__fluxnova_event, domain=None, range=Optional[str])

slots.fluxnovaExecutionListener__fluxnova_class = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_class, name="fluxnovaExecutionListener__fluxnova_class", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaExecutionListener__fluxnova_class, domain=None, range=Optional[str])

slots.fluxnovaExecutionListener__fluxnova_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, name="fluxnovaExecutionListener__fluxnova_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaExecutionListener__fluxnova_expression, domain=None, range=Optional[str])

slots.fluxnovaExecutionListener__fluxnova_delegate_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_delegate_expression, name="fluxnovaExecutionListener__fluxnova_delegate_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_delegate_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaExecutionListener__fluxnova_delegate_expression, domain=None, range=Optional[str])

slots.fluxnovaExecutionListener__bpmn_fields = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_fields, name="fluxnovaExecutionListener__bpmn_fields", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_fields'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaExecutionListener__bpmn_fields, domain=None, range=Optional[Union[Union[dict, FluxnovaField], list[Union[dict, FluxnovaField]]]])

slots.fluxnovaExecutionListener__script = Slot(uri=FLUXNOVA_BPM_PLATFORM.script, name="fluxnovaExecutionListener__script", curie=FLUXNOVA_BPM_PLATFORM.curie('script'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaExecutionListener__script, domain=None, range=Optional[Union[dict, FluxnovaScript]])

slots.fluxnovaExpression__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="fluxnovaExpression__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaExpression__text_content, domain=None, range=Optional[str])

slots.fluxnovaFailedJobRetryTimeCycle__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="fluxnovaFailedJobRetryTimeCycle__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFailedJobRetryTimeCycle__text_content, domain=None, range=Optional[str])

slots.fluxnovaField__fluxnova_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_name, name="fluxnovaField__fluxnova_name", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaField__fluxnova_name, domain=None, range=Optional[str])

slots.fluxnovaField__fluxnova_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, name="fluxnovaField__fluxnova_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaField__fluxnova_expression, domain=None, range=Optional[str])

slots.fluxnovaField__fluxnova_string_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_string_value, name="fluxnovaField__fluxnova_string_value", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_string_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaField__fluxnova_string_value, domain=None, range=Optional[str])

slots.fluxnovaField__expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.expression, name="fluxnovaField__expression", curie=FLUXNOVA_BPM_PLATFORM.curie('expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaField__expression, domain=None, range=Optional[Union[dict, FluxnovaExpression]])

slots.fluxnovaField__string = Slot(uri=FLUXNOVA_BPM_PLATFORM.string, name="fluxnovaField__string", curie=FLUXNOVA_BPM_PLATFORM.curie('string'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaField__string, domain=None, range=Optional[Union[dict, FluxnovaString]])

slots.fluxnovaFormData__form_fields = Slot(uri=FLUXNOVA_BPM_PLATFORM.form_fields, name="fluxnovaFormData__form_fields", curie=FLUXNOVA_BPM_PLATFORM.curie('form_fields'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormData__form_fields, domain=None, range=Optional[Union[Union[dict, FluxnovaFormField], list[Union[dict, FluxnovaFormField]]]])

slots.fluxnovaFormField__fluxnova_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_id, name="fluxnovaFormField__fluxnova_id", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormField__fluxnova_id, domain=None, range=Optional[str])

slots.fluxnovaFormField__fluxnova_label = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_label, name="fluxnovaFormField__fluxnova_label", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_label'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormField__fluxnova_label, domain=None, range=Optional[str])

slots.fluxnovaFormField__fluxnova_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_type, name="fluxnovaFormField__fluxnova_type", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormField__fluxnova_type, domain=None, range=Optional[str])

slots.fluxnovaFormField__fluxnova_date_pattern = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_date_pattern, name="fluxnovaFormField__fluxnova_date_pattern", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_date_pattern'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormField__fluxnova_date_pattern, domain=None, range=Optional[str])

slots.fluxnovaFormField__fluxnova_default_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_default_value, name="fluxnovaFormField__fluxnova_default_value", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_default_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormField__fluxnova_default_value, domain=None, range=Optional[str])

slots.fluxnovaFormField__properties = Slot(uri=FLUXNOVA_BPM_PLATFORM.properties, name="fluxnovaFormField__properties", curie=FLUXNOVA_BPM_PLATFORM.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormField__properties, domain=None, range=Optional[Union[dict, FluxnovaProperties]])

slots.fluxnovaFormField__validation = Slot(uri=FLUXNOVA_BPM_PLATFORM.validation, name="fluxnovaFormField__validation", curie=FLUXNOVA_BPM_PLATFORM.curie('validation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormField__validation, domain=None, range=Optional[Union[dict, FluxnovaValidation]])

slots.fluxnovaFormField__values = Slot(uri=FLUXNOVA_BPM_PLATFORM.values, name="fluxnovaFormField__values", curie=FLUXNOVA_BPM_PLATFORM.curie('values'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormField__values, domain=None, range=Optional[Union[Union[dict, FluxnovaValue], list[Union[dict, FluxnovaValue]]]])

slots.fluxnovaFormProperty__fluxnova_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_id, name="fluxnovaFormProperty__fluxnova_id", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_id, domain=None, range=Optional[str])

slots.fluxnovaFormProperty__fluxnova_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_name, name="fluxnovaFormProperty__fluxnova_name", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_name, domain=None, range=Optional[str])

slots.fluxnovaFormProperty__fluxnova_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_type, name="fluxnovaFormProperty__fluxnova_type", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_type, domain=None, range=Optional[str])

slots.fluxnovaFormProperty__fluxnova_required = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_required, name="fluxnovaFormProperty__fluxnova_required", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_required'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_required, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaFormProperty__fluxnova_readable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_readable, name="fluxnovaFormProperty__fluxnova_readable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_readable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_readable, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaFormProperty__fluxnova_writeable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_writeable, name="fluxnovaFormProperty__fluxnova_writeable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_writeable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_writeable, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaFormProperty__fluxnova_variable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable, name="fluxnovaFormProperty__fluxnova_variable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_variable, domain=None, range=Optional[str])

slots.fluxnovaFormProperty__fluxnova_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, name="fluxnovaFormProperty__fluxnova_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_expression, domain=None, range=Optional[str])

slots.fluxnovaFormProperty__fluxnova_date_pattern = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_date_pattern, name="fluxnovaFormProperty__fluxnova_date_pattern", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_date_pattern'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_date_pattern, domain=None, range=Optional[str])

slots.fluxnovaFormProperty__fluxnova_default = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_default, name="fluxnovaFormProperty__fluxnova_default", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_default'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__fluxnova_default, domain=None, range=Optional[str])

slots.fluxnovaFormProperty__values = Slot(uri=FLUXNOVA_BPM_PLATFORM.values, name="fluxnovaFormProperty__values", curie=FLUXNOVA_BPM_PLATFORM.curie('values'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaFormProperty__values, domain=None, range=Optional[Union[Union[dict, FluxnovaValue], list[Union[dict, FluxnovaValue]]]])

slots.fluxnovaIn__fluxnova_source = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_source, name="fluxnovaIn__fluxnova_source", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_source'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaIn__fluxnova_source, domain=None, range=Optional[str])

slots.fluxnovaIn__fluxnova_source_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_source_expression, name="fluxnovaIn__fluxnova_source_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_source_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaIn__fluxnova_source_expression, domain=None, range=Optional[str])

slots.fluxnovaIn__fluxnova_variables = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variables, name="fluxnovaIn__fluxnova_variables", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_variables'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaIn__fluxnova_variables, domain=None, range=Optional[str])

slots.fluxnovaIn__fluxnova_target = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_target, name="fluxnovaIn__fluxnova_target", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaIn__fluxnova_target, domain=None, range=Optional[str])

slots.fluxnovaIn__fluxnova_business_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_business_key, name="fluxnovaIn__fluxnova_business_key", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_business_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaIn__fluxnova_business_key, domain=None, range=Optional[str])

slots.fluxnovaIn__fluxnova_local = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_local, name="fluxnovaIn__fluxnova_local", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_local'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaIn__fluxnova_local, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaIn__fluxnova_restricted = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_restricted, name="fluxnovaIn__fluxnova_restricted", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_restricted'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaIn__fluxnova_restricted, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaInputOutput__input_parameters = Slot(uri=FLUXNOVA_BPM_PLATFORM.input_parameters, name="fluxnovaInputOutput__input_parameters", curie=FLUXNOVA_BPM_PLATFORM.curie('input_parameters'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaInputOutput__input_parameters, domain=None, range=Optional[Union[Union[dict, FluxnovaInputParameter], list[Union[dict, FluxnovaInputParameter]]]])

slots.fluxnovaInputOutput__output_parameters = Slot(uri=FLUXNOVA_BPM_PLATFORM.output_parameters, name="fluxnovaInputOutput__output_parameters", curie=FLUXNOVA_BPM_PLATFORM.curie('output_parameters'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaInputOutput__output_parameters, domain=None, range=Optional[Union[Union[dict, FluxnovaOutputParameter], list[Union[dict, FluxnovaOutputParameter]]]])

slots.fluxnovaInputParameter__fluxnova_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_name, name="fluxnovaInputParameter__fluxnova_name", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaInputParameter__fluxnova_name, domain=None, range=str)

slots.fluxnovaInputParameter__fluxnova_restricted = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_restricted, name="fluxnovaInputParameter__fluxnova_restricted", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_restricted'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaInputParameter__fluxnova_restricted, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaInputParameter__fluxnova_is_transient = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_is_transient, name="fluxnovaInputParameter__fluxnova_is_transient", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_is_transient'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaInputParameter__fluxnova_is_transient, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaInputParameter__value = Slot(uri=FLUXNOVA_BPM_PLATFORM.value, name="fluxnovaInputParameter__value", curie=FLUXNOVA_BPM_PLATFORM.curie('value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaInputParameter__value, domain=None, range=Optional[Union[dict, FluxnovaScript, FluxnovaList, FluxnovaMap]])

slots.fluxnovaInputParameter__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="fluxnovaInputParameter__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaInputParameter__text_content, domain=None, range=Optional[str])

slots.fluxnovaList__values = Slot(uri=FLUXNOVA_BPM_PLATFORM.values, name="fluxnovaList__values", curie=FLUXNOVA_BPM_PLATFORM.curie('values'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaList__values, domain=None, range=Optional[Union[Union[dict, BpmnModelElementInstance], list[Union[dict, BpmnModelElementInstance]]]])

slots.fluxnovaMap__entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.entries, name="fluxnovaMap__entries", curie=FLUXNOVA_BPM_PLATFORM.curie('entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaMap__entries, domain=None, range=Optional[Union[Union[dict, FluxnovaEntry], list[Union[dict, FluxnovaEntry]]]])

slots.fluxnovaOut__fluxnova_source = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_source, name="fluxnovaOut__fluxnova_source", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_source'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOut__fluxnova_source, domain=None, range=Optional[str])

slots.fluxnovaOut__fluxnova_source_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_source_expression, name="fluxnovaOut__fluxnova_source_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_source_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOut__fluxnova_source_expression, domain=None, range=Optional[str])

slots.fluxnovaOut__fluxnova_variables = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variables, name="fluxnovaOut__fluxnova_variables", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_variables'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOut__fluxnova_variables, domain=None, range=Optional[str])

slots.fluxnovaOut__fluxnova_target = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_target, name="fluxnovaOut__fluxnova_target", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOut__fluxnova_target, domain=None, range=Optional[str])

slots.fluxnovaOut__fluxnova_local = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_local, name="fluxnovaOut__fluxnova_local", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_local'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOut__fluxnova_local, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaOut__fluxnova_restricted = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_restricted, name="fluxnovaOut__fluxnova_restricted", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_restricted'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOut__fluxnova_restricted, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaOutputParameter__fluxnova_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_name, name="fluxnovaOutputParameter__fluxnova_name", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOutputParameter__fluxnova_name, domain=None, range=str)

slots.fluxnovaOutputParameter__fluxnova_restricted = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_restricted, name="fluxnovaOutputParameter__fluxnova_restricted", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_restricted'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOutputParameter__fluxnova_restricted, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaOutputParameter__fluxnova_is_transient = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_is_transient, name="fluxnovaOutputParameter__fluxnova_is_transient", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_is_transient'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOutputParameter__fluxnova_is_transient, domain=None, range=Optional[Union[bool, Bool]])

slots.fluxnovaOutputParameter__value = Slot(uri=FLUXNOVA_BPM_PLATFORM.value, name="fluxnovaOutputParameter__value", curie=FLUXNOVA_BPM_PLATFORM.curie('value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOutputParameter__value, domain=None, range=Optional[Union[dict, FluxnovaScript, FluxnovaList, FluxnovaMap]])

slots.fluxnovaOutputParameter__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="fluxnovaOutputParameter__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaOutputParameter__text_content, domain=None, range=Optional[str])

slots.fluxnovaPotentialStarter__resource_assignment_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_assignment_expression, name="fluxnovaPotentialStarter__resource_assignment_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_assignment_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaPotentialStarter__resource_assignment_expression, domain=None, range=Optional[Union[dict, BpmnResourceAssignmentExpression]])

slots.fluxnovaProperties__properties = Slot(uri=FLUXNOVA_BPM_PLATFORM.properties, name="fluxnovaProperties__properties", curie=FLUXNOVA_BPM_PLATFORM.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaProperties__properties, domain=None, range=Optional[Union[Union[dict, FluxnovaProperty], list[Union[dict, FluxnovaProperty]]]])

slots.fluxnovaProperty__fluxnova_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_id, name="fluxnovaProperty__fluxnova_id", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaProperty__fluxnova_id, domain=None, range=Optional[str])

slots.fluxnovaProperty__fluxnova_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_name, name="fluxnovaProperty__fluxnova_name", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaProperty__fluxnova_name, domain=None, range=Optional[str])

slots.fluxnovaProperty__fluxnova_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_value, name="fluxnovaProperty__fluxnova_value", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaProperty__fluxnova_value, domain=None, range=Optional[str])

slots.fluxnovaScript__script_format = Slot(uri=FLUXNOVA_BPM_PLATFORM.script_format, name="fluxnovaScript__script_format", curie=FLUXNOVA_BPM_PLATFORM.curie('script_format'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaScript__script_format, domain=None, range=str)

slots.fluxnovaScript__bpmn_resource = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_resource, name="fluxnovaScript__bpmn_resource", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_resource'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaScript__bpmn_resource, domain=None, range=Optional[str])

slots.fluxnovaScript__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="fluxnovaScript__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaScript__text_content, domain=None, range=Optional[str])

slots.fluxnovaString__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="fluxnovaString__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaString__text_content, domain=None, range=Optional[str])

slots.fluxnovaTaskListener__fluxnova_event = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_event, name="fluxnovaTaskListener__fluxnova_event", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_event'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaTaskListener__fluxnova_event, domain=None, range=Optional[str])

slots.fluxnovaTaskListener__fluxnova_class = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_class, name="fluxnovaTaskListener__fluxnova_class", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaTaskListener__fluxnova_class, domain=None, range=Optional[str])

slots.fluxnovaTaskListener__fluxnova_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, name="fluxnovaTaskListener__fluxnova_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaTaskListener__fluxnova_expression, domain=None, range=Optional[str])

slots.fluxnovaTaskListener__fluxnova_delegate_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_delegate_expression, name="fluxnovaTaskListener__fluxnova_delegate_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_delegate_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaTaskListener__fluxnova_delegate_expression, domain=None, range=Optional[str])

slots.fluxnovaTaskListener__bpmn_fields = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_fields, name="fluxnovaTaskListener__bpmn_fields", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_fields'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaTaskListener__bpmn_fields, domain=None, range=Optional[Union[Union[dict, FluxnovaField], list[Union[dict, FluxnovaField]]]])

slots.fluxnovaTaskListener__script = Slot(uri=FLUXNOVA_BPM_PLATFORM.script, name="fluxnovaTaskListener__script", curie=FLUXNOVA_BPM_PLATFORM.curie('script'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaTaskListener__script, domain=None, range=Optional[Union[dict, FluxnovaScript]])

slots.fluxnovaTaskListener__timer_event_definition = Slot(uri=FLUXNOVA_BPM_PLATFORM.timer_event_definition, name="fluxnovaTaskListener__timer_event_definition", curie=FLUXNOVA_BPM_PLATFORM.curie('timer_event_definition'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaTaskListener__timer_event_definition, domain=None, range=Optional[Union[dict, BpmnTimerEventDefinition]])

slots.fluxnovaValidation__bpmn_constraints = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_constraints, name="fluxnovaValidation__bpmn_constraints", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_constraints'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaValidation__bpmn_constraints, domain=None, range=Optional[Union[Union[dict, FluxnovaConstraint], list[Union[dict, FluxnovaConstraint]]]])

slots.fluxnovaValue__fluxnova_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_id, name="fluxnovaValue__fluxnova_id", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaValue__fluxnova_id, domain=None, range=Optional[str])

slots.fluxnovaValue__fluxnova_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_name, name="fluxnovaValue__fluxnova_name", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaValue__fluxnova_name, domain=None, range=Optional[str])

slots.fluxnovaValue__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="fluxnovaValue__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.fluxnovaValue__text_content, domain=None, range=Optional[str])

slots.bpmnActivity__is_for_compensation = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_for_compensation, name="bpmnActivity__is_for_compensation", curie=FLUXNOVA_BPM_PLATFORM.curie('is_for_compensation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__is_for_compensation, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnActivity__start_quantity = Slot(uri=FLUXNOVA_BPM_PLATFORM.start_quantity, name="bpmnActivity__start_quantity", curie=FLUXNOVA_BPM_PLATFORM.curie('start_quantity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__start_quantity, domain=None, range=Optional[int])

slots.bpmnActivity__completion_quantity = Slot(uri=FLUXNOVA_BPM_PLATFORM.completion_quantity, name="bpmnActivity__completion_quantity", curie=FLUXNOVA_BPM_PLATFORM.curie('completion_quantity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__completion_quantity, domain=None, range=Optional[int])

slots.bpmnActivity__default = Slot(uri=FLUXNOVA_BPM_PLATFORM.default, name="bpmnActivity__default", curie=FLUXNOVA_BPM_PLATFORM.curie('default'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__default, domain=None, range=Optional[str])

slots.bpmnActivity__io_specification = Slot(uri=FLUXNOVA_BPM_PLATFORM.io_specification, name="bpmnActivity__io_specification", curie=FLUXNOVA_BPM_PLATFORM.curie('io_specification'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__io_specification, domain=None, range=Optional[Union[dict, BpmnIoSpecification]])

slots.bpmnActivity__properties = Slot(uri=FLUXNOVA_BPM_PLATFORM.properties, name="bpmnActivity__properties", curie=FLUXNOVA_BPM_PLATFORM.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__properties, domain=None, range=Optional[Union[Union[dict, BpmnProperty], list[Union[dict, BpmnProperty]]]])

slots.bpmnActivity__data_input_associations = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_input_associations, name="bpmnActivity__data_input_associations", curie=FLUXNOVA_BPM_PLATFORM.curie('data_input_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__data_input_associations, domain=None, range=Optional[Union[Union[dict, BpmnDataInputAssociation], list[Union[dict, BpmnDataInputAssociation]]]])

slots.bpmnActivity__data_output_associations = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_output_associations, name="bpmnActivity__data_output_associations", curie=FLUXNOVA_BPM_PLATFORM.curie('data_output_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__data_output_associations, domain=None, range=Optional[Union[Union[dict, BpmnDataOutputAssociation], list[Union[dict, BpmnDataOutputAssociation]]]])

slots.bpmnActivity__resource_roles = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_roles, name="bpmnActivity__resource_roles", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_roles'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__resource_roles, domain=None, range=Optional[Union[Union[dict, BpmnResourceRole], list[Union[dict, BpmnResourceRole]]]])

slots.bpmnActivity__loop_characteristics = Slot(uri=FLUXNOVA_BPM_PLATFORM.loop_characteristics, name="bpmnActivity__loop_characteristics", curie=FLUXNOVA_BPM_PLATFORM.curie('loop_characteristics'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnActivity__loop_characteristics, domain=None, range=Optional[Union[dict, BpmnLoopCharacteristics]])

slots.bpmnAdHocSubProcess__ordering = Slot(uri=FLUXNOVA_BPM_PLATFORM.ordering, name="bpmnAdHocSubProcess__ordering", curie=FLUXNOVA_BPM_PLATFORM.curie('ordering'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnAdHocSubProcess__ordering, domain=None, range=Optional[str])

slots.bpmnAdHocSubProcess__cancel_remaining_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.cancel_remaining_instances, name="bpmnAdHocSubProcess__cancel_remaining_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('cancel_remaining_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnAdHocSubProcess__cancel_remaining_instances, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnAdHocSubProcess__completion_condition = Slot(uri=FLUXNOVA_BPM_PLATFORM.completion_condition, name="bpmnAdHocSubProcess__completion_condition", curie=FLUXNOVA_BPM_PLATFORM.curie('completion_condition'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnAdHocSubProcess__completion_condition, domain=None, range=Optional[Union[dict, BpmnCompletionCondition]])

slots.bpmnAssignment__from_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.from_expression, name="bpmnAssignment__from_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('from_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnAssignment__from_expression, domain=None, range=Union[dict, BpmnFrom])

slots.bpmnAssignment__to_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.to_expression, name="bpmnAssignment__to_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('to_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnAssignment__to_expression, domain=None, range=Union[dict, BpmnTo])

slots.bpmnAssociation__source_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.source_ref, name="bpmnAssociation__source_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('source_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnAssociation__source_ref, domain=None, range=str)

slots.bpmnAssociation__target_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.target_ref, name="bpmnAssociation__target_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('target_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnAssociation__target_ref, domain=None, range=str)

slots.bpmnAssociation__association_direction = Slot(uri=FLUXNOVA_BPM_PLATFORM.association_direction, name="bpmnAssociation__association_direction", curie=FLUXNOVA_BPM_PLATFORM.curie('association_direction'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnAssociation__association_direction, domain=None, range=Optional[Union[str, "BpmnAssociationDirection"]])

slots.bpmnBaseElement__bpmn_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_id, name="bpmnBaseElement__bpmn_id", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBaseElement__bpmn_id, domain=None, range=Optional[str])

slots.bpmnBaseElement__bpmn_documentation = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_documentation, name="bpmnBaseElement__bpmn_documentation", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_documentation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBaseElement__bpmn_documentation, domain=None, range=Optional[Union[Union[dict, BpmnDocumentation], list[Union[dict, BpmnDocumentation]]]])

slots.bpmnBaseElement__extension_elements = Slot(uri=FLUXNOVA_BPM_PLATFORM.extension_elements, name="bpmnBaseElement__extension_elements", curie=FLUXNOVA_BPM_PLATFORM.curie('extension_elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBaseElement__extension_elements, domain=None, range=Optional[Union[dict, BpmnExtensionElements]])

slots.bpmnBoundaryEvent__cancel_activity = Slot(uri=FLUXNOVA_BPM_PLATFORM.cancel_activity, name="bpmnBoundaryEvent__cancel_activity", curie=FLUXNOVA_BPM_PLATFORM.curie('cancel_activity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBoundaryEvent__cancel_activity, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnBoundaryEvent__attached_to_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.attached_to_ref, name="bpmnBoundaryEvent__attached_to_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('attached_to_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBoundaryEvent__attached_to_ref, domain=None, range=str)

slots.bpmnBusinessRuleTask__implementation = Slot(uri=FLUXNOVA_BPM_PLATFORM.implementation, name="bpmnBusinessRuleTask__implementation", curie=FLUXNOVA_BPM_PLATFORM.curie('implementation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__implementation, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_class = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_class, name="bpmnBusinessRuleTask__fluxnova_class", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_class, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_delegate_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_delegate_expression, name="bpmnBusinessRuleTask__fluxnova_delegate_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_delegate_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_delegate_expression, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, name="bpmnBusinessRuleTask__fluxnova_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_expression, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_result_variable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_result_variable, name="bpmnBusinessRuleTask__fluxnova_result_variable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_result_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_result_variable, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_topic = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_topic, name="bpmnBusinessRuleTask__fluxnova_topic", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_topic'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_topic, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_type, name="bpmnBusinessRuleTask__fluxnova_type", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_type, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_decision_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref, name="bpmnBusinessRuleTask__fluxnova_decision_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_decision_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_decision_ref, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_decision_ref_binding = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref_binding, name="bpmnBusinessRuleTask__fluxnova_decision_ref_binding", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_decision_ref_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_decision_ref_binding, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_decision_ref_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref_version, name="bpmnBusinessRuleTask__fluxnova_decision_ref_version", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_decision_ref_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_decision_ref_version, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_decision_ref_version_tag = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref_version_tag, name="bpmnBusinessRuleTask__fluxnova_decision_ref_version_tag", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_decision_ref_version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_decision_ref_version_tag, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_decision_ref_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_decision_ref_tenant_id, name="bpmnBusinessRuleTask__fluxnova_decision_ref_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_decision_ref_tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_decision_ref_tenant_id, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_map_decision_result = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_map_decision_result, name="bpmnBusinessRuleTask__fluxnova_map_decision_result", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_map_decision_result'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_map_decision_result, domain=None, range=Optional[str])

slots.bpmnBusinessRuleTask__fluxnova_task_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_task_priority, name="bpmnBusinessRuleTask__fluxnova_task_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_task_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnBusinessRuleTask__fluxnova_task_priority, domain=None, range=Optional[str])

slots.bpmnCallActivity__called_element = Slot(uri=FLUXNOVA_BPM_PLATFORM.called_element, name="bpmnCallActivity__called_element", curie=FLUXNOVA_BPM_PLATFORM.curie('called_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__called_element, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_async = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async, name="bpmnCallActivity__fluxnova_async", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_async, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnCallActivity__fluxnova_called_element_binding = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_called_element_binding, name="bpmnCallActivity__fluxnova_called_element_binding", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_called_element_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_called_element_binding, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_called_element_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_called_element_version, name="bpmnCallActivity__fluxnova_called_element_version", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_called_element_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_called_element_version, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_called_element_version_tag = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_called_element_version_tag, name="bpmnCallActivity__fluxnova_called_element_version_tag", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_called_element_version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_called_element_version_tag, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_case_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_case_ref, name="bpmnCallActivity__fluxnova_case_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_case_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_case_ref, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_case_binding = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_case_binding, name="bpmnCallActivity__fluxnova_case_binding", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_case_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_case_binding, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_case_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_case_version, name="bpmnCallActivity__fluxnova_case_version", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_case_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_case_version, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_called_element_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_called_element_tenant_id, name="bpmnCallActivity__fluxnova_called_element_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_called_element_tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_called_element_tenant_id, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_case_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_case_tenant_id, name="bpmnCallActivity__fluxnova_case_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_case_tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_case_tenant_id, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_variable_mapping_class = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable_mapping_class, name="bpmnCallActivity__fluxnova_variable_mapping_class", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_variable_mapping_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_variable_mapping_class, domain=None, range=Optional[str])

slots.bpmnCallActivity__fluxnova_variable_mapping_delegate_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable_mapping_delegate_expression, name="bpmnCallActivity__fluxnova_variable_mapping_delegate_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_variable_mapping_delegate_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallActivity__fluxnova_variable_mapping_delegate_expression, domain=None, range=Optional[str])

slots.bpmnCallConversation__called_collaboration_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.called_collaboration_ref, name="bpmnCallConversation__called_collaboration_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('called_collaboration_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallConversation__called_collaboration_ref, domain=None, range=Optional[str])

slots.bpmnCallConversation__participant_associations = Slot(uri=FLUXNOVA_BPM_PLATFORM.participant_associations, name="bpmnCallConversation__participant_associations", curie=FLUXNOVA_BPM_PLATFORM.curie('participant_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallConversation__participant_associations, domain=None, range=Optional[Union[Union[dict, BpmnParticipantAssociation], list[Union[dict, BpmnParticipantAssociation]]]])

slots.bpmnCallableElement__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnCallableElement__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallableElement__name, domain=None, range=Optional[str])

slots.bpmnCallableElement__supported_interface_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.supported_interface_refs, name="bpmnCallableElement__supported_interface_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('supported_interface_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallableElement__supported_interface_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnCallableElement__io_specification = Slot(uri=FLUXNOVA_BPM_PLATFORM.io_specification, name="bpmnCallableElement__io_specification", curie=FLUXNOVA_BPM_PLATFORM.curie('io_specification'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallableElement__io_specification, domain=None, range=Optional[Union[dict, BpmnIoSpecification]])

slots.bpmnCallableElement__io_bindings = Slot(uri=FLUXNOVA_BPM_PLATFORM.io_bindings, name="bpmnCallableElement__io_bindings", curie=FLUXNOVA_BPM_PLATFORM.curie('io_bindings'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCallableElement__io_bindings, domain=None, range=Optional[Union[Union[dict, BpmnIoBinding], list[Union[dict, BpmnIoBinding]]]])

slots.bpmnCatchEvent__parallel_multiple = Slot(uri=FLUXNOVA_BPM_PLATFORM.parallel_multiple, name="bpmnCatchEvent__parallel_multiple", curie=FLUXNOVA_BPM_PLATFORM.curie('parallel_multiple'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCatchEvent__parallel_multiple, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnCatchEvent__data_outputs = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_outputs, name="bpmnCatchEvent__data_outputs", curie=FLUXNOVA_BPM_PLATFORM.curie('data_outputs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCatchEvent__data_outputs, domain=None, range=Optional[Union[Union[dict, BpmnDataOutput], list[Union[dict, BpmnDataOutput]]]])

slots.bpmnCatchEvent__data_output_associations = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_output_associations, name="bpmnCatchEvent__data_output_associations", curie=FLUXNOVA_BPM_PLATFORM.curie('data_output_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCatchEvent__data_output_associations, domain=None, range=Optional[Union[Union[dict, BpmnDataOutputAssociation], list[Union[dict, BpmnDataOutputAssociation]]]])

slots.bpmnCatchEvent__output_set = Slot(uri=FLUXNOVA_BPM_PLATFORM.output_set, name="bpmnCatchEvent__output_set", curie=FLUXNOVA_BPM_PLATFORM.curie('output_set'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCatchEvent__output_set, domain=None, range=Optional[Union[dict, BpmnOutputSet]])

slots.bpmnCatchEvent__event_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_definitions, name="bpmnCatchEvent__event_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('event_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCatchEvent__event_definitions, domain=None, range=Optional[Union[Union[dict, BpmnEventDefinition], list[Union[dict, BpmnEventDefinition]]]])

slots.bpmnCatchEvent__event_definition_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_definition_refs, name="bpmnCatchEvent__event_definition_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('event_definition_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCatchEvent__event_definition_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnCategory__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnCategory__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCategory__name, domain=None, range=str)

slots.bpmnCategory__category_values = Slot(uri=FLUXNOVA_BPM_PLATFORM.category_values, name="bpmnCategory__category_values", curie=FLUXNOVA_BPM_PLATFORM.curie('category_values'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCategory__category_values, domain=None, range=Optional[Union[Union[dict, BpmnCategoryValue], list[Union[dict, BpmnCategoryValue]]]])

slots.bpmnCategoryValue__value = Slot(uri=FLUXNOVA_BPM_PLATFORM.value, name="bpmnCategoryValue__value", curie=FLUXNOVA_BPM_PLATFORM.curie('value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCategoryValue__value, domain=None, range=Optional[str])

slots.bpmnCollaboration__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnCollaboration__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__name, domain=None, range=Optional[str])

slots.bpmnCollaboration__is_closed = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_closed, name="bpmnCollaboration__is_closed", curie=FLUXNOVA_BPM_PLATFORM.curie('is_closed'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__is_closed, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnCollaboration__participants = Slot(uri=FLUXNOVA_BPM_PLATFORM.participants, name="bpmnCollaboration__participants", curie=FLUXNOVA_BPM_PLATFORM.curie('participants'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__participants, domain=None, range=Optional[Union[Union[dict, BpmnParticipant], list[Union[dict, BpmnParticipant]]]])

slots.bpmnCollaboration__message_flows = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_flows, name="bpmnCollaboration__message_flows", curie=FLUXNOVA_BPM_PLATFORM.curie('message_flows'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__message_flows, domain=None, range=Optional[Union[Union[dict, BpmnMessageFlow], list[Union[dict, BpmnMessageFlow]]]])

slots.bpmnCollaboration__artifacts = Slot(uri=FLUXNOVA_BPM_PLATFORM.artifacts, name="bpmnCollaboration__artifacts", curie=FLUXNOVA_BPM_PLATFORM.curie('artifacts'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__artifacts, domain=None, range=Optional[Union[Union[dict, BpmnArtifact], list[Union[dict, BpmnArtifact]]]])

slots.bpmnCollaboration__conversation_nodes = Slot(uri=FLUXNOVA_BPM_PLATFORM.conversation_nodes, name="bpmnCollaboration__conversation_nodes", curie=FLUXNOVA_BPM_PLATFORM.curie('conversation_nodes'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__conversation_nodes, domain=None, range=Optional[Union[Union[dict, BpmnConversationNode], list[Union[dict, BpmnConversationNode]]]])

slots.bpmnCollaboration__conversation_associations = Slot(uri=FLUXNOVA_BPM_PLATFORM.conversation_associations, name="bpmnCollaboration__conversation_associations", curie=FLUXNOVA_BPM_PLATFORM.curie('conversation_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__conversation_associations, domain=None, range=Optional[Union[Union[dict, BpmnConversationAssociation], list[Union[dict, BpmnConversationAssociation]]]])

slots.bpmnCollaboration__participant_associations = Slot(uri=FLUXNOVA_BPM_PLATFORM.participant_associations, name="bpmnCollaboration__participant_associations", curie=FLUXNOVA_BPM_PLATFORM.curie('participant_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__participant_associations, domain=None, range=Optional[Union[Union[dict, BpmnParticipantAssociation], list[Union[dict, BpmnParticipantAssociation]]]])

slots.bpmnCollaboration__message_flow_associations = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_flow_associations, name="bpmnCollaboration__message_flow_associations", curie=FLUXNOVA_BPM_PLATFORM.curie('message_flow_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__message_flow_associations, domain=None, range=Optional[Union[Union[dict, BpmnMessageFlowAssociation], list[Union[dict, BpmnMessageFlowAssociation]]]])

slots.bpmnCollaboration__correlation_keys = Slot(uri=FLUXNOVA_BPM_PLATFORM.correlation_keys, name="bpmnCollaboration__correlation_keys", curie=FLUXNOVA_BPM_PLATFORM.curie('correlation_keys'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__correlation_keys, domain=None, range=Optional[Union[Union[dict, BpmnCorrelationKey], list[Union[dict, BpmnCorrelationKey]]]])

slots.bpmnCollaboration__conversation_links = Slot(uri=FLUXNOVA_BPM_PLATFORM.conversation_links, name="bpmnCollaboration__conversation_links", curie=FLUXNOVA_BPM_PLATFORM.curie('conversation_links'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCollaboration__conversation_links, domain=None, range=Optional[Union[Union[dict, BpmnConversationLink], list[Union[dict, BpmnConversationLink]]]])

slots.bpmnCompensateEventDefinition__wait_for_completion = Slot(uri=FLUXNOVA_BPM_PLATFORM.wait_for_completion, name="bpmnCompensateEventDefinition__wait_for_completion", curie=FLUXNOVA_BPM_PLATFORM.curie('wait_for_completion'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCompensateEventDefinition__wait_for_completion, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnCompensateEventDefinition__activity_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_ref, name="bpmnCompensateEventDefinition__activity_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCompensateEventDefinition__activity_ref, domain=None, range=Optional[str])

slots.bpmnComplexGateway__default = Slot(uri=FLUXNOVA_BPM_PLATFORM.default, name="bpmnComplexGateway__default", curie=FLUXNOVA_BPM_PLATFORM.curie('default'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnComplexGateway__default, domain=None, range=Optional[str])

slots.bpmnComplexGateway__activation_condition = Slot(uri=FLUXNOVA_BPM_PLATFORM.activation_condition, name="bpmnComplexGateway__activation_condition", curie=FLUXNOVA_BPM_PLATFORM.curie('activation_condition'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnComplexGateway__activation_condition, domain=None, range=Optional[Union[dict, BpmnActivationCondition]])

slots.bpmnConditionExpression__xsi_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.xsi_type, name="bpmnConditionExpression__xsi_type", curie=FLUXNOVA_BPM_PLATFORM.curie('xsi_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConditionExpression__xsi_type, domain=None, range=Optional[str])

slots.bpmnConditionExpression__fluxnova_resource = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_resource, name="bpmnConditionExpression__fluxnova_resource", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_resource'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConditionExpression__fluxnova_resource, domain=None, range=Optional[str])

slots.bpmnConditionalEventDefinition__fluxnova_variable_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable_name, name="bpmnConditionalEventDefinition__fluxnova_variable_name", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_variable_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConditionalEventDefinition__fluxnova_variable_name, domain=None, range=Optional[str])

slots.bpmnConditionalEventDefinition__fluxnova_variable_events = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_variable_events, name="bpmnConditionalEventDefinition__fluxnova_variable_events", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_variable_events'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConditionalEventDefinition__fluxnova_variable_events, domain=None, range=Optional[str])

slots.bpmnConditionalEventDefinition__condition = Slot(uri=FLUXNOVA_BPM_PLATFORM.condition, name="bpmnConditionalEventDefinition__condition", curie=FLUXNOVA_BPM_PLATFORM.curie('condition'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConditionalEventDefinition__condition, domain=None, range=Union[dict, BpmnCondition])

slots.bpmnConversationAssociation__inner_conversation_node_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.inner_conversation_node_ref, name="bpmnConversationAssociation__inner_conversation_node_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('inner_conversation_node_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConversationAssociation__inner_conversation_node_ref, domain=None, range=str)

slots.bpmnConversationAssociation__outer_conversation_node_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.outer_conversation_node_ref, name="bpmnConversationAssociation__outer_conversation_node_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('outer_conversation_node_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConversationAssociation__outer_conversation_node_ref, domain=None, range=str)

slots.bpmnConversationLink__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnConversationLink__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConversationLink__name, domain=None, range=Optional[str])

slots.bpmnConversationLink__source_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.source_ref, name="bpmnConversationLink__source_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('source_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConversationLink__source_ref, domain=None, range=str)

slots.bpmnConversationLink__target_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.target_ref, name="bpmnConversationLink__target_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('target_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConversationLink__target_ref, domain=None, range=str)

slots.bpmnConversationNode__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnConversationNode__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConversationNode__name, domain=None, range=Optional[str])

slots.bpmnConversationNode__participant_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.participant_refs, name="bpmnConversationNode__participant_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('participant_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConversationNode__participant_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnConversationNode__message_flow_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_flow_refs, name="bpmnConversationNode__message_flow_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('message_flow_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConversationNode__message_flow_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnConversationNode__correlation_keys = Slot(uri=FLUXNOVA_BPM_PLATFORM.correlation_keys, name="bpmnConversationNode__correlation_keys", curie=FLUXNOVA_BPM_PLATFORM.curie('correlation_keys'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnConversationNode__correlation_keys, domain=None, range=Optional[Union[Union[dict, BpmnCorrelationKey], list[Union[dict, BpmnCorrelationKey]]]])

slots.bpmnCorrelationKey__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnCorrelationKey__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationKey__name, domain=None, range=Optional[str])

slots.bpmnCorrelationKey__correlation_property_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.correlation_property_refs, name="bpmnCorrelationKey__correlation_property_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('correlation_property_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationKey__correlation_property_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnCorrelationProperty__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnCorrelationProperty__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationProperty__name, domain=None, range=Optional[str])

slots.bpmnCorrelationProperty__type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="bpmnCorrelationProperty__type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationProperty__type, domain=None, range=Optional[str])

slots.bpmnCorrelationProperty__correlation_property_retrieval_expressions = Slot(uri=FLUXNOVA_BPM_PLATFORM.correlation_property_retrieval_expressions, name="bpmnCorrelationProperty__correlation_property_retrieval_expressions", curie=FLUXNOVA_BPM_PLATFORM.curie('correlation_property_retrieval_expressions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationProperty__correlation_property_retrieval_expressions, domain=None, range=Union[Union[dict, BpmnCorrelationPropertyRetrievalExpression], list[Union[dict, BpmnCorrelationPropertyRetrievalExpression]]])

slots.bpmnCorrelationPropertyBinding__correlation_property_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.correlation_property_ref, name="bpmnCorrelationPropertyBinding__correlation_property_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('correlation_property_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationPropertyBinding__correlation_property_ref, domain=None, range=str)

slots.bpmnCorrelationPropertyBinding__data_path = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_path, name="bpmnCorrelationPropertyBinding__data_path", curie=FLUXNOVA_BPM_PLATFORM.curie('data_path'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationPropertyBinding__data_path, domain=None, range=Union[dict, BpmnDataPath])

slots.bpmnCorrelationPropertyRetrievalExpression__message_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_ref, name="bpmnCorrelationPropertyRetrievalExpression__message_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('message_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationPropertyRetrievalExpression__message_ref, domain=None, range=str)

slots.bpmnCorrelationPropertyRetrievalExpression__message_path = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_path, name="bpmnCorrelationPropertyRetrievalExpression__message_path", curie=FLUXNOVA_BPM_PLATFORM.curie('message_path'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationPropertyRetrievalExpression__message_path, domain=None, range=Union[dict, BpmnMessagePath])

slots.bpmnCorrelationSubscription__correlation_key_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.correlation_key_ref, name="bpmnCorrelationSubscription__correlation_key_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('correlation_key_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationSubscription__correlation_key_ref, domain=None, range=str)

slots.bpmnCorrelationSubscription__correlation_property_bindings = Slot(uri=FLUXNOVA_BPM_PLATFORM.correlation_property_bindings, name="bpmnCorrelationSubscription__correlation_property_bindings", curie=FLUXNOVA_BPM_PLATFORM.curie('correlation_property_bindings'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnCorrelationSubscription__correlation_property_bindings, domain=None, range=Optional[Union[Union[dict, BpmnCorrelationPropertyBinding], list[Union[dict, BpmnCorrelationPropertyBinding]]]])

slots.bpmnDataAssociation__source_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.source_refs, name="bpmnDataAssociation__source_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('source_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataAssociation__source_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnDataAssociation__target_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.target_ref, name="bpmnDataAssociation__target_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('target_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataAssociation__target_ref, domain=None, range=str)

slots.bpmnDataAssociation__transformation = Slot(uri=FLUXNOVA_BPM_PLATFORM.transformation, name="bpmnDataAssociation__transformation", curie=FLUXNOVA_BPM_PLATFORM.curie('transformation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataAssociation__transformation, domain=None, range=Optional[Union[dict, BpmnTransformation]])

slots.bpmnDataAssociation__assignments = Slot(uri=FLUXNOVA_BPM_PLATFORM.assignments, name="bpmnDataAssociation__assignments", curie=FLUXNOVA_BPM_PLATFORM.curie('assignments'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataAssociation__assignments, domain=None, range=Optional[Union[Union[dict, BpmnAssignment], list[Union[dict, BpmnAssignment]]]])

slots.bpmnDataInput__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnDataInput__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataInput__name, domain=None, range=Optional[str])

slots.bpmnDataInput__is_collection = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_collection, name="bpmnDataInput__is_collection", curie=FLUXNOVA_BPM_PLATFORM.curie('is_collection'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataInput__is_collection, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnDataObject__item_subject_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.item_subject_ref, name="bpmnDataObject__item_subject_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('item_subject_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataObject__item_subject_ref, domain=None, range=Optional[str])

slots.bpmnDataObject__is_collection = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_collection, name="bpmnDataObject__is_collection", curie=FLUXNOVA_BPM_PLATFORM.curie('is_collection'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataObject__is_collection, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnDataObject__data_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_state, name="bpmnDataObject__data_state", curie=FLUXNOVA_BPM_PLATFORM.curie('data_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataObject__data_state, domain=None, range=Optional[Union[dict, BpmnDataState]])

slots.bpmnDataObjectReference__item_subject_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.item_subject_ref, name="bpmnDataObjectReference__item_subject_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('item_subject_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataObjectReference__item_subject_ref, domain=None, range=Optional[str])

slots.bpmnDataObjectReference__data_object_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_object_ref, name="bpmnDataObjectReference__data_object_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('data_object_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataObjectReference__data_object_ref, domain=None, range=Optional[str])

slots.bpmnDataObjectReference__data_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_state, name="bpmnDataObjectReference__data_state", curie=FLUXNOVA_BPM_PLATFORM.curie('data_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataObjectReference__data_state, domain=None, range=Optional[Union[dict, BpmnDataState]])

slots.bpmnDataOutput__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnDataOutput__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataOutput__name, domain=None, range=Optional[str])

slots.bpmnDataOutput__is_collection = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_collection, name="bpmnDataOutput__is_collection", curie=FLUXNOVA_BPM_PLATFORM.curie('is_collection'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataOutput__is_collection, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnDataState__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnDataState__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataState__name, domain=None, range=Optional[str])

slots.bpmnDataStore__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnDataStore__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataStore__name, domain=None, range=Optional[str])

slots.bpmnDataStore__capacity = Slot(uri=FLUXNOVA_BPM_PLATFORM.capacity, name="bpmnDataStore__capacity", curie=FLUXNOVA_BPM_PLATFORM.curie('capacity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataStore__capacity, domain=None, range=Optional[int])

slots.bpmnDataStore__is_unlimited = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_unlimited, name="bpmnDataStore__is_unlimited", curie=FLUXNOVA_BPM_PLATFORM.curie('is_unlimited'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataStore__is_unlimited, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnDataStore__item_subject_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.item_subject_ref, name="bpmnDataStore__item_subject_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('item_subject_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataStore__item_subject_ref, domain=None, range=Optional[str])

slots.bpmnDataStore__data_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_state, name="bpmnDataStore__data_state", curie=FLUXNOVA_BPM_PLATFORM.curie('data_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataStore__data_state, domain=None, range=Optional[Union[dict, BpmnDataState]])

slots.bpmnDataStoreReference__item_subject_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.item_subject_ref, name="bpmnDataStoreReference__item_subject_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('item_subject_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataStoreReference__item_subject_ref, domain=None, range=Optional[str])

slots.bpmnDataStoreReference__data_store_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_store_ref, name="bpmnDataStoreReference__data_store_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('data_store_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataStoreReference__data_store_ref, domain=None, range=Optional[str])

slots.bpmnDataStoreReference__data_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_state, name="bpmnDataStoreReference__data_state", curie=FLUXNOVA_BPM_PLATFORM.curie('data_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDataStoreReference__data_state, domain=None, range=Optional[Union[dict, BpmnDataState]])

slots.bpmnDefinitions__bpmn_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_id, name="bpmnDefinitions__bpmn_id", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__bpmn_id, domain=None, range=Optional[str])

slots.bpmnDefinitions__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnDefinitions__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__name, domain=None, range=Optional[str])

slots.bpmnDefinitions__target_namespace = Slot(uri=FLUXNOVA_BPM_PLATFORM.target_namespace, name="bpmnDefinitions__target_namespace", curie=FLUXNOVA_BPM_PLATFORM.curie('target_namespace'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__target_namespace, domain=None, range=str)

slots.bpmnDefinitions__expression_language = Slot(uri=FLUXNOVA_BPM_PLATFORM.expression_language, name="bpmnDefinitions__expression_language", curie=FLUXNOVA_BPM_PLATFORM.curie('expression_language'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__expression_language, domain=None, range=Optional[str])

slots.bpmnDefinitions__type_language = Slot(uri=FLUXNOVA_BPM_PLATFORM.type_language, name="bpmnDefinitions__type_language", curie=FLUXNOVA_BPM_PLATFORM.curie('type_language'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__type_language, domain=None, range=Optional[str])

slots.bpmnDefinitions__exporter = Slot(uri=FLUXNOVA_BPM_PLATFORM.exporter, name="bpmnDefinitions__exporter", curie=FLUXNOVA_BPM_PLATFORM.curie('exporter'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__exporter, domain=None, range=Optional[str])

slots.bpmnDefinitions__exporter_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.exporter_version, name="bpmnDefinitions__exporter_version", curie=FLUXNOVA_BPM_PLATFORM.curie('exporter_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__exporter_version, domain=None, range=Optional[str])

slots.bpmnDefinitions__imports = Slot(uri=FLUXNOVA_BPM_PLATFORM.imports, name="bpmnDefinitions__imports", curie=FLUXNOVA_BPM_PLATFORM.curie('imports'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__imports, domain=None, range=Optional[Union[Union[dict, BpmnImport], list[Union[dict, BpmnImport]]]])

slots.bpmnDefinitions__extensions = Slot(uri=FLUXNOVA_BPM_PLATFORM.extensions, name="bpmnDefinitions__extensions", curie=FLUXNOVA_BPM_PLATFORM.curie('extensions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__extensions, domain=None, range=Optional[Union[Union[dict, BpmnExtension], list[Union[dict, BpmnExtension]]]])

slots.bpmnDefinitions__root_elements = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_elements, name="bpmnDefinitions__root_elements", curie=FLUXNOVA_BPM_PLATFORM.curie('root_elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__root_elements, domain=None, range=Optional[Union[Union[dict, BpmnRootElement], list[Union[dict, BpmnRootElement]]]])

slots.bpmnDefinitions__bpmn_diagrams = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_diagrams, name="bpmnDefinitions__bpmn_diagrams", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_diagrams'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__bpmn_diagrams, domain=None, range=Optional[Union[Union[dict, BpmnDiagram], list[Union[dict, BpmnDiagram]]]])

slots.bpmnDefinitions__relationships = Slot(uri=FLUXNOVA_BPM_PLATFORM.relationships, name="bpmnDefinitions__relationships", curie=FLUXNOVA_BPM_PLATFORM.curie('relationships'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDefinitions__relationships, domain=None, range=Optional[Union[Union[dict, BpmnRelationship], list[Union[dict, BpmnRelationship]]]])

slots.bpmnDocumentation__bpmn_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_id, name="bpmnDocumentation__bpmn_id", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDocumentation__bpmn_id, domain=None, range=Optional[str])

slots.bpmnDocumentation__text_format = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_format, name="bpmnDocumentation__text_format", curie=FLUXNOVA_BPM_PLATFORM.curie('text_format'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDocumentation__text_format, domain=None, range=Optional[str])

slots.bpmnDocumentation__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="bpmnDocumentation__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDocumentation__text_content, domain=None, range=Optional[str])

slots.bpmnError__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnError__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnError__name, domain=None, range=Optional[str])

slots.bpmnError__error_code = Slot(uri=FLUXNOVA_BPM_PLATFORM.error_code, name="bpmnError__error_code", curie=FLUXNOVA_BPM_PLATFORM.curie('error_code'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnError__error_code, domain=None, range=Optional[str])

slots.bpmnError__fluxnova_error_message = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_error_message, name="bpmnError__fluxnova_error_message", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_error_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnError__fluxnova_error_message, domain=None, range=Optional[str])

slots.bpmnError__structure_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.structure_ref, name="bpmnError__structure_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('structure_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnError__structure_ref, domain=None, range=Optional[str])

slots.bpmnErrorEventDefinition__error_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.error_ref, name="bpmnErrorEventDefinition__error_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('error_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnErrorEventDefinition__error_ref, domain=None, range=Optional[str])

slots.bpmnErrorEventDefinition__fluxnova_error_code_variable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_error_code_variable, name="bpmnErrorEventDefinition__fluxnova_error_code_variable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_error_code_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnErrorEventDefinition__fluxnova_error_code_variable, domain=None, range=Optional[str])

slots.bpmnErrorEventDefinition__fluxnova_error_message_variable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_error_message_variable, name="bpmnErrorEventDefinition__fluxnova_error_message_variable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_error_message_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnErrorEventDefinition__fluxnova_error_message_variable, domain=None, range=Optional[str])

slots.bpmnEscalation__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnEscalation__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEscalation__name, domain=None, range=Optional[str])

slots.bpmnEscalation__escalation_code = Slot(uri=FLUXNOVA_BPM_PLATFORM.escalation_code, name="bpmnEscalation__escalation_code", curie=FLUXNOVA_BPM_PLATFORM.curie('escalation_code'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEscalation__escalation_code, domain=None, range=Optional[str])

slots.bpmnEscalation__structure_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.structure_ref, name="bpmnEscalation__structure_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('structure_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEscalation__structure_ref, domain=None, range=Optional[str])

slots.bpmnEscalationEventDefinition__escalation_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.escalation_ref, name="bpmnEscalationEventDefinition__escalation_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('escalation_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEscalationEventDefinition__escalation_ref, domain=None, range=Optional[str])

slots.bpmnEvent__properties = Slot(uri=FLUXNOVA_BPM_PLATFORM.properties, name="bpmnEvent__properties", curie=FLUXNOVA_BPM_PLATFORM.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEvent__properties, domain=None, range=Optional[Union[Union[dict, BpmnProperty], list[Union[dict, BpmnProperty]]]])

slots.bpmnEventBasedGateway__instantiate = Slot(uri=FLUXNOVA_BPM_PLATFORM.instantiate, name="bpmnEventBasedGateway__instantiate", curie=FLUXNOVA_BPM_PLATFORM.curie('instantiate'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEventBasedGateway__instantiate, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnEventBasedGateway__event_gateway_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_gateway_type, name="bpmnEventBasedGateway__event_gateway_type", curie=FLUXNOVA_BPM_PLATFORM.curie('event_gateway_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEventBasedGateway__event_gateway_type, domain=None, range=Optional[Union[str, "BpmnEventBasedGatewayType"]])

slots.bpmnExclusiveGateway__default = Slot(uri=FLUXNOVA_BPM_PLATFORM.default, name="bpmnExclusiveGateway__default", curie=FLUXNOVA_BPM_PLATFORM.curie('default'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnExclusiveGateway__default, domain=None, range=Optional[str])

slots.bpmnExpression__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="bpmnExpression__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnExpression__text_content, domain=None, range=Optional[str])

slots.bpmnExtension__bpmn_definition = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_definition, name="bpmnExtension__bpmn_definition", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_definition'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnExtension__bpmn_definition, domain=None, range=Optional[str])

slots.bpmnExtension__must_understand = Slot(uri=FLUXNOVA_BPM_PLATFORM.must_understand, name="bpmnExtension__must_understand", curie=FLUXNOVA_BPM_PLATFORM.curie('must_understand'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnExtension__must_understand, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnExtension__bpmn_documentation = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_documentation, name="bpmnExtension__bpmn_documentation", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_documentation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnExtension__bpmn_documentation, domain=None, range=Optional[Union[Union[dict, BpmnDocumentation], list[Union[dict, BpmnDocumentation]]]])

slots.bpmnExtensionElements__elements = Slot(uri=FLUXNOVA_BPM_PLATFORM.elements, name="bpmnExtensionElements__elements", curie=FLUXNOVA_BPM_PLATFORM.curie('elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnExtensionElements__elements, domain=None, range=Optional[Union[Union[dict, BpmnModelElementInstance], list[Union[dict, BpmnModelElementInstance]]]])

slots.bpmnFlowElement__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnFlowElement__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowElement__name, domain=None, range=Optional[str])

slots.bpmnFlowElement__auditing = Slot(uri=FLUXNOVA_BPM_PLATFORM.auditing, name="bpmnFlowElement__auditing", curie=FLUXNOVA_BPM_PLATFORM.curie('auditing'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowElement__auditing, domain=None, range=Optional[Union[dict, BpmnAuditing]])

slots.bpmnFlowElement__monitoring = Slot(uri=FLUXNOVA_BPM_PLATFORM.monitoring, name="bpmnFlowElement__monitoring", curie=FLUXNOVA_BPM_PLATFORM.curie('monitoring'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowElement__monitoring, domain=None, range=Optional[Union[dict, BpmnMonitoring]])

slots.bpmnFlowElement__category_value_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.category_value_refs, name="bpmnFlowElement__category_value_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('category_value_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowElement__category_value_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnFlowNode__fluxnova_async_after = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async_after, name="bpmnFlowNode__fluxnova_async_after", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async_after'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowNode__fluxnova_async_after, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnFlowNode__fluxnova_async_before = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async_before, name="bpmnFlowNode__fluxnova_async_before", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async_before'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowNode__fluxnova_async_before, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnFlowNode__fluxnova_exclusive = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_exclusive, name="bpmnFlowNode__fluxnova_exclusive", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_exclusive'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowNode__fluxnova_exclusive, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnFlowNode__fluxnova_job_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_job_priority, name="bpmnFlowNode__fluxnova_job_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_job_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowNode__fluxnova_job_priority, domain=None, range=Optional[str])

slots.bpmnFlowNode__incoming = Slot(uri=FLUXNOVA_BPM_PLATFORM.incoming, name="bpmnFlowNode__incoming", curie=FLUXNOVA_BPM_PLATFORM.curie('incoming'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowNode__incoming, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnFlowNode__outgoing = Slot(uri=FLUXNOVA_BPM_PLATFORM.outgoing, name="bpmnFlowNode__outgoing", curie=FLUXNOVA_BPM_PLATFORM.curie('outgoing'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFlowNode__outgoing, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnFormalExpression__language = Slot(uri=FLUXNOVA_BPM_PLATFORM.language, name="bpmnFormalExpression__language", curie=FLUXNOVA_BPM_PLATFORM.curie('language'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFormalExpression__language, domain=None, range=Optional[str])

slots.bpmnFormalExpression__evaluates_to_type_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.evaluates_to_type_ref, name="bpmnFormalExpression__evaluates_to_type_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('evaluates_to_type_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnFormalExpression__evaluates_to_type_ref, domain=None, range=Optional[str])

slots.bpmnGateway__gateway_direction = Slot(uri=FLUXNOVA_BPM_PLATFORM.gateway_direction, name="bpmnGateway__gateway_direction", curie=FLUXNOVA_BPM_PLATFORM.curie('gateway_direction'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnGateway__gateway_direction, domain=None, range=Optional[Union[str, "BpmnGatewayDirection"]])

slots.bpmnGroup__category_value_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.category_value_ref, name="bpmnGroup__category_value_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('category_value_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnGroup__category_value_ref, domain=None, range=Optional[str])

slots.bpmnImport__namespace = Slot(uri=FLUXNOVA_BPM_PLATFORM.namespace, name="bpmnImport__namespace", curie=FLUXNOVA_BPM_PLATFORM.curie('namespace'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnImport__namespace, domain=None, range=str)

slots.bpmnImport__location = Slot(uri=FLUXNOVA_BPM_PLATFORM.location, name="bpmnImport__location", curie=FLUXNOVA_BPM_PLATFORM.curie('location'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnImport__location, domain=None, range=str)

slots.bpmnImport__import_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.import_type, name="bpmnImport__import_type", curie=FLUXNOVA_BPM_PLATFORM.curie('import_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnImport__import_type, domain=None, range=str)

slots.bpmnInclusiveGateway__default = Slot(uri=FLUXNOVA_BPM_PLATFORM.default, name="bpmnInclusiveGateway__default", curie=FLUXNOVA_BPM_PLATFORM.curie('default'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInclusiveGateway__default, domain=None, range=Optional[str])

slots.bpmnInputSet__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnInputSet__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInputSet__name, domain=None, range=Optional[str])

slots.bpmnInputSet__data_input_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_input_refs, name="bpmnInputSet__data_input_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('data_input_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInputSet__data_input_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnInputSet__optional_input_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.optional_input_refs, name="bpmnInputSet__optional_input_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('optional_input_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInputSet__optional_input_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnInputSet__while_executing_input_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.while_executing_input_refs, name="bpmnInputSet__while_executing_input_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('while_executing_input_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInputSet__while_executing_input_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnInputSet__output_set_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.output_set_refs, name="bpmnInputSet__output_set_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('output_set_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInputSet__output_set_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnInteractionNode__bpmn_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_id, name="bpmnInteractionNode__bpmn_id", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInteractionNode__bpmn_id, domain=None, range=Optional[str])

slots.bpmnInterface__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnInterface__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInterface__name, domain=None, range=str)

slots.bpmnInterface__implementation_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.implementation_ref, name="bpmnInterface__implementation_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('implementation_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInterface__implementation_ref, domain=None, range=Optional[str])

slots.bpmnInterface__operations = Slot(uri=FLUXNOVA_BPM_PLATFORM.operations, name="bpmnInterface__operations", curie=FLUXNOVA_BPM_PLATFORM.curie('operations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnInterface__operations, domain=None, range=Union[Union[dict, BpmnOperation], list[Union[dict, BpmnOperation]]])

slots.bpmnIoBinding__operation_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_ref, name="bpmnIoBinding__operation_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnIoBinding__operation_ref, domain=None, range=str)

slots.bpmnIoBinding__input_data_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.input_data_ref, name="bpmnIoBinding__input_data_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('input_data_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnIoBinding__input_data_ref, domain=None, range=str)

slots.bpmnIoBinding__output_data_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.output_data_ref, name="bpmnIoBinding__output_data_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('output_data_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnIoBinding__output_data_ref, domain=None, range=str)

slots.bpmnIoSpecification__data_inputs = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_inputs, name="bpmnIoSpecification__data_inputs", curie=FLUXNOVA_BPM_PLATFORM.curie('data_inputs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnIoSpecification__data_inputs, domain=None, range=Optional[Union[Union[dict, BpmnDataInput], list[Union[dict, BpmnDataInput]]]])

slots.bpmnIoSpecification__data_outputs = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_outputs, name="bpmnIoSpecification__data_outputs", curie=FLUXNOVA_BPM_PLATFORM.curie('data_outputs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnIoSpecification__data_outputs, domain=None, range=Optional[Union[Union[dict, BpmnDataOutput], list[Union[dict, BpmnDataOutput]]]])

slots.bpmnIoSpecification__input_sets = Slot(uri=FLUXNOVA_BPM_PLATFORM.input_sets, name="bpmnIoSpecification__input_sets", curie=FLUXNOVA_BPM_PLATFORM.curie('input_sets'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnIoSpecification__input_sets, domain=None, range=Union[Union[dict, BpmnInputSet], list[Union[dict, BpmnInputSet]]])

slots.bpmnIoSpecification__output_sets = Slot(uri=FLUXNOVA_BPM_PLATFORM.output_sets, name="bpmnIoSpecification__output_sets", curie=FLUXNOVA_BPM_PLATFORM.curie('output_sets'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnIoSpecification__output_sets, domain=None, range=Union[Union[dict, BpmnOutputSet], list[Union[dict, BpmnOutputSet]]])

slots.bpmnItemAwareElement__item_subject_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.item_subject_ref, name="bpmnItemAwareElement__item_subject_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('item_subject_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnItemAwareElement__item_subject_ref, domain=None, range=Optional[str])

slots.bpmnItemAwareElement__data_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_state, name="bpmnItemAwareElement__data_state", curie=FLUXNOVA_BPM_PLATFORM.curie('data_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnItemAwareElement__data_state, domain=None, range=Optional[Union[dict, BpmnDataState]])

slots.bpmnItemDefinition__structure_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.structure_ref, name="bpmnItemDefinition__structure_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('structure_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnItemDefinition__structure_ref, domain=None, range=Optional[str])

slots.bpmnItemDefinition__is_collection = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_collection, name="bpmnItemDefinition__is_collection", curie=FLUXNOVA_BPM_PLATFORM.curie('is_collection'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnItemDefinition__is_collection, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnItemDefinition__item_kind = Slot(uri=FLUXNOVA_BPM_PLATFORM.item_kind, name="bpmnItemDefinition__item_kind", curie=FLUXNOVA_BPM_PLATFORM.curie('item_kind'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnItemDefinition__item_kind, domain=None, range=Optional[Union[str, "BpmnItemKind"]])

slots.bpmnLane__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnLane__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLane__name, domain=None, range=Optional[str])

slots.bpmnLane__partition_element_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.partition_element_ref, name="bpmnLane__partition_element_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('partition_element_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLane__partition_element_ref, domain=None, range=Optional[str])

slots.bpmnLane__partition_element = Slot(uri=FLUXNOVA_BPM_PLATFORM.partition_element, name="bpmnLane__partition_element", curie=FLUXNOVA_BPM_PLATFORM.curie('partition_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLane__partition_element, domain=None, range=Optional[Union[dict, BpmnPartitionElement]])

slots.bpmnLane__flow_node_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.flow_node_refs, name="bpmnLane__flow_node_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('flow_node_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLane__flow_node_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnLane__child_lane_set = Slot(uri=FLUXNOVA_BPM_PLATFORM.child_lane_set, name="bpmnLane__child_lane_set", curie=FLUXNOVA_BPM_PLATFORM.curie('child_lane_set'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLane__child_lane_set, domain=None, range=Optional[Union[dict, BpmnChildLaneSet]])

slots.bpmnLaneSet__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnLaneSet__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLaneSet__name, domain=None, range=Optional[str])

slots.bpmnLaneSet__lanes = Slot(uri=FLUXNOVA_BPM_PLATFORM.lanes, name="bpmnLaneSet__lanes", curie=FLUXNOVA_BPM_PLATFORM.curie('lanes'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLaneSet__lanes, domain=None, range=Optional[Union[Union[dict, BpmnLane], list[Union[dict, BpmnLane]]]])

slots.bpmnLinkEventDefinition__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnLinkEventDefinition__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLinkEventDefinition__name, domain=None, range=str)

slots.bpmnLinkEventDefinition__bpmn_sources = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_sources, name="bpmnLinkEventDefinition__bpmn_sources", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_sources'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLinkEventDefinition__bpmn_sources, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnLinkEventDefinition__bpmn_target = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_target, name="bpmnLinkEventDefinition__bpmn_target", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_target'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLinkEventDefinition__bpmn_target, domain=None, range=Optional[str])

slots.bpmnMessage__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnMessage__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessage__name, domain=None, range=Optional[str])

slots.bpmnMessage__item_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.item_ref, name="bpmnMessage__item_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('item_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessage__item_ref, domain=None, range=Optional[str])

slots.bpmnMessageEventDefinition__message_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_ref, name="bpmnMessageEventDefinition__message_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('message_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageEventDefinition__message_ref, domain=None, range=Optional[str])

slots.bpmnMessageEventDefinition__fluxnova_class = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_class, name="bpmnMessageEventDefinition__fluxnova_class", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageEventDefinition__fluxnova_class, domain=None, range=Optional[str])

slots.bpmnMessageEventDefinition__fluxnova_delegate_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_delegate_expression, name="bpmnMessageEventDefinition__fluxnova_delegate_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_delegate_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageEventDefinition__fluxnova_delegate_expression, domain=None, range=Optional[str])

slots.bpmnMessageEventDefinition__fluxnova_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, name="bpmnMessageEventDefinition__fluxnova_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageEventDefinition__fluxnova_expression, domain=None, range=Optional[str])

slots.bpmnMessageEventDefinition__fluxnova_result_variable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_result_variable, name="bpmnMessageEventDefinition__fluxnova_result_variable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_result_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageEventDefinition__fluxnova_result_variable, domain=None, range=Optional[str])

slots.bpmnMessageEventDefinition__fluxnova_topic = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_topic, name="bpmnMessageEventDefinition__fluxnova_topic", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_topic'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageEventDefinition__fluxnova_topic, domain=None, range=Optional[str])

slots.bpmnMessageEventDefinition__fluxnova_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_type, name="bpmnMessageEventDefinition__fluxnova_type", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageEventDefinition__fluxnova_type, domain=None, range=Optional[str])

slots.bpmnMessageEventDefinition__fluxnova_task_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_task_priority, name="bpmnMessageEventDefinition__fluxnova_task_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_task_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageEventDefinition__fluxnova_task_priority, domain=None, range=Optional[str])

slots.bpmnMessageEventDefinition__operation_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_ref, name="bpmnMessageEventDefinition__operation_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageEventDefinition__operation_ref, domain=None, range=Optional[str])

slots.bpmnMessageFlow__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnMessageFlow__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageFlow__name, domain=None, range=Optional[str])

slots.bpmnMessageFlow__source_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.source_ref, name="bpmnMessageFlow__source_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('source_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageFlow__source_ref, domain=None, range=str)

slots.bpmnMessageFlow__target_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.target_ref, name="bpmnMessageFlow__target_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('target_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageFlow__target_ref, domain=None, range=str)

slots.bpmnMessageFlow__message_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_ref, name="bpmnMessageFlow__message_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('message_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageFlow__message_ref, domain=None, range=Optional[str])

slots.bpmnMessageFlowAssociation__inner_message_flow_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.inner_message_flow_ref, name="bpmnMessageFlowAssociation__inner_message_flow_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('inner_message_flow_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageFlowAssociation__inner_message_flow_ref, domain=None, range=str)

slots.bpmnMessageFlowAssociation__outer_message_flow_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.outer_message_flow_ref, name="bpmnMessageFlowAssociation__outer_message_flow_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('outer_message_flow_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMessageFlowAssociation__outer_message_flow_ref, domain=None, range=str)

slots.bpmnMultiInstanceLoopCharacteristics__is_sequential = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_sequential, name="bpmnMultiInstanceLoopCharacteristics__is_sequential", curie=FLUXNOVA_BPM_PLATFORM.curie('is_sequential'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__is_sequential, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnMultiInstanceLoopCharacteristics__behavior = Slot(uri=FLUXNOVA_BPM_PLATFORM.behavior, name="bpmnMultiInstanceLoopCharacteristics__behavior", curie=FLUXNOVA_BPM_PLATFORM.curie('behavior'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__behavior, domain=None, range=Optional[Union[str, "BpmnMultiInstanceFlowCondition"]])

slots.bpmnMultiInstanceLoopCharacteristics__one_behavior_event_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.one_behavior_event_ref, name="bpmnMultiInstanceLoopCharacteristics__one_behavior_event_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('one_behavior_event_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__one_behavior_event_ref, domain=None, range=Optional[str])

slots.bpmnMultiInstanceLoopCharacteristics__none_behavior_event_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.none_behavior_event_ref, name="bpmnMultiInstanceLoopCharacteristics__none_behavior_event_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('none_behavior_event_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__none_behavior_event_ref, domain=None, range=Optional[str])

slots.bpmnMultiInstanceLoopCharacteristics__fluxnova_async_after = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async_after, name="bpmnMultiInstanceLoopCharacteristics__fluxnova_async_after", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async_after'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__fluxnova_async_after, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnMultiInstanceLoopCharacteristics__fluxnova_async_before = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async_before, name="bpmnMultiInstanceLoopCharacteristics__fluxnova_async_before", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async_before'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__fluxnova_async_before, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnMultiInstanceLoopCharacteristics__fluxnova_exclusive = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_exclusive, name="bpmnMultiInstanceLoopCharacteristics__fluxnova_exclusive", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_exclusive'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__fluxnova_exclusive, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnMultiInstanceLoopCharacteristics__fluxnova_collection = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_collection, name="bpmnMultiInstanceLoopCharacteristics__fluxnova_collection", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_collection'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__fluxnova_collection, domain=None, range=Optional[str])

slots.bpmnMultiInstanceLoopCharacteristics__fluxnova_element_variable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_element_variable, name="bpmnMultiInstanceLoopCharacteristics__fluxnova_element_variable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_element_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__fluxnova_element_variable, domain=None, range=Optional[str])

slots.bpmnMultiInstanceLoopCharacteristics__loop_cardinality = Slot(uri=FLUXNOVA_BPM_PLATFORM.loop_cardinality, name="bpmnMultiInstanceLoopCharacteristics__loop_cardinality", curie=FLUXNOVA_BPM_PLATFORM.curie('loop_cardinality'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__loop_cardinality, domain=None, range=Optional[Union[dict, BpmnLoopCardinality]])

slots.bpmnMultiInstanceLoopCharacteristics__loop_data_input_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.loop_data_input_ref, name="bpmnMultiInstanceLoopCharacteristics__loop_data_input_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('loop_data_input_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__loop_data_input_ref, domain=None, range=Optional[str])

slots.bpmnMultiInstanceLoopCharacteristics__loop_data_output_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.loop_data_output_ref, name="bpmnMultiInstanceLoopCharacteristics__loop_data_output_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('loop_data_output_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__loop_data_output_ref, domain=None, range=Optional[str])

slots.bpmnMultiInstanceLoopCharacteristics__output_data_item = Slot(uri=FLUXNOVA_BPM_PLATFORM.output_data_item, name="bpmnMultiInstanceLoopCharacteristics__output_data_item", curie=FLUXNOVA_BPM_PLATFORM.curie('output_data_item'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__output_data_item, domain=None, range=Optional[Union[dict, BpmnOutputDataItem]])

slots.bpmnMultiInstanceLoopCharacteristics__input_data_item = Slot(uri=FLUXNOVA_BPM_PLATFORM.input_data_item, name="bpmnMultiInstanceLoopCharacteristics__input_data_item", curie=FLUXNOVA_BPM_PLATFORM.curie('input_data_item'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__input_data_item, domain=None, range=Optional[Union[dict, BpmnInputDataItem]])

slots.bpmnMultiInstanceLoopCharacteristics__complex_behavior_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.complex_behavior_definitions, name="bpmnMultiInstanceLoopCharacteristics__complex_behavior_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('complex_behavior_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__complex_behavior_definitions, domain=None, range=Optional[Union[Union[dict, BpmnComplexBehaviorDefinition], list[Union[dict, BpmnComplexBehaviorDefinition]]]])

slots.bpmnMultiInstanceLoopCharacteristics__completion_condition = Slot(uri=FLUXNOVA_BPM_PLATFORM.completion_condition, name="bpmnMultiInstanceLoopCharacteristics__completion_condition", curie=FLUXNOVA_BPM_PLATFORM.curie('completion_condition'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnMultiInstanceLoopCharacteristics__completion_condition, domain=None, range=Optional[Union[dict, BpmnCompletionCondition]])

slots.bpmnOperation__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnOperation__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOperation__name, domain=None, range=str)

slots.bpmnOperation__implementation_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.implementation_ref, name="bpmnOperation__implementation_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('implementation_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOperation__implementation_ref, domain=None, range=Optional[str])

slots.bpmnOperation__in_message_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.in_message_ref, name="bpmnOperation__in_message_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('in_message_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOperation__in_message_ref, domain=None, range=str)

slots.bpmnOperation__out_message_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.out_message_ref, name="bpmnOperation__out_message_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('out_message_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOperation__out_message_ref, domain=None, range=Optional[str])

slots.bpmnOperation__error_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.error_refs, name="bpmnOperation__error_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('error_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOperation__error_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnOutputSet__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnOutputSet__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOutputSet__name, domain=None, range=Optional[str])

slots.bpmnOutputSet__data_output_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_output_refs, name="bpmnOutputSet__data_output_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('data_output_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOutputSet__data_output_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnOutputSet__optional_output_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.optional_output_refs, name="bpmnOutputSet__optional_output_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('optional_output_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOutputSet__optional_output_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnOutputSet__while_executing_output_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.while_executing_output_refs, name="bpmnOutputSet__while_executing_output_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('while_executing_output_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOutputSet__while_executing_output_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnOutputSet__input_set_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.input_set_refs, name="bpmnOutputSet__input_set_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('input_set_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnOutputSet__input_set_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnParallelGateway__fluxnova_async = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async, name="bpmnParallelGateway__fluxnova_async", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParallelGateway__fluxnova_async, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnParticipant__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnParticipant__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParticipant__name, domain=None, range=Optional[str])

slots.bpmnParticipant__process_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_ref, name="bpmnParticipant__process_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('process_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParticipant__process_ref, domain=None, range=Optional[str])

slots.bpmnParticipant__interface_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.interface_refs, name="bpmnParticipant__interface_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('interface_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParticipant__interface_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnParticipant__end_point_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.end_point_refs, name="bpmnParticipant__end_point_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('end_point_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParticipant__end_point_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnParticipant__participant_multiplicity = Slot(uri=FLUXNOVA_BPM_PLATFORM.participant_multiplicity, name="bpmnParticipant__participant_multiplicity", curie=FLUXNOVA_BPM_PLATFORM.curie('participant_multiplicity'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParticipant__participant_multiplicity, domain=None, range=Optional[Union[dict, BpmnParticipantMultiplicity]])

slots.bpmnParticipantAssociation__inner_participant_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.inner_participant_ref, name="bpmnParticipantAssociation__inner_participant_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('inner_participant_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParticipantAssociation__inner_participant_ref, domain=None, range=str)

slots.bpmnParticipantAssociation__outer_participant_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.outer_participant_ref, name="bpmnParticipantAssociation__outer_participant_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('outer_participant_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParticipantAssociation__outer_participant_ref, domain=None, range=str)

slots.bpmnParticipantMultiplicity__minimum = Slot(uri=FLUXNOVA_BPM_PLATFORM.minimum, name="bpmnParticipantMultiplicity__minimum", curie=FLUXNOVA_BPM_PLATFORM.curie('minimum'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParticipantMultiplicity__minimum, domain=None, range=Optional[int])

slots.bpmnParticipantMultiplicity__maximum = Slot(uri=FLUXNOVA_BPM_PLATFORM.maximum, name="bpmnParticipantMultiplicity__maximum", curie=FLUXNOVA_BPM_PLATFORM.curie('maximum'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnParticipantMultiplicity__maximum, domain=None, range=Optional[int])

slots.bpmnProcess__process_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_type, name="bpmnProcess__process_type", curie=FLUXNOVA_BPM_PLATFORM.curie('process_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__process_type, domain=None, range=Optional[Union[str, "BpmnProcessType"]])

slots.bpmnProcess__is_closed = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_closed, name="bpmnProcess__is_closed", curie=FLUXNOVA_BPM_PLATFORM.curie('is_closed'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__is_closed, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnProcess__is_executable = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_executable, name="bpmnProcess__is_executable", curie=FLUXNOVA_BPM_PLATFORM.curie('is_executable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__is_executable, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnProcess__fluxnova_candidate_starter_groups = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_starter_groups, name="bpmnProcess__fluxnova_candidate_starter_groups", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_candidate_starter_groups'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__fluxnova_candidate_starter_groups, domain=None, range=Optional[str])

slots.bpmnProcess__fluxnova_candidate_starter_users = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_starter_users, name="bpmnProcess__fluxnova_candidate_starter_users", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_candidate_starter_users'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__fluxnova_candidate_starter_users, domain=None, range=Optional[str])

slots.bpmnProcess__fluxnova_job_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_job_priority, name="bpmnProcess__fluxnova_job_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_job_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__fluxnova_job_priority, domain=None, range=Optional[str])

slots.bpmnProcess__fluxnova_task_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_task_priority, name="bpmnProcess__fluxnova_task_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_task_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__fluxnova_task_priority, domain=None, range=Optional[str])

slots.bpmnProcess__fluxnova_history_time_to_live = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_history_time_to_live, name="bpmnProcess__fluxnova_history_time_to_live", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_history_time_to_live'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__fluxnova_history_time_to_live, domain=None, range=Optional[str])

slots.bpmnProcess__fluxnova_is_startable_in_tasklist = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_is_startable_in_tasklist, name="bpmnProcess__fluxnova_is_startable_in_tasklist", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_is_startable_in_tasklist'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__fluxnova_is_startable_in_tasklist, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnProcess__fluxnova_version_tag = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_version_tag, name="bpmnProcess__fluxnova_version_tag", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__fluxnova_version_tag, domain=None, range=Optional[str])

slots.bpmnProcess__auditing = Slot(uri=FLUXNOVA_BPM_PLATFORM.auditing, name="bpmnProcess__auditing", curie=FLUXNOVA_BPM_PLATFORM.curie('auditing'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__auditing, domain=None, range=Optional[Union[dict, BpmnAuditing]])

slots.bpmnProcess__monitoring = Slot(uri=FLUXNOVA_BPM_PLATFORM.monitoring, name="bpmnProcess__monitoring", curie=FLUXNOVA_BPM_PLATFORM.curie('monitoring'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__monitoring, domain=None, range=Optional[Union[dict, BpmnMonitoring]])

slots.bpmnProcess__properties = Slot(uri=FLUXNOVA_BPM_PLATFORM.properties, name="bpmnProcess__properties", curie=FLUXNOVA_BPM_PLATFORM.curie('properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__properties, domain=None, range=Optional[Union[Union[dict, BpmnProperty], list[Union[dict, BpmnProperty]]]])

slots.bpmnProcess__lane_sets = Slot(uri=FLUXNOVA_BPM_PLATFORM.lane_sets, name="bpmnProcess__lane_sets", curie=FLUXNOVA_BPM_PLATFORM.curie('lane_sets'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__lane_sets, domain=None, range=Optional[Union[Union[dict, BpmnLaneSet], list[Union[dict, BpmnLaneSet]]]])

slots.bpmnProcess__flow_elements = Slot(uri=FLUXNOVA_BPM_PLATFORM.flow_elements, name="bpmnProcess__flow_elements", curie=FLUXNOVA_BPM_PLATFORM.curie('flow_elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__flow_elements, domain=None, range=Optional[Union[Union[dict, BpmnFlowElement], list[Union[dict, BpmnFlowElement]]]])

slots.bpmnProcess__artifacts = Slot(uri=FLUXNOVA_BPM_PLATFORM.artifacts, name="bpmnProcess__artifacts", curie=FLUXNOVA_BPM_PLATFORM.curie('artifacts'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__artifacts, domain=None, range=Optional[Union[Union[dict, BpmnArtifact], list[Union[dict, BpmnArtifact]]]])

slots.bpmnProcess__resource_roles = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_roles, name="bpmnProcess__resource_roles", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_roles'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__resource_roles, domain=None, range=Optional[Union[Union[dict, BpmnResourceRole], list[Union[dict, BpmnResourceRole]]]])

slots.bpmnProcess__correlation_subscriptions = Slot(uri=FLUXNOVA_BPM_PLATFORM.correlation_subscriptions, name="bpmnProcess__correlation_subscriptions", curie=FLUXNOVA_BPM_PLATFORM.curie('correlation_subscriptions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__correlation_subscriptions, domain=None, range=Optional[Union[Union[dict, BpmnCorrelationSubscription], list[Union[dict, BpmnCorrelationSubscription]]]])

slots.bpmnProcess__supports = Slot(uri=FLUXNOVA_BPM_PLATFORM.supports, name="bpmnProcess__supports", curie=FLUXNOVA_BPM_PLATFORM.curie('supports'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProcess__supports, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnProperty__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnProperty__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnProperty__name, domain=None, range=Optional[str])

slots.bpmnReceiveTask__implementation = Slot(uri=FLUXNOVA_BPM_PLATFORM.implementation, name="bpmnReceiveTask__implementation", curie=FLUXNOVA_BPM_PLATFORM.curie('implementation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnReceiveTask__implementation, domain=None, range=Optional[str])

slots.bpmnReceiveTask__instantiate = Slot(uri=FLUXNOVA_BPM_PLATFORM.instantiate, name="bpmnReceiveTask__instantiate", curie=FLUXNOVA_BPM_PLATFORM.curie('instantiate'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnReceiveTask__instantiate, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnReceiveTask__message_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_ref, name="bpmnReceiveTask__message_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('message_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnReceiveTask__message_ref, domain=None, range=Optional[str])

slots.bpmnReceiveTask__operation_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_ref, name="bpmnReceiveTask__operation_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnReceiveTask__operation_ref, domain=None, range=Optional[str])

slots.bpmnRelationship__type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="bpmnRelationship__type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnRelationship__type, domain=None, range=str)

slots.bpmnRelationship__direction = Slot(uri=FLUXNOVA_BPM_PLATFORM.direction, name="bpmnRelationship__direction", curie=FLUXNOVA_BPM_PLATFORM.curie('direction'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnRelationship__direction, domain=None, range=Optional[Union[str, "BpmnRelationshipDirection"]])

slots.bpmnRelationship__bpmn_sources = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_sources, name="bpmnRelationship__bpmn_sources", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_sources'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnRelationship__bpmn_sources, domain=None, range=Union[Union[dict, BpmnSource], list[Union[dict, BpmnSource]]])

slots.bpmnRelationship__targets = Slot(uri=FLUXNOVA_BPM_PLATFORM.targets, name="bpmnRelationship__targets", curie=FLUXNOVA_BPM_PLATFORM.curie('targets'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnRelationship__targets, domain=None, range=Union[Union[dict, BpmnTarget], list[Union[dict, BpmnTarget]]])

slots.bpmnResource__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnResource__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResource__name, domain=None, range=str)

slots.bpmnResource__resource_parameters = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_parameters, name="bpmnResource__resource_parameters", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_parameters'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResource__resource_parameters, domain=None, range=Optional[Union[Union[dict, BpmnResourceParameter], list[Union[dict, BpmnResourceParameter]]]])

slots.bpmnResourceAssignmentExpression__expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.expression, name="bpmnResourceAssignmentExpression__expression", curie=FLUXNOVA_BPM_PLATFORM.curie('expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceAssignmentExpression__expression, domain=None, range=Union[dict, BpmnExpression])

slots.bpmnResourceParameter__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnResourceParameter__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceParameter__name, domain=None, range=Optional[str])

slots.bpmnResourceParameter__type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="bpmnResourceParameter__type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceParameter__type, domain=None, range=Optional[str])

slots.bpmnResourceParameter__is_required = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_required, name="bpmnResourceParameter__is_required", curie=FLUXNOVA_BPM_PLATFORM.curie('is_required'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceParameter__is_required, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnResourceParameterBinding__parameter_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.parameter_ref, name="bpmnResourceParameterBinding__parameter_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('parameter_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceParameterBinding__parameter_ref, domain=None, range=str)

slots.bpmnResourceParameterBinding__expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.expression, name="bpmnResourceParameterBinding__expression", curie=FLUXNOVA_BPM_PLATFORM.curie('expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceParameterBinding__expression, domain=None, range=Union[dict, BpmnExpression])

slots.bpmnResourceRole__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnResourceRole__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceRole__name, domain=None, range=Optional[str])

slots.bpmnResourceRole__resource_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_ref, name="bpmnResourceRole__resource_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceRole__resource_ref, domain=None, range=Optional[str])

slots.bpmnResourceRole__resource_parameter_bindings = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_parameter_bindings, name="bpmnResourceRole__resource_parameter_bindings", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_parameter_bindings'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceRole__resource_parameter_bindings, domain=None, range=Optional[Union[Union[dict, BpmnResourceParameterBinding], list[Union[dict, BpmnResourceParameterBinding]]]])

slots.bpmnResourceRole__resource_assignment_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_assignment_expression, name="bpmnResourceRole__resource_assignment_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_assignment_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnResourceRole__resource_assignment_expression, domain=None, range=Optional[Union[dict, BpmnResourceAssignmentExpression]])

slots.bpmnScript__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="bpmnScript__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnScript__text_content, domain=None, range=Optional[str])

slots.bpmnScriptTask__script_format = Slot(uri=FLUXNOVA_BPM_PLATFORM.script_format, name="bpmnScriptTask__script_format", curie=FLUXNOVA_BPM_PLATFORM.curie('script_format'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnScriptTask__script_format, domain=None, range=Optional[str])

slots.bpmnScriptTask__fluxnova_result_variable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_result_variable, name="bpmnScriptTask__fluxnova_result_variable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_result_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnScriptTask__fluxnova_result_variable, domain=None, range=Optional[str])

slots.bpmnScriptTask__fluxnova_resource = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_resource, name="bpmnScriptTask__fluxnova_resource", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_resource'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnScriptTask__fluxnova_resource, domain=None, range=Optional[str])

slots.bpmnScriptTask__script = Slot(uri=FLUXNOVA_BPM_PLATFORM.script, name="bpmnScriptTask__script", curie=FLUXNOVA_BPM_PLATFORM.curie('script'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnScriptTask__script, domain=None, range=Optional[Union[dict, BpmnScript]])

slots.bpmnSendTask__implementation = Slot(uri=FLUXNOVA_BPM_PLATFORM.implementation, name="bpmnSendTask__implementation", curie=FLUXNOVA_BPM_PLATFORM.curie('implementation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__implementation, domain=None, range=Optional[str])

slots.bpmnSendTask__message_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_ref, name="bpmnSendTask__message_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('message_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__message_ref, domain=None, range=Optional[str])

slots.bpmnSendTask__operation_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_ref, name="bpmnSendTask__operation_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__operation_ref, domain=None, range=Optional[str])

slots.bpmnSendTask__fluxnova_class = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_class, name="bpmnSendTask__fluxnova_class", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__fluxnova_class, domain=None, range=Optional[str])

slots.bpmnSendTask__fluxnova_delegate_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_delegate_expression, name="bpmnSendTask__fluxnova_delegate_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_delegate_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__fluxnova_delegate_expression, domain=None, range=Optional[str])

slots.bpmnSendTask__fluxnova_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, name="bpmnSendTask__fluxnova_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__fluxnova_expression, domain=None, range=Optional[str])

slots.bpmnSendTask__fluxnova_result_variable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_result_variable, name="bpmnSendTask__fluxnova_result_variable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_result_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__fluxnova_result_variable, domain=None, range=Optional[str])

slots.bpmnSendTask__fluxnova_topic = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_topic, name="bpmnSendTask__fluxnova_topic", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_topic'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__fluxnova_topic, domain=None, range=Optional[str])

slots.bpmnSendTask__fluxnova_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_type, name="bpmnSendTask__fluxnova_type", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__fluxnova_type, domain=None, range=Optional[str])

slots.bpmnSendTask__fluxnova_task_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_task_priority, name="bpmnSendTask__fluxnova_task_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_task_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSendTask__fluxnova_task_priority, domain=None, range=Optional[str])

slots.bpmnSequenceFlow__source_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.source_ref, name="bpmnSequenceFlow__source_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('source_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSequenceFlow__source_ref, domain=None, range=str)

slots.bpmnSequenceFlow__target_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.target_ref, name="bpmnSequenceFlow__target_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('target_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSequenceFlow__target_ref, domain=None, range=str)

slots.bpmnSequenceFlow__is_immediate = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_immediate, name="bpmnSequenceFlow__is_immediate", curie=FLUXNOVA_BPM_PLATFORM.curie('is_immediate'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSequenceFlow__is_immediate, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnSequenceFlow__condition_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.condition_expression, name="bpmnSequenceFlow__condition_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('condition_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSequenceFlow__condition_expression, domain=None, range=Optional[Union[dict, BpmnConditionExpression]])

slots.bpmnServiceTask__implementation = Slot(uri=FLUXNOVA_BPM_PLATFORM.implementation, name="bpmnServiceTask__implementation", curie=FLUXNOVA_BPM_PLATFORM.curie('implementation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnServiceTask__implementation, domain=None, range=Optional[str])

slots.bpmnServiceTask__operation_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_ref, name="bpmnServiceTask__operation_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnServiceTask__operation_ref, domain=None, range=Optional[str])

slots.bpmnServiceTask__fluxnova_class = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_class, name="bpmnServiceTask__fluxnova_class", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnServiceTask__fluxnova_class, domain=None, range=Optional[str])

slots.bpmnServiceTask__fluxnova_delegate_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_delegate_expression, name="bpmnServiceTask__fluxnova_delegate_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_delegate_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnServiceTask__fluxnova_delegate_expression, domain=None, range=Optional[str])

slots.bpmnServiceTask__fluxnova_expression = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_expression, name="bpmnServiceTask__fluxnova_expression", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_expression'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnServiceTask__fluxnova_expression, domain=None, range=Optional[str])

slots.bpmnServiceTask__fluxnova_result_variable = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_result_variable, name="bpmnServiceTask__fluxnova_result_variable", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_result_variable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnServiceTask__fluxnova_result_variable, domain=None, range=Optional[str])

slots.bpmnServiceTask__fluxnova_topic = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_topic, name="bpmnServiceTask__fluxnova_topic", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_topic'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnServiceTask__fluxnova_topic, domain=None, range=Optional[str])

slots.bpmnServiceTask__fluxnova_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_type, name="bpmnServiceTask__fluxnova_type", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnServiceTask__fluxnova_type, domain=None, range=Optional[str])

slots.bpmnServiceTask__fluxnova_task_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_task_priority, name="bpmnServiceTask__fluxnova_task_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_task_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnServiceTask__fluxnova_task_priority, domain=None, range=Optional[str])

slots.bpmnSignal__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="bpmnSignal__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSignal__name, domain=None, range=Optional[str])

slots.bpmnSignal__structure_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.structure_ref, name="bpmnSignal__structure_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('structure_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSignal__structure_ref, domain=None, range=Optional[str])

slots.bpmnSignalEventDefinition__signal_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.signal_ref, name="bpmnSignalEventDefinition__signal_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('signal_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSignalEventDefinition__signal_ref, domain=None, range=Optional[str])

slots.bpmnSignalEventDefinition__fluxnova_async = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async, name="bpmnSignalEventDefinition__fluxnova_async", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSignalEventDefinition__fluxnova_async, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnStartEvent__is_interrupting = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_interrupting, name="bpmnStartEvent__is_interrupting", curie=FLUXNOVA_BPM_PLATFORM.curie('is_interrupting'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnStartEvent__is_interrupting, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnStartEvent__fluxnova_async = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async, name="bpmnStartEvent__fluxnova_async", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnStartEvent__fluxnova_async, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnStartEvent__fluxnova_form_handler_class = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_handler_class, name="bpmnStartEvent__fluxnova_form_handler_class", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_handler_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnStartEvent__fluxnova_form_handler_class, domain=None, range=Optional[str])

slots.bpmnStartEvent__fluxnova_form_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_key, name="bpmnStartEvent__fluxnova_form_key", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnStartEvent__fluxnova_form_key, domain=None, range=Optional[str])

slots.bpmnStartEvent__fluxnova_form_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_ref, name="bpmnStartEvent__fluxnova_form_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnStartEvent__fluxnova_form_ref, domain=None, range=Optional[str])

slots.bpmnStartEvent__fluxnova_form_ref_binding = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_ref_binding, name="bpmnStartEvent__fluxnova_form_ref_binding", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_ref_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnStartEvent__fluxnova_form_ref_binding, domain=None, range=Optional[str])

slots.bpmnStartEvent__fluxnova_form_ref_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_ref_version, name="bpmnStartEvent__fluxnova_form_ref_version", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_ref_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnStartEvent__fluxnova_form_ref_version, domain=None, range=Optional[str])

slots.bpmnStartEvent__fluxnova_initiator = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_initiator, name="bpmnStartEvent__fluxnova_initiator", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_initiator'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnStartEvent__fluxnova_initiator, domain=None, range=Optional[str])

slots.bpmnSubConversation__conversation_nodes = Slot(uri=FLUXNOVA_BPM_PLATFORM.conversation_nodes, name="bpmnSubConversation__conversation_nodes", curie=FLUXNOVA_BPM_PLATFORM.curie('conversation_nodes'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSubConversation__conversation_nodes, domain=None, range=Optional[Union[Union[dict, BpmnConversationNode], list[Union[dict, BpmnConversationNode]]]])

slots.bpmnSubProcess__triggered_by_event = Slot(uri=FLUXNOVA_BPM_PLATFORM.triggered_by_event, name="bpmnSubProcess__triggered_by_event", curie=FLUXNOVA_BPM_PLATFORM.curie('triggered_by_event'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSubProcess__triggered_by_event, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnSubProcess__fluxnova_async = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async, name="bpmnSubProcess__fluxnova_async", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSubProcess__fluxnova_async, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnSubProcess__lane_sets = Slot(uri=FLUXNOVA_BPM_PLATFORM.lane_sets, name="bpmnSubProcess__lane_sets", curie=FLUXNOVA_BPM_PLATFORM.curie('lane_sets'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSubProcess__lane_sets, domain=None, range=Optional[Union[Union[dict, BpmnLaneSet], list[Union[dict, BpmnLaneSet]]]])

slots.bpmnSubProcess__flow_elements = Slot(uri=FLUXNOVA_BPM_PLATFORM.flow_elements, name="bpmnSubProcess__flow_elements", curie=FLUXNOVA_BPM_PLATFORM.curie('flow_elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSubProcess__flow_elements, domain=None, range=Optional[Union[Union[dict, BpmnFlowElement], list[Union[dict, BpmnFlowElement]]]])

slots.bpmnSubProcess__artifacts = Slot(uri=FLUXNOVA_BPM_PLATFORM.artifacts, name="bpmnSubProcess__artifacts", curie=FLUXNOVA_BPM_PLATFORM.curie('artifacts'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnSubProcess__artifacts, domain=None, range=Optional[Union[Union[dict, BpmnArtifact], list[Union[dict, BpmnArtifact]]]])

slots.bpmnTask__fluxnova_async = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_async, name="bpmnTask__fluxnova_async", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_async'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnTask__fluxnova_async, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnText__text_content = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_content, name="bpmnText__text_content", curie=FLUXNOVA_BPM_PLATFORM.curie('text_content'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnText__text_content, domain=None, range=Optional[str])

slots.bpmnTextAnnotation__text_format = Slot(uri=FLUXNOVA_BPM_PLATFORM.text_format, name="bpmnTextAnnotation__text_format", curie=FLUXNOVA_BPM_PLATFORM.curie('text_format'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnTextAnnotation__text_format, domain=None, range=Optional[str])

slots.bpmnTextAnnotation__text = Slot(uri=FLUXNOVA_BPM_PLATFORM.text, name="bpmnTextAnnotation__text", curie=FLUXNOVA_BPM_PLATFORM.curie('text'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnTextAnnotation__text, domain=None, range=Optional[Union[dict, BpmnText]])

slots.bpmnThrowEvent__data_inputs = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_inputs, name="bpmnThrowEvent__data_inputs", curie=FLUXNOVA_BPM_PLATFORM.curie('data_inputs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnThrowEvent__data_inputs, domain=None, range=Optional[Union[Union[dict, BpmnDataInput], list[Union[dict, BpmnDataInput]]]])

slots.bpmnThrowEvent__data_input_associations = Slot(uri=FLUXNOVA_BPM_PLATFORM.data_input_associations, name="bpmnThrowEvent__data_input_associations", curie=FLUXNOVA_BPM_PLATFORM.curie('data_input_associations'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnThrowEvent__data_input_associations, domain=None, range=Optional[Union[Union[dict, BpmnDataInputAssociation], list[Union[dict, BpmnDataInputAssociation]]]])

slots.bpmnThrowEvent__input_set = Slot(uri=FLUXNOVA_BPM_PLATFORM.input_set, name="bpmnThrowEvent__input_set", curie=FLUXNOVA_BPM_PLATFORM.curie('input_set'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnThrowEvent__input_set, domain=None, range=Optional[Union[dict, BpmnInputSet]])

slots.bpmnThrowEvent__event_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_definitions, name="bpmnThrowEvent__event_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('event_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnThrowEvent__event_definitions, domain=None, range=Optional[Union[Union[dict, BpmnEventDefinition], list[Union[dict, BpmnEventDefinition]]]])

slots.bpmnThrowEvent__event_definition_refs = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_definition_refs, name="bpmnThrowEvent__event_definition_refs", curie=FLUXNOVA_BPM_PLATFORM.curie('event_definition_refs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnThrowEvent__event_definition_refs, domain=None, range=Optional[Union[str, list[str]]])

slots.bpmnTimerEventDefinition__time_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.time_date, name="bpmnTimerEventDefinition__time_date", curie=FLUXNOVA_BPM_PLATFORM.curie('time_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnTimerEventDefinition__time_date, domain=None, range=Optional[Union[dict, BpmnTimeDate]])

slots.bpmnTimerEventDefinition__time_duration = Slot(uri=FLUXNOVA_BPM_PLATFORM.time_duration, name="bpmnTimerEventDefinition__time_duration", curie=FLUXNOVA_BPM_PLATFORM.curie('time_duration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnTimerEventDefinition__time_duration, domain=None, range=Optional[Union[dict, BpmnTimeDuration]])

slots.bpmnTimerEventDefinition__time_cycle = Slot(uri=FLUXNOVA_BPM_PLATFORM.time_cycle, name="bpmnTimerEventDefinition__time_cycle", curie=FLUXNOVA_BPM_PLATFORM.curie('time_cycle'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnTimerEventDefinition__time_cycle, domain=None, range=Optional[Union[dict, BpmnTimeCycle]])

slots.bpmnTransaction__method = Slot(uri=FLUXNOVA_BPM_PLATFORM.method, name="bpmnTransaction__method", curie=FLUXNOVA_BPM_PLATFORM.curie('method'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnTransaction__method, domain=None, range=Optional[Union[str, "BpmnTransactionMethod"]])

slots.bpmnUserTask__implementation = Slot(uri=FLUXNOVA_BPM_PLATFORM.implementation, name="bpmnUserTask__implementation", curie=FLUXNOVA_BPM_PLATFORM.curie('implementation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__implementation, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_assignee = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_assignee, name="bpmnUserTask__fluxnova_assignee", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_assignee'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_assignee, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_candidate_groups = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_groups, name="bpmnUserTask__fluxnova_candidate_groups", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_candidate_groups'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_candidate_groups, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_candidate_users = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_candidate_users, name="bpmnUserTask__fluxnova_candidate_users", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_candidate_users'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_candidate_users, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_due_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_due_date, name="bpmnUserTask__fluxnova_due_date", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_due_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_due_date, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_follow_up_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_follow_up_date, name="bpmnUserTask__fluxnova_follow_up_date", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_follow_up_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_follow_up_date, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_form_handler_class = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_handler_class, name="bpmnUserTask__fluxnova_form_handler_class", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_handler_class'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_form_handler_class, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_form_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_key, name="bpmnUserTask__fluxnova_form_key", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_form_key, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_form_ref = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_ref, name="bpmnUserTask__fluxnova_form_ref", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_ref'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_form_ref, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_form_ref_binding = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_ref_binding, name="bpmnUserTask__fluxnova_form_ref_binding", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_ref_binding'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_form_ref_binding, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_form_ref_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_form_ref_version, name="bpmnUserTask__fluxnova_form_ref_version", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_form_ref_version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_form_ref_version, domain=None, range=Optional[str])

slots.bpmnUserTask__fluxnova_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.fluxnova_priority, name="bpmnUserTask__fluxnova_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('fluxnova_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__fluxnova_priority, domain=None, range=Optional[str])

slots.bpmnUserTask__renderings = Slot(uri=FLUXNOVA_BPM_PLATFORM.renderings, name="bpmnUserTask__renderings", curie=FLUXNOVA_BPM_PLATFORM.curie('renderings'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnUserTask__renderings, domain=None, range=Optional[Union[Union[dict, BpmnRendering], list[Union[dict, BpmnRendering]]]])

slots.bpmnDiagram__bpmn_plane = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_plane, name="bpmnDiagram__bpmn_plane", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_plane'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDiagram__bpmn_plane, domain=None, range=Union[dict, BpmnPlane])

slots.bpmnDiagram__bpmn_label_styles = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_label_styles, name="bpmnDiagram__bpmn_label_styles", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_label_styles'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnDiagram__bpmn_label_styles, domain=None, range=Optional[Union[Union[dict, BpmnLabelStyle], list[Union[dict, BpmnLabelStyle]]]])

slots.bpmnEdge__bpmn_element = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_element, name="bpmnEdge__bpmn_element", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEdge__bpmn_element, domain=None, range=Optional[str])

slots.bpmnEdge__source_element = Slot(uri=FLUXNOVA_BPM_PLATFORM.source_element, name="bpmnEdge__source_element", curie=FLUXNOVA_BPM_PLATFORM.curie('source_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEdge__source_element, domain=None, range=Optional[str])

slots.bpmnEdge__target_element = Slot(uri=FLUXNOVA_BPM_PLATFORM.target_element, name="bpmnEdge__target_element", curie=FLUXNOVA_BPM_PLATFORM.curie('target_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEdge__target_element, domain=None, range=Optional[str])

slots.bpmnEdge__message_visible_kind = Slot(uri=FLUXNOVA_BPM_PLATFORM.message_visible_kind, name="bpmnEdge__message_visible_kind", curie=FLUXNOVA_BPM_PLATFORM.curie('message_visible_kind'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEdge__message_visible_kind, domain=None, range=Optional[Union[str, "BpmnMessageVisibleKind"]])

slots.bpmnEdge__bpmn_label = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_label, name="bpmnEdge__bpmn_label", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_label'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnEdge__bpmn_label, domain=None, range=Optional[Union[dict, BpmnLabel]])

slots.bpmnLabel__label_style = Slot(uri=FLUXNOVA_BPM_PLATFORM.label_style, name="bpmnLabel__label_style", curie=FLUXNOVA_BPM_PLATFORM.curie('label_style'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLabel__label_style, domain=None, range=Optional[str])

slots.bpmnLabelStyle__font = Slot(uri=FLUXNOVA_BPM_PLATFORM.font, name="bpmnLabelStyle__font", curie=FLUXNOVA_BPM_PLATFORM.curie('font'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnLabelStyle__font, domain=None, range=Union[dict, DcFont])

slots.bpmnPlane__bpmn_element = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_element, name="bpmnPlane__bpmn_element", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnPlane__bpmn_element, domain=None, range=Optional[str])

slots.bpmnShape__bpmn_element = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_element, name="bpmnShape__bpmn_element", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_element'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnShape__bpmn_element, domain=None, range=Optional[str])

slots.bpmnShape__is_horizontal = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_horizontal, name="bpmnShape__is_horizontal", curie=FLUXNOVA_BPM_PLATFORM.curie('is_horizontal'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnShape__is_horizontal, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnShape__is_expanded = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_expanded, name="bpmnShape__is_expanded", curie=FLUXNOVA_BPM_PLATFORM.curie('is_expanded'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnShape__is_expanded, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnShape__is_marker_visible = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_marker_visible, name="bpmnShape__is_marker_visible", curie=FLUXNOVA_BPM_PLATFORM.curie('is_marker_visible'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnShape__is_marker_visible, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnShape__is_message_visible = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_message_visible, name="bpmnShape__is_message_visible", curie=FLUXNOVA_BPM_PLATFORM.curie('is_message_visible'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnShape__is_message_visible, domain=None, range=Optional[Union[bool, Bool]])

slots.bpmnShape__participant_band_kind = Slot(uri=FLUXNOVA_BPM_PLATFORM.participant_band_kind, name="bpmnShape__participant_band_kind", curie=FLUXNOVA_BPM_PLATFORM.curie('participant_band_kind'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnShape__participant_band_kind, domain=None, range=Optional[Union[str, "BpmnParticipantBandKind"]])

slots.bpmnShape__choreography_activity_shape = Slot(uri=FLUXNOVA_BPM_PLATFORM.choreography_activity_shape, name="bpmnShape__choreography_activity_shape", curie=FLUXNOVA_BPM_PLATFORM.curie('choreography_activity_shape'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnShape__choreography_activity_shape, domain=None, range=Optional[str])

slots.bpmnShape__bpmn_label = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_label, name="bpmnShape__bpmn_label", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_label'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnShape__bpmn_label, domain=None, range=Optional[Union[dict, BpmnLabel]])

slots.diDiagram__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="diDiagram__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diDiagram__name, domain=None, range=Optional[str])

slots.diDiagram__bpmn_documentation = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_documentation, name="diDiagram__bpmn_documentation", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_documentation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diDiagram__bpmn_documentation, domain=None, range=Optional[str])

slots.diDiagram__resolution = Slot(uri=FLUXNOVA_BPM_PLATFORM.resolution, name="diDiagram__resolution", curie=FLUXNOVA_BPM_PLATFORM.curie('resolution'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diDiagram__resolution, domain=None, range=Optional[float])

slots.diDiagram__bpmn_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_id, name="diDiagram__bpmn_id", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diDiagram__bpmn_id, domain=None, range=Optional[str])

slots.diDiagramElement__bpmn_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_id, name="diDiagramElement__bpmn_id", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diDiagramElement__bpmn_id, domain=None, range=Optional[str])

slots.diDiagramElement__extension = Slot(uri=FLUXNOVA_BPM_PLATFORM.extension, name="diDiagramElement__extension", curie=FLUXNOVA_BPM_PLATFORM.curie('extension'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diDiagramElement__extension, domain=None, range=Optional[Union[dict, DiExtension]])

slots.diEdge__waypoints = Slot(uri=FLUXNOVA_BPM_PLATFORM.waypoints, name="diEdge__waypoints", curie=FLUXNOVA_BPM_PLATFORM.curie('waypoints'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diEdge__waypoints, domain=None, range=Union[Union[dict, DiWaypoint], list[Union[dict, DiWaypoint]]])

slots.diLabel__bounds = Slot(uri=FLUXNOVA_BPM_PLATFORM.bounds, name="diLabel__bounds", curie=FLUXNOVA_BPM_PLATFORM.curie('bounds'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diLabel__bounds, domain=None, range=Optional[Union[dict, DcBounds]])

slots.diPlane__diagram_elements = Slot(uri=FLUXNOVA_BPM_PLATFORM.diagram_elements, name="diPlane__diagram_elements", curie=FLUXNOVA_BPM_PLATFORM.curie('diagram_elements'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diPlane__diagram_elements, domain=None, range=Optional[Union[Union[dict, DiDiagramElement], list[Union[dict, DiDiagramElement]]]])

slots.diShape__bounds = Slot(uri=FLUXNOVA_BPM_PLATFORM.bounds, name="diShape__bounds", curie=FLUXNOVA_BPM_PLATFORM.curie('bounds'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diShape__bounds, domain=None, range=Union[dict, DcBounds])

slots.diStyle__bpmn_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.bpmn_id, name="diStyle__bpmn_id", curie=FLUXNOVA_BPM_PLATFORM.curie('bpmn_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.diStyle__bpmn_id, domain=None, range=Optional[str])

slots.dcBounds__x = Slot(uri=FLUXNOVA_BPM_PLATFORM.x, name="dcBounds__x", curie=FLUXNOVA_BPM_PLATFORM.curie('x'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcBounds__x, domain=None, range=float)

slots.dcBounds__y = Slot(uri=FLUXNOVA_BPM_PLATFORM.y, name="dcBounds__y", curie=FLUXNOVA_BPM_PLATFORM.curie('y'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcBounds__y, domain=None, range=float)

slots.dcBounds__width = Slot(uri=FLUXNOVA_BPM_PLATFORM.width, name="dcBounds__width", curie=FLUXNOVA_BPM_PLATFORM.curie('width'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcBounds__width, domain=None, range=float)

slots.dcBounds__height = Slot(uri=FLUXNOVA_BPM_PLATFORM.height, name="dcBounds__height", curie=FLUXNOVA_BPM_PLATFORM.curie('height'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcBounds__height, domain=None, range=float)

slots.dcFont__name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="dcFont__name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcFont__name, domain=None, range=Optional[str])

slots.dcFont__size = Slot(uri=FLUXNOVA_BPM_PLATFORM.size, name="dcFont__size", curie=FLUXNOVA_BPM_PLATFORM.curie('size'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcFont__size, domain=None, range=Optional[float])

slots.dcFont__is_bold = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_bold, name="dcFont__is_bold", curie=FLUXNOVA_BPM_PLATFORM.curie('is_bold'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcFont__is_bold, domain=None, range=Optional[Union[bool, Bool]])

slots.dcFont__is_italic = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_italic, name="dcFont__is_italic", curie=FLUXNOVA_BPM_PLATFORM.curie('is_italic'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcFont__is_italic, domain=None, range=Optional[Union[bool, Bool]])

slots.dcFont__is_underline = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_underline, name="dcFont__is_underline", curie=FLUXNOVA_BPM_PLATFORM.curie('is_underline'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcFont__is_underline, domain=None, range=Optional[Union[bool, Bool]])

slots.dcFont__is_strike_through = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_strike_through, name="dcFont__is_strike_through", curie=FLUXNOVA_BPM_PLATFORM.curie('is_strike_through'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcFont__is_strike_through, domain=None, range=Optional[Union[bool, Bool]])

slots.dcPoint__x = Slot(uri=FLUXNOVA_BPM_PLATFORM.x, name="dcPoint__x", curie=FLUXNOVA_BPM_PLATFORM.curie('x'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcPoint__x, domain=None, range=float)

slots.dcPoint__y = Slot(uri=FLUXNOVA_BPM_PLATFORM.y, name="dcPoint__y", curie=FLUXNOVA_BPM_PLATFORM.curie('y'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.dcPoint__y, domain=None, range=float)

slots.bpmnModelElementInstance__element_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.element_type, name="bpmnModelElementInstance__element_type", curie=FLUXNOVA_BPM_PLATFORM.curie('element_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.bpmnModelElementInstance__element_type, domain=None, range=Optional[str])

slots.FluxnovaPlatformData_attachments = Slot(uri=FLUXNOVA_BPM_PLATFORM.attachments, name="FluxnovaPlatformData_attachments", curie=FLUXNOVA_BPM_PLATFORM.curie('attachments'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_attachments, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaAttachmentId], Union[dict, "FluxnovaAttachment"]], list[Union[dict, "FluxnovaAttachment"]]]])

slots.FluxnovaPlatformData_authorization_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.authorization_entries, name="FluxnovaPlatformData_authorization_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('authorization_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_authorization_entries, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaAuthorizationId], Union[dict, "FluxnovaAuthorization"]], list[Union[dict, "FluxnovaAuthorization"]]]])

slots.FluxnovaPlatformData_batches = Slot(uri=FLUXNOVA_BPM_PLATFORM.batches, name="FluxnovaPlatformData_batches", curie=FLUXNOVA_BPM_PLATFORM.curie('batches'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_batches, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaBatchId], Union[dict, "FluxnovaBatch"]], list[Union[dict, "FluxnovaBatch"]]]])

slots.FluxnovaPlatformData_byte_arrays = Slot(uri=FLUXNOVA_BPM_PLATFORM.byte_arrays, name="FluxnovaPlatformData_byte_arrays", curie=FLUXNOVA_BPM_PLATFORM.curie('byte_arrays'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_byte_arrays, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaByteArrayId], Union[dict, "FluxnovaByteArray"]], list[Union[dict, "FluxnovaByteArray"]]]])

slots.FluxnovaPlatformData_case_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definitions, name="FluxnovaPlatformData_case_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_case_definitions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaCaseDefinitionId], Union[dict, "FluxnovaCaseDefinition"]], list[Union[dict, "FluxnovaCaseDefinition"]]]])

slots.FluxnovaPlatformData_case_executions = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_executions, name="FluxnovaPlatformData_case_executions", curie=FLUXNOVA_BPM_PLATFORM.curie('case_executions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_case_executions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaCaseExecutionId], Union[dict, "FluxnovaCaseExecution"]], list[Union[dict, "FluxnovaCaseExecution"]]]])

slots.FluxnovaPlatformData_case_sentry_parts = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_sentry_parts, name="FluxnovaPlatformData_case_sentry_parts", curie=FLUXNOVA_BPM_PLATFORM.curie('case_sentry_parts'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_case_sentry_parts, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaCaseSentryPartId], Union[dict, "FluxnovaCaseSentryPart"]], list[Union[dict, "FluxnovaCaseSentryPart"]]]])

slots.FluxnovaPlatformData_comment_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.comment_entries, name="FluxnovaPlatformData_comment_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('comment_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_comment_entries, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaCommentId], Union[dict, "FluxnovaComment"]], list[Union[dict, "FluxnovaComment"]]]])

slots.FluxnovaPlatformData_configuration_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.configuration_entries, name="FluxnovaPlatformData_configuration_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('configuration_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_configuration_entries, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaConfigurationId], Union[dict, "FluxnovaConfiguration"]], list[Union[dict, "FluxnovaConfiguration"]]]])

slots.FluxnovaPlatformData_decision_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_definitions, name="FluxnovaPlatformData_decision_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_decision_definitions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaDecisionDefinitionId], Union[dict, "FluxnovaDecisionDefinition"]], list[Union[dict, "FluxnovaDecisionDefinition"]]]])

slots.FluxnovaPlatformData_decision_requirements_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definitions, name="FluxnovaPlatformData_decision_requirements_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_requirements_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_decision_requirements_definitions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaDecisionRequirementsDefinitionId], Union[dict, "FluxnovaDecisionRequirementsDefinition"]], list[Union[dict, "FluxnovaDecisionRequirementsDefinition"]]]])

slots.FluxnovaPlatformData_deployments = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployments, name="FluxnovaPlatformData_deployments", curie=FLUXNOVA_BPM_PLATFORM.curie('deployments'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_deployments, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaDeploymentId], Union[dict, "FluxnovaDeployment"]], list[Union[dict, "FluxnovaDeployment"]]]])

slots.FluxnovaPlatformData_engine_properties = Slot(uri=FLUXNOVA_BPM_PLATFORM.engine_properties, name="FluxnovaPlatformData_engine_properties", curie=FLUXNOVA_BPM_PLATFORM.curie('engine_properties'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_engine_properties, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaEnginePropertyName], Union[dict, "FluxnovaEngineProperty"]], list[Union[dict, "FluxnovaEngineProperty"]]]])

slots.FluxnovaPlatformData_event_subscriptions = Slot(uri=FLUXNOVA_BPM_PLATFORM.event_subscriptions, name="FluxnovaPlatformData_event_subscriptions", curie=FLUXNOVA_BPM_PLATFORM.curie('event_subscriptions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_event_subscriptions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaEventSubscriptionId], Union[dict, "FluxnovaEventSubscription"]], list[Union[dict, "FluxnovaEventSubscription"]]]])

slots.FluxnovaPlatformData_executions = Slot(uri=FLUXNOVA_BPM_PLATFORM.executions, name="FluxnovaPlatformData_executions", curie=FLUXNOVA_BPM_PLATFORM.curie('executions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_executions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaExecutionId], Union[dict, "FluxnovaExecution"]], list[Union[dict, "FluxnovaExecution"]]]])

slots.FluxnovaPlatformData_external_tasks = Slot(uri=FLUXNOVA_BPM_PLATFORM.external_tasks, name="FluxnovaPlatformData_external_tasks", curie=FLUXNOVA_BPM_PLATFORM.curie('external_tasks'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_external_tasks, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaExternalTaskId], Union[dict, "FluxnovaExternalTask"]], list[Union[dict, "FluxnovaExternalTask"]]]])

slots.FluxnovaPlatformData_filter_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.filter_entries, name="FluxnovaPlatformData_filter_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('filter_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_filter_entries, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaFilterId], Union[dict, "FluxnovaFilter"]], list[Union[dict, "FluxnovaFilter"]]]])

slots.FluxnovaPlatformData_form_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.form_definitions, name="FluxnovaPlatformData_form_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('form_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_form_definitions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaFormDefinitionId], Union[dict, "FluxnovaFormDefinition"]], list[Union[dict, "FluxnovaFormDefinition"]]]])

slots.FluxnovaPlatformData_groups = Slot(uri=FLUXNOVA_BPM_PLATFORM.groups, name="FluxnovaPlatformData_groups", curie=FLUXNOVA_BPM_PLATFORM.curie('groups'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_groups, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaGroupId], Union[dict, "FluxnovaGroup"]], list[Union[dict, "FluxnovaGroup"]]]])

slots.FluxnovaPlatformData_historic_activity_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_activity_instances, name="FluxnovaPlatformData_historic_activity_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_activity_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_activity_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricActivityInstanceId], Union[dict, "FluxnovaHistoricActivityInstance"]], list[Union[dict, "FluxnovaHistoricActivityInstance"]]]])

slots.FluxnovaPlatformData_historic_batches = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_batches, name="FluxnovaPlatformData_historic_batches", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_batches'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_batches, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricBatchId], Union[dict, "FluxnovaHistoricBatch"]], list[Union[dict, "FluxnovaHistoricBatch"]]]])

slots.FluxnovaPlatformData_historic_case_activity_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_case_activity_instances, name="FluxnovaPlatformData_historic_case_activity_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_case_activity_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_case_activity_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricCaseActivityInstanceId], Union[dict, "FluxnovaHistoricCaseActivityInstance"]], list[Union[dict, "FluxnovaHistoricCaseActivityInstance"]]]])

slots.FluxnovaPlatformData_historic_case_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_case_instances, name="FluxnovaPlatformData_historic_case_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_case_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_case_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricCaseInstanceId], Union[dict, "FluxnovaHistoricCaseInstance"]], list[Union[dict, "FluxnovaHistoricCaseInstance"]]]])

slots.FluxnovaPlatformData_historic_decision_input_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_decision_input_instances, name="FluxnovaPlatformData_historic_decision_input_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_decision_input_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_decision_input_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricDecisionInputInstanceId], Union[dict, "FluxnovaHistoricDecisionInputInstance"]], list[Union[dict, "FluxnovaHistoricDecisionInputInstance"]]]])

slots.FluxnovaPlatformData_historic_decision_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_decision_instances, name="FluxnovaPlatformData_historic_decision_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_decision_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_decision_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricDecisionInstanceId], Union[dict, "FluxnovaHistoricDecisionInstance"]], list[Union[dict, "FluxnovaHistoricDecisionInstance"]]]])

slots.FluxnovaPlatformData_historic_decision_output_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_decision_output_instances, name="FluxnovaPlatformData_historic_decision_output_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_decision_output_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_decision_output_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricDecisionOutputInstanceId], Union[dict, "FluxnovaHistoricDecisionOutputInstance"]], list[Union[dict, "FluxnovaHistoricDecisionOutputInstance"]]]])

slots.FluxnovaPlatformData_historic_details = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_details, name="FluxnovaPlatformData_historic_details", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_details'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_details, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricDetailId], Union[dict, "FluxnovaHistoricDetail"]], list[Union[dict, "FluxnovaHistoricDetail"]]]])

slots.FluxnovaPlatformData_historic_external_task_logs = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_external_task_logs, name="FluxnovaPlatformData_historic_external_task_logs", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_external_task_logs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_external_task_logs, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricExternalTaskLogId], Union[dict, "FluxnovaHistoricExternalTaskLog"]], list[Union[dict, "FluxnovaHistoricExternalTaskLog"]]]])

slots.FluxnovaPlatformData_historic_identity_links = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_identity_links, name="FluxnovaPlatformData_historic_identity_links", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_identity_links'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_identity_links, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricIdentityLinkId], Union[dict, "FluxnovaHistoricIdentityLink"]], list[Union[dict, "FluxnovaHistoricIdentityLink"]]]])

slots.FluxnovaPlatformData_historic_incidents = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_incidents, name="FluxnovaPlatformData_historic_incidents", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_incidents'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_incidents, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricIncidentId], Union[dict, "FluxnovaHistoricIncident"]], list[Union[dict, "FluxnovaHistoricIncident"]]]])

slots.FluxnovaPlatformData_historic_job_logs = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_job_logs, name="FluxnovaPlatformData_historic_job_logs", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_job_logs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_job_logs, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricJobLogId], Union[dict, "FluxnovaHistoricJobLog"]], list[Union[dict, "FluxnovaHistoricJobLog"]]]])

slots.FluxnovaPlatformData_historic_process_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_process_instances, name="FluxnovaPlatformData_historic_process_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_process_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_process_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricProcessInstanceId], Union[dict, "FluxnovaHistoricProcessInstance"]], list[Union[dict, "FluxnovaHistoricProcessInstance"]]]])

slots.FluxnovaPlatformData_historic_task_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_task_instances, name="FluxnovaPlatformData_historic_task_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_task_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_task_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricTaskInstanceId], Union[dict, "FluxnovaHistoricTaskInstance"]], list[Union[dict, "FluxnovaHistoricTaskInstance"]]]])

slots.FluxnovaPlatformData_historic_variable_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.historic_variable_instances, name="FluxnovaPlatformData_historic_variable_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('historic_variable_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_historic_variable_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaHistoricVariableInstanceId], Union[dict, "FluxnovaHistoricVariableInstance"]], list[Union[dict, "FluxnovaHistoricVariableInstance"]]]])

slots.FluxnovaPlatformData_identity_infos = Slot(uri=FLUXNOVA_BPM_PLATFORM.identity_infos, name="FluxnovaPlatformData_identity_infos", curie=FLUXNOVA_BPM_PLATFORM.curie('identity_infos'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_identity_infos, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaIdentityInfoId], Union[dict, "FluxnovaIdentityInfo"]], list[Union[dict, "FluxnovaIdentityInfo"]]]])

slots.FluxnovaPlatformData_identity_links = Slot(uri=FLUXNOVA_BPM_PLATFORM.identity_links, name="FluxnovaPlatformData_identity_links", curie=FLUXNOVA_BPM_PLATFORM.curie('identity_links'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_identity_links, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaIdentityLinkId], Union[dict, "FluxnovaIdentityLink"]], list[Union[dict, "FluxnovaIdentityLink"]]]])

slots.FluxnovaPlatformData_incidents = Slot(uri=FLUXNOVA_BPM_PLATFORM.incidents, name="FluxnovaPlatformData_incidents", curie=FLUXNOVA_BPM_PLATFORM.curie('incidents'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_incidents, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaIncidentId], Union[dict, "FluxnovaIncident"]], list[Union[dict, "FluxnovaIncident"]]]])

slots.FluxnovaPlatformData_job_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definitions, name="FluxnovaPlatformData_job_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_job_definitions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaJobDefinitionId], Union[dict, "FluxnovaJobDefinition"]], list[Union[dict, "FluxnovaJobDefinition"]]]])

slots.FluxnovaPlatformData_jobs = Slot(uri=FLUXNOVA_BPM_PLATFORM.jobs, name="FluxnovaPlatformData_jobs", curie=FLUXNOVA_BPM_PLATFORM.curie('jobs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_jobs, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaJobId], Union[dict, "FluxnovaJob"]], list[Union[dict, "FluxnovaJob"]]]])

slots.FluxnovaPlatformData_memberships = Slot(uri=FLUXNOVA_BPM_PLATFORM.memberships, name="FluxnovaPlatformData_memberships", curie=FLUXNOVA_BPM_PLATFORM.curie('memberships'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_memberships, domain=FluxnovaPlatformData, range=Optional[Union[Union[dict, "FluxnovaMembership"], list[Union[dict, "FluxnovaMembership"]]]])

slots.FluxnovaPlatformData_meter_logs = Slot(uri=FLUXNOVA_BPM_PLATFORM.meter_logs, name="FluxnovaPlatformData_meter_logs", curie=FLUXNOVA_BPM_PLATFORM.curie('meter_logs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_meter_logs, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaMeterLogId], Union[dict, "FluxnovaMeterLog"]], list[Union[dict, "FluxnovaMeterLog"]]]])

slots.FluxnovaPlatformData_process_definitions = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definitions, name="FluxnovaPlatformData_process_definitions", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definitions'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_process_definitions, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaProcessDefinitionId], Union[dict, "FluxnovaProcessDefinition"]], list[Union[dict, "FluxnovaProcessDefinition"]]]])

slots.FluxnovaPlatformData_schema_log_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.schema_log_entries, name="FluxnovaPlatformData_schema_log_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('schema_log_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_schema_log_entries, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaSchemaLogEntryId], Union[dict, "FluxnovaSchemaLogEntry"]], list[Union[dict, "FluxnovaSchemaLogEntry"]]]])

slots.FluxnovaPlatformData_task_meter_logs = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_meter_logs, name="FluxnovaPlatformData_task_meter_logs", curie=FLUXNOVA_BPM_PLATFORM.curie('task_meter_logs'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_task_meter_logs, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaTaskMeterLogId], Union[dict, "FluxnovaTaskMeterLog"]], list[Union[dict, "FluxnovaTaskMeterLog"]]]])

slots.FluxnovaPlatformData_tasks = Slot(uri=FLUXNOVA_BPM_PLATFORM.tasks, name="FluxnovaPlatformData_tasks", curie=FLUXNOVA_BPM_PLATFORM.curie('tasks'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_tasks, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaTaskId], Union[dict, "FluxnovaTask"]], list[Union[dict, "FluxnovaTask"]]]])

slots.FluxnovaPlatformData_tenant_memberships = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_memberships, name="FluxnovaPlatformData_tenant_memberships", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_memberships'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_tenant_memberships, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaTenantMembershipId], Union[dict, "FluxnovaTenantMembership"]], list[Union[dict, "FluxnovaTenantMembership"]]]])

slots.FluxnovaPlatformData_tenants = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenants, name="FluxnovaPlatformData_tenants", curie=FLUXNOVA_BPM_PLATFORM.curie('tenants'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_tenants, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaTenantId], Union[dict, "FluxnovaTenant"]], list[Union[dict, "FluxnovaTenant"]]]])

slots.FluxnovaPlatformData_user_operation_log_entries = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_operation_log_entries, name="FluxnovaPlatformData_user_operation_log_entries", curie=FLUXNOVA_BPM_PLATFORM.curie('user_operation_log_entries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_user_operation_log_entries, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaUserOperationLogEntryId], Union[dict, "FluxnovaUserOperationLogEntry"]], list[Union[dict, "FluxnovaUserOperationLogEntry"]]]])

slots.FluxnovaPlatformData_users = Slot(uri=FLUXNOVA_BPM_PLATFORM.users, name="FluxnovaPlatformData_users", curie=FLUXNOVA_BPM_PLATFORM.curie('users'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_users, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaUserId], Union[dict, "FluxnovaUser"]], list[Union[dict, "FluxnovaUser"]]]])

slots.FluxnovaPlatformData_variable_instances = Slot(uri=FLUXNOVA_BPM_PLATFORM.variable_instances, name="FluxnovaPlatformData_variable_instances", curie=FLUXNOVA_BPM_PLATFORM.curie('variable_instances'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaPlatformData_variable_instances, domain=FluxnovaPlatformData, range=Optional[Union[dict[Union[str, FluxnovaVariableInstanceId], Union[dict, "FluxnovaVariableInstance"]], list[Union[dict, "FluxnovaVariableInstance"]]]])

slots.FluxnovaAttachment_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaAttachment_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_id, domain=FluxnovaAttachment, range=Union[str, FluxnovaAttachmentId])

slots.FluxnovaAttachment_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaAttachment_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_name, domain=FluxnovaAttachment, range=Optional[str])

slots.FluxnovaAttachment_description = Slot(uri=FLUXNOVA_BPM_PLATFORM.description, name="FluxnovaAttachment_description", curie=FLUXNOVA_BPM_PLATFORM.curie('description'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_description, domain=FluxnovaAttachment, range=Optional[str])

slots.FluxnovaAttachment_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaAttachment_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_removal_time, domain=FluxnovaAttachment, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaAttachment_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaAttachment_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_root_process_instance_id, domain=FluxnovaAttachment, range=Optional[str])

slots.FluxnovaAttachment_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaAttachment_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_process_instance_id, domain=FluxnovaAttachment, range=Optional[str])

slots.FluxnovaAttachment_create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="FluxnovaAttachment_create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_create_time, domain=FluxnovaAttachment, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaAttachment_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaAttachment_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_task_id, domain=FluxnovaAttachment, range=Optional[str])

slots.FluxnovaAttachment_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="FluxnovaAttachment_type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_type, domain=FluxnovaAttachment, range=Optional[str])

slots.FluxnovaAttachment_created_by = Slot(uri=FLUXNOVA_BPM_PLATFORM.created_by, name="FluxnovaAttachment_created_by", curie=FLUXNOVA_BPM_PLATFORM.curie('created_by'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAttachment_created_by, domain=FluxnovaAttachment, range=Optional[str])

slots.FluxnovaAuthorization_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="FluxnovaAuthorization_type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAuthorization_type, domain=FluxnovaAuthorization, range=int)

slots.FluxnovaAuthorization_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaAuthorization_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAuthorization_removal_time, domain=FluxnovaAuthorization, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaAuthorization_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaAuthorization_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaAuthorization_root_process_instance_id, domain=FluxnovaAuthorization, range=Optional[str])

slots.FluxnovaBatch_seed_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.seed_job_definition_id, name="FluxnovaBatch_seed_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('seed_job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaBatch_seed_job_definition_id, domain=FluxnovaBatch, range=Optional[Union[str, FluxnovaJobDefinitionId]])

slots.FluxnovaBatch_batch_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.batch_job_definition_id, name="FluxnovaBatch_batch_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('batch_job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaBatch_batch_job_definition_id, domain=FluxnovaBatch, range=Optional[Union[str, FluxnovaJobDefinitionId]])

slots.FluxnovaBatch_monitor_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.monitor_job_definition_id, name="FluxnovaBatch_monitor_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('monitor_job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaBatch_monitor_job_definition_id, domain=FluxnovaBatch, range=Optional[Union[str, FluxnovaJobDefinitionId]])

slots.FluxnovaBatch_suspension_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.suspension_state, name="FluxnovaBatch_suspension_state", curie=FLUXNOVA_BPM_PLATFORM.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaBatch_suspension_state, domain=FluxnovaBatch, range=Optional[int])

slots.FluxnovaByteArray_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="FluxnovaByteArray_type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaByteArray_type, domain=FluxnovaByteArray, range=Optional[int])

slots.FluxnovaByteArray_deployment_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployment_id, name="FluxnovaByteArray_deployment_id", curie=FLUXNOVA_BPM_PLATFORM.curie('deployment_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaByteArray_deployment_id, domain=FluxnovaByteArray, range=Optional[Union[str, FluxnovaDeploymentId]])

slots.FluxnovaCaseDefinition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.key, name="FluxnovaCaseDefinition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseDefinition_key, domain=FluxnovaCaseDefinition, range=str)

slots.FluxnovaCaseDefinition_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.version, name="FluxnovaCaseDefinition_version", curie=FLUXNOVA_BPM_PLATFORM.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseDefinition_version, domain=FluxnovaCaseDefinition, range=int)

slots.FluxnovaCaseDefinition_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaCaseDefinition_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseDefinition_name, domain=FluxnovaCaseDefinition, range=Optional[str])

slots.FluxnovaCaseDefinition_category = Slot(uri=FLUXNOVA_BPM_PLATFORM.category, name="FluxnovaCaseDefinition_category", curie=FLUXNOVA_BPM_PLATFORM.curie('category'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseDefinition_category, domain=FluxnovaCaseDefinition, range=Optional[str])

slots.FluxnovaCaseExecution_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaCaseExecution_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseExecution_case_instance_id, domain=FluxnovaCaseExecution, range=Optional[Union[str, FluxnovaCaseExecutionId]])

slots.FluxnovaCaseExecution_parent_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.parent_id, name="FluxnovaCaseExecution_parent_id", curie=FLUXNOVA_BPM_PLATFORM.curie('parent_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseExecution_parent_id, domain=FluxnovaCaseExecution, range=Optional[Union[str, FluxnovaCaseExecutionId]])

slots.FluxnovaCaseExecution_case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="FluxnovaCaseExecution_case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseExecution_case_definition_id, domain=FluxnovaCaseExecution, range=Optional[Union[str, FluxnovaCaseDefinitionId]])

slots.FluxnovaCaseExecution_previous_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.previous_state, name="FluxnovaCaseExecution_previous_state", curie=FLUXNOVA_BPM_PLATFORM.curie('previous_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseExecution_previous_state, domain=FluxnovaCaseExecution, range=Optional[int])

slots.FluxnovaCaseExecution_current_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.current_state, name="FluxnovaCaseExecution_current_state", curie=FLUXNOVA_BPM_PLATFORM.curie('current_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseExecution_current_state, domain=FluxnovaCaseExecution, range=Optional[int])

slots.FluxnovaCaseExecution_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaCaseExecution_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseExecution_tenant_id, domain=FluxnovaCaseExecution, range=Optional[str])

slots.FluxnovaCaseSentryPart_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaCaseSentryPart_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseSentryPart_case_instance_id, domain=FluxnovaCaseSentryPart, range=Optional[Union[str, FluxnovaCaseExecutionId]])

slots.FluxnovaCaseSentryPart_case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, name="FluxnovaCaseSentryPart_case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaCaseSentryPart_case_execution_id, domain=FluxnovaCaseSentryPart, range=Optional[Union[str, FluxnovaCaseExecutionId]])

slots.FluxnovaComment_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaComment_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaComment_id, domain=FluxnovaComment, range=Union[str, FluxnovaCommentId])

slots.FluxnovaComment_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaComment_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaComment_removal_time, domain=FluxnovaComment, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaComment_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaComment_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaComment_root_process_instance_id, domain=FluxnovaComment, range=Optional[str])

slots.FluxnovaComment_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaComment_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaComment_process_instance_id, domain=FluxnovaComment, range=Optional[str])

slots.FluxnovaComment_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaComment_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaComment_task_id, domain=FluxnovaComment, range=Optional[str])

slots.FluxnovaComment_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_id, name="FluxnovaComment_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaComment_user_id, domain=FluxnovaComment, range=Optional[str])

slots.FluxnovaConfiguration_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.version, name="FluxnovaConfiguration_version", curie=FLUXNOVA_BPM_PLATFORM.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaConfiguration_version, domain=FluxnovaConfiguration, range=int)

slots.FluxnovaConfiguration_status = Slot(uri=FLUXNOVA_BPM_PLATFORM.status, name="FluxnovaConfiguration_status", curie=FLUXNOVA_BPM_PLATFORM.curie('status'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaConfiguration_status, domain=FluxnovaConfiguration, range=Union[str, "ConfigurationStatus"])

slots.FluxnovaDecisionDefinition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.key, name="FluxnovaDecisionDefinition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionDefinition_key, domain=FluxnovaDecisionDefinition, range=str)

slots.FluxnovaDecisionDefinition_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.version, name="FluxnovaDecisionDefinition_version", curie=FLUXNOVA_BPM_PLATFORM.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionDefinition_version, domain=FluxnovaDecisionDefinition, range=int)

slots.FluxnovaDecisionDefinition_decision_requirements_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_id, name="FluxnovaDecisionDefinition_decision_requirements_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_requirements_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionDefinition_decision_requirements_definition_id, domain=FluxnovaDecisionDefinition, range=Optional[Union[str, FluxnovaDecisionRequirementsDefinitionId]])

slots.FluxnovaDecisionDefinition_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaDecisionDefinition_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionDefinition_name, domain=FluxnovaDecisionDefinition, range=Optional[str])

slots.FluxnovaDecisionDefinition_category = Slot(uri=FLUXNOVA_BPM_PLATFORM.category, name="FluxnovaDecisionDefinition_category", curie=FLUXNOVA_BPM_PLATFORM.curie('category'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionDefinition_category, domain=FluxnovaDecisionDefinition, range=Optional[str])

slots.FluxnovaDecisionDefinition_decision_requirements_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_key, name="FluxnovaDecisionDefinition_decision_requirements_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_requirements_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionDefinition_decision_requirements_definition_key, domain=FluxnovaDecisionDefinition, range=Optional[str])

slots.FluxnovaDecisionDefinition_version_tag = Slot(uri=FLUXNOVA_BPM_PLATFORM.version_tag, name="FluxnovaDecisionDefinition_version_tag", curie=FLUXNOVA_BPM_PLATFORM.curie('version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionDefinition_version_tag, domain=FluxnovaDecisionDefinition, range=Optional[str])

slots.FluxnovaDecisionRequirementsDefinition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.key, name="FluxnovaDecisionRequirementsDefinition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionRequirementsDefinition_key, domain=FluxnovaDecisionRequirementsDefinition, range=str)

slots.FluxnovaDecisionRequirementsDefinition_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.version, name="FluxnovaDecisionRequirementsDefinition_version", curie=FLUXNOVA_BPM_PLATFORM.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionRequirementsDefinition_version, domain=FluxnovaDecisionRequirementsDefinition, range=int)

slots.FluxnovaDecisionRequirementsDefinition_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaDecisionRequirementsDefinition_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionRequirementsDefinition_name, domain=FluxnovaDecisionRequirementsDefinition, range=Optional[str])

slots.FluxnovaDecisionRequirementsDefinition_category = Slot(uri=FLUXNOVA_BPM_PLATFORM.category, name="FluxnovaDecisionRequirementsDefinition_category", curie=FLUXNOVA_BPM_PLATFORM.curie('category'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDecisionRequirementsDefinition_category, domain=FluxnovaDecisionRequirementsDefinition, range=Optional[str])

slots.FluxnovaDeployment_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaDeployment_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaDeployment_tenant_id, domain=FluxnovaDeployment, range=Optional[str])

slots.FluxnovaEventSubscription_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaEventSubscription_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaEventSubscription_execution_id, domain=FluxnovaEventSubscription, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaEventSubscription_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaEventSubscription_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaEventSubscription_id, domain=FluxnovaEventSubscription, range=Union[str, FluxnovaEventSubscriptionId])

slots.FluxnovaEventSubscription_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaEventSubscription_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaEventSubscription_tenant_id, domain=FluxnovaEventSubscription, range=Optional[str])

slots.FluxnovaEventSubscription_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaEventSubscription_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaEventSubscription_process_instance_id, domain=FluxnovaEventSubscription, range=Optional[str])

slots.FluxnovaEventSubscription_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_id, name="FluxnovaEventSubscription_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaEventSubscription_activity_id, domain=FluxnovaEventSubscription, range=Optional[str])

slots.FluxnovaExecution_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaExecution_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExecution_process_instance_id, domain=FluxnovaExecution, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaExecution_parent_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.parent_id, name="FluxnovaExecution_parent_id", curie=FLUXNOVA_BPM_PLATFORM.curie('parent_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExecution_parent_id, domain=FluxnovaExecution, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaExecution_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaExecution_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExecution_process_definition_id, domain=FluxnovaExecution, range=Optional[Union[str, FluxnovaProcessDefinitionId]])

slots.FluxnovaExecution_super_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.super_execution_id, name="FluxnovaExecution_super_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('super_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExecution_super_execution_id, domain=FluxnovaExecution, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaExecution_suspension_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.suspension_state, name="FluxnovaExecution_suspension_state", curie=FLUXNOVA_BPM_PLATFORM.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExecution_suspension_state, domain=FluxnovaExecution, range=Optional[int])

slots.FluxnovaExecution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaExecution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExecution_id, domain=FluxnovaExecution, range=Union[str, FluxnovaExecutionId])

slots.FluxnovaExecution_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaExecution_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExecution_tenant_id, domain=FluxnovaExecution, range=Optional[str])

slots.FluxnovaExecution_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaExecution_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExecution_process_definition_key, domain=FluxnovaExecution, range=Optional[str])

slots.FluxnovaExternalTask_error_details_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.error_details_id, name="FluxnovaExternalTask_error_details_id", curie=FLUXNOVA_BPM_PLATFORM.curie('error_details_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExternalTask_error_details_id, domain=FluxnovaExternalTask, range=Optional[Union[str, FluxnovaByteArrayId]])

slots.FluxnovaExternalTask_suspension_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.suspension_state, name="FluxnovaExternalTask_suspension_state", curie=FLUXNOVA_BPM_PLATFORM.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExternalTask_suspension_state, domain=FluxnovaExternalTask, range=Optional[int])

slots.FluxnovaExternalTask_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaExternalTask_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExternalTask_execution_id, domain=FluxnovaExternalTask, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaExternalTask_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.priority, name="FluxnovaExternalTask_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaExternalTask_priority, domain=FluxnovaExternalTask, range=int)

slots.FluxnovaFilter_resource_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.resource_type, name="FluxnovaFilter_resource_type", curie=FLUXNOVA_BPM_PLATFORM.curie('resource_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaFilter_resource_type, domain=FluxnovaFilter, range=str)

slots.FluxnovaFilter_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaFilter_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaFilter_name, domain=FluxnovaFilter, range=str)

slots.FluxnovaFormDefinition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.key, name="FluxnovaFormDefinition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaFormDefinition_key, domain=FluxnovaFormDefinition, range=str)

slots.FluxnovaFormDefinition_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.version, name="FluxnovaFormDefinition_version", curie=FLUXNOVA_BPM_PLATFORM.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaFormDefinition_version, domain=FluxnovaFormDefinition, range=int)

slots.FluxnovaHistoricActivityInstance_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricActivityInstance_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_process_definition_id, domain=FluxnovaHistoricActivityInstance, range=str)

slots.FluxnovaHistoricActivityInstance_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaHistoricActivityInstance_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_process_instance_id, domain=FluxnovaHistoricActivityInstance, range=str)

slots.FluxnovaHistoricActivityInstance_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaHistoricActivityInstance_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_execution_id, domain=FluxnovaHistoricActivityInstance, range=str)

slots.FluxnovaHistoricActivityInstance_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_id, name="FluxnovaHistoricActivityInstance_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_activity_id, domain=FluxnovaHistoricActivityInstance, range=str)

slots.FluxnovaHistoricActivityInstance_start_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.start_time, name="FluxnovaHistoricActivityInstance_start_time", curie=FLUXNOVA_BPM_PLATFORM.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_start_time, domain=FluxnovaHistoricActivityInstance, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricActivityInstance_activity_instance_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_instance_state, name="FluxnovaHistoricActivityInstance_activity_instance_state", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_instance_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_activity_instance_state, domain=FluxnovaHistoricActivityInstance, range=Optional[int])

slots.FluxnovaHistoricActivityInstance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricActivityInstance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_id, domain=FluxnovaHistoricActivityInstance, range=Union[str, FluxnovaHistoricActivityInstanceId])

slots.FluxnovaHistoricActivityInstance_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricActivityInstance_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_tenant_id, domain=FluxnovaHistoricActivityInstance, range=Optional[str])

slots.FluxnovaHistoricActivityInstance_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricActivityInstance_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_removal_time, domain=FluxnovaHistoricActivityInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricActivityInstance_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricActivityInstance_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_root_process_instance_id, domain=FluxnovaHistoricActivityInstance, range=Optional[str])

slots.FluxnovaHistoricActivityInstance_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricActivityInstance_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_process_definition_key, domain=FluxnovaHistoricActivityInstance, range=Optional[str])

slots.FluxnovaHistoricActivityInstance_end_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.end_time, name="FluxnovaHistoricActivityInstance_end_time", curie=FLUXNOVA_BPM_PLATFORM.curie('end_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_end_time, domain=FluxnovaHistoricActivityInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricActivityInstance_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaHistoricActivityInstance_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_task_id, domain=FluxnovaHistoricActivityInstance, range=Optional[str])

slots.FluxnovaHistoricActivityInstance_parent_activity_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.parent_activity_instance_id, name="FluxnovaHistoricActivityInstance_parent_activity_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('parent_activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_parent_activity_instance_id, domain=FluxnovaHistoricActivityInstance, range=Optional[str])

slots.FluxnovaHistoricActivityInstance_called_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.called_process_instance_id, name="FluxnovaHistoricActivityInstance_called_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('called_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_called_process_instance_id, domain=FluxnovaHistoricActivityInstance, range=Optional[str])

slots.FluxnovaHistoricActivityInstance_called_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.called_case_instance_id, name="FluxnovaHistoricActivityInstance_called_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('called_case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_called_case_instance_id, domain=FluxnovaHistoricActivityInstance, range=Optional[str])

slots.FluxnovaHistoricActivityInstance_assignee = Slot(uri=FLUXNOVA_BPM_PLATFORM.assignee, name="FluxnovaHistoricActivityInstance_assignee", curie=FLUXNOVA_BPM_PLATFORM.curie('assignee'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricActivityInstance_assignee, domain=FluxnovaHistoricActivityInstance, range=Optional[str])

slots.FluxnovaHistoricBatch_start_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.start_time, name="FluxnovaHistoricBatch_start_time", curie=FLUXNOVA_BPM_PLATFORM.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricBatch_start_time, domain=FluxnovaHistoricBatch, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricBatch_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricBatch_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricBatch_removal_time, domain=FluxnovaHistoricBatch, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricCaseActivityInstance_case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="FluxnovaHistoricCaseActivityInstance_case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_case_definition_id, domain=FluxnovaHistoricCaseActivityInstance, range=str)

slots.FluxnovaHistoricCaseActivityInstance_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaHistoricCaseActivityInstance_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_case_instance_id, domain=FluxnovaHistoricCaseActivityInstance, range=str)

slots.FluxnovaHistoricCaseActivityInstance_create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="FluxnovaHistoricCaseActivityInstance_create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_create_time, domain=FluxnovaHistoricCaseActivityInstance, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricCaseActivityInstance_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.state, name="FluxnovaHistoricCaseActivityInstance_state", curie=FLUXNOVA_BPM_PLATFORM.curie('state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_state, domain=FluxnovaHistoricCaseActivityInstance, range=Optional[int])

slots.FluxnovaHistoricCaseActivityInstance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricCaseActivityInstance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_id, domain=FluxnovaHistoricCaseActivityInstance, range=Union[str, FluxnovaHistoricCaseActivityInstanceId])

slots.FluxnovaHistoricCaseActivityInstance_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricCaseActivityInstance_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_tenant_id, domain=FluxnovaHistoricCaseActivityInstance, range=Optional[str])

slots.FluxnovaHistoricCaseActivityInstance_end_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.end_time, name="FluxnovaHistoricCaseActivityInstance_end_time", curie=FLUXNOVA_BPM_PLATFORM.curie('end_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_end_time, domain=FluxnovaHistoricCaseActivityInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricCaseActivityInstance_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaHistoricCaseActivityInstance_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_task_id, domain=FluxnovaHistoricCaseActivityInstance, range=Optional[str])

slots.FluxnovaHistoricCaseActivityInstance_called_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.called_process_instance_id, name="FluxnovaHistoricCaseActivityInstance_called_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('called_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_called_process_instance_id, domain=FluxnovaHistoricCaseActivityInstance, range=Optional[str])

slots.FluxnovaHistoricCaseActivityInstance_called_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.called_case_instance_id, name="FluxnovaHistoricCaseActivityInstance_called_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('called_case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseActivityInstance_called_case_instance_id, domain=FluxnovaHistoricCaseActivityInstance, range=Optional[str])

slots.FluxnovaHistoricCaseInstance_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaHistoricCaseInstance_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseInstance_case_instance_id, domain=FluxnovaHistoricCaseInstance, range=str)

slots.FluxnovaHistoricCaseInstance_case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="FluxnovaHistoricCaseInstance_case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseInstance_case_definition_id, domain=FluxnovaHistoricCaseInstance, range=str)

slots.FluxnovaHistoricCaseInstance_create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="FluxnovaHistoricCaseInstance_create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseInstance_create_time, domain=FluxnovaHistoricCaseInstance, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricCaseInstance_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.state, name="FluxnovaHistoricCaseInstance_state", curie=FLUXNOVA_BPM_PLATFORM.curie('state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseInstance_state, domain=FluxnovaHistoricCaseInstance, range=Optional[int])

slots.FluxnovaHistoricCaseInstance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricCaseInstance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseInstance_id, domain=FluxnovaHistoricCaseInstance, range=Union[str, FluxnovaHistoricCaseInstanceId])

slots.FluxnovaHistoricCaseInstance_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricCaseInstance_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseInstance_tenant_id, domain=FluxnovaHistoricCaseInstance, range=Optional[str])

slots.FluxnovaHistoricCaseInstance_business_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.business_key, name="FluxnovaHistoricCaseInstance_business_key", curie=FLUXNOVA_BPM_PLATFORM.curie('business_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseInstance_business_key, domain=FluxnovaHistoricCaseInstance, range=Optional[str])

slots.FluxnovaHistoricCaseInstance_create_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_user_id, name="FluxnovaHistoricCaseInstance_create_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('create_user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricCaseInstance_create_user_id, domain=FluxnovaHistoricCaseInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInputInstance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricDecisionInputInstance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInputInstance_id, domain=FluxnovaHistoricDecisionInputInstance, range=Union[str, FluxnovaHistoricDecisionInputInstanceId])

slots.FluxnovaHistoricDecisionInputInstance_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricDecisionInputInstance_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInputInstance_removal_time, domain=FluxnovaHistoricDecisionInputInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricDecisionInputInstance_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricDecisionInputInstance_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInputInstance_root_process_instance_id, domain=FluxnovaHistoricDecisionInputInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInputInstance_create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="FluxnovaHistoricDecisionInputInstance_create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInputInstance_create_time, domain=FluxnovaHistoricDecisionInputInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricDecisionInstance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricDecisionInstance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_id, domain=FluxnovaHistoricDecisionInstance, range=Union[str, FluxnovaHistoricDecisionInstanceId])

slots.FluxnovaHistoricDecisionInstance_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricDecisionInstance_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_tenant_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricDecisionInstance_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_removal_time, domain=FluxnovaHistoricDecisionInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricDecisionInstance_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricDecisionInstance_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_root_process_instance_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaHistoricDecisionInstance_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_process_instance_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricDecisionInstance_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_process_definition_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricDecisionInstance_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_process_definition_key, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_id, name="FluxnovaHistoricDecisionInstance_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_activity_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_activity_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_instance_id, name="FluxnovaHistoricDecisionInstance_activity_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_activity_instance_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="FluxnovaHistoricDecisionInstance_case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_case_definition_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaHistoricDecisionInstance_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_case_instance_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_id, name="FluxnovaHistoricDecisionInstance_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_user_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_case_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_key, name="FluxnovaHistoricDecisionInstance_case_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_case_definition_key, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_decision_requirements_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_id, name="FluxnovaHistoricDecisionInstance_decision_requirements_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_requirements_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_decision_requirements_definition_id, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionInstance_decision_requirements_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.decision_requirements_definition_key, name="FluxnovaHistoricDecisionInstance_decision_requirements_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('decision_requirements_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionInstance_decision_requirements_definition_key, domain=FluxnovaHistoricDecisionInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionOutputInstance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricDecisionOutputInstance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionOutputInstance_id, domain=FluxnovaHistoricDecisionOutputInstance, range=Union[str, FluxnovaHistoricDecisionOutputInstanceId])

slots.FluxnovaHistoricDecisionOutputInstance_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricDecisionOutputInstance_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionOutputInstance_removal_time, domain=FluxnovaHistoricDecisionOutputInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricDecisionOutputInstance_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricDecisionOutputInstance_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionOutputInstance_root_process_instance_id, domain=FluxnovaHistoricDecisionOutputInstance, range=Optional[str])

slots.FluxnovaHistoricDecisionOutputInstance_create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="FluxnovaHistoricDecisionOutputInstance_create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionOutputInstance_create_time, domain=FluxnovaHistoricDecisionOutputInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricDecisionOutputInstance_variable_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.variable_name, name="FluxnovaHistoricDecisionOutputInstance_variable_name", curie=FLUXNOVA_BPM_PLATFORM.curie('variable_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDecisionOutputInstance_variable_name, domain=FluxnovaHistoricDecisionOutputInstance, range=Optional[str])

slots.FluxnovaHistoricDetail_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="FluxnovaHistoricDetail_type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_type, domain=FluxnovaHistoricDetail, range=str)

slots.FluxnovaHistoricDetail_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaHistoricDetail_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_name, domain=FluxnovaHistoricDetail, range=str)

slots.FluxnovaHistoricDetail_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricDetail_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_id, domain=FluxnovaHistoricDetail, range=Union[str, FluxnovaHistoricDetailId])

slots.FluxnovaHistoricDetail_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricDetail_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_tenant_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricDetail_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_removal_time, domain=FluxnovaHistoricDetail, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricDetail_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricDetail_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_root_process_instance_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaHistoricDetail_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_process_instance_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricDetail_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_process_definition_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricDetail_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_process_definition_key, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaHistoricDetail_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_execution_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_activity_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_instance_id, name="FluxnovaHistoricDetail_activity_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_activity_instance_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaHistoricDetail_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_task_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="FluxnovaHistoricDetail_case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_case_definition_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaHistoricDetail_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_case_instance_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, name="FluxnovaHistoricDetail_case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_case_execution_id, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricDetail_case_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_key, name="FluxnovaHistoricDetail_case_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricDetail_case_definition_key, domain=FluxnovaHistoricDetail, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_timestamp = Slot(uri=FLUXNOVA_BPM_PLATFORM.timestamp, name="FluxnovaHistoricExternalTaskLog_timestamp", curie=FLUXNOVA_BPM_PLATFORM.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_timestamp, domain=FluxnovaHistoricExternalTaskLog, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricExternalTaskLog_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.state, name="FluxnovaHistoricExternalTaskLog_state", curie=FLUXNOVA_BPM_PLATFORM.curie('state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_state, domain=FluxnovaHistoricExternalTaskLog, range=Optional[int])

slots.FluxnovaHistoricExternalTaskLog_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.priority, name="FluxnovaHistoricExternalTaskLog_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_priority, domain=FluxnovaHistoricExternalTaskLog, range=int)

slots.FluxnovaHistoricExternalTaskLog_external_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.external_task_id, name="FluxnovaHistoricExternalTaskLog_external_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('external_task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_external_task_id, domain=FluxnovaHistoricExternalTaskLog, range=str)

slots.FluxnovaHistoricExternalTaskLog_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricExternalTaskLog_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_id, domain=FluxnovaHistoricExternalTaskLog, range=Union[str, FluxnovaHistoricExternalTaskLogId])

slots.FluxnovaHistoricExternalTaskLog_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricExternalTaskLog_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_tenant_id, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricExternalTaskLog_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_removal_time, domain=FluxnovaHistoricExternalTaskLog, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricExternalTaskLog_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricExternalTaskLog_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_root_process_instance_id, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaHistoricExternalTaskLog_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_process_instance_id, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricExternalTaskLog_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_process_definition_id, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricExternalTaskLog_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_process_definition_key, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaHistoricExternalTaskLog_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_execution_id, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_id, name="FluxnovaHistoricExternalTaskLog_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_activity_id, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_activity_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_instance_id, name="FluxnovaHistoricExternalTaskLog_activity_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_activity_instance_id, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_retries = Slot(uri=FLUXNOVA_BPM_PLATFORM.retries, name="FluxnovaHistoricExternalTaskLog_retries", curie=FLUXNOVA_BPM_PLATFORM.curie('retries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_retries, domain=FluxnovaHistoricExternalTaskLog, range=Optional[int])

slots.FluxnovaHistoricExternalTaskLog_topic_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.topic_name, name="FluxnovaHistoricExternalTaskLog_topic_name", curie=FLUXNOVA_BPM_PLATFORM.curie('topic_name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_topic_name, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_worker_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.worker_id, name="FluxnovaHistoricExternalTaskLog_worker_id", curie=FLUXNOVA_BPM_PLATFORM.curie('worker_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_worker_id, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricExternalTaskLog_error_message = Slot(uri=FLUXNOVA_BPM_PLATFORM.error_message, name="FluxnovaHistoricExternalTaskLog_error_message", curie=FLUXNOVA_BPM_PLATFORM.curie('error_message'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricExternalTaskLog_error_message, domain=FluxnovaHistoricExternalTaskLog, range=Optional[str])

slots.FluxnovaHistoricIdentityLink_timestamp = Slot(uri=FLUXNOVA_BPM_PLATFORM.timestamp, name="FluxnovaHistoricIdentityLink_timestamp", curie=FLUXNOVA_BPM_PLATFORM.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_timestamp, domain=FluxnovaHistoricIdentityLink, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricIdentityLink_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricIdentityLink_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_id, domain=FluxnovaHistoricIdentityLink, range=Union[str, FluxnovaHistoricIdentityLinkId])

slots.FluxnovaHistoricIdentityLink_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricIdentityLink_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_tenant_id, domain=FluxnovaHistoricIdentityLink, range=Optional[str])

slots.FluxnovaHistoricIdentityLink_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricIdentityLink_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_removal_time, domain=FluxnovaHistoricIdentityLink, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricIdentityLink_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricIdentityLink_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_root_process_instance_id, domain=FluxnovaHistoricIdentityLink, range=Optional[str])

slots.FluxnovaHistoricIdentityLink_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricIdentityLink_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_process_definition_id, domain=FluxnovaHistoricIdentityLink, range=Optional[str])

slots.FluxnovaHistoricIdentityLink_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricIdentityLink_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_process_definition_key, domain=FluxnovaHistoricIdentityLink, range=Optional[str])

slots.FluxnovaHistoricIdentityLink_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaHistoricIdentityLink_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_task_id, domain=FluxnovaHistoricIdentityLink, range=Optional[str])

slots.FluxnovaHistoricIdentityLink_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_id, name="FluxnovaHistoricIdentityLink_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_user_id, domain=FluxnovaHistoricIdentityLink, range=Optional[str])

slots.FluxnovaHistoricIdentityLink_group_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.group_id, name="FluxnovaHistoricIdentityLink_group_id", curie=FLUXNOVA_BPM_PLATFORM.curie('group_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_group_id, domain=FluxnovaHistoricIdentityLink, range=Optional[str])

slots.FluxnovaHistoricIdentityLink_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="FluxnovaHistoricIdentityLink_type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_type, domain=FluxnovaHistoricIdentityLink, range=Optional[str])

slots.FluxnovaHistoricIdentityLink_operation_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_type, name="FluxnovaHistoricIdentityLink_operation_type", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIdentityLink_operation_type, domain=FluxnovaHistoricIdentityLink, range=Optional[str])

slots.FluxnovaHistoricIncident_create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="FluxnovaHistoricIncident_create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_create_time, domain=FluxnovaHistoricIncident, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricIncident_incident_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.incident_state, name="FluxnovaHistoricIncident_incident_state", curie=FLUXNOVA_BPM_PLATFORM.curie('incident_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_incident_state, domain=FluxnovaHistoricIncident, range=Optional[int])

slots.FluxnovaHistoricIncident_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricIncident_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_id, domain=FluxnovaHistoricIncident, range=Union[str, FluxnovaHistoricIncidentId])

slots.FluxnovaHistoricIncident_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricIncident_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_tenant_id, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricIncident_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricIncident_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_removal_time, domain=FluxnovaHistoricIncident, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricIncident_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricIncident_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_root_process_instance_id, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricIncident_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaHistoricIncident_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_process_instance_id, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricIncident_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricIncident_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_process_definition_id, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricIncident_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricIncident_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_process_definition_key, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricIncident_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaHistoricIncident_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_execution_id, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricIncident_end_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.end_time, name="FluxnovaHistoricIncident_end_time", curie=FLUXNOVA_BPM_PLATFORM.curie('end_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_end_time, domain=FluxnovaHistoricIncident, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricIncident_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_id, name="FluxnovaHistoricIncident_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_activity_id, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricIncident_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definition_id, name="FluxnovaHistoricIncident_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_job_definition_id, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricIncident_configuration = Slot(uri=FLUXNOVA_BPM_PLATFORM.configuration, name="FluxnovaHistoricIncident_configuration", curie=FLUXNOVA_BPM_PLATFORM.curie('configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_configuration, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricIncident_annotation = Slot(uri=FLUXNOVA_BPM_PLATFORM.annotation, name="FluxnovaHistoricIncident_annotation", curie=FLUXNOVA_BPM_PLATFORM.curie('annotation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricIncident_annotation, domain=FluxnovaHistoricIncident, range=Optional[str])

slots.FluxnovaHistoricJobLog_timestamp = Slot(uri=FLUXNOVA_BPM_PLATFORM.timestamp, name="FluxnovaHistoricJobLog_timestamp", curie=FLUXNOVA_BPM_PLATFORM.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_timestamp, domain=FluxnovaHistoricJobLog, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricJobLog_job_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_state, name="FluxnovaHistoricJobLog_job_state", curie=FLUXNOVA_BPM_PLATFORM.curie('job_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_job_state, domain=FluxnovaHistoricJobLog, range=Optional[int])

slots.FluxnovaHistoricJobLog_job_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_priority, name="FluxnovaHistoricJobLog_job_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('job_priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_job_priority, domain=FluxnovaHistoricJobLog, range=int)

slots.FluxnovaHistoricJobLog_job_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_id, name="FluxnovaHistoricJobLog_job_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_job_id, domain=FluxnovaHistoricJobLog, range=str)

slots.FluxnovaHistoricJobLog_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricJobLog_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_id, domain=FluxnovaHistoricJobLog, range=Union[str, FluxnovaHistoricJobLogId])

slots.FluxnovaHistoricJobLog_deployment_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployment_id, name="FluxnovaHistoricJobLog_deployment_id", curie=FLUXNOVA_BPM_PLATFORM.curie('deployment_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_deployment_id, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricJobLog_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricJobLog_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_tenant_id, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricJobLog_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricJobLog_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_removal_time, domain=FluxnovaHistoricJobLog, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricJobLog_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricJobLog_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_root_process_instance_id, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricJobLog_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaHistoricJobLog_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_process_instance_id, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricJobLog_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricJobLog_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_process_definition_id, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricJobLog_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricJobLog_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_process_definition_key, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricJobLog_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaHistoricJobLog_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_execution_id, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricJobLog_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_id, name="FluxnovaHistoricJobLog_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_activity_id, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricJobLog_batch_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.batch_id, name="FluxnovaHistoricJobLog_batch_id", curie=FLUXNOVA_BPM_PLATFORM.curie('batch_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_batch_id, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricJobLog_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definition_id, name="FluxnovaHistoricJobLog_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricJobLog_job_definition_id, domain=FluxnovaHistoricJobLog, range=Optional[str])

slots.FluxnovaHistoricProcessInstance_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaHistoricProcessInstance_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_process_instance_id, domain=FluxnovaHistoricProcessInstance, range=str)

slots.FluxnovaHistoricProcessInstance_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricProcessInstance_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_process_definition_id, domain=FluxnovaHistoricProcessInstance, range=str)

slots.FluxnovaHistoricProcessInstance_start_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.start_time, name="FluxnovaHistoricProcessInstance_start_time", curie=FLUXNOVA_BPM_PLATFORM.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_start_time, domain=FluxnovaHistoricProcessInstance, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricProcessInstance_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.state, name="FluxnovaHistoricProcessInstance_state", curie=FLUXNOVA_BPM_PLATFORM.curie('state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_state, domain=FluxnovaHistoricProcessInstance, range=Optional[Union[str, "HistoricProcessInstanceState"]])

slots.FluxnovaHistoricProcessInstance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricProcessInstance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_id, domain=FluxnovaHistoricProcessInstance, range=Union[str, FluxnovaHistoricProcessInstanceId])

slots.FluxnovaHistoricProcessInstance_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricProcessInstance_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_tenant_id, domain=FluxnovaHistoricProcessInstance, range=Optional[str])

slots.FluxnovaHistoricProcessInstance_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricProcessInstance_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_removal_time, domain=FluxnovaHistoricProcessInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricProcessInstance_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricProcessInstance_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_root_process_instance_id, domain=FluxnovaHistoricProcessInstance, range=Optional[str])

slots.FluxnovaHistoricProcessInstance_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricProcessInstance_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_process_definition_key, domain=FluxnovaHistoricProcessInstance, range=Optional[str])

slots.FluxnovaHistoricProcessInstance_end_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.end_time, name="FluxnovaHistoricProcessInstance_end_time", curie=FLUXNOVA_BPM_PLATFORM.curie('end_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_end_time, domain=FluxnovaHistoricProcessInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricProcessInstance_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaHistoricProcessInstance_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_case_instance_id, domain=FluxnovaHistoricProcessInstance, range=Optional[str])

slots.FluxnovaHistoricProcessInstance_business_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.business_key, name="FluxnovaHistoricProcessInstance_business_key", curie=FLUXNOVA_BPM_PLATFORM.curie('business_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_business_key, domain=FluxnovaHistoricProcessInstance, range=Optional[str])

slots.FluxnovaHistoricProcessInstance_delete_reason = Slot(uri=FLUXNOVA_BPM_PLATFORM.delete_reason, name="FluxnovaHistoricProcessInstance_delete_reason", curie=FLUXNOVA_BPM_PLATFORM.curie('delete_reason'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricProcessInstance_delete_reason, domain=FluxnovaHistoricProcessInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_start_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.start_time, name="FluxnovaHistoricTaskInstance_start_time", curie=FLUXNOVA_BPM_PLATFORM.curie('start_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_start_time, domain=FluxnovaHistoricTaskInstance, range=Union[str, XSDDateTime])

slots.FluxnovaHistoricTaskInstance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaHistoricTaskInstance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_id, domain=FluxnovaHistoricTaskInstance, range=Union[str, FluxnovaHistoricTaskInstanceId])

slots.FluxnovaHistoricTaskInstance_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaHistoricTaskInstance_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_name, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_description = Slot(uri=FLUXNOVA_BPM_PLATFORM.description, name="FluxnovaHistoricTaskInstance_description", curie=FLUXNOVA_BPM_PLATFORM.curie('description'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_description, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricTaskInstance_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_tenant_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricTaskInstance_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_removal_time, domain=FluxnovaHistoricTaskInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricTaskInstance_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricTaskInstance_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_root_process_instance_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaHistoricTaskInstance_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_process_instance_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricTaskInstance_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_process_definition_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricTaskInstance_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_process_definition_key, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaHistoricTaskInstance_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_execution_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_end_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.end_time, name="FluxnovaHistoricTaskInstance_end_time", curie=FLUXNOVA_BPM_PLATFORM.curie('end_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_end_time, domain=FluxnovaHistoricTaskInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricTaskInstance_activity_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_instance_id, name="FluxnovaHistoricTaskInstance_activity_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_activity_instance_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="FluxnovaHistoricTaskInstance_case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_case_definition_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaHistoricTaskInstance_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_case_instance_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, name="FluxnovaHistoricTaskInstance_case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_case_execution_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_assignee = Slot(uri=FLUXNOVA_BPM_PLATFORM.assignee, name="FluxnovaHistoricTaskInstance_assignee", curie=FLUXNOVA_BPM_PLATFORM.curie('assignee'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_assignee, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_case_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_key, name="FluxnovaHistoricTaskInstance_case_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_case_definition_key, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.priority, name="FluxnovaHistoricTaskInstance_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_priority, domain=FluxnovaHistoricTaskInstance, range=Optional[int])

slots.FluxnovaHistoricTaskInstance_delete_reason = Slot(uri=FLUXNOVA_BPM_PLATFORM.delete_reason, name="FluxnovaHistoricTaskInstance_delete_reason", curie=FLUXNOVA_BPM_PLATFORM.curie('delete_reason'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_delete_reason, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_task_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_definition_key, name="FluxnovaHistoricTaskInstance_task_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('task_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_task_definition_key, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_parent_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.parent_task_id, name="FluxnovaHistoricTaskInstance_parent_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('parent_task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_parent_task_id, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_owner = Slot(uri=FLUXNOVA_BPM_PLATFORM.owner, name="FluxnovaHistoricTaskInstance_owner", curie=FLUXNOVA_BPM_PLATFORM.curie('owner'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_owner, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricTaskInstance_due_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.due_date, name="FluxnovaHistoricTaskInstance_due_date", curie=FLUXNOVA_BPM_PLATFORM.curie('due_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_due_date, domain=FluxnovaHistoricTaskInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricTaskInstance_follow_up_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.follow_up_date, name="FluxnovaHistoricTaskInstance_follow_up_date", curie=FLUXNOVA_BPM_PLATFORM.curie('follow_up_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_follow_up_date, domain=FluxnovaHistoricTaskInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricTaskInstance_task_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_state, name="FluxnovaHistoricTaskInstance_task_state", curie=FLUXNOVA_BPM_PLATFORM.curie('task_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricTaskInstance_task_state, domain=FluxnovaHistoricTaskInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaHistoricVariableInstance_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_name, domain=FluxnovaHistoricVariableInstance, range=str)

slots.FluxnovaHistoricVariableInstance_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.state, name="FluxnovaHistoricVariableInstance_state", curie=FLUXNOVA_BPM_PLATFORM.curie('state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_state, domain=FluxnovaHistoricVariableInstance, range=Optional[Union[str, "HistoricVariableInstanceState"]])

slots.FluxnovaHistoricVariableInstance_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaHistoricVariableInstance_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_tenant_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaHistoricVariableInstance_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_removal_time, domain=FluxnovaHistoricVariableInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricVariableInstance_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaHistoricVariableInstance_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_root_process_instance_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaHistoricVariableInstance_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_process_instance_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaHistoricVariableInstance_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_process_definition_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaHistoricVariableInstance_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_process_definition_key, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaHistoricVariableInstance_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_execution_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="FluxnovaHistoricVariableInstance_create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_create_time, domain=FluxnovaHistoricVariableInstance, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaHistoricVariableInstance_activity_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_instance_id, name="FluxnovaHistoricVariableInstance_activity_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_activity_instance_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaHistoricVariableInstance_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_task_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="FluxnovaHistoricVariableInstance_case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_case_definition_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaHistoricVariableInstance_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_case_instance_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, name="FluxnovaHistoricVariableInstance_case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_case_execution_id, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaHistoricVariableInstance_case_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_key, name="FluxnovaHistoricVariableInstance_case_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaHistoricVariableInstance_case_definition_key, domain=FluxnovaHistoricVariableInstance, range=Optional[str])

slots.FluxnovaIdentityLink_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaIdentityLink_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIdentityLink_task_id, domain=FluxnovaIdentityLink, range=Optional[Union[str, FluxnovaTaskId]])

slots.FluxnovaIdentityLink_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaIdentityLink_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIdentityLink_process_definition_id, domain=FluxnovaIdentityLink, range=Optional[Union[str, FluxnovaProcessDefinitionId]])

slots.FluxnovaIdentityLink_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaIdentityLink_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIdentityLink_id, domain=FluxnovaIdentityLink, range=Union[str, FluxnovaIdentityLinkId])

slots.FluxnovaIdentityLink_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaIdentityLink_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIdentityLink_tenant_id, domain=FluxnovaIdentityLink, range=Optional[str])

slots.FluxnovaIdentityLink_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_id, name="FluxnovaIdentityLink_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIdentityLink_user_id, domain=FluxnovaIdentityLink, range=Optional[str])

slots.FluxnovaIdentityLink_group_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.group_id, name="FluxnovaIdentityLink_group_id", curie=FLUXNOVA_BPM_PLATFORM.curie('group_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIdentityLink_group_id, domain=FluxnovaIdentityLink, range=Optional[str])

slots.FluxnovaIdentityLink_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="FluxnovaIdentityLink_type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIdentityLink_type, domain=FluxnovaIdentityLink, range=Optional[str])

slots.FluxnovaIncident_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaIncident_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_execution_id, domain=FluxnovaIncident, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaIncident_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaIncident_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_process_instance_id, domain=FluxnovaIncident, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaIncident_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaIncident_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_process_definition_id, domain=FluxnovaIncident, range=Optional[Union[str, FluxnovaProcessDefinitionId]])

slots.FluxnovaIncident_cause_incident_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.cause_incident_id, name="FluxnovaIncident_cause_incident_id", curie=FLUXNOVA_BPM_PLATFORM.curie('cause_incident_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_cause_incident_id, domain=FluxnovaIncident, range=Optional[Union[str, FluxnovaIncidentId]])

slots.FluxnovaIncident_root_cause_incident_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_cause_incident_id, name="FluxnovaIncident_root_cause_incident_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_cause_incident_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_root_cause_incident_id, domain=FluxnovaIncident, range=Optional[Union[str, FluxnovaIncidentId]])

slots.FluxnovaIncident_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definition_id, name="FluxnovaIncident_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_job_definition_id, domain=FluxnovaIncident, range=Optional[Union[str, FluxnovaJobDefinitionId]])

slots.FluxnovaIncident_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaIncident_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_id, domain=FluxnovaIncident, range=Union[str, FluxnovaIncidentId])

slots.FluxnovaIncident_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaIncident_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_tenant_id, domain=FluxnovaIncident, range=Optional[str])

slots.FluxnovaIncident_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_id, name="FluxnovaIncident_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_activity_id, domain=FluxnovaIncident, range=Optional[str])

slots.FluxnovaIncident_configuration = Slot(uri=FLUXNOVA_BPM_PLATFORM.configuration, name="FluxnovaIncident_configuration", curie=FLUXNOVA_BPM_PLATFORM.curie('configuration'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_configuration, domain=FluxnovaIncident, range=Optional[str])

slots.FluxnovaIncident_annotation = Slot(uri=FLUXNOVA_BPM_PLATFORM.annotation, name="FluxnovaIncident_annotation", curie=FLUXNOVA_BPM_PLATFORM.curie('annotation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaIncident_annotation, domain=FluxnovaIncident, range=Optional[str])

slots.FluxnovaJob_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="FluxnovaJob_type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_type, domain=FluxnovaJob, range=str)

slots.FluxnovaJob_suspension_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.suspension_state, name="FluxnovaJob_suspension_state", curie=FLUXNOVA_BPM_PLATFORM.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_suspension_state, domain=FluxnovaJob, range=int)

slots.FluxnovaJob_exception_stack_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.exception_stack_id, name="FluxnovaJob_exception_stack_id", curie=FLUXNOVA_BPM_PLATFORM.curie('exception_stack_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_exception_stack_id, domain=FluxnovaJob, range=Optional[Union[str, FluxnovaByteArrayId]])

slots.FluxnovaJob_repeat_offset = Slot(uri=FLUXNOVA_BPM_PLATFORM.repeat_offset, name="FluxnovaJob_repeat_offset", curie=FLUXNOVA_BPM_PLATFORM.curie('repeat_offset'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_repeat_offset, domain=FluxnovaJob, range=Optional[int])

slots.FluxnovaJob_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.priority, name="FluxnovaJob_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_priority, domain=FluxnovaJob, range=int)

slots.FluxnovaJob_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaJob_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_id, domain=FluxnovaJob, range=Union[str, FluxnovaJobId])

slots.FluxnovaJob_deployment_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployment_id, name="FluxnovaJob_deployment_id", curie=FLUXNOVA_BPM_PLATFORM.curie('deployment_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_deployment_id, domain=FluxnovaJob, range=Optional[str])

slots.FluxnovaJob_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaJob_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_tenant_id, domain=FluxnovaJob, range=Optional[str])

slots.FluxnovaJob_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaJob_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_root_process_instance_id, domain=FluxnovaJob, range=Optional[str])

slots.FluxnovaJob_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaJob_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_process_instance_id, domain=FluxnovaJob, range=Optional[str])

slots.FluxnovaJob_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaJob_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_process_definition_id, domain=FluxnovaJob, range=Optional[str])

slots.FluxnovaJob_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaJob_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_process_definition_key, domain=FluxnovaJob, range=Optional[str])

slots.FluxnovaJob_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaJob_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_execution_id, domain=FluxnovaJob, range=Optional[str])

slots.FluxnovaJob_create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="FluxnovaJob_create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_create_time, domain=FluxnovaJob, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaJob_batch_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.batch_id, name="FluxnovaJob_batch_id", curie=FLUXNOVA_BPM_PLATFORM.curie('batch_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_batch_id, domain=FluxnovaJob, range=Optional[str])

slots.FluxnovaJob_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definition_id, name="FluxnovaJob_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_job_definition_id, domain=FluxnovaJob, range=Optional[str])

slots.FluxnovaJob_retries = Slot(uri=FLUXNOVA_BPM_PLATFORM.retries, name="FluxnovaJob_retries", curie=FLUXNOVA_BPM_PLATFORM.curie('retries'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJob_retries, domain=FluxnovaJob, range=Optional[int])

slots.FluxnovaJobDefinition_suspension_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.suspension_state, name="FluxnovaJobDefinition_suspension_state", curie=FLUXNOVA_BPM_PLATFORM.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJobDefinition_suspension_state, domain=FluxnovaJobDefinition, range=Optional[int])

slots.FluxnovaJobDefinition_deployment_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployment_id, name="FluxnovaJobDefinition_deployment_id", curie=FLUXNOVA_BPM_PLATFORM.curie('deployment_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJobDefinition_deployment_id, domain=FluxnovaJobDefinition, range=Optional[str])

slots.FluxnovaJobDefinition_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaJobDefinition_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJobDefinition_tenant_id, domain=FluxnovaJobDefinition, range=Optional[str])

slots.FluxnovaJobDefinition_activity_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.activity_id, name="FluxnovaJobDefinition_activity_id", curie=FLUXNOVA_BPM_PLATFORM.curie('activity_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaJobDefinition_activity_id, domain=FluxnovaJobDefinition, range=Optional[str])

slots.FluxnovaMembership_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_id, name="FluxnovaMembership_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaMembership_user_id, domain=FluxnovaMembership, range=Union[str, FluxnovaUserId])

slots.FluxnovaMembership_group_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.group_id, name="FluxnovaMembership_group_id", curie=FLUXNOVA_BPM_PLATFORM.curie('group_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaMembership_group_id, domain=FluxnovaMembership, range=Union[str, FluxnovaGroupId])

slots.FluxnovaMeterLog_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaMeterLog_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaMeterLog_name, domain=FluxnovaMeterLog, range=str)

slots.FluxnovaMeterLog_value = Slot(uri=FLUXNOVA_BPM_PLATFORM.value, name="FluxnovaMeterLog_value", curie=FLUXNOVA_BPM_PLATFORM.curie('value'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaMeterLog_value, domain=FluxnovaMeterLog, range=Optional[int])

slots.FluxnovaMeterLog_milliseconds = Slot(uri=FLUXNOVA_BPM_PLATFORM.milliseconds, name="FluxnovaMeterLog_milliseconds", curie=FLUXNOVA_BPM_PLATFORM.curie('milliseconds'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaMeterLog_milliseconds, domain=FluxnovaMeterLog, range=Optional[int])

slots.FluxnovaProcessDefinition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.key, name="FluxnovaProcessDefinition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaProcessDefinition_key, domain=FluxnovaProcessDefinition, range=str)

slots.FluxnovaProcessDefinition_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.version, name="FluxnovaProcessDefinition_version", curie=FLUXNOVA_BPM_PLATFORM.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaProcessDefinition_version, domain=FluxnovaProcessDefinition, range=int)

slots.FluxnovaProcessDefinition_suspension_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.suspension_state, name="FluxnovaProcessDefinition_suspension_state", curie=FLUXNOVA_BPM_PLATFORM.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaProcessDefinition_suspension_state, domain=FluxnovaProcessDefinition, range=Optional[int])

slots.FluxnovaProcessDefinition_is_startable = Slot(uri=FLUXNOVA_BPM_PLATFORM.is_startable, name="FluxnovaProcessDefinition_is_startable", curie=FLUXNOVA_BPM_PLATFORM.curie('is_startable'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaProcessDefinition_is_startable, domain=FluxnovaProcessDefinition, range=Union[bool, Bool])

slots.FluxnovaProcessDefinition_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaProcessDefinition_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaProcessDefinition_name, domain=FluxnovaProcessDefinition, range=Optional[str])

slots.FluxnovaProcessDefinition_category = Slot(uri=FLUXNOVA_BPM_PLATFORM.category, name="FluxnovaProcessDefinition_category", curie=FLUXNOVA_BPM_PLATFORM.curie('category'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaProcessDefinition_category, domain=FluxnovaProcessDefinition, range=Optional[str])

slots.FluxnovaProcessDefinition_version_tag = Slot(uri=FLUXNOVA_BPM_PLATFORM.version_tag, name="FluxnovaProcessDefinition_version_tag", curie=FLUXNOVA_BPM_PLATFORM.curie('version_tag'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaProcessDefinition_version_tag, domain=FluxnovaProcessDefinition, range=Optional[str])

slots.FluxnovaEngineProperty_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaEngineProperty_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaEngineProperty_name, domain=FluxnovaEngineProperty, range=Union[str, FluxnovaEnginePropertyName])

slots.FluxnovaResourceDefinition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.key, name="FluxnovaResourceDefinition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaResourceDefinition_key, domain=FluxnovaResourceDefinition, range=Optional[str])

slots.FluxnovaResourceDefinition_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.version, name="FluxnovaResourceDefinition_version", curie=FLUXNOVA_BPM_PLATFORM.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaResourceDefinition_version, domain=FluxnovaResourceDefinition, range=Optional[int])

slots.FluxnovaResourceDefinition_deployment_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployment_id, name="FluxnovaResourceDefinition_deployment_id", curie=FLUXNOVA_BPM_PLATFORM.curie('deployment_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaResourceDefinition_deployment_id, domain=FluxnovaResourceDefinition, range=Optional[str])

slots.FluxnovaResourceDefinition_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaResourceDefinition_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaResourceDefinition_tenant_id, domain=FluxnovaResourceDefinition, range=Optional[str])

slots.FluxnovaSchemaLogEntry_version = Slot(uri=FLUXNOVA_BPM_PLATFORM.version, name="FluxnovaSchemaLogEntry_version", curie=FLUXNOVA_BPM_PLATFORM.curie('version'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaSchemaLogEntry_version, domain=FluxnovaSchemaLogEntry, range=Optional[str])

slots.FluxnovaTask_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaTask_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_execution_id, domain=FluxnovaTask, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaTask_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaTask_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_process_instance_id, domain=FluxnovaTask, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaTask_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaTask_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_process_definition_id, domain=FluxnovaTask, range=Optional[Union[str, FluxnovaProcessDefinitionId]])

slots.FluxnovaTask_case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, name="FluxnovaTask_case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_case_execution_id, domain=FluxnovaTask, range=Optional[Union[str, FluxnovaCaseExecutionId]])

slots.FluxnovaTask_case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="FluxnovaTask_case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_case_definition_id, domain=FluxnovaTask, range=Optional[Union[str, FluxnovaCaseDefinitionId]])

slots.FluxnovaTask_suspension_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.suspension_state, name="FluxnovaTask_suspension_state", curie=FLUXNOVA_BPM_PLATFORM.curie('suspension_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_suspension_state, domain=FluxnovaTask, range=Optional[int])

slots.FluxnovaTask_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaTask_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_id, domain=FluxnovaTask, range=Union[str, FluxnovaTaskId])

slots.FluxnovaTask_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaTask_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_name, domain=FluxnovaTask, range=Optional[str])

slots.FluxnovaTask_description = Slot(uri=FLUXNOVA_BPM_PLATFORM.description, name="FluxnovaTask_description", curie=FLUXNOVA_BPM_PLATFORM.curie('description'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_description, domain=FluxnovaTask, range=Optional[str])

slots.FluxnovaTask_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaTask_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_tenant_id, domain=FluxnovaTask, range=Optional[str])

slots.FluxnovaTask_create_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.create_time, name="FluxnovaTask_create_time", curie=FLUXNOVA_BPM_PLATFORM.curie('create_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_create_time, domain=FluxnovaTask, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaTask_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaTask_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_case_instance_id, domain=FluxnovaTask, range=Optional[str])

slots.FluxnovaTask_assignee = Slot(uri=FLUXNOVA_BPM_PLATFORM.assignee, name="FluxnovaTask_assignee", curie=FLUXNOVA_BPM_PLATFORM.curie('assignee'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_assignee, domain=FluxnovaTask, range=Optional[str])

slots.FluxnovaTask_priority = Slot(uri=FLUXNOVA_BPM_PLATFORM.priority, name="FluxnovaTask_priority", curie=FLUXNOVA_BPM_PLATFORM.curie('priority'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_priority, domain=FluxnovaTask, range=Optional[int])

slots.FluxnovaTask_task_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_definition_key, name="FluxnovaTask_task_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('task_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_task_definition_key, domain=FluxnovaTask, range=Optional[str])

slots.FluxnovaTask_parent_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.parent_task_id, name="FluxnovaTask_parent_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('parent_task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_parent_task_id, domain=FluxnovaTask, range=Optional[str])

slots.FluxnovaTask_owner = Slot(uri=FLUXNOVA_BPM_PLATFORM.owner, name="FluxnovaTask_owner", curie=FLUXNOVA_BPM_PLATFORM.curie('owner'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_owner, domain=FluxnovaTask, range=Optional[str])

slots.FluxnovaTask_due_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.due_date, name="FluxnovaTask_due_date", curie=FLUXNOVA_BPM_PLATFORM.curie('due_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_due_date, domain=FluxnovaTask, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaTask_follow_up_date = Slot(uri=FLUXNOVA_BPM_PLATFORM.follow_up_date, name="FluxnovaTask_follow_up_date", curie=FLUXNOVA_BPM_PLATFORM.curie('follow_up_date'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_follow_up_date, domain=FluxnovaTask, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaTask_task_state = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_state, name="FluxnovaTask_task_state", curie=FLUXNOVA_BPM_PLATFORM.curie('task_state'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTask_task_state, domain=FluxnovaTask, range=Optional[str])

slots.FluxnovaTenantMembership_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaTenantMembership_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTenantMembership_tenant_id, domain=FluxnovaTenantMembership, range=Union[str, FluxnovaTenantId])

slots.FluxnovaTenantMembership_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_id, name="FluxnovaTenantMembership_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTenantMembership_user_id, domain=FluxnovaTenantMembership, range=Optional[Union[str, FluxnovaUserId]])

slots.FluxnovaTenantMembership_group_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.group_id, name="FluxnovaTenantMembership_group_id", curie=FLUXNOVA_BPM_PLATFORM.curie('group_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaTenantMembership_group_id, domain=FluxnovaTenantMembership, range=Optional[Union[str, FluxnovaGroupId]])

slots.FluxnovaUserOperationLogEntry_timestamp = Slot(uri=FLUXNOVA_BPM_PLATFORM.timestamp, name="FluxnovaUserOperationLogEntry_timestamp", curie=FLUXNOVA_BPM_PLATFORM.curie('timestamp'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_timestamp, domain=FluxnovaUserOperationLogEntry, range=Union[str, XSDDateTime])

slots.FluxnovaUserOperationLogEntry_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.id, name="FluxnovaUserOperationLogEntry_id", curie=FLUXNOVA_BPM_PLATFORM.curie('id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_id, domain=FluxnovaUserOperationLogEntry, range=Union[str, FluxnovaUserOperationLogEntryId])

slots.FluxnovaUserOperationLogEntry_category = Slot(uri=FLUXNOVA_BPM_PLATFORM.category, name="FluxnovaUserOperationLogEntry_category", curie=FLUXNOVA_BPM_PLATFORM.curie('category'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_category, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_deployment_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.deployment_id, name="FluxnovaUserOperationLogEntry_deployment_id", curie=FLUXNOVA_BPM_PLATFORM.curie('deployment_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_deployment_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaUserOperationLogEntry_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_tenant_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_removal_time = Slot(uri=FLUXNOVA_BPM_PLATFORM.removal_time, name="FluxnovaUserOperationLogEntry_removal_time", curie=FLUXNOVA_BPM_PLATFORM.curie('removal_time'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_removal_time, domain=FluxnovaUserOperationLogEntry, range=Optional[Union[str, XSDDateTime]])

slots.FluxnovaUserOperationLogEntry_root_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.root_process_instance_id, name="FluxnovaUserOperationLogEntry_root_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('root_process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_root_process_instance_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaUserOperationLogEntry_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_process_instance_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaUserOperationLogEntry_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_process_definition_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_process_definition_key = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_key, name="FluxnovaUserOperationLogEntry_process_definition_key", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_key'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_process_definition_key, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaUserOperationLogEntry_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_execution_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaUserOperationLogEntry_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_task_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_case_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_definition_id, name="FluxnovaUserOperationLogEntry_case_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_case_definition_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaUserOperationLogEntry_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_case_instance_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, name="FluxnovaUserOperationLogEntry_case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_case_execution_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_user_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.user_id, name="FluxnovaUserOperationLogEntry_user_id", curie=FLUXNOVA_BPM_PLATFORM.curie('user_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_user_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_batch_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.batch_id, name="FluxnovaUserOperationLogEntry_batch_id", curie=FLUXNOVA_BPM_PLATFORM.curie('batch_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_batch_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_job_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_definition_id, name="FluxnovaUserOperationLogEntry_job_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_job_definition_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_operation_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_id, name="FluxnovaUserOperationLogEntry_operation_id", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_operation_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_external_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.external_task_id, name="FluxnovaUserOperationLogEntry_external_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('external_task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_external_task_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_operation_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.operation_type, name="FluxnovaUserOperationLogEntry_operation_type", curie=FLUXNOVA_BPM_PLATFORM.curie('operation_type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_operation_type, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_annotation = Slot(uri=FLUXNOVA_BPM_PLATFORM.annotation, name="FluxnovaUserOperationLogEntry_annotation", curie=FLUXNOVA_BPM_PLATFORM.curie('annotation'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_annotation, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaUserOperationLogEntry_job_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.job_id, name="FluxnovaUserOperationLogEntry_job_id", curie=FLUXNOVA_BPM_PLATFORM.curie('job_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaUserOperationLogEntry_job_id, domain=FluxnovaUserOperationLogEntry, range=Optional[str])

slots.FluxnovaVariableInstance_type = Slot(uri=FLUXNOVA_BPM_PLATFORM.type, name="FluxnovaVariableInstance_type", curie=FLUXNOVA_BPM_PLATFORM.curie('type'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_type, domain=FluxnovaVariableInstance, range=str)

slots.FluxnovaVariableInstance_name = Slot(uri=FLUXNOVA_BPM_PLATFORM.name, name="FluxnovaVariableInstance_name", curie=FLUXNOVA_BPM_PLATFORM.curie('name'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_name, domain=FluxnovaVariableInstance, range=str)

slots.FluxnovaVariableInstance_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.execution_id, name="FluxnovaVariableInstance_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_execution_id, domain=FluxnovaVariableInstance, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaVariableInstance_process_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_instance_id, name="FluxnovaVariableInstance_process_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_process_instance_id, domain=FluxnovaVariableInstance, range=Optional[Union[str, FluxnovaExecutionId]])

slots.FluxnovaVariableInstance_case_execution_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_execution_id, name="FluxnovaVariableInstance_case_execution_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_execution_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_case_execution_id, domain=FluxnovaVariableInstance, range=Optional[Union[str, FluxnovaCaseExecutionId]])

slots.FluxnovaVariableInstance_case_instance_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.case_instance_id, name="FluxnovaVariableInstance_case_instance_id", curie=FLUXNOVA_BPM_PLATFORM.curie('case_instance_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_case_instance_id, domain=FluxnovaVariableInstance, range=Optional[Union[str, FluxnovaCaseExecutionId]])

slots.FluxnovaVariableInstance_batch_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.batch_id, name="FluxnovaVariableInstance_batch_id", curie=FLUXNOVA_BPM_PLATFORM.curie('batch_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_batch_id, domain=FluxnovaVariableInstance, range=Optional[Union[str, FluxnovaBatchId]])

slots.FluxnovaVariableInstance_byte_array_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.byte_array_id, name="FluxnovaVariableInstance_byte_array_id", curie=FLUXNOVA_BPM_PLATFORM.curie('byte_array_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_byte_array_id, domain=FluxnovaVariableInstance, range=Optional[Union[str, FluxnovaByteArrayId]])

slots.FluxnovaVariableInstance_tenant_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.tenant_id, name="FluxnovaVariableInstance_tenant_id", curie=FLUXNOVA_BPM_PLATFORM.curie('tenant_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_tenant_id, domain=FluxnovaVariableInstance, range=Optional[str])

slots.FluxnovaVariableInstance_process_definition_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.process_definition_id, name="FluxnovaVariableInstance_process_definition_id", curie=FLUXNOVA_BPM_PLATFORM.curie('process_definition_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_process_definition_id, domain=FluxnovaVariableInstance, range=Optional[str])

slots.FluxnovaVariableInstance_task_id = Slot(uri=FLUXNOVA_BPM_PLATFORM.task_id, name="FluxnovaVariableInstance_task_id", curie=FLUXNOVA_BPM_PLATFORM.curie('task_id'),
                   model_uri=FLUXNOVA_BPM_PLATFORM.FluxnovaVariableInstance_task_id, domain=FluxnovaVariableInstance, range=Optional[str])
