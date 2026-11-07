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
  Work a process performs, either a task or a sub-process.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BpmnActivity extends BpmnFlowNode {

  private Boolean isForCompensation;
  private Integer startQuantity;
  private Integer completionQuantity;
  private String default_;
  private BpmnIoSpecification ioSpecification;
  private List<BpmnProperty> properties;
  private List<BpmnDataInputAssociation> dataInputAssociations;
  private List<BpmnDataOutputAssociation> dataOutputAssociations;
  private List<BpmnResourceRole> resourceRoles;
  private BpmnLoopCharacteristics loopCharacteristics;


}