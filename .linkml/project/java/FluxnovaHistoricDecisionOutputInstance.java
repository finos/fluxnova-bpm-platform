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
  Represents one output variable of a decision evaluation.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricDecisionOutputInstance  {

  private String id;
  private String decisionInstanceId;
  private String clauseId;
  private String clauseName;
  private String ruleId;
  private Integer ruleOrder;
  private String variableName;
  private String variableType;
  private String byteArrayId;
  private Float doubleValue;
  private Integer longValue;
  private String textValue;
  private String text2Value;
  private String tenantId;
  private ZonedDateTime createTime;
  private String rootProcessInstanceId;
  private ZonedDateTime removalTime;


}