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
  A gateway that takes the path of whichever following event happens first.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnEventBasedGateway extends BpmnGateway {

  private Boolean instantiate;
  private String eventGatewayType;


}