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
  Case Execution entity in the process execution runtime.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaCaseExecution  {

  private String id;
  private FluxnovaCaseExecution caseInstanceId;
  private String superCaseExecutionId;
  private String superExecutionId;
  private String businessKey;
  private FluxnovaCaseExecution parentId;
  private FluxnovaCaseDefinition caseDefinitionId;
  private String activityId;
  private Integer previousState;
  private Integer currentState;
  private Boolean isRequired;
  private String tenantId;


}