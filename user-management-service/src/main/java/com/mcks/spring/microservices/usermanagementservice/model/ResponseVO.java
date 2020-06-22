package com.mcks.spring.microservices.usermanagementservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseVO {
    
    private Object resultObject;
    private boolean status;
    private String statusMessages;
}