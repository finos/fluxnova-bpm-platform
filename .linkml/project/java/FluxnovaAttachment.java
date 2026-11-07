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
  Any type of content that is be associated with a task or with a process instance.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaAttachment  {

  private String id;
  private String userId;
  private String name;
  private String description;
  private String type;
  private String taskId;
  private String rootProcessInstanceId;
  private String processInstanceId;
  private String url;
  private String contentId;
  private String tenantId;
  private ZonedDateTime createTime;
  private ZonedDateTime removalTime;
  private String createdBy;


}