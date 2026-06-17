package org.workflow.example;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.model.bpmn.builder.CamundaErrorEventDefinitionBuilder;
import org.camunda.bpm.model.bpmn.impl.instance.camunda.CamundaExecutionListenerImpl;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaConnector;
import org.camunda.bpm.model.bpmn.impl.instance.camunda.CamundaInputOutputImpl;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaExecutionListener;

import java.util.Collection;

public class CamundaService {
    private final ProcessEngine processEngine;
    private CamundaInputOutputImpl inputOutputImpl;
    private Collection<CamundaExecutionListenerImpl> someList;

    public CamundaService(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    public void startProcess(String processKey) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey(processKey);
    }

    public void exampleMethod(Object listener, Collection<CamundaExecutionListenerImpl> listeners, Object someMethod) {
        CamundaExecutionListenerImpl testListener = (CamundaExecutionListenerImpl) listener;
        CamundaExecutionListener newListener = sampleMethod((CamundaExecutionListener) listener);

        getType(CamundaConnector.class);

        for(CamundaExecutionListenerImpl listenerItem : listeners) {
            // Process listener
        }

        inputOutputImpl.getCamundaInputParameters();
    }

    public CamundaExecutionListener sampleMethod(CamundaExecutionListener exeListener) {
        return exeListener;
    }

    public Object getType(Class<?> clazz) {
        return clazz;
    }
}
