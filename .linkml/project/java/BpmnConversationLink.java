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
  A link between a participant and a conversation node.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnConversationLink extends BpmnBaseElement {

  private String name;
  private String sourceRef;
  private String targetRef;


}