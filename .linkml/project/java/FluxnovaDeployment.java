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
  Represents a deployment that is already present in the process repository.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaDeployment  {

  private String id;
  private String name;
  private ZonedDateTime deployTime;
  private String source;
  private String tenantId;


}