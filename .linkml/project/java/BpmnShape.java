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
  The figure that draws a BPMN element such as a task, event, gateway, pool or lane.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnShape extends DiLabeledShape {

  private String bpmnElement;
  private Boolean isHorizontal;
  private Boolean isExpanded;
  private Boolean isMarkerVisible;
  private Boolean isMessageVisible;
  private String participantBandKind;
  private String choreographyActivityShape;
  private BpmnLabel bpmnLabel;


}