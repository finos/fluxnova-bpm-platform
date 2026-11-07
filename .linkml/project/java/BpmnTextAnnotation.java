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
  An artifact that adds a note to a diagram.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnTextAnnotation extends BpmnArtifact {

  private String textFormat;
  private BpmnText text;


}