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
  A parameter that narrows which resources a resource stands for.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnResourceParameter extends BpmnBaseElement {

  private String name;
  private String type;
  private Boolean isRequired;


}