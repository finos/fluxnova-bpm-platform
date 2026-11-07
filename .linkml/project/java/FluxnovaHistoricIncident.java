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
  Represents a historic incident that is stored permanently.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricIncident  {

  private String id;
  private String processDefinitionKey;
  private String processDefinitionId;
  private String rootProcessInstanceId;
  private String processInstanceId;
  private String executionId;
  private ZonedDateTime createTime;
  private ZonedDateTime endTime;
  private String incidentMessage;
  private String incidentType;
  private String activityId;
  private String failedActivityId;
  private String causeIncidentId;
  private String rootCauseIncidentId;
  private String configuration;
  private String historyConfiguration;
  private Integer incidentState;
  private String tenantId;
  private String jobDefinitionId;
  private String annotation;
  private ZonedDateTime removalTime;


}