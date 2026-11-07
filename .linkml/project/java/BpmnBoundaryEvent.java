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
  An event attached to the boundary of an activity, which can interrupt it.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnBoundaryEvent extends BpmnCatchEvent {

  private Boolean cancelActivity;
  private String attachedToRef;


}