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
  How a diagram element looks, such as its font or colour.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class DiStyle extends BpmnModelElementInstance {

  private String bpmnId;


}