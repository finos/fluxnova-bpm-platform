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
  The trigger of an event that sends or receives a signal.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnSignalEventDefinition extends BpmnEventDefinition {

  private String signalRef;
  private Boolean fluxnovaAsync;


}