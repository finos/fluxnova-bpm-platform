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
  An event that starts a process or sub-process.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnStartEvent extends BpmnCatchEvent {

  private Boolean isInterrupting;
  private Boolean fluxnovaAsync;
  private String fluxnovaFormHandlerClass;
  private String fluxnovaFormKey;
  private String fluxnovaFormRef;
  private String fluxnovaFormRefBinding;
  private String fluxnovaFormRefVersion;
  private String fluxnovaInitiator;


}