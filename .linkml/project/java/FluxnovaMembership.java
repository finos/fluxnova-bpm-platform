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
  Association entity in identity and access management.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaMembership  {

  private FluxnovaUser userId;
  private FluxnovaGroup groupId;


}