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
  Represents a historic task instance (waiting, finished or deleted) that is stored permanent for statistics, audit and other business intelligence purposes.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricTaskInstance extends FluxnovaHistoricScopeInstance {

  private String taskDefinitionKey;
  private String executionId;
  private String caseDefinitionKey;
  private String caseDefinitionId;
  private String caseInstanceId;
  private String caseExecutionId;
  private String activityInstanceId;
  private String name;
  private String parentTaskId;
  private String description;
  private String owner;
  private String assignee;
  private String deleteReason;
  private int priority;
  private ZonedDateTime dueDate;
  private ZonedDateTime followUpDate;
  private String tenantId;
  private String taskState;


}