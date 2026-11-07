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
  A script whose result is a value, such as a parameter's or a listener's.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaScript extends BpmnModelElementInstance {

  private String scriptFormat;
  private String bpmnResource;
  private String textContent;


}