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
  The state of a data object or data store, such as draft or approved.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnDataState extends BpmnBaseElement {

  private String name;


}