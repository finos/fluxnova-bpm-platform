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
  The participants of a model and the messages and conversations between them.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnCollaboration extends BpmnRootElement {

  private String name;
  private Boolean isClosed;
  private List<BpmnParticipant> participants;
  private List<BpmnMessageFlow> messageFlows;
  private List<BpmnArtifact> artifacts;
  private List<BpmnConversationNode> conversationNodes;
  private List<BpmnConversationAssociation> conversationAssociations;
  private List<BpmnParticipantAssociation> participantAssociations;
  private List<BpmnMessageFlowAssociation> messageFlowAssociations;
  private List<BpmnCorrelationKey> correlationKeys;
  private List<BpmnConversationLink> conversationLinks;


}