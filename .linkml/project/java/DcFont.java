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
  The font a diagram label is drawn in.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class DcFont extends BpmnModelElementInstance {

  private String name;
  private Double size;
  private Boolean isBold;
  private Boolean isItalic;
  private Boolean isUnderline;
  private Boolean isStrikeThrough;


}