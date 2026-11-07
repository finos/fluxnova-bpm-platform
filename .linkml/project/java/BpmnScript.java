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
  The body of a script task's script.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnScript extends BpmnModelElementInstance {

  private String textContent;


}