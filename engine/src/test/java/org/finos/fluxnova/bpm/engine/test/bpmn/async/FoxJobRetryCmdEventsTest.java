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
package org.finos.fluxnova.bpm.engine.test.bpmn.async;

import static org.assertj.core.api.Assertions.assertThat;
import static org.finos.fluxnova.bpm.engine.test.bpmn.async.RetryCmdDeployment.deployment;
import static org.finos.fluxnova.bpm.engine.test.bpmn.async.RetryCmdDeployment.prepareCompensationEventProcess;
import static org.finos.fluxnova.bpm.engine.test.bpmn.async.RetryCmdDeployment.prepareEscalationEventProcess;
import static org.finos.fluxnova.bpm.engine.test.bpmn.async.RetryCmdDeployment.prepareMessageEventProcess;
import static org.finos.fluxnova.bpm.engine.test.bpmn.async.RetryCmdDeployment.prepareSignalEventProcess;

import java.util.Collection;

import org.finos.fluxnova.bpm.engine.repository.Deployment;
import org.finos.fluxnova.bpm.engine.runtime.Job;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.util.ProcessEngineTestRule;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.finos.fluxnova.bpm.engine.test.util.ChainedExtension;

/**
 * @author Askar Akhmerov
 */
public class FoxJobRetryCmdEventsTest {

  public ProcessEngineRule engineRule = new ProvidedProcessEngineRule();
  public ProcessEngineTestRule testRule = new ProcessEngineTestRule(engineRule);

  @RegisterExtension
  public ChainedExtension ruleChain = ChainedExtension.outerExtension(engineRule).around(testRule);
  public RetryCmdDeployment deployment;

  public static Collection<RetryCmdDeployment[]> scenarios() {
    return RetryCmdDeployment.asParameters(
        deployment()
            .withEventProcess(prepareSignalEventProcess()),
        deployment()
            .withEventProcess(prepareMessageEventProcess()),
        deployment()
            .withEventProcess(prepareEscalationEventProcess()),
        deployment()
            .withEventProcess(prepareCompensationEventProcess())
    );
  }

  private Deployment currentDeployment;

  @MethodSource("scenarios")
  @ParameterizedTest(name = "deployment {index}")
  public void testFailedIntermediateThrowingSignalEventAsync(RetryCmdDeployment deployment) {
    initFoxJobRetryCmdEventsTest(deployment);
    currentDeployment = testRule.deploy(this.deployment.getBpmnModelInstances());
    ProcessInstance pi = engineRule.getRuntimeService().startProcessInstanceByKey(RetryCmdDeployment.PROCESS_ID);
    assertJobRetries(pi);
  }

  @AfterEach
  public void tearDown() {
    if (currentDeployment != null) {
      engineRule.getRepositoryService().deleteDeployment(currentDeployment.getId(),true,true);
    }
  }

  protected void assertJobRetries(ProcessInstance pi) {
    assertThat(pi).isNotNull();

    Job job = fetchJob(pi.getProcessInstanceId());

    try {
      engineRule.getManagementService().executeJob(job.getId());
    } catch (Exception e) {
    }

    // update job
    job = fetchJob(pi.getProcessInstanceId());
    assertThat(job.getRetries()).isEqualTo(4);
  }

  protected Job fetchJob(String processInstanceId) {
    return engineRule.getManagementService().createJobQuery().processInstanceId(processInstanceId).singleResult();
  }

  public void initFoxJobRetryCmdEventsTest(RetryCmdDeployment deployment) {
    this.deployment = deployment;
  }


}
