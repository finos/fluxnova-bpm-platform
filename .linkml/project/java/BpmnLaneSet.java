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
  The lanes that divide a process or sub-process.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnLaneSet extends BpmnBaseElement {

  private String name;
  private List<BpmnLane> lanes;


}