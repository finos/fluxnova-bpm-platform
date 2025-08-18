/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.finos.flowave.bpm.model.bpmn;

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.ACTIVITI_NS;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.BPMN20_NS;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;
import static org.finos.flowave.bpm.model.bpmn.impl.instance.ProcessImpl.DEFAULT_HISTORY_TIME_TO_LIVE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.finos.flowave.bpm.model.bpmn.builder.ProcessBuilder;
import org.finos.flowave.bpm.model.bpmn.impl.BpmnParser;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ActivationConditionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ActivityImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ArtifactImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.AssignmentImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.AssociationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.AuditingImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.BaseElementImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.BoundaryEventImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.BusinessRuleTaskImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CallActivityImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CallConversationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CallableElementImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CancelEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CatchEventImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CategoryImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CategoryValueImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CategoryValueRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ChildLaneSet;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CollaborationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CompensateEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CompletionConditionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ComplexBehaviorDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ComplexGatewayImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ConditionExpressionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ConditionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ConditionalEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ConversationAssociationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ConversationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ConversationLinkImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ConversationNodeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CorrelationKeyImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CorrelationPropertyBindingImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CorrelationPropertyImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CorrelationPropertyRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CorrelationPropertyRetrievalExpressionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.CorrelationSubscriptionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataAssociationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataInputAssociationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataInputImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataInputRefs;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataObjectImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataObjectReferenceImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataOutputAssociationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataOutputImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataOutputRefs;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataPath;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataStateImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataStoreImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DataStoreReferenceImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DefinitionsImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.DocumentationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.EndEventImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.EndPointImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.EndPointRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ErrorEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ErrorImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ErrorRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.EscalationEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.EscalationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.EventBasedGatewayImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.EventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.EventDefinitionRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.EventImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ExclusiveGatewayImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ExpressionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ExtensionElementsImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ExtensionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.FlowElementImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.FlowNodeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.FlowNodeRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.FormalExpressionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.From;
import org.finos.flowave.bpm.model.bpmn.impl.instance.GatewayImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.GlobalConversationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.GroupImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.HumanPerformerImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ImportImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.InMessageRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.InclusiveGatewayImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.Incoming;
import org.finos.flowave.bpm.model.bpmn.impl.instance.InnerParticipantRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.InputDataItemImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.InputSetImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.InputSetRefs;
import org.finos.flowave.bpm.model.bpmn.impl.instance.InteractionNodeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.InterfaceImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.InterfaceRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.IntermediateCatchEventImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.IntermediateThrowEventImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.IoBindingImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.IoSpecificationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ItemAwareElementImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ItemDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.LaneImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.LaneSetImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.LinkEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.LoopCardinalityImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.LoopCharacteristicsImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.LoopDataInputRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.LoopDataOutputRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ManualTaskImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.MessageEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.MessageFlowAssociationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.MessageFlowImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.MessageFlowRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.MessageImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.MessagePath;
import org.finos.flowave.bpm.model.bpmn.impl.instance.MonitoringImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.MultiInstanceLoopCharacteristicsImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.OperationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.OperationRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.OptionalInputRefs;
import org.finos.flowave.bpm.model.bpmn.impl.instance.OptionalOutputRefs;
import org.finos.flowave.bpm.model.bpmn.impl.instance.OutMessageRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.OuterParticipantRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.Outgoing;
import org.finos.flowave.bpm.model.bpmn.impl.instance.OutputDataItemImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.OutputSetImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.OutputSetRefs;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ParallelGatewayImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ParticipantAssociationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ParticipantImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ParticipantMultiplicityImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ParticipantRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.PartitionElement;
import org.finos.flowave.bpm.model.bpmn.impl.instance.PerformerImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.PotentialOwnerImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ProcessImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.PropertyImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ReceiveTaskImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.RelationshipImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.RenderingImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ResourceAssignmentExpressionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ResourceImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ResourceParameterBindingImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ResourceParameterImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ResourceRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ResourceRoleImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.RootElementImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ScriptImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ScriptTaskImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.SendTaskImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.SequenceFlowImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ServiceTaskImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.SignalEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.SignalImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.Source;
import org.finos.flowave.bpm.model.bpmn.impl.instance.SourceRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.StartEventImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.SubConversationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.SubProcessImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.SupportedInterfaceRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.Supports;
import org.finos.flowave.bpm.model.bpmn.impl.instance.Target;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TargetRef;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TaskImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TerminateEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TextAnnotationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TextImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ThrowEventImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TimeCycleImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TimeDateImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TimeDurationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TimerEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.To;
import org.finos.flowave.bpm.model.bpmn.impl.instance.TransactionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.Transformation;
import org.finos.flowave.bpm.model.bpmn.impl.instance.UserTaskImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.WhileExecutingInputRefs;
import org.finos.flowave.bpm.model.bpmn.impl.instance.WhileExecutingOutputRefs;
import org.finos.flowave.bpm.model.bpmn.impl.instance.bpmndi.BpmnDiagramImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.bpmndi.BpmnEdgeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.bpmndi.BpmnLabelImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.bpmndi.BpmnLabelStyleImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.bpmndi.BpmnPlaneImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.bpmndi.BpmnShapeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveConnectorIdImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveConnectorImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveConstraintImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveEntryImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveErrorEventDefinitionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveExecutionListenerImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveExpressionImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveFailedJobRetryTimeCycleImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveFieldImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveFormDataImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveFormFieldImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveFormPropertyImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveInImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveInputOutputImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveInputParameterImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveListImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveMapImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveOutImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveOutputParameterImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowavePotentialStarterImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowavePropertiesImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowavePropertyImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveScriptImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveStringImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveTaskListenerImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveValidationImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.flowave.FlowaveValueImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.dc.BoundsImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.dc.FontImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.dc.PointImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.DiagramElementImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.DiagramImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.EdgeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.LabelImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.LabeledEdgeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.LabeledShapeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.NodeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.PlaneImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.ShapeImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.StyleImpl;
import org.finos.flowave.bpm.model.bpmn.impl.instance.di.WaypointImpl;
import org.finos.flowave.bpm.model.bpmn.instance.Definitions;
import org.finos.flowave.bpm.model.bpmn.instance.Process;
import org.finos.flowave.bpm.model.bpmn.instance.bpmndi.BpmnDiagram;
import org.finos.flowave.bpm.model.bpmn.instance.bpmndi.BpmnPlane;
import org.finos.flowave.bpm.model.xml.Model;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.ModelException;
import org.finos.flowave.bpm.model.xml.ModelParseException;
import org.finos.flowave.bpm.model.xml.ModelValidationException;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelElementInstanceImpl;
import org.finos.flowave.bpm.model.xml.impl.util.IoUtil;

/**
 * <p>Provides access to the camunda BPMN model api.</p>
 *
 * @author Daniel Meyer
 *
 */
public class Bpmn {

  /** the singleton instance of {@link Bpmn}. If you want to customize the behavior of Bpmn,
   * replace this instance with an instance of a custom subclass of {@link Bpmn}. */
  public static Bpmn INSTANCE = new Bpmn();

  /** the parser used by the Bpmn implementation. */
  private BpmnParser bpmnParser = new BpmnParser();
  private final ModelBuilder bpmnModelBuilder;

  /** The {@link Model}
   */
  private Model bpmnModel;

  /**
   * Allows reading a {@link BpmnModelInstance} from a File.
   *
   * @param file the {@link File} to read the {@link BpmnModelInstance} from
   * @return the model read
   * @throws BpmnModelException if the model cannot be read
   */
  public static BpmnModelInstance readModelFromFile(File file) {
    return INSTANCE.doReadModelFromFile(file);
  }

  /**
   * Allows reading a {@link BpmnModelInstance} from an {@link InputStream}
   *
   * @param stream the {@link InputStream} to read the {@link BpmnModelInstance} from
   * @return the model read
   * @throws ModelParseException if the model cannot be read
   */
  public static BpmnModelInstance readModelFromStream(InputStream stream) {
    return INSTANCE.doReadModelFromInputStream(stream);
  }

  /**
   * Allows writing a {@link BpmnModelInstance} to a File. It will be
   * validated before writing.
   *
   * @param file the {@link File} to write the {@link BpmnModelInstance} to
   * @param modelInstance the {@link BpmnModelInstance} to write
   * @throws BpmnModelException if the model cannot be written
   * @throws ModelValidationException if the model is not valid
   */
  public static void writeModelToFile(File file, BpmnModelInstance modelInstance) {
    INSTANCE.doWriteModelToFile(file, modelInstance);
  }

  /**
   * Allows writing a {@link BpmnModelInstance} to an {@link OutputStream}. It will be
   * validated before writing.
   *
   * @param stream the {@link OutputStream} to write the {@link BpmnModelInstance} to
   * @param modelInstance the {@link BpmnModelInstance} to write
   * @throws ModelException if the model cannot be written
   * @throws ModelValidationException if the model is not valid
   */
  public static void writeModelToStream(OutputStream stream, BpmnModelInstance modelInstance) {
    INSTANCE.doWriteModelToOutputStream(stream, modelInstance);
  }

  /**
   * Allows the conversion of a {@link BpmnModelInstance} to an {@link String}. It will
   * be validated before conversion.
   *
   * @param modelInstance  the model instance to convert
   * @return the XML string representation of the model instance
   */
  public static String convertToString(BpmnModelInstance modelInstance) {
    return INSTANCE.doConvertToString(modelInstance);
  }

  /**
   * Validate model DOM document
   *
   * @param modelInstance the {@link BpmnModelInstance} to validate
   * @throws ModelValidationException if the model is not valid
   */
  public static void validateModel(BpmnModelInstance modelInstance) {
    INSTANCE.doValidateModel(modelInstance);
  }

  /**
   * Allows creating an new, empty {@link BpmnModelInstance}.
   *
   * @return the empty model.
   */
  public static BpmnModelInstance createEmptyModel() {
    return INSTANCE.doCreateEmptyModel();
  }

  public static ProcessBuilder createProcess() {
    BpmnModelInstance modelInstance = INSTANCE.doCreateEmptyModel();
    Definitions definitions = modelInstance.newInstance(Definitions.class);
    definitions.setTargetNamespace(BPMN20_NS);
    definitions.getDomElement().registerNamespace("camunda", CAMUNDA_NS);
    modelInstance.setDefinitions(definitions);
    Process process = modelInstance.newInstance(Process.class);
    definitions.addChildElement(process);

    BpmnDiagram bpmnDiagram = modelInstance.newInstance(BpmnDiagram.class);

    BpmnPlane bpmnPlane = modelInstance.newInstance(BpmnPlane.class);
    bpmnPlane.setBpmnElement(process);

    bpmnDiagram.addChildElement(bpmnPlane);
    definitions.addChildElement(bpmnDiagram);

    return process.builder().flowaveHistoryTimeToLiveString(DEFAULT_HISTORY_TIME_TO_LIVE);
  }

  public static ProcessBuilder createProcess(String processId) {
    return createProcess().id(processId);
  }

  public static ProcessBuilder createExecutableProcess() {
    return createProcess().executable();
  }

  public static ProcessBuilder createExecutableProcess(String processId) {
    return createProcess(processId).executable();
  }


  /**
   * Register known types of the BPMN model
   */
  protected Bpmn() {
    bpmnModelBuilder = ModelBuilder.createInstance("BPMN Model");
    bpmnModelBuilder.alternativeNamespace(ACTIVITI_NS, CAMUNDA_NS);
    doRegisterTypes(bpmnModelBuilder);
    bpmnModel = bpmnModelBuilder.build();
  }

  protected BpmnModelInstance doReadModelFromFile(File file) {
    InputStream is = null;
    try {
      is = new FileInputStream(file);
      return doReadModelFromInputStream(is);

    } catch (FileNotFoundException e) {
      throw new BpmnModelException("Cannot read model from file "+file+": file does not exist.");

    } finally {
      IoUtil.closeSilently(is);

    }
  }

  protected BpmnModelInstance doReadModelFromInputStream(InputStream is) {
    return bpmnParser.parseModelFromStream(is);
  }

  protected void doWriteModelToFile(File file, BpmnModelInstance modelInstance) {
    OutputStream os = null;
    try {
      os = new FileOutputStream(file);
      doWriteModelToOutputStream(os, modelInstance);
    }
    catch (FileNotFoundException e) {
      throw new BpmnModelException("Cannot write model to file "+file+": file does not exist.");
    } finally {
      IoUtil.closeSilently(os);
    }
  }

  protected void doWriteModelToOutputStream(OutputStream os, BpmnModelInstance modelInstance) {
    // validate DOM document
    doValidateModel(modelInstance);
    // write XML
    IoUtil.writeDocumentToOutputStream(modelInstance.getDocument(), os);
  }

  protected String doConvertToString(BpmnModelInstance modelInstance) {
    // validate DOM document
    doValidateModel(modelInstance);
    // convert to XML string
    return IoUtil.convertXmlDocumentToString(modelInstance.getDocument());
  }

  protected void doValidateModel(BpmnModelInstance modelInstance) {
    bpmnParser.validateModel(modelInstance.getDocument());
  }

  protected BpmnModelInstance doCreateEmptyModel() {
    return bpmnParser.getEmptyModel();
  }

  protected void doRegisterTypes(ModelBuilder bpmnModelBuilder) {
    ActivationConditionImpl.registerType(bpmnModelBuilder);
    ActivityImpl.registerType(bpmnModelBuilder);
    ArtifactImpl.registerType(bpmnModelBuilder);
    AssignmentImpl.registerType(bpmnModelBuilder);
    AssociationImpl.registerType(bpmnModelBuilder);
    AuditingImpl.registerType(bpmnModelBuilder);
    BaseElementImpl.registerType(bpmnModelBuilder);
    BoundaryEventImpl.registerType(bpmnModelBuilder);
    BusinessRuleTaskImpl.registerType(bpmnModelBuilder);
    CallableElementImpl.registerType(bpmnModelBuilder);
    CallActivityImpl.registerType(bpmnModelBuilder);
    CallConversationImpl.registerType(bpmnModelBuilder);
    CancelEventDefinitionImpl.registerType(bpmnModelBuilder);
    CatchEventImpl.registerType(bpmnModelBuilder);
    CategoryImpl.registerType(bpmnModelBuilder);
    CategoryValueImpl.registerType(bpmnModelBuilder);
    CategoryValueRef.registerType(bpmnModelBuilder);
    ChildLaneSet.registerType(bpmnModelBuilder);
    CollaborationImpl.registerType(bpmnModelBuilder);
    CompensateEventDefinitionImpl.registerType(bpmnModelBuilder);
    ConditionImpl.registerType(bpmnModelBuilder);
    ConditionalEventDefinitionImpl.registerType(bpmnModelBuilder);
    CompletionConditionImpl.registerType(bpmnModelBuilder);
    ComplexBehaviorDefinitionImpl.registerType(bpmnModelBuilder);
    ComplexGatewayImpl.registerType(bpmnModelBuilder);
    ConditionExpressionImpl.registerType(bpmnModelBuilder);
    ConversationAssociationImpl.registerType(bpmnModelBuilder);
    ConversationImpl.registerType(bpmnModelBuilder);
    ConversationLinkImpl.registerType(bpmnModelBuilder);
    ConversationNodeImpl.registerType(bpmnModelBuilder);
    CorrelationKeyImpl.registerType(bpmnModelBuilder);
    CorrelationPropertyBindingImpl.registerType(bpmnModelBuilder);
    CorrelationPropertyImpl.registerType(bpmnModelBuilder);
    CorrelationPropertyRef.registerType(bpmnModelBuilder);
    CorrelationPropertyRetrievalExpressionImpl.registerType(bpmnModelBuilder);
    CorrelationSubscriptionImpl.registerType(bpmnModelBuilder);
    DataAssociationImpl.registerType(bpmnModelBuilder);
    DataInputAssociationImpl.registerType(bpmnModelBuilder);
    DataInputImpl.registerType(bpmnModelBuilder);
    DataInputRefs.registerType(bpmnModelBuilder);
    DataOutputAssociationImpl.registerType(bpmnModelBuilder);
    DataOutputImpl.registerType(bpmnModelBuilder);
    DataOutputRefs.registerType(bpmnModelBuilder);
    DataPath.registerType(bpmnModelBuilder);
    DataStateImpl.registerType(bpmnModelBuilder);
    DataObjectImpl.registerType(bpmnModelBuilder);
    DataObjectReferenceImpl.registerType(bpmnModelBuilder);
    DataStoreImpl.registerType(bpmnModelBuilder);
    DataStoreReferenceImpl.registerType(bpmnModelBuilder);
    DefinitionsImpl.registerType(bpmnModelBuilder);
    DocumentationImpl.registerType(bpmnModelBuilder);
    EndEventImpl.registerType(bpmnModelBuilder);
    EndPointImpl.registerType(bpmnModelBuilder);
    EndPointRef.registerType(bpmnModelBuilder);
    ErrorEventDefinitionImpl.registerType(bpmnModelBuilder);
    ErrorImpl.registerType(bpmnModelBuilder);
    ErrorRef.registerType(bpmnModelBuilder);
    EscalationImpl.registerType(bpmnModelBuilder);
    EscalationEventDefinitionImpl.registerType(bpmnModelBuilder);
    EventBasedGatewayImpl.registerType(bpmnModelBuilder);
    EventDefinitionImpl.registerType(bpmnModelBuilder);
    EventDefinitionRef.registerType(bpmnModelBuilder);
    EventImpl.registerType(bpmnModelBuilder);
    ExclusiveGatewayImpl.registerType(bpmnModelBuilder);
    ExpressionImpl.registerType(bpmnModelBuilder);
    ExtensionElementsImpl.registerType(bpmnModelBuilder);
    ExtensionImpl.registerType(bpmnModelBuilder);
    FlowElementImpl.registerType(bpmnModelBuilder);
    FlowNodeImpl.registerType(bpmnModelBuilder);
    FlowNodeRef.registerType(bpmnModelBuilder);
    FormalExpressionImpl.registerType(bpmnModelBuilder);
    From.registerType(bpmnModelBuilder);
    GatewayImpl.registerType(bpmnModelBuilder);
    GlobalConversationImpl.registerType(bpmnModelBuilder);
    GroupImpl.registerType(bpmnModelBuilder);
    HumanPerformerImpl.registerType(bpmnModelBuilder);
    ImportImpl.registerType(bpmnModelBuilder);
    InclusiveGatewayImpl.registerType(bpmnModelBuilder);
    Incoming.registerType(bpmnModelBuilder);
    InMessageRef.registerType(bpmnModelBuilder);
    InnerParticipantRef.registerType(bpmnModelBuilder);
    InputDataItemImpl.registerType(bpmnModelBuilder);
    InputSetImpl.registerType(bpmnModelBuilder);
    InputSetRefs.registerType(bpmnModelBuilder);
    InteractionNodeImpl.registerType(bpmnModelBuilder);
    InterfaceImpl.registerType(bpmnModelBuilder);
    InterfaceRef.registerType(bpmnModelBuilder);
    IntermediateCatchEventImpl.registerType(bpmnModelBuilder);
    IntermediateThrowEventImpl.registerType(bpmnModelBuilder);
    IoBindingImpl.registerType(bpmnModelBuilder);
    IoSpecificationImpl.registerType(bpmnModelBuilder);
    ItemAwareElementImpl.registerType(bpmnModelBuilder);
    ItemDefinitionImpl.registerType(bpmnModelBuilder);
    LaneImpl.registerType(bpmnModelBuilder);
    LaneSetImpl.registerType(bpmnModelBuilder);
    LinkEventDefinitionImpl.registerType(bpmnModelBuilder);
    LoopCardinalityImpl.registerType(bpmnModelBuilder);
    LoopCharacteristicsImpl.registerType(bpmnModelBuilder);
    LoopDataInputRef.registerType(bpmnModelBuilder);
    LoopDataOutputRef.registerType(bpmnModelBuilder);
    ManualTaskImpl.registerType(bpmnModelBuilder);
    MessageEventDefinitionImpl.registerType(bpmnModelBuilder);
    MessageFlowAssociationImpl.registerType(bpmnModelBuilder);
    MessageFlowImpl.registerType(bpmnModelBuilder);
    MessageFlowRef.registerType(bpmnModelBuilder);
    MessageImpl.registerType(bpmnModelBuilder);
    MessagePath.registerType(bpmnModelBuilder);
    ModelElementInstanceImpl.registerType(bpmnModelBuilder);
    MonitoringImpl.registerType(bpmnModelBuilder);
    MultiInstanceLoopCharacteristicsImpl.registerType(bpmnModelBuilder);
    OperationImpl.registerType(bpmnModelBuilder);
    OperationRef.registerType(bpmnModelBuilder);
    OptionalInputRefs.registerType(bpmnModelBuilder);
    OptionalOutputRefs.registerType(bpmnModelBuilder);
    OuterParticipantRef.registerType(bpmnModelBuilder);
    OutMessageRef.registerType(bpmnModelBuilder);
    Outgoing.registerType(bpmnModelBuilder);
    OutputDataItemImpl.registerType(bpmnModelBuilder);
    OutputSetImpl.registerType(bpmnModelBuilder);
    OutputSetRefs.registerType(bpmnModelBuilder);
    ParallelGatewayImpl.registerType(bpmnModelBuilder);
    ParticipantAssociationImpl.registerType(bpmnModelBuilder);
    ParticipantImpl.registerType(bpmnModelBuilder);
    ParticipantMultiplicityImpl.registerType(bpmnModelBuilder);
    ParticipantRef.registerType(bpmnModelBuilder);
    PartitionElement.registerType(bpmnModelBuilder);
    PerformerImpl.registerType(bpmnModelBuilder);
    PotentialOwnerImpl.registerType(bpmnModelBuilder);
    ProcessImpl.registerType(bpmnModelBuilder);
    PropertyImpl.registerType(bpmnModelBuilder);
    ReceiveTaskImpl.registerType(bpmnModelBuilder);
    RelationshipImpl.registerType(bpmnModelBuilder);
    RenderingImpl.registerType(bpmnModelBuilder);
    ResourceAssignmentExpressionImpl.registerType(bpmnModelBuilder);
    ResourceImpl.registerType(bpmnModelBuilder);
    ResourceParameterBindingImpl.registerType(bpmnModelBuilder);
    ResourceParameterImpl.registerType(bpmnModelBuilder);
    ResourceRef.registerType(bpmnModelBuilder);
    ResourceRoleImpl.registerType(bpmnModelBuilder);
    RootElementImpl.registerType(bpmnModelBuilder);
    ScriptImpl.registerType(bpmnModelBuilder);
    ScriptTaskImpl.registerType(bpmnModelBuilder);
    SendTaskImpl.registerType(bpmnModelBuilder);
    SequenceFlowImpl.registerType(bpmnModelBuilder);
    ServiceTaskImpl.registerType(bpmnModelBuilder);
    SignalEventDefinitionImpl.registerType(bpmnModelBuilder);
    SignalImpl.registerType(bpmnModelBuilder);
    Source.registerType(bpmnModelBuilder);
    SourceRef.registerType(bpmnModelBuilder);
    StartEventImpl.registerType(bpmnModelBuilder);
    SubConversationImpl.registerType(bpmnModelBuilder);
    SubProcessImpl.registerType(bpmnModelBuilder);
    SupportedInterfaceRef.registerType(bpmnModelBuilder);
    Supports.registerType(bpmnModelBuilder);
    Target.registerType(bpmnModelBuilder);
    TargetRef.registerType(bpmnModelBuilder);
    TaskImpl.registerType(bpmnModelBuilder);
    TerminateEventDefinitionImpl.registerType(bpmnModelBuilder);
    TextImpl.registerType(bpmnModelBuilder);
    TextAnnotationImpl.registerType(bpmnModelBuilder);
    ThrowEventImpl.registerType(bpmnModelBuilder);
    TimeCycleImpl.registerType(bpmnModelBuilder);
    TimeDateImpl.registerType(bpmnModelBuilder);
    TimeDurationImpl.registerType(bpmnModelBuilder);
    TimerEventDefinitionImpl.registerType(bpmnModelBuilder);
    To.registerType(bpmnModelBuilder);
    TransactionImpl.registerType(bpmnModelBuilder);
    Transformation.registerType(bpmnModelBuilder);
    UserTaskImpl.registerType(bpmnModelBuilder);
    WhileExecutingInputRefs.registerType(bpmnModelBuilder);
    WhileExecutingOutputRefs.registerType(bpmnModelBuilder);

    /** DC */
    FontImpl.registerType(bpmnModelBuilder);
    PointImpl.registerType(bpmnModelBuilder);
    BoundsImpl.registerType(bpmnModelBuilder);

    /** DI */
    DiagramImpl.registerType(bpmnModelBuilder);
    DiagramElementImpl.registerType(bpmnModelBuilder);
    EdgeImpl.registerType(bpmnModelBuilder);
    org.finos.flowave.bpm.model.bpmn.impl.instance.di.ExtensionImpl.registerType(bpmnModelBuilder);
    LabelImpl.registerType(bpmnModelBuilder);
    LabeledEdgeImpl.registerType(bpmnModelBuilder);
    LabeledShapeImpl.registerType(bpmnModelBuilder);
    NodeImpl.registerType(bpmnModelBuilder);
    PlaneImpl.registerType(bpmnModelBuilder);
    ShapeImpl.registerType(bpmnModelBuilder);
    StyleImpl.registerType(bpmnModelBuilder);
    WaypointImpl.registerType(bpmnModelBuilder);

    /** BPMNDI */
    BpmnDiagramImpl.registerType(bpmnModelBuilder);
    BpmnEdgeImpl.registerType(bpmnModelBuilder);
    BpmnLabelImpl.registerType(bpmnModelBuilder);
    BpmnLabelStyleImpl.registerType(bpmnModelBuilder);
    BpmnPlaneImpl.registerType(bpmnModelBuilder);
    BpmnShapeImpl.registerType(bpmnModelBuilder);

    /** camunda extensions */
    FlowaveConnectorImpl.registerType(bpmnModelBuilder);
    FlowaveConnectorIdImpl.registerType(bpmnModelBuilder);
    FlowaveConstraintImpl.registerType(bpmnModelBuilder);
    FlowaveEntryImpl.registerType(bpmnModelBuilder);
    FlowaveErrorEventDefinitionImpl.registerType(bpmnModelBuilder);
    FlowaveExecutionListenerImpl.registerType(bpmnModelBuilder);
    FlowaveExpressionImpl.registerType(bpmnModelBuilder);
    FlowaveFailedJobRetryTimeCycleImpl.registerType(bpmnModelBuilder);
    FlowaveFieldImpl.registerType(bpmnModelBuilder);
    FlowaveFormDataImpl.registerType(bpmnModelBuilder);
    FlowaveFormFieldImpl.registerType(bpmnModelBuilder);
    FlowaveFormPropertyImpl.registerType(bpmnModelBuilder);
    FlowaveInImpl.registerType(bpmnModelBuilder);
    FlowaveInputOutputImpl.registerType(bpmnModelBuilder);
    FlowaveInputParameterImpl.registerType(bpmnModelBuilder);
    FlowaveListImpl.registerType(bpmnModelBuilder);
    FlowaveMapImpl.registerType(bpmnModelBuilder);
    FlowaveOutputParameterImpl.registerType(bpmnModelBuilder);
    FlowaveOutImpl.registerType(bpmnModelBuilder);
    FlowavePotentialStarterImpl.registerType(bpmnModelBuilder);
    FlowavePropertiesImpl.registerType(bpmnModelBuilder);
    FlowavePropertyImpl.registerType(bpmnModelBuilder);
    FlowaveScriptImpl.registerType(bpmnModelBuilder);
    FlowaveStringImpl.registerType(bpmnModelBuilder);
    FlowaveTaskListenerImpl.registerType(bpmnModelBuilder);
    FlowaveValidationImpl.registerType(bpmnModelBuilder);
    FlowaveValueImpl.registerType(bpmnModelBuilder);
  }

  /**
   * @return the {@link Model} instance to use
   */
  public Model getBpmnModel() {
    return bpmnModel;
  }

  public ModelBuilder getBpmnModelBuilder() {
    return bpmnModelBuilder;
  }

  /**
   * @param bpmnModel the bpmnModel to set
   */
  public void setBpmnModel(Model bpmnModel) {
    this.bpmnModel = bpmnModel;
  }

}
