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
  An event that throws a trigger, such as an end or intermediate throw event.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnThrowEvent extends BpmnEvent {

  private List<BpmnDataInput> dataInputs;
  private List<BpmnDataInputAssociation> dataInputAssociations;
  private BpmnInputSet inputSet;
  private List<BpmnEventDefinition> eventDefinitions;
  private List<String> eventDefinitionRefs;


}