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
  A party in a collaboration, usually drawn as a pool, and the process it runs.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnParticipant extends BpmnBaseElement {

  private String name;
  private String processRef;
  private List<String> interfaceRefs;
  private List<String> endPointRefs;
  private BpmnParticipantMultiplicity participantMultiplicity;


}