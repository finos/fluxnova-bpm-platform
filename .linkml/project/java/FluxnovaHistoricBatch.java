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
  Historic representation of a Batch.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaHistoricBatch  {

  private String id;
  private String type;
  private Integer totalJobs;
  private Integer jobsPerSeed;
  private Integer invocationsPerJob;
  private String seedJobDefinitionId;
  private String monitorJobDefinitionId;
  private String batchJobDefinitionId;
  private String tenantId;
  private String createUserId;
  private ZonedDateTime startTime;
  private ZonedDateTime endTime;
  private ZonedDateTime removalTime;
  private ZonedDateTime executionStartTime;


}