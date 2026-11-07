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
  A point where a process's flows split or join.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnGateway extends BpmnFlowNode {

  private String gatewayDirection;


}