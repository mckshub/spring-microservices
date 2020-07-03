package com.mcks.spring.microservices.roleservice.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Role")
public class Role {
    
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String activeInd;

}