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
  Root container for Fluxnova BPM Platform data.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaPlatformData  {

  private List<FluxnovaDeployment> deployments;
  private List<FluxnovaProcessDefinition> processDefinitions;
  private List<FluxnovaExecution> executions;
  private List<FluxnovaTask> tasks;
  private List<FluxnovaJob> jobs;
  private List<FluxnovaUser> users;
  private List<FluxnovaGroup> groups;
  private List<FluxnovaBatch> batches;


}