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

package org.finos.fluxnova.bpm.engine.test.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.Supplier;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * JUnit 5 Extension that performs resource cleanup for methods that require post-method execution cleanup.
 * Currently, the extension supports only clean up of {@link Task}s but can be extended for other resources.
 */
public class EntityRemoveRule implements BeforeEachCallback, AfterEachCallback {

  private static final Logger LOG = LoggerFactory.getLogger(EntityRemoveRule.class);

  protected Removable removable;

  private EntityRemoveRule() {
    this.removable = Removable.of((ProcessEngine) null);
  }

  private EntityRemoveRule(ProcessEngineTestRule engineTestRule) {
    this.removable = Removable.of(engineTestRule);
  }

  public static EntityRemoveRule of(ProcessEngineTestRule rule) {
    return new EntityRemoveRule(rule);
  }

  public static EntityRemoveRule ofLazyRule(Supplier<ProcessEngineTestRule> ruleSupplier) {
    return new LazyEntityRemoveRuleProxy(ruleSupplier);
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    // nothing to do before each test
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    Method testMethod = context.getRequiredTestMethod();
    RemoveAfter removeAfterAnnotation = testMethod.getAnnotation(RemoveAfter.class);
    boolean methodHasRemoveAfterAnnotation = (removeAfterAnnotation != null);
    LOG.debug("deleteTasks: {}", methodHasRemoveAfterAnnotation);
    executePostEvaluate(removeAfterAnnotation, methodHasRemoveAfterAnnotation);
  }

  protected void executePostEvaluate(RemoveAfter removeAfterAnnotation, boolean methodHasRemoveAfterAnnotation) {
    if (!methodHasRemoveAfterAnnotation) {
      return;
    }
    executePreRemoval();
    executeRemoval(removeAfterAnnotation);
  }

  /**
   * Hook method for pre-removal setup.
   */
  protected void executePreRemoval() {
  }

  /**
   * Hook method for executing removal.
   *
   * @param removeAfterAnnotation the remove after annotation parameter of the executing method.
   */
  protected void executeRemoval(RemoveAfter removeAfterAnnotation) {
    if (hasZeroArguments(removeAfterAnnotation)) {
      removable.removeAll();
      return;
    }
    removable.remove(removeAfterAnnotation.value());
  }

  private boolean hasZeroArguments(RemoveAfter annotation) {
    return annotation.value() == null || annotation.value().length == 0;
  }

  /* Proxy that enables EntityRemoveRule to support lazy initialization by initializing the rule using a supplier &
   *  after the execution of the method, before removal. */
  private static class LazyEntityRemoveRuleProxy extends EntityRemoveRule {

    private Supplier<ProcessEngineTestRule> supplier;

    public LazyEntityRemoveRuleProxy(Supplier<ProcessEngineTestRule> supplier) {
      super();
      this.supplier = supplier;
    }

    @Override
    protected void executePreRemoval() {
      removable = Removable.of(supplier.get());
    }
  }

}