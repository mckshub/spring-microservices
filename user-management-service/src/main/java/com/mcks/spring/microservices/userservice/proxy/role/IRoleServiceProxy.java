package com.mcks.spring.microservices.userservice.proxy.role;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "role-service", path= "role-service")
public interface IRoleServiceProxy {

	@GetMapping(value = "/role/getRoleById/{roleId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RoleResponseModel getRoleById(@PathVariable(name= "roleId")  final String roleId);
	
	
}
