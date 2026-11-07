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
  One key and value of a map.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaEntry extends BpmnModelElementInstance {

  private String fluxnovaKey;
  private String textContent;


}