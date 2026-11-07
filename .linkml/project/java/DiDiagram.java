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
  A diagram of a model, the root of what Diagram Interchange draws.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class DiDiagram extends BpmnModelElementInstance {

  private String name;
  private String bpmnDocumentation;
  private Double resolution;
  private String bpmnId;


}