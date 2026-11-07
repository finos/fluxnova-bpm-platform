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
  The expression that reads a correlation property from one message.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnCorrelationPropertyRetrievalExpression extends BpmnBaseElement {

  private String messageRef;
  private BpmnMessagePath messagePath;


}