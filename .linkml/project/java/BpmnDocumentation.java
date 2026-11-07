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
  Text that documents an element.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnDocumentation extends BpmnModelElementInstance {

  private String bpmnId;
  private String textFormat;
  private String textContent;


}