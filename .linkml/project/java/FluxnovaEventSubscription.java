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
  A message event subscription exists, if an Execution waits for an event like a message.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaEventSubscription  {

  private String id;
  private String eventType;
  private String eventName;
  private FluxnovaExecution executionId;
  private String processInstanceId;
  private String activityId;
  private String configuration;
  private ZonedDateTime created;
  private String tenantId;


}