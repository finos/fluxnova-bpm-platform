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
  An historic identity link stores the association of a task with a certain identity.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricIdentityLink  {

  private String id;
  private ZonedDateTime timestamp;
  private String type;
  private String userId;
  private String groupId;
  private String taskId;
  private String rootProcessInstanceId;
  private String processDefinitionId;
  private String operationType;
  private String assignerId;
  private String processDefinitionKey;
  private String tenantId;
  private ZonedDateTime removalTime;


}