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
  Log entry about an operation performed by a user.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaUserOperationLogEntry  {

  private String id;
  private String deploymentId;
  private String processDefinitionId;
  private String processDefinitionKey;
  private String rootProcessInstanceId;
  private String processInstanceId;
  private String executionId;
  private String caseDefinitionId;
  private String caseInstanceId;
  private String caseExecutionId;
  private String taskId;
  private String jobId;
  private String jobDefinitionId;
  private String batchId;
  private String userId;
  private ZonedDateTime timestamp;
  private String operationType;
  private String operationId;
  private String entityType;
  private String property;
  private String originalValue;
  private String newValue;
  private String tenantId;
  private ZonedDateTime removalTime;
  private String category;
  private String externalTaskId;
  private String annotation;


}