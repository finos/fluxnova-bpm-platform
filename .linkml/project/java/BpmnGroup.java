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
  An artifact that draws a box around elements of one category value.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnGroup extends BpmnArtifact {

  private String categoryValueRef;


}