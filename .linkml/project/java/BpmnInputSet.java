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
  A set of data inputs that is enough for an activity or event to start.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnInputSet extends BpmnBaseElement {

  private String name;
  private List<String> dataInputRefs;
  private List<String> optionalInputRefs;
  private List<String> whileExecutingInputRefs;
  private List<String> outputSetRefs;


}