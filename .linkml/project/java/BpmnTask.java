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
  An atomic activity, one that is not broken down further.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnTask extends BpmnActivity {

  private Boolean fluxnovaAsync;


}