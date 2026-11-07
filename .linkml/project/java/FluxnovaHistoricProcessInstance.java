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
  A single execution of a whole process definition that is stored permanently.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricProcessInstance extends FluxnovaHistoricScopeInstance {

  private String processInstanceId;
  private String businessKey;
  private String processDefinitionKey;
  private String processDefinitionId;
  private ZonedDateTime startTime;
  private ZonedDateTime endTime;
  private ZonedDateTime removalTime;
  private String startUserId;
  private String startActivityId;
  private String endActivityId;
  private String superProcessInstanceId;
  private String rootProcessInstanceId;
  private String superCaseInstanceId;
  private String caseInstanceId;
  private String deleteReason;
  private String state;
  private String restartedProcessInstanceId;


}