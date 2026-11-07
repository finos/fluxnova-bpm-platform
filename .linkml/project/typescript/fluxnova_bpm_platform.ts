export type FluxnovaAttachmentId = string;
export type FluxnovaAuthorizationId = string;
export type FluxnovaBatchId = string;
export type FluxnovaByteArrayId = string;
export type FluxnovaCaseDefinitionId = string;
export type FluxnovaCaseExecutionId = string;
export type FluxnovaCaseSentryPartId = string;
export type FluxnovaCommentId = string;
export type FluxnovaConfigurationId = string;
export type FluxnovaDecisionDefinitionId = string;
export type FluxnovaDecisionRequirementsDefinitionId = string;
export type FluxnovaDeploymentId = string;
export type FluxnovaEventSubscriptionId = string;
export type FluxnovaExecutionId = string;
export type FluxnovaExternalTaskId = string;
export type FluxnovaFilterId = string;
export type FluxnovaFormDefinitionId = string;
export type FluxnovaGroupId = string;
export type FluxnovaHistoricActivityInstanceId = string;
export type FluxnovaHistoricBatchId = string;
export type FluxnovaHistoricCaseActivityInstanceId = string;
export type FluxnovaHistoricCaseInstanceId = string;
export type FluxnovaHistoricDecisionInputInstanceId = string;
export type FluxnovaHistoricDecisionInstanceId = string;
export type FluxnovaHistoricDecisionOutputInstanceId = string;
export type FluxnovaHistoricDetailId = string;
export type FluxnovaHistoricExternalTaskLogId = string;
export type FluxnovaHistoricIdentityLinkId = string;
export type FluxnovaHistoricIncidentId = string;
export type FluxnovaHistoricJobLogId = string;
export type FluxnovaHistoricProcessInstanceId = string;
export type FluxnovaHistoricScopeInstanceId = string;
export type FluxnovaHistoricTaskInstanceId = string;
export type FluxnovaHistoricVariableInstanceId = string;
export type FluxnovaIdentityInfoId = string;
export type FluxnovaIdentityLinkId = string;
export type FluxnovaIncidentId = string;
export type FluxnovaJobId = string;
export type FluxnovaJobDefinitionId = string;
export type FluxnovaMeterLogId = string;
export type FluxnovaProcessDefinitionId = string;
export type FluxnovaEnginePropertyName = string;
export type FluxnovaResourceDefinitionId = string;
export type FluxnovaSchemaLogEntryId = string;
export type FluxnovaTaskId = string;
export type FluxnovaTaskMeterLogId = string;
export type FluxnovaTenantId = string;
export type FluxnovaTenantMembershipId = string;
export type FluxnovaUserId = string;
export type FluxnovaUserOperationLogEntryId = string;
export type FluxnovaVariableInstanceId = string;
/**
* The state a historic process instance records.
*/
export enum HistoricProcessInstanceState {
    
    /** The process instance is running. */
    ACTIVE = "ACTIVE",
    /** The process instance is suspended. */
    SUSPENDED = "SUSPENDED",
    /** The process instance reached an end event. */
    COMPLETED = "COMPLETED",
    /** The process instance was ended from outside, such as through the REST API. */
    EXTERNALLY_TERMINATED = "EXTERNALLY_TERMINATED",
    /** The process instance was ended from within, such as by a terminate end event. */
    INTERNALLY_TERMINATED = "INTERNALLY_TERMINATED",
};
/**
* Whether a historic variable instance still exists.
*/
export enum HistoricVariableInstanceState {
    
    /** The variable exists. */
    CREATED = "CREATED",
    /** The variable was deleted. */
    DELETED = "DELETED",
};
/**
* Whether a configuration entry is in effect.
*/
export enum ConfigurationStatus {
    
    /** The entry is in effect. */
    ACTIVE = "ACTIVE",
    /** A newer version of the entry replaced it. */
    INACTIVE = "INACTIVE",
    /** The entry was deleted, and is kept. */
    DELETED = "DELETED",
};
/**
* Where a delegated task stands.
*/
export enum DelegationState {
    
    /** The task was delegated and waits for the delegate to resolve it. */
    PENDING = "PENDING",
    /** The delegate resolved the task and handed it back to its owner. */
    RESOLVED = "RESOLVED",
};
/**
* Whether the message on a message flow is drawn as the one that starts the exchange.
*/
export enum BpmnMessageVisibleKind {
    
    /** The message starts the exchange. */
    initiating = "initiating",
    /** The message answers one that started the exchange. */
    non_initiating = "non_initiating",
};
/**
* Where a participant band sits on a choreography activity, and whether its participant initiates.
*/
export enum BpmnParticipantBandKind {
    
    /** The top band, of the initiating participant. */
    top_initiating = "top_initiating",
    /** A middle band, of the initiating participant. */
    middle_initiating = "middle_initiating",
    /** The bottom band, of the initiating participant. */
    bottom_initiating = "bottom_initiating",
    /** The top band, of a participant that does not initiate. */
    top_non_initiating = "top_non_initiating",
    /** A middle band, of a participant that does not initiate. */
    middle_non_initiating = "middle_non_initiating",
    /** The bottom band, of a participant that does not initiate. */
    bottom_non_initiating = "bottom_non_initiating",
};
/**
* Which ends of an association an arrow is drawn at.
*/
export enum BpmnAssociationDirection {
    
    /** No arrow is drawn. */
    None = "None",
    /** An arrow points at the target. */
    One = "One",
    /** Arrows point at both ends. */
    Both = "Both",
};
/**
* How an event-based gateway that starts a process waits for its events.
*/
export enum BpmnEventBasedGatewayType {
    
    /** The first event starts the instance, and the others are no longer waited for. */
    Exclusive = "Exclusive",
    /** Each event starts an instance, or joins the one already started. */
    Parallel = "Parallel",
};
/**
* Whether a gateway splits flows, joins them or does both.
*/
export enum BpmnGatewayDirection {
    
    /** The model does not say. */
    Unspecified = "Unspecified",
    /** The gateway joins incoming flows into one. */
    Converging = "Converging",
    /** The gateway splits one flow into several. */
    Diverging = "Diverging",
    /** The gateway both joins and splits. */
    Mixed = "Mixed",
};
/**
* Whether an item is information or a physical thing.
*/
export enum BpmnItemKind {
    
    /** The item is information. */
    Information = "Information",
    /** The item is a physical thing. */
    Physical = "Physical",
};
/**
* When a multi-instance activity throws an event as its instances complete.
*/
export enum BpmnMultiInstanceFlowCondition {
    
    /** An event is thrown for each instance that completes. */
    None = "None",
    /** An event is thrown when the first instance completes. */
    One = "One",
    /** No event is thrown. */
    All = "All",
    /** The complex behavior definitions decide which events are thrown. */
    Complex = "Complex",
};
/**
* Whether a process is private to its participant, public, or neither.
*/
export enum BpmnProcessType {
    
    /** The model does not say. */
    None = "None",
    /** The process shows only what its participant exchanges with others. */
    Public = "Public",
    /** The process is internal to its participant. */
    Private = "Private",
};
/**
* Which way a relationship points.
*/
export enum BpmnRelationshipDirection {
    
    /** It has no direction. */
    None = "None",
    /** From its sources to its targets. */
    Forward = "Forward",
    /** From its targets to its sources. */
    Backward = "Backward",
    /** Both ways. */
    Both = "Both",
};
/**
* How a transaction commits or cancels, by the three values BPMN keeps from BPMN 1.1.
*/
export enum BpmnTransactionMethod {
    
    /** The transaction is cancelled by compensation; the default. */
    Compensate = "##Compensate",
    /** The method BPMN 1.1 called image. */
    Image = "##Image",
    /** The method BPMN 1.1 called store. */
    Store = "##Store",
};


/**
 * Any type of content that is be associated with a task or with a process instance.
 */
export interface FluxnovaAttachment {
    /** Unique identifier. */
    id: string,
    /** Reference to a user. */
    user_id?: string,
    /** Human-readable name. */
    name?: string,
    /** Human-readable description. */
    description?: string,
    /** Type discriminator. */
    type?: string,
    /** Reference to the task. */
    task_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** The remote URL in case this is remote content. */
    url?: string,
    /** Reference to the content. */
    content_id?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Creation timestamp. */
    create_time?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
    /** The user who created this attachment. */
    created_by?: string,
}


/**
 * An Authorization assigns a set of Permissions to an identity to interact with a given Resource.
 */
export interface FluxnovaAuthorization {
    /** Unique identifier. */
    id: string,
    /** Type discriminator. */
    type: number,
    /** Reference to a group. */
    group_id?: string,
    /** Reference to a user. */
    user_id?: string,
    /** Numeric type of the authorized resource. */
    resource_type: number,
    /** Reference to the resource. */
    resource_id?: string,
    /** Bitmask of granted permissions. */
    permissions?: number,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
}


/**
 * A batch represents a number of jobs which execute a number of commands asynchronously.
 */
export interface FluxnovaBatch {
    /** Unique identifier. */
    id: string,
    /** Type discriminator. */
    type?: string,
    /** Total number of jobs. */
    total_jobs?: number,
    /** The jobs created. */
    jobs_created?: number,
    /** The jobs per seed. */
    jobs_per_seed?: number,
    /** The invocations per job. */
    invocations_per_job?: number,
    /** Reference to a JobDefinition. */
    seed_job_definition_id?: FluxnovaJobDefinitionId,
    /** Reference to a JobDefinition. */
    batch_job_definition_id?: FluxnovaJobDefinitionId,
    /** Reference to a JobDefinition. */
    monitor_job_definition_id?: FluxnovaJobDefinitionId,
    /** Whether the entity is active or suspended. */
    suspension_state?: number,
    /** Payload of this incident. */
    configuration?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** The authenticated user that created this case instance. */
    create_user_id?: string,
    /** Start timestamp. */
    start_time?: string,
    /** Timestamp when this started. */
    execution_start_time?: string,
}


/**
 * Byte Array entity in the engine infrastructure.
 */
export interface FluxnovaByteArray {
    /** Unique identifier. */
    id: string,
    /** Human-readable name. */
    name?: string,
    /** Reference to the deployment. */
    deployment_id?: FluxnovaDeploymentId,
    /** Serialized binary content. */
    bytes?: string,
    /** Whether this entity is generated. */
    is_generated?: boolean,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Type discriminator. */
    type?: number,
    /** Creation timestamp. */
    create_time?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
}


/**
 * A deployed case definition in the process repository.
 */
export interface FluxnovaCaseDefinition extends FluxnovaResourceDefinition {
}


/**
 * Case Execution entity in the process execution runtime.
 */
export interface FluxnovaCaseExecution {
    /** Unique identifier. */
    id: string,
    /** Reference to the case instance. */
    case_instance_id?: FluxnovaCaseExecutionId,
    /** Reference to the super case execution. */
    super_case_execution_id?: string,
    /** Reference to the super execution. */
    super_execution_id?: string,
    /** Domain-specific business key. */
    business_key?: string,
    /** Reference to a CaseExecution. */
    parent_id?: FluxnovaCaseExecutionId,
    /** Reference to the case definition. */
    case_definition_id?: FluxnovaCaseDefinitionId,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** The previous state. */
    previous_state?: number,
    /** The current state. */
    current_state?: number,
    /** Whether this entity is required. */
    is_required?: boolean,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
}


/**
 * Case Sentry Part entity in the process execution runtime.
 */
export interface FluxnovaCaseSentryPart {
    /** Unique identifier. */
    id: string,
    /** Reference to the case instance. */
    case_instance_id?: FluxnovaCaseExecutionId,
    /** Reference to the case execution. */
    case_execution_id?: FluxnovaCaseExecutionId,
    /** Reference to the sentry. */
    sentry_id?: string,
    /** Type discriminator. */
    type?: string,
    /** Reference to the source case execution. */
    source_case_execution_id?: string,
    /** The standard event. */
    standard_event?: string,
    /** The source. */
    source?: string,
    /** The variable event. */
    variable_event?: string,
    /** The name of the output variable. */
    variable_name?: string,
    /** Whether this entity is satisfied. */
    is_satisfied?: boolean,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
}


/**
 * User comments that form discussions around tasks.
 */
export interface FluxnovaComment {
    /** Unique identifier. */
    id: string,
    /** Type discriminator. */
    type?: string,
    /** Timestamp for event time. */
    event_time: string,
    /** Reference to a user. */
    user_id?: string,
    /** Reference to the task. */
    task_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** The action. */
    action?: string,
    /** Short message or summary. */
    message?: string,
    /** The full comment message the user had related to the task and/or process instance. */
    full_message?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
}


/**
 * A process configuration entry: a key/value pair which is either global or scoped to a single tenant.
 */
export interface FluxnovaConfiguration {
    /** Unique identifier. */
    id: string,
    /** The configuration key. */
    configuration_key: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** The configuration value. */
    configuration_value: string,
    /** Version number. */
    version: number,
    /** The status. */
    status: string,
    /** The user who created this attachment. */
    created_by?: string,
    /** Timestamp when this was created. */
    created_at?: string,
    /** The updated by. */
    updated_by?: string,
    /** Timestamp for updated at. */
    updated_at?: string,
}


/**
 * Definition of a decision resource.
 */
export interface FluxnovaDecisionDefinition extends FluxnovaResourceDefinition {
    /** Id of the related decision requirements definition. */
    decision_requirements_definition_id?: FluxnovaDecisionRequirementsDefinitionId,
    /** Key of the related decision requirements definition. */
    decision_requirements_definition_key?: string,
    /** Version tag of the process definition. */
    version_tag?: string,
}


/**
 * Container of DecisionDefinitions which belongs to the same decision requirements graph (i.e. DMN resource).
 */
export interface FluxnovaDecisionRequirementsDefinition extends FluxnovaResourceDefinition {
}


/**
 * Represents a deployment that is already present in the process repository.
 */
export interface FluxnovaDeployment {
    /** Unique identifier. */
    id: string,
    /** Human-readable name. */
    name?: string,
    /** Timestamp for deploy time. */
    deploy_time?: string,
    /** The source. */
    source?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
}


/**
 * A message event subscription exists, if an Execution waits for an event like a message.
 */
export interface FluxnovaEventSubscription {
    /** Unique identifier. */
    id: string,
    /** The event subscriptions type. "message" identifies message event subscriptions, "signal" identifies signal event subscription, "compensation" identifies event subscriptions used for compensation events. */
    event_type: string,
    /** The name of the event this subscription belongs to as defined in the process model. */
    event_name?: string,
    /** Reference to the execution. */
    execution_id?: FluxnovaExecutionId,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** Payload of this incident. */
    configuration?: string,
    /** The time this event subscription was created. */
    created: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
}


/**
 * Represent a 'path of execution' in a process instance.
 */
export interface FluxnovaExecution {
    /** Unique identifier. */
    id: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: FluxnovaExecutionId,
    /** Domain-specific business key. */
    business_key?: string,
    /** Reference to a CaseExecution. */
    parent_id?: FluxnovaExecutionId,
    /** Reference to the process definition. */
    process_definition_id?: FluxnovaProcessDefinitionId,
    /** Reference to the super execution. */
    super_execution_id?: FluxnovaExecutionId,
    /** Reference to the super case execution. */
    super_case_execution_id?: string,
    /** Reference to the case instance. */
    case_instance_id?: string,
    /** Runtime activity instance identifier. */
    activity_instance_id?: string,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** Whether this entity is active. */
    is_active?: boolean,
    /** Whether this entity is concurrent. */
    is_concurrent?: boolean,
    /** Whether this entity is scope. */
    is_scope?: boolean,
    /** Whether this entity is event scope. */
    is_event_scope?: boolean,
    /** Whether the entity is active or suspended. */
    suspension_state?: number,
    /** Bitmask caching associated entity existence. */
    cached_entity_state?: number,
    /** Monotonically increasing counter for ordering. */
    sequence_counter?: number,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
}


/**
 * Represents an instance of an external task that is created when a service-task like activity (i.e. service task, send task, ...) with attribute camunda:type="external" is executed.
 */
export interface FluxnovaExternalTask {
    /** Unique identifier. */
    id: string,
    /** Id of the worker that fetched the external task most recently. */
    worker_id?: string,
    /** Topic name of the associated external task. */
    topic_name?: string,
    /** Number of retries this job has left. */
    retries?: number,
    /** If the variable value could not be loaded, this returns the error message. */
    error_message?: string,
    /** Reference to a ByteArray. */
    error_details_id?: FluxnovaByteArrayId,
    /** Time at which the lock expires. */
    lock_expiration_time?: string,
    /** Creation timestamp. */
    create_time?: string,
    /** Whether the entity is active or suspended. */
    suspension_state?: number,
    /** Reference to the execution. */
    execution_id?: FluxnovaExecutionId,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** Runtime activity instance identifier. */
    activity_instance_id?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest. */
    priority: number,
    /** Reference to the last failure log. */
    last_failure_log_id?: string,
}


/**
 * Filter entity in the user collaboration.
 */
export interface FluxnovaFilter {
    /** Unique identifier. */
    id: string,
    /** Numeric type of the authorized resource. */
    resource_type: string,
    /** Human-readable name. */
    name: string,
    /** The userId of the person that is responsible for this task. */
    owner?: string,
    /** Serialized query expression. */
    query: string,
    /** Serialized properties. */
    properties?: string,
}


/**
 * An object structure representing a Camunda Form used to present forms to users either when starting a process instance or when assigned to a User Task.
 */
export interface FluxnovaFormDefinition extends FluxnovaResourceDefinition {
}


/**
 * Represents a group, used in IdentityService.
 */
export interface FluxnovaGroup {
    /** Unique identifier. */
    id: string,
    /** Human-readable name. */
    name?: string,
    /** Type discriminator. */
    type?: string,
}


/**
 * Represents one execution of an activity and it's stored permanent for statistics, audit and other business intelligence purposes.
 */
export interface FluxnovaHistoricActivityInstance extends FluxnovaHistoricScopeInstance {
    /** Id of the parent activity instance. */
    parent_activity_instance_id?: string,
    /** Reference to the execution. */
    execution_id: string,
    /** BPMN activity element identifier. */
    activity_id: string,
    /** Reference to the task. */
    task_id?: string,
    /** The called process instance in case of call activity. */
    called_process_instance_id?: string,
    /** The called case instance in case of (case) call activity. */
    called_case_instance_id?: string,
    /** The display name for the activity. */
    activity_name?: string,
    /** The activity type of the activity. */
    activity_type: string,
    /** The userId of the person to which this task is String) assigned or String) delegated. */
    assignee?: string,
    /** The activity instance state. */
    activity_instance_state?: number,
    /** Monotonically increasing counter for ordering. */
    sequence_counter?: number,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
}


/**
 * Historic representation of a Batch.
 */
export interface FluxnovaHistoricBatch {
    /** Unique identifier. */
    id: string,
    /** Type discriminator. */
    type?: string,
    /** Total number of jobs. */
    total_jobs?: number,
    /** The jobs per seed. */
    jobs_per_seed?: number,
    /** The invocations per job. */
    invocations_per_job?: number,
    /** Reference to a JobDefinition. */
    seed_job_definition_id?: string,
    /** Reference to a JobDefinition. */
    monitor_job_definition_id?: string,
    /** Reference to a JobDefinition. */
    batch_job_definition_id?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** The authenticated user that created this case instance. */
    create_user_id?: string,
    /** Start timestamp. */
    start_time: string,
    /** End timestamp. */
    end_time?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
    /** Timestamp when this started. */
    execution_start_time?: string,
}


/**
 * Represents one execution of a case activity which is stored permanent for statistics, audit and other business intelligence purposes.
 */
export interface FluxnovaHistoricCaseActivityInstance extends FluxnovaHistoricScopeInstance {
    /** Id of the parent activity instance. */
    parent_activity_instance_id?: string,
    /** Reference to the case definition. */
    case_definition_id: string,
    /** Reference to the case instance. */
    case_instance_id: string,
    /** The unique identifier of the case activity in the case. */
    case_activity_id: string,
    /** Reference to the task. */
    task_id?: string,
    /** The called process instance in case of call activity. */
    called_process_instance_id?: string,
    /** The called case instance in case of (case) call activity. */
    called_case_instance_id?: string,
    /** The display name for the case activity. */
    case_activity_name?: string,
    /** The display type for the case activity. */
    case_activity_type?: string,
    /** Creation timestamp. */
    create_time: string,
    /** The row's state; which values it takes depends on its table. */
    state?: number,
    /** Whether this entity is required. */
    is_required?: boolean,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
}


/**
 * A single execution of a case definition that is stored permanently.
 */
export interface FluxnovaHistoricCaseInstance extends FluxnovaHistoricScopeInstance {
    /** Reference to the case instance. */
    case_instance_id: string,
    /** Domain-specific business key. */
    business_key?: string,
    /** Reference to the case definition. */
    case_definition_id: string,
    /** Creation timestamp. */
    create_time: string,
    /** The time the case was closed. */
    close_time?: string,
    /** The row's state; which values it takes depends on its table. */
    state?: number,
    /** The authenticated user that created this case instance. */
    create_user_id?: string,
    /** The case instance id of a potential super case instance or null if no super case instance exists. */
    super_case_instance_id?: string,
    /** The process instance id of a potential super process instance or null if no super process instance exists. */
    super_process_instance_id?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
}


/**
 * Represents one input variable of a decision evaluation.
 */
export interface FluxnovaHistoricDecisionInputInstance {
    /** Unique identifier. */
    id: string,
    /** The unique identifier of the historic decision instance. */
    decision_instance_id: string,
    /** The unique identifier of the clause that the value is assigned for. */
    clause_id?: string,
    /** The name of the clause that the value is assigned for. */
    clause_name?: string,
    /** The variable type. */
    variable_type?: string,
    /** Reference to the byte array. */
    byte_array_id?: string,
    /** Variable value stored as double. */
    double_value?: number,
    /** Variable value stored as long. */
    long_value?: number,
    /** Variable value stored as text. */
    text_value?: string,
    /** Variable value stored as text2. */
    text2_value?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Creation timestamp. */
    create_time?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
}


/**
 * Represents one evaluation of a decision.
 */
export interface FluxnovaHistoricDecisionInstance {
    /** Unique identifier. */
    id: string,
    /** The decision definition reference. */
    decision_definition_id: string,
    /** The unique identifier of the decision definition. */
    decision_definition_key: string,
    /** The name of the decision definition. */
    decision_definition_name?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Case definition key reference. */
    case_definition_key?: string,
    /** Reference to the case definition. */
    case_definition_id?: string,
    /** Reference to the case instance. */
    case_instance_id?: string,
    /** Runtime activity instance identifier. */
    activity_instance_id?: string,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** Time when the decision was evaluated. */
    evaluation_time: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
    /** The result of the collect operation if the hit policy 'collect' was used for the decision. */
    collect_result_value?: number,
    /** Reference to a user. */
    user_id?: string,
    /** The unique identifier of the historic decision instance of the evaluated root decision. */
    root_decision_instance_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Id of the related decision requirements definition. */
    decision_requirements_definition_id?: string,
    /** Key of the related decision requirements definition. */
    decision_requirements_definition_key?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
}


/**
 * Represents one output variable of a decision evaluation.
 */
export interface FluxnovaHistoricDecisionOutputInstance {
    /** Unique identifier. */
    id: string,
    /** The unique identifier of the historic decision instance. */
    decision_instance_id: string,
    /** The unique identifier of the clause that the value is assigned for. */
    clause_id?: string,
    /** The name of the clause that the value is assigned for. */
    clause_name?: string,
    /** The unique identifier of the rule that is matched. */
    rule_id?: string,
    /** The order of the rule that is matched. */
    rule_order?: number,
    /** The name of the output variable. */
    variable_name?: string,
    /** The variable type. */
    variable_type?: string,
    /** Reference to the byte array. */
    byte_array_id?: string,
    /** Variable value stored as double. */
    double_value?: number,
    /** Variable value stored as long. */
    long_value?: number,
    /** Variable value stored as text. */
    text_value?: string,
    /** Variable value stored as text2. */
    text2_value?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Creation timestamp. */
    create_time?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
}


/**
 * Base class for all kinds of information that is related to either a HistoricProcessInstance or a HistoricActivityInstance.
 */
export interface FluxnovaHistoricDetail {
    /** Unique identifier. */
    id: string,
    /** Type discriminator. */
    type: string,
    /** Timestamp for event time. */
    event_time: string,
    /** Human-readable name. */
    name: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Reference to the execution. */
    execution_id?: string,
    /** Case definition key reference. */
    case_definition_key?: string,
    /** Reference to the case definition. */
    case_definition_id?: string,
    /** Reference to the case instance. */
    case_instance_id?: string,
    /** Reference to the case execution. */
    case_execution_id?: string,
    /** Reference to the task. */
    task_id?: string,
    /** Runtime activity instance identifier. */
    activity_instance_id?: string,
    /** Reference to the variable instance. */
    variable_instance_id?: string,
    /** The variable type. */
    variable_type?: string,
    /** Reference to the byte array. */
    byte_array_id?: string,
    /** Variable value stored as double. */
    double_value?: number,
    /** Variable value stored as long. */
    long_value?: number,
    /** Variable value stored as text. */
    text_value?: string,
    /** Variable value stored as text2. */
    text2_value?: string,
    /** Monotonically increasing counter for ordering. */
    sequence_counter?: number,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** The unique identifier of this operation. */
    operation_id?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
    /** Whether this entity is initial. */
    is_initial?: boolean,
}


/**
 * The HistoricExternalTaskLog is used to have a log containing information about task execution.
 */
export interface FluxnovaHistoricExternalTaskLog {
    /** Unique identifier. */
    id: string,
    /** Time when this log occurred. */
    timestamp: string,
    /** Id of the associated external task. */
    external_task_id: string,
    /** Number of retries this job has left. */
    retries?: number,
    /** Topic name of the associated external task. */
    topic_name?: string,
    /** Id of the worker that fetched the external task most recently. */
    worker_id?: string,
    /** Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest. */
    priority: number,
    /** If the variable value could not be loaded, this returns the error message. */
    error_message?: string,
    /** Reference to a ByteArray. */
    error_details_id?: string,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** Runtime activity instance identifier. */
    activity_instance_id?: string,
    /** Reference to the execution. */
    execution_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** The row's state; which values it takes depends on its table. */
    state?: number,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
}


/**
 * An historic identity link stores the association of a task with a certain identity.
 */
export interface FluxnovaHistoricIdentityLink {
    /** Unique identifier. */
    id: string,
    /** Time when this log occurred. */
    timestamp: string,
    /** Type discriminator. */
    type?: string,
    /** Reference to a user. */
    user_id?: string,
    /** Reference to a group. */
    group_id?: string,
    /** Reference to the task. */
    task_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Type of identity link history (add or delete identity link). */
    operation_type?: string,
    /** UserId of the user who assigns a task to the user. */
    assigner_id?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
}


/**
 * Represents a historic incident that is stored permanently.
 */
export interface FluxnovaHistoricIncident {
    /** Unique identifier. */
    id: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Reference to the execution. */
    execution_id?: string,
    /** Creation timestamp. */
    create_time: string,
    /** End timestamp. */
    end_time?: string,
    /** Incident message. */
    incident_message?: string,
    /** Type of this incident to identify the kind of incident. */
    incident_type: string,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** Id of the activity on which the last exception occurred. */
    failed_activity_id?: string,
    /** Id of the incident on which this incident has been triggered. */
    cause_incident_id?: string,
    /** Id of the root incident on which this transitive incident has been triggered. */
    root_cause_incident_id?: string,
    /** Payload of this incident. */
    configuration?: string,
    /** History payload of this incident. */
    history_configuration?: string,
    /** The incident state. */
    incident_state?: number,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Reference to the job definition. */
    job_definition_id?: string,
    /** Annotation of this incident. */
    annotation?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
}


/**
 * The HistoricJobLog is used to have a log containing information about job execution.
 */
export interface FluxnovaHistoricJobLog {
    /** Unique identifier. */
    id: string,
    /** Time when this log occurred. */
    timestamp: string,
    /** Id of the associated job. */
    job_id: string,
    /** Due date of the associated job when this log occurred. */
    job_due_date?: string,
    /** Retries of the associated job before the associated job has been executed and when this log occurred. */
    job_retries?: number,
    /** Priority of the associated job when this log entry was created. */
    job_priority: number,
    /** Message of the exception that occurred by executing the associated job. */
    job_exception_message?: string,
    /** Reference to the job exception stack. */
    job_exception_stack_id?: string,
    /** The job state. */
    job_state?: number,
    /** Reference to the job definition. */
    job_definition_id?: string,
    /** Job definition type of the associated job. */
    job_definition_type?: string,
    /** Job definition configuration type of the associated job. */
    job_definition_configuration?: string,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** Id of the activity on which the last exception occurred. */
    failed_activity_id?: string,
    /** Reference to the execution. */
    execution_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Reference to the deployment. */
    deployment_id?: string,
    /** Monotonically increasing counter for ordering. */
    sequence_counter?: number,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Name of the host where the Process Engine that added this job log runs. */
    hostname?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
    /** Reference to a batch. */
    batch_id?: string,
}


/**
 * A single execution of a whole process definition that is stored permanently.
 */
export interface FluxnovaHistoricProcessInstance extends FluxnovaHistoricScopeInstance {
    /** Domain-specific business key. */
    business_key?: string,
    /** The authenticated user that started this process instance. */
    start_user_id?: string,
    /** The start activity. */
    start_activity_id?: string,
    /** Reference to the end activity. */
    end_activity_id?: string,
    /** The process instance id of a potential super process instance or null if no super process instance exists. */
    super_process_instance_id?: string,
    /** The case instance id of a potential super case instance or null if no super case instance exists. */
    super_case_instance_id?: string,
    /** Reference to the case instance. */
    case_instance_id?: string,
    /** Obtains the reason for the process instance's deletion. */
    delete_reason?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** The row's state; which values it takes depends on its table. */
    state?: string,
    /** The id of the original process instance which was restarted. */
    restarted_process_instance_id?: string,
}


/**
 * Abstract base for historic entities with start/end time and duration.
 */
export interface FluxnovaHistoricScopeInstance {
    /** Unique identifier. */
    id: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Start timestamp. */
    start_time?: string,
    /** End timestamp. */
    end_time?: string,
    /** Duration in milliseconds. */
    duration?: number,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
}


/**
 * Represents a historic task instance (waiting, finished or deleted) that is stored permanent for statistics, audit and other business intelligence purposes.
 */
export interface FluxnovaHistoricTaskInstance extends FluxnovaHistoricScopeInstance {
    /** The id of the activity in the process defining this task or null if this is not related to a process. */
    task_definition_key?: string,
    /** Reference to the execution. */
    execution_id?: string,
    /** Case definition key reference. */
    case_definition_key?: string,
    /** Reference to the case definition. */
    case_definition_id?: string,
    /** Reference to the case instance. */
    case_instance_id?: string,
    /** Reference to the case execution. */
    case_execution_id?: string,
    /** Runtime activity instance identifier. */
    activity_instance_id?: string,
    /** Human-readable name. */
    name?: string,
    /** The parent task for which this task is a subtask. */
    parent_task_id?: string,
    /** Human-readable description. */
    description?: string,
    /** The userId of the person that is responsible for this task. */
    owner?: string,
    /** The userId of the person to which this task is String) assigned or String) delegated. */
    assignee?: string,
    /** Obtains the reason for the process instance's deletion. */
    delete_reason?: string,
    /** Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest. */
    priority: number,
    /** Due date of the task. */
    due_date?: string,
    /** Follow-up date of the task. */
    follow_up_date?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Task's state. */
    task_state?: string,
}


/**
 * A single process variable containing the last value when its process instance has finished.
 */
export interface FluxnovaHistoricVariableInstance {
    /** Unique identifier. */
    id: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Reference to the execution. */
    execution_id?: string,
    /** Case definition key reference. */
    case_definition_key?: string,
    /** Reference to the case definition. */
    case_definition_id?: string,
    /** Reference to the case instance. */
    case_instance_id?: string,
    /** Reference to the case execution. */
    case_execution_id?: string,
    /** Reference to the task. */
    task_id?: string,
    /** Runtime activity instance identifier. */
    activity_instance_id?: string,
    /** Human-readable name. */
    name: string,
    /** The variable type. */
    variable_type?: string,
    /** Creation timestamp. */
    create_time?: string,
    /** Reference to the byte array. */
    byte_array_id?: string,
    /** Variable value stored as double. */
    double_value?: number,
    /** Variable value stored as long. */
    long_value?: number,
    /** Variable value stored as text. */
    text_value?: string,
    /** Variable value stored as text2. */
    text2_value?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** The row's state; which values it takes depends on its table. */
    state?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
    /** Whether this variable is restricted. */
    restricted?: boolean,
}


/**
 * Identity Info entity in the identity and access management.
 */
export interface FluxnovaIdentityInfo {
    /** Unique identifier. */
    id: string,
    /** Reference to a user. */
    user_id?: string,
    /** Type discriminator. */
    type?: string,
    /** Business key for the definition. */
    key?: string,
    /** Value of this variable instance. */
    value?: string,
    /** Hashed password. */
    password?: string,
    /** Reference to a CaseExecution. */
    parent_id?: string,
}


/**
 * An identity link is used to associate a task with a certain identity.
 */
export interface FluxnovaIdentityLink {
    /** Unique identifier. */
    id: string,
    /** Reference to a group. */
    group_id?: string,
    /** Type discriminator. */
    type?: string,
    /** Reference to a user. */
    user_id?: string,
    /** Reference to the task. */
    task_id?: FluxnovaTaskId,
    /** Reference to the process definition. */
    process_definition_id?: FluxnovaProcessDefinitionId,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
}


/**
 * An Incident represents a failure in the execution of a process instance.
 */
export interface FluxnovaIncident {
    /** Unique identifier. */
    id: string,
    /** Time when the incident happened. */
    incident_timestamp: string,
    /** Incident message. */
    incident_message?: string,
    /** Type of this incident to identify the kind of incident. */
    incident_type: string,
    /** Reference to the execution. */
    execution_id?: FluxnovaExecutionId,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** Id of the activity on which the last exception occurred. */
    failed_activity_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: FluxnovaExecutionId,
    /** Reference to the process definition. */
    process_definition_id?: FluxnovaProcessDefinitionId,
    /** Id of the incident on which this incident has been triggered. */
    cause_incident_id?: FluxnovaIncidentId,
    /** Id of the root incident on which this transitive incident has been triggered. */
    root_cause_incident_id?: FluxnovaIncidentId,
    /** Payload of this incident. */
    configuration?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Reference to the job definition. */
    job_definition_id?: FluxnovaJobDefinitionId,
    /** Annotation of this incident. */
    annotation?: string,
}


/**
 * Represents one job (timer, message, etc.).
 */
export interface FluxnovaJob {
    /** Unique identifier. */
    id: string,
    /** Type discriminator. */
    type: string,
    /** Time at which the lock expires. */
    lock_expiration_time?: string,
    /** Identifier of the node that acquired the lock. */
    lock_owner?: string,
    /** Whether this entity is exclusive. */
    is_exclusive?: boolean,
    /** Reference to the execution. */
    execution_id?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Number of retries this job has left. */
    retries?: number,
    /** Reference to a ByteArray. */
    exception_stack_id?: FluxnovaByteArrayId,
    /** Message of the exception that occurred, the last time the job was executed. */
    exception_message?: string,
    /** Id of the activity on which the last exception occurred. */
    failed_activity_id?: string,
    /** Due date of the task. */
    due_date?: string,
    /** Repeat/recurrence expression (ISO 8601). */
    repeat?: string,
    /** Offset applied to repeat interval calculation. */
    repeat_offset?: number,
    /** Type of handler that processes this entity. */
    handler_type?: string,
    /** Configuration for the handler. */
    handler_configuration?: string,
    /** Reference to the deployment. */
    deployment_id?: string,
    /** Whether the entity is active or suspended. */
    suspension_state: number,
    /** Reference to the job definition. */
    job_definition_id?: string,
    /** Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest. */
    priority: number,
    /** Monotonically increasing counter for ordering. */
    sequence_counter?: number,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Creation timestamp. */
    create_time?: string,
    /** Reference to the last failure log. */
    last_failure_log_id?: string,
    /** Reference to a batch. */
    batch_id?: string,
}


/**
 * A Job Definition provides details about asynchronous background processing ("Jobs") performed by the process engine.
 */
export interface FluxnovaJobDefinition {
    /** Unique identifier. */
    id: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** BPMN activity element identifier. */
    activity_id?: string,
    /** The Type of a job. */
    job_type: string,
    /** The configuration of a job definition provides details about the jobs which will be created. */
    job_configuration?: string,
    /** Whether the entity is active or suspended. */
    suspension_state?: number,
    /** Priority of the associated job when this log entry was created. */
    job_priority: number,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Reference to the deployment. */
    deployment_id?: string,
}


/**
 * Association entity in identity and access management.
 */
export interface FluxnovaMembership {
    /** Reference to a user. */
    user_id: FluxnovaUserId,
    /** Reference to a group. */
    group_id: FluxnovaGroupId,
}


/**
 * Meter Log entity in the engine infrastructure.
 */
export interface FluxnovaMeterLog {
    /** Unique identifier. */
    id: string,
    /** Human-readable name. */
    name: string,
    /** Identifier of the reporting node. */
    reporter?: string,
    /** Value of this variable instance. */
    value?: number,
    /** Time when this log occurred. */
    timestamp?: string,
    /** The milliseconds. */
    milliseconds?: number,
}


/**
 * An object structure representing an executable process composed of activities and transitions.
 */
export interface FluxnovaProcessDefinition extends FluxnovaResourceDefinition {
    /** The has start form key. */
    has_start_form_key?: boolean,
    /** Whether the entity is active or suspended. */
    suspension_state?: number,
    /** Version tag of the process definition. */
    version_tag?: string,
    /** Whether this entity is startable. */
    is_startable: boolean,
}


/**
 * Property entity in the engine infrastructure.
 */
export interface FluxnovaEngineProperty {
    /** Human-readable name. */
    name: string,
    /** Value of this variable instance. */
    value?: string,
}


/**
 * Abstract base for deployable resource definitions (process, case, decision, form).
 */
export interface FluxnovaResourceDefinition {
    /** Unique identifier. */
    id: string,
    /** Business key for the definition. */
    key?: string,
    /** Human-readable name. */
    name?: string,
    /** Version number. */
    version?: number,
    /** Category classification. */
    category?: string,
    /** Reference to the deployment. */
    deployment_id?: string,
    /** Name of the deployed resource file. */
    resource_name?: string,
    /** Name of the diagram resource file. */
    diagram_resource_name?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Days to retain history before cleanup. */
    history_time_to_live?: number,
}


/**
 * Schema Log Entry entity in the engine infrastructure.
 */
export interface FluxnovaSchemaLogEntry {
    /** Unique identifier. */
    id: string,
    /** Time when this log occurred. */
    timestamp?: string,
    /** Version number. */
    version?: string,
}


/**
 * Represents one task for a human user.
 */
export interface FluxnovaTask {
    /** Unique identifier. */
    id: string,
    /** Reference to the execution. */
    execution_id?: FluxnovaExecutionId,
    /** Reference to the process instance. */
    process_instance_id?: FluxnovaExecutionId,
    /** Reference to the process definition. */
    process_definition_id?: FluxnovaProcessDefinitionId,
    /** Reference to the case execution. */
    case_execution_id?: FluxnovaCaseExecutionId,
    /** Reference to the case instance. */
    case_instance_id?: string,
    /** Reference to the case definition. */
    case_definition_id?: FluxnovaCaseDefinitionId,
    /** Human-readable name. */
    name?: string,
    /** The parent task for which this task is a subtask. */
    parent_task_id?: string,
    /** Human-readable description. */
    description?: string,
    /** The id of the activity in the process defining this task or null if this is not related to a process. */
    task_definition_key?: string,
    /** The userId of the person that is responsible for this task. */
    owner?: string,
    /** The userId of the person to which this task is String) assigned or String) delegated. */
    assignee?: string,
    /** The current DelegationState for this task. */
    delegation_state?: string,
    /** Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest. */
    priority: number,
    /** Creation timestamp. */
    create_time?: string,
    /** The date/time when this task was last updated. */
    last_updated?: string,
    /** Due date of the task. */
    due_date?: string,
    /** Follow-up date of the task. */
    follow_up_date?: string,
    /** Whether the entity is active or suspended. */
    suspension_state?: number,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Task's state. */
    task_state?: string,
}


/**
 * Task Meter Log entity in the engine infrastructure.
 */
export interface FluxnovaTaskMeterLog {
    /** Unique identifier. */
    id: string,
    /** Hash of the assignee for aggregation. */
    assignee_hash?: number,
    /** Time when this log occurred. */
    timestamp?: string,
}


/**
 * Represents a tenant, used in IdentityService.
 */
export interface FluxnovaTenant {
    /** Unique identifier. */
    id: string,
    /** Human-readable name. */
    name?: string,
}


/**
 * Association entity in identity and access management.
 */
export interface FluxnovaTenantMembership {
    /** Unique identifier. */
    id: string,
    /** Multi-tenancy discriminator. */
    tenant_id: FluxnovaTenantId,
    /** Reference to a user. */
    user_id?: FluxnovaUserId,
    /** Reference to a group. */
    group_id?: FluxnovaGroupId,
}


/**
 * Represents a user, used in IdentityService.
 */
export interface FluxnovaUser {
    /** Unique identifier. */
    id: string,
    /** First name. */
    first_name?: string,
    /** Last name. */
    last_name?: string,
    /** Email address. */
    email?: string,
    /** Hashed password. */
    password?: string,
    /** Cryptographic salt for password hashing. */
    salt?: string,
    /** Time at which the lock expires. */
    lock_expiration_time?: string,
    /** Number of failed login attempts. */
    attempts?: number,
    /** Reference to the picture. */
    picture_id?: string,
}


/**
 * Log entry about an operation performed by a user.
 */
export interface FluxnovaUserOperationLogEntry {
    /** Unique identifier. */
    id: string,
    /** Reference to the deployment. */
    deployment_id?: string,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Key of the process definition. */
    process_definition_key?: string,
    /** Root process instance for history cleanup. */
    root_process_instance_id?: string,
    /** Reference to the process instance. */
    process_instance_id?: string,
    /** Reference to the execution. */
    execution_id?: string,
    /** Reference to the case definition. */
    case_definition_id?: string,
    /** Reference to the case instance. */
    case_instance_id?: string,
    /** Reference to the case execution. */
    case_execution_id?: string,
    /** Reference to the task. */
    task_id?: string,
    /** Id of the associated job. */
    job_id: string,
    /** Reference to the job definition. */
    job_definition_id?: string,
    /** Reference to a batch. */
    batch_id?: string,
    /** Reference to a user. */
    user_id?: string,
    /** Time when this log occurred. */
    timestamp: string,
    /** Type of identity link history (add or delete identity link). */
    operation_type?: string,
    /** The unique identifier of this operation. */
    operation_id?: string,
    /** The type of the entity on which this operation was executed. */
    entity_type?: string,
    /** The property changed by this operation. */
    property?: string,
    /** The original value. */
    original_value?: string,
    /** The new value of the property. */
    new_value?: string,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Timestamp when this entity is eligible for removal. */
    removal_time?: string,
    /** Category classification. */
    category?: string,
    /** Id of the associated external task. */
    external_task_id: string,
    /** Annotation of this incident. */
    annotation?: string,
}


/**
 * A VariableInstance represents a variable in the execution of a process instance.
 */
export interface FluxnovaVariableInstance {
    /** Unique identifier. */
    id: string,
    /** Type discriminator. */
    type: string,
    /** Human-readable name. */
    name: string,
    /** Reference to the execution. */
    execution_id?: FluxnovaExecutionId,
    /** Reference to the process instance. */
    process_instance_id?: FluxnovaExecutionId,
    /** Reference to the process definition. */
    process_definition_id?: string,
    /** Reference to the case execution. */
    case_execution_id?: FluxnovaCaseExecutionId,
    /** Reference to the case instance. */
    case_instance_id?: FluxnovaCaseExecutionId,
    /** Reference to the task. */
    task_id?: string,
    /** Reference to a batch. */
    batch_id?: FluxnovaBatchId,
    /** Reference to the byte array. */
    byte_array_id?: FluxnovaByteArrayId,
    /** Variable value stored as double. */
    double_value?: number,
    /** Variable value stored as long. */
    long_value?: number,
    /** Variable value stored as text. */
    text_value?: string,
    /** Variable value stored as text2. */
    text2_value?: string,
    /** Reference to the variable scope. */
    variable_scope_id: string,
    /** Monotonically increasing counter for ordering. */
    sequence_counter?: number,
    /** Whether this entity is concurrent local. */
    is_concurrent_local?: boolean,
    /** Multi-tenancy discriminator. */
    tenant_id?: string,
    /** Whether this variable is restricted. */
    restricted?: boolean,
}


/**
 * Any element of a BPMN document that Fluxnova's model API reads, the base of every BPMN class here.
 */
export interface BpmnModelElementInstance {
    /** The name of the class an element is, which says which element it is when a slot's range admits several. */
    element_type?: string,
}


/**
 * A rectangle, by its top-left corner and its size, that places a shape on a diagram.
 */
export interface DcBounds extends BpmnModelElementInstance {
    /** The horizontal coordinate. */
    x: number,
    /** The vertical coordinate. */
    y: number,
    /** The width of the rectangle. */
    width: number,
    /** The height of the rectangle. */
    height: number,
}


/**
 * The font a diagram label is drawn in.
 */
export interface DcFont extends BpmnModelElementInstance {
    /** The element's name. */
    name?: string,
    /** The font's size. */
    size?: number,
    /** Whether the font is bold. */
    is_bold?: boolean,
    /** Whether the font is italic. */
    is_italic?: boolean,
    /** Whether the font is underlined. */
    is_underline?: boolean,
    /** Whether the font is struck through. */
    is_strike_through?: boolean,
}


/**
 * A point on a diagram, by its x and y coordinates.
 */
export interface DcPoint extends BpmnModelElementInstance {
    /** The horizontal coordinate. */
    x: number,
    /** The vertical coordinate. */
    y: number,
}


/**
 * A diagram of a model, the root of what Diagram Interchange draws.
 */
export interface DiDiagram extends BpmnModelElementInstance {
    /** The element's name. */
    name?: string,
    /** Text that documents the element. */
    documentation?: string,
    /** The resolution of the diagram, in units per inch. */
    resolution?: number,
    /** The element's id, unique within its document. */
    id?: string,
}


/**
 * Any element drawn on a diagram.
 */
export interface DiDiagramElement extends BpmnModelElementInstance {
    /** The element's id, unique within its document. */
    id?: string,
    /** Tool-specific content of the diagram element. */
    extension?: DiExtension,
}


/**
 * A diagram element drawn as a line through waypoints between two elements.
 */
export interface DiEdge extends DiDiagramElement {
    /** The points the edge passes through, in order. */
    waypoints: DiWaypoint[],
}


/**
 * Tool-specific content attached to a diagram element.
 */
export interface DiExtension extends BpmnModelElementInstance {
}


/**
 * A diagram element that shows text, placed by its bounds.
 */
export interface DiLabel extends DiNode {
    /** Where the element is drawn, and how large. */
    bounds?: DcBounds,
}


/**
 * An edge that can carry labels.
 */
export interface DiLabeledEdge extends DiEdge {
}


/**
 * A shape that can carry labels.
 */
export interface DiLabeledShape extends DiShape {
}


/**
 * A diagram element that other elements can connect to.
 */
export interface DiNode extends DiDiagramElement {
}


/**
 * A diagram's drawing surface, which holds its shapes and edges.
 */
export interface DiPlane extends DiNode {
    /** The shapes and edges on this plane. */
    diagram_elements?: DiDiagramElement[],
}


/**
 * A diagram element drawn as a figure inside its bounds.
 */
export interface DiShape extends DiNode {
    /** Where the element is drawn, and how large. */
    bounds: DcBounds,
}


/**
 * How a diagram element looks, such as its font or colour.
 */
export interface DiStyle extends BpmnModelElementInstance {
    /** The element's id, unique within its document. */
    id?: string,
}


/**
 * A point an edge passes through.
 */
export interface DiWaypoint extends DcPoint {
}


/**
 * A diagram of BPMN elements, with its plane and the label styles it uses.
 */
export interface BpmnDiagram extends DiDiagram {
    /** The plane that holds this diagram's shapes and edges. */
    bpmn_plane: BpmnPlane,
    /** The label styles this diagram's labels use. */
    bpmn_label_styles?: BpmnLabelStyle[],
}


/**
 * The line that draws a connecting BPMN element, such as a sequence flow, message flow or association.
 */
export interface BpmnEdge extends DiLabeledEdge {
    /** The QName of the BPMN element this diagram element draws. */
    bpmn_element?: string,
    /** The QName of the diagram element the edge starts at. */
    source_element?: string,
    /** The QName of the diagram element the edge ends at. */
    target_element?: string,
    /** Whether the message the edge carries is drawn as initiating or not. */
    message_visible_kind?: string,
    /** The label drawn with this shape or edge. */
    bpmn_label?: BpmnLabel,
}


/**
 * The label of a BPMN shape or edge, where its text is drawn.
 */
export interface BpmnLabel extends DiLabel {
    /** The QName of the label style the label uses. */
    label_style?: string,
}


/**
 * A font that BPMN labels share.
 */
export interface BpmnLabelStyle extends DiStyle {
    /** The font the labels are drawn in. */
    font: DcFont,
}


/**
 * The plane of a BPMN diagram, drawing one process, collaboration or sub-process.
 */
export interface BpmnPlane extends DiPlane {
    /** The QName of the BPMN element this diagram element draws. */
    bpmn_element?: string,
}


/**
 * The figure that draws a BPMN element such as a task, event, gateway, pool or lane.
 */
export interface BpmnShape extends DiLabeledShape {
    /** The QName of the BPMN element this diagram element draws. */
    bpmn_element?: string,
    /** Whether a pool or lane is drawn horizontally. */
    is_horizontal?: boolean,
    /** Whether a sub-process or call activity is drawn expanded. */
    is_expanded?: boolean,
    /** Whether an exclusive gateway is drawn with its marker. */
    is_marker_visible?: boolean,
    /** Whether a participant band is drawn with its message. */
    is_message_visible?: boolean,
    /** Where a participant band sits on a choreography activity, and whether it initiates. */
    participant_band_kind?: string,
    /** The QName of the choreography activity shape this participant band belongs to. */
    choreography_activity_shape?: string,
    /** The label drawn with this shape or edge. */
    bpmn_label?: BpmnLabel,
}


/**
 * The condition a complex gateway checks to decide when enough incoming flows have arrived to continue.
 */
export interface BpmnActivationCondition extends BpmnExpression {
}


/**
 * Work a process performs, either a task or a sub-process.
 */
export interface BpmnActivity extends BpmnFlowNode, BpmnInteractionNode {
    /** Whether the activity runs only to compensate another. */
    is_for_compensation?: boolean,
    /** How many tokens must arrive before the activity starts. */
    start_quantity?: number,
    /** How many tokens the activity sends on when it completes. */
    completion_quantity?: number,
    /** The id of the sequence flow taken when no other outgoing flow's condition holds. */
    default?: string,
    /** The element's data inputs and outputs. */
    io_specification?: BpmnIoSpecification,
    /** The element's properties. */
    properties?: BpmnProperty[],
    /** How data reaches the element's inputs. */
    data_input_associations?: BpmnDataInputAssociation[],
    /** How data leaves the element's outputs. */
    data_output_associations?: BpmnDataOutputAssociation[],
    /** The roles resources play in the element, such as its performers. */
    resource_roles?: BpmnResourceRole[],
    /** How the activity repeats. */
    loop_characteristics?: BpmnLoopCharacteristics,
}


/**
 * A sub-process whose inner activities run in no fixed order, as its performers choose.
 */
export interface BpmnAdHocSubProcess extends BpmnSubProcess {
    /** Whether the inner activities run in parallel or one after another. */
    ordering?: string,
    /** Whether the activities still running are cancelled once the completion condition holds. */
    cancel_remaining_instances?: boolean,
    /** The condition that ends the activity early when it holds. */
    completion_condition?: BpmnCompletionCondition,
}


/**
 * An element that adds information to a diagram without changing how the process runs.
 */
export interface BpmnArtifact extends BpmnBaseElement {
}


/**
 * A copy of a value from one expression to another within a data association.
 */
export interface BpmnAssignment extends BpmnBaseElement {
    /** The expression the value is copied from. */
    from_expression: BpmnFrom,
    /** The expression the value is copied to. */
    to_expression: BpmnTo,
}


/**
 * A link between an artifact, such as a text annotation, and another element.
 */
export interface BpmnAssociation extends BpmnArtifact {
    /** The id or QName of the element the connection starts at. */
    source_ref: string,
    /** The id or QName of the element the connection ends at. */
    target_ref: string,
    /** Which ends of the association an arrow is drawn at. */
    association_direction?: string,
}


/**
 * A hook for auditing a process or flow element, left to the implementation.
 */
export interface BpmnAuditing extends BpmnBaseElement {
}


/**
 * The base of nearly every BPMN element, giving it an id, documentation and extensions.
 */
export interface BpmnBaseElement extends BpmnModelElementInstance {
    /** The element's id, unique within its document. */
    id?: string,
    /** Text that documents the element. */
    documentation?: BpmnDocumentation[],
    /** The element's extension content, such as Fluxnova's settings. */
    extension_elements?: BpmnExtensionElements,
}


/**
 * An event attached to the boundary of an activity, which can interrupt it.
 */
export interface BpmnBoundaryEvent extends BpmnCatchEvent {
    /** Whether the event, when it fires, interrupts the activity it is attached to. */
    cancel_activity?: boolean,
    /** The QName of the activity this event is attached to. */
    attached_to_ref: string,
}


/**
 * A task that hands data to a business rules engine and receives its result.
 */
export interface BpmnBusinessRuleTask extends BpmnTask {
    /** The technology that runs the task, as a URI; the engine reads its own settings instead. */
    implementation?: string,
    /** The Java class the engine instantiates to run the element. */
    fluxnova_class?: string,
    /** An expression that gives the delegate object the engine calls. */
    fluxnova_delegate_expression?: string,
    /** An expression the engine evaluates to run the element. */
    fluxnova_expression?: string,
    /** The variable the result is stored in. */
    fluxnova_result_variable?: string,
    /** The topic of the external task the element creates. */
    fluxnova_topic?: string,
    /** The element's type, such as external for an external task or the form field's value type. */
    fluxnova_type?: string,
    /** The key of the decision to evaluate. */
    fluxnova_decision_ref?: string,
    /** Which version of the decision to use. */
    fluxnova_decision_ref_binding?: string,
    /** The version of the decision, when the binding asks for one. */
    fluxnova_decision_ref_version?: string,
    /** The version tag of the decision, when the binding asks for one. */
    fluxnova_decision_ref_version_tag?: string,
    /** The tenant whose decision to use. */
    fluxnova_decision_ref_tenant_id?: string,
    /** How the decision's result is mapped into a variable. */
    fluxnova_map_decision_result?: string,
    /** The priority of the external tasks the element creates. */
    fluxnova_task_priority?: string,
}


/**
 * An activity that calls a separate process or global task.
 */
export interface BpmnCallActivity extends BpmnActivity {
    /** The id of the process or global task this activity calls. */
    called_element?: string,
    /** Whether the engine continues asynchronously before the element; superseded by asyncBefore. */
    fluxnova_async?: boolean,
    /** Which version of the called process to use, such as the latest or the one deployed with this one. */
    fluxnova_called_element_binding?: string,
    /** The version of the called process, when the binding asks for one. */
    fluxnova_called_element_version?: string,
    /** The version tag of the called process, when the binding asks for one. */
    fluxnova_called_element_version_tag?: string,
    /** The key of the case definition to call. */
    fluxnova_case_ref?: string,
    /** Which version of the called case to use. */
    fluxnova_case_binding?: string,
    /** The version of the called case, when the binding asks for one. */
    fluxnova_case_version?: string,
    /** The tenant whose called process to use. */
    fluxnova_called_element_tenant_id?: string,
    /** The tenant whose called case to use. */
    fluxnova_case_tenant_id?: string,
    /** The Java class that maps variables into and out of the called process. */
    fluxnova_variable_mapping_class?: string,
    /** An expression giving the delegate that maps variables into and out of the called process. */
    fluxnova_variable_mapping_delegate_expression?: string,
}


/**
 * A conversation that calls a collaboration or global conversation defined elsewhere.
 */
export interface BpmnCallConversation extends BpmnConversationNode {
    /** The QName of the collaboration or global conversation this conversation calls. */
    called_collaboration_ref?: string,
    /** The links between participants and those in called collaborations. */
    participant_associations?: BpmnParticipantAssociation[],
}


/**
 * An element another process can call, such as a process.
 */
export interface BpmnCallableElement extends BpmnRootElement {
    /** The element's name. */
    name?: string,
    /** The QNames of the interfaces the element supports. */
    supported_interface_refs?: string[],
    /** The element's data inputs and outputs. */
    io_specification?: BpmnIoSpecification,
    /** How the element's operations map to its input and output sets. */
    io_bindings?: BpmnIoBinding[],
}


/**
 * The trigger of an event that cancels a transaction sub-process.
 */
export interface BpmnCancelEventDefinition extends BpmnEventDefinition {
}


/**
 * An event that waits for a trigger, such as a start or intermediate catch event.
 */
export interface BpmnCatchEvent extends BpmnEvent {
    /** Whether all of the event's triggers must happen, rather than any one. */
    parallel_multiple?: boolean,
    /** The data outputs. */
    data_outputs?: BpmnDataOutput[],
    /** How data leaves the element's outputs. */
    data_output_associations?: BpmnDataOutputAssociation[],
    /** The output set the event's data outputs make up. */
    output_set?: BpmnOutputSet,
    /** The event definitions that trigger this event. */
    event_definitions?: BpmnEventDefinition[],
    /** The QNames of event definitions, defined elsewhere in the document, that trigger this event. */
    event_definition_refs?: string[],
}


/**
 * A named set of category values that groups elements.
 */
export interface BpmnCategory extends BpmnRootElement {
    /** The element's name. */
    name: string,
    /** The values of this category. */
    category_values?: BpmnCategoryValue[],
}


/**
 * One value of a category, which a group shows.
 */
export interface BpmnCategoryValue extends BpmnBaseElement {
    /** The category value's text. */
    value?: string,
}


/**
 * The lanes a lane is divided into.
 */
export interface BpmnChildLaneSet extends BpmnLaneSet {
}


/**
 * The participants of a model and the messages and conversations between them.
 */
export interface BpmnCollaboration extends BpmnRootElement {
    /** The element's name. */
    name?: string,
    /** Whether no interactions occur other than those the model shows. */
    is_closed?: boolean,
    /** The participants, usually drawn as pools. */
    participants?: BpmnParticipant[],
    /** The message flows between the participants. */
    message_flows?: BpmnMessageFlow[],
    /** The artifacts, such as text annotations and groups, this element holds. */
    artifacts?: BpmnArtifact[],
    /** The conversations and sub-conversations this element holds. */
    conversation_nodes?: BpmnConversationNode[],
    /** The links between conversation nodes and the ones that refine them. */
    conversation_associations?: BpmnConversationAssociation[],
    /** The links between participants and those in called collaborations. */
    participant_associations?: BpmnParticipantAssociation[],
    /** The links between message flows and the ones that refine them. */
    message_flow_associations?: BpmnMessageFlowAssociation[],
    /** The correlation keys this element defines. */
    correlation_keys?: BpmnCorrelationKey[],
    /** The links between participants and conversation nodes. */
    conversation_links?: BpmnConversationLink[],
}


/**
 * The trigger of an event that starts or catches compensation.
 */
export interface BpmnCompensateEventDefinition extends BpmnEventDefinition {
    /** Whether the throwing event waits for the compensation to finish. */
    wait_for_completion?: boolean,
    /** The id of the activity to compensate; when absent, every compensable activity in scope is. */
    activity_ref?: string,
}


/**
 * The condition that ends a multi-instance activity or an ad-hoc sub-process early.
 */
export interface BpmnCompletionCondition extends BpmnExpression {
}


/**
 * A rule of a multi-instance activity that throws an event when its condition holds as instances complete.
 */
export interface BpmnComplexBehaviorDefinition extends BpmnBaseElement {
}


/**
 * A gateway that splits or joins flows by conditions of its own.
 */
export interface BpmnComplexGateway extends BpmnGateway {
    /** The id of the sequence flow taken when no other outgoing flow's condition holds. */
    default?: string,
    /** The condition that decides when the gateway may continue. */
    activation_condition?: BpmnActivationCondition,
}


/**
 * The expression a conditional event evaluates.
 */
export interface BpmnCondition extends BpmnExpression {
}


/**
 * The expression that decides whether a sequence flow is taken.
 */
export interface BpmnConditionExpression extends BpmnFormalExpression {
    /** The XML Schema type of the expression, a formal expression unless the document says otherwise. */
    xsi_type?: string,
    /** A resource that holds the script of a script condition. */
    fluxnova_resource?: string,
}


/**
 * The trigger of an event that fires when a condition becomes true.
 */
export interface BpmnConditionalEventDefinition extends BpmnEventDefinition {
    /** The variable whose changes make the engine check the condition. */
    fluxnova_variable_name?: string,
    /** The variable events, such as create or update, that make the engine check the condition. */
    fluxnova_variable_events?: string,
    /** The condition the event waits for. */
    condition: BpmnCondition,
}


/**
 * A set of message flows between participants that belong together.
 */
export interface BpmnConversation extends BpmnConversationNode {
}


/**
 * A link between a conversation node and one that refines it.
 */
export interface BpmnConversationAssociation extends BpmnBaseElement {
    /** The QName of the conversation node that refines the outer one. */
    inner_conversation_node_ref: string,
    /** The QName of the conversation node being refined. */
    outer_conversation_node_ref: string,
}


/**
 * A link between a participant and a conversation node.
 */
export interface BpmnConversationLink extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The id or QName of the element the connection starts at. */
    source_ref: string,
    /** The id or QName of the element the connection ends at. */
    target_ref: string,
}


/**
 * Any node of a conversation diagram, such as a conversation or sub-conversation.
 */
export interface BpmnConversationNode extends BpmnBaseElement, BpmnInteractionNode {
    /** The element's name. */
    name?: string,
    /** The QNames of the participants in the conversation. */
    participant_refs?: string[],
    /** The QNames of the message flows the conversation node groups. */
    message_flow_refs?: string[],
    /** The correlation keys this element defines. */
    correlation_keys?: BpmnCorrelationKey[],
}


/**
 * A set of correlation properties that together identify a conversation.
 */
export interface BpmnCorrelationKey extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The QNames of the correlation properties that make up this key. */
    correlation_property_refs?: string[],
}


/**
 * A value read from messages that ties them to one conversation.
 */
export interface BpmnCorrelationProperty extends BpmnRootElement {
    /** The element's name. */
    name?: string,
    /** The QName of the property's type. */
    type?: string,
    /** How the property is read from each kind of message. */
    correlation_property_retrieval_expressions: BpmnCorrelationPropertyRetrievalExpression[],
}


/**
 * The expression that gives a correlation property its value in a process.
 */
export interface BpmnCorrelationPropertyBinding extends BpmnBaseElement {
    /** The QName of the correlation property this binding gives a value. */
    correlation_property_ref: string,
    /** The expression that finds the value in process data. */
    data_path: BpmnDataPath,
}


/**
 * The expression that reads a correlation property from one message.
 */
export interface BpmnCorrelationPropertyRetrievalExpression extends BpmnBaseElement {
    /** The QName of the message sent or received. */
    message_ref: string,
    /** The expression that finds the value in the message. */
    message_path: BpmnMessagePath,
}


/**
 * How a process instance subscribes to messages by a correlation key.
 */
export interface BpmnCorrelationSubscription extends BpmnBaseElement {
    /** The QName of the correlation key this subscription uses. */
    correlation_key_ref: string,
    /** How the process gives each correlation property its value. */
    correlation_property_bindings?: BpmnCorrelationPropertyBinding[],
}


/**
 * A copy of data from sources to a target as an activity or event runs.
 */
export interface BpmnDataAssociation extends BpmnBaseElement {
    /** The ids of the data the association copies from. */
    source_refs?: string[],
    /** The id or QName of the element the connection ends at. */
    target_ref: string,
    /** The expression that changes the data as it is copied. */
    transformation?: BpmnTransformation,
    /** The copies of values this data association makes. */
    assignments?: BpmnAssignment[],
}


/**
 * A piece of data an activity, process or event needs.
 */
export interface BpmnDataInput extends BpmnItemAwareElement {
    /** The element's name. */
    name?: string,
    /** Whether the element holds a collection of items. */
    is_collection?: boolean,
}


/**
 * A data association that feeds a data input.
 */
export interface BpmnDataInputAssociation extends BpmnDataAssociation {
}


/**
 * Data a process creates or uses while it runs.
 */
export interface BpmnDataObject extends BpmnFlowElement {
    /** The QName of the item definition of the data. */
    item_subject_ref?: string,
    /** Whether the element holds a collection of items. */
    is_collection?: boolean,
    /** The state the data is in. */
    data_state?: BpmnDataState,
}


/**
 * A use of a data object at one place in a process.
 */
export interface BpmnDataObjectReference extends BpmnFlowElement {
    /** The QName of the item definition of the data. */
    item_subject_ref?: string,
    /** The id of the data object this reference uses. */
    data_object_ref?: string,
    /** The state the data is in. */
    data_state?: BpmnDataState,
}


/**
 * A piece of data an activity, process or event produces.
 */
export interface BpmnDataOutput extends BpmnItemAwareElement {
    /** The element's name. */
    name?: string,
    /** Whether the element holds a collection of items. */
    is_collection?: boolean,
}


/**
 * A data association that carries a data output on.
 */
export interface BpmnDataOutputAssociation extends BpmnDataAssociation {
}


/**
 * The expression that finds a correlation property's value in process data.
 */
export interface BpmnDataPath extends BpmnFormalExpression {
}


/**
 * The state of a data object or data store, such as draft or approved.
 */
export interface BpmnDataState extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
}


/**
 * Data that lasts beyond one process instance, such as a database.
 */
export interface BpmnDataStore extends BpmnRootElement {
    /** The element's name. */
    name?: string,
    /** How many items the data store can hold. */
    capacity?: number,
    /** Whether the data store's capacity has no limit. */
    is_unlimited?: boolean,
    /** The QName of the item definition of the data. */
    item_subject_ref?: string,
    /** The state the data is in. */
    data_state?: BpmnDataState,
}


/**
 * A use of a data store at one place in a process.
 */
export interface BpmnDataStoreReference extends BpmnFlowElement {
    /** The QName of the item definition of the data. */
    item_subject_ref?: string,
    /** The QName of the data store this reference uses. */
    data_store_ref?: string,
    /** The state the data is in. */
    data_state?: BpmnDataState,
}


/**
 * The root of a BPMN document, which holds its processes, collaborations and diagrams.
 */
export interface BpmnDefinitions extends BpmnModelElementInstance {
    /** The document's id. */
    id?: string,
    /** The document's name. */
    name?: string,
    /** The namespace of the elements this document defines. */
    target_namespace: string,
    /** The language the document's expressions are written in unless one says otherwise, as a URI. */
    expression_language?: string,
    /** The language the document's types are written in, as a URI. */
    type_language?: string,
    /** The tool that wrote the document. */
    exporter?: string,
    /** The version of the tool that wrote the document. */
    exporter_version?: string,
    /** The documents whose elements this one imports. */
    imports?: BpmnImport[],
    /** The extensions the document uses. */
    extensions?: BpmnExtension[],
    /** The processes, collaborations, messages, signals and other elements of the document. */
    root_elements?: BpmnRootElement[],
    /** The diagrams of the document. */
    bpmn_diagrams?: BpmnDiagram[],
    /** The relationships between this document's elements and others. */
    relationships?: BpmnRelationship[],
}


/**
 * Text that documents an element.
 */
export interface BpmnDocumentation extends BpmnModelElementInstance {
    /** The element's id, unique within its document. */
    id?: string,
    /** The format of the text, as a MIME type. */
    text_format?: string,
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * An event that ends a path of a process.
 */
export interface BpmnEndEvent extends BpmnThrowEvent {
}


/**
 * A place where a participant can be reached for messages.
 */
export interface BpmnEndPoint extends BpmnRootElement {
}


/**
 * An error that an activity can throw and an event can catch.
 */
export interface BpmnError extends BpmnRootElement {
    /** The element's name. */
    name?: string,
    /** The code that identifies the error. */
    error_code?: string,
    /** The message of the error. */
    fluxnova_error_message?: string,
    /** The QName of the type of the data, such as an XML Schema type. */
    structure_ref?: string,
}


/**
 * The trigger of an event that throws or catches an error.
 */
export interface BpmnErrorEventDefinition extends BpmnEventDefinition {
    /** The QName of the error thrown or caught. */
    error_ref?: string,
    /** The variable the caught error's code is stored in. */
    fluxnova_error_code_variable?: string,
    /** The variable the caught error's message is stored in. */
    fluxnova_error_message_variable?: string,
}


/**
 * An escalation that an activity can throw and an event can catch.
 */
export interface BpmnEscalation extends BpmnRootElement {
    /** The element's name. */
    name?: string,
    /** The code that identifies the escalation. */
    escalation_code?: string,
    /** The QName of the type of the data, such as an XML Schema type. */
    structure_ref?: string,
}


/**
 * The trigger of an event that throws or catches an escalation.
 */
export interface BpmnEscalationEventDefinition extends BpmnEventDefinition {
    /** The QName of the escalation thrown or caught. */
    escalation_ref?: string,
}


/**
 * Something that happens while a process runs, such as a start, a message or a timer.
 */
export interface BpmnEvent extends BpmnFlowNode, BpmnInteractionNode {
    /** The element's properties. */
    properties?: BpmnProperty[],
}


/**
 * A gateway that takes the path of whichever following event happens first.
 */
export interface BpmnEventBasedGateway extends BpmnGateway {
    /** Whether the element starts a new process instance. */
    instantiate?: boolean,
    /** Whether the gateway starts one process instance for the first event or waits for all of them. */
    event_gateway_type?: string,
}


/**
 * What triggers an event, such as a message, timer or signal.
 */
export interface BpmnEventDefinition extends BpmnRootElement {
}


/**
 * A gateway that takes exactly one of its outgoing flows.
 */
export interface BpmnExclusiveGateway extends BpmnGateway {
    /** The id of the sequence flow taken when no other outgoing flow's condition holds. */
    default?: string,
}


/**
 * An expression whose language and body the model leaves open.
 */
export interface BpmnExpression extends BpmnBaseElement {
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * A declaration that a document uses an extension, by its definition.
 */
export interface BpmnExtension extends BpmnModelElementInstance {
    /** The QName of the extension's definition. */
    definition?: string,
    /** Whether a tool reading the document must understand the extension. */
    must_understand?: boolean,
    /** Text that documents the element. */
    documentation?: BpmnDocumentation[],
}


/**
 * The container for an element's extension content, such as Fluxnova's settings.
 */
export interface BpmnExtensionElements extends BpmnModelElementInstance {
}


/**
 * An element that takes part in the flow of a process, such as an activity or sequence flow.
 */
export interface BpmnFlowElement extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The element's auditing hook. */
    auditing?: BpmnAuditing,
    /** The element's monitoring hook. */
    monitoring?: BpmnMonitoring,
    /** The QNames of the category values this element belongs to. */
    category_value_refs?: string[],
}


/**
 * A flow element that sequence flows connect, such as an activity, event or gateway.
 */
export interface BpmnFlowNode extends BpmnFlowElement {
    /** Whether the engine commits and continues asynchronously after the element. */
    fluxnova_async_after?: boolean,
    /** Whether the engine commits and continues asynchronously before the element. */
    fluxnova_async_before?: boolean,
    /** Whether the element's jobs run one at a time within a process instance. */
    fluxnova_exclusive?: boolean,
    /** The priority of the element's jobs. */
    fluxnova_job_priority?: string,
    /** The QNames of the sequence flows that enter this node. */
    incoming?: string[],
    /** The QNames of the sequence flows that leave this node. */
    outgoing?: string[],
}


/**
 * An expression in a stated language, with the type it evaluates to.
 */
export interface BpmnFormalExpression extends BpmnExpression {
    /** The language the expression is written in, as a URI. */
    language?: string,
    /** The QName of the item definition the expression's result has. */
    evaluates_to_type_ref?: string,
}


/**
 * The expression an assignment copies a value from.
 */
export interface BpmnFrom extends BpmnExpression {
}


/**
 * A point where a process's flows split or join.
 */
export interface BpmnGateway extends BpmnFlowNode {
    /** Whether the gateway splits flows, joins them, does both, or is not said. */
    gateway_direction?: string,
}


/**
 * A conversation defined on its own so that collaborations can call it.
 */
export interface BpmnGlobalConversation extends BpmnCollaboration {
}


/**
 * An artifact that draws a box around elements of one category value.
 */
export interface BpmnGroup extends BpmnArtifact {
    /** The QName of the category value this group shows. */
    category_value_ref?: string,
}


/**
 * The person who performs an activity.
 */
export interface BpmnHumanPerformer extends BpmnPerformer {
}


/**
 * A document the definitions import elements from.
 */
export interface BpmnImport extends BpmnModelElementInstance {
    /** The namespace of the imported document. */
    namespace: string,
    /** Where the imported document is. */
    location: string,
    /** The kind of document imported, as the URI of its language. */
    import_type: string,
}


/**
 * A gateway that takes every outgoing flow whose condition holds.
 */
export interface BpmnInclusiveGateway extends BpmnGateway {
    /** The id of the sequence flow taken when no other outgoing flow's condition holds. */
    default?: string,
}


/**
 * The data input each instance of a multi-instance activity receives.
 */
export interface BpmnInputDataItem extends BpmnDataInput {
}


/**
 * A set of data inputs that is enough for an activity or event to start.
 */
export interface BpmnInputSet extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The ids of the data inputs this set holds. */
    data_input_refs?: string[],
    /** The ids of inputs the set may do without. */
    optional_input_refs?: string[],
    /** The ids of inputs the element can take while it runs. */
    while_executing_input_refs?: string[],
    /** The ids of the output sets this input set can lead to. */
    output_set_refs?: string[],
}


/**
 * An element a message flow or conversation link can connect, such as a participant, task or event.
 */
export interface BpmnInteractionNode {
    /** The element's id, unique within its document. */
    id?: string,
}


/**
 * A set of operations a participant offers.
 */
export interface BpmnInterface extends BpmnRootElement {
    /** The element's name. */
    name: string,
    /** The QName of what implements the element. */
    implementation_ref?: string,
    /** The interface's operations. */
    operations: BpmnOperation[],
}


/**
 * An event on a process's path that waits for a trigger.
 */
export interface BpmnIntermediateCatchEvent extends BpmnCatchEvent {
}


/**
 * An event on a process's path that throws a trigger.
 */
export interface BpmnIntermediateThrowEvent extends BpmnThrowEvent {
}


/**
 * A link between an operation's messages and a callable element's input and output sets.
 */
export interface BpmnIoBinding extends BpmnBaseElement {
    /** The QName of the operation the element calls or implements. */
    operation_ref: string,
    /** The id of the input set the binding uses. */
    input_data_ref: string,
    /** The id of the output set the binding uses. */
    output_data_ref: string,
}


/**
 * The data inputs and outputs of an activity or process, and their sets.
 */
export interface BpmnIoSpecification extends BpmnBaseElement {
    /** The data inputs. */
    data_inputs?: BpmnDataInput[],
    /** The data outputs. */
    data_outputs?: BpmnDataOutput[],
    /** The sets of inputs, each enough to start. */
    input_sets: BpmnInputSet[],
    /** The sets of outputs. */
    output_sets: BpmnOutputSet[],
}


/**
 * An element that holds data of an item definition, such as a data object or data input.
 */
export interface BpmnItemAwareElement extends BpmnBaseElement {
    /** The QName of the item definition of the data. */
    item_subject_ref?: string,
    /** The state the data is in. */
    data_state?: BpmnDataState,
}


/**
 * The type of data an element holds or a message carries.
 */
export interface BpmnItemDefinition extends BpmnRootElement {
    /** The QName of the type of the data, such as an XML Schema type. */
    structure_ref?: string,
    /** Whether the element holds a collection of items. */
    is_collection?: boolean,
    /** Whether the item is information or a physical thing. */
    item_kind?: string,
}


/**
 * A partition of a process that groups flow nodes, often by who performs them.
 */
export interface BpmnLane extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The QName of the element the lane stands for. */
    partition_element_ref?: string,
    /** The element the lane stands for. */
    partition_element?: BpmnPartitionElement,
    /** The ids of the flow nodes in this lane. */
    flow_node_refs?: string[],
    /** The lanes this lane is divided into. */
    child_lane_set?: BpmnChildLaneSet,
}


/**
 * The lanes that divide a process or sub-process.
 */
export interface BpmnLaneSet extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The lanes of the set. */
    lanes?: BpmnLane[],
}


/**
 * The trigger of a pair of events that join two paths of a process like a jump.
 */
export interface BpmnLinkEventDefinition extends BpmnEventDefinition {
    /** The element's name. */
    name: string,
    /** The QNames of the throwing link events that jump to this one. */
    sources?: string[],
    /** The QName of the catching link event this one jumps to. */
    target?: string,
}


/**
 * The expression that says how many instances a multi-instance activity creates.
 */
export interface BpmnLoopCardinality extends BpmnExpression {
}


/**
 * How an activity repeats.
 */
export interface BpmnLoopCharacteristics extends BpmnBaseElement {
}


/**
 * A task done by a person without any system's help.
 */
export interface BpmnManualTask extends BpmnTask {
}


/**
 * What one participant sends another.
 */
export interface BpmnMessage extends BpmnRootElement {
    /** The element's name. */
    name?: string,
    /** The QName of the item definition the message carries. */
    item_ref?: string,
}


/**
 * The trigger of an event that sends or receives a message.
 */
export interface BpmnMessageEventDefinition extends BpmnEventDefinition {
    /** The QName of the message sent or received. */
    message_ref?: string,
    /** The Java class the engine instantiates to run the element. */
    fluxnova_class?: string,
    /** An expression that gives the delegate object the engine calls. */
    fluxnova_delegate_expression?: string,
    /** An expression the engine evaluates to run the element. */
    fluxnova_expression?: string,
    /** The variable the result is stored in. */
    fluxnova_result_variable?: string,
    /** The topic of the external task the element creates. */
    fluxnova_topic?: string,
    /** The element's type, such as external for an external task or the form field's value type. */
    fluxnova_type?: string,
    /** The priority of the external tasks the element creates. */
    fluxnova_task_priority?: string,
    /** The QName of the operation the element calls or implements. */
    operation_ref?: string,
}


/**
 * The path of a message between two participants.
 */
export interface BpmnMessageFlow extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The id or QName of the element the connection starts at. */
    source_ref: string,
    /** The id or QName of the element the connection ends at. */
    target_ref: string,
    /** The QName of the message sent or received. */
    message_ref?: string,
}


/**
 * A link between a message flow and one that refines it.
 */
export interface BpmnMessageFlowAssociation extends BpmnBaseElement {
    /** The QName of the message flow that refines the outer one. */
    inner_message_flow_ref: string,
    /** The QName of the message flow being refined. */
    outer_message_flow_ref: string,
}


/**
 * The expression that finds a correlation property's value in a message.
 */
export interface BpmnMessagePath extends BpmnFormalExpression {
}


/**
 * A hook for monitoring a process or flow element, left to the implementation.
 */
export interface BpmnMonitoring extends BpmnBaseElement {
}


/**
 * How an activity runs once for each item of a collection, in sequence or in parallel.
 */
export interface BpmnMultiInstanceLoopCharacteristics extends BpmnLoopCharacteristics {
    /** Whether the instances run one after another rather than at once. */
    is_sequential?: boolean,
    /** When the multi-instance activity throws an event as its instances complete. */
    behavior?: string,
    /** The QName of the event thrown when the first instance completes. */
    one_behavior_event_ref?: string,
    /** The QName of the event thrown when no instance's completion matches. */
    none_behavior_event_ref?: string,
    /** Whether the engine continues asynchronously after each instance. */
    fluxnova_async_after?: boolean,
    /** Whether each instance starts asynchronously. */
    fluxnova_async_before?: boolean,
    /** Whether the instances' jobs run one at a time. */
    fluxnova_exclusive?: boolean,
    /** The collection, or the expression giving it, whose items each instance receives. */
    fluxnova_collection?: string,
    /** The variable each instance receives its item of the collection in. */
    fluxnova_element_variable?: string,
    /** How many instances to create. */
    loop_cardinality?: BpmnLoopCardinality,
    /** The id of the collection the instances are created from. */
    loop_data_input_ref?: string,
    /** The id of the collection the instances' outputs go to. */
    loop_data_output_ref?: string,
    /** The data output of each instance. */
    output_data_item?: BpmnOutputDataItem,
    /** The data input of each instance. */
    input_data_item?: BpmnInputDataItem,
    /** The rules that throw events as instances complete. */
    complex_behavior_definitions?: BpmnComplexBehaviorDefinition[],
    /** The condition that ends the activity early when it holds. */
    completion_condition?: BpmnCompletionCondition,
}


/**
 * An operation of an interface, with the messages it takes and returns.
 */
export interface BpmnOperation extends BpmnBaseElement {
    /** The element's name. */
    name: string,
    /** The QName of what implements the element. */
    implementation_ref?: string,
    /** The QName of the message the operation takes. */
    in_message_ref: string,
    /** The QName of the message the operation returns. */
    out_message_ref?: string,
    /** The QNames of the errors the operation can raise. */
    error_refs?: string[],
}


/**
 * The data output each instance of a multi-instance activity produces.
 */
export interface BpmnOutputDataItem extends BpmnDataOutput {
}


/**
 * A set of data outputs an activity or event produces together.
 */
export interface BpmnOutputSet extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The ids of the data outputs this set holds. */
    data_output_refs?: string[],
    /** The ids of outputs the set may leave out. */
    optional_output_refs?: string[],
    /** The ids of outputs the element can produce while it runs. */
    while_executing_output_refs?: string[],
    /** The ids of the input sets this output set can be produced from. */
    input_set_refs?: string[],
}


/**
 * A gateway that takes all its outgoing flows, or waits for all its incoming ones.
 */
export interface BpmnParallelGateway extends BpmnGateway {
    /** Whether the engine continues asynchronously before the element; superseded by asyncBefore. */
    fluxnova_async?: boolean,
}


/**
 * A party in a collaboration, usually drawn as a pool, and the process it runs.
 */
export interface BpmnParticipant extends BpmnBaseElement, BpmnInteractionNode {
    /** The element's name. */
    name?: string,
    /** The QName of the process the participant runs. */
    process_ref?: string,
    /** The QNames of the interfaces the participant offers. */
    interface_refs?: string[],
    /** The QNames of the end points where the participant can be reached. */
    end_point_refs?: string[],
    /** How many instances of the participant take part. */
    participant_multiplicity?: BpmnParticipantMultiplicity,
}


/**
 * A link between a participant and one that a called collaboration defines.
 */
export interface BpmnParticipantAssociation extends BpmnBaseElement {
    /** The QName of the participant inside the called collaboration. */
    inner_participant_ref: string,
    /** The QName of the participant in the calling collaboration. */
    outer_participant_ref: string,
}


/**
 * How many instances of a participant take part, from a minimum to a maximum.
 */
export interface BpmnParticipantMultiplicity extends BpmnBaseElement {
    /** The fewest instances that take part. */
    minimum?: number,
    /** The most instances that take part. */
    maximum?: number,
}


/**
 * The element a lane stands for, such as a performer.
 */
export interface BpmnPartitionElement extends BpmnBaseElement {
}


/**
 * The resource that performs an activity.
 */
export interface BpmnPerformer extends BpmnResourceRole {
}


/**
 * A person who may claim and perform a user task.
 */
export interface BpmnPotentialOwner extends BpmnHumanPerformer {
}


/**
 * A sequence of activities, events and gateways that a participant performs.
 */
export interface BpmnProcess extends BpmnCallableElement {
    /** Whether the process is private to its participant, public, or neither. */
    process_type?: string,
    /** Whether no interactions occur other than those the model shows. */
    is_closed?: boolean,
    /** Whether the process is meant to be run by an engine. */
    is_executable?: boolean,
    /** The groups whose members may start the process. */
    fluxnova_candidate_starter_groups?: string,
    /** The users who may start the process. */
    fluxnova_candidate_starter_users?: string,
    /** The default priority of the process's jobs. */
    fluxnova_job_priority?: string,
    /** The default priority of the process's external tasks. */
    fluxnova_task_priority?: string,
    /** How long the engine keeps the process's history before it may remove it. */
    fluxnova_history_time_to_live?: string,
    /** Whether the tasklist offers the process to be started. */
    fluxnova_is_startable_in_tasklist?: boolean,
    /** The tag the process version carries. */
    fluxnova_version_tag?: string,
    /** The element's auditing hook. */
    auditing?: BpmnAuditing,
    /** The element's monitoring hook. */
    monitoring?: BpmnMonitoring,
    /** The element's properties. */
    properties?: BpmnProperty[],
    /** The lane sets that divide the element. */
    lane_sets?: BpmnLaneSet[],
    /** The activities, events, gateways, sequence flows and data this element holds. */
    flow_elements?: BpmnFlowElement[],
    /** The artifacts, such as text annotations and groups, this element holds. */
    artifacts?: BpmnArtifact[],
    /** The roles resources play in the element, such as its performers. */
    resource_roles?: BpmnResourceRole[],
    /** The correlation subscriptions of the process. */
    correlation_subscriptions?: BpmnCorrelationSubscription[],
    /** The QNames of the processes this one supports. */
    supports?: string[],
}


/**
 * A variable of a process, activity or event.
 */
export interface BpmnProperty extends BpmnItemAwareElement {
    /** The element's name. */
    name?: string,
}


/**
 * A task that waits for a message.
 */
export interface BpmnReceiveTask extends BpmnTask {
    /** The technology that runs the task, as a URI; the engine reads its own settings instead. */
    implementation?: string,
    /** Whether the element starts a new process instance. */
    instantiate?: boolean,
    /** The QName of the message sent or received. */
    message_ref?: string,
    /** The QName of the operation the element calls or implements. */
    operation_ref?: string,
}


/**
 * An informal link between elements of different models.
 */
export interface BpmnRelationship extends BpmnBaseElement {
    /** What kind of relationship it is. */
    type: string,
    /** Which way the relationship points. */
    direction?: string,
    /** The QNames of the elements the relationship starts from. */
    sources: BpmnSource[],
    /** The QNames of the elements the relationship leads to. */
    targets: BpmnTarget[],
}


/**
 * A hint for how a user task appears to the person who performs it.
 */
export interface BpmnRendering extends BpmnBaseElement {
}


/**
 * A resource, such as a person or role, that can perform activities.
 */
export interface BpmnResource extends BpmnRootElement {
    /** The element's name. */
    name: string,
    /** The resource's parameters. */
    resource_parameters?: BpmnResourceParameter[],
}


/**
 * The expression that chooses who performs an activity.
 */
export interface BpmnResourceAssignmentExpression extends BpmnBaseElement {
    /** The expression that chooses the resource. */
    expression: BpmnExpression,
}


/**
 * A parameter that narrows which resources a resource stands for.
 */
export interface BpmnResourceParameter extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The QName of the parameter's type. */
    type?: string,
    /** Whether the parameter must be given a value. */
    is_required?: boolean,
}


/**
 * The value a resource role gives a resource parameter.
 */
export interface BpmnResourceParameterBinding extends BpmnBaseElement {
    /** The QName of the parameter given a value. */
    parameter_ref: string,
    /** The expression that gives the parameter its value. */
    expression: BpmnExpression,
}


/**
 * The role a resource plays in an activity or process.
 */
export interface BpmnResourceRole extends BpmnBaseElement {
    /** The element's name. */
    name?: string,
    /** The QName of the resource that plays the role. */
    resource_ref?: string,
    /** The values given to the resource's parameters. */
    resource_parameter_bindings?: BpmnResourceParameterBinding[],
    /** The expression that chooses the resource. */
    resource_assignment_expression?: BpmnResourceAssignmentExpression,
}


/**
 * An element that can sit directly in a document's definitions, such as a process or message.
 */
export interface BpmnRootElement extends BpmnBaseElement {
}


/**
 * The body of a script task's script.
 */
export interface BpmnScript extends BpmnModelElementInstance {
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * A task that runs a script.
 */
export interface BpmnScriptTask extends BpmnTask {
    /** The language the script is written in, such as groovy or javascript. */
    script_format?: string,
    /** The variable the result is stored in. */
    fluxnova_result_variable?: string,
    /** A resource that holds the script, instead of the script's text. */
    fluxnova_resource?: string,
    /** The script the task runs. */
    script?: BpmnScript,
}


/**
 * A task that sends a message.
 */
export interface BpmnSendTask extends BpmnTask {
    /** The technology that runs the task, as a URI; the engine reads its own settings instead. */
    implementation?: string,
    /** The QName of the message sent or received. */
    message_ref?: string,
    /** The QName of the operation the element calls or implements. */
    operation_ref?: string,
    /** The Java class the engine instantiates to run the element. */
    fluxnova_class?: string,
    /** An expression that gives the delegate object the engine calls. */
    fluxnova_delegate_expression?: string,
    /** An expression the engine evaluates to run the element. */
    fluxnova_expression?: string,
    /** The variable the result is stored in. */
    fluxnova_result_variable?: string,
    /** The topic of the external task the element creates. */
    fluxnova_topic?: string,
    /** The element's type, such as external for an external task or the form field's value type. */
    fluxnova_type?: string,
    /** The priority of the external tasks the element creates. */
    fluxnova_task_priority?: string,
}


/**
 * The order of two flow nodes in a process, from a source to a target.
 */
export interface BpmnSequenceFlow extends BpmnFlowElement {
    /** The id or QName of the element the connection starts at. */
    source_ref: string,
    /** The id or QName of the element the connection ends at. */
    target_ref: string,
    /** Whether the flow's target follows its source with no other activity between them. */
    is_immediate?: boolean,
    /** The condition that decides whether the flow is taken. */
    condition_expression?: BpmnConditionExpression,
}


/**
 * A task that calls a service, such as a web service or application code.
 */
export interface BpmnServiceTask extends BpmnTask {
    /** The technology that runs the task, as a URI; the engine reads its own settings instead. */
    implementation?: string,
    /** The QName of the operation the element calls or implements. */
    operation_ref?: string,
    /** The Java class the engine instantiates to run the element. */
    fluxnova_class?: string,
    /** An expression that gives the delegate object the engine calls. */
    fluxnova_delegate_expression?: string,
    /** An expression the engine evaluates to run the element. */
    fluxnova_expression?: string,
    /** The variable the result is stored in. */
    fluxnova_result_variable?: string,
    /** The topic of the external task the element creates. */
    fluxnova_topic?: string,
    /** The element's type, such as external for an external task or the form field's value type. */
    fluxnova_type?: string,
    /** The priority of the external tasks the element creates. */
    fluxnova_task_priority?: string,
}


/**
 * A signal that is broadcast to every event waiting for it.
 */
export interface BpmnSignal extends BpmnRootElement {
    /** The element's name. */
    name?: string,
    /** The QName of the type of the data, such as an XML Schema type. */
    structure_ref?: string,
}


/**
 * The trigger of an event that sends or receives a signal.
 */
export interface BpmnSignalEventDefinition extends BpmnEventDefinition {
    /** The QName of the signal sent or received. */
    signal_ref?: string,
    /** Whether the engine continues asynchronously before the element; superseded by asyncBefore. */
    fluxnova_async?: boolean,
}


/**
 * An element a relationship starts from.
 */
export interface BpmnSource extends BpmnModelElementInstance {
}


/**
 * An event that starts a process or sub-process.
 */
export interface BpmnStartEvent extends BpmnCatchEvent {
    /** Whether the event, when it starts an event sub-process, interrupts its parent. */
    is_interrupting?: boolean,
    /** Whether the engine continues asynchronously before the element; superseded by asyncBefore. */
    fluxnova_async?: boolean,
    /** The Java class that handles the form. */
    fluxnova_form_handler_class?: string,
    /** The key of the form to show. */
    fluxnova_form_key?: string,
    /** The key of the deployed form to show. */
    fluxnova_form_ref?: string,
    /** Which version of the deployed form to use. */
    fluxnova_form_ref_binding?: string,
    /** The version of the deployed form, when the binding asks for one. */
    fluxnova_form_ref_version?: string,
    /** The variable the id of the user who started the process is stored in. */
    fluxnova_initiator?: string,
}


/**
 * A conversation node that groups other conversation nodes.
 */
export interface BpmnSubConversation extends BpmnConversationNode {
    /** The conversations and sub-conversations this element holds. */
    conversation_nodes?: BpmnConversationNode[],
}


/**
 * An activity that holds a process of its own.
 */
export interface BpmnSubProcess extends BpmnActivity {
    /** Whether the sub-process is an event sub-process, started by an event. */
    triggered_by_event?: boolean,
    /** Whether the engine continues asynchronously before the element; superseded by asyncBefore. */
    fluxnova_async?: boolean,
    /** The lane sets that divide the element. */
    lane_sets?: BpmnLaneSet[],
    /** The activities, events, gateways, sequence flows and data this element holds. */
    flow_elements?: BpmnFlowElement[],
    /** The artifacts, such as text annotations and groups, this element holds. */
    artifacts?: BpmnArtifact[],
}


/**
 * An element a relationship leads to.
 */
export interface BpmnTarget extends BpmnModelElementInstance {
}


/**
 * An atomic activity, one that is not broken down further.
 */
export interface BpmnTask extends BpmnActivity {
    /** Whether the engine continues asynchronously before the element; superseded by asyncBefore. */
    fluxnova_async?: boolean,
}


/**
 * The trigger of an end event that ends the whole process instance at once.
 */
export interface BpmnTerminateEventDefinition extends BpmnEventDefinition {
}


/**
 * The text of a text annotation.
 */
export interface BpmnText extends BpmnModelElementInstance {
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * An artifact that adds a note to a diagram.
 */
export interface BpmnTextAnnotation extends BpmnArtifact {
    /** The format of the text, as a MIME type. */
    text_format?: string,
    /** The annotation's text. */
    text?: BpmnText,
}


/**
 * An event that throws a trigger, such as an end or intermediate throw event.
 */
export interface BpmnThrowEvent extends BpmnEvent {
    /** The data inputs. */
    data_inputs?: BpmnDataInput[],
    /** How data reaches the element's inputs. */
    data_input_associations?: BpmnDataInputAssociation[],
    /** The input set the event's data inputs make up. */
    input_set?: BpmnInputSet,
    /** The event definitions that trigger this event. */
    event_definitions?: BpmnEventDefinition[],
    /** The QNames of event definitions, defined elsewhere in the document, that trigger this event. */
    event_definition_refs?: string[],
}


/**
 * The expression for a timer that fires repeatedly.
 */
export interface BpmnTimeCycle extends BpmnExpression {
}


/**
 * The expression for a timer that fires at a point in time.
 */
export interface BpmnTimeDate extends BpmnExpression {
}


/**
 * The expression for a timer that fires once a duration has passed.
 */
export interface BpmnTimeDuration extends BpmnExpression {
}


/**
 * The trigger of an event that fires at a time, after a duration or on a cycle.
 */
export interface BpmnTimerEventDefinition extends BpmnEventDefinition {
    /** The timer's point in time. */
    time_date?: BpmnTimeDate,
    /** The timer's duration. */
    time_duration?: BpmnTimeDuration,
    /** The timer's cycle. */
    time_cycle?: BpmnTimeCycle,
}


/**
 * The expression an assignment copies a value to.
 */
export interface BpmnTo extends BpmnExpression {
}


/**
 * A sub-process whose activities succeed or are undone together.
 */
export interface BpmnTransaction extends BpmnSubProcess {
    /** How the transaction commits or cancels; compensation unless the document says otherwise. */
    method?: string,
}


/**
 * The expression that changes data as a data association copies it.
 */
export interface BpmnTransformation extends BpmnFormalExpression {
}


/**
 * A task a person performs with the help of a software application.
 */
export interface BpmnUserTask extends BpmnTask {
    /** The technology that runs the task, as a URI. */
    implementation?: string,
    /** The user the task is assigned to, as a user id or an expression. */
    fluxnova_assignee?: string,
    /** The groups whose members may claim the task, as a comma-separated list or an expression. */
    fluxnova_candidate_groups?: string,
    /** The users who may claim the task, as a comma-separated list or an expression. */
    fluxnova_candidate_users?: string,
    /** When the task is due, as a date or an expression. */
    fluxnova_due_date?: string,
    /** When the task should be looked at again, as a date or an expression. */
    fluxnova_follow_up_date?: string,
    /** The Java class that handles the form. */
    fluxnova_form_handler_class?: string,
    /** The key of the form to show. */
    fluxnova_form_key?: string,
    /** The key of the deployed form to show. */
    fluxnova_form_ref?: string,
    /** Which version of the deployed form to use. */
    fluxnova_form_ref_binding?: string,
    /** The version of the deployed form, when the binding asks for one. */
    fluxnova_form_ref_version?: string,
    /** The task's priority, as a number or an expression. */
    fluxnova_priority?: string,
    /** Hints for how the task appears to its performer. */
    renderings?: BpmnRendering[],
}


/**
 * A connector that a service task or message event calls, with its id and its inputs and outputs.
 */
export interface FluxnovaConnector extends BpmnModelElementInstance {
    /** The id of the connector to call. */
    connector_id: FluxnovaConnectorId,
    /** The connector's input and output parameters. */
    input_output?: FluxnovaInputOutput,
}


/**
 * The id of the connector to call.
 */
export interface FluxnovaConnectorId extends BpmnModelElementInstance {
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * A rule a form field's value must meet, such as required or a maximum length.
 */
export interface FluxnovaConstraint extends BpmnModelElementInstance {
    /** The constraint's name, such as required, minlength or max. */
    fluxnova_name?: string,
    /** The constraint's setting, such as the maximum length. */
    fluxnova_config?: string,
}


/**
 * One key and value of a map.
 */
export interface FluxnovaEntry extends BpmnModelElementInstance {
    /** The entry's key. */
    fluxnova_key: string,
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * An error event definition on an external service task, raised when its expression holds.
 */
export interface FluxnovaErrorEventDefinition extends BpmnModelElementInstance {
    /** The expression that, when true, raises the error. */
    fluxnova_expression?: string,
}


/**
 * Code the engine runs when an execution passes an event of an element, such as its start or end.
 */
export interface FluxnovaExecutionListener extends BpmnModelElementInstance {
    /** The event the listener runs on, such as start, end, take, create or complete. */
    fluxnova_event?: string,
    /** The Java class the engine instantiates to run the element. */
    fluxnova_class?: string,
    /** An expression the engine evaluates when the listener runs. */
    fluxnova_expression?: string,
    /** An expression that gives the delegate object the engine calls. */
    fluxnova_delegate_expression?: string,
    /** The fields injected into the listener's delegate class. */
    fields?: FluxnovaField[],
    /** The script the listener runs. */
    script?: FluxnovaScript,
}


/**
 * An expression a field injects.
 */
export interface FluxnovaExpression extends BpmnModelElementInstance {
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * How often, and how many times, the engine retries a failed job.
 */
export interface FluxnovaFailedJobRetryTimeCycle extends BpmnModelElementInstance {
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * A value injected into a field of a delegate class, as a string or an expression.
 */
export interface FluxnovaField extends BpmnModelElementInstance {
    /** The name of the field to inject. */
    fluxnova_name?: string,
    /** The expression injected into the field. */
    fluxnova_expression?: string,
    /** The string injected into the field. */
    fluxnova_string_value?: string,
    /** The expression injected into the field. */
    expression?: FluxnovaExpression,
    /** The string injected into the field. */
    string?: FluxnovaString,
}


/**
 * The form fields of a generated task or start form.
 */
export interface FluxnovaFormData extends BpmnModelElementInstance {
    /** The fields of the form. */
    form_fields?: FluxnovaFormField[],
}


/**
 * One field of a generated form.
 */
export interface FluxnovaFormField extends BpmnModelElementInstance {
    /** The field's id, which names the variable it is stored in. */
    fluxnova_id?: string,
    /** The label shown with the field. */
    fluxnova_label?: string,
    /** The type of the field's value, such as string, long, boolean, date or enum. */
    fluxnova_type?: string,
    /** The pattern a date value is written in. */
    fluxnova_date_pattern?: string,
    /** The field's default value. */
    fluxnova_default_value?: string,
    /** The field's properties. */
    properties?: FluxnovaProperties,
    /** The rules the field's value must meet. */
    validation?: FluxnovaValidation,
    /** The options of an enumerated field. */
    values?: FluxnovaValue[],
}


/**
 * A form property, the older way of declaring a generated form's fields.
 */
export interface FluxnovaFormProperty extends BpmnModelElementInstance {
    /** The property's id. */
    fluxnova_id?: string,
    /** The property's label. */
    fluxnova_name?: string,
    /** The type of the property's value. */
    fluxnova_type?: string,
    /** Whether the property must be given a value. */
    fluxnova_required?: boolean,
    /** Whether the property can be read. */
    fluxnova_readable?: boolean,
    /** Whether the property can be written. */
    fluxnova_writeable?: boolean,
    /** The variable the property is bound to. */
    fluxnova_variable?: string,
    /** An expression that gives the property's value. */
    fluxnova_expression?: string,
    /** The pattern a date value is written in. */
    fluxnova_date_pattern?: string,
    /** The property's default value. */
    fluxnova_default?: string,
    /** The options of an enumerated field. */
    values?: FluxnovaValue[],
}


/**
 * A variable or business key passed into a called process or case.
 */
export interface FluxnovaIn extends BpmnModelElementInstance {
    /** The variable in the source scope to pass. */
    fluxnova_source?: string,
    /** The expression whose value is passed. */
    fluxnova_source_expression?: string,
    /** Which variables are passed; all passes every one. */
    fluxnova_variables?: string,
    /** The variable in the target scope that receives the value. */
    fluxnova_target?: string,
    /** The business key passed to the called process. */
    fluxnova_business_key?: string,
    /** Whether only the local variables of the calling scope are passed. */
    fluxnova_local?: boolean,
    /** Whether the mapping is restricted, a setting Fluxnova adds in its own namespace. */
    fluxnova_restricted?: boolean,
}


/**
 * The input and output parameters of an activity or connector.
 */
export interface FluxnovaInputOutput extends BpmnModelElementInstance {
    /** The input parameters. */
    input_parameters?: FluxnovaInputParameter[],
    /** The output parameters. */
    output_parameters?: FluxnovaOutputParameter[],
}


/**
 * A variable set in an activity's scope before it starts.
 */
export interface FluxnovaInputParameter extends BpmnModelElementInstance {
    /** The variable the parameter sets. */
    fluxnova_name: string,
    /** Whether the mapping is restricted, a setting Fluxnova adds in its own namespace. */
    fluxnova_restricted?: boolean,
    /** Whether the variable is kept only while the transaction runs. */
    fluxnova_is_transient?: boolean,
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * A list value of a parameter.
 */
export interface FluxnovaList extends BpmnModelElementInstance {
}


/**
 * A map value of a parameter.
 */
export interface FluxnovaMap extends BpmnModelElementInstance {
    /** The map's entries. */
    entries?: FluxnovaEntry[],
}


/**
 * A variable passed back from a called process or case.
 */
export interface FluxnovaOut extends BpmnModelElementInstance {
    /** The variable in the source scope to pass. */
    fluxnova_source?: string,
    /** The expression whose value is passed. */
    fluxnova_source_expression?: string,
    /** Which variables are passed; all passes every one. */
    fluxnova_variables?: string,
    /** The variable in the target scope that receives the value. */
    fluxnova_target?: string,
    /** Whether only the local variables of the calling scope are passed. */
    fluxnova_local?: boolean,
    /** Whether the mapping is restricted, a setting Fluxnova adds in its own namespace. */
    fluxnova_restricted?: boolean,
}


/**
 * A variable set outside an activity once it ends.
 */
export interface FluxnovaOutputParameter extends BpmnModelElementInstance {
    /** The variable the parameter sets. */
    fluxnova_name: string,
    /** Whether the mapping is restricted, a setting Fluxnova adds in its own namespace. */
    fluxnova_restricted?: boolean,
    /** Whether the variable is kept only while the transaction runs. */
    fluxnova_is_transient?: boolean,
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * The users or groups who may start a process.
 */
export interface FluxnovaPotentialStarter extends BpmnModelElementInstance {
    /** The expression that chooses the resource. */
    resource_assignment_expression?: BpmnResourceAssignmentExpression,
}


/**
 * A set of key and value properties on an element.
 */
export interface FluxnovaProperties extends BpmnModelElementInstance {
    /** The properties. */
    properties?: FluxnovaProperty[],
}


/**
 * One key and value property.
 */
export interface FluxnovaProperty extends BpmnModelElementInstance {
    /** The property's id. */
    fluxnova_id?: string,
    /** The property's name. */
    fluxnova_name?: string,
    /** The property's value. */
    fluxnova_value?: string,
}


/**
 * A script whose result is a value, such as a parameter's or a listener's.
 */
export interface FluxnovaScript extends BpmnModelElementInstance {
    /** The language the script is written in, such as groovy or javascript. */
    script_format: string,
    /** A resource that holds the script, instead of the script's text. */
    resource?: string,
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * A string a field injects.
 */
export interface FluxnovaString extends BpmnModelElementInstance {
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * Code the engine runs when a user task reaches an event, such as its creation or completion.
 */
export interface FluxnovaTaskListener extends BpmnModelElementInstance {
    /** The event the listener runs on, such as start, end, take, create or complete. */
    fluxnova_event?: string,
    /** The Java class the engine instantiates to run the element. */
    fluxnova_class?: string,
    /** An expression the engine evaluates when the listener runs. */
    fluxnova_expression?: string,
    /** An expression that gives the delegate object the engine calls. */
    fluxnova_delegate_expression?: string,
    /** The fields injected into the listener's delegate class. */
    fields?: FluxnovaField[],
    /** The script the listener runs. */
    script?: FluxnovaScript,
    /** The timer of a listener that runs on a timeout. */
    timer_event_definition?: BpmnTimerEventDefinition,
}


/**
 * The constraints of a form field.
 */
export interface FluxnovaValidation extends BpmnModelElementInstance {
    /** The constraints the value must meet. */
    constraints?: FluxnovaConstraint[],
}


/**
 * One option of an enumerated form field.
 */
export interface FluxnovaValue extends BpmnModelElementInstance {
    /** The option's id, its stored value. */
    fluxnova_id?: string,
    /** The option's label. */
    fluxnova_name?: string,
    /** The element's text, such as the body of an expression or a script. */
    text_content?: string,
}


/**
 * Root container for Fluxnova BPM Platform data.
 */
export interface FluxnovaPlatformData {
    /** Deployed resources. */
    deployments?: FluxnovaDeployment[],
    /** Process definitions. */
    process_definitions?: FluxnovaProcessDefinition[],
    /** Process execution instances. */
    executions?: FluxnovaExecution[],
    /** User tasks. */
    tasks?: FluxnovaTask[],
    /** Asynchronous jobs. */
    jobs?: FluxnovaJob[],
    /** Identity users. */
    users?: FluxnovaUser[],
    /** Identity groups. */
    groups?: FluxnovaGroup[],
    /** Batch operations. */
    batches?: FluxnovaBatch[],
}



