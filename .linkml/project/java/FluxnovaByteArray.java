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
  Byte Array entity in the engine infrastructure.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class FluxnovaByteArray  {

  private String id;
  private String name;
  private FluxnovaDeployment deploymentId;
  private String bytes;
  private Boolean isGenerated;
  private String tenantId;
  private Integer type;
  private ZonedDateTime createTime;
  private String rootProcessInstanceId;
  private ZonedDateTime removalTime;


}