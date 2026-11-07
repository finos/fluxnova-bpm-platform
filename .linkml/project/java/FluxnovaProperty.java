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
  One key and value property.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaProperty extends BpmnModelElementInstance {

  private String fluxnovaId;
  private String fluxnovaName;
  private String fluxnovaValue;


}