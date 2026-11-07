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
  The trigger of an event that throws or catches an error.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnErrorEventDefinition extends BpmnEventDefinition {

  private String errorRef;
  private String fluxnovaErrorCodeVariable;
  private String fluxnovaErrorMessageVariable;


}