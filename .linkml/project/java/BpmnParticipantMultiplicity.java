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
  How many instances of a participant take part, from a minimum to a maximum.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnParticipantMultiplicity extends BpmnBaseElement {

  private Integer minimum;
  private Integer maximum;


}