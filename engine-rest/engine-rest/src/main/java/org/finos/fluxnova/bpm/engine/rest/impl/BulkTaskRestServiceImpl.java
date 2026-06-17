package org.finos.fluxnova.bpm.engine.rest.impl;

import static org.finos.fluxnova.bpm.engine.rest.dto.MultiStatusResponseCode.MULTI_STATUS_CODE;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.TaskService;
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.finos.fluxnova.bpm.engine.rest.BulkTaskRestService;
import org.finos.fluxnova.bpm.engine.rest.dto.ResponseStatus;
import org.finos.fluxnova.bpm.engine.rest.dto.TaskUpdateResponse;
import org.finos.fluxnova.bpm.engine.rest.dto.VariableValueDto;
import org.finos.fluxnova.bpm.engine.rest.dto.task.CompleteTaskRequestDto;
import org.finos.fluxnova.bpm.engine.rest.dto.task.CompleteTasksDto;
import org.finos.fluxnova.bpm.engine.rest.dto.task.TaskCompleteResponseDto;
import org.finos.fluxnova.bpm.engine.rest.dto.task.TaskDto;
import org.finos.fluxnova.bpm.engine.rest.dto.task.TasksAssignDto;
import org.finos.fluxnova.bpm.engine.rest.exception.InvalidRequestException;
import org.finos.fluxnova.bpm.engine.rest.sub.task.TaskCommentsResource;
import org.finos.fluxnova.bpm.engine.rest.sub.task.impl.TaskCommentResourceImpl;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.variable.VariableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BulkTaskRestServiceImpl extends AbstractRestProcessEngineAware implements BulkTaskRestService {
  public static final int MAX_TASK_UPDATE_ALLOWED= 100;

  private final Logger logger = LoggerFactory.getLogger(BulkTaskRestServiceImpl.class);

  public BulkTaskRestServiceImpl(String engineName, final ObjectMapper objectMapper) {
    super(engineName, objectMapper);
  }

  public TaskCommentsResource createComments() {
    return new TaskCommentResourceImpl(getProcessEngine(), "");
  }

  /**
   * Updates multiple tasks based on the provided list of TaskDto.
   * Returns multi-status if any update fails.
   * @param taskDtos List of tasks to update
   * @return Response with update results
   */
  public Response updateTasks(List<TaskDto> taskDtos) {
    validateInputs(taskDtos);

    List<TaskUpdateResponse> responses = taskDtos.stream().map(this::processTask).collect(Collectors.toList());

    boolean hasFailures = responses.stream()
            .anyMatch(response -> response.getStatus().equals(ResponseStatus.FAILURE));

    if (hasFailures) {
      return Response.status(MULTI_STATUS_CODE).entity(responses).build();
    }
    return Response.status(Status.OK).entity(responses).build();

  }

  /**
   * Processes a single task update.
   * @param taskDto Task data to update
   * @return TaskUpdateResponse with status
   */
  private TaskUpdateResponse processTask(TaskDto taskDto) {
    ProcessEngine engine = getProcessEngine();
    TaskService taskService = engine.getTaskService();

    try {
      String taskId = taskDto.getId();
      Task task = getTask(taskId, taskService);

      taskDto.updateTask(task);
      taskService.saveTask(task);
      return new TaskUpdateResponse(taskDto.getId(), ResponseStatus.SUCCESS, null);
    } catch (Exception e) {
      logger.error("Unable to update task id: {}", taskDto.getId(), e);
      return new TaskUpdateResponse(taskDto.getId(), ResponseStatus.FAILURE, e.getMessage());
    }
  }

  /**
   * Retrieves a task by ID, throws exception if not found.
   * @param taskId ID of the task
   * @param taskService TaskService instance
   * @return Task object
   */
  private Task getTask(String taskId, TaskService taskService) {
    Task task = taskService.createTaskQuery().initializeFormKeys().taskId(taskId).singleResult();
    if (task == null) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "Task id: " + taskId + " cannot be found.");
    }
    return task;
  }

  /**
   * Validates the input list for bulk task update.
   * Checks for size limit and duplicate IDs.
   * @param taskDtos List of TaskDto
   */
  private void validateInputs(List<TaskDto> taskDtos) {
    if (taskDtos.size() > MAX_TASK_UPDATE_ALLOWED) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "The request exceeds the limit of 100 tasks objects.");
    }

    boolean isDuplicate = taskDtos.stream()
            .collect(Collectors.groupingBy(TaskDto::getId, Collectors.counting()))
            .entrySet()
            .stream()
            .anyMatch(entry -> entry.getValue() > 1);

    if (isDuplicate) {
      throw new InvalidRequestException(Status.BAD_REQUEST, "The request includes duplicate task IDs.");
    }

  }

  /**
   * Sets the assignee for multiple tasks.
   * Returns multi-status if any assignment fails.
   * @param dto TasksAssignDto containing task IDs and user ID
   * @return Response with assignment results
   */
  @Override
  public Response setTasksAssignee(TasksAssignDto dto) {
    List<TaskUpdateResponse> responses = new ArrayList<>();
    ProcessEngine engine = getProcessEngine();
    TaskService taskService = engine.getTaskService();
    boolean failureFlag = false;

    List<String> tasksWithoutDuplicates = dto.getTaskIds().stream()
            .distinct()
            .collect(Collectors.toList());

    for (String taskId : tasksWithoutDuplicates){
      try {
        taskService.setAssignee(taskId, dto.getUserId());
        responses.add(new TaskUpdateResponse(taskId, ResponseStatus.SUCCESS, null));
      } catch (Exception e) {
        logger.error("Unable to assign task id: {}", taskId, e);
        responses.add(new TaskUpdateResponse(taskId, ResponseStatus.FAILURE, e.getMessage()));
        failureFlag = true;
      }
    }

    if(failureFlag){
      return Response.status(MULTI_STATUS_CODE).entity(responses).build();
    }

    return Response.status(Status.OK).entity(responses).build();
  }

  /**
   * Completes multiple tasks, optionally returning variables.
   * Returns multi-status if any completion fails.
   * @param dtos CompleteTaskRequestDto containing completion info
   * @return Response with completion results
   */
  @Override
  public Response completeTasks(CompleteTaskRequestDto dtos) {
    ProcessEngine engine = getProcessEngine();
    TaskService taskService = engine.getTaskService();

    List<TaskCompleteResponseDto> taskCompleteResponseDtoList = new ArrayList<TaskCompleteResponseDto>();
    List<CompleteTasksDto> completeTasksListDto = dtos.getCompleteTasksInfo();

    for (CompleteTasksDto taskInstance : completeTasksListDto) {
      TaskCompleteResponseDto taskCompleteResponseDto = new TaskCompleteResponseDto();
      taskCompleteResponseDto.setStatus(ResponseStatus.SUCCESS);
      taskCompleteResponseDto.setTaskId(taskInstance.getTaskId());
      VariableMap variables = VariableValueDto.toMap(taskInstance.getVariables(), engine, objectMapper);
      try {
        if (dtos.isWithVariablesInReturn()) {
          VariableMap taskVariables = taskService.completeWithVariablesInReturn(taskInstance.getTaskId(), variables,
                  false);

          if (taskVariables != null) {
            Map<String, VariableValueDto> body = VariableValueDto.fromMap(taskVariables, true);
            taskCompleteResponseDto.setVariables(body);
          }
        } else {
          taskService.complete(taskInstance.getTaskId(), variables);
        }

      } catch (Exception e) {
        taskCompleteResponseDto.setStatus(ResponseStatus.FAILURE);
        taskCompleteResponseDto.setErrorMessage(e.getMessage());
      }
      taskCompleteResponseDtoList.add(taskCompleteResponseDto);

    }
    boolean hasFailures = taskCompleteResponseDtoList.stream()
            .anyMatch(response -> response.getStatus().equals(ResponseStatus.FAILURE));
    if (hasFailures) {
      return Response.status(MULTI_STATUS_CODE).entity(taskCompleteResponseDtoList).build();
    }

    return Response.status(Status.OK).entity(taskCompleteResponseDtoList).build();
  }

}
