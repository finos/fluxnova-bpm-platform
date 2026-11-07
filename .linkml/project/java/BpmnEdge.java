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
  The line that draws a connecting BPMN element, such as a sequence flow, message flow or association.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnEdge extends DiLabeledEdge {

  private String bpmnElement;
  private String sourceElement;
  private String targetElement;
  private String messageVisibleKind;
  private BpmnLabel bpmnLabel;


}