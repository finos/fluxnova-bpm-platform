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
  Code the engine runs when an execution passes an event of an element, such as its start or end.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaExecutionListener extends BpmnModelElementInstance {

  private String fluxnovaEvent;
  private String fluxnovaClass;
  private String fluxnovaExpression;
  private String fluxnovaDelegateExpression;
  private List<FluxnovaField> fields;
  private FluxnovaScript script;


}