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
  Represent a 'path of execution' in a process instance.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaExecution  {

  private String id;
  private String rootProcessInstanceId;
  private FluxnovaExecution processInstanceId;
  private String businessKey;
  private FluxnovaExecution parentId;
  private FluxnovaProcessDefinition processDefinitionId;
  private FluxnovaExecution superExecutionId;
  private String superCaseExecutionId;
  private String caseInstanceId;
  private String activityInstanceId;
  private String activityId;
  private Boolean isActive;
  private Boolean isConcurrent;
  private Boolean isScope;
  private Boolean isEventScope;
  private Integer suspensionState;
  private Integer cachedEntityState;
  private Integer sequenceCounter;
  private String tenantId;
  private String processDefinitionKey;


}