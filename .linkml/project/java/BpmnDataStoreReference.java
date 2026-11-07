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
  A use of a data store at one place in a process.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnDataStoreReference extends BpmnFlowElement {

  private String itemSubjectRef;
  private String dataStoreRef;
  private BpmnDataState dataState;


}