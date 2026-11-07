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
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: documentation Description: Text that documents the element.
--     * Slot: resolution Description: The resolution of the diagram, in units per inch.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Abstract Class: DiDiagramElement Description: Any element drawn on a diagram.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: DiPlane_uid Description: Autocreated FK slot
--     * Slot: BpmnPlane_uid Description: Autocreated FK slot
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiEdge Description: A diagram element drawn as a line through waypoints between two elements.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: DiExtension Description: Tool-specific content attached to a diagram element.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Abstract Class: DiLabel Description: A diagram element that shows text, placed by its bounds.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiLabeledEdge Description: An edge that can carry labels.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiLabeledShape Description: A shape that can carry labels.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiNode Description: A diagram element that other elements can connect to.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiPlane Description: A diagram's drawing surface, which holds its shapes and edges.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiShape Description: A diagram element drawn as a figure inside its bounds.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Abstract Class: DiStyle Description: How a diagram element looks, such as its font or colour.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: DiWaypoint Description: A point an edge passes through.
--     * Slot: id
--     * Slot: x Description: The horizontal coordinate.
--     * Slot: y Description: The vertical coordinate.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: DiEdge_uid Description: Autocreated FK slot
--     * Slot: DiLabeledEdge_uid Description: Autocreated FK slot
--     * Slot: BpmnEdge_uid Description: Autocreated FK slot
-- # Class: BpmnDiagram Description: A diagram of BPMN elements, with its plane and the label styles it uses.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: documentation Description: Text that documents the element.
--     * Slot: resolution Description: The resolution of the diagram, in units per inch.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_uid Description: Autocreated FK slot
--     * Slot: bpmn_plane_uid Description: The plane that holds this diagram's shapes and edges.
-- # Class: BpmnEdge Description: The line that draws a connecting BPMN element, such as a sequence flow, message flow or association.
--     * Slot: uid
--     * Slot: bpmn_element Description: The QName of the BPMN element this diagram element draws.
--     * Slot: source_element Description: The QName of the diagram element the edge starts at.
--     * Slot: target_element Description: The QName of the diagram element the edge ends at.
--     * Slot: message_visible_kind Description: Whether the message the edge carries is drawn as initiating or not.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bpmn_label_uid Description: The label drawn with this shape or edge.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: BpmnLabel Description: The label of a BPMN shape or edge, where its text is drawn.
--     * Slot: uid
--     * Slot: label_style Description: The QName of the label style the label uses.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: BpmnLabelStyle Description: A font that BPMN labels share.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDiagram_uid Description: Autocreated FK slot
--     * Slot: font_id Description: The font the labels are drawn in.
-- # Class: BpmnPlane Description: The plane of a BPMN diagram, drawing one process, collaboration or sub-process.
--     * Slot: uid
--     * Slot: bpmn_element Description: The QName of the BPMN element this diagram element draws.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: BpmnShape Description: The figure that draws a BPMN element such as a task, event, gateway, pool or lane.
--     * Slot: uid
--     * Slot: bpmn_element Description: The QName of the BPMN element this diagram element draws.
--     * Slot: is_horizontal Description: Whether a pool or lane is drawn horizontally.
--     * Slot: is_expanded Description: Whether a sub-process or call activity is drawn expanded.
--     * Slot: is_marker_visible Description: Whether an exclusive gateway is drawn with its marker.
--     * Slot: is_message_visible Description: Whether a participant band is drawn with its message.
--     * Slot: participant_band_kind Description: Where a participant band sits on a choreography activity, and whether it initiates.
--     * Slot: choreography_activity_shape Description: The QName of the choreography activity shape this participant band belongs to.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: bpmn_label_uid Description: The label drawn with this shape or edge.
--     * Slot: bounds_id Description: Where the element is drawn, and how large.
--     * Slot: extension_id Description: Tool-specific content of the diagram element.
-- # Class: BpmnActivationCondition Description: The condition a complex gateway checks to decide when enough incoming flows have arrived to continue.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnActivity Description: Work a process performs, either a task or a sub-process.
--     * Slot: uid
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnAdHocSubProcess Description: A sub-process whose inner activities run in no fixed order, as its performers choose.
--     * Slot: uid
--     * Slot: ordering Description: Whether the inner activities run in parallel or one after another.
--     * Slot: cancel_remaining_instances Description: Whether the activities still running are cancelled once the completion condition holds.
--     * Slot: triggered_by_event Description: Whether the sub-process is an event sub-process, started by an event.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: completion_condition_uid Description: The condition that ends the activity early when it holds.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnArtifact Description: An element that adds information to a diagram without changing how the process runs.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnAssignment Description: A copy of a value from one expression to another within a data association.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDataAssociation_uid Description: Autocreated FK slot
--     * Slot: BpmnDataInputAssociation_uid Description: Autocreated FK slot
--     * Slot: BpmnDataOutputAssociation_uid Description: Autocreated FK slot
--     * Slot: from_expression_uid Description: The expression the value is copied from.
--     * Slot: to_expression_uid Description: The expression the value is copied to.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnAssociation Description: A link between an artifact, such as a text annotation, and another element.
--     * Slot: uid
--     * Slot: source_ref Description: The id or QName of the element the connection starts at.
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: association_direction Description: Which ends of the association an arrow is drawn at.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnAuditing Description: A hook for auditing a process or flow element, left to the implementation.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnBaseElement Description: The base of nearly every BPMN element, giving it an id, documentation and extensions.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnBoundaryEvent Description: An event attached to the boundary of an activity, which can interrupt it.
--     * Slot: uid
--     * Slot: cancel_activity Description: Whether the event, when it fires, interrupts the activity it is attached to.
--     * Slot: attached_to_ref Description: The QName of the activity this event is attached to.
--     * Slot: parallel_multiple Description: Whether all of the event's triggers must happen, rather than any one.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: output_set_uid Description: The output set the event's data outputs make up.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnBusinessRuleTask Description: A task that hands data to a business rules engine and receives its result.
--     * Slot: uid
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
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCallActivity Description: An activity that calls a separate process or global task.
--     * Slot: uid
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
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCallConversation Description: A conversation that calls a collaboration or global conversation defined elsewhere.
--     * Slot: uid
--     * Slot: called_collaboration_ref Description: The QName of the collaboration or global conversation this conversation calls.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCallableElement Description: An element another process can call, such as a process.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCancelEventDefinition Description: The trigger of an event that cancels a transaction sub-process.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnCatchEvent Description: An event that waits for a trigger, such as a start or intermediate catch event.
--     * Slot: uid
--     * Slot: parallel_multiple Description: Whether all of the event's triggers must happen, rather than any one.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: output_set_uid Description: The output set the event's data outputs make up.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCategory Description: A named set of category values that groups elements.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCategoryValue Description: One value of a category, which a group shows.
--     * Slot: uid
--     * Slot: value Description: The category value's text.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCategory_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnChildLaneSet Description: The lanes a lane is divided into.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCollaboration Description: The participants of a model and the messages and conversations between them.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: is_closed Description: Whether no interactions occur other than those the model shows.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCompensateEventDefinition Description: The trigger of an event that starts or catches compensation.
--     * Slot: uid
--     * Slot: wait_for_completion Description: Whether the throwing event waits for the compensation to finish.
--     * Slot: activity_ref Description: The id of the activity to compensate; when absent, every compensable activity in scope is.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCompletionCondition Description: The condition that ends a multi-instance activity or an ad-hoc sub-process early.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnComplexBehaviorDefinition Description: A rule of a multi-instance activity that throws an event when its condition holds as instances complete.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnMultiInstanceLoopCharacteristics_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnComplexGateway Description: A gateway that splits or joins flows by conditions of its own.
--     * Slot: uid
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: activation_condition_uid Description: The condition that decides when the gateway may continue.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCondition Description: The expression a conditional event evaluates.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConditionExpression Description: The expression that decides whether a sequence flow is taken.
--     * Slot: uid
--     * Slot: xsi_type Description: The XML Schema type of the expression, a formal expression unless the document says otherwise.
--     * Slot: fluxnova_resource Description: A resource that holds the script of a script condition.
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConditionalEventDefinition Description: The trigger of an event that fires when a condition becomes true.
--     * Slot: uid
--     * Slot: fluxnova_variable_name Description: The variable whose changes make the engine check the condition.
--     * Slot: fluxnova_variable_events Description: The variable events, such as create or update, that make the engine check the condition.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: condition_uid Description: The condition the event waits for.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConversation Description: A set of message flows between participants that belong together.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConversationAssociation Description: A link between a conversation node and one that refines it.
--     * Slot: uid
--     * Slot: inner_conversation_node_ref Description: The QName of the conversation node that refines the outer one.
--     * Slot: outer_conversation_node_ref Description: The QName of the conversation node being refined.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnConversationLink Description: A link between a participant and a conversation node.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: source_ref Description: The id or QName of the element the connection starts at.
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnConversationNode Description: Any node of a conversation diagram, such as a conversation or sub-conversation.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnSubConversation_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationKey Description: A set of correlation properties that together identify a conversation.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCallConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnConversationNode_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnSubConversation_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationProperty Description: A value read from messages that ties them to one conversation.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: type Description: The QName of the property's type.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationPropertyBinding Description: The expression that gives a correlation property its value in a process.
--     * Slot: uid
--     * Slot: correlation_property_ref Description: The QName of the correlation property this binding gives a value.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCorrelationSubscription_uid Description: Autocreated FK slot
--     * Slot: data_path_uid Description: The expression that finds the value in process data.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationPropertyRetrievalExpression Description: The expression that reads a correlation property from one message.
--     * Slot: uid
--     * Slot: message_ref Description: The QName of the message sent or received.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCorrelationProperty_uid Description: Autocreated FK slot
--     * Slot: message_path_uid Description: The expression that finds the value in the message.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnCorrelationSubscription Description: How a process instance subscribes to messages by a correlation key.
--     * Slot: uid
--     * Slot: correlation_key_ref Description: The QName of the correlation key this subscription uses.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataAssociation Description: A copy of data from sources to a target as an activity or event runs.
--     * Slot: uid
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: transformation_uid Description: The expression that changes the data as it is copied.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataInput Description: A piece of data an activity, process or event needs.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnEndEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIoSpecification_uid Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_uid Description: Autocreated FK slot
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataInputAssociation Description: A data association that feeds a data input.
--     * Slot: uid
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_uid Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnEndEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnManualTask_uid Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_uid Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_uid Description: Autocreated FK slot
--     * Slot: BpmnSendTask_uid Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_uid Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnTask_uid Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: BpmnUserTask_uid Description: Autocreated FK slot
--     * Slot: transformation_uid Description: The expression that changes the data as it is copied.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataObject Description: Data a process creates or uses while it runs.
--     * Slot: uid
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataObjectReference Description: A use of a data object at one place in a process.
--     * Slot: uid
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: data_object_ref Description: The id of the data object this reference uses.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataOutput Description: A piece of data an activity, process or event produces.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnBoundaryEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIoSpecification_uid Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_uid Description: Autocreated FK slot
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataOutputAssociation Description: A data association that carries a data output on.
--     * Slot: uid
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnBoundaryEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_uid Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnManualTask_uid Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_uid Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_uid Description: Autocreated FK slot
--     * Slot: BpmnSendTask_uid Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_uid Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnTask_uid Description: Autocreated FK slot
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: BpmnUserTask_uid Description: Autocreated FK slot
--     * Slot: transformation_uid Description: The expression that changes the data as it is copied.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataPath Description: The expression that finds a correlation property's value in process data.
--     * Slot: uid
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataState Description: The state of a data object or data store, such as draft or approved.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataStore Description: Data that lasts beyond one process instance, such as a database.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: capacity Description: How many items the data store can hold.
--     * Slot: is_unlimited Description: Whether the data store's capacity has no limit.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDataStoreReference Description: A use of a data store at one place in a process.
--     * Slot: uid
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: data_store_ref Description: The QName of the data store this reference uses.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnDefinitions Description: The root of a BPMN document, which holds its processes, collaborations and diagrams.
--     * Slot: uid
--     * Slot: id Description: The document's id.
--     * Slot: name Description: The document's name.
--     * Slot: target_namespace Description: The namespace of the elements this document defines.
--     * Slot: expression_language Description: The language the document's expressions are written in unless one says otherwise, as a URI.
--     * Slot: type_language Description: The language the document's types are written in, as a URI.
--     * Slot: exporter Description: The tool that wrote the document.
--     * Slot: exporter_version Description: The version of the tool that wrote the document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: BpmnDocumentation Description: Text that documents an element.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: text_format Description: The format of the text, as a MIME type.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivationCondition_uid Description: Autocreated FK slot
--     * Slot: BpmnActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnArtifact_uid Description: Autocreated FK slot
--     * Slot: BpmnAssignment_uid Description: Autocreated FK slot
--     * Slot: BpmnAssociation_uid Description: Autocreated FK slot
--     * Slot: BpmnAuditing_uid Description: Autocreated FK slot
--     * Slot: BpmnBaseElement_uid Description: Autocreated FK slot
--     * Slot: BpmnBoundaryEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_uid Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnCallConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnCallableElement_uid Description: Autocreated FK slot
--     * Slot: BpmnCancelEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnCategory_uid Description: Autocreated FK slot
--     * Slot: BpmnCategoryValue_uid Description: Autocreated FK slot
--     * Slot: BpmnChildLaneSet_uid Description: Autocreated FK slot
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnCompensateEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnCompletionCondition_uid Description: Autocreated FK slot
--     * Slot: BpmnComplexBehaviorDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnComplexGateway_uid Description: Autocreated FK slot
--     * Slot: BpmnCondition_uid Description: Autocreated FK slot
--     * Slot: BpmnConditionExpression_uid Description: Autocreated FK slot
--     * Slot: BpmnConditionalEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnConversationAssociation_uid Description: Autocreated FK slot
--     * Slot: BpmnConversationLink_uid Description: Autocreated FK slot
--     * Slot: BpmnConversationNode_uid Description: Autocreated FK slot
--     * Slot: BpmnCorrelationKey_uid Description: Autocreated FK slot
--     * Slot: BpmnCorrelationProperty_uid Description: Autocreated FK slot
--     * Slot: BpmnCorrelationPropertyBinding_uid Description: Autocreated FK slot
--     * Slot: BpmnCorrelationPropertyRetrievalExpression_uid Description: Autocreated FK slot
--     * Slot: BpmnCorrelationSubscription_uid Description: Autocreated FK slot
--     * Slot: BpmnDataAssociation_uid Description: Autocreated FK slot
--     * Slot: BpmnDataInput_uid Description: Autocreated FK slot
--     * Slot: BpmnDataInputAssociation_uid Description: Autocreated FK slot
--     * Slot: BpmnDataObject_uid Description: Autocreated FK slot
--     * Slot: BpmnDataObjectReference_uid Description: Autocreated FK slot
--     * Slot: BpmnDataOutput_uid Description: Autocreated FK slot
--     * Slot: BpmnDataOutputAssociation_uid Description: Autocreated FK slot
--     * Slot: BpmnDataPath_uid Description: Autocreated FK slot
--     * Slot: BpmnDataState_uid Description: Autocreated FK slot
--     * Slot: BpmnDataStore_uid Description: Autocreated FK slot
--     * Slot: BpmnDataStoreReference_uid Description: Autocreated FK slot
--     * Slot: BpmnEndEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnEndPoint_uid Description: Autocreated FK slot
--     * Slot: BpmnError_uid Description: Autocreated FK slot
--     * Slot: BpmnErrorEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnEscalation_uid Description: Autocreated FK slot
--     * Slot: BpmnEscalationEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnEventBasedGateway_uid Description: Autocreated FK slot
--     * Slot: BpmnEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnExclusiveGateway_uid Description: Autocreated FK slot
--     * Slot: BpmnExpression_uid Description: Autocreated FK slot
--     * Slot: BpmnExtension_id Description: Autocreated FK slot
--     * Slot: BpmnFlowElement_uid Description: Autocreated FK slot
--     * Slot: BpmnFlowNode_uid Description: Autocreated FK slot
--     * Slot: BpmnFormalExpression_uid Description: Autocreated FK slot
--     * Slot: BpmnFrom_uid Description: Autocreated FK slot
--     * Slot: BpmnGateway_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnGroup_uid Description: Autocreated FK slot
--     * Slot: BpmnHumanPerformer_uid Description: Autocreated FK slot
--     * Slot: BpmnInclusiveGateway_uid Description: Autocreated FK slot
--     * Slot: BpmnInputDataItem_uid Description: Autocreated FK slot
--     * Slot: BpmnInputSet_uid Description: Autocreated FK slot
--     * Slot: BpmnInterface_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIoBinding_uid Description: Autocreated FK slot
--     * Slot: BpmnIoSpecification_uid Description: Autocreated FK slot
--     * Slot: BpmnItemAwareElement_uid Description: Autocreated FK slot
--     * Slot: BpmnItemDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnLane_uid Description: Autocreated FK slot
--     * Slot: BpmnLaneSet_uid Description: Autocreated FK slot
--     * Slot: BpmnLinkEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnLoopCardinality_uid Description: Autocreated FK slot
--     * Slot: BpmnLoopCharacteristics_uid Description: Autocreated FK slot
--     * Slot: BpmnManualTask_uid Description: Autocreated FK slot
--     * Slot: BpmnMessage_uid Description: Autocreated FK slot
--     * Slot: BpmnMessageEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnMessageFlow_uid Description: Autocreated FK slot
--     * Slot: BpmnMessageFlowAssociation_uid Description: Autocreated FK slot
--     * Slot: BpmnMessagePath_uid Description: Autocreated FK slot
--     * Slot: BpmnMonitoring_uid Description: Autocreated FK slot
--     * Slot: BpmnMultiInstanceLoopCharacteristics_uid Description: Autocreated FK slot
--     * Slot: BpmnOperation_uid Description: Autocreated FK slot
--     * Slot: BpmnOutputDataItem_uid Description: Autocreated FK slot
--     * Slot: BpmnOutputSet_uid Description: Autocreated FK slot
--     * Slot: BpmnParallelGateway_uid Description: Autocreated FK slot
--     * Slot: BpmnParticipant_uid Description: Autocreated FK slot
--     * Slot: BpmnParticipantAssociation_uid Description: Autocreated FK slot
--     * Slot: BpmnParticipantMultiplicity_uid Description: Autocreated FK slot
--     * Slot: BpmnPartitionElement_uid Description: Autocreated FK slot
--     * Slot: BpmnPerformer_uid Description: Autocreated FK slot
--     * Slot: BpmnPotentialOwner_uid Description: Autocreated FK slot
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnProperty_uid Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_uid Description: Autocreated FK slot
--     * Slot: BpmnRelationship_uid Description: Autocreated FK slot
--     * Slot: BpmnRendering_uid Description: Autocreated FK slot
--     * Slot: BpmnResource_uid Description: Autocreated FK slot
--     * Slot: BpmnResourceAssignmentExpression_uid Description: Autocreated FK slot
--     * Slot: BpmnResourceParameter_uid Description: Autocreated FK slot
--     * Slot: BpmnResourceParameterBinding_uid Description: Autocreated FK slot
--     * Slot: BpmnResourceRole_uid Description: Autocreated FK slot
--     * Slot: BpmnRootElement_uid Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_uid Description: Autocreated FK slot
--     * Slot: BpmnSendTask_uid Description: Autocreated FK slot
--     * Slot: BpmnSequenceFlow_uid Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_uid Description: Autocreated FK slot
--     * Slot: BpmnSignal_uid Description: Autocreated FK slot
--     * Slot: BpmnSignalEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnSubConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnTask_uid Description: Autocreated FK slot
--     * Slot: BpmnTerminateEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnTextAnnotation_uid Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnTimeCycle_uid Description: Autocreated FK slot
--     * Slot: BpmnTimeDate_uid Description: Autocreated FK slot
--     * Slot: BpmnTimeDuration_uid Description: Autocreated FK slot
--     * Slot: BpmnTimerEventDefinition_uid Description: Autocreated FK slot
--     * Slot: BpmnTo_uid Description: Autocreated FK slot
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: BpmnTransformation_uid Description: Autocreated FK slot
--     * Slot: BpmnUserTask_uid Description: Autocreated FK slot
-- # Class: BpmnEndEvent Description: An event that ends a path of a process.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: input_set_uid Description: The input set the event's data inputs make up.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnEndPoint Description: A place where a participant can be reached for messages.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnError Description: An error that an activity can throw and an event can catch.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: error_code Description: The code that identifies the error.
--     * Slot: fluxnova_error_message Description: The message of the error.
--     * Slot: structure_ref Description: The QName of the type of the data, such as an XML Schema type.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnErrorEventDefinition Description: The trigger of an event that throws or catches an error.
--     * Slot: uid
--     * Slot: error_ref Description: The QName of the error thrown or caught.
--     * Slot: fluxnova_error_code_variable Description: The variable the caught error's code is stored in.
--     * Slot: fluxnova_error_message_variable Description: The variable the caught error's message is stored in.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnEscalation Description: An escalation that an activity can throw and an event can catch.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: escalation_code Description: The code that identifies the escalation.
--     * Slot: structure_ref Description: The QName of the type of the data, such as an XML Schema type.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnEscalationEventDefinition Description: The trigger of an event that throws or catches an escalation.
--     * Slot: uid
--     * Slot: escalation_ref Description: The QName of the escalation thrown or caught.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnEvent Description: Something that happens while a process runs, such as a start, a message or a timer.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnEventBasedGateway Description: A gateway that takes the path of whichever following event happens first.
--     * Slot: uid
--     * Slot: instantiate Description: Whether the element starts a new process instance.
--     * Slot: event_gateway_type Description: Whether the gateway starts one process instance for the first event or waits for all of them.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnEventDefinition Description: What triggers an event, such as a message, timer or signal.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnBoundaryEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnEndEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnExclusiveGateway Description: A gateway that takes exactly one of its outgoing flows.
--     * Slot: uid
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnExpression Description: An expression whose language and body the model leaves open.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnExtension Description: A declaration that a document uses an extension, by its definition.
--     * Slot: id
--     * Slot: definition Description: The QName of the extension's definition.
--     * Slot: must_understand Description: Whether a tool reading the document must understand the extension.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_uid Description: Autocreated FK slot
-- # Class: BpmnExtensionElements Description: The container for an element's extension content, such as Fluxnova's settings.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Abstract Class: BpmnFlowElement Description: An element that takes part in the flow of a process, such as an activity or sequence flow.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnFlowNode Description: A flow element that sequence flows connect, such as an activity, event or gateway.
--     * Slot: uid
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnFormalExpression Description: An expression in a stated language, with the type it evaluates to.
--     * Slot: uid
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnFrom Description: The expression an assignment copies a value from.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnGateway Description: A point where a process's flows split or join.
--     * Slot: uid
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnGlobalConversation Description: A conversation defined on its own so that collaborations can call it.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: is_closed Description: Whether no interactions occur other than those the model shows.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnGroup Description: An artifact that draws a box around elements of one category value.
--     * Slot: uid
--     * Slot: category_value_ref Description: The QName of the category value this group shows.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnHumanPerformer Description: The person who performs an activity.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: resource_ref Description: The QName of the resource that plays the role.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: resource_assignment_expression_uid Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnImport Description: A document the definitions import elements from.
--     * Slot: id
--     * Slot: namespace Description: The namespace of the imported document.
--     * Slot: location Description: Where the imported document is.
--     * Slot: import_type Description: The kind of document imported, as the URI of its language.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_uid Description: Autocreated FK slot
-- # Class: BpmnInclusiveGateway Description: A gateway that takes every outgoing flow whose condition holds.
--     * Slot: uid
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnInputDataItem Description: The data input each instance of a multi-instance activity receives.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnInputSet Description: A set of data inputs that is enough for an activity or event to start.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnIoSpecification_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnInteractionNode Description: An element a message flow or conversation link can connect, such as a participant, task or event.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
-- # Class: BpmnInterface Description: A set of operations a participant offers.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: implementation_ref Description: The QName of what implements the element.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnIntermediateCatchEvent Description: An event on a process's path that waits for a trigger.
--     * Slot: uid
--     * Slot: parallel_multiple Description: Whether all of the event's triggers must happen, rather than any one.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: output_set_uid Description: The output set the event's data outputs make up.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnIntermediateThrowEvent Description: An event on a process's path that throws a trigger.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: input_set_uid Description: The input set the event's data inputs make up.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnIoBinding Description: A link between an operation's messages and a callable element's input and output sets.
--     * Slot: uid
--     * Slot: operation_ref Description: The QName of the operation the element calls or implements.
--     * Slot: input_data_ref Description: The id of the input set the binding uses.
--     * Slot: output_data_ref Description: The id of the output set the binding uses.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCallableElement_uid Description: Autocreated FK slot
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnIoSpecification Description: The data inputs and outputs of an activity or process, and their sets.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnItemAwareElement Description: An element that holds data of an item definition, such as a data object or data input.
--     * Slot: uid
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnItemDefinition Description: The type of data an element holds or a message carries.
--     * Slot: uid
--     * Slot: structure_ref Description: The QName of the type of the data, such as an XML Schema type.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_kind Description: Whether the item is information or a physical thing.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnLane Description: A partition of a process that groups flow nodes, often by who performs them.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: partition_element_ref Description: The QName of the element the lane stands for.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnChildLaneSet_uid Description: Autocreated FK slot
--     * Slot: BpmnLaneSet_uid Description: Autocreated FK slot
--     * Slot: partition_element_uid Description: The element the lane stands for.
--     * Slot: child_lane_set_uid Description: The lanes this lane is divided into.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnLaneSet Description: The lanes that divide a process or sub-process.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnLinkEventDefinition Description: The trigger of a pair of events that join two paths of a process like a jump.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: target Description: The QName of the catching link event this one jumps to.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnLoopCardinality Description: The expression that says how many instances a multi-instance activity creates.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnLoopCharacteristics Description: How an activity repeats.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnManualTask Description: A task done by a person without any system's help.
--     * Slot: uid
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessage Description: What one participant sends another.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: item_ref Description: The QName of the item definition the message carries.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessageEventDefinition Description: The trigger of an event that sends or receives a message.
--     * Slot: uid
--     * Slot: message_ref Description: The QName of the message sent or received.
--     * Slot: fluxnova_class Description: The Java class the engine instantiates to run the element.
--     * Slot: fluxnova_delegate_expression Description: An expression that gives the delegate object the engine calls.
--     * Slot: fluxnova_expression Description: An expression the engine evaluates to run the element.
--     * Slot: fluxnova_result_variable Description: The variable the result is stored in.
--     * Slot: fluxnova_topic Description: The topic of the external task the element creates.
--     * Slot: fluxnova_type Description: The element's type, such as external for an external task or the form field's value type.
--     * Slot: fluxnova_task_priority Description: The priority of the external tasks the element creates.
--     * Slot: operation_ref Description: The QName of the operation the element calls or implements.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessageFlow Description: The path of a message between two participants.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: source_ref Description: The id or QName of the element the connection starts at.
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: message_ref Description: The QName of the message sent or received.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessageFlowAssociation Description: A link between a message flow and one that refines it.
--     * Slot: uid
--     * Slot: inner_message_flow_ref Description: The QName of the message flow that refines the outer one.
--     * Slot: outer_message_flow_ref Description: The QName of the message flow being refined.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMessagePath Description: The expression that finds a correlation property's value in a message.
--     * Slot: uid
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMonitoring Description: A hook for monitoring a process or flow element, left to the implementation.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnMultiInstanceLoopCharacteristics Description: How an activity runs once for each item of a collection, in sequence or in parallel.
--     * Slot: uid
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
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: loop_cardinality_uid Description: How many instances to create.
--     * Slot: output_data_item_uid Description: The data output of each instance.
--     * Slot: input_data_item_uid Description: The data input of each instance.
--     * Slot: completion_condition_uid Description: The condition that ends the activity early when it holds.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnOperation Description: An operation of an interface, with the messages it takes and returns.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: implementation_ref Description: The QName of what implements the element.
--     * Slot: in_message_ref Description: The QName of the message the operation takes.
--     * Slot: out_message_ref Description: The QName of the message the operation returns.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnInterface_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnOutputDataItem Description: The data output each instance of a multi-instance activity produces.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: is_collection Description: Whether the element holds a collection of items.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnOutputSet Description: A set of data outputs an activity or event produces together.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnIoSpecification_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnParallelGateway Description: A gateway that takes all its outgoing flows, or waits for all its incoming ones.
--     * Slot: uid
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: gateway_direction Description: Whether the gateway splits flows, joins them, does both, or is not said.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnParticipant Description: A party in a collaboration, usually drawn as a pool, and the process it runs.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: process_ref Description: The QName of the process the participant runs.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: participant_multiplicity_uid Description: How many instances of the participant take part.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnParticipantAssociation Description: A link between a participant and one that a called collaboration defines.
--     * Slot: uid
--     * Slot: inner_participant_ref Description: The QName of the participant inside the called collaboration.
--     * Slot: outer_participant_ref Description: The QName of the participant in the calling collaboration.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnCallConversation_uid Description: Autocreated FK slot
--     * Slot: BpmnCollaboration_uid Description: Autocreated FK slot
--     * Slot: BpmnGlobalConversation_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnParticipantMultiplicity Description: How many instances of a participant take part, from a minimum to a maximum.
--     * Slot: uid
--     * Slot: minimum Description: The fewest instances that take part.
--     * Slot: maximum Description: The most instances that take part.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnPartitionElement Description: The element a lane stands for, such as a performer.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnPerformer Description: The resource that performs an activity.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: resource_ref Description: The QName of the resource that plays the role.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: resource_assignment_expression_uid Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnPotentialOwner Description: A person who may claim and perform a user task.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: resource_ref Description: The QName of the resource that plays the role.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: resource_assignment_expression_uid Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnProcess Description: A sequence of activities, events and gateways that a participant performs.
--     * Slot: uid
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
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnProperty Description: A variable of a process, activity or event.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: item_subject_ref Description: The QName of the item definition of the data.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnBoundaryEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_uid Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnEndEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateCatchEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnIntermediateThrowEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnManualTask_uid Description: Autocreated FK slot
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_uid Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_uid Description: Autocreated FK slot
--     * Slot: BpmnSendTask_uid Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_uid Description: Autocreated FK slot
--     * Slot: BpmnStartEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnTask_uid Description: Autocreated FK slot
--     * Slot: BpmnThrowEvent_uid Description: Autocreated FK slot
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: BpmnUserTask_uid Description: Autocreated FK slot
--     * Slot: data_state_uid Description: The state the data is in.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnReceiveTask Description: A task that waits for a message.
--     * Slot: uid
--     * Slot: implementation Description: The technology that runs the task, as a URI; the engine reads its own settings instead.
--     * Slot: instantiate Description: Whether the element starts a new process instance.
--     * Slot: message_ref Description: The QName of the message sent or received.
--     * Slot: operation_ref Description: The QName of the operation the element calls or implements.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnRelationship Description: An informal link between elements of different models.
--     * Slot: uid
--     * Slot: type Description: What kind of relationship it is.
--     * Slot: direction Description: Which way the relationship points.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnRendering Description: A hint for how a user task appears to the person who performs it.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnUserTask_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResource Description: A resource, such as a person or role, that can perform activities.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResourceAssignmentExpression Description: The expression that chooses who performs an activity.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: expression_uid Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResourceParameter Description: A parameter that narrows which resources a resource stands for.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: type Description: The QName of the parameter's type.
--     * Slot: is_required Description: Whether the parameter must be given a value.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnResource_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResourceParameterBinding Description: The value a resource role gives a resource parameter.
--     * Slot: uid
--     * Slot: parameter_ref Description: The QName of the parameter given a value.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnHumanPerformer_uid Description: Autocreated FK slot
--     * Slot: BpmnPerformer_uid Description: Autocreated FK slot
--     * Slot: BpmnPotentialOwner_uid Description: Autocreated FK slot
--     * Slot: BpmnResourceRole_uid Description: Autocreated FK slot
--     * Slot: expression_uid Description: The expression that gives the parameter its value.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnResourceRole Description: The role a resource plays in an activity or process.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: resource_ref Description: The QName of the resource that plays the role.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnBusinessRuleTask_uid Description: Autocreated FK slot
--     * Slot: BpmnCallActivity_uid Description: Autocreated FK slot
--     * Slot: BpmnManualTask_uid Description: Autocreated FK slot
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnReceiveTask_uid Description: Autocreated FK slot
--     * Slot: BpmnScriptTask_uid Description: Autocreated FK slot
--     * Slot: BpmnSendTask_uid Description: Autocreated FK slot
--     * Slot: BpmnServiceTask_uid Description: Autocreated FK slot
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: BpmnTask_uid Description: Autocreated FK slot
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: BpmnUserTask_uid Description: Autocreated FK slot
--     * Slot: resource_assignment_expression_uid Description: The expression that chooses the resource.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnRootElement Description: An element that can sit directly in a document's definitions, such as a process or message.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnDefinitions_uid Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnScript Description: The body of a script task's script.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: BpmnScriptTask Description: A task that runs a script.
--     * Slot: uid
--     * Slot: script_format Description: The language the script is written in, such as groovy or javascript.
--     * Slot: fluxnova_result_variable Description: The variable the result is stored in.
--     * Slot: fluxnova_resource Description: A resource that holds the script, instead of the script's text.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: script_id Description: The script the task runs.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSendTask Description: A task that sends a message.
--     * Slot: uid
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
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSequenceFlow Description: The order of two flow nodes in a process, from a source to a target.
--     * Slot: uid
--     * Slot: source_ref Description: The id or QName of the element the connection starts at.
--     * Slot: target_ref Description: The id or QName of the element the connection ends at.
--     * Slot: is_immediate Description: Whether the flow's target follows its source with no other activity between them.
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: condition_expression_uid Description: The condition that decides whether the flow is taken.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnServiceTask Description: A task that calls a service, such as a web service or application code.
--     * Slot: uid
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
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSignal Description: A signal that is broadcast to every event waiting for it.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: structure_ref Description: The QName of the type of the data, such as an XML Schema type.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSignalEventDefinition Description: The trigger of an event that sends or receives a signal.
--     * Slot: uid
--     * Slot: signal_ref Description: The QName of the signal sent or received.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSource Description: An element a relationship starts from.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnRelationship_uid Description: Autocreated FK slot
-- # Class: BpmnStartEvent Description: An event that starts a process or sub-process.
--     * Slot: uid
--     * Slot: is_interrupting Description: Whether the event, when it starts an event sub-process, interrupts its parent.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: fluxnova_form_handler_class Description: The Java class that handles the form.
--     * Slot: fluxnova_form_key Description: The key of the form to show.
--     * Slot: fluxnova_form_ref Description: The key of the deployed form to show.
--     * Slot: fluxnova_form_ref_binding Description: Which version of the deployed form to use.
--     * Slot: fluxnova_form_ref_version Description: The version of the deployed form, when the binding asks for one.
--     * Slot: fluxnova_initiator Description: The variable the id of the user who started the process is stored in.
--     * Slot: parallel_multiple Description: Whether all of the event's triggers must happen, rather than any one.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: output_set_uid Description: The output set the event's data outputs make up.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSubConversation Description: A conversation node that groups other conversation nodes.
--     * Slot: uid
--     * Slot: name Description: The element's name.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnSubProcess Description: An activity that holds a process of its own.
--     * Slot: uid
--     * Slot: triggered_by_event Description: Whether the sub-process is an event sub-process, started by an event.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTarget Description: An element a relationship leads to.
--     * Slot: id
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: BpmnRelationship_uid Description: Autocreated FK slot
-- # Class: BpmnTask Description: An atomic activity, one that is not broken down further.
--     * Slot: uid
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTerminateEventDefinition Description: The trigger of an end event that ends the whole process instance at once.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnText Description: The text of a text annotation.
--     * Slot: id
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
-- # Class: BpmnTextAnnotation Description: An artifact that adds a note to a diagram.
--     * Slot: uid
--     * Slot: text_format Description: The format of the text, as a MIME type.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: text_id Description: The annotation's text.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Abstract Class: BpmnThrowEvent Description: An event that throws a trigger, such as an end or intermediate throw event.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: input_set_uid Description: The input set the event's data inputs make up.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTimeCycle Description: The expression for a timer that fires repeatedly.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTimeDate Description: The expression for a timer that fires at a point in time.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTimeDuration Description: The expression for a timer that fires once a duration has passed.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTimerEventDefinition Description: The trigger of an event that fires at a time, after a duration or on a cycle.
--     * Slot: uid
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: time_date_uid Description: The timer's point in time.
--     * Slot: time_duration_uid Description: The timer's duration.
--     * Slot: time_cycle_uid Description: The timer's cycle.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTo Description: The expression an assignment copies a value to.
--     * Slot: uid
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTransaction Description: A sub-process whose activities succeed or are undone together.
--     * Slot: uid
--     * Slot: method Description: How the transaction commits or cancels; compensation unless the document says otherwise.
--     * Slot: triggered_by_event Description: Whether the sub-process is an event sub-process, started by an event.
--     * Slot: fluxnova_async Description: Whether the engine continues asynchronously before the element; superseded by asyncBefore.
--     * Slot: is_for_compensation Description: Whether the activity runs only to compensate another.
--     * Slot: start_quantity Description: How many tokens must arrive before the activity starts.
--     * Slot: completion_quantity Description: How many tokens the activity sends on when it completes.
--     * Slot: default Description: The id of the sequence flow taken when no other outgoing flow's condition holds.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnTransformation Description: The expression that changes data as a data association copies it.
--     * Slot: uid
--     * Slot: language Description: The language the expression is written in, as a URI.
--     * Slot: evaluates_to_type_ref Description: The QName of the item definition the expression's result has.
--     * Slot: text_content Description: The element's text, such as the body of an expression or a script.
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: extension_elements_id Description: The element's extension content, such as Fluxnova's settings.
-- # Class: BpmnUserTask Description: A task a person performs with the help of a software application.
--     * Slot: uid
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
--     * Slot: id Description: The element's id, unique within its document.
--     * Slot: fluxnova_async_after Description: Whether the engine commits and continues asynchronously after the element.
--     * Slot: fluxnova_async_before Description: Whether the engine commits and continues asynchronously before the element.
--     * Slot: fluxnova_exclusive Description: Whether the element's jobs run one at a time within a process instance.
--     * Slot: fluxnova_job_priority Description: The priority of the element's jobs.
--     * Slot: name Description: The element's name.
--     * Slot: element_type Description: The name of the class an element is, which says which element it is when a slot's range admits several.
--     * Slot: io_specification_uid Description: The element's data inputs and outputs.
--     * Slot: loop_characteristics_uid Description: How the activity repeats.
--     * Slot: auditing_uid Description: The element's auditing hook.
--     * Slot: monitoring_uid Description: The element's monitoring hook.
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
--     * Slot: resource_assignment_expression_uid Description: The expression that chooses the resource.
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
--     * Slot: resource Description: A resource that holds the script, instead of the script's text.
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
--     * Slot: timer_event_definition_uid Description: The timer of a listener that runs on a timeout.
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
--     * Slot: BpmnActivity_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnActivity_outgoing
--     * Slot: BpmnActivity_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnActivity_category_value_refs
--     * Slot: BpmnActivity_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnAdHocSubProcess_incoming
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnAdHocSubProcess_outgoing
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnAdHocSubProcess_category_value_refs
--     * Slot: BpmnAdHocSubProcess_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnBoundaryEvent_event_definition_refs
--     * Slot: BpmnBoundaryEvent_uid Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnBoundaryEvent_incoming
--     * Slot: BpmnBoundaryEvent_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnBoundaryEvent_outgoing
--     * Slot: BpmnBoundaryEvent_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnBoundaryEvent_category_value_refs
--     * Slot: BpmnBoundaryEvent_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnBusinessRuleTask_incoming
--     * Slot: BpmnBusinessRuleTask_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnBusinessRuleTask_outgoing
--     * Slot: BpmnBusinessRuleTask_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnBusinessRuleTask_category_value_refs
--     * Slot: BpmnBusinessRuleTask_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnCallActivity_incoming
--     * Slot: BpmnCallActivity_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnCallActivity_outgoing
--     * Slot: BpmnCallActivity_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnCallActivity_category_value_refs
--     * Slot: BpmnCallActivity_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnCallConversation_participant_refs
--     * Slot: BpmnCallConversation_uid Description: Autocreated FK slot
--     * Slot: participant_refs Description: The QNames of the participants in the conversation.
-- # Class: BpmnCallConversation_message_flow_refs
--     * Slot: BpmnCallConversation_uid Description: Autocreated FK slot
--     * Slot: message_flow_refs Description: The QNames of the message flows the conversation node groups.
-- # Class: BpmnCallableElement_supported_interface_refs
--     * Slot: BpmnCallableElement_uid Description: Autocreated FK slot
--     * Slot: supported_interface_refs Description: The QNames of the interfaces the element supports.
-- # Class: BpmnCatchEvent_event_definition_refs
--     * Slot: BpmnCatchEvent_uid Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnCatchEvent_incoming
--     * Slot: BpmnCatchEvent_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnCatchEvent_outgoing
--     * Slot: BpmnCatchEvent_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnCatchEvent_category_value_refs
--     * Slot: BpmnCatchEvent_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnComplexGateway_incoming
--     * Slot: BpmnComplexGateway_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnComplexGateway_outgoing
--     * Slot: BpmnComplexGateway_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnComplexGateway_category_value_refs
--     * Slot: BpmnComplexGateway_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnConversation_participant_refs
--     * Slot: BpmnConversation_uid Description: Autocreated FK slot
--     * Slot: participant_refs Description: The QNames of the participants in the conversation.
-- # Class: BpmnConversation_message_flow_refs
--     * Slot: BpmnConversation_uid Description: Autocreated FK slot
--     * Slot: message_flow_refs Description: The QNames of the message flows the conversation node groups.
-- # Class: BpmnConversationNode_participant_refs
--     * Slot: BpmnConversationNode_uid Description: Autocreated FK slot
--     * Slot: participant_refs Description: The QNames of the participants in the conversation.
-- # Class: BpmnConversationNode_message_flow_refs
--     * Slot: BpmnConversationNode_uid Description: Autocreated FK slot
--     * Slot: message_flow_refs Description: The QNames of the message flows the conversation node groups.
-- # Class: BpmnCorrelationKey_correlation_property_refs
--     * Slot: BpmnCorrelationKey_uid Description: Autocreated FK slot
--     * Slot: correlation_property_refs Description: The QNames of the correlation properties that make up this key.
-- # Class: BpmnDataAssociation_source_refs
--     * Slot: BpmnDataAssociation_uid Description: Autocreated FK slot
--     * Slot: source_refs Description: The ids of the data the association copies from.
-- # Class: BpmnDataInputAssociation_source_refs
--     * Slot: BpmnDataInputAssociation_uid Description: Autocreated FK slot
--     * Slot: source_refs Description: The ids of the data the association copies from.
-- # Class: BpmnDataObject_category_value_refs
--     * Slot: BpmnDataObject_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnDataObjectReference_category_value_refs
--     * Slot: BpmnDataObjectReference_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnDataOutputAssociation_source_refs
--     * Slot: BpmnDataOutputAssociation_uid Description: Autocreated FK slot
--     * Slot: source_refs Description: The ids of the data the association copies from.
-- # Class: BpmnDataStoreReference_category_value_refs
--     * Slot: BpmnDataStoreReference_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnEndEvent_event_definition_refs
--     * Slot: BpmnEndEvent_uid Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnEndEvent_incoming
--     * Slot: BpmnEndEvent_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnEndEvent_outgoing
--     * Slot: BpmnEndEvent_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnEndEvent_category_value_refs
--     * Slot: BpmnEndEvent_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnEvent_incoming
--     * Slot: BpmnEvent_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnEvent_outgoing
--     * Slot: BpmnEvent_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnEvent_category_value_refs
--     * Slot: BpmnEvent_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnEventBasedGateway_incoming
--     * Slot: BpmnEventBasedGateway_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnEventBasedGateway_outgoing
--     * Slot: BpmnEventBasedGateway_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnEventBasedGateway_category_value_refs
--     * Slot: BpmnEventBasedGateway_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnExclusiveGateway_incoming
--     * Slot: BpmnExclusiveGateway_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnExclusiveGateway_outgoing
--     * Slot: BpmnExclusiveGateway_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnExclusiveGateway_category_value_refs
--     * Slot: BpmnExclusiveGateway_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnFlowElement_category_value_refs
--     * Slot: BpmnFlowElement_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnFlowNode_incoming
--     * Slot: BpmnFlowNode_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnFlowNode_outgoing
--     * Slot: BpmnFlowNode_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnFlowNode_category_value_refs
--     * Slot: BpmnFlowNode_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnGateway_incoming
--     * Slot: BpmnGateway_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnGateway_outgoing
--     * Slot: BpmnGateway_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnGateway_category_value_refs
--     * Slot: BpmnGateway_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnInclusiveGateway_incoming
--     * Slot: BpmnInclusiveGateway_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnInclusiveGateway_outgoing
--     * Slot: BpmnInclusiveGateway_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnInclusiveGateway_category_value_refs
--     * Slot: BpmnInclusiveGateway_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnInputSet_data_input_refs
--     * Slot: BpmnInputSet_uid Description: Autocreated FK slot
--     * Slot: data_input_refs Description: The ids of the data inputs this set holds.
-- # Class: BpmnInputSet_optional_input_refs
--     * Slot: BpmnInputSet_uid Description: Autocreated FK slot
--     * Slot: optional_input_refs Description: The ids of inputs the set may do without.
-- # Class: BpmnInputSet_while_executing_input_refs
--     * Slot: BpmnInputSet_uid Description: Autocreated FK slot
--     * Slot: while_executing_input_refs Description: The ids of inputs the element can take while it runs.
-- # Class: BpmnInputSet_output_set_refs
--     * Slot: BpmnInputSet_uid Description: Autocreated FK slot
--     * Slot: output_set_refs Description: The ids of the output sets this input set can lead to.
-- # Class: BpmnIntermediateCatchEvent_event_definition_refs
--     * Slot: BpmnIntermediateCatchEvent_uid Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnIntermediateCatchEvent_incoming
--     * Slot: BpmnIntermediateCatchEvent_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnIntermediateCatchEvent_outgoing
--     * Slot: BpmnIntermediateCatchEvent_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnIntermediateCatchEvent_category_value_refs
--     * Slot: BpmnIntermediateCatchEvent_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnIntermediateThrowEvent_event_definition_refs
--     * Slot: BpmnIntermediateThrowEvent_uid Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnIntermediateThrowEvent_incoming
--     * Slot: BpmnIntermediateThrowEvent_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnIntermediateThrowEvent_outgoing
--     * Slot: BpmnIntermediateThrowEvent_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnIntermediateThrowEvent_category_value_refs
--     * Slot: BpmnIntermediateThrowEvent_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnLane_flow_node_refs
--     * Slot: BpmnLane_uid Description: Autocreated FK slot
--     * Slot: flow_node_refs Description: The ids of the flow nodes in this lane.
-- # Class: BpmnLinkEventDefinition_sources
--     * Slot: BpmnLinkEventDefinition_uid Description: Autocreated FK slot
--     * Slot: sources Description: The QNames of the throwing link events that jump to this one.
-- # Class: BpmnManualTask_incoming
--     * Slot: BpmnManualTask_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnManualTask_outgoing
--     * Slot: BpmnManualTask_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnManualTask_category_value_refs
--     * Slot: BpmnManualTask_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnOperation_error_refs
--     * Slot: BpmnOperation_uid Description: Autocreated FK slot
--     * Slot: error_refs Description: The QNames of the errors the operation can raise.
-- # Class: BpmnOutputSet_data_output_refs
--     * Slot: BpmnOutputSet_uid Description: Autocreated FK slot
--     * Slot: data_output_refs Description: The ids of the data outputs this set holds.
-- # Class: BpmnOutputSet_optional_output_refs
--     * Slot: BpmnOutputSet_uid Description: Autocreated FK slot
--     * Slot: optional_output_refs Description: The ids of outputs the set may leave out.
-- # Class: BpmnOutputSet_while_executing_output_refs
--     * Slot: BpmnOutputSet_uid Description: Autocreated FK slot
--     * Slot: while_executing_output_refs Description: The ids of outputs the element can produce while it runs.
-- # Class: BpmnOutputSet_input_set_refs
--     * Slot: BpmnOutputSet_uid Description: Autocreated FK slot
--     * Slot: input_set_refs Description: The ids of the input sets this output set can be produced from.
-- # Class: BpmnParallelGateway_incoming
--     * Slot: BpmnParallelGateway_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnParallelGateway_outgoing
--     * Slot: BpmnParallelGateway_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnParallelGateway_category_value_refs
--     * Slot: BpmnParallelGateway_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnParticipant_interface_refs
--     * Slot: BpmnParticipant_uid Description: Autocreated FK slot
--     * Slot: interface_refs Description: The QNames of the interfaces the participant offers.
-- # Class: BpmnParticipant_end_point_refs
--     * Slot: BpmnParticipant_uid Description: Autocreated FK slot
--     * Slot: end_point_refs Description: The QNames of the end points where the participant can be reached.
-- # Class: BpmnProcess_supports
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: supports Description: The QNames of the processes this one supports.
-- # Class: BpmnProcess_supported_interface_refs
--     * Slot: BpmnProcess_uid Description: Autocreated FK slot
--     * Slot: supported_interface_refs Description: The QNames of the interfaces the element supports.
-- # Class: BpmnReceiveTask_incoming
--     * Slot: BpmnReceiveTask_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnReceiveTask_outgoing
--     * Slot: BpmnReceiveTask_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnReceiveTask_category_value_refs
--     * Slot: BpmnReceiveTask_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnScriptTask_incoming
--     * Slot: BpmnScriptTask_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnScriptTask_outgoing
--     * Slot: BpmnScriptTask_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnScriptTask_category_value_refs
--     * Slot: BpmnScriptTask_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnSendTask_incoming
--     * Slot: BpmnSendTask_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnSendTask_outgoing
--     * Slot: BpmnSendTask_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnSendTask_category_value_refs
--     * Slot: BpmnSendTask_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnSequenceFlow_category_value_refs
--     * Slot: BpmnSequenceFlow_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnServiceTask_incoming
--     * Slot: BpmnServiceTask_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnServiceTask_outgoing
--     * Slot: BpmnServiceTask_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnServiceTask_category_value_refs
--     * Slot: BpmnServiceTask_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnStartEvent_event_definition_refs
--     * Slot: BpmnStartEvent_uid Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnStartEvent_incoming
--     * Slot: BpmnStartEvent_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnStartEvent_outgoing
--     * Slot: BpmnStartEvent_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnStartEvent_category_value_refs
--     * Slot: BpmnStartEvent_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnSubConversation_participant_refs
--     * Slot: BpmnSubConversation_uid Description: Autocreated FK slot
--     * Slot: participant_refs Description: The QNames of the participants in the conversation.
-- # Class: BpmnSubConversation_message_flow_refs
--     * Slot: BpmnSubConversation_uid Description: Autocreated FK slot
--     * Slot: message_flow_refs Description: The QNames of the message flows the conversation node groups.
-- # Class: BpmnSubProcess_incoming
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnSubProcess_outgoing
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnSubProcess_category_value_refs
--     * Slot: BpmnSubProcess_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnTask_incoming
--     * Slot: BpmnTask_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnTask_outgoing
--     * Slot: BpmnTask_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnTask_category_value_refs
--     * Slot: BpmnTask_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnThrowEvent_event_definition_refs
--     * Slot: BpmnThrowEvent_uid Description: Autocreated FK slot
--     * Slot: event_definition_refs Description: The QNames of event definitions, defined elsewhere in the document, that trigger this event.
-- # Class: BpmnThrowEvent_incoming
--     * Slot: BpmnThrowEvent_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnThrowEvent_outgoing
--     * Slot: BpmnThrowEvent_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnThrowEvent_category_value_refs
--     * Slot: BpmnThrowEvent_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnTransaction_incoming
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnTransaction_outgoing
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnTransaction_category_value_refs
--     * Slot: BpmnTransaction_uid Description: Autocreated FK slot
--     * Slot: category_value_refs Description: The QNames of the category values this element belongs to.
-- # Class: BpmnUserTask_incoming
--     * Slot: BpmnUserTask_uid Description: Autocreated FK slot
--     * Slot: incoming Description: The QNames of the sequence flows that enter this node.
-- # Class: BpmnUserTask_outgoing
--     * Slot: BpmnUserTask_uid Description: Autocreated FK slot
--     * Slot: outgoing Description: The QNames of the sequence flows that leave this node.
-- # Class: BpmnUserTask_category_value_refs
--     * Slot: BpmnUserTask_uid Description: Autocreated FK slot
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
	uid INTEGER NOT NULL,
	name TEXT,
	documentation TEXT,
	resolution FLOAT,
	id TEXT,
	element_type TEXT,
	PRIMARY KEY (uid)
);
CREATE INDEX "ix_DiDiagram_uid" ON "DiDiagram" (uid);

CREATE TABLE "DiExtension" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_DiExtension_id" ON "DiExtension" (id);

CREATE TABLE "DiStyle" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	PRIMARY KEY (uid)
);
CREATE INDEX "ix_DiStyle_uid" ON "DiStyle" (uid);

CREATE TABLE "BpmnDefinitions" (
	uid INTEGER NOT NULL,
	id TEXT,
	name TEXT,
	target_namespace TEXT NOT NULL,
	expression_language TEXT,
	type_language TEXT,
	exporter TEXT,
	exporter_version TEXT,
	element_type TEXT,
	PRIMARY KEY (uid)
);
CREATE INDEX "ix_BpmnDefinitions_uid" ON "BpmnDefinitions" (uid);

CREATE TABLE "BpmnExtensionElements" (
	id INTEGER NOT NULL,
	element_type TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_BpmnExtensionElements_id" ON "BpmnExtensionElements" (id);

CREATE TABLE "BpmnInteractionNode" (
	uid INTEGER NOT NULL,
	id TEXT,
	PRIMARY KEY (uid)
);
CREATE INDEX "ix_BpmnInteractionNode_uid" ON "BpmnInteractionNode" (uid);

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
	resource TEXT,
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
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiEdge_uid" ON "DiEdge" (uid);

CREATE TABLE "DiLabel" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	bounds_id INTEGER,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiLabel_uid" ON "DiLabel" (uid);

CREATE TABLE "DiLabeledEdge" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiLabeledEdge_uid" ON "DiLabeledEdge" (uid);

CREATE TABLE "DiLabeledShape" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	bounds_id INTEGER NOT NULL,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiLabeledShape_uid" ON "DiLabeledShape" (uid);

CREATE TABLE "DiNode" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiNode_uid" ON "DiNode" (uid);

CREATE TABLE "DiPlane" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiPlane_uid" ON "DiPlane" (uid);

CREATE TABLE "DiShape" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	bounds_id INTEGER NOT NULL,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiShape_uid" ON "DiShape" (uid);

CREATE TABLE "BpmnLabel" (
	uid INTEGER NOT NULL,
	label_style TEXT,
	id TEXT,
	element_type TEXT,
	bounds_id INTEGER,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_BpmnLabel_uid" ON "BpmnLabel" (uid);

CREATE TABLE "BpmnPlane" (
	uid INTEGER NOT NULL,
	bpmn_element TEXT,
	id TEXT,
	element_type TEXT,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_BpmnPlane_uid" ON "BpmnPlane" (uid);

CREATE TABLE "BpmnActivationCondition" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnActivationCondition_uid" ON "BpmnActivationCondition" (uid);

CREATE TABLE "BpmnAssociation" (
	uid INTEGER NOT NULL,
	source_ref TEXT NOT NULL,
	target_ref TEXT NOT NULL,
	association_direction VARCHAR(4),
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnAssociation_uid" ON "BpmnAssociation" (uid);

CREATE TABLE "BpmnAuditing" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnAuditing_uid" ON "BpmnAuditing" (uid);

CREATE TABLE "BpmnBaseElement" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnBaseElement_uid" ON "BpmnBaseElement" (uid);

CREATE TABLE "BpmnCallConversation" (
	uid INTEGER NOT NULL,
	called_collaboration_ref TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCallConversation_uid" ON "BpmnCallConversation" (uid);

CREATE TABLE "BpmnCancelEventDefinition" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCancelEventDefinition_uid" ON "BpmnCancelEventDefinition" (uid);

CREATE TABLE "BpmnCategory" (
	uid INTEGER NOT NULL,
	name TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCategory_uid" ON "BpmnCategory" (uid);

CREATE TABLE "BpmnChildLaneSet" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnChildLaneSet_uid" ON "BpmnChildLaneSet" (uid);

CREATE TABLE "BpmnCollaboration" (
	uid INTEGER NOT NULL,
	name TEXT,
	is_closed BOOLEAN,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCollaboration_uid" ON "BpmnCollaboration" (uid);

CREATE TABLE "BpmnCompensateEventDefinition" (
	uid INTEGER NOT NULL,
	wait_for_completion BOOLEAN,
	activity_ref TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCompensateEventDefinition_uid" ON "BpmnCompensateEventDefinition" (uid);

CREATE TABLE "BpmnCompletionCondition" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCompletionCondition_uid" ON "BpmnCompletionCondition" (uid);

CREATE TABLE "BpmnCondition" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCondition_uid" ON "BpmnCondition" (uid);

CREATE TABLE "BpmnConditionExpression" (
	uid INTEGER NOT NULL,
	xsi_type TEXT,
	fluxnova_resource TEXT,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConditionExpression_uid" ON "BpmnConditionExpression" (uid);

CREATE TABLE "BpmnConversation" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConversation_uid" ON "BpmnConversation" (uid);

CREATE TABLE "BpmnCorrelationProperty" (
	uid INTEGER NOT NULL,
	name TEXT,
	type TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationProperty_uid" ON "BpmnCorrelationProperty" (uid);

CREATE TABLE "BpmnDataPath" (
	uid INTEGER NOT NULL,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataPath_uid" ON "BpmnDataPath" (uid);

CREATE TABLE "BpmnDataState" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataState_uid" ON "BpmnDataState" (uid);

CREATE TABLE "BpmnEndPoint" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEndPoint_uid" ON "BpmnEndPoint" (uid);

CREATE TABLE "BpmnError" (
	uid INTEGER NOT NULL,
	name TEXT,
	error_code TEXT,
	fluxnova_error_message TEXT,
	structure_ref TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnError_uid" ON "BpmnError" (uid);

CREATE TABLE "BpmnErrorEventDefinition" (
	uid INTEGER NOT NULL,
	error_ref TEXT,
	fluxnova_error_code_variable TEXT,
	fluxnova_error_message_variable TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnErrorEventDefinition_uid" ON "BpmnErrorEventDefinition" (uid);

CREATE TABLE "BpmnEscalation" (
	uid INTEGER NOT NULL,
	name TEXT,
	escalation_code TEXT,
	structure_ref TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEscalation_uid" ON "BpmnEscalation" (uid);

CREATE TABLE "BpmnEscalationEventDefinition" (
	uid INTEGER NOT NULL,
	escalation_ref TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEscalationEventDefinition_uid" ON "BpmnEscalationEventDefinition" (uid);

CREATE TABLE "BpmnExpression" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnExpression_uid" ON "BpmnExpression" (uid);

CREATE TABLE "BpmnExtension" (
	id INTEGER NOT NULL,
	definition TEXT,
	must_understand BOOLEAN,
	element_type TEXT,
	"BpmnDefinitions_uid" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDefinitions_uid") REFERENCES "BpmnDefinitions" (uid)
);
CREATE INDEX "ix_BpmnExtension_id" ON "BpmnExtension" (id);

CREATE TABLE "BpmnFormalExpression" (
	uid INTEGER NOT NULL,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnFormalExpression_uid" ON "BpmnFormalExpression" (uid);

CREATE TABLE "BpmnFrom" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnFrom_uid" ON "BpmnFrom" (uid);

CREATE TABLE "BpmnGlobalConversation" (
	uid INTEGER NOT NULL,
	name TEXT,
	is_closed BOOLEAN,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnGlobalConversation_uid" ON "BpmnGlobalConversation" (uid);

CREATE TABLE "BpmnGroup" (
	uid INTEGER NOT NULL,
	category_value_ref TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnGroup_uid" ON "BpmnGroup" (uid);

CREATE TABLE "BpmnImport" (
	id INTEGER NOT NULL,
	namespace TEXT NOT NULL,
	location TEXT NOT NULL,
	import_type TEXT NOT NULL,
	element_type TEXT,
	"BpmnDefinitions_uid" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDefinitions_uid") REFERENCES "BpmnDefinitions" (uid)
);
CREATE INDEX "ix_BpmnImport_id" ON "BpmnImport" (id);

CREATE TABLE "BpmnInterface" (
	uid INTEGER NOT NULL,
	name TEXT NOT NULL,
	implementation_ref TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnInterface_uid" ON "BpmnInterface" (uid);

CREATE TABLE "BpmnIoSpecification" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnIoSpecification_uid" ON "BpmnIoSpecification" (uid);

CREATE TABLE "BpmnItemDefinition" (
	uid INTEGER NOT NULL,
	structure_ref TEXT,
	is_collection BOOLEAN,
	item_kind VARCHAR(11),
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnItemDefinition_uid" ON "BpmnItemDefinition" (uid);

CREATE TABLE "BpmnLinkEventDefinition" (
	uid INTEGER NOT NULL,
	name TEXT NOT NULL,
	target TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLinkEventDefinition_uid" ON "BpmnLinkEventDefinition" (uid);

CREATE TABLE "BpmnLoopCardinality" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLoopCardinality_uid" ON "BpmnLoopCardinality" (uid);

CREATE TABLE "BpmnLoopCharacteristics" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLoopCharacteristics_uid" ON "BpmnLoopCharacteristics" (uid);

CREATE TABLE "BpmnMessage" (
	uid INTEGER NOT NULL,
	name TEXT,
	item_ref TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessage_uid" ON "BpmnMessage" (uid);

CREATE TABLE "BpmnMessageEventDefinition" (
	uid INTEGER NOT NULL,
	message_ref TEXT,
	fluxnova_class TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_expression TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_topic TEXT,
	fluxnova_type TEXT,
	fluxnova_task_priority TEXT,
	operation_ref TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessageEventDefinition_uid" ON "BpmnMessageEventDefinition" (uid);

CREATE TABLE "BpmnMessagePath" (
	uid INTEGER NOT NULL,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessagePath_uid" ON "BpmnMessagePath" (uid);

CREATE TABLE "BpmnMonitoring" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMonitoring_uid" ON "BpmnMonitoring" (uid);

CREATE TABLE "BpmnParticipantMultiplicity" (
	uid INTEGER NOT NULL,
	minimum INTEGER,
	maximum INTEGER,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnParticipantMultiplicity_uid" ON "BpmnParticipantMultiplicity" (uid);

CREATE TABLE "BpmnPartitionElement" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnPartitionElement_uid" ON "BpmnPartitionElement" (uid);

CREATE TABLE "BpmnRelationship" (
	uid INTEGER NOT NULL,
	type TEXT NOT NULL,
	direction VARCHAR(8),
	id TEXT,
	element_type TEXT,
	"BpmnDefinitions_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnDefinitions_uid") REFERENCES "BpmnDefinitions" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnRelationship_uid" ON "BpmnRelationship" (uid);

CREATE TABLE "BpmnResource" (
	uid INTEGER NOT NULL,
	name TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResource_uid" ON "BpmnResource" (uid);

CREATE TABLE "BpmnRootElement" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnDefinitions_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnDefinitions_uid") REFERENCES "BpmnDefinitions" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnRootElement_uid" ON "BpmnRootElement" (uid);

CREATE TABLE "BpmnSignal" (
	uid INTEGER NOT NULL,
	name TEXT,
	structure_ref TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSignal_uid" ON "BpmnSignal" (uid);

CREATE TABLE "BpmnSignalEventDefinition" (
	uid INTEGER NOT NULL,
	signal_ref TEXT,
	fluxnova_async BOOLEAN,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSignalEventDefinition_uid" ON "BpmnSignalEventDefinition" (uid);

CREATE TABLE "BpmnSubConversation" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSubConversation_uid" ON "BpmnSubConversation" (uid);

CREATE TABLE "BpmnTerminateEventDefinition" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTerminateEventDefinition_uid" ON "BpmnTerminateEventDefinition" (uid);

CREATE TABLE "BpmnTextAnnotation" (
	uid INTEGER NOT NULL,
	text_format TEXT,
	id TEXT,
	element_type TEXT,
	text_id INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(text_id) REFERENCES "BpmnText" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTextAnnotation_uid" ON "BpmnTextAnnotation" (uid);

CREATE TABLE "BpmnTimeCycle" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTimeCycle_uid" ON "BpmnTimeCycle" (uid);

CREATE TABLE "BpmnTimeDate" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTimeDate_uid" ON "BpmnTimeDate" (uid);

CREATE TABLE "BpmnTimeDuration" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTimeDuration_uid" ON "BpmnTimeDuration" (uid);

CREATE TABLE "BpmnTo" (
	uid INTEGER NOT NULL,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTo_uid" ON "BpmnTo" (uid);

CREATE TABLE "BpmnTransformation" (
	uid INTEGER NOT NULL,
	language TEXT,
	evaluates_to_type_ref TEXT,
	text_content TEXT,
	id TEXT,
	element_type TEXT,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTransformation_uid" ON "BpmnTransformation" (uid);

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
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	"DiPlane_uid" INTEGER,
	"BpmnPlane_uid" INTEGER,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("DiPlane_uid") REFERENCES "DiPlane" (uid),
	FOREIGN KEY("BpmnPlane_uid") REFERENCES "BpmnPlane" (uid),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_DiDiagramElement_uid" ON "DiDiagramElement" (uid);

CREATE TABLE "BpmnDiagram" (
	uid INTEGER NOT NULL,
	name TEXT,
	documentation TEXT,
	resolution FLOAT,
	id TEXT,
	element_type TEXT,
	"BpmnDefinitions_uid" INTEGER,
	bpmn_plane_uid INTEGER NOT NULL,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnDefinitions_uid") REFERENCES "BpmnDefinitions" (uid),
	FOREIGN KEY(bpmn_plane_uid) REFERENCES "BpmnPlane" (uid)
);
CREATE INDEX "ix_BpmnDiagram_uid" ON "BpmnDiagram" (uid);

CREATE TABLE "BpmnEdge" (
	uid INTEGER NOT NULL,
	bpmn_element TEXT,
	source_element TEXT,
	target_element TEXT,
	message_visible_kind VARCHAR(14),
	id TEXT,
	element_type TEXT,
	bpmn_label_uid INTEGER,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(bpmn_label_uid) REFERENCES "BpmnLabel" (uid),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_BpmnEdge_uid" ON "BpmnEdge" (uid);

CREATE TABLE "BpmnShape" (
	uid INTEGER NOT NULL,
	bpmn_element TEXT,
	is_horizontal BOOLEAN,
	is_expanded BOOLEAN,
	is_marker_visible BOOLEAN,
	is_message_visible BOOLEAN,
	participant_band_kind VARCHAR(21),
	choreography_activity_shape TEXT,
	id TEXT,
	element_type TEXT,
	bpmn_label_uid INTEGER,
	bounds_id INTEGER NOT NULL,
	extension_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(bpmn_label_uid) REFERENCES "BpmnLabel" (uid),
	FOREIGN KEY(bounds_id) REFERENCES "DcBounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "DiExtension" (id)
);
CREATE INDEX "ix_BpmnShape_uid" ON "BpmnShape" (uid);

CREATE TABLE "BpmnActivity" (
	uid INTEGER NOT NULL,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnActivity_uid" ON "BpmnActivity" (uid);

CREATE TABLE "BpmnAdHocSubProcess" (
	uid INTEGER NOT NULL,
	ordering TEXT,
	cancel_remaining_instances BOOLEAN,
	triggered_by_event BOOLEAN,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	completion_condition_uid INTEGER,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(completion_condition_uid) REFERENCES "BpmnCompletionCondition" (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnAdHocSubProcess_uid" ON "BpmnAdHocSubProcess" (uid);

CREATE TABLE "BpmnBusinessRuleTask" (
	uid INTEGER NOT NULL,
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
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnBusinessRuleTask_uid" ON "BpmnBusinessRuleTask" (uid);

CREATE TABLE "BpmnCallActivity" (
	uid INTEGER NOT NULL,
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
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCallActivity_uid" ON "BpmnCallActivity" (uid);

CREATE TABLE "BpmnCallableElement" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCallableElement_uid" ON "BpmnCallableElement" (uid);

CREATE TABLE "BpmnCategoryValue" (
	uid INTEGER NOT NULL,
	value TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnCategory_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCategory_uid") REFERENCES "BpmnCategory" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCategoryValue_uid" ON "BpmnCategoryValue" (uid);

CREATE TABLE "BpmnComplexGateway" (
	uid INTEGER NOT NULL,
	"default" TEXT,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	activation_condition_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(activation_condition_uid) REFERENCES "BpmnActivationCondition" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnComplexGateway_uid" ON "BpmnComplexGateway" (uid);

CREATE TABLE "BpmnConditionalEventDefinition" (
	uid INTEGER NOT NULL,
	fluxnova_variable_name TEXT,
	fluxnova_variable_events TEXT,
	id TEXT,
	element_type TEXT,
	condition_uid INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(condition_uid) REFERENCES "BpmnCondition" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConditionalEventDefinition_uid" ON "BpmnConditionalEventDefinition" (uid);

CREATE TABLE "BpmnConversationAssociation" (
	uid INTEGER NOT NULL,
	inner_conversation_node_ref TEXT NOT NULL,
	outer_conversation_node_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConversationAssociation_uid" ON "BpmnConversationAssociation" (uid);

CREATE TABLE "BpmnConversationLink" (
	uid INTEGER NOT NULL,
	name TEXT,
	source_ref TEXT NOT NULL,
	target_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConversationLink_uid" ON "BpmnConversationLink" (uid);

CREATE TABLE "BpmnConversationNode" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	"BpmnSubConversation_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY("BpmnSubConversation_uid") REFERENCES "BpmnSubConversation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnConversationNode_uid" ON "BpmnConversationNode" (uid);

CREATE TABLE "BpmnCorrelationPropertyRetrievalExpression" (
	uid INTEGER NOT NULL,
	message_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnCorrelationProperty_uid" INTEGER,
	message_path_uid INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCorrelationProperty_uid") REFERENCES "BpmnCorrelationProperty" (uid),
	FOREIGN KEY(message_path_uid) REFERENCES "BpmnMessagePath" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationPropertyRetrievalExpression_uid" ON "BpmnCorrelationPropertyRetrievalExpression" (uid);

CREATE TABLE "BpmnDataAssociation" (
	uid INTEGER NOT NULL,
	target_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	transformation_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(transformation_uid) REFERENCES "BpmnTransformation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataAssociation_uid" ON "BpmnDataAssociation" (uid);

CREATE TABLE "BpmnDataObject" (
	uid INTEGER NOT NULL,
	item_subject_ref TEXT,
	is_collection BOOLEAN,
	name TEXT,
	id TEXT,
	element_type TEXT,
	data_state_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataObject_uid" ON "BpmnDataObject" (uid);

CREATE TABLE "BpmnDataObjectReference" (
	uid INTEGER NOT NULL,
	item_subject_ref TEXT,
	data_object_ref TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	data_state_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataObjectReference_uid" ON "BpmnDataObjectReference" (uid);

CREATE TABLE "BpmnDataStore" (
	uid INTEGER NOT NULL,
	name TEXT,
	capacity INTEGER,
	is_unlimited BOOLEAN,
	item_subject_ref TEXT,
	id TEXT,
	element_type TEXT,
	data_state_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataStore_uid" ON "BpmnDataStore" (uid);

CREATE TABLE "BpmnDataStoreReference" (
	uid INTEGER NOT NULL,
	item_subject_ref TEXT,
	data_store_ref TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	data_state_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataStoreReference_uid" ON "BpmnDataStoreReference" (uid);

CREATE TABLE "BpmnEvent" (
	uid INTEGER NOT NULL,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEvent_uid" ON "BpmnEvent" (uid);

CREATE TABLE "BpmnEventBasedGateway" (
	uid INTEGER NOT NULL,
	instantiate BOOLEAN,
	event_gateway_type VARCHAR(9),
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEventBasedGateway_uid" ON "BpmnEventBasedGateway" (uid);

CREATE TABLE "BpmnExclusiveGateway" (
	uid INTEGER NOT NULL,
	"default" TEXT,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnExclusiveGateway_uid" ON "BpmnExclusiveGateway" (uid);

CREATE TABLE "BpmnFlowNode" (
	uid INTEGER NOT NULL,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnFlowNode_uid" ON "BpmnFlowNode" (uid);

CREATE TABLE "BpmnGateway" (
	uid INTEGER NOT NULL,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnGateway_uid" ON "BpmnGateway" (uid);

CREATE TABLE "BpmnInclusiveGateway" (
	uid INTEGER NOT NULL,
	"default" TEXT,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnInclusiveGateway_uid" ON "BpmnInclusiveGateway" (uid);

CREATE TABLE "BpmnInputDataItem" (
	uid INTEGER NOT NULL,
	name TEXT,
	is_collection BOOLEAN,
	item_subject_ref TEXT,
	id TEXT,
	element_type TEXT,
	data_state_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnInputDataItem_uid" ON "BpmnInputDataItem" (uid);

CREATE TABLE "BpmnInputSet" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnIoSpecification_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnIoSpecification_uid") REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnInputSet_uid" ON "BpmnInputSet" (uid);

CREATE TABLE "BpmnItemAwareElement" (
	uid INTEGER NOT NULL,
	item_subject_ref TEXT,
	id TEXT,
	element_type TEXT,
	data_state_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnItemAwareElement_uid" ON "BpmnItemAwareElement" (uid);

CREATE TABLE "BpmnManualTask" (
	uid INTEGER NOT NULL,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnManualTask_uid" ON "BpmnManualTask" (uid);

CREATE TABLE "BpmnMessageFlow" (
	uid INTEGER NOT NULL,
	name TEXT,
	source_ref TEXT NOT NULL,
	target_ref TEXT NOT NULL,
	message_ref TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessageFlow_uid" ON "BpmnMessageFlow" (uid);

CREATE TABLE "BpmnMessageFlowAssociation" (
	uid INTEGER NOT NULL,
	inner_message_flow_ref TEXT NOT NULL,
	outer_message_flow_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMessageFlowAssociation_uid" ON "BpmnMessageFlowAssociation" (uid);

CREATE TABLE "BpmnOperation" (
	uid INTEGER NOT NULL,
	name TEXT NOT NULL,
	implementation_ref TEXT,
	in_message_ref TEXT NOT NULL,
	out_message_ref TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnInterface_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnInterface_uid") REFERENCES "BpmnInterface" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnOperation_uid" ON "BpmnOperation" (uid);

CREATE TABLE "BpmnOutputDataItem" (
	uid INTEGER NOT NULL,
	name TEXT,
	is_collection BOOLEAN,
	item_subject_ref TEXT,
	id TEXT,
	element_type TEXT,
	data_state_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnOutputDataItem_uid" ON "BpmnOutputDataItem" (uid);

CREATE TABLE "BpmnOutputSet" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnIoSpecification_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnIoSpecification_uid") REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnOutputSet_uid" ON "BpmnOutputSet" (uid);

CREATE TABLE "BpmnParallelGateway" (
	uid INTEGER NOT NULL,
	fluxnova_async BOOLEAN,
	gateway_direction VARCHAR(11),
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	id TEXT,
	element_type TEXT,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnParallelGateway_uid" ON "BpmnParallelGateway" (uid);

CREATE TABLE "BpmnParticipant" (
	uid INTEGER NOT NULL,
	name TEXT,
	process_ref TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	participant_multiplicity_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY(participant_multiplicity_uid) REFERENCES "BpmnParticipantMultiplicity" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnParticipant_uid" ON "BpmnParticipant" (uid);

CREATE TABLE "BpmnParticipantAssociation" (
	uid INTEGER NOT NULL,
	inner_participant_ref TEXT NOT NULL,
	outer_participant_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnCallConversation_uid" INTEGER,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCallConversation_uid") REFERENCES "BpmnCallConversation" (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnParticipantAssociation_uid" ON "BpmnParticipantAssociation" (uid);

CREATE TABLE "BpmnProcess" (
	uid INTEGER NOT NULL,
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
	id TEXT,
	element_type TEXT,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	io_specification_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnProcess_uid" ON "BpmnProcess" (uid);

CREATE TABLE "BpmnReceiveTask" (
	uid INTEGER NOT NULL,
	implementation TEXT,
	instantiate BOOLEAN,
	message_ref TEXT,
	operation_ref TEXT,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnReceiveTask_uid" ON "BpmnReceiveTask" (uid);

CREATE TABLE "BpmnResourceAssignmentExpression" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	expression_uid INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(expression_uid) REFERENCES "BpmnExpression" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResourceAssignmentExpression_uid" ON "BpmnResourceAssignmentExpression" (uid);

CREATE TABLE "BpmnResourceParameter" (
	uid INTEGER NOT NULL,
	name TEXT,
	type TEXT,
	is_required BOOLEAN,
	id TEXT,
	element_type TEXT,
	"BpmnResource_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnResource_uid") REFERENCES "BpmnResource" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResourceParameter_uid" ON "BpmnResourceParameter" (uid);

CREATE TABLE "BpmnScriptTask" (
	uid INTEGER NOT NULL,
	script_format TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_resource TEXT,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	script_id INTEGER,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(script_id) REFERENCES "BpmnScript" (id),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnScriptTask_uid" ON "BpmnScriptTask" (uid);

CREATE TABLE "BpmnSendTask" (
	uid INTEGER NOT NULL,
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
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSendTask_uid" ON "BpmnSendTask" (uid);

CREATE TABLE "BpmnSequenceFlow" (
	uid INTEGER NOT NULL,
	source_ref TEXT NOT NULL,
	target_ref TEXT NOT NULL,
	is_immediate BOOLEAN,
	name TEXT,
	id TEXT,
	element_type TEXT,
	condition_expression_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(condition_expression_uid) REFERENCES "BpmnConditionExpression" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSequenceFlow_uid" ON "BpmnSequenceFlow" (uid);

CREATE TABLE "BpmnServiceTask" (
	uid INTEGER NOT NULL,
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
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnServiceTask_uid" ON "BpmnServiceTask" (uid);

CREATE TABLE "BpmnSource" (
	id INTEGER NOT NULL,
	element_type TEXT,
	"BpmnRelationship_uid" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnRelationship_uid") REFERENCES "BpmnRelationship" (uid)
);
CREATE INDEX "ix_BpmnSource_id" ON "BpmnSource" (id);

CREATE TABLE "BpmnSubProcess" (
	uid INTEGER NOT NULL,
	triggered_by_event BOOLEAN,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnSubProcess_uid" ON "BpmnSubProcess" (uid);

CREATE TABLE "BpmnTarget" (
	id INTEGER NOT NULL,
	element_type TEXT,
	"BpmnRelationship_uid" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnRelationship_uid") REFERENCES "BpmnRelationship" (uid)
);
CREATE INDEX "ix_BpmnTarget_id" ON "BpmnTarget" (id);

CREATE TABLE "BpmnTask" (
	uid INTEGER NOT NULL,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTask_uid" ON "BpmnTask" (uid);

CREATE TABLE "BpmnTimerEventDefinition" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	time_date_uid INTEGER,
	time_duration_uid INTEGER,
	time_cycle_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(time_date_uid) REFERENCES "BpmnTimeDate" (uid),
	FOREIGN KEY(time_duration_uid) REFERENCES "BpmnTimeDuration" (uid),
	FOREIGN KEY(time_cycle_uid) REFERENCES "BpmnTimeCycle" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTimerEventDefinition_uid" ON "BpmnTimerEventDefinition" (uid);

CREATE TABLE "BpmnTransaction" (
	uid INTEGER NOT NULL,
	method VARCHAR(12),
	triggered_by_event BOOLEAN,
	fluxnova_async BOOLEAN,
	is_for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnTransaction_uid" ON "BpmnTransaction" (uid);

CREATE TABLE "BpmnUserTask" (
	uid INTEGER NOT NULL,
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
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	io_specification_uid INTEGER,
	loop_characteristics_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(io_specification_uid) REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY(loop_characteristics_uid) REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnUserTask_uid" ON "BpmnUserTask" (uid);

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
	"BpmnCallConversation_uid" INTEGER,
	participant_refs TEXT,
	PRIMARY KEY ("BpmnCallConversation_uid", participant_refs),
	FOREIGN KEY("BpmnCallConversation_uid") REFERENCES "BpmnCallConversation" (uid)
);
CREATE INDEX "ix_BpmnCallConversation_participant_refs_participant_refs" ON "BpmnCallConversation_participant_refs" (participant_refs);
CREATE INDEX "ix_BpmnCallConversation_participant_refs_BpmnCallConversation_uid" ON "BpmnCallConversation_participant_refs" ("BpmnCallConversation_uid");

CREATE TABLE "BpmnCallConversation_message_flow_refs" (
	"BpmnCallConversation_uid" INTEGER,
	message_flow_refs TEXT,
	PRIMARY KEY ("BpmnCallConversation_uid", message_flow_refs),
	FOREIGN KEY("BpmnCallConversation_uid") REFERENCES "BpmnCallConversation" (uid)
);
CREATE INDEX "ix_BpmnCallConversation_message_flow_refs_BpmnCallConversation_uid" ON "BpmnCallConversation_message_flow_refs" ("BpmnCallConversation_uid");
CREATE INDEX "ix_BpmnCallConversation_message_flow_refs_message_flow_refs" ON "BpmnCallConversation_message_flow_refs" (message_flow_refs);

CREATE TABLE "BpmnConversation_participant_refs" (
	"BpmnConversation_uid" INTEGER,
	participant_refs TEXT,
	PRIMARY KEY ("BpmnConversation_uid", participant_refs),
	FOREIGN KEY("BpmnConversation_uid") REFERENCES "BpmnConversation" (uid)
);
CREATE INDEX "ix_BpmnConversation_participant_refs_BpmnConversation_uid" ON "BpmnConversation_participant_refs" ("BpmnConversation_uid");
CREATE INDEX "ix_BpmnConversation_participant_refs_participant_refs" ON "BpmnConversation_participant_refs" (participant_refs);

CREATE TABLE "BpmnConversation_message_flow_refs" (
	"BpmnConversation_uid" INTEGER,
	message_flow_refs TEXT,
	PRIMARY KEY ("BpmnConversation_uid", message_flow_refs),
	FOREIGN KEY("BpmnConversation_uid") REFERENCES "BpmnConversation" (uid)
);
CREATE INDEX "ix_BpmnConversation_message_flow_refs_BpmnConversation_uid" ON "BpmnConversation_message_flow_refs" ("BpmnConversation_uid");
CREATE INDEX "ix_BpmnConversation_message_flow_refs_message_flow_refs" ON "BpmnConversation_message_flow_refs" (message_flow_refs);

CREATE TABLE "BpmnLinkEventDefinition_sources" (
	"BpmnLinkEventDefinition_uid" INTEGER,
	sources TEXT,
	PRIMARY KEY ("BpmnLinkEventDefinition_uid", sources),
	FOREIGN KEY("BpmnLinkEventDefinition_uid") REFERENCES "BpmnLinkEventDefinition" (uid)
);
CREATE INDEX "ix_BpmnLinkEventDefinition_sources_BpmnLinkEventDefinition_uid" ON "BpmnLinkEventDefinition_sources" ("BpmnLinkEventDefinition_uid");
CREATE INDEX "ix_BpmnLinkEventDefinition_sources_sources" ON "BpmnLinkEventDefinition_sources" (sources);

CREATE TABLE "BpmnSubConversation_participant_refs" (
	"BpmnSubConversation_uid" INTEGER,
	participant_refs TEXT,
	PRIMARY KEY ("BpmnSubConversation_uid", participant_refs),
	FOREIGN KEY("BpmnSubConversation_uid") REFERENCES "BpmnSubConversation" (uid)
);
CREATE INDEX "ix_BpmnSubConversation_participant_refs_BpmnSubConversation_uid" ON "BpmnSubConversation_participant_refs" ("BpmnSubConversation_uid");
CREATE INDEX "ix_BpmnSubConversation_participant_refs_participant_refs" ON "BpmnSubConversation_participant_refs" (participant_refs);

CREATE TABLE "BpmnSubConversation_message_flow_refs" (
	"BpmnSubConversation_uid" INTEGER,
	message_flow_refs TEXT,
	PRIMARY KEY ("BpmnSubConversation_uid", message_flow_refs),
	FOREIGN KEY("BpmnSubConversation_uid") REFERENCES "BpmnSubConversation" (uid)
);
CREATE INDEX "ix_BpmnSubConversation_message_flow_refs_BpmnSubConversation_uid" ON "BpmnSubConversation_message_flow_refs" ("BpmnSubConversation_uid");
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
	"DiEdge_uid" INTEGER,
	"DiLabeledEdge_uid" INTEGER,
	"BpmnEdge_uid" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("DiEdge_uid") REFERENCES "DiEdge" (uid),
	FOREIGN KEY("DiLabeledEdge_uid") REFERENCES "DiLabeledEdge" (uid),
	FOREIGN KEY("BpmnEdge_uid") REFERENCES "BpmnEdge" (uid)
);
CREATE INDEX "ix_DiWaypoint_id" ON "DiWaypoint" (id);

CREATE TABLE "BpmnLabelStyle" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnDiagram_uid" INTEGER,
	font_id INTEGER NOT NULL,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnDiagram_uid") REFERENCES "BpmnDiagram" (uid),
	FOREIGN KEY(font_id) REFERENCES "DcFont" (id)
);
CREATE INDEX "ix_BpmnLabelStyle_uid" ON "BpmnLabelStyle" (uid);

CREATE TABLE "BpmnArtifact" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnAdHocSubProcess_uid" INTEGER,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	"BpmnProcess_uid" INTEGER,
	"BpmnSubProcess_uid" INTEGER,
	"BpmnTransaction_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnArtifact_uid" ON "BpmnArtifact" (uid);

CREATE TABLE "BpmnBoundaryEvent" (
	uid INTEGER NOT NULL,
	cancel_activity BOOLEAN,
	attached_to_ref TEXT NOT NULL,
	parallel_multiple BOOLEAN,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	output_set_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(output_set_uid) REFERENCES "BpmnOutputSet" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnBoundaryEvent_uid" ON "BpmnBoundaryEvent" (uid);

CREATE TABLE "BpmnCatchEvent" (
	uid INTEGER NOT NULL,
	parallel_multiple BOOLEAN,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	output_set_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(output_set_uid) REFERENCES "BpmnOutputSet" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCatchEvent_uid" ON "BpmnCatchEvent" (uid);

CREATE TABLE "BpmnCorrelationKey" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnCallConversation_uid" INTEGER,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnConversation_uid" INTEGER,
	"BpmnConversationNode_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	"BpmnSubConversation_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCallConversation_uid") REFERENCES "BpmnCallConversation" (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnConversation_uid") REFERENCES "BpmnConversation" (uid),
	FOREIGN KEY("BpmnConversationNode_uid") REFERENCES "BpmnConversationNode" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY("BpmnSubConversation_uid") REFERENCES "BpmnSubConversation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationKey_uid" ON "BpmnCorrelationKey" (uid);

CREATE TABLE "BpmnCorrelationSubscription" (
	uid INTEGER NOT NULL,
	correlation_key_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnProcess_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationSubscription_uid" ON "BpmnCorrelationSubscription" (uid);

CREATE TABLE "BpmnEndEvent" (
	uid INTEGER NOT NULL,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	input_set_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(input_set_uid) REFERENCES "BpmnInputSet" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEndEvent_uid" ON "BpmnEndEvent" (uid);

CREATE TABLE "BpmnFlowElement" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnAdHocSubProcess_uid" INTEGER,
	"BpmnProcess_uid" INTEGER,
	"BpmnSubProcess_uid" INTEGER,
	"BpmnTransaction_uid" INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnFlowElement_uid" ON "BpmnFlowElement" (uid);

CREATE TABLE "BpmnHumanPerformer" (
	uid INTEGER NOT NULL,
	name TEXT,
	resource_ref TEXT,
	id TEXT,
	element_type TEXT,
	resource_assignment_expression_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(resource_assignment_expression_uid) REFERENCES "BpmnResourceAssignmentExpression" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnHumanPerformer_uid" ON "BpmnHumanPerformer" (uid);

CREATE TABLE "BpmnIntermediateCatchEvent" (
	uid INTEGER NOT NULL,
	parallel_multiple BOOLEAN,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	output_set_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(output_set_uid) REFERENCES "BpmnOutputSet" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_uid" ON "BpmnIntermediateCatchEvent" (uid);

CREATE TABLE "BpmnIntermediateThrowEvent" (
	uid INTEGER NOT NULL,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	input_set_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(input_set_uid) REFERENCES "BpmnInputSet" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_uid" ON "BpmnIntermediateThrowEvent" (uid);

CREATE TABLE "BpmnIoBinding" (
	uid INTEGER NOT NULL,
	operation_ref TEXT NOT NULL,
	input_data_ref TEXT NOT NULL,
	output_data_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnCallableElement_uid" INTEGER,
	"BpmnProcess_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCallableElement_uid") REFERENCES "BpmnCallableElement" (uid),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnIoBinding_uid" ON "BpmnIoBinding" (uid);

CREATE TABLE "BpmnLaneSet" (
	uid INTEGER NOT NULL,
	name TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnAdHocSubProcess_uid" INTEGER,
	"BpmnProcess_uid" INTEGER,
	"BpmnSubProcess_uid" INTEGER,
	"BpmnTransaction_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLaneSet_uid" ON "BpmnLaneSet" (uid);

CREATE TABLE "BpmnMultiInstanceLoopCharacteristics" (
	uid INTEGER NOT NULL,
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
	id TEXT,
	element_type TEXT,
	loop_cardinality_uid INTEGER,
	output_data_item_uid INTEGER,
	input_data_item_uid INTEGER,
	completion_condition_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(loop_cardinality_uid) REFERENCES "BpmnLoopCardinality" (uid),
	FOREIGN KEY(output_data_item_uid) REFERENCES "BpmnOutputDataItem" (uid),
	FOREIGN KEY(input_data_item_uid) REFERENCES "BpmnInputDataItem" (uid),
	FOREIGN KEY(completion_condition_uid) REFERENCES "BpmnCompletionCondition" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnMultiInstanceLoopCharacteristics_uid" ON "BpmnMultiInstanceLoopCharacteristics" (uid);

CREATE TABLE "BpmnPerformer" (
	uid INTEGER NOT NULL,
	name TEXT,
	resource_ref TEXT,
	id TEXT,
	element_type TEXT,
	resource_assignment_expression_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(resource_assignment_expression_uid) REFERENCES "BpmnResourceAssignmentExpression" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnPerformer_uid" ON "BpmnPerformer" (uid);

CREATE TABLE "BpmnPotentialOwner" (
	uid INTEGER NOT NULL,
	name TEXT,
	resource_ref TEXT,
	id TEXT,
	element_type TEXT,
	resource_assignment_expression_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(resource_assignment_expression_uid) REFERENCES "BpmnResourceAssignmentExpression" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnPotentialOwner_uid" ON "BpmnPotentialOwner" (uid);

CREATE TABLE "BpmnRendering" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnUserTask_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnUserTask_uid") REFERENCES "BpmnUserTask" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnRendering_uid" ON "BpmnRendering" (uid);

CREATE TABLE "BpmnResourceRole" (
	uid INTEGER NOT NULL,
	name TEXT,
	resource_ref TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnActivity_uid" INTEGER,
	"BpmnAdHocSubProcess_uid" INTEGER,
	"BpmnBusinessRuleTask_uid" INTEGER,
	"BpmnCallActivity_uid" INTEGER,
	"BpmnManualTask_uid" INTEGER,
	"BpmnProcess_uid" INTEGER,
	"BpmnReceiveTask_uid" INTEGER,
	"BpmnScriptTask_uid" INTEGER,
	"BpmnSendTask_uid" INTEGER,
	"BpmnServiceTask_uid" INTEGER,
	"BpmnSubProcess_uid" INTEGER,
	"BpmnTask_uid" INTEGER,
	"BpmnTransaction_uid" INTEGER,
	"BpmnUserTask_uid" INTEGER,
	resource_assignment_expression_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnActivity_uid") REFERENCES "BpmnActivity" (uid),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid),
	FOREIGN KEY("BpmnBusinessRuleTask_uid") REFERENCES "BpmnBusinessRuleTask" (uid),
	FOREIGN KEY("BpmnCallActivity_uid") REFERENCES "BpmnCallActivity" (uid),
	FOREIGN KEY("BpmnManualTask_uid") REFERENCES "BpmnManualTask" (uid),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid),
	FOREIGN KEY("BpmnReceiveTask_uid") REFERENCES "BpmnReceiveTask" (uid),
	FOREIGN KEY("BpmnScriptTask_uid") REFERENCES "BpmnScriptTask" (uid),
	FOREIGN KEY("BpmnSendTask_uid") REFERENCES "BpmnSendTask" (uid),
	FOREIGN KEY("BpmnServiceTask_uid") REFERENCES "BpmnServiceTask" (uid),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid),
	FOREIGN KEY("BpmnTask_uid") REFERENCES "BpmnTask" (uid),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid),
	FOREIGN KEY("BpmnUserTask_uid") REFERENCES "BpmnUserTask" (uid),
	FOREIGN KEY(resource_assignment_expression_uid) REFERENCES "BpmnResourceAssignmentExpression" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResourceRole_uid" ON "BpmnResourceRole" (uid);

CREATE TABLE "BpmnStartEvent" (
	uid INTEGER NOT NULL,
	is_interrupting BOOLEAN,
	fluxnova_async BOOLEAN,
	fluxnova_form_handler_class TEXT,
	fluxnova_form_key TEXT,
	fluxnova_form_ref TEXT,
	fluxnova_form_ref_binding TEXT,
	fluxnova_form_ref_version TEXT,
	fluxnova_initiator TEXT,
	parallel_multiple BOOLEAN,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	output_set_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(output_set_uid) REFERENCES "BpmnOutputSet" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnStartEvent_uid" ON "BpmnStartEvent" (uid);

CREATE TABLE "BpmnThrowEvent" (
	uid INTEGER NOT NULL,
	id TEXT,
	fluxnova_async_after BOOLEAN,
	fluxnova_async_before BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	element_type TEXT,
	input_set_uid INTEGER,
	auditing_uid INTEGER,
	monitoring_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY(input_set_uid) REFERENCES "BpmnInputSet" (uid),
	FOREIGN KEY(auditing_uid) REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY(monitoring_uid) REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnThrowEvent_uid" ON "BpmnThrowEvent" (uid);

CREATE TABLE "FluxnovaPotentialStarter" (
	id INTEGER NOT NULL,
	element_type TEXT,
	resource_assignment_expression_uid INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource_assignment_expression_uid) REFERENCES "BpmnResourceAssignmentExpression" (uid)
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
	timer_event_definition_uid INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(script_id) REFERENCES "FluxnovaScript" (id),
	FOREIGN KEY(timer_event_definition_uid) REFERENCES "BpmnTimerEventDefinition" (uid)
);
CREATE INDEX "ix_FluxnovaTaskListener_id" ON "FluxnovaTaskListener" (id);

CREATE TABLE "BpmnActivity_incoming" (
	"BpmnActivity_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnActivity_uid", incoming),
	FOREIGN KEY("BpmnActivity_uid") REFERENCES "BpmnActivity" (uid)
);
CREATE INDEX "ix_BpmnActivity_incoming_incoming" ON "BpmnActivity_incoming" (incoming);
CREATE INDEX "ix_BpmnActivity_incoming_BpmnActivity_uid" ON "BpmnActivity_incoming" ("BpmnActivity_uid");

CREATE TABLE "BpmnActivity_outgoing" (
	"BpmnActivity_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnActivity_uid", outgoing),
	FOREIGN KEY("BpmnActivity_uid") REFERENCES "BpmnActivity" (uid)
);
CREATE INDEX "ix_BpmnActivity_outgoing_outgoing" ON "BpmnActivity_outgoing" (outgoing);
CREATE INDEX "ix_BpmnActivity_outgoing_BpmnActivity_uid" ON "BpmnActivity_outgoing" ("BpmnActivity_uid");

CREATE TABLE "BpmnActivity_category_value_refs" (
	"BpmnActivity_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnActivity_uid", category_value_refs),
	FOREIGN KEY("BpmnActivity_uid") REFERENCES "BpmnActivity" (uid)
);
CREATE INDEX "ix_BpmnActivity_category_value_refs_category_value_refs" ON "BpmnActivity_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnActivity_category_value_refs_BpmnActivity_uid" ON "BpmnActivity_category_value_refs" ("BpmnActivity_uid");

CREATE TABLE "BpmnAdHocSubProcess_incoming" (
	"BpmnAdHocSubProcess_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnAdHocSubProcess_uid", incoming),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid)
);
CREATE INDEX "ix_BpmnAdHocSubProcess_incoming_BpmnAdHocSubProcess_uid" ON "BpmnAdHocSubProcess_incoming" ("BpmnAdHocSubProcess_uid");
CREATE INDEX "ix_BpmnAdHocSubProcess_incoming_incoming" ON "BpmnAdHocSubProcess_incoming" (incoming);

CREATE TABLE "BpmnAdHocSubProcess_outgoing" (
	"BpmnAdHocSubProcess_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnAdHocSubProcess_uid", outgoing),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid)
);
CREATE INDEX "ix_BpmnAdHocSubProcess_outgoing_outgoing" ON "BpmnAdHocSubProcess_outgoing" (outgoing);
CREATE INDEX "ix_BpmnAdHocSubProcess_outgoing_BpmnAdHocSubProcess_uid" ON "BpmnAdHocSubProcess_outgoing" ("BpmnAdHocSubProcess_uid");

CREATE TABLE "BpmnAdHocSubProcess_category_value_refs" (
	"BpmnAdHocSubProcess_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnAdHocSubProcess_uid", category_value_refs),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid)
);
CREATE INDEX "ix_BpmnAdHocSubProcess_category_value_refs_BpmnAdHocSubProcess_uid" ON "BpmnAdHocSubProcess_category_value_refs" ("BpmnAdHocSubProcess_uid");
CREATE INDEX "ix_BpmnAdHocSubProcess_category_value_refs_category_value_refs" ON "BpmnAdHocSubProcess_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnBusinessRuleTask_incoming" (
	"BpmnBusinessRuleTask_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnBusinessRuleTask_uid", incoming),
	FOREIGN KEY("BpmnBusinessRuleTask_uid") REFERENCES "BpmnBusinessRuleTask" (uid)
);
CREATE INDEX "ix_BpmnBusinessRuleTask_incoming_BpmnBusinessRuleTask_uid" ON "BpmnBusinessRuleTask_incoming" ("BpmnBusinessRuleTask_uid");
CREATE INDEX "ix_BpmnBusinessRuleTask_incoming_incoming" ON "BpmnBusinessRuleTask_incoming" (incoming);

CREATE TABLE "BpmnBusinessRuleTask_outgoing" (
	"BpmnBusinessRuleTask_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnBusinessRuleTask_uid", outgoing),
	FOREIGN KEY("BpmnBusinessRuleTask_uid") REFERENCES "BpmnBusinessRuleTask" (uid)
);
CREATE INDEX "ix_BpmnBusinessRuleTask_outgoing_BpmnBusinessRuleTask_uid" ON "BpmnBusinessRuleTask_outgoing" ("BpmnBusinessRuleTask_uid");
CREATE INDEX "ix_BpmnBusinessRuleTask_outgoing_outgoing" ON "BpmnBusinessRuleTask_outgoing" (outgoing);

CREATE TABLE "BpmnBusinessRuleTask_category_value_refs" (
	"BpmnBusinessRuleTask_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnBusinessRuleTask_uid", category_value_refs),
	FOREIGN KEY("BpmnBusinessRuleTask_uid") REFERENCES "BpmnBusinessRuleTask" (uid)
);
CREATE INDEX "ix_BpmnBusinessRuleTask_category_value_refs_category_value_refs" ON "BpmnBusinessRuleTask_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnBusinessRuleTask_category_value_refs_BpmnBusinessRuleTask_uid" ON "BpmnBusinessRuleTask_category_value_refs" ("BpmnBusinessRuleTask_uid");

CREATE TABLE "BpmnCallActivity_incoming" (
	"BpmnCallActivity_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnCallActivity_uid", incoming),
	FOREIGN KEY("BpmnCallActivity_uid") REFERENCES "BpmnCallActivity" (uid)
);
CREATE INDEX "ix_BpmnCallActivity_incoming_BpmnCallActivity_uid" ON "BpmnCallActivity_incoming" ("BpmnCallActivity_uid");
CREATE INDEX "ix_BpmnCallActivity_incoming_incoming" ON "BpmnCallActivity_incoming" (incoming);

CREATE TABLE "BpmnCallActivity_outgoing" (
	"BpmnCallActivity_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnCallActivity_uid", outgoing),
	FOREIGN KEY("BpmnCallActivity_uid") REFERENCES "BpmnCallActivity" (uid)
);
CREATE INDEX "ix_BpmnCallActivity_outgoing_BpmnCallActivity_uid" ON "BpmnCallActivity_outgoing" ("BpmnCallActivity_uid");
CREATE INDEX "ix_BpmnCallActivity_outgoing_outgoing" ON "BpmnCallActivity_outgoing" (outgoing);

CREATE TABLE "BpmnCallActivity_category_value_refs" (
	"BpmnCallActivity_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnCallActivity_uid", category_value_refs),
	FOREIGN KEY("BpmnCallActivity_uid") REFERENCES "BpmnCallActivity" (uid)
);
CREATE INDEX "ix_BpmnCallActivity_category_value_refs_BpmnCallActivity_uid" ON "BpmnCallActivity_category_value_refs" ("BpmnCallActivity_uid");
CREATE INDEX "ix_BpmnCallActivity_category_value_refs_category_value_refs" ON "BpmnCallActivity_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnCallableElement_supported_interface_refs" (
	"BpmnCallableElement_uid" INTEGER,
	supported_interface_refs TEXT,
	PRIMARY KEY ("BpmnCallableElement_uid", supported_interface_refs),
	FOREIGN KEY("BpmnCallableElement_uid") REFERENCES "BpmnCallableElement" (uid)
);
CREATE INDEX "ix_BpmnCallableElement_supported_interface_refs_BpmnCallableElement_uid" ON "BpmnCallableElement_supported_interface_refs" ("BpmnCallableElement_uid");
CREATE INDEX "ix_BpmnCallableElement_supported_interface_refs_supported_interface_refs" ON "BpmnCallableElement_supported_interface_refs" (supported_interface_refs);

CREATE TABLE "BpmnComplexGateway_incoming" (
	"BpmnComplexGateway_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnComplexGateway_uid", incoming),
	FOREIGN KEY("BpmnComplexGateway_uid") REFERENCES "BpmnComplexGateway" (uid)
);
CREATE INDEX "ix_BpmnComplexGateway_incoming_BpmnComplexGateway_uid" ON "BpmnComplexGateway_incoming" ("BpmnComplexGateway_uid");
CREATE INDEX "ix_BpmnComplexGateway_incoming_incoming" ON "BpmnComplexGateway_incoming" (incoming);

CREATE TABLE "BpmnComplexGateway_outgoing" (
	"BpmnComplexGateway_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnComplexGateway_uid", outgoing),
	FOREIGN KEY("BpmnComplexGateway_uid") REFERENCES "BpmnComplexGateway" (uid)
);
CREATE INDEX "ix_BpmnComplexGateway_outgoing_outgoing" ON "BpmnComplexGateway_outgoing" (outgoing);
CREATE INDEX "ix_BpmnComplexGateway_outgoing_BpmnComplexGateway_uid" ON "BpmnComplexGateway_outgoing" ("BpmnComplexGateway_uid");

CREATE TABLE "BpmnComplexGateway_category_value_refs" (
	"BpmnComplexGateway_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnComplexGateway_uid", category_value_refs),
	FOREIGN KEY("BpmnComplexGateway_uid") REFERENCES "BpmnComplexGateway" (uid)
);
CREATE INDEX "ix_BpmnComplexGateway_category_value_refs_BpmnComplexGateway_uid" ON "BpmnComplexGateway_category_value_refs" ("BpmnComplexGateway_uid");
CREATE INDEX "ix_BpmnComplexGateway_category_value_refs_category_value_refs" ON "BpmnComplexGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnConversationNode_participant_refs" (
	"BpmnConversationNode_uid" INTEGER,
	participant_refs TEXT,
	PRIMARY KEY ("BpmnConversationNode_uid", participant_refs),
	FOREIGN KEY("BpmnConversationNode_uid") REFERENCES "BpmnConversationNode" (uid)
);
CREATE INDEX "ix_BpmnConversationNode_participant_refs_participant_refs" ON "BpmnConversationNode_participant_refs" (participant_refs);
CREATE INDEX "ix_BpmnConversationNode_participant_refs_BpmnConversationNode_uid" ON "BpmnConversationNode_participant_refs" ("BpmnConversationNode_uid");

CREATE TABLE "BpmnConversationNode_message_flow_refs" (
	"BpmnConversationNode_uid" INTEGER,
	message_flow_refs TEXT,
	PRIMARY KEY ("BpmnConversationNode_uid", message_flow_refs),
	FOREIGN KEY("BpmnConversationNode_uid") REFERENCES "BpmnConversationNode" (uid)
);
CREATE INDEX "ix_BpmnConversationNode_message_flow_refs_BpmnConversationNode_uid" ON "BpmnConversationNode_message_flow_refs" ("BpmnConversationNode_uid");
CREATE INDEX "ix_BpmnConversationNode_message_flow_refs_message_flow_refs" ON "BpmnConversationNode_message_flow_refs" (message_flow_refs);

CREATE TABLE "BpmnDataAssociation_source_refs" (
	"BpmnDataAssociation_uid" INTEGER,
	source_refs TEXT,
	PRIMARY KEY ("BpmnDataAssociation_uid", source_refs),
	FOREIGN KEY("BpmnDataAssociation_uid") REFERENCES "BpmnDataAssociation" (uid)
);
CREATE INDEX "ix_BpmnDataAssociation_source_refs_BpmnDataAssociation_uid" ON "BpmnDataAssociation_source_refs" ("BpmnDataAssociation_uid");
CREATE INDEX "ix_BpmnDataAssociation_source_refs_source_refs" ON "BpmnDataAssociation_source_refs" (source_refs);

CREATE TABLE "BpmnDataObject_category_value_refs" (
	"BpmnDataObject_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnDataObject_uid", category_value_refs),
	FOREIGN KEY("BpmnDataObject_uid") REFERENCES "BpmnDataObject" (uid)
);
CREATE INDEX "ix_BpmnDataObject_category_value_refs_BpmnDataObject_uid" ON "BpmnDataObject_category_value_refs" ("BpmnDataObject_uid");
CREATE INDEX "ix_BpmnDataObject_category_value_refs_category_value_refs" ON "BpmnDataObject_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnDataObjectReference_category_value_refs" (
	"BpmnDataObjectReference_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnDataObjectReference_uid", category_value_refs),
	FOREIGN KEY("BpmnDataObjectReference_uid") REFERENCES "BpmnDataObjectReference" (uid)
);
CREATE INDEX "ix_BpmnDataObjectReference_category_value_refs_BpmnDataObjectReference_uid" ON "BpmnDataObjectReference_category_value_refs" ("BpmnDataObjectReference_uid");
CREATE INDEX "ix_BpmnDataObjectReference_category_value_refs_category_value_refs" ON "BpmnDataObjectReference_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnDataStoreReference_category_value_refs" (
	"BpmnDataStoreReference_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnDataStoreReference_uid", category_value_refs),
	FOREIGN KEY("BpmnDataStoreReference_uid") REFERENCES "BpmnDataStoreReference" (uid)
);
CREATE INDEX "ix_BpmnDataStoreReference_category_value_refs_category_value_refs" ON "BpmnDataStoreReference_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnDataStoreReference_category_value_refs_BpmnDataStoreReference_uid" ON "BpmnDataStoreReference_category_value_refs" ("BpmnDataStoreReference_uid");

CREATE TABLE "BpmnEvent_incoming" (
	"BpmnEvent_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnEvent_uid", incoming),
	FOREIGN KEY("BpmnEvent_uid") REFERENCES "BpmnEvent" (uid)
);
CREATE INDEX "ix_BpmnEvent_incoming_BpmnEvent_uid" ON "BpmnEvent_incoming" ("BpmnEvent_uid");
CREATE INDEX "ix_BpmnEvent_incoming_incoming" ON "BpmnEvent_incoming" (incoming);

CREATE TABLE "BpmnEvent_outgoing" (
	"BpmnEvent_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnEvent_uid", outgoing),
	FOREIGN KEY("BpmnEvent_uid") REFERENCES "BpmnEvent" (uid)
);
CREATE INDEX "ix_BpmnEvent_outgoing_BpmnEvent_uid" ON "BpmnEvent_outgoing" ("BpmnEvent_uid");
CREATE INDEX "ix_BpmnEvent_outgoing_outgoing" ON "BpmnEvent_outgoing" (outgoing);

CREATE TABLE "BpmnEvent_category_value_refs" (
	"BpmnEvent_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnEvent_uid", category_value_refs),
	FOREIGN KEY("BpmnEvent_uid") REFERENCES "BpmnEvent" (uid)
);
CREATE INDEX "ix_BpmnEvent_category_value_refs_BpmnEvent_uid" ON "BpmnEvent_category_value_refs" ("BpmnEvent_uid");
CREATE INDEX "ix_BpmnEvent_category_value_refs_category_value_refs" ON "BpmnEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnEventBasedGateway_incoming" (
	"BpmnEventBasedGateway_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnEventBasedGateway_uid", incoming),
	FOREIGN KEY("BpmnEventBasedGateway_uid") REFERENCES "BpmnEventBasedGateway" (uid)
);
CREATE INDEX "ix_BpmnEventBasedGateway_incoming_incoming" ON "BpmnEventBasedGateway_incoming" (incoming);
CREATE INDEX "ix_BpmnEventBasedGateway_incoming_BpmnEventBasedGateway_uid" ON "BpmnEventBasedGateway_incoming" ("BpmnEventBasedGateway_uid");

CREATE TABLE "BpmnEventBasedGateway_outgoing" (
	"BpmnEventBasedGateway_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnEventBasedGateway_uid", outgoing),
	FOREIGN KEY("BpmnEventBasedGateway_uid") REFERENCES "BpmnEventBasedGateway" (uid)
);
CREATE INDEX "ix_BpmnEventBasedGateway_outgoing_BpmnEventBasedGateway_uid" ON "BpmnEventBasedGateway_outgoing" ("BpmnEventBasedGateway_uid");
CREATE INDEX "ix_BpmnEventBasedGateway_outgoing_outgoing" ON "BpmnEventBasedGateway_outgoing" (outgoing);

CREATE TABLE "BpmnEventBasedGateway_category_value_refs" (
	"BpmnEventBasedGateway_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnEventBasedGateway_uid", category_value_refs),
	FOREIGN KEY("BpmnEventBasedGateway_uid") REFERENCES "BpmnEventBasedGateway" (uid)
);
CREATE INDEX "ix_BpmnEventBasedGateway_category_value_refs_category_value_refs" ON "BpmnEventBasedGateway_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnEventBasedGateway_category_value_refs_BpmnEventBasedGateway_uid" ON "BpmnEventBasedGateway_category_value_refs" ("BpmnEventBasedGateway_uid");

CREATE TABLE "BpmnExclusiveGateway_incoming" (
	"BpmnExclusiveGateway_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnExclusiveGateway_uid", incoming),
	FOREIGN KEY("BpmnExclusiveGateway_uid") REFERENCES "BpmnExclusiveGateway" (uid)
);
CREATE INDEX "ix_BpmnExclusiveGateway_incoming_BpmnExclusiveGateway_uid" ON "BpmnExclusiveGateway_incoming" ("BpmnExclusiveGateway_uid");
CREATE INDEX "ix_BpmnExclusiveGateway_incoming_incoming" ON "BpmnExclusiveGateway_incoming" (incoming);

CREATE TABLE "BpmnExclusiveGateway_outgoing" (
	"BpmnExclusiveGateway_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnExclusiveGateway_uid", outgoing),
	FOREIGN KEY("BpmnExclusiveGateway_uid") REFERENCES "BpmnExclusiveGateway" (uid)
);
CREATE INDEX "ix_BpmnExclusiveGateway_outgoing_BpmnExclusiveGateway_uid" ON "BpmnExclusiveGateway_outgoing" ("BpmnExclusiveGateway_uid");
CREATE INDEX "ix_BpmnExclusiveGateway_outgoing_outgoing" ON "BpmnExclusiveGateway_outgoing" (outgoing);

CREATE TABLE "BpmnExclusiveGateway_category_value_refs" (
	"BpmnExclusiveGateway_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnExclusiveGateway_uid", category_value_refs),
	FOREIGN KEY("BpmnExclusiveGateway_uid") REFERENCES "BpmnExclusiveGateway" (uid)
);
CREATE INDEX "ix_BpmnExclusiveGateway_category_value_refs_BpmnExclusiveGateway_uid" ON "BpmnExclusiveGateway_category_value_refs" ("BpmnExclusiveGateway_uid");
CREATE INDEX "ix_BpmnExclusiveGateway_category_value_refs_category_value_refs" ON "BpmnExclusiveGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnFlowNode_incoming" (
	"BpmnFlowNode_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnFlowNode_uid", incoming),
	FOREIGN KEY("BpmnFlowNode_uid") REFERENCES "BpmnFlowNode" (uid)
);
CREATE INDEX "ix_BpmnFlowNode_incoming_BpmnFlowNode_uid" ON "BpmnFlowNode_incoming" ("BpmnFlowNode_uid");
CREATE INDEX "ix_BpmnFlowNode_incoming_incoming" ON "BpmnFlowNode_incoming" (incoming);

CREATE TABLE "BpmnFlowNode_outgoing" (
	"BpmnFlowNode_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnFlowNode_uid", outgoing),
	FOREIGN KEY("BpmnFlowNode_uid") REFERENCES "BpmnFlowNode" (uid)
);
CREATE INDEX "ix_BpmnFlowNode_outgoing_BpmnFlowNode_uid" ON "BpmnFlowNode_outgoing" ("BpmnFlowNode_uid");
CREATE INDEX "ix_BpmnFlowNode_outgoing_outgoing" ON "BpmnFlowNode_outgoing" (outgoing);

CREATE TABLE "BpmnFlowNode_category_value_refs" (
	"BpmnFlowNode_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnFlowNode_uid", category_value_refs),
	FOREIGN KEY("BpmnFlowNode_uid") REFERENCES "BpmnFlowNode" (uid)
);
CREATE INDEX "ix_BpmnFlowNode_category_value_refs_BpmnFlowNode_uid" ON "BpmnFlowNode_category_value_refs" ("BpmnFlowNode_uid");
CREATE INDEX "ix_BpmnFlowNode_category_value_refs_category_value_refs" ON "BpmnFlowNode_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnGateway_incoming" (
	"BpmnGateway_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnGateway_uid", incoming),
	FOREIGN KEY("BpmnGateway_uid") REFERENCES "BpmnGateway" (uid)
);
CREATE INDEX "ix_BpmnGateway_incoming_incoming" ON "BpmnGateway_incoming" (incoming);
CREATE INDEX "ix_BpmnGateway_incoming_BpmnGateway_uid" ON "BpmnGateway_incoming" ("BpmnGateway_uid");

CREATE TABLE "BpmnGateway_outgoing" (
	"BpmnGateway_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnGateway_uid", outgoing),
	FOREIGN KEY("BpmnGateway_uid") REFERENCES "BpmnGateway" (uid)
);
CREATE INDEX "ix_BpmnGateway_outgoing_BpmnGateway_uid" ON "BpmnGateway_outgoing" ("BpmnGateway_uid");
CREATE INDEX "ix_BpmnGateway_outgoing_outgoing" ON "BpmnGateway_outgoing" (outgoing);

CREATE TABLE "BpmnGateway_category_value_refs" (
	"BpmnGateway_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnGateway_uid", category_value_refs),
	FOREIGN KEY("BpmnGateway_uid") REFERENCES "BpmnGateway" (uid)
);
CREATE INDEX "ix_BpmnGateway_category_value_refs_BpmnGateway_uid" ON "BpmnGateway_category_value_refs" ("BpmnGateway_uid");
CREATE INDEX "ix_BpmnGateway_category_value_refs_category_value_refs" ON "BpmnGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnInclusiveGateway_incoming" (
	"BpmnInclusiveGateway_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnInclusiveGateway_uid", incoming),
	FOREIGN KEY("BpmnInclusiveGateway_uid") REFERENCES "BpmnInclusiveGateway" (uid)
);
CREATE INDEX "ix_BpmnInclusiveGateway_incoming_BpmnInclusiveGateway_uid" ON "BpmnInclusiveGateway_incoming" ("BpmnInclusiveGateway_uid");
CREATE INDEX "ix_BpmnInclusiveGateway_incoming_incoming" ON "BpmnInclusiveGateway_incoming" (incoming);

CREATE TABLE "BpmnInclusiveGateway_outgoing" (
	"BpmnInclusiveGateway_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnInclusiveGateway_uid", outgoing),
	FOREIGN KEY("BpmnInclusiveGateway_uid") REFERENCES "BpmnInclusiveGateway" (uid)
);
CREATE INDEX "ix_BpmnInclusiveGateway_outgoing_outgoing" ON "BpmnInclusiveGateway_outgoing" (outgoing);
CREATE INDEX "ix_BpmnInclusiveGateway_outgoing_BpmnInclusiveGateway_uid" ON "BpmnInclusiveGateway_outgoing" ("BpmnInclusiveGateway_uid");

CREATE TABLE "BpmnInclusiveGateway_category_value_refs" (
	"BpmnInclusiveGateway_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnInclusiveGateway_uid", category_value_refs),
	FOREIGN KEY("BpmnInclusiveGateway_uid") REFERENCES "BpmnInclusiveGateway" (uid)
);
CREATE INDEX "ix_BpmnInclusiveGateway_category_value_refs_BpmnInclusiveGateway_uid" ON "BpmnInclusiveGateway_category_value_refs" ("BpmnInclusiveGateway_uid");
CREATE INDEX "ix_BpmnInclusiveGateway_category_value_refs_category_value_refs" ON "BpmnInclusiveGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnInputSet_data_input_refs" (
	"BpmnInputSet_uid" INTEGER,
	data_input_refs TEXT,
	PRIMARY KEY ("BpmnInputSet_uid", data_input_refs),
	FOREIGN KEY("BpmnInputSet_uid") REFERENCES "BpmnInputSet" (uid)
);
CREATE INDEX "ix_BpmnInputSet_data_input_refs_BpmnInputSet_uid" ON "BpmnInputSet_data_input_refs" ("BpmnInputSet_uid");
CREATE INDEX "ix_BpmnInputSet_data_input_refs_data_input_refs" ON "BpmnInputSet_data_input_refs" (data_input_refs);

CREATE TABLE "BpmnInputSet_optional_input_refs" (
	"BpmnInputSet_uid" INTEGER,
	optional_input_refs TEXT,
	PRIMARY KEY ("BpmnInputSet_uid", optional_input_refs),
	FOREIGN KEY("BpmnInputSet_uid") REFERENCES "BpmnInputSet" (uid)
);
CREATE INDEX "ix_BpmnInputSet_optional_input_refs_BpmnInputSet_uid" ON "BpmnInputSet_optional_input_refs" ("BpmnInputSet_uid");
CREATE INDEX "ix_BpmnInputSet_optional_input_refs_optional_input_refs" ON "BpmnInputSet_optional_input_refs" (optional_input_refs);

CREATE TABLE "BpmnInputSet_while_executing_input_refs" (
	"BpmnInputSet_uid" INTEGER,
	while_executing_input_refs TEXT,
	PRIMARY KEY ("BpmnInputSet_uid", while_executing_input_refs),
	FOREIGN KEY("BpmnInputSet_uid") REFERENCES "BpmnInputSet" (uid)
);
CREATE INDEX "ix_BpmnInputSet_while_executing_input_refs_while_executing_input_refs" ON "BpmnInputSet_while_executing_input_refs" (while_executing_input_refs);
CREATE INDEX "ix_BpmnInputSet_while_executing_input_refs_BpmnInputSet_uid" ON "BpmnInputSet_while_executing_input_refs" ("BpmnInputSet_uid");

CREATE TABLE "BpmnInputSet_output_set_refs" (
	"BpmnInputSet_uid" INTEGER,
	output_set_refs TEXT,
	PRIMARY KEY ("BpmnInputSet_uid", output_set_refs),
	FOREIGN KEY("BpmnInputSet_uid") REFERENCES "BpmnInputSet" (uid)
);
CREATE INDEX "ix_BpmnInputSet_output_set_refs_BpmnInputSet_uid" ON "BpmnInputSet_output_set_refs" ("BpmnInputSet_uid");
CREATE INDEX "ix_BpmnInputSet_output_set_refs_output_set_refs" ON "BpmnInputSet_output_set_refs" (output_set_refs);

CREATE TABLE "BpmnManualTask_incoming" (
	"BpmnManualTask_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnManualTask_uid", incoming),
	FOREIGN KEY("BpmnManualTask_uid") REFERENCES "BpmnManualTask" (uid)
);
CREATE INDEX "ix_BpmnManualTask_incoming_incoming" ON "BpmnManualTask_incoming" (incoming);
CREATE INDEX "ix_BpmnManualTask_incoming_BpmnManualTask_uid" ON "BpmnManualTask_incoming" ("BpmnManualTask_uid");

CREATE TABLE "BpmnManualTask_outgoing" (
	"BpmnManualTask_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnManualTask_uid", outgoing),
	FOREIGN KEY("BpmnManualTask_uid") REFERENCES "BpmnManualTask" (uid)
);
CREATE INDEX "ix_BpmnManualTask_outgoing_BpmnManualTask_uid" ON "BpmnManualTask_outgoing" ("BpmnManualTask_uid");
CREATE INDEX "ix_BpmnManualTask_outgoing_outgoing" ON "BpmnManualTask_outgoing" (outgoing);

CREATE TABLE "BpmnManualTask_category_value_refs" (
	"BpmnManualTask_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnManualTask_uid", category_value_refs),
	FOREIGN KEY("BpmnManualTask_uid") REFERENCES "BpmnManualTask" (uid)
);
CREATE INDEX "ix_BpmnManualTask_category_value_refs_BpmnManualTask_uid" ON "BpmnManualTask_category_value_refs" ("BpmnManualTask_uid");
CREATE INDEX "ix_BpmnManualTask_category_value_refs_category_value_refs" ON "BpmnManualTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnOperation_error_refs" (
	"BpmnOperation_uid" INTEGER,
	error_refs TEXT,
	PRIMARY KEY ("BpmnOperation_uid", error_refs),
	FOREIGN KEY("BpmnOperation_uid") REFERENCES "BpmnOperation" (uid)
);
CREATE INDEX "ix_BpmnOperation_error_refs_BpmnOperation_uid" ON "BpmnOperation_error_refs" ("BpmnOperation_uid");
CREATE INDEX "ix_BpmnOperation_error_refs_error_refs" ON "BpmnOperation_error_refs" (error_refs);

CREATE TABLE "BpmnOutputSet_data_output_refs" (
	"BpmnOutputSet_uid" INTEGER,
	data_output_refs TEXT,
	PRIMARY KEY ("BpmnOutputSet_uid", data_output_refs),
	FOREIGN KEY("BpmnOutputSet_uid") REFERENCES "BpmnOutputSet" (uid)
);
CREATE INDEX "ix_BpmnOutputSet_data_output_refs_data_output_refs" ON "BpmnOutputSet_data_output_refs" (data_output_refs);
CREATE INDEX "ix_BpmnOutputSet_data_output_refs_BpmnOutputSet_uid" ON "BpmnOutputSet_data_output_refs" ("BpmnOutputSet_uid");

CREATE TABLE "BpmnOutputSet_optional_output_refs" (
	"BpmnOutputSet_uid" INTEGER,
	optional_output_refs TEXT,
	PRIMARY KEY ("BpmnOutputSet_uid", optional_output_refs),
	FOREIGN KEY("BpmnOutputSet_uid") REFERENCES "BpmnOutputSet" (uid)
);
CREATE INDEX "ix_BpmnOutputSet_optional_output_refs_BpmnOutputSet_uid" ON "BpmnOutputSet_optional_output_refs" ("BpmnOutputSet_uid");
CREATE INDEX "ix_BpmnOutputSet_optional_output_refs_optional_output_refs" ON "BpmnOutputSet_optional_output_refs" (optional_output_refs);

CREATE TABLE "BpmnOutputSet_while_executing_output_refs" (
	"BpmnOutputSet_uid" INTEGER,
	while_executing_output_refs TEXT,
	PRIMARY KEY ("BpmnOutputSet_uid", while_executing_output_refs),
	FOREIGN KEY("BpmnOutputSet_uid") REFERENCES "BpmnOutputSet" (uid)
);
CREATE INDEX "ix_BpmnOutputSet_while_executing_output_refs_BpmnOutputSet_uid" ON "BpmnOutputSet_while_executing_output_refs" ("BpmnOutputSet_uid");
CREATE INDEX "ix_BpmnOutputSet_while_executing_output_refs_while_executing_output_refs" ON "BpmnOutputSet_while_executing_output_refs" (while_executing_output_refs);

CREATE TABLE "BpmnOutputSet_input_set_refs" (
	"BpmnOutputSet_uid" INTEGER,
	input_set_refs TEXT,
	PRIMARY KEY ("BpmnOutputSet_uid", input_set_refs),
	FOREIGN KEY("BpmnOutputSet_uid") REFERENCES "BpmnOutputSet" (uid)
);
CREATE INDEX "ix_BpmnOutputSet_input_set_refs_BpmnOutputSet_uid" ON "BpmnOutputSet_input_set_refs" ("BpmnOutputSet_uid");
CREATE INDEX "ix_BpmnOutputSet_input_set_refs_input_set_refs" ON "BpmnOutputSet_input_set_refs" (input_set_refs);

CREATE TABLE "BpmnParallelGateway_incoming" (
	"BpmnParallelGateway_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnParallelGateway_uid", incoming),
	FOREIGN KEY("BpmnParallelGateway_uid") REFERENCES "BpmnParallelGateway" (uid)
);
CREATE INDEX "ix_BpmnParallelGateway_incoming_incoming" ON "BpmnParallelGateway_incoming" (incoming);
CREATE INDEX "ix_BpmnParallelGateway_incoming_BpmnParallelGateway_uid" ON "BpmnParallelGateway_incoming" ("BpmnParallelGateway_uid");

CREATE TABLE "BpmnParallelGateway_outgoing" (
	"BpmnParallelGateway_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnParallelGateway_uid", outgoing),
	FOREIGN KEY("BpmnParallelGateway_uid") REFERENCES "BpmnParallelGateway" (uid)
);
CREATE INDEX "ix_BpmnParallelGateway_outgoing_BpmnParallelGateway_uid" ON "BpmnParallelGateway_outgoing" ("BpmnParallelGateway_uid");
CREATE INDEX "ix_BpmnParallelGateway_outgoing_outgoing" ON "BpmnParallelGateway_outgoing" (outgoing);

CREATE TABLE "BpmnParallelGateway_category_value_refs" (
	"BpmnParallelGateway_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnParallelGateway_uid", category_value_refs),
	FOREIGN KEY("BpmnParallelGateway_uid") REFERENCES "BpmnParallelGateway" (uid)
);
CREATE INDEX "ix_BpmnParallelGateway_category_value_refs_BpmnParallelGateway_uid" ON "BpmnParallelGateway_category_value_refs" ("BpmnParallelGateway_uid");
CREATE INDEX "ix_BpmnParallelGateway_category_value_refs_category_value_refs" ON "BpmnParallelGateway_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnParticipant_interface_refs" (
	"BpmnParticipant_uid" INTEGER,
	interface_refs TEXT,
	PRIMARY KEY ("BpmnParticipant_uid", interface_refs),
	FOREIGN KEY("BpmnParticipant_uid") REFERENCES "BpmnParticipant" (uid)
);
CREATE INDEX "ix_BpmnParticipant_interface_refs_BpmnParticipant_uid" ON "BpmnParticipant_interface_refs" ("BpmnParticipant_uid");
CREATE INDEX "ix_BpmnParticipant_interface_refs_interface_refs" ON "BpmnParticipant_interface_refs" (interface_refs);

CREATE TABLE "BpmnParticipant_end_point_refs" (
	"BpmnParticipant_uid" INTEGER,
	end_point_refs TEXT,
	PRIMARY KEY ("BpmnParticipant_uid", end_point_refs),
	FOREIGN KEY("BpmnParticipant_uid") REFERENCES "BpmnParticipant" (uid)
);
CREATE INDEX "ix_BpmnParticipant_end_point_refs_end_point_refs" ON "BpmnParticipant_end_point_refs" (end_point_refs);
CREATE INDEX "ix_BpmnParticipant_end_point_refs_BpmnParticipant_uid" ON "BpmnParticipant_end_point_refs" ("BpmnParticipant_uid");

CREATE TABLE "BpmnProcess_supports" (
	"BpmnProcess_uid" INTEGER,
	supports TEXT,
	PRIMARY KEY ("BpmnProcess_uid", supports),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid)
);
CREATE INDEX "ix_BpmnProcess_supports_BpmnProcess_uid" ON "BpmnProcess_supports" ("BpmnProcess_uid");
CREATE INDEX "ix_BpmnProcess_supports_supports" ON "BpmnProcess_supports" (supports);

CREATE TABLE "BpmnProcess_supported_interface_refs" (
	"BpmnProcess_uid" INTEGER,
	supported_interface_refs TEXT,
	PRIMARY KEY ("BpmnProcess_uid", supported_interface_refs),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid)
);
CREATE INDEX "ix_BpmnProcess_supported_interface_refs_BpmnProcess_uid" ON "BpmnProcess_supported_interface_refs" ("BpmnProcess_uid");
CREATE INDEX "ix_BpmnProcess_supported_interface_refs_supported_interface_refs" ON "BpmnProcess_supported_interface_refs" (supported_interface_refs);

CREATE TABLE "BpmnReceiveTask_incoming" (
	"BpmnReceiveTask_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnReceiveTask_uid", incoming),
	FOREIGN KEY("BpmnReceiveTask_uid") REFERENCES "BpmnReceiveTask" (uid)
);
CREATE INDEX "ix_BpmnReceiveTask_incoming_BpmnReceiveTask_uid" ON "BpmnReceiveTask_incoming" ("BpmnReceiveTask_uid");
CREATE INDEX "ix_BpmnReceiveTask_incoming_incoming" ON "BpmnReceiveTask_incoming" (incoming);

CREATE TABLE "BpmnReceiveTask_outgoing" (
	"BpmnReceiveTask_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnReceiveTask_uid", outgoing),
	FOREIGN KEY("BpmnReceiveTask_uid") REFERENCES "BpmnReceiveTask" (uid)
);
CREATE INDEX "ix_BpmnReceiveTask_outgoing_outgoing" ON "BpmnReceiveTask_outgoing" (outgoing);
CREATE INDEX "ix_BpmnReceiveTask_outgoing_BpmnReceiveTask_uid" ON "BpmnReceiveTask_outgoing" ("BpmnReceiveTask_uid");

CREATE TABLE "BpmnReceiveTask_category_value_refs" (
	"BpmnReceiveTask_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnReceiveTask_uid", category_value_refs),
	FOREIGN KEY("BpmnReceiveTask_uid") REFERENCES "BpmnReceiveTask" (uid)
);
CREATE INDEX "ix_BpmnReceiveTask_category_value_refs_BpmnReceiveTask_uid" ON "BpmnReceiveTask_category_value_refs" ("BpmnReceiveTask_uid");
CREATE INDEX "ix_BpmnReceiveTask_category_value_refs_category_value_refs" ON "BpmnReceiveTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnScriptTask_incoming" (
	"BpmnScriptTask_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnScriptTask_uid", incoming),
	FOREIGN KEY("BpmnScriptTask_uid") REFERENCES "BpmnScriptTask" (uid)
);
CREATE INDEX "ix_BpmnScriptTask_incoming_BpmnScriptTask_uid" ON "BpmnScriptTask_incoming" ("BpmnScriptTask_uid");
CREATE INDEX "ix_BpmnScriptTask_incoming_incoming" ON "BpmnScriptTask_incoming" (incoming);

CREATE TABLE "BpmnScriptTask_outgoing" (
	"BpmnScriptTask_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnScriptTask_uid", outgoing),
	FOREIGN KEY("BpmnScriptTask_uid") REFERENCES "BpmnScriptTask" (uid)
);
CREATE INDEX "ix_BpmnScriptTask_outgoing_BpmnScriptTask_uid" ON "BpmnScriptTask_outgoing" ("BpmnScriptTask_uid");
CREATE INDEX "ix_BpmnScriptTask_outgoing_outgoing" ON "BpmnScriptTask_outgoing" (outgoing);

CREATE TABLE "BpmnScriptTask_category_value_refs" (
	"BpmnScriptTask_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnScriptTask_uid", category_value_refs),
	FOREIGN KEY("BpmnScriptTask_uid") REFERENCES "BpmnScriptTask" (uid)
);
CREATE INDEX "ix_BpmnScriptTask_category_value_refs_BpmnScriptTask_uid" ON "BpmnScriptTask_category_value_refs" ("BpmnScriptTask_uid");
CREATE INDEX "ix_BpmnScriptTask_category_value_refs_category_value_refs" ON "BpmnScriptTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnSendTask_incoming" (
	"BpmnSendTask_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnSendTask_uid", incoming),
	FOREIGN KEY("BpmnSendTask_uid") REFERENCES "BpmnSendTask" (uid)
);
CREATE INDEX "ix_BpmnSendTask_incoming_BpmnSendTask_uid" ON "BpmnSendTask_incoming" ("BpmnSendTask_uid");
CREATE INDEX "ix_BpmnSendTask_incoming_incoming" ON "BpmnSendTask_incoming" (incoming);

CREATE TABLE "BpmnSendTask_outgoing" (
	"BpmnSendTask_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnSendTask_uid", outgoing),
	FOREIGN KEY("BpmnSendTask_uid") REFERENCES "BpmnSendTask" (uid)
);
CREATE INDEX "ix_BpmnSendTask_outgoing_outgoing" ON "BpmnSendTask_outgoing" (outgoing);
CREATE INDEX "ix_BpmnSendTask_outgoing_BpmnSendTask_uid" ON "BpmnSendTask_outgoing" ("BpmnSendTask_uid");

CREATE TABLE "BpmnSendTask_category_value_refs" (
	"BpmnSendTask_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnSendTask_uid", category_value_refs),
	FOREIGN KEY("BpmnSendTask_uid") REFERENCES "BpmnSendTask" (uid)
);
CREATE INDEX "ix_BpmnSendTask_category_value_refs_BpmnSendTask_uid" ON "BpmnSendTask_category_value_refs" ("BpmnSendTask_uid");
CREATE INDEX "ix_BpmnSendTask_category_value_refs_category_value_refs" ON "BpmnSendTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnSequenceFlow_category_value_refs" (
	"BpmnSequenceFlow_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnSequenceFlow_uid", category_value_refs),
	FOREIGN KEY("BpmnSequenceFlow_uid") REFERENCES "BpmnSequenceFlow" (uid)
);
CREATE INDEX "ix_BpmnSequenceFlow_category_value_refs_BpmnSequenceFlow_uid" ON "BpmnSequenceFlow_category_value_refs" ("BpmnSequenceFlow_uid");
CREATE INDEX "ix_BpmnSequenceFlow_category_value_refs_category_value_refs" ON "BpmnSequenceFlow_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnServiceTask_incoming" (
	"BpmnServiceTask_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnServiceTask_uid", incoming),
	FOREIGN KEY("BpmnServiceTask_uid") REFERENCES "BpmnServiceTask" (uid)
);
CREATE INDEX "ix_BpmnServiceTask_incoming_BpmnServiceTask_uid" ON "BpmnServiceTask_incoming" ("BpmnServiceTask_uid");
CREATE INDEX "ix_BpmnServiceTask_incoming_incoming" ON "BpmnServiceTask_incoming" (incoming);

CREATE TABLE "BpmnServiceTask_outgoing" (
	"BpmnServiceTask_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnServiceTask_uid", outgoing),
	FOREIGN KEY("BpmnServiceTask_uid") REFERENCES "BpmnServiceTask" (uid)
);
CREATE INDEX "ix_BpmnServiceTask_outgoing_outgoing" ON "BpmnServiceTask_outgoing" (outgoing);
CREATE INDEX "ix_BpmnServiceTask_outgoing_BpmnServiceTask_uid" ON "BpmnServiceTask_outgoing" ("BpmnServiceTask_uid");

CREATE TABLE "BpmnServiceTask_category_value_refs" (
	"BpmnServiceTask_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnServiceTask_uid", category_value_refs),
	FOREIGN KEY("BpmnServiceTask_uid") REFERENCES "BpmnServiceTask" (uid)
);
CREATE INDEX "ix_BpmnServiceTask_category_value_refs_BpmnServiceTask_uid" ON "BpmnServiceTask_category_value_refs" ("BpmnServiceTask_uid");
CREATE INDEX "ix_BpmnServiceTask_category_value_refs_category_value_refs" ON "BpmnServiceTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnSubProcess_incoming" (
	"BpmnSubProcess_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnSubProcess_uid", incoming),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid)
);
CREATE INDEX "ix_BpmnSubProcess_incoming_incoming" ON "BpmnSubProcess_incoming" (incoming);
CREATE INDEX "ix_BpmnSubProcess_incoming_BpmnSubProcess_uid" ON "BpmnSubProcess_incoming" ("BpmnSubProcess_uid");

CREATE TABLE "BpmnSubProcess_outgoing" (
	"BpmnSubProcess_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnSubProcess_uid", outgoing),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid)
);
CREATE INDEX "ix_BpmnSubProcess_outgoing_BpmnSubProcess_uid" ON "BpmnSubProcess_outgoing" ("BpmnSubProcess_uid");
CREATE INDEX "ix_BpmnSubProcess_outgoing_outgoing" ON "BpmnSubProcess_outgoing" (outgoing);

CREATE TABLE "BpmnSubProcess_category_value_refs" (
	"BpmnSubProcess_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnSubProcess_uid", category_value_refs),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid)
);
CREATE INDEX "ix_BpmnSubProcess_category_value_refs_BpmnSubProcess_uid" ON "BpmnSubProcess_category_value_refs" ("BpmnSubProcess_uid");
CREATE INDEX "ix_BpmnSubProcess_category_value_refs_category_value_refs" ON "BpmnSubProcess_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnTask_incoming" (
	"BpmnTask_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnTask_uid", incoming),
	FOREIGN KEY("BpmnTask_uid") REFERENCES "BpmnTask" (uid)
);
CREATE INDEX "ix_BpmnTask_incoming_BpmnTask_uid" ON "BpmnTask_incoming" ("BpmnTask_uid");
CREATE INDEX "ix_BpmnTask_incoming_incoming" ON "BpmnTask_incoming" (incoming);

CREATE TABLE "BpmnTask_outgoing" (
	"BpmnTask_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnTask_uid", outgoing),
	FOREIGN KEY("BpmnTask_uid") REFERENCES "BpmnTask" (uid)
);
CREATE INDEX "ix_BpmnTask_outgoing_outgoing" ON "BpmnTask_outgoing" (outgoing);
CREATE INDEX "ix_BpmnTask_outgoing_BpmnTask_uid" ON "BpmnTask_outgoing" ("BpmnTask_uid");

CREATE TABLE "BpmnTask_category_value_refs" (
	"BpmnTask_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnTask_uid", category_value_refs),
	FOREIGN KEY("BpmnTask_uid") REFERENCES "BpmnTask" (uid)
);
CREATE INDEX "ix_BpmnTask_category_value_refs_BpmnTask_uid" ON "BpmnTask_category_value_refs" ("BpmnTask_uid");
CREATE INDEX "ix_BpmnTask_category_value_refs_category_value_refs" ON "BpmnTask_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnTransaction_incoming" (
	"BpmnTransaction_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnTransaction_uid", incoming),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid)
);
CREATE INDEX "ix_BpmnTransaction_incoming_BpmnTransaction_uid" ON "BpmnTransaction_incoming" ("BpmnTransaction_uid");
CREATE INDEX "ix_BpmnTransaction_incoming_incoming" ON "BpmnTransaction_incoming" (incoming);

CREATE TABLE "BpmnTransaction_outgoing" (
	"BpmnTransaction_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnTransaction_uid", outgoing),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid)
);
CREATE INDEX "ix_BpmnTransaction_outgoing_BpmnTransaction_uid" ON "BpmnTransaction_outgoing" ("BpmnTransaction_uid");
CREATE INDEX "ix_BpmnTransaction_outgoing_outgoing" ON "BpmnTransaction_outgoing" (outgoing);

CREATE TABLE "BpmnTransaction_category_value_refs" (
	"BpmnTransaction_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnTransaction_uid", category_value_refs),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid)
);
CREATE INDEX "ix_BpmnTransaction_category_value_refs_category_value_refs" ON "BpmnTransaction_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnTransaction_category_value_refs_BpmnTransaction_uid" ON "BpmnTransaction_category_value_refs" ("BpmnTransaction_uid");

CREATE TABLE "BpmnUserTask_incoming" (
	"BpmnUserTask_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnUserTask_uid", incoming),
	FOREIGN KEY("BpmnUserTask_uid") REFERENCES "BpmnUserTask" (uid)
);
CREATE INDEX "ix_BpmnUserTask_incoming_BpmnUserTask_uid" ON "BpmnUserTask_incoming" ("BpmnUserTask_uid");
CREATE INDEX "ix_BpmnUserTask_incoming_incoming" ON "BpmnUserTask_incoming" (incoming);

CREATE TABLE "BpmnUserTask_outgoing" (
	"BpmnUserTask_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnUserTask_uid", outgoing),
	FOREIGN KEY("BpmnUserTask_uid") REFERENCES "BpmnUserTask" (uid)
);
CREATE INDEX "ix_BpmnUserTask_outgoing_BpmnUserTask_uid" ON "BpmnUserTask_outgoing" ("BpmnUserTask_uid");
CREATE INDEX "ix_BpmnUserTask_outgoing_outgoing" ON "BpmnUserTask_outgoing" (outgoing);

CREATE TABLE "BpmnUserTask_category_value_refs" (
	"BpmnUserTask_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnUserTask_uid", category_value_refs),
	FOREIGN KEY("BpmnUserTask_uid") REFERENCES "BpmnUserTask" (uid)
);
CREATE INDEX "ix_BpmnUserTask_category_value_refs_BpmnUserTask_uid" ON "BpmnUserTask_category_value_refs" ("BpmnUserTask_uid");
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
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnMultiInstanceLoopCharacteristics_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnMultiInstanceLoopCharacteristics_uid") REFERENCES "BpmnMultiInstanceLoopCharacteristics" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnComplexBehaviorDefinition_uid" ON "BpmnComplexBehaviorDefinition" (uid);

CREATE TABLE "BpmnCorrelationPropertyBinding" (
	uid INTEGER NOT NULL,
	correlation_property_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnCorrelationSubscription_uid" INTEGER,
	data_path_uid INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnCorrelationSubscription_uid") REFERENCES "BpmnCorrelationSubscription" (uid),
	FOREIGN KEY(data_path_uid) REFERENCES "BpmnDataPath" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnCorrelationPropertyBinding_uid" ON "BpmnCorrelationPropertyBinding" (uid);

CREATE TABLE "BpmnDataInput" (
	uid INTEGER NOT NULL,
	name TEXT,
	is_collection BOOLEAN,
	item_subject_ref TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnEndEvent_uid" INTEGER,
	"BpmnIntermediateThrowEvent_uid" INTEGER,
	"BpmnIoSpecification_uid" INTEGER,
	"BpmnThrowEvent_uid" INTEGER,
	data_state_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnEndEvent_uid") REFERENCES "BpmnEndEvent" (uid),
	FOREIGN KEY("BpmnIntermediateThrowEvent_uid") REFERENCES "BpmnIntermediateThrowEvent" (uid),
	FOREIGN KEY("BpmnIoSpecification_uid") REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY("BpmnThrowEvent_uid") REFERENCES "BpmnThrowEvent" (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataInput_uid" ON "BpmnDataInput" (uid);

CREATE TABLE "BpmnDataInputAssociation" (
	uid INTEGER NOT NULL,
	target_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnActivity_uid" INTEGER,
	"BpmnAdHocSubProcess_uid" INTEGER,
	"BpmnBusinessRuleTask_uid" INTEGER,
	"BpmnCallActivity_uid" INTEGER,
	"BpmnEndEvent_uid" INTEGER,
	"BpmnIntermediateThrowEvent_uid" INTEGER,
	"BpmnManualTask_uid" INTEGER,
	"BpmnReceiveTask_uid" INTEGER,
	"BpmnScriptTask_uid" INTEGER,
	"BpmnSendTask_uid" INTEGER,
	"BpmnServiceTask_uid" INTEGER,
	"BpmnSubProcess_uid" INTEGER,
	"BpmnTask_uid" INTEGER,
	"BpmnThrowEvent_uid" INTEGER,
	"BpmnTransaction_uid" INTEGER,
	"BpmnUserTask_uid" INTEGER,
	transformation_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnActivity_uid") REFERENCES "BpmnActivity" (uid),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid),
	FOREIGN KEY("BpmnBusinessRuleTask_uid") REFERENCES "BpmnBusinessRuleTask" (uid),
	FOREIGN KEY("BpmnCallActivity_uid") REFERENCES "BpmnCallActivity" (uid),
	FOREIGN KEY("BpmnEndEvent_uid") REFERENCES "BpmnEndEvent" (uid),
	FOREIGN KEY("BpmnIntermediateThrowEvent_uid") REFERENCES "BpmnIntermediateThrowEvent" (uid),
	FOREIGN KEY("BpmnManualTask_uid") REFERENCES "BpmnManualTask" (uid),
	FOREIGN KEY("BpmnReceiveTask_uid") REFERENCES "BpmnReceiveTask" (uid),
	FOREIGN KEY("BpmnScriptTask_uid") REFERENCES "BpmnScriptTask" (uid),
	FOREIGN KEY("BpmnSendTask_uid") REFERENCES "BpmnSendTask" (uid),
	FOREIGN KEY("BpmnServiceTask_uid") REFERENCES "BpmnServiceTask" (uid),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid),
	FOREIGN KEY("BpmnTask_uid") REFERENCES "BpmnTask" (uid),
	FOREIGN KEY("BpmnThrowEvent_uid") REFERENCES "BpmnThrowEvent" (uid),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid),
	FOREIGN KEY("BpmnUserTask_uid") REFERENCES "BpmnUserTask" (uid),
	FOREIGN KEY(transformation_uid) REFERENCES "BpmnTransformation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataInputAssociation_uid" ON "BpmnDataInputAssociation" (uid);

CREATE TABLE "BpmnDataOutput" (
	uid INTEGER NOT NULL,
	name TEXT,
	is_collection BOOLEAN,
	item_subject_ref TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnBoundaryEvent_uid" INTEGER,
	"BpmnCatchEvent_uid" INTEGER,
	"BpmnIntermediateCatchEvent_uid" INTEGER,
	"BpmnIoSpecification_uid" INTEGER,
	"BpmnStartEvent_uid" INTEGER,
	data_state_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnBoundaryEvent_uid") REFERENCES "BpmnBoundaryEvent" (uid),
	FOREIGN KEY("BpmnCatchEvent_uid") REFERENCES "BpmnCatchEvent" (uid),
	FOREIGN KEY("BpmnIntermediateCatchEvent_uid") REFERENCES "BpmnIntermediateCatchEvent" (uid),
	FOREIGN KEY("BpmnIoSpecification_uid") REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY("BpmnStartEvent_uid") REFERENCES "BpmnStartEvent" (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataOutput_uid" ON "BpmnDataOutput" (uid);

CREATE TABLE "BpmnDataOutputAssociation" (
	uid INTEGER NOT NULL,
	target_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnActivity_uid" INTEGER,
	"BpmnAdHocSubProcess_uid" INTEGER,
	"BpmnBoundaryEvent_uid" INTEGER,
	"BpmnBusinessRuleTask_uid" INTEGER,
	"BpmnCallActivity_uid" INTEGER,
	"BpmnCatchEvent_uid" INTEGER,
	"BpmnIntermediateCatchEvent_uid" INTEGER,
	"BpmnManualTask_uid" INTEGER,
	"BpmnReceiveTask_uid" INTEGER,
	"BpmnScriptTask_uid" INTEGER,
	"BpmnSendTask_uid" INTEGER,
	"BpmnServiceTask_uid" INTEGER,
	"BpmnStartEvent_uid" INTEGER,
	"BpmnSubProcess_uid" INTEGER,
	"BpmnTask_uid" INTEGER,
	"BpmnTransaction_uid" INTEGER,
	"BpmnUserTask_uid" INTEGER,
	transformation_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnActivity_uid") REFERENCES "BpmnActivity" (uid),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid),
	FOREIGN KEY("BpmnBoundaryEvent_uid") REFERENCES "BpmnBoundaryEvent" (uid),
	FOREIGN KEY("BpmnBusinessRuleTask_uid") REFERENCES "BpmnBusinessRuleTask" (uid),
	FOREIGN KEY("BpmnCallActivity_uid") REFERENCES "BpmnCallActivity" (uid),
	FOREIGN KEY("BpmnCatchEvent_uid") REFERENCES "BpmnCatchEvent" (uid),
	FOREIGN KEY("BpmnIntermediateCatchEvent_uid") REFERENCES "BpmnIntermediateCatchEvent" (uid),
	FOREIGN KEY("BpmnManualTask_uid") REFERENCES "BpmnManualTask" (uid),
	FOREIGN KEY("BpmnReceiveTask_uid") REFERENCES "BpmnReceiveTask" (uid),
	FOREIGN KEY("BpmnScriptTask_uid") REFERENCES "BpmnScriptTask" (uid),
	FOREIGN KEY("BpmnSendTask_uid") REFERENCES "BpmnSendTask" (uid),
	FOREIGN KEY("BpmnServiceTask_uid") REFERENCES "BpmnServiceTask" (uid),
	FOREIGN KEY("BpmnStartEvent_uid") REFERENCES "BpmnStartEvent" (uid),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid),
	FOREIGN KEY("BpmnTask_uid") REFERENCES "BpmnTask" (uid),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid),
	FOREIGN KEY("BpmnUserTask_uid") REFERENCES "BpmnUserTask" (uid),
	FOREIGN KEY(transformation_uid) REFERENCES "BpmnTransformation" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnDataOutputAssociation_uid" ON "BpmnDataOutputAssociation" (uid);

CREATE TABLE "BpmnEventDefinition" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnBoundaryEvent_uid" INTEGER,
	"BpmnCatchEvent_uid" INTEGER,
	"BpmnEndEvent_uid" INTEGER,
	"BpmnIntermediateCatchEvent_uid" INTEGER,
	"BpmnIntermediateThrowEvent_uid" INTEGER,
	"BpmnStartEvent_uid" INTEGER,
	"BpmnThrowEvent_uid" INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnBoundaryEvent_uid") REFERENCES "BpmnBoundaryEvent" (uid),
	FOREIGN KEY("BpmnCatchEvent_uid") REFERENCES "BpmnCatchEvent" (uid),
	FOREIGN KEY("BpmnEndEvent_uid") REFERENCES "BpmnEndEvent" (uid),
	FOREIGN KEY("BpmnIntermediateCatchEvent_uid") REFERENCES "BpmnIntermediateCatchEvent" (uid),
	FOREIGN KEY("BpmnIntermediateThrowEvent_uid") REFERENCES "BpmnIntermediateThrowEvent" (uid),
	FOREIGN KEY("BpmnStartEvent_uid") REFERENCES "BpmnStartEvent" (uid),
	FOREIGN KEY("BpmnThrowEvent_uid") REFERENCES "BpmnThrowEvent" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnEventDefinition_uid" ON "BpmnEventDefinition" (uid);

CREATE TABLE "BpmnLane" (
	uid INTEGER NOT NULL,
	name TEXT,
	partition_element_ref TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnChildLaneSet_uid" INTEGER,
	"BpmnLaneSet_uid" INTEGER,
	partition_element_uid INTEGER,
	child_lane_set_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnChildLaneSet_uid") REFERENCES "BpmnChildLaneSet" (uid),
	FOREIGN KEY("BpmnLaneSet_uid") REFERENCES "BpmnLaneSet" (uid),
	FOREIGN KEY(partition_element_uid) REFERENCES "BpmnPartitionElement" (uid),
	FOREIGN KEY(child_lane_set_uid) REFERENCES "BpmnChildLaneSet" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnLane_uid" ON "BpmnLane" (uid);

CREATE TABLE "BpmnProperty" (
	uid INTEGER NOT NULL,
	name TEXT,
	item_subject_ref TEXT,
	id TEXT,
	element_type TEXT,
	"BpmnActivity_uid" INTEGER,
	"BpmnAdHocSubProcess_uid" INTEGER,
	"BpmnBoundaryEvent_uid" INTEGER,
	"BpmnBusinessRuleTask_uid" INTEGER,
	"BpmnCallActivity_uid" INTEGER,
	"BpmnCatchEvent_uid" INTEGER,
	"BpmnEndEvent_uid" INTEGER,
	"BpmnEvent_uid" INTEGER,
	"BpmnIntermediateCatchEvent_uid" INTEGER,
	"BpmnIntermediateThrowEvent_uid" INTEGER,
	"BpmnManualTask_uid" INTEGER,
	"BpmnProcess_uid" INTEGER,
	"BpmnReceiveTask_uid" INTEGER,
	"BpmnScriptTask_uid" INTEGER,
	"BpmnSendTask_uid" INTEGER,
	"BpmnServiceTask_uid" INTEGER,
	"BpmnStartEvent_uid" INTEGER,
	"BpmnSubProcess_uid" INTEGER,
	"BpmnTask_uid" INTEGER,
	"BpmnThrowEvent_uid" INTEGER,
	"BpmnTransaction_uid" INTEGER,
	"BpmnUserTask_uid" INTEGER,
	data_state_uid INTEGER,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnActivity_uid") REFERENCES "BpmnActivity" (uid),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid),
	FOREIGN KEY("BpmnBoundaryEvent_uid") REFERENCES "BpmnBoundaryEvent" (uid),
	FOREIGN KEY("BpmnBusinessRuleTask_uid") REFERENCES "BpmnBusinessRuleTask" (uid),
	FOREIGN KEY("BpmnCallActivity_uid") REFERENCES "BpmnCallActivity" (uid),
	FOREIGN KEY("BpmnCatchEvent_uid") REFERENCES "BpmnCatchEvent" (uid),
	FOREIGN KEY("BpmnEndEvent_uid") REFERENCES "BpmnEndEvent" (uid),
	FOREIGN KEY("BpmnEvent_uid") REFERENCES "BpmnEvent" (uid),
	FOREIGN KEY("BpmnIntermediateCatchEvent_uid") REFERENCES "BpmnIntermediateCatchEvent" (uid),
	FOREIGN KEY("BpmnIntermediateThrowEvent_uid") REFERENCES "BpmnIntermediateThrowEvent" (uid),
	FOREIGN KEY("BpmnManualTask_uid") REFERENCES "BpmnManualTask" (uid),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid),
	FOREIGN KEY("BpmnReceiveTask_uid") REFERENCES "BpmnReceiveTask" (uid),
	FOREIGN KEY("BpmnScriptTask_uid") REFERENCES "BpmnScriptTask" (uid),
	FOREIGN KEY("BpmnSendTask_uid") REFERENCES "BpmnSendTask" (uid),
	FOREIGN KEY("BpmnServiceTask_uid") REFERENCES "BpmnServiceTask" (uid),
	FOREIGN KEY("BpmnStartEvent_uid") REFERENCES "BpmnStartEvent" (uid),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid),
	FOREIGN KEY("BpmnTask_uid") REFERENCES "BpmnTask" (uid),
	FOREIGN KEY("BpmnThrowEvent_uid") REFERENCES "BpmnThrowEvent" (uid),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid),
	FOREIGN KEY("BpmnUserTask_uid") REFERENCES "BpmnUserTask" (uid),
	FOREIGN KEY(data_state_uid) REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnProperty_uid" ON "BpmnProperty" (uid);

CREATE TABLE "BpmnResourceParameterBinding" (
	uid INTEGER NOT NULL,
	parameter_ref TEXT NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnHumanPerformer_uid" INTEGER,
	"BpmnPerformer_uid" INTEGER,
	"BpmnPotentialOwner_uid" INTEGER,
	"BpmnResourceRole_uid" INTEGER,
	expression_uid INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnHumanPerformer_uid") REFERENCES "BpmnHumanPerformer" (uid),
	FOREIGN KEY("BpmnPerformer_uid") REFERENCES "BpmnPerformer" (uid),
	FOREIGN KEY("BpmnPotentialOwner_uid") REFERENCES "BpmnPotentialOwner" (uid),
	FOREIGN KEY("BpmnResourceRole_uid") REFERENCES "BpmnResourceRole" (uid),
	FOREIGN KEY(expression_uid) REFERENCES "BpmnExpression" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnResourceParameterBinding_uid" ON "BpmnResourceParameterBinding" (uid);

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
	"BpmnBoundaryEvent_uid" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnBoundaryEvent_uid", event_definition_refs),
	FOREIGN KEY("BpmnBoundaryEvent_uid") REFERENCES "BpmnBoundaryEvent" (uid)
);
CREATE INDEX "ix_BpmnBoundaryEvent_event_definition_refs_BpmnBoundaryEvent_uid" ON "BpmnBoundaryEvent_event_definition_refs" ("BpmnBoundaryEvent_uid");
CREATE INDEX "ix_BpmnBoundaryEvent_event_definition_refs_event_definition_refs" ON "BpmnBoundaryEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnBoundaryEvent_incoming" (
	"BpmnBoundaryEvent_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnBoundaryEvent_uid", incoming),
	FOREIGN KEY("BpmnBoundaryEvent_uid") REFERENCES "BpmnBoundaryEvent" (uid)
);
CREATE INDEX "ix_BpmnBoundaryEvent_incoming_BpmnBoundaryEvent_uid" ON "BpmnBoundaryEvent_incoming" ("BpmnBoundaryEvent_uid");
CREATE INDEX "ix_BpmnBoundaryEvent_incoming_incoming" ON "BpmnBoundaryEvent_incoming" (incoming);

CREATE TABLE "BpmnBoundaryEvent_outgoing" (
	"BpmnBoundaryEvent_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnBoundaryEvent_uid", outgoing),
	FOREIGN KEY("BpmnBoundaryEvent_uid") REFERENCES "BpmnBoundaryEvent" (uid)
);
CREATE INDEX "ix_BpmnBoundaryEvent_outgoing_outgoing" ON "BpmnBoundaryEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnBoundaryEvent_outgoing_BpmnBoundaryEvent_uid" ON "BpmnBoundaryEvent_outgoing" ("BpmnBoundaryEvent_uid");

CREATE TABLE "BpmnBoundaryEvent_category_value_refs" (
	"BpmnBoundaryEvent_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnBoundaryEvent_uid", category_value_refs),
	FOREIGN KEY("BpmnBoundaryEvent_uid") REFERENCES "BpmnBoundaryEvent" (uid)
);
CREATE INDEX "ix_BpmnBoundaryEvent_category_value_refs_BpmnBoundaryEvent_uid" ON "BpmnBoundaryEvent_category_value_refs" ("BpmnBoundaryEvent_uid");
CREATE INDEX "ix_BpmnBoundaryEvent_category_value_refs_category_value_refs" ON "BpmnBoundaryEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnCatchEvent_event_definition_refs" (
	"BpmnCatchEvent_uid" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnCatchEvent_uid", event_definition_refs),
	FOREIGN KEY("BpmnCatchEvent_uid") REFERENCES "BpmnCatchEvent" (uid)
);
CREATE INDEX "ix_BpmnCatchEvent_event_definition_refs_BpmnCatchEvent_uid" ON "BpmnCatchEvent_event_definition_refs" ("BpmnCatchEvent_uid");
CREATE INDEX "ix_BpmnCatchEvent_event_definition_refs_event_definition_refs" ON "BpmnCatchEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnCatchEvent_incoming" (
	"BpmnCatchEvent_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnCatchEvent_uid", incoming),
	FOREIGN KEY("BpmnCatchEvent_uid") REFERENCES "BpmnCatchEvent" (uid)
);
CREATE INDEX "ix_BpmnCatchEvent_incoming_incoming" ON "BpmnCatchEvent_incoming" (incoming);
CREATE INDEX "ix_BpmnCatchEvent_incoming_BpmnCatchEvent_uid" ON "BpmnCatchEvent_incoming" ("BpmnCatchEvent_uid");

CREATE TABLE "BpmnCatchEvent_outgoing" (
	"BpmnCatchEvent_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnCatchEvent_uid", outgoing),
	FOREIGN KEY("BpmnCatchEvent_uid") REFERENCES "BpmnCatchEvent" (uid)
);
CREATE INDEX "ix_BpmnCatchEvent_outgoing_BpmnCatchEvent_uid" ON "BpmnCatchEvent_outgoing" ("BpmnCatchEvent_uid");
CREATE INDEX "ix_BpmnCatchEvent_outgoing_outgoing" ON "BpmnCatchEvent_outgoing" (outgoing);

CREATE TABLE "BpmnCatchEvent_category_value_refs" (
	"BpmnCatchEvent_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnCatchEvent_uid", category_value_refs),
	FOREIGN KEY("BpmnCatchEvent_uid") REFERENCES "BpmnCatchEvent" (uid)
);
CREATE INDEX "ix_BpmnCatchEvent_category_value_refs_BpmnCatchEvent_uid" ON "BpmnCatchEvent_category_value_refs" ("BpmnCatchEvent_uid");
CREATE INDEX "ix_BpmnCatchEvent_category_value_refs_category_value_refs" ON "BpmnCatchEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnCorrelationKey_correlation_property_refs" (
	"BpmnCorrelationKey_uid" INTEGER,
	correlation_property_refs TEXT,
	PRIMARY KEY ("BpmnCorrelationKey_uid", correlation_property_refs),
	FOREIGN KEY("BpmnCorrelationKey_uid") REFERENCES "BpmnCorrelationKey" (uid)
);
CREATE INDEX "ix_BpmnCorrelationKey_correlation_property_refs_BpmnCorrelationKey_uid" ON "BpmnCorrelationKey_correlation_property_refs" ("BpmnCorrelationKey_uid");
CREATE INDEX "ix_BpmnCorrelationKey_correlation_property_refs_correlation_property_refs" ON "BpmnCorrelationKey_correlation_property_refs" (correlation_property_refs);

CREATE TABLE "BpmnEndEvent_event_definition_refs" (
	"BpmnEndEvent_uid" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnEndEvent_uid", event_definition_refs),
	FOREIGN KEY("BpmnEndEvent_uid") REFERENCES "BpmnEndEvent" (uid)
);
CREATE INDEX "ix_BpmnEndEvent_event_definition_refs_BpmnEndEvent_uid" ON "BpmnEndEvent_event_definition_refs" ("BpmnEndEvent_uid");
CREATE INDEX "ix_BpmnEndEvent_event_definition_refs_event_definition_refs" ON "BpmnEndEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnEndEvent_incoming" (
	"BpmnEndEvent_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnEndEvent_uid", incoming),
	FOREIGN KEY("BpmnEndEvent_uid") REFERENCES "BpmnEndEvent" (uid)
);
CREATE INDEX "ix_BpmnEndEvent_incoming_BpmnEndEvent_uid" ON "BpmnEndEvent_incoming" ("BpmnEndEvent_uid");
CREATE INDEX "ix_BpmnEndEvent_incoming_incoming" ON "BpmnEndEvent_incoming" (incoming);

CREATE TABLE "BpmnEndEvent_outgoing" (
	"BpmnEndEvent_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnEndEvent_uid", outgoing),
	FOREIGN KEY("BpmnEndEvent_uid") REFERENCES "BpmnEndEvent" (uid)
);
CREATE INDEX "ix_BpmnEndEvent_outgoing_BpmnEndEvent_uid" ON "BpmnEndEvent_outgoing" ("BpmnEndEvent_uid");
CREATE INDEX "ix_BpmnEndEvent_outgoing_outgoing" ON "BpmnEndEvent_outgoing" (outgoing);

CREATE TABLE "BpmnEndEvent_category_value_refs" (
	"BpmnEndEvent_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnEndEvent_uid", category_value_refs),
	FOREIGN KEY("BpmnEndEvent_uid") REFERENCES "BpmnEndEvent" (uid)
);
CREATE INDEX "ix_BpmnEndEvent_category_value_refs_category_value_refs" ON "BpmnEndEvent_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnEndEvent_category_value_refs_BpmnEndEvent_uid" ON "BpmnEndEvent_category_value_refs" ("BpmnEndEvent_uid");

CREATE TABLE "BpmnFlowElement_category_value_refs" (
	"BpmnFlowElement_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnFlowElement_uid", category_value_refs),
	FOREIGN KEY("BpmnFlowElement_uid") REFERENCES "BpmnFlowElement" (uid)
);
CREATE INDEX "ix_BpmnFlowElement_category_value_refs_category_value_refs" ON "BpmnFlowElement_category_value_refs" (category_value_refs);
CREATE INDEX "ix_BpmnFlowElement_category_value_refs_BpmnFlowElement_uid" ON "BpmnFlowElement_category_value_refs" ("BpmnFlowElement_uid");

CREATE TABLE "BpmnIntermediateCatchEvent_event_definition_refs" (
	"BpmnIntermediateCatchEvent_uid" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnIntermediateCatchEvent_uid", event_definition_refs),
	FOREIGN KEY("BpmnIntermediateCatchEvent_uid") REFERENCES "BpmnIntermediateCatchEvent" (uid)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_event_definition_refs_BpmnIntermediateCatchEvent_uid" ON "BpmnIntermediateCatchEvent_event_definition_refs" ("BpmnIntermediateCatchEvent_uid");
CREATE INDEX "ix_BpmnIntermediateCatchEvent_event_definition_refs_event_definition_refs" ON "BpmnIntermediateCatchEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnIntermediateCatchEvent_incoming" (
	"BpmnIntermediateCatchEvent_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnIntermediateCatchEvent_uid", incoming),
	FOREIGN KEY("BpmnIntermediateCatchEvent_uid") REFERENCES "BpmnIntermediateCatchEvent" (uid)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_incoming_BpmnIntermediateCatchEvent_uid" ON "BpmnIntermediateCatchEvent_incoming" ("BpmnIntermediateCatchEvent_uid");
CREATE INDEX "ix_BpmnIntermediateCatchEvent_incoming_incoming" ON "BpmnIntermediateCatchEvent_incoming" (incoming);

CREATE TABLE "BpmnIntermediateCatchEvent_outgoing" (
	"BpmnIntermediateCatchEvent_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnIntermediateCatchEvent_uid", outgoing),
	FOREIGN KEY("BpmnIntermediateCatchEvent_uid") REFERENCES "BpmnIntermediateCatchEvent" (uid)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_outgoing_outgoing" ON "BpmnIntermediateCatchEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_outgoing_BpmnIntermediateCatchEvent_uid" ON "BpmnIntermediateCatchEvent_outgoing" ("BpmnIntermediateCatchEvent_uid");

CREATE TABLE "BpmnIntermediateCatchEvent_category_value_refs" (
	"BpmnIntermediateCatchEvent_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnIntermediateCatchEvent_uid", category_value_refs),
	FOREIGN KEY("BpmnIntermediateCatchEvent_uid") REFERENCES "BpmnIntermediateCatchEvent" (uid)
);
CREATE INDEX "ix_BpmnIntermediateCatchEvent_category_value_refs_BpmnIntermediateCatchEvent_uid" ON "BpmnIntermediateCatchEvent_category_value_refs" ("BpmnIntermediateCatchEvent_uid");
CREATE INDEX "ix_BpmnIntermediateCatchEvent_category_value_refs_category_value_refs" ON "BpmnIntermediateCatchEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnIntermediateThrowEvent_event_definition_refs" (
	"BpmnIntermediateThrowEvent_uid" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnIntermediateThrowEvent_uid", event_definition_refs),
	FOREIGN KEY("BpmnIntermediateThrowEvent_uid") REFERENCES "BpmnIntermediateThrowEvent" (uid)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_event_definition_refs_BpmnIntermediateThrowEvent_uid" ON "BpmnIntermediateThrowEvent_event_definition_refs" ("BpmnIntermediateThrowEvent_uid");
CREATE INDEX "ix_BpmnIntermediateThrowEvent_event_definition_refs_event_definition_refs" ON "BpmnIntermediateThrowEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnIntermediateThrowEvent_incoming" (
	"BpmnIntermediateThrowEvent_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnIntermediateThrowEvent_uid", incoming),
	FOREIGN KEY("BpmnIntermediateThrowEvent_uid") REFERENCES "BpmnIntermediateThrowEvent" (uid)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_incoming_BpmnIntermediateThrowEvent_uid" ON "BpmnIntermediateThrowEvent_incoming" ("BpmnIntermediateThrowEvent_uid");
CREATE INDEX "ix_BpmnIntermediateThrowEvent_incoming_incoming" ON "BpmnIntermediateThrowEvent_incoming" (incoming);

CREATE TABLE "BpmnIntermediateThrowEvent_outgoing" (
	"BpmnIntermediateThrowEvent_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnIntermediateThrowEvent_uid", outgoing),
	FOREIGN KEY("BpmnIntermediateThrowEvent_uid") REFERENCES "BpmnIntermediateThrowEvent" (uid)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_outgoing_outgoing" ON "BpmnIntermediateThrowEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_outgoing_BpmnIntermediateThrowEvent_uid" ON "BpmnIntermediateThrowEvent_outgoing" ("BpmnIntermediateThrowEvent_uid");

CREATE TABLE "BpmnIntermediateThrowEvent_category_value_refs" (
	"BpmnIntermediateThrowEvent_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnIntermediateThrowEvent_uid", category_value_refs),
	FOREIGN KEY("BpmnIntermediateThrowEvent_uid") REFERENCES "BpmnIntermediateThrowEvent" (uid)
);
CREATE INDEX "ix_BpmnIntermediateThrowEvent_category_value_refs_BpmnIntermediateThrowEvent_uid" ON "BpmnIntermediateThrowEvent_category_value_refs" ("BpmnIntermediateThrowEvent_uid");
CREATE INDEX "ix_BpmnIntermediateThrowEvent_category_value_refs_category_value_refs" ON "BpmnIntermediateThrowEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnStartEvent_event_definition_refs" (
	"BpmnStartEvent_uid" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnStartEvent_uid", event_definition_refs),
	FOREIGN KEY("BpmnStartEvent_uid") REFERENCES "BpmnStartEvent" (uid)
);
CREATE INDEX "ix_BpmnStartEvent_event_definition_refs_BpmnStartEvent_uid" ON "BpmnStartEvent_event_definition_refs" ("BpmnStartEvent_uid");
CREATE INDEX "ix_BpmnStartEvent_event_definition_refs_event_definition_refs" ON "BpmnStartEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnStartEvent_incoming" (
	"BpmnStartEvent_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnStartEvent_uid", incoming),
	FOREIGN KEY("BpmnStartEvent_uid") REFERENCES "BpmnStartEvent" (uid)
);
CREATE INDEX "ix_BpmnStartEvent_incoming_BpmnStartEvent_uid" ON "BpmnStartEvent_incoming" ("BpmnStartEvent_uid");
CREATE INDEX "ix_BpmnStartEvent_incoming_incoming" ON "BpmnStartEvent_incoming" (incoming);

CREATE TABLE "BpmnStartEvent_outgoing" (
	"BpmnStartEvent_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnStartEvent_uid", outgoing),
	FOREIGN KEY("BpmnStartEvent_uid") REFERENCES "BpmnStartEvent" (uid)
);
CREATE INDEX "ix_BpmnStartEvent_outgoing_outgoing" ON "BpmnStartEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnStartEvent_outgoing_BpmnStartEvent_uid" ON "BpmnStartEvent_outgoing" ("BpmnStartEvent_uid");

CREATE TABLE "BpmnStartEvent_category_value_refs" (
	"BpmnStartEvent_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnStartEvent_uid", category_value_refs),
	FOREIGN KEY("BpmnStartEvent_uid") REFERENCES "BpmnStartEvent" (uid)
);
CREATE INDEX "ix_BpmnStartEvent_category_value_refs_BpmnStartEvent_uid" ON "BpmnStartEvent_category_value_refs" ("BpmnStartEvent_uid");
CREATE INDEX "ix_BpmnStartEvent_category_value_refs_category_value_refs" ON "BpmnStartEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnThrowEvent_event_definition_refs" (
	"BpmnThrowEvent_uid" INTEGER,
	event_definition_refs TEXT,
	PRIMARY KEY ("BpmnThrowEvent_uid", event_definition_refs),
	FOREIGN KEY("BpmnThrowEvent_uid") REFERENCES "BpmnThrowEvent" (uid)
);
CREATE INDEX "ix_BpmnThrowEvent_event_definition_refs_BpmnThrowEvent_uid" ON "BpmnThrowEvent_event_definition_refs" ("BpmnThrowEvent_uid");
CREATE INDEX "ix_BpmnThrowEvent_event_definition_refs_event_definition_refs" ON "BpmnThrowEvent_event_definition_refs" (event_definition_refs);

CREATE TABLE "BpmnThrowEvent_incoming" (
	"BpmnThrowEvent_uid" INTEGER,
	incoming TEXT,
	PRIMARY KEY ("BpmnThrowEvent_uid", incoming),
	FOREIGN KEY("BpmnThrowEvent_uid") REFERENCES "BpmnThrowEvent" (uid)
);
CREATE INDEX "ix_BpmnThrowEvent_incoming_BpmnThrowEvent_uid" ON "BpmnThrowEvent_incoming" ("BpmnThrowEvent_uid");
CREATE INDEX "ix_BpmnThrowEvent_incoming_incoming" ON "BpmnThrowEvent_incoming" (incoming);

CREATE TABLE "BpmnThrowEvent_outgoing" (
	"BpmnThrowEvent_uid" INTEGER,
	outgoing TEXT,
	PRIMARY KEY ("BpmnThrowEvent_uid", outgoing),
	FOREIGN KEY("BpmnThrowEvent_uid") REFERENCES "BpmnThrowEvent" (uid)
);
CREATE INDEX "ix_BpmnThrowEvent_outgoing_outgoing" ON "BpmnThrowEvent_outgoing" (outgoing);
CREATE INDEX "ix_BpmnThrowEvent_outgoing_BpmnThrowEvent_uid" ON "BpmnThrowEvent_outgoing" ("BpmnThrowEvent_uid");

CREATE TABLE "BpmnThrowEvent_category_value_refs" (
	"BpmnThrowEvent_uid" INTEGER,
	category_value_refs TEXT,
	PRIMARY KEY ("BpmnThrowEvent_uid", category_value_refs),
	FOREIGN KEY("BpmnThrowEvent_uid") REFERENCES "BpmnThrowEvent" (uid)
);
CREATE INDEX "ix_BpmnThrowEvent_category_value_refs_BpmnThrowEvent_uid" ON "BpmnThrowEvent_category_value_refs" ("BpmnThrowEvent_uid");
CREATE INDEX "ix_BpmnThrowEvent_category_value_refs_category_value_refs" ON "BpmnThrowEvent_category_value_refs" (category_value_refs);

CREATE TABLE "BpmnAssignment" (
	uid INTEGER NOT NULL,
	id TEXT,
	element_type TEXT,
	"BpmnDataAssociation_uid" INTEGER,
	"BpmnDataInputAssociation_uid" INTEGER,
	"BpmnDataOutputAssociation_uid" INTEGER,
	from_expression_uid INTEGER NOT NULL,
	to_expression_uid INTEGER NOT NULL,
	extension_elements_id INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnDataAssociation_uid") REFERENCES "BpmnDataAssociation" (uid),
	FOREIGN KEY("BpmnDataInputAssociation_uid") REFERENCES "BpmnDataInputAssociation" (uid),
	FOREIGN KEY("BpmnDataOutputAssociation_uid") REFERENCES "BpmnDataOutputAssociation" (uid),
	FOREIGN KEY(from_expression_uid) REFERENCES "BpmnFrom" (uid),
	FOREIGN KEY(to_expression_uid) REFERENCES "BpmnTo" (uid),
	FOREIGN KEY(extension_elements_id) REFERENCES "BpmnExtensionElements" (id)
);
CREATE INDEX "ix_BpmnAssignment_uid" ON "BpmnAssignment" (uid);

CREATE TABLE "BpmnDataInputAssociation_source_refs" (
	"BpmnDataInputAssociation_uid" INTEGER,
	source_refs TEXT,
	PRIMARY KEY ("BpmnDataInputAssociation_uid", source_refs),
	FOREIGN KEY("BpmnDataInputAssociation_uid") REFERENCES "BpmnDataInputAssociation" (uid)
);
CREATE INDEX "ix_BpmnDataInputAssociation_source_refs_source_refs" ON "BpmnDataInputAssociation_source_refs" (source_refs);
CREATE INDEX "ix_BpmnDataInputAssociation_source_refs_BpmnDataInputAssociation_uid" ON "BpmnDataInputAssociation_source_refs" ("BpmnDataInputAssociation_uid");

CREATE TABLE "BpmnDataOutputAssociation_source_refs" (
	"BpmnDataOutputAssociation_uid" INTEGER,
	source_refs TEXT,
	PRIMARY KEY ("BpmnDataOutputAssociation_uid", source_refs),
	FOREIGN KEY("BpmnDataOutputAssociation_uid") REFERENCES "BpmnDataOutputAssociation" (uid)
);
CREATE INDEX "ix_BpmnDataOutputAssociation_source_refs_BpmnDataOutputAssociation_uid" ON "BpmnDataOutputAssociation_source_refs" ("BpmnDataOutputAssociation_uid");
CREATE INDEX "ix_BpmnDataOutputAssociation_source_refs_source_refs" ON "BpmnDataOutputAssociation_source_refs" (source_refs);

CREATE TABLE "BpmnLane_flow_node_refs" (
	"BpmnLane_uid" INTEGER,
	flow_node_refs TEXT,
	PRIMARY KEY ("BpmnLane_uid", flow_node_refs),
	FOREIGN KEY("BpmnLane_uid") REFERENCES "BpmnLane" (uid)
);
CREATE INDEX "ix_BpmnLane_flow_node_refs_BpmnLane_uid" ON "BpmnLane_flow_node_refs" ("BpmnLane_uid");
CREATE INDEX "ix_BpmnLane_flow_node_refs_flow_node_refs" ON "BpmnLane_flow_node_refs" (flow_node_refs);

CREATE TABLE "BpmnDocumentation" (
	uid INTEGER NOT NULL,
	id TEXT,
	text_format TEXT,
	text_content TEXT,
	element_type TEXT,
	"BpmnActivationCondition_uid" INTEGER,
	"BpmnActivity_uid" INTEGER,
	"BpmnAdHocSubProcess_uid" INTEGER,
	"BpmnArtifact_uid" INTEGER,
	"BpmnAssignment_uid" INTEGER,
	"BpmnAssociation_uid" INTEGER,
	"BpmnAuditing_uid" INTEGER,
	"BpmnBaseElement_uid" INTEGER,
	"BpmnBoundaryEvent_uid" INTEGER,
	"BpmnBusinessRuleTask_uid" INTEGER,
	"BpmnCallActivity_uid" INTEGER,
	"BpmnCallConversation_uid" INTEGER,
	"BpmnCallableElement_uid" INTEGER,
	"BpmnCancelEventDefinition_uid" INTEGER,
	"BpmnCatchEvent_uid" INTEGER,
	"BpmnCategory_uid" INTEGER,
	"BpmnCategoryValue_uid" INTEGER,
	"BpmnChildLaneSet_uid" INTEGER,
	"BpmnCollaboration_uid" INTEGER,
	"BpmnCompensateEventDefinition_uid" INTEGER,
	"BpmnCompletionCondition_uid" INTEGER,
	"BpmnComplexBehaviorDefinition_uid" INTEGER,
	"BpmnComplexGateway_uid" INTEGER,
	"BpmnCondition_uid" INTEGER,
	"BpmnConditionExpression_uid" INTEGER,
	"BpmnConditionalEventDefinition_uid" INTEGER,
	"BpmnConversation_uid" INTEGER,
	"BpmnConversationAssociation_uid" INTEGER,
	"BpmnConversationLink_uid" INTEGER,
	"BpmnConversationNode_uid" INTEGER,
	"BpmnCorrelationKey_uid" INTEGER,
	"BpmnCorrelationProperty_uid" INTEGER,
	"BpmnCorrelationPropertyBinding_uid" INTEGER,
	"BpmnCorrelationPropertyRetrievalExpression_uid" INTEGER,
	"BpmnCorrelationSubscription_uid" INTEGER,
	"BpmnDataAssociation_uid" INTEGER,
	"BpmnDataInput_uid" INTEGER,
	"BpmnDataInputAssociation_uid" INTEGER,
	"BpmnDataObject_uid" INTEGER,
	"BpmnDataObjectReference_uid" INTEGER,
	"BpmnDataOutput_uid" INTEGER,
	"BpmnDataOutputAssociation_uid" INTEGER,
	"BpmnDataPath_uid" INTEGER,
	"BpmnDataState_uid" INTEGER,
	"BpmnDataStore_uid" INTEGER,
	"BpmnDataStoreReference_uid" INTEGER,
	"BpmnEndEvent_uid" INTEGER,
	"BpmnEndPoint_uid" INTEGER,
	"BpmnError_uid" INTEGER,
	"BpmnErrorEventDefinition_uid" INTEGER,
	"BpmnEscalation_uid" INTEGER,
	"BpmnEscalationEventDefinition_uid" INTEGER,
	"BpmnEvent_uid" INTEGER,
	"BpmnEventBasedGateway_uid" INTEGER,
	"BpmnEventDefinition_uid" INTEGER,
	"BpmnExclusiveGateway_uid" INTEGER,
	"BpmnExpression_uid" INTEGER,
	"BpmnExtension_id" INTEGER,
	"BpmnFlowElement_uid" INTEGER,
	"BpmnFlowNode_uid" INTEGER,
	"BpmnFormalExpression_uid" INTEGER,
	"BpmnFrom_uid" INTEGER,
	"BpmnGateway_uid" INTEGER,
	"BpmnGlobalConversation_uid" INTEGER,
	"BpmnGroup_uid" INTEGER,
	"BpmnHumanPerformer_uid" INTEGER,
	"BpmnInclusiveGateway_uid" INTEGER,
	"BpmnInputDataItem_uid" INTEGER,
	"BpmnInputSet_uid" INTEGER,
	"BpmnInterface_uid" INTEGER,
	"BpmnIntermediateCatchEvent_uid" INTEGER,
	"BpmnIntermediateThrowEvent_uid" INTEGER,
	"BpmnIoBinding_uid" INTEGER,
	"BpmnIoSpecification_uid" INTEGER,
	"BpmnItemAwareElement_uid" INTEGER,
	"BpmnItemDefinition_uid" INTEGER,
	"BpmnLane_uid" INTEGER,
	"BpmnLaneSet_uid" INTEGER,
	"BpmnLinkEventDefinition_uid" INTEGER,
	"BpmnLoopCardinality_uid" INTEGER,
	"BpmnLoopCharacteristics_uid" INTEGER,
	"BpmnManualTask_uid" INTEGER,
	"BpmnMessage_uid" INTEGER,
	"BpmnMessageEventDefinition_uid" INTEGER,
	"BpmnMessageFlow_uid" INTEGER,
	"BpmnMessageFlowAssociation_uid" INTEGER,
	"BpmnMessagePath_uid" INTEGER,
	"BpmnMonitoring_uid" INTEGER,
	"BpmnMultiInstanceLoopCharacteristics_uid" INTEGER,
	"BpmnOperation_uid" INTEGER,
	"BpmnOutputDataItem_uid" INTEGER,
	"BpmnOutputSet_uid" INTEGER,
	"BpmnParallelGateway_uid" INTEGER,
	"BpmnParticipant_uid" INTEGER,
	"BpmnParticipantAssociation_uid" INTEGER,
	"BpmnParticipantMultiplicity_uid" INTEGER,
	"BpmnPartitionElement_uid" INTEGER,
	"BpmnPerformer_uid" INTEGER,
	"BpmnPotentialOwner_uid" INTEGER,
	"BpmnProcess_uid" INTEGER,
	"BpmnProperty_uid" INTEGER,
	"BpmnReceiveTask_uid" INTEGER,
	"BpmnRelationship_uid" INTEGER,
	"BpmnRendering_uid" INTEGER,
	"BpmnResource_uid" INTEGER,
	"BpmnResourceAssignmentExpression_uid" INTEGER,
	"BpmnResourceParameter_uid" INTEGER,
	"BpmnResourceParameterBinding_uid" INTEGER,
	"BpmnResourceRole_uid" INTEGER,
	"BpmnRootElement_uid" INTEGER,
	"BpmnScriptTask_uid" INTEGER,
	"BpmnSendTask_uid" INTEGER,
	"BpmnSequenceFlow_uid" INTEGER,
	"BpmnServiceTask_uid" INTEGER,
	"BpmnSignal_uid" INTEGER,
	"BpmnSignalEventDefinition_uid" INTEGER,
	"BpmnStartEvent_uid" INTEGER,
	"BpmnSubConversation_uid" INTEGER,
	"BpmnSubProcess_uid" INTEGER,
	"BpmnTask_uid" INTEGER,
	"BpmnTerminateEventDefinition_uid" INTEGER,
	"BpmnTextAnnotation_uid" INTEGER,
	"BpmnThrowEvent_uid" INTEGER,
	"BpmnTimeCycle_uid" INTEGER,
	"BpmnTimeDate_uid" INTEGER,
	"BpmnTimeDuration_uid" INTEGER,
	"BpmnTimerEventDefinition_uid" INTEGER,
	"BpmnTo_uid" INTEGER,
	"BpmnTransaction_uid" INTEGER,
	"BpmnTransformation_uid" INTEGER,
	"BpmnUserTask_uid" INTEGER,
	PRIMARY KEY (uid),
	FOREIGN KEY("BpmnActivationCondition_uid") REFERENCES "BpmnActivationCondition" (uid),
	FOREIGN KEY("BpmnActivity_uid") REFERENCES "BpmnActivity" (uid),
	FOREIGN KEY("BpmnAdHocSubProcess_uid") REFERENCES "BpmnAdHocSubProcess" (uid),
	FOREIGN KEY("BpmnArtifact_uid") REFERENCES "BpmnArtifact" (uid),
	FOREIGN KEY("BpmnAssignment_uid") REFERENCES "BpmnAssignment" (uid),
	FOREIGN KEY("BpmnAssociation_uid") REFERENCES "BpmnAssociation" (uid),
	FOREIGN KEY("BpmnAuditing_uid") REFERENCES "BpmnAuditing" (uid),
	FOREIGN KEY("BpmnBaseElement_uid") REFERENCES "BpmnBaseElement" (uid),
	FOREIGN KEY("BpmnBoundaryEvent_uid") REFERENCES "BpmnBoundaryEvent" (uid),
	FOREIGN KEY("BpmnBusinessRuleTask_uid") REFERENCES "BpmnBusinessRuleTask" (uid),
	FOREIGN KEY("BpmnCallActivity_uid") REFERENCES "BpmnCallActivity" (uid),
	FOREIGN KEY("BpmnCallConversation_uid") REFERENCES "BpmnCallConversation" (uid),
	FOREIGN KEY("BpmnCallableElement_uid") REFERENCES "BpmnCallableElement" (uid),
	FOREIGN KEY("BpmnCancelEventDefinition_uid") REFERENCES "BpmnCancelEventDefinition" (uid),
	FOREIGN KEY("BpmnCatchEvent_uid") REFERENCES "BpmnCatchEvent" (uid),
	FOREIGN KEY("BpmnCategory_uid") REFERENCES "BpmnCategory" (uid),
	FOREIGN KEY("BpmnCategoryValue_uid") REFERENCES "BpmnCategoryValue" (uid),
	FOREIGN KEY("BpmnChildLaneSet_uid") REFERENCES "BpmnChildLaneSet" (uid),
	FOREIGN KEY("BpmnCollaboration_uid") REFERENCES "BpmnCollaboration" (uid),
	FOREIGN KEY("BpmnCompensateEventDefinition_uid") REFERENCES "BpmnCompensateEventDefinition" (uid),
	FOREIGN KEY("BpmnCompletionCondition_uid") REFERENCES "BpmnCompletionCondition" (uid),
	FOREIGN KEY("BpmnComplexBehaviorDefinition_uid") REFERENCES "BpmnComplexBehaviorDefinition" (uid),
	FOREIGN KEY("BpmnComplexGateway_uid") REFERENCES "BpmnComplexGateway" (uid),
	FOREIGN KEY("BpmnCondition_uid") REFERENCES "BpmnCondition" (uid),
	FOREIGN KEY("BpmnConditionExpression_uid") REFERENCES "BpmnConditionExpression" (uid),
	FOREIGN KEY("BpmnConditionalEventDefinition_uid") REFERENCES "BpmnConditionalEventDefinition" (uid),
	FOREIGN KEY("BpmnConversation_uid") REFERENCES "BpmnConversation" (uid),
	FOREIGN KEY("BpmnConversationAssociation_uid") REFERENCES "BpmnConversationAssociation" (uid),
	FOREIGN KEY("BpmnConversationLink_uid") REFERENCES "BpmnConversationLink" (uid),
	FOREIGN KEY("BpmnConversationNode_uid") REFERENCES "BpmnConversationNode" (uid),
	FOREIGN KEY("BpmnCorrelationKey_uid") REFERENCES "BpmnCorrelationKey" (uid),
	FOREIGN KEY("BpmnCorrelationProperty_uid") REFERENCES "BpmnCorrelationProperty" (uid),
	FOREIGN KEY("BpmnCorrelationPropertyBinding_uid") REFERENCES "BpmnCorrelationPropertyBinding" (uid),
	FOREIGN KEY("BpmnCorrelationPropertyRetrievalExpression_uid") REFERENCES "BpmnCorrelationPropertyRetrievalExpression" (uid),
	FOREIGN KEY("BpmnCorrelationSubscription_uid") REFERENCES "BpmnCorrelationSubscription" (uid),
	FOREIGN KEY("BpmnDataAssociation_uid") REFERENCES "BpmnDataAssociation" (uid),
	FOREIGN KEY("BpmnDataInput_uid") REFERENCES "BpmnDataInput" (uid),
	FOREIGN KEY("BpmnDataInputAssociation_uid") REFERENCES "BpmnDataInputAssociation" (uid),
	FOREIGN KEY("BpmnDataObject_uid") REFERENCES "BpmnDataObject" (uid),
	FOREIGN KEY("BpmnDataObjectReference_uid") REFERENCES "BpmnDataObjectReference" (uid),
	FOREIGN KEY("BpmnDataOutput_uid") REFERENCES "BpmnDataOutput" (uid),
	FOREIGN KEY("BpmnDataOutputAssociation_uid") REFERENCES "BpmnDataOutputAssociation" (uid),
	FOREIGN KEY("BpmnDataPath_uid") REFERENCES "BpmnDataPath" (uid),
	FOREIGN KEY("BpmnDataState_uid") REFERENCES "BpmnDataState" (uid),
	FOREIGN KEY("BpmnDataStore_uid") REFERENCES "BpmnDataStore" (uid),
	FOREIGN KEY("BpmnDataStoreReference_uid") REFERENCES "BpmnDataStoreReference" (uid),
	FOREIGN KEY("BpmnEndEvent_uid") REFERENCES "BpmnEndEvent" (uid),
	FOREIGN KEY("BpmnEndPoint_uid") REFERENCES "BpmnEndPoint" (uid),
	FOREIGN KEY("BpmnError_uid") REFERENCES "BpmnError" (uid),
	FOREIGN KEY("BpmnErrorEventDefinition_uid") REFERENCES "BpmnErrorEventDefinition" (uid),
	FOREIGN KEY("BpmnEscalation_uid") REFERENCES "BpmnEscalation" (uid),
	FOREIGN KEY("BpmnEscalationEventDefinition_uid") REFERENCES "BpmnEscalationEventDefinition" (uid),
	FOREIGN KEY("BpmnEvent_uid") REFERENCES "BpmnEvent" (uid),
	FOREIGN KEY("BpmnEventBasedGateway_uid") REFERENCES "BpmnEventBasedGateway" (uid),
	FOREIGN KEY("BpmnEventDefinition_uid") REFERENCES "BpmnEventDefinition" (uid),
	FOREIGN KEY("BpmnExclusiveGateway_uid") REFERENCES "BpmnExclusiveGateway" (uid),
	FOREIGN KEY("BpmnExpression_uid") REFERENCES "BpmnExpression" (uid),
	FOREIGN KEY("BpmnExtension_id") REFERENCES "BpmnExtension" (id),
	FOREIGN KEY("BpmnFlowElement_uid") REFERENCES "BpmnFlowElement" (uid),
	FOREIGN KEY("BpmnFlowNode_uid") REFERENCES "BpmnFlowNode" (uid),
	FOREIGN KEY("BpmnFormalExpression_uid") REFERENCES "BpmnFormalExpression" (uid),
	FOREIGN KEY("BpmnFrom_uid") REFERENCES "BpmnFrom" (uid),
	FOREIGN KEY("BpmnGateway_uid") REFERENCES "BpmnGateway" (uid),
	FOREIGN KEY("BpmnGlobalConversation_uid") REFERENCES "BpmnGlobalConversation" (uid),
	FOREIGN KEY("BpmnGroup_uid") REFERENCES "BpmnGroup" (uid),
	FOREIGN KEY("BpmnHumanPerformer_uid") REFERENCES "BpmnHumanPerformer" (uid),
	FOREIGN KEY("BpmnInclusiveGateway_uid") REFERENCES "BpmnInclusiveGateway" (uid),
	FOREIGN KEY("BpmnInputDataItem_uid") REFERENCES "BpmnInputDataItem" (uid),
	FOREIGN KEY("BpmnInputSet_uid") REFERENCES "BpmnInputSet" (uid),
	FOREIGN KEY("BpmnInterface_uid") REFERENCES "BpmnInterface" (uid),
	FOREIGN KEY("BpmnIntermediateCatchEvent_uid") REFERENCES "BpmnIntermediateCatchEvent" (uid),
	FOREIGN KEY("BpmnIntermediateThrowEvent_uid") REFERENCES "BpmnIntermediateThrowEvent" (uid),
	FOREIGN KEY("BpmnIoBinding_uid") REFERENCES "BpmnIoBinding" (uid),
	FOREIGN KEY("BpmnIoSpecification_uid") REFERENCES "BpmnIoSpecification" (uid),
	FOREIGN KEY("BpmnItemAwareElement_uid") REFERENCES "BpmnItemAwareElement" (uid),
	FOREIGN KEY("BpmnItemDefinition_uid") REFERENCES "BpmnItemDefinition" (uid),
	FOREIGN KEY("BpmnLane_uid") REFERENCES "BpmnLane" (uid),
	FOREIGN KEY("BpmnLaneSet_uid") REFERENCES "BpmnLaneSet" (uid),
	FOREIGN KEY("BpmnLinkEventDefinition_uid") REFERENCES "BpmnLinkEventDefinition" (uid),
	FOREIGN KEY("BpmnLoopCardinality_uid") REFERENCES "BpmnLoopCardinality" (uid),
	FOREIGN KEY("BpmnLoopCharacteristics_uid") REFERENCES "BpmnLoopCharacteristics" (uid),
	FOREIGN KEY("BpmnManualTask_uid") REFERENCES "BpmnManualTask" (uid),
	FOREIGN KEY("BpmnMessage_uid") REFERENCES "BpmnMessage" (uid),
	FOREIGN KEY("BpmnMessageEventDefinition_uid") REFERENCES "BpmnMessageEventDefinition" (uid),
	FOREIGN KEY("BpmnMessageFlow_uid") REFERENCES "BpmnMessageFlow" (uid),
	FOREIGN KEY("BpmnMessageFlowAssociation_uid") REFERENCES "BpmnMessageFlowAssociation" (uid),
	FOREIGN KEY("BpmnMessagePath_uid") REFERENCES "BpmnMessagePath" (uid),
	FOREIGN KEY("BpmnMonitoring_uid") REFERENCES "BpmnMonitoring" (uid),
	FOREIGN KEY("BpmnMultiInstanceLoopCharacteristics_uid") REFERENCES "BpmnMultiInstanceLoopCharacteristics" (uid),
	FOREIGN KEY("BpmnOperation_uid") REFERENCES "BpmnOperation" (uid),
	FOREIGN KEY("BpmnOutputDataItem_uid") REFERENCES "BpmnOutputDataItem" (uid),
	FOREIGN KEY("BpmnOutputSet_uid") REFERENCES "BpmnOutputSet" (uid),
	FOREIGN KEY("BpmnParallelGateway_uid") REFERENCES "BpmnParallelGateway" (uid),
	FOREIGN KEY("BpmnParticipant_uid") REFERENCES "BpmnParticipant" (uid),
	FOREIGN KEY("BpmnParticipantAssociation_uid") REFERENCES "BpmnParticipantAssociation" (uid),
	FOREIGN KEY("BpmnParticipantMultiplicity_uid") REFERENCES "BpmnParticipantMultiplicity" (uid),
	FOREIGN KEY("BpmnPartitionElement_uid") REFERENCES "BpmnPartitionElement" (uid),
	FOREIGN KEY("BpmnPerformer_uid") REFERENCES "BpmnPerformer" (uid),
	FOREIGN KEY("BpmnPotentialOwner_uid") REFERENCES "BpmnPotentialOwner" (uid),
	FOREIGN KEY("BpmnProcess_uid") REFERENCES "BpmnProcess" (uid),
	FOREIGN KEY("BpmnProperty_uid") REFERENCES "BpmnProperty" (uid),
	FOREIGN KEY("BpmnReceiveTask_uid") REFERENCES "BpmnReceiveTask" (uid),
	FOREIGN KEY("BpmnRelationship_uid") REFERENCES "BpmnRelationship" (uid),
	FOREIGN KEY("BpmnRendering_uid") REFERENCES "BpmnRendering" (uid),
	FOREIGN KEY("BpmnResource_uid") REFERENCES "BpmnResource" (uid),
	FOREIGN KEY("BpmnResourceAssignmentExpression_uid") REFERENCES "BpmnResourceAssignmentExpression" (uid),
	FOREIGN KEY("BpmnResourceParameter_uid") REFERENCES "BpmnResourceParameter" (uid),
	FOREIGN KEY("BpmnResourceParameterBinding_uid") REFERENCES "BpmnResourceParameterBinding" (uid),
	FOREIGN KEY("BpmnResourceRole_uid") REFERENCES "BpmnResourceRole" (uid),
	FOREIGN KEY("BpmnRootElement_uid") REFERENCES "BpmnRootElement" (uid),
	FOREIGN KEY("BpmnScriptTask_uid") REFERENCES "BpmnScriptTask" (uid),
	FOREIGN KEY("BpmnSendTask_uid") REFERENCES "BpmnSendTask" (uid),
	FOREIGN KEY("BpmnSequenceFlow_uid") REFERENCES "BpmnSequenceFlow" (uid),
	FOREIGN KEY("BpmnServiceTask_uid") REFERENCES "BpmnServiceTask" (uid),
	FOREIGN KEY("BpmnSignal_uid") REFERENCES "BpmnSignal" (uid),
	FOREIGN KEY("BpmnSignalEventDefinition_uid") REFERENCES "BpmnSignalEventDefinition" (uid),
	FOREIGN KEY("BpmnStartEvent_uid") REFERENCES "BpmnStartEvent" (uid),
	FOREIGN KEY("BpmnSubConversation_uid") REFERENCES "BpmnSubConversation" (uid),
	FOREIGN KEY("BpmnSubProcess_uid") REFERENCES "BpmnSubProcess" (uid),
	FOREIGN KEY("BpmnTask_uid") REFERENCES "BpmnTask" (uid),
	FOREIGN KEY("BpmnTerminateEventDefinition_uid") REFERENCES "BpmnTerminateEventDefinition" (uid),
	FOREIGN KEY("BpmnTextAnnotation_uid") REFERENCES "BpmnTextAnnotation" (uid),
	FOREIGN KEY("BpmnThrowEvent_uid") REFERENCES "BpmnThrowEvent" (uid),
	FOREIGN KEY("BpmnTimeCycle_uid") REFERENCES "BpmnTimeCycle" (uid),
	FOREIGN KEY("BpmnTimeDate_uid") REFERENCES "BpmnTimeDate" (uid),
	FOREIGN KEY("BpmnTimeDuration_uid") REFERENCES "BpmnTimeDuration" (uid),
	FOREIGN KEY("BpmnTimerEventDefinition_uid") REFERENCES "BpmnTimerEventDefinition" (uid),
	FOREIGN KEY("BpmnTo_uid") REFERENCES "BpmnTo" (uid),
	FOREIGN KEY("BpmnTransaction_uid") REFERENCES "BpmnTransaction" (uid),
	FOREIGN KEY("BpmnTransformation_uid") REFERENCES "BpmnTransformation" (uid),
	FOREIGN KEY("BpmnUserTask_uid") REFERENCES "BpmnUserTask" (uid)
);
CREATE INDEX "ix_BpmnDocumentation_uid" ON "BpmnDocumentation" (uid);
