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
  The type of data an element holds or a message carries.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnItemDefinition extends BpmnRootElement {

  private String structureRef;
  private Boolean isCollection;
  private String itemKind;


}