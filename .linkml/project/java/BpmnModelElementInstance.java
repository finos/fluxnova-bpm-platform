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
  Any element of a BPMN document that Fluxnova's model API reads, the base of every BPMN class here.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnModelElementInstance  {

  private String elementType;


}