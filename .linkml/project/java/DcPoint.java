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
  A point on a diagram, by its x and y coordinates.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class DcPoint extends BpmnModelElementInstance {

  private double x;
  private double y;


}