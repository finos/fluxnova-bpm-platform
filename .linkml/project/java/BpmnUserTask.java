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
  A task a person performs with the help of a software application.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnUserTask extends BpmnTask {

  private String implementation;
  private String fluxnovaAssignee;
  private String fluxnovaCandidateGroups;
  private String fluxnovaCandidateUsers;
  private String fluxnovaDueDate;
  private String fluxnovaFollowUpDate;
  private String fluxnovaFormHandlerClass;
  private String fluxnovaFormKey;
  private String fluxnovaFormRef;
  private String fluxnovaFormRefBinding;
  private String fluxnovaFormRefVersion;
  private String fluxnovaPriority;
  private List<BpmnRendering> renderings;


}