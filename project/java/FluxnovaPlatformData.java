package None;

/* metamodel_version: 1.11.0 */
/* version: 3.0.0-SNAPSHOT */
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

  private List<Deployment> deployments;
  private List<ProcessDefinition> processDefinitions;
  private List<Execution> executions;
  private List<Task> tasks;
  private List<Job> jobs;
  private List<User> users;
  private List<Group> groups;
  private List<Batch> batches;


}