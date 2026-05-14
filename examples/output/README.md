## HistoricDecisionInputInstance-vendor
### Input
```yaml
clause_id: aDecisionInputClauseId
clause_name: aDecisionInputClauseName
create_time: '2015-09-06T11:00:00+00:00'
decision_instance_id: aHistoricDecisionInstanceId
id: aDecisionInputInstanceId
removal_time: '2015-10-18T11:00:00+00:00'
root_process_instance_id: aRootProcInstId
tenant_id: aTenantId
text_value: test
variable_type: String

```
## HistoricActivityInstance-vendor
### Input
```yaml
activity_id: anActivityId
activity_name: anActivityName
activity_type: userTask
assignee: anAssignee
called_case_instance_id: aHistoricCalledCaseInstanceId
called_process_instance_id: aHistoricCalledProcessInstanceId
duration: 2000
end_time: '2013-04-23T18:42:43+00:00'
execution_id: anExecId
id: aHistoricActivityInstanceId
parent_activity_instance_id: aHistoricParentActivityInstanceId
process_definition_id: aProcDefId
process_definition_key: aKey
process_instance_id: aProcInstId
removal_time: '2013-04-23T13:42:43+00:00'
root_process_instance_id: aRootProcInstId
sequence_counter: 10
start_time: '2013-04-23T13:42:43+00:00'
task_id: aTaskId
tenant_id: aTenantId

```
## IdentityInfo-001
### Input
```yaml
id: idinfo-001
key: google
type: account
user_id: user-001
value: user@gmail.com

```
## HistoricActivityInstance-001
### Input
```yaml
activity_id: Task_ApproveInvoice
activity_name: Approve Invoice
activity_type: userTask
assignee: jane
duration: 1740000
end_time: '2025-03-01T09:30:00+00:00'
execution_id: exec-001
id: hai-001
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
root_process_instance_id: pi-001
start_time: '2025-03-01T09:01:00+00:00'
task_id: task-001
tenant_id: tenant-alpha

```
## CaseExecution-vendor
### Input
```yaml
activity_id: anActivityId
case_definition_id: aCaseDefinitionId
case_instance_id: aCaseInstanceId
id: aCaseExecutionId
is_required: true
parent_id: aParentId
tenant_id: aTenantId

```
## HistoricDecisionInstance-vendor
### Input
```yaml
activity_id: aHistoricDecisionInstanceActivityId
activity_instance_id: aHistoricDecisionInstanceActivityInstanceId
collect_result_value: 42.0
decision_definition_id: aDecisionDefinitionId
decision_definition_key: aDecisionDefinitionKey
decision_definition_name: aDecisionDefinitionName
evaluation_time: '2015-09-07T11:00:00+00:00'
id: aHistoricDecisionInstanceId
process_definition_id: aProcDefId
process_definition_key: aKey
process_instance_id: aProcInstId
removal_time: '2015-09-10T11:00:00+00:00'
root_process_instance_id: aRootProcInstId
tenant_id: aTenantId
user_id: aUserId

```
## Group-001
### Input
```yaml
id: group-001
name: Accounting
type: ORGANIZATION

```
## SchemaLogEntry-001
### Input
```yaml
id: sle-001
timestamp: '2025-01-01T00:00:00+00:00'
version: '1'

```
## HistoricDecisionOutputInstance-vendor
### Input
```yaml
clause_id: aDecisionInputClauseId
clause_name: aDecisionInputClauseName
create_time: '2015-09-06T11:00:00+00:00'
decision_instance_id: aHistoricDecisionInstanceId
id: aDecisionInputInstanceId
removal_time: '2015-10-18T11:00:00+00:00'
root_process_instance_id: aRootProcInstId
rule_id: aDecisionInputRuleId
rule_order: 12
tenant_id: aTenantId
text_value: test
variable_name: aDecisionInputInstanceName
variable_type: String

```
## UserOperationLogEntry-001
### Input
```yaml
batch_id: batch-001
category: TaskWorker
deployment_id: dep-001
entity_type: Task
execution_id: exec-001
external_task_id: et-001
id: uol-001
job_definition_id: jd-001
job_id: job-001
new_value: jane
operation_id: op-001
operation_type: Claim
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
property: assignee
root_process_instance_id: pi-001
task_id: task-001
tenant_id: tenant-alpha
timestamp: '2025-03-01T09:25:00+00:00'
user_id: user-001

```
## TaskMeterLog-001
### Input
```yaml
assignee_hash: 123456789
id: tml-001
timestamp: '2025-03-15T08:00:00+00:00'

```
## ProcessDefinition-vendor
### Input
```yaml
category: aCategory
deployment_id: aDeploymentId
diagram_resource_name: aResourceName.png
history_time_to_live: 5
id: aProcDefId
is_startable: true
key: aKey
name: aName
resource_name: aResourceName
suspension_state: SUSPENDED
tenant_id: aTenantId
version: 42
version_tag: '42'

```
## HistoricProcessInstance-001
### Input
```yaml
business_key: INV-2025-0042
duration: 5400000
end_activity_id: EndEvent_1
end_time: '2025-03-01T10:30:00+00:00'
id: hpi-001
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
removal_time: '2025-09-01T00:00:00+00:00'
root_process_instance_id: pi-001
start_activity_id: StartEvent_1
start_time: '2025-03-01T09:00:00+00:00'
start_user_id: user-001
state: COMPLETED
tenant_id: tenant-alpha

```
## Attachment-vendor
### Input
```yaml
create_time: '2018-07-19T15:02:36+00:00'
description: aTaskAttachmentDescription
id: aTaskAttachmentId
name: aTaskAttachmentName
process_instance_id: aProcInstId
removal_time: '2018-10-17T13:35:07+00:00'
root_process_instance_id: aRootProcInstId
task_id: anId
tenant_id: aTenantId
type: aTaskAttachmentType
url: aTaskAttachmentUrl
user_id: aUserId

```
## Membership-001
### Input
```yaml
group_id: group-001
user_id: user-001

```
## JobDefinition-vendor
### Input
```yaml
activity_id: aJobActivityId
deployment_id: aDeploymentId
id: aJobDefId
job_configuration: aJobConfig
job_priority: 2147483699
job_type: aJobType
process_definition_id: aProcDefId
process_definition_key: aKey
suspension_state: SUSPENDED
tenant_id: aTenantId

```
## HistoricIncident-001
### Input
```yaml
activity_id: ExternalTask_SendEmail
cause_incident_id: hinc-001
create_time: '2025-03-01T09:20:00+00:00'
end_time: '2025-03-01T09:25:00+00:00'
execution_id: exec-001
id: hinc-001
incident_message: Failed to send email
incident_state: RESOLVED
incident_type: failedJob
job_definition_id: jd-001
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
root_cause_incident_id: hinc-001
root_process_instance_id: pi-001
tenant_id: tenant-alpha

```
## Font-001
### Input
```yaml
bold: true
italic: false
name: Arial
size: 12.0
strike_through: false
underline: false

```
## Authorization-001
### Input
```yaml
id: auth-001
permissions: 2147483647
resource_id: '*'
resource_type: 6
type: GRANT
user_id: user-001

```
## Batch-001
### Input
```yaml
batch_job_definition_id: bjd-001
create_user_id: admin
id: batch-001
invocations_per_job: 1
jobs_created: 100
jobs_per_seed: 100
monitor_job_definition_id: mjd-001
seed_job_definition_id: sjd-001
start_time: '2025-04-01T22:00:00+00:00'
suspension_state: ACTIVE
tenant_id: tenant-alpha
total_jobs: 100
type: migration

```
## Execution-001
### Input
```yaml
activity_id: Task_ApproveInvoice
id: exec-001
is_active: true
is_concurrent: false
is_event_scope: false
is_scope: true
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
root_process_instance_id: pi-001
sequence_counter: 5
suspension_state: ACTIVE
tenant_id: tenant-alpha

```
## Deployment-vendor
### Input
```yaml
deploy_time: '2013-01-23T13:59:43+00:00'
id: aDeploymentId
name: aName
source: aDeploymentSource
tenant_id: aTenantId

```
## Deployment-001
### Input
```yaml
deploy_time: '2025-02-20T09:15:00+00:00'
id: dep-001
name: invoice-process-v2
source: classpath
tenant_id: tenant-alpha

```
## ExternalTask-001
### Input
```yaml
activity_id: ExternalTask_SendEmail
activity_instance_id: ai-001
create_time: '2025-04-01T14:00:00+00:00'
execution_id: exec-001
id: et-001
lock_expiration_time: '2025-04-01T14:30:00+00:00'
priority: 10
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
retries: 3
suspension_state: ACTIVE
tenant_id: tenant-alpha
topic_name: sendEmail
worker_id: worker-node-1

```
## Attachment-001
### Input
```yaml
content_id: ba-002
create_time: '2025-04-01T14:05:00+00:00'
description: Scanned copy of the paper invoice
id: att-001
name: invoice-scan.pdf
process_instance_id: pi-001
root_process_instance_id: pi-001
task_id: task-001
tenant_id: tenant-alpha
type: application/pdf
url: http://example.com/files/invoice-scan.pdf
user_id: user-001

```
## CaseDefinition-vendor
### Input
```yaml
category: aCaseDefinitionCategory
deployment_id: aDeploymentId
diagram_resource_name: aResourceName.png
id: aCaseDefnitionId
key: aCaseDefinitionKey
name: aCaseDefinitionName
resource_name: aCaseDefinitionResourceName
tenant_id: aTenantId
version: 1

```
## Comment-vendor
### Input
```yaml
event_time: '2014-04-24T14:10:44+00:00'
full_message: aTaskCommentFullMessage
id: aTaskCommentId
message: aMessage
process_instance_id: aProcInstId
root_process_instance_id: aRootProcInstId
task_id: anId
tenant_id: aTenantId
type: comment
user_id: anAssignee

```
## HistoricTaskInstance-vendor
### Input
```yaml
activity_instance_id: anActInstId
assignee: anAssignee
delete_reason: aDeleteReason
description: aDescription
due_date: '2014-01-01T00:00:00+00:00'
duration: 5000
end_time: '2014-01-01T00:00:00+00:00'
execution_id: anExecId
follow_up_date: '2014-01-01T00:00:00+00:00'
id: aHistoricTaskInstanceId
name: aName
owner: anOwner
parent_task_id: aParentTaskId
priority: 60
process_definition_id: aProcDefId
process_definition_key: aProcDefKey
process_instance_id: aProcInstId
removal_time: '2018-01-01T00:00:00+00:00'
root_process_instance_id: aRootProcInstId
start_time: '2014-01-01T00:00:00+00:00'
task_definition_key: aTaskDefinitionKey
task_state: aTaskState
tenant_id: aTenantId

```
## HistoricIdentityLink-001
### Input
```yaml
assigner_id: admin
id: hil-001
operation_type: AddUserLink
process_definition_id: procdef-001
process_definition_key: invoice-process
root_process_instance_id: pi-001
task_id: task-001
tenant_id: tenant-alpha
timestamp: '2025-03-01T09:01:00+00:00'
type: candidate
user_id: user-001

```
## HistoricProcessInstance-vendor
### Input
```yaml
business_key: aKey
case_instance_id: aCaseInstanceId
delete_reason: aDeleteReason
duration: 2000
end_activity_id: anEndActivityId
end_time: '2013-04-23T13:42:43+00:00'
id: aProcInstId
process_definition_id: aProcDefId
process_definition_key: aKey
process_instance_id: aProcInstId
removal_time: '2013-04-26T13:42:43+00:00'
root_process_instance_id: aRootProcessInstanceId
start_activity_id: aStartActivityId
start_time: '2013-04-23T13:42:43+00:00'
start_user_id: aStartUserId
state: COMPLETED
super_case_instance_id: aSuperCaseInstanceId
super_process_instance_id: aSuperProcessInstanceId
tenant_id: aTenantId

```
## DecisionDefinition-vendor
### Input
```yaml
category: aDecisionDefinitionCategory
deployment_id: aDeploymentId
diagram_resource_name: aResourceName.png
id: aDecisionDefinitionId
key: aDecisionDefinitionKey
name: aDecisionDefinitionName
resource_name: aDecisionDefinitionResourceName
tenant_id: aTenantId
version: 1

```
## VariableInstance-001
### Input
```yaml
execution_id: exec-001
id: var-001
name: invoiceNumber
process_definition_id: procdef-001
process_instance_id: pi-001
sequence_counter: 1
task_id: task-001
tenant_id: tenant-alpha
text_value: INV-2025-0042
type: string
variable_scope_id: exec-001

```
## Property-001
### Input
```yaml
name: schema.version
value: 7.22.0

```
## HistoricCaseInstance-vendor
### Input
```yaml
business_key: aBusinessKey
case_definition_id: aCaseDefId
case_instance_id: aCaseInstId
close_time: '2013-04-23T13:42:43+00:00'
create_time: '2013-04-23T13:42:43+00:00'
create_user_id: aCreateUserId
duration: 2000
end_time: '2013-04-23T13:42:43+00:00'
id: aCaseInstId
process_definition_id: aProcDefId
process_definition_key: aKey
process_instance_id: aProcInstId
root_process_instance_id: aRootProcInstId
start_time: '2013-04-23T13:42:43+00:00'
state: COMPLETED
super_case_instance_id: aSuperCaseInstanceId
super_process_instance_id: aSuperProcessInstanceId
tenant_id: aTenantId

```
## HistoricJobLog-vendor
### Input
```yaml
activity_id: anActId
deployment_id: aDeploymentId
execution_id: anExecId
failed_activity_id: aFailedActId
hostname: aHostname
id: aHistoricJobLogId
job_definition_configuration: aJobDefConfig
job_definition_id: aJobDefId
job_definition_type: aJobDefType
job_due_date: '2015-10-01T00:00:00+00:00'
job_exception_message: aJobExceptionMsg
job_id: aJobId
job_priority: 2147483689
job_retries: 5
job_state: CREATED
process_definition_id: aProcDefId
process_definition_key: aProcDefKey
process_instance_id: aProcInstId
removal_time: '2018-01-01T00:00:00+00:00'
root_process_instance_id: aRootProcInstId
sequence_counter: 1
tenant_id: aTenantId
timestamp: '2015-01-01T00:00:00+00:00'

```
## DecisionRequirementsDefinition-vendor
### Input
```yaml
category: aDecisionRequirementsDefinitionCategory
deployment_id: aDeploymentId
diagram_resource_name: aResourceName.png
id: aDecisionRequirementsDefinitionId
key: aDecisionRequirementsDefinitionKey
name: aDecisionRequirementsDefinitionName
resource_name: aDecisionRequirementsDefinitionResourceName
tenant_id: aTenantId
version: 1

```
## FormDefinition-001
### Input
```yaml
deployment_id: dep-001
id: formdef-001
key: invoice-form
name: Invoice Form
resource_name: invoice-form.form
version: 1

```
## HistoricBatch-001
### Input
```yaml
batch_job_definition_id: bjd-001
create_user_id: admin
end_time: '2025-03-10T22:30:00+00:00'
id: hbatch-001
invocations_per_job: 1
jobs_per_seed: 50
monitor_job_definition_id: mjd-001
seed_job_definition_id: sjd-001
start_time: '2025-03-10T22:00:00+00:00'
tenant_id: tenant-alpha
total_jobs: 50
type: migration

```
## HistoricDecisionInputInstance-001
### Input
```yaml
clause_id: clause-1
clause_name: Amount
create_time: '2025-03-01T09:10:00+00:00'
decision_instance_id: hdi-001
id: hdii-001
root_process_instance_id: pi-001
tenant_id: tenant-alpha
text_value: '1500.00'
variable_type: string

```
## HistoricCaseActivityInstance-001
### Input
```yaml
case_activity_id: HumanTask_1
case_activity_name: Review Case
case_definition_id: casedef-001
case_instance_id: ci-001
create_time: '2025-03-01T09:05:00+00:00'
duration: 1500000
end_time: '2025-03-01T09:30:00+00:00'
id: hcai-001
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
root_process_instance_id: pi-001
start_time: '2025-03-01T09:05:00+00:00'
state: COMPLETED
task_id: task-001
tenant_id: tenant-alpha

```
## Batch-vendor
### Input
```yaml
batch_job_definition_id: aBatchJobDefinitionId
id: aBatchId
invocations_per_job: 12
jobs_created: 9
jobs_per_seed: 11
monitor_job_definition_id: aMonitorJobDefinitionId
seed_job_definition_id: aSeedJobDefinitionId
start_time: '2016-04-12T15:29:33+00:00'
suspension_state: ACTIVE
tenant_id: aTenantId
total_jobs: 10
type: aBatchType

```
## FluxnovaPlatformData-001
### Input
```yaml
deployments:
- id: dep-001
  name: invoice-v1
groups:
- id: group-001
  name: Accounting
process_definitions:
- id: pd-001
  is_startable: true
  key: invoice
  name: Invoice
  version: 1
tasks:
- create_time: '2025-04-01T10:00:00+00:00'
  id: task-001
  name: Review
  priority: 50
users:
- first_name: Jane
  id: user-001
  last_name: Doe

```
## HistoricVariableInstance-001
### Input
```yaml
activity_instance_id: hai-001
create_time: '2025-03-01T09:01:00+00:00'
execution_id: exec-001
id: hvi-001
name: invoiceNumber
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
root_process_instance_id: pi-001
state: ACTIVE
tenant_id: tenant-alpha
text_value: INV-2025-0042
variable_type: string

```
## Job-001
### Input
```yaml
create_time: '2025-04-01T14:00:00+00:00'
deployment_id: dep-001
due_date: '2025-04-02T06:00:00+00:00'
execution_id: exec-001
handler_type: async-continuation
id: job-001
is_exclusive: true
job_definition_id: jd-001
lock_owner: engine-node-1
priority: 0
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
retries: 3
root_process_instance_id: pi-001
sequence_counter: 1
suspension_state: ACTIVE
tenant_id: tenant-alpha
type: message

```
## Filter-vendor
### Input
```yaml
id: aFilterId
name: aFilterName
owner: aFilterOwner
properties: '{"color":"#112233"}'
query: '{"taskName":"test"}'
resource_type: '7'

```
## HistoricTaskInstance-001
### Input
```yaml
activity_instance_id: hai-001
assignee: jane
due_date: '2025-03-05T17:00:00+00:00'
duration: 1440000
end_time: '2025-03-01T09:25:00+00:00'
execution_id: exec-001
id: hti-001
name: Approve Invoice
owner: john
priority: 50
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
root_process_instance_id: pi-001
start_time: '2025-03-01T09:01:00+00:00'
task_definition_key: Task_ApproveInvoice
task_state: COMPLETED
tenant_id: tenant-alpha

```
## Incident-vendor
### Input
```yaml
activity_id: anActivityId
cause_incident_id: aCauseIncidentId
configuration: aConfiguration
execution_id: anExecutionId
failed_activity_id: aFailedActivityId
id: anIncidentId
incident_message: anIncidentMessage
incident_timestamp: '2014-01-02T00:00:00+00:00'
incident_type: anIncidentType
process_definition_id: aProcDefId
process_instance_id: aProcInstId
root_cause_incident_id: aRootCauseIncidentId
tenant_id: aTenantId

```
## HistoricJobLog-001
### Input
```yaml
activity_id: Task_SendEmail
deployment_id: dep-001
execution_id: exec-001
hostname: engine-node-1
id: hjl-001
job_definition_id: jd-001
job_definition_type: async-continuation
job_due_date: '2025-03-02T06:00:00+00:00'
job_id: job-001
job_priority: 0
job_retries: 3
job_state: CREATED
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
root_process_instance_id: pi-001
sequence_counter: 1
tenant_id: tenant-alpha
timestamp: '2025-03-01T09:15:00+00:00'

```
## HistoricCaseActivityInstance-vendor
### Input
```yaml
called_case_instance_id: aCalledCaseInstanceId
called_process_instance_id: aCalledProcessInstanceId
case_activity_id: aCaseActivityId
case_activity_name: aCaseActivityName
case_activity_type: aCaseActivityType
case_definition_id: aCaseDefId
case_instance_id: aCaseInstId
create_time: '2014-04-23T18:42:42+00:00'
duration: 2000
end_time: '2014-04-23T18:42:43+00:00'
id: aCaseActivityInstanceId
is_required: true
parent_activity_instance_id: aParentCaseActivityId
process_definition_id: aProcDefId
process_definition_key: aKey
process_instance_id: aProcInstId
root_process_instance_id: aRootProcInstId
start_time: '2014-04-23T18:42:42+00:00'
state: COMPLETED
task_id: aTaskId
tenant_id: aTenantId

```
## MeterLog-001
### Input
```yaml
id: ml-001
milliseconds: 150
name: job-acquisition
reporter: engine-node-1
timestamp: '2025-06-01T12:00:00+00:00'
value: 42

```
## HistoricDecisionInstance-001
### Input
```yaml
activity_id: BusinessRuleTask_1
activity_instance_id: hai-001
decision_definition_id: decdef-001
decision_definition_key: approval-decision
decision_definition_name: Approval Decision
evaluation_time: '2025-03-01T09:10:00+00:00'
id: hdi-001
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
root_process_instance_id: pi-001
tenant_id: tenant-alpha
user_id: user-001

```
## HistoricDetail-vendor
### Input
```yaml
activity_instance_id: anActInst
case_definition_id: aCaseDefId
case_definition_key: aCaseDefKey
case_execution_id: aCaseExecId
case_instance_id: aCaseInstId
event_time: '2014-01-01T00:00:00+00:00'
execution_id: anExecutionId
id: aHistoricVariableUpdateId
name: aVariableName
operation_id: anOperationId
process_definition_id: aProcDefId
process_definition_key: aProcDefKey
process_instance_id: aProcInst
root_process_instance_id: aRootProcInstId
sequence_counter: 1
task_id: aTaskId
tenant_id: aTenantId
type: variableUpdate
variable_instance_id: aVariableInstanceId
variable_type: String

```
## HistoricBatch-vendor
### Input
```yaml
batch_job_definition_id: aBatchJobDefinitionId
end_time: '2016-04-12T16:23:34+00:00'
id: aBatchId
invocations_per_job: 12
jobs_per_seed: 11
monitor_job_definition_id: aMonitorJobDefinitionId
removal_time: '2016-04-12T16:23:34+00:00'
seed_job_definition_id: aSeedJobDefinitionId
start_time: '2016-04-12T15:29:33+00:00'
tenant_id: aTenantId
total_jobs: 10
type: aBatchType

```
## DecisionRequirementsDefinition-001
### Input
```yaml
deployment_id: dep-001
id: drdef-001
key: approval-drg
name: Approval Decision Requirements
resource_name: approval-drg.dmn
version: 1

```
## ProcessDefinition-001
### Input
```yaml
category: finance
deployment_id: dep-001
diagram_resource_name: invoice-process.png
has_start_form_key: true
history_time_to_live: 180
id: procdef-001
is_startable: true
key: invoice-process
name: Invoice Processing
resource_name: invoice-process.bpmn
suspension_state: ACTIVE
tenant_id: tenant-alpha
version: 2
version_tag: 2.0.0

```
## UserOperationLogEntry-vendor
### Input
```yaml
annotation: anAnnotation
batch_id: aBatchId
entity_type: Task
execution_id: anExecId
external_task_id: anExternalTaskId
id: userOpLogId
job_definition_id: aJobDefId
job_id: aJobId
new_value: newValue
operation_id: opId
operation_type: Claim
original_value: orgValue
process_definition_id: aProcDefId
process_definition_key: aKey
process_instance_id: aProcInstId
property: opProperty
root_process_instance_id: aRootProcInstId
task_id: aTaskId
tenant_id: aTenantId
timestamp: '2014-02-20T16:53:37+00:00'
user_id: aUserId

```
## HistoricIncident-vendor
### Input
```yaml
activity_id: anActivityId
cause_incident_id: aCauseIncidentId
configuration: aConfiguration
create_time: '2014-01-02T00:00:00+00:00'
end_time: '2014-01-02T00:00:00+00:00'
execution_id: anExecutionId
failed_activity_id: aFailedActivityId
history_configuration: aHistoryConfiguration
id: anIncidentId
incident_message: anIncidentMessage
incident_state: RESOLVED
incident_type: anIncidentType
process_definition_id: aProcDefId
process_definition_key: aProcDefKey
process_instance_id: aProcInstId
removal_time: '2018-01-01T00:00:00+00:00'
root_cause_incident_id: aRootCauseIncidentId
root_process_instance_id: aRootProcInstId
tenant_id: aTenantId

```
## Job-vendor
### Input
```yaml
create_time: '2015-01-01T00:00:00+00:00'
deployment_id: aDeploymentId
due_date: '2013-04-23T13:42:43+00:00'
exception_message: aExceptionMessage
execution_id: anExecutionId
failed_activity_id: aFailedJobActivityId
handler_type: aHandlerType
id: aJobId
is_exclusive: true
job_definition_id: aJobDefId
lock_owner: aLockOwner
priority: 2147483689
process_definition_id: aProcDefId
process_definition_key: aKey
process_instance_id: aProcInstId
retries: 3
root_process_instance_id: aRootProcessInstanceId
sequence_counter: 1
suspension_state: SUSPENDED
tenant_id: aTenantId
type: aJobType

```
## DecisionDefinition-001
### Input
```yaml
decision_requirements_definition_id: drdef-001
decision_requirements_definition_key: approval-drg
deployment_id: dep-001
id: decdef-001
key: approval-decision
name: Approval Decision
resource_name: approval.dmn
version: 1
version_tag: '1.0'

```
## Filter-001
### Input
```yaml
id: filter-001
name: My Tasks
owner: user-001
properties: '{"color": "#3e4d2f"}'
query: '{"assignee": "user-001"}'
resource_type: '7'

```
## HistoricDecisionOutputInstance-001
### Input
```yaml
clause_id: clause-out-1
clause_name: Approved
create_time: '2025-03-01T09:10:00+00:00'
decision_instance_id: hdi-001
id: hdoi-001
root_process_instance_id: pi-001
rule_id: rule-1
rule_order: 1
tenant_id: tenant-alpha
text_value: 'true'
variable_name: approved
variable_type: boolean

```
## HistoricDetail-001
### Input
```yaml
activity_instance_id: hai-001
double_value: 1500.0
event_time: '2025-03-01T09:02:00+00:00'
execution_id: exec-001
id: hd-001
name: invoiceAmount
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
root_process_instance_id: pi-001
sequence_counter: 1
tenant_id: tenant-alpha
text_value: '1500.0'
type: variableUpdate
variable_type: double

```
## User-001
### Input
```yaml
email: jane.doe@example.com
first_name: Jane
id: user-001
last_name: Doe

```
## Authorization-vendor
### Input
```yaml
group_id: aGroupId
id: someAuthorizationId
permissions: 2147483647
removal_time: '2013-04-23T13:42:43+00:00'
resource_id: exampleResourceId
resource_type: 12345678
root_process_instance_id: aRootProcessInstanceId
type: GLOBAL
user_id: aUserId

```
## EventSubscription-001
### Input
```yaml
activity_id: StartEvent_1
configuration: correlationKey
created: '2025-04-01T10:00:00+00:00'
event_name: InvoiceReceived
event_type: message
execution_id: exec-001
id: evtsub-001
process_instance_id: pi-001
tenant_id: tenant-alpha

```
## EventSubscription-vendor
### Input
```yaml
activity_id: anActivityId
created: '2013-01-23T13:59:43+00:00'
event_name: anEvent
event_type: message
execution_id: anExecutionId
id: anEventSubscriptionId
process_instance_id: aProcInstId
tenant_id: aTenantId

```
## Tenant-001
### Input
```yaml
id: tenant-001
name: Alpha Corp

```
## Comment-001
### Input
```yaml
action: AddComment
event_time: '2025-04-01T14:10:00+00:00'
full_message: Invoice approved by Jane Doe on 2025-04-01
id: comment-001
message: Approved by manager
process_instance_id: pi-001
root_process_instance_id: pi-001
task_id: task-001
tenant_id: tenant-alpha
type: event
user_id: user-001

```
## JobDefinition-001
### Input
```yaml
activity_id: Task_SendEmail
deployment_id: dep-001
id: jd-001
job_configuration: transition
job_priority: 0
job_type: async-continuation
process_definition_id: procdef-001
process_definition_key: invoice-process
suspension_state: ACTIVE
tenant_id: tenant-alpha

```
## HistoricExternalTaskLog-vendor
### Input
```yaml
activity_id: anActId
activity_instance_id: anActInstanceId
error_message: aEXTERNAL_TASKExceptionMsg
execution_id: anExecId
external_task_id: anExternalTaskId
id: aHistoricExternalTaskLogId
priority: 2147483689
process_definition_id: aProcDefId
process_definition_key: aProcDefKey
process_instance_id: aProcInstId
removal_time: '2018-01-01T00:00:00+00:00'
retries: 5
root_process_instance_id: aRootProcInstId
state: ACTIVE
tenant_id: aTenantId
timestamp: '2015-01-01T00:00:00+00:00'
topic_name: aTopicName
worker_id: aWorkerId

```
## IdentityLink-001
### Input
```yaml
group_id: group-001
id: idlink-001
task_id: task-001
tenant_id: tenant-alpha
type: candidate

```
## CaseSentryPart-001
### Input
```yaml
case_execution_id: caseexec-001
case_instance_id: ci-001
id: csp-001
sentry_id: Sentry_1
source_case_execution_id: caseexec-002
standard_event: complete
tenant_id: tenant-alpha
type: planItem

```
## ExternalTask-vendor
### Input
```yaml
activity_id: anActivityId
activity_instance_id: anActivityInstanceId
create_time: '2015-10-05T12:25:00+00:00'
error_message: some error
execution_id: anExecutionId
id: anExternalTaskId
lock_expiration_time: '2015-10-05T13:25:00+00:00'
priority: 2147484113
process_definition_id: aProcDefId
process_definition_key: aKey
process_instance_id: aProcInstId
retries: 5
suspension_state: SUSPENDED
tenant_id: aTenantId
topic_name: aTopic
worker_id: aWorkerId

```
## VariableInstance-vendor
### Input
```yaml
batch_id: aBatchId
case_execution_id: aVariableInstanceCaseExecutionId
case_instance_id: aVariableInstanceCaseInstId
execution_id: aVariableInstanceExecutionId
id: aVariableInstanceId
name: aVariableInstanceName
process_definition_id: aVariableInstanceProcDefId
process_instance_id: aVariableInstanceProcInstId
task_id: aVariableInstanceTaskId
tenant_id: aTenantId
text_value: aVariableInstanceValue
type: String
variable_scope_id: aVariableInstanceExecutionId

```
## HistoricIdentityLink-vendor
### Input
```yaml
assigner_id: aAssignerId
group_id: aGroupId
id: aHistIdentityLinkId
operation_type: add
process_definition_id: aProcDefId
process_definition_key: aProcDefKey
removal_time: '2018-01-05T00:00:00+00:00'
root_process_instance_id: aRootProcInstId
task_id: aTaskId
tenant_id: aTenantId
timestamp: '2014-01-05T00:00:00+00:00'
type: assignee
user_id: aUserId

```
## TenantMembership-001
### Input
```yaml
group_id: group-001
id: tm-001
tenant_id: tenant-001
user_id: user-001

```
## CaseDefinition-001
### Input
```yaml
deployment_id: dep-001
id: casedef-001
key: support-case
name: Support Case
resource_name: support-case.cmmn
tenant_id: tenant-alpha
version: 1

```
## Task-vendor
### Input
```yaml
assignee: anAssignee
create_time: '2013-01-23T13:42:42+00:00'
delegation_state: RESOLVED
description: aDescription
due_date: '2013-01-23T13:42:43+00:00'
execution_id: anExecution
follow_up_date: '2013-01-23T13:42:44+00:00'
id: anId
last_updated: '2013-01-23T13:42:45+00:00'
name: aName
owner: anOwner
parent_task_id: aParentId
priority: 42
process_definition_id: aProcDefId
process_instance_id: aProcInstId
suspension_state: ACTIVE
task_definition_key: aTaskDefinitionKey
task_state: aTaskState
tenant_id: aTenantId

```
## HistoricExternalTaskLog-001
### Input
```yaml
activity_id: ExternalTask_SendEmail
activity_instance_id: hai-002
execution_id: exec-001
external_task_id: et-001
id: hetl-001
priority: 10
process_definition_id: procdef-001
process_definition_key: invoice-process
process_instance_id: pi-001
retries: 3
root_process_instance_id: pi-001
state: ACTIVE
tenant_id: tenant-alpha
timestamp: '2025-03-01T09:15:00+00:00'
topic_name: sendEmail
worker_id: worker-node-1

```
## Bounds-001
### Input
```yaml
height: 80.0
width: 120.0
x: 10.0
y: 20.0

```
## Task-001
### Input
```yaml
assignee: jane
create_time: '2025-04-01T14:00:00+00:00'
delegation_state: PENDING
description: Review and approve the submitted invoice
due_date: '2025-04-05T17:00:00+00:00'
execution_id: exec-001
follow_up_date: '2025-04-03T09:00:00+00:00'
id: task-001
last_updated: '2025-04-01T15:30:00+00:00'
name: Approve Invoice
owner: john
priority: 50
process_definition_id: procdef-001
process_instance_id: pi-001
suspension_state: ACTIVE
task_definition_key: Task_ApproveInvoice
task_state: CREATED
tenant_id: tenant-alpha

```
## Incident-001
### Input
```yaml
activity_id: Task_SendEmail
cause_incident_id: inc-001
configuration: job-001
execution_id: exec-001
id: inc-001
incident_message: Failed to execute job
incident_timestamp: '2025-03-10T11:22:33+00:00'
incident_type: failedJob
job_definition_id: jd-001
process_definition_id: procdef-001
process_instance_id: pi-001
root_cause_incident_id: inc-001
tenant_id: tenant-alpha

```
## Point-001
### Input
```yaml
x: 100.0
y: 200.5

```
## ByteArray-001
### Input
```yaml
create_time: '2025-01-15T10:30:00+00:00'
deployment_id: dep-001
id: ba-001
name: process-diagram.bpmn
tenant_id: tenant-alpha
type: 1

```
## CaseExecution-001
### Input
```yaml
activity_id: HumanTask_ReviewCase
case_definition_id: casedef-001
case_instance_id: ci-001
current_state: 1
id: caseexec-001
parent_id: caseexec-000
previous_state: 0
tenant_id: tenant-alpha

```
## Authorization-bad-type
### Input
```yaml
id: someAuthorizationId
resource_id: exampleResourceId
resource_type: not_a_number
type: 0
user_id: aUserId

```
## Batch-bad-total-jobs
### Input
```yaml
id: aBatchId
total_jobs: ten
type: aBatchType

```
## ExternalTask-bad-timestamp
### Input
```yaml
id: anExternalTaskId
lock_expiration_time: not-a-date
topic_name: aTopic
worker_id: aWorkerId

```
## User-missing-id
### Input
```yaml
email: john@example.com
first_name: John
last_name: Smith

```
## Font-bad-bool
### Input
```yaml
bold: yes-please
name: Arial
size: 12.0

```
## Point-bad-type
### Input
```yaml
x: not-a-number
y: 200.0

```
## Filter-missing-query
### Input
```yaml
id: filter-no-query
name: Broken Filter
owner: user-001
resource_type: 7

```
## Job-bad-retries
### Input
```yaml
execution_id: anExecutionId
id: aJobId
process_definition_id: aProcDefId
process_instance_id: aProcInstId
retries: not-a-number
type: aJobType

```
## ProcessDefinition-missing-id
### Input
```yaml
is_startable: true
key: invoice-process
name: Invoice Processing
version: 1

```
## HistoricProcessInstance-bad-state
### Input
```yaml
id: aProcInstId
process_definition_id: aProcDefId
process_instance_id: aProcInstId
start_time: '2013-04-23T13:42:43+00:00'
state: NONEXISTENT_STATE

```
## HistoricCaseInstance-bad-state
### Input
```yaml
case_definition_id: casedef-001
case_instance_id: ci-001
create_time: '2025-03-01T09:00:00+00:00'
id: hci-001
state: NONEXISTENT_STATE

```
## Task-missing-id
### Input
```yaml
name: Approve Invoice
priority: 50

```
## Comment-missing-event-time
### Input
```yaml
id: comment-no-time
message: Incomplete comment
type: event
user_id: user-001

```
## ProcessDefinition-bad-enum
### Input
```yaml
id: procdef-bad-enum
is_startable: true
key: bad-process
name: Bad Process
suspension_state: INVALID_STATE
version: 1

```
