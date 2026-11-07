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
  A link between a message flow and one that refines it.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnMessageFlowAssociation extends BpmnBaseElement {

  private String innerMessageFlowRef;
  private String outerMessageFlowRef;


}