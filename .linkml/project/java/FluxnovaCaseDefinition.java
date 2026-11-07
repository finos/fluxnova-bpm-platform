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
  A deployed case definition in the process repository.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaCaseDefinition extends FluxnovaResourceDefinition {

  private String category;
  private String name;
  private String diagramResourceName;
  private Integer historyTimeToLive;


}