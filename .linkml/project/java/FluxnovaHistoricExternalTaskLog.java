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
  The HistoricExternalTaskLog is used to have a log containing information about task execution.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricExternalTaskLog  {

  private String id;
  private ZonedDateTime timestamp;
  private String externalTaskId;
  private Integer retries;
  private String topicName;
  private String workerId;
  private int priority;
  private String errorMessage;
  private String errorDetailsId;
  private String activityId;
  private String activityInstanceId;
  private String executionId;
  private String rootProcessInstanceId;
  private String processInstanceId;
  private String processDefinitionId;
  private String processDefinitionKey;
  private String tenantId;
  private Integer state;
  private ZonedDateTime removalTime;


}