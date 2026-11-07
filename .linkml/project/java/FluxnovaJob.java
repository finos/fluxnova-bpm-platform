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
  Represents one job (timer, message, etc.).
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaJob  {

  private String id;
  private String type;
  private ZonedDateTime lockExpirationTime;
  private String lockOwner;
  private Boolean isExclusive;
  private String executionId;
  private String rootProcessInstanceId;
  private String processInstanceId;
  private String processDefinitionId;
  private String processDefinitionKey;
  private Integer retries;
  private FluxnovaByteArray exceptionStackId;
  private String exceptionMessage;
  private String failedActivityId;
  private ZonedDateTime dueDate;
  private String repeat;
  private Integer repeatOffset;
  private String handlerType;
  private String handlerConfiguration;
  private String deploymentId;
  private int suspensionState;
  private String jobDefinitionId;
  private int priority;
  private Integer sequenceCounter;
  private String tenantId;
  private ZonedDateTime createTime;
  private String lastFailureLogId;
  private String batchId;


}