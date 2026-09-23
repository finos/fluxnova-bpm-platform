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
package org.finos.fluxnova.bpm.engine;

import org.finos.fluxnova.bpm.engine.configuration.Configuration;

/**
 * <p>Service which provides access to process configurations: key/value pairs
 * which are either global or scoped to a single tenant.</p>
 */
public interface ConfigurationService {

  /**
   * <p>Creates a new configuration entry.</p>
   *
   * <p>If {@code tenantId} is {@code null} the entry is created as a global
   * configuration which applies to all tenants.</p>
   *
   * @param configKey the configuration key, must not be {@code null}
   * @param configValue the configuration value, must not be {@code null}
   * @param tenantId the tenant to scope the entry to, or {@code null} for a global entry
   * @return the newly created configuration
   *
   * @throws org.finos.fluxnova.bpm.engine.exception.NotValidException
   *          if {@code configKey} or {@code configValue} is {@code null}
   * @throws BadUserRequestException
   *          if an active configuration with the same key already exists in the same scope
   */
  Configuration createConfiguration(String configKey, String configValue, String tenantId);

  /**
   * <p>Returns the configuration with the given id.</p>
   *
   * @param configurationId the id of the configuration, must not be {@code null}
   * @return the configuration, or {@code null} if no configuration exists for that id
   */
  Configuration getConfiguration(String configurationId);

}
