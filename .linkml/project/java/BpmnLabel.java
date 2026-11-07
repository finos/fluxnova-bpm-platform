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
  The label of a BPMN shape or edge, where its text is drawn.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnLabel extends DiLabel {

  private String labelStyle;


}