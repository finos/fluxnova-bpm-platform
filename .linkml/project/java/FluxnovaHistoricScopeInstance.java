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
  Abstract base of the historic process, activity, task, case and case activity instances, with the columns all five tables have.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class FluxnovaHistoricScopeInstance  {

  private String id;
  private Integer duration;
  private String tenantId;


}