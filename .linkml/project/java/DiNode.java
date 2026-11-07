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
  A diagram element that other elements can connect to.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class DiNode extends DiDiagramElement {



}