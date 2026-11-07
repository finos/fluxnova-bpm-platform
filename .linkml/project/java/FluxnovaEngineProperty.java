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
  Property entity in the engine infrastructure.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaEngineProperty  {

  private String name;
  private String value;


}