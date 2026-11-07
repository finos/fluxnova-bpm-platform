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
  The constraints of a form field.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaValidation extends BpmnModelElementInstance {

  private List<FluxnovaConstraint> bpmnConstraints;


}