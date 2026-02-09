package org.finos.fluxnova.bpm.engine.rest.sub.task;

import org.finos.fluxnova.bpm.engine.rest.dto.task.CommentDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;


public interface TaskCommentsResource {

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response createTaskComments(@Context UriInfo uriInfo, List<CommentDto> commentDtos);
}
