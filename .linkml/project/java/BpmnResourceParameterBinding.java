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
  The value a resource role gives a resource parameter.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnResourceParameterBinding extends BpmnBaseElement {

  private String parameterRef;
  private BpmnExpression expression;


}