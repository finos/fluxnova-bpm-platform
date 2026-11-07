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
  An event on a process's path that waits for a trigger.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnIntermediateCatchEvent extends BpmnCatchEvent {



}