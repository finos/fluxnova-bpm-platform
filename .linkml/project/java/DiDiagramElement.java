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
  Any element drawn on a diagram.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class DiDiagramElement extends BpmnModelElementInstance {

  private String id;
  private DiExtension extension;


}