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
  What triggers an event, such as a message, timer or signal.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnEventDefinition extends BpmnRootElement {



}