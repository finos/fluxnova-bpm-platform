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
  A link between an artifact, such as a text annotation, and another element.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnAssociation extends BpmnArtifact {

  private String sourceRef;
  private String targetRef;
  private String associationDirection;


}