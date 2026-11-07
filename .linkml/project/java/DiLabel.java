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
  A diagram element that shows text, placed by its bounds.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class DiLabel extends DiNode {

  private DcBounds bounds;


}