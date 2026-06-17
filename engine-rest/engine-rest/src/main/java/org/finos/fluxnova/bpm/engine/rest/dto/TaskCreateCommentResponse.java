package org.finos.fluxnova.bpm.engine.rest.dto;

import org.finos.fluxnova.bpm.engine.rest.dto.task.CommentDto;

public class TaskCreateCommentResponse {
    public ResponseStatus status;
    private CommentDto commentInfo;
    private String errorMessage;

    public TaskCreateCommentResponse(CommentDto commentDto, ResponseStatus status, String errorMessage) {
        this.commentInfo = commentDto;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public TaskCreateCommentResponse() {
    }

    public CommentDto getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(CommentDto commentInfo) {
        this.commentInfo = commentInfo;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}

