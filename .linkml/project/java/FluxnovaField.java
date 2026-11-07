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
  A value injected into a field of a delegate class, as a string or an expression.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaField extends BpmnModelElementInstance {

  private String fluxnovaName;
  private String fluxnovaExpression;
  private String fluxnovaStringValue;
  private FluxnovaExpression expression;
  private FluxnovaString string;


}