package org.finos.fluxnova.bpm.engine.rest;

import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.finos.fluxnova.bpm.engine.rest.dto.CountResultDto;
import org.finos.fluxnova.bpm.engine.rest.dto.task.CompleteTaskRequestDto;
import org.finos.fluxnova.bpm.engine.rest.dto.task.TaskDto;
import org.finos.fluxnova.bpm.engine.rest.dto.task.TaskQueryDto;
import org.finos.fluxnova.bpm.engine.rest.dto.task.TasksAssignDto;
import org.finos.fluxnova.bpm.engine.rest.hal.Hal;
import org.finos.fluxnova.bpm.engine.rest.sub.task.TaskCommentsResource;
import org.finos.fluxnova.bpm.engine.rest.sub.task.TaskReportResource;
import org.finos.fluxnova.bpm.engine.rest.sub.task.TaskResource;

@Produces(MediaType.APPLICATION_JSON)
public interface BulkTaskRestService {

    public static final String PATH = "/bulk/task";

    @Path("/comment/create")
    TaskCommentsResource createComments();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    Response updateTasks(List<TaskDto> taskDtos);

    @POST
    @Path("/assign")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response setTasksAssignee(TasksAssignDto dto);

    @POST
    @Path("/complete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response completeTasks(CompleteTaskRequestDto dto);
}
