package com.mcks.spring.microservices.roleservice.model;

import java.util.List;

import com.mcks.spring.microservices.roleservice.document.Role;

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
public class RoleRequestVO {
	
	private Role role;
	
	private List<Role> roles;
	
	private List<String> roleCodes;

}
