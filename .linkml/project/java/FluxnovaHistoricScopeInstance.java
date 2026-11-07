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
  Abstract base for historic entities with start/end time and duration.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class FluxnovaHistoricScopeInstance  {

  private String id;
  private String rootProcessInstanceId;
  private String processInstanceId;
  private String processDefinitionId;
  private String processDefinitionKey;
  private ZonedDateTime startTime;
  private ZonedDateTime endTime;
  private Integer duration;
  private ZonedDateTime removalTime;


}