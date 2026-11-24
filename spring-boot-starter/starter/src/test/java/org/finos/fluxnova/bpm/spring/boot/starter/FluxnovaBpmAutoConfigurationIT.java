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
package org.finos.fluxnova.bpm.spring.boot.starter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngineServices;
import org.finos.fluxnova.bpm.engine.impl.cfg.CompositeProcessEnginePlugin;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.finos.fluxnova.bpm.engine.impl.variable.serializer.TypedValueSerializer;
import org.finos.fluxnova.bpm.engine.repository.Deployment;
import org.finos.fluxnova.bpm.engine.repository.DeploymentBuilder;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.model.bpmn.Bpmn;
import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.finos.fluxnova.bpm.spring.boot.starter.test.nonpa.TestApplication;
import org.finos.fluxnova.connect.plugin.impl.ConnectProcessEnginePlugin;
import org.finos.fluxnova.spin.plugin.impl.SpinObjectValueSerializer;
import org.finos.fluxnova.spin.plugin.impl.SpinProcessEnginePlugin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = { TestApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FluxnovaBpmAutoConfigurationIT {

  @Autowired
  ProcessEngineConfigurationImpl processEngineConfiguration;

  @Autowired
  private ApplicationContext appContext;

  @Test
  public void ensureProcessEngineServicesAreExposedAsBeans() {
    for (Class<?> classToCheck : getProcessEngineServicesClasses()) {
      Object bean = appContext.getBean(classToCheck);
      assertNotNull(bean, classToCheck + " must be exposed as @Bean. Check configuration");
      String beanName = convertToBeanName(classToCheck);
      assertSame(bean, appContext.getBean(beanName), classToCheck + " must be exposed as '" + beanName + "'. Check configuration");
    }

  }

  @Test
  public void ensureSpinProcessEnginePluginIsCorrectlyLoaded() {
    // given
    List<ProcessEnginePlugin> plugins = processEngineConfiguration.getProcessEnginePlugins();
    List<TypedValueSerializer<?>> serializers = processEngineConfiguration.getVariableSerializers().getSerializers();

    if (plugins.get(0) instanceof CompositeProcessEnginePlugin) {
      plugins = ((CompositeProcessEnginePlugin) plugins.get(0)).getPlugins();
    }

    boolean isJacksonJsonDataFormat = serializers.stream().anyMatch(s ->
        s instanceof SpinObjectValueSerializer
        && s.getSerializationDataformat().equals("application/json"));

    // then
    assertThat(plugins.stream().anyMatch(plugin -> plugin instanceof SpinProcessEnginePlugin)).isTrue();
    assertThat(isJacksonJsonDataFormat).isTrue();
  }

  @Test
  public void ensureConnectProcessEnginePluginIsCorrectlyLoaded() {
    // given
    List<ProcessEnginePlugin> plugins = processEngineConfiguration.getProcessEnginePlugins();

    if (plugins.get(0) instanceof CompositeProcessEnginePlugin) {
      plugins = ((CompositeProcessEnginePlugin) plugins.get(0)).getPlugins();
    }

    // then
    assertThat(plugins.stream().anyMatch(plugin -> plugin instanceof ConnectProcessEnginePlugin)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({
      ",${null},global-value",
      ",${execution.getTenantId()},global-value",
      "tenant-a,${execution.getTenantId()},tenant-value",
      "tenant-b,${execution.getTenantId()},global-value",
      "tenant-a,${null},global-value"
  })
  @Transactional
  public void resolvesConfigurationThroughServiceTaskExpression(
      String tenantId, String tenantExpression, String expectedValue) {
    ProcessEngine engine = appContext.getBean(ProcessEngine.class);
    engine.getConfigurationService().createConfiguration("lookup.test", "global-value", null);
    engine.getConfigurationService().createConfiguration("lookup.test", "tenant-value", "tenant-a");

    BpmnModelInstance model = Bpmn.createExecutableProcess("configurationLookupTest")
        .fluxnovaHistoryTimeToLive(1)
        .startEvent()
        .serviceTask("readConfiguration")
          .fluxnovaInputParameter("configurationKey", "lookup.test")
          .fluxnovaInputParameter("configurationTenantId", tenantExpression)
          .fluxnovaExpression(
              "${configurationLookup.getValue(execution, configurationKey, configurationTenantId)}")
          .fluxnovaResultVariable("configurationValue")
        .userTask("waitForResult")
        .endEvent()
        .done();

    DeploymentBuilder builder = engine.getRepositoryService().createDeployment()
        .addModelInstance("configurationLookup.bpmn", model);
    if (tenantId != null) {
      builder.tenantId(tenantId);
    }
    Deployment deployment = builder.deploy();
    try {
      String definitionId = engine.getRepositoryService().createProcessDefinitionQuery()
          .deploymentId(deployment.getId()).singleResult().getId();
      ProcessInstance instance = engine.getRuntimeService().startProcessInstanceById(definitionId);

      assertThat(engine.getRuntimeService().getVariable(instance.getId(), "configurationValue"))
          .isEqualTo(expectedValue);
    } finally {
      engine.getRepositoryService().deleteDeployment(deployment.getId(), true);
    }
  }

  private String convertToBeanName(Class<?> beanClass) {
    return StringUtils.uncapitalize(beanClass.getSimpleName());
  }

  private List<Class<?>> getProcessEngineServicesClasses() {
    List<Class<?>> classes = new ArrayList<Class<?>>();
    for (Method method : ProcessEngineServices.class.getMethods()) {
      classes.add(method.getReturnType());
    }
    return classes;
  }

}
