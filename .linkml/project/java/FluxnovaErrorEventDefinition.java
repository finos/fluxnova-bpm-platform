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
  An error event definition on an external service task, raised when its expression holds.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaErrorEventDefinition extends BpmnModelElementInstance {

  private String fluxnovaExpression;


}