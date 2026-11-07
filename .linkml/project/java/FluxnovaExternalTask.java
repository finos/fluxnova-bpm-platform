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
  Represents an instance of an external task that is created when a service-task like activity (i.e. service task, send task, ...) with attribute camunda:type="external" is executed.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaExternalTask  {

  private String id;
  private String workerId;
  private String topicName;
  private Integer retries;
  private String errorMessage;
  private FluxnovaByteArray errorDetailsId;
  private ZonedDateTime lockExpirationTime;
  private ZonedDateTime createTime;
  private Integer suspensionState;
  private FluxnovaExecution executionId;
  private String processInstanceId;
  private String processDefinitionId;
  private String processDefinitionKey;
  private String activityId;
  private String activityInstanceId;
  private String tenantId;
  private int priority;
  private String lastFailureLogId;


}