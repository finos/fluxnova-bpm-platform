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
  The root of a BPMN document, which holds its processes, collaborations and diagrams.
**/
@Data
@EqualsAndHashCode(callSuper=false)
public class BpmnDefinitions extends BpmnModelElementInstance {

  private String bpmnId;
  private String name;
  private String targetNamespace;
  private String expressionLanguage;
  private String typeLanguage;
  private String exporter;
  private String exporterVersion;
  private List<BpmnImport> imports;
  private List<BpmnExtension> extensions;
  private List<BpmnRootElement> rootElements;
  private List<BpmnDiagram> bpmnDiagrams;
  private List<BpmnRelationship> relationships;


}