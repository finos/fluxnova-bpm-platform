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
package org.finos.fluxnova.bpm.spring.boot.starter.runlistener;

import java.io.IOException;

import org.finos.fluxnova.bpm.spring.boot.starter.util.FluxnovaBpmVersion;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * Adds Fluxnova version properties and starter defaults to the environment during
 * early application bootstrap.
 */
public class PropertiesListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

  private static final String DEFAULTS_PROPERTY_SOURCE_NAME = "fluxnovaDefaults";
  private static final String DEFAULTS_RESOURCE = "fluxnova-defaults.properties";

  private final FluxnovaBpmVersion version;

  /**
   * Default constructor, used when initializing via spring.factories.
   *
   * @see PropertiesListener#PropertiesListener(FluxnovaBpmVersion)
   */
  public PropertiesListener() {
    this(new FluxnovaBpmVersion());
  }

  /**
   * Initialize with version.
   *
   * @param version the current camundaBpmVersion instance.
   */
  PropertiesListener(FluxnovaBpmVersion version) {
    this.version = version;
  }

  @Override
  public void onApplicationEvent(final ApplicationEnvironmentPreparedEvent event) {
    event.getEnvironment()
      .getPropertySources()
      .addFirst(version.getPropertiesPropertySource());

    if (!event.getEnvironment().getPropertySources().contains(DEFAULTS_PROPERTY_SOURCE_NAME)) {
      ClassPathResource resource = new ClassPathResource(DEFAULTS_RESOURCE);

      // Fluxnova starter defaults must be available during early bootstrap
      // so Liquibase-related defaults are applied before auto-configuration runs.
      if (!resource.exists()) {
        throw new IllegalStateException("Could not find required defaults resource " + DEFAULTS_RESOURCE);
      }

      try {
        event.getEnvironment().getPropertySources()
          .addLast(new ResourcePropertySource(DEFAULTS_PROPERTY_SOURCE_NAME, resource));
      } catch (IOException e) {
        throw new IllegalStateException("Could not load " + DEFAULTS_RESOURCE, e);
      }
    }
  }

}
