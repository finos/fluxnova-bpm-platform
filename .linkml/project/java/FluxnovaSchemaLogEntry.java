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
  Schema Log Entry entity in the engine infrastructure.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaSchemaLogEntry  {

  private String id;
  private ZonedDateTime timestamp;
  private String version;


}