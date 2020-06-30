package com.mcks.spring.microservices.roleservice.model;


public class ResponseVO {
    
    private Object resultObject;
    private boolean status;
    private String statusMessages;

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusMessages() {
        return statusMessages;
    }

    public void setStatusMessages(String statusMessages) {
        this.statusMessages = statusMessages;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "resultObject=" + resultObject +
                ", status=" + status +
                ", statusMessages='" + statusMessages + '\'' +
                '}';
    }
}