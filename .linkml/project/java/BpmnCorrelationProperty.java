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
  A value read from messages that ties them to one conversation.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnCorrelationProperty extends BpmnRootElement {

  private String name;
  private String type;
  private List<BpmnCorrelationPropertyRetrievalExpression> correlationPropertyRetrievalExpressions;


}