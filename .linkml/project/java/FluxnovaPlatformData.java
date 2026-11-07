package example;

/* metamodel_version: 1.12.0 */
/* version: 3.1.1 */
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.*;

/**
  Root container for Fluxnova BPM Platform data: a list of rows for each of the engine's tables.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaPlatformData  {

  private List<FluxnovaAttachment> attachments;
  private List<FluxnovaAuthorization> authorizationEntries;
  private List<FluxnovaBatch> batches;
  private List<FluxnovaByteArray> byteArrays;
  private List<FluxnovaCaseDefinition> caseDefinitions;
  private List<FluxnovaCaseExecution> caseExecutions;
  private List<FluxnovaCaseSentryPart> caseSentryParts;
  private List<FluxnovaComment> commentEntries;
  private List<FluxnovaConfiguration> configurationEntries;
  private List<FluxnovaDecisionDefinition> decisionDefinitions;
  private List<FluxnovaDecisionRequirementsDefinition> decisionRequirementsDefinitions;
  private List<FluxnovaDeployment> deployments;
  private List<FluxnovaEngineProperty> engineProperties;
  private List<FluxnovaEventSubscription> eventSubscriptions;
  private List<FluxnovaExecution> executions;
  private List<FluxnovaExternalTask> externalTasks;
  private List<FluxnovaFilter> filterEntries;
  private List<FluxnovaFormDefinition> formDefinitions;
  private List<FluxnovaGroup> groups;
  private List<FluxnovaHistoricActivityInstance> historicActivityInstances;
  private List<FluxnovaHistoricBatch> historicBatches;
  private List<FluxnovaHistoricCaseActivityInstance> historicCaseActivityInstances;
  private List<FluxnovaHistoricCaseInstance> historicCaseInstances;
  private List<FluxnovaHistoricDecisionInputInstance> historicDecisionInputInstances;
  private List<FluxnovaHistoricDecisionInstance> historicDecisionInstances;
  private List<FluxnovaHistoricDecisionOutputInstance> historicDecisionOutputInstances;
  private List<FluxnovaHistoricDetail> historicDetails;
  private List<FluxnovaHistoricExternalTaskLog> historicExternalTaskLogs;
  private List<FluxnovaHistoricIdentityLink> historicIdentityLinks;
  private List<FluxnovaHistoricIncident> historicIncidents;
  private List<FluxnovaHistoricJobLog> historicJobLogs;
  private List<FluxnovaHistoricProcessInstance> historicProcessInstances;
  private List<FluxnovaHistoricTaskInstance> historicTaskInstances;
  private List<FluxnovaHistoricVariableInstance> historicVariableInstances;
  private List<FluxnovaIdentityInfo> identityInfos;
  private List<FluxnovaIdentityLink> identityLinks;
  private List<FluxnovaIncident> incidents;
  private List<FluxnovaJobDefinition> jobDefinitions;
  private List<FluxnovaJob> jobs;
  private List<FluxnovaMembership> memberships;
  private List<FluxnovaMeterLog> meterLogs;
  private List<FluxnovaProcessDefinition> processDefinitions;
  private List<FluxnovaSchemaLogEntry> schemaLogEntries;
  private List<FluxnovaTaskMeterLog> taskMeterLogs;
  private List<FluxnovaTask> tasks;
  private List<FluxnovaTenantMembership> tenantMemberships;
  private List<FluxnovaTenant> tenants;
  private List<FluxnovaUserOperationLogEntry> userOperationLogEntries;
  private List<FluxnovaUser> users;
  private List<FluxnovaVariableInstance> variableInstances;


}