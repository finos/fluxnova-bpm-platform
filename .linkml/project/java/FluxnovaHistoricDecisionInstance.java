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
  Represents one evaluation of a decision.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricDecisionInstance  {

  private String id;
  private String decisionDefinitionId;
  private String decisionDefinitionKey;
  private String decisionDefinitionName;
  private String processDefinitionKey;
  private String processDefinitionId;
  private String processInstanceId;
  private String caseDefinitionKey;
  private String caseDefinitionId;
  private String caseInstanceId;
  private String activityInstanceId;
  private String activityId;
  private ZonedDateTime evaluationTime;
  private ZonedDateTime removalTime;
  private Float collectResultValue;
  private String userId;
  private String rootDecisionInstanceId;
  private String rootProcessInstanceId;
  private String decisionRequirementsDefinitionId;
  private String decisionRequirementsDefinitionKey;
  private String tenantId;


}