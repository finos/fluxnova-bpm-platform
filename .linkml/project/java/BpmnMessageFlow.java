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
  The path of a message between two participants.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnMessageFlow extends BpmnBaseElement {

  private String name;
  private String sourceRef;
  private String targetRef;
  private String messageRef;


}