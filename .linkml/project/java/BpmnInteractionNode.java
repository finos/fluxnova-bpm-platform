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
  An element a message flow or conversation link can connect, such as a participant, task or event.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnInteractionNode  {

  private String id;


}