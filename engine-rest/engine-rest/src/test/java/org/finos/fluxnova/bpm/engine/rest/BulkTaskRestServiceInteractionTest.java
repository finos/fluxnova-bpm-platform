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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.finos.fluxnova.bpm.ProcessApplicationService;
import org.finos.fluxnova.bpm.application.ProcessApplicationInfo;
import org.finos.fluxnova.bpm.container.RuntimeContainerDelegate;
import org.finos.fluxnova.bpm.engine.*;
import org.finos.fluxnova.bpm.engine.form.TaskFormData;
import org.finos.fluxnova.bpm.engine.history.HistoricTaskInstance;
import org.finos.fluxnova.bpm.engine.history.HistoricTaskInstanceQuery;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.repository.ProcessDefinition;
import org.finos.fluxnova.bpm.engine.rest.dto.ResponseStatus;
import org.finos.fluxnova.bpm.engine.rest.dto.TaskCreateCommentResponse;
import org.finos.fluxnova.bpm.engine.rest.dto.TaskUpdateResponse;
import org.finos.fluxnova.bpm.engine.rest.dto.task.*;
import org.finos.fluxnova.bpm.engine.rest.exception.InvalidRequestException;
import org.finos.fluxnova.bpm.engine.rest.helper.MockProvider;
import org.finos.fluxnova.bpm.engine.rest.util.container.TestContainerRule;
import org.finos.fluxnova.bpm.engine.task.*;
import org.finos.fluxnova.bpm.engine.variable.VariableMap;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.finos.fluxnova.bpm.engine.rest.dto.MultiStatusResponseCode.MULTI_STATUS_CODE;
import static org.finos.fluxnova.bpm.engine.rest.helper.MockProvider.*;
import static org.finos.fluxnova.bpm.engine.rest.impl.BulkTaskRestServiceImpl.MAX_TASK_UPDATE_ALLOWED;
import static org.finos.fluxnova.bpm.engine.rest.sub.task.impl.TaskCommentResourceImpl.MAX_COMMENT_CREATE_ALLOWED;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BulkTaskRestServiceInteractionTest extends
    AbstractRestServiceTest {

  @ClassRule
  public static TestContainerRule rule = new TestContainerRule();

  protected static final String BULK_TASK_SERVICE_URL = TEST_RESOURCE_ROOT_PATH + "/bulk/task";
  protected static final String COMPLETE_TASKS_URL = BULK_TASK_SERVICE_URL + "/complete";
  protected static final String TASKS_ASSIGN_URL = BULK_TASK_SERVICE_URL + "/assign";
  protected static final String MULTIPLE_TASK_COMMENTS_CREATE_URL = BULK_TASK_SERVICE_URL + "/comment/create";
  protected static final String TASK_CREATE_URL = BULK_TASK_SERVICE_URL + "/create";
  protected static final String TASK_UPDATE = BULK_TASK_SERVICE_URL + "/update";

  private TaskService taskService;
  private Task mockTask;
  private TaskService taskServiceMock;
  private TaskQuery mockQuery;
  private FormService formServiceMock;
  private ManagementService managementServiceMock;
  private RepositoryService repositoryServiceMock;

  private HistoricTaskInstanceQuery historicTaskInstanceQueryMock;

  private Comment mockTaskComment;
  private List<Comment> mockTaskComments;

  private Attachment mockTaskAttachment;
  private List<Attachment> mockTaskAttachments;

  @Before
  public void setUpRuntimeData() {
    taskServiceMock = mock(TaskService.class);
    when(processEngine.getTaskService()).thenReturn(taskServiceMock);
    taskService = processEngine.getTaskService();


    mockTask = MockProvider.createMockTask();
    mockQuery = mock(TaskQuery.class);
    when(mockQuery.initializeFormKeys()).thenReturn(mockQuery);
    when(mockQuery.taskId(any())).thenReturn(mockQuery);
    when(mockQuery.withCommentAttachmentInfo()).thenReturn(mockQuery);
    when(mockQuery.singleResult()).thenReturn(mockTask);
    when(taskServiceMock.createTaskQuery()).thenReturn(mockQuery);

    mockTaskComment = MockProvider.createMockTaskComment();
    when(taskServiceMock.getTaskComment(EXAMPLE_TASK_ID, EXAMPLE_TASK_COMMENT_ID)).thenReturn(mockTaskComment);
    mockTaskComments = MockProvider.createMockTaskComments();
    when(taskServiceMock.getTaskComments(EXAMPLE_TASK_ID)).thenReturn(mockTaskComments);
    when(taskServiceMock.createComment(EXAMPLE_TASK_ID, null, EXAMPLE_TASK_COMMENT_FULL_MESSAGE)).thenReturn(mockTaskComment);

    mockTaskAttachment = MockProvider.createMockTaskAttachment();
    when(taskServiceMock.getTaskAttachment(EXAMPLE_TASK_ID, EXAMPLE_TASK_ATTACHMENT_ID)).thenReturn(mockTaskAttachment);
    mockTaskAttachments = MockProvider.createMockTaskAttachments();
    when(taskServiceMock.getTaskAttachments(EXAMPLE_TASK_ID)).thenReturn(mockTaskAttachments);
    when(taskServiceMock.createAttachment(any(), any(), any(), any(), any(), Mockito.<String>any())).thenReturn(mockTaskAttachment);
    when(taskServiceMock.createAttachment(any(), any(), any(), any(), any(), Mockito.<InputStream>any())).thenReturn(mockTaskAttachment);
    when(taskServiceMock.getTaskAttachmentContent(EXAMPLE_TASK_ID, EXAMPLE_TASK_ATTACHMENT_ID)).thenReturn(new ByteArrayInputStream(createMockByteData()));

    formServiceMock = mock(FormService.class);
    when(processEngine.getFormService()).thenReturn(formServiceMock);
    TaskFormData mockFormData = MockProvider.createMockTaskFormData();
    when(formServiceMock.getTaskFormData(any())).thenReturn(mockFormData);
    when(formServiceMock.getTaskFormKey(any(), any())).thenReturn(MockProvider.EXAMPLE_FORM_KEY);


    repositoryServiceMock = mock(RepositoryService.class);
    when(processEngine.getRepositoryService()).thenReturn(repositoryServiceMock);
    ProcessDefinition mockDefinition = MockProvider.createMockDefinition();
    when(repositoryServiceMock.getProcessDefinition(MockProvider.EXAMPLE_PROCESS_DEFINITION_ID)).thenReturn(mockDefinition);

    managementServiceMock = mock(ManagementService.class);
    when(processEngine.getManagementService()).thenReturn(managementServiceMock);
    when(managementServiceMock.getProcessApplicationForDeployment(MockProvider.EXAMPLE_DEPLOYMENT_ID)).thenReturn(MockProvider.EXAMPLE_PROCESS_APPLICATION_NAME);
    when(managementServiceMock.getHistoryLevel()).thenReturn(ProcessEngineConfigurationImpl.HISTORYLEVEL_FULL);

    HistoryService historyServiceMock = mock(HistoryService.class);
    when(processEngine.getHistoryService()).thenReturn(historyServiceMock);
    historicTaskInstanceQueryMock = mock(HistoricTaskInstanceQuery.class);
    when(historyServiceMock.createHistoricTaskInstanceQuery()).thenReturn(historicTaskInstanceQueryMock);
    when(historicTaskInstanceQueryMock.taskId(eq(EXAMPLE_TASK_ID))).thenReturn(historicTaskInstanceQueryMock);
    HistoricTaskInstance historicTaskInstanceMock = createMockHistoricTaskInstance();
    when(historicTaskInstanceQueryMock.singleResult()).thenReturn(historicTaskInstanceMock);

    // replace the runtime container delegate & process application service with a mock

    ProcessApplicationService processApplicationService = mock(ProcessApplicationService.class);
    ProcessApplicationInfo appMock = MockProvider.createMockProcessApplicationInfo();
    when(processApplicationService.getProcessApplicationInfo(MockProvider.EXAMPLE_PROCESS_APPLICATION_NAME)).thenReturn(appMock);

    RuntimeContainerDelegate delegate = mock(RuntimeContainerDelegate.class);
    when(delegate.getProcessApplicationService()).thenReturn(processApplicationService);
    RuntimeContainerDelegate.INSTANCE.set(delegate);
  }

  private byte[] createMockByteData() {
    return "someContent".getBytes();
  }



  @Test
  public void testAssignTasksAllFailure() throws ParseException {
    doThrow(new ProcessEngineException("expected exception")).when(taskServiceMock).setAssignee(any(),any());

    Map<String, Object> json = new HashMap<>();
    json.put("taskIds", Arrays.asList(EXAMPLE_TASK_ID,EXAMPLE_TASK_ID2));
    json.put("userId", EXAMPLE_USER_ID);

    Response restResponse = given().body(json)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(TASKS_ASSIGN_URL);

    List<TaskUpdateResponse> updateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskUpdateResponse.class);

    MatcherAssert.assertThat(updateResponse, everyItem(hasProperty("status", equalTo(ResponseStatus.FAILURE))));
    MatcherAssert.assertThat(updateResponse, everyItem(hasProperty("errorMessage", equalTo("expected exception"))));

    MatcherAssert.assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(EXAMPLE_TASK_ID))));
    MatcherAssert.assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(EXAMPLE_TASK_ID2))));

    // Verify that setAssignee was called twice
    verify(taskServiceMock, times(2)).setAssignee(anyString(),anyString());
  }

  @Test
  public void testAssignTasksAllSuccess() throws ParseException {
    Map<String, Object> json = new HashMap<>();
    json.put("taskIds", Arrays.asList(EXAMPLE_TASK_ID,EXAMPLE_TASK_ID2));
    json.put("userId", EXAMPLE_USER_ID);

    Response restResponse = given().body(json)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(Status.OK.getStatusCode())
        .when()
        .post(TASKS_ASSIGN_URL);

    List<TaskUpdateResponse> updateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskUpdateResponse.class);

    MatcherAssert.assertThat(updateResponse, everyItem(hasProperty("status", equalTo(ResponseStatus.SUCCESS))));
    MatcherAssert.assertThat(updateResponse, everyItem(hasProperty("errorMessage", equalTo(null))));

    MatcherAssert.assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(EXAMPLE_TASK_ID))));
    MatcherAssert.assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(EXAMPLE_TASK_ID2))));

    // Verify that setAssignee was called twice
    verify(taskServiceMock, times(2)).setAssignee(anyString(),anyString());
  }

  @Test
  public void testAssignTasksPartialFailure() throws ParseException {
    doThrow(new ProcessEngineException("expected exception")).when(taskServiceMock).setAssignee(EXAMPLE_TASK_ID,EXAMPLE_USER_ID);

    Map<String, Object> json = new HashMap<>();
    json.put("taskIds", Arrays.asList(EXAMPLE_TASK_ID,EXAMPLE_TASK_ID2));
    json.put("userId", EXAMPLE_USER_ID);

    Response restResponse = given().body(json)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(TASKS_ASSIGN_URL);

    List<TaskUpdateResponse> updateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskUpdateResponse.class);

    MatcherAssert.assertThat(updateResponse.get(0).getTaskId(), equalTo(EXAMPLE_TASK_ID));
    MatcherAssert.assertThat(updateResponse.get(0).getStatus(), equalTo(ResponseStatus.FAILURE));
    MatcherAssert.assertThat(updateResponse.get(0).getErrorMessage(), equalTo("expected exception"));

    MatcherAssert.assertThat(updateResponse.get(1).getTaskId(), equalTo(EXAMPLE_TASK_ID2));
    MatcherAssert.assertThat(updateResponse.get(1).getStatus(), equalTo(ResponseStatus.SUCCESS));
    MatcherAssert.assertThat(updateResponse.get(1).getErrorMessage(), equalTo(null));

    // Verify that setAssignee was called twice
    verify(taskServiceMock, times(2)).setAssignee(anyString(),anyString());
  }

  @Test
  public void testAssignTasksThrowsAuthorizationException() {
    Map<String, Object> json = new HashMap<>();
    json.put("taskIds", Arrays.asList(EXAMPLE_TASK_ID,EXAMPLE_TASK_ID2));
    json.put("userId", EXAMPLE_USER_ID);

    String message = "expected exception";
    doThrow(new AuthorizationException(message)).when(taskServiceMock).setAssignee(any(), any());

    Response restResponse = given()
        .contentType(POST_JSON_CONTENT_TYPE)
        .body(json)
        .then().expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(TASKS_ASSIGN_URL);

    List<TaskUpdateResponse> updateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskUpdateResponse.class);

    // Asserts the response
    MatcherAssert.assertThat(updateResponse, everyItem(hasProperty("status", equalTo(ResponseStatus.FAILURE))));
    MatcherAssert.assertThat(updateResponse, everyItem(hasProperty("errorMessage", equalTo("expected exception"))));

    MatcherAssert.assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(EXAMPLE_TASK_ID))));
    MatcherAssert.assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(EXAMPLE_TASK_ID2))));

    // Verify that setAssignee was called twice
    verify(taskServiceMock, times(2)).setAssignee(anyString(),anyString());

  }

  @Test
  public void testAssignTasksForDuplicates() throws ParseException {
    Map<String, Object> json = new HashMap<>();
    json.put("taskIds", Arrays.asList(EXAMPLE_TASK_ID,EXAMPLE_TASK_ID2,EXAMPLE_TASK_ID));
    json.put("userId", EXAMPLE_USER_ID);

    Response restResponse = given().body(json)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(Status.OK.getStatusCode())
        .when()
        .post(TASKS_ASSIGN_URL);

    // Verify that setAssignee was called twice removing duplicates
    verify(taskServiceMock, times(2)).setAssignee(anyString(),anyString());
  }

  @Test
  public void testUpdateTasksAllSuccess() throws ParseException {
    String taskOneId = "taskOneId";
    String taskTwoId = "taskTwoId";

    List<TaskDto> taskDtos = Arrays.asList(createTaskDto(taskOneId), createTaskDto(taskTwoId));
    Task taskOne = processEngine.getTaskService().createTaskQuery().taskId(taskOneId).singleResult();
    Task taskTwo = processEngine.getTaskService().createTaskQuery().taskId(taskTwoId).singleResult();

    TaskQuery taskQuery = mock(TaskQuery.class);
    when(taskService.createTaskQuery()).thenReturn(taskQuery);
    when(taskQuery.initializeFormKeys()).thenReturn(taskQuery);
    when(taskQuery.taskId(taskOneId)).thenReturn(taskQuery);
    when(taskQuery.taskId(taskTwoId)).thenReturn(taskQuery);
    when(taskQuery.singleResult()).thenReturn(taskOne).thenReturn(taskTwo);

    Response restResponse = given().body(taskDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(Status.OK.getStatusCode())
        .when()
        .post(TASK_UPDATE);

    List<TaskUpdateResponse> updateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskUpdateResponse.class);

    assertThat(updateResponse, everyItem(hasProperty("status", equalTo(ResponseStatus.SUCCESS))));
    assertThat(updateResponse, everyItem(hasProperty("errorMessage", equalTo(null))));

    assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(taskOneId))));
    assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(taskTwoId))));

    // Verify that saveTask was called twice
    verify(taskService, times(2)).saveTask(any(Task.class));
  }

  @Test
  public void testUpdateTasksAllFailures() throws ParseException {
    String taskOneId = "taskOneId";
    String taskTwoId = "taskTwoId";

    List<TaskDto> taskDtos = Arrays.asList(createTaskDto(taskOneId), createTaskDto(taskTwoId));

    TaskQuery taskQuery = mock(TaskQuery.class);
    when(taskService.createTaskQuery()).thenReturn(taskQuery);
    when(taskQuery.initializeFormKeys()).thenReturn(taskQuery);
    when(taskQuery.taskId(anyString())).thenReturn(taskQuery);
    when(taskQuery.singleResult()).thenReturn(null);

    Response restResponse = given().body(taskDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(TASK_UPDATE);

    // Adjust the assertion based on the actual response structure
    List<TaskUpdateResponse> updateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskUpdateResponse.class);

    assertThat(updateResponse, everyItem(hasProperty("status", equalTo(ResponseStatus.FAILURE))));
    assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(taskOneId))));
    assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(taskTwoId))));
    assertThat(updateResponse,
        hasItem(hasProperty("errorMessage", equalTo("Task id: " + taskOneId + " cannot be found."))));
    assertThat(updateResponse,
        hasItem(hasProperty("errorMessage", equalTo("Task id: " + taskTwoId + " cannot be found."))));

    // Verify that saveTask was not called
    verify(taskService, times(0)).saveTask(any(Task.class));
  }

  @Test
  public void testUpdateTasksPartialFailures() throws ParseException {
    String taskOneId = "taskOneId";
    String taskTwoId = "taskTwoId";

    List<TaskDto> taskDtos = Arrays.asList(createTaskDto(taskOneId), createTaskDto(taskTwoId));

    Task taskOne = mock(Task.class);

    TaskQuery taskQuery = mock(TaskQuery.class);
    when(taskService.createTaskQuery()).thenReturn(taskQuery);
    when(taskQuery.initializeFormKeys()).thenReturn(taskQuery);
    when(taskQuery.taskId(taskOneId)).thenReturn(taskQuery);
    when(taskQuery.taskId(taskTwoId)).thenReturn(taskQuery);
    when(taskQuery.singleResult()).thenReturn(taskOne)
        .thenThrow(new InvalidRequestException(Status.BAD_REQUEST, "Task id: " + taskTwoId + " cannot be found."));

    Response restResponse = given().body(taskDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(TASK_UPDATE);

    List<TaskUpdateResponse> updateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskUpdateResponse.class);

    assertThat(updateResponse, hasItem(hasProperty("status", equalTo(ResponseStatus.SUCCESS))));
    assertThat(updateResponse, hasItem(hasProperty("status", equalTo(ResponseStatus.FAILURE))));
    assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(taskOneId))));
    assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(taskTwoId))));
    assertThat(updateResponse,
        hasItem(hasProperty("errorMessage", equalTo("Task id: " + taskTwoId + " cannot be found."))));

    verify(taskService, times(1)).saveTask(any(Task.class));
  }

  @Test
  public void testUpdateTasksInvalidAuthorization() throws ParseException {
    String taskOneId = "taskOneId";
    String taskTwoId = "taskTwoId";

    List<TaskDto> taskDtos = Arrays.asList(createTaskDto(taskOneId), createTaskDto(taskTwoId));

    Task taskOne = mock(Task.class);
    Task taskTwo = mock(Task.class);

    TaskQuery taskQuery = mock(TaskQuery.class);
    when(taskService.createTaskQuery()).thenReturn(taskQuery);
    when(taskQuery.initializeFormKeys()).thenReturn(taskQuery);
    when(taskQuery.taskId(taskOneId)).thenReturn(taskQuery);
    when(taskQuery.taskId(taskTwoId)).thenReturn(taskQuery);
    when(taskQuery.singleResult()).thenReturn(taskOne).thenReturn(taskTwo);

    doThrow(new AuthorizationException("User does not have access to update the task " + taskOneId)).when(taskService)
        .saveTask(taskOne);
    doThrow(new AuthorizationException("User does not have access to update the task " + taskTwoId)).when(taskService)
        .saveTask(taskTwo);

    Response restResponse = given().body(taskDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(TASK_UPDATE);

    List<TaskUpdateResponse> updateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskUpdateResponse.class);

    assertThat(updateResponse, everyItem(hasProperty("status", equalTo(ResponseStatus.FAILURE))));
    assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(taskOneId))));
    assertThat(updateResponse, hasItem(hasProperty("taskId", equalTo(taskTwoId))));
    assertThat(updateResponse,
        everyItem(hasProperty("errorMessage", containsString("User does not have access to update the task"))));

    // Verify that saveTask was called twice
    verify(taskService, times(2)).saveTask(any(Task.class));
  }

  @Test
  public void testUpdateTasksDuplicateIds() throws ParseException {
    String duplicateId = "duplicateId";

    List<TaskDto> taskDtos = Arrays.asList(createTaskDto(duplicateId), createTaskDto(duplicateId));

    given().body(taskDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(Status.BAD_REQUEST.getStatusCode())
        .when()
        .post(TASK_UPDATE)
        .then()
        .assertThat()
        .body(containsString("The request includes duplicate task IDs."));
  }

  @Test
  public void testUpdateTasksMoreThan100Items() throws ParseException {
    List<TaskDto> taskDtos = createMaxAllowedPlusOneDtos();
    given().body(taskDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(Status.BAD_REQUEST.getStatusCode())
        .when()
        .post(TASK_UPDATE)
        .then()
        .assertThat()
        .body(containsString("The request exceeds the limit of 100 tasks objects."));

  }

  private TaskDto createTaskDto(String taskId) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    TaskDto dto = new TaskDto();
    dto.setId(taskId);
    dto.setDescription("description");
    dto.setName(taskId);
    dto.setPriority(0);
    dto.setAssignee("taskassignee");
    dto.setDelegationState(DelegationState.PENDING.toString());
    dto.setOwner("taskowner");
    Date dueDate = sdf.parse("01/02/2003 04:05:06");
    dto.setDue(dueDate);
    Date followUpDate = sdf.parse("01/02/2004 04:05:06");
    dto.setFollowUp(followUpDate);
    dto.setParentTaskId("parentTaskId");
    dto.setCaseInstanceId("taskcaseinstanceid");
    return dto;
  }

  private List<TaskDto> createMaxAllowedPlusOneDtos() throws ParseException {
    List<TaskDto> taskDtos = new ArrayList<>();
    for (int i = 0; i < MAX_TASK_UPDATE_ALLOWED + 1; i++) {
      taskDtos.add(createTaskDto(String.valueOf(i)));
    }
    return taskDtos;
  }

  @Test
  public void testCreateTaskCommentsAllSuccess() {
    List<CommentDto> commentDtos = Arrays.asList(
        createTaskCommentsDto(EXAMPLE_TASK_ID, EXAMPLE_TASK_COMMENT_FULL_MESSAGE),
        createTaskCommentsDto(EXAMPLE_TASK_ID, EXAMPLE_TASK_COMMENT_FULL_MESSAGE));

    // Mocking the task service for the existing task ID
    when(taskServiceMock.createComment(EXAMPLE_TASK_ID, null, EXAMPLE_TASK_COMMENT_FULL_MESSAGE)).thenReturn(
        mockTaskComment);

    // Sending the request
    Response restResponse = given().body(commentDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(Status.OK.getStatusCode())
        .when()
        .post(MULTIPLE_TASK_COMMENTS_CREATE_URL);

    // Parsing the response
    List<TaskCreateCommentResponse> taskUpdateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskCreateCommentResponse.class);

    // Assertions for success
    assertThat(taskUpdateResponse,
        everyItem(hasProperty("status", equalTo(ResponseStatus.SUCCESS))));
    assertThat(taskUpdateResponse, everyItem(hasProperty("errorMessage", equalTo(null))));

    // Verify that createComment was called twice
    verify(taskServiceMock, times(2)).createComment(EXAMPLE_TASK_ID, null, EXAMPLE_TASK_COMMENT_FULL_MESSAGE);
  }

  @Test
  public void testCreateTaskCommentsAllFailures() {
    List<CommentDto> commentDtos = Arrays.asList(
        createTaskCommentsDto(NON_EXISTING_ID, EXAMPLE_TASK_COMMENT_FULL_MESSAGE),
        createTaskCommentsDto(NON_EXISTING_ID, EXAMPLE_TASK_COMMENT_FULL_MESSAGE));

    // Mocking the historic task instance query for the non-existing task ID
    when(historicTaskInstanceQueryMock.taskId(NON_EXISTING_ID)).thenReturn(historicTaskInstanceQueryMock);
    when(historicTaskInstanceQueryMock.singleResult()).thenReturn(null);

    // Sending the request
    Response restResponse = given().body(commentDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(MULTIPLE_TASK_COMMENTS_CREATE_URL);

    // Parsing the response
    List<TaskCreateCommentResponse> taskUpdateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskCreateCommentResponse.class);

    // Assertions for failure
    assertThat(taskUpdateResponse,everyItem(hasProperty("status", equalTo(ResponseStatus.FAILURE))));
    assertThat(taskUpdateResponse,everyItem(hasProperty("errorMessage", equalTo("No task found for task id " + NON_EXISTING_ID))));

    // Verify that createComment was not called for the non-existing task ID
    verify(taskServiceMock, times(0)).createComment(NON_EXISTING_ID, null, EXAMPLE_TASK_COMMENT_FULL_MESSAGE);
  }

  @Test
  public void testCreateTaskCommentsPartialFailures() {
    List<CommentDto> commentDtos = Arrays.asList(
        createTaskCommentsDto(NON_EXISTING_ID, EXAMPLE_TASK_COMMENT_FULL_MESSAGE),
        createTaskCommentsDto(EXAMPLE_TASK_ID, EXAMPLE_TASK_COMMENT_FULL_MESSAGE));

    // Mocking the task service for the existing task ID
    when(taskServiceMock.createComment(EXAMPLE_TASK_ID, null, EXAMPLE_TASK_COMMENT_FULL_MESSAGE)).thenReturn(
        mockTaskComment);

    // Mocking the historic task instance query for the non-existing task ID
    HistoricTaskInstanceQuery nonExistingTaskQueryMock = mock(HistoricTaskInstanceQuery.class);
    when(nonExistingTaskQueryMock.taskId(NON_EXISTING_ID)).thenReturn(nonExistingTaskQueryMock);
    when(nonExistingTaskQueryMock.singleResult()).thenReturn(null);

    // Mocking the historic task instance query for the existing task ID
    HistoricTaskInstanceQuery existingTaskQueryMock = mock(HistoricTaskInstanceQuery.class);
    when(existingTaskQueryMock.taskId(eq(EXAMPLE_TASK_ID))).thenReturn(existingTaskQueryMock);
    HistoricTaskInstance historicTaskInstanceMock = createMockHistoricTaskInstance();
    when(existingTaskQueryMock.singleResult()).thenReturn(historicTaskInstanceMock);

    // Sending the request
    Response restResponse = given().body(commentDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(MULTIPLE_TASK_COMMENTS_CREATE_URL);

    // Parsing the response
    List<TaskCreateCommentResponse> taskUpdateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskCreateCommentResponse.class);

    // Assertions for both success and failure
    assertThat(taskUpdateResponse, hasItem(hasProperty("status", equalTo(ResponseStatus.FAILURE))));
    assertThat(taskUpdateResponse, hasItem(hasProperty("status", equalTo(ResponseStatus.SUCCESS))));
    assertThat(taskUpdateResponse, hasItem(hasProperty("errorMessage", equalTo(null))));
    assertThat(taskUpdateResponse, hasItem(hasProperty("errorMessage", notNullValue())));

    // Verify that createComment was called correctly
    verify(taskServiceMock, times(0)).createComment(NON_EXISTING_ID, null, EXAMPLE_TASK_COMMENT_FULL_MESSAGE);
    verify(taskServiceMock, times(1)).createComment(EXAMPLE_TASK_ID, null, EXAMPLE_TASK_COMMENT_FULL_MESSAGE);

  }

  @Test
  public void testCreateTaskCommentsWithProcessInstanceId() {
    CommentDto commentDtoOne = createTaskCommentsDto(EXAMPLE_TASK_ID, EXAMPLE_TASK_COMMENT_FULL_MESSAGE);
    CommentDto commentDtoTwo = createTaskCommentsDto(EXAMPLE_TASK_ID, EXAMPLE_TASK_COMMENT_FULL_MESSAGE);
    commentDtoOne.setProcessInstanceId(EXAMPLE_PROCESS_INSTANCE_ID);
    commentDtoTwo.setProcessInstanceId(EXAMPLE_PROCESS_INSTANCE_ID);

    List<CommentDto> commentDtos = Arrays.asList(commentDtoOne, commentDtoTwo);

    when(taskServiceMock.createComment(EXAMPLE_TASK_ID, EXAMPLE_PROCESS_INSTANCE_ID,
        EXAMPLE_TASK_COMMENT_FULL_MESSAGE)).thenReturn(mockTaskComment);

    // Sending the request
    Response restResponse = given().body(commentDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(Status.OK.getStatusCode())
        .when()
        .post(MULTIPLE_TASK_COMMENTS_CREATE_URL);

    // Parsing the response
    List<TaskCreateCommentResponse> taskUpdateResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskCreateCommentResponse.class);

    // Assertions for success
    assertThat(taskUpdateResponse, everyItem(hasProperty("status", equalTo(ResponseStatus.SUCCESS))));
    assertThat(taskUpdateResponse, everyItem(hasProperty("errorMessage", equalTo(null))));

    // Verify that createComment was called twice
    verify(taskServiceMock, times(2)).createComment(EXAMPLE_TASK_ID, EXAMPLE_PROCESS_INSTANCE_ID,
        EXAMPLE_TASK_COMMENT_FULL_MESSAGE);
  }

  @Test
  public void testCreateTaskCommentsMoreThan100Items() {
    List<CommentDto> commentDtos = createMaxAllowedPlusOneCommentDtos();

    given().body(commentDtos)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(Status.BAD_REQUEST.getStatusCode())
        .when()
        .post(MULTIPLE_TASK_COMMENTS_CREATE_URL)
        .then()
        .assertThat()
        .body(containsString("The request exceeds the limit of 100 tasks objects."));
  }

  private List<CommentDto> createMaxAllowedPlusOneCommentDtos() {
    List<CommentDto> commentDtos = new ArrayList<>();
    for (int i = 0; i < MAX_COMMENT_CREATE_ALLOWED + 1; i++) {
      commentDtos.add(createTaskCommentsDto(String.valueOf(i), EXAMPLE_TASK_COMMENT_FULL_MESSAGE));
    }
    return commentDtos;
  }

  private CommentDto createTaskCommentsDto(String taskId, String message) {
    CommentDto commentDto = new CommentDto();
    commentDto.setTaskId(taskId);
    commentDto.setMessage(message);
    return commentDto;
  }

  @Test
  public void testCompleteTasksWithVariablesInReturn() {
    ObjectMapper mapper = new ObjectMapper();
    String taskTwoId = "taskTwoId";
    VariableMap variablesMock = MockProvider.createMockFormVariables();
    when(taskServiceMock.completeWithVariablesInReturn(EXAMPLE_TASK_ID, null, false)).thenReturn(variablesMock);
    when(taskServiceMock.completeWithVariablesInReturn("taskTwoId", null, false)).thenReturn(variablesMock);
    CompleteTasksDto completeTasksDto = new CompleteTasksDto();
    CompleteTasksDto completeTasksDto1 = new CompleteTasksDto();
    completeTasksDto.setTaskId(EXAMPLE_TASK_ID);
    completeTasksDto1.setTaskId(taskTwoId);

    List<CompleteTasksDto> taskDtos = Arrays.asList(completeTasksDto, completeTasksDto1);
    CompleteTaskRequestDto completeTaskRequestDto = new CompleteTaskRequestDto();
    completeTaskRequestDto.setWithVariablesInReturn(true);
    completeTaskRequestDto.setCompleteTasksInfo(taskDtos);

    //Object to JSON in String
    String jsonInString = null;
    try {
      jsonInString = mapper.writeValueAsString(completeTaskRequestDto);
    } catch (JsonProcessingException e1) {
      e1.printStackTrace();
    }

    Response restResponse = given().body(jsonInString)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(Status.OK.getStatusCode())
        .when()
        .post(COMPLETE_TASKS_URL);

    List<TaskCompleteResponseDto> completeResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskCompleteResponseDto.class);
    MatcherAssert.assertThat(completeResponse.get(0).getTaskId(), equalTo(EXAMPLE_TASK_ID));
    MatcherAssert.assertThat(completeResponse.get(0).getStatus(), equalTo(ResponseStatus.SUCCESS));
    MatcherAssert.assertThat(completeResponse.get(0).getErrorMessage(), equalTo(null));
    MatcherAssert.assertThat(completeResponse, hasItem(hasProperty("taskId", equalTo(EXAMPLE_TASK_ID))));
    MatcherAssert.assertThat(completeResponse.get(1).getTaskId(), equalTo(taskTwoId));
    MatcherAssert.assertThat(completeResponse.get(1).getStatus(), equalTo(ResponseStatus.SUCCESS));
    MatcherAssert.assertThat(completeResponse.get(1).getErrorMessage(), equalTo(null));
  }

  @Test
  public void testCompleteTasksAllFailure() throws ParseException {
    String taskTwoId = "taskTwoId";
    doThrow(new ProcessEngineException("expected exception")).when(taskServiceMock)
        .completeWithVariablesInReturn(EXAMPLE_TASK_ID, null, false);
    doThrow(new ProcessEngineException("expected exception")).when(taskServiceMock)
        .completeWithVariablesInReturn(taskTwoId, null, false);
    CompleteTasksDto completeTasksDto = new CompleteTasksDto();
    CompleteTasksDto completeTasksDto1 = new CompleteTasksDto();
    completeTasksDto.setVariables(null);
    completeTasksDto.setTaskId(EXAMPLE_TASK_ID);
    completeTasksDto1.setTaskId(taskTwoId);
    completeTasksDto1.setVariables(null);
    List<CompleteTasksDto> taskDtos = Arrays.asList(completeTasksDto, completeTasksDto1);
    CompleteTaskRequestDto completeTaskRequestDto = new CompleteTaskRequestDto();
    completeTaskRequestDto.setWithVariablesInReturn(true);
    completeTaskRequestDto.setCompleteTasksInfo(taskDtos);

    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = null;
    try {
      jsonInString = mapper.writeValueAsString(completeTaskRequestDto);
    } catch (JsonProcessingException e1) {
      e1.printStackTrace();
    }

    Response restResponse = given().body(jsonInString)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(COMPLETE_TASKS_URL);
    List<TaskCompleteResponseDto> completeResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskCompleteResponseDto.class);
    MatcherAssert.assertThat(completeResponse, everyItem(hasProperty("status", equalTo(ResponseStatus.FAILURE))));
    MatcherAssert.assertThat(completeResponse, everyItem(hasProperty("errorMessage", equalTo("expected exception"))));
    MatcherAssert.assertThat(completeResponse, hasItem(hasProperty("taskId", equalTo(EXAMPLE_TASK_ID))));
    MatcherAssert.assertThat(completeResponse, hasItem(hasProperty("taskId", equalTo(taskTwoId))));
  }

  @Test
  public void testCompleteTasksPartialFailure() throws ParseException {

    String taskTwoId = "taskTwoId";
    doThrow(new ProcessEngineException("expected exception")).when(taskServiceMock)
        .completeWithVariablesInReturn(EXAMPLE_TASK_ID, null, false);

    VariableMap variablesMock = MockProvider.createMockFormVariables();
    when(taskServiceMock.completeWithVariablesInReturn("taskTwoId", null, false)).thenReturn(variablesMock);
    CompleteTasksDto completeTasksDto = new CompleteTasksDto();
    CompleteTasksDto completeTasksDto1 = new CompleteTasksDto();
    completeTasksDto.setVariables(null);
    completeTasksDto.setTaskId(EXAMPLE_TASK_ID);
    completeTasksDto1.setTaskId(taskTwoId);
    completeTasksDto1.setVariables(null);
    List<CompleteTasksDto> taskDtos = Arrays.asList(completeTasksDto, completeTasksDto1);
    CompleteTaskRequestDto completeTaskRequestDto = new CompleteTaskRequestDto();
    completeTaskRequestDto.setWithVariablesInReturn(true);
    completeTaskRequestDto.setCompleteTasksInfo(taskDtos);

    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = null;
    try {
      jsonInString = mapper.writeValueAsString(completeTaskRequestDto);
    } catch (JsonProcessingException e1) {
      e1.printStackTrace();
    }

    Response restResponse = given().body(jsonInString)
        .contentType(ContentType.JSON)
        .header("accept", MediaType.APPLICATION_JSON)
        .expect()
        .statusCode(MULTI_STATUS_CODE)
        .when()
        .post(COMPLETE_TASKS_URL);
    List<TaskCompleteResponseDto> completeResponse = restResponse.getBody()
        .jsonPath()
        .getList("", TaskCompleteResponseDto.class);
    MatcherAssert.assertThat(completeResponse.get(0).getStatus(), equalTo(ResponseStatus.FAILURE));
    MatcherAssert.assertThat(completeResponse.get(0).getErrorMessage(), equalTo("expected exception"));
    MatcherAssert.assertThat(completeResponse, hasItem(hasProperty("taskId", equalTo(EXAMPLE_TASK_ID))));
    MatcherAssert.assertThat(completeResponse.get(1).getTaskId(), equalTo(taskTwoId));
    MatcherAssert.assertThat(completeResponse.get(1).getStatus(), equalTo(ResponseStatus.SUCCESS));
    MatcherAssert.assertThat(completeResponse.get(1).getErrorMessage(), equalTo(null));

  }
}
