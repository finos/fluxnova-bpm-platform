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
  An escalation that an activity can throw and an event can catch.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnEscalation extends BpmnRootElement {

  private String name;
  private String escalationCode;
  private String structureRef;


}