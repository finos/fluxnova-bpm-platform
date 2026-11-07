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
  An element that takes part in the flow of a process, such as an activity or sequence flow.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnFlowElement extends BpmnBaseElement {

  private String name;
  private BpmnAuditing auditing;
  private BpmnMonitoring monitoring;
  private List<String> categoryValueRefs;


}