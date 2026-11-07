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
  Represents one execution of an activity and it's stored permanent for statistics, audit and other business intelligence purposes.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricActivityInstance extends FluxnovaHistoricScopeInstance {

  private String parentActivityInstanceId;
  private String executionId;
  private String activityId;
  private String taskId;
  private String calledProcessInstanceId;
  private String calledCaseInstanceId;
  private String activityName;
  private String activityType;
  private String assignee;
  private Integer activityInstanceState;
  private Integer sequenceCounter;
  private String tenantId;


}