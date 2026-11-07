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
  The text of a text annotation.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnText extends BpmnModelElementInstance {

  private String textContent;


}