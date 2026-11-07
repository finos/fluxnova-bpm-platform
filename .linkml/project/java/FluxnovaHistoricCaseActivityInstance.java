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
  Represents one execution of a case activity which is stored permanent for statistics, audit and other business intelligence purposes.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricCaseActivityInstance extends FluxnovaHistoricScopeInstance {

  private String parentActivityInstanceId;
  private String caseDefinitionId;
  private String caseInstanceId;
  private String caseActivityId;
  private String taskId;
  private String calledProcessInstanceId;
  private String calledCaseInstanceId;
  private String caseActivityName;
  private String caseActivityType;
  private ZonedDateTime createTime;
  private ZonedDateTime endTime;
  private Integer state;
  private Boolean isRequired;


}