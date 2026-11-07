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
  A gateway that takes every outgoing flow whose condition holds.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnInclusiveGateway extends BpmnGateway {

  private String default_;


}