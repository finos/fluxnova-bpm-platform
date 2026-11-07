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
  Represents a group, used in IdentityService.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaGroup  {

  private String id;
  private String name;
  private String type;


}