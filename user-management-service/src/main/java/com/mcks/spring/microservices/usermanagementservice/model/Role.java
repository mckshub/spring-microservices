package com.mcks.spring.microservices.usermanagementservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="Role")
public class Role {
    
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String activeInd;
    
}