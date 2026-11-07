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
  Definition of a decision resource.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaDecisionDefinition extends FluxnovaResourceDefinition {

  private FluxnovaDecisionRequirementsDefinition decisionRequirementsDefinitionId;
  private String decisionRequirementsDefinitionKey;
  private String versionTag;


}