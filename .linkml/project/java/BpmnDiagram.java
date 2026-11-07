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
  A diagram of BPMN elements, with its plane and the label styles it uses.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnDiagram extends DiDiagram {

  private BpmnPlane bpmnPlane;
  private List<BpmnLabelStyle> bpmnLabelStyles;


}