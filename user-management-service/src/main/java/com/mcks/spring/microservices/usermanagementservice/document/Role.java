package com.mcks.spring.microservices.usermanagementservice.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection="Role")
public class Role {
    
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String activeInd;

    /**
     * 
     */
    public Role() {
    }

    /**
     * @param roleId
     * @param roleName
     * @param roleCode
     * @param activeInd
     */
    public Role(Integer roleId, String roleName, String roleCode, String activeInd) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleCode = roleCode;
        this.activeInd = activeInd;
    }
    
    
    
}