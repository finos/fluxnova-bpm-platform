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
  Any node of a conversation diagram, such as a conversation or sub-conversation.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnConversationNode extends BpmnBaseElement {

  private String name;
  private List<String> participantRefs;
  private List<String> messageFlowRefs;
  private List<BpmnCorrelationKey> correlationKeys;


}