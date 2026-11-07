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
  A process configuration entry: a key/value pair which is either global or scoped to a single tenant.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaConfiguration  {

  private String id;
  private String configurationKey;
  private String tenantId;
  private String configurationValue;
  private int version;
  private String status;
  private String createdBy;
  private ZonedDateTime createdAt;
  private String updatedBy;
  private ZonedDateTime updatedAt;


}