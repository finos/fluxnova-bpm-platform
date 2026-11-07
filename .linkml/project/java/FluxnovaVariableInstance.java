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
  A VariableInstance represents a variable in the execution of a process instance.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaVariableInstance  {

  private String id;
  private String type;
  private String name;
  private FluxnovaExecution executionId;
  private FluxnovaExecution processInstanceId;
  private String processDefinitionId;
  private FluxnovaCaseExecution caseExecutionId;
  private FluxnovaCaseExecution caseInstanceId;
  private String taskId;
  private FluxnovaBatch batchId;
  private FluxnovaByteArray byteArrayId;
  private Float doubleValue;
  private Integer longValue;
  private String textValue;
  private String text2Value;
  private String variableScopeId;
  private Integer sequenceCounter;
  private Boolean isConcurrentLocal;
  private String tenantId;
  private Boolean restricted;


}