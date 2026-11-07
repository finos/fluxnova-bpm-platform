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
  A diagram's drawing surface, which holds its shapes and edges.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class DiPlane extends DiNode {

  private List<DiDiagramElement> diagramElements;


}