package com.nineleaps.DocumentManagementSystem.exceptions;

import java.util.Date;

public class CustomResponse {

    private String httpCodeMessage;
    private Date timestamp;
    private String message;
    private String details;

    public CustomResponse() {
    }

    public CustomResponse(Date timestamp, String message, String details, String httpCodeMessage) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.httpCodeMessage = httpCodeMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public void setHttpCodeMessage(String httpCodeMessage) {
        this.httpCodeMessage = httpCodeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
