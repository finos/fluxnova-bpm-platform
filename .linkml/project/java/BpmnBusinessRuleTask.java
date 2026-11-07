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
  A task that hands data to a business rules engine and receives its result.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnBusinessRuleTask extends BpmnTask {

  private String implementation;
  private String fluxnovaClass;
  private String fluxnovaDelegateExpression;
  private String fluxnovaExpression;
  private String fluxnovaResultVariable;
  private String fluxnovaTopic;
  private String fluxnovaType;
  private String fluxnovaDecisionRef;
  private String fluxnovaDecisionRefBinding;
  private String fluxnovaDecisionRefVersion;
  private String fluxnovaDecisionRefVersionTag;
  private String fluxnovaDecisionRefTenantId;
  private String fluxnovaMapDecisionResult;
  private String fluxnovaTaskPriority;


}