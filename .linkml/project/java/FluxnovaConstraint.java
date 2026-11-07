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
  A rule a form field's value must meet, such as required or a maximum length.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaConstraint extends BpmnModelElementInstance {

  private String fluxnovaName;
  private String fluxnovaConfig;


}