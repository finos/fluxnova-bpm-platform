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
  An Incident represents a failure in the execution of a process instance.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaIncident  {

  private String id;
  private ZonedDateTime incidentTimestamp;
  private String incidentMessage;
  private String incidentType;
  private FluxnovaExecution executionId;
  private String activityId;
  private String failedActivityId;
  private FluxnovaExecution processInstanceId;
  private FluxnovaProcessDefinition processDefinitionId;
  private FluxnovaIncident causeIncidentId;
  private FluxnovaIncident rootCauseIncidentId;
  private String configuration;
  private String tenantId;
  private FluxnovaJobDefinition jobDefinitionId;
  private String annotation;


}