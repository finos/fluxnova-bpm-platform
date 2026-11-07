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
  A set of data outputs an activity or event produces together.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnOutputSet extends BpmnBaseElement {

  private String name;
  private List<String> dataOutputRefs;
  private List<String> optionalOutputRefs;
  private List<String> whileExecutingOutputRefs;
  private List<String> inputSetRefs;


}