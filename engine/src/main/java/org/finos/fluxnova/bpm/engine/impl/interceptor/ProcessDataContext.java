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
package org.finos.fluxnova.bpm.engine.impl.interceptor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.finos.fluxnova.bpm.application.ProcessApplicationReference;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.context.Context;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.finos.fluxnova.commons.logging.MdcAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holds contextual process data and supports custom MDC properties via a provider-based
 * registration mechanism.
 *
 * <p>In addition to all built-in logging context properties (activityId, tenantId, etc.), this
 * class supports engine-level extensibility through {@link MdcPropertyProvider}:
 *
 * <ul>
 *   <li>All built-in FluxNova logging context properties (activityId, tenantId, etc.)
 *   <li>Registration of custom MDC property names with value providers via {@link
 *       ProcessEngineConfigurationImpl#addCustomMdcProperty(String, MdcPropertyProvider)}
 *   <li>Automatic MDC stack management for custom properties alongside built-in ones
 *   <li>Automatic property value computation during {@link #pushSection(ExecutionEntity)} via
 *       registered providers
 * </ul>
 *
 * <p><strong>Custom Property Registration:</strong>
 *
 * <p>Custom properties are registered on {@link ProcessEngineConfigurationImpl} by calling {@link
 * ProcessEngineConfigurationImpl#addCustomMdcProperty(String, MdcPropertyProvider)}, typically
 * from a {@code AbstractProcessEnginePlugin} {@code preInit()} method. During context
 * initialization, this class reads all registered providers from the configuration and sets up:
 *
 * <ul>
 *   <li>A dedicated {@link ProcessDataStack} for each custom property
 *   <li>Automatic section/stack management (push/pop/cleanup) alongside built-in properties
 *   <li>MDC integration through the existing stack mechanism
 *   <li>Automatic value computation via the registered {@link MdcPropertyProvider} on each push
 * </ul>
 *
 * <p><strong>Setting Custom Property Values:</strong>
 *
 * <p>Custom property values are computed automatically during {@link #pushSection(ExecutionEntity)}
 * by invoking the registered {@link MdcPropertyProvider} callback. The provider receives the
 * current {@link ExecutionEntity} and should return the property value, or {@code null} if not
 * applicable for that execution.
 *
 * <p><strong>Example Usage:</strong>
 *
 * <pre>
 * // In a ProcessEnginePlugin's preInit(), register custom MDC properties:
 * {@literal @}Override
 * public void preInit(ProcessEngineConfigurationImpl configuration) {
 *     configuration.addCustomMdcProperty("applicationId",
 *         execution -&gt; execution != null ? resolveAppId(execution) : null);
 *     configuration.addCustomMdcProperty("businessUnit",
 *         execution -&gt; execution != null ? lookupBusinessUnit(execution) : null);
 * }
 *
 * // ProcessDataContext will automatically retrieve providers from the configuration
 * // at construction time and invoke them on every pushSection().
 * </pre>
 *
 * <p>Holds the contextual process data.<br>
 *
 * <p>New context properties are always part of a section that can be started by {@link
 * #pushSection(ExecutionEntity)}. The section keeps track of all pushed properties. Those can
 * easily be cleared by popping the section with {@link #popSection()} afterwards, e.g. after the
 * successful execution.<br>
 *
 * <p>A property can be pushed to the logging context (MDC) if there is a configured non-empty
 * context name for it in the {@link ProcessEngineConfigurationImpl process engine configuration}.
 * The following configuration options are available:
 *
 * <ul>
 *   <li>loggingContextActivityId - the context property for the activity id
 *   <li>loggingContextActivityName - the context property for the activity name
 *   <li>loggingContextApplicationName - the context property for the application name
 *   <li>loggingContextBusinessKey - the context property for the business key
 *   <li>loggingContextProcessDefinitionId - the context property for the definition id
 *   <li>loggingContextProcessDefinitionKey - the context property for the definition key
 *   <li>loggingContextProcessInstanceId - the context property for the instance id
 *   <li>loggingContextTenantId - the context property for the tenant id
 *   <li>loggingContextEngineName - the context property for the engine name
 *   <li>loggingContextRootProcessInstanceId - the context property for the root process instance id
 *   <li>Custom properties - registered via {@link #registerCustomMdcProperty(String,
 *       MdcPropertyProvider)}
 * </ul>
 */

public class ProcessDataContext {

  private static final Logger LOG = LoggerFactory.getLogger(ProcessDataContext.class);

  protected static final String NULL_VALUE = "~NULL_VALUE~";

  protected String mdcPropertyActivityId;
  protected String mdcPropertyActivityName;
  protected String mdcPropertyApplicationName;
  protected String mdcPropertyBusinessKey;
  protected String mdcPropertyDefinitionId;
  protected String mdcPropertyDefinitionKey;
  protected String mdcPropertyInstanceId;
  protected String mdcPropertyTenantId;
  protected String mdcPropertyEngineName;
  protected String mdcPropertyRootProcessInstanceId;

  /**
   * Property providers for custom MDC properties in this context instance. Maps property name ->
   * callback that computes the property value from execution context.
   *
   * <p>Why needed: Only custom properties require providers. Built-in properties (activityId,
   * tenantId, etc.) access ExecutionEntity fields directly without callbacks.
   */
  protected Map<String, MdcPropertyProvider> customMdcPropertyProviders = new HashMap<>();

  protected boolean handleMdc = false;

  protected ProcessDataStack activityIdStack;

  /**
   * All data stacks we need to keep for MDC logging. Maps MDC property name -> stack that tracks
   * property values through nested contexts. Includes both built-in properties (activityId,
   * tenantId, etc.) and custom properties.
   *
   * <p>Why needed: Manages value history for ALL MDC properties through nested execution contexts.
   * When a process calls a subprocess, we push new values onto the stack. When the subprocess
   * completes, we pop to restore parent process values. This cannot be derived from
   * customMdcPropertyProviders alone because:
   *
   * <ul>
   *   <li>Built-in properties need stacks but don't have providers
   *   <li>Stacks track the value history, providers only compute current values
   * </ul>
   */
  protected Map<String, ProcessDataStack> mdcDataStacks = new HashMap<>();

  protected ProcessDataSections sections = new ProcessDataSections();

  /**
   * Preserves MDC properties from outer contexts when parkExternalProperties is enabled. Maps MDC
   * property name -> value to restore when this context completes.
   *
   * <p>Why needed: When commands nest (one command triggering another), each creates its own
   * ProcessDataContext. Without parking, the outer command's MDC would be lost. Example: Outer
   * command has processInstanceId=123, inner command has processInstanceId=456. When inner
   * completes, we restore the outer context's processInstanceId=123.
   */
  protected Map<String, String> externalProperties = new HashMap<>();

  public ProcessDataContext(ProcessEngineConfigurationImpl configuration) {
    this(configuration, false, false);
  }

  public ProcessDataContext(
          ProcessEngineConfigurationImpl configuration, boolean initFromCurrentMdc) {
    this(configuration, initFromCurrentMdc, false);
  }

  /**
   * All-args constructor.
   *
   * @param configuration          the process engine configuration to use to fetch Logging Context Parameters.
   * @param initFromCurrentMdc     when true, this process data context will be populated from the current state of the MDC
   * @param parkExternalProperties when true, the MDC tuples that are the same as the configured logging context parameters
   *                               will be preserved separately in the process data context.
   */
  public ProcessDataContext(ProcessEngineConfigurationImpl configuration, boolean initFromCurrentMdc,
                            boolean parkExternalProperties) {
    mdcPropertyActivityId = configuration.getLoggingContextActivityId();

    // always keep track of activity ids, because those are used to
    // populate the Job#getFailedActivityId field. This is independent
    // of the logging configuration
    activityIdStack = new ProcessDataStack(isNotBlank(mdcPropertyActivityId) ? mdcPropertyActivityId : null);

    if (isNotBlank(mdcPropertyActivityId)) {
      mdcDataStacks.put(mdcPropertyActivityId, activityIdStack);
    }

    mdcPropertyActivityName = initProperty(configuration::getLoggingContextActivityName);
    mdcPropertyApplicationName = initProperty(configuration::getLoggingContextApplicationName);
    mdcPropertyBusinessKey = initProperty(configuration::getLoggingContextBusinessKey);
    mdcPropertyDefinitionId = initProperty(configuration::getLoggingContextProcessDefinitionId);
    mdcPropertyDefinitionKey = initProperty(configuration::getLoggingContextProcessDefinitionKey);
    mdcPropertyInstanceId = initProperty(configuration::getLoggingContextProcessInstanceId);
    mdcPropertyTenantId = initProperty(configuration::getLoggingContextTenantId);
    mdcPropertyEngineName = initProperty(configuration::getLoggingContextEngineName);
    mdcPropertyRootProcessInstanceId = initProperty(configuration::getLoggingContextRootProcessInstanceId);

    initializeCustomPropertiesFromConfiguration(configuration);

    if (parkExternalProperties) {
      parkExternalProperties(configuration);
    }

    handleMdc = !mdcDataStacks.isEmpty();

    if (initFromCurrentMdc) {
      mdcDataStacks.values().forEach(stack -> {
        boolean valuePushed = stack.pushCurrentValueFromMdc();
        if (valuePushed) {
          sections.addToCurrentSection(stack);
        }
      });

      sections.sealCurrentSection();
    }
  }

  /**
   * Initializes custom MDC properties from the process engine configuration.
   *
   * <p>Reads all {@link MdcPropertyProvider} instances registered on the supplied {@link
   * ProcessEngineConfigurationImpl} via {@link
   * ProcessEngineConfigurationImpl#addCustomMdcProperty(String, MdcPropertyProvider)} and
   * registers each one with this context instance.
   *
   * <p>This allows for configuration-driven registration of custom properties without requiring
   * direct manipulation of {@code ProcessDataContext} instances.
   *
   * @param configuration the process engine configuration; if {@code null} initialization is
   *     skipped silently
   */
  private void initializeCustomPropertiesFromConfiguration(
          ProcessEngineConfigurationImpl configuration) {
    if (configuration == null) {
      return;
    }

    Map<String, MdcPropertyProvider> configProviders = configuration.getCustomMdcPropertyProviders();

    if (configProviders != null && !configProviders.isEmpty()) {
      for (Map.Entry<String, MdcPropertyProvider> entry : configProviders.entrySet()) {
        registerCustomMdcProperty(entry.getKey(), entry.getValue());
      }
    }
  }

  /**
   * Parks (saves) existing MDC properties that match configured logging context parameters.
   *
   * <p><strong>Purpose:</strong> When this ProcessDataContext is created within an outer command
   * that already has MDC properties set, we need to preserve those outer values so they can be
   * restored when this context completes. This prevents the inner command from permanently
   * overwriting the outer command's MDC state.
   *
   * <p><strong>Example scenario:</strong>
   *
   * <pre>
   * Outer command context:
   *   MDC: processInstanceId=123, tenantId=tenant-outer
   *
   * Inner command starts → creates new ProcessDataContext with parkExternalProperties=true
   *   → Parks: {processInstanceId=123, tenantId=tenant-outer}
   *   → Sets: processInstanceId=456, tenantId=tenant-inner
   *
   * Inner command completes → calls restoreExternalMDCProperties()
   *   → Restores: processInstanceId=123, tenantId=tenant-outer
   * </pre>
   *
   * <p><strong>When used:</strong> Set to true when creating nested ProcessDataContext instances
   * that should preserve the outer MDC state. Set to false for top-level contexts.
   *
   * @param configuration the process engine configuration containing MDC property names
   */
  protected void parkExternalProperties(ProcessEngineConfigurationImpl configuration) {
    parkExternalMDCProperty(configuration::getLoggingContextActivityId);
    parkExternalMDCProperty(configuration::getLoggingContextActivityName);
    parkExternalMDCProperty(configuration::getLoggingContextApplicationName);
    parkExternalMDCProperty(configuration::getLoggingContextBusinessKey);
    parkExternalMDCProperty(configuration::getLoggingContextProcessDefinitionId);
    parkExternalMDCProperty(configuration::getLoggingContextProcessDefinitionKey);
    parkExternalMDCProperty(configuration::getLoggingContextProcessInstanceId);
    parkExternalMDCProperty(configuration::getLoggingContextTenantId);
    parkExternalMDCProperty(configuration::getLoggingContextEngineName);
    parkCustomMdcProperties();
  }

  protected void parkCustomMdcProperties() {
    for (String propertyName : customMdcPropertyProviders.keySet()) {
      parkExternalMDCProperty(() -> propertyName);
    }
  }

  protected String initProperty(final Supplier<String> configSupplier) {
    final String configValue = configSupplier.get();
    if (isNotBlank(configValue)) {
      mdcDataStacks.put(configValue, new ProcessDataStack(configValue));
    }
    return configValue;
  }

  protected String parkExternalMDCProperty(final Supplier<String> configSupplier) {
    final String configValue = configSupplier.get();

    if (isNotBlank(configValue) && isNotBlank(MdcAccess.get(configValue))) {
      externalProperties.put(configValue, MdcAccess.get(configValue));
    }
    return configValue;
  }

  /**
   * Registers a custom MDC property name to be managed by this context with a callback to provide
   * its value.
   *
   * <p>The property will have its own stack created and will be automatically managed through the
   * section mechanism. If a property provider is supplied, it will be invoked automatically during
   * {@link #pushSection(ExecutionEntity)} to compute the property value. The provider's {@link
   * MdcPropertyProvider#getPropertyValue(ExecutionEntity)} method will be called with the current
   * execution context, and should return the property value or null if not applicable.
   *
   * <p>If no provider is supplied (null), the property stack will still be created and managed, but
   * no automatic value computation will occur.
   *
   * <p><strong>Thread Safety:</strong> This method should be called during engine configuration
   * before the engine is used. It is not thread-safe if called concurrently with
   * pushSection/popSection operations.
   *
   * @param propertyName the MDC property name to register, must not be null or empty
   * @param propertyProvider optional callback to compute the property value during pushSection, may
   *     be null
   * @throws IllegalArgumentException if propertyName is null or blank
   */
  private void registerCustomMdcProperty(
          String propertyName, MdcPropertyProvider propertyProvider) {
    if (!isNotBlank(propertyName)) {
      throw new IllegalArgumentException("Property name must not be null or blank");
    }

    if (!mdcDataStacks.containsKey(propertyName)) {
      initProperty(() -> propertyName);
      LOG.debug("Registered custom MDC property: {} with provider: {}", propertyName, propertyProvider != null);
    } else {
      LOG.debug("Custom MDC property already registered: {}", propertyName);
    }

    if (propertyProvider != null) {
      customMdcPropertyProviders.put(propertyName, propertyProvider);
    }
  }

  /**
   * Start a new section that keeps track of the pushed properties.
   *
   * If logging context properties are defined, the MDC is updated as well. This
   * also includes clearing the MDC for the first section that is pushed for the
   * logging context so that only the current properties will be present in the
   * MDC (might be less than previously present in the MDC). The previous
   * logging context needs to be reset in the MDC when this one is closed. This
   * can be achieved by using {@link #updateMdcFromCurrentValues()} with the previous
   * logging context.
   *
   * @param execution
   *          the execution to retrieve the context data from
   *
   * @return <code>true</code> if the section contains any updates and therefore
   *         should be popped later by {@link #popSection()}
   */
  public boolean pushSection(ExecutionEntity execution) {
    if (handleMdc && hasNoMdcValues()) {
      clearMdc();
    }

    int numSections = sections.size();

    addToStack(activityIdStack, execution.getActivityId());
    addToStack(execution.getCurrentActivityName(), mdcPropertyActivityName);
    addToStack(execution.getProcessDefinitionId(), mdcPropertyDefinitionId);
    addToStack(execution.getProcessInstanceId(), mdcPropertyInstanceId);
    addToStack(execution.getTenantId(), mdcPropertyTenantId);
    addToStack(execution.getProcessEngine().getName(), mdcPropertyEngineName);
    addToStack(execution.getRootProcessInstanceId(), mdcPropertyRootProcessInstanceId);

    if (isNotBlank(mdcPropertyApplicationName)) {
      ProcessApplicationReference currentPa = Context.getCurrentProcessApplication();
      if (currentPa != null) {
        addToStack(currentPa.getName(), mdcPropertyApplicationName);
      }
    }

    if (isNotBlank(mdcPropertyBusinessKey)) {
      addToStack(execution.getBusinessKey(), mdcPropertyBusinessKey);
    }

    if (isNotBlank(mdcPropertyDefinitionKey)) {
      addToStack(execution.getProcessDefinitionKey(), mdcPropertyDefinitionKey);
    }

    populateCustomMdcProperties(execution);

    sections.sealCurrentSection();

    return numSections != sections.size();
  }

  /**
   * Populates custom MDC properties by invoking registered providers.
   *
   * <p>Iterates through all registered custom MDC properties and invokes their associated provider
   * to get property values based on the current execution context. If provider does not return
   * null, it is added to the MDC stack.
   */
  protected void populateCustomMdcProperties(ExecutionEntity execution) {
    for (Map.Entry<String, MdcPropertyProvider> entry : customMdcPropertyProviders.entrySet()) {
      String propertyName = entry.getKey();
      MdcPropertyProvider provider = entry.getValue();
      if (provider != null) {
        try {
          String propertyValue = provider.getPropertyValue(execution);
          if (propertyValue != null) {
            addToStack(propertyValue, propertyName);
            LOG.debug("Set custom MDC property via provider: {}={} for execution={}",
                propertyName, propertyValue, execution.getId());
          }
        } catch (Exception e) {
          LOG.warn("Error invoking property provider for '{}': {}", propertyName, e.getMessage(), e);
        }
      }
    }
  }

  protected boolean hasNoMdcValues() {
    return mdcDataStacks.values().stream()
        .allMatch(ProcessDataStack::isEmpty);
  }

  /**
   * Pop the latest section, remove all pushed properties of that section and -
   * if logging context properties are defined - update the MDC accordingly.
   */
  public void popSection() {
    sections.popCurrentSection();
  }

  /** Remove all logging context properties from the MDC */
  public void clearMdc() {
    if (handleMdc) {
      mdcDataStacks.values().forEach(ProcessDataStack::clearMdcProperty);
    }
  }

  /**
   * Restores the external properties to the MDC. Meant to be called for ProcessDataContexts associated with outer commands.
   */
  public void restoreExternalMDCProperties() {
    externalProperties.forEach(MdcAccess::put);
  }

  /** Update the MDC with the current values of this logging context */
  public void updateMdcFromCurrentValues() {
    if (handleMdc) {
      mdcDataStacks.values().forEach(ProcessDataStack::updateMdcWithCurrentValue);
    }
  }

  /**
   * @return the latest value of the activity id property if exists, <code>null</code>
   *         otherwise
   */
  public String getLatestActivityId() {
    return activityIdStack.getCurrentValue();
  }

  protected void addToStack(String value, String property) {
    if (!isNotBlank(property)) {
      return;
    }

    ProcessDataStack stack = mdcDataStacks.get(property);
    addToStack(stack, value);
  }

  protected void addToStack(ProcessDataStack stack, String value) {
    String current = stack.getCurrentValue();
    if (valuesEqual(current, value)) {
      return;
    }

    stack.pushCurrentValue(value);
    sections.addToCurrentSection(stack);
  }

  protected static boolean isNotBlank(String property) {
    return property != null && !property.trim().isEmpty();
  }

  protected static boolean valuesEqual(String val1, String val2) {
    if (isNull(val1)) {
      return val2 == null;
    }
    return val1.equals(val2);
  }

  protected static boolean isNull(String value) {
    return value == null || NULL_VALUE.equals(value);
  }

  protected static class ProcessDataStack {

    protected String mdcName;
    protected Deque<String> deque = new ArrayDeque<>();

    /**
     * @param mdcName is optional. If present, any additions to a stack will also be reflected in the MDC context
     */
    public ProcessDataStack(String mdcName) {
      this.mdcName = mdcName;
    }

    public boolean isEmpty() {
      return deque.isEmpty();
    }

    public String getCurrentValue() {
      return deque.peekFirst();
    }

    public void pushCurrentValue(String value) {
      deque.addFirst(value != null ? value : NULL_VALUE);

      updateMdcWithCurrentValue();
    }

    /**
     * @return true if a value was obtained from the mdc
     *   and added to the stack
     */
    public boolean pushCurrentValueFromMdc() {
      if (isNotBlank(mdcName)) {
        String mdcValue = MdcAccess.get(mdcName);

        deque.addFirst(mdcValue != null ? mdcValue : NULL_VALUE);
        return true;
      } else {
        return false;
      }
    }

    public void removeCurrentValue() {
      deque.removeFirst();

      updateMdcWithCurrentValue();
    }

    public void clearMdcProperty() {
      if (isNotBlank(mdcName)) {
        MdcAccess.remove(mdcName);
      }
    }

    public void updateMdcWithCurrentValue() {
      if (isNotBlank(mdcName)) {
        String currentValue = getCurrentValue();

        if (isNull(currentValue)) {
          MdcAccess.remove(mdcName);
        } else {
          MdcAccess.put(mdcName, currentValue);
        }
      }
    }
  }

  protected static class ProcessDataSections {

    /**
     * Keeps track of when we added values to which stack (as we do not add
     * a new value to every stack with every update, but only changed values)
     */
    protected Deque<List<ProcessDataStack>> sections = new ArrayDeque<>();

    protected boolean currentSectionSealed = true;

    /**
     * Adds a stack to the current section. If the current section is already sealed,
     * a new section is created.
     */
    public void addToCurrentSection(ProcessDataStack stack) {
      List<ProcessDataStack> currentSection;

      if (currentSectionSealed) {
        currentSection = new ArrayList<>();
        sections.addFirst(currentSection);
        currentSectionSealed = false;

      } else {
        currentSection = sections.peekFirst();
      }

      currentSection.add(stack);
    }

    /**
     * Pops the current section and removes the
     * current values from the referenced stacks (including updates
     * to the MDC)
     */
    public void popCurrentSection() {
      List<ProcessDataStack> section = sections.pollFirst();
      if (section != null) {
        section.forEach(ProcessDataStack::removeCurrentValue);
      }

      currentSectionSealed = true;
    }

    /**
     * After a section is sealed, a new section will be created
     * with the next call to {@link #addToCurrentSection(ProcessDataStack)}
     */
    public void sealCurrentSection() {
      currentSectionSealed = true;
    }

    public int size() {
      return sections.size();
    }
  }
}
