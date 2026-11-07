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
  A connector that a service task or message event calls, with its id and its inputs and outputs.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaConnector extends BpmnModelElementInstance {

  private FluxnovaConnectorId connectorId;
  private FluxnovaInputOutput inputOutput;


}