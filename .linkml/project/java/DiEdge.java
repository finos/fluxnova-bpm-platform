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
  A diagram element drawn as a line through waypoints between two elements.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class DiEdge extends DiDiagramElement {

  private List<DiWaypoint> waypoints;


}