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
  Represents one task for a human user.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaTask  {

  private String id;
  private FluxnovaExecution executionId;
  private FluxnovaExecution processInstanceId;
  private FluxnovaProcessDefinition processDefinitionId;
  private FluxnovaCaseExecution caseExecutionId;
  private String caseInstanceId;
  private FluxnovaCaseDefinition caseDefinitionId;
  private String name;
  private String parentTaskId;
  private String description;
  private String taskDefinitionKey;
  private String owner;
  private String assignee;
  private String delegationState;
  private int priority;
  private ZonedDateTime createTime;
  private ZonedDateTime lastUpdated;
  private ZonedDateTime dueDate;
  private ZonedDateTime followUpDate;
  private Integer suspensionState;
  private String tenantId;
  private String taskState;


}