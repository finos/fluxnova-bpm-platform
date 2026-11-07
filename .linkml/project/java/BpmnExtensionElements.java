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
  The container for an element's extension content, such as Fluxnova's settings.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnExtensionElements extends BpmnModelElementInstance {

  private List<BpmnModelElementInstance> elements;


}