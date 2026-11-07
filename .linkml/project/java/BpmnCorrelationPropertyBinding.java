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
  The expression that gives a correlation property its value in a process.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnCorrelationPropertyBinding extends BpmnBaseElement {

  private String correlationPropertyRef;
  private BpmnDataPath dataPath;


}