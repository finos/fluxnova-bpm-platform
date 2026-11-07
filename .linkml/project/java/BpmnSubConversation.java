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
  A conversation node that groups other conversation nodes.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnSubConversation extends BpmnConversationNode {

  private List<BpmnConversationNode> conversationNodes;


}