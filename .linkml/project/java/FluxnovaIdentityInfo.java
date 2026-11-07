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
  Identity Info entity in the identity and access management.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaIdentityInfo  {

  private String id;
  private String userId;
  private String type;
  private String key;
  private String value;
  private String password;
  private String parentId;


}