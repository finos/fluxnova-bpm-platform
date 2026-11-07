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
  A conversation defined on its own so that collaborations can call it.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnGlobalConversation extends BpmnCollaboration {



}