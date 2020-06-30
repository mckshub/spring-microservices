package com.mcks.spring.microservices.roleservice.service;

import com.mcks.spring.microservices.roleservice.document.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    
    List<Role> getAllRoles();

    List<Role> getAllRolesByList(final List<Integer> roleIds);

    Optional<Role> getRole(final Integer roleId);

}