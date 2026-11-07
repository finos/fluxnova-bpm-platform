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
  Abstract base for deployable resource definitions (process, case, decision, form).
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class FluxnovaResourceDefinition  {

  private String id;
  private String key;
  private String name;
  private Integer version;
  private String category;
  private String deploymentId;
  private String resourceName;
  private String diagramResourceName;
  private String tenantId;
  private Integer historyTimeToLive;


}