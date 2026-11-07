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
  The HistoricJobLog is used to have a log containing information about job execution.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricJobLog  {

  private String id;
  private ZonedDateTime timestamp;
  private String jobId;
  private ZonedDateTime jobDueDate;
  private Integer jobRetries;
  private int jobPriority;
  private String jobExceptionMessage;
  private String jobExceptionStackId;
  private Integer jobState;
  private String jobDefinitionId;
  private String jobDefinitionType;
  private String jobDefinitionConfiguration;
  private String activityId;
  private String failedActivityId;
  private String executionId;
  private String rootProcessInstanceId;
  private String processInstanceId;
  private String processDefinitionId;
  private String processDefinitionKey;
  private String deploymentId;
  private Integer sequenceCounter;
  private String tenantId;
  private String hostname;
  private ZonedDateTime removalTime;
  private String batchId;


}