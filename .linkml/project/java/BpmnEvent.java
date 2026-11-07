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
  Something that happens while a process runs, such as a start, a message or a timer.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnEvent extends BpmnFlowNode {

  private List<BpmnProperty> properties;


}