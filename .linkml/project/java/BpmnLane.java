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
  A partition of a process that groups flow nodes, often by who performs them.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnLane extends BpmnBaseElement {

  private String name;
  private String partitionElementRef;
  private BpmnPartitionElement partitionElement;
  private List<String> flowNodeRefs;
  private BpmnChildLaneSet childLaneSet;


}