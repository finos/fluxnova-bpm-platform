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
  The order of two flow nodes in a process, from a source to a target.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnSequenceFlow extends BpmnFlowElement {

  private String sourceRef;
  private String targetRef;
  private Boolean isImmediate;
  private BpmnConditionExpression conditionExpression;


}