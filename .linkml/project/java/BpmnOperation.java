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
  An operation of an interface, with the messages it takes and returns.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnOperation extends BpmnBaseElement {

  private String name;
  private String implementationRef;
  private String inMessageRef;
  private String outMessageRef;
  private List<String> errorRefs;


}