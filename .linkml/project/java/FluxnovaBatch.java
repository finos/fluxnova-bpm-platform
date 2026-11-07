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
  A batch represents a number of jobs which execute a number of commands asynchronously.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaBatch  {

  private String id;
  private String type;
  private Integer totalJobs;
  private Integer jobsCreated;
  private Integer jobsPerSeed;
  private Integer invocationsPerJob;
  private FluxnovaJobDefinition seedJobDefinitionId;
  private FluxnovaJobDefinition batchJobDefinitionId;
  private FluxnovaJobDefinition monitorJobDefinitionId;
  private Integer suspensionState;
  private String configuration;
  private String tenantId;
  private String createUserId;
  private ZonedDateTime startTime;
  private ZonedDateTime executionStartTime;


}