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
  A set of key and value properties on an element.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaProperties extends BpmnModelElementInstance {

  private List<FluxnovaProperty> properties;


}