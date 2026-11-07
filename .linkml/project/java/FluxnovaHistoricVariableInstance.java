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
  A single process variable containing the last value when its process instance has finished.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricVariableInstance  {

  private String id;
  private String processDefinitionKey;
  private String processDefinitionId;
  private String rootProcessInstanceId;
  private String processInstanceId;
  private String executionId;
  private String caseDefinitionKey;
  private String caseDefinitionId;
  private String caseInstanceId;
  private String caseExecutionId;
  private String taskId;
  private String activityInstanceId;
  private String name;
  private String variableType;
  private ZonedDateTime createTime;
  private String byteArrayId;
  private Float doubleValue;
  private Integer longValue;
  private String textValue;
  private String text2Value;
  private String tenantId;
  private String state;
  private ZonedDateTime removalTime;
  private Boolean restricted;


}