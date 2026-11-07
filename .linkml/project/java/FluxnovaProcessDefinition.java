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
  An object structure representing an executable process composed of activities and transitions.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaProcessDefinition extends FluxnovaResourceDefinition {

  private Boolean hasStartFormKey;
  private Integer suspensionState;
  private String versionTag;
  private boolean isStartable;


}