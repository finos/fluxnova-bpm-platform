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
  How an activity runs once for each item of a collection, in sequence or in parallel.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnMultiInstanceLoopCharacteristics extends BpmnLoopCharacteristics {

  private Boolean isSequential;
  private String behavior;
  private String oneBehaviorEventRef;
  private String noneBehaviorEventRef;
  private Boolean fluxnovaAsyncAfter;
  private Boolean fluxnovaAsyncBefore;
  private Boolean fluxnovaExclusive;
  private String fluxnovaCollection;
  private String fluxnovaElementVariable;
  private BpmnLoopCardinality loopCardinality;
  private String loopDataInputRef;
  private String loopDataOutputRef;
  private BpmnOutputDataItem outputDataItem;
  private BpmnInputDataItem inputDataItem;
  private List<BpmnComplexBehaviorDefinition> complexBehaviorDefinitions;
  private BpmnCompletionCondition completionCondition;


}