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
  An informal link between elements of different models.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnRelationship extends BpmnBaseElement {

  private String type;
  private String direction;
  private List<BpmnSource> sources;
  private List<BpmnTarget> targets;


}