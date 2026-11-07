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
  A variable set in an activity's scope before it starts.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaInputParameter extends BpmnModelElementInstance {

  private String fluxnovaName;
  private Boolean fluxnovaRestricted;
  private Boolean fluxnovaIsTransient;
  private String textContent;


}