-- # Class: FluxnovaPlatformData Description: Root container for Fluxnova BPM Platform data.
--     * Slot: id
-- # Class: FluxnovaAttachment Description: Any type of content that is be associated with a task or with a process instance.
--     * Slot: id Description: Unique identifier.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: name Description: Human-readable name.
--     * Slot: description Description: Human-readable description.
--     * Slot: type Description: Type discriminator.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: url Description: The remote URL in case this is remote content.
--     * Slot: content_id Description: Reference to the content.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: created_by Description: The user who created this attachment.
-- # Class: FluxnovaAuthorization Description: An Authorization assigns a set of Permissions to an identity to interact with a given Resource.
--     * Slot: id Description: Unique identifier.
--     * Slot: type Description: Type discriminator.
--     * Slot: group_id Description: Reference to a group.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: resource_type Description: Numeric type of the authorized resource.
--     * Slot: resource_id Description: Reference to the resource.
--     * Slot: permissions Description: Bitmask of granted permissions.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
-- # Class: FluxnovaBatch Description: A batch represents a number of jobs which execute a number of commands asynchronously.
--     * Slot: id Description: Unique identifier.
--     * Slot: type Description: Type discriminator.
--     * Slot: total_jobs Description: Total number of jobs.
--     * Slot: jobs_created Description: The jobs created.
--     * Slot: jobs_per_seed Description: The jobs per seed.
--     * Slot: invocations_per_job Description: The invocations per job.
--     * Slot: seed_job_definition_id Description: Reference to a JobDefinition.
--     * Slot: batch_job_definition_id Description: Reference to a JobDefinition.
--     * Slot: monitor_job_definition_id Description: Reference to a JobDefinition.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: configuration Description: Payload of this incident.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: create_user_id Description: The authenticated user that created this case instance.
--     * Slot: start_time Description: Start timestamp.
--     * Slot: execution_start_time Description: Timestamp when this started.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: FluxnovaByteArray Description: Byte Array entity in the engine infrastructure.
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: bytes Description: Serialized binary content.
--     * Slot: is_generated Description: Whether this entity is generated.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: type Description: Type discriminator.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaCaseDefinition Description: A deployed case definition in the process repository.
--     * Slot: id Description: Unique identifier.
--     * Slot: key Description: Business key for the definition.
--     * Slot: name Description: Human-readable name.
--     * Slot: version Description: Version number.
--     * Slot: category Description: Category classification.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: resource_name Description: Name of the deployed resource file.
--     * Slot: diagram_resource_name Description: Name of the diagram resource file.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: history_time_to_live Description: Days to retain history before cleanup.
-- # Class: FluxnovaCaseExecution Description: Case Execution entity in the process execution runtime.
--     * Slot: id Description: Unique identifier.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: super_case_execution_id Description: Reference to the super case execution.
--     * Slot: super_execution_id Description: Reference to the super execution.
--     * Slot: business_key Description: Domain-specific business key.
--     * Slot: parent_id Description: Reference to a CaseExecution.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: previous_state Description: The previous state.
--     * Slot: current_state Description: The current state.
--     * Slot: is_required Description: Whether this entity is required.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
-- # Class: FluxnovaCaseSentryPart Description: Case Sentry Part entity in the process execution runtime.
--     * Slot: id Description: Unique identifier.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_execution_id Description: Reference to the case execution.
--     * Slot: sentry_id Description: Reference to the sentry.
--     * Slot: type Description: Type discriminator.
--     * Slot: source_case_execution_id Description: Reference to the source case execution.
--     * Slot: standard_event Description: The standard event.
--     * Slot: source Description: The source.
--     * Slot: variable_event Description: The variable event.
--     * Slot: variable_name Description: The name of the output variable.
--     * Slot: is_satisfied Description: Whether this entity is satisfied.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
-- # Class: FluxnovaComment Description: User comments that form discussions around tasks.
--     * Slot: id Description: Unique identifier.
--     * Slot: type Description: Type discriminator.
--     * Slot: event_time Description: Timestamp for event time.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: action Description: The action.
--     * Slot: message Description: Short message or summary.
--     * Slot: full_message Description: The full comment message the user had related to the task and/or process instance.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaConfiguration Description: A process configuration entry: a key/value pair which is either global or scoped to a single tenant.
--     * Slot: id Description: Unique identifier.
--     * Slot: configuration_key Description: The configuration key.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: configuration_value Description: The configuration value.
--     * Slot: version Description: Version number.
--     * Slot: status Description: The status.
--     * Slot: created_by Description: The user who created this attachment.
--     * Slot: created_at Description: Timestamp when this was created.
--     * Slot: updated_by Description: The updated by.
--     * Slot: updated_at Description: Timestamp for updated at.
-- # Class: FluxnovaDecisionDefinition Description: Definition of a decision resource.
--     * Slot: decision_requirements_definition_id Description: Id of the related decision requirements definition.
--     * Slot: decision_requirements_definition_key Description: Key of the related decision requirements definition.
--     * Slot: version_tag Description: Version tag of the process definition.
--     * Slot: id Description: Unique identifier.
--     * Slot: key Description: Business key for the definition.
--     * Slot: name Description: Human-readable name.
--     * Slot: version Description: Version number.
--     * Slot: category Description: Category classification.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: resource_name Description: Name of the deployed resource file.
--     * Slot: diagram_resource_name Description: Name of the diagram resource file.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: history_time_to_live Description: Days to retain history before cleanup.
-- # Class: FluxnovaDecisionRequirementsDefinition Description: Container of DecisionDefinitions which belongs to the same decision requirements graph (i.e. DMN resource).
--     * Slot: id Description: Unique identifier.
--     * Slot: key Description: Business key for the definition.
--     * Slot: name Description: Human-readable name.
--     * Slot: version Description: Version number.
--     * Slot: category Description: Category classification.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: resource_name Description: Name of the deployed resource file.
--     * Slot: diagram_resource_name Description: Name of the diagram resource file.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: history_time_to_live Description: Days to retain history before cleanup.
-- # Class: FluxnovaDeployment Description: Represents a deployment that is already present in the process repository.
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: deploy_time Description: Timestamp for deploy time.
--     * Slot: source Description: The source.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: FluxnovaEventSubscription Description: A message event subscription exists, if an Execution waits for an event like a message.
--     * Slot: id Description: Unique identifier.
--     * Slot: event_type Description: The event subscriptions type. "message" identifies message event subscriptions, "signal" identifies signal event subscription, "compensation" identifies event subscriptions used for compensation events.
--     * Slot: event_name Description: The name of the event this subscription belongs to as defined in the process model.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: configuration Description: Payload of this incident.
--     * Slot: created Description: The time this event subscription was created.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
-- # Class: FluxnovaExecution Description: Represent a 'path of execution' in a process instance.
--     * Slot: id Description: Unique identifier.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: business_key Description: Domain-specific business key.
--     * Slot: parent_id Description: Reference to a CaseExecution.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: super_execution_id Description: Reference to the super execution.
--     * Slot: super_case_execution_id Description: Reference to the super case execution.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: activity_instance_id Description: Runtime activity instance identifier.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: is_active Description: Whether this entity is active.
--     * Slot: is_concurrent Description: Whether this entity is concurrent.
--     * Slot: is_scope Description: Whether this entity is scope.
--     * Slot: is_event_scope Description: Whether this entity is event scope.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: cached_entity_state Description: Bitmask caching associated entity existence.
--     * Slot: sequence_counter Description: Monotonically increasing counter for ordering.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: FluxnovaExternalTask Description: Represents an instance of an external task that is created when a service-task like activity (i.e. service task, send task, ...) with attribute camunda:type="external" is executed.
--     * Slot: id Description: Unique identifier.
--     * Slot: worker_id Description: Id of the worker that fetched the external task most recently.
--     * Slot: topic_name Description: Topic name of the associated external task.
--     * Slot: retries Description: Number of retries this job has left.
--     * Slot: error_message Description: If the variable value could not be loaded, this returns the error message.
--     * Slot: error_details_id Description: Reference to a ByteArray.
--     * Slot: lock_expiration_time Description: Time at which the lock expires.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: activity_instance_id Description: Runtime activity instance identifier.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest.
--     * Slot: last_failure_log_id Description: Reference to the last failure log.
-- # Class: FluxnovaFilter Description: Filter entity in the user collaboration.
--     * Slot: id Description: Unique identifier.
--     * Slot: resource_type Description: Numeric type of the authorized resource.
--     * Slot: name Description: Human-readable name.
--     * Slot: owner Description: The userId of the person that is responsible for this task.
--     * Slot: query Description: Serialized query expression.
--     * Slot: properties Description: Serialized properties.
-- # Class: FluxnovaFormDefinition Description: An object structure representing a Camunda Form used to present forms to users either when starting a process instance or when assigned to a User Task.
--     * Slot: id Description: Unique identifier.
--     * Slot: key Description: Business key for the definition.
--     * Slot: name Description: Human-readable name.
--     * Slot: version Description: Version number.
--     * Slot: category Description: Category classification.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: resource_name Description: Name of the deployed resource file.
--     * Slot: diagram_resource_name Description: Name of the diagram resource file.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: history_time_to_live Description: Days to retain history before cleanup.
-- # Class: FluxnovaGroup Description: Represents a group, used in IdentityService.
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: type Description: Type discriminator.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: FluxnovaHistoricActivityInstance Description: Represents one execution of an activity and it's stored permanent for statistics, audit and other business intelligence purposes.
--     * Slot: parent_activity_instance_id Description: Id of the parent activity instance.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: called_process_instance_id Description: The called process instance in case of call activity.
--     * Slot: called_case_instance_id Description: The called case instance in case of (case) call activity.
--     * Slot: activity_name Description: The display name for the activity.
--     * Slot: activity_type Description: The activity type of the activity.
--     * Slot: assignee Description: The userId of the person to which this task is String) assigned or String) delegated.
--     * Slot: activity_instance_state Description: The activity instance state.
--     * Slot: sequence_counter Description: Monotonically increasing counter for ordering.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: id Description: Unique identifier.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: start_time Description: Start timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: duration Description: Duration in milliseconds.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricBatch Description: Historic representation of a Batch.
--     * Slot: id Description: Unique identifier.
--     * Slot: type Description: Type discriminator.
--     * Slot: total_jobs Description: Total number of jobs.
--     * Slot: jobs_per_seed Description: The jobs per seed.
--     * Slot: invocations_per_job Description: The invocations per job.
--     * Slot: seed_job_definition_id Description: Reference to a JobDefinition.
--     * Slot: monitor_job_definition_id Description: Reference to a JobDefinition.
--     * Slot: batch_job_definition_id Description: Reference to a JobDefinition.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: create_user_id Description: The authenticated user that created this case instance.
--     * Slot: start_time Description: Start timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: execution_start_time Description: Timestamp when this started.
-- # Class: FluxnovaHistoricCaseActivityInstance Description: Represents one execution of a case activity which is stored permanent for statistics, audit and other business intelligence purposes.
--     * Slot: parent_activity_instance_id Description: Id of the parent activity instance.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_activity_id Description: The unique identifier of the case activity in the case.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: called_process_instance_id Description: The called process instance in case of call activity.
--     * Slot: called_case_instance_id Description: The called case instance in case of (case) call activity.
--     * Slot: case_activity_name Description: The display name for the case activity.
--     * Slot: case_activity_type Description: The display type for the case activity.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: state Description: The row's state; which values it takes depends on its table.
--     * Slot: is_required Description: Whether this entity is required.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: id Description: Unique identifier.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: start_time Description: Start timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: duration Description: Duration in milliseconds.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricCaseInstance Description: A single execution of a case definition that is stored permanently.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: business_key Description: Domain-specific business key.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: close_time Description: The time the case was closed.
--     * Slot: state Description: The row's state; which values it takes depends on its table.
--     * Slot: create_user_id Description: The authenticated user that created this case instance.
--     * Slot: super_case_instance_id Description: The case instance id of a potential super case instance or null if no super case instance exists.
--     * Slot: super_process_instance_id Description: The process instance id of a potential super process instance or null if no super process instance exists.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: id Description: Unique identifier.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: start_time Description: Start timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: duration Description: Duration in milliseconds.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricDecisionInputInstance Description: Represents one input variable of a decision evaluation.
--     * Slot: id Description: Unique identifier.
--     * Slot: decision_instance_id Description: The unique identifier of the historic decision instance.
--     * Slot: clause_id Description: The unique identifier of the clause that the value is assigned for.
--     * Slot: clause_name Description: The name of the clause that the value is assigned for.
--     * Slot: variable_type Description: The variable type.
--     * Slot: byte_array_id Description: Reference to the byte array.
--     * Slot: double_value Description: Variable value stored as double.
--     * Slot: long_value Description: Variable value stored as long.
--     * Slot: text_value Description: Variable value stored as text.
--     * Slot: text2_value Description: Variable value stored as text2.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricDecisionInstance Description: Represents one evaluation of a decision.
--     * Slot: id Description: Unique identifier.
--     * Slot: decision_definition_id Description: The decision definition reference.
--     * Slot: decision_definition_key Description: The unique identifier of the decision definition.
--     * Slot: decision_definition_name Description: The name of the decision definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: case_definition_key Description: Case definition key reference.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: activity_instance_id Description: Runtime activity instance identifier.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: evaluation_time Description: Time when the decision was evaluated.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: collect_result_value Description: The result of the collect operation if the hit policy 'collect' was used for the decision.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: root_decision_instance_id Description: The unique identifier of the historic decision instance of the evaluated root decision.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: decision_requirements_definition_id Description: Id of the related decision requirements definition.
--     * Slot: decision_requirements_definition_key Description: Key of the related decision requirements definition.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
-- # Class: FluxnovaHistoricDecisionOutputInstance Description: Represents one output variable of a decision evaluation.
--     * Slot: id Description: Unique identifier.
--     * Slot: decision_instance_id Description: The unique identifier of the historic decision instance.
--     * Slot: clause_id Description: The unique identifier of the clause that the value is assigned for.
--     * Slot: clause_name Description: The name of the clause that the value is assigned for.
--     * Slot: rule_id Description: The unique identifier of the rule that is matched.
--     * Slot: rule_order Description: The order of the rule that is matched.
--     * Slot: variable_name Description: The name of the output variable.
--     * Slot: variable_type Description: The variable type.
--     * Slot: byte_array_id Description: Reference to the byte array.
--     * Slot: double_value Description: Variable value stored as double.
--     * Slot: long_value Description: Variable value stored as long.
--     * Slot: text_value Description: Variable value stored as text.
--     * Slot: text2_value Description: Variable value stored as text2.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricDetail Description: Base class for all kinds of information that is related to either a HistoricProcessInstance or a HistoricActivityInstance.
--     * Slot: id Description: Unique identifier.
--     * Slot: type Description: Type discriminator.
--     * Slot: event_time Description: Timestamp for event time.
--     * Slot: name Description: Human-readable name.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: case_definition_key Description: Case definition key reference.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_execution_id Description: Reference to the case execution.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: activity_instance_id Description: Runtime activity instance identifier.
--     * Slot: variable_instance_id Description: Reference to the variable instance.
--     * Slot: variable_type Description: The variable type.
--     * Slot: byte_array_id Description: Reference to the byte array.
--     * Slot: double_value Description: Variable value stored as double.
--     * Slot: long_value Description: Variable value stored as long.
--     * Slot: text_value Description: Variable value stored as text.
--     * Slot: text2_value Description: Variable value stored as text2.
--     * Slot: sequence_counter Description: Monotonically increasing counter for ordering.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: operation_id Description: The unique identifier of this operation.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: is_initial Description: Whether this entity is initial.
-- # Class: FluxnovaHistoricExternalTaskLog Description: The HistoricExternalTaskLog is used to have a log containing information about task execution.
--     * Slot: id Description: Unique identifier.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: external_task_id Description: Id of the associated external task.
--     * Slot: retries Description: Number of retries this job has left.
--     * Slot: topic_name Description: Topic name of the associated external task.
--     * Slot: worker_id Description: Id of the worker that fetched the external task most recently.
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest.
--     * Slot: error_message Description: If the variable value could not be loaded, this returns the error message.
--     * Slot: error_details_id Description: Reference to a ByteArray.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: activity_instance_id Description: Runtime activity instance identifier.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: state Description: The row's state; which values it takes depends on its table.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricIdentityLink Description: An historic identity link stores the association of a task with a certain identity.
--     * Slot: id Description: Unique identifier.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: type Description: Type discriminator.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: group_id Description: Reference to a group.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: operation_type Description: Type of identity link history (add or delete identity link).
--     * Slot: assigner_id Description: UserId of the user who assigns a task to the user.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricIncident Description: Represents a historic incident that is stored permanently.
--     * Slot: id Description: Unique identifier.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: incident_message Description: Incident message.
--     * Slot: incident_type Description: Type of this incident to identify the kind of incident.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: failed_activity_id Description: Id of the activity on which the last exception occurred.
--     * Slot: cause_incident_id Description: Id of the incident on which this incident has been triggered.
--     * Slot: root_cause_incident_id Description: Id of the root incident on which this transitive incident has been triggered.
--     * Slot: configuration Description: Payload of this incident.
--     * Slot: history_configuration Description: History payload of this incident.
--     * Slot: incident_state Description: The incident state.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: job_definition_id Description: Reference to the job definition.
--     * Slot: annotation Description: Annotation of this incident.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricJobLog Description: The HistoricJobLog is used to have a log containing information about job execution.
--     * Slot: id Description: Unique identifier.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: job_id Description: Id of the associated job.
--     * Slot: job_due_date Description: Due date of the associated job when this log occurred.
--     * Slot: job_retries Description: Retries of the associated job before the associated job has been executed and when this log occurred.
--     * Slot: job_priority Description: Priority of the associated job when this log entry was created.
--     * Slot: job_exception_message Description: Message of the exception that occurred by executing the associated job.
--     * Slot: job_exception_stack_id Description: Reference to the job exception stack.
--     * Slot: job_state Description: The job state.
--     * Slot: job_definition_id Description: Reference to the job definition.
--     * Slot: job_definition_type Description: Job definition type of the associated job.
--     * Slot: job_definition_configuration Description: Job definition configuration type of the associated job.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: failed_activity_id Description: Id of the activity on which the last exception occurred.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: sequence_counter Description: Monotonically increasing counter for ordering.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: hostname Description: Name of the host where the Process Engine that added this job log runs.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: batch_id Description: Reference to a batch.
-- # Class: FluxnovaHistoricProcessInstance Description: A single execution of a whole process definition that is stored permanently.
--     * Slot: business_key Description: Domain-specific business key.
--     * Slot: start_user_id Description: The authenticated user that started this process instance.
--     * Slot: start_activity_id Description: The start activity.
--     * Slot: end_activity_id Description: Reference to the end activity.
--     * Slot: super_process_instance_id Description: The process instance id of a potential super process instance or null if no super process instance exists.
--     * Slot: super_case_instance_id Description: The case instance id of a potential super case instance or null if no super case instance exists.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: delete_reason Description: Obtains the reason for the process instance's deletion.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: state Description: The row's state; which values it takes depends on its table.
--     * Slot: restarted_process_instance_id Description: The id of the original process instance which was restarted.
--     * Slot: id Description: Unique identifier.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: start_time Description: Start timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: duration Description: Duration in milliseconds.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Abstract Class: FluxnovaHistoricScopeInstance Description: Abstract base for historic entities with start/end time and duration.
--     * Slot: id Description: Unique identifier.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: start_time Description: Start timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: duration Description: Duration in milliseconds.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricTaskInstance Description: Represents a historic task instance (waiting, finished or deleted) that is stored permanent for statistics, audit and other business intelligence purposes.
--     * Slot: task_definition_key Description: The id of the activity in the process defining this task or null if this is not related to a process.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: case_definition_key Description: Case definition key reference.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_execution_id Description: Reference to the case execution.
--     * Slot: activity_instance_id Description: Runtime activity instance identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: parent_task_id Description: The parent task for which this task is a subtask.
--     * Slot: description Description: Human-readable description.
--     * Slot: owner Description: The userId of the person that is responsible for this task.
--     * Slot: assignee Description: The userId of the person to which this task is String) assigned or String) delegated.
--     * Slot: delete_reason Description: Obtains the reason for the process instance's deletion.
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest.
--     * Slot: due_date Description: Due date of the task.
--     * Slot: follow_up_date Description: Follow-up date of the task.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: task_state Description: Task's state.
--     * Slot: id Description: Unique identifier.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: start_time Description: Start timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: duration Description: Duration in milliseconds.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: FluxnovaHistoricVariableInstance Description: A single process variable containing the last value when its process instance has finished.
--     * Slot: id Description: Unique identifier.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: case_definition_key Description: Case definition key reference.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_execution_id Description: Reference to the case execution.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: activity_instance_id Description: Runtime activity instance identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: variable_type Description: The variable type.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: byte_array_id Description: Reference to the byte array.
--     * Slot: double_value Description: Variable value stored as double.
--     * Slot: long_value Description: Variable value stored as long.
--     * Slot: text_value Description: Variable value stored as text.
--     * Slot: text2_value Description: Variable value stored as text2.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: state Description: The row's state; which values it takes depends on its table.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: restricted Description: Whether this variable is restricted.
-- # Class: FluxnovaIdentityInfo Description: Identity Info entity in the identity and access management.
--     * Slot: id Description: Unique identifier.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: type Description: Type discriminator.
--     * Slot: key Description: Business key for the definition.
--     * Slot: value Description: Value of this variable instance.
--     * Slot: password Description: Hashed password.
--     * Slot: parent_id Description: Reference to a CaseExecution.
-- # Class: FluxnovaIdentityLink Description: An identity link is used to associate a task with a certain identity.
--     * Slot: id Description: Unique identifier.
--     * Slot: group_id Description: Reference to a group.
--     * Slot: type Description: Type discriminator.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
-- # Class: FluxnovaIncident Description: An Incident represents a failure in the execution of a process instance.
--     * Slot: id Description: Unique identifier.
--     * Slot: incident_timestamp Description: Time when the incident happened.
--     * Slot: incident_message Description: Incident message.
--     * Slot: incident_type Description: Type of this incident to identify the kind of incident.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: failed_activity_id Description: Id of the activity on which the last exception occurred.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: cause_incident_id Description: Id of the incident on which this incident has been triggered.
--     * Slot: root_cause_incident_id Description: Id of the root incident on which this transitive incident has been triggered.
--     * Slot: configuration Description: Payload of this incident.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: job_definition_id Description: Reference to the job definition.
--     * Slot: annotation Description: Annotation of this incident.
-- # Class: FluxnovaJob Description: Represents one job (timer, message, etc.).
--     * Slot: id Description: Unique identifier.
--     * Slot: type Description: Type discriminator.
--     * Slot: lock_expiration_time Description: Time at which the lock expires.
--     * Slot: lock_owner Description: Identifier of the node that acquired the lock.
--     * Slot: is_exclusive Description: Whether this entity is exclusive.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: retries Description: Number of retries this job has left.
--     * Slot: exception_stack_id Description: Reference to a ByteArray.
--     * Slot: exception_message Description: Message of the exception that occurred, the last time the job was executed.
--     * Slot: failed_activity_id Description: Id of the activity on which the last exception occurred.
--     * Slot: due_date Description: Due date of the task.
--     * Slot: repeat Description: Repeat/recurrence expression (ISO 8601).
--     * Slot: repeat_offset Description: Offset applied to repeat interval calculation.
--     * Slot: handler_type Description: Type of handler that processes this entity.
--     * Slot: handler_configuration Description: Configuration for the handler.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: job_definition_id Description: Reference to the job definition.
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest.
--     * Slot: sequence_counter Description: Monotonically increasing counter for ordering.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: last_failure_log_id Description: Reference to the last failure log.
--     * Slot: batch_id Description: Reference to a batch.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: FluxnovaJobDefinition Description: A Job Definition provides details about asynchronous background processing ("Jobs") performed by the process engine.
--     * Slot: id Description: Unique identifier.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: job_type Description: The Type of a job.
--     * Slot: job_configuration Description: The configuration of a job definition provides details about the jobs which will be created.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: job_priority Description: Priority of the associated job when this log entry was created.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: deployment_id Description: Reference to the deployment.
-- # Class: FluxnovaMembership Description: Association entity in identity and access management.
--     * Slot: id
--     * Slot: user_id Description: Reference to a user.
--     * Slot: group_id Description: Reference to a group.
-- # Class: FluxnovaMeterLog Description: Meter Log entity in the engine infrastructure.
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: reporter Description: Identifier of the reporting node.
--     * Slot: value Description: Value of this variable instance.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: milliseconds Description: The milliseconds.
-- # Class: FluxnovaProcessDefinition Description: An object structure representing an executable process composed of activities and transitions.
--     * Slot: has_start_form_key Description: The has start form key.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: version_tag Description: Version tag of the process definition.
--     * Slot: is_startable Description: Whether this entity is startable.
--     * Slot: id Description: Unique identifier.
--     * Slot: key Description: Business key for the definition.
--     * Slot: name Description: Human-readable name.
--     * Slot: version Description: Version number.
--     * Slot: category Description: Category classification.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: resource_name Description: Name of the deployed resource file.
--     * Slot: diagram_resource_name Description: Name of the diagram resource file.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: history_time_to_live Description: Days to retain history before cleanup.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: FluxnovaEngineProperty Description: Property entity in the engine infrastructure.
--     * Slot: name Description: Human-readable name.
--     * Slot: value Description: Value of this variable instance.
-- # Abstract Class: FluxnovaResourceDefinition Description: Abstract base for deployable resource definitions (process, case, decision, form).
--     * Slot: id Description: Unique identifier.
--     * Slot: key Description: Business key for the definition.
--     * Slot: name Description: Human-readable name.
--     * Slot: version Description: Version number.
--     * Slot: category Description: Category classification.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: resource_name Description: Name of the deployed resource file.
--     * Slot: diagram_resource_name Description: Name of the diagram resource file.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: history_time_to_live Description: Days to retain history before cleanup.
-- # Class: FluxnovaSchemaLogEntry Description: Schema Log Entry entity in the engine infrastructure.
--     * Slot: id Description: Unique identifier.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: version Description: Version number.
-- # Class: FluxnovaTask Description: Represents one task for a human user.
--     * Slot: id Description: Unique identifier.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: case_execution_id Description: Reference to the case execution.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: name Description: Human-readable name.
--     * Slot: parent_task_id Description: The parent task for which this task is a subtask.
--     * Slot: description Description: Human-readable description.
--     * Slot: task_definition_key Description: The id of the activity in the process defining this task or null if this is not related to a process.
--     * Slot: owner Description: The userId of the person that is responsible for this task.
--     * Slot: assignee Description: The userId of the person to which this task is String) assigned or String) delegated.
--     * Slot: delegation_state Description: The current DelegationState for this task.
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high [80..100] highest.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: last_updated Description: The date/time when this task was last updated.
--     * Slot: due_date Description: Due date of the task.
--     * Slot: follow_up_date Description: Follow-up date of the task.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: task_state Description: Task's state.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: FluxnovaTaskMeterLog Description: Task Meter Log entity in the engine infrastructure.
--     * Slot: id Description: Unique identifier.
--     * Slot: assignee_hash Description: Hash of the assignee for aggregation.
--     * Slot: timestamp Description: Time when this log occurred.
-- # Class: FluxnovaTenant Description: Represents a tenant, used in IdentityService.
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
-- # Class: FluxnovaTenantMembership Description: Association entity in identity and access management.
--     * Slot: id Description: Unique identifier.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: group_id Description: Reference to a group.
-- # Class: FluxnovaUser Description: Represents a user, used in IdentityService.
--     * Slot: id Description: Unique identifier.
--     * Slot: first_name Description: First name.
--     * Slot: last_name Description: Last name.
--     * Slot: email Description: Email address.
--     * Slot: password Description: Hashed password.
--     * Slot: salt Description: Cryptographic salt for password hashing.
--     * Slot: lock_expiration_time Description: Time at which the lock expires.
--     * Slot: attempts Description: Number of failed login attempts.
--     * Slot: picture_id Description: Reference to the picture.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: FluxnovaUserOperationLogEntry Description: Log entry about an operation performed by a user.
--     * Slot: id Description: Unique identifier.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_execution_id Description: Reference to the case execution.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: job_id Description: Id of the associated job.
--     * Slot: job_definition_id Description: Reference to the job definition.
--     * Slot: batch_id Description: Reference to a batch.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: operation_type Description: Type of identity link history (add or delete identity link).
--     * Slot: operation_id Description: The unique identifier of this operation.
--     * Slot: entity_type Description: The type of the entity on which this operation was executed.
--     * Slot: property Description: The property changed by this operation.
--     * Slot: original_value Description: The original value.
--     * Slot: new_value Description: The new value of the property.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: category Description: Category classification.
--     * Slot: external_task_id Description: Id of the associated external task.
--     * Slot: annotation Description: Annotation of this incident.
-- # Class: FluxnovaVariableInstance Description: A VariableInstance represents a variable in the execution of a process instance.
--     * Slot: id Description: Unique identifier.
--     * Slot: type Description: Type discriminator.
--     * Slot: name Description: Human-readable name.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: case_execution_id Description: Reference to the case execution.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: batch_id Description: Reference to a batch.
--     * Slot: byte_array_id Description: Reference to the byte array.
--     * Slot: double_value Description: Variable value stored as double.
--     * Slot: long_value Description: Variable value stored as long.
--     * Slot: text_value Description: Variable value stored as text.
--     * Slot: text2_value Description: Variable value stored as text2.
--     * Slot: variable_scope_id Description: Reference to the variable scope.
--     * Slot: sequence_counter Description: Monotonically increasing counter for ordering.
--     * Slot: is_concurrent_local Description: Whether this entity is concurrent local.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: restricted Description: Whether this variable is restricted.
-- # Abstract Class: BpmnModelElementInstance Description: Any element of a BPMN document that Fluxnova's model API reads, the base of every BPMN class here.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: DcBounds Description: A rectangle, by its top-left corner and its size, that places a shape on a diagram.
--     * Slot: id
--     * Slot: x Description: The horizontal coordinate.
--     * Slot: y Description: The vertical coordinate.
--     * Slot: width Description: The width of the rectangle.
--     * Slot: height Description: The height of the rectangle.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: DcFont Description: The font a diagram label is drawn in.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: size Description: The font's size.
--     * Slot: is_bold Description: Whether the font is bold.
--     * Slot: is_italic Description: Whether the font is italic.
--     * Slot: is_underline Description: Whether the font is underlined.
--     * Slot: is_strike_through Description: Whether the font is struck through.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: DcPoint Description: A point on a diagram, by its x and y coordinates.
--     * Slot: id
--     * Slot: x Description: The horizontal coordinate.
--     * Slot: y Description: The vertical coordinate.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Abstract Class: DiDiagram Description: A diagram of a model, the root of what Diagram Interchange draws.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_documentation Description: Text that documents the element.
--     * Slot: resolution Description: The resolution of the diagram, in units per inch.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Abstract Class: DiDiagramElement Description: Any element drawn on a diagram.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: DiPlane_id Description: Autocreated FK slot
--     * Slot: BpmnPlane_id Description: Autocreated FK slot
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiEdge Description: A diagram element drawn as a line through waypoints between two elements.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: DiExtension Description: Tool-specific content attached to a diagram element.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Abstract Class: DiLabel Description: A diagram element that shows text, placed by its bounds.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiLabeledEdge Description: An edge that can carry labels.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiLabeledShape Description: A shape that can carry labels.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiNode Description: A diagram element that other elements can connect to.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiPlane Description: A diagram's drawing surface, which holds its shapes and edges.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiShape Description: A diagram element drawn as a figure inside its bounds.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiStyle Description: How a diagram element looks, such as its font or colour.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: DiWaypoint Description: A point an edge passes through.
--     * Slot: id
--     * Slot: x Description: The horizontal coordinate.
--     * Slot: y Description: The vertical coordinate.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: DiEdge_id Description: Autocreated FK slot
--     * Slot: DiLabeledEdge_id Description: Autocreated FK slot
--     * Slot: BpmnEdge_id Description: Autocreated FK slot
-- # Class: BpmnDiagram Description: A diagram of BPMN elements, with its plane and the label styles it uses.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_documentation Description: Text that documents the element.
--     * Slot: resolution Description: The resolution of the diagram, in units per inch.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_id Description: Autocreated FK slot
--     * Slot: bpmn_plane_id Description: The plane that holds this diagram's shapes and edges.
-- # Class: BpmnEdge Description: The line that draws a connecting BPMN element, such as a sequence flow, message flow or association.
--     * Slot: id
--     * Slot: bpmn_element Description: The QName of the BPMN element this diagram element draws.
--     * Slot: source_element Description: The QName of the diagram element the edge starts at.
--     * Slot: target_element Description: The QName of the diagram element the edge ends at.
--     * Slot: message_visible_kind Description: Whether the message the edge carries is drawn as initiating or not.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bpmn_label_id Description: The label drawn with this shape or edge.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: BpmnLabel Description: The label of a BPMN shape or edge, where its text is drawn.
--     * Slot: id
--     * Slot: label_style Description: The QName of the label style the label uses.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: BpmnLabelStyle Description: A font that BPMN labels share.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDiagram_id Description: Autocreated FK slot
--     * Slot: font_id Description: The font the labels are drawn in.
-- # Class: BpmnPlane Description: The plane of a BPMN diagram, drawing one process, collaboration or sub-process.
--     * Slot: id
--     * Slot: bpmn_element Description: The QName of the BPMN element this diagram element draws.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: BpmnShape Description: The figure that draws a BPMN element such as a task, event, gateway, pool or lane.
--     * Slot: id
--     * Slot: bpmn_element Description: The QName of the BPMN element this diagram element draws.
--     * Slot: is_horizontal Description: Whether a pool or lane is drawn horizontally.
--     * Slot: is_expanded Description: Whether a sub-process or call activity is drawn expanded.
--     * Slot: is_marker_visible Description: Whether an exclusive gateway is drawn with its marker.
--     * Slot: is_message_visible Description: Whether a participant band is drawn with its message.
--     * Slot: participant_band_kind Description: Where a participant band sits on a choreography activity, and whether it initiates.
--     * Slot: choreography_activity_shape Description: The QName of the choreography activity shape this participant band belongs to.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bpmn_label_id Description: The label drawn with this shape or edge.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: BpmnActivationCondition Description: The condition a complex gateway checks to decide when enough incoming flows have arrived to continue.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnActivity Description: Work a process performs, either a task or a sub-process.
--     * Slot: id
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnAdHocSubProcess Description: A sub-process whose inner activities run in no fixed order, as its performers choose.
--     * Slot: id
--     * Slot: ordering Description: Whether the inner activities run in parallel or one after another.
--     * Slot: cancel_remaining_instances Description: Whether the activities still running are cancelled once the completion condition holds.
--     * Slot: triggered_by_event Description: Whether the sub-process is an event sub-process, started by an event.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: completion_condition_id Description: The condition that ends the activity early when it holds.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnArtifact Description: An element that adds information to a diagram without changing how the process runs.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnAssignment Description: A copy of a value from one expression to another within a data association.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDataAssociation_id Description: Autocreated FK slot
--     * Slot: BpmnDataInputAssociation_id Description: Autocreated FK slot
--     * Slot: BpmnDataOutputAssociation_id Description: Autocreated FK slot
--     * Slot: from_expression_id Description: The expression the value is copied from.
--     * Slot: to_expression_id Description: The expression the value is copied to.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnAssociation Description: A link between an artifact, such as a text annotation, and another element.
--     * Slot: id
--     * Slot: source_ref Description: The id or QName of the element the connection starts at.
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: association_direction Description: Which ends of the association an arrow is drawn at.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnAuditing Description: A hook for auditing a process or flow element, left to the implementation.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnBaseElement Description: The base of nearly every BPMN element, giving it an id, documentation and extensions.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnBoundaryEvent Description: An event attached to the boundary of an activity, which can interrupt it.
--     * Slot: id
--     * Slot: cancel_activity Description: Whether the event, when it fires, interrupts the activity it is attached to.
--     * Slot: attached_to_ref Description: The QName of the activity this event is attached to.
--     * Slot: parallel_multiple Description: Whether all of the event's triggers must happen, rather than any one.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: output_set_id Description: The output set the event's data outputs make up.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnBusinessRuleTask Description: A task that hands data to a business rules engine and receives its result.
--     * Slot: id
--     * Slot: implementation Description: The technology that runs the task, as a URI; the engine reads its own settings instead.
--     * Slot: fluxnova_class Description: The Java class the engine instantiates to run the element.
--     * Slot: fluxnova_delegate_expression Description: An expression that gives the delegate object the engine calls.
--     * Slot: fluxnova_expression Description: An expression the engine evaluates to run the element.
--     * Slot: fluxnova_result_variable Description: The variable the result is stored in.
--     * Slot: fluxnova_topic Description: The topic of the external task the element creates.
--     * Slot: fluxnova_type Description: The element's type, such as external for an external task or the form field's value type.
--     * Slot: fluxnova_decision_ref Description: The key of the decision to evaluate.
--     * Slot: fluxnova_decision_ref_binding Description: Which version of the decision to use.
--     * Slot: fluxnova_decision_ref_version Description: The version of the decision, when the binding asks for one.
--     * Slot: fluxnova_decision_ref_version_tag Description: The version tag of the decision, when the binding asks for one.
--     * Slot: fluxnova_decision_ref_tenant_id Description: The tenant whose decision to use.
--     * Slot: fluxnova_map_decision_result Description: How the decision's result is mapped into a variable.
--     * Slot: fluxnova_task_priority Description: The priority of the external tasks the element creates.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCallActivity Description: An activity that calls a separate process or global task.
--     * Slot: id
--     * Slot: called_element Description: The id of the process or global task this activity calls.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: fluxnova_called_element_binding Description: Which version of the called process to use, such as the latest or the one deployed with this one.
--     * Slot: fluxnova_called_element_version Description: The version of the called process, when the binding asks for one.
--     * Slot: fluxnova_called_element_version_tag Description: The version tag of the called process, when the binding asks for one.
--     * Slot: fluxnova_case_ref Description: The key of the case definition to call.
--     * Slot: fluxnova_case_binding Description: Which version of the called case to use.
--     * Slot: fluxnova_case_version Description: The version of the called case, when the binding asks for one.
--     * Slot: fluxnova_called_element_tenant_id Description: The tenant whose called process to use.
--     * Slot: fluxnova_case_tenant_id Description: The tenant whose called case to use.
--     * Slot: fluxnova_variable_mapping_class Description: The Java class that maps variables into and out of the called process.
--     * Slot: fluxnova_variable_mapping_delegate_expression Description: An expression giving the delegate that maps variables into and out of the called process.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCallConversation Description: A conversation that calls a collaboration or global conversation defined elsewhere.
--     * Slot: id
--     * Slot: called_collaboration_ref Description: The QName of the collaboration or global conversation this conversation calls.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCallableElement Description: An element another process can call, such as a process.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCancelEventDefinition Description: The trigger of an event that cancels a transaction sub-process.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnCatchEvent Description: An event that waits for a trigger, such as a start or intermediate catch event.
--     * Slot: id
--     * Slot: parallel_multiple Description: Whether all of the event's triggers must happen, rather than any one.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: output_set_id Description: The output set the event's data outputs make up.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCategory Description: A named set of category values that groups elements.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCategoryValue Description: One value of a category, which a group shows.
--     * Slot: id
--     * Slot: value Description: The category value's text.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCategory_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnChildLaneSet Description: The lanes a lane is divided into.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCollaboration Description: The participants of a model and the messages and conversations between them.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: is_closed Description: Whether no interactions occur other than those the model shows.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCompensateEventDefinition Description: The trigger of an event that starts or catches compensation.
--     * Slot: id
--     * Slot: wait_for_completion Description: Whether the throwing event waits for the compensation to finish.
--     * Slot: activity_ref Description: The id of the activity to compensate; when absent, every compensable activity in scope is.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCompletionCondition Description: The condition that ends a multi-instance activity or an ad-hoc sub-process early.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnComplexBehaviorDefinition Description: A rule of a multi-instance activity that throws an event when its condition holds as instances complete.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnMultiInstanceLoopCharacteristics_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnComplexGateway Description: A gateway that splits or joins flows by conditions of its own.
--     * Slot: id
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: activation_condition_id Description: The condition that decides when the gateway may continue.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCondition Description: The expression a conditional event evaluates.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConditionExpression Description: The expression that decides whether a sequence flow is taken.
--     * Slot: id
--     * Slot: xsi_type Description: The XML Schema type of the expression, a formal expression unless the document says otherwise.
--     * Slot: fluxnova_resource Description: A resource that holds the script of a script condition.
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConditionalEventDefinition Description: The trigger of an event that fires when a condition becomes true.
--     * Slot: id
--     * Slot: fluxnova_variable_name Description: The variable whose changes make the engine check the condition.
--     * Slot: fluxnova_variable_events Description: The variable events, such as create or update, that make the engine check the condition.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: condition_id Description: The condition the event waits for.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConversation Description: A set of message flows between participants that belong together.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConversationAssociation Description: A link between a conversation node and one that refines it.
--     * Slot: id
--     * Slot: inner_conversation_node_ref Description: The QName of the conversation node that refines the outer one.
--     * Slot: outer_conversation_node_ref Description: The QName of the conversation node being refined.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConversationLink Description: A link between a participant and a conversation node.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: source_ref Description: The id or QName of the element the connection starts at.
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnConversationNode Description: Any node of a conversation diagram, such as a conversation or sub-conversation.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: BpmnSubConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationKey Description: A set of correlation properties that together identify a conversation.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCallConversation_id Description: Autocreated FK slot
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnConversation_id Description: Autocreated FK slot
--     * Slot: BpmnConversationNode_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: BpmnSubConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationProperty Description: A value read from messages that ties them to one conversation.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: type Description: The QName of the property's type.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationPropertyBinding Description: The expression that gives a correlation property its value in a process.
--     * Slot: id
--     * Slot: correlation_property_ref Description: The QName of the correlation property this binding gives a value.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCorrelationSubscription_id Description: Autocreated FK slot
--     * Slot: data_path_id Description: The expression that finds the value in process data.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationPropertyRetrievalExpression Description: The expression that reads a correlation property from one message.
--     * Slot: id
--     * Slot: message_ref Description: The QName of the message sent or received.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCorrelationProperty_id Description: Autocreated FK slot
--     * Slot: message_path_id Description: The expression that finds the value in the message.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationSubscription Description: How a process instance subscribes to messages by a correlation key.
--     * Slot: id
--     * Slot: correlation_key_ref Description: The QName of the correlation key this subscription uses.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataAssociation Description: A copy of data from sources to a target as an activity or event runs.
--     * Slot: id
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: transformation_id Description: The expression that changes the data as it is copied.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataInput Description: A piece of data an activity, process or event needs.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnEndEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIoSpecification_id Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_id Description: Autocreated FK slot
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataInputAssociation Description: A data association that feeds a data input.
--     * Slot: id
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivity_id Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_id Description: Autocreated FK slot
--     * Slot: BpmnEndEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: BpmnManualTask_id Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_id Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_id Description: Autocreated FK slot
--     * Slot: BpmnSendTask_id Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_id Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_id Description: Autocreated FK slot
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: BpmnUserTask_id Description: Autocreated FK slot
--     * Slot: transformation_id Description: The expression that changes the data as it is copied.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataObject Description: Data a process creates or uses while it runs.
--     * Slot: id
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataObjectReference Description: A use of a data object at one place in a process.
--     * Slot: id
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: data_object_ref Description: The id of the data object this reference uses.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataOutput Description: A piece of data an activity, process or event produces.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnBoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIoSpecification_id Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_id Description: Autocreated FK slot
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataOutputAssociation Description: A data association that carries a data output on.
--     * Slot: id
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivity_id Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnBoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_id Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnManualTask_id Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_id Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_id Description: Autocreated FK slot
--     * Slot: BpmnSendTask_id Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_id Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_id Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: BpmnUserTask_id Description: Autocreated FK slot
--     * Slot: transformation_id Description: The expression that changes the data as it is copied.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataPath Description: The expression that finds a correlation property's value in process data.
--     * Slot: id
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataState Description: The state of a data object or data store, such as draft or approved.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataStore Description: Data that lasts beyond one process instance, such as a database.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: capacity Description: How many items the data store can hold.
--     * Slot: is_unlimited Description: Whether the data store's capacity has no limit.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataStoreReference Description: A use of a data store at one place in a process.
--     * Slot: id
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: data_store_ref Description: The QName of the data store this reference uses.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDefinitions Description: The root of a BPMN document, which holds its processes, collaborations and diagrams.
--     * Slot: id
--     * Slot: bpmn_id Description: The document's id.
--     * Slot: name Description: The document's name.
--     * Slot: target_namespace Description: The namespace of the elements this document defines.
--     * Slot: expression_language Description: The language the document's expressions are written in unless one says otherwise, as a URI.
--     * Slot: type_language Description: The language the document's types are written in, as a URI.
--     * Slot: exporter Description: The tool that wrote the document.
--     * Slot: exporter_version Description: The version of the tool that wrote the document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: BpmnDocumentation Description: Text that documents an element.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: text_format Description: The format of the text, as a MIME type.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivationCondition_id Description: Autocreated FK slot
--     * Slot: BpmnActivity_id Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnArtifact_id Description: Autocreated FK slot
--     * Slot: BpmnAssignment_id Description: Autocreated FK slot
--     * Slot: BpmnAssociation_id Description: Autocreated FK slot
--     * Slot: BpmnAuditing_id Description: Autocreated FK slot
--     * Slot: BpmnBaseElement_id Description: Autocreated FK slot
--     * Slot: BpmnBoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_id Description: Autocreated FK slot
--     * Slot: BpmnCallConversation_id Description: Autocreated FK slot
--     * Slot: BpmnCallableElement_id Description: Autocreated FK slot
--     * Slot: BpmnCancelEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnCategory_id Description: Autocreated FK slot
--     * Slot: BpmnCategoryValue_id Description: Autocreated FK slot
--     * Slot: BpmnChildLaneSet_id Description: Autocreated FK slot
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnCompensateEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnCompletionCondition_id Description: Autocreated FK slot
--     * Slot: BpmnComplexBehaviorDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnComplexGateway_id Description: Autocreated FK slot
--     * Slot: BpmnCondition_id Description: Autocreated FK slot
--     * Slot: BpmnConditionExpression_id Description: Autocreated FK slot
--     * Slot: BpmnConditionalEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnConversation_id Description: Autocreated FK slot
--     * Slot: BpmnConversationAssociation_id Description: Autocreated FK slot
--     * Slot: BpmnConversationLink_id Description: Autocreated FK slot
--     * Slot: BpmnConversationNode_id Description: Autocreated FK slot
--     * Slot: BpmnCorrelationKey_id Description: Autocreated FK slot
--     * Slot: BpmnCorrelationProperty_id Description: Autocreated FK slot
--     * Slot: BpmnCorrelationPropertyBinding_id Description: Autocreated FK slot
--     * Slot: BpmnCorrelationPropertyRetrievalExpression_id Description: Autocreated FK slot
--     * Slot: BpmnCorrelationSubscription_id Description: Autocreated FK slot
--     * Slot: BpmnDataAssociation_id Description: Autocreated FK slot
--     * Slot: BpmnDataInput_id Description: Autocreated FK slot
--     * Slot: BpmnDataInputAssociation_id Description: Autocreated FK slot
--     * Slot: BpmnDataObject_id Description: Autocreated FK slot
--     * Slot: BpmnDataObjectReference_id Description: Autocreated FK slot
--     * Slot: BpmnDataOutput_id Description: Autocreated FK slot
--     * Slot: BpmnDataOutputAssociation_id Description: Autocreated FK slot
--     * Slot: BpmnDataPath_id Description: Autocreated FK slot
--     * Slot: BpmnDataState_id Description: Autocreated FK slot
--     * Slot: BpmnDataStore_id Description: Autocreated FK slot
--     * Slot: BpmnDataStoreReference_id Description: Autocreated FK slot
--     * Slot: BpmnEndEvent_id Description: Autocreated FK slot
--     * Slot: BpmnEndPoint_id Description: Autocreated FK slot
--     * Slot: BpmnError_id Description: Autocreated FK slot
--     * Slot: BpmnErrorEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnEscalation_id Description: Autocreated FK slot
--     * Slot: BpmnEscalationEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnEvent_id Description: Autocreated FK slot
--     * Slot: BpmnEventBasedGateway_id Description: Autocreated FK slot
--     * Slot: BpmnEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnExclusiveGateway_id Description: Autocreated FK slot
--     * Slot: BpmnExpression_id Description: Autocreated FK slot
--     * Slot: BpmnExtension_id Description: Autocreated FK slot
--     * Slot: BpmnFlowElement_id Description: Autocreated FK slot
--     * Slot: BpmnFlowNode_id Description: Autocreated FK slot
--     * Slot: BpmnFormalExpression_id Description: Autocreated FK slot
--     * Slot: BpmnFrom_id Description: Autocreated FK slot
--     * Slot: BpmnGateway_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: BpmnGroup_id Description: Autocreated FK slot
--     * Slot: BpmnHumanPerformer_id Description: Autocreated FK slot
--     * Slot: BpmnInclusiveGateway_id Description: Autocreated FK slot
--     * Slot: BpmnInputDataItem_id Description: Autocreated FK slot
--     * Slot: BpmnInputSet_id Description: Autocreated FK slot
--     * Slot: BpmnInterface_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIoBinding_id Description: Autocreated FK slot
--     * Slot: BpmnIoSpecification_id Description: Autocreated FK slot
--     * Slot: BpmnItemAwareElement_id Description: Autocreated FK slot
--     * Slot: BpmnItemDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnLane_id Description: Autocreated FK slot
--     * Slot: BpmnLaneSet_id Description: Autocreated FK slot
--     * Slot: BpmnLinkEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnLoopCardinality_id Description: Autocreated FK slot
--     * Slot: BpmnLoopCharacteristics_id Description: Autocreated FK slot
--     * Slot: BpmnManualTask_id Description: Autocreated FK slot
--     * Slot: BpmnMessage_id Description: Autocreated FK slot
--     * Slot: BpmnMessageEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnMessageFlow_id Description: Autocreated FK slot
--     * Slot: BpmnMessageFlowAssociation_id Description: Autocreated FK slot
--     * Slot: BpmnMessagePath_id Description: Autocreated FK slot
--     * Slot: BpmnMonitoring_id Description: Autocreated FK slot
--     * Slot: BpmnMultiInstanceLoopCharacteristics_id Description: Autocreated FK slot
--     * Slot: BpmnOperation_id Description: Autocreated FK slot
--     * Slot: BpmnOutputDataItem_id Description: Autocreated FK slot
--     * Slot: BpmnOutputSet_id Description: Autocreated FK slot
--     * Slot: BpmnParallelGateway_id Description: Autocreated FK slot
--     * Slot: BpmnParticipant_id Description: Autocreated FK slot
--     * Slot: BpmnParticipantAssociation_id Description: Autocreated FK slot
--     * Slot: BpmnParticipantMultiplicity_id Description: Autocreated FK slot
--     * Slot: BpmnPartitionElement_id Description: Autocreated FK slot
--     * Slot: BpmnPerformer_id Description: Autocreated FK slot
--     * Slot: BpmnPotentialOwner_id Description: Autocreated FK slot
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: BpmnProperty_id Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_id Description: Autocreated FK slot
--     * Slot: BpmnRelationship_id Description: Autocreated FK slot
--     * Slot: BpmnRendering_id Description: Autocreated FK slot
--     * Slot: BpmnResource_id Description: Autocreated FK slot
--     * Slot: BpmnResourceAssignmentExpression_id Description: Autocreated FK slot
--     * Slot: BpmnResourceParameter_id Description: Autocreated FK slot
--     * Slot: BpmnResourceParameterBinding_id Description: Autocreated FK slot
--     * Slot: BpmnResourceRole_id Description: Autocreated FK slot
--     * Slot: BpmnRootElement_id Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_id Description: Autocreated FK slot
--     * Slot: BpmnSendTask_id Description: Autocreated FK slot
--     * Slot: BpmnSequenceFlow_id Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_id Description: Autocreated FK slot
--     * Slot: BpmnSignal_id Description: Autocreated FK slot
--     * Slot: BpmnSignalEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_id Description: Autocreated FK slot
--     * Slot: BpmnSubConversation_id Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: BpmnTerminateEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnTextAnnotation_id Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_id Description: Autocreated FK slot
--     * Slot: BpmnTimeCycle_id Description: Autocreated FK slot
--     * Slot: BpmnTimeDate_id Description: Autocreated FK slot
--     * Slot: BpmnTimeDuration_id Description: Autocreated FK slot
--     * Slot: BpmnTimerEventDefinition_id Description: Autocreated FK slot
--     * Slot: BpmnTo_id Description: Autocreated FK slot
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: BpmnTransformation_id Description: Autocreated FK slot
--     * Slot: BpmnUserTask_id Description: Autocreated FK slot
-- # Class: BpmnEndEvent Description: An event that ends a path of a process.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: input_set_id Description: The input set the event's data inputs make up.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnEndPoint Description: A place where a participant can be reached for messages.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnError Description: An error that an activity can throw and an event can catch.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: error_code Description: The code that identifies the error.
--     * Slot: fluxnova_error_message Description: The message of the error.
--     * Slot: structure_ref Description: The QName of the type of the data, such as an XML Schema type.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnErrorEventDefinition Description: The trigger of an event that throws or catches an error.
--     * Slot: id
--     * Slot: error_ref Description: The QName of the error thrown or caught.
--     * Slot: fluxnova_error_code_variable Description: The variable the caught error's code is stored in.
--     * Slot: fluxnova_error_message_variable Description: The variable the caught error's message is stored in.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnEscalation Description: An escalation that an activity can throw and an event can catch.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: escalation_code Description: The code that identifies the escalation.
--     * Slot: structure_ref Description: The QName of the type of the data, such as an XML Schema type.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnEscalationEventDefinition Description: The trigger of an event that throws or catches an escalation.
--     * Slot: id
--     * Slot: escalation_ref Description: The QName of the escalation thrown or caught.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnEvent Description: Something that happens while a process runs, such as a start, a message or a timer.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnEventBasedGateway Description: A gateway that takes the path of whichever following event happens first.
--     * Slot: id
--     * Slot: instantiate Description: Whether the element starts a new process instance.
--     * Slot: event_gateway_type Description: Whether the gateway starts one process instance for the first event or waits for all of them.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnEventDefinition Description: What triggers an event, such as a message, timer or signal.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnBoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnEndEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_id Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnExclusiveGateway Description: A gateway that takes exactly one of its outgoing flows.
--     * Slot: id
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnExpression Description: An expression whose language and body the model leaves open.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnExtension Description: A declaration that a document uses an extension, by its definition.
--     * Slot: id
--     * Slot: bpmn_definition Description: The QName of the extension's definition.
--     * Slot: must_understand Description: Whether a tool reading the document must understand the extension.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_id Description: Autocreated FK slot
-- # Class: BpmnExtensionElements Description: The container for an element's extension content, such as Fluxnova's settings.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Abstract Class: BpmnFlowElement Description: An element that takes part in the flow of a process, such as an activity or sequence flow.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnFlowNode Description: A flow element that sequence flows connect, such as an activity, event or gateway.
--     * Slot: id
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnFormalExpression Description: An expression in a stated language, with the type it evaluates to.
--     * Slot: id
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnFrom Description: The expression an assignment copies a value from.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnGateway Description: A point where a process's flows split or join.
--     * Slot: id
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnGlobalConversation Description: A conversation defined on its own so that collaborations can call it.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: is_closed Description: Whether no interactions occur other than those the model shows.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnGroup Description: An artifact that draws a box around elements of one category value.
--     * Slot: id
--     * Slot: category_value_ref Description: The QName of the category value this group shows.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnHumanPerformer Description: The person who performs an activity.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: resource_ref Description: The QName of the resource that plays the role.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: resource_assignment_expression_id Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnImport Description: A document the definitions import elements from.
--     * Slot: id
--     * Slot: namespace Description: The namespace of the imported document.
--     * Slot: location Description: Where the imported document is.
--     * Slot: import_type Description: The kind of document imported, as the URI of its language.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_id Description: Autocreated FK slot
-- # Class: BpmnInclusiveGateway Description: A gateway that takes every outgoing flow whose condition holds.
--     * Slot: id
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnInputDataItem Description: The data input each instance of a multi-instance activity receives.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnInputSet Description: A set of data inputs that is enough for an activity or event to start.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnIoSpecification_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnInteractionNode Description: An element a message flow or conversation link can connect, such as a participant, task or event.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
-- # Class: BpmnInterface Description: A set of operations a participant offers.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: implementation_ref Description: The QName of what implements the element.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnIntermediateCatchEvent Description: An event on a process's path that waits for a trigger.
--     * Slot: id
--     * Slot: parallel_multiple Description: Whether all of the event's triggers must happen, rather than any one.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: output_set_id Description: The output set the event's data outputs make up.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnIntermediateThrowEvent Description: An event on a process's path that throws a trigger.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: input_set_id Description: The input set the event's data inputs make up.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnIoBinding Description: A link between an operation's messages and a callable element's input and output sets.
--     * Slot: id
--     * Slot: operation_ref Description: The QName of the operation the element calls or implements.
--     * Slot: input_data_ref Description: The id of the input set the binding uses.
--     * Slot: output_data_ref Description: The id of the output set the binding uses.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCallableElement_id Description: Autocreated FK slot
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnIoSpecification Description: The data inputs and outputs of an activity or process, and their sets.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnItemAwareElement Description: An element that holds data of an item definition, such as a data object or data input.
--     * Slot: id
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnItemDefinition Description: The type of data an element holds or a message carries.
--     * Slot: id
--     * Slot: structure_ref Description: The QName of the type of the data, such as an XML Schema type.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_kind Description: Whether the item is information or a physical thing.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnLane Description: A partition of a process that groups flow nodes, often by who performs them.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: partition_element_ref Description: The QName of the element the lane stands for.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnChildLaneSet_id Description: Autocreated FK slot
--     * Slot: BpmnLaneSet_id Description: Autocreated FK slot
--     * Slot: partition_element_id Description: The element the lane stands for.
--     * Slot: child_lane_set_id Description: The lanes this lane is divided into.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnLaneSet Description: The lanes that divide a process or sub-process.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnLinkEventDefinition Description: The trigger of a pair of events that join two paths of a process like a jump.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_target Description: The QName of the catching link event this one jumps to.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnLoopCardinality Description: The expression that says how many instances a multi-instance activity creates.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnLoopCharacteristics Description: How an activity repeats.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnManualTask Description: A task done by a person without any system's help.
--     * Slot: id
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessage Description: What one participant sends another.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: item_ref Description: The QName of the item definition the message carries.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessageEventDefinition Description: The trigger of an event that sends or receives a message.
--     * Slot: id
--     * Slot: message_ref Description: The QName of the message sent or received.
--     * Slot: fluxnova_class Description: The Java class the engine instantiates to run the element.
--     * Slot: fluxnova_delegate_expression Description: An expression that gives the delegate object the engine calls.
--     * Slot: fluxnova_expression Description: An expression the engine evaluates to run the element.
--     * Slot: fluxnova_result_variable Description: The variable the result is stored in.
--     * Slot: fluxnova_topic Description: The topic of the external task the element creates.
--     * Slot: fluxnova_type Description: The element's type, such as external for an external task or the form field's value type.
--     * Slot: fluxnova_task_priority Description: The priority of the external tasks the element creates.
--     * Slot: operation_ref Description: The QName of the operation the element calls or implements.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessageFlow Description: The path of a message between two participants.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: source_ref Description: The id or QName of the element the connection starts at.
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: message_ref Description: The QName of the message sent or received.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessageFlowAssociation Description: A link between a message flow and one that refines it.
--     * Slot: id
--     * Slot: inner_message_flow_ref Description: The QName of the message flow that refines the outer one.
--     * Slot: outer_message_flow_ref Description: The QName of the message flow being refined.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessagePath Description: The expression that finds a correlation property's value in a message.
--     * Slot: id
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMonitoring Description: A hook for monitoring a process or flow element, left to the implementation.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMultiInstanceLoopCharacteristics Description: How an activity runs once for each item of a collection, in sequence or in parallel.
--     * Slot: id
--     * Slot: is_sequential Description: Whether the instances run one after another rather than at once.
--     * Slot: behavior Description: When the multi-instance activity throws an event as its instances complete.
--     * Slot: one_behavior_event_ref Description: The QName of the event thrown when the first instance completes.
--     * Slot: none_behavior_event_ref Description: The QName of the event thrown when no instance's completion matches.
--     * Slot: fluxnova_async_after Description: Whether the engine continues asynchronously after each instance.
--     * Slot: fluxnova_async_before Description: Whether each instance starts asynchronously.
--     * Slot: fluxnova_exclusive Description: Whether the instances' jobs run one at a time.
--     * Slot: fluxnova_collection Description: The collection, or the expression giving it, whose items each instance receives.
--     * Slot: fluxnova_element_variable Description: The variable each instance receives its item of the collection in.
--     * Slot: loop_data_input_ref Description: The id of the collection the instances are created from.
--     * Slot: loop_data_output_ref Description: The id of the collection the instances' outputs go to.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: loop_cardinality_id Description: How many instances to create.
--     * Slot: output_data_item_id Description: The data output of each instance.
--     * Slot: input_data_item_id Description: The data input of each instance.
--     * Slot: completion_condition_id Description: The condition that ends the activity early when it holds.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnOperation Description: An operation of an interface, with the messages it takes and returns.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: implementation_ref Description: The QName of what implements the element.
--     * Slot: in_message_ref Description: The QName of the message the operation takes.
--     * Slot: out_message_ref Description: The QName of the message the operation returns.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnInterface_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnOutputDataItem Description: The data output each instance of a multi-instance activity produces.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnOutputSet Description: A set of data outputs an activity or event produces together.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnIoSpecification_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnParallelGateway Description: A gateway that takes all its outgoing flows, or waits for all its incoming ones.
--     * Slot: id
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnParticipant Description: A party in a collaboration, usually drawn as a pool, and the process it runs.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: process_ref Description: The QName of the process the participant runs.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: participant_multiplicity_id Description: How many instances of the participant take part.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnParticipantAssociation Description: A link between a participant and one that a called collaboration defines.
--     * Slot: id
--     * Slot: inner_participant_ref Description: The QName of the participant inside the called collaboration.
--     * Slot: outer_participant_ref Description: The QName of the participant in the calling collaboration.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCallConversation_id Description: Autocreated FK slot
--     * Slot: BpmnCollaboration_id Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnParticipantMultiplicity Description: How many instances of a participant take part, from a minimum to a maximum.
--     * Slot: id
--     * Slot: minimum Description: The fewest instances that take part.
--     * Slot: maximum Description: The most instances that take part.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnPartitionElement Description: The element a lane stands for, such as a performer.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnPerformer Description: The resource that performs an activity.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: resource_ref Description: The QName of the resource that plays the role.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: resource_assignment_expression_id Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnPotentialOwner Description: A person who may claim and perform a user task.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: resource_ref Description: The QName of the resource that plays the role.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: resource_assignment_expression_id Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnProcess Description: A sequence of activities, events and gateways that a participant performs.
--     * Slot: id
--     * Slot: process_type Description: Whether the process is private to its participant, public, or neither.
--     * Slot: is_closed Description: Whether no interactions occur other than those the model shows.
--     * Slot: is_executable Description: Whether the process is meant to be run by an engine.
--     * Slot: fluxnova_candidate_starter_groups Description: The groups whose members may start the process.
--     * Slot: fluxnova_candidate_starter_users Description: The users who may start the process.
--     * Slot: fluxnova_job_priority Description: The default priority of the process's jobs.
--     * Slot: fluxnova_task_priority Description: The default priority of the process's external tasks.
--     * Slot: fluxnova_history_time_to_live Description: How long the engine keeps the process's history before it may remove it.
--     * Slot: fluxnova_is_startable_in_tasklist Description: Whether the tasklist offers the process to be started.
--     * Slot: fluxnova_version_tag Description: The tag the process version carries.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnProperty Description: A variable of a process, activity or event.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivity_id Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnBoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_id Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnEndEvent_id Description: Autocreated FK slot
--     * Slot: BpmnEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: BpmnManualTask_id Description: Autocreated FK slot
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_id Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_id Description: Autocreated FK slot
--     * Slot: BpmnSendTask_id Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_id Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_id Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_id Description: Autocreated FK slot
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: BpmnUserTask_id Description: Autocreated FK slot
--     * Slot: data_state_id Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnReceiveTask Description: A task that waits for a message.
--     * Slot: id
--     * Slot: implementation Description: The technology that runs the task, as a URI; the engine reads its own settings instead.
--     * Slot: instantiate Description: Whether the element starts a new process instance.
--     * Slot: message_ref Description: The QName of the message sent or received.
--     * Slot: operation_ref Description: The QName of the operation the element calls or implements.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnRelationship Description: An informal link between elements of different models.
--     * Slot: id
--     * Slot: type Description: What kind of relationship it is.
--     * Slot: direction Description: Which way the relationship points.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnRendering Description: A hint for how a user task appears to the person who performs it.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnUserTask_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResource Description: A resource, such as a person or role, that can perform activities.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResourceAssignmentExpression Description: The expression that chooses who performs an activity.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: expression_id Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResourceParameter Description: A parameter that narrows which resources a resource stands for.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: type Description: The QName of the parameter's type.
--     * Slot: is_required Description: Whether the parameter must be given a value.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnResource_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResourceParameterBinding Description: The value a resource role gives a resource parameter.
--     * Slot: id
--     * Slot: parameter_ref Description: The QName of the parameter given a value.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnHumanPerformer_id Description: Autocreated FK slot
--     * Slot: BpmnPerformer_id Description: Autocreated FK slot
--     * Slot: BpmnPotentialOwner_id Description: Autocreated FK slot
--     * Slot: BpmnResourceRole_id Description: Autocreated FK slot
--     * Slot: expression_id Description: The expression that gives the parameter its value.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResourceRole Description: The role a resource plays in an activity or process.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: resource_ref Description: The QName of the resource that plays the role.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivity_id Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_id Description: Autocreated FK slot
--     * Slot: BpmnManualTask_id Description: Autocreated FK slot
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_id Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_id Description: Autocreated FK slot
--     * Slot: BpmnSendTask_id Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_id Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: BpmnUserTask_id Description: Autocreated FK slot
--     * Slot: resource_assignment_expression_id Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnRootElement Description: An element that can sit directly in a document's definitions, such as a process or message.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnScript Description: The body of a script task's script.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: BpmnScriptTask Description: A task that runs a script.
--     * Slot: id
--     * Slot: script_format Description: The language the script is written in, such as groovy or javascript.
--     * Slot: fluxnova_result_variable Description: The variable the result is stored in.
--     * Slot: fluxnova_resource Description: A resource that holds the script, instead of the script's text.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: script_id Description: The script the task runs.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSendTask Description: A task that sends a message.
--     * Slot: id
--     * Slot: implementation Description: The technology that runs the task, as a URI; the engine reads its own settings instead.
--     * Slot: message_ref Description: The QName of the message sent or received.
--     * Slot: operation_ref Description: The QName of the operation the element calls or implements.
--     * Slot: fluxnova_class Description: The Java class the engine instantiates to run the element.
--     * Slot: fluxnova_delegate_expression Description: An expression that gives the delegate object the engine calls.
--     * Slot: fluxnova_expression Description: An expression the engine evaluates to run the element.
--     * Slot: fluxnova_result_variable Description: The variable the result is stored in.
--     * Slot: fluxnova_topic Description: The topic of the external task the element creates.
--     * Slot: fluxnova_type Description: The element's type, such as external for an external task or the form field's value type.
--     * Slot: fluxnova_task_priority Description: The priority of the external tasks the element creates.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSequenceFlow Description: The order of two flow nodes in a process, from a source to a target.
--     * Slot: id
--     * Slot: source_ref Description: The id or QName of the element the connection starts at.
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: is_immediate Description: Whether the flow's target follows its source with no other activity between them.
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: condition_expression_id Description: The condition that decides whether the flow is taken.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnServiceTask Description: A task that calls a service, such as a web service or application code.
--     * Slot: id
--     * Slot: implementation Description: The technology that runs the task, as a URI; the engine reads its own settings instead.
--     * Slot: operation_ref Description: The QName of the operation the element calls or implements.
--     * Slot: fluxnova_class Description: The Java class the engine instantiates to run the element.
--     * Slot: fluxnova_delegate_expression Description: An expression that gives the delegate object the engine calls.
--     * Slot: fluxnova_expression Description: An expression the engine evaluates to run the element.
--     * Slot: fluxnova_result_variable Description: The variable the result is stored in.
--     * Slot: fluxnova_topic Description: The topic of the external task the element creates.
--     * Slot: fluxnova_type Description: The element's type, such as external for an external task or the form field's value type.
--     * Slot: fluxnova_task_priority Description: The priority of the external tasks the element creates.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSignal Description: A signal that is broadcast to every event waiting for it.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: structure_ref Description: The QName of the type of the data, such as an XML Schema type.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSignalEventDefinition Description: The trigger of an event that sends or receives a signal.
--     * Slot: id
--     * Slot: signal_ref Description: The QName of the signal sent or received.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSource Description: An element a relationship starts from.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnRelationship_id Description: Autocreated FK slot
-- # Class: BpmnStartEvent Description: An event that starts a process or sub-process.
--     * Slot: id
--     * Slot: is_interrupting Description: Whether the event, when it starts an event sub-process, interrupts its parent.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: fluxnova_form_handler_class Description: The Java class that handles the form.
--     * Slot: fluxnova_form_key Description: The key of the form to show.
--     * Slot: fluxnova_form_ref Description: The key of the deployed form to show.
--     * Slot: fluxnova_form_ref_binding Description: Which version of the deployed form to use.
--     * Slot: fluxnova_form_ref_version Description: The version of the deployed form, when the binding asks for one.
--     * Slot: fluxnova_initiator Description: The variable the id of the user who started the process is stored in.
--     * Slot: parallel_multiple Description: Whether all of the event's triggers must happen, rather than any one.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: output_set_id Description: The output set the event's data outputs make up.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSubConversation Description: A conversation node that groups other conversation nodes.
--     * Slot: id
--     * Slot: name Description: The element's name.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSubProcess Description: An activity that holds a process of its own.
--     * Slot: id
--     * Slot: triggered_by_event Description: Whether the sub-process is an event sub-process, started by an event.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTarget Description: An element a relationship leads to.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnRelationship_id Description: Autocreated FK slot
-- # Class: BpmnTask Description: An atomic activity, one that is not broken down further.
--     * Slot: id
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTerminateEventDefinition Description: The trigger of an end event that ends the whole process instance at once.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnText Description: The text of a text annotation.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: BpmnTextAnnotation Description: An artifact that adds a note to a diagram.
--     * Slot: id
--     * Slot: text_format Description: The format of the text, as a MIME type.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: text_id Description: The annotation's text.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnThrowEvent Description: An event that throws a trigger, such as an end or intermediate throw event.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: input_set_id Description: The input set the event's data inputs make up.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTimeCycle Description: The expression for a timer that fires repeatedly.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTimeDate Description: The expression for a timer that fires at a point in time.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTimeDuration Description: The expression for a timer that fires once a duration has passed.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTimerEventDefinition Description: The trigger of an event that fires at a time, after a duration or on a cycle.
--     * Slot: id
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: time_date_id Description: The timer's point in time.
--     * Slot: time_duration_id Description: The timer's duration.
--     * Slot: time_cycle_id Description: The timer's cycle.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTo Description: The expression an assignment copies a value to.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTransaction Description: A sub-process whose activities succeed or are undone together.
--     * Slot: id
--     * Slot: method Description: How the transaction commits or cancels; compensation unless the document says otherwise.
--     * Slot: triggered_by_event Description: Whether the sub-process is an event sub-process, started by an event.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTransformation Description: The expression that changes data as a data association copies it.
--     * Slot: id
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnUserTask Description: A task a person performs with the help of a software application.
--     * Slot: id
--     * Slot: implementation Description: The technology that runs the task, as a URI.
--     * Slot: fluxnova_assignee Description: The user the task is assigned to, as a user id or an expression.
--     * Slot: fluxnova_candidate_groups Description: The groups whose members may claim the task, as a comma-separated list or an expression.
--     * Slot: fluxnova_candidate_users Description: The users who may claim the task, as a comma-separated list or an expression.
--     * Slot: fluxnova_due_date Description: When the task is due, as a date or an expression.
--     * Slot: fluxnova_follow_up_date Description: When the task should be looked at again, as a date or an expression.
--     * Slot: fluxnova_form_handler_class Description: The Java class that handles the form.
--     * Slot: fluxnova_form_key Description: The key of the form to show.
--     * Slot: fluxnova_form_ref Description: The key of the deployed form to show.
--     * Slot: fluxnova_form_ref_binding Description: Which version of the deployed form to use.
--     * Slot: fluxnova_form_ref_version Description: The version of the deployed form, when the binding asks for one.
--     * Slot: fluxnova_priority Description: The task's priority, as a number or an expression.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: bpmn_id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_id Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_id Description: How the activity repeats.
--     * Slot: auditing_id Description: The element's auditing hook.
--     * Slot: monitoring_id Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: FluxnovaConnector Description: A connector that a service task or message event calls, with its id and its inputs and outputs.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: connector_id_id Description: The id of the connector to call.
--     * Slot: input_output_id Description: The connector's input and output parameters.
-- # Class: FluxnovaConnectorId Description: The id of the connector to call.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaConstraint Description: A rule a form field's value must meet, such as required or a maximum length.
--     * Slot: id
--     * Slot: fluxnova_name Description: The constraint's name, such as required, minlength or max.
--     * Slot: fluxnova_config Description: The constraint's setting, such as the maximum length.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: FluxnovaValidation_id Description: Autocreated FK slot
-- # Class: FluxnovaEntry Description: One key and value of a map.
--     * Slot: id
--     * Slot: fluxnova_key Description: The entry's key.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: FluxnovaMap_id Description: Autocreated FK slot
-- # Class: FluxnovaErrorEventDefinition Description: An error event definition on an external service task, raised when its expression holds.
--     * Slot: id
--     * Slot: fluxnova_expression Description: The expression that, when true, raises the error.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaExecutionListener Description: Code the engine runs when an execution passes an event of an element, such as its start or end.
--     * Slot: id
--     * Slot: fluxnova_event Description: The event the listener runs on, such as start, end, take, create or complete.
--     * Slot: fluxnova_class Description: The Java class the engine instantiates to run the element.
--     * Slot: fluxnova_expression Description: An expression the engine evaluates when the listener runs.
--     * Slot: fluxnova_delegate_expression Description: An expression that gives the delegate object the engine calls.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: script_id Description: The script the listener runs.
-- # Class: FluxnovaExpression Description: An expression a field injects.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaFailedJobRetryTimeCycle Description: How often, and how many times, the engine retries a failed job.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaField Description: A value injected into a field of a delegate class, as a string or an expression.
--     * Slot: id
--     * Slot: fluxnova_name Description: The name of the field to inject.
--     * Slot: fluxnova_expression Description: The expression injected into the field.
--     * Slot: fluxnova_string_value Description: The string injected into the field.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: FluxnovaExecutionListener_id Description: Autocreated FK slot
--     * Slot: FluxnovaTaskListener_id Description: Autocreated FK slot
--     * Slot: expression_id Description: The expression injected into the field.
--     * Slot: string_id Description: The string injected into the field.
-- # Class: FluxnovaFormData Description: The form fields of a generated task or start form.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaFormField Description: One field of a generated form.
--     * Slot: id
--     * Slot: fluxnova_id Description: The field's id, which names the variable it is stored in.
--     * Slot: fluxnova_label Description: The label shown with the field.
--     * Slot: fluxnova_type Description: The type of the field's value, such as string, long, boolean, date or enum.
--     * Slot: fluxnova_date_pattern Description: The pattern a date value is written in.
--     * Slot: fluxnova_default_value Description: The field's default value.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: FluxnovaFormData_id Description: Autocreated FK slot
--     * Slot: properties_id Description: The field's properties.
--     * Slot: validation_id Description: The rules the field's value must meet.
-- # Class: FluxnovaFormProperty Description: A form property, the older way of declaring a generated form's fields.
--     * Slot: id
--     * Slot: fluxnova_id Description: The property's id.
--     * Slot: fluxnova_name Description: The property's label.
--     * Slot: fluxnova_type Description: The type of the property's value.
--     * Slot: fluxnova_required Description: Whether the property must be given a value.
--     * Slot: fluxnova_readable Description: Whether the property can be read.
--     * Slot: fluxnova_writeable Description: Whether the property can be written.
--     * Slot: fluxnova_variable Description: The variable the property is bound to.
--     * Slot: fluxnova_expression Description: An expression that gives the property's value.
--     * Slot: fluxnova_date_pattern Description: The pattern a date value is written in.
--     * Slot: fluxnova_default Description: The property's default value.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaIn Description: A variable or business key passed into a called process or case.
--     * Slot: id
--     * Slot: fluxnova_source Description: The variable in the source scope to pass.
--     * Slot: fluxnova_source_expression Description: The expression whose value is passed.
--     * Slot: fluxnova_variables Description: Which variables are passed; all passes every one.
--     * Slot: fluxnova_target Description: The variable in the target scope that receives the value.
--     * Slot: fluxnova_business_key Description: The business key passed to the called process.
--     * Slot: fluxnova_local Description: Whether only the local variables of the calling scope are passed.
--     * Slot: fluxnova_restricted Description: Whether the mapping is restricted, a setting Fluxnova adds in its own namespace.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaInputOutput Description: The input and output parameters of an activity or connector.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaInputParameter Description: A variable set in an activity's scope before it starts.
--     * Slot: id
--     * Slot: fluxnova_name Description: The variable the parameter sets.
--     * Slot: fluxnova_restricted Description: Whether the mapping is restricted, a setting Fluxnova adds in its own namespace.
--     * Slot: fluxnova_is_transient Description: Whether the variable is kept only while the transaction runs.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: FluxnovaInputOutput_id Description: Autocreated FK slot
-- # Class: FluxnovaList Description: A list value of a parameter.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaMap Description: A map value of a parameter.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaOut Description: A variable passed back from a called process or case.
--     * Slot: id
--     * Slot: fluxnova_source Description: The variable in the source scope to pass.
--     * Slot: fluxnova_source_expression Description: The expression whose value is passed.
--     * Slot: fluxnova_variables Description: Which variables are passed; all passes every one.
--     * Slot: fluxnova_target Description: The variable in the target scope that receives the value.
--     * Slot: fluxnova_local Description: Whether only the local variables of the calling scope are passed.
--     * Slot: fluxnova_restricted Description: Whether the mapping is restricted, a setting Fluxnova adds in its own namespace.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaOutputParameter Description: A variable set outside an activity once it ends.
--     * Slot: id
--     * Slot: fluxnova_name Description: The variable the parameter sets.
--     * Slot: fluxnova_restricted Description: Whether the mapping is restricted, a setting Fluxnova adds in its own namespace.
--     * Slot: fluxnova_is_transient Description: Whether the variable is kept only while the transaction runs.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: FluxnovaInputOutput_id Description: Autocreated FK slot
-- # Class: FluxnovaPotentialStarter Description: The users or groups who may start a process.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: resource_assignment_expression_id Description: The expression that chooses the resource.
-- # Class: FluxnovaProperties Description: A set of key and value properties on an element.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaProperty Description: One key and value property.
--     * Slot: id
--     * Slot: fluxnova_id Description: The property's id.
--     * Slot: fluxnova_name Description: The property's name.
--     * Slot: fluxnova_value Description: The property's value.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: FluxnovaProperties_id Description: Autocreated FK slot
-- # Class: FluxnovaScript Description: A script whose result is a value, such as a parameter's or a listener's.
--     * Slot: id
--     * Slot: script_format Description: The language the script is written in, such as groovy or javascript.
--     * Slot: bpmn_resource Description: A resource that holds the script, instead of the script's text.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaString Description: A string a field injects.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaTaskListener Description: Code the engine runs when a user task reaches an event, such as its creation or completion.
--     * Slot: id
--     * Slot: fluxnova_event Description: The event the listener runs on, such as start, end, take, create or complete.
--     * Slot: fluxnova_class Description: The Java class the engine instantiates to run the element.
--     * Slot: fluxnova_expression Description: An expression the engine evaluates when the listener runs.
--     * Slot: fluxnova_delegate_expression Description: An expression that gives the delegate object the engine calls.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: script_id Description: The script the listener runs.
--     * Slot: timer_event_definition_id Description: The timer of a listener that runs on a timeout.
-- # Class: FluxnovaValidation Description: The constraints of a form field.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: FluxnovaValue Description: One option of an enumerated form field.
--     * Slot: id
--     * Slot: fluxnova_id Description: The option's id, its stored value.
--     * Slot: fluxnova_name Description: The option's label.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: FluxnovaFormField_id Description: Autocreated FK slot
--     * Slot: FluxnovaFormProperty_id Description: Autocreated FK slot
-- # Class: BpmnActivity_incoming
--     * Slot: BpmnActivity_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnActivity_outgoing
--     * Slot: BpmnActivity_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnActivity_category_value_refs
--     * Slot: BpmnActivity_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnAdHocSubProcess_incoming
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnAdHocSubProcess_outgoing
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnAdHocSubProcess_category_value_refs
--     * Slot: BpmnAdHocSubProcess_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnBoundaryEvent_event_definition_refs
--     * Slot: BpmnBoundaryEvent_id Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnBoundaryEvent_incoming
--     * Slot: BpmnBoundaryEvent_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnBoundaryEvent_outgoing
--     * Slot: BpmnBoundaryEvent_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnBoundaryEvent_category_value_refs
--     * Slot: BpmnBoundaryEvent_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnBusinessRuleTask_incoming
--     * Slot: BpmnBusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnBusinessRuleTask_outgoing
--     * Slot: BpmnBusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnBusinessRuleTask_category_value_refs
--     * Slot: BpmnBusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnCallActivity_incoming
--     * Slot: BpmnCallActivity_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnCallActivity_outgoing
--     * Slot: BpmnCallActivity_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnCallActivity_category_value_refs
--     * Slot: BpmnCallActivity_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnCallConversation_participant_refs
--     * Slot: BpmnCallConversation_id Description: Autocreated FK slot
--     * Slot: participant_refs Description: The QNames of the participants in the conversation.
-- # Class: BpmnCallConversation_message_flow_refs
--     * Slot: BpmnCallConversation_id Description: Autocreated FK slot
--     * Slot: message_flow_refs Description: The QNames of the message flows the conversation node groups.
-- # Class: BpmnCallableElement_supported_interface_refs
--     * Slot: BpmnCallableElement_id Description: Autocreated FK slot
--     * Slot: supported_interface_refs Description: The QNames of the interfaces the element supports.
-- # Class: BpmnCatchEvent_event_definition_refs
--     * Slot: BpmnCatchEvent_id Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnCatchEvent_incoming
--     * Slot: BpmnCatchEvent_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnCatchEvent_outgoing
--     * Slot: BpmnCatchEvent_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnCatchEvent_category_value_refs
--     * Slot: BpmnCatchEvent_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnComplexGateway_incoming
--     * Slot: BpmnComplexGateway_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnComplexGateway_outgoing
--     * Slot: BpmnComplexGateway_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnComplexGateway_category_value_refs
--     * Slot: BpmnComplexGateway_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnConversation_participant_refs
--     * Slot: BpmnConversation_id Description: Autocreated FK slot
--     * Slot: participant_refs Description: The QNames of the participants in the conversation.
-- # Class: BpmnConversation_message_flow_refs
--     * Slot: BpmnConversation_id Description: Autocreated FK slot
--     * Slot: message_flow_refs Description: The QNames of the message flows the conversation node groups.
-- # Class: BpmnConversationNode_participant_refs
--     * Slot: BpmnConversationNode_id Description: Autocreated FK slot
--     * Slot: participant_refs Description: The QNames of the participants in the conversation.
-- # Class: BpmnConversationNode_message_flow_refs
--     * Slot: BpmnConversationNode_id Description: Autocreated FK slot
--     * Slot: message_flow_refs Description: The QNames of the message flows the conversation node groups.
-- # Class: BpmnCorrelationKey_correlation_property_refs
--     * Slot: BpmnCorrelationKey_id Description: Autocreated FK slot
--     * Slot: correlation_property_refs Description: The QNames of the correlation properties that make up this key.
-- # Class: BpmnDataAssociation_source_refs
--     * Slot: BpmnDataAssociation_id Description: Autocreated FK slot
--     * Slot: source_refs Description: The ids of the data the association copies from.
-- # Class: BpmnDataInputAssociation_source_refs
--     * Slot: BpmnDataInputAssociation_id Description: Autocreated FK slot
--     * Slot: source_refs Description: The ids of the data the association copies from.
-- # Class: BpmnDataObject_category_value_refs
--     * Slot: BpmnDataObject_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnDataObjectReference_category_value_refs
--     * Slot: BpmnDataObjectReference_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnDataOutputAssociation_source_refs
--     * Slot: BpmnDataOutputAssociation_id Description: Autocreated FK slot
--     * Slot: source_refs Description: The ids of the data the association copies from.
-- # Class: BpmnDataStoreReference_category_value_refs
--     * Slot: BpmnDataStoreReference_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnEndEvent_event_definition_refs
--     * Slot: BpmnEndEvent_id Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnEndEvent_incoming
--     * Slot: BpmnEndEvent_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnEndEvent_outgoing
--     * Slot: BpmnEndEvent_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnEndEvent_category_value_refs
--     * Slot: BpmnEndEvent_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnEvent_incoming
--     * Slot: BpmnEvent_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnEvent_outgoing
--     * Slot: BpmnEvent_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnEvent_category_value_refs
--     * Slot: BpmnEvent_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnEventBasedGateway_incoming
--     * Slot: BpmnEventBasedGateway_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnEventBasedGateway_outgoing
--     * Slot: BpmnEventBasedGateway_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnEventBasedGateway_category_value_refs
--     * Slot: BpmnEventBasedGateway_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnExclusiveGateway_incoming
--     * Slot: BpmnExclusiveGateway_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnExclusiveGateway_outgoing
--     * Slot: BpmnExclusiveGateway_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnExclusiveGateway_category_value_refs
--     * Slot: BpmnExclusiveGateway_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnFlowElement_category_value_refs
--     * Slot: BpmnFlowElement_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnFlowNode_incoming
--     * Slot: BpmnFlowNode_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnFlowNode_outgoing
--     * Slot: BpmnFlowNode_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnFlowNode_category_value_refs
--     * Slot: BpmnFlowNode_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnGateway_incoming
--     * Slot: BpmnGateway_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnGateway_outgoing
--     * Slot: BpmnGateway_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnGateway_category_value_refs
--     * Slot: BpmnGateway_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnInclusiveGateway_incoming
--     * Slot: BpmnInclusiveGateway_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnInclusiveGateway_outgoing
--     * Slot: BpmnInclusiveGateway_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnInclusiveGateway_category_value_refs
--     * Slot: BpmnInclusiveGateway_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnInputSet_data_input_refs
--     * Slot: BpmnInputSet_id Description: Autocreated FK slot
--     * Slot: data_input_refs Description: The ids of the data inputs this set holds.
-- # Class: BpmnInputSet_optional_input_refs
--     * Slot: BpmnInputSet_id Description: Autocreated FK slot
--     * Slot: optional_input_refs Description: The ids of inputs the set may do without.
-- # Class: BpmnInputSet_while_executing_input_refs
--     * Slot: BpmnInputSet_id Description: Autocreated FK slot
--     * Slot: while_executing_input_refs Description: The ids of inputs the element can take while it runs.
-- # Class: BpmnInputSet_output_set_refs
--     * Slot: BpmnInputSet_id Description: Autocreated FK slot
--     * Slot: output_set_refs Description: The ids of the output sets this input set can lead to.
-- # Class: BpmnIntermediateCatchEvent_event_definition_refs
--     * Slot: BpmnIntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnIntermediateCatchEvent_incoming
--     * Slot: BpmnIntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnIntermediateCatchEvent_outgoing
--     * Slot: BpmnIntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnIntermediateCatchEvent_category_value_refs
--     * Slot: BpmnIntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnIntermediateThrowEvent_event_definition_refs
--     * Slot: BpmnIntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnIntermediateThrowEvent_incoming
--     * Slot: BpmnIntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnIntermediateThrowEvent_outgoing
--     * Slot: BpmnIntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnIntermediateThrowEvent_category_value_refs
--     * Slot: BpmnIntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnLane_flow_node_refs
--     * Slot: BpmnLane_id Description: Autocreated FK slot
--     * Slot: flow_node_refs Description: The ids of the flow nodes in this lane.
-- # Class: BpmnLinkEventDefinition_bpmn_sources
--     * Slot: BpmnLinkEventDefinition_id Description: Autocreated FK slot
--     * Slot: bpmn_sources Description: The QNames of the throwing link events that jump to this one.
-- # Class: BpmnManualTask_incoming
--     * Slot: BpmnManualTask_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnManualTask_outgoing
--     * Slot: BpmnManualTask_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnManualTask_category_value_refs
--     * Slot: BpmnManualTask_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnOperation_error_refs
--     * Slot: BpmnOperation_id Description: Autocreated FK slot
--     * Slot: error_refs Description: The QNames of the errors the operation can raise.
-- # Class: BpmnOutputSet_data_output_refs
--     * Slot: BpmnOutputSet_id Description: Autocreated FK slot
--     * Slot: data_output_refs Description: The ids of the data outputs this set holds.
-- # Class: BpmnOutputSet_optional_output_refs
--     * Slot: BpmnOutputSet_id Description: Autocreated FK slot
--     * Slot: optional_output_refs Description: The ids of outputs the set may leave out.
-- # Class: BpmnOutputSet_while_executing_output_refs
--     * Slot: BpmnOutputSet_id Description: Autocreated FK slot
--     * Slot: while_executing_output_refs Description: The ids of outputs the element can produce while it runs.
-- # Class: BpmnOutputSet_input_set_refs
--     * Slot: BpmnOutputSet_id Description: Autocreated FK slot
--     * Slot: input_set_refs Description: The ids of the input sets this output set can be produced from.
-- # Class: BpmnParallelGateway_incoming
--     * Slot: BpmnParallelGateway_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnParallelGateway_outgoing
--     * Slot: BpmnParallelGateway_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnParallelGateway_category_value_refs
--     * Slot: BpmnParallelGateway_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnParticipant_interface_refs
--     * Slot: BpmnParticipant_id Description: Autocreated FK slot
--     * Slot: interface_refs Description: The QNames of the interfaces the participant offers.
-- # Class: BpmnParticipant_end_point_refs
--     * Slot: BpmnParticipant_id Description: Autocreated FK slot
--     * Slot: end_point_refs Description: The QNames of the end points where the participant can be reached.
-- # Class: BpmnProcess_supports
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: supports Description: The QNames of the processes this one supports.
-- # Class: BpmnProcess_supported_interface_refs
--     * Slot: BpmnProcess_id Description: Autocreated FK slot
--     * Slot: supported_interface_refs Description: The QNames of the interfaces the element supports.
-- # Class: BpmnReceiveTask_incoming
--     * Slot: BpmnReceiveTask_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnReceiveTask_outgoing
--     * Slot: BpmnReceiveTask_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnReceiveTask_category_value_refs
--     * Slot: BpmnReceiveTask_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnScriptTask_incoming
--     * Slot: BpmnScriptTask_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnScriptTask_outgoing
--     * Slot: BpmnScriptTask_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnScriptTask_category_value_refs
--     * Slot: BpmnScriptTask_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnSendTask_incoming
--     * Slot: BpmnSendTask_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnSendTask_outgoing
--     * Slot: BpmnSendTask_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnSendTask_category_value_refs
--     * Slot: BpmnSendTask_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnSequenceFlow_category_value_refs
--     * Slot: BpmnSequenceFlow_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnServiceTask_incoming
--     * Slot: BpmnServiceTask_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnServiceTask_outgoing
--     * Slot: BpmnServiceTask_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnServiceTask_category_value_refs
--     * Slot: BpmnServiceTask_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnStartEvent_event_definition_refs
--     * Slot: BpmnStartEvent_id Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnStartEvent_incoming
--     * Slot: BpmnStartEvent_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnStartEvent_outgoing
--     * Slot: BpmnStartEvent_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnStartEvent_category_value_refs
--     * Slot: BpmnStartEvent_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnSubConversation_participant_refs
--     * Slot: BpmnSubConversation_id Description: Autocreated FK slot
--     * Slot: participant_refs Description: The QNames of the participants in the conversation.
-- # Class: BpmnSubConversation_message_flow_refs
--     * Slot: BpmnSubConversation_id Description: Autocreated FK slot
--     * Slot: message_flow_refs Description: The QNames of the message flows the conversation node groups.
-- # Class: BpmnSubProcess_incoming
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnSubProcess_outgoing
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnSubProcess_category_value_refs
--     * Slot: BpmnSubProcess_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnTask_incoming
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnTask_outgoing
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnTask_category_value_refs
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnThrowEvent_event_definition_refs
--     * Slot: BpmnThrowEvent_id Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnThrowEvent_incoming
--     * Slot: BpmnThrowEvent_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnThrowEvent_outgoing
--     * Slot: BpmnThrowEvent_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnThrowEvent_category_value_refs
--     * Slot: BpmnThrowEvent_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnTransaction_incoming
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnTransaction_outgoing
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnTransaction_category_value_refs
--     * Slot: BpmnTransaction_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnUserTask_incoming
--     * Slot: BpmnUserTask_id Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnUserTask_outgoing
--     * Slot: BpmnUserTask_id Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnUserTask_category_value_refs
--     * Slot: BpmnUserTask_id Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.

CREATE TABLE "FluxnovaPlatformData" (
	id INTEGER NOT NULL,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaPlatformData_id" ON "FluxnovaPlatformData" (id);

CREATE TABLE "FluxnovaAttachment" (
	id TEXT NOT NULL,
	user_id TEXT,
	name TEXT,
	description TEXT,
	type TEXT,
	task_id TEXT,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	url TEXT,
	content_id TEXT,
	tenant_id TEXT,
	create_time DATETIME,
	removal_time DATETIME,
	created_by TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaAttachment_id" ON "FluxnovaAttachment" (id);

CREATE TABLE "FluxnovaAuthorization" (
	id TEXT NOT NULL,
	type INTEGER NOT NULL,
	group_id TEXT,
	user_id TEXT,
	resource_type INTEGER NOT NULL,
	resource_id TEXT,
	permissions INTEGER,
	removal_time DATETIME,
	root_process_instance_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaAuthorization_id" ON "FluxnovaAuthorization" (id);

CREATE TABLE "FluxnovaCaseDefinition" (
	id TEXT NOT NULL,
	"key" TEXT NOT NULL,
	name TEXT,
	version INTEGER NOT NULL,
	category TEXT,
	deployment_id TEXT,
	resource_name TEXT,
	diagram_resource_name TEXT,
	tenant_id TEXT,
	history_time_to_live INTEGER,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaCaseDefinition_id" ON "FluxnovaCaseDefinition" (id);

CREATE TABLE "FluxnovaComment" (
	id TEXT NOT NULL,
	type TEXT,
	event_time DATETIME NOT NULL,
	user_id TEXT,
	task_id TEXT,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	action TEXT,
	message TEXT,
	full_message TEXT,
	tenant_id TEXT,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaComment_id" ON "FluxnovaComment" (id);

CREATE TABLE "FluxnovaConfiguration" (
	id TEXT NOT NULL,
	configuration_key TEXT NOT NULL,
	tenant_id TEXT,
	configuration_value TEXT NOT NULL,
	version INTEGER NOT NULL,
	status VARCHAR(8) NOT NULL,
	created_by TEXT,
	created_at DATETIME,
	updated_by TEXT,
	updated_at DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaConfiguration_id" ON "FluxnovaConfiguration" (id);

CREATE TABLE "FluxnovaDecisionRequirementsDefinition" (
	id TEXT NOT NULL,
	"key" TEXT NOT NULL,
	name TEXT,
	version INTEGER NOT NULL,
	category TEXT,
	deployment_id TEXT,
	resource_name TEXT,
	diagram_resource_name TEXT,
	tenant_id TEXT,
	history_time_to_live INTEGER,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaDecisionRequirementsDefinition_id" ON "FluxnovaDecisionRequirementsDefinition" (id);

CREATE TABLE "FluxnovaFilter" (
	id TEXT NOT NULL,
	resource_type TEXT NOT NULL,
	name TEXT NOT NULL,
	owner TEXT,
	"query" TEXT NOT NULL,
	properties TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaFilter_id" ON "FluxnovaFilter" (id);

CREATE TABLE "FluxnovaFormDefinition" (
	id TEXT NOT NULL,
	"key" TEXT NOT NULL,
	name TEXT,
	version INTEGER NOT NULL,
	category TEXT,
	deployment_id TEXT,
	resource_name TEXT,
	diagram_resource_name TEXT,
	tenant_id TEXT,
	history_time_to_live INTEGER,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaFormDefinition_id" ON "FluxnovaFormDefinition" (id);

CREATE TABLE "FluxnovaHistoricActivityInstance" (
	parent_activity_instance_id TEXT,
	execution_id TEXT NOT NULL,
	activity_id TEXT NOT NULL,
	task_id TEXT,
	called_process_instance_id TEXT,
	called_case_instance_id TEXT,
	activity_name TEXT,
	activity_type TEXT NOT NULL,
	assignee TEXT,
	activity_instance_state INTEGER,
	sequence_counter INTEGER,
	tenant_id TEXT,
	id TEXT NOT NULL,
	root_process_instance_id TEXT,
	process_instance_id TEXT NOT NULL,
	process_definition_id TEXT NOT NULL,
	process_definition_key TEXT,
	start_time DATETIME NOT NULL,
	end_time DATETIME,
	duration INTEGER,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricActivityInstance_id" ON "FluxnovaHistoricActivityInstance" (id);

CREATE TABLE "FluxnovaHistoricBatch" (
	id TEXT NOT NULL,
	type TEXT,
	total_jobs INTEGER,
	jobs_per_seed INTEGER,
	invocations_per_job INTEGER,
	seed_job_definition_id TEXT,
	monitor_job_definition_id TEXT,
	batch_job_definition_id TEXT,
	tenant_id TEXT,
	create_user_id TEXT,
	start_time DATETIME NOT NULL,
	end_time DATETIME,
	removal_time DATETIME,
	execution_start_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricBatch_id" ON "FluxnovaHistoricBatch" (id);

CREATE TABLE "FluxnovaHistoricCaseActivityInstance" (
	parent_activity_instance_id TEXT,
	case_definition_id TEXT NOT NULL,
	case_instance_id TEXT NOT NULL,
	case_activity_id TEXT NOT NULL,
	task_id TEXT,
	called_process_instance_id TEXT,
	called_case_instance_id TEXT,
	case_activity_name TEXT,
	case_activity_type TEXT,
	create_time DATETIME NOT NULL,
	state INTEGER,
	is_required BOOLEAN,
	tenant_id TEXT,
	id TEXT NOT NULL,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	start_time DATETIME,
	end_time DATETIME,
	duration INTEGER,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricCaseActivityInstance_id" ON "FluxnovaHistoricCaseActivityInstance" (id);

CREATE TABLE "FluxnovaHistoricCaseInstance" (
	case_instance_id TEXT NOT NULL,
	business_key TEXT,
	case_definition_id TEXT NOT NULL,
	create_time DATETIME NOT NULL,
	close_time DATETIME,
	state INTEGER,
	create_user_id TEXT,
	super_case_instance_id TEXT,
	super_process_instance_id TEXT,
	tenant_id TEXT,
	id TEXT NOT NULL,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	start_time DATETIME,
	end_time DATETIME,
	duration INTEGER,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricCaseInstance_id" ON "FluxnovaHistoricCaseInstance" (id);

CREATE TABLE "FluxnovaHistoricDecisionInputInstance" (
	id TEXT NOT NULL,
	decision_instance_id TEXT NOT NULL,
	clause_id TEXT,
	clause_name TEXT,
	variable_type TEXT,
	byte_array_id TEXT,
	double_value FLOAT,
	long_value INTEGER,
	text_value TEXT,
	text2_value TEXT,
	tenant_id TEXT,
	create_time DATETIME,
	root_process_instance_id TEXT,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricDecisionInputInstance_id" ON "FluxnovaHistoricDecisionInputInstance" (id);

CREATE TABLE "FluxnovaHistoricDecisionInstance" (
	id TEXT NOT NULL,
	decision_definition_id TEXT NOT NULL,
	decision_definition_key TEXT NOT NULL,
	decision_definition_name TEXT,
	process_definition_key TEXT,
	process_definition_id TEXT,
	process_instance_id TEXT,
	case_definition_key TEXT,
	case_definition_id TEXT,
	case_instance_id TEXT,
	activity_instance_id TEXT,
	activity_id TEXT,
	evaluation_time DATETIME NOT NULL,
	removal_time DATETIME,
	collect_result_value FLOAT,
	user_id TEXT,
	root_decision_instance_id TEXT,
	root_process_instance_id TEXT,
	decision_requirements_definition_id TEXT,
	decision_requirements_definition_key TEXT,
	tenant_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricDecisionInstance_id" ON "FluxnovaHistoricDecisionInstance" (id);

CREATE TABLE "FluxnovaHistoricDecisionOutputInstance" (
	id TEXT NOT NULL,
	decision_instance_id TEXT NOT NULL,
	clause_id TEXT,
	clause_name TEXT,
	rule_id TEXT,
	rule_order INTEGER,
	variable_name TEXT,
	variable_type TEXT,
	byte_array_id TEXT,
	double_value FLOAT,
	long_value INTEGER,
	text_value TEXT,
	text2_value TEXT,
	tenant_id TEXT,
	create_time DATETIME,
	root_process_instance_id TEXT,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricDecisionOutputInstance_id" ON "FluxnovaHistoricDecisionOutputInstance" (id);

CREATE TABLE "FluxnovaHistoricDetail" (
	id TEXT NOT NULL,
	type TEXT NOT NULL,
	event_time DATETIME NOT NULL,
	name TEXT NOT NULL,
	process_definition_key TEXT,
	process_definition_id TEXT,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	execution_id TEXT,
	case_definition_key TEXT,
	case_definition_id TEXT,
	case_instance_id TEXT,
	case_execution_id TEXT,
	task_id TEXT,
	activity_instance_id TEXT,
	variable_instance_id TEXT,
	variable_type TEXT,
	byte_array_id TEXT,
	double_value FLOAT,
	long_value INTEGER,
	text_value TEXT,
	text2_value TEXT,
	sequence_counter INTEGER,
	tenant_id TEXT,
	operation_id TEXT,
	removal_time DATETIME,
	is_initial BOOLEAN,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricDetail_id" ON "FluxnovaHistoricDetail" (id);

CREATE TABLE "FluxnovaHistoricExternalTaskLog" (
	id TEXT NOT NULL,
	timestamp DATETIME NOT NULL,
	external_task_id TEXT NOT NULL,
	retries INTEGER,
	topic_name TEXT,
	worker_id TEXT,
	priority INTEGER NOT NULL,
	error_message TEXT,
	error_details_id TEXT,
	activity_id TEXT,
	activity_instance_id TEXT,
	execution_id TEXT,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	tenant_id TEXT,
	state INTEGER,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricExternalTaskLog_id" ON "FluxnovaHistoricExternalTaskLog" (id);

CREATE TABLE "FluxnovaHistoricIdentityLink" (
	id TEXT NOT NULL,
	timestamp DATETIME NOT NULL,
	type TEXT,
	user_id TEXT,
	group_id TEXT,
	task_id TEXT,
	root_process_instance_id TEXT,
	process_definition_id TEXT,
	operation_type TEXT,
	assigner_id TEXT,
	process_definition_key TEXT,
	tenant_id TEXT,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricIdentityLink_id" ON "FluxnovaHistoricIdentityLink" (id);

CREATE TABLE "FluxnovaHistoricIncident" (
	id TEXT NOT NULL,
	process_definition_key TEXT,
	process_definition_id TEXT,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	execution_id TEXT,
	create_time DATETIME NOT NULL,
	end_time DATETIME,
	incident_message TEXT,
	incident_type TEXT NOT NULL,
	activity_id TEXT,
	failed_activity_id TEXT,
	cause_incident_id TEXT,
	root_cause_incident_id TEXT,
	configuration TEXT,
	history_configuration TEXT,
	incident_state INTEGER,
	tenant_id TEXT,
	job_definition_id TEXT,
	annotation TEXT,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricIncident_id" ON "FluxnovaHistoricIncident" (id);

CREATE TABLE "FluxnovaHistoricJobLog" (
	id TEXT NOT NULL,
	timestamp DATETIME NOT NULL,
	job_id TEXT NOT NULL,
	job_due_date DATETIME,
	job_retries INTEGER,
	job_priority INTEGER NOT NULL,
	job_exception_message TEXT,
	job_exception_stack_id TEXT,
	job_state INTEGER,
	job_definition_id TEXT,
	job_definition_type TEXT,
	job_definition_configuration TEXT,
	activity_id TEXT,
	failed_activity_id TEXT,
	execution_id TEXT,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	deployment_id TEXT,
	sequence_counter INTEGER,
	tenant_id TEXT,
	hostname TEXT,
	removal_time DATETIME,
	batch_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricJobLog_id" ON "FluxnovaHistoricJobLog" (id);

CREATE TABLE "FluxnovaHistoricProcessInstance" (
	business_key TEXT,
	start_user_id TEXT,
	start_activity_id TEXT,
	end_activity_id TEXT,
	super_process_instance_id TEXT,
	super_case_instance_id TEXT,
	case_instance_id TEXT,
	delete_reason TEXT,
	tenant_id TEXT,
	state VARCHAR(21),
	restarted_process_instance_id TEXT,
	id TEXT NOT NULL,
	root_process_instance_id TEXT,
	process_instance_id TEXT NOT NULL,
	process_definition_id TEXT NOT NULL,
	process_definition_key TEXT,
	start_time DATETIME NOT NULL,
	end_time DATETIME,
	duration INTEGER,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricProcessInstance_id" ON "FluxnovaHistoricProcessInstance" (id);

CREATE TABLE "FluxnovaHistoricScopeInstance" (
	id TEXT NOT NULL,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	start_time DATETIME,
	end_time DATETIME,
	duration INTEGER,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricScopeInstance_id" ON "FluxnovaHistoricScopeInstance" (id);

CREATE TABLE "FluxnovaHistoricTaskInstance" (
	task_definition_key TEXT,
	execution_id TEXT,
	case_definition_key TEXT,
	case_definition_id TEXT,
	case_instance_id TEXT,
	case_execution_id TEXT,
	activity_instance_id TEXT,
	name TEXT,
	parent_task_id TEXT,
	description TEXT,
	owner TEXT,
	assignee TEXT,
	delete_reason TEXT,
	priority INTEGER NOT NULL,
	due_date DATETIME,
	follow_up_date DATETIME,
	tenant_id TEXT,
	task_state TEXT,
	id TEXT NOT NULL,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	start_time DATETIME NOT NULL,
	end_time DATETIME,
	duration INTEGER,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricTaskInstance_id" ON "FluxnovaHistoricTaskInstance" (id);

CREATE TABLE "FluxnovaHistoricVariableInstance" (
	id TEXT NOT NULL,
	process_definition_key TEXT,
	process_definition_id TEXT,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	execution_id TEXT,
	case_definition_key TEXT,
	case_definition_id TEXT,
	case_instance_id TEXT,
	case_execution_id TEXT,
	task_id TEXT,
	activity_instance_id TEXT,
	name TEXT NOT NULL,
	variable_type TEXT,
	create_time DATETIME,
	byte_array_id TEXT,
	double_value FLOAT,
	long_value INTEGER,
	text_value TEXT,
	text2_value TEXT,
	tenant_id TEXT,
	state VARCHAR(7),
	removal_time DATETIME,
	restricted BOOLEAN,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaHistoricVariableInstance_id" ON "FluxnovaHistoricVariableInstance" (id);

CREATE TABLE "FluxnovaIdentityInfo" (
	id TEXT NOT NULL,
	user_id TEXT,
	type TEXT,
	"key" TEXT,
	value TEXT,
	password TEXT,
	parent_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaIdentityInfo_id" ON "FluxnovaIdentityInfo" (id);

CREATE TABLE "FluxnovaJobDefinition" (
	id TEXT NOT NULL,
	process_definition_id TEXT,
	process_definition_key TEXT,
	activity_id TEXT,
	job_type TEXT NOT NULL,
	job_configuration TEXT,
	suspension_state INTEGER,
	job_priority INTEGER NOT NULL,
	tenant_id TEXT,
	deployment_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaJobDefinition_id" ON "FluxnovaJobDefinition" (id);

CREATE TABLE "FluxnovaMeterLog" (
	id TEXT NOT NULL,
	name TEXT NOT NULL,
	reporter TEXT,
	value INTEGER,
	timestamp DATETIME,
	milliseconds INTEGER,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaMeterLog_id" ON "FluxnovaMeterLog" (id);

CREATE TABLE "FluxnovaEngineProperty" (
	name TEXT NOT NULL,
	value TEXT,
	PRIMARY KEY (name)
);
CREATE INDEX "ix_FluxnovaEngineProperty_name" ON "FluxnovaEngineProperty" (name);

CREATE TABLE "FluxnovaResourceDefinition" (
	id TEXT NOT NULL,
	"key" TEXT,
	name TEXT,
	version INTEGER,
	category TEXT,
	deployment_id TEXT,
	resource_name TEXT,
	diagram_resource_name TEXT,
	tenant_id TEXT,
	history_time_to_live INTEGER,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaResourceDefinition_id" ON "FluxnovaResourceDefinition" (id);

CREATE TABLE "FluxnovaSchemaLogEntry" (
	id TEXT NOT NULL,
	timestamp DATETIME,
	version TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaSchemaLogEntry_id" ON "FluxnovaSchemaLogEntry" (id);

CREATE TABLE "FluxnovaTaskMeterLog" (
	id TEXT NOT NULL,
	assignee_hash INTEGER,
	timestamp DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaTaskMeterLog_id" ON "FluxnovaTaskMeterLog" (id);

CREATE TABLE "FluxnovaTenant" (
	id TEXT NOT NULL,
	name TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaTenant_id" ON "FluxnovaTenant" (id);

CREATE TABLE "FluxnovaUserOperationLogEntry" (
	id TEXT NOT NULL,
	deployment_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	execution_id TEXT,
	case_definition_id TEXT,
	case_instance_id TEXT,
	case_execution_id TEXT,
	task_id TEXT,
	job_id TEXT NOT NULL,
	job_definition_id TEXT,
	batch_id TEXT,
	user_id TEXT,
	timestamp DATETIME NOT NULL,
	operation_type TEXT,
	operation_id TEXT,
	entity_type TEXT,
	property TEXT,
	original_value TEXT,
	new_value TEXT,
	tenant_id TEXT,
	removal_time DATETIME,
	category TEXT,
	external_task_id TEXT NOT NULL,
	annotation TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaUserOperationLogEntry_id" ON "FluxnovaUserOperationLogEntry" (id);

CREATE TABLE "BpmnModelElementInstance" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_BpmnModelElementInstance_id" ON "BpmnModelElementInstance" (id);

CREATE TABLE "DcBounds" (
	id INTEGER NOT NULL,
	x FLOAT NOT NULL,
	y FLOAT NOT NULL,
	width FLOAT NOT NULL,
	height FLOAT NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_DcBounds_id" ON "DcBounds" (id);

CREATE TABLE "DcFont" (
	id INTEGER NOT NULL,
	name TEXT,
	size FLOAT,
	is_bold BOOLEAN,
	is_italic BOOLEAN,
	is_underline BOOLEAN,
	is_strike_through BOOLEAN,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_DcFont_id" ON "DcFont" (id);

CREATE TABLE "DcPoint" (
	id INTEGER NOT NULL,
	x FLOAT NOT NULL,
	y FLOAT NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_DcPoint_id" ON "DcPoint" (id);

CREATE TABLE "DiDiagram" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_documentation TEXT,
	resolution FLOAT,
	bpmn_id TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_DiDiagram_id" ON "DiDiagram" (id);

CREATE TABLE "DiExtension" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_DiExtension_id" ON "DiExtension" (id);

CREATE TABLE "DiStyle" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_DiStyle_id" ON "DiStyle" (id);

CREATE TABLE "BpmnDefinitions" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	name TEXT,
	target_namespace TEXT NOT NULL,
	expression_language TEXT,
	type_language TEXT,
	exporter TEXT,
	exporter_version TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_BpmnDefinitions_id" ON "BpmnDefinitions" (id);

CREATE TABLE "BpmnExtensionElements" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_BpmnExtensionElements_id" ON "BpmnExtensionElements" (id);

CREATE TABLE "BpmnInteractionNode" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_BpmnInteractionNode_id" ON "BpmnInteractionNode" (id);

CREATE TABLE "BpmnScript" (
	id INTEGER NOT NULL,
	text_content TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_BpmnScript_id" ON "BpmnScript" (id);

CREATE TABLE "BpmnText" (
	id INTEGER NOT NULL,
	text_content TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_BpmnText_id" ON "BpmnText" (id);

CREATE TABLE "FluxnovaConnectorId" (
	id INTEGER NOT NULL,
	text_content TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaConnectorId_id" ON "FluxnovaConnectorId" (id);

CREATE TABLE "FluxnovaErrorEventDefinition" (
	id INTEGER NOT NULL,
	fluxnova_expression TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaErrorEventDefinition_id" ON "FluxnovaErrorEventDefinition" (id);

CREATE TABLE "FluxnovaExpression" (
	id INTEGER NOT NULL,
	text_content TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaExpression_id" ON "FluxnovaExpression" (id);

CREATE TABLE "FluxnovaFailedJobRetryTimeCycle" (
	id INTEGER NOT NULL,
	text_content TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaFailedJobRetryTimeCycle_id" ON "FluxnovaFailedJobRetryTimeCycle" (id);

CREATE TABLE "FluxnovaFormData" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaFormData_id" ON "FluxnovaFormData" (id);

CREATE TABLE "FluxnovaFormProperty" (
	id INTEGER NOT NULL,
	fluxnova_id TEXT,
	fluxnova_name TEXT,
	fluxnova_type TEXT,
	fluxnova_required BOOLEAN,
	fluxnova_readable BOOLEAN,
	fluxnova_writeable BOOLEAN,
	fluxnova_variable TEXT,
	fluxnova_expression TEXT,
	fluxnova_date_pattern TEXT,
	fluxnova_default TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaFormProperty_id" ON "FluxnovaFormProperty" (id);

CREATE TABLE "FluxnovaIn" (
	id INTEGER NOT NULL,
	fluxnova_source TEXT,
	fluxnova_source_expression TEXT,
	fluxnova_variables TEXT,
	fluxnova_target TEXT,
	fluxnova_business_key TEXT,
	fluxnova_local BOOLEAN,
	fluxnova_restricted BOOLEAN,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaIn_id" ON "FluxnovaIn" (id);

CREATE TABLE "FluxnovaInputOutput" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaInputOutput_id" ON "FluxnovaInputOutput" (id);

CREATE TABLE "FluxnovaList" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaList_id" ON "FluxnovaList" (id);

CREATE TABLE "FluxnovaMap" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaMap_id" ON "FluxnovaMap" (id);

CREATE TABLE "FluxnovaOut" (
	id INTEGER NOT NULL,
	fluxnova_source TEXT,
	fluxnova_source_expression TEXT,
	fluxnova_variables TEXT,
	fluxnova_target TEXT,
	fluxnova_local BOOLEAN,
	fluxnova_restricted BOOLEAN,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaOut_id" ON "FluxnovaOut" (id);

CREATE TABLE "FluxnovaProperties" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaProperties_id" ON "FluxnovaProperties" (id);

CREATE TABLE "FluxnovaScript" (
	id INTEGER NOT NULL,
	script_format TEXT NOT NULL,
	bpmn_resource TEXT,
	text_content TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaScript_id" ON "FluxnovaScript" (id);

CREATE TABLE "FluxnovaString" (
	id INTEGER NOT NULL,
	text_content TEXT,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaString_id" ON "FluxnovaString" (id);

CREATE TABLE "FluxnovaValidation" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaValidation_id" ON "FluxnovaValidation" (id);

CREATE TABLE "FluxnovaBatch" (
	id TEXT NOT NULL,
	type TEXT,
	total_jobs INTEGER,
	jobs_created INTEGER,
	jobs_per_seed INTEGER,
	invocations_per_job INTEGER,
	seed_job_definition_id TEXT,
	batch_job_definition_id TEXT,
	monitor_job_definition_id TEXT,
	suspension_state INTEGER,
	configuration TEXT,
	tenant_id TEXT,
	create_user_id TEXT,
	start_time DATETIME,
	execution_start_time DATETIME,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(seed_job_definition_id) REFERENCES "FluxnovaJobDefinition" (id),
	FOREIGN KEY(batch_job_definition_id) REFERENCES "FluxnovaJobDefinition" (id),
	FOREIGN KEY(monitor_job_definition_id) REFERENCES "FluxnovaJobDefinition" (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_FluxnovaBatch_id" ON "FluxnovaBatch" (id);

CREATE TABLE "FluxnovaCaseExecution" (
	id TEXT NOT NULL,
	case_instance_id TEXT,
	super_case_execution_id TEXT,
	super_execution_id TEXT,
	business_key TEXT,
	parent_id TEXT,
	case_definition_id TEXT,
	activity_id TEXT,
	previous_state INTEGER,
	current_state INTEGER,
	is_required BOOLEAN,
	tenant_id TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY(case_instance_id) REFERENCES "FluxnovaCaseExecution" (id),
	FOREIGN KEY(parent_id) REFERENCES "FluxnovaCaseExecution" (id),
	FOREIGN KEY(case_definition_id) REFERENCES "FluxnovaCaseDefinition" (id)
);
CREATE INDEX "ix_FluxnovaCaseExecution_id" ON "FluxnovaCaseExecution" (id);

CREATE TABLE "FluxnovaDecisionDefinition" (
	decision_requirements_definition_id TEXT,
	decision_requirements_definition_key TEXT,
	version_tag TEXT,
	id TEXT NOT NULL,
	"key" TEXT NOT NULL,
	name TEXT,
	version INTEGER NOT NULL,
	category TEXT,
	deployment_id TEXT,
	resource_name TEXT,
	diagram_resource_name TEXT,
	tenant_id TEXT,
	history_time_to_live INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(decision_requirements_definition_id) REFERENCES "FluxnovaDecisionRequirementsDefinition" (id)
);
CREATE INDEX "ix_FluxnovaDecisionDefinition_id" ON "FluxnovaDecisionDefinition" (id);

CREATE TABLE "FluxnovaDeployment" (
	id TEXT NOT NULL,
	name TEXT,
	deploy_time DATETIME,
	source TEXT,
	tenant_id TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_FluxnovaDeployment_id" ON "FluxnovaDeployment" (id);

CREATE TABLE "FluxnovaGroup" (
	id TEXT NOT NULL,
	name TEXT,
	type TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_FluxnovaGroup_id" ON "FluxnovaGroup" (id);

CREATE TABLE "FluxnovaProcessDefinition" (
	has_start_form_key BOOLEAN,
	suspension_state INTEGER,
	version_tag TEXT,
	is_startable BOOLEAN NOT NULL,
	id TEXT NOT NULL,
	"key" TEXT NOT NULL,
	name TEXT,
	version INTEGER NOT NULL,
	category TEXT,
	deployment_id TEXT,
	resource_name TEXT,
	diagram_resource_name TEXT,
	tenant_id TEXT,
	history_time_to_live INTEGER,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_FluxnovaProcessDefinition_id" ON "FluxnovaProcessDefinition" (id);

CREATE TABLE "FluxnovaUser" (
	id TEXT NOT NULL,
	first_name TEXT,
	last_name TEXT,
	email TEXT,
	password TEXT,
	salt TEXT,
	lock_expiration_time DATETIME,
	attempts INTEGER,
	picture_id TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_FluxnovaUser_id" ON "FluxnovaUser" (id);

CREATE TABLE "DiEdge" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiEdge_id" ON "DiEdge" (id);

CREATE TABLE "DiLabel" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	bounds_id INTEGER,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiLabel_id" ON "DiLabel" (id);

CREATE TABLE "DiLabeledEdge" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiLabeledEdge_id" ON "DiLabeledEdge" (id);

CREATE TABLE "DiLabeledShape" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	bounds_id INTEGER NOT NULL,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiLabeledShape_id" ON "DiLabeledShape" (id);

CREATE TABLE "DiNode" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiNode_id" ON "DiNode" (id);

CREATE TABLE "DiPlane" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiPlane_id" ON "DiPlane" (id);

CREATE TABLE "DiShape" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	bounds_id INTEGER NOT NULL,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiShape_id" ON "DiShape" (id);

CREATE TABLE "BpmnLabel" (
	id INTEGER NOT NULL,
	label_style TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	bounds_id INTEGER,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_BpmnLabel_id" ON "BpmnLabel" (id);

CREATE TABLE "BpmnPlane" (
	id INTEGER NOT NULL,
	bpmn_element TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_BpmnPlane_id" ON "BpmnPlane" (id);

CREATE TABLE "BpmnActivationCondition" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnActivationCondition_id" ON "BpmnActivationCondition" (id);

CREATE TABLE "BpmnAssociation" (
	id INTEGER NOT NULL,
	source_ref TEXT NOT NULL,
	target_ref TEXT NOT NULL,
	association_direction VARCHAR(4),
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnAssociation_id" ON "BpmnAssociation" (id);

CREATE TABLE "BpmnAuditing" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnAuditing_id" ON "BpmnAuditing" (id);

CREATE TABLE "BpmnBaseElement" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnBaseElement_id" ON "BpmnBaseElement" (id);

CREATE TABLE "BpmnCallConversation" (
	id INTEGER NOT NULL,
	called_collaboration_ref TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCallConversation_id" ON "BpmnCallConversation" (id);

CREATE TABLE "BpmnCancelEventDefinition" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCancelEventDefinition_id" ON "BpmnCancelEventDefinition" (id);

CREATE TABLE "BpmnCategory" (
	id INTEGER NOT NULL,
	name TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCategory_id" ON "BpmnCategory" (id);

CREATE TABLE "BpmnChildLaneSet" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnChildLaneSet_id" ON "BpmnChildLaneSet" (id);

CREATE TABLE "BpmnCollaboration" (
	id INTEGER NOT NULL,
	name TEXT,
	is_closed BOOLEAN,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCollaboration_id" ON "BpmnCollaboration" (id);

CREATE TABLE "BpmnCompensateEventDefinition" (
	id INTEGER NOT NULL,
	wait_for_completion BOOLEAN,
	activity_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCompensateEventDefinition_id" ON "BpmnCompensateEventDefinition" (id);

CREATE TABLE "BpmnCompletionCondition" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCompletionCondition_id" ON "BpmnCompletionCondition" (id);

CREATE TABLE "BpmnCondition" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCondition_id" ON "BpmnCondition" (id);

CREATE TABLE "BpmnConditionExpression" (
	id INTEGER NOT NULL,
	xsi_type TEXT,
	fluxnova_resource TEXT,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConditionExpression_id" ON "BpmnConditionExpression" (id);

CREATE TABLE "BpmnConversation" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConversation_id" ON "BpmnConversation" (id);

CREATE TABLE "BpmnCorrelationProperty" (
	id INTEGER NOT NULL,
	name TEXT,
	type TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationProperty_id" ON "BpmnCorrelationProperty" (id);

CREATE TABLE "BpmnDataPath" (
	id INTEGER NOT NULL,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataPath_id" ON "BpmnDataPath" (id);

CREATE TABLE "BpmnDataState" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataState_id" ON "BpmnDataState" (id);

CREATE TABLE "BpmnEndPoint" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEndPoint_id" ON "BpmnEndPoint" (id);

CREATE TABLE "BpmnError" (
	id INTEGER NOT NULL,
	name TEXT,
	error_code TEXT,
	fluxnova_error_message TEXT,
	structure_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnError_id" ON "BpmnError" (id);

CREATE TABLE "BpmnErrorEventDefinition" (
	id INTEGER NOT NULL,
	error_ref TEXT,
	fluxnova_error_code_variable TEXT,
	fluxnova_error_message_variable TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnErrorEventDefinition_id" ON "BpmnErrorEventDefinition" (id);

CREATE TABLE "BpmnEscalation" (
	id INTEGER NOT NULL,
	name TEXT,
	escalation_code TEXT,
	structure_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEscalation_id" ON "BpmnEscalation" (id);

CREATE TABLE "BpmnEscalationEventDefinition" (
	id INTEGER NOT NULL,
	escalation_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEscalationEventDefinition_id" ON "BpmnEscalationEventDefinition" (id);

CREATE TABLE "BpmnExpression" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnExpression_id" ON "BpmnExpression" (id);

CREATE TABLE "BpmnExtension" (
	id INTEGER NOT NULL,
	bpmn_definition TEXT,
	must_understand BOOLEAN,
	element_type TEXT,
	"BpmnDefinitions_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDefinitions_id") REFERENCES "BpmnDefinitions" (id)
);
CREATE INDEX "ix_BpmnExtension_id" ON "BpmnExtension" (id);

CREATE TABLE "BpmnFormalExpression" (
	id INTEGER NOT NULL,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnFormalExpression_id" ON "BpmnFormalExpression" (id);

CREATE TABLE "BpmnFrom" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnFrom_id" ON "BpmnFrom" (id);

CREATE TABLE "BpmnGlobalConversation" (
	id INTEGER NOT NULL,
	name TEXT,
	is_closed BOOLEAN,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnGlobalConversation_id" ON "BpmnGlobalConversation" (id);

CREATE TABLE "BpmnGroup" (
	id INTEGER NOT NULL,
	category_value_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnGroup_id" ON "BpmnGroup" (id);

CREATE TABLE "BpmnImport" (
	id INTEGER NOT NULL,
	namespace TEXT NOT NULL,
	location TEXT NOT NULL,
	import_type TEXT NOT NULL,
	element_type TEXT,
	"BpmnDefinitions_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDefinitions_id") REFERENCES "BpmnDefinitions" (id)
);
CREATE INDEX "ix_BpmnImport_id" ON "BpmnImport" (id);

CREATE TABLE "BpmnInterface" (
	id INTEGER NOT NULL,
	name TEXT NOT NULL,
	implementation_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnInterface_id" ON "BpmnInterface" (id);

CREATE TABLE "BpmnIoSpecification" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnIoSpecification_id" ON "BpmnIoSpecification" (id);

CREATE TABLE "BpmnItemDefinition" (
	id INTEGER NOT NULL,
	structure_ref TEXT,
	is_collection BOOLEAN,
	item_kind VARCHAR(11),
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnItemDefinition_id" ON "BpmnItemDefinition" (id);

CREATE TABLE "BpmnLinkEventDefinition" (
	id INTEGER NOT NULL,
	name TEXT NOT NULL,
	bpmn_target TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLinkEventDefinition_id" ON "BpmnLinkEventDefinition" (id);

CREATE TABLE "BpmnLoopCardinality" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLoopCardinality_id" ON "BpmnLoopCardinality" (id);

CREATE TABLE "BpmnLoopCharacteristics" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLoopCharacteristics_id" ON "BpmnLoopCharacteristics" (id);

CREATE TABLE "BpmnMessage" (
	id INTEGER NOT NULL,
	name TEXT,
	item_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessage_id" ON "BpmnMessage" (id);

CREATE TABLE "BpmnMessageEventDefinition" (
	id INTEGER NOT NULL,
	message_ref TEXT,
	fluxnova_class TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_expression TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_topic TEXT,
	fluxnova_type TEXT,
	fluxnova_task_priority TEXT,
	operation_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessageEventDefinition_id" ON "BpmnMessageEventDefinition" (id);

CREATE TABLE "BpmnMessagePath" (
	id INTEGER NOT NULL,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessagePath_id" ON "BpmnMessagePath" (id);

CREATE TABLE "BpmnMonitoring" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMonitoring_id" ON "BpmnMonitoring" (id);

CREATE TABLE "BpmnParticipantMultiplicity" (
	id INTEGER NOT NULL,
	minimum INTEGER,
	maximum INTEGER,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnParticipantMultiplicity_id" ON "BpmnParticipantMultiplicity" (id);

CREATE TABLE "BpmnPartitionElement" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnPartitionElement_id" ON "BpmnPartitionElement" (id);

CREATE TABLE "BpmnRelationship" (
	id INTEGER NOT NULL,
	type TEXT NOT NULL,
	direction VARCHAR(8),
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnDefinitions_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDefinitions_id") REFERENCES "BpmnDefinitions" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnRelationship_id" ON "BpmnRelationship" (id);

CREATE TABLE "BpmnResource" (
	id INTEGER NOT NULL,
	name TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResource_id" ON "BpmnResource" (id);

CREATE TABLE "BpmnRootElement" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnDefinitions_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDefinitions_id") REFERENCES "BpmnDefinitions" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnRootElement_id" ON "BpmnRootElement" (id);

CREATE TABLE "BpmnSignal" (
	id INTEGER NOT NULL,
	name TEXT,
	structure_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSignal_id" ON "BpmnSignal" (id);

CREATE TABLE "BpmnSignalEventDefinition" (
	id INTEGER NOT NULL,
	signal_ref TEXT,
	fluxnova_async BOOLEAN,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSignalEventDefinition_id" ON "BpmnSignalEventDefinition" (id);

CREATE TABLE "BpmnSubConversation" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSubConversation_id" ON "BpmnSubConversation" (id);

CREATE TABLE "BpmnTerminateEventDefinition" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTerminateEventDefinition_id" ON "BpmnTerminateEventDefinition" (id);

CREATE TABLE "BpmnTextAnnotation" (
	id INTEGER NOT NULL,
	text_format TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	text_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(text_id) REFERENCES "BpmnText" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTextAnnotation_id" ON "BpmnTextAnnotation" (id);

CREATE TABLE "BpmnTimeCycle" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTimeCycle_id" ON "BpmnTimeCycle" (id);

CREATE TABLE "BpmnTimeDate" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTimeDate_id" ON "BpmnTimeDate" (id);

CREATE TABLE "BpmnTimeDuration" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTimeDuration_id" ON "BpmnTimeDuration" (id);

CREATE TABLE "BpmnTo" (
	id INTEGER NOT NULL,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTo_id" ON "BpmnTo" (id);

CREATE TABLE "BpmnTransformation" (
	id INTEGER NOT NULL,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTransformation_id" ON "BpmnTransformation" (id);

CREATE TABLE "FluxnovaConnector" (
	id INTEGER NOT NULL,
	element_type TEXT,
	connector_id_id INTEGER NOT NULL,
	input_output_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(connector_id_id) REFERENCES "FluxnovaConnectorId" (id),
	FOREIGN KEY(input_output_id) REFERENCES "FluxnovaInputOutput" (id)
);
CREATE INDEX "ix_FluxnovaConnector_id" ON "FluxnovaConnector" (id);

CREATE TABLE "FluxnovaConstraint" (
	id INTEGER NOT NULL,
	fluxnova_name TEXT,
	fluxnova_config TEXT,
	element_type TEXT,
	"FluxnovaValidation_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaValidation_id") REFERENCES "FluxnovaValidation" (id)
);
CREATE INDEX "ix_FluxnovaConstraint_id" ON "FluxnovaConstraint" (id);

CREATE TABLE "FluxnovaEntry" (
	id INTEGER NOT NULL,
	fluxnova_key TEXT NOT NULL,
	text_content TEXT,
	element_type TEXT,
	"FluxnovaMap_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaMap_id") REFERENCES "FluxnovaMap" (id)
);
CREATE INDEX "ix_FluxnovaEntry_id" ON "FluxnovaEntry" (id);

CREATE TABLE "FluxnovaExecutionListener" (
	id INTEGER NOT NULL,
	fluxnova_event TEXT,
	fluxnova_class TEXT,
	fluxnova_expression TEXT,
	fluxnova_delegate_expression TEXT,
	element_type TEXT,
	script_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(script_id) REFERENCES "FluxnovaScript" (id)
);
CREATE INDEX "ix_FluxnovaExecutionListener_id" ON "FluxnovaExecutionListener" (id);

CREATE TABLE "FluxnovaFormField" (
	id INTEGER NOT NULL,
	fluxnova_id TEXT,
	fluxnova_label TEXT,
	fluxnova_type TEXT,
	fluxnova_date_pattern TEXT,
	fluxnova_default_value TEXT,
	element_type TEXT,
	"FluxnovaFormData_id" INTEGER,
	properties_id INTEGER,
	validation_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaFormData_id") REFERENCES "FluxnovaFormData" (id),
	FOREIGN KEY(properties_id) REFERENCES "FluxnovaProperties" (id),
	FOREIGN KEY(validation_id) REFERENCES "FluxnovaValidation" (id)
);
CREATE INDEX "ix_FluxnovaFormField_id" ON "FluxnovaFormField" (id);

CREATE TABLE "FluxnovaInputParameter" (
	id INTEGER NOT NULL,
	fluxnova_name TEXT NOT NULL,
	fluxnova_restricted BOOLEAN,
	fluxnova_is_transient BOOLEAN,
	text_content TEXT,
	element_type TEXT,
	"FluxnovaInputOutput_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaInputOutput_id") REFERENCES "FluxnovaInputOutput" (id)
);
CREATE INDEX "ix_FluxnovaInputParameter_id" ON "FluxnovaInputParameter" (id);

CREATE TABLE "FluxnovaOutputParameter" (
	id INTEGER NOT NULL,
	fluxnova_name TEXT NOT NULL,
	fluxnova_restricted BOOLEAN,
	fluxnova_is_transient BOOLEAN,
	text_content TEXT,
	element_type TEXT,
	"FluxnovaInputOutput_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaInputOutput_id") REFERENCES "FluxnovaInputOutput" (id)
);
CREATE INDEX "ix_FluxnovaOutputParameter_id" ON "FluxnovaOutputParameter" (id);

CREATE TABLE "FluxnovaProperty" (
	id INTEGER NOT NULL,
	fluxnova_id TEXT,
	fluxnova_name TEXT,
	fluxnova_value TEXT,
	element_type TEXT,
	"FluxnovaProperties_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaProperties_id") REFERENCES "FluxnovaProperties" (id)
);
CREATE INDEX "ix_FluxnovaProperty_id" ON "FluxnovaProperty" (id);

CREATE TABLE "FluxnovaByteArray" (
	id TEXT NOT NULL,
	name TEXT,
	deployment_id TEXT,
	bytes TEXT,
	is_generated BOOLEAN,
	tenant_id TEXT,
	type INTEGER,
	create_time DATETIME,
	root_process_instance_id TEXT,
	removal_time DATETIME,
	PRIMARY KEY (id),
	FOREIGN KEY(deployment_id) REFERENCES "FluxnovaDeployment" (id)
);
CREATE INDEX "ix_FluxnovaByteArray_id" ON "FluxnovaByteArray" (id);

CREATE TABLE "FluxnovaCaseSentryPart" (
	id TEXT NOT NULL,
	case_instance_id TEXT,
	case_execution_id TEXT,
	sentry_id TEXT,
	type TEXT,
	source_case_execution_id TEXT,
	standard_event TEXT,
	source TEXT,
	variable_event TEXT,
	variable_name TEXT,
	is_satisfied BOOLEAN,
	tenant_id TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY(case_instance_id) REFERENCES "FluxnovaCaseExecution" (id),
	FOREIGN KEY(case_execution_id) REFERENCES "FluxnovaCaseExecution" (id)
);
CREATE INDEX "ix_FluxnovaCaseSentryPart_id" ON "FluxnovaCaseSentryPart" (id);

CREATE TABLE "FluxnovaExecution" (
	id TEXT NOT NULL,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	business_key TEXT,
	parent_id TEXT,
	process_definition_id TEXT,
	super_execution_id TEXT,
	super_case_execution_id TEXT,
	case_instance_id TEXT,
	activity_instance_id TEXT,
	activity_id TEXT,
	is_active BOOLEAN,
	is_concurrent BOOLEAN,
	is_scope BOOLEAN,
	is_event_scope BOOLEAN,
	suspension_state INTEGER,
	cached_entity_state INTEGER,
	sequence_counter INTEGER,
	tenant_id TEXT,
	process_definition_key TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(process_instance_id) REFERENCES "FluxnovaExecution" (id),
	FOREIGN KEY(parent_id) REFERENCES "FluxnovaExecution" (id),
	FOREIGN KEY(process_definition_id) REFERENCES "FluxnovaProcessDefinition" (id),
	FOREIGN KEY(super_execution_id) REFERENCES "FluxnovaExecution" (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_FluxnovaExecution_id" ON "FluxnovaExecution" (id);

CREATE TABLE "FluxnovaMembership" (
	id INTEGER NOT NULL,
	user_id TEXT NOT NULL,
	group_id TEXT NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (user_id, group_id),
	FOREIGN KEY(user_id) REFERENCES "FluxnovaUser" (id),
	FOREIGN KEY(group_id) REFERENCES "FluxnovaGroup" (id)
);
CREATE INDEX "FluxnovaMembership_user_id_group_id_idx" ON "FluxnovaMembership" (user_id, group_id);
CREATE INDEX "ix_FluxnovaMembership_id" ON "FluxnovaMembership" (id);

CREATE TABLE "FluxnovaTenantMembership" (
	id TEXT NOT NULL,
	tenant_id TEXT NOT NULL,
	user_id TEXT,
	group_id TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY(tenant_id) REFERENCES "FluxnovaTenant" (id),
	FOREIGN KEY(user_id) REFERENCES "FluxnovaUser" (id),
	FOREIGN KEY(group_id) REFERENCES "FluxnovaGroup" (id)
);
CREATE INDEX "ix_FluxnovaTenantMembership_id" ON "FluxnovaTenantMembership" (id);

CREATE TABLE "DiDiagramElement" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"DiPlane_id" INTEGER,
	"BpmnPlane_id" INTEGER,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("DiPlane_id") REFERENCES "DiPlane" (id),
	FOREIGN KEY("BpmnPlane_id") REFERENCES "BpmnPlane" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiDiagramElement_id" ON "DiDiagramElement" (id);

CREATE TABLE "BpmnDiagram" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_documentation TEXT,
	resolution FLOAT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnDefinitions_id" INTEGER,
	bpmn_plane_id INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDefinitions_id") REFERENCES "BpmnDefinitions" (id),
	FOREIGN KEY(bpmn_plane_id) REFERENCES "BpmnPlane" (id)
);
CREATE INDEX "ix_BpmnDiagram_id" ON "BpmnDiagram" (id);

CREATE TABLE "BpmnEdge" (
	id INTEGER NOT NULL,
	bpmn_element TEXT,
	source_element TEXT,
	target_element TEXT,
	message_visible_kind VARCHAR(14),
	bpmn_id TEXT,
	element_type TEXT,
	bpmn_label_id INTEGER,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bpmn_label_id) REFERENCES "BpmnLabel" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_BpmnEdge_id" ON "BpmnEdge" (id);

CREATE TABLE "BpmnShape" (
	id INTEGER NOT NULL,
	bpmn_element TEXT,
	is_horizontal BOOLEAN,
	is_expanded BOOLEAN,
	is_marker_visible BOOLEAN,
	is_message_visible BOOLEAN,
	participant_band_kind VARCHAR(21),
	choreography_activity_shape TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	bpmn_label_id INTEGER,
	bounds_id INTEGER NOT NULL,
	extension_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bpmn_label_id) REFERENCES "BpmnLabel" (id),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_BpmnShape_id" ON "BpmnShape" (id);

CREATE TABLE "BpmnActivity" (
	id INTEGER NOT NULL,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnActivity_id" ON "BpmnActivity" (id);

CREATE TABLE "BpmnAdHocSubProcess" (
	id INTEGER NOT NULL,
	ordering TEXT,
	cancel_remaining_instances BOOLEAN,
	triggered_by_event BOOLEAN,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	completion_condition_id INTEGER,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(completion_condition_id) REFERENCES "BpmnCompletionCondition" (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnAdHocSubProcess_id" ON "BpmnAdHocSubProcess" (id);

CREATE TABLE "BpmnBusinessRuleTask" (
	id INTEGER NOT NULL,
	implementation TEXT,
	fluxnova_class TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_expression TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_topic TEXT,
	fluxnova_type TEXT,
	fluxnova_decision_ref TEXT,
	fluxnova_decision_ref_binding TEXT,
	fluxnova_decision_ref_version TEXT,
	fluxnova_decision_ref_version_tag TEXT,
	fluxnova_decision_ref_tenant_id TEXT,
	fluxnova_map_decision_result TEXT,
	fluxnova_task_priority TEXT,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnBusinessRuleTask_id" ON "BpmnBusinessRuleTask" (id);

CREATE TABLE "BpmnCallActivity" (
	id INTEGER NOT NULL,
	called_element TEXT,
	fluxnova_async BOOLEAN,
	fluxnova_called_element_binding TEXT,
	fluxnova_called_element_version TEXT,
	fluxnova_called_element_version_tag TEXT,
	fluxnova_case_ref TEXT,
	fluxnova_case_binding TEXT,
	fluxnova_case_version TEXT,
	fluxnova_called_element_tenant_id TEXT,
	fluxnova_case_tenant_id TEXT,
	fluxnova_variable_mapping_class TEXT,
	fluxnova_variable_mapping_delegate_expression TEXT,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCallActivity_id" ON "BpmnCallActivity" (id);

CREATE TABLE "BpmnCallableElement" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCallableElement_id" ON "BpmnCallableElement" (id);

CREATE TABLE "BpmnCategoryValue" (
	id INTEGER NOT NULL,
	value TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCategory_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCategory_id") REFERENCES "BpmnCategory" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCategoryValue_id" ON "BpmnCategoryValue" (id);

CREATE TABLE "BpmnComplexGateway" (
	id INTEGER NOT NULL,
	"default" TEXT,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	activation_condition_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(activation_condition_id) REFERENCES "BpmnActivationCondition" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnComplexGateway_id" ON "BpmnComplexGateway" (id);

CREATE TABLE "BpmnConditionalEventDefinition" (
	id INTEGER NOT NULL,
	fluxnova_variable_name TEXT,
	fluxnova_variable_events TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	condition_id INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(condition_id) REFERENCES "BpmnCondition" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConditionalEventDefinition_id" ON "BpmnConditionalEventDefinition" (id);

CREATE TABLE "BpmnConversationAssociation" (
	id INTEGER NOT NULL,
	inner_conversation_node_ref TEXT NOT NULL,
	outer_conversation_node_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCollaboration_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConversationAssociation_id" ON "BpmnConversationAssociation" (id);

CREATE TABLE "BpmnConversationLink" (
	id INTEGER NOT NULL,
	name TEXT,
	source_ref TEXT NOT NULL,
	target_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCollaboration_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConversationLink_id" ON "BpmnConversationLink" (id);

CREATE TABLE "BpmnConversationNode" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCollaboration_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	"BpmnSubConversation_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY("BpmnSubConversation_id") REFERENCES "BpmnSubConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConversationNode_id" ON "BpmnConversationNode" (id);

CREATE TABLE "BpmnCorrelationPropertyRetrievalExpression" (
	id INTEGER NOT NULL,
	message_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCorrelationProperty_id" INTEGER,
	message_path_id INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCorrelationProperty_id") REFERENCES "BpmnCorrelationProperty" (id),
	FOREIGN KEY(message_path_id) REFERENCES "BpmnMessagePath" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationPropertyRetrievalExpression_id" ON "BpmnCorrelationPropertyRetrievalExpression" (id);

CREATE TABLE "BpmnDataAssociation" (
	id INTEGER NOT NULL,
	target_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	transformation_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(transformation_id) REFERENCES "BpmnTransformation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataAssociation_id" ON "BpmnDataAssociation" (id);

CREATE TABLE "BpmnDataObject" (
	id INTEGER NOT NULL,
	item_subject_ref TEXT,
	is_collection BOOLEAN,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	data_state_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataObject_id" ON "BpmnDataObject" (id);

CREATE TABLE "BpmnDataObjectReference" (
	id INTEGER NOT NULL,
	item_subject_ref TEXT,
	data_object_ref TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	data_state_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataObjectReference_id" ON "BpmnDataObjectReference" (id);

CREATE TABLE "BpmnDataStore" (
	id INTEGER NOT NULL,
	name TEXT,
	capacity INTEGER,
	is_unlimited BOOLEAN,
	item_subject_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	data_state_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataStore_id" ON "BpmnDataStore" (id);

CREATE TABLE "BpmnDataStoreReference" (
	id INTEGER NOT NULL,
	item_subject_ref TEXT,
	data_store_ref TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	data_state_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataStoreReference_id" ON "BpmnDataStoreReference" (id);

CREATE TABLE "BpmnEvent" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEvent_id" ON "BpmnEvent" (id);

CREATE TABLE "BpmnEventBasedGateway" (
	id INTEGER NOT NULL,
	instantiate BOOLEAN,
	event_gateway_type VARCHAR(9),
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEventBasedGateway_id" ON "BpmnEventBasedGateway" (id);

CREATE TABLE "BpmnExclusiveGateway" (
	id INTEGER NOT NULL,
	"default" TEXT,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnExclusiveGateway_id" ON "BpmnExclusiveGateway" (id);

CREATE TABLE "BpmnFlowNode" (
	id INTEGER NOT NULL,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnFlowNode_id" ON "BpmnFlowNode" (id);

CREATE TABLE "BpmnGateway" (
	id INTEGER NOT NULL,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnGateway_id" ON "BpmnGateway" (id);

CREATE TABLE "BpmnInclusiveGateway" (
	id INTEGER NOT NULL,
	"default" TEXT,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnInclusiveGateway_id" ON "BpmnInclusiveGateway" (id);

CREATE TABLE "BpmnInputDataItem" (
	id INTEGER NOT NULL,
	name TEXT,
	is_collection BOOLEAN,
	item_subject_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	data_state_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnInputDataItem_id" ON "BpmnInputDataItem" (id);

CREATE TABLE "BpmnInputSet" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnIoSpecification_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnIoSpecification_id") REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnInputSet_id" ON "BpmnInputSet" (id);

CREATE TABLE "BpmnItemAwareElement" (
	id INTEGER NOT NULL,
	item_subject_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	data_state_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnItemAwareElement_id" ON "BpmnItemAwareElement" (id);

CREATE TABLE "BpmnManualTask" (
	id INTEGER NOT NULL,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnManualTask_id" ON "BpmnManualTask" (id);

CREATE TABLE "BpmnMessageFlow" (
	id INTEGER NOT NULL,
	name TEXT,
	source_ref TEXT NOT NULL,
	target_ref TEXT NOT NULL,
	message_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCollaboration_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessageFlow_id" ON "BpmnMessageFlow" (id);

CREATE TABLE "BpmnMessageFlowAssociation" (
	id INTEGER NOT NULL,
	inner_message_flow_ref TEXT NOT NULL,
	outer_message_flow_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCollaboration_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessageFlowAssociation_id" ON "BpmnMessageFlowAssociation" (id);

CREATE TABLE "BpmnOperation" (
	id INTEGER NOT NULL,
	name TEXT NOT NULL,
	implementation_ref TEXT,
	in_message_ref TEXT NOT NULL,
	out_message_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnInterface_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnInterface_id") REFERENCES "BpmnInterface" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnOperation_id" ON "BpmnOperation" (id);

CREATE TABLE "BpmnOutputDataItem" (
	id INTEGER NOT NULL,
	name TEXT,
	is_collection BOOLEAN,
	item_subject_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	data_state_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnOutputDataItem_id" ON "BpmnOutputDataItem" (id);

CREATE TABLE "BpmnOutputSet" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnIoSpecification_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnIoSpecification_id") REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnOutputSet_id" ON "BpmnOutputSet" (id);

CREATE TABLE "BpmnParallelGateway" (
	id INTEGER NOT NULL,
	fluxnova_async BOOLEAN,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnParallelGateway_id" ON "BpmnParallelGateway" (id);

CREATE TABLE "BpmnParticipant" (
	id INTEGER NOT NULL,
	name TEXT,
	process_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCollaboration_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	participant_multiplicity_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY(participant_multiplicity_id) REFERENCES "BpmnParticipantMultiplicity" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnParticipant_id" ON "BpmnParticipant" (id);

CREATE TABLE "BpmnParticipantAssociation" (
	id INTEGER NOT NULL,
	inner_participant_ref TEXT NOT NULL,
	outer_participant_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCallConversation_id" INTEGER,
	"BpmnCollaboration_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCallConversation_id") REFERENCES "BpmnCallConversation" (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnParticipantAssociation_id" ON "BpmnParticipantAssociation" (id);

CREATE TABLE "BpmnProcess" (
	id INTEGER NOT NULL,
	process_type VARCHAR(7),
	is_closed BOOLEAN,
	is_executable BOOLEAN,
	fluxnova_candidate_starter_groups TEXT,
	fluxnova_candidate_starter_users TEXT,
	fluxnova_job_priority TEXT,
	fluxnova_task_priority TEXT,
	fluxnova_history_time_to_live TEXT,
	fluxnova_is_startable_in_tasklist BOOLEAN,
	fluxnova_version_tag TEXT,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	io_specification_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnProcess_id" ON "BpmnProcess" (id);

CREATE TABLE "BpmnReceiveTask" (
	id INTEGER NOT NULL,
	implementation TEXT,
	instantiate BOOLEAN,
	message_ref TEXT,
	operation_ref TEXT,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnReceiveTask_id" ON "BpmnReceiveTask" (id);

CREATE TABLE "BpmnResourceAssignmentExpression" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	expression_id INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(expression_id) REFERENCES "BpmnExpression" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResourceAssignmentExpression_id" ON "BpmnResourceAssignmentExpression" (id);

CREATE TABLE "BpmnResourceParameter" (
	id INTEGER NOT NULL,
	name TEXT,
	type TEXT,
	is_required BOOLEAN,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnResource_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnResource_id") REFERENCES "BpmnResource" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResourceParameter_id" ON "BpmnResourceParameter" (id);

CREATE TABLE "BpmnScriptTask" (
	id INTEGER NOT NULL,
	script_format TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_resource TEXT,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	script_id INTEGER,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(script_id) REFERENCES "BpmnScript" (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnScriptTask_id" ON "BpmnScriptTask" (id);

CREATE TABLE "BpmnSendTask" (
	id INTEGER NOT NULL,
	implementation TEXT,
	message_ref TEXT,
	operation_ref TEXT,
	fluxnova_class TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_expression TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_topic TEXT,
	fluxnova_type TEXT,
	fluxnova_task_priority TEXT,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSendTask_id" ON "BpmnSendTask" (id);

CREATE TABLE "BpmnSequenceFlow" (
	id INTEGER NOT NULL,
	source_ref TEXT NOT NULL,
	target_ref TEXT NOT NULL,
	is_immediate BOOLEAN,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	condition_expression_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(condition_expression_id) REFERENCES "BpmnConditionExpression" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSequenceFlow_id" ON "BpmnSequenceFlow" (id);

CREATE TABLE "BpmnServiceTask" (
	id INTEGER NOT NULL,
	implementation TEXT,
	operation_ref TEXT,
	fluxnova_class TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_expression TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_topic TEXT,
	fluxnova_type TEXT,
	fluxnova_task_priority TEXT,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnServiceTask_id" ON "BpmnServiceTask" (id);

CREATE TABLE "BpmnSource" (
	id INTEGER NOT NULL,
	element_type TEXT,
	"BpmnRelationship_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnRelationship_id") REFERENCES "BpmnRelationship" (id)
);
CREATE INDEX "ix_BpmnSource_id" ON "BpmnSource" (id);

CREATE TABLE "BpmnSubProcess" (
	id INTEGER NOT NULL,
	triggered_by_event BOOLEAN,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSubProcess_id" ON "BpmnSubProcess" (id);

CREATE TABLE "BpmnTarget" (
	id INTEGER NOT NULL,
	element_type TEXT,
	"BpmnRelationship_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnRelationship_id") REFERENCES "BpmnRelationship" (id)
);
CREATE INDEX "ix_BpmnTarget_id" ON "BpmnTarget" (id);

CREATE TABLE "BpmnTask" (
	id INTEGER NOT NULL,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTask_id" ON "BpmnTask" (id);

CREATE TABLE "BpmnTimerEventDefinition" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	time_date_id INTEGER,
	time_duration_id INTEGER,
	time_cycle_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(time_date_id) REFERENCES "BpmnTimeDate" (id),
	FOREIGN KEY(time_duration_id) REFERENCES "BpmnTimeDuration" (id),
	FOREIGN KEY(time_cycle_id) REFERENCES "BpmnTimeCycle" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTimerEventDefinition_id" ON "BpmnTimerEventDefinition" (id);

CREATE TABLE "BpmnTransaction" (
	id INTEGER NOT NULL,
	method VARCHAR(12),
	triggered_by_event BOOLEAN,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTransaction_id" ON "BpmnTransaction" (id);

CREATE TABLE "BpmnUserTask" (
	id INTEGER NOT NULL,
	implementation TEXT,
	fluxnova_assignee TEXT,
	fluxnova_candidate_groups TEXT,
	fluxnova_candidate_users TEXT,
	fluxnova_due_date TEXT,
	fluxnova_follow_up_date TEXT,
	fluxnova_form_handler_class TEXT,
	fluxnova_form_key TEXT,
	fluxnova_form_ref TEXT,
	fluxnova_form_ref_binding TEXT,
	fluxnova_form_ref_version TEXT,
	fluxnova_priority TEXT,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_id INTEGER,
	loop_characteristics_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification_id) REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY(loop_characteristics_id) REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnUserTask_id" ON "BpmnUserTask" (id);

CREATE TABLE "FluxnovaValue" (
	id INTEGER NOT NULL,
	fluxnova_id TEXT,
	fluxnova_name TEXT,
	text_content TEXT,
	element_type TEXT,
	"FluxnovaFormField_id" INTEGER,
	"FluxnovaFormProperty_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaFormField_id") REFERENCES "FluxnovaFormField" (id),
	FOREIGN KEY("FluxnovaFormProperty_id") REFERENCES "FluxnovaFormProperty" (id)
);
CREATE INDEX "ix_FluxnovaValue_id" ON "FluxnovaValue" (id);

CREATE TABLE "BpmnCallConversation_participant_refs" (
	"BpmnCallConversation_id" INTEGER,
	participant_refs TEXT,
	PRIMARY KEY ("BpmnCallConversation_id", participant_refs),
	FOREIGN KEY("BpmnCallConversation_id") REFERENCES "BpmnCallConversation" (id)
);
CREATE INDEX "ix_BpmnCallConversation_participant_refs_participant_refs" ON "BpmnCallConversation_participant_refs" (participant_refs);
CREATE INDEX "ix_BpmnCallConversation_participant_refs_BpmnCallConversation_id" ON "BpmnCallConversation_participant_refs" ("BpmnCallConversation_id");

CREATE TABLE "BpmnCallConversation_message_flow_refs" (
	"BpmnCallConversation_id" INTEGER,
	message_flow_refs TEXT,
	PRIMARY KEY ("BpmnCallConversation_id", message_flow_refs),
	FOREIGN KEY("BpmnCallConversation_id") REFERENCES "BpmnCallConversation" (id)
);
CREATE INDEX "ix_BpmnCallConversation_message_flow_refs_BpmnCallConversation_id" ON "BpmnCallConversation_message_flow_refs" ("BpmnCallConversation_id");
CREATE INDEX "ix_BpmnCallConversation_message_flow_refs_message_flow_refs" ON "BpmnCallConversation_message_flow_refs" (message_flow_refs);

CREATE TABLE "BpmnConversation_participant_refs" (
	"BpmnConversation_id" INTEGER,
	participant_refs TEXT,
	PRIMARY KEY ("BpmnConversation_id", participant_refs),
	FOREIGN KEY("BpmnConversation_id") REFERENCES "BpmnConversation" (id)
);
CREATE INDEX "ix_BpmnConversation_participant_refs_BpmnConversation_id" ON "BpmnConversation_participant_refs" ("BpmnConversation_id");
CREATE INDEX "ix_BpmnConversation_participant_refs_participant_refs" ON "BpmnConversation_participant_refs" (participant_refs);

CREATE TABLE "BpmnConversation_message_flow_refs" (
	"BpmnConversation_id" INTEGER,
	message_flow_refs TEXT,
	PRIMARY KEY ("BpmnConversation_id", message_flow_refs),
	FOREIGN KEY("BpmnConversation_id") REFERENCES "BpmnConversation" (id)
);
CREATE INDEX "ix_BpmnConversation_message_flow_refs_BpmnConversation_id" ON "BpmnConversation_message_flow_refs" ("BpmnConversation_id");
CREATE INDEX "ix_BpmnConversation_message_flow_refs_message_flow_refs" ON "BpmnConversation_message_flow_refs" (message_flow_refs);

CREATE TABLE "BpmnLinkEventDefinition_bpmn_sources" (
	"BpmnLinkEventDefinition_id" INTEGER,
	bpmn_sources TEXT,
	PRIMARY KEY ("BpmnLinkEventDefinition_id", bpmn_sources),
	FOREIGN KEY("BpmnLinkEventDefinition_id") REFERENCES "BpmnLinkEventDefinition" (id)
);
CREATE INDEX "ix_BpmnLinkEventDefinition_bpmn_sources_BpmnLinkEventDefinition_id" ON "BpmnLinkEventDefinition_bpmn_sources" ("BpmnLinkEventDefinition_id");
CREATE INDEX "ix_BpmnLinkEventDefinition_bpmn_sources_bpmn_sources" ON "BpmnLinkEventDefinition_bpmn_sources" (bpmn_sources);

CREATE TABLE "BpmnSubConversation_participant_refs" (
	"BpmnSubConversation_id" INTEGER,
	participant_refs TEXT,
	PRIMARY KEY ("BpmnSubConversation_id", participant_refs),
	FOREIGN KEY("BpmnSubConversation_id") REFERENCES "BpmnSubConversation" (id)
);
CREATE INDEX "ix_BpmnSubConversation_participant_refs_BpmnSubConversation_id" ON "BpmnSubConversation_participant_refs" ("BpmnSubConversation_id");
CREATE INDEX "ix_BpmnSubConversation_participant_refs_participant_refs" ON "BpmnSubConversation_participant_refs" (participant_refs);

CREATE TABLE "BpmnSubConversation_message_flow_refs" (
	"BpmnSubConversation_id" INTEGER,
	message_flow_refs TEXT,
	PRIMARY KEY ("BpmnSubConversation_id", message_flow_refs),
	FOREIGN KEY("BpmnSubConversation_id") REFERENCES "BpmnSubConversation" (id)
);
CREATE INDEX "ix_BpmnSubConversation_message_flow_refs_BpmnSubConversation_id" ON "BpmnSubConversation_message_flow_refs" ("BpmnSubConversation_id");
CREATE INDEX "ix_BpmnSubConversation_message_flow_refs_message_flow_refs" ON "BpmnSubConversation_message_flow_refs" (message_flow_refs);

CREATE TABLE "FluxnovaEventSubscription" (
	id TEXT NOT NULL,
	event_type TEXT NOT NULL,
	event_name TEXT,
	execution_id TEXT,
	process_instance_id TEXT,
	activity_id TEXT,
	configuration TEXT,
	created DATETIME NOT NULL,
	tenant_id TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY(execution_id) REFERENCES "FluxnovaExecution" (id)
);
CREATE INDEX "ix_FluxnovaEventSubscription_id" ON "FluxnovaEventSubscription" (id);

CREATE TABLE "FluxnovaExternalTask" (
	id TEXT NOT NULL,
	worker_id TEXT,
	topic_name TEXT,
	retries INTEGER,
	error_message TEXT,
	error_details_id TEXT,
	lock_expiration_time DATETIME,
	create_time DATETIME,
	suspension_state INTEGER,
	execution_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	activity_id TEXT,
	activity_instance_id TEXT,
	tenant_id TEXT,
	priority INTEGER NOT NULL,
	last_failure_log_id TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY(error_details_id) REFERENCES "FluxnovaByteArray" (id),
	FOREIGN KEY(execution_id) REFERENCES "FluxnovaExecution" (id)
);
CREATE INDEX "ix_FluxnovaExternalTask_id" ON "FluxnovaExternalTask" (id);

CREATE TABLE "FluxnovaIncident" (
	id TEXT NOT NULL,
	incident_timestamp DATETIME NOT NULL,
	incident_message TEXT,
	incident_type TEXT NOT NULL,
	execution_id TEXT,
	activity_id TEXT,
	failed_activity_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	cause_incident_id TEXT,
	root_cause_incident_id TEXT,
	configuration TEXT,
	tenant_id TEXT,
	job_definition_id TEXT,
	annotation TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY(execution_id) REFERENCES "FluxnovaExecution" (id),
	FOREIGN KEY(process_instance_id) REFERENCES "FluxnovaExecution" (id),
	FOREIGN KEY(process_definition_id) REFERENCES "FluxnovaProcessDefinition" (id),
	FOREIGN KEY(cause_incident_id) REFERENCES "FluxnovaIncident" (id),
	FOREIGN KEY(root_cause_incident_id) REFERENCES "FluxnovaIncident" (id),
	FOREIGN KEY(job_definition_id) REFERENCES "FluxnovaJobDefinition" (id)
);
CREATE INDEX "ix_FluxnovaIncident_id" ON "FluxnovaIncident" (id);

CREATE TABLE "FluxnovaJob" (
	id TEXT NOT NULL,
	type TEXT NOT NULL,
	lock_expiration_time DATETIME,
	lock_owner TEXT,
	is_exclusive BOOLEAN,
	execution_id TEXT,
	root_process_instance_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	retries INTEGER,
	exception_stack_id TEXT,
	exception_message TEXT,
	failed_activity_id TEXT,
	due_date DATETIME,
	repeat TEXT,
	repeat_offset INTEGER,
	handler_type TEXT,
	handler_configuration TEXT,
	deployment_id TEXT,
	suspension_state INTEGER NOT NULL,
	job_definition_id TEXT,
	priority INTEGER NOT NULL,
	sequence_counter INTEGER,
	tenant_id TEXT,
	create_time DATETIME,
	last_failure_log_id TEXT,
	batch_id TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(exception_stack_id) REFERENCES "FluxnovaByteArray" (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_FluxnovaJob_id" ON "FluxnovaJob" (id);

CREATE TABLE "FluxnovaTask" (
	id TEXT NOT NULL,
	execution_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	case_execution_id TEXT,
	case_instance_id TEXT,
	case_definition_id TEXT,
	name TEXT,
	parent_task_id TEXT,
	description TEXT,
	task_definition_key TEXT,
	owner TEXT,
	assignee TEXT,
	delegation_state VARCHAR(8),
	priority INTEGER NOT NULL,
	create_time DATETIME,
	last_updated DATETIME,
	due_date DATETIME,
	follow_up_date DATETIME,
	suspension_state INTEGER,
	tenant_id TEXT,
	task_state TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(execution_id) REFERENCES "FluxnovaExecution" (id),
	FOREIGN KEY(process_instance_id) REFERENCES "FluxnovaExecution" (id),
	FOREIGN KEY(process_definition_id) REFERENCES "FluxnovaProcessDefinition" (id),
	FOREIGN KEY(case_execution_id) REFERENCES "FluxnovaCaseExecution" (id),
	FOREIGN KEY(case_definition_id) REFERENCES "FluxnovaCaseDefinition" (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_FluxnovaTask_id" ON "FluxnovaTask" (id);

CREATE TABLE "FluxnovaVariableInstance" (
	id TEXT NOT NULL,
	type TEXT NOT NULL,
	name TEXT NOT NULL,
	execution_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	case_execution_id TEXT,
	case_instance_id TEXT,
	task_id TEXT,
	batch_id TEXT,
	byte_array_id TEXT,
	double_value FLOAT,
	long_value INTEGER,
	text_value TEXT,
	text2_value TEXT,
	variable_scope_id TEXT NOT NULL,
	sequence_counter INTEGER,
	is_concurrent_local BOOLEAN,
	tenant_id TEXT,
	restricted BOOLEAN,
	PRIMARY KEY (id),
	FOREIGN KEY(execution_id) REFERENCES "FluxnovaExecution" (id),
	FOREIGN KEY(process_instance_id) REFERENCES "FluxnovaExecution" (id),
	FOREIGN KEY(case_execution_id) REFERENCES "FluxnovaCaseExecution" (id),
	FOREIGN KEY(case_instance_id) REFERENCES "FluxnovaCaseExecution" (id),
	FOREIGN KEY(batch_id) REFERENCES "FluxnovaBatch" (id),
	FOREIGN KEY(byte_array_id) REFERENCES "FluxnovaByteArray" (id)
);
CREATE INDEX "ix_FluxnovaVariableInstance_id" ON "FluxnovaVariableInstance" (id);

CREATE TABLE "DiWaypoint" (
	id INTEGER NOT NULL,
	x FLOAT NOT NULL,
	y FLOAT NOT NULL,
	element_type TEXT,
	"DiEdge_id" INTEGER,
	"DiLabeledEdge_id" INTEGER,
	"BpmnEdge_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("DiEdge_id") REFERENCES "DiEdge" (id),
	FOREIGN KEY("DiLabeledEdge_id") REFERENCES "DiLabeledEdge" (id),
	FOREIGN KEY("BpmnEdge_id") REFERENCES "BpmnEdge" (id)
);
CREATE INDEX "ix_DiWaypoint_id" ON "DiWaypoint" (id);

CREATE TABLE "BpmnLabelStyle" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnDiagram_id" INTEGER,
	font_id INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDiagram_id") REFERENCES "BpmnDiagram" (id),
	FOREIGN KEY(font_id) REFERENCES "DcFont" (id)
);
CREATE INDEX "ix_BpmnLabelStyle_id" ON "BpmnLabelStyle" (id);

CREATE TABLE "BpmnArtifact" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnAdHocSubProcess_id" INTEGER,
	"BpmnCollaboration_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	"BpmnProcess_id" INTEGER,
	"BpmnSubProcess_id" INTEGER,
	"BpmnTransaction_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnArtifact_id" ON "BpmnArtifact" (id);

CREATE TABLE "BpmnBoundaryEvent" (
	id INTEGER NOT NULL,
	cancel_activity BOOLEAN,
	attached_to_ref TEXT NOT NULL,
	parallel_multiple BOOLEAN,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	output_set_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(output_set_id) REFERENCES "BpmnOutputSet" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnBoundaryEvent_id" ON "BpmnBoundaryEvent" (id);

CREATE TABLE "BpmnCatchEvent" (
	id INTEGER NOT NULL,
	parallel_multiple BOOLEAN,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	output_set_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(output_set_id) REFERENCES "BpmnOutputSet" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCatchEvent_id" ON "BpmnCatchEvent" (id);

CREATE TABLE "BpmnCorrelationKey" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCallConversation_id" INTEGER,
	"BpmnCollaboration_id" INTEGER,
	"BpmnConversation_id" INTEGER,
	"BpmnConversationNode_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	"BpmnSubConversation_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCallConversation_id") REFERENCES "BpmnCallConversation" (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnConversation_id") REFERENCES "BpmnConversation" (id),
	FOREIGN KEY("BpmnConversationNode_id") REFERENCES "BpmnConversationNode" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY("BpmnSubConversation_id") REFERENCES "BpmnSubConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationKey_id" ON "BpmnCorrelationKey" (id);

CREATE TABLE "BpmnCorrelationSubscription" (
	id INTEGER NOT NULL,
	correlation_key_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnProcess_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationSubscription_id" ON "BpmnCorrelationSubscription" (id);

CREATE TABLE "BpmnEndEvent" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	input_set_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(input_set_id) REFERENCES "BpmnInputSet" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEndEvent_id" ON "BpmnEndEvent" (id);

CREATE TABLE "BpmnFlowElement" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnAdHocSubProcess_id" INTEGER,
	"BpmnProcess_id" INTEGER,
	"BpmnSubProcess_id" INTEGER,
	"BpmnTransaction_id" INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnFlowElement_id" ON "BpmnFlowElement" (id);

CREATE TABLE "BpmnHumanPerformer" (
	id INTEGER NOT NULL,
	name TEXT,
	resource_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	resource_assignment_expression_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource_assignment_expression_id) REFERENCES "BpmnResourceAssignmentExpression" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnHumanPerformer_id" ON "BpmnHumanPerformer" (id);

CREATE TABLE "BpmnIntermediateCatchEvent" (
	id INTEGER NOT NULL,
	parallel_multiple BOOLEAN,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	output_set_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(output_set_id) REFERENCES "BpmnOutputSet" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_id" ON "BpmnIntermediateCatchEvent" (id);

CREATE TABLE "BpmnIntermediateThrowEvent" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	input_set_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(input_set_id) REFERENCES "BpmnInputSet" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_id" ON "BpmnIntermediateThrowEvent" (id);

CREATE TABLE "BpmnIoBinding" (
	id INTEGER NOT NULL,
	operation_ref TEXT NOT NULL,
	input_data_ref TEXT NOT NULL,
	output_data_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCallableElement_id" INTEGER,
	"BpmnProcess_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCallableElement_id") REFERENCES "BpmnCallableElement" (id),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnIoBinding_id" ON "BpmnIoBinding" (id);

CREATE TABLE "BpmnLaneSet" (
	id INTEGER NOT NULL,
	name TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnAdHocSubProcess_id" INTEGER,
	"BpmnProcess_id" INTEGER,
	"BpmnSubProcess_id" INTEGER,
	"BpmnTransaction_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLaneSet_id" ON "BpmnLaneSet" (id);

CREATE TABLE "BpmnMultiInstanceLoopCharacteristics" (
	id INTEGER NOT NULL,
	is_sequential BOOLEAN,
	behavior VARCHAR(7),
	one_behavior_event_ref TEXT,
	none_behavior_event_ref TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_collection TEXT,
	fluxnova_element_variable TEXT,
	loop_data_input_ref TEXT,
	loop_data_output_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	loop_cardinality_id INTEGER,
	output_data_item_id INTEGER,
	input_data_item_id INTEGER,
	completion_condition_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(loop_cardinality_id) REFERENCES "BpmnLoopCardinality" (id),
	FOREIGN KEY(output_data_item_id) REFERENCES "BpmnOutputDataItem" (id),
	FOREIGN KEY(input_data_item_id) REFERENCES "BpmnInputDataItem" (id),
	FOREIGN KEY(completion_condition_id) REFERENCES "BpmnCompletionCondition" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMultiInstanceLoopCharacteristics_id" ON "BpmnMultiInstanceLoopCharacteristics" (id);

CREATE TABLE "BpmnPerformer" (
	id INTEGER NOT NULL,
	name TEXT,
	resource_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	resource_assignment_expression_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource_assignment_expression_id) REFERENCES "BpmnResourceAssignmentExpression" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnPerformer_id" ON "BpmnPerformer" (id);

CREATE TABLE "BpmnPotentialOwner" (
	id INTEGER NOT NULL,
	name TEXT,
	resource_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	resource_assignment_expression_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource_assignment_expression_id) REFERENCES "BpmnResourceAssignmentExpression" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnPotentialOwner_id" ON "BpmnPotentialOwner" (id);

CREATE TABLE "BpmnRendering" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnUserTask_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnUserTask_id") REFERENCES "BpmnUserTask" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnRendering_id" ON "BpmnRendering" (id);

CREATE TABLE "BpmnResourceRole" (
	id INTEGER NOT NULL,
	name TEXT,
	resource_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnActivity_id" INTEGER,
	"BpmnAdHocSubProcess_id" INTEGER,
	"BpmnBusinessRuleTask_id" INTEGER,
	"BpmnCallActivity_id" INTEGER,
	"BpmnManualTask_id" INTEGER,
	"BpmnProcess_id" INTEGER,
	"BpmnReceiveTask_id" INTEGER,
	"BpmnScriptTask_id" INTEGER,
	"BpmnSendTask_id" INTEGER,
	"BpmnServiceTask_id" INTEGER,
	"BpmnSubProcess_id" INTEGER,
	"BpmnTask_id" INTEGER,
	"BpmnTransaction_id" INTEGER,
	"BpmnUserTask_id" INTEGER,
	resource_assignment_expression_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnActivity_id") REFERENCES "BpmnActivity" (id),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id),
	FOREIGN KEY("BpmnBusinessRuleTask_id") REFERENCES "BpmnBusinessRuleTask" (id),
	FOREIGN KEY("BpmnCallActivity_id") REFERENCES "BpmnCallActivity" (id),
	FOREIGN KEY("BpmnManualTask_id") REFERENCES "BpmnManualTask" (id),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id),
	FOREIGN KEY("BpmnReceiveTask_id") REFERENCES "BpmnReceiveTask" (id),
	FOREIGN KEY("BpmnScriptTask_id") REFERENCES "BpmnScriptTask" (id),
	FOREIGN KEY("BpmnSendTask_id") REFERENCES "BpmnSendTask" (id),
	FOREIGN KEY("BpmnServiceTask_id") REFERENCES "BpmnServiceTask" (id),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id),
	FOREIGN KEY("BpmnUserTask_id") REFERENCES "BpmnUserTask" (id),
	FOREIGN KEY(resource_assignment_expression_id) REFERENCES "BpmnResourceAssignmentExpression" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResourceRole_id" ON "BpmnResourceRole" (id);

CREATE TABLE "BpmnStartEvent" (
	id INTEGER NOT NULL,
	is_interrupting BOOLEAN,
	fluxnova_async BOOLEAN,
	fluxnova_form_handler_class TEXT,
	fluxnova_form_key TEXT,
	fluxnova_form_ref TEXT,
	fluxnova_form_ref_binding TEXT,
	fluxnova_form_ref_version TEXT,
	fluxnova_initiator TEXT,
	parallel_multiple BOOLEAN,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	output_set_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(output_set_id) REFERENCES "BpmnOutputSet" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnStartEvent_id" ON "BpmnStartEvent" (id);

CREATE TABLE "BpmnThrowEvent" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	input_set_id INTEGER,
	auditing_id INTEGER,
	monitoring_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(input_set_id) REFERENCES "BpmnInputSet" (id),
	FOREIGN KEY(auditing_id) REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY(monitoring_id) REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnThrowEvent_id" ON "BpmnThrowEvent" (id);

CREATE TABLE "FluxnovaPotentialStarter" (
	id INTEGER NOT NULL,
	element_type TEXT,
	resource_assignment_expression_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource_assignment_expression_id) REFERENCES "BpmnResourceAssignmentExpression" (id)
);
CREATE INDEX "ix_FluxnovaPotentialStarter_id" ON "FluxnovaPotentialStarter" (id);

CREATE TABLE "FluxnovaTaskListener" (
	id INTEGER NOT NULL,
	fluxnova_event TEXT,
	fluxnova_class TEXT,
	fluxnova_expression TEXT,
	fluxnova_delegate_expression TEXT,
	element_type TEXT,
	script_id INTEGER,
	timer_event_definition_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(script_id) REFERENCES "FluxnovaScript" (id),
	FOREIGN KEY(timer_event_definition_id) REFERENCES "BpmnTimerEventDefinition" (id)
);
CREATE INDEX "ix_FluxnovaTaskListener_id" ON "FluxnovaTaskListener" (id);

CREATE TABLE "BpmnActivity_incoming" (
	"BpmnActivity_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnActivity_id", incoming),
	FOREIGN KEY("BpmnActivity_id") REFERENCES "BpmnActivity" (id)
);
CREATE INDEX "ix_BpmnActivity_incoming_incoming" ON "BpmnActivity_incoming" (incoming);
CREATE INDEX "ix_BpmnActivity_incoming_BpmnActivity_id" ON "BpmnActivity_incoming" ("BpmnActivity_id");

CREATE TABLE "BpmnActivity_outgoing" (
	"BpmnActivity_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnActivity_id", outgoing),
	FOREIGN KEY("BpmnActivity_id") REFERENCES "BpmnActivity" (id)
);
CREATE INDEX "ix_BpmnActivity_outgoing_outgoing" ON "BpmnActivity_outgoing" (outgoing);
CREATE INDEX "ix_BpmnActivity_outgoing_BpmnActivity_id" ON "BpmnActivity_outgoing" ("BpmnActivity_id");

CREATE TABLE "BpmnActivity_category_value_refs" (
	"BpmnActivity_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnActivity_id", category_value_refs),
	FOREIGN KEY("BpmnActivity_id") REFERENCES "BpmnActivity" (id)
);
CREATE INDEX "ix_BpmnActivity_category_value_refs_category_value_refs" ON "BpmnActivity_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnActivity_category_value_refs_BpmnActivity_id" ON "BpmnActivity_category_value_refs" ("BpmnActivity_id");

CREATE TABLE "BpmnAdHocSubProcess_incoming" (
	"BpmnAdHocSubProcess_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnAdHocSubProcess_id", incoming),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id)
);
CREATE INDEX "ix_BpmnAdHocSubProcess_incoming_BpmnAdHocSubProcess_id" ON "BpmnAdHocSubProcess_incoming" ("BpmnAdHocSubProcess_id");
CREATE INDEX "ix_BpmnAdHocSubProcess_incoming_incoming" ON "BpmnAdHocSubProcess_incoming" (incoming);

CREATE TABLE "BpmnAdHocSubProcess_outgoing" (
	"BpmnAdHocSubProcess_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnAdHocSubProcess_id", outgoing),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id)
);
CREATE INDEX "ix_BpmnAdHocSubProcess_outgoing_outgoing" ON "BpmnAdHocSubProcess_outgoing" (outgoing);
CREATE INDEX "ix_BpmnAdHocSubProcess_outgoing_BpmnAdHocSubProcess_id" ON "BpmnAdHocSubProcess_outgoing" ("BpmnAdHocSubProcess_id");

CREATE TABLE "BpmnAdHocSubProcess_category_value_refs" (
	"BpmnAdHocSubProcess_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnAdHocSubProcess_id", category_value_refs),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id)
);
CREATE INDEX "ix_BpmnAdHocSubProcess_category_value_refs_BpmnAdHocSubProcess_id" ON "BpmnAdHocSubProcess_category_value_refs" ("BpmnAdHocSubProcess_id");
CREATE INDEX "ix_BpmnAdHocSubProcess_category_value_refs_category_value_refs" ON "BpmnAdHocSubProcess_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnBusinessRuleTask_incoming" (
	"BpmnBusinessRuleTask_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnBusinessRuleTask_id", incoming),
	FOREIGN KEY("BpmnBusinessRuleTask_id") REFERENCES "BpmnBusinessRuleTask" (id)
);
CREATE INDEX "ix_BpmnBusinessRuleTask_incoming_BpmnBusinessRuleTask_id" ON "BpmnBusinessRuleTask_incoming" ("BpmnBusinessRuleTask_id");
CREATE INDEX "ix_BpmnBusinessRuleTask_incoming_incoming" ON "BpmnBusinessRuleTask_incoming" (incoming);

CREATE TABLE "BpmnBusinessRuleTask_outgoing" (
	"BpmnBusinessRuleTask_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnBusinessRuleTask_id", outgoing),
	FOREIGN KEY("BpmnBusinessRuleTask_id") REFERENCES "BpmnBusinessRuleTask" (id)
);
CREATE INDEX "ix_BpmnBusinessRuleTask_outgoing_BpmnBusinessRuleTask_id" ON "BpmnBusinessRuleTask_outgoing" ("BpmnBusinessRuleTask_id");
CREATE INDEX "ix_BpmnBusinessRuleTask_outgoing_outgoing" ON "BpmnBusinessRuleTask_outgoing" (outgoing);

CREATE TABLE "BpmnBusinessRuleTask_category_value_refs" (
	"BpmnBusinessRuleTask_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnBusinessRuleTask_id", category_value_refs),
	FOREIGN KEY("BpmnBusinessRuleTask_id") REFERENCES "BpmnBusinessRuleTask" (id)
);
CREATE INDEX "ix_BpmnBusinessRuleTask_category_value_refs_category_value_refs" ON "BpmnBusinessRuleTask_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnBusinessRuleTask_category_value_refs_BpmnBusinessRuleTask_id" ON "BpmnBusinessRuleTask_category_value_refs" ("BpmnBusinessRuleTask_id");

CREATE TABLE "BpmnCallActivity_incoming" (
	"BpmnCallActivity_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnCallActivity_id", incoming),
	FOREIGN KEY("BpmnCallActivity_id") REFERENCES "BpmnCallActivity" (id)
);
CREATE INDEX "ix_BpmnCallActivity_incoming_BpmnCallActivity_id" ON "BpmnCallActivity_incoming" ("BpmnCallActivity_id");
CREATE INDEX "ix_BpmnCallActivity_incoming_incoming" ON "BpmnCallActivity_incoming" (incoming);

CREATE TABLE "BpmnCallActivity_outgoing" (
	"BpmnCallActivity_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnCallActivity_id", outgoing),
	FOREIGN KEY("BpmnCallActivity_id") REFERENCES "BpmnCallActivity" (id)
);
CREATE INDEX "ix_BpmnCallActivity_outgoing_BpmnCallActivity_id" ON "BpmnCallActivity_outgoing" ("BpmnCallActivity_id");
CREATE INDEX "ix_BpmnCallActivity_outgoing_outgoing" ON "BpmnCallActivity_outgoing" (outgoing);

CREATE TABLE "BpmnCallActivity_category_value_refs" (
	"BpmnCallActivity_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnCallActivity_id", category_value_refs),
	FOREIGN KEY("BpmnCallActivity_id") REFERENCES "BpmnCallActivity" (id)
);
CREATE INDEX "ix_BpmnCallActivity_category_value_refs_BpmnCallActivity_id" ON "BpmnCallActivity_category_value_refs" ("BpmnCallActivity_id");
CREATE INDEX "ix_BpmnCallActivity_category_value_refs_category_value_refs" ON "BpmnCallActivity_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnCallableElement_supported_interface_refs" (
	"BpmnCallableElement_id" INTEGER,
	supported_interface_refs TEXT,
	PRIMARY KEY ("BpmnCallableElement_id", supported_interface_refs),
	FOREIGN KEY("BpmnCallableElement_id") REFERENCES "BpmnCallableElement" (id)
);
CREATE INDEX "ix_BpmnCallableElement_supported_interface_refs_BpmnCallableElement_id" ON "BpmnCallableElement_supported_interface_refs" ("BpmnCallableElement_id");
CREATE INDEX "ix_BpmnCallableElement_supported_interface_refs_supported_interface_refs" ON "BpmnCallableElement_supported_interface_refs" (supported_interface_refs);

CREATE TABLE "BpmnComplexGateway_incoming" (
	"BpmnComplexGateway_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnComplexGateway_id", incoming),
	FOREIGN KEY("BpmnComplexGateway_id") REFERENCES "BpmnComplexGateway" (id)
);
CREATE INDEX "ix_BpmnComplexGateway_incoming_BpmnComplexGateway_id" ON "BpmnComplexGateway_incoming" ("BpmnComplexGateway_id");
CREATE INDEX "ix_BpmnComplexGateway_incoming_incoming" ON "BpmnComplexGateway_incoming" (incoming);

CREATE TABLE "BpmnComplexGateway_outgoing" (
	"BpmnComplexGateway_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnComplexGateway_id", outgoing),
	FOREIGN KEY("BpmnComplexGateway_id") REFERENCES "BpmnComplexGateway" (id)
);
CREATE INDEX "ix_BpmnComplexGateway_outgoing_outgoing" ON "BpmnComplexGateway_outgoing" (outgoing);
CREATE INDEX "ix_BpmnComplexGateway_outgoing_BpmnComplexGateway_id" ON "BpmnComplexGateway_outgoing" ("BpmnComplexGateway_id");

CREATE TABLE "BpmnComplexGateway_category_value_refs" (
	"BpmnComplexGateway_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnComplexGateway_id", category_value_refs),
	FOREIGN KEY("BpmnComplexGateway_id") REFERENCES "BpmnComplexGateway" (id)
);
CREATE INDEX "ix_BpmnComplexGateway_category_value_refs_BpmnComplexGateway_id" ON "BpmnComplexGateway_category_value_refs" ("BpmnComplexGateway_id");
CREATE INDEX "ix_BpmnComplexGateway_category_value_refs_category_value_refs" ON "BpmnComplexGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnConversationNode_participant_refs" (
	"BpmnConversationNode_id" INTEGER,
	participant_refs TEXT,
	PRIMARY KEY ("BpmnConversationNode_id", participant_refs),
	FOREIGN KEY("BpmnConversationNode_id") REFERENCES "BpmnConversationNode" (id)
);
CREATE INDEX "ix_BpmnConversationNode_participant_refs_participant_refs" ON "BpmnConversationNode_participant_refs" (participant_refs);
CREATE INDEX "ix_BpmnConversationNode_participant_refs_BpmnConversationNode_id" ON "BpmnConversationNode_participant_refs" ("BpmnConversationNode_id");

CREATE TABLE "BpmnConversationNode_message_flow_refs" (
	"BpmnConversationNode_id" INTEGER,
	message_flow_refs TEXT,
	PRIMARY KEY ("BpmnConversationNode_id", message_flow_refs),
	FOREIGN KEY("BpmnConversationNode_id") REFERENCES "BpmnConversationNode" (id)
);
CREATE INDEX "ix_BpmnConversationNode_message_flow_refs_BpmnConversationNode_id" ON "BpmnConversationNode_message_flow_refs" ("BpmnConversationNode_id");
CREATE INDEX "ix_BpmnConversationNode_message_flow_refs_message_flow_refs" ON "BpmnConversationNode_message_flow_refs" (message_flow_refs);

CREATE TABLE "BpmnDataAssociation_source_refs" (
	"BpmnDataAssociation_id" INTEGER,
	source_refs TEXT,
	PRIMARY KEY ("BpmnDataAssociation_id", source_refs),
	FOREIGN KEY("BpmnDataAssociation_id") REFERENCES "BpmnDataAssociation" (id)
);
CREATE INDEX "ix_BpmnDataAssociation_source_refs_BpmnDataAssociation_id" ON "BpmnDataAssociation_source_refs" ("BpmnDataAssociation_id");
CREATE INDEX "ix_BpmnDataAssociation_source_refs_source_refs" ON "BpmnDataAssociation_source_refs" (source_refs);

CREATE TABLE "BpmnDataObject_category_value_refs" (
	"BpmnDataObject_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnDataObject_id", category_value_refs),
	FOREIGN KEY("BpmnDataObject_id") REFERENCES "BpmnDataObject" (id)
);
CREATE INDEX "ix_BpmnDataObject_category_value_refs_BpmnDataObject_id" ON "BpmnDataObject_category_value_refs" ("BpmnDataObject_id");
CREATE INDEX "ix_BpmnDataObject_category_value_refs_category_value_refs" ON "BpmnDataObject_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnDataObjectReference_category_value_refs" (
	"BpmnDataObjectReference_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnDataObjectReference_id", category_value_refs),
	FOREIGN KEY("BpmnDataObjectReference_id") REFERENCES "BpmnDataObjectReference" (id)
);
CREATE INDEX "ix_BpmnDataObjectReference_category_value_refs_BpmnDataObjectReference_id" ON "BpmnDataObjectReference_category_value_refs" ("BpmnDataObjectReference_id");
CREATE INDEX "ix_BpmnDataObjectReference_category_value_refs_category_value_refs" ON "BpmnDataObjectReference_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnDataStoreReference_category_value_refs" (
	"BpmnDataStoreReference_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnDataStoreReference_id", category_value_refs),
	FOREIGN KEY("BpmnDataStoreReference_id") REFERENCES "BpmnDataStoreReference" (id)
);
CREATE INDEX "ix_BpmnDataStoreReference_category_value_refs_category_value_refs" ON "BpmnDataStoreReference_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnDataStoreReference_category_value_refs_BpmnDataStoreReference_id" ON "BpmnDataStoreReference_category_value_refs" ("BpmnDataStoreReference_id");

CREATE TABLE "BpmnEvent_incoming" (
	"BpmnEvent_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnEvent_id", incoming),
	FOREIGN KEY("BpmnEvent_id") REFERENCES "BpmnEvent" (id)
);
CREATE INDEX "ix_BpmnEvent_incoming_BpmnEvent_id" ON "BpmnEvent_incoming" ("BpmnEvent_id");
CREATE INDEX "ix_BpmnEvent_incoming_incoming" ON "BpmnEvent_incoming" (incoming);

CREATE TABLE "BpmnEvent_outgoing" (
	"BpmnEvent_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnEvent_id", outgoing),
	FOREIGN KEY("BpmnEvent_id") REFERENCES "BpmnEvent" (id)
);
CREATE INDEX "ix_BpmnEvent_outgoing_BpmnEvent_id" ON "BpmnEvent_outgoing" ("BpmnEvent_id");
CREATE INDEX "ix_BpmnEvent_outgoing_outgoing" ON "BpmnEvent_outgoing" (outgoing);

CREATE TABLE "BpmnEvent_category_value_refs" (
	"BpmnEvent_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnEvent_id", category_value_refs),
	FOREIGN KEY("BpmnEvent_id") REFERENCES "BpmnEvent" (id)
);
CREATE INDEX "ix_BpmnEvent_category_value_refs_BpmnEvent_id" ON "BpmnEvent_category_value_refs" ("BpmnEvent_id");
CREATE INDEX "ix_BpmnEvent_category_value_refs_category_value_refs" ON "BpmnEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnEventBasedGateway_incoming" (
	"BpmnEventBasedGateway_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnEventBasedGateway_id", incoming),
	FOREIGN KEY("BpmnEventBasedGateway_id") REFERENCES "BpmnEventBasedGateway" (id)
);
CREATE INDEX "ix_BpmnEventBasedGateway_incoming_incoming" ON "BpmnEventBasedGateway_incoming" (incoming);
CREATE INDEX "ix_BpmnEventBasedGateway_incoming_BpmnEventBasedGateway_id" ON "BpmnEventBasedGateway_incoming" ("BpmnEventBasedGateway_id");

CREATE TABLE "BpmnEventBasedGateway_outgoing" (
	"BpmnEventBasedGateway_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnEventBasedGateway_id", outgoing),
	FOREIGN KEY("BpmnEventBasedGateway_id") REFERENCES "BpmnEventBasedGateway" (id)
);
CREATE INDEX "ix_BpmnEventBasedGateway_outgoing_BpmnEventBasedGateway_id" ON "BpmnEventBasedGateway_outgoing" ("BpmnEventBasedGateway_id");
CREATE INDEX "ix_BpmnEventBasedGateway_outgoing_outgoing" ON "BpmnEventBasedGateway_outgoing" (outgoing);

CREATE TABLE "BpmnEventBasedGateway_category_value_refs" (
	"BpmnEventBasedGateway_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnEventBasedGateway_id", category_value_refs),
	FOREIGN KEY("BpmnEventBasedGateway_id") REFERENCES "BpmnEventBasedGateway" (id)
);
CREATE INDEX "ix_BpmnEventBasedGateway_category_value_refs_category_value_refs" ON "BpmnEventBasedGateway_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnEventBasedGateway_category_value_refs_BpmnEventBasedGateway_id" ON "BpmnEventBasedGateway_category_value_refs" ("BpmnEventBasedGateway_id");

CREATE TABLE "BpmnExclusiveGateway_incoming" (
	"BpmnExclusiveGateway_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnExclusiveGateway_id", incoming),
	FOREIGN KEY("BpmnExclusiveGateway_id") REFERENCES "BpmnExclusiveGateway" (id)
);
CREATE INDEX "ix_BpmnExclusiveGateway_incoming_BpmnExclusiveGateway_id" ON "BpmnExclusiveGateway_incoming" ("BpmnExclusiveGateway_id");
CREATE INDEX "ix_BpmnExclusiveGateway_incoming_incoming" ON "BpmnExclusiveGateway_incoming" (incoming);

CREATE TABLE "BpmnExclusiveGateway_outgoing" (
	"BpmnExclusiveGateway_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnExclusiveGateway_id", outgoing),
	FOREIGN KEY("BpmnExclusiveGateway_id") REFERENCES "BpmnExclusiveGateway" (id)
);
CREATE INDEX "ix_BpmnExclusiveGateway_outgoing_BpmnExclusiveGateway_id" ON "BpmnExclusiveGateway_outgoing" ("BpmnExclusiveGateway_id");
CREATE INDEX "ix_BpmnExclusiveGateway_outgoing_outgoing" ON "BpmnExclusiveGateway_outgoing" (outgoing);

CREATE TABLE "BpmnExclusiveGateway_category_value_refs" (
	"BpmnExclusiveGateway_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnExclusiveGateway_id", category_value_refs),
	FOREIGN KEY("BpmnExclusiveGateway_id") REFERENCES "BpmnExclusiveGateway" (id)
);
CREATE INDEX "ix_BpmnExclusiveGateway_category_value_refs_BpmnExclusiveGateway_id" ON "BpmnExclusiveGateway_category_value_refs" ("BpmnExclusiveGateway_id");
CREATE INDEX "ix_BpmnExclusiveGateway_category_value_refs_category_value_refs" ON "BpmnExclusiveGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnFlowNode_incoming" (
	"BpmnFlowNode_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnFlowNode_id", incoming),
	FOREIGN KEY("BpmnFlowNode_id") REFERENCES "BpmnFlowNode" (id)
);
CREATE INDEX "ix_BpmnFlowNode_incoming_BpmnFlowNode_id" ON "BpmnFlowNode_incoming" ("BpmnFlowNode_id");
CREATE INDEX "ix_BpmnFlowNode_incoming_incoming" ON "BpmnFlowNode_incoming" (incoming);

CREATE TABLE "BpmnFlowNode_outgoing" (
	"BpmnFlowNode_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnFlowNode_id", outgoing),
	FOREIGN KEY("BpmnFlowNode_id") REFERENCES "BpmnFlowNode" (id)
);
CREATE INDEX "ix_BpmnFlowNode_outgoing_BpmnFlowNode_id" ON "BpmnFlowNode_outgoing" ("BpmnFlowNode_id");
CREATE INDEX "ix_BpmnFlowNode_outgoing_outgoing" ON "BpmnFlowNode_outgoing" (outgoing);

CREATE TABLE "BpmnFlowNode_category_value_refs" (
	"BpmnFlowNode_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnFlowNode_id", category_value_refs),
	FOREIGN KEY("BpmnFlowNode_id") REFERENCES "BpmnFlowNode" (id)
);
CREATE INDEX "ix_BpmnFlowNode_category_value_refs_BpmnFlowNode_id" ON "BpmnFlowNode_category_value_refs" ("BpmnFlowNode_id");
CREATE INDEX "ix_BpmnFlowNode_category_value_refs_category_value_refs" ON "BpmnFlowNode_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnGateway_incoming" (
	"BpmnGateway_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnGateway_id", incoming),
	FOREIGN KEY("BpmnGateway_id") REFERENCES "BpmnGateway" (id)
);
CREATE INDEX "ix_BpmnGateway_incoming_incoming" ON "BpmnGateway_incoming" (incoming);
CREATE INDEX "ix_BpmnGateway_incoming_BpmnGateway_id" ON "BpmnGateway_incoming" ("BpmnGateway_id");

CREATE TABLE "BpmnGateway_outgoing" (
	"BpmnGateway_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnGateway_id", outgoing),
	FOREIGN KEY("BpmnGateway_id") REFERENCES "BpmnGateway" (id)
);
CREATE INDEX "ix_BpmnGateway_outgoing_BpmnGateway_id" ON "BpmnGateway_outgoing" ("BpmnGateway_id");
CREATE INDEX "ix_BpmnGateway_outgoing_outgoing" ON "BpmnGateway_outgoing" (outgoing);

CREATE TABLE "BpmnGateway_category_value_refs" (
	"BpmnGateway_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnGateway_id", category_value_refs),
	FOREIGN KEY("BpmnGateway_id") REFERENCES "BpmnGateway" (id)
);
CREATE INDEX "ix_BpmnGateway_category_value_refs_BpmnGateway_id" ON "BpmnGateway_category_value_refs" ("BpmnGateway_id");
CREATE INDEX "ix_BpmnGateway_category_value_refs_category_value_refs" ON "BpmnGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnInclusiveGateway_incoming" (
	"BpmnInclusiveGateway_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnInclusiveGateway_id", incoming),
	FOREIGN KEY("BpmnInclusiveGateway_id") REFERENCES "BpmnInclusiveGateway" (id)
);
CREATE INDEX "ix_BpmnInclusiveGateway_incoming_BpmnInclusiveGateway_id" ON "BpmnInclusiveGateway_incoming" ("BpmnInclusiveGateway_id");
CREATE INDEX "ix_BpmnInclusiveGateway_incoming_incoming" ON "BpmnInclusiveGateway_incoming" (incoming);

CREATE TABLE "BpmnInclusiveGateway_outgoing" (
	"BpmnInclusiveGateway_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnInclusiveGateway_id", outgoing),
	FOREIGN KEY("BpmnInclusiveGateway_id") REFERENCES "BpmnInclusiveGateway" (id)
);
CREATE INDEX "ix_BpmnInclusiveGateway_outgoing_outgoing" ON "BpmnInclusiveGateway_outgoing" (outgoing);
CREATE INDEX "ix_BpmnInclusiveGateway_outgoing_BpmnInclusiveGateway_id" ON "BpmnInclusiveGateway_outgoing" ("BpmnInclusiveGateway_id");

CREATE TABLE "BpmnInclusiveGateway_category_value_refs" (
	"BpmnInclusiveGateway_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnInclusiveGateway_id", category_value_refs),
	FOREIGN KEY("BpmnInclusiveGateway_id") REFERENCES "BpmnInclusiveGateway" (id)
);
CREATE INDEX "ix_BpmnInclusiveGateway_category_value_refs_BpmnInclusiveGateway_id" ON "BpmnInclusiveGateway_category_value_refs" ("BpmnInclusiveGateway_id");
CREATE INDEX "ix_BpmnInclusiveGateway_category_value_refs_category_value_refs" ON "BpmnInclusiveGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnInputSet_data_input_refs" (
	"BpmnInputSet_id" INTEGER,
	data_input_refs TEXT,
	PRIMARY KEY ("BpmnInputSet_id", data_input_refs),
	FOREIGN KEY("BpmnInputSet_id") REFERENCES "BpmnInputSet" (id)
);
CREATE INDEX "ix_BpmnInputSet_data_input_refs_BpmnInputSet_id" ON "BpmnInputSet_data_input_refs" ("BpmnInputSet_id");
CREATE INDEX "ix_BpmnInputSet_data_input_refs_data_input_refs" ON "BpmnInputSet_data_input_refs" (data_input_refs);

CREATE TABLE "BpmnInputSet_optional_input_refs" (
	"BpmnInputSet_id" INTEGER,
	optional_input_refs TEXT,
	PRIMARY KEY ("BpmnInputSet_id", optional_input_refs),
	FOREIGN KEY("BpmnInputSet_id") REFERENCES "BpmnInputSet" (id)
);
CREATE INDEX "ix_BpmnInputSet_optional_input_refs_BpmnInputSet_id" ON "BpmnInputSet_optional_input_refs" ("BpmnInputSet_id");
CREATE INDEX "ix_BpmnInputSet_optional_input_refs_optional_input_refs" ON "BpmnInputSet_optional_input_refs" (optional_input_refs);

CREATE TABLE "BpmnInputSet_while_executing_input_refs" (
	"BpmnInputSet_id" INTEGER,
	while_executing_input_refs TEXT,
	PRIMARY KEY ("BpmnInputSet_id", while_executing_input_refs),
	FOREIGN KEY("BpmnInputSet_id") REFERENCES "BpmnInputSet" (id)
);
CREATE INDEX "ix_BpmnInputSet_while_executing_input_refs_while_executing_input_refs" ON "BpmnInputSet_while_executing_input_refs" (while_executing_input_refs);
CREATE INDEX "ix_BpmnInputSet_while_executing_input_refs_BpmnInputSet_id" ON "BpmnInputSet_while_executing_input_refs" ("BpmnInputSet_id");

CREATE TABLE "BpmnInputSet_output_set_refs" (
	"BpmnInputSet_id" INTEGER,
	output_set_refs TEXT,
	PRIMARY KEY ("BpmnInputSet_id", output_set_refs),
	FOREIGN KEY("BpmnInputSet_id") REFERENCES "BpmnInputSet" (id)
);
CREATE INDEX "ix_BpmnInputSet_output_set_refs_BpmnInputSet_id" ON "BpmnInputSet_output_set_refs" ("BpmnInputSet_id");
CREATE INDEX "ix_BpmnInputSet_output_set_refs_output_set_refs" ON "BpmnInputSet_output_set_refs" (output_set_refs);

CREATE TABLE "BpmnManualTask_incoming" (
	"BpmnManualTask_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnManualTask_id", incoming),
	FOREIGN KEY("BpmnManualTask_id") REFERENCES "BpmnManualTask" (id)
);
CREATE INDEX "ix_BpmnManualTask_incoming_incoming" ON "BpmnManualTask_incoming" (incoming);
CREATE INDEX "ix_BpmnManualTask_incoming_BpmnManualTask_id" ON "BpmnManualTask_incoming" ("BpmnManualTask_id");

CREATE TABLE "BpmnManualTask_outgoing" (
	"BpmnManualTask_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnManualTask_id", outgoing),
	FOREIGN KEY("BpmnManualTask_id") REFERENCES "BpmnManualTask" (id)
);
CREATE INDEX "ix_BpmnManualTask_outgoing_BpmnManualTask_id" ON "BpmnManualTask_outgoing" ("BpmnManualTask_id");
CREATE INDEX "ix_BpmnManualTask_outgoing_outgoing" ON "BpmnManualTask_outgoing" (outgoing);

CREATE TABLE "BpmnManualTask_category_value_refs" (
	"BpmnManualTask_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnManualTask_id", category_value_refs),
	FOREIGN KEY("BpmnManualTask_id") REFERENCES "BpmnManualTask" (id)
);
CREATE INDEX "ix_BpmnManualTask_category_value_refs_BpmnManualTask_id" ON "BpmnManualTask_category_value_refs" ("BpmnManualTask_id");
CREATE INDEX "ix_BpmnManualTask_category_value_refs_category_value_refs" ON "BpmnManualTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnOperation_error_refs" (
	"BpmnOperation_id" INTEGER,
	error_refs TEXT,
	PRIMARY KEY ("BpmnOperation_id", error_refs),
	FOREIGN KEY("BpmnOperation_id") REFERENCES "BpmnOperation" (id)
);
CREATE INDEX "ix_BpmnOperation_error_refs_BpmnOperation_id" ON "BpmnOperation_error_refs" ("BpmnOperation_id");
CREATE INDEX "ix_BpmnOperation_error_refs_error_refs" ON "BpmnOperation_error_refs" (error_refs);

CREATE TABLE "BpmnOutputSet_data_output_refs" (
	"BpmnOutputSet_id" INTEGER,
	data_output_refs TEXT,
	PRIMARY KEY ("BpmnOutputSet_id", data_output_refs),
	FOREIGN KEY("BpmnOutputSet_id") REFERENCES "BpmnOutputSet" (id)
);
CREATE INDEX "ix_BpmnOutputSet_data_output_refs_data_output_refs" ON "BpmnOutputSet_data_output_refs" (data_output_refs);
CREATE INDEX "ix_BpmnOutputSet_data_output_refs_BpmnOutputSet_id" ON "BpmnOutputSet_data_output_refs" ("BpmnOutputSet_id");

CREATE TABLE "BpmnOutputSet_optional_output_refs" (
	"BpmnOutputSet_id" INTEGER,
	optional_output_refs TEXT,
	PRIMARY KEY ("BpmnOutputSet_id", optional_output_refs),
	FOREIGN KEY("BpmnOutputSet_id") REFERENCES "BpmnOutputSet" (id)
);
CREATE INDEX "ix_BpmnOutputSet_optional_output_refs_BpmnOutputSet_id" ON "BpmnOutputSet_optional_output_refs" ("BpmnOutputSet_id");
CREATE INDEX "ix_BpmnOutputSet_optional_output_refs_optional_output_refs" ON "BpmnOutputSet_optional_output_refs" (optional_output_refs);

CREATE TABLE "BpmnOutputSet_while_executing_output_refs" (
	"BpmnOutputSet_id" INTEGER,
	while_executing_output_refs TEXT,
	PRIMARY KEY ("BpmnOutputSet_id", while_executing_output_refs),
	FOREIGN KEY("BpmnOutputSet_id") REFERENCES "BpmnOutputSet" (id)
);
CREATE INDEX "ix_BpmnOutputSet_while_executing_output_refs_BpmnOutputSet_id" ON "BpmnOutputSet_while_executing_output_refs" ("BpmnOutputSet_id");
CREATE INDEX "ix_BpmnOutputSet_while_executing_output_refs_while_executing_output_refs" ON "BpmnOutputSet_while_executing_output_refs" (while_executing_output_refs);

CREATE TABLE "BpmnOutputSet_input_set_refs" (
	"BpmnOutputSet_id" INTEGER,
	input_set_refs TEXT,
	PRIMARY KEY ("BpmnOutputSet_id", input_set_refs),
	FOREIGN KEY("BpmnOutputSet_id") REFERENCES "BpmnOutputSet" (id)
);
CREATE INDEX "ix_BpmnOutputSet_input_set_refs_BpmnOutputSet_id" ON "BpmnOutputSet_input_set_refs" ("BpmnOutputSet_id");
CREATE INDEX "ix_BpmnOutputSet_input_set_refs_input_set_refs" ON "BpmnOutputSet_input_set_refs" (input_set_refs);

CREATE TABLE "BpmnParallelGateway_incoming" (
	"BpmnParallelGateway_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnParallelGateway_id", incoming),
	FOREIGN KEY("BpmnParallelGateway_id") REFERENCES "BpmnParallelGateway" (id)
);
CREATE INDEX "ix_BpmnParallelGateway_incoming_incoming" ON "BpmnParallelGateway_incoming" (incoming);
CREATE INDEX "ix_BpmnParallelGateway_incoming_BpmnParallelGateway_id" ON "BpmnParallelGateway_incoming" ("BpmnParallelGateway_id");

CREATE TABLE "BpmnParallelGateway_outgoing" (
	"BpmnParallelGateway_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnParallelGateway_id", outgoing),
	FOREIGN KEY("BpmnParallelGateway_id") REFERENCES "BpmnParallelGateway" (id)
);
CREATE INDEX "ix_BpmnParallelGateway_outgoing_BpmnParallelGateway_id" ON "BpmnParallelGateway_outgoing" ("BpmnParallelGateway_id");
CREATE INDEX "ix_BpmnParallelGateway_outgoing_outgoing" ON "BpmnParallelGateway_outgoing" (outgoing);

CREATE TABLE "BpmnParallelGateway_category_value_refs" (
	"BpmnParallelGateway_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnParallelGateway_id", category_value_refs),
	FOREIGN KEY("BpmnParallelGateway_id") REFERENCES "BpmnParallelGateway" (id)
);
CREATE INDEX "ix_BpmnParallelGateway_category_value_refs_BpmnParallelGateway_id" ON "BpmnParallelGateway_category_value_refs" ("BpmnParallelGateway_id");
CREATE INDEX "ix_BpmnParallelGateway_category_value_refs_category_value_refs" ON "BpmnParallelGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnParticipant_interface_refs" (
	"BpmnParticipant_id" INTEGER,
	interface_refs TEXT,
	PRIMARY KEY ("BpmnParticipant_id", interface_refs),
	FOREIGN KEY("BpmnParticipant_id") REFERENCES "BpmnParticipant" (id)
);
CREATE INDEX "ix_BpmnParticipant_interface_refs_BpmnParticipant_id" ON "BpmnParticipant_interface_refs" ("BpmnParticipant_id");
CREATE INDEX "ix_BpmnParticipant_interface_refs_interface_refs" ON "BpmnParticipant_interface_refs" (interface_refs);

CREATE TABLE "BpmnParticipant_end_point_refs" (
	"BpmnParticipant_id" INTEGER,
	end_point_refs TEXT,
	PRIMARY KEY ("BpmnParticipant_id", end_point_refs),
	FOREIGN KEY("BpmnParticipant_id") REFERENCES "BpmnParticipant" (id)
);
CREATE INDEX "ix_BpmnParticipant_end_point_refs_end_point_refs" ON "BpmnParticipant_end_point_refs" (end_point_refs);
CREATE INDEX "ix_BpmnParticipant_end_point_refs_BpmnParticipant_id" ON "BpmnParticipant_end_point_refs" ("BpmnParticipant_id");

CREATE TABLE "BpmnProcess_supports" (
	"BpmnProcess_id" INTEGER,
	supports TEXT,
	PRIMARY KEY ("BpmnProcess_id", supports),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id)
);
CREATE INDEX "ix_BpmnProcess_supports_BpmnProcess_id" ON "BpmnProcess_supports" ("BpmnProcess_id");
CREATE INDEX "ix_BpmnProcess_supports_supports" ON "BpmnProcess_supports" (supports);

CREATE TABLE "BpmnProcess_supported_interface_refs" (
	"BpmnProcess_id" INTEGER,
	supported_interface_refs TEXT,
	PRIMARY KEY ("BpmnProcess_id", supported_interface_refs),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id)
);
CREATE INDEX "ix_BpmnProcess_supported_interface_refs_BpmnProcess_id" ON "BpmnProcess_supported_interface_refs" ("BpmnProcess_id");
CREATE INDEX "ix_BpmnProcess_supported_interface_refs_supported_interface_refs" ON "BpmnProcess_supported_interface_refs" (supported_interface_refs);

CREATE TABLE "BpmnReceiveTask_incoming" (
	"BpmnReceiveTask_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnReceiveTask_id", incoming),
	FOREIGN KEY("BpmnReceiveTask_id") REFERENCES "BpmnReceiveTask" (id)
);
CREATE INDEX "ix_BpmnReceiveTask_incoming_BpmnReceiveTask_id" ON "BpmnReceiveTask_incoming" ("BpmnReceiveTask_id");
CREATE INDEX "ix_BpmnReceiveTask_incoming_incoming" ON "BpmnReceiveTask_incoming" (incoming);

CREATE TABLE "BpmnReceiveTask_outgoing" (
	"BpmnReceiveTask_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnReceiveTask_id", outgoing),
	FOREIGN KEY("BpmnReceiveTask_id") REFERENCES "BpmnReceiveTask" (id)
);
CREATE INDEX "ix_BpmnReceiveTask_outgoing_outgoing" ON "BpmnReceiveTask_outgoing" (outgoing);
CREATE INDEX "ix_BpmnReceiveTask_outgoing_BpmnReceiveTask_id" ON "BpmnReceiveTask_outgoing" ("BpmnReceiveTask_id");

CREATE TABLE "BpmnReceiveTask_category_value_refs" (
	"BpmnReceiveTask_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnReceiveTask_id", category_value_refs),
	FOREIGN KEY("BpmnReceiveTask_id") REFERENCES "BpmnReceiveTask" (id)
);
CREATE INDEX "ix_BpmnReceiveTask_category_value_refs_BpmnReceiveTask_id" ON "BpmnReceiveTask_category_value_refs" ("BpmnReceiveTask_id");
CREATE INDEX "ix_BpmnReceiveTask_category_value_refs_category_value_refs" ON "BpmnReceiveTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnScriptTask_incoming" (
	"BpmnScriptTask_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnScriptTask_id", incoming),
	FOREIGN KEY("BpmnScriptTask_id") REFERENCES "BpmnScriptTask" (id)
);
CREATE INDEX "ix_BpmnScriptTask_incoming_BpmnScriptTask_id" ON "BpmnScriptTask_incoming" ("BpmnScriptTask_id");
CREATE INDEX "ix_BpmnScriptTask_incoming_incoming" ON "BpmnScriptTask_incoming" (incoming);

CREATE TABLE "BpmnScriptTask_outgoing" (
	"BpmnScriptTask_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnScriptTask_id", outgoing),
	FOREIGN KEY("BpmnScriptTask_id") REFERENCES "BpmnScriptTask" (id)
);
CREATE INDEX "ix_BpmnScriptTask_outgoing_BpmnScriptTask_id" ON "BpmnScriptTask_outgoing" ("BpmnScriptTask_id");
CREATE INDEX "ix_BpmnScriptTask_outgoing_outgoing" ON "BpmnScriptTask_outgoing" (outgoing);

CREATE TABLE "BpmnScriptTask_category_value_refs" (
	"BpmnScriptTask_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnScriptTask_id", category_value_refs),
	FOREIGN KEY("BpmnScriptTask_id") REFERENCES "BpmnScriptTask" (id)
);
CREATE INDEX "ix_BpmnScriptTask_category_value_refs_BpmnScriptTask_id" ON "BpmnScriptTask_category_value_refs" ("BpmnScriptTask_id");
CREATE INDEX "ix_BpmnScriptTask_category_value_refs_category_value_refs" ON "BpmnScriptTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnSendTask_incoming" (
	"BpmnSendTask_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnSendTask_id", incoming),
	FOREIGN KEY("BpmnSendTask_id") REFERENCES "BpmnSendTask" (id)
);
CREATE INDEX "ix_BpmnSendTask_incoming_BpmnSendTask_id" ON "BpmnSendTask_incoming" ("BpmnSendTask_id");
CREATE INDEX "ix_BpmnSendTask_incoming_incoming" ON "BpmnSendTask_incoming" (incoming);

CREATE TABLE "BpmnSendTask_outgoing" (
	"BpmnSendTask_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnSendTask_id", outgoing),
	FOREIGN KEY("BpmnSendTask_id") REFERENCES "BpmnSendTask" (id)
);
CREATE INDEX "ix_BpmnSendTask_outgoing_outgoing" ON "BpmnSendTask_outgoing" (outgoing);
CREATE INDEX "ix_BpmnSendTask_outgoing_BpmnSendTask_id" ON "BpmnSendTask_outgoing" ("BpmnSendTask_id");

CREATE TABLE "BpmnSendTask_category_value_refs" (
	"BpmnSendTask_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnSendTask_id", category_value_refs),
	FOREIGN KEY("BpmnSendTask_id") REFERENCES "BpmnSendTask" (id)
);
CREATE INDEX "ix_BpmnSendTask_category_value_refs_BpmnSendTask_id" ON "BpmnSendTask_category_value_refs" ("BpmnSendTask_id");
CREATE INDEX "ix_BpmnSendTask_category_value_refs_category_value_refs" ON "BpmnSendTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnSequenceFlow_category_value_refs" (
	"BpmnSequenceFlow_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnSequenceFlow_id", category_value_refs),
	FOREIGN KEY("BpmnSequenceFlow_id") REFERENCES "BpmnSequenceFlow" (id)
);
CREATE INDEX "ix_BpmnSequenceFlow_category_value_refs_BpmnSequenceFlow_id" ON "BpmnSequenceFlow_category_value_refs" ("BpmnSequenceFlow_id");
CREATE INDEX "ix_BpmnSequenceFlow_category_value_refs_category_value_refs" ON "BpmnSequenceFlow_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnServiceTask_incoming" (
	"BpmnServiceTask_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnServiceTask_id", incoming),
	FOREIGN KEY("BpmnServiceTask_id") REFERENCES "BpmnServiceTask" (id)
);
CREATE INDEX "ix_BpmnServiceTask_incoming_BpmnServiceTask_id" ON "BpmnServiceTask_incoming" ("BpmnServiceTask_id");
CREATE INDEX "ix_BpmnServiceTask_incoming_incoming" ON "BpmnServiceTask_incoming" (incoming);

CREATE TABLE "BpmnServiceTask_outgoing" (
	"BpmnServiceTask_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnServiceTask_id", outgoing),
	FOREIGN KEY("BpmnServiceTask_id") REFERENCES "BpmnServiceTask" (id)
);
CREATE INDEX "ix_BpmnServiceTask_outgoing_outgoing" ON "BpmnServiceTask_outgoing" (outgoing);
CREATE INDEX "ix_BpmnServiceTask_outgoing_BpmnServiceTask_id" ON "BpmnServiceTask_outgoing" ("BpmnServiceTask_id");

CREATE TABLE "BpmnServiceTask_category_value_refs" (
	"BpmnServiceTask_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnServiceTask_id", category_value_refs),
	FOREIGN KEY("BpmnServiceTask_id") REFERENCES "BpmnServiceTask" (id)
);
CREATE INDEX "ix_BpmnServiceTask_category_value_refs_BpmnServiceTask_id" ON "BpmnServiceTask_category_value_refs" ("BpmnServiceTask_id");
CREATE INDEX "ix_BpmnServiceTask_category_value_refs_category_value_refs" ON "BpmnServiceTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnSubProcess_incoming" (
	"BpmnSubProcess_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnSubProcess_id", incoming),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id)
);
CREATE INDEX "ix_BpmnSubProcess_incoming_incoming" ON "BpmnSubProcess_incoming" (incoming);
CREATE INDEX "ix_BpmnSubProcess_incoming_BpmnSubProcess_id" ON "BpmnSubProcess_incoming" ("BpmnSubProcess_id");

CREATE TABLE "BpmnSubProcess_outgoing" (
	"BpmnSubProcess_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnSubProcess_id", outgoing),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id)
);
CREATE INDEX "ix_BpmnSubProcess_outgoing_BpmnSubProcess_id" ON "BpmnSubProcess_outgoing" ("BpmnSubProcess_id");
CREATE INDEX "ix_BpmnSubProcess_outgoing_outgoing" ON "BpmnSubProcess_outgoing" (outgoing);

CREATE TABLE "BpmnSubProcess_category_value_refs" (
	"BpmnSubProcess_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnSubProcess_id", category_value_refs),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id)
);
CREATE INDEX "ix_BpmnSubProcess_category_value_refs_BpmnSubProcess_id" ON "BpmnSubProcess_category_value_refs" ("BpmnSubProcess_id");
CREATE INDEX "ix_BpmnSubProcess_category_value_refs_category_value_refs" ON "BpmnSubProcess_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnTask_incoming" (
	"BpmnTask_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnTask_id", incoming),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id)
);
CREATE INDEX "ix_BpmnTask_incoming_BpmnTask_id" ON "BpmnTask_incoming" ("BpmnTask_id");
CREATE INDEX "ix_BpmnTask_incoming_incoming" ON "BpmnTask_incoming" (incoming);

CREATE TABLE "BpmnTask_outgoing" (
	"BpmnTask_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnTask_id", outgoing),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id)
);
CREATE INDEX "ix_BpmnTask_outgoing_outgoing" ON "BpmnTask_outgoing" (outgoing);
CREATE INDEX "ix_BpmnTask_outgoing_BpmnTask_id" ON "BpmnTask_outgoing" ("BpmnTask_id");

CREATE TABLE "BpmnTask_category_value_refs" (
	"BpmnTask_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnTask_id", category_value_refs),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id)
);
CREATE INDEX "ix_BpmnTask_category_value_refs_BpmnTask_id" ON "BpmnTask_category_value_refs" ("BpmnTask_id");
CREATE INDEX "ix_BpmnTask_category_value_refs_category_value_refs" ON "BpmnTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnTransaction_incoming" (
	"BpmnTransaction_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnTransaction_id", incoming),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id)
);
CREATE INDEX "ix_BpmnTransaction_incoming_BpmnTransaction_id" ON "BpmnTransaction_incoming" ("BpmnTransaction_id");
CREATE INDEX "ix_BpmnTransaction_incoming_incoming" ON "BpmnTransaction_incoming" (incoming);

CREATE TABLE "BpmnTransaction_outgoing" (
	"BpmnTransaction_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnTransaction_id", outgoing),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id)
);
CREATE INDEX "ix_BpmnTransaction_outgoing_BpmnTransaction_id" ON "BpmnTransaction_outgoing" ("BpmnTransaction_id");
CREATE INDEX "ix_BpmnTransaction_outgoing_outgoing" ON "BpmnTransaction_outgoing" (outgoing);

CREATE TABLE "BpmnTransaction_category_value_refs" (
	"BpmnTransaction_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnTransaction_id", category_value_refs),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id)
);
CREATE INDEX "ix_BpmnTransaction_category_value_refs_category_value_refs" ON "BpmnTransaction_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnTransaction_category_value_refs_BpmnTransaction_id" ON "BpmnTransaction_category_value_refs" ("BpmnTransaction_id");

CREATE TABLE "BpmnUserTask_incoming" (
	"BpmnUserTask_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnUserTask_id", incoming),
	FOREIGN KEY("BpmnUserTask_id") REFERENCES "BpmnUserTask" (id)
);
CREATE INDEX "ix_BpmnUserTask_incoming_BpmnUserTask_id" ON "BpmnUserTask_incoming" ("BpmnUserTask_id");
CREATE INDEX "ix_BpmnUserTask_incoming_incoming" ON "BpmnUserTask_incoming" (incoming);

CREATE TABLE "BpmnUserTask_outgoing" (
	"BpmnUserTask_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnUserTask_id", outgoing),
	FOREIGN KEY("BpmnUserTask_id") REFERENCES "BpmnUserTask" (id)
);
CREATE INDEX "ix_BpmnUserTask_outgoing_BpmnUserTask_id" ON "BpmnUserTask_outgoing" ("BpmnUserTask_id");
CREATE INDEX "ix_BpmnUserTask_outgoing_outgoing" ON "BpmnUserTask_outgoing" (outgoing);

CREATE TABLE "BpmnUserTask_category_value_refs" (
	"BpmnUserTask_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnUserTask_id", category_value_refs),
	FOREIGN KEY("BpmnUserTask_id") REFERENCES "BpmnUserTask" (id)
);
CREATE INDEX "ix_BpmnUserTask_category_value_refs_BpmnUserTask_id" ON "BpmnUserTask_category_value_refs" ("BpmnUserTask_id");
CREATE INDEX "ix_BpmnUserTask_category_value_refs_category_value_refs" ON "BpmnUserTask_category_value_refs" (category_value_refs);

CREATE TABLE "FluxnovaIdentityLink" (
	id TEXT NOT NULL,
	group_id TEXT,
	type TEXT,
	user_id TEXT,
	task_id TEXT,
	process_definition_id TEXT,
	tenant_id TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY(task_id) REFERENCES "FluxnovaTask" (id),
	FOREIGN KEY(process_definition_id) REFERENCES "FluxnovaProcessDefinition" (id)
);
CREATE INDEX "ix_FluxnovaIdentityLink_id" ON "FluxnovaIdentityLink" (id);

CREATE TABLE "BpmnComplexBehaviorDefinition" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnMultiInstanceLoopCharacteristics_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnMultiInstanceLoopCharacteristics_id") REFERENCES "BpmnMultiInstanceLoopCharacteristics" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnComplexBehaviorDefinition_id" ON "BpmnComplexBehaviorDefinition" (id);

CREATE TABLE "BpmnCorrelationPropertyBinding" (
	id INTEGER NOT NULL,
	correlation_property_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnCorrelationSubscription_id" INTEGER,
	data_path_id INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnCorrelationSubscription_id") REFERENCES "BpmnCorrelationSubscription" (id),
	FOREIGN KEY(data_path_id) REFERENCES "BpmnDataPath" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationPropertyBinding_id" ON "BpmnCorrelationPropertyBinding" (id);

CREATE TABLE "BpmnDataInput" (
	id INTEGER NOT NULL,
	name TEXT,
	is_collection BOOLEAN,
	item_subject_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnEndEvent_id" INTEGER,
	"BpmnIntermediateThrowEvent_id" INTEGER,
	"BpmnIoSpecification_id" INTEGER,
	"BpmnThrowEvent_id" INTEGER,
	data_state_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnEndEvent_id") REFERENCES "BpmnEndEvent" (id),
	FOREIGN KEY("BpmnIntermediateThrowEvent_id") REFERENCES "BpmnIntermediateThrowEvent" (id),
	FOREIGN KEY("BpmnIoSpecification_id") REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY("BpmnThrowEvent_id") REFERENCES "BpmnThrowEvent" (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataInput_id" ON "BpmnDataInput" (id);

CREATE TABLE "BpmnDataInputAssociation" (
	id INTEGER NOT NULL,
	target_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnActivity_id" INTEGER,
	"BpmnAdHocSubProcess_id" INTEGER,
	"BpmnBusinessRuleTask_id" INTEGER,
	"BpmnCallActivity_id" INTEGER,
	"BpmnEndEvent_id" INTEGER,
	"BpmnIntermediateThrowEvent_id" INTEGER,
	"BpmnManualTask_id" INTEGER,
	"BpmnReceiveTask_id" INTEGER,
	"BpmnScriptTask_id" INTEGER,
	"BpmnSendTask_id" INTEGER,
	"BpmnServiceTask_id" INTEGER,
	"BpmnSubProcess_id" INTEGER,
	"BpmnTask_id" INTEGER,
	"BpmnThrowEvent_id" INTEGER,
	"BpmnTransaction_id" INTEGER,
	"BpmnUserTask_id" INTEGER,
	transformation_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnActivity_id") REFERENCES "BpmnActivity" (id),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id),
	FOREIGN KEY("BpmnBusinessRuleTask_id") REFERENCES "BpmnBusinessRuleTask" (id),
	FOREIGN KEY("BpmnCallActivity_id") REFERENCES "BpmnCallActivity" (id),
	FOREIGN KEY("BpmnEndEvent_id") REFERENCES "BpmnEndEvent" (id),
	FOREIGN KEY("BpmnIntermediateThrowEvent_id") REFERENCES "BpmnIntermediateThrowEvent" (id),
	FOREIGN KEY("BpmnManualTask_id") REFERENCES "BpmnManualTask" (id),
	FOREIGN KEY("BpmnReceiveTask_id") REFERENCES "BpmnReceiveTask" (id),
	FOREIGN KEY("BpmnScriptTask_id") REFERENCES "BpmnScriptTask" (id),
	FOREIGN KEY("BpmnSendTask_id") REFERENCES "BpmnSendTask" (id),
	FOREIGN KEY("BpmnServiceTask_id") REFERENCES "BpmnServiceTask" (id),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("BpmnThrowEvent_id") REFERENCES "BpmnThrowEvent" (id),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id),
	FOREIGN KEY("BpmnUserTask_id") REFERENCES "BpmnUserTask" (id),
	FOREIGN KEY(transformation_id) REFERENCES "BpmnTransformation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataInputAssociation_id" ON "BpmnDataInputAssociation" (id);

CREATE TABLE "BpmnDataOutput" (
	id INTEGER NOT NULL,
	name TEXT,
	is_collection BOOLEAN,
	item_subject_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnBoundaryEvent_id" INTEGER,
	"BpmnCatchEvent_id" INTEGER,
	"BpmnIntermediateCatchEvent_id" INTEGER,
	"BpmnIoSpecification_id" INTEGER,
	"BpmnStartEvent_id" INTEGER,
	data_state_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnBoundaryEvent_id") REFERENCES "BpmnBoundaryEvent" (id),
	FOREIGN KEY("BpmnCatchEvent_id") REFERENCES "BpmnCatchEvent" (id),
	FOREIGN KEY("BpmnIntermediateCatchEvent_id") REFERENCES "BpmnIntermediateCatchEvent" (id),
	FOREIGN KEY("BpmnIoSpecification_id") REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY("BpmnStartEvent_id") REFERENCES "BpmnStartEvent" (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataOutput_id" ON "BpmnDataOutput" (id);

CREATE TABLE "BpmnDataOutputAssociation" (
	id INTEGER NOT NULL,
	target_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnActivity_id" INTEGER,
	"BpmnAdHocSubProcess_id" INTEGER,
	"BpmnBoundaryEvent_id" INTEGER,
	"BpmnBusinessRuleTask_id" INTEGER,
	"BpmnCallActivity_id" INTEGER,
	"BpmnCatchEvent_id" INTEGER,
	"BpmnIntermediateCatchEvent_id" INTEGER,
	"BpmnManualTask_id" INTEGER,
	"BpmnReceiveTask_id" INTEGER,
	"BpmnScriptTask_id" INTEGER,
	"BpmnSendTask_id" INTEGER,
	"BpmnServiceTask_id" INTEGER,
	"BpmnStartEvent_id" INTEGER,
	"BpmnSubProcess_id" INTEGER,
	"BpmnTask_id" INTEGER,
	"BpmnTransaction_id" INTEGER,
	"BpmnUserTask_id" INTEGER,
	transformation_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnActivity_id") REFERENCES "BpmnActivity" (id),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id),
	FOREIGN KEY("BpmnBoundaryEvent_id") REFERENCES "BpmnBoundaryEvent" (id),
	FOREIGN KEY("BpmnBusinessRuleTask_id") REFERENCES "BpmnBusinessRuleTask" (id),
	FOREIGN KEY("BpmnCallActivity_id") REFERENCES "BpmnCallActivity" (id),
	FOREIGN KEY("BpmnCatchEvent_id") REFERENCES "BpmnCatchEvent" (id),
	FOREIGN KEY("BpmnIntermediateCatchEvent_id") REFERENCES "BpmnIntermediateCatchEvent" (id),
	FOREIGN KEY("BpmnManualTask_id") REFERENCES "BpmnManualTask" (id),
	FOREIGN KEY("BpmnReceiveTask_id") REFERENCES "BpmnReceiveTask" (id),
	FOREIGN KEY("BpmnScriptTask_id") REFERENCES "BpmnScriptTask" (id),
	FOREIGN KEY("BpmnSendTask_id") REFERENCES "BpmnSendTask" (id),
	FOREIGN KEY("BpmnServiceTask_id") REFERENCES "BpmnServiceTask" (id),
	FOREIGN KEY("BpmnStartEvent_id") REFERENCES "BpmnStartEvent" (id),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id),
	FOREIGN KEY("BpmnUserTask_id") REFERENCES "BpmnUserTask" (id),
	FOREIGN KEY(transformation_id) REFERENCES "BpmnTransformation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataOutputAssociation_id" ON "BpmnDataOutputAssociation" (id);

CREATE TABLE "BpmnEventDefinition" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnBoundaryEvent_id" INTEGER,
	"BpmnCatchEvent_id" INTEGER,
	"BpmnEndEvent_id" INTEGER,
	"BpmnIntermediateCatchEvent_id" INTEGER,
	"BpmnIntermediateThrowEvent_id" INTEGER,
	"BpmnStartEvent_id" INTEGER,
	"BpmnThrowEvent_id" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnBoundaryEvent_id") REFERENCES "BpmnBoundaryEvent" (id),
	FOREIGN KEY("BpmnCatchEvent_id") REFERENCES "BpmnCatchEvent" (id),
	FOREIGN KEY("BpmnEndEvent_id") REFERENCES "BpmnEndEvent" (id),
	FOREIGN KEY("BpmnIntermediateCatchEvent_id") REFERENCES "BpmnIntermediateCatchEvent" (id),
	FOREIGN KEY("BpmnIntermediateThrowEvent_id") REFERENCES "BpmnIntermediateThrowEvent" (id),
	FOREIGN KEY("BpmnStartEvent_id") REFERENCES "BpmnStartEvent" (id),
	FOREIGN KEY("BpmnThrowEvent_id") REFERENCES "BpmnThrowEvent" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEventDefinition_id" ON "BpmnEventDefinition" (id);

CREATE TABLE "BpmnLane" (
	id INTEGER NOT NULL,
	name TEXT,
	partition_element_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnChildLaneSet_id" INTEGER,
	"BpmnLaneSet_id" INTEGER,
	partition_element_id INTEGER,
	child_lane_set_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnChildLaneSet_id") REFERENCES "BpmnChildLaneSet" (id),
	FOREIGN KEY("BpmnLaneSet_id") REFERENCES "BpmnLaneSet" (id),
	FOREIGN KEY(partition_element_id) REFERENCES "BpmnPartitionElement" (id),
	FOREIGN KEY(child_lane_set_id) REFERENCES "BpmnChildLaneSet" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLane_id" ON "BpmnLane" (id);

CREATE TABLE "BpmnProperty" (
	id INTEGER NOT NULL,
	name TEXT,
	item_subject_ref TEXT,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnActivity_id" INTEGER,
	"BpmnAdHocSubProcess_id" INTEGER,
	"BpmnBoundaryEvent_id" INTEGER,
	"BpmnBusinessRuleTask_id" INTEGER,
	"BpmnCallActivity_id" INTEGER,
	"BpmnCatchEvent_id" INTEGER,
	"BpmnEndEvent_id" INTEGER,
	"BpmnEvent_id" INTEGER,
	"BpmnIntermediateCatchEvent_id" INTEGER,
	"BpmnIntermediateThrowEvent_id" INTEGER,
	"BpmnManualTask_id" INTEGER,
	"BpmnProcess_id" INTEGER,
	"BpmnReceiveTask_id" INTEGER,
	"BpmnScriptTask_id" INTEGER,
	"BpmnSendTask_id" INTEGER,
	"BpmnServiceTask_id" INTEGER,
	"BpmnStartEvent_id" INTEGER,
	"BpmnSubProcess_id" INTEGER,
	"BpmnTask_id" INTEGER,
	"BpmnThrowEvent_id" INTEGER,
	"BpmnTransaction_id" INTEGER,
	"BpmnUserTask_id" INTEGER,
	data_state_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnActivity_id") REFERENCES "BpmnActivity" (id),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id),
	FOREIGN KEY("BpmnBoundaryEvent_id") REFERENCES "BpmnBoundaryEvent" (id),
	FOREIGN KEY("BpmnBusinessRuleTask_id") REFERENCES "BpmnBusinessRuleTask" (id),
	FOREIGN KEY("BpmnCallActivity_id") REFERENCES "BpmnCallActivity" (id),
	FOREIGN KEY("BpmnCatchEvent_id") REFERENCES "BpmnCatchEvent" (id),
	FOREIGN KEY("BpmnEndEvent_id") REFERENCES "BpmnEndEvent" (id),
	FOREIGN KEY("BpmnEvent_id") REFERENCES "BpmnEvent" (id),
	FOREIGN KEY("BpmnIntermediateCatchEvent_id") REFERENCES "BpmnIntermediateCatchEvent" (id),
	FOREIGN KEY("BpmnIntermediateThrowEvent_id") REFERENCES "BpmnIntermediateThrowEvent" (id),
	FOREIGN KEY("BpmnManualTask_id") REFERENCES "BpmnManualTask" (id),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id),
	FOREIGN KEY("BpmnReceiveTask_id") REFERENCES "BpmnReceiveTask" (id),
	FOREIGN KEY("BpmnScriptTask_id") REFERENCES "BpmnScriptTask" (id),
	FOREIGN KEY("BpmnSendTask_id") REFERENCES "BpmnSendTask" (id),
	FOREIGN KEY("BpmnServiceTask_id") REFERENCES "BpmnServiceTask" (id),
	FOREIGN KEY("BpmnStartEvent_id") REFERENCES "BpmnStartEvent" (id),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("BpmnThrowEvent_id") REFERENCES "BpmnThrowEvent" (id),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id),
	FOREIGN KEY("BpmnUserTask_id") REFERENCES "BpmnUserTask" (id),
	FOREIGN KEY(data_state_id) REFERENCES "BpmnDataState" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnProperty_id" ON "BpmnProperty" (id);

CREATE TABLE "BpmnResourceParameterBinding" (
	id INTEGER NOT NULL,
	parameter_ref TEXT NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnHumanPerformer_id" INTEGER,
	"BpmnPerformer_id" INTEGER,
	"BpmnPotentialOwner_id" INTEGER,
	"BpmnResourceRole_id" INTEGER,
	expression_id INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnHumanPerformer_id") REFERENCES "BpmnHumanPerformer" (id),
	FOREIGN KEY("BpmnPerformer_id") REFERENCES "BpmnPerformer" (id),
	FOREIGN KEY("BpmnPotentialOwner_id") REFERENCES "BpmnPotentialOwner" (id),
	FOREIGN KEY("BpmnResourceRole_id") REFERENCES "BpmnResourceRole" (id),
	FOREIGN KEY(expression_id) REFERENCES "BpmnExpression" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResourceParameterBinding_id" ON "BpmnResourceParameterBinding" (id);

CREATE TABLE "FluxnovaField" (
	id INTEGER NOT NULL,
	fluxnova_name TEXT,
	fluxnova_expression TEXT,
	fluxnova_string_value TEXT,
	element_type TEXT,
	"FluxnovaExecutionListener_id" INTEGER,
	"FluxnovaTaskListener_id" INTEGER,
	expression_id INTEGER,
	string_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaExecutionListener_id") REFERENCES "FluxnovaExecutionListener" (id),
	FOREIGN KEY("FluxnovaTaskListener_id") REFERENCES "FluxnovaTaskListener" (id),
	FOREIGN KEY(expression_id) REFERENCES "FluxnovaExpression" (id),
	FOREIGN KEY(string_id) REFERENCES "FluxnovaString" (id)
);
CREATE INDEX "ix_FluxnovaField_id" ON "FluxnovaField" (id);

CREATE TABLE "BpmnBoundaryEvent_event_definition_refs" (
	"BpmnBoundaryEvent_id" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnBoundaryEvent_id", event_definition_refs),
	FOREIGN KEY("BpmnBoundaryEvent_id") REFERENCES "BpmnBoundaryEvent" (id)
);
CREATE INDEX "ix_BpmnBoundaryEvent_event_definition_refs_BpmnBoundaryEvent_id" ON "BpmnBoundaryEvent_event_definition_refs" ("BpmnBoundaryEvent_id");
CREATE INDEX "ix_BpmnBoundaryEvent_event_definition_refs_event_definition_refs" ON "BpmnBoundaryEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnBoundaryEvent_incoming" (
	"BpmnBoundaryEvent_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnBoundaryEvent_id", incoming),
	FOREIGN KEY("BpmnBoundaryEvent_id") REFERENCES "BpmnBoundaryEvent" (id)
);
CREATE INDEX "ix_BpmnBoundaryEvent_incoming_BpmnBoundaryEvent_id" ON "BpmnBoundaryEvent_incoming" ("BpmnBoundaryEvent_id");
CREATE INDEX "ix_BpmnBoundaryEvent_incoming_incoming" ON "BpmnBoundaryEvent_incoming" (incoming);

CREATE TABLE "BpmnBoundaryEvent_outgoing" (
	"BpmnBoundaryEvent_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnBoundaryEvent_id", outgoing),
	FOREIGN KEY("BpmnBoundaryEvent_id") REFERENCES "BpmnBoundaryEvent" (id)
);
CREATE INDEX "ix_BpmnBoundaryEvent_outgoing_outgoing" ON "BpmnBoundaryEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnBoundaryEvent_outgoing_BpmnBoundaryEvent_id" ON "BpmnBoundaryEvent_outgoing" ("BpmnBoundaryEvent_id");

CREATE TABLE "BpmnBoundaryEvent_category_value_refs" (
	"BpmnBoundaryEvent_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnBoundaryEvent_id", category_value_refs),
	FOREIGN KEY("BpmnBoundaryEvent_id") REFERENCES "BpmnBoundaryEvent" (id)
);
CREATE INDEX "ix_BpmnBoundaryEvent_category_value_refs_BpmnBoundaryEvent_id" ON "BpmnBoundaryEvent_category_value_refs" ("BpmnBoundaryEvent_id");
CREATE INDEX "ix_BpmnBoundaryEvent_category_value_refs_category_value_refs" ON "BpmnBoundaryEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnCatchEvent_event_definition_refs" (
	"BpmnCatchEvent_id" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnCatchEvent_id", event_definition_refs),
	FOREIGN KEY("BpmnCatchEvent_id") REFERENCES "BpmnCatchEvent" (id)
);
CREATE INDEX "ix_BpmnCatchEvent_event_definition_refs_BpmnCatchEvent_id" ON "BpmnCatchEvent_event_definition_refs" ("BpmnCatchEvent_id");
CREATE INDEX "ix_BpmnCatchEvent_event_definition_refs_event_definition_refs" ON "BpmnCatchEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnCatchEvent_incoming" (
	"BpmnCatchEvent_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnCatchEvent_id", incoming),
	FOREIGN KEY("BpmnCatchEvent_id") REFERENCES "BpmnCatchEvent" (id)
);
CREATE INDEX "ix_BpmnCatchEvent_incoming_incoming" ON "BpmnCatchEvent_incoming" (incoming);
CREATE INDEX "ix_BpmnCatchEvent_incoming_BpmnCatchEvent_id" ON "BpmnCatchEvent_incoming" ("BpmnCatchEvent_id");

CREATE TABLE "BpmnCatchEvent_outgoing" (
	"BpmnCatchEvent_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnCatchEvent_id", outgoing),
	FOREIGN KEY("BpmnCatchEvent_id") REFERENCES "BpmnCatchEvent" (id)
);
CREATE INDEX "ix_BpmnCatchEvent_outgoing_BpmnCatchEvent_id" ON "BpmnCatchEvent_outgoing" ("BpmnCatchEvent_id");
CREATE INDEX "ix_BpmnCatchEvent_outgoing_outgoing" ON "BpmnCatchEvent_outgoing" (outgoing);

CREATE TABLE "BpmnCatchEvent_category_value_refs" (
	"BpmnCatchEvent_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnCatchEvent_id", category_value_refs),
	FOREIGN KEY("BpmnCatchEvent_id") REFERENCES "BpmnCatchEvent" (id)
);
CREATE INDEX "ix_BpmnCatchEvent_category_value_refs_BpmnCatchEvent_id" ON "BpmnCatchEvent_category_value_refs" ("BpmnCatchEvent_id");
CREATE INDEX "ix_BpmnCatchEvent_category_value_refs_category_value_refs" ON "BpmnCatchEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnCorrelationKey_correlation_property_refs" (
	"BpmnCorrelationKey_id" INTEGER,
	correlation_property_refs TEXT,
	PRIMARY KEY ("BpmnCorrelationKey_id", correlation_property_refs),
	FOREIGN KEY("BpmnCorrelationKey_id") REFERENCES "BpmnCorrelationKey" (id)
);
CREATE INDEX "ix_BpmnCorrelationKey_correlation_property_refs_BpmnCorrelationKey_id" ON "BpmnCorrelationKey_correlation_property_refs" ("BpmnCorrelationKey_id");
CREATE INDEX "ix_BpmnCorrelationKey_correlation_property_refs_correlation_property_refs" ON "BpmnCorrelationKey_correlation_property_refs" (correlation_property_refs);

CREATE TABLE "BpmnEndEvent_event_definition_refs" (
	"BpmnEndEvent_id" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnEndEvent_id", event_definition_refs),
	FOREIGN KEY("BpmnEndEvent_id") REFERENCES "BpmnEndEvent" (id)
);
CREATE INDEX "ix_BpmnEndEvent_event_definition_refs_BpmnEndEvent_id" ON "BpmnEndEvent_event_definition_refs" ("BpmnEndEvent_id");
CREATE INDEX "ix_BpmnEndEvent_event_definition_refs_event_definition_refs" ON "BpmnEndEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnEndEvent_incoming" (
	"BpmnEndEvent_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnEndEvent_id", incoming),
	FOREIGN KEY("BpmnEndEvent_id") REFERENCES "BpmnEndEvent" (id)
);
CREATE INDEX "ix_BpmnEndEvent_incoming_BpmnEndEvent_id" ON "BpmnEndEvent_incoming" ("BpmnEndEvent_id");
CREATE INDEX "ix_BpmnEndEvent_incoming_incoming" ON "BpmnEndEvent_incoming" (incoming);

CREATE TABLE "BpmnEndEvent_outgoing" (
	"BpmnEndEvent_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnEndEvent_id", outgoing),
	FOREIGN KEY("BpmnEndEvent_id") REFERENCES "BpmnEndEvent" (id)
);
CREATE INDEX "ix_BpmnEndEvent_outgoing_BpmnEndEvent_id" ON "BpmnEndEvent_outgoing" ("BpmnEndEvent_id");
CREATE INDEX "ix_BpmnEndEvent_outgoing_outgoing" ON "BpmnEndEvent_outgoing" (outgoing);

CREATE TABLE "BpmnEndEvent_category_value_refs" (
	"BpmnEndEvent_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnEndEvent_id", category_value_refs),
	FOREIGN KEY("BpmnEndEvent_id") REFERENCES "BpmnEndEvent" (id)
);
CREATE INDEX "ix_BpmnEndEvent_category_value_refs_category_value_refs" ON "BpmnEndEvent_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnEndEvent_category_value_refs_BpmnEndEvent_id" ON "BpmnEndEvent_category_value_refs" ("BpmnEndEvent_id");

CREATE TABLE "BpmnFlowElement_category_value_refs" (
	"BpmnFlowElement_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnFlowElement_id", category_value_refs),
	FOREIGN KEY("BpmnFlowElement_id") REFERENCES "BpmnFlowElement" (id)
);
CREATE INDEX "ix_BpmnFlowElement_category_value_refs_category_value_refs" ON "BpmnFlowElement_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnFlowElement_category_value_refs_BpmnFlowElement_id" ON "BpmnFlowElement_category_value_refs" ("BpmnFlowElement_id");

CREATE TABLE "BpmnIntermediateCatchEvent_event_definition_refs" (
	"BpmnIntermediateCatchEvent_id" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnIntermediateCatchEvent_id", event_definition_refs),
	FOREIGN KEY("BpmnIntermediateCatchEvent_id") REFERENCES "BpmnIntermediateCatchEvent" (id)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_event_definition_refs_BpmnIntermediateCatchEvent_id" ON "BpmnIntermediateCatchEvent_event_definition_refs" ("BpmnIntermediateCatchEvent_id");
CREATE INDEX "ix_BpmnIntermediateCatchEvent_event_definition_refs_event_definition_refs" ON "BpmnIntermediateCatchEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnIntermediateCatchEvent_incoming" (
	"BpmnIntermediateCatchEvent_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnIntermediateCatchEvent_id", incoming),
	FOREIGN KEY("BpmnIntermediateCatchEvent_id") REFERENCES "BpmnIntermediateCatchEvent" (id)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_incoming_BpmnIntermediateCatchEvent_id" ON "BpmnIntermediateCatchEvent_incoming" ("BpmnIntermediateCatchEvent_id");
CREATE INDEX "ix_BpmnIntermediateCatchEvent_incoming_incoming" ON "BpmnIntermediateCatchEvent_incoming" (incoming);

CREATE TABLE "BpmnIntermediateCatchEvent_outgoing" (
	"BpmnIntermediateCatchEvent_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnIntermediateCatchEvent_id", outgoing),
	FOREIGN KEY("BpmnIntermediateCatchEvent_id") REFERENCES "BpmnIntermediateCatchEvent" (id)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_outgoing_outgoing" ON "BpmnIntermediateCatchEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_outgoing_BpmnIntermediateCatchEvent_id" ON "BpmnIntermediateCatchEvent_outgoing" ("BpmnIntermediateCatchEvent_id");

CREATE TABLE "BpmnIntermediateCatchEvent_category_value_refs" (
	"BpmnIntermediateCatchEvent_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnIntermediateCatchEvent_id", category_value_refs),
	FOREIGN KEY("BpmnIntermediateCatchEvent_id") REFERENCES "BpmnIntermediateCatchEvent" (id)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_category_value_refs_BpmnIntermediateCatchEvent_id" ON "BpmnIntermediateCatchEvent_category_value_refs" ("BpmnIntermediateCatchEvent_id");
CREATE INDEX "ix_BpmnIntermediateCatchEvent_category_value_refs_category_value_refs" ON "BpmnIntermediateCatchEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnIntermediateThrowEvent_event_definition_refs" (
	"BpmnIntermediateThrowEvent_id" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnIntermediateThrowEvent_id", event_definition_refs),
	FOREIGN KEY("BpmnIntermediateThrowEvent_id") REFERENCES "BpmnIntermediateThrowEvent" (id)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_event_definition_refs_BpmnIntermediateThrowEvent_id" ON "BpmnIntermediateThrowEvent_event_definition_refs" ("BpmnIntermediateThrowEvent_id");
CREATE INDEX "ix_BpmnIntermediateThrowEvent_event_definition_refs_event_definition_refs" ON "BpmnIntermediateThrowEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnIntermediateThrowEvent_incoming" (
	"BpmnIntermediateThrowEvent_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnIntermediateThrowEvent_id", incoming),
	FOREIGN KEY("BpmnIntermediateThrowEvent_id") REFERENCES "BpmnIntermediateThrowEvent" (id)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_incoming_BpmnIntermediateThrowEvent_id" ON "BpmnIntermediateThrowEvent_incoming" ("BpmnIntermediateThrowEvent_id");
CREATE INDEX "ix_BpmnIntermediateThrowEvent_incoming_incoming" ON "BpmnIntermediateThrowEvent_incoming" (incoming);

CREATE TABLE "BpmnIntermediateThrowEvent_outgoing" (
	"BpmnIntermediateThrowEvent_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnIntermediateThrowEvent_id", outgoing),
	FOREIGN KEY("BpmnIntermediateThrowEvent_id") REFERENCES "BpmnIntermediateThrowEvent" (id)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_outgoing_outgoing" ON "BpmnIntermediateThrowEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_outgoing_BpmnIntermediateThrowEvent_id" ON "BpmnIntermediateThrowEvent_outgoing" ("BpmnIntermediateThrowEvent_id");

CREATE TABLE "BpmnIntermediateThrowEvent_category_value_refs" (
	"BpmnIntermediateThrowEvent_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnIntermediateThrowEvent_id", category_value_refs),
	FOREIGN KEY("BpmnIntermediateThrowEvent_id") REFERENCES "BpmnIntermediateThrowEvent" (id)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_category_value_refs_BpmnIntermediateThrowEvent_id" ON "BpmnIntermediateThrowEvent_category_value_refs" ("BpmnIntermediateThrowEvent_id");
CREATE INDEX "ix_BpmnIntermediateThrowEvent_category_value_refs_category_value_refs" ON "BpmnIntermediateThrowEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnStartEvent_event_definition_refs" (
	"BpmnStartEvent_id" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnStartEvent_id", event_definition_refs),
	FOREIGN KEY("BpmnStartEvent_id") REFERENCES "BpmnStartEvent" (id)
);
CREATE INDEX "ix_BpmnStartEvent_event_definition_refs_BpmnStartEvent_id" ON "BpmnStartEvent_event_definition_refs" ("BpmnStartEvent_id");
CREATE INDEX "ix_BpmnStartEvent_event_definition_refs_event_definition_refs" ON "BpmnStartEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnStartEvent_incoming" (
	"BpmnStartEvent_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnStartEvent_id", incoming),
	FOREIGN KEY("BpmnStartEvent_id") REFERENCES "BpmnStartEvent" (id)
);
CREATE INDEX "ix_BpmnStartEvent_incoming_BpmnStartEvent_id" ON "BpmnStartEvent_incoming" ("BpmnStartEvent_id");
CREATE INDEX "ix_BpmnStartEvent_incoming_incoming" ON "BpmnStartEvent_incoming" (incoming);

CREATE TABLE "BpmnStartEvent_outgoing" (
	"BpmnStartEvent_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnStartEvent_id", outgoing),
	FOREIGN KEY("BpmnStartEvent_id") REFERENCES "BpmnStartEvent" (id)
);
CREATE INDEX "ix_BpmnStartEvent_outgoing_outgoing" ON "BpmnStartEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnStartEvent_outgoing_BpmnStartEvent_id" ON "BpmnStartEvent_outgoing" ("BpmnStartEvent_id");

CREATE TABLE "BpmnStartEvent_category_value_refs" (
	"BpmnStartEvent_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnStartEvent_id", category_value_refs),
	FOREIGN KEY("BpmnStartEvent_id") REFERENCES "BpmnStartEvent" (id)
);
CREATE INDEX "ix_BpmnStartEvent_category_value_refs_BpmnStartEvent_id" ON "BpmnStartEvent_category_value_refs" ("BpmnStartEvent_id");
CREATE INDEX "ix_BpmnStartEvent_category_value_refs_category_value_refs" ON "BpmnStartEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnThrowEvent_event_definition_refs" (
	"BpmnThrowEvent_id" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnThrowEvent_id", event_definition_refs),
	FOREIGN KEY("BpmnThrowEvent_id") REFERENCES "BpmnThrowEvent" (id)
);
CREATE INDEX "ix_BpmnThrowEvent_event_definition_refs_BpmnThrowEvent_id" ON "BpmnThrowEvent_event_definition_refs" ("BpmnThrowEvent_id");
CREATE INDEX "ix_BpmnThrowEvent_event_definition_refs_event_definition_refs" ON "BpmnThrowEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnThrowEvent_incoming" (
	"BpmnThrowEvent_id" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnThrowEvent_id", incoming),
	FOREIGN KEY("BpmnThrowEvent_id") REFERENCES "BpmnThrowEvent" (id)
);
CREATE INDEX "ix_BpmnThrowEvent_incoming_BpmnThrowEvent_id" ON "BpmnThrowEvent_incoming" ("BpmnThrowEvent_id");
CREATE INDEX "ix_BpmnThrowEvent_incoming_incoming" ON "BpmnThrowEvent_incoming" (incoming);

CREATE TABLE "BpmnThrowEvent_outgoing" (
	"BpmnThrowEvent_id" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnThrowEvent_id", outgoing),
	FOREIGN KEY("BpmnThrowEvent_id") REFERENCES "BpmnThrowEvent" (id)
);
CREATE INDEX "ix_BpmnThrowEvent_outgoing_outgoing" ON "BpmnThrowEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnThrowEvent_outgoing_BpmnThrowEvent_id" ON "BpmnThrowEvent_outgoing" ("BpmnThrowEvent_id");

CREATE TABLE "BpmnThrowEvent_category_value_refs" (
	"BpmnThrowEvent_id" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnThrowEvent_id", category_value_refs),
	FOREIGN KEY("BpmnThrowEvent_id") REFERENCES "BpmnThrowEvent" (id)
);
CREATE INDEX "ix_BpmnThrowEvent_category_value_refs_BpmnThrowEvent_id" ON "BpmnThrowEvent_category_value_refs" ("BpmnThrowEvent_id");
CREATE INDEX "ix_BpmnThrowEvent_category_value_refs_category_value_refs" ON "BpmnThrowEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnAssignment" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	element_type TEXT,
	"BpmnDataAssociation_id" INTEGER,
	"BpmnDataInputAssociation_id" INTEGER,
	"BpmnDataOutputAssociation_id" INTEGER,
	from_expression_id INTEGER NOT NULL,
	to_expression_id INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDataAssociation_id") REFERENCES "BpmnDataAssociation" (id),
	FOREIGN KEY("BpmnDataInputAssociation_id") REFERENCES "BpmnDataInputAssociation" (id),
	FOREIGN KEY("BpmnDataOutputAssociation_id") REFERENCES "BpmnDataOutputAssociation" (id),
	FOREIGN KEY(from_expression_id) REFERENCES "BpmnFrom" (id),
	FOREIGN KEY(to_expression_id) REFERENCES "BpmnTo" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnAssignment_id" ON "BpmnAssignment" (id);

CREATE TABLE "BpmnDataInputAssociation_source_refs" (
	"BpmnDataInputAssociation_id" INTEGER,
	source_refs TEXT,
	PRIMARY KEY ("BpmnDataInputAssociation_id", source_refs),
	FOREIGN KEY("BpmnDataInputAssociation_id") REFERENCES "BpmnDataInputAssociation" (id)
);
CREATE INDEX "ix_BpmnDataInputAssociation_source_refs_source_refs" ON "BpmnDataInputAssociation_source_refs" (source_refs);
CREATE INDEX "ix_BpmnDataInputAssociation_source_refs_BpmnDataInputAssociation_id" ON "BpmnDataInputAssociation_source_refs" ("BpmnDataInputAssociation_id");

CREATE TABLE "BpmnDataOutputAssociation_source_refs" (
	"BpmnDataOutputAssociation_id" INTEGER,
	source_refs TEXT,
	PRIMARY KEY ("BpmnDataOutputAssociation_id", source_refs),
	FOREIGN KEY("BpmnDataOutputAssociation_id") REFERENCES "BpmnDataOutputAssociation" (id)
);
CREATE INDEX "ix_BpmnDataOutputAssociation_source_refs_BpmnDataOutputAssociation_id" ON "BpmnDataOutputAssociation_source_refs" ("BpmnDataOutputAssociation_id");
CREATE INDEX "ix_BpmnDataOutputAssociation_source_refs_source_refs" ON "BpmnDataOutputAssociation_source_refs" (source_refs);

CREATE TABLE "BpmnLane_flow_node_refs" (
	"BpmnLane_id" INTEGER,
	flow_node_refs TEXT,
	PRIMARY KEY ("BpmnLane_id", flow_node_refs),
	FOREIGN KEY("BpmnLane_id") REFERENCES "BpmnLane" (id)
);
CREATE INDEX "ix_BpmnLane_flow_node_refs_BpmnLane_id" ON "BpmnLane_flow_node_refs" ("BpmnLane_id");
CREATE INDEX "ix_BpmnLane_flow_node_refs_flow_node_refs" ON "BpmnLane_flow_node_refs" (flow_node_refs);

CREATE TABLE "BpmnDocumentation" (
	id INTEGER NOT NULL,
	bpmn_id TEXT,
	text_format TEXT,
	text_content TEXT,
	element_type TEXT,
	"BpmnActivationCondition_id" INTEGER,
	"BpmnActivity_id" INTEGER,
	"BpmnAdHocSubProcess_id" INTEGER,
	"BpmnArtifact_id" INTEGER,
	"BpmnAssignment_id" INTEGER,
	"BpmnAssociation_id" INTEGER,
	"BpmnAuditing_id" INTEGER,
	"BpmnBaseElement_id" INTEGER,
	"BpmnBoundaryEvent_id" INTEGER,
	"BpmnBusinessRuleTask_id" INTEGER,
	"BpmnCallActivity_id" INTEGER,
	"BpmnCallConversation_id" INTEGER,
	"BpmnCallableElement_id" INTEGER,
	"BpmnCancelEventDefinition_id" INTEGER,
	"BpmnCatchEvent_id" INTEGER,
	"BpmnCategory_id" INTEGER,
	"BpmnCategoryValue_id" INTEGER,
	"BpmnChildLaneSet_id" INTEGER,
	"BpmnCollaboration_id" INTEGER,
	"BpmnCompensateEventDefinition_id" INTEGER,
	"BpmnCompletionCondition_id" INTEGER,
	"BpmnComplexBehaviorDefinition_id" INTEGER,
	"BpmnComplexGateway_id" INTEGER,
	"BpmnCondition_id" INTEGER,
	"BpmnConditionExpression_id" INTEGER,
	"BpmnConditionalEventDefinition_id" INTEGER,
	"BpmnConversation_id" INTEGER,
	"BpmnConversationAssociation_id" INTEGER,
	"BpmnConversationLink_id" INTEGER,
	"BpmnConversationNode_id" INTEGER,
	"BpmnCorrelationKey_id" INTEGER,
	"BpmnCorrelationProperty_id" INTEGER,
	"BpmnCorrelationPropertyBinding_id" INTEGER,
	"BpmnCorrelationPropertyRetrievalExpression_id" INTEGER,
	"BpmnCorrelationSubscription_id" INTEGER,
	"BpmnDataAssociation_id" INTEGER,
	"BpmnDataInput_id" INTEGER,
	"BpmnDataInputAssociation_id" INTEGER,
	"BpmnDataObject_id" INTEGER,
	"BpmnDataObjectReference_id" INTEGER,
	"BpmnDataOutput_id" INTEGER,
	"BpmnDataOutputAssociation_id" INTEGER,
	"BpmnDataPath_id" INTEGER,
	"BpmnDataState_id" INTEGER,
	"BpmnDataStore_id" INTEGER,
	"BpmnDataStoreReference_id" INTEGER,
	"BpmnEndEvent_id" INTEGER,
	"BpmnEndPoint_id" INTEGER,
	"BpmnError_id" INTEGER,
	"BpmnErrorEventDefinition_id" INTEGER,
	"BpmnEscalation_id" INTEGER,
	"BpmnEscalationEventDefinition_id" INTEGER,
	"BpmnEvent_id" INTEGER,
	"BpmnEventBasedGateway_id" INTEGER,
	"BpmnEventDefinition_id" INTEGER,
	"BpmnExclusiveGateway_id" INTEGER,
	"BpmnExpression_id" INTEGER,
	"BpmnExtension_id" INTEGER,
	"BpmnFlowElement_id" INTEGER,
	"BpmnFlowNode_id" INTEGER,
	"BpmnFormalExpression_id" INTEGER,
	"BpmnFrom_id" INTEGER,
	"BpmnGateway_id" INTEGER,
	"BpmnGlobalConversation_id" INTEGER,
	"BpmnGroup_id" INTEGER,
	"BpmnHumanPerformer_id" INTEGER,
	"BpmnInclusiveGateway_id" INTEGER,
	"BpmnInputDataItem_id" INTEGER,
	"BpmnInputSet_id" INTEGER,
	"BpmnInterface_id" INTEGER,
	"BpmnIntermediateCatchEvent_id" INTEGER,
	"BpmnIntermediateThrowEvent_id" INTEGER,
	"BpmnIoBinding_id" INTEGER,
	"BpmnIoSpecification_id" INTEGER,
	"BpmnItemAwareElement_id" INTEGER,
	"BpmnItemDefinition_id" INTEGER,
	"BpmnLane_id" INTEGER,
	"BpmnLaneSet_id" INTEGER,
	"BpmnLinkEventDefinition_id" INTEGER,
	"BpmnLoopCardinality_id" INTEGER,
	"BpmnLoopCharacteristics_id" INTEGER,
	"BpmnManualTask_id" INTEGER,
	"BpmnMessage_id" INTEGER,
	"BpmnMessageEventDefinition_id" INTEGER,
	"BpmnMessageFlow_id" INTEGER,
	"BpmnMessageFlowAssociation_id" INTEGER,
	"BpmnMessagePath_id" INTEGER,
	"BpmnMonitoring_id" INTEGER,
	"BpmnMultiInstanceLoopCharacteristics_id" INTEGER,
	"BpmnOperation_id" INTEGER,
	"BpmnOutputDataItem_id" INTEGER,
	"BpmnOutputSet_id" INTEGER,
	"BpmnParallelGateway_id" INTEGER,
	"BpmnParticipant_id" INTEGER,
	"BpmnParticipantAssociation_id" INTEGER,
	"BpmnParticipantMultiplicity_id" INTEGER,
	"BpmnPartitionElement_id" INTEGER,
	"BpmnPerformer_id" INTEGER,
	"BpmnPotentialOwner_id" INTEGER,
	"BpmnProcess_id" INTEGER,
	"BpmnProperty_id" INTEGER,
	"BpmnReceiveTask_id" INTEGER,
	"BpmnRelationship_id" INTEGER,
	"BpmnRendering_id" INTEGER,
	"BpmnResource_id" INTEGER,
	"BpmnResourceAssignmentExpression_id" INTEGER,
	"BpmnResourceParameter_id" INTEGER,
	"BpmnResourceParameterBinding_id" INTEGER,
	"BpmnResourceRole_id" INTEGER,
	"BpmnRootElement_id" INTEGER,
	"BpmnScriptTask_id" INTEGER,
	"BpmnSendTask_id" INTEGER,
	"BpmnSequenceFlow_id" INTEGER,
	"BpmnServiceTask_id" INTEGER,
	"BpmnSignal_id" INTEGER,
	"BpmnSignalEventDefinition_id" INTEGER,
	"BpmnStartEvent_id" INTEGER,
	"BpmnSubConversation_id" INTEGER,
	"BpmnSubProcess_id" INTEGER,
	"BpmnTask_id" INTEGER,
	"BpmnTerminateEventDefinition_id" INTEGER,
	"BpmnTextAnnotation_id" INTEGER,
	"BpmnThrowEvent_id" INTEGER,
	"BpmnTimeCycle_id" INTEGER,
	"BpmnTimeDate_id" INTEGER,
	"BpmnTimeDuration_id" INTEGER,
	"BpmnTimerEventDefinition_id" INTEGER,
	"BpmnTo_id" INTEGER,
	"BpmnTransaction_id" INTEGER,
	"BpmnTransformation_id" INTEGER,
	"BpmnUserTask_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnActivationCondition_id") REFERENCES "BpmnActivationCondition" (id),
	FOREIGN KEY("BpmnActivity_id") REFERENCES "BpmnActivity" (id),
	FOREIGN KEY("BpmnAdHocSubProcess_id") REFERENCES "BpmnAdHocSubProcess" (id),
	FOREIGN KEY("BpmnArtifact_id") REFERENCES "BpmnArtifact" (id),
	FOREIGN KEY("BpmnAssignment_id") REFERENCES "BpmnAssignment" (id),
	FOREIGN KEY("BpmnAssociation_id") REFERENCES "BpmnAssociation" (id),
	FOREIGN KEY("BpmnAuditing_id") REFERENCES "BpmnAuditing" (id),
	FOREIGN KEY("BpmnBaseElement_id") REFERENCES "BpmnBaseElement" (id),
	FOREIGN KEY("BpmnBoundaryEvent_id") REFERENCES "BpmnBoundaryEvent" (id),
	FOREIGN KEY("BpmnBusinessRuleTask_id") REFERENCES "BpmnBusinessRuleTask" (id),
	FOREIGN KEY("BpmnCallActivity_id") REFERENCES "BpmnCallActivity" (id),
	FOREIGN KEY("BpmnCallConversation_id") REFERENCES "BpmnCallConversation" (id),
	FOREIGN KEY("BpmnCallableElement_id") REFERENCES "BpmnCallableElement" (id),
	FOREIGN KEY("BpmnCancelEventDefinition_id") REFERENCES "BpmnCancelEventDefinition" (id),
	FOREIGN KEY("BpmnCatchEvent_id") REFERENCES "BpmnCatchEvent" (id),
	FOREIGN KEY("BpmnCategory_id") REFERENCES "BpmnCategory" (id),
	FOREIGN KEY("BpmnCategoryValue_id") REFERENCES "BpmnCategoryValue" (id),
	FOREIGN KEY("BpmnChildLaneSet_id") REFERENCES "BpmnChildLaneSet" (id),
	FOREIGN KEY("BpmnCollaboration_id") REFERENCES "BpmnCollaboration" (id),
	FOREIGN KEY("BpmnCompensateEventDefinition_id") REFERENCES "BpmnCompensateEventDefinition" (id),
	FOREIGN KEY("BpmnCompletionCondition_id") REFERENCES "BpmnCompletionCondition" (id),
	FOREIGN KEY("BpmnComplexBehaviorDefinition_id") REFERENCES "BpmnComplexBehaviorDefinition" (id),
	FOREIGN KEY("BpmnComplexGateway_id") REFERENCES "BpmnComplexGateway" (id),
	FOREIGN KEY("BpmnCondition_id") REFERENCES "BpmnCondition" (id),
	FOREIGN KEY("BpmnConditionExpression_id") REFERENCES "BpmnConditionExpression" (id),
	FOREIGN KEY("BpmnConditionalEventDefinition_id") REFERENCES "BpmnConditionalEventDefinition" (id),
	FOREIGN KEY("BpmnConversation_id") REFERENCES "BpmnConversation" (id),
	FOREIGN KEY("BpmnConversationAssociation_id") REFERENCES "BpmnConversationAssociation" (id),
	FOREIGN KEY("BpmnConversationLink_id") REFERENCES "BpmnConversationLink" (id),
	FOREIGN KEY("BpmnConversationNode_id") REFERENCES "BpmnConversationNode" (id),
	FOREIGN KEY("BpmnCorrelationKey_id") REFERENCES "BpmnCorrelationKey" (id),
	FOREIGN KEY("BpmnCorrelationProperty_id") REFERENCES "BpmnCorrelationProperty" (id),
	FOREIGN KEY("BpmnCorrelationPropertyBinding_id") REFERENCES "BpmnCorrelationPropertyBinding" (id),
	FOREIGN KEY("BpmnCorrelationPropertyRetrievalExpression_id") REFERENCES "BpmnCorrelationPropertyRetrievalExpression" (id),
	FOREIGN KEY("BpmnCorrelationSubscription_id") REFERENCES "BpmnCorrelationSubscription" (id),
	FOREIGN KEY("BpmnDataAssociation_id") REFERENCES "BpmnDataAssociation" (id),
	FOREIGN KEY("BpmnDataInput_id") REFERENCES "BpmnDataInput" (id),
	FOREIGN KEY("BpmnDataInputAssociation_id") REFERENCES "BpmnDataInputAssociation" (id),
	FOREIGN KEY("BpmnDataObject_id") REFERENCES "BpmnDataObject" (id),
	FOREIGN KEY("BpmnDataObjectReference_id") REFERENCES "BpmnDataObjectReference" (id),
	FOREIGN KEY("BpmnDataOutput_id") REFERENCES "BpmnDataOutput" (id),
	FOREIGN KEY("BpmnDataOutputAssociation_id") REFERENCES "BpmnDataOutputAssociation" (id),
	FOREIGN KEY("BpmnDataPath_id") REFERENCES "BpmnDataPath" (id),
	FOREIGN KEY("BpmnDataState_id") REFERENCES "BpmnDataState" (id),
	FOREIGN KEY("BpmnDataStore_id") REFERENCES "BpmnDataStore" (id),
	FOREIGN KEY("BpmnDataStoreReference_id") REFERENCES "BpmnDataStoreReference" (id),
	FOREIGN KEY("BpmnEndEvent_id") REFERENCES "BpmnEndEvent" (id),
	FOREIGN KEY("BpmnEndPoint_id") REFERENCES "BpmnEndPoint" (id),
	FOREIGN KEY("BpmnError_id") REFERENCES "BpmnError" (id),
	FOREIGN KEY("BpmnErrorEventDefinition_id") REFERENCES "BpmnErrorEventDefinition" (id),
	FOREIGN KEY("BpmnEscalation_id") REFERENCES "BpmnEscalation" (id),
	FOREIGN KEY("BpmnEscalationEventDefinition_id") REFERENCES "BpmnEscalationEventDefinition" (id),
	FOREIGN KEY("BpmnEvent_id") REFERENCES "BpmnEvent" (id),
	FOREIGN KEY("BpmnEventBasedGateway_id") REFERENCES "BpmnEventBasedGateway" (id),
	FOREIGN KEY("BpmnEventDefinition_id") REFERENCES "BpmnEventDefinition" (id),
	FOREIGN KEY("BpmnExclusiveGateway_id") REFERENCES "BpmnExclusiveGateway" (id),
	FOREIGN KEY("BpmnExpression_id") REFERENCES "BpmnExpression" (id),
	FOREIGN KEY("BpmnExtension_id") REFERENCES "BpmnExtension" (id),
	FOREIGN KEY("BpmnFlowElement_id") REFERENCES "BpmnFlowElement" (id),
	FOREIGN KEY("BpmnFlowNode_id") REFERENCES "BpmnFlowNode" (id),
	FOREIGN KEY("BpmnFormalExpression_id") REFERENCES "BpmnFormalExpression" (id),
	FOREIGN KEY("BpmnFrom_id") REFERENCES "BpmnFrom" (id),
	FOREIGN KEY("BpmnGateway_id") REFERENCES "BpmnGateway" (id),
	FOREIGN KEY("BpmnGlobalConversation_id") REFERENCES "BpmnGlobalConversation" (id),
	FOREIGN KEY("BpmnGroup_id") REFERENCES "BpmnGroup" (id),
	FOREIGN KEY("BpmnHumanPerformer_id") REFERENCES "BpmnHumanPerformer" (id),
	FOREIGN KEY("BpmnInclusiveGateway_id") REFERENCES "BpmnInclusiveGateway" (id),
	FOREIGN KEY("BpmnInputDataItem_id") REFERENCES "BpmnInputDataItem" (id),
	FOREIGN KEY("BpmnInputSet_id") REFERENCES "BpmnInputSet" (id),
	FOREIGN KEY("BpmnInterface_id") REFERENCES "BpmnInterface" (id),
	FOREIGN KEY("BpmnIntermediateCatchEvent_id") REFERENCES "BpmnIntermediateCatchEvent" (id),
	FOREIGN KEY("BpmnIntermediateThrowEvent_id") REFERENCES "BpmnIntermediateThrowEvent" (id),
	FOREIGN KEY("BpmnIoBinding_id") REFERENCES "BpmnIoBinding" (id),
	FOREIGN KEY("BpmnIoSpecification_id") REFERENCES "BpmnIoSpecification" (id),
	FOREIGN KEY("BpmnItemAwareElement_id") REFERENCES "BpmnItemAwareElement" (id),
	FOREIGN KEY("BpmnItemDefinition_id") REFERENCES "BpmnItemDefinition" (id),
	FOREIGN KEY("BpmnLane_id") REFERENCES "BpmnLane" (id),
	FOREIGN KEY("BpmnLaneSet_id") REFERENCES "BpmnLaneSet" (id),
	FOREIGN KEY("BpmnLinkEventDefinition_id") REFERENCES "BpmnLinkEventDefinition" (id),
	FOREIGN KEY("BpmnLoopCardinality_id") REFERENCES "BpmnLoopCardinality" (id),
	FOREIGN KEY("BpmnLoopCharacteristics_id") REFERENCES "BpmnLoopCharacteristics" (id),
	FOREIGN KEY("BpmnManualTask_id") REFERENCES "BpmnManualTask" (id),
	FOREIGN KEY("BpmnMessage_id") REFERENCES "BpmnMessage" (id),
	FOREIGN KEY("BpmnMessageEventDefinition_id") REFERENCES "BpmnMessageEventDefinition" (id),
	FOREIGN KEY("BpmnMessageFlow_id") REFERENCES "BpmnMessageFlow" (id),
	FOREIGN KEY("BpmnMessageFlowAssociation_id") REFERENCES "BpmnMessageFlowAssociation" (id),
	FOREIGN KEY("BpmnMessagePath_id") REFERENCES "BpmnMessagePath" (id),
	FOREIGN KEY("BpmnMonitoring_id") REFERENCES "BpmnMonitoring" (id),
	FOREIGN KEY("BpmnMultiInstanceLoopCharacteristics_id") REFERENCES "BpmnMultiInstanceLoopCharacteristics" (id),
	FOREIGN KEY("BpmnOperation_id") REFERENCES "BpmnOperation" (id),
	FOREIGN KEY("BpmnOutputDataItem_id") REFERENCES "BpmnOutputDataItem" (id),
	FOREIGN KEY("BpmnOutputSet_id") REFERENCES "BpmnOutputSet" (id),
	FOREIGN KEY("BpmnParallelGateway_id") REFERENCES "BpmnParallelGateway" (id),
	FOREIGN KEY("BpmnParticipant_id") REFERENCES "BpmnParticipant" (id),
	FOREIGN KEY("BpmnParticipantAssociation_id") REFERENCES "BpmnParticipantAssociation" (id),
	FOREIGN KEY("BpmnParticipantMultiplicity_id") REFERENCES "BpmnParticipantMultiplicity" (id),
	FOREIGN KEY("BpmnPartitionElement_id") REFERENCES "BpmnPartitionElement" (id),
	FOREIGN KEY("BpmnPerformer_id") REFERENCES "BpmnPerformer" (id),
	FOREIGN KEY("BpmnPotentialOwner_id") REFERENCES "BpmnPotentialOwner" (id),
	FOREIGN KEY("BpmnProcess_id") REFERENCES "BpmnProcess" (id),
	FOREIGN KEY("BpmnProperty_id") REFERENCES "BpmnProperty" (id),
	FOREIGN KEY("BpmnReceiveTask_id") REFERENCES "BpmnReceiveTask" (id),
	FOREIGN KEY("BpmnRelationship_id") REFERENCES "BpmnRelationship" (id),
	FOREIGN KEY("BpmnRendering_id") REFERENCES "BpmnRendering" (id),
	FOREIGN KEY("BpmnResource_id") REFERENCES "BpmnResource" (id),
	FOREIGN KEY("BpmnResourceAssignmentExpression_id") REFERENCES "BpmnResourceAssignmentExpression" (id),
	FOREIGN KEY("BpmnResourceParameter_id") REFERENCES "BpmnResourceParameter" (id),
	FOREIGN KEY("BpmnResourceParameterBinding_id") REFERENCES "BpmnResourceParameterBinding" (id),
	FOREIGN KEY("BpmnResourceRole_id") REFERENCES "BpmnResourceRole" (id),
	FOREIGN KEY("BpmnRootElement_id") REFERENCES "BpmnRootElement" (id),
	FOREIGN KEY("BpmnScriptTask_id") REFERENCES "BpmnScriptTask" (id),
	FOREIGN KEY("BpmnSendTask_id") REFERENCES "BpmnSendTask" (id),
	FOREIGN KEY("BpmnSequenceFlow_id") REFERENCES "BpmnSequenceFlow" (id),
	FOREIGN KEY("BpmnServiceTask_id") REFERENCES "BpmnServiceTask" (id),
	FOREIGN KEY("BpmnSignal_id") REFERENCES "BpmnSignal" (id),
	FOREIGN KEY("BpmnSignalEventDefinition_id") REFERENCES "BpmnSignalEventDefinition" (id),
	FOREIGN KEY("BpmnStartEvent_id") REFERENCES "BpmnStartEvent" (id),
	FOREIGN KEY("BpmnSubConversation_id") REFERENCES "BpmnSubConversation" (id),
	FOREIGN KEY("BpmnSubProcess_id") REFERENCES "BpmnSubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("BpmnTerminateEventDefinition_id") REFERENCES "BpmnTerminateEventDefinition" (id),
	FOREIGN KEY("BpmnTextAnnotation_id") REFERENCES "BpmnTextAnnotation" (id),
	FOREIGN KEY("BpmnThrowEvent_id") REFERENCES "BpmnThrowEvent" (id),
	FOREIGN KEY("BpmnTimeCycle_id") REFERENCES "BpmnTimeCycle" (id),
	FOREIGN KEY("BpmnTimeDate_id") REFERENCES "BpmnTimeDate" (id),
	FOREIGN KEY("BpmnTimeDuration_id") REFERENCES "BpmnTimeDuration" (id),
	FOREIGN KEY("BpmnTimerEventDefinition_id") REFERENCES "BpmnTimerEventDefinition" (id),
	FOREIGN KEY("BpmnTo_id") REFERENCES "BpmnTo" (id),
	FOREIGN KEY("BpmnTransaction_id") REFERENCES "BpmnTransaction" (id),
	FOREIGN KEY("BpmnTransformation_id") REFERENCES "BpmnTransformation" (id),
	FOREIGN KEY("BpmnUserTask_id") REFERENCES "BpmnUserTask" (id)
);
CREATE INDEX "ix_BpmnDocumentation_id" ON "BpmnDocumentation" (id);
