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
  A task that sends a message.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnSendTask extends BpmnTask {

  private String implementation;
  private String messageRef;
  private String operationRef;
  private String fluxnovaClass;
  private String fluxnovaDelegateExpression;
  private String fluxnovaExpression;
  private String fluxnovaResultVariable;
  private String fluxnovaTopic;
  private String fluxnovaType;
  private String fluxnovaTaskPriority;


}