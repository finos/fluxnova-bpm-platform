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
  The base of nearly every BPMN element, giving it an id, documentation and extensions.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnBaseElement extends BpmnModelElementInstance {

  private String bpmnId;
  private List<BpmnDocumentation> bpmnDocumentation;
  private BpmnExtensionElements extensionElements;


}