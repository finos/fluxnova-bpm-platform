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
  A set of correlation properties that together identify a conversation.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnCorrelationKey extends BpmnBaseElement {

  private String name;
  private List<String> correlationPropertyRefs;


}