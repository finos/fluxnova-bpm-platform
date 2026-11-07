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
  Represents a user, used in IdentityService.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaUser  {

  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String salt;
  private ZonedDateTime lockExpirationTime;
  private Integer attempts;
  private String pictureId;


}