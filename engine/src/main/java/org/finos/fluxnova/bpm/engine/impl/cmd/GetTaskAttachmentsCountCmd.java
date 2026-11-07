package org.finos.fluxnova.bpm.engine.impl.cmd;

import java.io.Serializable;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;

public class GetTaskAttachmentsCountCmd implements Command<Long>, Serializable {

  private static final long serialVersionUID = 1L;

  protected String taskId;

  public GetTaskAttachmentsCountCmd(String taskId) {
    this.taskId = taskId;
  }

  public String getTaskId() {
    return taskId;
  }

  public Long execute(CommandContext commandContext) {
    return commandContext
      .getAttachmentManager()
      .countAttachmentsByTaskId(taskId);
  }

}
