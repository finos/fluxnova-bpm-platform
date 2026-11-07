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
  How a process instance subscribes to messages by a correlation key.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnCorrelationSubscription extends BpmnBaseElement {

  private String correlationKeyRef;
  private List<BpmnCorrelationPropertyBinding> correlationPropertyBindings;


}