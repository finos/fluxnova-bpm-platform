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
package org.finos.fluxnova.bpm.engine.rest.sub.task.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.finos.fluxnova.bpm.engine.AuthorizationException;
import org.finos.fluxnova.bpm.engine.IdentityService;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngineException;
import org.finos.fluxnova.bpm.engine.TaskService;
import org.finos.fluxnova.bpm.engine.exception.NullValueException;
import org.finos.fluxnova.bpm.engine.history.HistoricTaskInstance;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.identity.Authentication;
import org.finos.fluxnova.bpm.engine.rest.TaskRestService;
import org.finos.fluxnova.bpm.engine.rest.dto.ResponseStatus;
import org.finos.fluxnova.bpm.engine.rest.dto.TaskCreateCommentResponse;
import org.finos.fluxnova.bpm.engine.rest.dto.task.CommentDto;
import org.finos.fluxnova.bpm.engine.rest.exception.InvalidRequestException;
import org.finos.fluxnova.bpm.engine.rest.sub.task.TaskCommentResource;
import org.finos.fluxnova.bpm.engine.rest.sub.task.TaskCommentsResource;
import org.finos.fluxnova.bpm.engine.task.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.finos.fluxnova.bpm.engine.rest.dto.MultiStatusResponseCode.MULTI_STATUS_CODE;

public class TaskCommentResourceImpl implements TaskCommentResource, TaskCommentsResource {

  private final Logger logger = LoggerFactory.getLogger(TaskCommentResourceImpl.class);

  public static final int MAX_COMMENT_CREATE_ALLOWED = 100;

  private ProcessEngine engine;
  private String taskId;
  private String rootResourcePath;

  public TaskCommentResourceImpl(ProcessEngine engine, String taskId, String rootResourcePath) {
    this.engine = engine;
    this.taskId = taskId;
    this.rootResourcePath = rootResourcePath;
  }

  public TaskCommentResourceImpl(ProcessEngine engine, String rootResourcePath) {
    this.engine = engine;
    this.rootResourcePath = rootResourcePath;
  }

  public List<CommentDto> getComments() {
    if (!isHistoryEnabled()) {
      return Collections.emptyList();
    }

    ensureTaskExists(Status.NOT_FOUND);

    List<Comment> taskComments = engine.getTaskService().getTaskComments(taskId);

    List<CommentDto> comments = new ArrayList<CommentDto>();
    for (Comment comment : taskComments) {
      comments.add(CommentDto.fromComment(comment));
    }

    return comments;
  }

  public CommentDto getComment(String commentId) {
    ensureHistoryEnabled(Status.NOT_FOUND);

    Comment comment = engine.getTaskService().getTaskComment(taskId, commentId);
    if (comment == null) {
      throw new InvalidRequestException(Status.NOT_FOUND, "Task comment with id " + commentId + " does not exist for task id '" + taskId + "'.");
    }

    return CommentDto.fromComment(comment);
  }

  public void deleteComment(String commentId) {
    ensureHistoryEnabled(Status.FORBIDDEN);
    ensureTaskExists(Status.NOT_FOUND);

    TaskService taskService = engine.getTaskService();
    try {
      taskService.deleteTaskComment(taskId, commentId);
    } catch (AuthorizationException e) {
      throw e;
    } catch (NullValueException e) {
      throw new InvalidRequestException(Status.BAD_REQUEST, e.getMessage());
    }
  }

  public void updateComment(CommentDto comment) {
    ensureHistoryEnabled(Status.FORBIDDEN);
    ensureTaskExists(Status.NOT_FOUND);

    try {
      engine.getTaskService().updateTaskComment(taskId, comment.getId(), comment.getMessage());
    } catch (AuthorizationException e) {
      throw e;
    } catch (NullValueException e) {
      throw new InvalidRequestException(Status.BAD_REQUEST, e.getMessage());
    }
  }

  public void deleteComments() {
    ensureHistoryEnabled(Status.FORBIDDEN);
    ensureTaskExists(Status.NOT_FOUND);
    TaskService taskService = engine.getTaskService();

    try {
      taskService.deleteTaskComments(taskId);
    } catch (AuthorizationException e) {
      throw e;
    } catch (NullValueException e) {
      throw new InvalidRequestException(Status.BAD_REQUEST, e.getMessage());
    }
  }

  public CommentDto createComment(UriInfo uriInfo, CommentDto commentDto) {
    ensureHistoryEnabled(Status.FORBIDDEN);
    ensureTaskExists(Status.BAD_REQUEST);

    Comment comment;

    String processInstanceId = commentDto.getProcessInstanceId();
    try {
      comment = engine.getTaskService().createComment(taskId, processInstanceId, commentDto.getMessage());
    }
    catch (ProcessEngineException e) {
      throw new InvalidRequestException(Status.BAD_REQUEST, e, "Not enough parameters submitted");
    }

    URI uri = uriInfo.getBaseUriBuilder()
            .path(rootResourcePath)
            .path(TaskRestService.PATH)
            .path(taskId + "/comment/" + comment.getId())
            .build();

    CommentDto resultDto = CommentDto.fromComment(comment);

    // GET /
    resultDto.addReflexiveLink(uri, HttpMethod.GET, "self");

    return resultDto;
  }

  private boolean isHistoryEnabled() {
    IdentityService identityService = engine.getIdentityService();
    Authentication currentAuthentication = identityService.getCurrentAuthentication();
    try {
      identityService.clearAuthentication();
      int historyLevel = engine.getManagementService().getHistoryLevel();
      return historyLevel > ProcessEngineConfigurationImpl.HISTORYLEVEL_NONE;
    } finally {
      identityService.setAuthentication(currentAuthentication);
    }
  }

  private void ensureHistoryEnabled(Status status) {
    if (!isHistoryEnabled()) {
      throw new InvalidRequestException(status, "History is not enabled");
    }
  }

  private void ensureTaskExists(Status status) {
    HistoricTaskInstance historicTaskInstance = engine.getHistoryService().createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
    if (historicTaskInstance == null) {
      throw new InvalidRequestException(status, "No task found for task id " + taskId);
    }
  }

  public Response createTaskComments(UriInfo uriInfo, List<CommentDto> commentDtos) {
    validateInputs(commentDtos);

    List<TaskCreateCommentResponse> responses = commentDtos.stream()
            .map(aComment -> processCreateBulkComment(aComment, uriInfo))
            .collect(Collectors.toList());

    boolean hasFailures = responses.stream()
            .anyMatch(response -> response.getStatus().equals(ResponseStatus.FAILURE));

    if (hasFailures) {
      return Response.status(MULTI_STATUS_CODE).entity(responses).build();
    }
    return Response.status(Status.OK).entity(responses).build();

  }

  private TaskCreateCommentResponse processCreateBulkComment(CommentDto commentDto, UriInfo uriInfo) {

    try {
      this.taskId = commentDto.getTaskId();
      CommentDto created = createComment(uriInfo, commentDto);
      return new TaskCreateCommentResponse(created, ResponseStatus.SUCCESS, null);
    } catch (Exception e) {
      logger.error("Unable to create comment for task id: {}", commentDto.getTaskId(), e);
      return new TaskCreateCommentResponse(commentDto, ResponseStatus.FAILURE, e.getMessage());
    }
  }

  private void validateInputs(List<CommentDto> commentDtos) {
    if (commentDtos.size() > MAX_COMMENT_CREATE_ALLOWED) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "The request exceeds the limit of 100 tasks objects.");
    }

    boolean allCommentsHaveTaskId = commentDtos.stream().allMatch(comment -> comment.getTaskId() != null);

    if (!allCommentsHaveTaskId) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "One or more request objects are missing taskId");
    }

  }
}
