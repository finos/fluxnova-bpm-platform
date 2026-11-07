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
  A link between an operation's messages and a callable element's input and output sets.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnIoBinding extends BpmnBaseElement {

  private String operationRef;
  private String inputDataRef;
  private String outputDataRef;


}