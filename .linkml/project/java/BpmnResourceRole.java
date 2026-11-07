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
  The role a resource plays in an activity or process.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnResourceRole extends BpmnBaseElement {

  private String name;
  private String resourceRef;
  private List<BpmnResourceParameterBinding> resourceParameterBindings;
  private BpmnResourceAssignmentExpression resourceAssignmentExpression;


}