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
  A declaration that a document uses an extension, by its definition.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnExtension extends BpmnModelElementInstance {

  private String bpmnDefinition;
  private Boolean mustUnderstand;
  private List<BpmnDocumentation> bpmnDocumentation;


}