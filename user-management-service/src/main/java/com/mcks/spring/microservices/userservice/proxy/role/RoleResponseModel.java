package com.mcks.spring.microservices.userservice.proxy.role;

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
public class RoleResponseModel {

	private Object resultObject;
	private boolean status;
	private String statusMessage;
	private String serviceMessage;
	
	
}
