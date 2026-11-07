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
  A sub-process whose inner activities run in no fixed order, as its performers choose.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnAdHocSubProcess extends BpmnSubProcess {

  private String ordering;
  private Boolean cancelRemainingInstances;
  private BpmnCompletionCondition completionCondition;


}