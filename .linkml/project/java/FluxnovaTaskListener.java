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
  Code the engine runs when a user task reaches an event, such as its creation or completion.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaTaskListener extends BpmnModelElementInstance {

  private String fluxnovaEvent;
  private String fluxnovaClass;
  private String fluxnovaExpression;
  private String fluxnovaDelegateExpression;
  private List<FluxnovaField> bpmnFields;
  private FluxnovaScript script;
  private BpmnTimerEventDefinition timerEventDefinition;


}