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
  An element that holds data of an item definition, such as a data object or data input.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnItemAwareElement extends BpmnBaseElement {

  private String itemSubjectRef;
  private BpmnDataState dataState;


}