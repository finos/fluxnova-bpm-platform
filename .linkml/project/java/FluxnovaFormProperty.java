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
  A form property, the older way of declaring a generated form's fields.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaFormProperty extends BpmnModelElementInstance {

  private String fluxnovaId;
  private String fluxnovaName;
  private String fluxnovaType;
  private Boolean fluxnovaRequired;
  private Boolean fluxnovaReadable;
  private Boolean fluxnovaWriteable;
  private String fluxnovaVariable;
  private String fluxnovaExpression;
  private String fluxnovaDatePattern;
  private String fluxnovaDefault;
  private List<FluxnovaValue> values;


}