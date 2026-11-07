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
  One field of a generated form.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaFormField extends BpmnModelElementInstance {

  private String fluxnovaId;
  private String fluxnovaLabel;
  private String fluxnovaType;
  private String fluxnovaDatePattern;
  private String fluxnovaDefaultValue;
  private FluxnovaProperties properties;
  private FluxnovaValidation validation;
  private List<FluxnovaValue> values;


}