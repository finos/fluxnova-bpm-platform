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
  An activity that calls a separate process or global task.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnCallActivity extends BpmnActivity {

  private String calledElement;
  private Boolean fluxnovaAsync;
  private String fluxnovaCalledElementBinding;
  private String fluxnovaCalledElementVersion;
  private String fluxnovaCalledElementVersionTag;
  private String fluxnovaCaseRef;
  private String fluxnovaCaseBinding;
  private String fluxnovaCaseVersion;
  private String fluxnovaCalledElementTenantId;
  private String fluxnovaCaseTenantId;
  private String fluxnovaVariableMappingClass;
  private String fluxnovaVariableMappingDelegateExpression;


}