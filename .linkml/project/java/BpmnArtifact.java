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
  An element that adds information to a diagram without changing how the process runs.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnArtifact extends BpmnBaseElement {



}