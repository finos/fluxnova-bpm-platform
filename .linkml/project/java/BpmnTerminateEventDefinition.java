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
  The trigger of an end event that ends the whole process instance at once.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnTerminateEventDefinition extends BpmnEventDefinition {



}