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
  A single execution of a case definition that is stored permanently.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricCaseInstance extends FluxnovaHistoricScopeInstance {

  private String caseInstanceId;
  private String businessKey;
  private String caseDefinitionId;
  private ZonedDateTime createTime;
  private ZonedDateTime closeTime;
  private Integer state;
  private String createUserId;
  private String superCaseInstanceId;
  private String superProcessInstanceId;


}