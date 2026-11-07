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
  An activity that holds a process of its own.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnSubProcess extends BpmnActivity {

  private Boolean triggeredByEvent;
  private Boolean fluxnovaAsync;
  private List<BpmnLaneSet> laneSets;
  private List<BpmnFlowElement> flowElements;
  private List<BpmnArtifact> artifacts;


}