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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.batch.Batch;
import org.finos.fluxnova.bpm.engine.exception.NullValueException;
import org.finos.fluxnova.bpm.engine.impl.util.CollectionUtil;
import org.finos.fluxnova.bpm.engine.impl.util.EnsureUtil;
import org.finos.fluxnova.bpm.engine.management.SetJobRetriesByJobsAsyncBuilder;
import org.finos.fluxnova.bpm.engine.rest.JobRestService;
import org.finos.fluxnova.bpm.engine.rest.dto.CountResultDto;
import org.finos.fluxnova.bpm.engine.rest.dto.JobSuspensionResponse;
import org.finos.fluxnova.bpm.engine.rest.dto.ResponseStatus;
import org.finos.fluxnova.bpm.engine.rest.dto.batch.BatchDto;
import org.finos.fluxnova.bpm.engine.rest.dto.runtime.JobDto;
import org.finos.fluxnova.bpm.engine.rest.dto.runtime.JobQueryDto;
import org.finos.fluxnova.bpm.engine.rest.dto.runtime.JobSuspensionStateDto;
import org.finos.fluxnova.bpm.engine.rest.dto.runtime.SetJobRetriesDto;
import org.finos.fluxnova.bpm.engine.rest.dto.runtime.modification.JobActivateSuspendDto;
import org.finos.fluxnova.bpm.engine.rest.dto.runtime.modification.JobDeletionDto;
import org.finos.fluxnova.bpm.engine.rest.dto.JobDeletionResponse;
import org.finos.fluxnova.bpm.engine.rest.exception.InvalidRequestException;
import org.finos.fluxnova.bpm.engine.rest.sub.runtime.JobResource;
import org.finos.fluxnova.bpm.engine.rest.sub.runtime.impl.JobResourceImpl;
import org.finos.fluxnova.bpm.engine.rest.util.QueryUtil;
import org.finos.fluxnova.bpm.engine.runtime.Job;
import org.finos.fluxnova.bpm.engine.runtime.JobQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobRestServiceImpl extends AbstractRestProcessEngineAware
    implements JobRestService {

  private final Logger logger = LoggerFactory.getLogger(JobRestServiceImpl.class);
  private static final int MAX_JOBS_ALLOWED_FOR_SUSPEND_RESUME_OPERATION = 200;
  private static final int MAX_JOBS_ALLOWED_FOR_DELETE_OPERATION = 200;

  public JobRestServiceImpl(String engineName, ObjectMapper objectMapper) {
    super(engineName, objectMapper);
  }

  @Override
  public JobResource getJob(String jobId) {
    return new JobResourceImpl(getProcessEngine(), jobId);
  }

  @Override
  public List<JobDto> getJobs(UriInfo uriInfo, Integer firstResult,
                              Integer maxResults) {
    JobQueryDto queryDto = new JobQueryDto(getObjectMapper(), uriInfo.getQueryParameters());
    return queryJobs(queryDto, firstResult, maxResults);
  }

  @Override
  public List<JobDto> queryJobs(JobQueryDto queryDto, Integer firstResult,
                                Integer maxResults) {
    ProcessEngine engine = getProcessEngine();
    queryDto.setObjectMapper(getObjectMapper());
    JobQuery query = queryDto.toQuery(engine);

    List<Job> matchingJobs = QueryUtil.list(query, firstResult, maxResults);

    List<JobDto> jobResults = new ArrayList<>();
    for (Job job : matchingJobs) {
      JobDto resultJob = JobDto.fromJob(job);
      jobResults.add(resultJob);
    }
    return jobResults;
  }

  @Override
  public CountResultDto getJobsCount(UriInfo uriInfo) {
    JobQueryDto queryDto = new JobQueryDto(getObjectMapper(), uriInfo.getQueryParameters());
    return queryJobsCount(queryDto);
  }

  @Override
  public CountResultDto queryJobsCount(JobQueryDto queryDto) {
    ProcessEngine engine = getProcessEngine();
    queryDto.setObjectMapper(getObjectMapper());
    JobQuery query = queryDto.toQuery(engine);

    long count = query.count();
    CountResultDto result = new CountResultDto();
    result.setCount(count);

    return result;
  }

  @Override
  public BatchDto setRetries(SetJobRetriesDto setJobRetriesDto) {
    try {
      EnsureUtil.ensureNotNull("setJobRetriesDto", setJobRetriesDto);
      EnsureUtil.ensureNotNull("retries", setJobRetriesDto.getRetries());
    } catch (NullValueException e) {
      throw new InvalidRequestException(Status.BAD_REQUEST, e.getMessage());
    }
    JobQuery jobQuery = null;
    if (setJobRetriesDto.getJobQuery() != null) {
      JobQueryDto jobQueryDto = setJobRetriesDto.getJobQuery();
      jobQueryDto.setObjectMapper(getObjectMapper());
      jobQuery = jobQueryDto.toQuery(getProcessEngine());
    }

    try {
      SetJobRetriesByJobsAsyncBuilder builder = getProcessEngine().getManagementService()
          .setJobRetriesByJobsAsync(setJobRetriesDto.getRetries().intValue())
          .jobIds(setJobRetriesDto.getJobIds())
          .jobQuery(jobQuery);
      if(setJobRetriesDto.isDueDateSet()) {
        builder.dueDate(setJobRetriesDto.getDueDate());
      }
      Batch batch = builder.executeAsync();
      return BatchDto.fromBatch(batch);
    } catch (BadUserRequestException e) {
      throw new InvalidRequestException(Status.BAD_REQUEST, e.getMessage());
    }
  }

  @Override
  public void updateSuspensionState(JobSuspensionStateDto dto) {
    if (dto.getJobId() != null) {
      String message = "Either jobDefinitionId, processInstanceId, processDefinitionId or processDefinitionKey can be set to update the suspension state.";
      throw new InvalidRequestException(Status.BAD_REQUEST, message);
    }

    dto.updateSuspensionState(getProcessEngine());
  }

  @Override
  public Response updateSuspensionStateForJobs(JobActivateSuspendDto jobActivateSuspendDto) {
    // validate
    validateInputList(jobActivateSuspendDto.getJobIds(), MAX_JOBS_ALLOWED_FOR_SUSPEND_RESUME_OPERATION);
    // remove duplicates
    Set<String> jobIds = new HashSet<>(jobActivateSuspendDto.getJobIds());
    // update state
    List<JobSuspensionResponse> suspensionResponses = jobIds.stream()
            .map(jobId -> updateJobSuspensionState.apply(jobId, jobActivateSuspendDto.isSuspended()))
            .collect(Collectors.toList());

    boolean hasFailures = suspensionResponses.stream()
            .anyMatch(response -> response.getStatus().equals(ResponseStatus.FAILURE));

    if (hasFailures) {
      return Response.status(MULTI_STATUS_CODE).entity(suspensionResponses).build();
    }
    return Response.status(Status.OK).entity(suspensionResponses).build();
  }

  BiFunction<String, Boolean, JobSuspensionResponse> updateJobSuspensionState = (jobId, isSuspended) -> {
    try {
      JobResource currentJob = this.getJob(jobId);
      this.prepareSuspensionStateMapper.apply(currentJob, isSuspended).updateSuspensionState(getProcessEngine());
      return new JobSuspensionResponse(jobId, ResponseStatus.SUCCESS, null);
    } catch (Exception e) {
      logger.error("Unable to delete job id: {}", jobId, e);
      return new JobSuspensionResponse(jobId, ResponseStatus.FAILURE, e.getMessage());
    }
  };

  @Override
  public Response deleteJobs(JobDeletionDto jobDeletionDto) {

    // validate
    validateInputList(jobDeletionDto.getJobIds(), MAX_JOBS_ALLOWED_FOR_DELETE_OPERATION);
    // remove duplicates
    Set<String> jobIds = new HashSet<>(jobDeletionDto.getJobIds());
    // update state
    List<JobDeletionResponse> deleteResults = jobIds.stream().map(deleteJob).collect(Collectors.toList());

    boolean hasFailures = deleteResults.stream()
            .anyMatch(response -> response.getStatus().equals(ResponseStatus.FAILURE));

    if (hasFailures) {
      return Response.status(MULTI_STATUS_CODE).entity(deleteResults).build();
    }
    return Response.status(Status.OK).entity(deleteResults).build();
  }

  Function<String, JobDeletionResponse> deleteJob = jobId -> {
    try {
      this.getJob(jobId).deleteJob();
      return new JobDeletionResponse(jobId, ResponseStatus.SUCCESS, null);
    } catch (Exception e) {
      logger.error("Unable to delete job id: {}", jobId, e);
      return new JobDeletionResponse(jobId, ResponseStatus.FAILURE, e.getMessage());
    }
  };

  BiFunction<JobResource, Boolean, JobSuspensionStateDto> prepareSuspensionStateMapper = (jobResource, suspended) -> {
    JobSuspensionStateDto dto = new JobSuspensionStateDto();
    dto.setJobId(jobResource.getJob().getId());
    dto.setSuspended(suspended);
    return dto;
  };
  BiPredicate<List<?>, Integer> ifInputSizeExceedsLimit = (list, limit) -> list.size() > limit;

  private void validateInputList(List<String> inputList, int limit) {
    boolean invalidInput =
            CollectionUtil.isEmpty(inputList) || inputList.stream().anyMatch(id -> id == null || id.isBlank());
    if (invalidInput) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "Please supply valid job ids as input.");
    }
    if (ifInputSizeExceedsLimit.test(inputList, limit)) {
      throw new InvalidRequestException(Status.BAD_REQUEST,
              String.format("Input request exceeds the limit of %s.", limit));
    }
  }
}
