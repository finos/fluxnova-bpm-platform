# Fluxnova BPM Platform

LinkML schema for the Fluxnova BPM Platform data model, covering process definitions, runtime execution, jobs, identity, history, and collaboration entities.

URI: https://w3id.org/TD-Universe/fluxnova-bpm-platform

Name: fluxnova_bpm_platform



## Classes

| Class | Description |
| --- | --- |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |
| [Authorization](Authorization.md) | An Authorization assigns a set of Permission Permissions to an identity to in... |
| [Batch](Batch.md) | A batch represents a number of jobs which execute a number of commands asynch... |
| [BpmnModelElementInstance](BpmnModelElementInstance.md) | Interface implemented by all elements in a BPMN Model |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BaseElement](BaseElement.md) | The BPMN baseElement element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Artifact](Artifact.md) | The BPMN artifact element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Association](Association.md) | The BPMN association element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BpmnGroup](BpmnGroup.md) | An artifact that visually groups flow elements without affecting the process ... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[TextAnnotation](TextAnnotation.md) | The BPMN 2 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Assignment](Assignment.md) | The BPMN assignment element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Auditing](Auditing.md) | The BPMN auditing element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CategoryValue](CategoryValue.md) | The BPMN categoryValue element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ComplexBehaviorDefinition](ComplexBehaviorDefinition.md) | Note: Currently not implemented, because both child elements are defined with... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ConversationAssociation](ConversationAssociation.md) | The BPMN conversationAssociation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ConversationLink](ConversationLink.md) | The BPMN conversationLink element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ConversationNode](ConversationNode.md) | The BPMN conversationNode element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CallConversation](CallConversation.md) | The BPMN callConversation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Conversation](Conversation.md) | The BPMN conversation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[SubConversation](SubConversation.md) | The BPMN subConversation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CorrelationKey](CorrelationKey.md) | The BPMN correlationKey element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CorrelationPropertyBinding](CorrelationPropertyBinding.md) | The BPMN correlationPropertyBinding element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CorrelationPropertyRetrievalExpression](CorrelationPropertyRetrievalExpression.md) | The BPMN correlationPropertyRetrievalExpression element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CorrelationSubscription](CorrelationSubscription.md) | The BPMN correlationSubscription element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataAssociation](DataAssociation.md) | The BPMN dataAssociation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataInputAssociation](DataInputAssociation.md) | The BPMN dataInputAssociation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataOutputAssociation](DataOutputAssociation.md) | The BPMN dataOutputAssociation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataState](DataState.md) | The BPMN dataState element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Expression](Expression.md) | The BPMN expression element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ActivationCondition](ActivationCondition.md) | The BPMN element activationCondition of the BPMN tComplexGateway type |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CompletionCondition](CompletionCondition.md) | The BPMN 2 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Condition](Condition.md) | The BPMN condition element of the BPMN tConditionalEventDefinition type |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FormalExpression](FormalExpression.md) | The BPMN formalExpression element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ConditionExpression](ConditionExpression.md) | The BPMN conditionExpression element of the BPMN tSequenceFlow type |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[LoopCardinality](LoopCardinality.md) | The loopCardinality element from the tMultiInstanceLoopCharacteristics comple... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[TimeCycle](TimeCycle.md) | The BPMN timeCycle element of the BPMN tTimerEventDefinition type |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[TimeDate](TimeDate.md) | The BPMN timeDate element of the BPMN tTimerEventDefinition type |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[TimeDuration](TimeDuration.md) | The BPMN timeDuration element of the BPMN tTimerEventDefinition type |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FlowElement](FlowElement.md) | The BPMN flowElement element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataObject](DataObject.md) | The BPMN dataObject element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataObjectReference](DataObjectReference.md) | The BPMN dataObjectReference element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataStoreReference](DataStoreReference.md) | The BPMN dataStoreReference element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FlowNode](FlowNode.md) | The BPMN flowNode element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Activity](Activity.md) | The BPMN activity element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BpmnTask](BpmnTask.md) | The BPMN task element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BusinessRuleTask](BusinessRuleTask.md) | The BPMN businessRuleTask element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ManualTask](ManualTask.md) | The BPMN manualTask element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ReceiveTask](ReceiveTask.md) | The BPMN receiveTask element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ScriptTask](ScriptTask.md) | The BPMN scriptTask element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[SendTask](SendTask.md) | The BPMN sendTask element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ServiceTask](ServiceTask.md) | The BPMN serviceTask element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[UserTask](UserTask.md) | The BPMN userTask element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CallActivity](CallActivity.md) | The BPMN callActivity element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[SubProcess](SubProcess.md) | The BPMN subProcess element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Transaction](Transaction.md) | A sub-process that executes as an atomic unit with compensation support |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Event](Event.md) | The BPMN event element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CatchEvent](CatchEvent.md) | The BPMN catchEvent element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BoundaryEvent](BoundaryEvent.md) | The BPMN boundaryEvent element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[IntermediateCatchEvent](IntermediateCatchEvent.md) | The BPMN intermediateCatchEvent element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[StartEvent](StartEvent.md) | The BPMN startEvent element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ThrowEvent](ThrowEvent.md) | The BPMN throwEvent element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[EndEvent](EndEvent.md) | The BPMN endEvent element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[IntermediateThrowEvent](IntermediateThrowEvent.md) | The BPMN intermediateThrowEvent element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Gateway](Gateway.md) | The BPMN gateway element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ComplexGateway](ComplexGateway.md) | The BPMN complexGateway element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[EventBasedGateway](EventBasedGateway.md) | The BPMN eventBasedGateway element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ExclusiveGateway](ExclusiveGateway.md) | The BPMN exclusiveGateway element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[InclusiveGateway](InclusiveGateway.md) | The BPMN inclusiveGateway element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ParallelGateway](ParallelGateway.md) | The BPMN parallelGateway element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[SequenceFlow](SequenceFlow.md) | The BPMN sequenceFlow element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[InputSet](InputSet.md) | The BPMN inputSet element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[IoBinding](IoBinding.md) | The BPMN ioBinding element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[IoSpecification](IoSpecification.md) | The BPMN inputOutputSpecification element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ItemAwareElement](ItemAwareElement.md) | The BPMN itemAwareElement element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BpmnProperty](BpmnProperty.md) | The BPMN property element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataInput](DataInput.md) | The BPMN dataInput element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[InputDataItem](InputDataItem.md) | The BPMN 2 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataOutput](DataOutput.md) | The BPMN dataOutput element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[OutputDataItem](OutputDataItem.md) | The BPMN 2 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Lane](Lane.md) | The BPMN lane element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[LaneSet](LaneSet.md) | The BPMN laneSet element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[LoopCharacteristics](LoopCharacteristics.md) | The BPMN loopCharacteristics element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[MultiInstanceLoopCharacteristics](MultiInstanceLoopCharacteristics.md) | The BPMN 2 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[MessageFlow](MessageFlow.md) | The BPMN messageFlow element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[MessageFlowAssociation](MessageFlowAssociation.md) | The BPMN messageFlowAssociation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Monitoring](Monitoring.md) | The BPMN monitoring element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Operation](Operation.md) | The BPMN operation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[OutputSet](OutputSet.md) | The BPMN outputSet element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Participant](Participant.md) | The BPMN participant element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ParticipantAssociation](ParticipantAssociation.md) | The BPMN participantAssociation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ParticipantMultiplicity](ParticipantMultiplicity.md) | The BPMN participantMultiplicity element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Relationship](Relationship.md) | The BPMN relationship element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Rendering](Rendering.md) | The BPMN rendering element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ResourceAssignmentExpression](ResourceAssignmentExpression.md) | The BPMN resourceAssignmentExpression element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ResourceParameter](ResourceParameter.md) | The BPMN resourceParameter element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ResourceParameterBinding](ResourceParameterBinding.md) | The BPMN resourceParameterBinding element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ResourceRole](ResourceRole.md) | The BPMN resourceRole element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Performer](Performer.md) | The BPMN performer element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[HumanPerformer](HumanPerformer.md) | The BPMN humanPerformer element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[PotentialOwner](PotentialOwner.md) | The BPMN potentialOwner element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[RootElement](RootElement.md) | The BPMN rootElement element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CallableElement](CallableElement.md) | The BPMN callableElement element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Process](Process.md) | The BPMN process element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Category](Category.md) | A named grouping used to categorise BPMN elements via CategoryValue reference... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Collaboration](Collaboration.md) | The BPMN collaboration element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[GlobalConversation](GlobalConversation.md) | The BPMN globalConversation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CorrelationProperty](CorrelationProperty.md) | The BPMN correlationProperty element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DataStore](DataStore.md) | The BPMN dataStore element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[EndPoint](EndPoint.md) | The BPMN endPoint element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Error](Error.md) | The BPMN error element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Escalation](Escalation.md) | The BPMN escalation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[EventDefinition](EventDefinition.md) | The BPMN eventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CancelEventDefinition](CancelEventDefinition.md) | The BPMN cancelEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CompensateEventDefinition](CompensateEventDefinition.md) | The BPMN compensateEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ConditionalEventDefinition](ConditionalEventDefinition.md) | The BPMN conditionalEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ErrorEventDefinition](ErrorEventDefinition.md) | The BPMN errorEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaErrorEventDefinition](FluxnovaErrorEventDefinition.md) | Fluxnova extension that augments an end event error definition with engine-sp... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[EscalationEventDefinition](EscalationEventDefinition.md) | The BPMN escalationEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[LinkEventDefinition](LinkEventDefinition.md) | The BPMN linkEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[MessageEventDefinition](MessageEventDefinition.md) | The BPMN messageEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[SignalEventDefinition](SignalEventDefinition.md) | The BPMN signalEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[TerminateEventDefinition](TerminateEventDefinition.md) | The BPMN terminateEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[TimerEventDefinition](TimerEventDefinition.md) | The BPMN timerEventDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Interface](Interface.md) | The BPMN interface element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ItemDefinition](ItemDefinition.md) | The BPMN itemDefinition element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Message](Message.md) | The BPMN message element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Resource](Resource.md) | The BPMN resource element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Signal](Signal.md) | The BPMN signal element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Bounds](Bounds.md) | The DC bounds element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Definitions](Definitions.md) | The BPMN definitions element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Diagram](Diagram.md) | The DI Diagram element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BpmnDiagram](BpmnDiagram.md) | The BPMNDI BPMNDiagram element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DiagramElement](DiagramElement.md) | The DI DiagramElement element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Edge](Edge.md) | The DI Edge element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[LabeledEdge](LabeledEdge.md) | The DI LabeledEdge element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BpmnEdge](BpmnEdge.md) | The BPMNDI BPMNEdge element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Node](Node.md) | The DI Node element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Label](Label.md) | The DI Label element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BpmnLabel](BpmnLabel.md) | The BPMNDI BPMNLabel element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Plane](Plane.md) | The DI Plane element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BpmnPlane](BpmnPlane.md) | The BPMNDI BPMNPlane element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Shape](Shape.md) | The DI Shape element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[LabeledShape](LabeledShape.md) | The DI LabeledShape element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BpmnShape](BpmnShape.md) | The BPMNDI BPMNShape element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Documentation](Documentation.md) | The BPMN documentation element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Extension](Extension.md) | The DI extension element of the DI DiagramElement type |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ExtensionElements](ExtensionElements.md) | The BPMN extensionElements element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaConnector](FluxnovaConnector.md) | The BPMN connector camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaConnectorId](FluxnovaConnectorId.md) | The BPMN connectorId camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaConstraint](FluxnovaConstraint.md) | The BPMN constraint camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaEntry](FluxnovaEntry.md) | The BPMN camundaEntry camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaExecutionListener](FluxnovaExecutionListener.md) | The BPMN executionListener camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaExpression](FluxnovaExpression.md) | The BPMN expression camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaFailedJobRetryTimeCycle](FluxnovaFailedJobRetryTimeCycle.md) | The BPMN failedJobRetryTimeCycle camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaField](FluxnovaField.md) | The BPMN field camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaFormData](FluxnovaFormData.md) | The BPMN formData camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaFormField](FluxnovaFormField.md) | The BPMN formField camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaFormProperty](FluxnovaFormProperty.md) | The BPMN formProperty camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaIn](FluxnovaIn.md) | The BPMN in camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaInputOutput](FluxnovaInputOutput.md) | The BPMN inputOutput camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaInputParameter](FluxnovaInputParameter.md) | The BPMN inputParameter camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaList](FluxnovaList.md) | The BPMN camundaList extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaMap](FluxnovaMap.md) | The BPMN camundaMap extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaOut](FluxnovaOut.md) | The BPMN out camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaOutputParameter](FluxnovaOutputParameter.md) | The BPMN outputParameter camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaPotentialStarter](FluxnovaPotentialStarter.md) | The BPMN potentialStarter camunda extension |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaProperties](FluxnovaProperties.md) | The BPMN properties camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaProperty](FluxnovaProperty.md) | The BPMN property camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaScript](FluxnovaScript.md) | The BPMN script camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaString](FluxnovaString.md) | The BPMN string camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaTaskListener](FluxnovaTaskListener.md) | The BPMN taskListener camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaValidation](FluxnovaValidation.md) | The BPMN validation camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FluxnovaValue](FluxnovaValue.md) | The BPMN value camunda extension element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Font](Font.md) | The DC font element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Import](Import.md) | The BPMN Import element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Point](Point.md) | The DC point element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Waypoint](Waypoint.md) | The DI waypoint element of the DI Edge type |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Script](Script.md) | The BPMN script element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Style](Style.md) | The DI Style element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[BpmnLabelStyle](BpmnLabelStyle.md) | The BPMNDI BPMNLabelStyle element |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Text](Text.md) | The BPMN 2 |
| [BpmnModelInstance](BpmnModelInstance.md) | Root container for a parsed BPMN model, providing access to the Definitions e... |
| [BpmnModelType](BpmnModelType.md) | Enumeration-like interface representing the BPMN model type |
| [ByteArray](ByteArray.md) | Byte Array entity in the engine infrastructure |
| [CaseExecution](CaseExecution.md) | Case Execution entity in the process execution runtime |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |
| [Comment](Comment.md) | User comments that form discussions around tasks |
| [Deployment](Deployment.md) | Represents a deployment that is already present in the process repository |
| [EventSubscription](EventSubscription.md) | A message event subscription exists, if an Execution waits for an event like ... |
| [Execution](Execution.md) | Represent a 'path of execution' in a process instance |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |
| [Filter](Filter.md) | Filter entity in the user collaboration |
| [FluxnovaGenericValueElement](FluxnovaGenericValueElement.md) | A helper interface for camunda extension elements which hold a generic child ... |
| [FluxnovaPlatformData](FluxnovaPlatformData.md) | Root container for Fluxnova BPM Platform data |
| [Group](Group.md) | Represents a group, used in IdentityService |
| [HistoricBatch](HistoricBatch.md) | Historic representation of a org |
| [HistoricDecisionInputInstance](HistoricDecisionInputInstance.md) | Represents one input variable of a decision evaluation |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |
| [HistoricDecisionOutputInstance](HistoricDecisionOutputInstance.md) | Represents one output variable of a decision evaluation |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |
| [HistoricScopeInstance](HistoricScopeInstance.md) | Abstract base for historic entities with start/end time and duration |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |
| [HistoricVariableInstance](HistoricVariableInstance.md) | A single process variable containing the last value when its process instance... |
| [IdentityInfo](IdentityInfo.md) | Identity Info entity in the identity and access management |
| [IdentityLink](IdentityLink.md) | An identity link is used to associate a task with a certain identity |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |
| [InteractionNode](InteractionNode.md) | The BPMN interactionNode interface |
| [Job](Job.md) | Represents one job (timer, message, etc |
| [JobDefinition](JobDefinition.md) | A Job Definition provides details about asynchronous background processing ("... |
| [Membership](Membership.md) | Association entity in identity and access management |
| [MeterLog](MeterLog.md) | Meter Log entity in the engine infrastructure |
| [Property](Property.md) | Property entity in the engine infrastructure |
| [ResourceDefinition](ResourceDefinition.md) | Abstract base for deployable resource definitions (process, case, decision, f... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[CaseDefinition](CaseDefinition.md) | A deployed case definition in the process repository |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DecisionDefinition](DecisionDefinition.md) | Definition of a decision resource |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[DecisionRequirementsDefinition](DecisionRequirementsDefinition.md) | Container of DecisionDefinitions which belongs to the same decision requireme... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FormDefinition](FormDefinition.md) | An object structure representing a Camunda Form used to present forms to user... |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ProcessDefinition](ProcessDefinition.md) | An object structure representing an executable process composed of activities... |
| [SchemaLogEntry](SchemaLogEntry.md) | Schema Log Entry entity in the engine infrastructure |
| [Task](Task.md) | Represents one task for a human user |
| [TaskMeterLog](TaskMeterLog.md) | Task Meter Log entity in the engine infrastructure |
| [Tenant](Tenant.md) | Represents a tenant, used in IdentityService |
| [TenantMembership](TenantMembership.md) | Association entity in identity and access management |
| [User](User.md) | Represents a user, used in IdentityService |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |



## Slots

| Slot | Description |
| --- | --- |
| [action](action.md) | The action |
| [activation_condition](activation_condition.md) | Condition that activates this complex gateway |
| [activity](activity.md) | The activity of this element |
| [activity_id](activity_id.md) | BPMN activity element identifier |
| [activity_instance_id](activity_instance_id.md) | Runtime activity instance identifier |
| [activity_instance_state](activity_instance_state.md) | The activity instance state |
| [activity_name](activity_name.md) | The display name for the activity |
| [activity_type](activity_type.md) | The activity type of the activity |
| [annotation](annotation.md) | Annotation of this incident |
| [artifacts](artifacts.md) | Artifacts (text annotations, groups, associations) in this process |
| [assignee](assignee.md) | The userId of the person to which this task is assigned or delegated |
| [assignee_hash](assignee_hash.md) | Hash of the assignee for aggregation |
| [assigner_id](assigner_id.md) | UserId of the user who assigns a task to the user |
| [assignments](assignments.md) | Data assignments (from/to) within this data association |
| [association_direction](association_direction.md) | The association direction of this element |
| [attached_to](attached_to.md) | The activity to which this boundary event is attached |
| [attempts](attempts.md) | Number of failed login attempts |
| [auditing](auditing.md) | Auditing information attached to this flow element |
| [batch_id](batch_id.md) | Reference to a batch |
| [batch_job_definition_id](batch_job_definition_id.md) | Reference to a JobDefinition |
| [batches](batches.md) | Batch operations |
| [behavior](behavior.md) | Behavior governing how completion events are thrown |
| [bold](bold.md) | Whether the font is rendered in bold |
| [bounds](bounds.md) | Bounding rectangle giving position and size of this diagram element |
| [bpm_diagrams](bpm_diagrams.md) | BPMN diagram elements (BPMNDiagram) in the root definitions |
| [bpmn_element](bpmn_element.md) | The BPMN model element this diagram element represents |
| [bpmn_label](bpmn_label.md) | The label element attached to this shape or edge |
| [bpmn_label_styles](bpmn_label_styles.md) | Label style definitions available in this BPMN diagram |
| [bpmn_plane](bpmn_plane.md) | The plane element containing the shapes and edges of this diagram |
| [business_key](business_key.md) | Domain-specific business key |
| [byte_array_id](byte_array_id.md) | Reference to the byte array |
| [bytes](bytes.md) | Serialized binary content |
| [cached_entity_state](cached_entity_state.md) | Bitmask caching associated entity existence |
| [called_case_instance_id](called_case_instance_id.md) | The called case instance in case of (case) call activity |
| [called_collaboration](called_collaboration.md) | The collaboration element called by this call conversation |
| [called_element](called_element.md) | The global task or process called by this call activity |
| [called_process_instance_id](called_process_instance_id.md) | The called process instance in case of call activity |
| [capacity](capacity.md) | Maximum number of items this data store can hold |
| [case_activity_id](case_activity_id.md) | The unique identifier of the case activity in the case |
| [case_activity_name](case_activity_name.md) | The display name for the case activity |
| [case_activity_type](case_activity_type.md) | The display type for the case activity |
| [case_definition_id](case_definition_id.md) | Reference to the case definition |
| [case_definition_key](case_definition_key.md) | Case definition key reference |
| [case_execution_id](case_execution_id.md) | Reference to the case execution |
| [case_instance_id](case_instance_id.md) | Reference to the case instance |
| [category](category.md) | Category classification |
| [category_value_refs](category_value_refs.md) | Category values associated with this flow element |
| [category_values](category_values.md) | Category values contained in this category |
| [cause_incident_id](cause_incident_id.md) | Id of the incident on which this incident has been triggered |
| [child_lane_set](child_lane_set.md) | The child lane set contained within this lane |
| [choreography_activity_shape](choreography_activity_shape.md) | Shape of the associated choreography activity |
| [clause_id](clause_id.md) | The unique identifier of the clause that the value is assigned for |
| [clause_name](clause_name.md) | The name of the clause that the value is assigned for |
| [close_time](close_time.md) | The time the case was closed |
| [closed](closed.md) | Whether closed |
| [collect_result_value](collect_result_value.md) | The result of the collect operation if the hit policy 'collect' was used for ... |
| [collection](collection.md) | Whether collection |
| [completion_condition](completion_condition.md) | Condition that, when true, terminates remaining instances |
| [completion_quantity](completion_quantity.md) | Number of tokens produced when this activity completes |
| [complex_behavior_definitions](complex_behavior_definitions.md) | Rules defining complex multi-instance completion behavior |
| [condition](condition.md) | Condition guard expression |
| [condition_expression](condition_expression.md) | Expression evaluated to decide whether this flow is taken |
| [configuration](configuration.md) | Payload of this incident |
| [content_id](content_id.md) | Reference to the content |
| [conversation_associations](conversation_associations.md) | Associations linking conversation nodes to other elements |
| [conversation_links](conversation_links.md) | TODO: choreographyRef |
| [conversation_nodes](conversation_nodes.md) | Conversation nodes in this collaboration |
| [correlation_key](correlation_key.md) | Correlation key grouping correlation properties |
| [correlation_keys](correlation_keys.md) | Correlation keys used to correlate messages in this collaboration |
| [correlation_properties](correlation_properties.md) | Correlation properties defined in this collaboration |
| [correlation_property](correlation_property.md) | The correlation property this binding is based on |
| [correlation_property_bindings](correlation_property_bindings.md) | Bindings mapping correlation properties to data paths |
| [correlation_property_retrieval_expressions](correlation_property_retrieval_expressions.md) | Retrieval expressions for this correlation property |
| [correlation_subscriptions](correlation_subscriptions.md) | Correlation subscriptions associated with this process |
| [create_time](create_time.md) | Creation timestamp |
| [create_user_id](create_user_id.md) | The authenticated user that created this case instance |
| [created](created.md) | The time this event subscription was created |
| [current_state](current_state.md) | The current state |
| [data_input_associations](data_input_associations.md) | Data associations that feed input data into this activity |
| [data_inputs](data_inputs.md) | Input data elements of this specification |
| [data_object](data_object.md) | The data object that this reference points to |
| [data_output_associations](data_output_associations.md) | Data associations that move output data out of this activity |
| [data_output_refs](data_output_refs.md) | Produced output data references for this output set |
| [data_outputs](data_outputs.md) | Output data elements of this specification |
| [data_path](data_path.md) | XPath expression navigating to the relevant data node |
| [data_state](data_state.md) | Current state of this data object or data store reference |
| [data_store](data_store.md) | The data store that this reference points to |
| [decision_definition_id](decision_definition_id.md) | The decision definition reference |
| [decision_definition_key](decision_definition_key.md) | The unique identifier of the decision definition |
| [decision_definition_name](decision_definition_name.md) | The name of the decision definition |
| [decision_instance_id](decision_instance_id.md) | The unique identifier of the historic decision instance |
| [decision_requirements_definition_id](decision_requirements_definition_id.md) | Id of the related decision requirements definition |
| [decision_requirements_definition_key](decision_requirements_definition_key.md) | Key of the related decision requirements definition |
| [default](default.md) | Default sequence flow taken when no other outgoing condition is satisfied |
| [definitions](definitions.md) | The root BPMN Definitions element of this model |
| [delegation_state](delegation_state.md) | The current DelegationState for this task |
| [delete_reason](delete_reason.md) | Obtains the reason for the process instance's deletion |
| [deploy_time](deploy_time.md) | Timestamp for deploy time |
| [deployment_id](deployment_id.md) | Reference to the deployment |
| [deployments](deployments.md) | Deployed resources |
| [description](description.md) | Human-readable description |
| [diagram_element](diagram_element.md) | The diagram element that visually represents this BPMN element |
| [diagram_elements](diagram_elements.md) | All diagram elements contained within this plane |
| [diagram_resource_name](diagram_resource_name.md) | Name of the diagram resource file |
| [direction](direction.md) | Direction of this relationship |
| [documentation](documentation.md) | Human-readable documentation attached to this element |
| [documentations](documentations.md) | Collection of documentation elements associated with this element |
| [double_value](double_value.md) | Variable value stored as double |
| [due_date](due_date.md) | Due date of the task |
| [duration](duration.md) | Duration in milliseconds |
| [elements](elements.md) | Collection of elements values |
| [elements_query](elements_query.md) | The elements query of this element |
| [email](email.md) | Email address |
| [end_activity_id](end_activity_id.md) | Reference to the end activity |
| [end_points](end_points.md) | Endpoints associated with this process or service |
| [end_time](end_time.md) | End timestamp |
| [entity_type](entity_type.md) | The type of the entity on which this operation was executed |
| [error](error.md) | The error of this element |
| [error_code](error_code.md) | The error code identifying this error |
| [error_details_id](error_details_id.md) | Reference to a ByteArray |
| [error_message](error_message.md) | If the variable value could not be loaded, this returns the error message |
| [errors](errors.md) | Collection of error elements associated with this element |
| [escalation](escalation.md) | The escalation of this element |
| [escalation_code](escalation_code.md) | The escalation code identifying this escalation |
| [evaluates_to_type](evaluates_to_type.md) | The evaluates to type of this element |
| [evaluation_time](evaluation_time.md) | Time when the decision was evaluated |
| [event_definition_refs](event_definition_refs.md) | Collection of event definition elements associated with this element |
| [event_definitions](event_definitions.md) | Event definitions that specify the event trigger type |
| [event_gateway_type](event_gateway_type.md) | The event gateway type of this element |
| [event_name](event_name.md) | The name of the event this subscription belongs to as defined in the process ... |
| [event_time](event_time.md) | Timestamp for event time |
| [event_type](event_type.md) | The event subscriptions type |
| [exception_message](exception_message.md) | Message of the exception that occurred, the last time the job was executed |
| [exception_stack_id](exception_stack_id.md) | Reference to a ByteArray |
| [executable](executable.md) | Whether executable |
| [execution_id](execution_id.md) | Reference to the execution |
| [execution_start_time](execution_start_time.md) | Timestamp when this started |
| [executions](executions.md) | Process execution instances |
| [expanded](expanded.md) | Whether this sub-process shape is shown in expanded form |
| [exporter](exporter.md) | Name of the tool that exported this BPMN document |
| [exporter_version](exporter_version.md) | Version of the exporting tool |
| [expression](expression.md) | The expression of this element |
| [expression_language](expression_language.md) | Default expression language used in this definitions element |
| [extension](extension.md) | Extension element containing additional diagram information |
| [extension_elements](extension_elements.md) | Extension elements holding vendor-specific metadata |
| [extensions](extensions.md) | Extension elements attached to this definitions element |
| [external_task_id](external_task_id.md) | Id of the associated external task |
| [failed_activity_id](failed_activity_id.md) | Id of the activity on which the last exception occurred |
| [first_name](first_name.md) | First name |
| [flow_elements](flow_elements.md) | Flow elements (tasks, gateways, events, sequence flows) in this process |
| [flow_node_refs](flow_node_refs.md) | Flow nodes allocated to this lane |
| [fluxnova_assignee](fluxnova_assignee.md) | Camunda extensions |
| [fluxnova_async](fluxnova_async.md) | Camunda extensions */ /** |
| [fluxnova_async_after](fluxnova_async_after.md) | Whether this element is executed asynchronously after its end |
| [fluxnova_async_before](fluxnova_async_before.md) | Whether this element is executed asynchronously before its start |
| [fluxnova_business_key](fluxnova_business_key.md) | Fluxnova extension property: business key |
| [fluxnova_called_element_binding](fluxnova_called_element_binding.md) | Fluxnova extension property: called element binding |
| [fluxnova_called_element_tenant_id](fluxnova_called_element_tenant_id.md) | Fluxnova extension property: called element tenant id |
| [fluxnova_called_element_version](fluxnova_called_element_version.md) | Fluxnova extension property: called element version |
| [fluxnova_called_element_version_tag](fluxnova_called_element_version_tag.md) | Fluxnova extension property: called element version tag |
| [fluxnova_candidate_groups](fluxnova_candidate_groups.md) | Fluxnova extension property: candidate groups |
| [fluxnova_candidate_groups_list](fluxnova_candidate_groups_list.md) | Fluxnova extension property: candidate groups list |
| [fluxnova_candidate_starter_groups](fluxnova_candidate_starter_groups.md) | Camunda extensions |
| [fluxnova_candidate_starter_groups_list](fluxnova_candidate_starter_groups_list.md) | Fluxnova extension property: candidate starter groups list |
| [fluxnova_candidate_starter_users](fluxnova_candidate_starter_users.md) | Fluxnova extension property: candidate starter users |
| [fluxnova_candidate_starter_users_list](fluxnova_candidate_starter_users_list.md) | Fluxnova extension property: candidate starter users list |
| [fluxnova_candidate_users](fluxnova_candidate_users.md) | Fluxnova extension property: candidate users |
| [fluxnova_candidate_users_list](fluxnova_candidate_users_list.md) | Fluxnova extension property: candidate users list |
| [fluxnova_case_binding](fluxnova_case_binding.md) | Fluxnova extension property: case binding |
| [fluxnova_case_ref](fluxnova_case_ref.md) | Fluxnova extension property: case ref |
| [fluxnova_case_tenant_id](fluxnova_case_tenant_id.md) | Fluxnova extension property: case tenant id |
| [fluxnova_case_version](fluxnova_case_version.md) | Fluxnova extension property: case version |
| [fluxnova_class](fluxnova_class.md) | Camunda extensions |
| [fluxnova_collection](fluxnova_collection.md) | Fluxnova extension property: collection |
| [fluxnova_config](fluxnova_config.md) | Fluxnova extension property: config |
| [fluxnova_connector_id](fluxnova_connector_id.md) | The unique identifier of this connector configuration |
| [fluxnova_constraints](fluxnova_constraints.md) | Validation constraints for this form field |
| [fluxnova_date_pattern](fluxnova_date_pattern.md) | Date pattern for date-typed form fields |
| [fluxnova_decision_ref](fluxnova_decision_ref.md) | Fluxnova extension property: decision ref |
| [fluxnova_decision_ref_binding](fluxnova_decision_ref_binding.md) | Fluxnova extension property: decision ref binding |
| [fluxnova_decision_ref_tenant_id](fluxnova_decision_ref_tenant_id.md) | Fluxnova extension property: decision ref tenant id |
| [fluxnova_decision_ref_version](fluxnova_decision_ref_version.md) | Fluxnova extension property: decision ref version |
| [fluxnova_decision_ref_version_tag](fluxnova_decision_ref_version_tag.md) | Fluxnova extension property: decision ref version tag |
| [fluxnova_default](fluxnova_default.md) | Fluxnova extension property: default |
| [fluxnova_default_value](fluxnova_default_value.md) | Default value for this form field |
| [fluxnova_delegate_expression](fluxnova_delegate_expression.md) | Expression resolving to a JavaDelegate |
| [fluxnova_due_date](fluxnova_due_date.md) | Fluxnova extension property: due date |
| [fluxnova_element_variable](fluxnova_element_variable.md) | Fluxnova extension property: element variable |
| [fluxnova_entries](fluxnova_entries.md) | Key-value entries in this Fluxnova map |
| [fluxnova_error_code_variable](fluxnova_error_code_variable.md) | Process variable to receive the error code |
| [fluxnova_error_message](fluxnova_error_message.md) | Fluxnova extension property: error message |
| [fluxnova_error_message_variable](fluxnova_error_message_variable.md) | Process variable to receive the error message |
| [fluxnova_event](fluxnova_event.md) | Event that triggers this execution listener |
| [fluxnova_exclusive](fluxnova_exclusive.md) | Whether this element participates in an exclusive job execution |
| [fluxnova_expression](fluxnova_expression.md) | EL expression for this element |
| [fluxnova_expression_child](fluxnova_expression_child.md) | Fluxnova extension property: expression child |
| [fluxnova_fields](fluxnova_fields.md) | Field elements of this connector or form |
| [fluxnova_follow_up_date](fluxnova_follow_up_date.md) | Fluxnova extension property: follow up date |
| [fluxnova_form_fields](fluxnova_form_fields.md) | Form fields defined in this form data |
| [fluxnova_form_handler_class](fluxnova_form_handler_class.md) | Fluxnova extension property: form handler class |
| [fluxnova_form_key](fluxnova_form_key.md) | Fluxnova extension property: form key |
| [fluxnova_form_ref](fluxnova_form_ref.md) | Fluxnova extension property: form ref |
| [fluxnova_form_ref_binding](fluxnova_form_ref_binding.md) | Fluxnova extension property: form ref binding |
| [fluxnova_form_ref_version](fluxnova_form_ref_version.md) | Fluxnova extension property: form ref version |
| [fluxnova_history_time_to_live](fluxnova_history_time_to_live.md) | Fluxnova extension property: history time to live |
| [fluxnova_history_time_to_live_string](fluxnova_history_time_to_live_string.md) | Fluxnova extension property: history time to live string |
| [fluxnova_id](fluxnova_id.md) | Identifier for this Fluxnova extension element |
| [fluxnova_initiator](fluxnova_initiator.md) | Fluxnova extension property: initiator |
| [fluxnova_input_output](fluxnova_input_output.md) | Input/output parameter container for this connector |
| [fluxnova_input_parameters](fluxnova_input_parameters.md) | Input parameters passed to this connector or script |
| [fluxnova_job_priority](fluxnova_job_priority.md) | Priority assigned to async continuation jobs for this element |
| [fluxnova_key](fluxnova_key.md) | Fluxnova extension property: key |
| [fluxnova_label](fluxnova_label.md) | Display label for this form field |
| [fluxnova_local](fluxnova_local.md) | Fluxnova extension property: local |
| [fluxnova_map_decision_result](fluxnova_map_decision_result.md) | Fluxnova extension property: map decision result |
| [fluxnova_name](fluxnova_name.md) | Name attribute of this Fluxnova extension element |
| [fluxnova_output_parameters](fluxnova_output_parameters.md) | Output parameters produced by this connector or script |
| [fluxnova_priority](fluxnova_priority.md) | Fluxnova extension property: priority |
| [fluxnova_properties](fluxnova_properties.md) | Fluxnova extension properties container |
| [fluxnova_readable](fluxnova_readable.md) | Fluxnova extension property: readable |
| [fluxnova_required](fluxnova_required.md) | Fluxnova extension property: required |
| [fluxnova_resource](fluxnova_resource.md) | Camunda extensions |
| [fluxnova_result_variable](fluxnova_result_variable.md) | Process variable to store the expression result |
| [fluxnova_script](fluxnova_script.md) | Inline script for this element |
| [fluxnova_script_format](fluxnova_script_format.md) | Fluxnova extension property: script format |
| [fluxnova_source](fluxnova_source.md) | Fluxnova extension property: source |
| [fluxnova_source_expression](fluxnova_source_expression.md) | Fluxnova extension property: source expression |
| [fluxnova_startable_in_tasklist](fluxnova_startable_in_tasklist.md) | Fluxnova extension property: startable in tasklist |
| [fluxnova_string](fluxnova_string.md) | Inline string value |
| [fluxnova_string_value](fluxnova_string_value.md) | Fluxnova extension property: string value |
| [fluxnova_target](fluxnova_target.md) | Fluxnova extension property: target |
| [fluxnova_task_priority](fluxnova_task_priority.md) | Fluxnova extension property: task priority |
| [fluxnova_topic](fluxnova_topic.md) | External task topic name |
| [fluxnova_type](fluxnova_type.md) | Type name for this form field or listener |
| [fluxnova_validation](fluxnova_validation.md) | Validation rules for this form field |
| [fluxnova_value](fluxnova_value.md) | Value of this Fluxnova extension element |
| [fluxnova_values](fluxnova_values.md) | Permissible value options for this form field |
| [fluxnova_variable](fluxnova_variable.md) | Fluxnova extension property: variable |
| [fluxnova_variable_events](fluxnova_variable_events.md) | Fluxnova extension property: variable events |
| [fluxnova_variable_events_list](fluxnova_variable_events_list.md) | Fluxnova extension property: variable events list |
| [fluxnova_variable_mapping_class](fluxnova_variable_mapping_class.md) | Fluxnova extension property: variable mapping class |
| [fluxnova_variable_mapping_delegate_expression](fluxnova_variable_mapping_delegate_expression.md) | Fluxnova extension property: variable mapping delegate expression |
| [fluxnova_variable_name](fluxnova_variable_name.md) | Fluxnova extension property: variable name |
| [fluxnova_variables](fluxnova_variables.md) | Fluxnova extension property: variables |
| [fluxnova_version_tag](fluxnova_version_tag.md) | Fluxnova extension property: version tag |
| [fluxnova_writeable](fluxnova_writeable.md) | Fluxnova extension property: writeable |
| [follow_up_date](follow_up_date.md) | Follow-up date of the task |
| [font](font.md) | The font of this element |
| [for_compensation](for_compensation.md) | Whether this activity is used for compensation handling |
| [from_](from_.md) | The source expression of this assignment |
| [full_message](full_message.md) | The full comment message the user had related to the task and/or process inst... |
| [gateway_direction](gateway_direction.md) | Convergence/divergence direction of token routing through this gateway |
| [group_id](group_id.md) | Reference to a group |
| [groups](groups.md) | Identity groups |
| [handler_configuration](handler_configuration.md) | Configuration for the handler |
| [handler_type](handler_type.md) | Type of handler that processes this entity |
| [has_start_form_key](has_start_form_key.md) | The has start form key |
| [height](height.md) | Height of this element's bounding rectangle |
| [history_configuration](history_configuration.md) | History payload of this incident |
| [history_time_to_live](history_time_to_live.md) | Days to retain history before cleanup |
| [horizontal](horizontal.md) | Whether this pool or lane is oriented horizontally |
| [hostname](hostname.md) | Name of the host where the Process Engine that added this job log runs |
| [id](id.md) | Unique identifier |
| [immediate](immediate.md) | Whether immediate |
| [implementation](implementation.md) | Implementation technology of this service or send/receive task |
| [implementation_ref](implementation_ref.md) | The implementation ref of this element |
| [import_type](import_type.md) | The import type of this element |
| [imports](imports.md) | Import declarations referencing external definitions |
| [in_message](in_message.md) | The in message of this element |
| [incident_message](incident_message.md) | Incident message |
| [incident_state](incident_state.md) | The incident state |
| [incident_timestamp](incident_timestamp.md) | Time when the incident happened |
| [incident_type](incident_type.md) | Type of this incident to identify the kind of incident |
| [incoming](incoming.md) | Sequence flows entering this flow node |
| [inner_conversation_node](inner_conversation_node.md) | The inner conversation node of this element |
| [inner_message_flow](inner_message_flow.md) | The inner message flow of this element |
| [inner_participant](inner_participant.md) | The inner participant of this element |
| [input_data](input_data.md) | The input data of this element |
| [input_data_item](input_data_item.md) | Loop input data item variable |
| [input_set](input_set.md) | The input set associated with this input data |
| [input_set_refs](input_set_refs.md) | Collection of input set elements associated with this element |
| [input_sets](input_sets.md) | Input sets grouping required input data |
| [instantiate](instantiate.md) | Whether receiving this message creates a new process instance |
| [interfaces](interfaces.md) | Collection of interface elements associated with this element |
| [interrupting](interrupting.md) | Whether this start event interrupts the parent sub-process |
| [invocations_per_job](invocations_per_job.md) | The invocations per job |
| [io_bindings](io_bindings.md) | Collection of io binding elements associated with this element |
| [io_specification](io_specification.md) | Input and output specification of this activity |
| [is_active](is_active.md) | Whether this entity is active |
| [is_concurrent](is_concurrent.md) | Whether this entity is concurrent |
| [is_concurrent_local](is_concurrent_local.md) | Whether this entity is concurrent local |
| [is_event_scope](is_event_scope.md) | Whether this entity is event scope |
| [is_exclusive](is_exclusive.md) | Whether this entity is exclusive |
| [is_generated](is_generated.md) | Whether this entity is generated |
| [is_initial](is_initial.md) | Whether this entity is initial |
| [is_required](is_required.md) | Whether this entity is required |
| [is_satisfied](is_satisfied.md) | Whether this entity is satisfied |
| [is_scope](is_scope.md) | Whether this entity is scope |
| [is_startable](is_startable.md) | Whether this entity is startable |
| [italic](italic.md) | Whether the font is rendered in italic |
| [item](item.md) | The item of this element |
| [item_kind](item_kind.md) | The item kind of this element |
| [item_subject](item_subject.md) | The item subject of this element |
| [job_configuration](job_configuration.md) | The configuration of a job definition provides details about the jobs which w... |
| [job_definition_configuration](job_definition_configuration.md) | Job definition configuration type of the associated job |
| [job_definition_id](job_definition_id.md) | Reference to the job definition |
| [job_definition_type](job_definition_type.md) | Job definition type of the associated job |
| [job_due_date](job_due_date.md) | Due date of the associated job when this log occurred |
| [job_exception_message](job_exception_message.md) | Message of the exception that occurred by executing the associated job |
| [job_exception_stack_id](job_exception_stack_id.md) | Reference to the job exception stack |
| [job_id](job_id.md) | Id of the associated job |
| [job_priority](job_priority.md) | Priority of the associated job when this log entry was created |
| [job_retries](job_retries.md) | Retries of the associated job before the associated job has been executed and... |
| [job_state](job_state.md) | The job state |
| [job_type](job_type.md) | The Type of a job |
| [jobs](jobs.md) | Asynchronous jobs |
| [jobs_created](jobs_created.md) | The jobs created |
| [jobs_per_seed](jobs_per_seed.md) | The jobs per seed |
| [key](key.md) | Business key for the definition |
| [label_style](label_style.md) | The label style of this element |
| [lane_sets](lane_sets.md) | Lane sets partitioning this process into swimlanes |
| [lanes](lanes.md) | Sub-lanes contained in this lane |
| [language](language.md) | The language of this element |
| [last_failure_log_id](last_failure_log_id.md) | Reference to the last failure log |
| [last_name](last_name.md) | Last name |
| [last_updated](last_updated.md) | The date/time when this task was last updated |
| [location](location.md) | The location of this element |
| [lock_expiration_time](lock_expiration_time.md) | Time at which the lock expires |
| [lock_owner](lock_owner.md) | Identifier of the node that acquired the lock |
| [long_value](long_value.md) | Variable value stored as long |
| [loop_cardinality](loop_cardinality.md) | Expression evaluating to the number of loop iterations |
| [loop_characteristics](loop_characteristics.md) | Loop or multi-instance characteristics of this activity |
| [loop_data_input_ref](loop_data_input_ref.md) | The loop data input ref of this element |
| [loop_data_output_ref](loop_data_output_ref.md) | The loop data output ref of this element |
| [marker_visible](marker_visible.md) | Whether the loop or multi-instance marker is displayed |
| [maximum](maximum.md) | Maximum number of instances for this participant multiplicity |
| [message](message.md) | Short message or summary |
| [message_flow_associations](message_flow_associations.md) | Associations between message flows |
| [message_flows](message_flows.md) | Message flows between participants in this collaboration |
| [message_path](message_path.md) | The message path of this element |
| [message_visible](message_visible.md) | Whether the message flow envelope icon is visible |
| [message_visible_kind](message_visible_kind.md) | Visibility kind of the message flow in this edge |
| [method](method.md) | The method of this element |
| [milliseconds](milliseconds.md) | The milliseconds |
| [minimum](minimum.md) | Minimum number of instances for this participant multiplicity |
| [monitor_job_definition_id](monitor_job_definition_id.md) | Reference to a JobDefinition |
| [monitoring](monitoring.md) | Monitoring information attached to this flow element |
| [name](name.md) | Human-readable name |
| [namespace](namespace.md) | The namespace of this element |
| [new_value](new_value.md) | The new value of the property |
| [none_behavior_event_ref](none_behavior_event_ref.md) | The none behavior event ref of this element |
| [one_behavior_event_ref](one_behavior_event_ref.md) | The one behavior event ref of this element |
| [operation](operation.md) | The operation of this element |
| [operation_id](operation_id.md) | The unique identifier of this operation |
| [operation_type](operation_type.md) | Type of identity link history (add or delete identity link) |
| [operations](operations.md) | Operations defined by this interface |
| [optional_inputs](optional_inputs.md) | Collection of data input elements associated with this element |
| [optional_output_refs](optional_output_refs.md) | Output data that may or may not be produced |
| [original_value](original_value.md) | The original value |
| [out_message](out_message.md) | The out message of this element |
| [outer_conversation_node](outer_conversation_node.md) | The outer conversation node of this element |
| [outer_message_flow](outer_message_flow.md) | The outer message flow of this element |
| [outer_participant](outer_participant.md) | The outer participant of this element |
| [outgoing](outgoing.md) | Sequence flows leaving this flow node |
| [output_data](output_data.md) | The output data of this element |
| [output_data_item](output_data_item.md) | Loop output data item variable |
| [output_set](output_set.md) | The output set associated with this output data |
| [output_sets](output_sets.md) | Output sets grouping produced output data |
| [owner](owner.md) | The userId of the person that is responsible for this task |
| [parallel_multiple](parallel_multiple.md) | Whether all event triggers must occur (parallel) rather than any one |
| [parameter](parameter.md) | The parameter of this element |
| [parent_activity_instance_id](parent_activity_instance_id.md) | Id of the parent activity instance |
| [parent_id](parent_id.md) | Reference to a CaseExecution |
| [parent_task_id](parent_task_id.md) | The parent task for which this task is a subtask |
| [participant_associations](participant_associations.md) | Associations between participants |
| [participant_band_kind](participant_band_kind.md) | Indicates the initiating/non-initiating role of this participant band |
| [participant_multiplicity](participant_multiplicity.md) | Multiplicity configuration of this participant |
| [participants](participants.md) | Participants (pools) in this collaboration |
| [partition_element](partition_element.md) | The partitioning element (e |
| [partition_element_child](partition_element_child.md) | The partition element child of this element |
| [password](password.md) | Hashed password |
| [permissions](permissions.md) | Bitmask of granted permissions |
| [picture_id](picture_id.md) | Reference to the picture |
| [previous_nodes](previous_nodes.md) | The previous nodes of this element |
| [previous_state](previous_state.md) | The previous state |
| [priority](priority.md) | Indication of how important/urgent this task is with a number between 0 and 1... |
| [process](process.md) | The process of this element |
| [process_definition_id](process_definition_id.md) | Reference to the process definition |
| [process_definition_key](process_definition_key.md) | Key of the process definition |
| [process_definitions](process_definitions.md) | Process definitions |
| [process_instance_id](process_instance_id.md) | Reference to the process instance |
| [process_type](process_type.md) | Whether this process is a public, private, or collaboration process |
| [properties](properties.md) | Serialized properties |
| [property](property.md) | The property changed by this operation |
| [query](query.md) | Serialized query expression |
| [relationships](relationships.md) | Informal relationships between elements in this model |
| [removal_time](removal_time.md) | Timestamp when this entity is eligible for removal |
| [renderings](renderings.md) | Rendering hints for this event |
| [repeat](repeat.md) | Repeat/recurrence expression (ISO 8601) |
| [repeat_offset](repeat_offset.md) | Offset applied to repeat interval calculation |
| [reporter](reporter.md) | Identifier of the reporting node |
| [required](required.md) | Whether required |
| [resolution](resolution.md) | The resolution of this element |
| [resource](resource.md) | The resource of this element |
| [resource_assignment_expression](resource_assignment_expression.md) | Expression used to resolve the assigned resource |
| [resource_id](resource_id.md) | Reference to the resource |
| [resource_name](resource_name.md) | Name of the deployed resource file |
| [resource_parameter_binding](resource_parameter_binding.md) | Collection of resource parameter binding elements associated with this elemen... |
| [resource_parameters](resource_parameters.md) | Parameters defined on this resource |
| [resource_roles](resource_roles.md) | Resources (performers, potential owners) assigned to this activity |
| [resource_type](resource_type.md) | Numeric type of the authorized resource |
| [restarted_process_instance_id](restarted_process_instance_id.md) | The id of the original process instance which was restarted |
| [retries](retries.md) | Number of retries this job has left |
| [root_cause_incident_id](root_cause_incident_id.md) | Id of the root incident on which this transitive incident has been triggered |
| [root_decision_instance_id](root_decision_instance_id.md) | The unique identifier of the historic decision instance of the evaluated root... |
| [root_elements](root_elements.md) | Top-level elements (processes, messages, signals, etc |
| [root_process_instance_id](root_process_instance_id.md) | Root process instance for history cleanup |
| [rule_id](rule_id.md) | The unique identifier of the rule that is matched |
| [rule_order](rule_order.md) | The order of the rule that is matched |
| [salt](salt.md) | Cryptographic salt for password hashing |
| [scope](scope.md) | Tests if the element is a scope like process or sub-process |
| [script](script.md) | Script code of this script task |
| [script_format](script_format.md) | MIME type or language of the script (e |
| [seed_job_definition_id](seed_job_definition_id.md) | Reference to a JobDefinition |
| [sentry_id](sentry_id.md) | Reference to the sentry |
| [sequence_counter](sequence_counter.md) | Monotonically increasing counter for ordering |
| [sequential](sequential.md) | Whether sequential |
| [signal](signal.md) | The signal of this element |
| [size](size.md) | Font size in points |
| [source](source.md) | The source |
| [source_case_execution_id](source_case_execution_id.md) | Reference to the source case execution |
| [source_element](source_element.md) | The source element of this element |
| [sources](sources.md) | The throwing link events that send to this link target |
| [standard_event](standard_event.md) | The standard event |
| [start_activity_id](start_activity_id.md) | The start activity |
| [start_quantity](start_quantity.md) | Minimum number of tokens required to start this activity |
| [start_time](start_time.md) | Start timestamp |
| [start_user_id](start_user_id.md) | The authenticated user that started this process instance |
| [state](state.md) | Current state of HistoricProcessInstance, following values are recognized dur... |
| [strike_through](strike_through.md) | Whether the font has a strike-through decoration |
| [structure](structure.md) | The structure of this element |
| [structure_ref](structure_ref.md) | The item definition describing the data structure |
| [succeeding_nodes](succeeding_nodes.md) | The succeeding nodes of this element |
| [super_case_execution_id](super_case_execution_id.md) | Reference to the super case execution |
| [super_case_instance_id](super_case_instance_id.md) | The case instance id of a potential super case instance or null if no super c... |
| [super_execution_id](super_execution_id.md) | Reference to the super execution |
| [super_process_instance_id](super_process_instance_id.md) | The process instance id of a potential super process instance or null if no s... |
| [supported_interfaces](supported_interfaces.md) | Collection of interface elements associated with this element |
| [supports](supports.md) | Interfaces that this process is declared to support |
| [suspension_state](suspension_state.md) | Whether the entity is active or suspended |
| [target](target.md) | The catching link event that receives this link |
| [target_element](target_element.md) | The target element of this element |
| [target_namespace](target_namespace.md) | Namespace URI for elements defined in this document |
| [targets](targets.md) | Collection of targets values |
| [task_definition_key](task_definition_key.md) | The id of the activity in the process defining this task or null if this is n... |
| [task_id](task_id.md) | Reference to the task |
| [task_state](task_state.md) | Task's state |
| [tasks](tasks.md) | User tasks |
| [tenant_id](tenant_id.md) | Multi-tenancy discriminator |
| [text](text.md) | Textual content of this element |
| [text2_value](text2_value.md) | Variable value stored as text2 |
| [text_format](text_format.md) | MIME type or format of the documentation text |
| [text_value](text_value.md) | Variable value stored as text |
| [time_cycle](time_cycle.md) | Repeating cycle expression for this timer |
| [time_date](time_date.md) | Specific date and time at which this timer fires |
| [time_duration](time_duration.md) | Duration expression for this timer |
| [timeouts](timeouts.md) | Collection of timer event definition elements associated with this element |
| [timestamp](timestamp.md) | Time when this log occurred |
| [to_](to_.md) | The target expression of this assignment |
| [topic_name](topic_name.md) | Topic name of the associated external task |
| [total_jobs](total_jobs.md) | Total number of jobs |
| [transformation](transformation.md) | Transformation expression applied during data association |
| [type](type.md) | Type discriminator |
| [type_language](type_language.md) | Default type language used for item definitions |
| [underline](underline.md) | Whether the font is underlined |
| [unlimited](unlimited.md) | Whether unlimited |
| [url](url.md) | The remote URL in case this is remote content |
| [user_id](user_id.md) | Reference to a user |
| [users](users.md) | Identity users |
| [value](value.md) | Value of this variable instance |
| [values](values.md) | The values of this element |
| [variable_event](variable_event.md) | The variable event |
| [variable_instance_id](variable_instance_id.md) | Reference to the variable instance |
| [variable_name](variable_name.md) | The name of the output variable |
| [variable_scope_id](variable_scope_id.md) | Reference to the variable scope |
| [variable_type](variable_type.md) | The variable type |
| [version](version.md) | Version number |
| [version_tag](version_tag.md) | Version tag of the process definition |
| [wait_for_completion](wait_for_completion.md) | Whether to wait for the compensation to complete |
| [waypoints](waypoints.md) | Ordered list of waypoints defining the visual path of this edge |
| [while_executing_input](while_executing_input.md) | Collection of data input elements associated with this element |
| [while_executing_output_refs](while_executing_output_refs.md) | Output data produced during execution before completion |
| [width](width.md) | Width of this element's bounding rectangle |
| [worker_id](worker_id.md) | Id of the worker that fetched the external task most recently |
| [x](x.md) | X coordinate (horizontal offset) of this element's bounds |
| [y](y.md) | Y coordinate (vertical offset) of this element's bounds |


## Enumerations

| Enumeration | Description |
| --- | --- |
| [ActivityInstanceState](ActivityInstanceState.md) | State of an activity instance |
| [AssociationDirection](AssociationDirection.md) | The BPMN tAssociationDirection type |
| [AuthorizationType](AuthorizationType.md) | Type of authorization rule |
| [DelegationState](DelegationState.md) | Delegation states of a task |
| [EntityState](EntityState.md) | General state of an entity (e |
| [EventBasedGatewayType](EventBasedGatewayType.md) | The BPMN tEventBasedGatewayType simpleType |
| [GatewayDirection](GatewayDirection.md) | The BPMN tGatewayDirection simpleType |
| [IncidentState](IncidentState.md) | State of a historic incident |
| [ItemKind](ItemKind.md) | The BPMN tItemKind simple type |
| [JobState](JobState.md) | State of a historic job log entry |
| [MessageVisibleKind](MessageVisibleKind.md) | The BPMNDI MessageVisibleKind simpleType |
| [MultiInstanceFlowCondition](MultiInstanceFlowCondition.md) | The BPMN 2 |
| [ParticipantBandKind](ParticipantBandKind.md) | The BPMNDI ParticipantBandKind simpleType |
| [ProcessType](ProcessType.md) | The BPMN tProcessType simple type |
| [RelationshipDirection](RelationshipDirection.md) | The BPMN tRelationshipDirection type |
| [SuspensionState](SuspensionState.md) | Whether an entity is active or suspended |
| [TransactionMethod](TransactionMethod.md) | BPMN TransactionMethod enumeration |


## Types

| Type | Description |
| --- | --- |
| [Boolean](Boolean.md) | A binary (true or false) value |
| [Curie](Curie.md) | a compact URI |
| [Date](Date.md) | a date (year, month and day) in an idealized calendar |
| [DateOrDatetime](DateOrDatetime.md) | Either a date or a datetime |
| [Datetime](Datetime.md) | The combination of a date and time |
| [Decimal](Decimal.md) | A real number with arbitrary precision that conforms to the xsd:decimal speci... |
| [Double](Double.md) | A real number that conforms to the xsd:double specification |
| [Float](Float.md) | A real number that conforms to the xsd:float specification |
| [Integer](Integer.md) | An integer |
| [Jsonpath](Jsonpath.md) | A string encoding a JSON Path |
| [Jsonpointer](Jsonpointer.md) | A string encoding a JSON Pointer |
| [Ncname](Ncname.md) | Prefix part of CURIE |
| [Nodeidentifier](Nodeidentifier.md) | A URI, CURIE or BNODE that represents a node in a model |
| [Objectidentifier](Objectidentifier.md) | A URI or CURIE that represents an object in the model |
| [Sparqlpath](Sparqlpath.md) | A string encoding a SPARQL Property Path |
| [String](String.md) | A character string |
| [Time](Time.md) | A time object represents a (local) time of day, independent of any particular... |
| [Uri](Uri.md) | a complete URI |
| [Uriorcurie](Uriorcurie.md) | a URI or a CURIE |


## Subsets

| Subset | Description |
| --- | --- |
| [Base](Base.md) | Base types and utility entities (ByteArray, Property, Meter, Schema) |
| [Bpmndi](Bpmndi.md) | BPMN diagram interchange interfaces and enums |
| [Collaboration](Collaboration.md) | Collaboration features (Comments, Attachments, Filters) |
| [CoreApi](CoreApi.md) | Top-level BPMN API types and enums |
| [Dc](Dc.md) | Diagram coordinate and bounds interfaces |
| [Di](Di.md) | Generic diagram interchange interfaces |
| [FluxnovaBpm](FluxnovaBpm.md) | All Fluxnova BPM platform entities |
| [FluxnovaBpmnModel](FluxnovaBpmnModel.md) | All Fluxnova BPMN Model API types |
| [FluxnovaExtensions](FluxnovaExtensions.md) | Fluxnova BPMN extension interfaces |
| [History](History.md) | Historical snapshots of completed runtime entities |
| [Identity](Identity.md) | Identity and authorization entities (User, Group, Tenant, Role) |
| [Instance](Instance.md) | Core BPMN element interfaces |
| [Job](Job.md) | Job and batch management entities |
| [Platform](Platform.md) | Top-level platform schema entities (filename-derived subset for fluxnova_bpm_... |
| [Repository](Repository.md) | Resource definitions (Process, Case, Decision, Form) |
| [Runtime](Runtime.md) | Active execution, task, and event instances |
