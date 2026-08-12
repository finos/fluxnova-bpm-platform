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
package org.finos.fluxnova.bpm.engine.cdi.test.jsf;

import java.util.Set;

import jakarta.enterprise.inject.AmbiguousResolutionException;
import jakarta.enterprise.inject.spi.Bean;

import org.finos.fluxnova.bpm.engine.cdi.compat.FluxnovaTaskForm;
import org.finos.fluxnova.bpm.engine.cdi.compat.FoxTaskForm;
import org.finos.fluxnova.bpm.engine.cdi.jsf.TaskForm;
import org.finos.fluxnova.bpm.engine.cdi.test.CdiProcessEngineTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.jboss.arquillian.junit5.ArquillianExtension;

/**
 * @author Daniel Meyer
 */
@ExtendWith(ArquillianExtension.class)
public class TaskFormTest extends CdiProcessEngineTestCase {

  @Test
  public void testTaskFormInjectable() throws Exception {

    Set<Bean<?>> taskForm = beanManager.getBeans(TaskForm.class);
    try {
      Bean<? extends Object> bean = beanManager.resolve(taskForm);
      Assertions.assertNotNull(bean);
    }catch(AmbiguousResolutionException e) {
      Assertions.fail("Injection of TaskForm is ambiguous.");
    }

    Set<Bean<?>> foxTaskForm = beanManager.getBeans(FoxTaskForm.class);
    try {
      Bean<? extends Object> bean = beanManager.resolve(foxTaskForm);
      Assertions.assertNotNull(bean);
    }catch(AmbiguousResolutionException e) {
      Assertions.fail("Injection of FoxTaskForm is ambiguous.");
    }

    Set<Bean<?>> camundaTaskForm = beanManager.getBeans(FluxnovaTaskForm.class);
    try {
      Bean<? extends Object> bean = beanManager.resolve(camundaTaskForm);
      Assertions.assertNotNull(bean);
    }catch(AmbiguousResolutionException e) {
      Assertions.fail("Injection of CamundaTaskForm is ambiguous.");
    }

  }

}
