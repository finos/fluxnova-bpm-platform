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
  The condition a complex gateway checks to decide when enough incoming flows have arrived to continue.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnActivationCondition extends BpmnExpression {



}