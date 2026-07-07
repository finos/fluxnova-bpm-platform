package org.finos.fluxnova.bpm.engine.rest.sub.task;

import org.finos.fluxnova.bpm.engine.rest.dto.task.CommentDto;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.util.List;


public interface TaskCommentsResource {

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response createTaskComments(@Context UriInfo uriInfo, List<CommentDto> commentDtos);
}
