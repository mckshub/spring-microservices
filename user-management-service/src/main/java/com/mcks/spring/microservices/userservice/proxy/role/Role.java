package com.mcks.spring.microservices.userservice.proxy.role;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String roleName;
    private String roleCode;
    private String activeInd;
}