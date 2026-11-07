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
  A task that waits for a message.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnReceiveTask extends BpmnTask {

  private String implementation;
  private Boolean instantiate;
  private String messageRef;
  private String operationRef;


}