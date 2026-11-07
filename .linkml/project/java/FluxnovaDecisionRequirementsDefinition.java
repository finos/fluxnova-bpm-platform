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
  Container of DecisionDefinitions which belongs to the same decision requirements graph (i.e. DMN resource).
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaDecisionRequirementsDefinition extends FluxnovaResourceDefinition {

  private String category;
  private String name;
  private String diagramResourceName;


}