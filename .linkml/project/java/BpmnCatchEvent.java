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
  An event that waits for a trigger, such as a start or intermediate catch event.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnCatchEvent extends BpmnEvent {

  private Boolean parallelMultiple;
  private List<BpmnDataOutput> dataOutputs;
  private List<BpmnDataOutputAssociation> dataOutputAssociations;
  private BpmnOutputSet outputSet;
  private List<BpmnEventDefinition> eventDefinitions;
  private List<String> eventDefinitionRefs;


}