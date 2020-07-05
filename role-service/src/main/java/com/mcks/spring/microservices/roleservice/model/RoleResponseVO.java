package com.mcks.spring.microservices.roleservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonInclude(Include.NON_NULL)
public class RoleResponseVO implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3899838024881398878L;
	
	private Object resultObject;
    private boolean status;
    private String statusMessages;

}