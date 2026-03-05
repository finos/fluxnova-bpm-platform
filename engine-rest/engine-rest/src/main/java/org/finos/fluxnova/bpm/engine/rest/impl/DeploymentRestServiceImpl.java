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
package org.finos.fluxnova.bpm.engine.rest.impl;

import static org.finos.fluxnova.bpm.engine.rest.dto.MultiStatusResponseCode.MULTI_STATUS_CODE;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.impl.calendar.DateTimeUtil;
import org.finos.fluxnova.bpm.engine.repository.Deployment;
import org.finos.fluxnova.bpm.engine.repository.DeploymentBuilder;
import org.finos.fluxnova.bpm.engine.repository.DeploymentQuery;
import org.finos.fluxnova.bpm.engine.repository.DeploymentWithDefinitions;
import org.finos.fluxnova.bpm.engine.rest.DeploymentRestService;
import org.finos.fluxnova.bpm.engine.rest.dto.CountResultDto;
import org.finos.fluxnova.bpm.engine.rest.dto.ResponseStatus;
import org.finos.fluxnova.bpm.engine.rest.dto.repository.DeleteDeploymentResponse;
import org.finos.fluxnova.bpm.engine.rest.dto.repository.DeleteDeploymentsDto;
import org.finos.fluxnova.bpm.engine.rest.dto.repository.DeploymentDto;
import org.finos.fluxnova.bpm.engine.rest.dto.repository.DeploymentQueryDto;
import org.finos.fluxnova.bpm.engine.rest.dto.repository.DeploymentWithDefinitionsDto;
import org.finos.fluxnova.bpm.engine.rest.exception.InvalidRequestException;
import org.finos.fluxnova.bpm.engine.rest.mapper.MultipartFormData;
import org.finos.fluxnova.bpm.engine.rest.mapper.MultipartFormData.FormPart;
import org.finos.fluxnova.bpm.engine.rest.sub.repository.DeploymentResource;
import org.finos.fluxnova.bpm.engine.rest.sub.repository.impl.DeploymentResourceImpl;
import org.finos.fluxnova.bpm.engine.rest.util.QueryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeploymentRestServiceImpl extends AbstractRestProcessEngineAware implements DeploymentRestService {

  public final static String DEPLOYMENT_NAME = "deployment-name";
  public final static String DEPLOYMENT_ACTIVATION_TIME = "deployment-activation-time";
  public final static String ENABLE_DUPLICATE_FILTERING = "enable-duplicate-filtering";
  public final static String DEPLOY_CHANGED_ONLY = "deploy-changed-only";
  public final static String DEPLOYMENT_SOURCE = "deployment-source";
  public final static String TENANT_ID = "tenant-id";

  protected static final Set<String> RESERVED_KEYWORDS = new HashSet<String>();
  private final Logger logger = LoggerFactory.getLogger(DeploymentRestServiceImpl.class);

  static {
    RESERVED_KEYWORDS.add(DEPLOYMENT_NAME);
    RESERVED_KEYWORDS.add(DEPLOYMENT_ACTIVATION_TIME);
    RESERVED_KEYWORDS.add(ENABLE_DUPLICATE_FILTERING);
    RESERVED_KEYWORDS.add(DEPLOY_CHANGED_ONLY);
    RESERVED_KEYWORDS.add(DEPLOYMENT_SOURCE);
    RESERVED_KEYWORDS.add(TENANT_ID);
  }

	public DeploymentRestServiceImpl(String engineName, ObjectMapper objectMapper) {
    super(engineName, objectMapper);
  }

  @Override
  public DeploymentResource getDeployment(String deploymentId) {
    return new DeploymentResourceImpl(getProcessEngine().getName(), deploymentId, relativeRootResourcePath, getObjectMapper());
  }

  @Override
  public List<DeploymentDto> getDeployments(UriInfo uriInfo, Integer firstResult, Integer maxResults) {
    DeploymentQueryDto queryDto = new DeploymentQueryDto(getObjectMapper(), uriInfo.getQueryParameters());

    ProcessEngine engine = getProcessEngine();
    DeploymentQuery query = queryDto.toQuery(engine);

    List<Deployment> matchingDeployments = QueryUtil.list(query, firstResult, maxResults);

    List<DeploymentDto> deployments = new ArrayList<DeploymentDto>();
    for (Deployment deployment : matchingDeployments) {
      DeploymentDto def = DeploymentDto.fromDeployment(deployment);
      deployments.add(def);
    }
    return deployments;
  }

  @Override
  public DeploymentWithDefinitionsDto createDeployment(UriInfo uriInfo, MultipartFormData payload) {
    DeploymentBuilder deploymentBuilder = extractDeploymentInformation(payload);

    if(!deploymentBuilder.getResourceNames().isEmpty()) {
      DeploymentWithDefinitions deployment = deploymentBuilder.deployWithResult();

      DeploymentWithDefinitionsDto deploymentDto = DeploymentWithDefinitionsDto.fromDeployment(deployment);


      URI uri = uriInfo.getBaseUriBuilder()
        .path(relativeRootResourcePath)
        .path(DeploymentRestService.PATH)
        .path(deployment.getId())
        .build();

      // GET
      deploymentDto.addReflexiveLink(uri, HttpMethod.GET, "self");

      return deploymentDto;

    } else {
      throw new InvalidRequestException(Status.BAD_REQUEST, "No deployment resources contained in the form upload.");
    }
  }

  private DeploymentBuilder extractDeploymentInformation(MultipartFormData payload) {
    DeploymentBuilder deploymentBuilder = getProcessEngine().getRepositoryService().createDeployment();

    Set<String> partNames = payload.getPartNames();

    for (String name : partNames) {
      FormPart part = payload.getNamedPart(name);

      if (!RESERVED_KEYWORDS.contains(name)) {
        String fileName = part.getFileName();
        if (fileName != null) {
          deploymentBuilder.addInputStream(part.getFileName(), new ByteArrayInputStream(part.getBinaryContent()));
        } else {
          throw new InvalidRequestException(Status.BAD_REQUEST, "No file name found in the deployment resource described by form parameter '" + fileName + "'.");
        }
      }
    }

    FormPart deploymentName = payload.getNamedPart(DEPLOYMENT_NAME);
    if (deploymentName != null) {
      deploymentBuilder.name(deploymentName.getTextContent());
    }

    FormPart deploymentActivationTime = payload.getNamedPart(DEPLOYMENT_ACTIVATION_TIME);
    if (deploymentActivationTime != null && !deploymentActivationTime.getTextContent().isEmpty()) {
      deploymentBuilder.activateProcessDefinitionsOn(DateTimeUtil.parseDate(deploymentActivationTime.getTextContent()));
    }

    FormPart deploymentSource = payload.getNamedPart(DEPLOYMENT_SOURCE);
    if (deploymentSource != null) {
      deploymentBuilder.source(deploymentSource.getTextContent());
    }

    FormPart deploymentTenantId = payload.getNamedPart(TENANT_ID);
    if (deploymentTenantId != null) {
      deploymentBuilder.tenantId(deploymentTenantId.getTextContent());
    }

    extractDuplicateFilteringForDeployment(payload, deploymentBuilder);
    return deploymentBuilder;
  }

  private void extractDuplicateFilteringForDeployment(MultipartFormData payload, DeploymentBuilder deploymentBuilder) {
    boolean enableDuplicateFiltering = false;
    boolean deployChangedOnly = false;

    FormPart deploymentEnableDuplicateFiltering = payload.getNamedPart(ENABLE_DUPLICATE_FILTERING);
    if (deploymentEnableDuplicateFiltering != null) {
      enableDuplicateFiltering = Boolean.parseBoolean(deploymentEnableDuplicateFiltering.getTextContent());
    }

    FormPart deploymentDeployChangedOnly = payload.getNamedPart(DEPLOY_CHANGED_ONLY);
    if (deploymentDeployChangedOnly != null) {
      deployChangedOnly = Boolean.parseBoolean(deploymentDeployChangedOnly.getTextContent());
    }

    // deployChangedOnly overrides the enableDuplicateFiltering setting
    if (deployChangedOnly) {
      deploymentBuilder.enableDuplicateFiltering(true);
    } else if (enableDuplicateFiltering) {
      deploymentBuilder.enableDuplicateFiltering(false);
    }
  }

  @Override
  public CountResultDto getDeploymentsCount(UriInfo uriInfo) {
    DeploymentQueryDto queryDto = new DeploymentQueryDto(getObjectMapper(), uriInfo.getQueryParameters());

    ProcessEngine engine = getProcessEngine();
    DeploymentQuery query = queryDto.toQuery(engine);

    long count = query.count();
    CountResultDto result = new CountResultDto();
    result.setCount(count);
    return result;
  }

  @Override
  public Set<String> getRegisteredDeployments(final UriInfo uriInfo) {
    return getProcessEngine().getManagementService().getRegisteredDeployments();
  }

  @Override
  public Response deleteDeployments(DeleteDeploymentsDto deleteDeploymentDto) {
    boolean cascade = deleteDeploymentDto.isCascade();
    boolean skipCustomListeners = deleteDeploymentDto.isSkipCustomListeners();
    boolean skipIoMappings = deleteDeploymentDto.isSkipIoMappings();

    List<DeleteDeploymentResponse> responses = deleteDeploymentDto.getDeploymentIds()
        .stream()
        .map(deploymentId -> deleteDeployment(deploymentId, cascade, skipCustomListeners, skipIoMappings))
        .collect(Collectors.toList());

    boolean hasFailures = responses.stream().anyMatch(response -> response.getStatus().equals(ResponseStatus.FAILURE));

    if (hasFailures) {
      return Response.status(MULTI_STATUS_CODE).entity(responses).build();
    }
    return Response.status(Status.OK).entity(responses).build();
  }

  private DeleteDeploymentResponse deleteDeployment(String deploymentId,
                                                    boolean cascade,
                                                    boolean skipCustomListeners,
                                                    boolean skipIoMappings) {
    ProcessEngine engine = getProcessEngine();
    RepositoryService repositoryService = engine.getRepositoryService();

    try {
      verifyDeploymentExists(deploymentId, repositoryService);
      repositoryService.deleteDeployment(deploymentId, cascade, skipCustomListeners, skipIoMappings);
      return new DeleteDeploymentResponse(deploymentId, ResponseStatus.SUCCESS, null);
    } catch (Exception e) {
      logger.error("Unable to delete deployment id: {}", deploymentId, e);
      return new DeleteDeploymentResponse(deploymentId, ResponseStatus.FAILURE, e.getMessage());
    }
  }

  private void verifyDeploymentExists(String deploymentId, RepositoryService repositoryService) {
    Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
    if (deployment == null) {
      throw new InvalidRequestException(Status.NOT_FOUND, "Deployment with id '" + deploymentId + "' does not exist");
    }
  }
}
