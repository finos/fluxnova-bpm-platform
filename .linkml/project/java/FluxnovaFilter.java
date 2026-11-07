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
  Filter entity in the user collaboration.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaFilter  {

  private String id;
  private String resourceType;
  private String name;
  private String owner;
  private String query;
  private String properties;


}