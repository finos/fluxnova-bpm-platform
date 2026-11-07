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
  Abstract base of the process, case, decision, decision requirements and form definitions, with the columns all five tables have.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class FluxnovaResourceDefinition  {

  private String id;
  private String key;
  private Integer version;
  private String deploymentId;
  private String resourceName;
  private String tenantId;


}