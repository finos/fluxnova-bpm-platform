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
  The trigger of a pair of events that join two paths of a process like a jump.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnLinkEventDefinition extends BpmnEventDefinition {

  private String name;
  private List<String> bpmnSources;
  private String bpmnTarget;


}