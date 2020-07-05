package com.mcks.spring.microservices.roleservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcks.spring.microservices.roleservice.document.Role;
import com.mcks.spring.microservices.roleservice.model.RoleRequestVO;
import com.mcks.spring.microservices.roleservice.model.RoleResponseVO;
import com.mcks.spring.microservices.roleservice.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {

	private static final String APPLICATION_JSON = "application/json";

	@Autowired
	private RoleService roleService;

	@GetMapping(value = "/getAllRoles", produces = APPLICATION_JSON)
	public RoleResponseVO getAllRoles() {
		final RoleResponseVO responseVO = new RoleResponseVO();
		final List<Role> allRoles = roleService.getAllRoles();
		responseVO.setResultObject((Object) allRoles);
		return responseVO;
	}

	@PostMapping(value = "/getAllRolesByIds", produces = APPLICATION_JSON)
	public RoleResponseVO getAllRolesByIds(@RequestBody final RoleRequestVO requestVO) {
		final RoleResponseVO responseVO = new RoleResponseVO();
		final List<Role> allRoles = roleService.getAllRolesByList(requestVO.getRoleCodes());
		responseVO.setResultObject(allRoles);
		responseVO.setStatus(true);
		responseVO.setStatusMessages("Success");
		return responseVO;
	}

	@GetMapping(value = "/getRoleById/{roleId}", produces = APPLICATION_JSON)
	public RoleResponseVO getRoleById(@PathVariable("roleId") final String roleId) {
		RoleResponseVO responseVO = new RoleResponseVO();
		Optional<Role> role = roleService.getRole(roleId);
		responseVO.setResultObject(role.get());
		responseVO.setStatus(true);
		responseVO.setStatusMessages("Success");
		return responseVO;
	}

	@PostMapping(value = "/saveRole", produces = APPLICATION_JSON)
	public RoleResponseVO saveCategory(@RequestBody final RoleRequestVO requestVO) {
		RoleResponseVO responseVO = new RoleResponseVO();
		Role savedRole = roleService.save(requestVO.getRole());
		responseVO.setResultObject(savedRole);
		responseVO.setStatus(true);
		responseVO.setStatusMessages("Success");
		return responseVO;
	}

	@PostMapping(value = "/saveAllRoles", produces = APPLICATION_JSON)
	public RoleResponseVO saveAllCategories(@RequestBody final RoleRequestVO requestVO) {
		RoleResponseVO responseVO = new RoleResponseVO();
		List<Role> savedRoles = roleService.saveAll(requestVO.getRoles());
		responseVO.setResultObject(savedRoles);
		responseVO.setStatus(true);
		responseVO.setStatusMessages("Success");
		return responseVO;
	}

}