package com.innowise.mongodb.dto;

public class ResponseDTO {

    private Status status;

    private String message;

    private Object body;

    public ResponseDTO(Status status, String message, Object body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public enum Status {
        SUCCESS, FAIL
    }
}
