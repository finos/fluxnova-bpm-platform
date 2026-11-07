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
  User comments that form discussions around tasks.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaComment  {

  private String id;
  private String type;
  private ZonedDateTime eventTime;
  private String userId;
  private String taskId;
  private String rootProcessInstanceId;
  private String processInstanceId;
  private String action;
  private String message;
  private String fullMessage;
  private String tenantId;
  private ZonedDateTime removalTime;


}