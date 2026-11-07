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
  A link between a participant and one that a called collaboration defines.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnParticipantAssociation extends BpmnBaseElement {

  private String innerParticipantRef;
  private String outerParticipantRef;


}