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
  A sequence of activities, events and gateways that a participant performs.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnProcess extends BpmnCallableElement {

  private String processType;
  private Boolean isClosed;
  private Boolean isExecutable;
  private String fluxnovaCandidateStarterGroups;
  private String fluxnovaCandidateStarterUsers;
  private String fluxnovaJobPriority;
  private String fluxnovaTaskPriority;
  private String fluxnovaHistoryTimeToLive;
  private Boolean fluxnovaIsStartableInTasklist;
  private String fluxnovaVersionTag;
  private BpmnAuditing auditing;
  private BpmnMonitoring monitoring;
  private List<BpmnProperty> properties;
  private List<BpmnLaneSet> laneSets;
  private List<BpmnFlowElement> flowElements;
  private List<BpmnArtifact> artifacts;
  private List<BpmnResourceRole> resourceRoles;
  private List<BpmnCorrelationSubscription> correlationSubscriptions;
  private List<String> supports;


}