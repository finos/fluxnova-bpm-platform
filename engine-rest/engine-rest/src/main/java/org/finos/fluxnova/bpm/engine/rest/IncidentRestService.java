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

import org.finos.fluxnova.bpm.engine.rest.dto.CountResultDto;
import org.finos.fluxnova.bpm.engine.rest.dto.ProcessInstanceIncidentCountStatisticsDto;
import org.finos.fluxnova.bpm.engine.rest.dto.runtime.IncidentDto;
import org.finos.fluxnova.bpm.engine.rest.dto.runtime.ProcessInstanceIncidentCountRequestDto;
import org.finos.fluxnova.bpm.engine.rest.sub.runtime.IncidentResource;
import org.finos.fluxnova.bpm.engine.runtime.IncidentQuery;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * @author Roman Smirnov
 *
 */
@Produces(MediaType.APPLICATION_JSON)
public interface IncidentRestService {

  public static final String PATH = "/incident";

  /**
   * Exposes the {@link IncidentQuery} interface as a REST service.
   * @param uriInfo
   * @param firstResult
   * @param maxResults
   * @return
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  List<IncidentDto> getIncidents(@Context UriInfo uriInfo,
      @QueryParam("firstResult") Integer firstResult, @QueryParam("maxResults") Integer maxResults);

  @GET
  @Path("/count")
  @Produces(MediaType.APPLICATION_JSON)
  CountResultDto getIncidentsCount(@Context UriInfo uriInfo);

  @Path("/{id}")
  IncidentResource getIncident(@PathParam("id") String incidentId);

  /**
   * Retrieves statistics about incidents grouped by process instance, based on the provided request criteria.
   * <p>
   * This endpoint accepts a {@link ProcessInstanceIncidentCountRequestDto} in the request body, which can specify
   * various filters and grouping options. The response is a list of {@link ProcessInstanceIncidentCountStatisticsDto}
   * objects, each representing aggregated incident statistics for process instances matching the criteria.
   * <p>
   * Typical use cases include reporting, monitoring, or dashboarding scenarios where grouped or filtered
   * incident counts are required for process instances.
   *
   * @param request the request object containing filtering and grouping criteria
   * @return a list of statistics objects, each containing incident count information for a group of process instances
   */
  @POST
  @Path("/process-instance-statistics")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  List<ProcessInstanceIncidentCountStatisticsDto> getProcessInstanceIncidentStatistics(
          ProcessInstanceIncidentCountRequestDto request);
}
