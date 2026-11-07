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
  The trigger of an event that sends or receives a message.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnMessageEventDefinition extends BpmnEventDefinition {

  private String messageRef;
  private String fluxnovaClass;
  private String fluxnovaDelegateExpression;
  private String fluxnovaExpression;
  private String fluxnovaResultVariable;
  private String fluxnovaTopic;
  private String fluxnovaType;
  private String fluxnovaTaskPriority;
  private String operationRef;


}