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
package org.finos.fluxnova.bpm.model.bpmn.builder;

import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.finos.fluxnova.bpm.model.bpmn.instance.ExtensionElements;
import org.finos.fluxnova.bpm.model.bpmn.instance.Task;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaExecutionListener;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaInputOutput;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaInputParameter;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaOutputParameter;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaTaskListener;

/**
 * @author Sebastian Menski
 */
public abstract class AbstractTaskBuilder<B extends AbstractTaskBuilder<B, E>, E extends Task> extends AbstractActivityBuilder<B, E> {

  protected AbstractTaskBuilder(BpmnModelInstance modelInstance, E element, Class<?> selfType) {
    super(modelInstance, element, selfType);
  }

  /** camunda extensions */

  /**
   * @deprecated use camundaAsyncBefore() instead.
   *
   * Sets the camunda async attribute to true.
   *
   * @return the builder object
   */
  @Deprecated
  public B fluxnovaAsync() {
    element.setFluxnovaAsyncBefore(true);
    return myself;
  }

  /**
   * @deprecated use camundaAsyncBefore(isCamundaAsyncBefore) instead.
   *
   * Sets the camunda async attribute.
   *
   * @param isCamundaAsync  the async state of the task
   * @return the builder object
   */
  @Deprecated
  public B fluxnovaAsync(boolean isCamundaAsync) {
    element.setFluxnovaAsyncBefore(isCamundaAsync);
    return myself;
  }

}
