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
  The data inputs and outputs of an activity or process, and their sets.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnIoSpecification extends BpmnBaseElement {

  private List<BpmnDataInput> dataInputs;
  private List<BpmnDataOutput> dataOutputs;
  private List<BpmnInputSet> inputSets;
  private List<BpmnOutputSet> outputSets;


}