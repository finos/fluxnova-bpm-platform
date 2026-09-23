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
package org.finos.fluxnova.bpm.engine.rest;

import org.finos.fluxnova.bpm.engine.rest.dto.configuration.CreateConfigurationDto;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Produces(MediaType.APPLICATION_JSON)
public interface ConfigurationRestService {

  public static final String PATH = "/configurations";

  /**
   * Creates a new configuration entry.
   *
   * <p>If {@code tenantId} is omitted or blank the entry is treated as a global
   * configuration applicable to all tenants. A duplicate {@code (configKey, tenantId)}
   * combination with {@code STATUS_=ACTIVE} results in a {@code 409 Conflict}.</p>
   *
   * @param configurationDto the create request containing {@code configKey},
   *                         {@code configValue} and an optional {@code tenantId}
   * @param uriInfo          JAX-RS URI context used to build the {@code Location} header
   * @return {@code 201 Created} with the persisted configuration and a {@code Location}
   *         header pointing to the new resource
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response createConfiguration(CreateConfigurationDto configurationDto, @Context UriInfo uriInfo);

}
