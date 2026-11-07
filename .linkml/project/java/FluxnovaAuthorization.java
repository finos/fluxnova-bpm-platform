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
  An Authorization assigns a set of Permissions to an identity to interact with a given Resource.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaAuthorization  {

  private String id;
  private int type;
  private String groupId;
  private String userId;
  private int resourceType;
  private String resourceId;
  private Integer permissions;
  private ZonedDateTime removalTime;
  private String rootProcessInstanceId;


}