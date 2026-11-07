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
  A gateway that splits or joins flows by conditions of its own.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnComplexGateway extends BpmnGateway {

  private String default_;
  private BpmnActivationCondition activationCondition;


}