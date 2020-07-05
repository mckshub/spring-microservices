package com.mcks.spring.microservices.roleservice.service;

import java.util.List;
import java.util.Optional;

import com.mcks.spring.microservices.roleservice.document.Role;

public interface RoleService {

	List<Role> getAllRoles();

	List<Role> getAllRolesByList(final List<String> roleCodes);

	Optional<Role> getRole(final String code);

	Role save(Role role);

	List<Role> saveAll(List<Role> roles);

}