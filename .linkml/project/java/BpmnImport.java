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
  A document the definitions import elements from.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnImport extends BpmnModelElementInstance {

  private String namespace;
  private String location;
  private String importType;


}