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
  An expression in a stated language, with the type it evaluates to.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnFormalExpression extends BpmnExpression {

  private String language;
  private String evaluatesToTypeRef;


}