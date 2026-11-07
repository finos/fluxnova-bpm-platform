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
  A variable passed back from a called process or case.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaOut extends BpmnModelElementInstance {

  private String fluxnovaSource;
  private String fluxnovaSourceExpression;
  private String fluxnovaVariables;
  private String fluxnovaTarget;
  private Boolean fluxnovaLocal;
  private Boolean fluxnovaRestricted;


}