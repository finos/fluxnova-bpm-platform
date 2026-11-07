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
  What one participant sends another.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnMessage extends BpmnRootElement {

  private String name;
  private String itemRef;


}