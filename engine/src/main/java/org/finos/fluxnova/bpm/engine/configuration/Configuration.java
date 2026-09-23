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
package org.finos.fluxnova.bpm.engine.configuration;

import java.util.Date;

/**
 * <p>A process configuration entry: a key/value pair which is either global or
 * scoped to a single tenant.</p>
 */
public interface Configuration {

  /** Lifecycle status of an entry which is currently in effect. */
  String STATUS_ACTIVE = "ACTIVE";

  /** Lifecycle status of an entry which has been soft-deleted. */
  String STATUS_DELETED = "DELETED";

  /** @return the id of the configuration entry */
  String getId();

  /** @return the configuration key */
  String getConfigKey();

  /** @return the id of the tenant this entry belongs to, or {@code null} for a global entry */
  String getTenantId();

  /** @return the configuration value */
  String getConfigValue();

  /** @return the version of this entry, starting at 1 */
  int getVersion();

  /** @return the lifecycle status, either {@link #STATUS_ACTIVE} or {@link #STATUS_DELETED} */
  String getStatus();

  /** @return the id of the user who created this entry */
  String getCreatedBy();

  /** @return the time this entry was created */
  Date getCreatedAt();

  /** @return the id of the user who last updated this entry */
  String getUpdatedBy();

  /** @return the time this entry was last updated */
  Date getUpdatedAt();

}
