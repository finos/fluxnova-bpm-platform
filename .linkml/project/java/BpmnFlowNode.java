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
  A flow element that sequence flows connect, such as an activity, event or gateway.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnFlowNode extends BpmnFlowElement {

  private Boolean fluxnovaAsyncAfter;
  private Boolean fluxnovaAsyncBefore;
  private Boolean fluxnovaExclusive;
  private String fluxnovaJobPriority;
  private List<String> incoming;
  private List<String> outgoing;


}