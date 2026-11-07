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
  A rectangle, by its top-left corner and its size, that places a shape on a diagram.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class DcBounds extends BpmnModelElementInstance {

  private double x;
  private double y;
  private double width;
  private double height;


}