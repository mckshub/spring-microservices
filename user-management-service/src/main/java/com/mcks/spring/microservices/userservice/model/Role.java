package com.mcks.spring.microservices.userservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String activeInd;

}