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
  The expression that decides whether a sequence flow is taken.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnConditionExpression extends BpmnFormalExpression {

  private String xsiType;
  private String fluxnovaResource;


}