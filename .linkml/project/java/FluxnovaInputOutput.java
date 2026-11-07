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
  The input and output parameters of an activity or connector.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaInputOutput extends BpmnModelElementInstance {

  private List<FluxnovaInputParameter> inputParameters;
  private List<FluxnovaOutputParameter> outputParameters;


}