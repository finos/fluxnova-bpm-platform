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
package org.finos.flowave.bpm.engine.test.bpmn.usertask;

import org.finos.flowave.bpm.engine.delegate.DelegateTask;
import org.finos.flowave.bpm.engine.delegate.TaskListener;
import org.finos.flowave.bpm.engine.test.bpmn.common.AbstractProcessEngineServicesAccessTest;
import org.finos.flowave.bpm.model.bpmn.BpmnModelInstance;
import org.finos.flowave.bpm.model.bpmn.instance.Task;
import org.finos.flowave.bpm.model.bpmn.instance.UserTask;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveTaskListener;

/**
 * @author Daniel Meyer
 *
 */
public class TaskListenerProcessEngineServicesAccessTest extends AbstractProcessEngineServicesAccessTest {

  protected Class<?> getTestServiceAccessibleClass() {
    return AccessServicesListener.class;
  }

  protected Class<?> getQueryClass() {
    return PerformQueryListener.class;
  }

  protected Class<?> getStartProcessInstanceClass() {
    return StartProcessListener.class;
  }

  protected Class<?> getProcessEngineStartProcessClass() {
    return ProcessEngineStartProcessListener.class;
  }

  protected Task createModelAccessTask(BpmnModelInstance modelInstance, Class<?> delegateClass) {
    UserTask task = modelInstance.newInstance(UserTask.class);
    task.setId("userTask");
    FlowaveTaskListener executionListener = modelInstance.newInstance(FlowaveTaskListener.class);
    executionListener.setFlowaveEvent(TaskListener.EVENTNAME_CREATE);
    executionListener.setFlowaveClass(delegateClass.getName());
    task.builder().addExtensionElement(executionListener);
    return task;
  }

  public static class AccessServicesListener implements TaskListener {
    public void notify(DelegateTask execution) {
      assertCanAccessServices(execution.getProcessEngineServices());
    }
  }

  public static class PerformQueryListener implements TaskListener {
    public void notify(DelegateTask execution) {
      assertCanPerformQuery(execution.getProcessEngineServices());
    }
  }

  public static class StartProcessListener implements TaskListener {
    public void notify(DelegateTask execution) {
      assertCanStartProcessInstance(execution.getProcessEngineServices());
    }
  }

  public static class ProcessEngineStartProcessListener implements TaskListener {
    @Override
    public void notify(DelegateTask execution) {
      assertCanStartProcessInstance(execution.getProcessEngine());
    }
  }

}
