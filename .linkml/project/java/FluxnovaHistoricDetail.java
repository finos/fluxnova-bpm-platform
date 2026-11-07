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
  Base class for all kinds of information that is related to either a HistoricProcessInstance or a HistoricActivityInstance.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricDetail  {

  private String id;
  private String type;
  private ZonedDateTime eventTime;
  private String name;
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
  private String variableInstanceId;
  private String variableType;
  private String byteArrayId;
  private Float doubleValue;
  private Integer longValue;
  private String textValue;
  private String text2Value;
  private Integer sequenceCounter;
  private String tenantId;
  private String operationId;
  private ZonedDateTime removalTime;
  private Boolean isInitial;


}