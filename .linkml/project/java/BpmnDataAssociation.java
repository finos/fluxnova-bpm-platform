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
  A copy of data from sources to a target as an activity or event runs.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnDataAssociation extends BpmnBaseElement {

  private List<String> sourceRefs;
  private String targetRef;
  private BpmnTransformation transformation;
  private List<BpmnAssignment> assignments;


}