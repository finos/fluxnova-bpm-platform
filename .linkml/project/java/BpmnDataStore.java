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
  Data that lasts beyond one process instance, such as a database.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnDataStore extends BpmnRootElement {

  private String name;
  private Integer capacity;
  private Boolean isUnlimited;
  private String itemSubjectRef;
  private BpmnDataState dataState;


}