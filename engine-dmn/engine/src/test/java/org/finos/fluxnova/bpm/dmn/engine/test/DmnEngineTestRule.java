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
package org.finos.fluxnova.bpm.dmn.engine.test;

import java.io.InputStream;
import java.util.List;

import org.finos.fluxnova.bpm.dmn.engine.DmnDecision;
import org.finos.fluxnova.bpm.dmn.engine.DmnEngineConfiguration;
import org.finos.fluxnova.commons.utils.IoUtil;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * JUnit test rule for internal unit tests. Uses The
 * {@link DecisionResource} annotation to load decisions
 * before tests.
 */
public class DmnEngineTestRule extends DmnEngineRule {

  public static final String DMN_SUFFIX = "dmn";

  protected DmnDecision decision;

  public DmnEngineTestRule() {
    super();
  }

  public DmnEngineTestRule(DmnEngineConfiguration dmnEngineConfiguration) {
    super(dmnEngineConfiguration);
  }

  public DmnDecision getDecision() {
    return decision;
  }

  @Override
  public void beforeEach(ExtensionContext context) {
    super.beforeEach(context);
    decision = loadDecision(context);
  }

  protected DmnDecision loadDecision(ExtensionContext context) {
    DecisionResource decisionResource = context.getRequiredTestMethod().getAnnotation(DecisionResource.class);

    if (decisionResource != null) {
      String resourcePath = decisionResource.resource();
      resourcePath = expandResourcePath(context, resourcePath);

      InputStream inputStream = IoUtil.fileAsStream(resourcePath);
      String decisionKey = decisionResource.decisionKey();

      if (decisionKey == null || decisionKey.isEmpty()) {
        List<DmnDecision> decisions = dmnEngine.parseDecisions(inputStream);
        return decisions.isEmpty() ? null : decisions.get(0);
      } else {
        return dmnEngine.parseDecision(decisionKey, inputStream);
      }
    } else {
      return null;
    }
  }

  protected String expandResourcePath(ExtensionContext context, String resourcePath) {
    if (resourcePath.contains("/")) {
      return resourcePath;
    } else {
      Class<?> testClass = context.getRequiredTestClass();
      if (resourcePath.isEmpty()) {
        return testClass.getName().replace(".", "/") + "." + context.getRequiredTestMethod().getName() + "." + DMN_SUFFIX;
      } else {
        return testClass.getPackage().getName().replace(".", "/") + "/" + resourcePath;
      }
    }
  }

}
