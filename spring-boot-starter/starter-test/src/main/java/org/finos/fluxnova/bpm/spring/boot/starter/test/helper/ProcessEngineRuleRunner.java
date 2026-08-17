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
package org.finos.fluxnova.bpm.spring.boot.starter.test.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

/**
 * Extension that ensures closing process engines after test run.
 */
public class ProcessEngineRuleRunner implements TestInstancePostProcessor {

  private final Collection<ProcessEngineRule> processEngineRules = new ArrayList<>();

  @Override
  public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
    // Collect all ProcessEngineRule extensions from the test instance
    context.getStore(ExtensionContext.Namespace.GLOBAL).getOrComputeIfAbsent(
        ProcessEngineRule.class,
        k -> {
          // Register a close callback
          context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put("cleanup", new ExtensionContext.Store.CloseableResource() {
            @Override
            public void close() throws Throwable {
              for (ProcessEngineRule processEngineRule : processEngineRules) {
                try {
                  processEngineRule.getProcessEngine().close();
                } catch (Exception e) {
                  // close quietly
                }
              }
            }
          });
          return new Object();
        }
    );
  }

  public void addProcessEngineRule(ProcessEngineRule rule) {
    processEngineRules.add(rule);
  }

}
