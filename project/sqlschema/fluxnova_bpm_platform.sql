-- # Class: FluxnovaPlatformData Description: Root container for Fluxnova BPM Platform data.
--     * Slot: id
-- # Class: ByteArray Description: Byte Array entity in the engine infrastructure.
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
-- # Class: MeterLog Description: Meter Log entity in the engine infrastructure.
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: reporter Description: Identifier of the reporting node.
--     * Slot: value Description: Value of this variable instance.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: milliseconds Description: The milliseconds.
-- # Class: Property Description: Property entity in the engine infrastructure.
--     * Slot: name Description: Human-readable name.
--     * Slot: value Description: Value of this variable instance.
-- # Class: SchemaLogEntry Description: Schema Log Entry entity in the engine infrastructure.
--     * Slot: id Description: Unique identifier.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: version Description: Version number.
-- # Class: TaskMeterLog Description: Task Meter Log entity in the engine infrastructure.
--     * Slot: id Description: Unique identifier.
--     * Slot: assignee_hash Description: Hash of the assignee for aggregation.
--     * Slot: timestamp Description: Time when this log occurred.
-- # Class: Authorization Description: An Authorization assigns a set of Permission Permissions to an identity to interact with a given Resource. EXAMPLES: Nobody is allowed to edit process variables in the cockpit application, except t...
--     * Slot: id Description: Unique identifier.
--     * Slot: type Description: Type discriminator.
--     * Slot: group_id Description: Reference to a group.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: resource_type Description: Numeric type of the authorized resource.
--     * Slot: resource_id Description: Reference to the resource.
--     * Slot: permissions Description: Bitmask of granted permissions.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
-- # Class: Group Description: Represents a group, used in IdentityService.
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: type Description: Type discriminator.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: IdentityInfo Description: Identity Info entity in the identity and access management.
--     * Slot: id Description: Unique identifier.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: type Description: Type discriminator.
--     * Slot: key Description: Business key for the definition.
--     * Slot: value Description: Value of this variable instance.
--     * Slot: password Description: Hashed password.
--     * Slot: parent_id Description: Reference to a CaseExecution.
-- # Class: IdentityLink Description: An identity link is used to associate a task with a certain identity. For example: - a user can be an assignee (= identity link type) for a task - a group can be a candidate-group (= identity link ...
--     * Slot: id Description: Unique identifier.
--     * Slot: group_id Description: Reference to a group.
--     * Slot: type Description: Type discriminator.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
-- # Class: Membership Description: Association entity in identity and access management.
--     * Slot: id
--     * Slot: user_id Description: Reference to a user.
--     * Slot: group_id Description: Reference to a group.
-- # Class: Tenant Description: Represents a tenant, used in IdentityService.
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
-- # Class: TenantMembership Description: Association entity in identity and access management.
--     * Slot: id Description: Unique identifier.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: group_id Description: Reference to a group.
-- # Class: User Description: Represents a user, used in IdentityService.
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
-- # Class: CaseExecution Description: Case Execution entity in the process execution runtime.
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
-- # Class: CaseSentryPart Description: Case Sentry Part entity in the process execution runtime.
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
-- # Class: EventSubscription Description: A message event subscription exists, if an Execution waits for an event like a message.
--     * Slot: id Description: Unique identifier.
--     * Slot: event_type Description: The event subscriptions type. "message" identifies message event subscriptions, "signal" identifies signal event subscription, "compensation" identifies event subscriptions used for compensation ev...
--     * Slot: event_name Description: The name of the event this subscription belongs to as defined in the process model.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: configuration Description: Payload of this incident.
--     * Slot: created Description: The time this event subscription was created.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
-- # Class: Execution Description: Represent a 'path of execution' in a process instance. Note that a ProcessInstance also is an execution.
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
-- # Class: ExternalTask Description: Represents an instance of an external task that is created when a service-task like activity (i.e. service task, send task, ...) with attribute camunda:type="external" is executed.
--     * Slot: id Description: Unique identifier.
--     * Slot: worker_id Description: Id of the worker that fetched the external task most recently.
--     * Slot: topic_name Description: Topic name of the associated external task.
--     * Slot: retries Description: Number of retries this job has left. Whenever the jobexecutor fails to execute the job, this value is decremented. When it hits zero, the job is supposed to be dead and not retried again (ie a manu...
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
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..5...
--     * Slot: last_failure_log_id Description: Reference to the last failure log.
-- # Class: Incident Description: An Incident represents a failure in the execution of a process instance. A possible failure could be for example a failed Job during the execution, so that the job retry is equal zero (job.retries ...
--     * Slot: id Description: Unique identifier.
--     * Slot: incident_timestamp Description: Time when the incident happened.
--     * Slot: incident_message Description: Incident message.
--     * Slot: incident_type Description: Type of this incident to identify the kind of incident. For example: failedJobs will be returned in the case of an incident, which identify failed job during the execution of a process instance.
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
--     * Slot: annotation Description: Annotation of this incident
-- # Class: Task Description: Represents one task for a human user.
--     * Slot: id Description: Unique identifier.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: case_execution_id Description: Reference to the case execution.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: name Description: Human-readable name.
--     * Slot: parent_task_id Description: The parent task for which this task is a subtask
--     * Slot: description Description: Human-readable description.
--     * Slot: task_definition_key Description: The id of the activity in the process defining this task or null if this is not related to a process
--     * Slot: owner Description: The userId of the person that is responsible for this task. This is used when a task is delegated.
--     * Slot: assignee Description: The userId of the person to which this task is assigned or delegated.
--     * Slot: delegation_state Description: The current DelegationState for this task.
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..5...
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: last_updated Description: The date/time when this task was last updated. All operations that fire count as an update to the task. Returns null if the task was never updated before (i.e. it was only created).
--     * Slot: due_date Description: Due date of the task.
--     * Slot: follow_up_date Description: Follow-up date of the task.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: task_state Description: Task's state.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: VariableInstance Description: A VariableInstance represents a variable in the execution of a process instance.
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
-- # Class: Attachment Description: Any type of content that is be associated with a task or with a process instance.
--     * Slot: id Description: Unique identifier.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: name Description: Human-readable name.
--     * Slot: description Description: Human-readable description.
--     * Slot: type Description: Type discriminator.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: url Description: The remote URL in case this is remote content. If the attachment content was uploaded with an input stream, then this method returns null and the content can be fetched with .
--     * Slot: content_id Description: Reference to the content.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: Comment Description: User comments that form discussions around tasks.
--     * Slot: id Description: Unique identifier.
--     * Slot: type Description: Type discriminator.
--     * Slot: event_time Description: Timestamp for event time.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: action Description: The action.
--     * Slot: message Description: Short message or summary.
--     * Slot: full_message Description: The full comment message the user had related to the task and/or process instance
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: Filter Description: Filter entity in the user collaboration.
--     * Slot: id Description: Unique identifier.
--     * Slot: resource_type Description: Numeric type of the authorized resource.
--     * Slot: name Description: Human-readable name.
--     * Slot: owner Description: The userId of the person that is responsible for this task. This is used when a task is delegated.
--     * Slot: query Description: Serialized query expression.
--     * Slot: properties Description: Serialized properties.
-- # Class: CaseDefinition Description: A deployed case definition in the process repository.
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
-- # Class: DecisionDefinition Description: Definition of a decision resource
--     * Slot: decision_requirements_definition_id Description: Id of the related decision requirements definition. Can be null if the decision has no relations to other decisions.
--     * Slot: decision_requirements_definition_key Description: Key of the related decision requirements definition. Can be null if the decision has no relations to other decisions.
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
-- # Class: DecisionRequirementsDefinition Description: Container of DecisionDefinitions which belongs to the same decision requirements graph (i.e. DMN resource).
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
-- # Class: Deployment Description: Represents a deployment that is already present in the process repository. A deployment is a container for resources such as process definitions, images, forms, etc. When a deployment is 'deployed'...
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: deploy_time Description: Timestamp for deploy time.
--     * Slot: source Description: The source.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: FormDefinition Description: An object structure representing a Camunda Form used to present forms to users either when starting a process instance or when assigned to a User Task. Camunda Forms are usually composed with the h...
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
-- # Class: ProcessDefinition Description: An object structure representing an executable process composed of activities and transitions. Business processes are often created with graphical editors that store the process definition in certa...
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
-- # Abstract Class: ResourceDefinition Description: Abstract base for deployable resource definitions (process, case, decision, form).
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
-- # Class: Batch Description: A batch represents a number of jobs which execute a number of commands asynchronously. Batches have three types of jobs: Seed jobs: Create execution jobs Execution jobs: Execute the actual action M...
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
-- # Class: Job Description: Represents one job (timer, message, etc.).
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
--     * Slot: retries Description: Number of retries this job has left. Whenever the jobexecutor fails to execute the job, this value is decremented. When it hits zero, the job is supposed to be dead and not retried again (ie a manu...
--     * Slot: exception_stack_id Description: Reference to a ByteArray.
--     * Slot: exception_message Description: Message of the exception that occurred, the last time the job was executed. Returns null when no exception occurred. To get the full exception stacktrace, use
--     * Slot: failed_activity_id Description: Id of the activity on which the last exception occurred.
--     * Slot: due_date Description: Due date of the task.
--     * Slot: repeat Description: Repeat/recurrence expression (ISO 8601).
--     * Slot: repeat_offset Description: Offset applied to repeat interval calculation.
--     * Slot: handler_type Description: Type of handler that processes this entity.
--     * Slot: handler_configuration Description: Configuration for the handler.
--     * Slot: deployment_id Description: Reference to the deployment.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: job_definition_id Description: Reference to the job definition.
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..5...
--     * Slot: sequence_counter Description: Monotonically increasing counter for ordering.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: last_failure_log_id Description: Reference to the last failure log.
--     * Slot: batch_id Description: Reference to a batch.
--     * Slot: FluxnovaPlatformData_id Description: Autocreated FK slot
-- # Class: JobDefinition Description: A Job Definition provides details about asynchronous background processing ("Jobs") performed by the process engine. Each Job Definition corresponds to a Timer or Asynchronous continuation job inst...
--     * Slot: id Description: Unique identifier.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: job_type Description: The Type of a job. Asynchronous continuation, timer, ...
--     * Slot: job_configuration Description: The configuration of a job definition provides details about the jobs which will be created. For timer jobs this method returns the timer configuration.
--     * Slot: suspension_state Description: Whether the entity is active or suspended.
--     * Slot: job_priority Description: Priority of the associated job when this log entry was created.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: deployment_id Description: Reference to the deployment.
-- # Class: HistoricActivityInstance Description: Represents one execution of an activity and it's stored permanent for statistics, audit and other business intelligence purposes.
--     * Slot: parent_activity_instance_id Description: Id of the parent activity instance
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: called_process_instance_id Description: The called process instance in case of call activity
--     * Slot: called_case_instance_id Description: The called case instance in case of (case) call activity
--     * Slot: activity_name Description: The display name for the activity
--     * Slot: activity_type Description: The activity type of the activity. Typically the activity type correspond to the XML tag used in the BPMN 2.0 process definition file. All activity types are available in org.finos.fluxnova.bpm.eng...
--     * Slot: assignee Description: The userId of the person to which this task is assigned or delegated.
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
-- # Class: HistoricBatch Description: Historic representation of a org.finos.fluxnova.bpm.engine.batch.Batch.
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
-- # Class: HistoricCaseActivityInstance Description: Represents one execution of a case activity which is stored permanent for statistics, audit and other business intelligence purposes.
--     * Slot: parent_activity_instance_id Description: Id of the parent activity instance
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_activity_id Description: The unique identifier of the case activity in the case.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: called_process_instance_id Description: The called process instance in case of call activity
--     * Slot: called_case_instance_id Description: The called case instance in case of (case) call activity
--     * Slot: case_activity_name Description: The display name for the case activity.
--     * Slot: case_activity_type Description: The display type for the case activity.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: state Description: Current state of HistoricProcessInstance, following values are recognized during process engine operations: STATE_ACTIVE - running process instance STATE_SUSPENDED - suspended process instances STA...
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
-- # Class: HistoricCaseInstance Description: A single execution of a case definition that is stored permanently.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: business_key Description: Domain-specific business key.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: close_time Description: The time the case was closed.
--     * Slot: state Description: Current state of HistoricProcessInstance, following values are recognized during process engine operations: STATE_ACTIVE - running process instance STATE_SUSPENDED - suspended process instances STA...
--     * Slot: create_user_id Description: The authenticated user that created this case instance.
--     * Slot: super_case_instance_id Description: The case instance id of a potential super case instance or null if no super case instance exists
--     * Slot: super_process_instance_id Description: The process instance id of a potential super process instance or null if no super process instance exists
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
-- # Class: HistoricDecisionInputInstance Description: Represents one input variable of a decision evaluation.
--     * Slot: id Description: Unique identifier.
--     * Slot: decision_instance_id Description: The unique identifier of the historic decision instance.
--     * Slot: clause_id Description: The unique identifier of the clause that the value is assigned for. Can be null if the decision is not implemented as decision table.
--     * Slot: clause_name Description: The name of the clause that the value is assigned for. Can be null if the decision is not implemented as decision table.
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
-- # Class: HistoricDecisionInstance Description: Represents one evaluation of a decision.
--     * Slot: id Description: Unique identifier.
--     * Slot: decision_definition_id Description: The decision definition reference.
--     * Slot: decision_definition_key Description: The unique identifier of the decision definition
--     * Slot: decision_definition_name Description: The name of the decision definition
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
--     * Slot: root_decision_instance_id Description: The unique identifier of the historic decision instance of the evaluated root decision. Can be null if this instance is the root decision instance of the evaluation.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: decision_requirements_definition_id Description: Id of the related decision requirements definition. Can be null if the decision has no relations to other decisions.
--     * Slot: decision_requirements_definition_key Description: Key of the related decision requirements definition. Can be null if the decision has no relations to other decisions.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
-- # Class: HistoricDecisionOutputInstance Description: Represents one output variable of a decision evaluation.
--     * Slot: id Description: Unique identifier.
--     * Slot: decision_instance_id Description: The unique identifier of the historic decision instance.
--     * Slot: clause_id Description: The unique identifier of the clause that the value is assigned for. Can be null if the decision is not implemented as decision table.
--     * Slot: clause_name Description: The name of the clause that the value is assigned for. Can be null if the decision is not implemented as decision table.
--     * Slot: rule_id Description: The unique identifier of the rule that is matched. Can be null if the decision is not implemented as decision table.
--     * Slot: rule_order Description: The order of the rule that is matched. Can be null if the decision is not implemented as decision table.
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
-- # Class: HistoricDetail Description: Base class for all kinds of information that is related to either a HistoricProcessInstance or a HistoricActivityInstance.
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
--     * Slot: operation_id Description: The unique identifier of this operation. If an operation modifies multiple properties, multiple UserOperationLogEntry instances will be created with a common operationId. This allows grouping multi...
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: is_initial Description: Whether this entity is initial.
-- # Class: HistoricExternalTaskLog Description: The HistoricExternalTaskLog is used to have a log containing information about ExternalTask task execution. The log provides details about the last lifecycle state of a ExternalTask task: An instan...
--     * Slot: id Description: Unique identifier.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: external_task_id Description: Id of the associated external task.
--     * Slot: retries Description: Number of retries this job has left. Whenever the jobexecutor fails to execute the job, this value is decremented. When it hits zero, the job is supposed to be dead and not retried again (ie a manu...
--     * Slot: topic_name Description: Topic name of the associated external task.
--     * Slot: worker_id Description: Id of the worker that fetched the external task most recently.
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..5...
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
--     * Slot: state Description: Current state of HistoricProcessInstance, following values are recognized during process engine operations: STATE_ACTIVE - running process instance STATE_SUSPENDED - suspended process instances STA...
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: HistoricIdentityLink Description: An historic identity link stores the association of a task with a certain identity. For example, historic identity link is logged on the following conditions: - a user can be an assignee/Candidate/...
--     * Slot: id Description: Unique identifier.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: type Description: Type discriminator.
--     * Slot: user_id Description: Reference to a user.
--     * Slot: group_id Description: Reference to a group.
--     * Slot: task_id Description: Reference to the task.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: operation_type Description: Type of identity link history (add or delete identity link)
--     * Slot: assigner_id Description: UserId of the user who assigns a task to the user
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: HistoricIncident Description: Represents a historic Incident incident that is stored permanently.
--     * Slot: id Description: Unique identifier.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: create_time Description: Creation timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: incident_message Description: Incident message.
--     * Slot: incident_type Description: Type of this incident to identify the kind of incident. For example: failedJobs will be returned in the case of an incident, which identify failed job during the execution of a process instance.
--     * Slot: activity_id Description: BPMN activity element identifier.
--     * Slot: failed_activity_id Description: Id of the activity on which the last exception occurred.
--     * Slot: cause_incident_id Description: Id of the incident on which this incident has been triggered.
--     * Slot: root_cause_incident_id Description: Id of the root incident on which this transitive incident has been triggered.
--     * Slot: configuration Description: Payload of this incident.
--     * Slot: history_configuration Description: History payload of this incident.
--     * Slot: incident_state Description: The incident state.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: job_definition_id Description: Reference to the job definition.
--     * Slot: annotation Description: Annotation of this incident
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: HistoricJobLog Description: The HistoricJobLog is used to have a log containing information about Job job execution. The log provides details about the complete lifecycle of a Job job: An instance of HistoricJobLog represents...
--     * Slot: id Description: Unique identifier.
--     * Slot: timestamp Description: Time when this log occurred.
--     * Slot: job_id Description: Id of the associated job.
--     * Slot: job_due_date Description: Due date of the associated job when this log occurred.
--     * Slot: job_retries Description: Retries of the associated job before the associated job has been executed and when this log occurred.
--     * Slot: job_priority Description: Priority of the associated job when this log entry was created.
--     * Slot: job_exception_message Description: Message of the exception that occurred by executing the associated job. To get the full exception stacktrace, use
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
-- # Class: HistoricProcessInstance Description: A single execution of a whole process definition that is stored permanently.
--     * Slot: business_key Description: Domain-specific business key.
--     * Slot: start_user_id Description: The authenticated user that started this process instance.
--     * Slot: start_activity_id Description: The start activity.
--     * Slot: end_activity_id Description: Reference to the end activity.
--     * Slot: super_process_instance_id Description: The process instance id of a potential super process instance or null if no super process instance exists
--     * Slot: super_case_instance_id Description: The case instance id of a potential super case instance or null if no super case instance exists
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: delete_reason Description: Obtains the reason for the process instance's deletion.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: state Description: Current state of HistoricProcessInstance, following values are recognized during process engine operations: STATE_ACTIVE - running process instance STATE_SUSPENDED - suspended process instances STA...
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
-- # Abstract Class: HistoricScopeInstance Description: Abstract base for historic entities with start/end time and duration.
--     * Slot: id Description: Unique identifier.
--     * Slot: root_process_instance_id Description: Root process instance for history cleanup.
--     * Slot: process_instance_id Description: Reference to the process instance.
--     * Slot: process_definition_id Description: Reference to the process definition.
--     * Slot: process_definition_key Description: Key of the process definition.
--     * Slot: start_time Description: Start timestamp.
--     * Slot: end_time Description: End timestamp.
--     * Slot: duration Description: Duration in milliseconds.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: HistoricTaskInstance Description: Represents a historic task instance (waiting, finished or deleted) that is stored permanent for statistics, audit and other business intelligence purposes.
--     * Slot: task_definition_key Description: The id of the activity in the process defining this task or null if this is not related to a process
--     * Slot: execution_id Description: Reference to the execution.
--     * Slot: case_definition_key Description: Case definition key reference.
--     * Slot: case_definition_id Description: Reference to the case definition.
--     * Slot: case_instance_id Description: Reference to the case instance.
--     * Slot: case_execution_id Description: Reference to the case execution.
--     * Slot: activity_instance_id Description: Runtime activity instance identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: parent_task_id Description: The parent task for which this task is a subtask
--     * Slot: description Description: Human-readable description.
--     * Slot: owner Description: The userId of the person that is responsible for this task. This is used when a task is delegated.
--     * Slot: assignee Description: The userId of the person to which this task is assigned or delegated.
--     * Slot: delete_reason Description: Obtains the reason for the process instance's deletion.
--     * Slot: priority Description: Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..5...
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
-- # Class: HistoricVariableInstance Description: A single process variable containing the last value when its process instance has finished. It is only available when HISTORY_LEVEL is set >= AUDIT
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
--     * Slot: state Description: Current state of HistoricProcessInstance, following values are recognized during process engine operations: STATE_ACTIVE - running process instance STATE_SUSPENDED - suspended process instances STA...
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
-- # Class: UserOperationLogEntry Description: Log entry about an operation performed by a user. This is used for logging actions such as creating a new task, completing a task, canceling a process instance, ... The type of the operation which ...
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
--     * Slot: operation_type Description: Type of identity link history (add or delete identity link)
--     * Slot: operation_id Description: The unique identifier of this operation. If an operation modifies multiple properties, multiple UserOperationLogEntry instances will be created with a common operationId. This allows grouping multi...
--     * Slot: entity_type Description: The type of the entity on which this operation was executed.
--     * Slot: property Description: The property changed by this operation.
--     * Slot: original_value Description: The original value.
--     * Slot: new_value Description: The new value of the property.
--     * Slot: tenant_id Description: Multi-tenancy discriminator.
--     * Slot: removal_time Description: Timestamp when this entity is eligible for removal.
--     * Slot: category Description: Category classification.
--     * Slot: external_task_id Description: Id of the associated external task.
--     * Slot: annotation Description: Annotation of this incident
-- # Class: Bounds Description: The DC bounds element
--     * Slot: id
--     * Slot: x Description: X coordinate (horizontal offset) of this element's bounds.
--     * Slot: y Description: Y coordinate (vertical offset) of this element's bounds.
--     * Slot: width Description: Width of this element's bounding rectangle.
--     * Slot: height Description: Height of this element's bounding rectangle.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Font Description: The DC font element
--     * Slot: id
--     * Slot: name Description: Human-readable name.
--     * Slot: size Description: Font size in points.
--     * Slot: bold Description: Whether the font is rendered in bold.
--     * Slot: italic Description: Whether the font is rendered in italic.
--     * Slot: underline Description: Whether the font is underlined.
--     * Slot: strike_through Description: Whether the font has a strike-through decoration.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Point Description: The DC point element
--     * Slot: id
--     * Slot: x Description: X coordinate (horizontal offset) of this element's bounds.
--     * Slot: y Description: Y coordinate (vertical offset) of this element's bounds.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Diagram Description: The DI Diagram element
--     * Slot: name Description: Human-readable name.
--     * Slot: documentation Description: Human-readable documentation attached to this element.
--     * Slot: resolution Description: The resolution of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DiagramElement Description: The DI DiagramElement element
--     * Slot: id Description: Unique identifier.
--     * Slot: Plane_id Description: Autocreated FK slot
--     * Slot: BpmnPlane_id Description: Autocreated FK slot
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Edge Description: The DI Edge element
--     * Slot: id Description: Unique identifier.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Extension Description: The DI extension element of the DI DiagramElement type
--     * Slot: id
--     * Slot: Definitions_id Description: Autocreated FK slot
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Label Description: The DI Label element
--     * Slot: id Description: Unique identifier.
--     * Slot: bounds_id Description: Bounding rectangle giving position and size of this diagram element.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: LabeledEdge Description: The DI LabeledEdge element
--     * Slot: id Description: Unique identifier.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: LabeledShape Description: The DI LabeledShape element
--     * Slot: id Description: Unique identifier.
--     * Slot: bounds_id Description: Bounding rectangle giving position and size of this diagram element.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Node Description: The DI Node element
--     * Slot: id Description: Unique identifier.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Plane Description: The DI Plane element
--     * Slot: id Description: Unique identifier.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Shape Description: The DI Shape element
--     * Slot: id Description: Unique identifier.
--     * Slot: bounds_id Description: Bounding rectangle giving position and size of this diagram element.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Style Description: The DI Style element
--     * Slot: id Description: Unique identifier.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Waypoint Description: The DI waypoint element of the DI Edge type
--     * Slot: id
--     * Slot: x Description: X coordinate (horizontal offset) of this element's bounds.
--     * Slot: y Description: Y coordinate (vertical offset) of this element's bounds.
--     * Slot: Edge_id Description: Autocreated FK slot
--     * Slot: LabeledEdge_id Description: Autocreated FK slot
--     * Slot: BpmnEdge_id Description: Autocreated FK slot
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ActivationCondition Description: The BPMN element activationCondition of the BPMN tComplexGateway type
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Activity Description: The BPMN activity element
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Artifact Description: The BPMN artifact element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Assignment Description: The BPMN assignment element
--     * Slot: from_ Description: The source expression of this assignment.
--     * Slot: to_ Description: The target expression of this assignment.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: DataAssociation_id Description: Autocreated FK slot
--     * Slot: DataInputAssociation_id Description: Autocreated FK slot
--     * Slot: DataOutputAssociation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Association Description: The BPMN association element
--     * Slot: source Description: The source.
--     * Slot: target Description: The catching link event that receives this link.
--     * Slot: association_direction Description: The association direction of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Auditing Description: The BPMN auditing element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BaseElement Description: The BPMN baseElement element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BoundaryEvent Description: The BPMN boundaryEvent element
--     * Slot: attached_to Description: The activity to which this boundary event is attached.
--     * Slot: parallel_multiple Description: Whether all event triggers must occur (parallel) rather than any one.
--     * Slot: output_set Description: The output set associated with this output data.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnModelElementInstance Description: Interface implemented by all elements in a BPMN Model
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BusinessRuleTask Description: The BPMN businessRuleTask element
--     * Slot: implementation Description: Implementation technology of this service or send/receive task.
--     * Slot: fluxnova_class Description: Camunda extensions
--     * Slot: fluxnova_delegate_expression Description: Expression resolving to a JavaDelegate.
--     * Slot: fluxnova_expression Description: EL expression for this element.
--     * Slot: fluxnova_result_variable Description: Process variable to store the expression result.
--     * Slot: fluxnova_type Description: Type name for this form field or listener.
--     * Slot: fluxnova_topic Description: External task topic name.
--     * Slot: fluxnova_decision_ref Description: Fluxnova extension property: decision ref.
--     * Slot: fluxnova_decision_ref_binding Description: Fluxnova extension property: decision ref binding.
--     * Slot: fluxnova_decision_ref_version Description: Fluxnova extension property: decision ref version.
--     * Slot: fluxnova_decision_ref_version_tag Description: Fluxnova extension property: decision ref version tag.
--     * Slot: fluxnova_decision_ref_tenant_id Description: Fluxnova extension property: decision ref tenant id.
--     * Slot: fluxnova_map_decision_result Description: Fluxnova extension property: map decision result.
--     * Slot: fluxnova_task_priority Description: Fluxnova extension property: task priority.
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CallActivity Description: The BPMN callActivity element
--     * Slot: called_element Description: The global task or process called by this call activity.
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: fluxnova_called_element_binding Description: Fluxnova extension property: called element binding.
--     * Slot: fluxnova_called_element_version Description: Fluxnova extension property: called element version.
--     * Slot: fluxnova_called_element_version_tag Description: Fluxnova extension property: called element version tag.
--     * Slot: fluxnova_case_ref Description: Fluxnova extension property: case ref.
--     * Slot: fluxnova_case_binding Description: Fluxnova extension property: case binding.
--     * Slot: fluxnova_case_version Description: Fluxnova extension property: case version.
--     * Slot: fluxnova_called_element_tenant_id Description: Fluxnova extension property: called element tenant id.
--     * Slot: fluxnova_case_tenant_id Description: Fluxnova extension property: case tenant id.
--     * Slot: fluxnova_variable_mapping_class Description: Fluxnova extension property: variable mapping class.
--     * Slot: fluxnova_variable_mapping_delegate_expression Description: Fluxnova extension property: variable mapping delegate expression.
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CallConversation Description: The BPMN callConversation element
--     * Slot: called_collaboration Description: The collaboration element called by this call conversation.
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CallableElement Description: The BPMN callableElement element
--     * Slot: name Description: Human-readable name.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CancelEventDefinition Description: The BPMN cancelEventDefinition element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CatchEvent Description: The BPMN catchEvent element
--     * Slot: parallel_multiple Description: Whether all event triggers must occur (parallel) rather than any one.
--     * Slot: output_set Description: The output set associated with this output data.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Category Description: A named grouping used to categorise BPMN elements via CategoryValue references.
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CategoryValue Description: The BPMN categoryValue element
--     * Slot: value Description: Value of this variable instance.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Activity_id Description: Autocreated FK slot
--     * Slot: BoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: CallActivity_id Description: Autocreated FK slot
--     * Slot: CatchEvent_id Description: Autocreated FK slot
--     * Slot: Category_id Description: Autocreated FK slot
--     * Slot: ComplexGateway_id Description: Autocreated FK slot
--     * Slot: DataObject_id Description: Autocreated FK slot
--     * Slot: DataObjectReference_id Description: Autocreated FK slot
--     * Slot: DataStoreReference_id Description: Autocreated FK slot
--     * Slot: EndEvent_id Description: Autocreated FK slot
--     * Slot: Event_id Description: Autocreated FK slot
--     * Slot: EventBasedGateway_id Description: Autocreated FK slot
--     * Slot: ExclusiveGateway_id Description: Autocreated FK slot
--     * Slot: FlowElement_id Description: Autocreated FK slot
--     * Slot: FlowNode_id Description: Autocreated FK slot
--     * Slot: Gateway_id Description: Autocreated FK slot
--     * Slot: InclusiveGateway_id Description: Autocreated FK slot
--     * Slot: IntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: IntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: ManualTask_id Description: Autocreated FK slot
--     * Slot: ParallelGateway_id Description: Autocreated FK slot
--     * Slot: ReceiveTask_id Description: Autocreated FK slot
--     * Slot: ScriptTask_id Description: Autocreated FK slot
--     * Slot: SendTask_id Description: Autocreated FK slot
--     * Slot: SequenceFlow_id Description: Autocreated FK slot
--     * Slot: ServiceTask_id Description: Autocreated FK slot
--     * Slot: StartEvent_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: ThrowEvent_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Collaboration Description: The BPMN collaboration element
--     * Slot: name Description: Human-readable name.
--     * Slot: closed Description: Whether closed.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CompensateEventDefinition Description: The BPMN compensateEventDefinition element
--     * Slot: wait_for_completion Description: Whether to wait for the compensation to complete.
--     * Slot: activity Description: The activity of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CompletionCondition Description: The BPMN 2.0 completionCondition element from the tMultiInstanceLoopCharacteristics type
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ComplexBehaviorDefinition Description: Note: Currently not implemented, because both child elements are defined with a name already used in the BPMN model API and it is currently not supported by the model API to define elements with th...
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: MultiInstanceLoopCharacteristics_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ComplexGateway Description: The BPMN complexGateway element
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: activation_condition Description: Condition that activates this complex gateway.
--     * Slot: gateway_direction Description: Convergence/divergence direction of token routing through this gateway.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Condition Description: The BPMN condition element of the BPMN tConditionalEventDefinition type
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ConditionExpression Description: The BPMN conditionExpression element of the BPMN tSequenceFlow type
--     * Slot: type Description: Type discriminator.
--     * Slot: fluxnova_resource Description: Camunda extensions
--     * Slot: language Description: The language of this element.
--     * Slot: evaluates_to_type Description: The evaluates to type of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ConditionalEventDefinition Description: The BPMN conditionalEventDefinition element
--     * Slot: condition Description: Condition guard expression.
--     * Slot: fluxnova_variable_name Description: Fluxnova extension property: variable name.
--     * Slot: fluxnova_variable_events Description: Fluxnova extension property: variable events.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Conversation Description: The BPMN conversation element
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ConversationAssociation Description: The BPMN conversationAssociation element
--     * Slot: inner_conversation_node Description: The inner conversation node of this element.
--     * Slot: outer_conversation_node Description: The outer conversation node of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ConversationLink Description: The BPMN conversationLink element
--     * Slot: name Description: Human-readable name.
--     * Slot: source Description: The source.
--     * Slot: target Description: The catching link event that receives this link.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ConversationNode Description: The BPMN conversationNode element
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: SubConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CorrelationKey Description: The BPMN correlationKey element
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: CallConversation_id Description: Autocreated FK slot
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: Conversation_id Description: Autocreated FK slot
--     * Slot: ConversationNode_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: SubConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CorrelationProperty Description: The BPMN correlationProperty element
--     * Slot: name Description: Human-readable name.
--     * Slot: type Description: Type discriminator.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: CorrelationKey_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CorrelationPropertyBinding Description: The BPMN correlationPropertyBinding element
--     * Slot: correlation_property Description: The correlation property this binding is based on.
--     * Slot: data_path Description: XPath expression navigating to the relevant data node.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: CorrelationSubscription_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CorrelationPropertyRetrievalExpression Description: The BPMN correlationPropertyRetrievalExpression element
--     * Slot: message Description: Short message or summary.
--     * Slot: message_path Description: The message path of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: CorrelationProperty_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: CorrelationSubscription Description: The BPMN correlationSubscription element
--     * Slot: correlation_key Description: Correlation key grouping correlation properties.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataAssociation Description: The BPMN dataAssociation element
--     * Slot: target Description: The catching link event that receives this link.
--     * Slot: transformation Description: Transformation expression applied during data association.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataInput Description: The BPMN dataInput element
--     * Slot: name Description: Human-readable name.
--     * Slot: collection Description: Whether collection.
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: EndEvent_id Description: Autocreated FK slot
--     * Slot: InputSet_id Description: Autocreated FK slot
--     * Slot: IntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: IoSpecification_id Description: Autocreated FK slot
--     * Slot: ThrowEvent_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataInputAssociation Description: The BPMN dataInputAssociation element
--     * Slot: target Description: The catching link event that receives this link.
--     * Slot: transformation Description: Transformation expression applied during data association.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Activity_id Description: Autocreated FK slot
--     * Slot: BusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: CallActivity_id Description: Autocreated FK slot
--     * Slot: EndEvent_id Description: Autocreated FK slot
--     * Slot: IntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: ManualTask_id Description: Autocreated FK slot
--     * Slot: ReceiveTask_id Description: Autocreated FK slot
--     * Slot: ScriptTask_id Description: Autocreated FK slot
--     * Slot: SendTask_id Description: Autocreated FK slot
--     * Slot: ServiceTask_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: ThrowEvent_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataObject Description: The BPMN dataObject element
--     * Slot: collection Description: Whether collection.
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataObjectReference Description: The BPMN dataObjectReference element
--     * Slot: data_object Description: The data object that this reference points to.
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataOutput Description: The BPMN dataOutput element
--     * Slot: name Description: Human-readable name.
--     * Slot: collection Description: Whether collection.
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: BoundaryEvent_id Description: Autocreated FK slot
--     * Slot: CatchEvent_id Description: Autocreated FK slot
--     * Slot: IntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: IoSpecification_id Description: Autocreated FK slot
--     * Slot: OutputSet_id Description: Autocreated FK slot
--     * Slot: StartEvent_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataOutputAssociation Description: The BPMN dataOutputAssociation element
--     * Slot: target Description: The catching link event that receives this link.
--     * Slot: transformation Description: Transformation expression applied during data association.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Activity_id Description: Autocreated FK slot
--     * Slot: BoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: CallActivity_id Description: Autocreated FK slot
--     * Slot: CatchEvent_id Description: Autocreated FK slot
--     * Slot: IntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: ManualTask_id Description: Autocreated FK slot
--     * Slot: ReceiveTask_id Description: Autocreated FK slot
--     * Slot: ScriptTask_id Description: Autocreated FK slot
--     * Slot: SendTask_id Description: Autocreated FK slot
--     * Slot: ServiceTask_id Description: Autocreated FK slot
--     * Slot: StartEvent_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataState Description: The BPMN dataState element
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataStore Description: The BPMN dataStore element
--     * Slot: name Description: Human-readable name.
--     * Slot: capacity Description: Maximum number of items this data store can hold.
--     * Slot: unlimited Description: Whether unlimited.
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: DataStoreReference Description: The BPMN dataStoreReference element
--     * Slot: data_store Description: The data store that this reference points to.
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Definitions Description: The BPMN definitions element
--     * Slot: id Description: Unique identifier.
--     * Slot: name Description: Human-readable name.
--     * Slot: target_namespace Description: Namespace URI for elements defined in this document.
--     * Slot: expression_language Description: Default expression language used in this definitions element.
--     * Slot: type_language Description: Default type language used for item definitions.
--     * Slot: exporter Description: Name of the tool that exported this BPMN document.
--     * Slot: exporter_version Description: Version of the exporting tool.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Documentation Description: The BPMN documentation element
--     * Slot: id Description: Unique identifier.
--     * Slot: text_format Description: MIME type or format of the documentation text.
--     * Slot: ActivationCondition_id Description: Autocreated FK slot
--     * Slot: Activity_id Description: Autocreated FK slot
--     * Slot: Artifact_id Description: Autocreated FK slot
--     * Slot: Assignment_id Description: Autocreated FK slot
--     * Slot: Association_id Description: Autocreated FK slot
--     * Slot: Auditing_id Description: Autocreated FK slot
--     * Slot: BaseElement_id Description: Autocreated FK slot
--     * Slot: BoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: CallActivity_id Description: Autocreated FK slot
--     * Slot: CallConversation_id Description: Autocreated FK slot
--     * Slot: CallableElement_id Description: Autocreated FK slot
--     * Slot: CancelEventDefinition_id Description: Autocreated FK slot
--     * Slot: CatchEvent_id Description: Autocreated FK slot
--     * Slot: Category_id Description: Autocreated FK slot
--     * Slot: CategoryValue_id Description: Autocreated FK slot
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: CompensateEventDefinition_id Description: Autocreated FK slot
--     * Slot: CompletionCondition_id Description: Autocreated FK slot
--     * Slot: ComplexBehaviorDefinition_id Description: Autocreated FK slot
--     * Slot: ComplexGateway_id Description: Autocreated FK slot
--     * Slot: Condition_id Description: Autocreated FK slot
--     * Slot: ConditionExpression_id Description: Autocreated FK slot
--     * Slot: ConditionalEventDefinition_id Description: Autocreated FK slot
--     * Slot: Conversation_id Description: Autocreated FK slot
--     * Slot: ConversationAssociation_id Description: Autocreated FK slot
--     * Slot: ConversationLink_id Description: Autocreated FK slot
--     * Slot: ConversationNode_id Description: Autocreated FK slot
--     * Slot: CorrelationKey_id Description: Autocreated FK slot
--     * Slot: CorrelationProperty_id Description: Autocreated FK slot
--     * Slot: CorrelationPropertyBinding_id Description: Autocreated FK slot
--     * Slot: CorrelationPropertyRetrievalExpression_id Description: Autocreated FK slot
--     * Slot: CorrelationSubscription_id Description: Autocreated FK slot
--     * Slot: DataAssociation_id Description: Autocreated FK slot
--     * Slot: DataInput_id Description: Autocreated FK slot
--     * Slot: DataInputAssociation_id Description: Autocreated FK slot
--     * Slot: DataObject_id Description: Autocreated FK slot
--     * Slot: DataObjectReference_id Description: Autocreated FK slot
--     * Slot: DataOutput_id Description: Autocreated FK slot
--     * Slot: DataOutputAssociation_id Description: Autocreated FK slot
--     * Slot: DataState_id Description: Autocreated FK slot
--     * Slot: DataStore_id Description: Autocreated FK slot
--     * Slot: DataStoreReference_id Description: Autocreated FK slot
--     * Slot: EndEvent_id Description: Autocreated FK slot
--     * Slot: EndPoint_id Description: Autocreated FK slot
--     * Slot: Error_id Description: Autocreated FK slot
--     * Slot: ErrorEventDefinition_id Description: Autocreated FK slot
--     * Slot: Escalation_id Description: Autocreated FK slot
--     * Slot: EscalationEventDefinition_id Description: Autocreated FK slot
--     * Slot: Event_id Description: Autocreated FK slot
--     * Slot: EventBasedGateway_id Description: Autocreated FK slot
--     * Slot: EventDefinition_id Description: Autocreated FK slot
--     * Slot: ExclusiveGateway_id Description: Autocreated FK slot
--     * Slot: Expression_id Description: Autocreated FK slot
--     * Slot: FlowElement_id Description: Autocreated FK slot
--     * Slot: FlowNode_id Description: Autocreated FK slot
--     * Slot: FormalExpression_id Description: Autocreated FK slot
--     * Slot: Gateway_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: BpmnGroup_id Description: Autocreated FK slot
--     * Slot: HumanPerformer_id Description: Autocreated FK slot
--     * Slot: InclusiveGateway_id Description: Autocreated FK slot
--     * Slot: InputDataItem_id Description: Autocreated FK slot
--     * Slot: InputSet_id Description: Autocreated FK slot
--     * Slot: Interface_id Description: Autocreated FK slot
--     * Slot: IntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: IntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: IoBinding_id Description: Autocreated FK slot
--     * Slot: IoSpecification_id Description: Autocreated FK slot
--     * Slot: ItemAwareElement_id Description: Autocreated FK slot
--     * Slot: ItemDefinition_id Description: Autocreated FK slot
--     * Slot: Lane_id Description: Autocreated FK slot
--     * Slot: LaneSet_id Description: Autocreated FK slot
--     * Slot: LinkEventDefinition_id Description: Autocreated FK slot
--     * Slot: LoopCardinality_id Description: Autocreated FK slot
--     * Slot: LoopCharacteristics_id Description: Autocreated FK slot
--     * Slot: ManualTask_id Description: Autocreated FK slot
--     * Slot: Message_id Description: Autocreated FK slot
--     * Slot: MessageEventDefinition_id Description: Autocreated FK slot
--     * Slot: MessageFlow_id Description: Autocreated FK slot
--     * Slot: MessageFlowAssociation_id Description: Autocreated FK slot
--     * Slot: Monitoring_id Description: Autocreated FK slot
--     * Slot: MultiInstanceLoopCharacteristics_id Description: Autocreated FK slot
--     * Slot: Operation_id Description: Autocreated FK slot
--     * Slot: OutputDataItem_id Description: Autocreated FK slot
--     * Slot: OutputSet_id Description: Autocreated FK slot
--     * Slot: ParallelGateway_id Description: Autocreated FK slot
--     * Slot: Participant_id Description: Autocreated FK slot
--     * Slot: ParticipantAssociation_id Description: Autocreated FK slot
--     * Slot: ParticipantMultiplicity_id Description: Autocreated FK slot
--     * Slot: Performer_id Description: Autocreated FK slot
--     * Slot: PotentialOwner_id Description: Autocreated FK slot
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: BpmnProperty_id Description: Autocreated FK slot
--     * Slot: ReceiveTask_id Description: Autocreated FK slot
--     * Slot: Relationship_id Description: Autocreated FK slot
--     * Slot: Rendering_id Description: Autocreated FK slot
--     * Slot: Resource_id Description: Autocreated FK slot
--     * Slot: ResourceAssignmentExpression_id Description: Autocreated FK slot
--     * Slot: ResourceParameter_id Description: Autocreated FK slot
--     * Slot: ResourceParameterBinding_id Description: Autocreated FK slot
--     * Slot: ResourceRole_id Description: Autocreated FK slot
--     * Slot: RootElement_id Description: Autocreated FK slot
--     * Slot: ScriptTask_id Description: Autocreated FK slot
--     * Slot: SendTask_id Description: Autocreated FK slot
--     * Slot: SequenceFlow_id Description: Autocreated FK slot
--     * Slot: ServiceTask_id Description: Autocreated FK slot
--     * Slot: Signal_id Description: Autocreated FK slot
--     * Slot: SignalEventDefinition_id Description: Autocreated FK slot
--     * Slot: StartEvent_id Description: Autocreated FK slot
--     * Slot: SubConversation_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: TerminateEventDefinition_id Description: Autocreated FK slot
--     * Slot: TextAnnotation_id Description: Autocreated FK slot
--     * Slot: ThrowEvent_id Description: Autocreated FK slot
--     * Slot: TimeCycle_id Description: Autocreated FK slot
--     * Slot: TimeDate_id Description: Autocreated FK slot
--     * Slot: TimeDuration_id Description: Autocreated FK slot
--     * Slot: TimerEventDefinition_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: FluxnovaErrorEventDefinition_id Description: Autocreated FK slot
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: EndEvent Description: The BPMN endEvent element
--     * Slot: input_set Description: The input set associated with this input data.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: EndPoint Description: The BPMN endPoint element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Participant_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Error Description: The BPMN error element
--     * Slot: name Description: Human-readable name.
--     * Slot: error_code Description: The error code identifying this error.
--     * Slot: fluxnova_error_message Description: Fluxnova extension property: error message.
--     * Slot: structure Description: The structure of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Operation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ErrorEventDefinition Description: The BPMN errorEventDefinition element
--     * Slot: error Description: The error of this element.
--     * Slot: fluxnova_error_code_variable Description: Process variable to receive the error code.
--     * Slot: fluxnova_error_message_variable Description: Process variable to receive the error message.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Escalation Description: The BPMN escalation element
--     * Slot: name Description: Human-readable name.
--     * Slot: escalation_code Description: The escalation code identifying this escalation.
--     * Slot: structure Description: The structure of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: EscalationEventDefinition Description: The BPMN escalationEventDefinition element
--     * Slot: escalation Description: The escalation of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Event Description: The BPMN event element
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: EventBasedGateway Description: The BPMN eventBasedGateway element
--     * Slot: instantiate Description: Whether receiving this message creates a new process instance.
--     * Slot: event_gateway_type Description: The event gateway type of this element.
--     * Slot: gateway_direction Description: Convergence/divergence direction of token routing through this gateway.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: EventDefinition Description: The BPMN eventDefinition element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: BoundaryEvent_id Description: Autocreated FK slot
--     * Slot: CatchEvent_id Description: Autocreated FK slot
--     * Slot: EndEvent_id Description: Autocreated FK slot
--     * Slot: IntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: IntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: StartEvent_id Description: Autocreated FK slot
--     * Slot: ThrowEvent_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ExclusiveGateway Description: The BPMN exclusiveGateway element
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: gateway_direction Description: Convergence/divergence direction of token routing through this gateway.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Expression Description: The BPMN expression element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ExtensionElements Description: The BPMN extensionElements element
--     * Slot: id
--     * Slot: elements_query Description: The elements query of this element.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FlowElement Description: The BPMN flowElement element
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FlowNode Description: The BPMN flowNode element
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Lane_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FormalExpression Description: The BPMN formalExpression element
--     * Slot: language Description: The language of this element.
--     * Slot: evaluates_to_type Description: The evaluates to type of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Gateway Description: The BPMN gateway element
--     * Slot: gateway_direction Description: Convergence/divergence direction of token routing through this gateway.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: GlobalConversation Description: The BPMN globalConversation element
--     * Slot: name Description: Human-readable name.
--     * Slot: closed Description: Whether closed.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnGroup Description: An artifact that visually groups flow elements without affecting the process semantics.
--     * Slot: category Description: Category classification.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: HumanPerformer Description: The BPMN humanPerformer element
--     * Slot: name Description: Human-readable name.
--     * Slot: resource Description: The resource of this element.
--     * Slot: resource_assignment_expression Description: Expression used to resolve the assigned resource.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Import Description: The BPMN Import element
--     * Slot: id
--     * Slot: namespace Description: The namespace of this element.
--     * Slot: location Description: The location of this element.
--     * Slot: import_type Description: The import type of this element.
--     * Slot: Definitions_id Description: Autocreated FK slot
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: InclusiveGateway Description: The BPMN inclusiveGateway element
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: gateway_direction Description: Convergence/divergence direction of token routing through this gateway.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: InputDataItem Description: The BPMN 2.0 inputDataItem from the tMultiInstanceLoopCharacteristics type
--     * Slot: name Description: Human-readable name.
--     * Slot: collection Description: Whether collection.
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: InputSet Description: The BPMN inputSet element
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: IoSpecification_id Description: Autocreated FK slot
--     * Slot: OutputSet_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: InteractionNode Description: The BPMN interactionNode interface
--     * Slot: id Description: Unique identifier.
-- # Class: Interface Description: The BPMN interface element
--     * Slot: name Description: Human-readable name.
--     * Slot: implementation_ref Description: The implementation ref of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: CallableElement_id Description: Autocreated FK slot
--     * Slot: Participant_id Description: Autocreated FK slot
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: IntermediateCatchEvent Description: The BPMN intermediateCatchEvent element
--     * Slot: parallel_multiple Description: Whether all event triggers must occur (parallel) rather than any one.
--     * Slot: output_set Description: The output set associated with this output data.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: IntermediateThrowEvent Description: The BPMN intermediateThrowEvent element
--     * Slot: input_set Description: The input set associated with this input data.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: IoBinding Description: The BPMN ioBinding element
--     * Slot: operation Description: The operation of this element.
--     * Slot: input_data Description: The input data of this element.
--     * Slot: output_data Description: The output data of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: CallableElement_id Description: Autocreated FK slot
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: IoSpecification Description: The BPMN inputOutputSpecification element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ItemAwareElement Description: The BPMN itemAwareElement element
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: DataAssociation_id Description: Autocreated FK slot
--     * Slot: DataInputAssociation_id Description: Autocreated FK slot
--     * Slot: DataOutputAssociation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ItemDefinition Description: The BPMN itemDefinition element
--     * Slot: structure_ref Description: The item definition describing the data structure.
--     * Slot: collection Description: Whether collection.
--     * Slot: item_kind Description: The item kind of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Lane Description: The BPMN lane element
--     * Slot: name Description: Human-readable name.
--     * Slot: partition_element Description: The partitioning element (e.g. performer) represented by this lane.
--     * Slot: partition_element_child Description: The partition element child of this element.
--     * Slot: child_lane_set Description: The child lane set contained within this lane.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: LaneSet_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: LaneSet Description: The BPMN laneSet element
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: LinkEventDefinition Description: The BPMN linkEventDefinition element
--     * Slot: name Description: Human-readable name.
--     * Slot: target Description: The catching link event that receives this link.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: LinkEventDefinition_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: LoopCardinality Description: The loopCardinality element from the tMultiInstanceLoopCharacteristics complex type
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: LoopCharacteristics Description: The BPMN loopCharacteristics element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ManualTask Description: The BPMN manualTask element
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Message Description: The BPMN message element
--     * Slot: name Description: Human-readable name.
--     * Slot: item Description: The item of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: MessageEventDefinition Description: The BPMN messageEventDefinition element
--     * Slot: message Description: Short message or summary.
--     * Slot: operation Description: The operation of this element.
--     * Slot: fluxnova_class Description: Camunda extensions
--     * Slot: fluxnova_delegate_expression Description: Expression resolving to a JavaDelegate.
--     * Slot: fluxnova_expression Description: EL expression for this element.
--     * Slot: fluxnova_result_variable Description: Process variable to store the expression result.
--     * Slot: fluxnova_topic Description: External task topic name.
--     * Slot: fluxnova_type Description: Type name for this form field or listener.
--     * Slot: fluxnova_task_priority Description: Fluxnova extension property: task priority.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: MessageFlow Description: The BPMN messageFlow element
--     * Slot: name Description: Human-readable name.
--     * Slot: source Description: The source.
--     * Slot: target Description: The catching link event that receives this link.
--     * Slot: message Description: Short message or summary.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: CallConversation_id Description: Autocreated FK slot
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: Conversation_id Description: Autocreated FK slot
--     * Slot: ConversationNode_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: SubConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: MessageFlowAssociation Description: The BPMN messageFlowAssociation element
--     * Slot: inner_message_flow Description: The inner message flow of this element.
--     * Slot: outer_message_flow Description: The outer message flow of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Monitoring Description: The BPMN monitoring element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: MultiInstanceLoopCharacteristics Description: The BPMN 2.0 multiInstanceLoopCharacteristics element type
--     * Slot: loop_cardinality Description: Expression evaluating to the number of loop iterations.
--     * Slot: loop_data_input_ref Description: The loop data input ref of this element.
--     * Slot: loop_data_output_ref Description: The loop data output ref of this element.
--     * Slot: input_data_item Description: Loop input data item variable.
--     * Slot: output_data_item Description: Loop output data item variable.
--     * Slot: completion_condition Description: Condition that, when true, terminates remaining instances.
--     * Slot: sequential Description: Whether sequential.
--     * Slot: behavior Description: Behavior governing how completion events are thrown.
--     * Slot: one_behavior_event_ref Description: The one behavior event ref of this element.
--     * Slot: none_behavior_event_ref Description: The none behavior event ref of this element.
--     * Slot: fluxnova_collection Description: Fluxnova extension property: collection.
--     * Slot: fluxnova_element_variable Description: Fluxnova extension property: element variable.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Operation Description: The BPMN operation element
--     * Slot: name Description: Human-readable name.
--     * Slot: implementation_ref Description: The implementation ref of this element.
--     * Slot: in_message Description: The in message of this element.
--     * Slot: out_message Description: The out message of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Interface_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: OutputDataItem Description: The BPMN 2.0 outputDataItem from the tMultiInstanceLoopCharacteristics type
--     * Slot: name Description: Human-readable name.
--     * Slot: collection Description: Whether collection.
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: OutputSet Description: The BPMN outputSet element
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: InputSet_id Description: Autocreated FK slot
--     * Slot: IoSpecification_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ParallelGateway Description: The BPMN parallelGateway element
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: gateway_direction Description: Convergence/divergence direction of token routing through this gateway.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Participant Description: The BPMN participant element
--     * Slot: name Description: Human-readable name.
--     * Slot: process Description: The process of this element.
--     * Slot: participant_multiplicity Description: Multiplicity configuration of this participant.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: CallConversation_id Description: Autocreated FK slot
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: Conversation_id Description: Autocreated FK slot
--     * Slot: ConversationNode_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: SubConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ParticipantAssociation Description: The BPMN participantAssociation element
--     * Slot: inner_participant Description: The inner participant of this element.
--     * Slot: outer_participant Description: The outer participant of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: CallConversation_id Description: Autocreated FK slot
--     * Slot: Collaboration_id Description: Autocreated FK slot
--     * Slot: GlobalConversation_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ParticipantMultiplicity Description: The BPMN participantMultiplicity element
--     * Slot: minimum Description: Minimum number of instances for this participant multiplicity.
--     * Slot: maximum Description: Maximum number of instances for this participant multiplicity.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Performer Description: The BPMN performer element
--     * Slot: name Description: Human-readable name.
--     * Slot: resource Description: The resource of this element.
--     * Slot: resource_assignment_expression Description: Expression used to resolve the assigned resource.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: PotentialOwner Description: The BPMN potentialOwner element
--     * Slot: name Description: Human-readable name.
--     * Slot: resource Description: The resource of this element.
--     * Slot: resource_assignment_expression Description: Expression used to resolve the assigned resource.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Process Description: The BPMN process element
--     * Slot: process_type Description: Whether this process is a public, private, or collaboration process.
--     * Slot: closed Description: Whether closed.
--     * Slot: executable Description: Whether executable.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: fluxnova_candidate_starter_groups Description: Camunda extensions
--     * Slot: fluxnova_candidate_starter_users Description: Fluxnova extension property: candidate starter users.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: fluxnova_task_priority Description: Fluxnova extension property: task priority.
--     * Slot: fluxnova_history_time_to_live Description: Fluxnova extension property: history time to live.
--     * Slot: fluxnova_history_time_to_live_string Description: Fluxnova extension property: history time to live string.
--     * Slot: fluxnova_startable_in_tasklist Description: Fluxnova extension property: startable in tasklist.
--     * Slot: fluxnova_version_tag Description: Fluxnova extension property: version tag.
--     * Slot: name Description: Human-readable name.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnProperty Description: The BPMN property element
--     * Slot: name Description: Human-readable name.
--     * Slot: item_subject Description: The item subject of this element.
--     * Slot: data_state Description: Current state of this data object or data store reference.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Activity_id Description: Autocreated FK slot
--     * Slot: BoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: CallActivity_id Description: Autocreated FK slot
--     * Slot: CatchEvent_id Description: Autocreated FK slot
--     * Slot: EndEvent_id Description: Autocreated FK slot
--     * Slot: Event_id Description: Autocreated FK slot
--     * Slot: IntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: IntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: ManualTask_id Description: Autocreated FK slot
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: ReceiveTask_id Description: Autocreated FK slot
--     * Slot: ScriptTask_id Description: Autocreated FK slot
--     * Slot: SendTask_id Description: Autocreated FK slot
--     * Slot: ServiceTask_id Description: Autocreated FK slot
--     * Slot: StartEvent_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: ThrowEvent_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ReceiveTask Description: The BPMN receiveTask element
--     * Slot: implementation Description: Implementation technology of this service or send/receive task.
--     * Slot: message Description: Short message or summary.
--     * Slot: operation Description: The operation of this element.
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Relationship Description: The BPMN relationship element
--     * Slot: type Description: Type discriminator.
--     * Slot: direction Description: Direction of this relationship.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Definitions_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Rendering Description: The BPMN rendering element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Resource Description: The BPMN resource element
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ResourceAssignmentExpression Description: The BPMN resourceAssignmentExpression element
--     * Slot: expression Description: The expression of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ResourceParameter Description: The BPMN resourceParameter element
--     * Slot: name Description: Human-readable name.
--     * Slot: type Description: Type discriminator.
--     * Slot: required Description: Whether required.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Resource_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ResourceParameterBinding Description: The BPMN resourceParameterBinding element
--     * Slot: parameter Description: The parameter of this element.
--     * Slot: expression Description: The expression of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: HumanPerformer_id Description: Autocreated FK slot
--     * Slot: Performer_id Description: Autocreated FK slot
--     * Slot: PotentialOwner_id Description: Autocreated FK slot
--     * Slot: ResourceRole_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ResourceRole Description: The BPMN resourceRole element
--     * Slot: name Description: Human-readable name.
--     * Slot: resource Description: The resource of this element.
--     * Slot: resource_assignment_expression Description: Expression used to resolve the assigned resource.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Activity_id Description: Autocreated FK slot
--     * Slot: BusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: CallActivity_id Description: Autocreated FK slot
--     * Slot: ManualTask_id Description: Autocreated FK slot
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: ReceiveTask_id Description: Autocreated FK slot
--     * Slot: ScriptTask_id Description: Autocreated FK slot
--     * Slot: SendTask_id Description: Autocreated FK slot
--     * Slot: ServiceTask_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: RootElement Description: The BPMN rootElement element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Definitions_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Script Description: The BPMN script element
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ScriptTask Description: The BPMN scriptTask element
--     * Slot: script_format Description: MIME type or language of the script (e.g. application/javascript).
--     * Slot: fluxnova_result_variable Description: Process variable to store the expression result.
--     * Slot: fluxnova_resource Description: Camunda extensions
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: script_id Description: Script code of this script task.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: SendTask Description: The BPMN sendTask element
--     * Slot: implementation Description: Implementation technology of this service or send/receive task.
--     * Slot: message Description: Short message or summary.
--     * Slot: operation Description: The operation of this element.
--     * Slot: fluxnova_class Description: Camunda extensions
--     * Slot: fluxnova_delegate_expression Description: Expression resolving to a JavaDelegate.
--     * Slot: fluxnova_expression Description: EL expression for this element.
--     * Slot: fluxnova_result_variable Description: Process variable to store the expression result.
--     * Slot: fluxnova_type Description: Type name for this form field or listener.
--     * Slot: fluxnova_topic Description: External task topic name.
--     * Slot: fluxnova_task_priority Description: Fluxnova extension property: task priority.
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: SequenceFlow Description: The BPMN sequenceFlow element
--     * Slot: source Description: The source.
--     * Slot: target Description: The catching link event that receives this link.
--     * Slot: immediate Description: Whether immediate.
--     * Slot: condition_expression Description: Expression evaluated to decide whether this flow is taken.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: Activity_id Description: Autocreated FK slot
--     * Slot: BoundaryEvent_id Description: Autocreated FK slot
--     * Slot: BusinessRuleTask_id Description: Autocreated FK slot
--     * Slot: CallActivity_id Description: Autocreated FK slot
--     * Slot: CatchEvent_id Description: Autocreated FK slot
--     * Slot: ComplexGateway_id Description: Autocreated FK slot
--     * Slot: EndEvent_id Description: Autocreated FK slot
--     * Slot: Event_id Description: Autocreated FK slot
--     * Slot: EventBasedGateway_id Description: Autocreated FK slot
--     * Slot: ExclusiveGateway_id Description: Autocreated FK slot
--     * Slot: FlowNode_id Description: Autocreated FK slot
--     * Slot: Gateway_id Description: Autocreated FK slot
--     * Slot: InclusiveGateway_id Description: Autocreated FK slot
--     * Slot: IntermediateCatchEvent_id Description: Autocreated FK slot
--     * Slot: IntermediateThrowEvent_id Description: Autocreated FK slot
--     * Slot: ManualTask_id Description: Autocreated FK slot
--     * Slot: ParallelGateway_id Description: Autocreated FK slot
--     * Slot: ReceiveTask_id Description: Autocreated FK slot
--     * Slot: ScriptTask_id Description: Autocreated FK slot
--     * Slot: SendTask_id Description: Autocreated FK slot
--     * Slot: ServiceTask_id Description: Autocreated FK slot
--     * Slot: StartEvent_id Description: Autocreated FK slot
--     * Slot: SubProcess_id Description: Autocreated FK slot
--     * Slot: BpmnTask_id Description: Autocreated FK slot
--     * Slot: ThrowEvent_id Description: Autocreated FK slot
--     * Slot: Transaction_id Description: Autocreated FK slot
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ServiceTask Description: The BPMN serviceTask element
--     * Slot: implementation Description: Implementation technology of this service or send/receive task.
--     * Slot: operation Description: The operation of this element.
--     * Slot: fluxnova_class Description: Camunda extensions
--     * Slot: fluxnova_delegate_expression Description: Expression resolving to a JavaDelegate.
--     * Slot: fluxnova_expression Description: EL expression for this element.
--     * Slot: fluxnova_result_variable Description: Process variable to store the expression result.
--     * Slot: fluxnova_type Description: Type name for this form field or listener.
--     * Slot: fluxnova_topic Description: External task topic name.
--     * Slot: fluxnova_task_priority Description: Fluxnova extension property: task priority.
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Signal Description: The BPMN signal element
--     * Slot: name Description: Human-readable name.
--     * Slot: structure Description: The structure of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: SignalEventDefinition Description: The BPMN signalEventDefinition element
--     * Slot: signal Description: The signal of this element.
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: StartEvent Description: The BPMN startEvent element
--     * Slot: interrupting Description: Whether this start event interrupts the parent sub-process.
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: fluxnova_form_handler_class Description: Fluxnova extension property: form handler class.
--     * Slot: fluxnova_form_key Description: Fluxnova extension property: form key.
--     * Slot: fluxnova_form_ref Description: Fluxnova extension property: form ref.
--     * Slot: fluxnova_form_ref_binding Description: Fluxnova extension property: form ref binding.
--     * Slot: fluxnova_form_ref_version Description: Fluxnova extension property: form ref version.
--     * Slot: fluxnova_initiator Description: Fluxnova extension property: initiator.
--     * Slot: parallel_multiple Description: Whether all event triggers must occur (parallel) rather than any one.
--     * Slot: output_set Description: The output set associated with this output data.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: SubConversation Description: The BPMN subConversation element
--     * Slot: name Description: Human-readable name.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: SubProcess Description: The BPMN subProcess element
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnTask Description: The BPMN task element
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: TerminateEventDefinition Description: The BPMN terminateEventDefinition element
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Text Description: The BPMN 2.0 text element from the tTextAnnotation complex type
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: TextAnnotation Description: The BPMN 2.0 textAnnotation element
--     * Slot: text_format Description: MIME type or format of the documentation text.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: text_id Description: Textual content of this element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: ThrowEvent Description: The BPMN throwEvent element
--     * Slot: input_set Description: The input set associated with this input data.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: TimeCycle Description: The BPMN timeCycle element of the BPMN tTimerEventDefinition type
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: TimeDate Description: The BPMN timeDate element of the BPMN tTimerEventDefinition type
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: TimeDuration Description: The BPMN timeDuration element of the BPMN tTimerEventDefinition type
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: TimerEventDefinition Description: The BPMN timerEventDefinition element
--     * Slot: time_date Description: Specific date and time at which this timer fires.
--     * Slot: time_duration Description: Duration expression for this timer.
--     * Slot: time_cycle Description: Repeating cycle expression for this timer.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: FluxnovaTaskListener_id Description: Autocreated FK slot
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: Transaction Description: A sub-process that executes as an atomic unit with compensation support.
--     * Slot: method Description: The method of this element.
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: UserTask Description: The BPMN userTask element
--     * Slot: implementation Description: Implementation technology of this service or send/receive task.
--     * Slot: fluxnova_assignee Description: Camunda extensions
--     * Slot: fluxnova_candidate_groups Description: Fluxnova extension property: candidate groups.
--     * Slot: fluxnova_candidate_users Description: Fluxnova extension property: candidate users.
--     * Slot: fluxnova_due_date Description: Fluxnova extension property: due date.
--     * Slot: fluxnova_follow_up_date Description: Fluxnova extension property: follow up date.
--     * Slot: fluxnova_form_handler_class Description: Fluxnova extension property: form handler class.
--     * Slot: fluxnova_form_key Description: Fluxnova extension property: form key.
--     * Slot: fluxnova_form_ref Description: Fluxnova extension property: form ref.
--     * Slot: fluxnova_form_ref_binding Description: Fluxnova extension property: form ref binding.
--     * Slot: fluxnova_form_ref_version Description: Fluxnova extension property: form ref version.
--     * Slot: fluxnova_priority Description: Fluxnova extension property: priority.
--     * Slot: fluxnova_async Description: Camunda extensions */ /**
--     * Slot: for_compensation Description: Whether this activity is used for compensation handling.
--     * Slot: start_quantity Description: Minimum number of tokens required to start this activity.
--     * Slot: completion_quantity Description: Number of tokens produced when this activity completes.
--     * Slot: default Description: Default sequence flow taken when no other outgoing condition is satisfied.
--     * Slot: io_specification Description: Input and output specification of this activity.
--     * Slot: loop_characteristics Description: Loop or multi-instance characteristics of this activity.
--     * Slot: id Description: Unique identifier.
--     * Slot: previous_nodes Description: The previous nodes of this element.
--     * Slot: succeeding_nodes Description: The succeeding nodes of this element.
--     * Slot: fluxnova_async_before Description: Whether this element is executed asynchronously before its start.
--     * Slot: fluxnova_async_after Description: Whether this element is executed asynchronously after its end.
--     * Slot: fluxnova_exclusive Description: Whether this element participates in an exclusive job execution.
--     * Slot: fluxnova_job_priority Description: Priority assigned to async continuation jobs for this element.
--     * Slot: name Description: Human-readable name.
--     * Slot: auditing Description: Auditing information attached to this flow element.
--     * Slot: monitoring Description: Monitoring information attached to this flow element.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnDiagram Description: The BPMNDI BPMNDiagram element
--     * Slot: bpmn_plane Description: The plane element containing the shapes and edges of this diagram.
--     * Slot: name Description: Human-readable name.
--     * Slot: documentation Description: Human-readable documentation attached to this element.
--     * Slot: resolution Description: The resolution of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnEdge Description: The BPMNDI BPMNEdge element
--     * Slot: bpmn_element Description: The BPMN model element this diagram element represents.
--     * Slot: source_element Description: The source element of this element.
--     * Slot: target_element Description: The target element of this element.
--     * Slot: message_visible_kind Description: Visibility kind of the message flow in this edge.
--     * Slot: bpmn_label Description: The label element attached to this shape or edge.
--     * Slot: id Description: Unique identifier.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnLabel Description: The BPMNDI BPMNLabel element
--     * Slot: label_style Description: The label style of this element.
--     * Slot: id Description: Unique identifier.
--     * Slot: bounds_id Description: Bounding rectangle giving position and size of this diagram element.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnLabelStyle Description: The BPMNDI BPMNLabelStyle element
--     * Slot: id Description: Unique identifier.
--     * Slot: BpmnDiagram_id Description: Autocreated FK slot
--     * Slot: font_id Description: The font of this element.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnPlane Description: The BPMNDI BPMNPlane element
--     * Slot: bpmn_element Description: The BPMN model element this diagram element represents.
--     * Slot: id Description: Unique identifier.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnShape Description: The BPMNDI BPMNShape element
--     * Slot: bpmn_element Description: The BPMN model element this diagram element represents.
--     * Slot: horizontal Description: Whether this pool or lane is oriented horizontally.
--     * Slot: expanded Description: Whether this sub-process shape is shown in expanded form.
--     * Slot: marker_visible Description: Whether the loop or multi-instance marker is displayed.
--     * Slot: message_visible Description: Whether the message flow envelope icon is visible.
--     * Slot: participant_band_kind Description: Indicates the initiating/non-initiating role of this participant band.
--     * Slot: choreography_activity_shape Description: Shape of the associated choreography activity.
--     * Slot: bpmn_label Description: The label element attached to this shape or edge.
--     * Slot: id Description: Unique identifier.
--     * Slot: bounds_id Description: Bounding rectangle giving position and size of this diagram element.
--     * Slot: extension_id Description: Extension element containing additional diagram information.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaConnector Description: The BPMN connector camunda extension element
--     * Slot: id
--     * Slot: fluxnova_connector_id_id Description: The unique identifier of this connector configuration.
--     * Slot: fluxnova_input_output_id Description: Input/output parameter container for this connector.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaConnectorId Description: The BPMN connectorId camunda extension element
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaConstraint Description: The BPMN constraint camunda extension element
--     * Slot: id
--     * Slot: fluxnova_name Description: Name attribute of this Fluxnova extension element.
--     * Slot: fluxnova_config Description: Fluxnova extension property: config.
--     * Slot: FluxnovaValidation_id Description: Autocreated FK slot
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaEntry Description: The BPMN camundaEntry camunda extension element
--     * Slot: id
--     * Slot: fluxnova_key Description: Fluxnova extension property: key.
--     * Slot: value Description: Value of this variable instance.
--     * Slot: FluxnovaMap_id Description: Autocreated FK slot
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaErrorEventDefinition Description: Fluxnova extension that augments an end event error definition with engine-specific variables.
--     * Slot: fluxnova_expression Description: EL expression for this element.
--     * Slot: error Description: The error of this element.
--     * Slot: fluxnova_error_code_variable Description: Process variable to receive the error code.
--     * Slot: fluxnova_error_message_variable Description: Process variable to receive the error message.
--     * Slot: id Description: Unique identifier.
--     * Slot: diagram_element Description: The diagram element that visually represents this BPMN element.
--     * Slot: extension_elements_id Description: Extension elements holding vendor-specific metadata.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaExecutionListener Description: The BPMN executionListener camunda extension element
--     * Slot: id
--     * Slot: fluxnova_event Description: Event that triggers this execution listener.
--     * Slot: fluxnova_class Description: Camunda extensions
--     * Slot: fluxnova_expression Description: EL expression for this element.
--     * Slot: fluxnova_delegate_expression Description: Expression resolving to a JavaDelegate.
--     * Slot: fluxnova_script_id Description: Inline script for this element.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaExpression Description: The BPMN expression camunda extension element
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaFailedJobRetryTimeCycle Description: The BPMN failedJobRetryTimeCycle camunda extension element
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaField Description: The BPMN field camunda extension element
--     * Slot: id
--     * Slot: fluxnova_name Description: Name attribute of this Fluxnova extension element.
--     * Slot: fluxnova_expression Description: EL expression for this element.
--     * Slot: fluxnova_string_value Description: Fluxnova extension property: string value.
--     * Slot: FluxnovaExecutionListener_id Description: Autocreated FK slot
--     * Slot: FluxnovaTaskListener_id Description: Autocreated FK slot
--     * Slot: fluxnova_string_id Description: Inline string value.
--     * Slot: fluxnova_expression_child_id Description: Fluxnova extension property: expression child.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaFormData Description: The BPMN formData camunda extension element
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaFormField Description: The BPMN formField camunda extension element
--     * Slot: id
--     * Slot: fluxnova_id Description: Identifier for this Fluxnova extension element.
--     * Slot: fluxnova_label Description: Display label for this form field.
--     * Slot: fluxnova_type Description: Type name for this form field or listener.
--     * Slot: fluxnova_date_pattern Description: Date pattern for date-typed form fields.
--     * Slot: fluxnova_default_value Description: Default value for this form field.
--     * Slot: FluxnovaFormData_id Description: Autocreated FK slot
--     * Slot: fluxnova_properties_id Description: Fluxnova extension properties container.
--     * Slot: fluxnova_validation_id Description: Validation rules for this form field.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaFormProperty Description: The BPMN formProperty camunda extension element
--     * Slot: id
--     * Slot: fluxnova_id Description: Identifier for this Fluxnova extension element.
--     * Slot: fluxnova_name Description: Name attribute of this Fluxnova extension element.
--     * Slot: fluxnova_type Description: Type name for this form field or listener.
--     * Slot: fluxnova_required Description: Fluxnova extension property: required.
--     * Slot: fluxnova_readable Description: Fluxnova extension property: readable.
--     * Slot: fluxnova_writeable Description: Fluxnova extension property: writeable.
--     * Slot: fluxnova_variable Description: Fluxnova extension property: variable.
--     * Slot: fluxnova_expression Description: EL expression for this element.
--     * Slot: fluxnova_date_pattern Description: Date pattern for date-typed form fields.
--     * Slot: fluxnova_default Description: Fluxnova extension property: default.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaGenericValueElement Description: A helper interface for camunda extension elements which hold a generic child element like camunda:inputParameter, camunda:outputParameter and camunda:entry.
--     * Slot: id
--     * Slot: value Description: Value of this variable instance.
-- # Class: FluxnovaIn Description: The BPMN in camunda extension element
--     * Slot: id
--     * Slot: fluxnova_source Description: Fluxnova extension property: source.
--     * Slot: fluxnova_source_expression Description: Fluxnova extension property: source expression.
--     * Slot: fluxnova_variables Description: Fluxnova extension property: variables.
--     * Slot: fluxnova_target Description: Fluxnova extension property: target.
--     * Slot: fluxnova_business_key Description: Fluxnova extension property: business key.
--     * Slot: fluxnova_local Description: Fluxnova extension property: local.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaInputOutput Description: The BPMN inputOutput camunda extension element
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaInputParameter Description: The BPMN inputParameter camunda extension element
--     * Slot: id
--     * Slot: fluxnova_name Description: Name attribute of this Fluxnova extension element.
--     * Slot: value Description: Value of this variable instance.
--     * Slot: FluxnovaInputOutput_id Description: Autocreated FK slot
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaList Description: The BPMN camundaList extension element
--     * Slot: id
--     * Slot: values Description: The values of this element.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaMap Description: The BPMN camundaMap extension element
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaOut Description: The BPMN out camunda extension element
--     * Slot: id
--     * Slot: fluxnova_source Description: Fluxnova extension property: source.
--     * Slot: fluxnova_source_expression Description: Fluxnova extension property: source expression.
--     * Slot: fluxnova_variables Description: Fluxnova extension property: variables.
--     * Slot: fluxnova_target Description: Fluxnova extension property: target.
--     * Slot: fluxnova_local Description: Fluxnova extension property: local.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaOutputParameter Description: The BPMN outputParameter camunda extension element
--     * Slot: id
--     * Slot: fluxnova_name Description: Name attribute of this Fluxnova extension element.
--     * Slot: value Description: Value of this variable instance.
--     * Slot: FluxnovaInputOutput_id Description: Autocreated FK slot
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaPotentialStarter Description: The BPMN potentialStarter camunda extension
--     * Slot: id
--     * Slot: resource_assignment_expression Description: Expression used to resolve the assigned resource.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaProperties Description: The BPMN properties camunda extension element
--     * Slot: id
--     * Slot: fluxnova_properties_id Description: Fluxnova extension properties container.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaProperty Description: The BPMN property camunda extension element
--     * Slot: id
--     * Slot: fluxnova_id Description: Identifier for this Fluxnova extension element.
--     * Slot: fluxnova_name Description: Name attribute of this Fluxnova extension element.
--     * Slot: fluxnova_value Description: Value of this Fluxnova extension element.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaScript Description: The BPMN script camunda extension element
--     * Slot: id
--     * Slot: fluxnova_script_format Description: Fluxnova extension property: script format.
--     * Slot: fluxnova_resource Description: Camunda extensions
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaString Description: The BPMN string camunda extension element
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaTaskListener Description: The BPMN taskListener camunda extension element
--     * Slot: id
--     * Slot: fluxnova_event Description: Event that triggers this execution listener.
--     * Slot: fluxnova_class Description: Camunda extensions
--     * Slot: fluxnova_expression Description: EL expression for this element.
--     * Slot: fluxnova_delegate_expression Description: Expression resolving to a JavaDelegate.
--     * Slot: fluxnova_script_id Description: Inline script for this element.
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaValidation Description: The BPMN validation camunda extension element
--     * Slot: id
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: FluxnovaValue Description: The BPMN value camunda extension element
--     * Slot: id
--     * Slot: fluxnova_id Description: Identifier for this Fluxnova extension element.
--     * Slot: fluxnova_name Description: Name attribute of this Fluxnova extension element.
--     * Slot: FluxnovaFormField_id Description: Autocreated FK slot
--     * Slot: FluxnovaFormProperty_id Description: Autocreated FK slot
--     * Slot: scope_id Description: Tests if the element is a scope like process or sub-process.
-- # Class: BpmnModelInstance Description: Root container for a parsed BPMN model, providing access to the Definitions element.
--     * Slot: id
--     * Slot: definitions Description: The root BPMN Definitions element of this model.
-- # Class: BpmnModelType Description: Enumeration-like interface representing the BPMN model type.
--     * Slot: id
-- # Class: ConditionalEventDefinition_fluxnova_variable_events_list
--     * Slot: ConditionalEventDefinition_id Description: Autocreated FK slot
--     * Slot: fluxnova_variable_events_list Description: Fluxnova extension property: variable events list.
-- # Class: Definitions_bpm_diagrams
--     * Slot: Definitions_id Description: Autocreated FK slot
--     * Slot: bpm_diagrams Description: BPMN diagram elements (BPMNDiagram) in the root definitions.
-- # Class: ExtensionElements_elements
--     * Slot: ExtensionElements_id Description: Autocreated FK slot
--     * Slot: elements Description: Collection of elements values.
-- # Class: Process_fluxnova_candidate_starter_groups_list
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: fluxnova_candidate_starter_groups_list Description: Fluxnova extension property: candidate starter groups list.
-- # Class: Process_fluxnova_candidate_starter_users_list
--     * Slot: Process_id Description: Autocreated FK slot
--     * Slot: fluxnova_candidate_starter_users_list Description: Fluxnova extension property: candidate starter users list.
-- # Class: Relationship_sources
--     * Slot: Relationship_id Description: Autocreated FK slot
--     * Slot: sources Description: The throwing link events that send to this link target.
-- # Class: Relationship_targets
--     * Slot: Relationship_id Description: Autocreated FK slot
--     * Slot: targets Description: Collection of targets values.
-- # Class: UserTask_fluxnova_candidate_groups_list
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: fluxnova_candidate_groups_list Description: Fluxnova extension property: candidate groups list.
-- # Class: UserTask_fluxnova_candidate_users_list
--     * Slot: UserTask_id Description: Autocreated FK slot
--     * Slot: fluxnova_candidate_users_list Description: Fluxnova extension property: candidate users list.

CREATE TABLE "FluxnovaPlatformData" (
	id INTEGER NOT NULL,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaPlatformData_id" ON "FluxnovaPlatformData" (id);

CREATE TABLE "ByteArray" (
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
	PRIMARY KEY (id)
);
CREATE INDEX "ix_ByteArray_id" ON "ByteArray" (id);

CREATE TABLE "MeterLog" (
	id TEXT NOT NULL,
	name TEXT NOT NULL,
	reporter TEXT,
	value INTEGER,
	timestamp DATETIME,
	milliseconds INTEGER,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_MeterLog_id" ON "MeterLog" (id);

CREATE TABLE "Property" (
	name TEXT NOT NULL,
	value TEXT,
	PRIMARY KEY (name)
);
CREATE INDEX "ix_Property_name" ON "Property" (name);

CREATE TABLE "SchemaLogEntry" (
	id TEXT NOT NULL,
	timestamp DATETIME,
	version TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_SchemaLogEntry_id" ON "SchemaLogEntry" (id);

CREATE TABLE "TaskMeterLog" (
	id TEXT NOT NULL,
	assignee_hash INTEGER,
	timestamp DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_TaskMeterLog_id" ON "TaskMeterLog" (id);

CREATE TABLE "Authorization" (
	id TEXT NOT NULL,
	type VARCHAR(6) NOT NULL,
	group_id TEXT,
	user_id TEXT,
	resource_type INTEGER NOT NULL,
	resource_id TEXT,
	permissions INTEGER,
	removal_time DATETIME,
	root_process_instance_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_Authorization_id" ON "Authorization" (id);

CREATE TABLE "IdentityInfo" (
	id TEXT NOT NULL,
	user_id TEXT,
	type TEXT,
	"key" TEXT,
	value TEXT,
	password TEXT,
	parent_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_IdentityInfo_id" ON "IdentityInfo" (id);

CREATE TABLE "IdentityLink" (
	id TEXT NOT NULL,
	group_id TEXT,
	type TEXT,
	user_id TEXT,
	task_id TEXT,
	process_definition_id TEXT,
	tenant_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_IdentityLink_id" ON "IdentityLink" (id);

CREATE TABLE "Membership" (
	id INTEGER NOT NULL,
	user_id TEXT NOT NULL,
	group_id TEXT NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (user_id, group_id)
);
CREATE INDEX "ix_Membership_id" ON "Membership" (id);
CREATE INDEX "Membership_user_id_group_id_idx" ON "Membership" (user_id, group_id);

CREATE TABLE "Tenant" (
	id TEXT NOT NULL,
	name TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_Tenant_id" ON "Tenant" (id);

CREATE TABLE "TenantMembership" (
	id TEXT NOT NULL,
	tenant_id TEXT NOT NULL,
	user_id TEXT,
	group_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_TenantMembership_id" ON "TenantMembership" (id);

CREATE TABLE "CaseExecution" (
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
	PRIMARY KEY (id)
);
CREATE INDEX "ix_CaseExecution_id" ON "CaseExecution" (id);

CREATE TABLE "CaseSentryPart" (
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
	PRIMARY KEY (id)
);
CREATE INDEX "ix_CaseSentryPart_id" ON "CaseSentryPart" (id);

CREATE TABLE "EventSubscription" (
	id TEXT NOT NULL,
	event_type TEXT NOT NULL,
	event_name TEXT,
	execution_id TEXT,
	process_instance_id TEXT,
	activity_id TEXT,
	configuration TEXT,
	created DATETIME NOT NULL,
	tenant_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_EventSubscription_id" ON "EventSubscription" (id);

CREATE TABLE "ExternalTask" (
	id TEXT NOT NULL,
	worker_id TEXT,
	topic_name TEXT,
	retries INTEGER,
	error_message TEXT,
	error_details_id TEXT,
	lock_expiration_time DATETIME,
	create_time DATETIME,
	suspension_state VARCHAR(9),
	execution_id TEXT,
	process_instance_id TEXT,
	process_definition_id TEXT,
	process_definition_key TEXT,
	activity_id TEXT,
	activity_instance_id TEXT,
	tenant_id TEXT,
	priority INTEGER NOT NULL,
	last_failure_log_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_ExternalTask_id" ON "ExternalTask" (id);

CREATE TABLE "Incident" (
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
	PRIMARY KEY (id)
);
CREATE INDEX "ix_Incident_id" ON "Incident" (id);

CREATE TABLE "VariableInstance" (
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
	PRIMARY KEY (id)
);
CREATE INDEX "ix_VariableInstance_id" ON "VariableInstance" (id);

CREATE TABLE "Attachment" (
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
	PRIMARY KEY (id)
);
CREATE INDEX "ix_Attachment_id" ON "Attachment" (id);

CREATE TABLE "Comment" (
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
CREATE INDEX "ix_Comment_id" ON "Comment" (id);

CREATE TABLE "Filter" (
	id TEXT NOT NULL,
	resource_type TEXT NOT NULL,
	name TEXT NOT NULL,
	owner TEXT,
	"query" TEXT NOT NULL,
	properties TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_Filter_id" ON "Filter" (id);

CREATE TABLE "CaseDefinition" (
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
CREATE INDEX "ix_CaseDefinition_id" ON "CaseDefinition" (id);

CREATE TABLE "DecisionDefinition" (
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
	PRIMARY KEY (id)
);
CREATE INDEX "ix_DecisionDefinition_id" ON "DecisionDefinition" (id);

CREATE TABLE "DecisionRequirementsDefinition" (
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
CREATE INDEX "ix_DecisionRequirementsDefinition_id" ON "DecisionRequirementsDefinition" (id);

CREATE TABLE "FormDefinition" (
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
CREATE INDEX "ix_FormDefinition_id" ON "FormDefinition" (id);

CREATE TABLE "ResourceDefinition" (
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
CREATE INDEX "ix_ResourceDefinition_id" ON "ResourceDefinition" (id);

CREATE TABLE "JobDefinition" (
	id TEXT NOT NULL,
	process_definition_id TEXT,
	process_definition_key TEXT,
	activity_id TEXT,
	job_type TEXT NOT NULL,
	job_configuration TEXT,
	suspension_state VARCHAR(9),
	job_priority INTEGER NOT NULL,
	tenant_id TEXT,
	deployment_id TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_JobDefinition_id" ON "JobDefinition" (id);

CREATE TABLE "HistoricActivityInstance" (
	parent_activity_instance_id TEXT,
	execution_id TEXT NOT NULL,
	activity_id TEXT NOT NULL,
	task_id TEXT,
	called_process_instance_id TEXT,
	called_case_instance_id TEXT,
	activity_name TEXT,
	activity_type TEXT NOT NULL,
	assignee TEXT,
	activity_instance_state VARCHAR(14),
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
CREATE INDEX "ix_HistoricActivityInstance_id" ON "HistoricActivityInstance" (id);

CREATE TABLE "HistoricBatch" (
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
CREATE INDEX "ix_HistoricBatch_id" ON "HistoricBatch" (id);

CREATE TABLE "HistoricCaseActivityInstance" (
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
	state VARCHAR(21),
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
CREATE INDEX "ix_HistoricCaseActivityInstance_id" ON "HistoricCaseActivityInstance" (id);

CREATE TABLE "HistoricCaseInstance" (
	case_instance_id TEXT NOT NULL,
	business_key TEXT,
	case_definition_id TEXT NOT NULL,
	create_time DATETIME NOT NULL,
	close_time DATETIME,
	state VARCHAR(21),
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
CREATE INDEX "ix_HistoricCaseInstance_id" ON "HistoricCaseInstance" (id);

CREATE TABLE "HistoricDecisionInputInstance" (
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
CREATE INDEX "ix_HistoricDecisionInputInstance_id" ON "HistoricDecisionInputInstance" (id);

CREATE TABLE "HistoricDecisionInstance" (
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
CREATE INDEX "ix_HistoricDecisionInstance_id" ON "HistoricDecisionInstance" (id);

CREATE TABLE "HistoricDecisionOutputInstance" (
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
CREATE INDEX "ix_HistoricDecisionOutputInstance_id" ON "HistoricDecisionOutputInstance" (id);

CREATE TABLE "HistoricDetail" (
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
CREATE INDEX "ix_HistoricDetail_id" ON "HistoricDetail" (id);

CREATE TABLE "HistoricExternalTaskLog" (
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
	state VARCHAR(21),
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_HistoricExternalTaskLog_id" ON "HistoricExternalTaskLog" (id);

CREATE TABLE "HistoricIdentityLink" (
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
CREATE INDEX "ix_HistoricIdentityLink_id" ON "HistoricIdentityLink" (id);

CREATE TABLE "HistoricIncident" (
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
	incident_state VARCHAR(8),
	tenant_id TEXT,
	job_definition_id TEXT,
	annotation TEXT,
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_HistoricIncident_id" ON "HistoricIncident" (id);

CREATE TABLE "HistoricJobLog" (
	id TEXT NOT NULL,
	timestamp DATETIME NOT NULL,
	job_id TEXT NOT NULL,
	job_due_date DATETIME,
	job_retries INTEGER,
	job_priority INTEGER NOT NULL,
	job_exception_message TEXT,
	job_exception_stack_id TEXT,
	job_state VARCHAR(10),
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
CREATE INDEX "ix_HistoricJobLog_id" ON "HistoricJobLog" (id);

CREATE TABLE "HistoricProcessInstance" (
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
CREATE INDEX "ix_HistoricProcessInstance_id" ON "HistoricProcessInstance" (id);

CREATE TABLE "HistoricScopeInstance" (
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
CREATE INDEX "ix_HistoricScopeInstance_id" ON "HistoricScopeInstance" (id);

CREATE TABLE "HistoricTaskInstance" (
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
CREATE INDEX "ix_HistoricTaskInstance_id" ON "HistoricTaskInstance" (id);

CREATE TABLE "HistoricVariableInstance" (
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
	state VARCHAR(21),
	removal_time DATETIME,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_HistoricVariableInstance_id" ON "HistoricVariableInstance" (id);

CREATE TABLE "UserOperationLogEntry" (
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
CREATE INDEX "ix_UserOperationLogEntry_id" ON "UserOperationLogEntry" (id);

CREATE TABLE "Activity" (
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Activity_id" ON "Activity" (id);

CREATE TABLE "BoundaryEvent" (
	attached_to TEXT,
	parallel_multiple BOOLEAN,
	output_set TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(attached_to) REFERENCES "Activity" (id),
	FOREIGN KEY(output_set) REFERENCES "OutputSet" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BoundaryEvent_id" ON "BoundaryEvent" (id);

CREATE TABLE "BpmnModelElementInstance" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnModelElementInstance_id" ON "BpmnModelElementInstance" (id);

CREATE TABLE "BusinessRuleTask" (
	implementation TEXT,
	fluxnova_class TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_expression TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_type TEXT,
	fluxnova_topic TEXT,
	fluxnova_decision_ref TEXT,
	fluxnova_decision_ref_binding TEXT,
	fluxnova_decision_ref_version TEXT,
	fluxnova_decision_ref_version_tag TEXT,
	fluxnova_decision_ref_tenant_id TEXT,
	fluxnova_map_decision_result TEXT,
	fluxnova_task_priority TEXT,
	fluxnova_async BOOLEAN,
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BusinessRuleTask_id" ON "BusinessRuleTask" (id);

CREATE TABLE "CallActivity" (
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
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CallActivity_id" ON "CallActivity" (id);

CREATE TABLE "CatchEvent" (
	parallel_multiple BOOLEAN,
	output_set TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(output_set) REFERENCES "OutputSet" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CatchEvent_id" ON "CatchEvent" (id);

CREATE TABLE "ComplexGateway" (
	"default" TEXT,
	activation_condition TEXT,
	gateway_direction TEXT,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(activation_condition) REFERENCES "ActivationCondition" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ComplexGateway_id" ON "ComplexGateway" (id);

CREATE TABLE "DataAssociation" (
	target TEXT,
	transformation TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(target) REFERENCES "ItemAwareElement" (id),
	FOREIGN KEY(transformation) REFERENCES "FormalExpression" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataAssociation_id" ON "DataAssociation" (id);

CREATE TABLE "DataInputAssociation" (
	target TEXT,
	transformation TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Activity_id" TEXT,
	"BusinessRuleTask_id" TEXT,
	"CallActivity_id" TEXT,
	"EndEvent_id" TEXT,
	"IntermediateThrowEvent_id" TEXT,
	"ManualTask_id" TEXT,
	"ReceiveTask_id" TEXT,
	"ScriptTask_id" TEXT,
	"SendTask_id" TEXT,
	"ServiceTask_id" TEXT,
	"SubProcess_id" TEXT,
	"BpmnTask_id" TEXT,
	"ThrowEvent_id" TEXT,
	"Transaction_id" TEXT,
	"UserTask_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(target) REFERENCES "ItemAwareElement" (id),
	FOREIGN KEY(transformation) REFERENCES "FormalExpression" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Activity_id") REFERENCES "Activity" (id),
	FOREIGN KEY("BusinessRuleTask_id") REFERENCES "BusinessRuleTask" (id),
	FOREIGN KEY("CallActivity_id") REFERENCES "CallActivity" (id),
	FOREIGN KEY("EndEvent_id") REFERENCES "EndEvent" (id),
	FOREIGN KEY("IntermediateThrowEvent_id") REFERENCES "IntermediateThrowEvent" (id),
	FOREIGN KEY("ManualTask_id") REFERENCES "ManualTask" (id),
	FOREIGN KEY("ReceiveTask_id") REFERENCES "ReceiveTask" (id),
	FOREIGN KEY("ScriptTask_id") REFERENCES "ScriptTask" (id),
	FOREIGN KEY("SendTask_id") REFERENCES "SendTask" (id),
	FOREIGN KEY("ServiceTask_id") REFERENCES "ServiceTask" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("ThrowEvent_id") REFERENCES "ThrowEvent" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataInputAssociation_id" ON "DataInputAssociation" (id);

CREATE TABLE "DataOutputAssociation" (
	target TEXT,
	transformation TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Activity_id" TEXT,
	"BoundaryEvent_id" TEXT,
	"BusinessRuleTask_id" TEXT,
	"CallActivity_id" TEXT,
	"CatchEvent_id" TEXT,
	"IntermediateCatchEvent_id" TEXT,
	"ManualTask_id" TEXT,
	"ReceiveTask_id" TEXT,
	"ScriptTask_id" TEXT,
	"SendTask_id" TEXT,
	"ServiceTask_id" TEXT,
	"StartEvent_id" TEXT,
	"SubProcess_id" TEXT,
	"BpmnTask_id" TEXT,
	"Transaction_id" TEXT,
	"UserTask_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(target) REFERENCES "ItemAwareElement" (id),
	FOREIGN KEY(transformation) REFERENCES "FormalExpression" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Activity_id") REFERENCES "Activity" (id),
	FOREIGN KEY("BoundaryEvent_id") REFERENCES "BoundaryEvent" (id),
	FOREIGN KEY("BusinessRuleTask_id") REFERENCES "BusinessRuleTask" (id),
	FOREIGN KEY("CallActivity_id") REFERENCES "CallActivity" (id),
	FOREIGN KEY("CatchEvent_id") REFERENCES "CatchEvent" (id),
	FOREIGN KEY("IntermediateCatchEvent_id") REFERENCES "IntermediateCatchEvent" (id),
	FOREIGN KEY("ManualTask_id") REFERENCES "ManualTask" (id),
	FOREIGN KEY("ReceiveTask_id") REFERENCES "ReceiveTask" (id),
	FOREIGN KEY("ScriptTask_id") REFERENCES "ScriptTask" (id),
	FOREIGN KEY("SendTask_id") REFERENCES "SendTask" (id),
	FOREIGN KEY("ServiceTask_id") REFERENCES "ServiceTask" (id),
	FOREIGN KEY("StartEvent_id") REFERENCES "StartEvent" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataOutputAssociation_id" ON "DataOutputAssociation" (id);

CREATE TABLE "EndEvent" (
	input_set TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(input_set) REFERENCES "InputSet" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_EndEvent_id" ON "EndEvent" (id);

CREATE TABLE "Event" (
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Event_id" ON "Event" (id);

CREATE TABLE "EventBasedGateway" (
	instantiate BOOLEAN,
	event_gateway_type TEXT,
	gateway_direction TEXT,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_EventBasedGateway_id" ON "EventBasedGateway" (id);

CREATE TABLE "ExclusiveGateway" (
	"default" TEXT,
	gateway_direction TEXT,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ExclusiveGateway_id" ON "ExclusiveGateway" (id);

CREATE TABLE "FlowNode" (
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Lane_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Lane_id") REFERENCES "Lane" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FlowNode_id" ON "FlowNode" (id);

CREATE TABLE "Gateway" (
	gateway_direction TEXT,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Gateway_id" ON "Gateway" (id);

CREATE TABLE "InclusiveGateway" (
	"default" TEXT,
	gateway_direction TEXT,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_InclusiveGateway_id" ON "InclusiveGateway" (id);

CREATE TABLE "InputSet" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"IoSpecification_id" TEXT,
	"OutputSet_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("IoSpecification_id") REFERENCES "IoSpecification" (id),
	FOREIGN KEY("OutputSet_id") REFERENCES "OutputSet" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_InputSet_id" ON "InputSet" (id);

CREATE TABLE "InteractionNode" (
	id TEXT NOT NULL,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_InteractionNode_id" ON "InteractionNode" (id);

CREATE TABLE "IntermediateCatchEvent" (
	parallel_multiple BOOLEAN,
	output_set TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(output_set) REFERENCES "OutputSet" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_IntermediateCatchEvent_id" ON "IntermediateCatchEvent" (id);

CREATE TABLE "IntermediateThrowEvent" (
	input_set TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(input_set) REFERENCES "InputSet" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_IntermediateThrowEvent_id" ON "IntermediateThrowEvent" (id);

CREATE TABLE "ItemAwareElement" (
	item_subject TEXT,
	data_state TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"DataAssociation_id" TEXT,
	"DataInputAssociation_id" TEXT,
	"DataOutputAssociation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("DataAssociation_id") REFERENCES "DataAssociation" (id),
	FOREIGN KEY("DataInputAssociation_id") REFERENCES "DataInputAssociation" (id),
	FOREIGN KEY("DataOutputAssociation_id") REFERENCES "DataOutputAssociation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ItemAwareElement_id" ON "ItemAwareElement" (id);

CREATE TABLE "Lane" (
	name TEXT,
	partition_element TEXT,
	partition_element_child TEXT,
	child_lane_set TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"LaneSet_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("LaneSet_id") REFERENCES "LaneSet" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Lane_id" ON "Lane" (id);

CREATE TABLE "LaneSet" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Process_id" TEXT,
	"SubProcess_id" TEXT,
	"Transaction_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_LaneSet_id" ON "LaneSet" (id);

CREATE TABLE "ManualTask" (
	fluxnova_async BOOLEAN,
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ManualTask_id" ON "ManualTask" (id);

CREATE TABLE "OutputSet" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"InputSet_id" TEXT,
	"IoSpecification_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("InputSet_id") REFERENCES "InputSet" (id),
	FOREIGN KEY("IoSpecification_id") REFERENCES "IoSpecification" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_OutputSet_id" ON "OutputSet" (id);

CREATE TABLE "ParallelGateway" (
	fluxnova_async BOOLEAN,
	gateway_direction TEXT,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ParallelGateway_id" ON "ParallelGateway" (id);

CREATE TABLE "ReceiveTask" (
	implementation TEXT,
	message TEXT,
	operation TEXT,
	fluxnova_async BOOLEAN,
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(message) REFERENCES "Message" (id),
	FOREIGN KEY(operation) REFERENCES "Operation" (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ReceiveTask_id" ON "ReceiveTask" (id);

CREATE TABLE "ScriptTask" (
	script_format TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_resource TEXT,
	fluxnova_async BOOLEAN,
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	script_id INTEGER,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(script_id) REFERENCES "Script" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ScriptTask_id" ON "ScriptTask" (id);

CREATE TABLE "SendTask" (
	implementation TEXT,
	message TEXT,
	operation TEXT,
	fluxnova_class TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_expression TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_type TEXT,
	fluxnova_topic TEXT,
	fluxnova_task_priority TEXT,
	fluxnova_async BOOLEAN,
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(message) REFERENCES "Message" (id),
	FOREIGN KEY(operation) REFERENCES "Operation" (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_SendTask_id" ON "SendTask" (id);

CREATE TABLE "SequenceFlow" (
	source TEXT,
	target TEXT,
	"immediate" BOOLEAN,
	condition_expression TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Activity_id" TEXT,
	"BoundaryEvent_id" TEXT,
	"BusinessRuleTask_id" TEXT,
	"CallActivity_id" TEXT,
	"CatchEvent_id" TEXT,
	"ComplexGateway_id" TEXT,
	"EndEvent_id" TEXT,
	"Event_id" TEXT,
	"EventBasedGateway_id" TEXT,
	"ExclusiveGateway_id" TEXT,
	"FlowNode_id" TEXT,
	"Gateway_id" TEXT,
	"InclusiveGateway_id" TEXT,
	"IntermediateCatchEvent_id" TEXT,
	"IntermediateThrowEvent_id" TEXT,
	"ManualTask_id" TEXT,
	"ParallelGateway_id" TEXT,
	"ReceiveTask_id" TEXT,
	"ScriptTask_id" TEXT,
	"SendTask_id" TEXT,
	"ServiceTask_id" TEXT,
	"StartEvent_id" TEXT,
	"SubProcess_id" TEXT,
	"BpmnTask_id" TEXT,
	"ThrowEvent_id" TEXT,
	"Transaction_id" TEXT,
	"UserTask_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(source) REFERENCES "FlowNode" (id),
	FOREIGN KEY(target) REFERENCES "FlowNode" (id),
	FOREIGN KEY(condition_expression) REFERENCES "ConditionExpression" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Activity_id") REFERENCES "Activity" (id),
	FOREIGN KEY("BoundaryEvent_id") REFERENCES "BoundaryEvent" (id),
	FOREIGN KEY("BusinessRuleTask_id") REFERENCES "BusinessRuleTask" (id),
	FOREIGN KEY("CallActivity_id") REFERENCES "CallActivity" (id),
	FOREIGN KEY("CatchEvent_id") REFERENCES "CatchEvent" (id),
	FOREIGN KEY("ComplexGateway_id") REFERENCES "ComplexGateway" (id),
	FOREIGN KEY("EndEvent_id") REFERENCES "EndEvent" (id),
	FOREIGN KEY("Event_id") REFERENCES "Event" (id),
	FOREIGN KEY("EventBasedGateway_id") REFERENCES "EventBasedGateway" (id),
	FOREIGN KEY("ExclusiveGateway_id") REFERENCES "ExclusiveGateway" (id),
	FOREIGN KEY("FlowNode_id") REFERENCES "FlowNode" (id),
	FOREIGN KEY("Gateway_id") REFERENCES "Gateway" (id),
	FOREIGN KEY("InclusiveGateway_id") REFERENCES "InclusiveGateway" (id),
	FOREIGN KEY("IntermediateCatchEvent_id") REFERENCES "IntermediateCatchEvent" (id),
	FOREIGN KEY("IntermediateThrowEvent_id") REFERENCES "IntermediateThrowEvent" (id),
	FOREIGN KEY("ManualTask_id") REFERENCES "ManualTask" (id),
	FOREIGN KEY("ParallelGateway_id") REFERENCES "ParallelGateway" (id),
	FOREIGN KEY("ReceiveTask_id") REFERENCES "ReceiveTask" (id),
	FOREIGN KEY("ScriptTask_id") REFERENCES "ScriptTask" (id),
	FOREIGN KEY("SendTask_id") REFERENCES "SendTask" (id),
	FOREIGN KEY("ServiceTask_id") REFERENCES "ServiceTask" (id),
	FOREIGN KEY("StartEvent_id") REFERENCES "StartEvent" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("ThrowEvent_id") REFERENCES "ThrowEvent" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_SequenceFlow_id" ON "SequenceFlow" (id);

CREATE TABLE "ServiceTask" (
	implementation TEXT,
	operation TEXT,
	fluxnova_class TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_expression TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_type TEXT,
	fluxnova_topic TEXT,
	fluxnova_task_priority TEXT,
	fluxnova_async BOOLEAN,
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(operation) REFERENCES "Operation" (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ServiceTask_id" ON "ServiceTask" (id);

CREATE TABLE "StartEvent" (
	interrupting BOOLEAN,
	fluxnova_async BOOLEAN,
	fluxnova_form_handler_class TEXT,
	fluxnova_form_key TEXT,
	fluxnova_form_ref TEXT,
	fluxnova_form_ref_binding TEXT,
	fluxnova_form_ref_version TEXT,
	fluxnova_initiator TEXT,
	parallel_multiple BOOLEAN,
	output_set TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(output_set) REFERENCES "OutputSet" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_StartEvent_id" ON "StartEvent" (id);

CREATE TABLE "SubProcess" (
	fluxnova_async BOOLEAN,
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_SubProcess_id" ON "SubProcess" (id);

CREATE TABLE "BpmnTask" (
	fluxnova_async BOOLEAN,
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnTask_id" ON "BpmnTask" (id);

CREATE TABLE "ThrowEvent" (
	input_set TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(input_set) REFERENCES "InputSet" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ThrowEvent_id" ON "ThrowEvent" (id);

CREATE TABLE "Transaction" (
	method TEXT,
	fluxnova_async BOOLEAN,
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Transaction_id" ON "Transaction" (id);

CREATE TABLE "UserTask" (
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
	for_compensation BOOLEAN,
	start_quantity INTEGER,
	completion_quantity INTEGER,
	"default" TEXT,
	io_specification TEXT,
	loop_characteristics TEXT,
	id TEXT NOT NULL,
	previous_nodes TEXT,
	succeeding_nodes TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	fluxnova_job_priority TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("default") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(loop_characteristics) REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY(previous_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(succeeding_nodes) REFERENCES "FlowNode" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_UserTask_id" ON "UserTask" (id);

CREATE TABLE "FluxnovaGenericValueElement" (
	id INTEGER NOT NULL,
	value TEXT,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_FluxnovaGenericValueElement_id" ON "FluxnovaGenericValueElement" (id);

CREATE TABLE "BpmnModelType" (
	id INTEGER NOT NULL,
	PRIMARY KEY (id)
);
CREATE INDEX "ix_BpmnModelType_id" ON "BpmnModelType" (id);

CREATE TABLE "Group" (
	id TEXT NOT NULL,
	name TEXT,
	type TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_Group_id" ON "Group" (id);

CREATE TABLE "User" (
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
CREATE INDEX "ix_User_id" ON "User" (id);

CREATE TABLE "Execution" (
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
	suspension_state VARCHAR(9),
	cached_entity_state INTEGER,
	sequence_counter INTEGER,
	tenant_id TEXT,
	process_definition_key TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_Execution_id" ON "Execution" (id);

CREATE TABLE "Task" (
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
	suspension_state VARCHAR(9),
	tenant_id TEXT,
	task_state TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_Task_id" ON "Task" (id);

CREATE TABLE "Deployment" (
	id TEXT NOT NULL,
	name TEXT,
	deploy_time DATETIME,
	source TEXT,
	tenant_id TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_Deployment_id" ON "Deployment" (id);

CREATE TABLE "ProcessDefinition" (
	has_start_form_key BOOLEAN,
	suspension_state VARCHAR(9),
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
CREATE INDEX "ix_ProcessDefinition_id" ON "ProcessDefinition" (id);

CREATE TABLE "Batch" (
	id TEXT NOT NULL,
	type TEXT,
	total_jobs INTEGER,
	jobs_created INTEGER,
	jobs_per_seed INTEGER,
	invocations_per_job INTEGER,
	seed_job_definition_id TEXT,
	batch_job_definition_id TEXT,
	monitor_job_definition_id TEXT,
	suspension_state VARCHAR(9),
	configuration TEXT,
	tenant_id TEXT,
	create_user_id TEXT,
	start_time DATETIME,
	execution_start_time DATETIME,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_Batch_id" ON "Batch" (id);

CREATE TABLE "Job" (
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
	suspension_state VARCHAR(9) NOT NULL,
	job_definition_id TEXT,
	priority INTEGER NOT NULL,
	sequence_counter INTEGER,
	tenant_id TEXT,
	create_time DATETIME,
	last_failure_log_id TEXT,
	batch_id TEXT,
	"FluxnovaPlatformData_id" INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaPlatformData_id") REFERENCES "FluxnovaPlatformData" (id)
);
CREATE INDEX "ix_Job_id" ON "Job" (id);

CREATE TABLE "Bounds" (
	id INTEGER NOT NULL,
	x FLOAT,
	y FLOAT,
	width FLOAT,
	height FLOAT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Bounds_id" ON "Bounds" (id);

CREATE TABLE "Font" (
	id INTEGER NOT NULL,
	name TEXT,
	size FLOAT,
	bold BOOLEAN,
	italic BOOLEAN,
	underline BOOLEAN,
	strike_through BOOLEAN,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Font_id" ON "Font" (id);

CREATE TABLE "Point" (
	id INTEGER NOT NULL,
	x FLOAT,
	y FLOAT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Point_id" ON "Point" (id);

CREATE TABLE "Diagram" (
	name TEXT,
	documentation TEXT,
	resolution FLOAT,
	id TEXT NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Diagram_id" ON "Diagram" (id);

CREATE TABLE "Style" (
	id TEXT NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Style_id" ON "Style" (id);

CREATE TABLE "Definitions" (
	id TEXT NOT NULL,
	name TEXT,
	target_namespace TEXT,
	expression_language TEXT,
	type_language TEXT,
	exporter TEXT,
	exporter_version TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Definitions_id" ON "Definitions" (id);

CREATE TABLE "ExtensionElements" (
	id INTEGER NOT NULL,
	elements_query TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ExtensionElements_id" ON "ExtensionElements" (id);

CREATE TABLE "Script" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Script_id" ON "Script" (id);

CREATE TABLE "Text" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Text_id" ON "Text" (id);

CREATE TABLE "FluxnovaConnectorId" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaConnectorId_id" ON "FluxnovaConnectorId" (id);

CREATE TABLE "FluxnovaExpression" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaExpression_id" ON "FluxnovaExpression" (id);

CREATE TABLE "FluxnovaFailedJobRetryTimeCycle" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaFailedJobRetryTimeCycle_id" ON "FluxnovaFailedJobRetryTimeCycle" (id);

CREATE TABLE "FluxnovaFormData" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
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
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
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
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaIn_id" ON "FluxnovaIn" (id);

CREATE TABLE "FluxnovaInputOutput" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaInputOutput_id" ON "FluxnovaInputOutput" (id);

CREATE TABLE "FluxnovaList" (
	id INTEGER NOT NULL,
	"values" TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaList_id" ON "FluxnovaList" (id);

CREATE TABLE "FluxnovaMap" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaMap_id" ON "FluxnovaMap" (id);

CREATE TABLE "FluxnovaOut" (
	id INTEGER NOT NULL,
	fluxnova_source TEXT,
	fluxnova_source_expression TEXT,
	fluxnova_variables TEXT,
	fluxnova_target TEXT,
	fluxnova_local BOOLEAN,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaOut_id" ON "FluxnovaOut" (id);

CREATE TABLE "FluxnovaProperty" (
	id INTEGER NOT NULL,
	fluxnova_id TEXT,
	fluxnova_name TEXT,
	fluxnova_value TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaProperty_id" ON "FluxnovaProperty" (id);

CREATE TABLE "FluxnovaScript" (
	id INTEGER NOT NULL,
	fluxnova_script_format TEXT,
	fluxnova_resource TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaScript_id" ON "FluxnovaScript" (id);

CREATE TABLE "FluxnovaString" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaString_id" ON "FluxnovaString" (id);

CREATE TABLE "FluxnovaValidation" (
	id INTEGER NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaValidation_id" ON "FluxnovaValidation" (id);

CREATE TABLE "UserTask_fluxnova_candidate_groups_list" (
	"UserTask_id" TEXT,
	fluxnova_candidate_groups_list TEXT,
	PRIMARY KEY ("UserTask_id", fluxnova_candidate_groups_list),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id)
);
CREATE INDEX "ix_UserTask_fluxnova_candidate_groups_list_fluxnova_candidate_groups_list" ON "UserTask_fluxnova_candidate_groups_list" (fluxnova_candidate_groups_list);
CREATE INDEX "ix_UserTask_fluxnova_candidate_groups_list_UserTask_id" ON "UserTask_fluxnova_candidate_groups_list" ("UserTask_id");

CREATE TABLE "UserTask_fluxnova_candidate_users_list" (
	"UserTask_id" TEXT,
	fluxnova_candidate_users_list TEXT,
	PRIMARY KEY ("UserTask_id", fluxnova_candidate_users_list),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id)
);
CREATE INDEX "ix_UserTask_fluxnova_candidate_users_list_UserTask_id" ON "UserTask_fluxnova_candidate_users_list" ("UserTask_id");
CREATE INDEX "ix_UserTask_fluxnova_candidate_users_list_fluxnova_candidate_users_list" ON "UserTask_fluxnova_candidate_users_list" (fluxnova_candidate_users_list);

CREATE TABLE "Extension" (
	id INTEGER NOT NULL,
	"Definitions_id" TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("Definitions_id") REFERENCES "Definitions" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Extension_id" ON "Extension" (id);

CREATE TABLE "Import" (
	id INTEGER NOT NULL,
	namespace TEXT,
	location TEXT,
	import_type TEXT,
	"Definitions_id" TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("Definitions_id") REFERENCES "Definitions" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Import_id" ON "Import" (id);

CREATE TABLE "FluxnovaConnector" (
	id INTEGER NOT NULL,
	fluxnova_connector_id_id INTEGER,
	fluxnova_input_output_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(fluxnova_connector_id_id) REFERENCES "FluxnovaConnectorId" (id),
	FOREIGN KEY(fluxnova_input_output_id) REFERENCES "FluxnovaInputOutput" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaConnector_id" ON "FluxnovaConnector" (id);

CREATE TABLE "FluxnovaConstraint" (
	id INTEGER NOT NULL,
	fluxnova_name TEXT,
	fluxnova_config TEXT,
	"FluxnovaValidation_id" INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaValidation_id") REFERENCES "FluxnovaValidation" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaConstraint_id" ON "FluxnovaConstraint" (id);

CREATE TABLE "FluxnovaEntry" (
	id INTEGER NOT NULL,
	fluxnova_key TEXT,
	value TEXT,
	"FluxnovaMap_id" INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaMap_id") REFERENCES "FluxnovaMap" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaEntry_id" ON "FluxnovaEntry" (id);

CREATE TABLE "FluxnovaExecutionListener" (
	id INTEGER NOT NULL,
	fluxnova_event TEXT,
	fluxnova_class TEXT,
	fluxnova_expression TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_script_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(fluxnova_script_id) REFERENCES "FluxnovaScript" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaExecutionListener_id" ON "FluxnovaExecutionListener" (id);

CREATE TABLE "FluxnovaInputParameter" (
	id INTEGER NOT NULL,
	fluxnova_name TEXT,
	value TEXT,
	"FluxnovaInputOutput_id" INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaInputOutput_id") REFERENCES "FluxnovaInputOutput" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaInputParameter_id" ON "FluxnovaInputParameter" (id);

CREATE TABLE "FluxnovaOutputParameter" (
	id INTEGER NOT NULL,
	fluxnova_name TEXT,
	value TEXT,
	"FluxnovaInputOutput_id" INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaInputOutput_id") REFERENCES "FluxnovaInputOutput" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaOutputParameter_id" ON "FluxnovaOutputParameter" (id);

CREATE TABLE "FluxnovaProperties" (
	id INTEGER NOT NULL,
	fluxnova_properties_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(fluxnova_properties_id) REFERENCES "FluxnovaProperty" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaProperties_id" ON "FluxnovaProperties" (id);

CREATE TABLE "FluxnovaTaskListener" (
	id INTEGER NOT NULL,
	fluxnova_event TEXT,
	fluxnova_class TEXT,
	fluxnova_expression TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_script_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(fluxnova_script_id) REFERENCES "FluxnovaScript" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaTaskListener_id" ON "FluxnovaTaskListener" (id);

CREATE TABLE "BpmnModelInstance" (
	id INTEGER NOT NULL,
	definitions TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY(definitions) REFERENCES "Definitions" (id)
);
CREATE INDEX "ix_BpmnModelInstance_id" ON "BpmnModelInstance" (id);

CREATE TABLE "Definitions_bpm_diagrams" (
	"Definitions_id" TEXT,
	bpm_diagrams TEXT,
	PRIMARY KEY ("Definitions_id", bpm_diagrams),
	FOREIGN KEY("Definitions_id") REFERENCES "Definitions" (id)
);
CREATE INDEX "ix_Definitions_bpm_diagrams_Definitions_id" ON "Definitions_bpm_diagrams" ("Definitions_id");
CREATE INDEX "ix_Definitions_bpm_diagrams_bpm_diagrams" ON "Definitions_bpm_diagrams" (bpm_diagrams);

CREATE TABLE "ExtensionElements_elements" (
	"ExtensionElements_id" INTEGER,
	elements TEXT,
	PRIMARY KEY ("ExtensionElements_id", elements),
	FOREIGN KEY("ExtensionElements_id") REFERENCES "ExtensionElements" (id)
);
CREATE INDEX "ix_ExtensionElements_elements_ExtensionElements_id" ON "ExtensionElements_elements" ("ExtensionElements_id");
CREATE INDEX "ix_ExtensionElements_elements_elements" ON "ExtensionElements_elements" (elements);

CREATE TABLE "Edge" (
	id TEXT NOT NULL,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Edge_id" ON "Edge" (id);

CREATE TABLE "Label" (
	id TEXT NOT NULL,
	bounds_id INTEGER,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bounds_id) REFERENCES "Bounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Label_id" ON "Label" (id);

CREATE TABLE "LabeledEdge" (
	id TEXT NOT NULL,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_LabeledEdge_id" ON "LabeledEdge" (id);

CREATE TABLE "LabeledShape" (
	id TEXT NOT NULL,
	bounds_id INTEGER,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bounds_id) REFERENCES "Bounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_LabeledShape_id" ON "LabeledShape" (id);

CREATE TABLE "Node" (
	id TEXT NOT NULL,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Node_id" ON "Node" (id);

CREATE TABLE "Plane" (
	id TEXT NOT NULL,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Plane_id" ON "Plane" (id);

CREATE TABLE "Shape" (
	id TEXT NOT NULL,
	bounds_id INTEGER,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bounds_id) REFERENCES "Bounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Shape_id" ON "Shape" (id);

CREATE TABLE "BpmnPlane" (
	bpmn_element TEXT,
	id TEXT NOT NULL,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnPlane_id" ON "BpmnPlane" (id);

CREATE TABLE "FluxnovaField" (
	id INTEGER NOT NULL,
	fluxnova_name TEXT,
	fluxnova_expression TEXT,
	fluxnova_string_value TEXT,
	"FluxnovaExecutionListener_id" INTEGER,
	"FluxnovaTaskListener_id" INTEGER,
	fluxnova_string_id INTEGER,
	fluxnova_expression_child_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaExecutionListener_id") REFERENCES "FluxnovaExecutionListener" (id),
	FOREIGN KEY("FluxnovaTaskListener_id") REFERENCES "FluxnovaTaskListener" (id),
	FOREIGN KEY(fluxnova_string_id) REFERENCES "FluxnovaString" (id),
	FOREIGN KEY(fluxnova_expression_child_id) REFERENCES "FluxnovaExpression" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaField_id" ON "FluxnovaField" (id);

CREATE TABLE "FluxnovaFormField" (
	id INTEGER NOT NULL,
	fluxnova_id TEXT,
	fluxnova_label TEXT,
	fluxnova_type TEXT,
	fluxnova_date_pattern TEXT,
	fluxnova_default_value TEXT,
	"FluxnovaFormData_id" INTEGER,
	fluxnova_properties_id INTEGER,
	fluxnova_validation_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaFormData_id") REFERENCES "FluxnovaFormData" (id),
	FOREIGN KEY(fluxnova_properties_id) REFERENCES "FluxnovaProperties" (id),
	FOREIGN KEY(fluxnova_validation_id) REFERENCES "FluxnovaValidation" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaFormField_id" ON "FluxnovaFormField" (id);

CREATE TABLE "DiagramElement" (
	id TEXT NOT NULL,
	"Plane_id" TEXT,
	"BpmnPlane_id" TEXT,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("Plane_id") REFERENCES "Plane" (id),
	FOREIGN KEY("BpmnPlane_id") REFERENCES "BpmnPlane" (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DiagramElement_id" ON "DiagramElement" (id);

CREATE TABLE "BpmnDiagram" (
	bpmn_plane TEXT,
	name TEXT,
	documentation TEXT,
	resolution FLOAT,
	id TEXT NOT NULL,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(bpmn_plane) REFERENCES "BpmnPlane" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnDiagram_id" ON "BpmnDiagram" (id);

CREATE TABLE "FluxnovaValue" (
	id INTEGER NOT NULL,
	fluxnova_id TEXT,
	fluxnova_name TEXT,
	"FluxnovaFormField_id" INTEGER,
	"FluxnovaFormProperty_id" INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("FluxnovaFormField_id") REFERENCES "FluxnovaFormField" (id),
	FOREIGN KEY("FluxnovaFormProperty_id") REFERENCES "FluxnovaFormProperty" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaValue_id" ON "FluxnovaValue" (id);

CREATE TABLE "ActivationCondition" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ActivationCondition_id" ON "ActivationCondition" (id);

CREATE TABLE "Assignment" (
	from_ TEXT,
	to_ TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"DataAssociation_id" TEXT,
	"DataInputAssociation_id" TEXT,
	"DataOutputAssociation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("DataAssociation_id") REFERENCES "DataAssociation" (id),
	FOREIGN KEY("DataInputAssociation_id") REFERENCES "DataInputAssociation" (id),
	FOREIGN KEY("DataOutputAssociation_id") REFERENCES "DataOutputAssociation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Assignment_id" ON "Assignment" (id);

CREATE TABLE "Auditing" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Auditing_id" ON "Auditing" (id);

CREATE TABLE "BaseElement" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BaseElement_id" ON "BaseElement" (id);

CREATE TABLE "CancelEventDefinition" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CancelEventDefinition_id" ON "CancelEventDefinition" (id);

CREATE TABLE "Category" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Category_id" ON "Category" (id);

CREATE TABLE "Collaboration" (
	name TEXT,
	closed BOOLEAN,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Collaboration_id" ON "Collaboration" (id);

CREATE TABLE "CompensateEventDefinition" (
	wait_for_completion BOOLEAN,
	activity TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(activity) REFERENCES "Activity" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CompensateEventDefinition_id" ON "CompensateEventDefinition" (id);

CREATE TABLE "CompletionCondition" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CompletionCondition_id" ON "CompletionCondition" (id);

CREATE TABLE "Condition" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Condition_id" ON "Condition" (id);

CREATE TABLE "Conversation" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Conversation_id" ON "Conversation" (id);

CREATE TABLE "DataState" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataState_id" ON "DataState" (id);

CREATE TABLE "EventDefinition" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	"BoundaryEvent_id" TEXT,
	"CatchEvent_id" TEXT,
	"EndEvent_id" TEXT,
	"IntermediateCatchEvent_id" TEXT,
	"IntermediateThrowEvent_id" TEXT,
	"StartEvent_id" TEXT,
	"ThrowEvent_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("BoundaryEvent_id") REFERENCES "BoundaryEvent" (id),
	FOREIGN KEY("CatchEvent_id") REFERENCES "CatchEvent" (id),
	FOREIGN KEY("EndEvent_id") REFERENCES "EndEvent" (id),
	FOREIGN KEY("IntermediateCatchEvent_id") REFERENCES "IntermediateCatchEvent" (id),
	FOREIGN KEY("IntermediateThrowEvent_id") REFERENCES "IntermediateThrowEvent" (id),
	FOREIGN KEY("StartEvent_id") REFERENCES "StartEvent" (id),
	FOREIGN KEY("ThrowEvent_id") REFERENCES "ThrowEvent" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_EventDefinition_id" ON "EventDefinition" (id);

CREATE TABLE "Expression" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Expression_id" ON "Expression" (id);

CREATE TABLE "GlobalConversation" (
	name TEXT,
	closed BOOLEAN,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_GlobalConversation_id" ON "GlobalConversation" (id);

CREATE TABLE "IoSpecification" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_IoSpecification_id" ON "IoSpecification" (id);

CREATE TABLE "ItemDefinition" (
	structure_ref TEXT,
	collection BOOLEAN,
	item_kind TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ItemDefinition_id" ON "ItemDefinition" (id);

CREATE TABLE "LinkEventDefinition" (
	name TEXT,
	target TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"LinkEventDefinition_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(target) REFERENCES "LinkEventDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("LinkEventDefinition_id") REFERENCES "LinkEventDefinition" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_LinkEventDefinition_id" ON "LinkEventDefinition" (id);

CREATE TABLE "LoopCardinality" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_LoopCardinality_id" ON "LoopCardinality" (id);

CREATE TABLE "LoopCharacteristics" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_LoopCharacteristics_id" ON "LoopCharacteristics" (id);

CREATE TABLE "Monitoring" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Monitoring_id" ON "Monitoring" (id);

CREATE TABLE "ParticipantMultiplicity" (
	minimum INTEGER,
	maximum INTEGER,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ParticipantMultiplicity_id" ON "ParticipantMultiplicity" (id);

CREATE TABLE "Relationship" (
	type TEXT,
	direction TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Definitions_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Definitions_id") REFERENCES "Definitions" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Relationship_id" ON "Relationship" (id);

CREATE TABLE "Rendering" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	"UserTask_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Rendering_id" ON "Rendering" (id);

CREATE TABLE "Resource" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Resource_id" ON "Resource" (id);

CREATE TABLE "RootElement" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Definitions_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Definitions_id") REFERENCES "Definitions" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_RootElement_id" ON "RootElement" (id);

CREATE TABLE "SubConversation" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_SubConversation_id" ON "SubConversation" (id);

CREATE TABLE "TerminateEventDefinition" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_TerminateEventDefinition_id" ON "TerminateEventDefinition" (id);

CREATE TABLE "TextAnnotation" (
	text_format TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	text_id INTEGER,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(text_id) REFERENCES "Text" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_TextAnnotation_id" ON "TextAnnotation" (id);

CREATE TABLE "TimeCycle" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_TimeCycle_id" ON "TimeCycle" (id);

CREATE TABLE "TimeDate" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_TimeDate_id" ON "TimeDate" (id);

CREATE TABLE "TimeDuration" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_TimeDuration_id" ON "TimeDuration" (id);

CREATE TABLE "BpmnLabelStyle" (
	id TEXT NOT NULL,
	"BpmnDiagram_id" TEXT,
	font_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("BpmnDiagram_id") REFERENCES "BpmnDiagram" (id),
	FOREIGN KEY(font_id) REFERENCES "Font" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnLabelStyle_id" ON "BpmnLabelStyle" (id);

CREATE TABLE "Association" (
	source TEXT,
	target TEXT,
	association_direction TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(source) REFERENCES "BaseElement" (id),
	FOREIGN KEY(target) REFERENCES "BaseElement" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Association_id" ON "Association" (id);

CREATE TABLE "CallConversation" (
	called_collaboration TEXT,
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(called_collaboration) REFERENCES "GlobalConversation" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CallConversation_id" ON "CallConversation" (id);

CREATE TABLE "CallableElement" (
	name TEXT,
	io_specification TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CallableElement_id" ON "CallableElement" (id);

CREATE TABLE "ConditionExpression" (
	type TEXT,
	fluxnova_resource TEXT,
	language TEXT,
	evaluates_to_type TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(evaluates_to_type) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ConditionExpression_id" ON "ConditionExpression" (id);

CREATE TABLE "ConditionalEventDefinition" (
	condition TEXT,
	fluxnova_variable_name TEXT,
	fluxnova_variable_events TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(condition) REFERENCES "Condition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ConditionalEventDefinition_id" ON "ConditionalEventDefinition" (id);

CREATE TABLE "ConversationLink" (
	name TEXT,
	source TEXT,
	target TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Collaboration_id" TEXT,
	"GlobalConversation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(source) REFERENCES "InteractionNode" (id),
	FOREIGN KEY(target) REFERENCES "InteractionNode" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ConversationLink_id" ON "ConversationLink" (id);

CREATE TABLE "ConversationNode" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Collaboration_id" TEXT,
	"GlobalConversation_id" TEXT,
	"SubConversation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY("SubConversation_id") REFERENCES "SubConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ConversationNode_id" ON "ConversationNode" (id);

CREATE TABLE "DataInput" (
	name TEXT,
	collection BOOLEAN,
	item_subject TEXT,
	data_state TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"EndEvent_id" TEXT,
	"InputSet_id" TEXT,
	"IntermediateThrowEvent_id" TEXT,
	"IoSpecification_id" TEXT,
	"ThrowEvent_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("EndEvent_id") REFERENCES "EndEvent" (id),
	FOREIGN KEY("InputSet_id") REFERENCES "InputSet" (id),
	FOREIGN KEY("IntermediateThrowEvent_id") REFERENCES "IntermediateThrowEvent" (id),
	FOREIGN KEY("IoSpecification_id") REFERENCES "IoSpecification" (id),
	FOREIGN KEY("ThrowEvent_id") REFERENCES "ThrowEvent" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataInput_id" ON "DataInput" (id);

CREATE TABLE "DataObject" (
	collection BOOLEAN,
	item_subject TEXT,
	data_state TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataObject_id" ON "DataObject" (id);

CREATE TABLE "DataOutput" (
	name TEXT,
	collection BOOLEAN,
	item_subject TEXT,
	data_state TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"BoundaryEvent_id" TEXT,
	"CatchEvent_id" TEXT,
	"IntermediateCatchEvent_id" TEXT,
	"IoSpecification_id" TEXT,
	"OutputSet_id" TEXT,
	"StartEvent_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("BoundaryEvent_id") REFERENCES "BoundaryEvent" (id),
	FOREIGN KEY("CatchEvent_id") REFERENCES "CatchEvent" (id),
	FOREIGN KEY("IntermediateCatchEvent_id") REFERENCES "IntermediateCatchEvent" (id),
	FOREIGN KEY("IoSpecification_id") REFERENCES "IoSpecification" (id),
	FOREIGN KEY("OutputSet_id") REFERENCES "OutputSet" (id),
	FOREIGN KEY("StartEvent_id") REFERENCES "StartEvent" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataOutput_id" ON "DataOutput" (id);

CREATE TABLE "DataStore" (
	name TEXT,
	capacity INTEGER,
	unlimited BOOLEAN,
	item_subject TEXT,
	data_state TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataStore_id" ON "DataStore" (id);

CREATE TABLE "Escalation" (
	name TEXT,
	escalation_code TEXT,
	structure TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(structure) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Escalation_id" ON "Escalation" (id);

CREATE TABLE "FormalExpression" (
	language TEXT,
	evaluates_to_type TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(evaluates_to_type) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FormalExpression_id" ON "FormalExpression" (id);

CREATE TABLE "InputDataItem" (
	name TEXT,
	collection BOOLEAN,
	item_subject TEXT,
	data_state TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_InputDataItem_id" ON "InputDataItem" (id);

CREATE TABLE "Message" (
	name TEXT,
	item TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(item) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Message_id" ON "Message" (id);

CREATE TABLE "OutputDataItem" (
	name TEXT,
	collection BOOLEAN,
	item_subject TEXT,
	data_state TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_OutputDataItem_id" ON "OutputDataItem" (id);

CREATE TABLE "Process" (
	process_type TEXT,
	closed BOOLEAN,
	executable BOOLEAN,
	auditing TEXT,
	monitoring TEXT,
	fluxnova_candidate_starter_groups TEXT,
	fluxnova_candidate_starter_users TEXT,
	fluxnova_job_priority TEXT,
	fluxnova_task_priority TEXT,
	fluxnova_history_time_to_live INTEGER,
	fluxnova_history_time_to_live_string TEXT,
	fluxnova_startable_in_tasklist BOOLEAN,
	fluxnova_version_tag TEXT,
	name TEXT,
	io_specification TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Process_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(io_specification) REFERENCES "IoSpecification" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Process_id" ON "Process" (id);

CREATE TABLE "ResourceAssignmentExpression" (
	expression TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(expression) REFERENCES "Expression" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ResourceAssignmentExpression_id" ON "ResourceAssignmentExpression" (id);

CREATE TABLE "ResourceParameter" (
	name TEXT,
	type TEXT,
	required BOOLEAN,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Resource_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(type) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Resource_id") REFERENCES "Resource" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ResourceParameter_id" ON "ResourceParameter" (id);

CREATE TABLE "Signal" (
	name TEXT,
	structure TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(structure) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Signal_id" ON "Signal" (id);

CREATE TABLE "TimerEventDefinition" (
	time_date TEXT,
	time_duration TEXT,
	time_cycle TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"FluxnovaTaskListener_id" INTEGER,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(time_date) REFERENCES "TimeDate" (id),
	FOREIGN KEY(time_duration) REFERENCES "TimeDuration" (id),
	FOREIGN KEY(time_cycle) REFERENCES "TimeCycle" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("FluxnovaTaskListener_id") REFERENCES "FluxnovaTaskListener" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_TimerEventDefinition_id" ON "TimerEventDefinition" (id);

CREATE TABLE "BpmnLabel" (
	label_style TEXT,
	id TEXT NOT NULL,
	bounds_id INTEGER,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(label_style) REFERENCES "BpmnLabelStyle" (id),
	FOREIGN KEY(bounds_id) REFERENCES "Bounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnLabel_id" ON "BpmnLabel" (id);

CREATE TABLE "Relationship_sources" (
	"Relationship_id" TEXT,
	sources TEXT,
	PRIMARY KEY ("Relationship_id", sources),
	FOREIGN KEY("Relationship_id") REFERENCES "Relationship" (id)
);
CREATE INDEX "ix_Relationship_sources_sources" ON "Relationship_sources" (sources);
CREATE INDEX "ix_Relationship_sources_Relationship_id" ON "Relationship_sources" ("Relationship_id");

CREATE TABLE "Relationship_targets" (
	"Relationship_id" TEXT,
	targets TEXT,
	PRIMARY KEY ("Relationship_id", targets),
	FOREIGN KEY("Relationship_id") REFERENCES "Relationship" (id)
);
CREATE INDEX "ix_Relationship_targets_Relationship_id" ON "Relationship_targets" ("Relationship_id");
CREATE INDEX "ix_Relationship_targets_targets" ON "Relationship_targets" (targets);

CREATE TABLE "Artifact" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Collaboration_id" TEXT,
	"GlobalConversation_id" TEXT,
	"Process_id" TEXT,
	"SubProcess_id" TEXT,
	"Transaction_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Artifact_id" ON "Artifact" (id);

CREATE TABLE "ConversationAssociation" (
	inner_conversation_node TEXT,
	outer_conversation_node TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Collaboration_id" TEXT,
	"GlobalConversation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(inner_conversation_node) REFERENCES "ConversationNode" (id),
	FOREIGN KEY(outer_conversation_node) REFERENCES "ConversationNode" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ConversationAssociation_id" ON "ConversationAssociation" (id);

CREATE TABLE "CorrelationKey" (
	name TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"CallConversation_id" TEXT,
	"Collaboration_id" TEXT,
	"Conversation_id" TEXT,
	"ConversationNode_id" TEXT,
	"GlobalConversation_id" TEXT,
	"SubConversation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("CallConversation_id") REFERENCES "CallConversation" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("Conversation_id") REFERENCES "Conversation" (id),
	FOREIGN KEY("ConversationNode_id") REFERENCES "ConversationNode" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY("SubConversation_id") REFERENCES "SubConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CorrelationKey_id" ON "CorrelationKey" (id);

CREATE TABLE "DataObjectReference" (
	data_object TEXT,
	item_subject TEXT,
	data_state TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(data_object) REFERENCES "DataObject" (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataObjectReference_id" ON "DataObjectReference" (id);

CREATE TABLE "DataStoreReference" (
	data_store TEXT,
	item_subject TEXT,
	data_state TEXT,
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(data_store) REFERENCES "DataStore" (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_DataStoreReference_id" ON "DataStoreReference" (id);

CREATE TABLE "EscalationEventDefinition" (
	escalation TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(escalation) REFERENCES "Escalation" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_EscalationEventDefinition_id" ON "EscalationEventDefinition" (id);

CREATE TABLE "FlowElement" (
	name TEXT,
	auditing TEXT,
	monitoring TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Process_id" TEXT,
	"SubProcess_id" TEXT,
	"Transaction_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(auditing) REFERENCES "Auditing" (id),
	FOREIGN KEY(monitoring) REFERENCES "Monitoring" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FlowElement_id" ON "FlowElement" (id);

CREATE TABLE "HumanPerformer" (
	name TEXT,
	resource TEXT,
	resource_assignment_expression TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource) REFERENCES "Resource" (id),
	FOREIGN KEY(resource_assignment_expression) REFERENCES "ResourceAssignmentExpression" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_HumanPerformer_id" ON "HumanPerformer" (id);

CREATE TABLE "MessageFlow" (
	name TEXT,
	source TEXT,
	target TEXT,
	message TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"CallConversation_id" TEXT,
	"Collaboration_id" TEXT,
	"Conversation_id" TEXT,
	"ConversationNode_id" TEXT,
	"GlobalConversation_id" TEXT,
	"SubConversation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(source) REFERENCES "InteractionNode" (id),
	FOREIGN KEY(target) REFERENCES "InteractionNode" (id),
	FOREIGN KEY(message) REFERENCES "Message" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("CallConversation_id") REFERENCES "CallConversation" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("Conversation_id") REFERENCES "Conversation" (id),
	FOREIGN KEY("ConversationNode_id") REFERENCES "ConversationNode" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY("SubConversation_id") REFERENCES "SubConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_MessageFlow_id" ON "MessageFlow" (id);

CREATE TABLE "MultiInstanceLoopCharacteristics" (
	loop_cardinality TEXT,
	loop_data_input_ref TEXT,
	loop_data_output_ref TEXT,
	input_data_item TEXT,
	output_data_item TEXT,
	completion_condition TEXT,
	sequential BOOLEAN,
	behavior TEXT,
	one_behavior_event_ref TEXT,
	none_behavior_event_ref TEXT,
	fluxnova_collection TEXT,
	fluxnova_element_variable TEXT,
	fluxnova_async_before BOOLEAN,
	fluxnova_async_after BOOLEAN,
	fluxnova_exclusive BOOLEAN,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(loop_cardinality) REFERENCES "LoopCardinality" (id),
	FOREIGN KEY(loop_data_input_ref) REFERENCES "DataInput" (id),
	FOREIGN KEY(loop_data_output_ref) REFERENCES "DataOutput" (id),
	FOREIGN KEY(input_data_item) REFERENCES "InputDataItem" (id),
	FOREIGN KEY(output_data_item) REFERENCES "OutputDataItem" (id),
	FOREIGN KEY(completion_condition) REFERENCES "CompletionCondition" (id),
	FOREIGN KEY(one_behavior_event_ref) REFERENCES "EventDefinition" (id),
	FOREIGN KEY(none_behavior_event_ref) REFERENCES "EventDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_MultiInstanceLoopCharacteristics_id" ON "MultiInstanceLoopCharacteristics" (id);

CREATE TABLE "Participant" (
	name TEXT,
	process TEXT,
	participant_multiplicity TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"CallConversation_id" TEXT,
	"Collaboration_id" TEXT,
	"Conversation_id" TEXT,
	"ConversationNode_id" TEXT,
	"GlobalConversation_id" TEXT,
	"SubConversation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(process) REFERENCES "Process" (id),
	FOREIGN KEY(participant_multiplicity) REFERENCES "ParticipantMultiplicity" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("CallConversation_id") REFERENCES "CallConversation" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("Conversation_id") REFERENCES "Conversation" (id),
	FOREIGN KEY("ConversationNode_id") REFERENCES "ConversationNode" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY("SubConversation_id") REFERENCES "SubConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Participant_id" ON "Participant" (id);

CREATE TABLE "Performer" (
	name TEXT,
	resource TEXT,
	resource_assignment_expression TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource) REFERENCES "Resource" (id),
	FOREIGN KEY(resource_assignment_expression) REFERENCES "ResourceAssignmentExpression" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Performer_id" ON "Performer" (id);

CREATE TABLE "PotentialOwner" (
	name TEXT,
	resource TEXT,
	resource_assignment_expression TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource) REFERENCES "Resource" (id),
	FOREIGN KEY(resource_assignment_expression) REFERENCES "ResourceAssignmentExpression" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_PotentialOwner_id" ON "PotentialOwner" (id);

CREATE TABLE "BpmnProperty" (
	name TEXT,
	item_subject TEXT,
	data_state TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Activity_id" TEXT,
	"BoundaryEvent_id" TEXT,
	"BusinessRuleTask_id" TEXT,
	"CallActivity_id" TEXT,
	"CatchEvent_id" TEXT,
	"EndEvent_id" TEXT,
	"Event_id" TEXT,
	"IntermediateCatchEvent_id" TEXT,
	"IntermediateThrowEvent_id" TEXT,
	"ManualTask_id" TEXT,
	"Process_id" TEXT,
	"ReceiveTask_id" TEXT,
	"ScriptTask_id" TEXT,
	"SendTask_id" TEXT,
	"ServiceTask_id" TEXT,
	"StartEvent_id" TEXT,
	"SubProcess_id" TEXT,
	"BpmnTask_id" TEXT,
	"ThrowEvent_id" TEXT,
	"Transaction_id" TEXT,
	"UserTask_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(item_subject) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(data_state) REFERENCES "DataState" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Activity_id") REFERENCES "Activity" (id),
	FOREIGN KEY("BoundaryEvent_id") REFERENCES "BoundaryEvent" (id),
	FOREIGN KEY("BusinessRuleTask_id") REFERENCES "BusinessRuleTask" (id),
	FOREIGN KEY("CallActivity_id") REFERENCES "CallActivity" (id),
	FOREIGN KEY("CatchEvent_id") REFERENCES "CatchEvent" (id),
	FOREIGN KEY("EndEvent_id") REFERENCES "EndEvent" (id),
	FOREIGN KEY("Event_id") REFERENCES "Event" (id),
	FOREIGN KEY("IntermediateCatchEvent_id") REFERENCES "IntermediateCatchEvent" (id),
	FOREIGN KEY("IntermediateThrowEvent_id") REFERENCES "IntermediateThrowEvent" (id),
	FOREIGN KEY("ManualTask_id") REFERENCES "ManualTask" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY("ReceiveTask_id") REFERENCES "ReceiveTask" (id),
	FOREIGN KEY("ScriptTask_id") REFERENCES "ScriptTask" (id),
	FOREIGN KEY("SendTask_id") REFERENCES "SendTask" (id),
	FOREIGN KEY("ServiceTask_id") REFERENCES "ServiceTask" (id),
	FOREIGN KEY("StartEvent_id") REFERENCES "StartEvent" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("ThrowEvent_id") REFERENCES "ThrowEvent" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnProperty_id" ON "BpmnProperty" (id);

CREATE TABLE "ResourceRole" (
	name TEXT,
	resource TEXT,
	resource_assignment_expression TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Activity_id" TEXT,
	"BusinessRuleTask_id" TEXT,
	"CallActivity_id" TEXT,
	"ManualTask_id" TEXT,
	"Process_id" TEXT,
	"ReceiveTask_id" TEXT,
	"ScriptTask_id" TEXT,
	"SendTask_id" TEXT,
	"ServiceTask_id" TEXT,
	"SubProcess_id" TEXT,
	"BpmnTask_id" TEXT,
	"Transaction_id" TEXT,
	"UserTask_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource) REFERENCES "Resource" (id),
	FOREIGN KEY(resource_assignment_expression) REFERENCES "ResourceAssignmentExpression" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Activity_id") REFERENCES "Activity" (id),
	FOREIGN KEY("BusinessRuleTask_id") REFERENCES "BusinessRuleTask" (id),
	FOREIGN KEY("CallActivity_id") REFERENCES "CallActivity" (id),
	FOREIGN KEY("ManualTask_id") REFERENCES "ManualTask" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY("ReceiveTask_id") REFERENCES "ReceiveTask" (id),
	FOREIGN KEY("ScriptTask_id") REFERENCES "ScriptTask" (id),
	FOREIGN KEY("SendTask_id") REFERENCES "SendTask" (id),
	FOREIGN KEY("ServiceTask_id") REFERENCES "ServiceTask" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ResourceRole_id" ON "ResourceRole" (id);

CREATE TABLE "SignalEventDefinition" (
	signal TEXT,
	fluxnova_async BOOLEAN,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(signal) REFERENCES "Signal" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_SignalEventDefinition_id" ON "SignalEventDefinition" (id);

CREATE TABLE "BpmnEdge" (
	bpmn_element TEXT,
	source_element TEXT,
	target_element TEXT,
	message_visible_kind VARCHAR(14),
	bpmn_label TEXT,
	id TEXT NOT NULL,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(source_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(target_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(bpmn_label) REFERENCES "BpmnLabel" (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnEdge_id" ON "BpmnEdge" (id);

CREATE TABLE "BpmnShape" (
	bpmn_element TEXT,
	horizontal BOOLEAN,
	expanded BOOLEAN,
	marker_visible BOOLEAN,
	message_visible BOOLEAN,
	participant_band_kind VARCHAR(21),
	choreography_activity_shape TEXT,
	bpmn_label TEXT,
	id TEXT NOT NULL,
	bounds_id INTEGER,
	extension_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(choreography_activity_shape) REFERENCES "BpmnShape" (id),
	FOREIGN KEY(bpmn_label) REFERENCES "BpmnLabel" (id),
	FOREIGN KEY(bounds_id) REFERENCES "Bounds" (id),
	FOREIGN KEY(extension_id) REFERENCES "Extension" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnShape_id" ON "BpmnShape" (id);

CREATE TABLE "FluxnovaPotentialStarter" (
	id INTEGER NOT NULL,
	resource_assignment_expression TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(resource_assignment_expression) REFERENCES "ResourceAssignmentExpression" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaPotentialStarter_id" ON "FluxnovaPotentialStarter" (id);

CREATE TABLE "ConditionalEventDefinition_fluxnova_variable_events_list" (
	"ConditionalEventDefinition_id" TEXT,
	fluxnova_variable_events_list TEXT,
	PRIMARY KEY ("ConditionalEventDefinition_id", fluxnova_variable_events_list),
	FOREIGN KEY("ConditionalEventDefinition_id") REFERENCES "ConditionalEventDefinition" (id)
);
CREATE INDEX "ix_ConditionalEventDefinition_fluxnova_variable_events_list_fluxnova_variable_events_list" ON "ConditionalEventDefinition_fluxnova_variable_events_list" (fluxnova_variable_events_list);
CREATE INDEX "ix_ConditionalEventDefinition_fluxnova_variable_events_list_ConditionalEventDefinition_id" ON "ConditionalEventDefinition_fluxnova_variable_events_list" ("ConditionalEventDefinition_id");

CREATE TABLE "Process_fluxnova_candidate_starter_groups_list" (
	"Process_id" TEXT,
	fluxnova_candidate_starter_groups_list TEXT,
	PRIMARY KEY ("Process_id", fluxnova_candidate_starter_groups_list),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id)
);
CREATE INDEX "ix_Process_fluxnova_candidate_starter_groups_list_fluxnova_candidate_starter_groups_list" ON "Process_fluxnova_candidate_starter_groups_list" (fluxnova_candidate_starter_groups_list);
CREATE INDEX "ix_Process_fluxnova_candidate_starter_groups_list_Process_id" ON "Process_fluxnova_candidate_starter_groups_list" ("Process_id");

CREATE TABLE "Process_fluxnova_candidate_starter_users_list" (
	"Process_id" TEXT,
	fluxnova_candidate_starter_users_list TEXT,
	PRIMARY KEY ("Process_id", fluxnova_candidate_starter_users_list),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id)
);
CREATE INDEX "ix_Process_fluxnova_candidate_starter_users_list_fluxnova_candidate_starter_users_list" ON "Process_fluxnova_candidate_starter_users_list" (fluxnova_candidate_starter_users_list);
CREATE INDEX "ix_Process_fluxnova_candidate_starter_users_list_Process_id" ON "Process_fluxnova_candidate_starter_users_list" ("Process_id");

CREATE TABLE "Waypoint" (
	id INTEGER NOT NULL,
	x FLOAT,
	y FLOAT,
	"Edge_id" TEXT,
	"LabeledEdge_id" TEXT,
	"BpmnEdge_id" TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("Edge_id") REFERENCES "Edge" (id),
	FOREIGN KEY("LabeledEdge_id") REFERENCES "LabeledEdge" (id),
	FOREIGN KEY("BpmnEdge_id") REFERENCES "BpmnEdge" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Waypoint_id" ON "Waypoint" (id);

CREATE TABLE "CategoryValue" (
	value TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Activity_id" TEXT,
	"BoundaryEvent_id" TEXT,
	"BusinessRuleTask_id" TEXT,
	"CallActivity_id" TEXT,
	"CatchEvent_id" TEXT,
	"Category_id" TEXT,
	"ComplexGateway_id" TEXT,
	"DataObject_id" TEXT,
	"DataObjectReference_id" TEXT,
	"DataStoreReference_id" TEXT,
	"EndEvent_id" TEXT,
	"Event_id" TEXT,
	"EventBasedGateway_id" TEXT,
	"ExclusiveGateway_id" TEXT,
	"FlowElement_id" TEXT,
	"FlowNode_id" TEXT,
	"Gateway_id" TEXT,
	"InclusiveGateway_id" TEXT,
	"IntermediateCatchEvent_id" TEXT,
	"IntermediateThrowEvent_id" TEXT,
	"ManualTask_id" TEXT,
	"ParallelGateway_id" TEXT,
	"ReceiveTask_id" TEXT,
	"ScriptTask_id" TEXT,
	"SendTask_id" TEXT,
	"SequenceFlow_id" TEXT,
	"ServiceTask_id" TEXT,
	"StartEvent_id" TEXT,
	"SubProcess_id" TEXT,
	"BpmnTask_id" TEXT,
	"ThrowEvent_id" TEXT,
	"Transaction_id" TEXT,
	"UserTask_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Activity_id") REFERENCES "Activity" (id),
	FOREIGN KEY("BoundaryEvent_id") REFERENCES "BoundaryEvent" (id),
	FOREIGN KEY("BusinessRuleTask_id") REFERENCES "BusinessRuleTask" (id),
	FOREIGN KEY("CallActivity_id") REFERENCES "CallActivity" (id),
	FOREIGN KEY("CatchEvent_id") REFERENCES "CatchEvent" (id),
	FOREIGN KEY("Category_id") REFERENCES "Category" (id),
	FOREIGN KEY("ComplexGateway_id") REFERENCES "ComplexGateway" (id),
	FOREIGN KEY("DataObject_id") REFERENCES "DataObject" (id),
	FOREIGN KEY("DataObjectReference_id") REFERENCES "DataObjectReference" (id),
	FOREIGN KEY("DataStoreReference_id") REFERENCES "DataStoreReference" (id),
	FOREIGN KEY("EndEvent_id") REFERENCES "EndEvent" (id),
	FOREIGN KEY("Event_id") REFERENCES "Event" (id),
	FOREIGN KEY("EventBasedGateway_id") REFERENCES "EventBasedGateway" (id),
	FOREIGN KEY("ExclusiveGateway_id") REFERENCES "ExclusiveGateway" (id),
	FOREIGN KEY("FlowElement_id") REFERENCES "FlowElement" (id),
	FOREIGN KEY("FlowNode_id") REFERENCES "FlowNode" (id),
	FOREIGN KEY("Gateway_id") REFERENCES "Gateway" (id),
	FOREIGN KEY("InclusiveGateway_id") REFERENCES "InclusiveGateway" (id),
	FOREIGN KEY("IntermediateCatchEvent_id") REFERENCES "IntermediateCatchEvent" (id),
	FOREIGN KEY("IntermediateThrowEvent_id") REFERENCES "IntermediateThrowEvent" (id),
	FOREIGN KEY("ManualTask_id") REFERENCES "ManualTask" (id),
	FOREIGN KEY("ParallelGateway_id") REFERENCES "ParallelGateway" (id),
	FOREIGN KEY("ReceiveTask_id") REFERENCES "ReceiveTask" (id),
	FOREIGN KEY("ScriptTask_id") REFERENCES "ScriptTask" (id),
	FOREIGN KEY("SendTask_id") REFERENCES "SendTask" (id),
	FOREIGN KEY("SequenceFlow_id") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY("ServiceTask_id") REFERENCES "ServiceTask" (id),
	FOREIGN KEY("StartEvent_id") REFERENCES "StartEvent" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("ThrowEvent_id") REFERENCES "ThrowEvent" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CategoryValue_id" ON "CategoryValue" (id);

CREATE TABLE "ComplexBehaviorDefinition" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	"MultiInstanceLoopCharacteristics_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("MultiInstanceLoopCharacteristics_id") REFERENCES "MultiInstanceLoopCharacteristics" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ComplexBehaviorDefinition_id" ON "ComplexBehaviorDefinition" (id);

CREATE TABLE "CorrelationProperty" (
	name TEXT,
	type TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"CorrelationKey_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(type) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("CorrelationKey_id") REFERENCES "CorrelationKey" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CorrelationProperty_id" ON "CorrelationProperty" (id);

CREATE TABLE "CorrelationSubscription" (
	correlation_key TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Process_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(correlation_key) REFERENCES "CorrelationKey" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CorrelationSubscription_id" ON "CorrelationSubscription" (id);

CREATE TABLE "EndPoint" (
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Participant_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Participant_id") REFERENCES "Participant" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_EndPoint_id" ON "EndPoint" (id);

CREATE TABLE "Interface" (
	name TEXT,
	implementation_ref TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"CallableElement_id" TEXT,
	"Participant_id" TEXT,
	"Process_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("CallableElement_id") REFERENCES "CallableElement" (id),
	FOREIGN KEY("Participant_id") REFERENCES "Participant" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Interface_id" ON "Interface" (id);

CREATE TABLE "MessageFlowAssociation" (
	inner_message_flow TEXT,
	outer_message_flow TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Collaboration_id" TEXT,
	"GlobalConversation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(inner_message_flow) REFERENCES "MessageFlow" (id),
	FOREIGN KEY(outer_message_flow) REFERENCES "MessageFlow" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_MessageFlowAssociation_id" ON "MessageFlowAssociation" (id);

CREATE TABLE "ParticipantAssociation" (
	inner_participant TEXT,
	outer_participant TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"CallConversation_id" TEXT,
	"Collaboration_id" TEXT,
	"GlobalConversation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(inner_participant) REFERENCES "Participant" (id),
	FOREIGN KEY(outer_participant) REFERENCES "Participant" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("CallConversation_id") REFERENCES "CallConversation" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ParticipantAssociation_id" ON "ParticipantAssociation" (id);

CREATE TABLE "ResourceParameterBinding" (
	parameter TEXT,
	expression TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"HumanPerformer_id" TEXT,
	"Performer_id" TEXT,
	"PotentialOwner_id" TEXT,
	"ResourceRole_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(parameter) REFERENCES "ResourceParameter" (id),
	FOREIGN KEY(expression) REFERENCES "Expression" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("HumanPerformer_id") REFERENCES "HumanPerformer" (id),
	FOREIGN KEY("Performer_id") REFERENCES "Performer" (id),
	FOREIGN KEY("PotentialOwner_id") REFERENCES "PotentialOwner" (id),
	FOREIGN KEY("ResourceRole_id") REFERENCES "ResourceRole" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ResourceParameterBinding_id" ON "ResourceParameterBinding" (id);

CREATE TABLE "CorrelationPropertyBinding" (
	correlation_property TEXT,
	data_path TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"CorrelationSubscription_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(correlation_property) REFERENCES "CorrelationProperty" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("CorrelationSubscription_id") REFERENCES "CorrelationSubscription" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CorrelationPropertyBinding_id" ON "CorrelationPropertyBinding" (id);

CREATE TABLE "CorrelationPropertyRetrievalExpression" (
	message TEXT,
	message_path TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"CorrelationProperty_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(message) REFERENCES "Message" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("CorrelationProperty_id") REFERENCES "CorrelationProperty" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_CorrelationPropertyRetrievalExpression_id" ON "CorrelationPropertyRetrievalExpression" (id);

CREATE TABLE "BpmnGroup" (
	category TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(category) REFERENCES "CategoryValue" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_BpmnGroup_id" ON "BpmnGroup" (id);

CREATE TABLE "Operation" (
	name TEXT,
	implementation_ref TEXT,
	in_message TEXT,
	out_message TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Interface_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(in_message) REFERENCES "Message" (id),
	FOREIGN KEY(out_message) REFERENCES "Message" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Interface_id") REFERENCES "Interface" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Operation_id" ON "Operation" (id);

CREATE TABLE "Error" (
	name TEXT,
	error_code TEXT,
	fluxnova_error_message TEXT,
	structure TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"Operation_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(structure) REFERENCES "ItemDefinition" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("Operation_id") REFERENCES "Operation" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Error_id" ON "Error" (id);

CREATE TABLE "IoBinding" (
	operation TEXT,
	input_data TEXT,
	output_data TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	"CallableElement_id" TEXT,
	"Process_id" TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(operation) REFERENCES "Operation" (id),
	FOREIGN KEY(input_data) REFERENCES "DataInput" (id),
	FOREIGN KEY(output_data) REFERENCES "DataOutput" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY("CallableElement_id") REFERENCES "CallableElement" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_IoBinding_id" ON "IoBinding" (id);

CREATE TABLE "MessageEventDefinition" (
	message TEXT,
	operation TEXT,
	fluxnova_class TEXT,
	fluxnova_delegate_expression TEXT,
	fluxnova_expression TEXT,
	fluxnova_result_variable TEXT,
	fluxnova_topic TEXT,
	fluxnova_type TEXT,
	fluxnova_task_priority TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(message) REFERENCES "Message" (id),
	FOREIGN KEY(operation) REFERENCES "Operation" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_MessageEventDefinition_id" ON "MessageEventDefinition" (id);

CREATE TABLE "ErrorEventDefinition" (
	error TEXT,
	fluxnova_error_code_variable TEXT,
	fluxnova_error_message_variable TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(error) REFERENCES "Error" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_ErrorEventDefinition_id" ON "ErrorEventDefinition" (id);

CREATE TABLE "FluxnovaErrorEventDefinition" (
	fluxnova_expression TEXT,
	error TEXT,
	fluxnova_error_code_variable TEXT,
	fluxnova_error_message_variable TEXT,
	id TEXT NOT NULL,
	diagram_element TEXT,
	extension_elements_id INTEGER,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY(error) REFERENCES "Error" (id),
	FOREIGN KEY(diagram_element) REFERENCES "DiagramElement" (id),
	FOREIGN KEY(extension_elements_id) REFERENCES "ExtensionElements" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_FluxnovaErrorEventDefinition_id" ON "FluxnovaErrorEventDefinition" (id);

CREATE TABLE "Documentation" (
	id TEXT NOT NULL,
	text_format TEXT,
	"ActivationCondition_id" TEXT,
	"Activity_id" TEXT,
	"Artifact_id" TEXT,
	"Assignment_id" TEXT,
	"Association_id" TEXT,
	"Auditing_id" TEXT,
	"BaseElement_id" TEXT,
	"BoundaryEvent_id" TEXT,
	"BusinessRuleTask_id" TEXT,
	"CallActivity_id" TEXT,
	"CallConversation_id" TEXT,
	"CallableElement_id" TEXT,
	"CancelEventDefinition_id" TEXT,
	"CatchEvent_id" TEXT,
	"Category_id" TEXT,
	"CategoryValue_id" TEXT,
	"Collaboration_id" TEXT,
	"CompensateEventDefinition_id" TEXT,
	"CompletionCondition_id" TEXT,
	"ComplexBehaviorDefinition_id" TEXT,
	"ComplexGateway_id" TEXT,
	"Condition_id" TEXT,
	"ConditionExpression_id" TEXT,
	"ConditionalEventDefinition_id" TEXT,
	"Conversation_id" TEXT,
	"ConversationAssociation_id" TEXT,
	"ConversationLink_id" TEXT,
	"ConversationNode_id" TEXT,
	"CorrelationKey_id" TEXT,
	"CorrelationProperty_id" TEXT,
	"CorrelationPropertyBinding_id" TEXT,
	"CorrelationPropertyRetrievalExpression_id" TEXT,
	"CorrelationSubscription_id" TEXT,
	"DataAssociation_id" TEXT,
	"DataInput_id" TEXT,
	"DataInputAssociation_id" TEXT,
	"DataObject_id" TEXT,
	"DataObjectReference_id" TEXT,
	"DataOutput_id" TEXT,
	"DataOutputAssociation_id" TEXT,
	"DataState_id" TEXT,
	"DataStore_id" TEXT,
	"DataStoreReference_id" TEXT,
	"EndEvent_id" TEXT,
	"EndPoint_id" TEXT,
	"Error_id" TEXT,
	"ErrorEventDefinition_id" TEXT,
	"Escalation_id" TEXT,
	"EscalationEventDefinition_id" TEXT,
	"Event_id" TEXT,
	"EventBasedGateway_id" TEXT,
	"EventDefinition_id" TEXT,
	"ExclusiveGateway_id" TEXT,
	"Expression_id" TEXT,
	"FlowElement_id" TEXT,
	"FlowNode_id" TEXT,
	"FormalExpression_id" TEXT,
	"Gateway_id" TEXT,
	"GlobalConversation_id" TEXT,
	"BpmnGroup_id" TEXT,
	"HumanPerformer_id" TEXT,
	"InclusiveGateway_id" TEXT,
	"InputDataItem_id" TEXT,
	"InputSet_id" TEXT,
	"Interface_id" TEXT,
	"IntermediateCatchEvent_id" TEXT,
	"IntermediateThrowEvent_id" TEXT,
	"IoBinding_id" TEXT,
	"IoSpecification_id" TEXT,
	"ItemAwareElement_id" TEXT,
	"ItemDefinition_id" TEXT,
	"Lane_id" TEXT,
	"LaneSet_id" TEXT,
	"LinkEventDefinition_id" TEXT,
	"LoopCardinality_id" TEXT,
	"LoopCharacteristics_id" TEXT,
	"ManualTask_id" TEXT,
	"Message_id" TEXT,
	"MessageEventDefinition_id" TEXT,
	"MessageFlow_id" TEXT,
	"MessageFlowAssociation_id" TEXT,
	"Monitoring_id" TEXT,
	"MultiInstanceLoopCharacteristics_id" TEXT,
	"Operation_id" TEXT,
	"OutputDataItem_id" TEXT,
	"OutputSet_id" TEXT,
	"ParallelGateway_id" TEXT,
	"Participant_id" TEXT,
	"ParticipantAssociation_id" TEXT,
	"ParticipantMultiplicity_id" TEXT,
	"Performer_id" TEXT,
	"PotentialOwner_id" TEXT,
	"Process_id" TEXT,
	"BpmnProperty_id" TEXT,
	"ReceiveTask_id" TEXT,
	"Relationship_id" TEXT,
	"Rendering_id" TEXT,
	"Resource_id" TEXT,
	"ResourceAssignmentExpression_id" TEXT,
	"ResourceParameter_id" TEXT,
	"ResourceParameterBinding_id" TEXT,
	"ResourceRole_id" TEXT,
	"RootElement_id" TEXT,
	"ScriptTask_id" TEXT,
	"SendTask_id" TEXT,
	"SequenceFlow_id" TEXT,
	"ServiceTask_id" TEXT,
	"Signal_id" TEXT,
	"SignalEventDefinition_id" TEXT,
	"StartEvent_id" TEXT,
	"SubConversation_id" TEXT,
	"SubProcess_id" TEXT,
	"BpmnTask_id" TEXT,
	"TerminateEventDefinition_id" TEXT,
	"TextAnnotation_id" TEXT,
	"ThrowEvent_id" TEXT,
	"TimeCycle_id" TEXT,
	"TimeDate_id" TEXT,
	"TimeDuration_id" TEXT,
	"TimerEventDefinition_id" TEXT,
	"Transaction_id" TEXT,
	"UserTask_id" TEXT,
	"FluxnovaErrorEventDefinition_id" TEXT,
	scope_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY("ActivationCondition_id") REFERENCES "ActivationCondition" (id),
	FOREIGN KEY("Activity_id") REFERENCES "Activity" (id),
	FOREIGN KEY("Artifact_id") REFERENCES "Artifact" (id),
	FOREIGN KEY("Assignment_id") REFERENCES "Assignment" (id),
	FOREIGN KEY("Association_id") REFERENCES "Association" (id),
	FOREIGN KEY("Auditing_id") REFERENCES "Auditing" (id),
	FOREIGN KEY("BaseElement_id") REFERENCES "BaseElement" (id),
	FOREIGN KEY("BoundaryEvent_id") REFERENCES "BoundaryEvent" (id),
	FOREIGN KEY("BusinessRuleTask_id") REFERENCES "BusinessRuleTask" (id),
	FOREIGN KEY("CallActivity_id") REFERENCES "CallActivity" (id),
	FOREIGN KEY("CallConversation_id") REFERENCES "CallConversation" (id),
	FOREIGN KEY("CallableElement_id") REFERENCES "CallableElement" (id),
	FOREIGN KEY("CancelEventDefinition_id") REFERENCES "CancelEventDefinition" (id),
	FOREIGN KEY("CatchEvent_id") REFERENCES "CatchEvent" (id),
	FOREIGN KEY("Category_id") REFERENCES "Category" (id),
	FOREIGN KEY("CategoryValue_id") REFERENCES "CategoryValue" (id),
	FOREIGN KEY("Collaboration_id") REFERENCES "Collaboration" (id),
	FOREIGN KEY("CompensateEventDefinition_id") REFERENCES "CompensateEventDefinition" (id),
	FOREIGN KEY("CompletionCondition_id") REFERENCES "CompletionCondition" (id),
	FOREIGN KEY("ComplexBehaviorDefinition_id") REFERENCES "ComplexBehaviorDefinition" (id),
	FOREIGN KEY("ComplexGateway_id") REFERENCES "ComplexGateway" (id),
	FOREIGN KEY("Condition_id") REFERENCES "Condition" (id),
	FOREIGN KEY("ConditionExpression_id") REFERENCES "ConditionExpression" (id),
	FOREIGN KEY("ConditionalEventDefinition_id") REFERENCES "ConditionalEventDefinition" (id),
	FOREIGN KEY("Conversation_id") REFERENCES "Conversation" (id),
	FOREIGN KEY("ConversationAssociation_id") REFERENCES "ConversationAssociation" (id),
	FOREIGN KEY("ConversationLink_id") REFERENCES "ConversationLink" (id),
	FOREIGN KEY("ConversationNode_id") REFERENCES "ConversationNode" (id),
	FOREIGN KEY("CorrelationKey_id") REFERENCES "CorrelationKey" (id),
	FOREIGN KEY("CorrelationProperty_id") REFERENCES "CorrelationProperty" (id),
	FOREIGN KEY("CorrelationPropertyBinding_id") REFERENCES "CorrelationPropertyBinding" (id),
	FOREIGN KEY("CorrelationPropertyRetrievalExpression_id") REFERENCES "CorrelationPropertyRetrievalExpression" (id),
	FOREIGN KEY("CorrelationSubscription_id") REFERENCES "CorrelationSubscription" (id),
	FOREIGN KEY("DataAssociation_id") REFERENCES "DataAssociation" (id),
	FOREIGN KEY("DataInput_id") REFERENCES "DataInput" (id),
	FOREIGN KEY("DataInputAssociation_id") REFERENCES "DataInputAssociation" (id),
	FOREIGN KEY("DataObject_id") REFERENCES "DataObject" (id),
	FOREIGN KEY("DataObjectReference_id") REFERENCES "DataObjectReference" (id),
	FOREIGN KEY("DataOutput_id") REFERENCES "DataOutput" (id),
	FOREIGN KEY("DataOutputAssociation_id") REFERENCES "DataOutputAssociation" (id),
	FOREIGN KEY("DataState_id") REFERENCES "DataState" (id),
	FOREIGN KEY("DataStore_id") REFERENCES "DataStore" (id),
	FOREIGN KEY("DataStoreReference_id") REFERENCES "DataStoreReference" (id),
	FOREIGN KEY("EndEvent_id") REFERENCES "EndEvent" (id),
	FOREIGN KEY("EndPoint_id") REFERENCES "EndPoint" (id),
	FOREIGN KEY("Error_id") REFERENCES "Error" (id),
	FOREIGN KEY("ErrorEventDefinition_id") REFERENCES "ErrorEventDefinition" (id),
	FOREIGN KEY("Escalation_id") REFERENCES "Escalation" (id),
	FOREIGN KEY("EscalationEventDefinition_id") REFERENCES "EscalationEventDefinition" (id),
	FOREIGN KEY("Event_id") REFERENCES "Event" (id),
	FOREIGN KEY("EventBasedGateway_id") REFERENCES "EventBasedGateway" (id),
	FOREIGN KEY("EventDefinition_id") REFERENCES "EventDefinition" (id),
	FOREIGN KEY("ExclusiveGateway_id") REFERENCES "ExclusiveGateway" (id),
	FOREIGN KEY("Expression_id") REFERENCES "Expression" (id),
	FOREIGN KEY("FlowElement_id") REFERENCES "FlowElement" (id),
	FOREIGN KEY("FlowNode_id") REFERENCES "FlowNode" (id),
	FOREIGN KEY("FormalExpression_id") REFERENCES "FormalExpression" (id),
	FOREIGN KEY("Gateway_id") REFERENCES "Gateway" (id),
	FOREIGN KEY("GlobalConversation_id") REFERENCES "GlobalConversation" (id),
	FOREIGN KEY("BpmnGroup_id") REFERENCES "BpmnGroup" (id),
	FOREIGN KEY("HumanPerformer_id") REFERENCES "HumanPerformer" (id),
	FOREIGN KEY("InclusiveGateway_id") REFERENCES "InclusiveGateway" (id),
	FOREIGN KEY("InputDataItem_id") REFERENCES "InputDataItem" (id),
	FOREIGN KEY("InputSet_id") REFERENCES "InputSet" (id),
	FOREIGN KEY("Interface_id") REFERENCES "Interface" (id),
	FOREIGN KEY("IntermediateCatchEvent_id") REFERENCES "IntermediateCatchEvent" (id),
	FOREIGN KEY("IntermediateThrowEvent_id") REFERENCES "IntermediateThrowEvent" (id),
	FOREIGN KEY("IoBinding_id") REFERENCES "IoBinding" (id),
	FOREIGN KEY("IoSpecification_id") REFERENCES "IoSpecification" (id),
	FOREIGN KEY("ItemAwareElement_id") REFERENCES "ItemAwareElement" (id),
	FOREIGN KEY("ItemDefinition_id") REFERENCES "ItemDefinition" (id),
	FOREIGN KEY("Lane_id") REFERENCES "Lane" (id),
	FOREIGN KEY("LaneSet_id") REFERENCES "LaneSet" (id),
	FOREIGN KEY("LinkEventDefinition_id") REFERENCES "LinkEventDefinition" (id),
	FOREIGN KEY("LoopCardinality_id") REFERENCES "LoopCardinality" (id),
	FOREIGN KEY("LoopCharacteristics_id") REFERENCES "LoopCharacteristics" (id),
	FOREIGN KEY("ManualTask_id") REFERENCES "ManualTask" (id),
	FOREIGN KEY("Message_id") REFERENCES "Message" (id),
	FOREIGN KEY("MessageEventDefinition_id") REFERENCES "MessageEventDefinition" (id),
	FOREIGN KEY("MessageFlow_id") REFERENCES "MessageFlow" (id),
	FOREIGN KEY("MessageFlowAssociation_id") REFERENCES "MessageFlowAssociation" (id),
	FOREIGN KEY("Monitoring_id") REFERENCES "Monitoring" (id),
	FOREIGN KEY("MultiInstanceLoopCharacteristics_id") REFERENCES "MultiInstanceLoopCharacteristics" (id),
	FOREIGN KEY("Operation_id") REFERENCES "Operation" (id),
	FOREIGN KEY("OutputDataItem_id") REFERENCES "OutputDataItem" (id),
	FOREIGN KEY("OutputSet_id") REFERENCES "OutputSet" (id),
	FOREIGN KEY("ParallelGateway_id") REFERENCES "ParallelGateway" (id),
	FOREIGN KEY("Participant_id") REFERENCES "Participant" (id),
	FOREIGN KEY("ParticipantAssociation_id") REFERENCES "ParticipantAssociation" (id),
	FOREIGN KEY("ParticipantMultiplicity_id") REFERENCES "ParticipantMultiplicity" (id),
	FOREIGN KEY("Performer_id") REFERENCES "Performer" (id),
	FOREIGN KEY("PotentialOwner_id") REFERENCES "PotentialOwner" (id),
	FOREIGN KEY("Process_id") REFERENCES "Process" (id),
	FOREIGN KEY("BpmnProperty_id") REFERENCES "BpmnProperty" (id),
	FOREIGN KEY("ReceiveTask_id") REFERENCES "ReceiveTask" (id),
	FOREIGN KEY("Relationship_id") REFERENCES "Relationship" (id),
	FOREIGN KEY("Rendering_id") REFERENCES "Rendering" (id),
	FOREIGN KEY("Resource_id") REFERENCES "Resource" (id),
	FOREIGN KEY("ResourceAssignmentExpression_id") REFERENCES "ResourceAssignmentExpression" (id),
	FOREIGN KEY("ResourceParameter_id") REFERENCES "ResourceParameter" (id),
	FOREIGN KEY("ResourceParameterBinding_id") REFERENCES "ResourceParameterBinding" (id),
	FOREIGN KEY("ResourceRole_id") REFERENCES "ResourceRole" (id),
	FOREIGN KEY("RootElement_id") REFERENCES "RootElement" (id),
	FOREIGN KEY("ScriptTask_id") REFERENCES "ScriptTask" (id),
	FOREIGN KEY("SendTask_id") REFERENCES "SendTask" (id),
	FOREIGN KEY("SequenceFlow_id") REFERENCES "SequenceFlow" (id),
	FOREIGN KEY("ServiceTask_id") REFERENCES "ServiceTask" (id),
	FOREIGN KEY("Signal_id") REFERENCES "Signal" (id),
	FOREIGN KEY("SignalEventDefinition_id") REFERENCES "SignalEventDefinition" (id),
	FOREIGN KEY("StartEvent_id") REFERENCES "StartEvent" (id),
	FOREIGN KEY("SubConversation_id") REFERENCES "SubConversation" (id),
	FOREIGN KEY("SubProcess_id") REFERENCES "SubProcess" (id),
	FOREIGN KEY("BpmnTask_id") REFERENCES "BpmnTask" (id),
	FOREIGN KEY("TerminateEventDefinition_id") REFERENCES "TerminateEventDefinition" (id),
	FOREIGN KEY("TextAnnotation_id") REFERENCES "TextAnnotation" (id),
	FOREIGN KEY("ThrowEvent_id") REFERENCES "ThrowEvent" (id),
	FOREIGN KEY("TimeCycle_id") REFERENCES "TimeCycle" (id),
	FOREIGN KEY("TimeDate_id") REFERENCES "TimeDate" (id),
	FOREIGN KEY("TimeDuration_id") REFERENCES "TimeDuration" (id),
	FOREIGN KEY("TimerEventDefinition_id") REFERENCES "TimerEventDefinition" (id),
	FOREIGN KEY("Transaction_id") REFERENCES "Transaction" (id),
	FOREIGN KEY("UserTask_id") REFERENCES "UserTask" (id),
	FOREIGN KEY("FluxnovaErrorEventDefinition_id") REFERENCES "FluxnovaErrorEventDefinition" (id),
	FOREIGN KEY(scope_id) REFERENCES "BpmnModelElementInstance" (id)
);
CREATE INDEX "ix_Documentation_id" ON "Documentation" (id);
