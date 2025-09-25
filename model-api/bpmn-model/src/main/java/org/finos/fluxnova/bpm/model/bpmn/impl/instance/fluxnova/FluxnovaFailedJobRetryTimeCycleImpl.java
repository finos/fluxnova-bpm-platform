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
package org.finos.fluxnova.bpm.model.bpmn.impl.instance.fluxnova;

import org.finos.fluxnova.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFailedJobRetryTimeCycle;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_FAILED_JOB_RETRY_TIME_CYCLE;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;
import static org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN failedJobRetryTimeCycle camunda extension element
 *
 * @author Sebastian Menski
 */
public class FluxnovaFailedJobRetryTimeCycleImpl extends BpmnModelElementInstanceImpl implements FluxnovaFailedJobRetryTimeCycle {

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaFailedJobRetryTimeCycle.class, CAMUNDA_ELEMENT_FAILED_JOB_RETRY_TIME_CYCLE)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaFailedJobRetryTimeCycle>() {
        public FluxnovaFailedJobRetryTimeCycle newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaFailedJobRetryTimeCycleImpl(instanceContext);
        }
      });

    typeBuilder.build();
  }

  public FluxnovaFailedJobRetryTimeCycleImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }
}
