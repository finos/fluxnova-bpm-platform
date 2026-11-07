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
  A Job Definition provides details about asynchronous background processing ("Jobs") performed by the process engine.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaJobDefinition  {

  private String id;
  private String processDefinitionId;
  private String processDefinitionKey;
  private String activityId;
  private String jobType;
  private String jobConfiguration;
  private Integer suspensionState;
  private Integer jobPriority;
  private String tenantId;
  private String deploymentId;


}