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
  A conversation that calls a collaboration or global conversation defined elsewhere.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnCallConversation extends BpmnConversationNode {

  private String calledCollaborationRef;
  private List<BpmnParticipantAssociation> participantAssociations;


}