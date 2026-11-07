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
  Case Sentry Part entity in the process execution runtime.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaCaseSentryPart  {

  private String id;
  private FluxnovaCaseExecution caseInstanceId;
  private FluxnovaCaseExecution caseExecutionId;
  private String sentryId;
  private String type;
  private String sourceCaseExecutionId;
  private String standardEvent;
  private String source;
  private String variableEvent;
  private String variableName;
  private Boolean isSatisfied;
  private String tenantId;


}