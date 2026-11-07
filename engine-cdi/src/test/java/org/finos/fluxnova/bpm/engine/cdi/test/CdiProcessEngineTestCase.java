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
package org.finos.fluxnova.bpm.engine.cdi.test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;

import org.finos.fluxnova.bpm.BpmPlatform;
import org.finos.fluxnova.bpm.container.RuntimeContainerDelegate;
import org.finos.fluxnova.bpm.engine.AuthorizationService;
import org.finos.fluxnova.bpm.engine.CaseService;
import org.finos.fluxnova.bpm.engine.DecisionService;
import org.finos.fluxnova.bpm.engine.ExternalTaskService;
import org.finos.fluxnova.bpm.engine.FilterService;
import org.finos.fluxnova.bpm.engine.FormService;
import org.finos.fluxnova.bpm.engine.HistoryService;
import org.finos.fluxnova.bpm.engine.IdentityService;
import org.finos.fluxnova.bpm.engine.ManagementService;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngineException;
import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.TaskService;
import org.finos.fluxnova.bpm.engine.cdi.BusinessProcess;
import org.finos.fluxnova.bpm.engine.cdi.impl.util.BeanManagerLookup;
import org.finos.fluxnova.bpm.engine.cdi.impl.util.ProgrammaticBeanLookup;
import org.finos.fluxnova.bpm.engine.impl.ProcessEngineImpl;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.jobexecutor.JobExecutor;
import org.finos.fluxnova.bpm.engine.impl.test.TestHelper;
import org.finos.fluxnova.bpm.engine.impl.util.LogUtil;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Daniel Meyer
 */
/**
 * When creating a new test class, extend it with this class and add a
 * @RunWith(Arquillian.class) annotation to the child class.
 */
public abstract class CdiProcessEngineTestCase {

  static {
    LogUtil.readJavaUtilLoggingConfigFromClasspath();
  }

  protected Logger logger = Logger.getLogger(getClass().getName());

  @Deployment
  public static JavaArchive createDeployment() {

    return ShrinkWrap.create(JavaArchive.class)
      .addPackages(true, "org.finos.fluxnova.bpm.engine.cdi")
      .addAsManifestResource("META-INF/beans.xml", "beans.xml");
  }

  @RegisterExtension
  public ProcessEngineRule processEngineRule = new ProcessEngineRule();

  // CDI-injected fields: populated by Weld on the CDI-managed test instance.
  // On the plain JUnit5 instance these @Inject annotations are ignored;
  // the @BeforeEach method below fills in the fields as a fallback.
  @Inject
  protected BeanManager beanManager;

  @Inject
  protected ProcessEngine processEngine;
  @Inject
  protected FormService formService;
  @Inject
  protected HistoryService historyService;
  @Inject
  protected IdentityService identityService;
  @Inject
  protected ManagementService managementService;
  @Inject
  protected RepositoryService repositoryService;
  @Inject
  protected RuntimeService runtimeService;
  @Inject
  protected TaskService taskService;
  @Inject
  protected AuthorizationService authorizationService;
  @Inject
  protected FilterService filterService;
  @Inject
  protected ExternalTaskService externalTaskService;
  @Inject
  protected CaseService caseService;
  @Inject
  protected DecisionService decisionService;

  // No CDI producer for ProcessEngineConfigurationImpl – set manually.
  protected ProcessEngineConfigurationImpl processEngineConfiguration;

  @BeforeEach
  public void setUpCdiProcessEngineTestCase() throws Exception {

    if(BpmPlatform.getProcessEngineService().getDefaultProcessEngine() == null) {
      RuntimeContainerDelegate.INSTANCE.get().registerProcessEngine(processEngineRule.getProcessEngine());
    }

    beanManager = ProgrammaticBeanLookup.lookup(BeanManager.class);
    processEngine = processEngineRule.getProcessEngine();
    processEngineConfiguration = (ProcessEngineConfigurationImpl) processEngineRule.getProcessEngine().getProcessEngineConfiguration();
    formService = processEngine.getFormService();
    historyService = processEngine.getHistoryService();
    identityService = processEngine.getIdentityService();
    managementService = processEngine.getManagementService();
    repositoryService = processEngine.getRepositoryService();
    runtimeService = processEngine.getRuntimeService();
    taskService = processEngine.getTaskService();
    authorizationService = processEngine.getAuthorizationService();
    filterService = processEngine.getFilterService();
    externalTaskService = processEngine.getExternalTaskService();
    caseService = processEngine.getCaseService();
    decisionService = processEngine.getDecisionService();
  }

  @AfterEach
  public void tearDownCdiProcessEngineTestCase() throws Exception {
    RuntimeContainerDelegate.INSTANCE.get().unregisterProcessEngine(processEngine);
    beanManager = null;
    processEngine = null;
    processEngineConfiguration = null;
    formService = null;
    historyService = null;
    identityService = null;
    managementService = null;
    repositoryService = null;
    runtimeService = null;
    taskService = null;
    authorizationService = null;
    filterService = null;
    externalTaskService = null;
    caseService = null;
    decisionService = null;
    processEngineRule = null;
  }

  protected void endConversationAndBeginNew(String processInstanceId) {
    getBeanInstance(BusinessProcess.class).associateExecutionById(processInstanceId);
  }

  protected <T> T getBeanInstance(Class<T> clazz) {
    return ProgrammaticBeanLookup.lookup(clazz);
  }

  protected Object getBeanInstance(String name) {
    return ProgrammaticBeanLookup.lookup(name);
  }

  //////////////////////// copied from AbstractActivitiTestcase

  public void waitForJobExecutorToProcessAllJobs(long maxMillisToWait, long intervalMillis) {
    // processEngineConfiguration may be null if CDI-injected processEngine was cleared in
    // teardown and not re-injected (Arquillian may reuse the same test instance). Re-derive it.
    if (processEngineConfiguration == null && processEngine != null) {
      processEngineConfiguration = (ProcessEngineConfigurationImpl) processEngine.getProcessEngineConfiguration();
    }
    if (processEngineConfiguration == null) {
      throw new ProcessEngineException("processEngineConfiguration is not initialized. " +
          "Ensure setUpCdiProcessEngineTestCase() ran successfully before calling this method.");
    }
    JobExecutor jobExecutor = processEngineConfiguration.getJobExecutor();
    jobExecutor.start();

    try {
      Timer timer = new Timer();
      InteruptTask task = new InteruptTask(Thread.currentThread());
      timer.schedule(task, maxMillisToWait);
      boolean areJobsAvailable = true;
      try {
        while (areJobsAvailable && !task.isTimeLimitExceeded()) {
          Thread.sleep(intervalMillis);
          areJobsAvailable = areJobsAvailable();
        }
      } catch (InterruptedException e) {
      } finally {
        timer.cancel();
      }
      if (areJobsAvailable) {
        throw new ProcessEngineException("time limit of " + maxMillisToWait + " was exceeded");
      }

    } finally {
      jobExecutor.shutdown();
    }
  }

  public void waitForJobExecutorOnCondition(long maxMillisToWait, long intervalMillis, Callable<Boolean> condition) {
    JobExecutor jobExecutor = processEngineConfiguration.getJobExecutor();
    jobExecutor.start();

    try {
      Timer timer = new Timer();
      InteruptTask task = new InteruptTask(Thread.currentThread());
      timer.schedule(task, maxMillisToWait);
      boolean conditionIsViolated = true;
      try {
        while (conditionIsViolated) {
          Thread.sleep(intervalMillis);
          conditionIsViolated = !condition.call();
        }
      } catch (InterruptedException e) {
      } catch (Exception e) {
        throw new ProcessEngineException("Exception while waiting on condition: "+e.getMessage(), e);
      } finally {
        timer.cancel();
      }
      if (conditionIsViolated) {
        throw new ProcessEngineException("time limit of " + maxMillisToWait + " was exceeded");
      }

    } finally {
      jobExecutor.shutdown();
    }
  }

  public boolean areJobsAvailable() {
    return !managementService
      .createJobQuery()
      .executable()
      .list()
      .isEmpty();
  }

  private static class InteruptTask extends TimerTask {
    protected boolean timeLimitExceeded = false;
    protected Thread thread;
    public InteruptTask(Thread thread) {
      this.thread = thread;
    }
    public boolean isTimeLimitExceeded() {
      return timeLimitExceeded;
    }
    @Override
    public void run() {
      timeLimitExceeded = true;
      thread.interrupt();
    }
  }
}
